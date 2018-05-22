package id.co.venport.vendorportalandroidapplication.SplashLoginRegister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import id.co.venport.vendorportalandroidapplication.R;

public class lupapasswordActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnForget;
    private ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        btnBack = (ImageView) findViewById(R.id.backButton);
        btnForget = (Button) findViewById(R.id.btn_forget);

        btnBack.setOnClickListener(this);
        btnForget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnBack){
            startActivity(new Intent(this,TampilanAwalActivity.class));
        }else if(v == btnForget){
            Toast.makeText(this,"On progress",Toast.LENGTH_LONG).show();
        }
    }
}
