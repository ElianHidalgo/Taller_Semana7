import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtFId.getText());
                String nombre = txtFNombre.getText();
                String rango = cboRango.getSelectedItem().toString();
                String constelacion = cboConstelacion.getSelectedItem().toString();
                int nivelPoder = (int) spnNivelPoder.getValue();
                String mision = txtFMision.getText();
                int dificultad = cboDificultad.getItemCount();
                int recompensa = (int) spnRecompensa.getValue();
                CaballeroMision caballero = new CaballeroMision(id, nombre, rango, constelacion, nivelPoder, mision, dificultad, recompensa);
                gestor.registrarCaballero(caballero);
            }
        });
        btnInforme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtFIdInforme.getText());
                gestor.generarInforme(id);
            }
        });
    }
}
