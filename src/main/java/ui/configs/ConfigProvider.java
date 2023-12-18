package ui.configs;

import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {

    private static final String CONFIG_PATH = "config.properties";

    private static final Properties prop = initProperties();

    //1
    public static final String BASE_URL = prop.getProperty("base.url");
    public static final String EN_URL = prop.getProperty("assert.url");

    //2
    public static final String UNI_PHONENUMBER = prop.getProperty("uni.phonenumber");

    //3
    public static final String SCHEDULE_URL = prop.getProperty("url.schedule");

    //4
    public static final String PAYMENT_URL = prop.getProperty("url.payment");

    //5
    public static final String PAYMENT_RAH = prop.getProperty("assert.paymentrah");

    //6
    public static final String SEARCH_CHECK = prop.getProperty("assert.search");

    //7
    public static final String FINAL_HEIGHT = prop.getProperty("img.height");
    public static final String FINAL_WIDTH = prop.getProperty("img.width");

    //8

    //9

    //10

    private static Properties initProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file: " + CONFIG_PATH);
        }
        return properties;
    }
}
