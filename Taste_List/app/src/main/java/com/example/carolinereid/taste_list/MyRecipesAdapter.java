package com.example.carolinereid.taste_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by carolinereid on 11/11/2017.
 */

public class MyRecipesAdapter extends ArrayAdapter<Recipe> {

    public MyRecipesAdapter(Context context, ArrayList<Recipe> recipes) {
        super(context, 0, recipes);
    }

    public View getView(int position, View listItemView, ViewGroup parent){
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.recipe_item, parent, false);
        }
        Recipe currentRecipe = getItem(position);
        TextView name = (TextView)listItemView.findViewById(R.id.name);
        name.setText(currentRecipe.getName());
        TextView url = (TextView)listItemView.findViewById(R.id.url);
        url.setText(currentRecipe.getUrl());
        TextView triedStatus = (TextView)listItemView.findViewById(R.id.triedStatus);
        triedStatus.setText(currentRecipe.getTriedStatus());
        TextView notes = (TextView)listItemView.findViewById(R.id.notes);
        notes.setText(currentRecipe.getNotes());

        listItemView.setTag(currentRecipe);

        return listItemView;
    }
}
