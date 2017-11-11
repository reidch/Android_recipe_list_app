package com.example.carolinereid.taste_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MyRecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_list);
        DBHelper dbHelper = new DBHelper(this);
        ArrayList<Recipe> recipeList = dbHelper.all();

        MyRecipesAdapter recipeAdapter = new MyRecipesAdapter(this, recipeList);
        ListView listView = (ListView)findViewById(R.id.recipe_list);
        listView.setAdapter(recipeAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.add_recipe){
            Intent intent = new Intent(this, AddRecipeActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getRecipe(View listItem){
        Recipe recipe = (Recipe) listItem.getTag();
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("name", recipe.getName());
        i.putExtra("url", recipe.getUrl());
        i.putExtra("triedStatus", recipe.getTriedStatus());
        i.putExtra("notes", recipe.getNotes());
        i.putExtra("id", recipe.getId());
        startActivity(i);
    }
}
