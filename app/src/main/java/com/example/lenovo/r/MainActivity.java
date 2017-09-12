package com.example.lenovo.r;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout f1;
    private Button button1;
    private Button button2;
    private AFragment aFragment;
    private BFragment bFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getDta();
    }

    private void getDta() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        aFragment = new AFragment();
        bFragment = new BFragment();
        transaction.replace(R.id.f1, aFragment);
        transaction.commit();


    }

    private void initView() {
        f1 = (FrameLayout) findViewById(R.id.f1);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.button1:
                transaction.replace(R.id.f1, aFragment);
                break;
            case R.id.button2:
                transaction.replace(R.id.f1, bFragment);
                break;
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
}