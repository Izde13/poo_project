package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;

public class JsonFileManager {
	
	private transient static char[] encryptedPassword;

	public static JsonArray readFileJSON(String pathFile) {
        JsonArray jsonArray = new JsonArray();
        try (FileReader reader = new FileReader(pathFile)) {
            Gson gson = new Gson();
            jsonArray = gson.fromJson(reader, JsonArray.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonArray;
    }
	
	 public static void writeFileJSON(String pathFile, JsonArray jsonArray) {
		 try (FileWriter fileWriter = new FileWriter(pathFile)) {
			 Gson gson = new GsonBuilder().setPrettyPrinting().create();
	         String jsonOutput = gson.toJson(jsonArray);
	         fileWriter.write(jsonOutput);
	         System.out.println("Ok write");
		 } catch (IOException e) {
			 e.printStackTrace();
	     }
	 }
	 
	 public static List<User> readUsersFromFile(String pathFile) {
		 List<User> userList = new ArrayList<>();
	     try (FileReader reader = new FileReader(pathFile)) {
	    	 Gson gson = new Gson();
	         userList = gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
	     } catch (IOException e) {
	    	 e.printStackTrace();
	     }
	     return userList;
	 }
	 
	 public static List<Account> readAccountFromFile(String pathFile) {
		 List<Account> accountList = new ArrayList<>();
	     try (FileReader reader = new FileReader(pathFile)) {
	    	 Gson gson = new Gson();
	    	 accountList = gson.fromJson(reader, new TypeToken<List<Account>>(){}.getType());
	     } catch (IOException e) {
	    	 e.printStackTrace();
	     }
	     return accountList;
	 }
	 
	 public static void writeUsersToFile(List<User> userList) {
	    JsonArray jsonArray = new JsonArray();
	    String pathFile = "C:\\Documents\\Universidad\\POO\\1er_corte\\poo_project\\src\\model\\users.json";
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	    for (User user : userList) {
	        JsonObject userJson = new JsonObject();
	        userJson.addProperty("firstName", user.getFirstName());
	        userJson.addProperty("lastName", user.getLastName());
	        userJson.addProperty("idUser", user.getIdUser());
	        userJson.addProperty("mobile", user.getMobile());
	        userJson.addProperty("role", user.getRole());
	        userJson.addProperty("email", user.getEmail());
	        encryptedPassword = user.getPass();
	        userJson.add("password", gson.toJsonTree(encryptedPassword));
	        jsonArray.add(userJson);
	    }
	
	    try (FileWriter fileWriter = new FileWriter(pathFile)) {
	        String jsonOutput = gson.toJson(jsonArray);
	        fileWriter.write(jsonOutput);
	        System.out.println("Ok write");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	 
	public static void writeAccountToFile(List<Account> accountList) {
		JsonArray jsonArray = new JsonArray();
		String pathFile = "C:\\Documents\\Universidad\\POO\\1er_corte\\poo_project\\src\\model\\account.json";
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    for (Account account : accountList) {
	        String accountJson = gson.toJson(account);
	        jsonArray.add(gson.fromJson(accountJson, JsonObject.class));
	    }
	    try (FileWriter fileWriter = new FileWriter(pathFile)) {
	        String jsonOutput = gson.toJson(jsonArray);
	        fileWriter.write(jsonOutput);
	        System.out.println("Ok write");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
