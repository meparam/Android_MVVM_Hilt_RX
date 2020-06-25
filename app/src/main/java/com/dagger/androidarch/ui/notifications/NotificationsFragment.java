package com.dagger.androidarch.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dagger.androidarch.R;
import com.dagger.androidarch.adapter.InboxAdapter;
import com.dagger.androidarch.databinding.FragmentNotificationsBinding;
import com.dagger.androidarch.model.Inbox;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    FragmentNotificationsBinding fragmentNotificationsBinding;


    InboxAdapter inboxAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentNotificationsBinding = FragmentNotificationsBinding.inflate(inflater,container,false);
       View view = fragmentNotificationsBinding.getRoot();

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = fragmentNotificationsBinding.popularRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        notificationsViewModel = new ViewModelProvider(NotificationsFragment.this).get(NotificationsViewModel.class);
        // notificationsViewModel.getCast();

        inboxAdapter = new InboxAdapter(getActivity());
        recyclerView.setAdapter(inboxAdapter);

        notificationsViewModel.getAllInbox().observe(getViewLifecycleOwner(), new Observer<ArrayList<Inbox>>() {
            @Override
            public void onChanged(ArrayList<Inbox> inboxes) {

                inboxAdapter.setInboxList(inboxes);
                //   Log.e("TAG", "onChanged: "+inboxes.toString() );
            }
        });
    }


}