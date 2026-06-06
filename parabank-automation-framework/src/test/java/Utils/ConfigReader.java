package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public ConfigReader() {

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "src/test/resources/config.properties");

            prop = new Properties();

            prop.load(fis);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public String getBrowser() {

        return prop.getProperty("browser");
    }

    public String getUrl() {

        return prop.getProperty("url");
    }

    public String getUsername() {

        return prop.getProperty("username");
    }

    public String getPassword() {

        return prop.getProperty("password");
    }

    public String getExecution() {

        return prop.getProperty("execution");
    }
}