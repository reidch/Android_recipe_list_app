package com.example.carolinereid.taste_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddRecipeActivity extends AppCompatActivity {

    EditText editName;
    EditText editUrl;
    EditText editNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        editName = (EditText)findViewById(R.id.name);
        editUrl = (EditText)findViewById(R.id.url);
        editNotes = (EditText)findViewById(R.id.notes);
    }

    public void addRecipe(View button){
        DBHelper dbHelper = new DBHelper(this);
        String name = editName.getText().toString();
        String url = editUrl.getText().toString();
        String notes = editNotes.getText().toString();
        dbHelper.save(name, url, notes, false);
        Intent intent = new Intent(this, MyRecipesActivity.class);
        startActivity(intent);
    }


}
