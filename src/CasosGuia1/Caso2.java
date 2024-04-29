/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasosGuia1;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Alumno-ETI
 */
public class Caso2 extends JFrame{
    //Atributos de clase (Controller)
    private JLabel lbl_texto1, lbl_texto2, lbl_texto3, lbl_texto4, lbl_titulo;
    private JTextField txt_valor_x, txt_valor_y;
    private JTextArea txt_reporte;
    private JScrollPane scr_reporte;
    private JButton btn_aceptar, btn_cerrar;
    
    // Constructor (Inicializar la clase)
    public Caso2() {
        super();
        Configurar();
        Iniciar();
    }

    // Metodo para configurar la ventana 
    private void Configurar() {
        this.setSize(700, 400);
        this.setTitle("DS - SENATI: ");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Metodo para configurar los controles
    private void Iniciar() {
        lbl_titulo = new JLabel();
        lbl_titulo.setText("VECTORES");
        lbl_titulo.setFont(new Font("Calibri", Font.BOLD, 24));
        lbl_titulo.setForeground(new Color(255, 38, 235));
        lbl_titulo.setBounds(50, 20, 150, 27);
        
        lbl_texto4 = new JLabel();
        lbl_texto4.setText("Elaborado por: SACA MACHACA CESAR FERNANDO");
        lbl_texto4.setFont(new Font("Calibri", Font.BOLD, 24));
        lbl_texto4.setForeground(new Color(255, 38, 235));
        lbl_texto4.setBounds(50, 40, 850, 27);
        
        lbl_texto1 = new JLabel();
        lbl_texto1.setText("Valor X");
        lbl_texto1.setFont(new Font("Calibri", Font.BOLD, 14));
        lbl_texto1.setForeground(new Color(38, 199, 255));
        lbl_texto1.setBounds(50, 70, 150, 27);
        
        lbl_texto2 = new JLabel();
        lbl_texto2.setText("Valor Y");
        lbl_texto2.setFont(new Font("Calibri", Font.BOLD, 14));
        lbl_texto2.setForeground(new Color(38, 199, 255));
        lbl_texto2.setBounds(50, 100, 150, 27);
        
        txt_valor_x = new JTextField();
        txt_valor_x.setFont(new Font("Calibri", Font.BOLD, 14));
        txt_valor_x.setForeground(new Color(255, 38, 235));
        txt_valor_x.setBounds(170, 70, 150, 27);
        
        txt_valor_y = new JTextField();
        txt_valor_y.setFont(new Font("Calibri", Font.BOLD, 24));
        txt_valor_y.setForeground(new Color(255, 38, 235));
        txt_valor_y.setBounds(170, 100, 150, 27);
        
        lbl_texto3 = new JLabel();
        lbl_texto3.setText("Resultados");
        lbl_texto3.setFont(new Font("Calibri", Font.BOLD, 14));
        lbl_texto3.setForeground(new Color(38, 199, 255));
        lbl_texto3.setBounds(50, 140, 150, 27);
        
        txt_reporte = new JTextArea();
        txt_reporte.setFont(new Font("Calibri", Font.BOLD, 14));
        txt_reporte.setEditable(false);
        
        //scr_reporte = new JScrollPane();
        //scr_reporte.setFont(new Font("Calibri", Font.BOLD, 14));
        //scr_reporte.setEditable(false);
        
        btn_aceptar = new JButton();
        btn_aceptar.setText("Aceptar");
        btn_aceptar.setBounds(25, 230, 100, 25);
        
        btn_cerrar = new JButton();
        btn_cerrar.setText("CERRAR");
        btn_cerrar.setBounds(150, 230, 100, 25);
        // 2.   Agregar el control al ancahoJFrame
        this.add(lbl_titulo);
        this.add(lbl_texto1);
        this.add(lbl_texto2);
        this.add(lbl_texto3);
        this.add(txt_valor_x);
        this.add(txt_valor_y);
        this.add(btn_aceptar);
        this.add(btn_cerrar);
        this.add(lbl_texto4);
        
    }
    
    public static void main(String[] args) {
        Caso2 caso2 = new Caso2();
        caso2.setVisible(true);
    }
}
