package com.example.recyclerviewanimation;

import android.content.res.ColorStateList;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Message> mMessageList;

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    private boolean isDark = false;
    private FloatingActionButton fab;
    private ConstraintLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = findViewById(R.id.root_layout);
        Date date =  new Date();

        mMessageList = new ArrayList<>();
        mMessageList.add(new Message(getString(R.string.one_title),getString(R.string.one_desc),date,R.drawable.one));
        mMessageList.add(new Message(getString(R.string.two_title),getString(R.string.two_desc),date,R.drawable.two));
        mMessageList.add(new Message(getString(R.string.three_title),getString(R.string.three_desc),date,R.drawable.three));
        mMessageList.add(new Message(getString(R.string.four_title),getString(R.string.four_desc),date,R.drawable.four));
        mMessageList.add(new Message(getString(R.string.five_title),getString(R.string.five_desc),date,R.drawable.five));
        mMessageList.add(new Message(getString(R.string.six_title),getString(R.string.six_desc),date,R.drawable.six));
        mMessageList.add(new Message(getString(R.string.seven_title),getString(R.string.seven_desc),date,R.drawable.seven));
        mMessageList.add(new Message(getString(R.string.eight_title),getString(R.string.eight_desc),date,R.drawable.eight));
        mMessageList.add(new Message(getString(R.string.nine_title),getString(R.string.nine_desc),date,R.drawable.nine));
        mMessageList.add(new Message(getString(R.string.ten_title),getString(R.string.ten_desc),date,R.drawable.ten));
        mMessageList.add(new Message(getString(R.string.eleven_title),getString(R.string.eleven_desc),date,R.drawable.eleven));

        mRecyclerView = findViewById(R.id.recycler_view_main);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerViewAdapter = new RecyclerViewAdapter(this,mMessageList,isDark);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        fab = findViewById(R.id.fab_main);

        final Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark;
                if(isDark){
                    rootLayout.setBackgroundColor(getColor(R.color.black));
                    window.setStatusBarColor(getColor(R.color.black));
                    fab.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.colorMaterialBlack900)));
                    fab.setImageResource(R.drawable.ic_wb_sunny_white_56dp);
                }else {
                    rootLayout.setBackgroundColor(getColor(R.color.white));
                    window.setStatusBarColor(getColor(R.color.colorPrimaryDark));
                    fab.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.colorAccent)));
                    fab.setImageResource(R.drawable.ic_brightness_3_black_56dp);
                }
                mRecyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,mMessageList,isDark);
                mRecyclerView.setAdapter(mRecyclerViewAdapter);
            }
        });
    }
}
