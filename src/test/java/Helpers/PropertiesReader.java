package Helpers;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Вспомогательный класс для чтения файлов пропертис
 */
public class PropertiesReader {

    /**
     * Инстанс класса
     */
    private static PropertiesReader instance;

    /**
     * Инпутстрим для чтения пропертис
     */
    private FileInputStream fis;

    /**
     * Значения из файла пропертис
     */
    private final Properties properties = new Properties();

    /**
     * Конструктор класса
     */
    @SneakyThrows
    private PropertiesReader() {
        try {
            fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert fis != null;
            fis.close();
        }
    }

    /**
     * Геттер инстанса PropertiesReader
     * @return инстанс PropertiesReader
     */
    private static PropertiesReader getInstance()  {
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    /**
     * Метод получения значения проперти
     * @param propertyName имя проперти
     * @return значение проперти
     */
    @SneakyThrows
    public static String getProperty(String propertyName) {
        return getInstance().properties.getProperty(propertyName);
    }
}
