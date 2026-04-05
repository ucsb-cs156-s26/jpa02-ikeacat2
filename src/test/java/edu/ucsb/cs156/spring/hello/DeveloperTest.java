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
        assertEquals("Ivy Marie", Developer.getName());
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
        assertTrue(t.getMembers().contains("SHARANYA"), "Team should contain Shranya");
        assertTrue(t.getMembers().contains("ROHIL"), "Team should contain Rohil");
        assertTrue(t.getMembers().contains("NIKITA ANH"), "Team should contain Nikita");
        assertTrue(t.getMembers().contains("JACK T"), "Team should contain Jack T");
        assertTrue(t.getMembers().contains("IVY MARIE"), "Team should contain Ivy Marie");
        assertTrue(t.getMembers().contains("JOHN DEREK"), "Team should contain John Derek");
    }

}
