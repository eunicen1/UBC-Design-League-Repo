package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

// Spring boot Entity, initializes table and columns when create table is true
@Entity
@Table(name = "Search")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true, ignoreUnknown = true)
public class Search {

    @javax.persistence.Id
    @GeneratedValue
    private UUID uuid;

    @JsonProperty(value = "keyword")
    private String keyword;

    @JsonProperty(value = "category")
    private String category;

    @JsonProperty(value = "popularity")
    private float popularity;

    @JsonProperty(value = "link")
    private String link;


    @JsonProperty(value = "instruction")
    @Column(columnDefinition = "LONGTEXT")
    private String instruction;

    @JsonProperty(value = "")
    private String image;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
