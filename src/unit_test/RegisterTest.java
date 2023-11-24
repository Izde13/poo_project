package unit_test;

import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gui.Register;

import javax.swing.JFormattedTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.*;

public class RegisterTest {

    private Register register;

    @Before
    public void setUp() {
        register = new Register();
    }

    @After
    public void tearDown() {
        register = null;
    }

    @Test
    public void testGetFirstName() {
        register.firstName.setText("John");
        assertEquals("John", register.getFirstName());
    }

    @Test
    public void testGetPass() {
        char[] password = "password".toCharArray();
        register.pass.setText("password");
        assertArrayEquals(password, register.getPass());
    }

    @Test
    public void testGetEmail() {
        register.email.setText("john@example.com");
        assertEquals("john@example.com", register.getEmail());
    }

    @Test
    public void testGetLastName() {
        register.lastName.setText("Doe");
        assertEquals("Doe", register.getLastName());
    }

    @Test
    public void testGetId() {
        register.id.setValue(123);
        assertEquals(123, register.getId());
    }

    @Test
    public void testGetMobile() {
        register.mobile.setValue(1234567890L);
        assertEquals(1234567890L, register.getMobile());
    }

    @Test
    public void testIsAdminRoleSelected() {
        assertFalse(register.isAdminRoleSelected());
        register.adminRole.setSelected(true);
        assertTrue(register.isAdminRoleSelected());
    }

    @Test
    public void testIsEmployeeRoleSelected() {
        assertFalse(register.isEmployeeRoleSelected());
        register.employeeRole.setSelected(true);
        assertTrue(register.isEmployeeRoleSelected());
    }

    @Test
    public void testIsStudentRoleSelected() {
        assertFalse(register.isStudentRoleSelected());
        register.studentRole.setSelected(true);
        assertTrue(register.isStudentRoleSelected());
    }


}
