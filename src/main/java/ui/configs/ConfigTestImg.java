package ui.configs;

import java.io.IOException;
import java.util.Properties;

public class ConfigTestImg {
    private static Properties prop;

    public static String url_link_to_page;
    public static String img_on_page;
    public static String assert_img_height_on_page;
    public static String assert_img_weight_on_page;

    public ConfigTestImg(String configPath) {
        prop = initProperties(configPath);

        url_link_to_page = prop.getProperty("url.link.to.page");
        img_on_page = prop.getProperty("img.on.page");
        assert_img_height_on_page = prop.getProperty("assert.img.height.on.page");
        assert_img_weight_on_page = prop.getProperty("assert.img.weight.on.page");
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
