package com.coopr.hq.client;

import com.coopr.hq.core.models.Character;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.util.Optional;

/***************************************
 * Author: xetra11                     
 * Datum: 19.11.2018                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/

@Log4j2
@Component
@EnableConfigurationProperties
public class HQConnection {
  private final String VERSION = "version";
  private final String API = "/api/";
  private final String CHARACTER = "/character/";
  private final String CHARACTERS = "/characters/";
  private final String FETCH = "/fetch";
  private final String SAVE = "/save";

  @Value("${hq.host}")
  private String host;
  @Setter
  private Version version;

  private final RestTemplate restTemplate;

  public HQConnection(RestTemplateBuilder restTemplateBuilder) {
    restTemplate = restTemplateBuilder.build();
  }

  public Optional<Character> getCharacter(String id) {
    if (this.version == null) {
      log.error("No version has been set for this connection. Aborting API call.");
      return Optional.empty();
    }

    try {
      String apiUrl = apiBaseUrl() + CHARACTER + FETCH + "/" + id;
      return Optional.ofNullable(restTemplate.getForObject(apiUrl, Character.class));
    } catch (RestClientException e) {
      log.error("Could no retrieve character by id {}", id);
      log.error(e.getMessage());
      return Optional.empty();
    }
  }

  private String apiBaseUrl() {
    StringBuilder builder = new StringBuilder(host);

    builder.append(API);
    builder.append("{" + VERSION + "}");

    String uri = builder.toString();

    UriTemplate uriTemplate = new UriTemplate(uri);
    return uriTemplate.expand(version).toString();
  }
}
