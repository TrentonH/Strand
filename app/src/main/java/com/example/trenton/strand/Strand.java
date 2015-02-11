package com.example.trenton.strand;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;




public class Strand extends ActionBarActivity {

    //strand one rights to the file
    //creat a new strand
    // activate on wright to file
    wrightToFile() {
        for (int i = 1; i <= 10; ++i) {
            try {
                thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }


    //strand 2 prints to the string
// display on the phone screen
    printToScreen() {
        for (int i = 1; i <= 10; ++i) {
        }
    }
//f
}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strand);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_strand, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
