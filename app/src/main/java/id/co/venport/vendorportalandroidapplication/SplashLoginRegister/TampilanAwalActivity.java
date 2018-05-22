package id.co.venport.vendorportalandroidapplication.SplashLoginRegister;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import id.co.venport.vendorportalandroidapplication.AppConfig.PreferenceLogin;
import id.co.venport.vendorportalandroidapplication.R;
import id.co.venport.vendorportalandroidapplication.mainmenu.MenuActivity;

public class TampilanAwalActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView daftarButton, masukButton, fbButton, googleButton;
    private FirebaseAuth firebaseAuth;
    private EditText user, passwd;
    private ProgressDialog progressDialog;
    private PreferenceLogin preferenceLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_awal);

        firebaseAuth=FirebaseAuth.getInstance();
        preferenceLogin = new PreferenceLogin(this);

        progressDialog = new ProgressDialog(this);

        daftarButton =(TextView) findViewById(R.id.btnEmail);
        masukButton =(TextView) findViewById(R.id.btnLogin);
        fbButton =(TextView) findViewById(R.id.btnFacebook);
        googleButton =(TextView) findViewById(R.id.btnGoogle);

        daftarButton.setOnClickListener(this);
        fbButton.setOnClickListener(this);
        googleButton.setOnClickListener(this);

        masukButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(TampilanAwalActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_dialog_login, null);

                if(firebaseAuth.getCurrentUser()!=null){
                    preferenceLogin.createIntro(firebaseAuth.getCurrentUser().getEmail());
                    finish();
                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                }

                user = (EditText) mView.findViewById(R.id.username);
                passwd = (EditText) mView.findViewById(R.id.password);
                Button btnMasuk = (Button) mView.findViewById(R.id.btnMasuk);
                TextView lupaSandi = (TextView) mView.findViewById(R.id.lupaKataSandi);
                TextView cancleBtn = (TextView) mView.findViewById(R.id.cancle);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                btnMasuk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!user.getText().toString().isEmpty() && !passwd.getText().toString().isEmpty()){
                            userLogin();
                        }else{
                            Toast.makeText(TampilanAwalActivity.this, "Please fill all field", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                lupaSandi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(TampilanAwalActivity.this, lupapasswordActivity.class));
                    }
                });

                cancleBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
            }

        });
    }

    private void userLogin(){
        final String email = user.getText().toString().trim();
        String password = passwd.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Please enter your email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Please enter your password",Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length()<5){
            Toast.makeText(getApplicationContext(),"Password must be at least 5 digits", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Checking Account...");
        progressDialog.show();

//        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                progressDialog.dismiss();
//                if(task.isSuccessful()){
//                    preferenceLogin.createIntro(email);
//                    finish();
//                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
//                }else{
//                    Toast.makeText(TampilanAwalActivity.this,"Maybe user or password is wrong",Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        progressDialog.dismiss();
        if(email.equals("admin@gmail.com") && password.equals("admin")){
            preferenceLogin.createIntro(email);
                    finish();
                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
        }
    }

    @Override
    public void onClick(View v) {
        if (v == daftarButton){
            startActivity(new Intent(TampilanAwalActivity.this,RegisterActivity.class));
        }else if (v == fbButton || v==googleButton){
            Toast.makeText(TampilanAwalActivity.this,"Still in progress",Toast.LENGTH_LONG).show();
        }
    }
}
