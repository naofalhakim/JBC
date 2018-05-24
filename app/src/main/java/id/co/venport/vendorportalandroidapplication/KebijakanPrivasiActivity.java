package id.co.venport.vendorportalandroidapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class KebijakanPrivasiActivity extends AppCompatActivity {
    private ImageView backButton;
//=======
//    private Button backButton;
//>>>>>>> 119aa4894c2e45db3ce3b525cae85ac9d9c30345

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kebijakan_privasi);

//<<<<<<< HEAD
        backButton = (ImageView) findViewById(R.id.backButton);
//=======
//        backButton = (Button)findViewById(R.id.backButton);
//>>>>>>> 119aa4894c2e45db3ce3b525cae85ac9d9c30345

//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(KebijakanPrivasiActivity.this,HomePageActivity.class));
//                finish();
//            }
//        });
    }
}
