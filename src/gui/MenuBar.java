package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuBar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JButton btnRecharge;
    private JButton btnSendMoney;
    private JButton btnPurchase;
    private JButton btnProducts;
    private JLabel lblAccount;
    private JComboBox comboBox_1;
    private JButton btnBalance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBar frame = new MenuBar();
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
	public MenuBar() {
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
		
		btnRecharge = new JButton("Recharge");
		btnRecharge.setBounds(120, 36, 89, 23);
		btnRecharge.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(btnRecharge);
		
		btnSendMoney = new JButton("Send money");
		btnSendMoney.setBounds(234, 36, 105, 23);
		panel.add(btnSendMoney);
		
		lblAccount = new JLabel("Account");
		lblAccount.setBounds(388, 11, 54, 14);
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblAccount);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(377, 36, 80, 22);
		panel.add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("Edit account");
		comboBox_1.addItem("Exit");
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(491, 36, 89, 23);
		panel.add(btnPurchase);
		
		btnBalance = new JButton("Balance");
		btnBalance.setBounds(613, 36, 89, 23);
		panel.add(btnBalance);
		
		btnProducts = new JButton("Products");
		btnProducts.setBounds(10, 36, 89, 23);
		btnProducts.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(btnProducts);
	}
	
    public JComponent getMenuBarComponent() {
        // Devuelve un contenedor que contiene todos los botones de la barra de menú
    	 JPanel menuPanel = new JPanel();
    	    menuPanel.setBackground(new Color(0, 128, 255));
    	    menuPanel.setLayout(null);

    	    btnRecharge.setBounds(120, 36, 89, 23);
    	    btnSendMoney.setBounds(234, 36, 105, 23);
    	    lblAccount.setBounds(388, 11, 54, 14);
    	    comboBox_1.setBounds(377, 36, 80, 22);
    	    btnPurchase.setBounds(491, 36, 89, 23);
    	    btnBalance.setBounds(613, 36, 89, 23);
    	    btnProducts.setBounds(10, 36, 89, 23);

    	    menuPanel.add(btnRecharge);
    	    menuPanel.add(btnSendMoney);
    	    menuPanel.add(lblAccount);
    	    menuPanel.add(comboBox_1);
    	    menuPanel.add(btnPurchase);
    	    menuPanel.add(btnBalance);
    	    menuPanel.add(btnProducts);

    	    return menuPanel;
    }

}
