import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTabbedPane JTabbedPane1;
    private JTextField txtPlaca;
    private JComboBox cboMarca;
    private JTextField txtModelo;
    private JSpinner spiYear;
    private JButton btnLimpiar;
    private JButton btnAgregar;
    private JTextArea txtListar;
    private JButton btnPagar;
    private JButton btnListar;
    private JLabel lblResultado;
    private JComboBox cboBuscar;
    private JTextArea txtBuscar;
    private JButton btnBuscar;
    private ColaAutos agencia = new ColaAutos();


    public Ventana(){
        spiYear.setModel(new SpinnerNumberModel(2025, 1950, 2026, 1));
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPlaca.setText("");
                txtModelo.setText("");
                cboMarca.setSelectedIndex(0);
                spiYear.setValue(2025); ;
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();
                String marca = cboMarca.getSelectedItem().toString();
                String modelo = txtModelo.getText();
                int year = Integer.parseInt(spiYear.getValue().toString());
                Auto auto = new Auto(placa, marca, modelo, year);
                agencia.encolar(auto);
                JOptionPane.showMessageDialog(null, "Auto agregado correctamente");
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText(agencia.toString());
            }
        });
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Auto pagado = agencia.desencolar();
                    float valor;
                    if (pagado.getYear() < 2000){
                        valor = 50.25f;
                    }else{
                        valor = 100.99f;
                    }
                    lblResultado.setText(pagado.toString() + " PAGÓ: " + valor);
                    txtListar.setText(agencia.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = cboBuscar.getSelectedItem().toString();

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
}
