package demopoi.dao;

import demopoi.model.Products;
import demopoi.util.ConnectionDB;
import java.util.*;
import java.sql.*;

public class Negocio {

    private static ConnectionDB cdb;
    private static PreparedStatement ps = null;
    private static CallableStatement cs = null;
    private static ResultSet rs = null;

    public Negocio() {
        cdb = ConnectionDB.newInstance();
    }

    private void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (cdb != null) {
                cdb.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexion :" + e.getMessage());
        }
    }
    
    public List<Products> findAllProducts() {
        List<Products> productos = new ArrayList();
        try {
            String sql = "SELECT id, name, category, number_serie, product_information, price FROM Products p;";
            ps = cdb.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();            
            Products p;
            while (rs.next()) {
                p = new Products();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                //p.setCategory(rs.getInt(3));
                p.setNumberSerie(rs.getInt(4));
                p.setProductInformation(rs.getString(5));
                p.setPrice(rs.getDouble(6));
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return productos;
    }
}
