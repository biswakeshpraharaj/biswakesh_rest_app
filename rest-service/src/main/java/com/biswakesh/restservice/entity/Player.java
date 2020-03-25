package com.biswakesh.restservice.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="players")
@NamedQueries({
        @NamedQuery(name = "Player.findAllPlayers",query = "SELECT p FROM Player p ORDER BY p.playerID DESC")
})
public class Player implements Serializable {
    @Id
    @Column(name = "playerid")
    private String playerID;

    @Column(name = "birthyear")
    private String birthYear;

    @Column(name="birthmonth")
    private String birthMonth;

    @Column(name="birthday")
    private String birthDay;

    @Column(name="birthcountry")
    private String birthCountry;

    @Column(name="birthstate")
    private String birthState;

    @Column(name="birthcity")
    private String birthCity;

    @Column(name = "deathyear")
    private String deathYear;

    @Column(name="deathmonth")
    private String deathMonth;

    @Column(name="deathday")
    private String deathDay;

    @Column(name="deathcountry")
    private String deathCountry;

    @Column(name="deathstate")
    private String deathState;

    @Column(name="deathcity")
    private String deathCity;

    @Column(name="namefirst")
    private String nameFirst;

    @Column(name="namelast")
    private String nameLast;

    @Column(name="namegiven")
    private String nameGiven;

    @Column(name="weight")
    private Float weight;

    @Column(name="height")
    private Float height;

    //0 for right and 1 for left
    @Column(name="bats")
    private String bats;

    //0 for right and 1 for left
    @Column(name="throws")
    private String playerThrows;

    //TODO Use Temporal.DATE
    @Column(name="debut")
    private String debut;

    //TODO Use Temporal.DATE
    @Column(name="finalgame")
    private String finalGame;

    @Column(name="retroid")
    private String retroID;

    @Column(name="bbrefid")
    private String bbrefID;

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }

    public String getDeathMonth() {
        return deathMonth;
    }

    public void setDeathMonth(String deathMonth) {
        this.deathMonth = deathMonth;
    }

    public String getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(String deathDay) {
        this.deathDay = deathDay;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }

    public String getDeathState() {
        return deathState;
    }

    public void setDeathState(String deathState) {
        this.deathState = deathState;
    }

    public String getDeathCity() {
        return deathCity;
    }

    public void setDeathCity(String deathCity) {
        this.deathCity = deathCity;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getBats() {
        return bats;
    }

    public void setBats(String bats) {
        this.bats = bats;
    }

    public String getPlayerThrows() {
        return playerThrows;
    }

    public void setPlayerThrows(String playerThrows) {
        this.playerThrows = playerThrows;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFinalGame() {
        return finalGame;
    }

    public void setFinalGame(String finalGame) {
        this.finalGame = finalGame;
    }

    public String getRetroID() {
        return retroID;
    }

    public void setRetroID(String retroID) {
        this.retroID = retroID;
    }

    public String getBbrefID() {
        return bbrefID;
    }

    public void setBbrefID(String bbrefID) {
        this.bbrefID = bbrefID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getBirthYear() == player.getBirthYear() &&
                getBirthMonth() == player.getBirthMonth() &&
                getBirthDay() == player.getBirthDay() &&
                getDeathYear() == player.getDeathYear() &&
                getDeathMonth() == player.getDeathMonth() &&
                getDeathDay() == player.getDeathDay() &&
                getBats() == player.getBats() &&
                getPlayerThrows() == player.getPlayerThrows() &&
                Objects.equals(getPlayerID(), player.getPlayerID()) &&
                Objects.equals(getBirthCountry(), player.getBirthCountry()) &&
                Objects.equals(getBirthState(), player.getBirthState()) &&
                Objects.equals(getBirthCity(), player.getBirthCity()) &&
                Objects.equals(getDeathCountry(), player.getDeathCountry()) &&
                Objects.equals(getDeathState(), player.getDeathState()) &&
                Objects.equals(getDeathCity(), player.getDeathCity()) &&
                Objects.equals(getNameFirst(), player.getNameFirst()) &&
                Objects.equals(getNameLast(), player.getNameLast()) &&
                Objects.equals(getNameGiven(), player.getNameGiven()) &&
                Objects.equals(getWeight(), player.getWeight()) &&
                Objects.equals(getHeight(), player.getHeight()) &&
                Objects.equals(getDebut(), player.getDebut()) &&
                Objects.equals(getFinalGame(), player.getFinalGame()) &&
                Objects.equals(getRetroID(), player.getRetroID()) &&
                Objects.equals(getBbrefID(), player.getBbrefID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayerID(), getBirthYear(), getBirthMonth(), getBirthDay(), getBirthCountry(), getBirthState(), getBirthCity(), getDeathYear(), getDeathMonth(), getDeathDay(), getDeathCountry(), getDeathState(), getDeathCity(), getNameFirst(), getNameLast(), getNameGiven(), getWeight(), getHeight(), getBats(), getPlayerThrows(), getDebut(), getFinalGame(), getRetroID(), getBbrefID());
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerID='" + playerID + '\'' +
                ", birthYear=" + birthYear +
                ", birthMonth=" + birthMonth +
                ", birthDay=" + birthDay +
                ", birthCountry='" + birthCountry + '\'' +
                ", birthState='" + birthState + '\'' +
                ", birthCity='" + birthCity + '\'' +
                ", deathYear=" + deathYear +
                ", deathMonth=" + deathMonth +
                ", deathDay=" + deathDay +
                ", deathCountry='" + deathCountry + '\'' +
                ", deathState='" + deathState + '\'' +
                ", deathCity='" + deathCity + '\'' +
                ", nameFirst='" + nameFirst + '\'' +
                ", nameLast='" + nameLast + '\'' +
                ", nameGiven='" + nameGiven + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", bats=" + bats +
                ", playerThrows=" + playerThrows +
                ", debut=" + debut +
                ", finalGame=" + finalGame +
                ", retroID='" + retroID + '\'' +
                ", bbrefID='" + bbrefID + '\'' +
                '}';
    }
}
