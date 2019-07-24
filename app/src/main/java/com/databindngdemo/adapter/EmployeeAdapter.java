package com.databindngdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.databindngdemo.bean.Employee;
import com.databindngdemo.main.BR;
import com.databindngdemo.main.BindingViewHolder;
import com.databindngdemo.main.ListActivity;
import com.databindngdemo.main.R;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private static final int ITEM_VIEW_TYPE_ON = 1; //在职
    private static final int ITEM_VIEW_TYPE_OFF = 2;//开除
    private LayoutInflater mLayoutInflater;
    private List<Employee> mEmployeeList;

    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void OnEmployeeListener(Employee employee);
    }

    public void setListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public EmployeeAdapter(Context context){
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mEmployeeList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        Employee employee = mEmployeeList.get(position);
        if(employee.isFired.get()){
            return ITEM_VIEW_TYPE_OFF;
        }else{
            return ITEM_VIEW_TYPE_ON;
        }
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if(viewType == ITEM_VIEW_TYPE_ON){
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee, parent, false);

        }else{
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee_off,parent,false);

        }
        return new BindingViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        final Employee employee = mEmployeeList.get(position);
//        holder.getBinding().setVariable(BR.item,employee);
        holder.getBinding().setVariable(BR.item,employee);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnEmployeeListener(employee);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mEmployeeList.size();
    }

    public void addAll(List<Employee> employees) {
        mEmployeeList.addAll(employees);
    }

}
