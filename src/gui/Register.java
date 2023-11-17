package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstName;
	private JPasswordField pass;
	private JTextField email;
	private JTextField lastName;
	private JFormattedTextField  id;
	private JFormattedTextField  mobile;
	private JRadioButton studentRole;
	private JRadioButton employeeRole;
	private JRadioButton adminRole;
	JButton btnNewRegister;	
	JButton btnCancelRegister;
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
		
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);

        NumberFormat mobileFormat = NumberFormat.getInstance();
        NumberFormatter mobileFormatter = new NumberFormatter(mobileFormat);
        mobileFormatter.setValueClass(Long.class);
        mobileFormatter.setMinimum(0L);
        mobileFormatter.setMaximum(Long.MAX_VALUE);
        mobileFormatter.setAllowsInvalid(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(295, 0, 99, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(178, 56, 91, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(178, 183, 91, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(178, 284, 91, 17);
		contentPane.add(lblNewLabel_1_2);
		
		firstName = new JTextField();
		firstName.setBounds(178, 75, 325, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		pass = new JPasswordField();
		pass.setColumns(10);
		pass.setBounds(178, 205, 325, 23);
		contentPane.add(pass);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(178, 299, 325, 23);
		contentPane.add(email);
		
		btnNewRegister = new JButton("Register");
		btnNewRegister.setForeground(new Color(0, 64, 128));
		btnNewRegister.setBackground(new Color(0, 128, 255));
		btnNewRegister.setBounds(178, 385, 128, 23);
		contentPane.add(btnNewRegister);
		
		btnCancelRegister = new JButton("Cancel");
		btnCancelRegister.setForeground(new Color(255, 0, 0));
		btnCancelRegister.setBackground(new Color(255, 128, 128));
		btnCancelRegister.setBounds(375, 385, 128, 23);
		contentPane.add(btnCancelRegister);
		
		JLabel lblNewLabel_1_3 = new JLabel("Last Name");
		lblNewLabel_1_3.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(178, 96, 91, 23);
		contentPane.add(lblNewLabel_1_3);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(178, 114, 325, 23);
		contentPane.add(lastName);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Id");
		lblNewLabel_1_3_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_1.setBounds(178, 140, 91, 23);
		contentPane.add(lblNewLabel_1_3_1);
		
		id = new JFormattedTextField(formatter);
		id.setColumns(10);
		id.setBounds(178, 158, 325, 23);
		contentPane.add(id);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mobile");
		lblNewLabel_1_1_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(178, 227, 91, 23);
		contentPane.add(lblNewLabel_1_1_1);
		
		mobile = new JFormattedTextField(mobileFormat);
		mobile.setColumns(10);
		mobile.setBounds(178, 250, 325, 23);
		contentPane.add(mobile);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Role");
		lblNewLabel_1_2_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(178, 344, 33, 17);
		contentPane.add(lblNewLabel_1_2_1);
		
		adminRole = new JRadioButton("Admin");
		adminRole.setBounds(213, 342, 63, 23);
		contentPane.add(adminRole);
		
		employeeRole = new JRadioButton("Employee");
		employeeRole.setBounds(295, 342, 99, 23);
		contentPane.add(employeeRole);
		
		studentRole = new JRadioButton("Student");
		studentRole.setBounds(412, 342, 91, 23);
		contentPane.add(studentRole);
	}


	public String getFirstName() {
		return firstName.getText();
	}


	public char[]  getPass() {
		return pass.getPassword();
	}

	public String getEmail() {
		return email.getText();
	}


	public String getLastName() {
		return lastName.getText();
	}


	public int getId() {
		return (int) id.getValue();
	}


	public long getMobile() {
		return (long) mobile.getValue();
	}

    public boolean isAdminRoleSelected() {
        return adminRole.isSelected();
    }

    public boolean isEmployeeRoleSelected() {
        return employeeRole.isSelected();
    }

    public boolean isStudentRoleSelected() {
        return studentRole.isSelected();
    }	
    
    public void showMessage(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
	
    public void clearForm() {
        firstName.setText("");
        lastName.setText("");
        pass.setText("");
        email.setText("");
        id.setText("");
        mobile.setText("");
    }
    
    public void addRegisterListener(ActionListener listener) {
        btnNewRegister.addActionListener(listener);
    }
    
    public void addCancelRegisterListener(ActionListener listener) {
    	btnCancelRegister.addActionListener(listener);
    }
	
}
