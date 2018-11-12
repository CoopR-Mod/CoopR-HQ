package com.coopr.hq.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/***************************************
 * Author: xetra11                     
 * Datum: 12.11.2018                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/
@AllArgsConstructor
@Document(collection = "coopr_hq_characters")
public class Character {
  // Meta
  @Id
  private String uid;
  private int slot;
  private String name;
  private String role;
  // State
  private String state;
  private String position;
  private double timestampWIA;
  // Equipment
  private String loadout;
  // Scores
  private int reputation;
  private int legacy;

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public int getSlot() {
    return slot;
  }

  public void setSlot(int slot) {
    this.slot = slot;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public double getTimestampWIA() {
    return timestampWIA;
  }

  public void setTimestampWIA(double timestampWIA) {
    this.timestampWIA = timestampWIA;
  }

  public String getLoadout() {
    return loadout;
  }

  public void setLoadout(String loadout) {
    this.loadout = loadout;
  }

  public int getReputation() {
    return reputation;
  }

  public void setReputation(int reputation) {
    this.reputation = reputation;
  }

  public int getLegacy() {
    return legacy;
  }

  public void setLegacy(int legacy) {
    this.legacy = legacy;
  }

}
