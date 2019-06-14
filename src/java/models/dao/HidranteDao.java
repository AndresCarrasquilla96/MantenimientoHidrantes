/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.awt.geom.Point2D;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Hidrante;
import utils.DbProperties;

public class HidranteDao {

    DbProperties dbProperties;
    private static final String INGRESAR_HIDRANTE = "{call insertarHidrante(?,?,?,?)}";

    private static final String OBTENER_HIDRANTES = "{call obtenerHidrantes()}";

    private static final String ACTUALIZAR_ESTADO = "{call actualizarHidrante(?)}";

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

    public void ingresarHidrante(String latitud, String longitud, String caudal_esperado, String tamanio_salidas) throws Exception {

        try (Connection connection = DriverManager.getConnection(
                dbProperties.getDbDatasource(),
                dbProperties.getDbUser(),
                dbProperties.getDbPassword());
                CallableStatement ps = connection.prepareCall(INGRESAR_HIDRANTE);) {

            ps.setDouble(1, Double.parseDouble(latitud));
            ps.setDouble(2, Double.parseDouble(longitud));
            ps.setString(3, caudal_esperado);
            ps.setString(4, tamanio_salidas);

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Hidrante> obtenerHidrantes() {
        List<Hidrante> resultado = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(
                dbProperties.getDbDatasource(),
                dbProperties.getDbUser(),
                dbProperties.getDbPassword());
                CallableStatement ps = connection.prepareCall(OBTENER_HIDRANTES);) {

            System.out.println("models.dao.HidranteDao.obtenerHidrantes()");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] coordenadas = String.valueOf(rs.getObject("ubicacion")).split(",");
                String lat = coordenadas[0].replace("(", "");
                String lng = coordenadas[1].replace(")", "");
                Point2D.Double ubicacion = new Point2D.Double(Double.parseDouble(lat), Double.parseDouble(lng));

                Hidrante h = new Hidrante(rs.getInt("id_hidrante"), ubicacion, rs.getString("caudal_esperado"), rs.getString("tamanio_salidas"), rs.getBoolean("buen_estado"));

                resultado.add(h);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public Boolean actualizarEstado(Integer id_hidrante) {

        Boolean update = false;

        try (Connection connection = DriverManager.getConnection(
                dbProperties.getDbDatasource(),
                dbProperties.getDbUser(),
                dbProperties.getDbPassword());
                CallableStatement ps = connection.prepareCall(ACTUALIZAR_ESTADO);) {

            ps.setInt(1, id_hidrante);
            if (ps.execute()) {
                update = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return update;
    }
}