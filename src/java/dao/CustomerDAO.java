/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Customer;

/**
 *
 * @author troqu
 */
public class CustomerDAO {
        public static ArrayList<Customer> getCustomers() {
        DBContext db = DBContext.getInstance();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            String sql = """
                         select *
                         from Customer
                         """;
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("customerID"), 
                        rs.getString("customerName"), 
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
                customers.add(customer);
            }
            
        }catch ( Exception e){
            return null;
        }
        if (customers.isEmpty()) return null;
        else return customers;
    }
}
