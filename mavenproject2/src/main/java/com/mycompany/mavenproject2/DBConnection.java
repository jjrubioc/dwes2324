/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanjo
 */
public class DBConnection {

    private Connection c;

    public DBConnection() {

//        String url = "jdbc:mysql://192.168.1.142/deportes?enabledTLSProtocols=TLSv1.2";
//        String user = "user";
//        String pass = "pass";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.c = DriverManager.getConnection(
                    "jdbc:mariadb://192.168.1.144:3306/deportes",
                    "user", "pass"
            );
        } catch (SQLException | ClassNotFoundException ex) {
            this.c = null;
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("conn: " + c);
    }

    public int insertSport(String s) {
        String sqlSentence = "insert into deporte values ('" + s + "');";
        System.out.println("Sentence: " + sqlSentence);
        Statement st;
        int n = -1;
        try {
            st = this.c.createStatement();

            n = st.executeUpdate(sqlSentence);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

}
