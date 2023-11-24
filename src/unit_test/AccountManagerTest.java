package unit_test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import model.AccountManager;
import model.User;

import java.util.List;

public class AccountManagerTest {

    private AccountManager accountManager;
    private User testUser;

    @Before
    public void setUp() {
        accountManager = new AccountManager();
        testUser = new User("John", "Doe", 1, 1234567890L, "user", "john.doe@example.com", "password123".toCharArray());
    }

    @Test
    public void testCreateAccount() {
        accountManager.createAccount(testUser);
        assertNotNull(accountManager.editUserById(testUser.getIdUser()));
    }

    @Test
    public void testEditUser() {
        accountManager.createAccount(testUser);
        testUser.setFirstName("Jane");
        accountManager.editUser(testUser);
        assertEquals("Jane", accountManager.editUserById(testUser.getIdUser()).getFirstName());
    }

    @Test
    public void testFindIdUser() {
        accountManager.createAccount(testUser);
        assertTrue(accountManager.findIdUser(testUser.getIdUser()));
    }

    @Test
    public void testIsAdmin() {
        User adminUser = new User("Admin", "User", 2, 9876543210L, "Admin", "admin@example.com", "adminPass".toCharArray());
        accountManager.createAccount(adminUser);
        assertTrue(accountManager.isAdmin(adminUser.getIdUser()));
    }


    @Test
    public void testRoleUserById() {
        accountManager.createAccount(testUser);
        String userRole = accountManager.roleUserById(testUser.getIdUser());
        assertEquals("user", userRole);
    }
}
