package model;

import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DatabaseUtil;

public class ProductModel {

    Connection conn = null;

    public List<Product> findAll() {

        conn = DatabaseUtil.createConnection();

        PreparedStatement prst = null;

        String sql = "SELECT * FROM product";

        List<Product> list = null;

        try {
            prst = conn.prepareStatement(sql);

            ResultSet rs = prst.executeQuery();

            list = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int idCategory = rs.getInt("id_category");
                list.add(new Product(id, name, price, idCategory));
            }

            prst.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Product findById(int id) {
        Product product = null;

        conn = DatabaseUtil.createConnection();

        PreparedStatement prst = null;

        String sql = "SELECT * FROM product WHERE id = ?";
        try {
            prst = conn.prepareStatement(sql);
            prst.setInt(1, id);

            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                int idProduct = rs.getInt("id");
                String nameProduct = rs.getString("name");
                int priceProduct = rs.getInt("price");
                int idCategory = rs.getInt("id_category");
                product = new Product(idProduct, nameProduct, priceProduct, idCategory);
            }
            
            prst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    public boolean insert(Product product) {
        boolean result = false;
        conn = DatabaseUtil.createConnection();
        String sql = "INSERT INTO product (name, price, id_category) VALUES (?, ?, ?)";;
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, product.getName());
            prst.setInt(2, product.getPrice());
            prst.setInt(3, product.getIdCategory());

            if (prst.executeUpdate() > 0) {
                result = true;
            } else {
                result = false;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean update(Product product) {
        boolean result = false;
        conn = DatabaseUtil.createConnection();
        String sql = "UPDATE product set name = ?, price = ?, id_category = ? WHERE id = ?";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, product.getName());
            prst.setInt(2, product.getPrice());
            prst.setInt(3, product.getIdCategory());
            prst.setInt(4, product.getId());

            if (prst.executeUpdate() > 0) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        conn = DatabaseUtil.createConnection();
        String sql = "DELETE FROM product WHERE id = ?";
        try {
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setInt(1, id);

            if (prst.executeUpdate() > 0) {
                result = true;
            } else {
                result = false;
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }
    
    public static void main(String[] args) {
        ProductModel productModel = new ProductModel();
        Product product = new Product(13, "aaaaabbb", 123, 1);
        if (productModel.update(product)) {
            System.out.println("Success !");
        }else {
            System.out.println("Error !");
        }
    }

}
