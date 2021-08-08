package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationHelper {

    public static String chromeDriverPath;

    public static String mainSiteUrl;
    public static String adminPanelLogin;
    public static String adminUsername;
    public static String adminPassword;

    public static void init() throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("configuration.properties");
        properties.load(fis);

        mainSiteUrl = properties.getProperty("mainSiteUrl");
        adminPanelLogin = properties.getProperty("adminPanelLogin");
        adminUsername = properties.getProperty("adminUsername");
        adminPassword = properties.getProperty("adminPassword");
        adminPanelLogin = properties.getProperty("adminPanelLogin");
        chromeDriverPath = properties.getProperty("chromeDriverPath");
    }
}
