package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Ivy", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_id() {
        assertEquals("ikeacat2", Developer.getGithubId());
    }
    
    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s26-16", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Ivy"), "Team should contain Ivy");
        assertTrue(t.getMembers().contains("Jack"), "Team should contain Jack");
        assertTrue(t.getMembers().contains("John"), "Team should contain John");
        assertTrue(t.getMembers().contains("Nikita"), "Team should contain Nikita");
        assertTrue(t.getMembers().contains("Rohil"), "Team should contain Rohil");
        assertTrue(t.getMembers().contains("Shranya"), "Team should contain Shranya");
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
