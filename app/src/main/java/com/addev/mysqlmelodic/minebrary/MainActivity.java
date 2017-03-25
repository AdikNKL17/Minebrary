package com.addev.mysqlmelodic.minebrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Jadwal> jadwalList = new ArrayList<>();
    RecyclerView recyclerView;
    JadwalAdapter jadwalAdapter;

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        setupToolbar();
        navigationView = (NavigationView)findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        return true;
                    case R.id.nav_my_profile:
                        Toast.makeText(MainActivity.this, "My Profile clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_settings:
                        Toast.makeText(MainActivity.this, "Settings clicked", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return true;
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recycler);

        jadwalAdapter = new JadwalAdapter(jadwalList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new Divider(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(jadwalAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView,
                new ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Jadwal jadwal = jadwalList.get(position);
                        Toast.makeText(MainActivity.this, "Clicked " +jadwalList.get(position).toString(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Detail.class);

                        startActivity(intent);
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));

        dataJadwal();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void dataJadwal(){
        Jadwal jadwal = new Jadwal(R.drawable.alias,"Alias", "Ruwi Meita",R.drawable.ic_star_amber_300_24dp, "5.0");
        jadwalList.add(jadwal);
        jadwal = new Jadwal(R.drawable.perahu_kertas,"Perahu Kertas", "Dee",R.drawable.ic_star_amber_300_24dp, "4.0");
        jadwalList.add(jadwal);
        jadwal = new Jadwal(R.drawable.manusia_setengah_salmon,"Manusia Setengah Salmon", "Raditya Dika",R.drawable.ic_star_amber_300_24dp, "4.5");
        jadwalList.add(jadwal);
        jadwal = new Jadwal(R.drawable.misteri_rumah_kosong,"Misteri Rumah Kosong", "Glenn Alexei",R.drawable.ic_star_amber_300_24dp, "3.9");
        jadwalList.add(jadwal);
        jadwal = new Jadwal(R.drawable.summer_in_seoul,"Summer In Seoul", "Ilana Tan",R.drawable.ic_star_amber_300_24dp, "4.1");
        jadwalList.add(jadwal);
        jadwal = new Jadwal(R.drawable.winter_in_tokyo,"Winter In Tokyo", "Ilana Tan",R.drawable.ic_star_amber_300_24dp, "4.7");
        jadwalList.add(jadwal);

        jadwalAdapter.notifyDataSetChanged();
    }

    public interface ClickListener{
        void onClick (View view, int position);
        void onLongClick (View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private GestureDetector detector;
        private MainActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView,
                                     final MainActivity.ClickListener clickListener){
            this.clickListener = clickListener;
            detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent motionEvent){
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent motionEvent){
                    View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                    if (child != null && clickListener != null){
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && detector.onTouchEvent(e)){
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    private void setupToolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

        actionBar.setTitle(R.string.app_name);
    }

}
