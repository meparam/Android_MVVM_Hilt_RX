package com.dagger.androidarch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dagger.androidarch.R;
import com.dagger.androidarch.databinding.FeedListItemRowBinding;
import com.dagger.androidarch.databinding.InboxRowItemBinding;
import com.dagger.androidarch.model.Feed;
import com.dagger.androidarch.model.Inbox;
import com.dagger.androidarch.utils.Constants;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.InboxAdapterViewHolder> {
    private ArrayList<Feed> employees;
    FeedListItemRowBinding  binding;
    private Context mContext;

    public FeedAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public InboxAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = FeedListItemRowBinding.inflate(inflater,viewGroup,false);
        return new InboxAdapterViewHolder(binding);

    }
    @Override
    public void onBindViewHolder(@NonNull InboxAdapterViewHolder employeeViewHolder, int i) {

        employeeViewHolder.mybinding.setFeed(employees.get(i));
    }

    @Override
    public int getItemCount() {
        if (employees != null) {
            return employees.size();
        } else {
            return 0;
        }
    }

    public void setInboxList(ArrayList<Feed> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }


    class InboxAdapterViewHolder extends RecyclerView.ViewHolder{

        private FeedListItemRowBinding mybinding;

        public InboxAdapterViewHolder(FeedListItemRowBinding binding) {
            super(binding.getRoot());
            this.mybinding = binding;
        }
    }




}