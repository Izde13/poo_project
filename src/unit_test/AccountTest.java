package unit_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import model.Account;
import model.User;

public class AccountTest {

    @Test
    public void testGettersAndSetters() {
        // Creamos user que seria el owner
        User user = new User("John", "Doe", 1, 1234567890L, "user", "john.doe@example.com", "password123".toCharArray());

        Account account = new Account(user);

        assertEquals(0, account.getAvailableMoney(), 0.001);
        assertNotNull(account.getOwner());
        assertEquals(user, account.getOwner());

        account.setAvailableMoney(100.0);
        User newUser = new User("Jane", "Doe", 2, 9876543210L, "admin", "jane.doe@example.com", "password456".toCharArray());
        account.setOwner(newUser);

        assertEquals(100.0, account.getAvailableMoney(), 0.001);
        assertEquals(newUser, account.getOwner());
    }

}
