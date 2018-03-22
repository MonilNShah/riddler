/*
 * Devinettes
 *
 * Copyright (C) 2014 - 2016 Fenimore Love
 *
 * Devinettes is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * Devinettes is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Devinettes; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 *
 * Riddles are licensed under
 *     Creative Commons -
 *     Attribution-NonCommercial-NoDerivs 3.0 United States
 */
package com.example.priyad.riddlemethat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class RiddlePanel extends AppCompatActivity {

    private TextView tv;
    private ImageButton btn;
    private EditText et;
    private Riddle r;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent i = getIntent();
        r = i.getParcelableExtra("riddle");
        Log.d("THE ID", Integer.toString(r.getId()));

        tv = (TextView) findViewById(R.id.riddle);
        et = (EditText) findViewById(R.id.guess);
        tv.setText(r.getRiddle());
        btn = (ImageButton) findViewById(R.id.btnGuess);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = et.getText().toString().toLowerCase();
               // guess = createHash(guess);
                if (r.checkAnswer(guess)) {
                    Toast.makeText(RiddlePanel.this, "Correct!", Toast.LENGTH_SHORT).show();
                    et.setText("");


                } else {
                    Toast.makeText(RiddlePanel.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //startActivityForResult(new Intent(getBaseContext(), MainActivity.class), 0);
                //finish();
                //NavUtils.shouldUpRecreateTask(this, new Intent(this, MainActivity.class));
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
