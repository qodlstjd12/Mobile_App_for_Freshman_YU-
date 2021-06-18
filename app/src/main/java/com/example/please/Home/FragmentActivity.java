package com.example.please.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.please.Home.fragment.FoodFragment;
import com.example.please.Home.fragment.MyPageFragment;
import com.example.please.Home.fragment.NoteBookFragment;
import com.example.please.Home.fragment.NoticeFragment;
import com.example.please.Data.Myinfo;
import com.example.please.Home.fragment.ProfessorFragment;
import com.example.please.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class FragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        final Myinfo myinfo = (Myinfo) intent.getSerializableExtra("myinfo");
        String fragment = intent.getExtras().getString("fragment");
        Fragment f;
        Bundle bundle = new Bundle();
        bundle.putSerializable("myinfo",myinfo);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch(fragment){
            case "notebook":
                setTitle("노트북 대여");
                f = new NoteBookFragment();
                f.setArguments(bundle);
                ft.replace(R.id.nav_host_fragment, f);
                ft.commit();
                break;
            case "notice":
                setTitle("공지사항");
                f = new NoticeFragment();
                f.setArguments(bundle);
                ft.replace(R.id.nav_host_fragment, f);
                ft.commit();
                break;
            case "mypage":
                setTitle("마이페이지");
                f = new MyPageFragment();
                f.setArguments(bundle);
                ft.replace(R.id.nav_host_fragment, f);
                ft.commit();
                break;
            case "food":
                setTitle("오늘의 맛집");
                f = new FoodFragment();
                f.setArguments(bundle);
                ft.replace(R.id.nav_host_fragment, f);
                ft.commit();
                break;
            case "professor":
                setTitle("교수진 소개");
                f = new ProfessorFragment();
                f.setArguments(bundle);
                ft.replace(R.id.nav_host_fragment, f);
                ft.commit();
                break;
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        View nav_header_main = navigationView.getHeaderView(0);
        TextView 네비이름,네비이메일;
        네비이름 = (TextView)nav_header_main.findViewById(R.id.nav_name);
        네비이메일 = (TextView)nav_header_main.findViewById(R.id.nav_email);
        네비이름.setText(myinfo.getName());
        네비이메일.setText(myinfo.getEmail());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                Fragment fragment = null;
                Bundle bundle = new Bundle();

                if (itemId == R.id.notice) {
                    setTitle("공지사항");
                    fragment = new NoticeFragment();
                    bundle.putSerializable("myinfo",myinfo);
                    fragment.setArguments(bundle);
                } else if (itemId == R.id.notebook) {
                    setTitle("노트북 대여");
                    fragment = new NoteBookFragment();
                    bundle.putSerializable("myinfo",myinfo);
                    fragment.setArguments(bundle);
                }else if(itemId == R.id.mypage){
                    setTitle("마이페이지");
                    fragment = new MyPageFragment();
                    bundle.putSerializable("myinfo",myinfo);
                    fragment.setArguments(bundle);
                }else if(itemId == R.id.food){
                    setTitle("오늘의 맛집");
                    fragment = new FoodFragment();
                    bundle.putSerializable("myinfo",myinfo);
                    fragment.setArguments(bundle);
                }else{
                    setTitle("교수진 소개");
                    fragment = new ProfessorFragment();
                    bundle.putSerializable("myinfo",myinfo);
                    fragment.setArguments(bundle);
                }

                if (fragment != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.nav_host_fragment, fragment);
                    ft.commit();
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}
