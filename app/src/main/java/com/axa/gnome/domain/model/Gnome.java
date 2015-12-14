package com.axa.gnome.domain.model;


import java.util.ArrayList;
import java.util.List;

public class Gnome {

    private Long id;
    private String name;
    private String thumbnail;
    private int age;
    private float weight;
    private float height;
    private String hairColor;
    private List<String> professions = new ArrayList<String>();
    private List<String> friends = new ArrayList<String>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public List<String> getProfessions() {
        return professions;
    }

    public void setProfessions(List<String> professions) {
        this.professions = professions;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gnome gnome = (Gnome) o;

        if (age != gnome.age) return false;
        if (Float.compare(gnome.weight, weight) != 0) return false;
        if (Float.compare(gnome.height, height) != 0) return false;
        if (!id.equals(gnome.id)) return false;
        if (!name.equals(gnome.name)) return false;
        if (!thumbnail.equals(gnome.thumbnail)) return false;
        if (!hairColor.equals(gnome.hairColor)) return false;
        if (!professions.equals(gnome.professions)) return false;
        return friends.equals(gnome.friends);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + thumbnail.hashCode();
        result = 31 * result + age;
        result = 31 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        result = 31 * result + (height != +0.0f ? Float.floatToIntBits(height) : 0);
        result = 31 * result + hairColor.hashCode();
        result = 31 * result + professions.hashCode();
        result = 31 * result + friends.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Gnome{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", hairColor='" + hairColor + '\'' +
                ", professions=" + professions +
                ", friends=" + friends +
                '}';
    }
}
