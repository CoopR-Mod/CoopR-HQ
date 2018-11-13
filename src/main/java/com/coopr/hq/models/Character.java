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
@Data
@NoArgsConstructor
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

}
