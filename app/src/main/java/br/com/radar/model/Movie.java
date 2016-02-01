package br.com.radar.model;

public class Movie {

    private String title;
    private String genre;
    private String year;
    private String picture;

    public Movie() {
    }

    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public Movie(String title, String genre, String year, String picture) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
