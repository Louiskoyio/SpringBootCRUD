package com.example.fixture;

import javax.persistence.*;


@Entity
@Table(name = "fixtures")
public class Fixture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int team1;
    private int team2;
    private int venue;
    private boolean played;
    private int team1Goals;
    private int team2Goals;
    private int editionNumber;

    public Fixture() {
    }

    public Fixture(int team1, int team2, int venue, boolean played, int team1Goals, int team2Goals, int editionNumber) {
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
        this.played = played;
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
        this.editionNumber = editionNumber;
    }

    public int getFixtureId() {
        return id;
    }

    public void setFixtureId(int fixtureId) {
        this.id = fixtureId;
    }

    public int getTeam1() {
        return team1;
    }

    public void setTeam1(int team1) {
        this.team1 = team1;
    }

    public int getTeam2() {
        return team2;
    }

    public void setTeam2(int team2) {
        this.team2 = team2;
    }

    public int getVenue() {
        return venue;
    }

    public void setVenue(int venue) {
        this.venue = venue;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public int getTeam1Goals() {
        return team1Goals;
    }

    public void setTeam1Goals(int team1Goals) {
        this.team1Goals = team1Goals;
    }

    public int getTeam2Goals() {
        return team2Goals;
    }

    public void setTeam2Goals(int team2Goals) {
        this.team2Goals = team2Goals;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }
}
