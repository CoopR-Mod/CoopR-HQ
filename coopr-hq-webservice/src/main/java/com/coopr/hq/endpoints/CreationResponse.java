package com.coopr.hq.endpoints;

import lombok.AllArgsConstructor;
import lombok.Data;

/***************************************
 * Author: xetra11                     
 * Datum: 5/2/2019                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/
@Data
@AllArgsConstructor
public class CreationResponse {
    private boolean created;
    private String reason;
}
