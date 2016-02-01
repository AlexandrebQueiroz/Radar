package br.com.radar.activity;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;


import br.com.radar.adapter.reciclerView.MoviesAdapter;
import br.com.radar.fragment.OneFragment;
import br.com.radar.fragment.ThreeFragment;
import br.com.radar.fragment.TwoFragment;
import br.com.radar.model.Movie;
import br.com.radar.radar.R;


public class HomeActivity extends AppCompatActivity {

    private Context context;

    private final int abaConversa = 0;
    private final int abaPessoa = 1;
    private final int abaEvento = 2;


    //Abas
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    //Aba Fragmento One
    private TextView textoFragment;

    //Recicler view
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    public static String POSITION = "POSITION";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        context = HomeActivity.this;

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == abaConversa){
                    Toast.makeText(context, "Aba um Selecionada", Toast.LENGTH_SHORT).show();
                }else if(tab.getPosition() == abaPessoa){
                    Toast.makeText(context, "Aba Dois Selecionada", Toast.LENGTH_SHORT).show();
                }else if(tab.getPosition() == abaEvento){
                    Toast.makeText(context, "Aba Três Selecionada", Toast.LENGTH_SHORT).show();
                }
                
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                if(tab.getPosition() == abaConversa){
                    Toast.makeText(context, "Aba um DesSelecionada", Toast.LENGTH_SHORT).show();
                }else if(tab.getPosition() == abaPessoa){
                    Toast.makeText(context, "Aba Dois DesSelecionada", Toast.LENGTH_SHORT).show();
                }else if(tab.getPosition() == abaEvento){
                    Toast.makeText(context, "Aba Três DesSelecionada", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if(tab.getPosition() == abaConversa){
                    Toast.makeText(context, "Aba um ReSelecionada", Toast.LENGTH_SHORT).show();
                }else if(tab.getPosition() == abaPessoa){
                    Toast.makeText(context, "Aba Dois ReSelecionada", Toast.LENGTH_SHORT).show();
                }else if(tab.getPosition() == abaEvento){
                    Toast.makeText(context, "Aba Três ReSelecionada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setupTabIcons();

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(abaConversa).setIcon(R.drawable.ic_tab_radar);
        tabLayout.getTabAt(abaPessoa).setIcon(R.drawable.ic_tab_people);
        tabLayout.getTabAt(abaEvento).setIcon(R.drawable.ic_tab_calendar);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "ONE");
        adapter.addFragment(new TwoFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(POSITION, tabLayout.getSelectedTabPosition());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        viewPager.setCurrentItem(savedInstanceState.getInt(POSITION));
    }

}
