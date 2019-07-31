package com.pirateway.scrapper.frontend.primefaces.model.entity;

import org.jetbrains.annotations.Nullable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "app_fork")
public class Fork extends AbstractEntity {

    public Fork(
            @Nullable final String name,
            @Nullable final String description,
            @Nullable final String type,
            @Nullable final String age
    ) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.age = age;
    }

    @Nullable
    @OneToMany(mappedBy = "fork", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bet> bets;

    @Nullable
    private String type;

    @Nullable
    public String getType() {
        return type;
    }

    public void setType(@Nullable String type) {
        this.type = type;
    }

    @Nullable
    private String age;

    @Nullable
    public List<Bet> getBets() {
        return bets;
    }

    public Fork() {
    }

    @Override
    public String toString() {
        return "Fork{" +
                "bets=" + bets +
                ", type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void setBets(@Nullable final List<Bet> bets) {
        this.bets = bets;
    }

    @Nullable
    public String getAge() {
        return age;
    }

    public void setAge(@Nullable final String age) {
        this.age = age;
    }
}
