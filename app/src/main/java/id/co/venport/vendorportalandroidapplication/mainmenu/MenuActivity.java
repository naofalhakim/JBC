package id.co.venport.vendorportalandroidapplication.mainmenu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

import id.co.venport.vendorportalandroidapplication.AppConfig.PreferenceLogin;
import id.co.venport.vendorportalandroidapplication.R;
import id.co.venport.vendorportalandroidapplication.fragmentMenu.EventFragment;
import id.co.venport.vendorportalandroidapplication.fragmentMenu.EventRecyclerViewAdapter;
import id.co.venport.vendorportalandroidapplication.fragmentMenu.EventsFragment;
import id.co.venport.vendorportalandroidapplication.model.Event;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private PreferenceLogin preferenceLogin;
    private TextView txtEmail,txtNama,txtClose;
    private String nama, email;

    private RecyclerView recyclerView;
    private ArrayList<Event> eventArrayList;


    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        preferenceLogin = new PreferenceLogin(this);
        preferenceLogin.checkProceed();
        HashMap<String,String> maps = preferenceLogin.getUserIntro();
        email = maps.get(preferenceLogin.KEY_EMAIL);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment,new EventFragment());
        ft.commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Event");

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        View root = navigationView.getRootView();

       View root = navigationView.getHeaderView(0);
        txtClose = (TextView) root.findViewById(R.id.btnCloseNav);
        txtEmail = (TextView) root.findViewById(R.id.txtEmail);
        txtEmail.setText(email);
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item;
        SpannableString s;

        for (int i = 0; i < menu.size(); i++) {
            item = menu.getItem(i);
            s = new SpannableString(item.getTitle());
            s.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, s.length(), 0);
            item.setTitle(s);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (id == R.id.nav_event) {
            ft.replace(R.id.fragment,new EventFragment());
            getSupportActionBar().setTitle("Event");
        } else if (id == R.id.nav_konsumsi) {
            ft.replace(R.id.fragment,new EventFragment());
            getSupportActionBar().setTitle("Konsumsi");
        } else if (id == R.id.nav_logistik) {
            getSupportActionBar().setTitle("Logistik");
            ft.replace(R.id.fragment,new EventFragment());
        } else if (id == R.id.nav_attribut) {
            ft.replace(R.id.fragment,new EventFragment());
            getSupportActionBar().setTitle("Attribut");
        } else if (id == R.id.nav_lacak) {
            ft.replace(R.id.fragment,new EventFragment());
            getSupportActionBar().setTitle("Lacak");
        } else if (id == R.id.nav_kebijakan) {
            ft.replace(R.id.fragment,new EventFragment());
            getSupportActionBar().setTitle("Kebijakan");
        }else if (id == R.id.nav_bantuan) {
            ft.replace(R.id.fragment,new EventFragment());
            getSupportActionBar().setTitle("Bantuan");
        }else{
            ft.replace(R.id.fragment,new EventFragment());
            getSupportActionBar().setTitle("Event");
        }
        ft.commit();

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
