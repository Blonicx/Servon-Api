package blonicx.servonapi.servon_network;

import blonicx.servonapi.Servon_Api;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.MongoException;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Database {
    static String uri;

    private static String getUri() throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = Servon_Api.class.getResourceAsStream("/uri.yml")) {
            if (inputStream == null) {
                throw new IOException("uri.yml not found in the JAR.");
            }
            Map<String, Object> obj = yaml.load(inputStream);
            return (String) obj.get("MondoDB");
        }
    }

    {
        try {
            uri = getUri();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void SubmitPlayer(Player p)
    {

        try {
            MongoClient mongoClient = MongoClients.create(uri);

            MongoDatabase database = mongoClient.getDatabase("ServonNetwork");

            MongoCollection<Document> collection = database.getCollection("User");

            Document user = new Document("name", p.getName()).append("uuid", p.getUniqueId());

            collection.insertOne(user);

            mongoClient.close();
        } catch (MongoException e) {
            System.err.println("Failed to connect to the database: " + e);
        }
    }
}