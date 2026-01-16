import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProductDemo {
    public static void main(String[] args) {
        // Use GsonBuilder for "Pretty Printing" so the file is readable
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String fileName = "product.json";

        // Write to file
        Product myProduct = new Product("Mechanical Keyboard", 89.99, true);

        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(myProduct, writer);
            System.out.println("Successfully wrote Product to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------------");

        // Read from file
        try (FileReader reader = new FileReader(fileName)) {
            // Read the JSON and convert it back to a Product object
            Product importedProduct = gson.fromJson(reader, Product.class);

            System.out.println("Successfully read from file!");
            System.out.println("Object Data: " + importedProduct);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}