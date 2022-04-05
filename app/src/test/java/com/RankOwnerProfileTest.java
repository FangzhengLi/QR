package com;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.example.qrhunter.RankOwnerProfileList;
import com.example.qrhunter.User;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RankOwnerProfileTest {



    @Test
    public void testSortTotal(){
        RankOwnerProfileList list = new RankOwnerProfileList();
        User user1 = new User("A1", 26);
        User user2 = new User("A2", 57);
        User user3 = new User("A3", 68);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        assertEquals("A3", list.sort().get(0).getUserName());
    }


    @Test
    public void testFind(){
        RankOwnerProfileList list = new RankOwnerProfileList();
        User user1 = new User("A1", 26);
        User user2 = new User("A2", 57);
        User user3 = new User("A3", 68);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        String userId = "A1";
        assertEquals(1, list.find(userId));

    }

    @Test
    public void testDelete() {
        RankOwnerProfileList list = new RankOwnerProfileList();
        User user1 = new User("A1", 26);
        User user2 = new User("A2", 57);
        User user3 = new User("A3", 68);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        User user4 = new User("A4", 13);
        list.add(user4);

        assertEquals(4,list.sort().size());

        list.deleteUser(user4);

        assertFalse(list.hasUser(user4));

    }

    @Test
    public void testLow(){
        RankOwnerProfileList list = new RankOwnerProfileList();
        User user1 = new User("A1", 26);
        User user2 = new User("A2", 57);
        User user3 = new User("A3", 68);
        list.add(user2);
        list.add(user1);
        list.add(user3);


        assertEquals("A1",list.findLow());
    }


    @Test
    public void testHigh(){
        RankOwnerProfileList list = new RankOwnerProfileList();
        User user1 = new User("A1", 26);
        User user2 = new User("A2", 57);
        User user3 = new User("A3", 68);
        list.add(user2);
        list.add(user1);
        list.add(user3);


        assertEquals("A3",list.findHigh());
    }


}

