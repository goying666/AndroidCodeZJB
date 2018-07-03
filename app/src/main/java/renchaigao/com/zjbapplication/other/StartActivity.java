package renchaigao.com.zjbapplication.other;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import renchaigao.com.zjbapplication.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)actionBar.hide();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);       //此界面沉睡5秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(StartActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }).start();
    }
}
