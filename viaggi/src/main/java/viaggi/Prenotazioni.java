package main.java.viaggi;

// Classe Prenotazioni
class Prenotazioni {
    private List<Prenotazione> listaPrenotazioni;

    public Prenotazioni() {
        listaPrenotazioni = new ArrayList<>();
    }

    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        listaPrenotazioni.add(prenotazione);
    }

    public void eliminaPrenotazione(String codiceCliente, String codiceVolo) {
        listaPrenotazioni.removeIf(prenotazione -> prenotazione.getCodiceCliente().equals(codiceCliente) && prenotazione.getCodiceVolo().equals(codiceVolo));
    }

    public void modificaPrenotazione(String codiceCliente, String codiceVolo, int nuovoNumeroBagagli, double nuovoPesoBagagli) {
        for (Prenotazione prenotazione : listaPrenotazioni) {
            if (prenotazione.getCodiceCliente().equals(codiceCliente) && prenotazione.getCodiceVolo().equals(codiceVolo)) {
                prenotazione.setNumeroBagagli(nuovoNumeroBagagli);
                prenotazione.setPesoBagagli(nuovoPesoBagagli);
                break;
            }
        }
    }

    public List<Prenotazione> cercaPrenotazioniCliente(String codiceCliente) {
        List<Prenotazione> risultato = new ArrayList<>();
        for (Prenotazione prenotazione : listaPrenotazioni) {
            if (prenotazione.getCodiceCliente().equals(codiceCliente)) {
                risultato.add(prenotazione);
            }
        }
        return risultato;
    }

    public List<Prenotazione> cercaPrenotazioniVolo(String codiceVolo) {
        List<Prenotazione> risultato = new ArrayList<>();
        for (Prenotazione prenotazione : listaPrenotazioni) {
            if (prenotazione.getCodiceVolo().equals(codiceVolo)) {
                risultato.add(prenotazione);
            }
        }
        return risultato;
    }

    public void salvaSuFile(String nomeFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(listaPrenotazioni);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void ripristinaDaFile(String nomeFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            listaPrenotazioni = (List<Prenotazione>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
