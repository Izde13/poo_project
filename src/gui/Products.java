package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Product;
import model.ProductManager;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Products extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> selectedComboBox;
    JButton btnBuy;
    JButton btnCancel;
    
    private void addComboBoxItems(JComboBox<String> comboBox, ArrayList<Product> productList) {
        comboBox.removeAllItems();
        comboBox.addItem("");
        for (Product product : productList) {
            comboBox.addItem(product.getName());
        }
    }
    
    private void disableOtherComboBoxes(JComboBox<String> currentComboBox, JComboBox<String>... comboBoxes) {
        selectedComboBox = currentComboBox;
        for (JComboBox<String> comboBox : comboBoxes) {
            if (comboBox != currentComboBox) {
                comboBox.setEnabled(false);
            }
        }
    }
    
    public JComboBox<String> getSelectedComboBox() {
        return selectedComboBox;
    }
    
    public String getSelectedItem() {
        if (selectedComboBox != null) {
            return (String) selectedComboBox.getSelectedItem();
        }
        return null;
    }
    
    private JComboBox<String> drinkComboBox;
    private JComboBox<String> saltySnacksComboBox;
    private JComboBox<String> sweetSnacksComboBox;

    public Products() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        panel_2.setBounds(10, 11, 692, 105);
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel = new JLabel("Drinks");
        lblNewLabel.setBounds(10, 11, 52, 20);
        panel_2.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

        ProductManager productManager = new ProductManager();
        ArrayList<Product> drinkProducts = productManager.getDrinkProducts();
        drinkComboBox = new JComboBox<>();
        addComboBoxItems(drinkComboBox, drinkProducts);
        drinkComboBox.setBounds(10, 53, 658, 20);
        panel_2.add(drinkComboBox);

        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBounds(10, 141, 692, 105);
        panel_1.add(panel_2_1);
        panel_2_1.setLayout(null);

        JLabel lblSaltySnacks = new JLabel("Salty snacks");
        lblSaltySnacks.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSaltySnacks.setBounds(10, 11, 108, 20);
        panel_2_1.add(lblSaltySnacks);

        ArrayList<Product> saltySnacksProducts = productManager.getSaltySnacksProducts();
        saltySnacksComboBox = new JComboBox<>();
        addComboBoxItems(saltySnacksComboBox, saltySnacksProducts);
        saltySnacksComboBox.setBounds(10, 55, 658, 20);
        panel_2_1.add(saltySnacksComboBox);

        JPanel panel_2_1_1 = new JPanel();
        panel_2_1_1.setBounds(10, 270, 692, 105);
        panel_1.add(panel_2_1_1);
        panel_2_1_1.setLayout(null);

        JLabel lblSweetSnacks = new JLabel("Sweet snacks");
        lblSweetSnacks.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSweetSnacks.setBounds(10, 11, 121, 20);
        panel_2_1_1.add(lblSweetSnacks);

        ArrayList<Product> sweetSnacksProducts = productManager.getSweetSnacksProducts();
        sweetSnacksComboBox = new JComboBox<>();
        addComboBoxItems(sweetSnacksComboBox, sweetSnacksProducts);
        sweetSnacksComboBox.setBounds(10, 51, 661, 20);
        panel_2_1_1.add(sweetSnacksComboBox);

        btnBuy = new JButton("Buy");
        btnBuy.setBounds(196, 386, 145, 23);
        panel_1.add(btnBuy);

        btnCancel = new JButton("Cancel");
        btnCancel.setForeground(new Color(255, 0, 0));
        btnCancel.setBounds(406, 386, 145, 23);
        panel_1.add(btnCancel);
        
        drinkComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    disableOtherComboBoxes(drinkComboBox, saltySnacksComboBox, sweetSnacksComboBox);
			}
		});

        saltySnacksComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    disableOtherComboBoxes(saltySnacksComboBox, drinkComboBox, sweetSnacksComboBox);
			}
		});

        sweetSnacksComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    disableOtherComboBoxes(sweetSnacksComboBox, drinkComboBox, saltySnacksComboBox);
			}
		});
    }
    
    public void addBuyListener(ActionListener listener) {
        btnBuy.addActionListener(listener);
    }
    
    public void cancelBuyListener(ActionListener listener) {
        btnCancel.addActionListener(listener);
    }
}
