package com.example.carolinereid.taste_list;

import java.util.ArrayList;

/**
 * Created by carolinereid on 11/11/2017.
 */

public class MyRecipes {

    private ArrayList<Recipe> list;

    public MyRecipes() {
        list = new ArrayList<Recipe>();
        list.add(new Recipe(1, "Curried cauliflower rice", "https://stupideasypaleo.com/2017/06/30/curried-cauliflower-rice-recipe/", "would make again", "great with dhal"));
    }

    public ArrayList<Recipe> getList() {
        return new ArrayList<Recipe>(list);
    }
}
