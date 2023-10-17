package poo_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainPage;
import gui.SendMoney;


public class SendMoneyController {
	private SendMoney view;
	
	public SendMoneyController(SendMoney view) {
		this.view = view;
        this.view.addSendListener(new SendListener());	
        this.view.addCancelSendListener(new CancelSendListener());
	}
	
    class SendListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
             double amountSend = view.getAmountSend();
             int idDestination = view.getId();
             String emailDestination = view.getEmail();
             
             boolean successfulRecharge = AccountManager.transferMoney(idDestination, amountSend);
             
             if (successfulRecharge) {
                 view.showMessage("Sending of money successfully");
                 MainPage mainPage = new MainPage();
                 MainPageController MainPageController = new MainPageController(mainPage);
                 mainPage.setVisible(true);
       			 view.dispose();
             } else {
                 view.showMessage("Sending of money failed");
             }        
        }
    }
    
    class CancelSendListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	MainPage mainPage = new MainPage();
            MainPageController MainPageController = new MainPageController(mainPage);
            mainPage.setVisible(true);
       		view.dispose();      
        }
    }
}
