/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasosGuia1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Alumno-ETI
 */
public class Caso1 extends JInternalFrame implements ActionListener {

    //Atributos de clase (Controller)
    private JLabel lbl_texto1;
    private JLabel lbl_texto2;
    private JTextField txt_alumno;
    private JComboBox cbo_programa;
    private JButton btn_aceptar;
    private JButton btn_cerrar;

    // Constructor (Inicializar la clase)
    public Caso1() {
        super();
        Configurar();
        Iniciar();
    }

    // Metodo para configurar la ventana 
    private void Configurar() {
        this.setSize(400, 300);
        this.setTitle("DS - SENATI");
        //this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // Metodo para configurar los controles
    private void Iniciar() {
        // 1.   Configuracion de cada control
        lbl_texto1 = new JLabel();
        lbl_texto1.setText("Ingrese nombre");
        lbl_texto1.setBounds(15, 15, 100, 22);

        txt_alumno = new JTextField();
        txt_alumno.setBounds(15, 40, 100, 22);

        lbl_texto2 = new JLabel();
        lbl_texto2.setText("Seleccione programa");
        lbl_texto2.setBounds(15, 70, 140, 22);

        cbo_programa = new JComboBox();
        cbo_programa.setBounds(15, 100, 120, 22);

        String[] arr_programa = {"ofimatica", "redes", "CiberSeguridad", "Sistemas", "Desarrollo app Movil", "IA"};
        for (String programa : arr_programa) {
            cbo_programa.addItem(programa);
        }

        cbo_programa.setSelectedIndex(-1);

        btn_aceptar = new JButton();
        btn_aceptar.setText("Aceptar");
        btn_aceptar.setBounds(25, 150, 100, 25);
        btn_aceptar.addActionListener(this);
        
        btn_cerrar = new JButton();
        btn_cerrar.setText("CERRAR");
        btn_cerrar.setBounds(150, 150, 100, 25);
        btn_cerrar.addActionListener(this);
        // 2.   Agregar el control al JFrame
        this.add(lbl_texto1);
        this.add(txt_alumno);
        this.add(lbl_texto2);
        this.add(cbo_programa);
        this.add(btn_aceptar);
        this.add(btn_cerrar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_aceptar) {
            if (txt_alumno.getText(). length() == 0){
                JOptionPane.showMessageDialog(null, "Falta ingresar nombre");
                txt_alumno.requestFocus();
                return;
            }
            if (cbo_programa.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Falta ingresar programa");
                cbo_programa.requestFocus();
                return;
            }
            
            final float TIPO_CAMBIO = 3.73f; //casteo
         
         float[] arr_costo_d = {85.34f, 132.49f, 34.31f, 25.81f, 63.74f, 52.92f};
             String alumno = txt_alumno.getText();
             String programa = (String)cbo_programa.getSelectedItem();
             float costo_d = arr_costo_d[cbo_programa.getSelectedIndex()];
             float Costo_soles = TIPO_CAMBIO * arr_costo_d[cbo_programa.getSelectedIndex()];
             
             String reporte = "";
             reporte += "Bienvenido(a)\n";
             reporte += "Alumno(a): " + alumno + "\n" ;
             reporte += "Programa: " + programa + "\n";
             reporte += "Costo Dolares: " + costo_d + "\n" ;
             reporte += "Costo Soles: " + Costo_soles + "\n";
             JOptionPane.showMessageDialog(null, reporte);
             
        } else if (e.getSource() == btn_cerrar) {
            //System.exit(0);
            int c = JOptionPane.showConfirmDialog(null,
                    "¿Seguro de cerrar la app?",
                    "Salir del sistema", JOptionPane.YES_NO_OPTION);
            
            if (c == JOptionPane.YES_OPTION) {
                dispose();
            }            
        }
    }

    public static void main(String[] args) {
        Caso1 caso1 = new Caso1();
        caso1.setVisible(true);
    }
}
