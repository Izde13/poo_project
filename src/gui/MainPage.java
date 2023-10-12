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


public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	}
}
