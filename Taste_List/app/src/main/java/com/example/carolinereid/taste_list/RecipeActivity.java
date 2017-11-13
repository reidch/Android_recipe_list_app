package com.example.carolinereid.taste_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    TextView nameTV;
    TextView urlTV;
    TextView notesTV;
    Switch switchStatus;
    Bundle extras;
    String name;
    String url;
    String notes;
    Boolean triedStatus;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        extras = getIntent().getExtras();

        name = extras.getString("name");
        url = extras.getString("url");
        notes = extras.getString("notes");
        triedStatus = extras.getBoolean("triedStatus");

        nameTV = (TextView) findViewById(R.id.name);
        urlTV = (TextView) findViewById(R.id.url);
        notesTV = (TextView) findViewById(R.id.notes);
        switchStatus = (Switch) findViewById(R.id.triedStatus);

        nameTV.setText(name);
        urlTV.setText(url);
        notesTV.setText(notes);
        switchStatus.setChecked(triedStatus);
    }

    public void updateRecipe(View button){

    }

    public void deleteRecipe(View button){
        Integer id = extras.getInt("id");
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.delete(id);
        Intent intent = new Intent(this, MyRecipesActivity.class);
        startActivity(intent);
    }
}

