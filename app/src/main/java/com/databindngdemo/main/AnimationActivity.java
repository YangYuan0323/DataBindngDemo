package com.databindngdemo.main;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.databindngdemo.main.databinding.ActivtiyAnimationBinding;

public class AnimationActivity extends Activity {
    ActivtiyAnimationBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activtiy_animation);
        binding.setPresenter(new Presenter());
        binding.addOnRebindCallback(new OnRebindCallback() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup root = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(root);
                return true;
            }
        });

    }

    public class Presenter{
        public void onCheckedChanged(View buttonView, Boolean isChecked){
            binding.setShowImage(isChecked);
        }
    }
}
