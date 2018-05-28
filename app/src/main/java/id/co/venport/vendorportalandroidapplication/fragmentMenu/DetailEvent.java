package id.co.venport.vendorportalandroidapplication.fragmentMenu;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import id.co.venport.vendorportalandroidapplication.R;

public class DetailEvent extends AppCompatActivity {
    AppBarLayout Appbar;
    CollapsingToolbarLayout CoolToolbar;
    Boolean ExpandedActionBar = true;
    Toolbar toolbar;

    ImageView poster;
    TextView judul, status, pembuat, deskripsi, jam, tanggal, tempat, note;
    Button btnOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);

        toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        Appbar = (AppBarLayout) findViewById(R.id.MyAppbar);
        CoolToolbar = (CollapsingToolbarLayout) findViewById(R.id.MyCollapseToolbar);

        poster = (ImageView) findViewById(R.id.posterAcara);
        judul = (TextView) findViewById(R.id.judulAcara);
        status = (TextView) findViewById(R.id.statusAcara);
        pembuat = (TextView) findViewById(R.id.pembuatAcara);
        deskripsi = (TextView) findViewById(R.id.deskripsiAcara);
        jam = (TextView) findViewById(R.id.jamAcara);
        tanggal = (TextView) findViewById(R.id.tanggalAcara);
        tempat = (TextView) findViewById(R.id.tempatAcara);
        note = (TextView) findViewById(R.id.noteAcara);
        btnOrder = (Button) findViewById(R.id.btnOrderTicket);

        final Intent i = getIntent();
        final int posterA = i.getIntExtra("posterAcara",0);
        final String judulA = i.getStringExtra("judulAcara");
        final int statusA = i.getIntExtra("statusAcara",0);
        final String pembuatA = i.getStringExtra("pembuatAcara");
        final String deskripsiA = i.getStringExtra("deskripsiAcara");
        final String jamA = i.getStringExtra("jamAcara");
        final String tanggalA= i.getStringExtra("tanggalAcara");
        final String tempatA= i.getStringExtra("tempatAcara");
        final String noteA= i.getStringExtra("noteAcara");

        //Log.v("statuss cek",toString(statusA));

        poster.setImageResource(posterA);
        judul.setText(judulA);
        if (statusA == 0){
            status.setText("Free Entry");
            btnOrder.setVisibility(View.INVISIBLE);
        }else{
            status.setText("Rp "+Integer.toString(statusA));
        }
        pembuat.setText(pembuatA);
        deskripsi.setText(deskripsiA);
        jam.setText(jamA);
        tanggal.setText(tanggalA);
        tempat.setText(tempatA);
        note.setText(noteA);

        Appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset) > 150){
                    ExpandedActionBar = false;
                    CoolToolbar.setTitle("Event "+judulA);
                    //CoolToolbar.setContentScrimColor(Color.parseColor("#ffffff"));
                }else{
                    ExpandedActionBar = true;
                    CoolToolbar.setTitle(" ");
                }
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(DetailEvent.this,statusA,Toast.LENGTH_LONG).show();
            }
        });
    }
}
