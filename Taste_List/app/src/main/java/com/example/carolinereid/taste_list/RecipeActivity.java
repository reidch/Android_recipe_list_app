package com.example.carolinereid.taste_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    TextView nameTV;
    TextView urlTV;
//    CheckBox triedCB;
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
//        triedCB = (CheckBox) findViewById(R.id.triedStatus);
        notesTV = (TextView) findViewById(R.id.notes);

//        if (checkBox.isChecked()) {
//            checkBox.setChecked(false);
//        }

        nameTV.setText(name);
        urlTV.setText(url);
        notesTV.setText(notes);
    }

//    public void onCheckboxClicked(View checkbox) {
//        boolean checked = ((CheckBox) view).isChecked();
//
//
//    }

    public void deleteRecipe(View button){
        Integer id = extras.getInt("id");
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.delete(id);
        Intent intent = new Intent(this, MyRecipesActivity.class);
        startActivity(intent);
    }
}
