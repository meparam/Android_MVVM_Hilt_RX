package com.dagger.androidarch.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dagger.androidarch.R;
import com.dagger.androidarch.databinding.InboxRowItemBinding;
import com.dagger.androidarch.model.Inbox;
import com.dagger.androidarch.utils.Constants;

import java.util.ArrayList;

public class InboxAdapter  extends RecyclerView.Adapter<InboxAdapter.InboxAdapterViewHolder> {
    private ArrayList<Inbox> employees;
    InboxRowItemBinding binding;
    private Context mContext;

    public InboxAdapter( Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public InboxAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = InboxRowItemBinding.inflate(inflater,viewGroup,false);
        return new InboxAdapterViewHolder(binding);

    }
    @Override
    public void onBindViewHolder(@NonNull InboxAdapterViewHolder employeeViewHolder, int i) {
       // Inbox currentStudent = ;


        employeeViewHolder.mybinding.setInbox(employees.get(i));

        employeeViewHolder.mybinding.iconProfile.setColorFilter(Constants.getRandomMaterialColor());
        employeeViewHolder.mybinding.iconProfile.setImageResource(R.drawable.bg_circle);

    }
    @Override
    public int getItemCount() {
        if (employees != null) {
            return employees.size();
        } else {
            return 0;
        }
    }
    public void setInboxList(ArrayList<Inbox> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }


    class InboxAdapterViewHolder extends RecyclerView.ViewHolder{

        private InboxRowItemBinding mybinding;

        public InboxAdapterViewHolder(InboxRowItemBinding binding) {
            super(binding.getRoot());
            this.mybinding = binding;
        }
    }




}