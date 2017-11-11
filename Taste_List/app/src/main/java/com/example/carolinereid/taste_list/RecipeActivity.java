package com.example.carolinereid.taste_list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    TextView nameTV;
    TextView urlTV;
//    triedStatus
    TextView notesTV;
    Bundle extras;
//    ImageView imageIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        extras = getIntent().getExtras();

        String name = extras.getString("name");
        String url = extras.getString("url");
        String notes = extras.getString("notes");

        nameTV = (TextView) findViewById(R.id.name);
        urlTV = (TextView) findViewById(R.id.url);
        notesTV = (TextView) findViewById(R.id.notes);

        nameTV.setText(name);
        urlTV.setText(url);
        notesTV.setText(notes);
    }

    public void deleteRecipe(View button){
        Integer id = extras.getInt("id");
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.delete(id);
        Intent intent = new Intent(this, MyRecipesActivity.class);
        startActivity(intent);
    }
}
