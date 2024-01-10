package ui.configs;

import java.io.IOException;
import java.util.Properties;

public class ConfigTestLink {

    private static Properties prop;

    public static String url_link_to_page;
    public static String url_link_on_page;
    public static String assert_link_on_page;
    public static String text_link_on_page;
    public static String assert_text_link_on_page;

    public ConfigTestLink(String configPath) {
        prop = initProperties(configPath);

        url_link_to_page = prop.getProperty("url.link.to.page");
        url_link_on_page = prop.getProperty("url.link.on.page");
        assert_link_on_page = prop.getProperty("assert.link.on.page");
        text_link_on_page = prop.getProperty("text.link.on.page");
        assert_text_link_on_page = prop.getProperty("assert.text.link.on.page");
    }

    private static Properties initProperties(String configPath) {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(configPath));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file: " + configPath);
        }
        return properties;
    }
}
