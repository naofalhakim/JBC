package id.co.venport.vendorportalandroidapplication.SplashLoginRegister;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import id.co.venport.vendorportalandroidapplication.HomePageActivity;
import id.co.venport.vendorportalandroidapplication.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextKtp, editTextNama,editTextTlp, editTextEmail,editTextPassword, editTextRePassword;
    private Button buttonRegister;
    private ImageView buttonBack;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth=FirebaseAuth.getInstance();
//        if(firebaseAuth.getCurrentUser()!=null){
//            finish();
//            startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
//        }

        progressDialog = new ProgressDialog(this);

        editTextKtp = (EditText) findViewById(R.id.edKtp);
        editTextNama = (EditText) findViewById(R.id.edNama);
        editTextEmail = (EditText) findViewById(R.id.edEmail);
        editTextTlp = (EditText) findViewById(R.id.edTelepon);
        editTextPassword = (EditText) findViewById(R.id.edPassword);
        editTextRePassword = (EditText) findViewById(R.id.edRePassword);
        buttonRegister = (Button) findViewById(R.id.btnRegister);
        buttonBack = (ImageView) findViewById(R.id.backButton);

        buttonRegister.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
    }

    private void registerFunction() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        String nama = editTextNama.getText().toString();
        String hp = editTextTlp.getText().toString();
        String ulangpassword = editTextRePassword.getText().toString();
        String noktp = editTextKtp.getText().toString();

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

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), TampilanAwalActivity.class));
                            Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(RegisterActivity.this, "Authorization Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


    @Override
    public void onClick(View view) {
        if(view == buttonRegister){
            registerFunction();
        }else if (view == buttonBack){
            Intent intent = new Intent(RegisterActivity.this, TampilanAwalActivity.class);
            startActivity(intent);
        }
    }
}
