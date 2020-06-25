package com.dagger.androidarch.ui.dashboard;

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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dagger.androidarch.R;
import com.dagger.androidarch.adapter.FeedAdapter;
import com.dagger.androidarch.adapter.Menudapter;
import com.dagger.androidarch.databinding.FragmentDashboardBinding;
import com.dagger.androidarch.databinding.FragmentHomeBinding;
import com.dagger.androidarch.model.Feed;
import com.dagger.androidarch.model.MenuModel;
import com.dagger.androidarch.ui.home.HomeFragment;
import com.dagger.androidarch.ui.home.HomeViewModel;
import com.dagger.androidarch.utils.RecyclerItemTouchHelper;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding fragmentDashboardBinding;
    private DashboardViewModel dashboardViewModel;
    private FeedAdapter feedAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fragmentDashboardBinding = FragmentDashboardBinding.inflate(inflater,container,false);
        View view = fragmentDashboardBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = fragmentDashboardBinding.popularRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        dashboardViewModel = new ViewModelProvider(DashboardFragment.this).get(DashboardViewModel.class);
        feedAdapter = new FeedAdapter(getActivity());
        recyclerView.setAdapter(feedAdapter);

        dashboardViewModel.getAllFeed().observe(getViewLifecycleOwner(), new Observer<ArrayList<Feed>>() {
            @Override
            public void onChanged(ArrayList<Feed> inboxes) {

                feedAdapter.setInboxList(inboxes);
                Log.e("TAG", "onChanged: "+inboxes.toString() );
            }
        });
    }
}