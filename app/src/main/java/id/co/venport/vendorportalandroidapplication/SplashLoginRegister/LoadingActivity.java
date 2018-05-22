package id.co.venport.vendorportalandroidapplication.SplashLoginRegister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

import id.co.venport.vendorportalandroidapplication.R;

public class LoadingActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        auth=FirebaseAuth.getInstance();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);

        final Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    //for time in 3 second
                    for (int i =0; i<100;i++){
                        progressBar.setProgress(i);
                        sleep(40);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(getApplicationContext(), SliderActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        };
        thread.start();
    }
}
