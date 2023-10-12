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
import javax.swing.JList;
import javax.swing.JComboBox;


public class ChangePass extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePass frame = new ChangePass();
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
	public ChangePass() {
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
		panel.setBounds(0, 0, 712, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Recharge");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(120, 36, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnSendMoney = new JButton("Send money");
		btnSendMoney.setBounds(234, 36, 105, 23);
		panel.add(btnSendMoney);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAccount.setBounds(388, 11, 54, 14);
		panel.add(lblAccount);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(377, 36, 80, 22);
		panel.add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("Edit account");
		comboBox_1.addItem("Exit");
		
		JButton btnNewButton_1_1 = new JButton("Purchase");
		btnNewButton_1_1.setBounds(491, 36, 89, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Balance");
		btnNewButton_1_2.setBounds(613, 36, 89, 23);
		panel.add(btnNewButton_1_2);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProducts.setBounds(10, 36, 89, 23);
		panel.add(btnProducts);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 77, 712, 342);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(170, 11, 359, 320);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setBounds(112, 11, 147, 19);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblCurrentBalance = new JLabel("Old password");
		lblCurrentBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrentBalance.setBounds(140, 90, 82, 19);
		panel_2.add(lblCurrentBalance);
		
		JLabel lblAmountToRecharge = new JLabel("New Password");
		lblAmountToRecharge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAmountToRecharge.setBounds(140, 167, 89, 19);
		panel_2.add(lblAmountToRecharge);
		
		JButton btnNewButton_1 = new JButton("Change");
		btnNewButton_1.setBackground(new Color(0, 128, 192));
		btnNewButton_1.setBounds(140, 268, 89, 23);
		panel_2.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(112, 197, 160, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 120, 145, 20);
		panel_2.add(textField_1);
	}

}
