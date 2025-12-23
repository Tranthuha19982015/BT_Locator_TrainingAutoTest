package com.hatester.helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties properties;
    private static String linkFile;
    private static String relPropertiesFilePathDefault = "src/test/resources/configs/config.properties";

    public static Properties loadAllFiles() {
        LinkedList<String> files = new LinkedList<>();
        // Add tất cả file Properties vào đây theo mẫu
        files.add("src/test/resources/configs/config.properties");
//        files.add("src/test/resources/configs/local.properties");
//        files.add("src/test/resources/configs/production.properties");

        try {
            properties = new Properties();
            for (String f : files) {
                linkFile = SystemHelper.getCurrentDir() + f;
                try (FileInputStream fis = new FileInputStream(linkFile)) {
                    Properties tempProp = new Properties();
                    tempProp.load(fis);
                    properties.putAll(tempProp);
                }
            }
            linkFile = SystemHelper.getCurrentDir() + relPropertiesFilePathDefault; //gán lại gtrị default nếu có nhiều file properties
            return properties;
        } catch (IOException ioe) {
            throw new RuntimeException("Cannot load properties file: " + linkFile, ioe);
        }
    }

    public static void setFile(String relPropertiesFilePath) {
        Properties temp = new Properties();
        linkFile = SystemHelper.getCurrentDir() + relPropertiesFilePath;
        try (FileInputStream fis = new FileInputStream(linkFile)) {
            temp.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load: " + linkFile, e);
        }
        properties = temp;
    }

    public static void setDefaultFile() {
        setFile(relPropertiesFilePathDefault);
    }

    public static String getValue(String key) {
        if (properties == null) {
            setDefaultFile();
        }
        // Lấy giá trị từ file đã Set
        return properties.getProperty(key);
    }

    //synchronized: Để ngăn chặn nhiều thread cùng lúc ghi vào file .properties
    // => Chỉ cho PHÉP 1 thread chạy setValue() tại một thời điểm
    // => Các thread khác phải đợi
    public static synchronized void setValue(String key, String value) {
        if (properties == null) {
            setDefaultFile();
        }
        properties.setProperty(key, value);
        try (FileOutputStream out = new FileOutputStream(linkFile)) {
            properties.store(out, null);
        } catch (Exception e) {
            throw new RuntimeException("Cannot write property file: " + linkFile, e);
        }
    }
}
