package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {

            Connection conn = null;
            PreparedStatement st = null;


            try{
                conn = DB.getConnection();
                st = conn.prepareStatement(
                        "UPDATE seller "
                        + "SET BaseSalary = BaseSalary + ? "
                        + "WHERE "
                        + "(DepartmentId = ? )");

                st.setDouble(1, 200.0);
                st.setInt(2, 2);
                int rows = st.executeUpdate();

                System.out.println("Done! Rows affected " + rows);
            }catch (SQLException e){
                e.printStackTrace();

            }
            DB.closeStatement(st);
            DB.closeConnection();
    }
}
