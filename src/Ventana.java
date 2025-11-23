import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JButton btnRegistrar;
    private JTextField txtFId;
    private JTextField txtFNombre;
    private JComboBox cboRango;
    private JComboBox cboConstelacion;
    private JSpinner spnNivelPoder;
    private JTextField txtFMision;
    private JComboBox cboDificultad;
    private JSpinner spnRecompensa;
    private JButton btnEditar;
    private JButton btnListar;
    private JButton btnInforme;
    private JTextArea txtAreaListar;
    private JTextArea txtAreaInforme;
    private JTextField txtFIdInforme;
    GestorMisiones gestor = new GestorMisiones();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(txtFId.getText());
                    String nombre = txtFNombre.getText();
                    String rango = cboRango.getSelectedItem().toString();
                    String constelacion = cboConstelacion.getSelectedItem().toString();
                    int nivelPoder = (int) spnNivelPoder.getValue();
                    String mision = txtFMision.getText();
                    int dificultad = cboDificultad.getItemCount();
                    double recompensa = (int) spnRecompensa.getValue();
                    if (nombre.trim().isEmpty() || mision.trim().isEmpty()) {
                        throw new InputMismatchException("Nombre y Misión no pueden estar vacíos.");
                    }
                    CaballeroMision caballero = new CaballeroMision(id, nombre, rango, constelacion, nivelPoder, mision, dificultad, recompensa);
                    if (gestor.registrarCaballero(caballero)) {
                        JOptionPane.showMessageDialog(null, "Caballero registrado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: El ID ya existe.");
                    }
                    gestor.registrarCaballero(caballero);
                } catch (NumberFormatException | InputMismatchException ex){
                    JOptionPane.showMessageDialog(null, "Error en los datos de entrada: " + ex.getMessage())    ;
                }
            }
        });
        btnInforme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAreaInforme.setText("");
                int id = Integer.parseInt(txtFIdInforme.getText());
                txtAreaInforme.setText(gestor.generarInforme(id));
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAreaListar.setText(gestor.listarCaballeros());
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtFId.getText());
                    String nombre = txtFNombre.getText();
                    String rango = cboRango.getSelectedItem().toString();
                    String constelacion = cboConstelacion.getSelectedItem().toString();
                    int nivelPoder = (Integer) spnNivelPoder.getValue();
                    String mision = txtFMision.getText();
                    int dificultad = Integer.parseInt(cboDificultad.getSelectedItem().toString());
                    double recompensa = Double.parseDouble(spnRecompensa.getValue().toString());

                    if (gestor.modificarCaballero(id, nombre, rango, constelacion, nivelPoder, mision, dificultad, recompensa)) {
                        JOptionPane.showMessageDialog(principal, "Caballero con ID " + id + " modificado con éxito.", "Modificación OK", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(principal, "Error: Caballero con ID " + id + " no encontrado.", "Error de Edición", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException | InputMismatchException ex) {
                    JOptionPane.showMessageDialog(principal, "Error en los datos de entrada para edición: " + ex.getMessage(), "Error de Formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
