package CasosGuia3;

import fuente.Personal;
import fuente.ConexionMySQL;
// import fuente.ConexionSQL;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

public class AppPersonal extends JFrame implements ActionListener {

    private JLabel lbl_titulo, lbl_1, lbl_2, lbl_3, lbl_4, lbl_5, lbl_6, lbl_7;

    private JTextField txt_dni, txt_nombre, txt_app, txt_apm, txt_sueldo;

    private JDateChooser dc_fn;

    private JRadioButton rbt_genero_f, rbt_genero_m;
    private ButtonGroup bg_genero;

    private JButton btn_nuevo, btn_agregar, btn_editar, btn_borrar, btn_cerrar;

    private JTable tb_persona1;
    private JScrollPane scr_personal;

    private ConexionMySQL cn = new ConexionMySQL();

    public AppPersonal() {
        super();

        ConfigurarVentana();
        IniciarControles();
        LimpiarDatos();
        MostrarDatos();
    }

    private void ConfigurarVentana() {
        this.setTitle("SENATI - ETI");
        this.setSize(430, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void IniciarControles() {
        lbl_titulo = new JLabel();
        lbl_titulo.setText("MANTENIMIENTO DE DATOS");
        lbl_titulo.setFont(new Font("Calibri", Font.BOLD, 20));
        lbl_titulo.setForeground(Color.BLUE);
        lbl_titulo.setBounds(10, 15, 300, 25);

        lbl_1 = new JLabel();
        lbl_1.setText("N mero DNI");
        lbl_1.setBounds(20, 50, 120, 25);

        txt_dni = new JTextField();
        txt_dni.setBounds(150, 50, 80, 25);

        lbl_2 = new JLabel();
        lbl_2.setText("Apellido Paterno");
        lbl_2.setBounds(20, 80, 110, 25);

        txt_app = new JTextField();
        txt_app.setBounds(20, 110, 110, 25);

        lbl_3 = new JLabel();
        lbl_3.setText("Apellido Materno");
        lbl_3.setBounds(150, 80, 110, 25);

        txt_apm = new JTextField();
        txt_apm.setBounds(150, 110, 110, 25);

        lbl_4 = new JLabel();
        lbl_4.setText("Nombre");
        lbl_4.setBounds(280, 80, 110, 25);

        txt_nombre = new JTextField();
        txt_nombre.setBounds(280, 110, 110, 25);

        lbl_5 = new JLabel();
        lbl_5.setText("G nero");
        lbl_5.setBounds(20, 140, 110, 25);

        bg_genero = new ButtonGroup();

        rbt_genero_f = new JRadioButton("Fem.");
        rbt_genero_f.setBounds(20, 170, 60, 25);
        bg_genero.add(rbt_genero_f);

        rbt_genero_m = new JRadioButton("Masc.");
        rbt_genero_m.setBounds(80, 170, 60, 25);
        bg_genero.add(rbt_genero_m);

        lbl_6 = new JLabel();
        lbl_6.setText("Fecha Nacimiento");
        lbl_6.setBounds(150, 140, 110, 25);

        dc_fn = new JDateChooser();
        dc_fn.setDateFormatString("dd/MM/yyyy");
        dc_fn.setBounds(150, 170, 110, 25);

        lbl_7 = new JLabel();
        lbl_7.setText("Sueldo");
        lbl_7.setBounds(280, 140, 110, 25);

        txt_sueldo = new JTextField();
        txt_sueldo.setBounds(280, 170, 110, 25);
        
        btn_nuevo = new JButton();
        btn_nuevo.setText("NUEVO");
        btn_nuevo.setBounds(10, 210, 90, 25);
        btn_nuevo.addActionListener(this);

        btn_agregar = new JButton();
        btn_agregar.setText("AGREGAR");
        btn_agregar.setBounds(110, 210, 90, 25);
        btn_agregar.addActionListener(this);

        btn_editar = new JButton();
        btn_editar.setText("EDITAR");
        btn_editar.setBounds(210, 210, 90, 25);
        btn_editar.addActionListener(this);

        btn_borrar = new JButton();
        btn_borrar.setText("BORRAR");
        btn_borrar.setBounds(310, 210, 90, 25);
        btn_borrar.addActionListener(this);

        btn_cerrar = new JButton();
        btn_cerrar.setText("CERRAR");
        btn_cerrar.setFont(new Font("Consolas", Font.BOLD, 14));
        btn_cerrar.setBackground(Color.RED);
        btn_cerrar.setForeground(Color.WHITE);
        btn_cerrar.setBounds(110, 420, 180, 30);
        btn_cerrar.addActionListener(this);

        tb_persona1 = new JTable();

        tb_persona1.setRowHeight(20);
        tb_persona1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        scr_personal = new JScrollPane(tb_persona1);
        scr_personal.setBounds(10, 250, 390, 150);

        // Agregar los controles al JFrame
        this.add(lbl_titulo);
        this.add(lbl_1);
        this.add(txt_dni);
        this.add(lbl_2);
        this.add(txt_app);
        this.add(lbl_3);
        this.add(txt_apm);
        this.add(lbl_4);
        this.add(txt_nombre);
        this.add(lbl_5);
        this.add(rbt_genero_f);
        this.add(rbt_genero_m);
        this.add(lbl_6);
        this.add(dc_fn);
        this.add(lbl_7);
        this.add(txt_sueldo);
        this.add(btn_nuevo);
        this.add(btn_agregar);
        this.add(btn_editar);
        this.add(btn_borrar);
        this.add(btn_cerrar);
        this.add(scr_personal);

        ControladorTxt ctxt = new ControladorTxt();

        txt_dni.addKeyListener(ctxt);
        txt_app.addKeyListener(ctxt);
        txt_apm.addKeyListener(ctxt);
        txt_nombre.addKeyListener(ctxt);

        ControladorClick click = new ControladorClick();

        tb_persona1.addMouseListener(click);
    }

    private void MostrarDatos() {
        DefaultTableModel md_tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        md_tabla.setRowCount(0);

        Connection cnx = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            cnx = cn.Conectar();
            stm = cnx.createStatement();
            
            rs = stm.executeQuery("select * from tb_persona1 order by ap_paterno asc");

            int nc = rs.getMetaData().getColumnCount();

            for (int i = 1; i <= nc; i++) {
                md_tabla.addColumn(rs.getMetaData().getColumnName(i));
            }

            while (rs.next()) {
                Object[] arr_filas = new Object[nc];

                for (int i = 0; i < nc; i++) {
                    arr_filas[i] = rs.getObject(i + 1);
                }

                md_tabla.addRow(arr_filas);
            }

        } catch (SQLException e1) {

        } finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
                if (cnx != null) cnx.close();
            } catch (SQLException e2) {

            }
        }

        tb_persona1.setModel(md_tabla);
    }

    private class ControladorTxt implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getSource() == txt_dni && txt_dni.getText().length() == 8) {
                e.consume();
            } else if (e.getSource() == txt_app && txt_app.getText().length() == 25) {
                e.consume();
            } else if (e.getSource() == txt_apm && txt_apm.getText().length() == 25) {
                e.consume();
            } else if (e.getSource() == txt_nombre && txt_nombre.getText().length() == 25) {
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class ControladorClick extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            int num_fila = tb_persona1.getSelectedRow();
            
            txt_dni.setEditable(false);

            String dni = (String) tb_persona1.getValueAt(num_fila, 0);
            String app = (String) tb_persona1.getValueAt(num_fila, 1);
            String apm = (String) tb_persona1.getValueAt(num_fila, 2);
            String nombre = (String) tb_persona1.getValueAt(num_fila, 3);
            String gen = (String) tb_persona1.getValueAt(num_fila, 4);
            Date fn = (Date) tb_persona1.getValueAt(num_fila, 5);
            Float sue = (Float)tb_persona1.getValueAt(num_fila, 6);
            
            txt_dni.setText(dni);
            txt_app.setText(app);
            txt_apm.setText(apm);
            txt_nombre.setText(nombre);
            
            if (gen.equals("M")) rbt_genero_m.setSelected(true);
            if (gen.equals("F")) rbt_genero_f.setSelected(true);
            
            dc_fn.setDate(fn);
            
            txt_sueldo.setText(String.valueOf(sue));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn_cerrar) {
            dispose();
        } else if (e.getSource() == btn_nuevo) {
            LimpiarDatos();
        } else {
            if (txt_dni.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese número de DNI");
                txt_dni.requestFocus();
                return;
            }
            
            if (txt_app.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Ingrese apellido paterno");
                txt_app.requestFocus();
                return;
            }
            
            if (txt_apm.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Ingrese apellido materno");
                txt_apm.requestFocus();
                return;
            }
            
            if (txt_nombre.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Ingrese nombre");
                txt_nombre.requestFocus();
                return;
            }
            
            if (txt_sueldo.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Ingrese sueldo");
                txt_sueldo.requestFocus();
                return;
            }
            
            if (rbt_genero_f.isSelected() == false){
                if(rbt_genero_m.isSelected() == false)
                JOptionPane.showMessageDialog(null, "Seleccione un genero");
                return;
            }
            
            Personal personal = new Personal();

            personal.setDni(txt_dni.getText());
            personal.setAp_paterno(txt_app.getText());
            personal.setAp_materno(txt_apm.getText());
            personal.setNombre(txt_nombre.getText());
            
            if(rbt_genero_f.isSelected()) personal.setGenero('f');
            if(rbt_genero_m.isSelected()) personal.setGenero('m');
            
            Date fec1 = dc_fn.getDate();
            long fec2 = fec1.getTime();
            java.sql.Date fec3 = new java.sql.Date(fec2);
            
            personal.setFecha_nacimineto(fec3);
            
            personal.setSueldo(Float.parseFloat(txt_sueldo.getText()));
            
            Connection cnx = null;
            
            java.sql.PreparedStatement pstm = null;
            
            try {
                cnx = cn.Conectar();

                String cad_sql = "";

                if (e.getSource() == btn_agregar) {
                    cad_sql = "insert into tb_persona1 values (?, ?, ?, ?, ?, ?, ?)";
                    
                    pstm = cnx.prepareStatement(cad_sql);

                    pstm.setString(1, personal.getDni());
                    pstm.setString(2, personal.getAp_paterno());
                    pstm.setString(3, personal.getAp_materno());
                    pstm.setString(4, personal.getNombre());
                    pstm.setString(5, Character.toString(personal.getGenero()));
                    pstm.setDate(6, (java.sql.Date) personal.getFecha_nacimineto());
                    pstm.setFloat(7, personal.getSueldo());
                    
                    pstm.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Personal Registrado");
                } else if (e.getSource() == btn_editar) {
                    cad_sql = "update tb_persona1 set ap_paterno = ?, ap_materno = ?, nombre = ?, genero = ?, fecha_nacimiento = ?, sueldo = ? where dni = ?";

                    pstm = cnx.prepareStatement(cad_sql);
                    
                    
                    pstm.setString(1, personal.getAp_paterno());
                    pstm.setString(2, personal.getAp_materno());
                    pstm.setString(3, personal.getNombre());
                    pstm.setString(4, Character.toString(personal.getGenero()));
                    pstm.setDate(5, (java.sql.Date)personal.getFecha_nacimineto());
                    pstm.setFloat(6, personal.getSueldo());
                    pstm.setString(7, personal.getDni());

                    pstm.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Personal Actualizado");
                } else if (e.getSource() == btn_borrar) {
                    int opc = JOptionPane.showConfirmDialog(null,
                            " Seguro de borrar el registro?",
                            "SENATI", JOptionPane.YES_NO_OPTION);

                    if (opc == JOptionPane.YES_OPTION) {
                        cad_sql = "delete from tb_persona1 where dni = ?";

                        pstm = cnx.prepareStatement(cad_sql);

                        pstm.setString(1, personal.getDni());

                        pstm.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Personal Eliminado");
                    }
                }

                MostrarDatos();
            } catch (SQLException e1) {

            } finally {
                try {
                    if (pstm != null) pstm.close();
                    if (cnx != null) cnx.close();

                } catch (SQLException e2) {

                }
            }

            LimpiarDatos();
        }
    }

    private void LimpiarDatos() {
        txt_dni.setEditable(true);

        tb_persona1.clearSelection();

        txt_dni.setText("");
        txt_app.setText("");
        txt_apm.setText("");
        txt_nombre.setText("");
        bg_genero.clearSelection();
        dc_fn.setDate(null);
        txt_sueldo.setText("");
        
        txt_dni.requestFocus();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha;
        try {
            fecha = sdf.parse("2000-01-01");
            dc_fn.setDate(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(AppPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }

        txt_dni.requestFocus();
    }
    
    public static void main(String[] args) {
        AppPersonal app_per = new AppPersonal();
        app_per.setVisible(true);
    }
}
