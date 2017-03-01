package com.example.n00147109.asyncca;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView output;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        output = (TextView) findViewById(R.id.Task);
        pb = (ProgressBar) findViewById(R.id.PB);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

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
        if (id == R.id.action_settings) {
            MyTask t = new MyTask();
//            t.execute("param1", "param2", "param3");
            t.execute("http://10.0.2.2/flowers/Stock.xml");
        }

        return super.onOptionsItemSelected(item);
    }

    //hello
    private class MyTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
            updateDisplay("starting Task");
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d("log", "in bg");
            for (int i = 0; i < strings.length; i++) {
//                publishProgress("working with" + strings[i]);
                Log.d("log", "in for " +strings[0]);
                try {
                    Thread.sleep(2000);
                    String data = HTTPManager.getData(strings[0]);
                    publishProgress(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            try {
//                Thread.sleep(2000);
//                String data = HTTPManager.getData(strings[0]);
//                publishProgress(data);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            return "task complete";
        }
        protected void onProgressUpdate(String... values)
        {
            for(int i =0; i < values.length; i++) {
                updateDisplay("working with" + values[i]);
            }
        }
        @Override
        protected void onPostExecute(String s) {
            updateDisplay(s);
            pb.setVisibility(View.INVISIBLE);
        }
    }

    private void updateDisplay(String message) {
        output.append(message + "\n");
    }
}
