/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasosGuia2;

import fuente.ConexionMySQL;
// import Clases.ConexionSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author User
 */
public class AppBDCaso1 {
    public static String UnirFecha(int d, int m, int a){
        String dd = (d < 10 ? "0" + String.valueOf(d) : String.valueOf(d));
        String mm = (m < 10 ? "0" + String.valueOf(m) : String.valueOf(m));
        String aa = String.valueOf(a);
        
        return dd + "/" + mm + "/" + aa;
    }
    
    public static void main(String[] args) {
        ConexionMySQL cn = new ConexionMySQL();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        Connection cnx = null;  //Conexion
        Statement stm = null;   // Sentencia (con SQL)
        ResultSet rs = null;    // Resultados
        
        try {
            cnx = cn.Conectar();
            stm = cnx.createStatement();
            rs = stm.executeQuery("select * from tb_persona1 order by ap_paterno asc");
            
            String formato = "%-10s %-30s %-6s %-12s %-10s";
            
            System.out.println(String.format(formato, "DNI", "Apellido y Nombre",
                    "Genero", "Fec. Nac", "Sueldo"));
            System.out.println(String.format(formato, "------", "------------------",
                    "--------", "--------", "------"));
            
            while (rs.next()) {
                String dni = rs.getString(1);
                String nom = rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4);
                char gen = rs.getString(5).charAt(0);
                
                LocalDate fn = LocalDate.parse(rs.getString(6), dtf);
                
                String fec_nac = UnirFecha(fn.getDayOfMonth(), fn.getMonthValue(), fn.getYear());
                
                float sue = rs.getFloat(7);
                
                System.out.println(String.format(formato, dni, nom, gen, fec_nac, df.format(sue)));
            }
        } catch (SQLException e1){
            e1.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                
                if (stm != null) stm.close();
                
                if (cnx != null) cnx.close();
            } catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }
}
