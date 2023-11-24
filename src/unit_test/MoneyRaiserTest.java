package unit_test;

import static org.junit.Assert.*;
import org.junit.Test;

import model.AccountManager;
import model.MoneyRaiser;
import model.ProductManager;

public class MoneyRaiserTest {

    @Test
    public void testGenerateBill() {
        ProductManager productManager = new ProductManager();
        AccountManager accountManager = new AccountManager();

        MoneyRaiser moneyRaiser = new MoneyRaiser(1, 1, 1, 50.0, 5.0, 9.5, 54.5, 2, "Cash");

        System.out.println("Simulating system output for generateBill() method:");

        moneyRaiser.generateBill();
    }

    @Test
    public void testGettersAndSetters() {
        MoneyRaiser moneyRaiser = new MoneyRaiser(1, 1, 1, 50.0, 5.0, 9.5, 54.5, 2, "Cash");
        assertEquals(1, moneyRaiser.getIdMovement());
        assertEquals(1, moneyRaiser.getIdUser());
        assertEquals(1, moneyRaiser.getIdProduct(), 0.001);
        assertEquals(50.0, moneyRaiser.getCostProduct(), 0.001);
        assertEquals(5.0, moneyRaiser.getDiscount(), 0.001);
        assertEquals(9.5, moneyRaiser.getValueIva(), 0.001);
        assertEquals(54.5, moneyRaiser.getTotalCost(), 0.001);
        assertEquals(2, moneyRaiser.getAmount());
        assertEquals("Cash", moneyRaiser.getPaymentType());
        moneyRaiser.setIdMovement(2);
        moneyRaiser.setIdUser(3);
        moneyRaiser.setIdProduct(4);
        moneyRaiser.setCostProduct(60.0);
        moneyRaiser.setDiscount(6.0);
        moneyRaiser.setValueIva(11.5);
        moneyRaiser.setTotalCost(65.5);
        moneyRaiser.setAmount(3);
        moneyRaiser.setPaymentType("Card");
        assertEquals(2, moneyRaiser.getIdMovement());
        assertEquals(3, moneyRaiser.getIdUser());
        assertEquals(4, moneyRaiser.getIdProduct(), 0.001);
        assertEquals(60.0, moneyRaiser.getCostProduct(), 0.001);
        assertEquals(6.0, moneyRaiser.getDiscount(), 0.001);
        assertEquals(11.5, moneyRaiser.getValueIva(), 0.001);
        assertEquals(65.5, moneyRaiser.getTotalCost(), 0.001);
        assertEquals(3, moneyRaiser.getAmount());
        assertEquals("Card", moneyRaiser.getPaymentType());
    }
}
