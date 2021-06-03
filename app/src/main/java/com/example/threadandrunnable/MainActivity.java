package com.example.threadandrunnable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Thread wr, wt;
    boolean running = true;
    final String TAG = "THREAD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Now I am in onCreate");

    }

    class WorkerThread extends Thread {
        public void run() {
            int i = 0;
            for (i = 0; i < 20 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                Log.v(TAG, "Thread time=" + i);
            }
        }
    }

    class Runnable extends Thread {
        public void run() {
            int i = 0;
            for (i = 0; i < 20 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                Log.v(TAG, "Runnable time = " + i);
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        running = true;
        wt = new WorkerThread();
        wt.start();
        wr = new Runnable();
        wr.start();
        Log.v(TAG, "Now I am onStart");

    }

    @Override
    public void onStop() {
        super.onStop();
        running = false;
        Log.v(TAG, "Now I am in onStop");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(TAG, "Now I am in onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v(TAG, "Now I am in onResume");
    }
}

