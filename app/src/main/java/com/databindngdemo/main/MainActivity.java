package com.databindngdemo.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.databindngdemo.main.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private  ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mBinding.setPresenter(new Presenter());
    }

    public class Presenter{
        public void onClickSimpleDemo(View view) {
            startActivity(new Intent(MainActivity.this, SimpleActivity.class));
        }

        public void onClickListActivity(View view) {
            startActivity(new Intent(MainActivity.this, ListActivity.class));
        }

        public void onClickTwoWayActivity(View view) {
            startActivity(new Intent(MainActivity.this, TwoWayActivity.class));
        }

        public void onClickExpressionActivity(View view) {
            startActivity(new Intent(MainActivity.this, ExpressionActivity.class));
        }
        public void onClickAnimationActivity(View view) {
            startActivity(new Intent(MainActivity.this, AnimationActivity.class));
        }
    }
}
