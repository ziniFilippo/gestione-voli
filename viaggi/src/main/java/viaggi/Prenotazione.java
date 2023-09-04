package viaggi;


// Classe Prenotazione
class Prenotazione {
    private String codiceCliente;
    private String codiceVolo;
    private int numeroBagagli;
    private double pesoBagagli;

    public Prenotazione(String codiceCliente, String codiceVolo, int numeroBagagli, double pesoBagagli) {
        this.codiceCliente = codiceCliente;
        this.codiceVolo = codiceVolo;
        this.numeroBagagli = numeroBagagli;
        this.pesoBagagli = pesoBagagli;
    }

    // Metodi getter e setter

    public String getCodiceCliente() {
        return codiceCliente;
    }
    public String getCodiceVolo() {
        return codiceVolo;
    }
    public int getNumeroBagagli() {
        return numeroBagagli;
    }
    public double getPesoBagagli() {
        return pesoBagagli;
    }
    public void setCodiceCliente(String codiceCliente) {
        this.codiceCliente = codiceCliente;
    }

    public void setCodiceVolo(String codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

    public void setNumeroBagagli(int numeroBagagli) {
        this.numeroBagagli = numeroBagagli;
    }

    public void setPesoBagagli(double pesoBagagli) {
        this.pesoBagagli = pesoBagagli;
    }
}