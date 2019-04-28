package com.coopr.hq.security;

import lombok.AllArgsConstructor;
import lombok.Data;

/***************************************
 * Author: xetra11                     
 * Datum: 4/28/2019                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/
@Data
@AllArgsConstructor
public class AuthResponse {
  private boolean authenticated;
  private String reason;
}

