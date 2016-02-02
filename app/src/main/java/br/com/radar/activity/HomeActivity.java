package br.com.radar.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;

import br.com.radar.activity.fragment.FragmentAbaA_Eventos;
import br.com.radar.activity.fragment.FragmentAbaB_Conversas;
import br.com.radar.activity.fragment.FragmentAbaC_Pessoas;
import br.com.radar.adpter.ViewPagerAdapter;
import br.com.radar.radar.R;
import br.com.radar.util.Typefaces;


public class HomeActivity extends AppCompatActivity {

    private final int abaEvento = 0;
    private final int abaPessoa = 1;
    private final int abaConversa = 2;

    private ViewPagerAdapter adp;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private String caminhoFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        setupFloatingActionButton();
        setupViewPagger();
        setupTabIcons();
    }

    private void setupViewPagger() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adp = new ViewPagerAdapter(getSupportFragmentManager());
        adp.addFragment(new FragmentAbaA_Eventos(),"Eventos");
        adp.addFragment(new FragmentAbaB_Conversas(), "e90b");
        adp.addFragment(new FragmentAbaC_Pessoas(), "icon-headphones");
        viewPager.setAdapter(adp);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(getResources().getColor(R.color.black), getResources().getColor(R.color.vermelho));
    }

    private void setupFloatingActionButton(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                caminhoFoto = getFilesDir()+ "/" + System.currentTimeMillis()+ ".png";
                Intent irCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File arquivo = new File(caminhoFoto);
                Uri localFoto = Uri.fromFile(arquivo);
                irCamera.putExtra(MediaStore.EXTRA_OUTPUT, arquivo);
                startActivityForResult(irCamera, 123);

           }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123) {

            if(resultCode== Activity.RESULT_OK){
                Toast.makeText(this, caminhoFoto, Toast.LENGTH_SHORT).show();
                
            }else if(resultCode== Activity.RESULT_CANCELED){

            }else if(resultCode== Activity.RESULT_FIRST_USER){

            }
        }
    }

    private void setupTabIcons() {

    }
}

