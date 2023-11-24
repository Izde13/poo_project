package unit_test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import gui.Login;

public class LoginTest {

    private Login login;

    @Before
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testGetEmail() {
        login.email.setText("test@example.com");
        assertEquals("test@example.com", login.getEmail());
    }

    @Test
    public void testGetPassword() {
        login.pass.setText("testPassword");
        assertArrayEquals("testPassword".toCharArray(), login.getPassword());
    }

    @Test
    public void testAddLoginListener() {
        ActionListenerMock listener = new ActionListenerMock();
        login.addLoginListener(listener);

        JButton btnSignIn = login.btnSignIn;
        assertNotNull(btnSignIn);

        btnSignIn.doClick();

        assertTrue(listener.actionPerformedCalled);
    }

    @Test
    public void testAddRegisterListener() {
        ActionListenerMock listener = new ActionListenerMock();
        login.addRegisterListener(listener);

        JButton btnRegister = login.btnRegister;
        assertNotNull(btnRegister);

        btnRegister.doClick();

        assertTrue(listener.actionPerformedCalled);
    }


    @Test
    public void testClearForm() {
        login.email.setText("test@example.com");
        login.pass.setText("testPassword");

        login.clearForm();

        assertEquals("", login.email.getText());
        assertEquals("", String.valueOf(login.pass.getPassword()));
    }

    private static class ActionListenerMock implements java.awt.event.ActionListener {
        public boolean actionPerformedCalled = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            actionPerformedCalled = true;
        }
    }

}
