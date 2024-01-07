package ui.configs;

import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {

    private static final String CONFIG_PATH = "config.properties";

    private static final Properties prop = initProperties();

    public static final String BASE_URL = prop.getProperty("base.url");
    public static final String EN_URL = prop.getProperty("assert.url");

    public static final String UNI_PHONENUMBER = prop.getProperty("uni.phonenumber");

    public static final String SCHEDULE_URL = prop.getProperty("url.schedule");

    public static final String PAYMENT_URL = prop.getProperty("url.payment");

    public static final String PAYMENT_DETAILS = prop.getProperty("assert.paymentdetails");

    public static final String TEACHERS_URL = prop.getProperty("url.teachers");

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
