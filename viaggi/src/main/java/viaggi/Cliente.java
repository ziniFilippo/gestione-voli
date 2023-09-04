package viaggi;

class Cliente {
    static public int codici = 0;
    private int codiceCliente;
    private String cognome;
    private String nome;
    private String nazioneNascita;
    private String cittaNascita;
    private String dataNascita;

    public Cliente(String cognome, String nome, String nazioneNascita, String cittaNascita, String dataNascita) {
        codiceCliente = codici;
        codici++;
        this.cognome = cognome;
        this.nome = nome;
        this.nazioneNascita = nazioneNascita;
        this.cittaNascita = cittaNascita;
        this.dataNascita = dataNascita;
    }

    // getter e setter

    public int getCodiceCliente() {
        return codiceCliente;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getNazioneNascita() {
        return nazioneNascita;
    }

    public String getCittaNascita() {
        return cittaNascita;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setCittaNascita(String cittaNascita) {
        this.cittaNascita = cittaNascita;
    }
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }
    public void setNazioneNascita(String nazioneNascita) {
        this.nazioneNascita = nazioneNascita;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}