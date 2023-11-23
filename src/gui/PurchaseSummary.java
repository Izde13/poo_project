package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class PurchaseSummary extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JLabel labelNameProduct;
    private JLabel labelCategoryProduct;
    private JFormattedTextField amount;
    private JComboBox comboBox;
    private JLabel labelTotalPurchase;
    private JLabel labelIva;
    private JLabel labelTotalProduct;
    private JLabel labelDiscount;
    private JLabel labelUnitCost;
    JButton btnSubmit;
    JButton btnCancel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseSummary frame = new PurchaseSummary();
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
	public PurchaseSummary() {
		setTitle("Purchase Summary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 458);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 328, 351);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Detail");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(98, 11, 130, 31);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name product");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(35, 92, 93, 20);
		panel.add(lblNewLabel_1);
		
		labelNameProduct = new JLabel("");
		labelNameProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelNameProduct.setBounds(174, 95, 132, 20);
		panel.add(labelNameProduct);
		
		JLabel lblNewLabel_1_2 = new JLabel("Amount");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(35, 193, 72, 14);
		panel.add(lblNewLabel_1_2);
		
		labelCategoryProduct = new JLabel("");
		labelCategoryProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCategoryProduct.setBounds(176, 144, 110, 14);
		panel.add(labelCategoryProduct);
		
		JLabel lblNewLabel_1_3 = new JLabel("Category");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(35, 141, 93, 20);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Payment method ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(35, 242, 130, 20);
		panel.add(lblNewLabel_1_4);
		
		comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("Coins");
		comboBox.addItem("Card");
		comboBox.addItem("Money in account");
		comboBox.setBounds(176, 243, 110, 22);
		panel.add(comboBox);
		
		amount = new JFormattedTextField(formatter);
		amount.setValue(1);
		amount.setBounds(174, 192, 86, 20);
		panel.add(amount);
		amount.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(358, 11, 328, 351);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPurchaseDetails = new JLabel("Purchase details");
		lblPurchaseDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPurchaseDetails.setBounds(97, 11, 142, 25);
		panel_1.add(lblPurchaseDetails);
		
		JLabel lblNewLabel_1_5 = new JLabel("Unit Product Cost");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(23, 74, 130, 20);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Discount");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(23, 175, 72, 14);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Total product cost");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(23, 123, 119, 20);
		panel_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("IVA value");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(23, 222, 72, 14);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Total purchase");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_2.setBounds(23, 290, 130, 25);
		panel_1.add(lblNewLabel_1_2_1_2);
		
		labelUnitCost = new JLabel("");
		labelUnitCost.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelUnitCost.setBounds(196, 74, 93, 20);
		panel_1.add(labelUnitCost);
		
		labelDiscount = new JLabel("");
		labelDiscount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelDiscount.setBounds(196, 175, 72, 14);
		panel_1.add(labelDiscount);
		
		labelTotalProduct = new JLabel("");
		labelTotalProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTotalProduct.setBounds(196, 123, 93, 20);
		panel_1.add(labelTotalProduct);
		
		labelIva = new JLabel("");
		labelIva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelIva.setBounds(196, 222, 72, 14);
		panel_1.add(labelIva);
		
		labelTotalPurchase = new JLabel("");
		labelTotalPurchase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTotalPurchase.setBounds(196, 290, 93, 14);
		panel_1.add(labelTotalPurchase);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(218, 385, 89, 23);
		contentPane.add(btnSubmit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setBounds(402, 385, 89, 23);
		contentPane.add(btnCancel);
		

	}
	
    public void updateProductDetails(String productName, String category) {
        labelNameProduct.setText(productName);
        labelCategoryProduct.setText(category);
    }
    
    public void updateBillDetail(double unitCost, double totalCost, double discount, double valueIva, double totalPurchase) {
    	labelUnitCost.setText(String.valueOf(unitCost));
    	labelTotalProduct.setText(String.valueOf(totalCost));
    	labelDiscount.setText(String.valueOf(discount));
    	labelIva.setText(String.valueOf(valueIva));
    	labelTotalPurchase.setText(String.valueOf(totalPurchase));
    }
        
    public int getAmount() {
        try {
            return Integer.parseInt(amount.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public void addAmountChangeListener(DocumentListener listener) {
        amount.getDocument().addDocumentListener(listener);
    }
	
    public JComboBox<String> getComboBox() {
        return comboBox;
    }
    
    public void showMessage(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void addBuyOkListener(ActionListener listener) {
        btnSubmit.addActionListener(listener);
    }
    
    public void addBuyCancelListener(ActionListener listener) {
        btnCancel.addActionListener(listener);
    }

}
