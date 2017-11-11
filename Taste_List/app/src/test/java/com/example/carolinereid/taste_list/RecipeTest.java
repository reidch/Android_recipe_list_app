package com.example.carolinereid.taste_list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by carolinereid on 11/11/2017.
 */

public class RecipeTest {

    Recipe recipe;

    @Before
    public void before() {
        recipe = new Recipe(1, "Curried cauliflower rice", "https://stupideasypaleo.com/2017/06/30/curried-cauliflower-rice-recipe/", "would make again", "great with dhal");
    }

    @Test
    public void testHasName(){
        assertEquals("Curried cauliflower rice", recipe.getName());
    }

//    @Test
//    public void testCanSetName(){
//
//    }

    @Test
    public void testHasUrl(){
        assertEquals("https://stupideasypaleo.com/2017/06/30/curried-cauliflower-rice-recipe/", recipe.getUrl());
    }

//    @Test
//    public void testHasStatus(){
//        assertEquals("would make again", recipe.getStatus());
//    }

    @Test
    public void testHasNotes(){
        assertEquals("great with dhal", recipe.getNotes());
    }
}
