package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

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

public class SendMoney extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField idDestination;
	private JFormattedTextField amountToSend;
	private JTextField emaiDestination;
	JButton btnSend;
	JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendMoney frame = new SendMoney();
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
	public SendMoney() {
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Double.class);
	    formatter.setMinimum(0.0);
	    formatter.setMaximum(Double.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    
	    NumberFormat intFormat = NumberFormat.getInstance();
	    NumberFormatter intFormatter = new NumberFormatter(intFormat);
	    intFormatter.setValueClass(Integer.class);
	    intFormatter.setMinimum(0);
	    intFormatter.setMaximum(Integer.MAX_VALUE);
	    intFormatter.setAllowsInvalid(false);
	    
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
		panel_2.setBounds(133, 11, 441, 397);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Send Money");
		lblNewLabel.setBounds(161, 11, 119, 23);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblCurrentBalance = new JLabel("Amount to send");
		lblCurrentBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrentBalance.setBounds(161, 86, 102, 19);
		panel_2.add(lblCurrentBalance);
		
		JLabel lblAmountToRecharge = new JLabel("Recipient identification");
		lblAmountToRecharge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAmountToRecharge.setBounds(161, 168, 135, 19);
		panel_2.add(lblAmountToRecharge);
		
		btnSend = new JButton("Send");
		btnSend.setBackground(new Color(0, 128, 192));
		btnSend.setBounds(106, 349, 89, 23);
		panel_2.add(btnSend);
		
		idDestination = new JFormattedTextField(intFormatter);
		idDestination.setBounds(148, 198, 160, 20);
		panel_2.add(idDestination);
		idDestination.setColumns(10);
		
		amountToSend = new JFormattedTextField(formatter);
		amountToSend.setColumns(10);
		amountToSend.setBounds(151, 116, 145, 20);
		panel_2.add(amountToSend);
		
		JLabel lblEmailIdentification = new JLabel("Email identification");
		lblEmailIdentification.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailIdentification.setBounds(170, 251, 110, 19);
		panel_2.add(lblEmailIdentification);
		
		emaiDestination = new JTextField();
		emaiDestination.setColumns(10);
		emaiDestination.setBounds(148, 281, 160, 20);
		panel_2.add(emaiDestination);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setBackground(new Color(0, 128, 192));
		btnCancel.setBounds(258, 349, 89, 23);
		panel_2.add(btnCancel);
	}
	
	public int getId() {
		return (int) idDestination.getValue();
	}
	
	public double getAmountSend() {
		return (double) amountToSend.getValue();
	}
	
	public String getEmail() {
		return emaiDestination.getText();
	}
	
    public void showMessage(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void clearForm() {
        amountToSend.setText("");
        idDestination.setText("");
        emaiDestination.setText("");
    }
    
    public void addSendListener(ActionListener listener) {
    	btnSend.addActionListener(listener);
    }
    
    public void addCancelSendListener(ActionListener listener) {
    	btnCancel.addActionListener(listener);
    }
}
