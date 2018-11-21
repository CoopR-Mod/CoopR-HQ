package com.coopr.hq.client

import com.coopr.hq.core.models.AceRole
import com.coopr.hq.core.models.Character
import com.coopr.hq.core.models.CharacterRole
import com.coopr.hq.core.models.CharacterState
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.client.MockRestServiceServer
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess

/***************************************
 * Author: xetra11                     
 * Datum: 20.11.2018                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/

@TestPropertySource("classpath:application-test.properties")
@RestClientTest(components = [HQConnection.class, ClientApplication.class])
class HQConnectionSpec extends Specification {

    @Autowired
    private HQConnection uut
    @Autowired
    private MockRestServiceServer mockServer

    @Autowired
    private ObjectMapper objectMapper;

    @Unroll
    def "should build url out of application host and given version"(Version version, String testId, Character character) {

        given:
        String responseObject = objectMapper.writeValueAsString(character)
        mockServer.expect(requestTo("/test.coopr-hq.com/api/$version/character/fetch/$testId"))
                .andRespond(withSuccess(responseObject, MediaType.APPLICATION_JSON))
        uut.setVersion(version);

        expect:
        Character actual = uut.getCharacter(testId).get()
        actual.getUid() == testId;
        actual.getName().contains(version.toString())

        where:
        version        | testId | character
        Version.V0_1   | "123"  | getTestCharacter123()
        Version.V0_2   | "345"  | getTestCharacter345()
        Version.LATEST | "678"  | getTestCharacter678()
    }

    def getTestCharacter123() {
        new Character("123", 1, "Peter of v0.1", CharacterRole.MEDIC, CharacterState.OK,
                "[1423423,234234,2342342]", 42423.3, "[loadoutTest]",
                32, 1, AceRole.ACE_MEDIC)
    }

    def getTestCharacter345() {
        new Character("345", 1, "Sabine of v0.2", CharacterRole.MEDIC, CharacterState.OK,
                "[1423423,234234,2342342]", 42423.3, "[loadoutTest]",
                32, 1, AceRole.ACE_MEDIC)
    }

    def getTestCharacter678() {
        new Character("678", 1, "Anna of v0.1 (latest)", CharacterRole.MEDIC, CharacterState.OK,
                "[1423423,234234,2342342]", 42423.3, "[loadoutTest]",
                32, 1, AceRole.ACE_MEDIC)
    }
}






