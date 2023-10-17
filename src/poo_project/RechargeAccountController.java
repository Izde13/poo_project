package poo_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainPage;
import gui.RechargeAccount;

public class RechargeAccountController {
	private RechargeAccount view;
	
	public RechargeAccountController(RechargeAccount view) {
		this.view = view;
        this.view.addRechargeListener(new RechargeAccountListener());	
        this.view.addCancelRechargeListener(new CancelRechargeAccountListener());
	}
	
    class RechargeAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	 User loggedInUser = UserSession.getLoggedInUser();
             double rechargeAmount = view.getAmountRecharge();
             boolean successfulRecharge = AccountManager.rechargeAccount(loggedInUser, rechargeAmount);
             if (successfulRecharge) {
                 view.showMessage("Account recharged successfully");
                 MainPage mainPage = new MainPage();
                 MainPageController MainPageController = new MainPageController(mainPage);
                 mainPage.setVisible(true);
       			 view.dispose();
             } else {
                 view.showMessage("Account recharge failed");
             }        
        }
    }
    
    class CancelRechargeAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	MainPage mainPage = new MainPage();
            MainPageController MainPageController = new MainPageController(mainPage);
            mainPage.setVisible(true);
       		view.dispose();      
        }
    }

}
