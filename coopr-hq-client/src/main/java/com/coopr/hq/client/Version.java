package com.coopr.hq.client;

/***************************************
 * Author: xetra11                     
 * Datum: 19.11.2018                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/
public enum Version {
  LATEST("v0.1"),
  V0_1("v0.1"),
  V0_2("v0.2");

  private final String version;

  Version(final String version) {
    this.version = version;
  }

  public String toString(){
    return version;
  }

}
