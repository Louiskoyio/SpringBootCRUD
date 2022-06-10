package com.example.goal;

import javax.persistence.*;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int goalscorer;
    private int assist;
    private int team;
    private int opponent;
    private int matchId;

    public Goal(int goalscorer, int assist, int team, int opponent, int matchId) {
        this.goalscorer = goalscorer;
        this.assist = assist;
        this.team = team;
        this.opponent = opponent;
        this.matchId = matchId;
    }

    public Goal() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoalscorer() {
        return goalscorer;
    }

    public void setGoalscorer(int goalscorer) {
        this.goalscorer = goalscorer;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getOpponent() {
        return opponent;
    }

    public void setOpponent(int opponent) {
        this.opponent = opponent;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }


}
