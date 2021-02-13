package com.example.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private TextView username;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        username=findViewById(R.id.username);
        Map<String,String> account=SaveAccount.getUserInfo(this);
        username.setText(account.get("account"));
        //bottomNavigationView添加监听器，导航栏的项发生改变时，对应的页面也相应作出改变
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_news:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.item_finding:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.item_plus:
                        viewPager.setCurrentItem(2);
                        break;

                }
                return true;
            }
        });

        //viewPager添加监听器：当用户滑动页面时，导航栏的项目也要发生改变
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //当页面滑动完成时调用
            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //向适配器里添加Fragment
        setViewPagerAdapter(viewPager);
    }

    //向适配器中添加Fragment
    private void setViewPagerAdapter(ViewPager viewPager){
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment1());
        adapter.addFragment(new Fragment2());
        adapter.addFragment(new Fragment3());

        viewPager.setAdapter(adapter);
    }
    public void onInformClick(View view)
    {
        Intent intent=new Intent(this,InformActivity.class);
        startActivity(intent);
    }
}
