package com.databindngdemo.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.databindngdemo.adapter.EmployeeAdapter;
import com.databindngdemo.bean.Employee;
import com.databindngdemo.main.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements EmployeeAdapter.OnItemClickListener {
    private  ActivityListBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_list);
        binding.setPresenter(new Presenter());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        EmployeeAdapter adapter = new EmployeeAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        List<Employee> demoList = new ArrayList<>();
        demoList.add(new Employee("Zhai", "Mark", false));
        demoList.add(new Employee("Zhai2", "Mark2", false));
        demoList.add(new Employee("Zhai3", "Mark3", true));
        demoList.add(new Employee("Zhai4", "Mark4", false));
        adapter.addAll(demoList);
        adapter.notifyDataSetChanged();
        adapter.setListener(this);
    }

    @Override
    public void OnEmployeeListener(Employee employee) {
        Toast.makeText(ListActivity.this,
                employee.getFirstName(), Toast.LENGTH_SHORT).show();
    }


    public class Presenter{
        public void onClickAddItem(View view){
            Toast.makeText(ListActivity.this,"onClickAddItem",Toast.LENGTH_LONG).show();
        }

        public void onClickRemoveItem(View view){
            Toast.makeText(ListActivity.this,"onClickRemoveItem",Toast.LENGTH_LONG).show();
        }
    }


}