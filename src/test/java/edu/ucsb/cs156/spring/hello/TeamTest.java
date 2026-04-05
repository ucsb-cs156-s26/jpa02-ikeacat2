package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void check_equals() {
        //check equal to itself
        assertTrue(team.equals(team));
        //check equal to a copy
        Team other = new Team("test-team");
        assertTrue(team.equals(other));
        assertTrue(other.equals(team));
        //check that not equals works (both ways)
        Team different = new Team("different");
        assertFalse(team.equals(different));
        assertFalse(different.equals(team));
        //check null
        assertFalse(team.equals(null));
        //check different type
        assertFalse(team.equals("bad_type"));
        
    }
    @Test
    public void different_members_returns_false() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("test-team");
        assertTrue(team1.equals(team2));
        team2.addMember("Alice");
        assertFalse(team1.equals(team2));
        assertFalse(team2.equals(team1));
    }

    @Test 
    public void same_objects_have_same_hashcode() {
        Team t1 = new Team("test-team");
        t1.addMember("Alice");
        Team t2 = new Team("test-team");
        t2.addMember("Alice");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    @Test
    public void hashCode_equals_hashresult() {
        int result = team.hashCode();
        int expected = -1226298695;
        assertEquals(result, expected);
    }
    //can't check if different teams have different hashfunctions because they are being hashed so they could technically still be equal

}
