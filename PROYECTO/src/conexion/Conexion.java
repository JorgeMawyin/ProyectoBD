package conexion;

import java.sql.*;

public class Conexion {

    Connection cn;
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/serviciofinanciero", "root", "jmawyin");
        }catch(Exception e){
            System.out.println("ERROR DE CONEXION BD "+e);
        }
        return cn;
    }
}
