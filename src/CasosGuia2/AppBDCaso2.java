/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasosGuia2;

import Clases.ConexionSQL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class AppBDCaso2 extends JFrame {
    // Controles
    private JTable tb_persona1;
    private JScrollPane scp;
    private DefaultTableModel modelo_tb;
    
    public AppBDCaso2(){
        super();
        
        ConfigurarVentana();
        IniciarComponentes();
    }
    
    private void ConfigurarVentana(){
        this.setTitle("Lista de Personal");
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
    
    private void IniciarComponentes(){
        tb_persona1 = new JTable();
        
        modelo_tb = new DefaultTableModel();
        tb_persona1.setModel(modelo_tb);
        
        ConexionSQL cn = new ConexionSQL();
        
        Connection cnx = null;
        Statement stm = null;
        ResultSet rs = null;
        
        try {
            cnx = cn.Conectar();
            stm = cnx.createStatement();
            
            rs = stm.executeQuery("sp_ListarPersona1");
            
            int nc = rs.getMetaData().getColumnCount();
            
            for (int i = 1; i <= nc; i++)
                modelo_tb.addColumn(rs.getMetaData().getColumnName(i));
            
            while (rs.next()) {
                Object[] arr_filas = new Object[nc];
                
                for (int i = 0; i < nc; i++)
                    arr_filas[i] = rs.getObject(i + 1);
                
                modelo_tb.addRow(arr_filas);
            }
        } catch (SQLException e){
            
        }finally{
            try {
                if (rs != null) rs.close();
                
                if (stm != null) stm.close();
                
                if (cnx != null) cnx.close();
            } catch (SQLException e2) {
            
            }
        }
        
        tb_persona1.setRowHeight(20);
        
        DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        
        TableColumnModel arr_col = tb_persona1.getColumnModel();
        arr_col.getColumn(0).setCellRenderer(alinear);
        arr_col.getColumn(0).setPreferredWidth(120);
        
        arr_col.getColumn(1).setPreferredWidth(300);
        
        arr_col.getColumn(2).setCellRenderer(alinear);
        arr_col.getColumn(2).setPreferredWidth(180);
        
        scp = new JScrollPane(tb_persona1);
        
        this.add(scp);
    }
    
    public static void main(String[] args) {
        AppBDCaso2 caso2 = new AppBDCaso2();
        caso2.setVisible(true);
    }
}