package com.example.priyad.riddlemethat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<Riddle> riddles;
    private RiddleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        riddles = RiddleCollection.Collect();
        // Take sharedpreferences, and update collection

        mListView = (ListView) findViewById(android.R.id.list);
        adapter = new RiddleAdapter(this, R.layout.row_riddle, riddles);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent intent = new Intent(getBaseContext(), RiddlePanel.class);
                intent.putExtra("riddle", riddles.get(pos));
                startActivityForResult(intent, 0);
            }
        });
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            //noinspection SimplifiableIfStatement
            if (id == R.id.action_score) {
                Toast toast = Toast.makeText(this, calcScore(), Toast.LENGTH_LONG);
                toast.show();
                return true;
            } else if (id == R.id.action_reset) {
                SharedPreferences score = getSharedPreferences("score", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = score.edit();
                for(int i = 0; i<riddles.size(); i++){
                    String key = Integer.toString(i);
                    editor.putBoolean(key, false);
                    riddles.get(i).setCorrect(false);
                }
                editor.commit();
                adapter.notifyDataSetChanged();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

    private void loadScoreData() {
        SharedPreferences score;
        score = getSharedPreferences("score", Context.MODE_PRIVATE);
        for (int i=0; i<riddles.size(); i++) {
            riddles.get(i).setCorrect(score.getBoolean(Integer.toString(i), false));
        }

    }

    private String calcScore() {
        String s;
        int count = 0;
        for (int i= 0; i<riddles.size(); i++) {
            if (riddles.get(i).isCorrect()) {
                count++;
            }
        }
        if (count == 1) {
            return "1 Riddle Solved!";
        }
        if (count == riddles.size()) {
            return "Congratulations! All the Riddles have been solved!";
        }
        s = Integer.toString(count) + " Riddles Solved!";
        return s;
    }

    public void setContentView(int contentView) {
        this.contentView = contentView;
    }
}



    }
}
