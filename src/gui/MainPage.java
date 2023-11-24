package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import model.AccountManager;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;


public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JButton btnRecharge;
    private JButton btnSendMoney;
    private JButton btnProducts;
    private JLabel lblNewLabel;
    private JComboBox comboBox_1;
    private JLabel labelBalance;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Double.class);
	    formatter.setMinimum(0.0);
	    formatter.setMaximum(Double.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 458);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(36, 30, 632, 359);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnRecharge = new JButton("Recharge");
		btnRecharge.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRecharge.setBounds(134, 263, 117, 41);
		panel.add(btnRecharge);
		
		btnSendMoney = new JButton("Send money");
		btnSendMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSendMoney.setBounds(134, 175, 117, 41);
		panel.add(btnSendMoney);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setForeground(new Color(255, 255, 255));
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAccount.setBounds(405, 162, 54, 14);
		panel.add(lblAccount);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(405, 177, 109, 37);
		panel.add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("Edit account");
		comboBox_1.addItem("Delete account");
		comboBox_1.addItem("Exit");
		
		btnProducts = new JButton("Products");
		btnProducts.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProducts.setBounds(134, 100, 117, 41);
		panel.add(btnProducts);
		
		lblNewLabel = new JLabel("Vending machine");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(242, 11, 191, 64);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Balance");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(405, 100, 109, 14);
		panel.add(lblNewLabel_1);
		
		labelBalance = new JLabel("");
		labelBalance.setForeground(new Color(0, 0, 0));
		labelBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelBalance.setBounds(405, 125, 109, 14);
		panel.add(labelBalance);
		AccountManager accountManager = new AccountManager(); 
        double newCurrentBalance = accountManager.getCurrentBalance();
        setCurrentBalance(newCurrentBalance);	
	}
	
    public void addProductsButtonListener(ActionListener listener) {
        btnProducts.addActionListener(listener);
    }
    
    public void addRechargeAccountButtonListener(ActionListener listener) {
        btnRecharge.addActionListener(listener);
    }
    
    public void addTransferMoneyButtonListener(ActionListener listener) {
        btnSendMoney.addActionListener(listener);
    }
    
    public JComboBox<String> getComboBox() {
        return comboBox_1;
    }
    
    public void addExitButtonListener(ActionListener listener) {
        comboBox_1.addActionListener(listener);
    }
    
    public void setCurrentBalance(double balance) {
    	labelBalance.setText(String.valueOf(balance));
    }
}
