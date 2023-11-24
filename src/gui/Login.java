package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JPasswordField pass;
	public JTextField email;
    public JButton btnSignIn;
    public JButton btnRegister;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 458);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(0, 0, 277, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 211, 266, 197);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/resources/logoU2.jpg")));
		
		JLabel lblNewLabel_1 = new JLabel("Vending machine");
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(46, 88, 191, 69);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(275, 0, 435, 419);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		pass = new JPasswordField();
		pass.setBounds(103, 247, 228, 32);
		panel_1.add(pass);
		pass.setColumns(10);
		
		email = new JTextField();
		email.setBounds(103, 152, 228, 32);
		panel_1.add(email);
		email.setColumns(10);
		
		btnSignIn = new JButton("Sign In");
		btnSignIn.setForeground(new Color(0, 0, 0));
		btnSignIn.setBackground(new Color(0, 128, 192));
		btnSignIn.setBounds(103, 333, 98, 23);
		panel_1.add(btnSignIn);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(103, 119, 63, 32);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(103, 216, 63, 32);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setForeground(new Color(0, 128, 192));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(103, 56, 48, 32);
		panel_1.add(lblNewLabel_3);
		
		btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setBackground(new Color(0, 128, 192));
		btnRegister.setBounds(230, 333, 98, 23);
		panel_1.add(btnRegister);
	}
	
    public String getEmail() {
        return email.getText();
    }

    public char[] getPassword() {
        return pass.getPassword();
    }
    
    public void addLoginListener(ActionListener listener) {
        btnSignIn.addActionListener(listener);
    }
    
    public void addRegisterListener(ActionListener listener) {
        btnRegister.addActionListener(listener);
    }
    
    public void showMessage(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void clearForm() {
        email.setText("");
        pass.setText("");
    }
}

