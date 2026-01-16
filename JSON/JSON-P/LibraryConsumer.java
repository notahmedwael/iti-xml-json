import jakarta.json.*;
import java.io.FileReader;
import java.io.IOException;

public class LibraryConsumer {
    public static void main(String[] args) {
        try (JsonReader reader = Json.createReader(new FileReader("library.json"))) {
            // 1. Get the Root and Config Object
            JsonObject root = reader.readObject();
            JsonObject config = root.getJsonObject("library_config");

            // 2. Retrieve Basic Info
            System.out.println("LIBRARY REPORT");
            System.out.println("===============");
            System.out.println("Location: " + config.getString("location"));
            System.out.println("Description: " + config.getString("description"));

            JsonObject librarian = config.getJsonObject("librarian");
            System.out.println("Librarian: " + librarian.getString("name") + " (ID: " + librarian.getString("id") + ")");
            System.out.println();

            // 3. Loop through Books
            JsonArray books = config.getJsonArray("books");
            for (JsonValue bookVal : books) {
                JsonObject book = bookVal.asJsonObject();
                System.out.println("BOOK: " + book.getString("title"));
                System.out.println("Author: " + book.getString("author"));
                System.out.println("Price: $" + book.getString("price"));

                // 4. Loop through Parts
                JsonArray parts = book.getJsonArray("parts");
                for (JsonValue partVal : parts) {
                    JsonObject part = partVal.asJsonObject();
                    System.out.println("  [Part]: " + part.getString("part_title"));

                    // 5. Loop through Chapters
                    JsonArray chapters = part.getJsonArray("chapters");
                    for (JsonValue chapVal : chapters) {
                        JsonObject chapter = chapVal.asJsonObject();
                        System.out.println("    - Chapter: " + chapter.getString("chapter_title"));
                        System.out.println("      Summary: " + chapter.getString("summary"));

                        // 6. Loop through Sections
                        JsonArray sections = chapter.getJsonArray("sections");
                        for (JsonValue secVal : sections) {
                            JsonObject section = secVal.asJsonObject();
                            System.out.println("      > Section: " + section.getString("section_title"));

                            // 7. Loop through Paragraphs (Content Array)
                            JsonArray content = section.getJsonArray("content");
                            for (JsonValue pVal : content) {
                                // Content is an array of strings
                                String paragraph = ((JsonString) pVal).getString();
                                System.out.println("          " + paragraph);
                            }
                        }
                    }
                }
                System.out.println("--------------------------------------------------");
            }

        } catch (IOException e) {
            System.err.println("Could not find library.json. Run the Producer first!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}