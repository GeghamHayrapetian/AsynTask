package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private Switch aSwitch;
    private Button start;
    private Button stop;
    Thread th;
    class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; ++i) {
                Log.d(TAG, "StartClick :" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    class ExampleThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; ++i) {
                Log.d(TAG, "StartClick :" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch = findViewById(R.id.switch1);
        start = findViewById(R.id.b_start);
        stop = findViewById(R.id.b_stop);
        th=new Thread(new MyRunnable());
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startClick(view);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                th.interrupt();

            }
        });

    }



    public void startClick(View view) {
       // ExampleThread thread = new ExampleThread();
        //thread.start();

        th.start();

    }
}
