package com.coopr.hq.core.models;

/***************************************
 * Author: xetra11                     
 * Datum: 21.11.2018                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/
public enum CharacterState {
  OK("coopr_state_ok"),
  HOSTAGE("coopr_state_hostage"),
  WOUNDED_IN_ACTION("coopr_state_wia"),
  KILLED_IN_ACTION("coopr_state_kia");

  private final String state;

  CharacterState(final String state) {
    this.state = state;
  }

  public String toString() {
    return state;
  }
}
