package com.example.carolinereid.taste_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
//        dbHelper.save("Oatmeal Pumpkin Pancakes", "https://myheartbeets.com/gluten-free-oatmeal-pumpkin-pancakes/", "recommended by Sue", false);
//        dbHelper.save("Asian Chicken Cabbage Salad", "https://iheartumami.com/paleo-asian-chicken-cabbage-salad/", "great for lunches", true);
//        dbHelper.save("Shakshuka", "https://thedomesticman.com/2017/09/26/shakshuka/", "delicious!", true);
//        dbHelper.save("Curried Cauliflower Rice", "https://stupideasypaleo.com/2017/06/30/curried-cauliflower-rice-recipe/", "great with dhal", true);

        MyRecipesAdapter recipeAdapter = new MyRecipesAdapter(this, recipeList);
        ListView listView = (ListView)findViewById(R.id.recipe_list);
        listView.setAdapter(recipeAdapter);
    }

    public void getRecipe(View listItem){
        Recipe recipe = (Recipe) listItem.getTag();
        Intent i = new Intent(this, RecipeActivity.class);
        i.putExtra("name", recipe.getName());
        i.putExtra("url", recipe.getUrl());
        i.putExtra("notes", recipe.getNotes());
        i.putExtra("triedStatus", recipe.getTriedStatus());
        i.putExtra("id", recipe.getId());
        startActivity(i);
    }
}
