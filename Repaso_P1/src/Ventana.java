import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

// Interfaz gráfica (Swing) para registrar y ajustar personajes de anime
public class Ventana {
    private JPanel principal;
    private JTextField txtID;
    private JButton btnIngreso;
    private JTextField txtNombre;
    private JTextField txtUniverso;
    private JComboBox cboHabilidad;
    private JButton btnAjustarPoder;
    private JTextArea txtResumen;
    private JTextArea txtAjustes;
    private JSpinner spiNivelPoder;

    // Cola de prioridad donde se almacenan los personajes
    ColaPersonajeAnime personajes = new ColaPersonajeAnime();

    // Constructor: define la lógica de los botones
    public Ventana() {

        // Acción del botón "Ingreso"
        btnIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener valores de los campos
                int id = Integer.parseInt(txtID.getText());
                String nombre = txtNombre.getText();
                String universo = txtUniverso.getText();
                int nivelPoder = Integer.parseInt(spiNivelPoder.getValue().toString());
                String habilidad = cboHabilidad.getSelectedItem().toString();

                // Crear objeto PersonajeAnime con los datos del formulario
                PersonajeAnime personaje = new PersonajeAnime(id, nombre, universo, nivelPoder, habilidad);

                // Añadirlo a la cola
                personajes.anadir(personaje);

                // Limpiar área de texto y volver a mostrar la lista ordenada
                txtResumen.setText("");
                List<PersonajeAnime> ordenados = personajes.listarPersonajes();
                Collections.sort(ordenados);

                // Usar la variable del bucle (p) y agregar salto de línea
                for (PersonajeAnime p : ordenados){
                    txtResumen.append(p.toString() + "\n");
                }

                JOptionPane.showMessageDialog(principal, "Personaje ingresado con éxito");
            }
        });

        // Acción del botón "Ajustar Poder"
        btnAjustarPoder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener datos actuales de los campos
                int id = Integer.parseInt(txtID.getText());
                String nombre = txtNombre.getText();
                String universo = txtUniverso.getText();
                int nivelPoder = Integer.parseInt(spiNivelPoder.getValue().toString());
                String habilidad = cboHabilidad.getSelectedItem().toString();

                // Crear nuevo personaje
                PersonajeAnime personaje = new PersonajeAnime(id, nombre, universo, nivelPoder, habilidad);

                // Ajuste de poder según universo
                if (universo.equals("Dragon Ball")) {
                    personaje.setNivelPoder((nivelPoder + nivelPoder * 0.2));   // +20%
                } else if (universo.equals("Naruto")) {
                    personaje.setNivelPoder((nivelPoder + nivelPoder * 0.15));  // +15%
                }

                // Añadir nuevamente a la cola (versión mejorada)
                personajes.anadir(personaje);

                // Mostrar resultados en txtAjustes
                txtAjustes.setText("");
                List<PersonajeAnime> ordenados = personajes.listarPersonajes();
                Collections.sort(ordenados);
                for (PersonajeAnime p : ordenados){
                    txtAjustes.append(p.toString() + "\n");
                }

                JOptionPane.showMessageDialog(principal, "Poder del personaje ajustado con éxito");
            }
        });
    }

    // Método principal para ejecutar la interfaz
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana Personajes Anime");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
