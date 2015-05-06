package com.lab.chun.androidlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import model.Club;

/**
 * Created by chun on 2015-05-02.
 */
public class ClubAdapter extends ArrayAdapter<Club> {
    private Context context;

    public ClubAdapter(Context context, ArrayList<Club> clubs) {
        super(context, 0, clubs);

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Club club = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listing_club_item,
                    parent,
                    false
            );

        // Lookup view for data population
        ImageView icone = (ImageView) convertView.findViewById(R.id.icone);
        TextView nom = (TextView) convertView.findViewById(R.id.nom);
        TextView local = (TextView) convertView.findViewById(R.id.local);

        // Populate the data into the template view using the data object
        int id = context.getResources().getIdentifier(
                club.getIcone(),
                "drawable",
                context.getPackageName()
        );
        if (id != 0)
            icone.setImageResource(id);
        nom.setText(club.getNom());
        local.setText(club.getLocal());

        convertView.setTag(club.getSiteweb());

        // Return the completed view to render on screen
        return convertView;
    }
}
