
package CasosGuia1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;


public class Caso3 extends JFrame implements ActionListener {
    
    // Controles 
        private JMenuBar mb_principal;
        private JMenu mn_casos;
        private JMenuItem mi_caso1, mi_caso2, mi_caso3;
        private JSeparator separador1;
        
        private JMenuItem mi_salir;
        
        private JDesktopPane dsk_escritorio;
     // Constructor
    public Caso3() {
        super();
        
        Configurar();
        Iniciar();
    }

    
    private void Configurar() {
        this.setSize(900, 900);
        this.setTitle("DS - SENATI: VECTOR ");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void Iniciar(){
        dsk_escritorio = new  JDesktopPane();
        mb_principal = new JMenuBar();
        
        mn_casos = new JMenu (" CASOS ");
        
        mi_caso1 = new JMenuItem("Ver caso 1");
        mi_caso1.addActionListener(this);
    
        mi_caso2 = new JMenuItem("Ver csao 2");
        mi_caso2.addActionListener(this);
        
        separador1 = new JSeparator();
        
        mi_salir = new JMenuItem("Salir de la Aplicacion");
        mi_salir.addActionListener(this);
        
        mn_casos.add(mi_caso1);
        mn_casos.add(mi_caso2);
        mn_casos.add(separador1);
        mn_casos.add(mi_salir);
        
        mb_principal.add(mn_casos);
        
        this.setJMenuBar((mb_principal));
        
        this.add(dsk_escritorio);
    }
    
    private void VerificarFrm(JInternalFrame iframe) {
        JInternalFrame[] arr_iframe = dsk_escritorio.getAllFrames();
        
        boolean marca = false;
        
        for (JInternalFrame frm: arr_iframe) {
            if (iframe.getClass().isInstance(frm)){
            JOptionPane.showMessageDialog(null,"Ventana abierta");
            marca = true;
            break;
        }
        }
        if (marca == false) {
            dsk_escritorio.add(iframe);
            
            iframe.setLocation(
            (dsk_escritorio.getWidth() - iframe.getWidth())/2,
            (dsk_escritorio.getHeight() - iframe.getHeight())/2
            );
            
            iframe.show();
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mi_caso1) {
            Caso1 caso1 = new Caso1();
            
            VerificarFrm(caso1);
        } else if (e.getSource() == mi_caso2) {
            Caso2 caso2 = new Caso2();
            VerificarFrm(caso2); 
        } else if (e.getSource() == mi_salir) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
    
        Caso3 caso3 = new Caso3();
        caso3.setVisible(true);
    }
    
}
