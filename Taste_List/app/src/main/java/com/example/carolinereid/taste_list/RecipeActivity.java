package com.example.carolinereid.taste_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    TextView nameTV;
    TextView urlTV;
    Switch switchStatus;
    Bundle extras;
    String name;
    String url;
    String notes;
    Boolean triedStatus;
    Integer id;
    EditText editNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        extras = getIntent().getExtras();

        name = extras.getString("name");
        url = extras.getString("url");
        notes = extras.getString("notes");
        triedStatus = extras.getBoolean("triedStatus");
        id = extras.getInt("id");

        nameTV = (TextView) findViewById(R.id.name);
        urlTV = (TextView) findViewById(R.id.url);
        editNotes = (EditText) findViewById(R.id.editNotes);
        switchStatus = (Switch) findViewById(R.id.triedStatus);
        switchStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DBHelper dbHelper = new DBHelper(RecipeActivity.this);
                String name = nameTV.getText().toString();
                String url = urlTV.getText().toString();
                triedStatus = switchStatus.isChecked();
                dbHelper.update(id, name, url, notes, isChecked);
            }
        });

        nameTV.setText(name);
        urlTV.setText(url);
        editNotes.setText(notes);
        switchStatus.setChecked(triedStatus);
    }

    public void updateNotes(View button){
        DBHelper dbHelper = new DBHelper(this);
        String notes = editNotes.getText().toString();
        dbHelper.updateNotes(id, notes);

//        Toast.makeText(RecipeActivity.this, R.string.menu_toast_updated, Toast.LENGTH_LONG).show();
    }

    public void deleteRecipe(View button){
        Integer id = extras.getInt("id");
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.delete(id);
        Intent intent = new Intent(this, MyRecipesActivity.class);
        startActivity(intent);
    }
}

