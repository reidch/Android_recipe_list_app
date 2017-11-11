package com.example.carolinereid.taste_list;

/**
 * Created by carolinereid on 11/11/2017.
 */

public class Recipe {

    private Integer id;
    private String name;
    private String url;
    private Boolean triedStatus;
    private String notes;

    public Recipe(String name, String url, Boolean triedStatus, String notes) {
        this.name = name;
        this.url = url;
        this.triedStatus = triedStatus;
        this.notes = notes;
    }

    public Recipe(Integer id, String name, String url, Boolean triedStatus, String notes) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.triedStatus = triedStatus;
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

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getTriedStatus() {
        return this.triedStatus;
    }

    public void setTriedStatus(Boolean triedStatus) {
        this.triedStatus = triedStatus;
    }
//    public boolean statusTried() {
//        true ("would make again", "still to try"){
//            return "would make again"
//        }
//        false ("would make again", "still to try"){
//            return "still to try"
//        }
//    }

}
