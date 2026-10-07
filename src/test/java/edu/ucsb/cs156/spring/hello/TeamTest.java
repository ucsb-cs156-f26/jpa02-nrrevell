package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
    public void equals_returns_correct_bool() {
        Team t1 = new Team("Team 1");
        Team t2 = t1;
        Team t3 = new Team("Team 1");
        t3.setMembers(new ArrayList<>(List.of("Apple", "Banana", "Cherry")));
        String string1 = new String();
        assertEquals(true, t1.equals(t1)); //same object
        assertEquals(false, t1.equals(string1)); // different class
        assertEquals(true, t1.equals(t2)); // different object that is equivalent
        assertEquals(false, t1.equals(team)); // different object that is fully different
        assertEquals(false, t1.equals(t3)); // different object that is slightly different

    }
   @Test 
   public void hash_returns_correct() {
    Team t = new Team();
    int result = t.hashCode();
    int expectedResult = 1;
    assertEquals(expectedResult, result);
   }

}
