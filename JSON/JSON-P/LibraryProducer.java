import jakarta.json.*;
import java.io.FileWriter;
import java.io.IOException;

public class LibraryProducer {
    public static void main(String[] args) {

        // Book 1
        JsonObject section1A = Json.createObjectBuilder()
                .add("section_title", "Protons and Neutrons")
                .add("content", Json.createArrayBuilder()
                        .add("The nucleus is composed of protons and neutrons.")
                        .add("Protons carry a positive charge, while neutrons are neutral.")
                        .add("Together, they account for nearly all of an atom's mass.")
                        .build())
                .build();

        JsonObject section1B = Json.createObjectBuilder()
                .add("section_title", "This chapter reviews Bohr")
                .add("content", Json.createArrayBuilder()
                        .add("Bohr was great")
                        .add("We all like Bohr")
                        .build())
                .build();

        JsonObject chapter1 = Json.createObjectBuilder()
                .add("chapter_title", "Chapter 1: The Nucleus")
                .add("summary", "This chapter explores the core of the atom.")
                .add("sections", Json.createArrayBuilder().add(section1A).add(section1B).build())
                .build();

        JsonObject book1 = Json.createObjectBuilder()
                .add("title", "The Architecture of Atoms")
                .add("isbn", "978-3-16-148410-0")
                .add("author", "Dr. Elena Sterling")
                .add("preface", "An introductory look at atomic structures in the modern age.")
                .add("publisher", "Someone")
                .add("year", "2000")
                .add("price", "49.99")
                .add("parts", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("part_title", "Part I: Fundamental Particles")
                                .add("chapters", Json.createArrayBuilder().add(chapter1).build())))
                .build();

        // Book 2
        JsonObject section2A = Json.createObjectBuilder()
                .add("section_title", "Crossing the Creek")
                .add("content", Json.createArrayBuilder()
                        .add("They use a rope swing to cross the gully into their new kingdom.")
                        .add("Leslie declares they need a place that is theirs alone, away from the world.")
                        .build())
                .build();

        JsonObject section2B = Json.createObjectBuilder()
                .add("section_title", "Ending")
                .add("content", Json.createArrayBuilder()
                        .add("A very sad ending")
                        .add("Our childhood trauma")
                        .build())
                .build();

        JsonObject chapter2 = Json.createObjectBuilder()
                .add("chapter_title", "Chapter 4: Rulers of Terabithia")
                .add("summary", "Jess and Leslie find a secret place in the woods and name it Terabithia.")
                .add("sections", Json.createArrayBuilder().add(section2A).add(section2B).build())
                .build();

        JsonObject book2 = Json.createObjectBuilder()
                .add("title", "Bridge to Terabithia")
                .add("isbn", "978-0-06-073401-5")
                .add("author", "Katherine Paterson")
                .add("preface", "A story of friendship and the power of imagination.")
                .add("publisher", "Someone")
                .add("year", "1977")
                .add("price", "29.99")
                .add("parts", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("part_title", "Part 1: The Creation of a Kingdom")
                                .add("chapters", Json.createArrayBuilder().add(chapter2).build())))
                .build();

        // Build the pieces
        JsonObject libraryRoot = Json.createObjectBuilder()
                .add("library_config", Json.createObjectBuilder()
                        .add("location", "New Cairo")
                        .add("description", "A library based in New Cairo")
                        .add("librarian", Json.createObjectBuilder()
                                .add("name", "Ahmed Wael")
                                .add("id", "20210045"))
                        .add("books", Json.createArrayBuilder()
                                .add(book1)
                                .add(book2)))
                .build();

        // Write to file
        try (JsonWriter writer = Json.createWriter(new FileWriter("library.json"))) {
            writer.writeObject(libraryRoot);
            System.out.println("Success: library.json is made yaaay");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}