package com.databindngdemo.main;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.databindngdemo.bean.Employee;
import com.databindngdemo.main.databinding.ActivityDemoBinding;

public class SimpleActivity extends Activity {
    private ActivityDemoBinding binding;
    Employee employee = new Employee("Zhai", "Mark");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_demo);
        binding.viewStub.getViewStub().inflate();
        binding.setEmployee(employee);
        binding.setPresenter(new Presenter());

    }

    public class Presenter{
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            employee.setFirstName(s.toString());
            employee.setFired(!employee.isFired.get());
        }

        public void onClick(){
            Toast.makeText(SimpleActivity.this, "点到了", Toast.LENGTH_SHORT).show();
        }

        public void onClickListenerBinding(Employee employee){
            Toast.makeText(SimpleActivity.this, employee.getLastName(),
                    Toast.LENGTH_SHORT).show();
        }


    }

}
