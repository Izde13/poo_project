package unit_test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.google.gson.JsonArray;

import model.Account;
import model.JsonFileManager;
import model.Product;
import model.User;

public class JsonFileManagerTest {

    @Test
    public void testWriteFileJSON() throws IOException {
        JsonFileManager.writeFileJSON("fake/path", new JsonArray());
    }

    @Test
    public void testReadUsersFromFile() {
        List<User> userList = JsonFileManager.readUsersFromFile("fake/path");
        assertEquals(0, userList.size());
    }

    @Test
    public void testReadAccountFromFile() {
        List<Account> accountList = JsonFileManager.readAccountFromFile("fake/path");
        assertEquals(0, accountList.size());
    }

    @Test
    public void testReadProductsFromFile() {
        List<Product> productList = JsonFileManager.readProductsFromFile("fake/path");
        assertEquals(0, productList.size());
    }

}
