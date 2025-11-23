import java.util.ArrayList;
import java.util.List;

public class GestorMisiones {
    // Estructura de datos: ArrayList
    private ArrayList<CaballeroMision> caballeros;

    public GestorMisiones() {
        this.caballeros = new ArrayList<>();
    }

    // 1. Registrar Caballero (Req. 1)
    public boolean registrarCaballero(CaballeroMision nuevoCaballero) {
        // Validación de ID único (requiere búsqueda O(n))
        for (CaballeroMision c : caballeros) {
            if (c.getIdCaballero() == nuevoCaballero.getIdCaballero()) {
                System.out.println("ERROR: El ID " + nuevoCaballero.getIdCaballero() + " ya está registrado.");
                return false;
            }
        }
        this.caballeros.add(nuevoCaballero);
        return true;
    }

    // 2. Modificar Datos (Req. 2)
    public boolean modificarCaballero(int id, String nuevoNombre, String nuevoRango, double nuevaRecompensa) {
        // Búsqueda lineal O(n) por ID
        for (CaballeroMision c : caballeros) {
            if (c.getIdCaballero() == id) {
                // Actualizar los datos
                c.setNombre(nuevoNombre);
                c.setRango(nuevoRango);
                // Si la recompensa cambia, los cálculos se actualizan automáticamente en el setter
                c.setRecompensaBase(nuevaRecompensa);
                return true;
            }
        }
        return false;
    }

    public List<CaballeroMision> listarCaballeros() {
        return this.caballeros;
    }


    public String generarInforme(int id) {
        // Búsqueda lineal O(n) por ID
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
