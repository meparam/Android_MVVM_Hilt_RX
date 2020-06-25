package com.dagger.androidarch.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dagger.androidarch.utils.RecyclerItemTouchHelper;
import com.dagger.androidarch.adapter.Menudapter;
import com.dagger.androidarch.databinding.FragmentHomeBinding;
import com.dagger.androidarch.model.MenuModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener{

    private HomeViewModel homeViewModel;
    FragmentHomeBinding fragmentNotificationsBinding;


    Menudapter inboxAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        fragmentNotificationsBinding = FragmentHomeBinding.inflate(inflater,container,false);
        View view = fragmentNotificationsBinding.getRoot();

        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = fragmentNotificationsBinding.popularRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);


        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);


        homeViewModel = new ViewModelProvider(HomeFragment.this).get(HomeViewModel.class);

        inboxAdapter = new Menudapter(getActivity());
        recyclerView.setAdapter(inboxAdapter);

        homeViewModel.getAllInbox().observe(getViewLifecycleOwner(), new Observer<ArrayList<MenuModel>>() {
            @Override
            public void onChanged(ArrayList<MenuModel> inboxes) {

                inboxAdapter.setInboxList(inboxes);
                   Log.e("TAG", "onChanged: "+inboxes.toString() );
            }
        });
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof Menudapter.InboxAdapterViewHolder) {
            // get the removed item name to display it in snack bar
          //  String name = cartList.get(viewHolder.getAdapterPosition()).getName();

            // backup of removed item for undo purpose
           // final Item deletedItem = cartList.get(viewHolder.getAdapterPosition());
           // final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            inboxAdapter.removeItem(viewHolder.getAdapterPosition());

//            // showing snack bar with Undo option
//            Snackbar snackbar = Snackbar
//                    .make(coordinatorLayout, name + " removed from cart!", Snackbar.LENGTH_LONG);
//            snackbar.setAction("UNDO", new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    // undo is selected, restore the deleted item
//                    mAdapter.restoreItem(deletedItem, deletedIndex);
//                }
//            });
//            snackbar.setActionTextColor(Color.YELLOW);
//            snackbar.show();
        }
    }
}