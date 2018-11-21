package com.coopr.hq.core.models;

/***************************************
 * Author: xetra11                     
 * Datum: 21.11.2018                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/
public enum AceRole {
  ACE_MEDIC("ace3_role_medic"),
  ACE_ENGINEER("ace3_role_engineer");

  private final String roleText;

  AceRole(final String roleText) {
    this.roleText = roleText;
  }

  public String toString() {
    return roleText;
  }
}
