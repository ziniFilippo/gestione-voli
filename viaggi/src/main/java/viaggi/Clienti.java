package main.java.viaggi;

// Classe Clienti
class Clienti {
    private List<Cliente> listaClienti;

    public Clienti() {
        listaClienti = new ArrayList<>();
    }

    public void aggiungiCliente(Cliente cliente) {
        listaClienti.add(cliente);
    }

    public void eliminaCliente(String codiceCliente) {
        listaClienti.removeIf(cliente -> cliente.getCodiceCliente().equals(codiceCliente));
    }

    public void modificaCliente(String codiceCliente, String nuovoCognome, String nuovoNome, String nuovaNazioneNascita, String nuovaCittaNascita, String nuovaDataNascita) {
        for (Cliente cliente : listaClienti) {
            if (cliente.getCodiceCliente() == codiceCliente) {
                cliente.setCognome(nuovoCognome);
                cliente.setNome(nuovoNome);
                cliente.setNazioneNascita(nuovaNazioneNascita);
                cliente.setCittaNascita(nuovaCittaNascita);
                cliente.setDataNascita(nuovaDataNascita);
                break;
            }
        }
    }

    public Cliente cercaClientePerCodice(String codiceCliente) {
        for (Cliente cliente : listaClienti) {
            if (cliente.getCodiceCliente() == codiceCliente) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> cercaClientePerCognomeENome(String cognome, String nome) {
        List<Cliente> risultato = new ArrayList<>();
        for (Cliente cliente : listaClienti) {
            if (cliente.getCognome().equalsIgnoreCase(cognome) && cliente.getNome().equalsIgnoreCase(nome)) {
                risultato.add(cliente);
            }
        }
        return risultato;
    }

    public void salvaSuFile(String nomeFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(listaClienti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void ripristinaDaFile(String nomeFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            listaClienti = (List<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}