package com.example.team;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teamName;
    private int teamCaptain;

  /*  @OneToMany(targetEntity = Player.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "team_player_fk", referencedColumnName = "id")*/


    public Team() {
    }

    public Team(int id, String teamName, int teamCaptain) {
        this.id = id;
        this.teamName = teamName;
        this.teamCaptain = teamCaptain;
    }

    public Integer getId() {
        return id;
    }

    public Team setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public Team setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public int getTeamCaptain() {
        return teamCaptain;
    }

    public Team setTeamCaptain(int teamCaptain) {
        this.teamCaptain = teamCaptain;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id && teamCaptain == team.teamCaptain && Objects.equals(teamName, team.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName, teamCaptain);
    }
}
