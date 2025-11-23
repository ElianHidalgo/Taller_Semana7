public class CaballeroMision {
    private int idCaballero;
    private String nombre;
    private String rango;
    private String constelacion;
    private int nivelPoder;
    private String misionAsignada;
    private int dificultadMision;
    private double recompensaBase;

    private double aporteFondoSantuario;
    private double impuestoReinoAtena;
    private double recompensaNeta;


    public CaballeroMision(int idCaballero, String nombre, String rango, String constelacion, int nivelPoder,
                           String misionAsignada, int dificultadMision, double recompensaBase) {
        this.idCaballero = idCaballero;
        this.nombre = nombre;
        this.rango = rango;
        this.constelacion = constelacion;
        this.nivelPoder = nivelPoder;
        this.misionAsignada = misionAsignada;
        this.dificultadMision = dificultadMision;
        this.recompensaBase = recompensaBase;

        calcularDatosFinancieros();
    }



    // --- Métodos de Cálculo ---

    public void calcularDatosFinancieros() {
        this.aporteFondoSantuario = calcularAporte();
        this.impuestoReinoAtena = calcularImpuesto();
        this.recompensaNeta = this.recompensaBase - this.aporteFondoSantuario - this.impuestoReinoAtena;
    }

    private double calcularAporte() {
        return this.recompensaBase * 0.10;
    }

    private double calcularImpuesto() {
        double impuesto = 0.0;
        double recompensa = this.recompensaBase;

        if (recompensa <= 100000) {
            impuesto = 0.0;
        } else if (recompensa <= 200000) {
            impuesto = (recompensa - 100000) * 0.12;
        } else if (recompensa> 200000 && recompensa <= 400000) {
            impuesto = 100000 * 0.12;
            impuesto += (recompensa - 200000) * 0.25;
        } else {
            impuesto = (100000 * 0.12) + (200000 * 0.25);
            impuesto += (recompensa - 400000) * 0.35;
        }
        return impuesto;
    }



    public int getIdCaballero() { return idCaballero; }
    public String getNombre() { return nombre; }
    public String getRango() { return rango; }
    public String getConstelacion() { return constelacion; }
    public int getNivelPoder() { return nivelPoder; }
    public String getMisionAsignada() { return misionAsignada; }
    public double getRecompensaBase() { return recompensaBase; }
    public double getAporteFondoSantuario() { return aporteFondoSantuario; }
    public double getImpuestoReinoAtena() { return impuestoReinoAtena; }
    public double getRecompensaNeta() { return recompensaNeta; }


    public void setRecompensaBase(double recompensaBase) {
        this.recompensaBase = recompensaBase;
        calcularDatosFinancieros();
    }

    public void setConstelacion(String constelacion) {this.constelacion = constelacion;}
    public void setNivelPoder(int nivelPoder) {this.nivelPoder = nivelPoder;}
    public void setMisionAsignada(String misionAsignada) {this.misionAsignada = misionAsignada;}
    public void setDificultadMision(int dificultadMision) {this.dificultadMision = dificultadMision;}
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setRango(String rango) { this.rango = rango; }

}



