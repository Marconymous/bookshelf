package dev.marconymous.bookshelf.service;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@ApplicationPath("/resource")
public class Config extends Application {
  private static final String PROPERTIES_PATH = "/home/marconymous/git/bookshelf/src/main/resources/booklist.properties";
  private static Properties properties = null;

  /**
   * Gets the value of a property
   *
   * @param property the key of the property to be read
   * @return the value of the property
   */
  public static String getProperty(String property) {
    if (Config.properties == null) {
      setProperties(new Properties());
      readProperties();
    }
    String value = Config.properties.getProperty(property);
    if (value == null) return "";
    return value;
  }

  /**
   * reads the properties file
   */
  private static void readProperties() {
    try (var inputStream = new FileInputStream(PROPERTIES_PATH)) {
      properties.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

  /**
   * Sets the properties
   *
   * @param properties the value to set
   */
  private static void setProperties(Properties properties) {
    Config.properties = properties;
  }
}
