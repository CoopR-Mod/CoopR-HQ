package com.coopr.hq.core.models;

/***************************************
 * Author: xetra11                     
 * Datum: 21.11.2018                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/
public enum CharacterRole {
  LEADER("coopr_role_leader"),
  MEDIC("coopr_role_medic"),
  ENGINEER("coopr_role_engineer"),
  DMR("coopr_role_dmr"),
  MACHINEGUNNER("coopr_role_mg");

  private final String role;

  CharacterRole(final String role) {
    this.role = role;
  }

  public String toString() {
    return role;
  }
}
