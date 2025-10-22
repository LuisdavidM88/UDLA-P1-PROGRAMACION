import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ventana {
    private JPanel principal;
    private JTextField txtNombre;
    private JComboBox cboTipo;
    private JSpinner spiPrioridad;
    private JButton btnRegistrar;
    private JTextArea txtListar;
    private JButton btnAtender;

    private Banco bbarrio = new Banco();

    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String tipo = cboTipo.getSelectedItem().toString();
                int p = Integer. parseInt(spiPrioridad.getValue().toString());
                Cliente c = new Cliente(nombre, tipo, p);
                bbarrio.encolar(c);
                Listar();
            }
        });
        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Cliente c =bbarrio.desencolar();
                    Listar();
                    JOptionPane.showMessageDialog(null, c.toString()+"Fue atendido con exito.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void Listar (){
        List<Cliente> resultado=bbarrio.listarClientes();
        Collections.sort(resultado);
        txtListar.setText("");
        for(Cliente c: resultado){
            txtListar.append(c.toString());
        }
    }


}
