import java.util.ArrayList;
import java.util.List;

public class GestorMisiones {
    // Estructura de datos: ArrayList
    private ArrayList<CaballeroMision> caballeros;

    public GestorMisiones() {
        this.caballeros = new ArrayList<>();
    }

    public boolean registrarCaballero(CaballeroMision nuevoCaballero) {
        for (CaballeroMision c : caballeros) {
            if (c.getIdCaballero() == nuevoCaballero.getIdCaballero()) {
                return false;
            }
        }
        this.caballeros.add(nuevoCaballero);
        return true;
    }

    public boolean modificarCaballero(int id, String nombre, String rango, String constelacion, int nivelPoder, String mision, int dificultad, double recompensa) {
        for (CaballeroMision c : caballeros) {
            if (c.getIdCaballero() == id) {
                c.setNombre(nombre);
                c.setRango(rango);
                c.setConstelacion(constelacion);
                c.setNivelPoder(nivelPoder);
                c.setMisionAsignada(mision);
                c.setDificultadMision(dificultad);
                c.setRecompensaBase(recompensa);
                return true;
            }
        }
        return false;
    }

    public String listarCaballeros() {
        if (this.caballeros.isEmpty()) {
            return "No hay caballeros registrados en el Santuario.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("================================================================================================\n");
        sb.append(String.format("| %-4s | %-15s | %-8s | %-15s | %-5s | %-12s |\n",
                "ID", "NOMBRE", "RANGO", "CONSTELACIÓN", "PODER", "RECOMPENSA"));
        sb.append("================================================================================================\n");

        for (CaballeroMision c : this.caballeros) {
            sb.append(String.format("| %-4d | %-15s | %-8s | %-15s | %-5d | %-12.2f |\n",
                    c.getIdCaballero(),
                    c.getNombre(),
                    c.getRango(),
                    c.getConstelacion(),
                    c.getNivelPoder(),
                    c.getRecompensaBase()));
        }
        sb.append("================================================================================================\n");
        return sb.toString();
    }


    public String generarInforme(int id) {
        for (CaballeroMision c : caballeros) {
            if (c.getIdCaballero() == id) {
                return String.format(
                        "--- INFORME FINANCIERO ---\n" +
                                "Nombre: %s (Rango: %s, Constelación: %s)\n" +
                                "Nivel de Poder: %d\n" +
                                "Misión Asignada: %s\n" +
                                "Recompensa Base: %.2f\n" +
                                "Aporte al Fondo del Santuario (10%%): %.2f\n" +
                                "Impuesto del Reino de Atena: %.2f\n" +
                                "Recompensa Neta a Recibir: %.2f\n",
                        c.getNombre(), c.getRango(), c.getConstelacion(),
                        c.getNivelPoder(), c.getMisionAsignada(),
                        c.getRecompensaBase(), c.getAporteFondoSantuario(),
                        c.getImpuestoReinoAtena(), c.getRecompensaNeta());
            }
        }
        return "Caballero con ID " + id + " no encontrado para generar informe.";
    }
}
