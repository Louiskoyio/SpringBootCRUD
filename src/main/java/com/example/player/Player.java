package com.example.player;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private int nationalId;

    private String fname;
    private String lname;

    @JoinColumn(name = "teamId", referencedColumnName = "id")
    private int teamId;

    @Column(unique = true)
    private String phoneNumber;
    private String password;


    public Player() {
    }

    public Player(int nationalId, String fname, String lname, int teamId, String phoneNumber) {
        this.nationalId = nationalId;
        this.fname = fname;
        this.lname = lname;
        this.teamId = teamId;
        this.phoneNumber = phoneNumber;
    }


    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && teamId == player.teamId && Objects.equals(fname, player.fname) && Objects.equals(lname, player.lname) && Objects.equals(phoneNumber, player.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fname, lname, teamId, phoneNumber);
    }
}
