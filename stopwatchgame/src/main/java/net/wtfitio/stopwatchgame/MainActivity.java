package net.wtfitio.stopwatchgame;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends ActionBarActivity {

    TextView text1;
    TextView text2;
    Button but;
    int points;
    Chronometer cron;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but = (Button)findViewById(R.id.click);
        text1=(TextView)findViewById(R.id.output_time);
        text2=(TextView)findViewById(R.id.output_points);
        cron = (Chronometer)findViewById(R.id.chrono);
        points = 0;
        long t =Calendar.getInstance().getTimeInMillis();
        Log.v("time",String.valueOf(t));
        cron.setBase(t);
        cron.start();
       /* if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
//kkk

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String last_second=  getTimeStamp();
                if (last_second.equals("0")) {
                    points++;

                    text2.setText(String.format("You have %d points",points));
                }



            }
        });




    }

    private String getTimeStamp() {

        Date now =  Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.S");
        SimpleDateFormat sdf_check = new SimpleDateFormat("S");
        String date = sdf.format(now);
        String data1=sdf_check.format(now);
        text1.setText(date);

        return data1;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
