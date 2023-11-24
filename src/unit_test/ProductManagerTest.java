package unit_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Product;
import model.ProductManager;

public class ProductManagerTest {

    private ProductManager productManager;

    @Before
    public void setUp() {
        productManager = new ProductManager();
    }

    @Test
    public void testCreateProduct() {
        List<Product> initialProducts = productManager.getDrinkProducts();
        Product newProduct = new Product(1, "New Product", 10.0, "Drinks", 100);
        productManager.createProduct(newProduct);
        List<Product> updatedProducts = productManager.getDrinkProducts();
        assertTrue(updatedProducts.contains(newProduct));
        assertTrue(updatedProducts.size() > initialProducts.size());
    }

    @Test
    public void testEditProduct() {
        Product originalProduct = new Product(1, "Original Product", 20.0, "Category", 50);
        productManager.createProduct(originalProduct);
        originalProduct.setCost(25.0);
        originalProduct.setQuantityAvailable(75);
        productManager.editProduct(originalProduct);
        Product editedProduct = productManager.editProductById(originalProduct.getIdProduct());
        assertEquals(25.0, editedProduct.getCost(), 0.001);
        assertEquals(75, editedProduct.getQuantityAvailable());
    }

    @Test
    public void testFindIdProduct() {
        Product testProduct = new Product(1, "Test Product", 30.0, "Category", 20);
        productManager.createProduct(testProduct);
        assertTrue(productManager.findIdProduct(testProduct.getIdProduct()));
        assertFalse(productManager.findIdProduct(-1));
    }

    @Test
    public void testEditProductById() {
        Product testProduct = new Product(1, "Test Product", 30.0, "Category", 20);
        productManager.createProduct(testProduct);
        Product editedProduct = productManager.editProductById(testProduct.getIdProduct());
    }
    

    @Test
    public void testProductByIndex() {
        Product product1 = new Product(1, "Product 1", 10.0, "Category", 100);
        Product product2 = new Product(2, "Product 2", 15.0, "Category", 50);
        Product product3 = new Product(3, "Product 3", 20.0, "Category", 75);
        productManager.createProduct(product1);
        productManager.createProduct(product2);
        productManager.createProduct(product3);
        Product retrievedProduct1 = productManager.productByIndex(0);
        Product retrievedProduct2 = productManager.productByIndex(1);
        Product retrievedProduct3 = productManager.productByIndex(2);
    }

    @Test
    public void testProductNameById() {
        Product product1 = new Product(1, "Product 1", 10.0, "Category", 100);
        Product product2 = new Product(2, "Product 2", 15.0, "Category", 50);
        productManager.createProduct(product1);
        productManager.createProduct(product2);
        String name1 = productManager.productNameById(1);
        String name2 = productManager.productNameById(2);
    }
}
