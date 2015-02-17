package com.example.trenton.strand;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ProgressBar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Strand extends ActionBarActivity{

   private  Boolean clearIt = false;
    private List<String> numbers = new ArrayList<String>();
    ListView myList = (ListView) findViewById(R.id.myListView);

    /**
     * creates a new file and writes 1 - 10 in the file
     */
    public void Create() {
        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setMax(10);
        progress.setProgress(0);

        try {
            File file = new File("numbers.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 1; i <= 10; ++i) {
                try {
                    bw.write(i + "\n");
                    Thread.sleep(25);
                    progress.setProgress(i-1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (clearIt == true) {
                    i = 11;
                }
            }
        }
        catch(IOException a)
        {
            a.printStackTrace();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * loads a file and displays it in the list display on the screen
     */
    public void loadF (){
        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setMax(10);
        progress.setProgress(0);
        String number;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("numbers.txt"));
            for (int i = 1; i <= 10; ++i) {
                try {
                    Thread.sleep(25);
                } catch (InterruptedException ex) {
                }
                number = br.readLine();
                numbers.add(number);
                progress.setProgress(i-1);

                if (clearIt == true){
                    i = 11;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clearIt = false;

    }

    /**
     * this stops the file from running
     */
    public void Stop(){

        clearIt = true;
    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_strand);
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_strand, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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