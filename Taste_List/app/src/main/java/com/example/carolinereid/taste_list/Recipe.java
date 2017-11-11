package com.example.carolinereid.taste_list;

/**
 * Created by carolinereid on 11/11/2017.
 */

public class Recipe {

    private Integer id;
    private String name;
    private String url;
//    private String status;
    private String notes;

    public Recipe(Integer id, String name, String url, String status, String notes) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.status = status;
        this.notes = notes;
    }

    public Recipe(String name, String url, String status, String notes) {
        this.name = name;
        this.url = url;
        this.status = status;
        this.notes = notes;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public String getStatus() {
//        return this.status;
//    }

//    don't think need setter for status
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean statusTried(){
        true ("would make again", "still to try") {
            return "would make again"
        }
        false ("would make again", "still to try") {
            return "still to try"
        }
    }
}
