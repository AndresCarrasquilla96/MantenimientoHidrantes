/*
    DbProperties.java
    Junio 2019
    Autores    :
                --------- Bryan Garro Eduarte
                --------- Fiorella Salgado Rodriguez
                116770151 Elmer Montenegro Brenes
 */

package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbProperties {

    public DbProperties() {
        properties = new Properties();
        loadDbProperties(properties);
    }

    private void loadDbProperties(Properties prop) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(strFilePath)) {
            prop.load(input);
        } catch (IOException ex) {
            Logger.getLogger(DbProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDbDriver() {
        return properties.getProperty("driver");
    }

    public String getDbDatasource() {
        return properties.getProperty("datasource");
    }

    public String getDbUser() {
        return properties.getProperty("user");
    }

    public String getDbPassword() {
        return properties.getProperty("password");
    }
    private final static String strFilePath = "\\resources\\application.properties";
    Properties properties;
}
