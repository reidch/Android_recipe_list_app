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
        recipe = new Recipe(1, "Curried cauliflower rice", "https://stupideasypaleo.com/2017/06/30/curried-cauliflower-rice-recipe/", "great with dhal", true);
        recipe2 = new Recipe(2, "shakshuka", "https://smittenkitchen.com/2010/04/shakshuka/", "recommended by Sue", false);
    }

    @Test
    public void testHasName(){
        assertEquals("Curried cauliflower rice", recipe.getName());
    }

    @Test
    public void testCanEditName(){
        recipe.setName("Cauliflower couscous");
        assertEquals("Cauliflower couscous", recipe.getName());
    }

    @Test
    public void testHasUrl(){
        assertEquals("https://stupideasypaleo.com/2017/06/30/curried-cauliflower-rice-recipe/", recipe.getUrl());
    }

    @Test
    public void testCanChangeUrl() {
        recipe.setUrl("https://smittenkitchen.com/2009/07/cantaloupe-salsa/");
        assertEquals("https://smittenkitchen.com/2009/07/cantaloupe-salsa/", recipe.getUrl());
    }

    @Test
    public void testHasNotes(){
        assertEquals("great with dhal", recipe.getNotes());
    }

    @Test
    public void testCanEditNotes(){
        recipe.setNotes("omit sultanas");
        assertEquals("omit sultanas", recipe.getNotes());
    }

    @Test
    public void testTriedStatus(){
        assertTrue(recipe.getTriedStatus());
    }

    @Test
    public void testUntriedStatus(){
        assertFalse(recipe2.getTriedStatus());
    }

    @Test
    public void testCanEditStatus(){
        recipe2.setTriedStatus(true);
        assertEquals(true, recipe2.getTriedStatus());
    }
}
