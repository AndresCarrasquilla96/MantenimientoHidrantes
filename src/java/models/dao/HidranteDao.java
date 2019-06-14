/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DbProperties;

public class HidranteDao {

    private static final String INGRESAR_HIDRANTE
            = "INSERT INTO hidrante (calle, avenida, numero_hidrante, caudal_esperado, tamanio_salidas) VALUES "
            + "(?, ?, ?, ?, ?);";
    DbProperties dbProperties;

    public HidranteDao() {
        try {
            dbProperties = new DbProperties();
            Class.forName(dbProperties.getDbDriver()).newInstance();
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException ex) {
            Logger.getLogger(HidranteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ingresarHidrante(String calle, String avenida, Integer numero_hidrante, Double caudal_esperado, Integer tamanio_salidas) throws Exception {

        try (Connection connection = DriverManager.getConnection(
                dbProperties.getDbDatasource(),
                dbProperties.getDbUser(),
                dbProperties.getDbPassword());
                PreparedStatement ps = connection.prepareStatement(INGRESAR_HIDRANTE);) {
            ps.setString(1, calle);
            ps.setString(2, avenida);
            ps.setInt(3, numero_hidrante);
            ps.setDouble(4, caudal_esperado);
            ps.setInt(5, tamanio_salidas);

            if (ps.executeUpdate() == 0) {
                throw new Exception("Error en el HidranteDao ingresarHidrante()");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //-------------------
    private static final String PRUEBA_ALV
            = "INSERT INTO hidrante_prueba (latitud, longitud, caudal_esperado, tamanio_salidas) VALUES "
            + "(?, ?, ?, ?);";

    public void ingresarHidrante(String latitud, String longitud, String caudal_esperado, String tamanio_salidas) throws Exception {
        try (Connection connection = DriverManager.getConnection(
                dbProperties.getDbDatasource(),
                dbProperties.getDbUser(),
                dbProperties.getDbPassword());
                PreparedStatement ps = connection.prepareStatement(PRUEBA_ALV);) {
            
            ps.setString(1, latitud);
            ps.setString(2, longitud);
            ps.setString(3, caudal_esperado);
            ps.setString(4, tamanio_salidas);

            if (ps.executeUpdate() == 0) {
                throw new Exception("Error en el HidranteDao ingresarHidrante()");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}