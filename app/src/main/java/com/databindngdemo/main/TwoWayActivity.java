package com.databindngdemo.main;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.widget.Toast;

import com.databindngdemo.bean.FormModel;
import com.databindngdemo.main.databinding.ActivityTwoWayBinding;

public class TwoWayActivity extends Activity {

    private ActivityTwoWayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_way);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_two_way);
        FormModel model = new FormModel("markzhai", "123456");

        binding.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Toast.makeText(TwoWayActivity.this, String.valueOf(propertyId),
                        Toast.LENGTH_SHORT).show();
            }
        });

        binding.setModel(model);

    }
}
