package unit_test;


import model.User;
import poo_project.UserSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserSessionTest {

    private User testUser;

    @Before
    public void setUp() {
        int userId = 1;
        long mobileNumber = 1234567890;
        char[] password = "password123".toCharArray();
        User testUser = new User("John", "Doe", userId, mobileNumber, "user", "john.doe@example.com", password);
    }

    @After
    public void tearDown() {
        UserSession.clearLoggedInUser();
    }

    @Test
    public void testSetAndGetLoggedInUser() {
        assertNull(UserSession.getLoggedInUser());

        UserSession.setLoggedInUser(testUser);

        assertEquals(testUser, UserSession.getLoggedInUser());
    }

    @Test
    public void testClearLoggedInUser() {
        UserSession.setLoggedInUser(testUser);

        assertEquals(testUser, UserSession.getLoggedInUser());

        UserSession.clearLoggedInUser();

        assertNull(UserSession.getLoggedInUser());
    }
}
