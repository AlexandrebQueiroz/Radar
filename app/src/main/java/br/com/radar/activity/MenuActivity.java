package br.com.radar.activity;


import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.radar.activity.fragment.FragmentAbaA_Eventos;
import br.com.radar.activity.fragment.FragmentAbaB_Conversas;
import br.com.radar.activity.fragment.FragmentAbaC_Pessoas;
import br.com.radar.adpter.ViewPagerAdapter;
import br.com.radar.radar.R;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private ViewPagerAdapter adp;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ImageView fotoPerfil;
    private TextView textoPerfil;
    private TextView codPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        iniciarElementosTela();
        setupViewPagger();

    }


    private void iniciarElementosTela() {

        View headerLayout = navigationView.getHeaderView(0);

        fotoPerfil = (ImageView) headerLayout.findViewById(R.id.foto_perfil);
        textoPerfil = (TextView) headerLayout.findViewById(R.id.texto_perfil);
        codPerfil = (TextView) headerLayout.findViewById(R.id.cod_perfil);

        fotoPerfil.setImageResource(R.drawable.ic_foto_perfil);
        textoPerfil.setText("Alexandre Queiroz");
        codPerfil.setText("@AQueiroz");


        fotoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Ir para Perfil 1", Toast.LENGTH_SHORT).show();
            }
        });

        textoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Ir para Perfil 2", Toast.LENGTH_SHORT).show();
            }
        });

        codPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Ir para Perfil 3", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setupViewPagger() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        adp = new ViewPagerAdapter(getSupportFragmentManager());
        adp.addFragment(new FragmentAbaA_Eventos(), "Eventos");
        adp.addFragment(new FragmentAbaB_Conversas(), "e90b");
        adp.addFragment(new FragmentAbaC_Pessoas(), "icon-headphones");

        viewPager.setAdapter(adp);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(getResources().getColor(R.color.colorPrimaryDark), getResources().getColor(R.color.colorAccent));
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        String texto = "";

        if (id == R.id.nav_perfil) {
            texto = "perfil";
        } else if (id == R.id.nav_pessoas) {
            texto = "pessoas";
        } else if (id == R.id.nav_locais) {
            texto = "locais";
        } else if (id == R.id.nav_eventos) {
            texto = "eventos";
        } else if (id == R.id.nav_preferencias) {
            texto = "preferencias";
        } else if (id == R.id.nav_visibilidade) {
            texto = "visibilidade";
        }

        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
