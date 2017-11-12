package com.example.carolinereid.taste_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void addRecipe(View button) {
        Intent intent = new Intent(this, AddRecipeActivity.class);
        startActivity(intent);
    }

    public void viewRecipes(View button) {
        Intent intent = new Intent(this, MyRecipesActivity.class);
        startActivity(intent);
    }

//    public void randomRecipe(View button) {
//        Intent intent = new Intent();
//        startActivity(intent);
//    }

//    plus randomRecipe function

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
        if(item.getItemId() == R.id.recipes_list){
            Intent intent = new Intent(this, MyRecipesActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
