package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField newUser;
	private JTextField newPass;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 458);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(294, 11, 99, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(178, 80, 91, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(178, 174, 91, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(178, 259, 91, 28);
		contentPane.add(lblNewLabel_1_2);
		
		newUser = new JTextField();
		newUser.setBounds(178, 107, 325, 36);
		contentPane.add(newUser);
		newUser.setColumns(10);
		
		newPass = new JTextField();
		newPass.setColumns(10);
		newPass.setBounds(178, 202, 325, 36);
		contentPane.add(newPass);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(178, 287, 325, 36);
		contentPane.add(email);
		
		JButton btnNewRegister = new JButton("Register");
		btnNewRegister.setForeground(new Color(0, 64, 128));
		btnNewRegister.setBackground(new Color(0, 128, 255));
		btnNewRegister.setBounds(178, 365, 128, 23);
		contentPane.add(btnNewRegister);
		
		JButton btnCancelRegister = new JButton("Cancel");
		btnCancelRegister.setForeground(new Color(255, 0, 0));
		btnCancelRegister.setBackground(new Color(255, 128, 128));
		btnCancelRegister.setBounds(375, 365, 128, 23);
		contentPane.add(btnCancelRegister);
	}

}
