package viaggi;

import java.util.*;
import java.io.*;

// Classe Voli
class Voli {
    private List<Volo> listaVoli;

    public Voli() {
        listaVoli = new ArrayList<>();
    }

    public void aggiungiVolo(Volo volo) {
        listaVoli.add(volo);
    }

    public void eliminaVolo(String codiceVolo) {
        listaVoli.removeIf(volo -> volo.getCodiceVolo().equals(codiceVolo));
    }

    public void modificaVolo(String codiceVolo, String nuovoAeroportoPartenza, String nuovoAeroportoArrivo, String nuovaDataVolo, String nuovaOraPartenza, String nuovaOraArrivo, int nuovoNumeroPosti, double nuovoCostoVolo) {
        for (Volo volo : listaVoli) {
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                volo.setAeroportoPartenza(nuovoAeroportoPartenza);
                volo.setAeroportoArrivo(nuovoAeroportoArrivo);
                volo.setDataVolo(nuovaDataVolo);
                volo.setOraPartenza(nuovaOraPartenza);
                volo.setOraArrivo(nuovaOraArrivo);
                volo.setNumeroPosti(nuovoNumeroPosti);
                volo.setCostoVolo(nuovoCostoVolo);
               break;
            }
        }
    }

    public Volo cercaVoloPerCodice(String codiceVolo) {
        for (Volo volo : listaVoli) {
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                return volo;
            }
        }
        return null;
    }

    public List<Volo> cercaVoloPerParametri(String dataVolo, String aeroportoPartenza, String aeroportoArrivo, String oraPartenza) {
        List<Volo> risultato = new ArrayList<>();
        for (Volo volo : listaVoli) {
            if (volo.getDataVolo().equals(dataVolo) && volo.getAeroportoPartenza().equals(aeroportoPartenza) &&
                volo.getAeroportoArrivo().equals(aeroportoArrivo) && volo.getOraPartenza().equals(oraPartenza)) {
                risultato.add(volo);
            }
        }
        return risultato;
    }

    public void salvaSuFile(String nomeFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(listaVoli);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void ripristinaDaFile(String nomeFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            listaVoli = (List<Volo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

