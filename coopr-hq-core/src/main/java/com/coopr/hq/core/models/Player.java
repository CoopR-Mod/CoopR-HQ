package com.coopr.hq.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
@Document(collection = "coopr_hq_players")
public class Player {
  // Meta
  @Id
  private String uid;
  private String username;
  private String password;
  private List<String> characters;
}
