
package com.example.priyad.riddlemethat;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;


public class RiddleCollection {


    public static ArrayList<Riddle> Collect() {
        ArrayList<Riddle> riddles = new ArrayList<>(20);

        // Increment automatically the id
        // So that I can change around order no prob
        int i = 0;

        Riddle r = new Riddle("The Sphinx\'s Riddle",
                "What walks on four legs in the morning,\n" +
                        "then two legs in the afternoon,\n" +
                        "and three in the evening?",
                "Sophocles",
                Arrays.asList("human","the human"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Name This ", "See if you can name this one:\n" +
                "I oocur once in a minute,\n" +
                "twice in a moment,\n"+
                "never in thousand\n",
                "jacki",
                Arrays.asList("m","letter m"));
        r.setId(i);
        i++;

        riddles.add(r);
        Log.d("ID?", Integer.toString(i));
        r = new Riddle("Delicate", "Something is Delicate\n" +
                "What is so delicate that saying it breaks \n",

                "mobia & ludos 2015",
                Arrays.asList("silence"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Wetter dryer", "Name it:\nWhat gets wetter as it dries?","mobia 2012",
                Arrays.asList("towel","the towel"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Broken one",
                "Name me the broken one\nWhat has to broken before using it","rufus12",
                Arrays.asList("egg","the egg"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("The Poor one",
                "\nWhat has hands but cannot clap","rufus 2013",
                Arrays.asList("clock","the clock"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Name Me The place",
                "\nWhat stats with p ends with e and has 1000 letters","rufus 2013",
                Arrays.asList("postoffice","the postoffice"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Rainbow",
                "\nWhat is at the end of the rainbow.",
                "rufus 2013",
                Arrays.asList("W","letter w"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("My 13 Heart",
                "\nWho has3 hearts but no other organs.",
                "ludos 2013",
                Arrays.asList("playing cards","cards"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Easy and hard",
                "What is easy to get in but difficult to get out?","monil",
                Arrays.asList("trouble"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("You  might have to sleep on thsi one",
                "\nWhat has one head one foot and four legs","rufus & ludos 2010",
                Arrays.asList("bed","the bed"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Impossible One",
                "\nWhere fridaycomes before thursday",
                "rufus & ludos 2010",
                Arrays.asList("dictionary",
                        "in the dictionary",
                        "the dictionary"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Pronunciation matters",
                "\nWhat english word retains the same pronunciation ,even after you take away four of its five letter",
                "rufus & ludos 2010",
                Arrays.asList("queue"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Poor People have it",
                "\nPoor people have it ,Rich people need it,Poor people eat it , if you eat this you ll die bro.\nWhat is it?","mobia & ludos 2012",
                Arrays.asList("nothing"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("They Come at night",
                "\nThey come at night without being called abd are lost in the day without being stolen","mobia & ludos 2012",
                Arrays.asList("stars","the star"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("Curious One",
                "\nThe curious one?","mobia & ludos 2012",
                Arrays.asList("letter y","y"));
        r.setId(i);
        i++;
        riddles.add(r);

        r = new Riddle("What Do You Call.....",
                "What do You Call a bear without An ear\n",
                "rufus 2010",
                Arrays.asList("An b", "b"));
        r.setId(i);
        i++;
        riddles.add(r);

        /*
        r = new Riddle("",
                "",
                "",
                "");
        r.setId(i);
        i++;
        riddles.add(r);

        */


        return riddles;
    }
}
