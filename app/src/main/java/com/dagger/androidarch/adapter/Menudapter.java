package com.dagger.androidarch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dagger.androidarch.databinding.CartListItemBinding;
import com.dagger.androidarch.databinding.InboxRowItemBinding;
import com.dagger.androidarch.model.Inbox;
import com.dagger.androidarch.model.MenuModel;

import java.util.ArrayList;

public class Menudapter extends RecyclerView.Adapter<Menudapter.InboxAdapterViewHolder> {
    private ArrayList<MenuModel> employees;
    CartListItemBinding binding;
    private Context mContext;

    public Menudapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public InboxAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = CartListItemBinding.inflate(inflater,viewGroup,false);
        return new InboxAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InboxAdapterViewHolder employeeViewHolder, int i) {
        employeeViewHolder.mybinding.setMenu(employees.get(i));

    }
    @Override
    public int getItemCount() {
        if (employees != null) {
            return employees.size();
        } else {
            return 0;
        }
    }
    public void setInboxList(ArrayList<MenuModel> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }


   public class InboxAdapterViewHolder extends RecyclerView.ViewHolder{

        public CartListItemBinding mybinding;

        public InboxAdapterViewHolder(CartListItemBinding binding) {
            super(binding.getRoot());
            this.mybinding = binding;
        }
    }
    public void removeItem(int position) {
        employees.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

    public void restoreItem(MenuModel item, int position) {
        employees.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }



}