package com.example.gmail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.*;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public static ArrayList<EmailItem> emailItems_star = new ArrayList<EmailItem>();

    RecyclerView mRecyclerView, mRecyclerView_star;
    EmailItemAdapter mAdapter, mAdapter_star;
    ImageButton star;
    MenuItem stared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_activity_main);

        stared = findViewById(R.id.with_star);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EmailComposerActivity.class));
            }
        });

        mRecyclerView = findViewById(R.id.emailList);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, mLayoutManager.getOrientation()));
        mRecyclerView.setLayoutManager(mLayoutManager);

        EmailItem[] email_sample = EmailItem.samples();
        mAdapter = new EmailItemAdapter(email_sample);
        mRecyclerView.setAdapter(mAdapter);

        EmailItem[] emailss = findStar(mRecyclerView);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.opening_drawer, R.string.closing_drawer);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    public EmailItem[] findStar(RecyclerView mRecyclerView_){
        View v = mRecyclerView_.getLayoutManager().findViewByPosition(0);
        System.out.println(v + "giang");
        EmailItem[] emailss = {
                new EmailItem("msonline", "Mã kiểm chứng",
                        "Kiểm chứng email", "2/12/2020")};

        return emailss;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                break;
            case R.id.with_star:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(Gravity.START)){
            drawer.closeDrawer(Gravity.START);
        }

        System.out.println("size = " + emailItems_star.size());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        ArrayList<EmailItem> emails = new ArrayList<EmailItem>();
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, mLayoutManager.getOrientation()));
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new EmailItemAdapter(MainActivity.emailItems_star);
        mRecyclerView.setAdapter(mAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        DrawerLayout drawer1 = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle1 = new ActionBarDrawerToggle(this, drawer1, toolbar,
                R.string.opening_drawer, R.string.closing_drawer);

        drawer1.addDrawerListener(toggle1);
        toggle1.syncState();

        return true;
    }
}
