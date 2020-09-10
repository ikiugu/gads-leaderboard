package com.ikiugu.leaderboard.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "learningLeaders")
public class LearningLeader {
    @PrimaryKey
    private Integer id;

    private String name;

    private Integer hours;

    private String country;

    private String badgeUrl;

    public LearningLeader() {
    }

    public LearningLeader(Integer id, String name, Integer hours, String country, String badgeUrl) {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    @Override
    public String toString() {
        return "LearningLeader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hours=" + hours +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }
}
