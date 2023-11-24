package unit_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.User;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        //Crea un usuario para el test
        int userId = 1;
        long mobileNumber = 1234567890;
        char[] password = "password123".toCharArray();
        User user = new User("John", "Doe", userId, mobileNumber, "user", "john.doe@example.com", password);

        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(userId, user.getIdUser());
        assertEquals(mobileNumber, user.getMobile());
        assertEquals("user", user.getRole());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals(password, user.getPass());

        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setIdUser(2);
        user.setMobile(9876543210L);
        user.setRole("admin");
        user.setEmail("jane.doe@example.com");

        assertEquals("Jane", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(2, user.getIdUser());
        assertEquals(9876543210L, user.getMobile());
        assertEquals("admin", user.getRole());
        assertEquals("jane.doe@example.com", user.getEmail());
    }
}
