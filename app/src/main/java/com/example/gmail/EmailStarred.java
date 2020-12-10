package com.example.gmail;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;

public class EmailStarred extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.drawer_activity_main);
        setTitle("Starred");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showListStarred();
    }

    public void showListStarred( )  {
        System.out.println("size = " + MainActivity.emailItems_star.size());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        RecyclerView mRecyclerView = findViewById(R.id.emailList);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, mLayoutManager.getOrientation()));
        mRecyclerView.setLayoutManager(mLayoutManager);

        for(EmailItem p:MainActivity.emailItems_star){
            p.setStar(1);

        }

        EmailItemAdapter mAdapter = new EmailItemAdapter(MainActivity.emailItems_star);
        mRecyclerView.setAdapter(mAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        DrawerLayout drawer1 = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle1 = new ActionBarDrawerToggle(this, drawer1, toolbar,
                R.string.opening_drawer, R.string.closing_drawer);

        drawer1.addDrawerListener(toggle1);
        toggle1.syncState();
    }
}
