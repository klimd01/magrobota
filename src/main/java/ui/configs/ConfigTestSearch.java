package ui.configs;

import java.io.IOException;
import java.util.Properties;

public class ConfigTestSearch {
    private static Properties prop;

    public static String url_link_to_page;
    public static String search_on_page;
    public static String assert_search_on_page;
    public static String word_on_page;
    public static String search_check_on_page;


    public ConfigTestSearch(String configPath) {
        prop = initProperties(configPath);

        url_link_to_page = prop.getProperty("url.link.to.page");
        search_on_page = prop.getProperty("search.on.page");
        assert_search_on_page = prop.getProperty("assert.search.on.page");
        word_on_page = prop.getProperty("word.on.page");
        search_check_on_page = prop.getProperty("search.check.on.page");


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
