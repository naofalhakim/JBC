package id.co.venport.vendorportalandroidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import id.co.venport.vendorportalandroidapplication.SplashLoginRegister.TampilanAwalActivity;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView userID;
    private Button btnLogout;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this, TampilanAwalActivity.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();

        userID = (TextView) findViewById(R.id.userId);
        btnLogout = (Button) findViewById(R.id.logout);
        userID.setText("Welcome "+user.getEmail());

        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,TampilanAwalActivity.class));
        }
    }
}
