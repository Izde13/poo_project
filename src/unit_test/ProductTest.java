package unit_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Product;

public class ProductTest {

    @Test
    public void testGettersAndSetters() {
        //Creamos un Producto
        Product product = new Product(1, "Producto de prueba", 10.0, "Electrónicos", 50);

        //Probamos getters
        assertEquals(1, product.getIdProduct());
        assertEquals("Producto de prueba", product.getName());
        assertEquals(10.0, product.getCost(), 0.001); // Usar delta para la comparación de valores de punto flotante
        assertEquals("Electrónicos", product.getCategory());
        assertEquals(50, product.getQuantityAvailable());

        //Probamos setters
        product.setIdProduct(2);
        product.setName("Nuevo producto");
        product.setCost(15.0);
        product.setCategory("Ropa");
        product.setQuantityAvailable(20);

        //Probamos actualización igual a creación
        assertEquals(2, product.getIdProduct());
        assertEquals("Nuevo producto", product.getName());
        assertEquals(15.0, product.getCost(), 0.001);
        assertEquals("Ropa", product.getCategory());
        assertEquals(20, product.getQuantityAvailable());
    }
}
