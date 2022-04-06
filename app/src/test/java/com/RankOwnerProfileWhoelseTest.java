package com;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.example.qrhunter.RankOwnerProfileWhoelseList;
import com.example.qrhunter.User;


import org.junit.jupiter.api.Test;

public class RankOwnerProfileWhoelseTest {

    /**
     * test sort
     */

    @Test
    public void testSort(){
        RankOwnerProfileWhoelseList list = new RankOwnerProfileWhoelseList();
        User user1 = new User("A1", 26);
        User user2 = new User("A2", 57);
        User user3 = new User("A3", 68);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        assertEquals("A3", list.sort().get(0).getUserName());
    }


    /**
     * test find user
     */

    @Test
    public void testFind(){
        RankOwnerProfileWhoelseList list = new RankOwnerProfileWhoelseList();
        User user1 = new User("A1", 26);
        User user2 = new User("A2", 57);
        User user3 = new User("A3", 68);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        String userId = "A1";
        assertEquals(1, list.find(userId));



    }

    /**
     * test delete
     */

    @Test
    public void testDelete() {
        RankOwnerProfileWhoelseList list = new RankOwnerProfileWhoelseList();
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

    /**
     * test find lowest user
     */
    @Test
    public void testLow(){
        RankOwnerProfileWhoelseList list = new RankOwnerProfileWhoelseList();
        User user1 = new User("A1", 26);
        User user2 = new User("A2", 57);
        User user3 = new User("A3", 68);
        list.add(user2);
        list.add(user1);
        list.add(user3);


        assertEquals("A1",list.findLow());
    }

    /**
     * test find highest user
     */
    @Test
    public void testHigh(){
        RankOwnerProfileWhoelseList list = new RankOwnerProfileWhoelseList();
        User user1 = new User("A1", 26);
        User user2 = new User("A2", 57);
        User user3 = new User("A3", 68);
        list.add(user2);
        list.add(user1);
        list.add(user3);


        assertEquals("A3",list.findHigh());
    }


}

