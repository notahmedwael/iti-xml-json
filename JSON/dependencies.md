# Project Dependencies: JSON Processing in Java

This project demonstrates three different ways to handle JSON in Java:  **JSON-Processing (JSON-P)** ,  **JSON-Binding (JSON-B)** , and  **Google Gson** .

Below are the required JAR files for each module. All JARs should be placed in the `lib/` folder and added to the Project Structure in IntelliJ.

## 1. JSON-P (Object Model API)

*Used for manual building and parsing of JSON trees using `JsonObjectBuilder` and `JsonReader`.*

| **JAR File**             | **Role**          | **Version** |
| ------------------------------ | ----------------------- | ----------------- |
| `jakarta.json-api-2.1.3.jar` | API (Interfaces)        | 2.1.3             |
| `jakarta.json-2.0.1.jar`     | Implementation (Engine) | 2.0.1             |

---

## 2. JSON-B (Jakarta JSON Binding)

*Used for automatic mapping of Java POJOs to JSON. Note: JSON-B **requires** the JSON-P JARs (above) to be present to function.*

| **JAR File**                  | **Role**           | **Version** |
| ----------------------------------- | ------------------------ | ----------------- |
| `jakarta.json.bind-api-3.0.1.jar` | Binding API              | 3.0.1             |
| `yasson-3.0.4.jar`                | Reference Implementation | 3.0.4             |

---

## 3. Google Gson

*A lightweight, third-party library by Google for serialization and deserialization. It is "all-in-one" and has no other dependencies.*

| **JAR File**  | **Role**   | **Version** |
| ------------------- | ---------------- | ----------------- |
| `gson-2.10.1.jar` | Complete Library | 2.10.1            |

---

## Installation Instructions (IntelliJ IDEA)

1. **Create lib folder:** Create a folder named `lib` in your project root.
2. **Download JARs:** Place the required `.jar` files into that folder.
3. **Configure IntelliJ:**
   * Go to  **File > Project Structure > Libraries** .
   * Click the **+** button ->  **Java** .
   * Select the JARs from the `lib` folder.
   * Click  **OK** .

---

### Verification Code

To ensure your environment is set up correctly, you can run the following test imports:

**Java**

```
import jakarta.json.Json;            // Tests JSON-P
import jakarta.json.bind.Jsonb;      // Tests JSON-B
import com.google.gson.Gson;         // Tests Gson
```
