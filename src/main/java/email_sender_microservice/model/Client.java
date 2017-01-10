package email_sender_microservice.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@DatabaseTable(tableName = "client")
public class Client {
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    @DatabaseField(id = true)
    private String name;
    @DatabaseField
    private String password;
    @DatabaseField
    private String APIKey;
    @DatabaseField
    private String header;
    @DatabaseField
    private String footer;
    @DatabaseField
    private String textRGB;

    public Client() {

        // ORMLite needs a no-arg constructor

    }

    public Client(String name, String password, String header, String footer, String textRGB) {
        logger.info("creating new client");
        this.name = name;
        this.password = password;
        this.APIKey = generateAPIKey();
        this.header = header;
        this.footer = footer;
        this.textRGB = textRGB;
    }

    public String generateAPIKey() {
        final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        logger.info("generated uuid: " + uuid);
        return uuid;
    }
}

