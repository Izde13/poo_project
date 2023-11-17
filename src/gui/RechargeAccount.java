package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import model.AccountManager;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class RechargeAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField amountRecharge;
	private JLabel currentBalance;
	JButton btnRecharge;
	JButton btnCancelRecharge;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechargeAccount frame = new RechargeAccount();
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
	public RechargeAccount() {
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Double.class);
	    formatter.setMinimum(0.0);
	    formatter.setMaximum(Double.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	        
		setBounds(100, 100, 728, 458);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 712, 419);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(155, 11, 396, 397);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recharge account");
		lblNewLabel.setBounds(106, 29, 213, 34);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lblCurrentBalance = new JLabel("Current balance");
		lblCurrentBalance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCurrentBalance.setBounds(143, 122, 130, 19);
		panel_2.add(lblCurrentBalance);
		
		JLabel lblAmountToRecharge = new JLabel("Amount to recharge");
		lblAmountToRecharge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAmountToRecharge.setBounds(130, 223, 157, 19);
		panel_2.add(lblAmountToRecharge);
		
		btnRecharge = new JButton("Recharge");
		btnRecharge.setBackground(new Color(0, 128, 192));
		btnRecharge.setBounds(106, 334, 89, 23);
		panel_2.add(btnRecharge);
		
		amountRecharge = new JFormattedTextField(formatter);
		amountRecharge.setBounds(106, 253, 194, 20);
		panel_2.add(amountRecharge);
		amountRecharge.setColumns(10);
		
		currentBalance = new JLabel("");
		currentBalance.setBounds(143, 152, 115, 14);
		panel_2.add(currentBalance);
		AccountManager accountManager = new AccountManager(); 
        double newCurrentBalance = accountManager.getCurrentBalance();
        setCurrentBalance(newCurrentBalance);	
        
		btnCancelRecharge = new JButton("Cancel");
		btnCancelRecharge.setForeground(new Color(255, 0, 0));
		btnCancelRecharge.setBounds(225, 334, 89, 23);
		panel_2.add(btnCancelRecharge);
	
	}
	
	public double getAmountRecharge() {
		return (double) amountRecharge.getValue();
	}

    public void addRechargeListener(ActionListener listener) {
        btnRecharge.addActionListener(listener);
    }
    
    public void addCancelRechargeListener(ActionListener listener) {
        btnCancelRecharge.addActionListener(listener);
    }
    
    public void setCurrentBalance(double balance) {
    	currentBalance.setText(String.valueOf(balance));
    }
    
    public void showMessage(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void clearForm() {
        amountRecharge.setText("");
    }
}
