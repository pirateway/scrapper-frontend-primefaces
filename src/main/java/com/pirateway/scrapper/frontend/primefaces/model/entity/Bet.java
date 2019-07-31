package com.pirateway.scrapper.frontend.primefaces.model.entity;

import org.jetbrains.annotations.Nullable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "app_bet")
public class Bet extends AbstractEntity {

    @Nullable
    Date date;

    @Nullable
    String bookmaker;

    @Nullable
    String event;

    @Nullable
    String link;

    @Nullable
    String coefficient;

    @Nullable
    String forkCount;



    @Nullable
    String move;


    public Bet() {
    }

    public Bet(
            @Nullable final String name,
            @Nullable final String description,
            @Nullable final Date date,
            @Nullable final String bookmaker,
            @Nullable final String event,
            @Nullable final String link,
            @Nullable final String coefficient,
            @Nullable final String move,
            @Nullable final String forkCount,
            @Nullable final Fork fork) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.bookmaker = bookmaker;
        this.event = event;
        this.link = link;
        this.coefficient = coefficient;
        this.move = move;
        this.forkCount = forkCount;
        this.fork = fork;
    }

    @Nullable
    @ManyToOne
    @JoinColumn(name = "fork_id")
    private Fork fork;

    @Nullable
    public Date getDate() {
        return date;
    }

    public void setDate(@Nullable final Date date) {
        this.date = date;
    }

    @Nullable
    public String getBookmaker() {
        return bookmaker;
    }

    public void setBookmaker(@Nullable final String bookmaker) {
        this.bookmaker = bookmaker;
    }

    @Nullable
    public String getEvent() {
        return event;
    }

    public void setEvent(@Nullable final String event) {
        this.event = event;
    }

    @Nullable
    public String getLink() {
        return link;
    }

    public void setLink(@Nullable final String link) {
        this.link = link;
    }

    @Nullable
    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(@Nullable final String coefficient) {
        this.coefficient = coefficient;
    }

    @Nullable
    public String getMove() {
        return move;
    }

    public void setMove(@Nullable final String move) {
        this.move = move;
    }

    @Nullable
    public Fork getFork() {
        return fork;
    }

    public void setFork(@Nullable final Fork fork) {
        this.fork = fork;
    }

    @Nullable
    public String getForkCount() {
        return forkCount;
    }

    public void setForkCount(@Nullable String forkCount) {
        this.forkCount = forkCount;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "date=" + date +
                ", bookmaker='" + bookmaker + '\'' +
                ", event='" + event + '\'' +
                ", link='" + link + '\'' +
                ", coefficient='" + coefficient + '\'' +
                ", forkCount='" + forkCount + '\'' +
                ", move='" + move + '\'' +
                ", fork=" + fork +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}