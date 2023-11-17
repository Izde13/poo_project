package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import model.AccountManager;

public class MainPageAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JButton btnManageAccount;
    private JButton btnDeleteProduct;
    private JButton btnCreateProduct;
    private JButton btnEditProduct;
    private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPageAdmin frame = new MainPageAdmin();
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
	public MainPageAdmin() {
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
		
		btnManageAccount = new JButton("Manage account");
		btnManageAccount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnManageAccount.setBounds(397, 221, 117, 41);
		panel.add(btnManageAccount);
		
		btnDeleteProduct = new JButton("Delete product");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteProduct.setBounds(397, 159, 117, 41);
		panel.add(btnDeleteProduct);
		
		btnCreateProduct = new JButton("Create product");
		btnCreateProduct.setBounds(397, 26, 117, 41);
		panel.add(btnCreateProduct);
		
		btnEditProduct = new JButton("Edit product");
		btnEditProduct.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEditProduct.setBounds(397, 87, 117, 41);
		panel.add(btnEditProduct);
		
		lblNewLabel = new JLabel("Panel admin");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(72, 150, 187, 64);
		panel.add(lblNewLabel);
		
		JComboBox<String> comboBox_1 = new JComboBox();
		comboBox_1.setBounds(397, 292, 117, 37);
		panel.add(comboBox_1);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setForeground(Color.WHITE);
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAccount.setBounds(397, 273, 54, 14);
		panel.add(lblAccount);
		AccountManager accountManager = new AccountManager(); 
        double newCurrentBalance = accountManager.getCurrentBalance();        setCurrentBalance(newCurrentBalance);	
	}
	
    public void addProductsButtonListener(ActionListener listener) {
        btnEditProduct.addActionListener(listener);
    }
    
    public void addRechargeAccountButtonListener(ActionListener listener) {
        btnManageAccount.addActionListener(listener);
    }
    
    public void addTransferMoneyButtonListener(ActionListener listener) {
        btnDeleteProduct.addActionListener(listener);
    }
    
    public void addShowCartButtonListener(ActionListener listener) {
        btnCreateProduct.addActionListener(listener);
    }
    
   // public JComboBox<String> getComboBox() {
        //return comboBox_1;
    //}
    
   // public void addExitButtonListener(ActionListener listener) {
  //      comboBox_1.addActionListener(listener);
   // }
    
    public void setCurrentBalance(double balance) {
    }
}
