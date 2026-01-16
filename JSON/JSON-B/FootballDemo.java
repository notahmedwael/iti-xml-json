import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.List;

public class FootballDemo {
    public static void main(String[] args) {
        // Create the JSON-B engine
        Jsonb jsonb = JsonbBuilder.create();

        Footballer player = new Footballer("Mohamed Salah", "Liverpool", 18);
        String objectJson = jsonb.toJson(player);
        System.out.println("Object Mapping:\n" + objectJson);

        // A "raw" list can hold different types (String, Integer, Boolean)
        List rawList = new ArrayList();
        rawList.add("Premier League");
        rawList.add(2024);
        rawList.add(true);

        String rawJson = jsonb.toJson(rawList);
        System.out.println("\nRaw Collection Mapping:\n" + rawJson);

        // A list specifically restricted to <Footballer> objects
        List<Footballer> team = new ArrayList<>();
        team.add(new Footballer("L. Messi", "Inter Miami", 12));
        team.add(new Footballer("C. Ronaldo", "Al Nassr", 25));

        String genericJson = jsonb.toJson(team);
        System.out.println("\nGeneric Collection Mapping:\n" + genericJson);
    }
}