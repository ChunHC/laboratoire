package com.lab.chun.androidlab;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import model.DatabaseHandler;

/**
 * Created by chun on 2015-05-02.
 */
public class ListingClub extends ListFragment {
    @Override
    public void onListItemClick(ListView listview, View view, int position, long id) {
        ((ClubWeb) getActivity().getFragmentManager().findFragmentById(R.id.webFragment))
                .loadUrl(view.getTag().toString());
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        // Create the adapter to convert the array to views
        ClubAdapter adapter = new ClubAdapter(
                getActivity().getApplicationContext(),
                DatabaseHandler.getInstance(null).getClubList()
        );
        // Attach the adapter to a ListView
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
