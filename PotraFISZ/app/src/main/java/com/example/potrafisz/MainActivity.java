package com.example.potrafisz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.example.potrafisz.data.DictionaryDatabase;
import com.example.potrafisz.ui.langadd.LangaddFragment;
import com.example.potrafisz.ui.home.HomeFragment;
import com.example.potrafisz.ui.langlearn.LanglearnFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    public static Context appContext;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    public static String language;
    private Button userButton;
    private TextView userTx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);




            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            drawer = findViewById(R.id.drawer_layout);
            navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.setItemIconTintList(null);
            View headerLayout = navigationView.getHeaderView(0);
            userButton = headerLayout.findViewById(R.id.userButton);



            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();


            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();



            appContext = this.getApplicationContext();
            DictionaryDatabase db = DictionaryDatabase.getDbInstance(this.getApplicationContext());
            List<String> languages = db.dictionaryDao().getAllLanguages();
            for (int i = 0; i < languages.size(); i++) {
                String buff = languages.get(i);
                showItem(buff);
            }

            List<String> username = db.dictionaryDao().getUsername();

            userButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), UserActivity.class);
                    startActivity(intent);
                }
            });

        if (firstStart) {
            Intent intent = new Intent(this, FirstLoginActivity.class);
            startActivity(intent);
            //userTx.setText(username.get(0));
        }



    }


    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    public void showItem(String buff)
    {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();


            switch (buff) {
                case "English":
                    nav_Menu.findItem(R.id.flag_eng).setVisible(true);
                    break;
                case "????????????????????":
                    nav_Menu.findItem(R.id.flag_bel).setVisible(true);
                    break;
                case "??????????????????":
                    nav_Menu.findItem(R.id.flag_bul).setVisible(true);
                    break;
                case "Bosanski":
                    nav_Menu.findItem(R.id.flag_bos).setVisible(true);
                    break;
                case "??e??tina":
                    nav_Menu.findItem(R.id.flag_cze).setVisible(true);
                    break;
                case "Dansk":
                    nav_Menu.findItem(R.id.flag_den).setVisible(true);
                    break;
                case "Deutsch":
                    nav_Menu.findItem(R.id.flag_ger).setVisible(true);
                    break;
                case "Eesti":
                    nav_Menu.findItem(R.id.flag_est).setVisible(true);
                    break;
                case "????????????????":
                    nav_Menu.findItem(R.id.flag_gre).setVisible(true);
                    break;
                case "Espa??ol":
                    nav_Menu.findItem(R.id.flag_spa).setVisible(true);
                    break;
                case "Fran??ais":
                    nav_Menu.findItem(R.id.flag_fra).setVisible(true);
                    break;
                case "Hrvatski":
                    nav_Menu.findItem(R.id.flag_cro).setVisible(true);
                    break;
                case "Italiano":
                    nav_Menu.findItem(R.id.flag_ita).setVisible(true);
                    break;
                case "??slenska":
                    nav_Menu.findItem(R.id.flag_ice).setVisible(true);
                    break;
                case "Latvie??u":
                    nav_Menu.findItem(R.id.flag_lat).setVisible(true);
                    break;
                case "Lietuvi??":
                    nav_Menu.findItem(R.id.flag_lit).setVisible(true);
                    break;
                case "Magyar":
                    nav_Menu.findItem(R.id.flag_hun).setVisible(true);
                    break;
                case "Malti":
                    nav_Menu.findItem(R.id.flag_mal).setVisible(true);
                    break;
                case "????????????????????":
                    nav_Menu.findItem(R.id.flag_mac).setVisible(true);
                    break;
                case "Nederlands":
                    nav_Menu.findItem(R.id.flag_net).setVisible(true);
                    break;
                case "Norsk":
                    nav_Menu.findItem(R.id.flag_nor).setVisible(true);
                    break;
                case "Polski":
                    nav_Menu.findItem(R.id.flag_pol).setVisible(true);
                    break;
                case "Rom??n??":
                    nav_Menu.findItem(R.id.flag_rom).setVisible(true);
                    break;
                case "Portugu??s":
                    nav_Menu.findItem(R.id.flag_por).setVisible(true);
                    break;
                case "??????????????":
                    nav_Menu.findItem(R.id.flag_rus).setVisible(true);
                    break;

                case "Shqip":
                    nav_Menu.findItem(R.id.flag_alb).setVisible(true);
                    break;
                case "Sloven??ina":
                    nav_Menu.findItem(R.id.flag_svk).setVisible(true);
                    break;
                case "Sloven????ina":
                    nav_Menu.findItem(R.id.flag_slo).setVisible(true);
                    break;
                case "????????????":
                    nav_Menu.findItem(R.id.flag_ser).setVisible(true);
                    break;
                case "Suomi":
                    nav_Menu.findItem(R.id.flag_fin).setVisible(true);
                    break;
                case "Svenska":
                    nav_Menu.findItem(R.id.flag_swe).setVisible(true);
                    break;
                case "????????????????????":
                    nav_Menu.findItem(R.id.flag_ukr).setVisible(true);
                    break;
                case "Inny":
                    nav_Menu.findItem(R.id.another).setVisible(true);

                    break;


        }
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_new:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LangaddFragment()).commit();
                break;
            case R.id.flag_eng:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "angielski";
                break;
            case R.id.flag_bel:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new LanglearnFragment()).commit();
                language = "bia??oruski";
                break;
            case R.id.flag_bul:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "bu??garski";
                break;
            case R.id.flag_bos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "bo??niacki";
                break;
            case R.id.flag_cze:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "czeski";
                break;
            case R.id.flag_den:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "du??ski";
                break;
            case R.id.flag_ger:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "niemiecki";
                break;
            case R.id.flag_est:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "esto??ski";
                break;
            case R.id.flag_gre:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "grecki";
                break;
            case R.id.flag_spa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "hiszpa??ski";
                break;
            case R.id.flag_fra:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "francuski";
                break;
            case R.id.flag_cro:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "chorwacki";
                break;
            case R.id.flag_ita:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "w??oski";
                break;
            case R.id.flag_ice:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "islandzki";
                break;
            case R.id.flag_lat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "??otewski";
                break;
            case R.id.flag_lit:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "litewski";
                break;
            case R.id.flag_hun:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "w??gierski";
                break;
            case R.id.flag_mal:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "malta??ski";
                break;
            case R.id.flag_mac:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "macedo??ski";
                break;
            case R.id.flag_net:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "niderlandzki";
                break;
            case R.id.flag_nor:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "norweski";
                break;
            case R.id.flag_pol:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "polski";
                break;
            case R.id.flag_por:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "portugalski";
                break;
            case R.id.flag_rom:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "rumu??ski";
                break;
            case R.id.flag_rus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "rosyjski";
                break;
            case R.id.flag_alb:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "alba??ski";
                break;
            case R.id.flag_svk:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "s??owacki";
                break;
            case R.id.flag_slo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "s??owe??ski";
                break;
            case R.id.flag_ser:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "serbski";
                break;
            case R.id.flag_fin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "fi??ski";
                break;
            case R.id.flag_swe:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "szwedzki";
                break;
            case R.id.flag_ukr:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "ukrai??ski";
                break;
            case R.id.another:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LanglearnFragment()).commit();
                language = "Inne";
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}