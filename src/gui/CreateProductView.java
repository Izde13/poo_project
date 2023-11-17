package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

public class CreateProductView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idProduct;
	private JTextField name;
	private JFormattedTextField  cost;
	private JFormattedTextField  quantityAvailable;
	private JRadioButton sweetSnacksCategory;
	private JRadioButton saltySnacksCategory;
	private JRadioButton drinkCategory;
	JButton btnNewProduct;	
	JButton btnCancelRegister;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateProductView frame = new CreateProductView();
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
	public CreateProductView() {
			
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

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Create product");
			lblNewLabel.setForeground(new Color(0, 128, 192));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblNewLabel.setBounds(236, 0, 208, 48);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Id");
			lblNewLabel_1.setForeground(new Color(0, 128, 255));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(178, 56, 91, 23);
			contentPane.add(lblNewLabel_1);
			
			idProduct = new JTextField();
			idProduct.setBounds(178, 75, 325, 20);
			contentPane.add(idProduct);
			idProduct.setColumns(10);
			
			btnNewProduct = new JButton("Create");
			btnNewProduct.setForeground(new Color(0, 64, 128));
			btnNewProduct.setBackground(new Color(0, 128, 255));
			btnNewProduct.setBounds(178, 385, 128, 23);
			contentPane.add(btnNewProduct);
			
			btnCancelRegister = new JButton("Cancel");
			btnCancelRegister.setForeground(new Color(255, 0, 0));
			btnCancelRegister.setBackground(new Color(255, 128, 128));
			btnCancelRegister.setBounds(375, 385, 128, 23);
			contentPane.add(btnCancelRegister);
			
			JLabel lblNewLabel_1_3 = new JLabel("Name");
			lblNewLabel_1_3.setForeground(new Color(0, 128, 255));
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_3.setBounds(178, 106, 91, 23);
			contentPane.add(lblNewLabel_1_3);
			
			name = new JTextField();
			name.setColumns(10);
			name.setBounds(178, 131, 325, 23);
			contentPane.add(name);
			
			JLabel lblNewLabel_1_3_1 = new JLabel("Cost");
			lblNewLabel_1_3_1.setForeground(new Color(0, 128, 255));
			lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_3_1.setBounds(178, 159, 91, 23);
			contentPane.add(lblNewLabel_1_3_1);
			
			cost = new JFormattedTextField(formatter);
			cost.setColumns(10);
			cost.setBounds(178, 181, 325, 23);
			contentPane.add(cost);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Quantity available");
			lblNewLabel_1_1_1.setForeground(new Color(0, 128, 255));
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1_1.setBounds(178, 215, 128, 23);
			contentPane.add(lblNewLabel_1_1_1);
			
			quantityAvailable = new JFormattedTextField(formatter);
			quantityAvailable.setColumns(10);
			quantityAvailable.setBounds(178, 235, 325, 23);
			contentPane.add(quantityAvailable);
			
			JLabel lblNewLabel_1_2_1 = new JLabel("Category");
			lblNewLabel_1_2_1.setForeground(new Color(0, 128, 255));
			lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_2_1.setBounds(314, 268, 63, 17);
			contentPane.add(lblNewLabel_1_2_1);
			
			drinkCategory = new JRadioButton("Drinks");
			drinkCategory.setBounds(314, 292, 63, 23);
			contentPane.add(drinkCategory);
			
			saltySnacksCategory = new JRadioButton("Salty snacks");
			saltySnacksCategory.setBounds(314, 318, 99, 23);
			contentPane.add(saltySnacksCategory);
			
			sweetSnacksCategory = new JRadioButton("Sweet snacks");
			sweetSnacksCategory.setBounds(314, 343, 91, 23);
			contentPane.add(sweetSnacksCategory);
		}


		public String getFirstName() {
			return idProduct.getText();
		}


		public String getLastName() {
			return name.getText();
		}


		public int getId() {
			return (int) cost.getValue();
		}


		public int getMobile() {
			return (int) quantityAvailable.getValue();
		}

	    public boolean isAdminRoleSelected() {
	        return drinkCategory.isSelected();
	    }

	    public boolean isEmployeeRoleSelected() {
	        return saltySnacksCategory.isSelected();
	    }

	    public boolean isStudentRoleSelected() {
	        return sweetSnacksCategory.isSelected();
	    }	
	    
	    public void showMessage(String mensaje) {
	        JOptionPane.showMessageDialog(this, mensaje);
	    }
		
	    public void clearForm() {
	        idProduct.setText("");
	        name.setText("");
	        quantityAvailable.setText("");
	        cost.setText("");
	        quantityAvailable.setText("");
	    }
	    
	    public void addRegisterListener(ActionListener listener) {
	        btnNewProduct.addActionListener(listener);
	    }
	    
	    public void addCancelRegisterListener(ActionListener listener) {
	    	btnCancelRegister.addActionListener(listener);
	    }

}
