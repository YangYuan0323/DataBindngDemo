package com.databindngdemo.main;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.databindngdemo.bean.Employee;
import com.databindngdemo.main.databinding.ActivityExpressionBinding;

import java.util.Random;

public class ExpressionActivity extends Activity {

    private ActivityExpressionBinding binding;
    Random mRandom = new Random(System.currentTimeMillis());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Employee employee = new Employee("mark", "zhai");
        employee.setAvatar("https://avatars2.githubusercontent.com/u/1106500?v=3&s=460");
        binding = DataBindingUtil.setContentView(this,R.layout.activity_expression);
        binding.setEmployee(employee);

    }
}
