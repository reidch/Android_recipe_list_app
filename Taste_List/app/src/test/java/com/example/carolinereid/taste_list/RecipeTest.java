package com.example.carolinereid.taste_list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by carolinereid on 11/11/2017.
 */

public class RecipeTest {

    Recipe recipe;
    Recipe recipe2;

    @Before
    public void before() {
        recipe = new Recipe(1, "Curried cauliflower rice", "https://stupideasypaleo.com/2017/06/30/curried-cauliflower-rice-recipe/", true, "great with dhal");
        recipe2 = new Recipe(2, "shakshuka", "https://smittenkitchen.com/2010/04/shakshuka/", true, "great with dhal");
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

    @Test
    public void testTriedStatus(){
        assertTrue(recipe.getTriedStatus());
    }

    @Test
    public void testHasNotes(){
        assertEquals("great with dhal", recipe.getNotes());
    }

    @Test
    public void testUntriedStatus(){
        Recipe recipe2 = new Recipe();
        assertFalse(recipe.getTriedStatus());
    }
}
