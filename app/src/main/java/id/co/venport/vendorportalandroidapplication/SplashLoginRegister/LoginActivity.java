package id.co.venport.vendorportalandroidapplication.SplashLoginRegister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import id.co.venport.vendorportalandroidapplication.HomePageActivity;
import id.co.venport.vendorportalandroidapplication.R;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEdit, passwordEdit;
    private Button loginButton, lupaPasswordButton, backButton;
    private FirebaseAuth auth;

    //@Override
    //public void onBackPressed() {
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

//        emailEdit = (EditText)findViewById(R.id.emailEdit);
//        passwordEdit = (EditText)findViewById(R.id.passwordEdit);
//        loginButton = (Button)findViewById(R.id.loginButton);
//        lupaPasswordButton = (Button)findViewById(R.id.lupaPasswordButton);
//        backButton = (Button)findViewById(R.id.backButton);


        //We are checking for a valid authorization.
        //if(auth.getCurrentUser() != null){
        //Intent intent = new Intent(LoginActivity.this,HomePageActivity.class);
        //startActivity(intent);
        //finish();
        // }

//        lupaPasswordButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this,lupapasswordActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = emailEdit.getText().toString();
//                final String password = passwordEdit.getText().toString();
//
//                //email error
//                if (TextUtils.isEmpty(email)) {
//                    Toast.makeText(getApplicationContext(), "Please enter your e-mail address ", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                //password error
//                if (TextUtils.isEmpty(password)) {
//                    Toast.makeText(getApplicationContext(), "Please Enter Your Password", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                //We are starting user verification on Firebase
//                //If the input succeeds, task.isSuccessful will return true and the MainActivity will be passed
//                auth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    startActivity(new Intent(LoginActivity.this,HomePageActivity.class));
//                                    finish();
//                                }
//                                else {
//                                    Toast.makeText(getApplicationContext(),""+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                                    Log.e("Input Error",task.getException().getMessage());
//                                }
//                            }
//                        });
//
//            }
//        });
//
//    }
    }
}




