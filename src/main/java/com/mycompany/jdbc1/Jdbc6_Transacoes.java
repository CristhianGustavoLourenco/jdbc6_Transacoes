/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.jdbc1;

import db.DB;
import db.DbIntegrityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author crist
 */
public class Jdbc6_Transacoes {

    public static void main(String[] args) {
      Connection conn = null;
      PreparedStatement st = null;
      
      try{
          conn = DB.getConnection();
          st= conn.prepareStatement("DELETE FROM department WHERE Id = ?");
          
          st.setInt(1, 5);
          
          int rowsAffected = st.executeUpdate();
          
          System.out.println("Done! Rows Affected: " + rowsAffected);
      }catch(SQLException e){
          throw new DbIntegrityException(e.getMessage());
      }finally{
          DB.closeStatement(st);
          DB.closeConnetion(); 
      }
    }
 }
