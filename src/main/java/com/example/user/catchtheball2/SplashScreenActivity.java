package com.example.user.catchtheball2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    private int setProgress;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Remove the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove the notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        progressBar = findViewById(R.id.ProgressBar_Id);

        Thread thread = new Thread(new Runnable() {

            @Override

            public void run() {

                doWork();
                startApp();
            }
        });

        thread.start();
    }

    public  void doWork() {

        for (setProgress = 10; setProgress <= 100; setProgress = setProgress + 10) {

            try {

                Thread.sleep(400);
                progressBar.setProgress(setProgress);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    public void startApp() {

        Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);

        startActivity(intent);

        finish();
    }

    //Disable Return Button

    @Override

    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {

            switch (event.getKeyCode()) {

                case KeyEvent.KEYCODE_BACK:

                    return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }
}
