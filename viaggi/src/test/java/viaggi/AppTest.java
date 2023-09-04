package viaggi;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestSistemaGestioneVoli {
    private Clienti clienti;
    private Voli voli;
    private Prenotazioni prenotazioni;

    @Before
    public void setUp() {
        clienti = new Clienti();
        voli = new Voli();
        prenotazioni = new Prenotazioni();
    }

    @Test
    public void testAggiungiCliente() {
        Cliente cliente = new Cliente("001", "Rossi", "Mario", "Italia", "Roma", "01/01/1990");
        clienti.aggiungiCliente(cliente);
        assertEquals(cliente, clienti.cercaClientePerCodice("001"));
    }

    @Test
    public void testEliminaCliente() {
        Cliente cliente = new Cliente("002", "Bianchi", "Laura", "Italia", "Milano", "02/02/1985");
        clienti.aggiungiCliente(cliente);
        clienti.eliminaCliente("002");
        assertNull(clienti.cercaClientePerCodice("002"));
    }

    @Test
    public void testAggiungiVolo() {
        Volo volo = new Volo("V001", "Aeroporto1", "Aeroporto2", "01/01/2023", "08:00", "10:00", 150, 200.0);
        voli.aggiungiVolo(volo);
        assertEquals(volo, voli.cercaVoloPerCodice("V001"));
    }

    @Test
    public void testEliminaVolo() {
        Volo volo = new Volo("V002", "Aeroporto3", "Aeroporto4", "02/02/2023", "12:00", "14:00", 200, 250.0);
        voli.aggiungiVolo(volo);
        voli.eliminaVolo("V002");
        assertNull(voli.cercaVoloPerCodice("V002"));
    }

    @Test
    public void testAggiungiPrenotazione() {
        Cliente cliente = new Cliente("003", "Verdi", "Giuseppe", "Italia", "Napoli", "03/03/1980");
        Volo volo = new Volo("V003", "Aeroporto5", "Aeroporto6", "03/03/2023", "16:00", "18:00", 180, 180.0);
        clienti.aggiungiCliente(cliente);
        voli.aggiungiVolo(volo);
        Prenotazione prenotazione = new Prenotazione("003", "V003", 2, 30.0);
        prenotazioni.aggiungiPrenotazione(prenotazione);
        assertEquals(prenotazione, prenotazioni.cercaPrenotazioniCliente("003").get(0));
    }

    @Test
    public void testEliminaPrenotazione() {
        Cliente cliente = new Cliente("004", "Ferrari", "Luigi", "Italia", "Torino", "04/04/1975");
        Volo volo = new Volo("V004", "Aeroporto7", "Aeroporto8", "04/04/2023", "20:00", "22:00", 160, 220.0);
        clienti.aggiungiCliente(cliente);
        voli.aggiungiVolo(volo);
        Prenotazione prenotazione = new Prenotazione("004", "V004", 1, 15.0);
        prenotazioni.aggiungiPrenotazione(prenotazione);
        prenotazioni.eliminaPrenotazione("004", "V004");
        assertEquals(0, prenotazioni.cercaPrenotazioniCliente("004").size());
    }

    @Test
    public void testModificaCliente() {
        Cliente cliente = new Cliente("005", "Gialli", "Anna", "Italia", "Bologna", "05/05/1988");
        clienti.aggiungiCliente(cliente);
        clienti.modificaCliente("005", "Verdi", "Anna", "Francia", "Parigi", "05/05/1988");
        Cliente clienteModificato = clienti.cercaClientePerCodice("005");
        assertEquals("Verdi", clienteModificato.getCognome());
        assertEquals("Francia", clienteModificato.getNazioneNascita());
    }

    @Test
    public void testModificaVolo() {
        Volo volo = new Volo("V005", "Aeroporto9", "Aeroporto10", "05/05/2023", "10:00", "12:00", 140, 150.0);
        voli.aggiungiVolo(volo);
        voli.modificaVolo("V005", "Aeroporto11", "Aeroporto12", "05/05/2023", "14:00", "16:00", 160, 170.0);
        Volo voloModificato = voli.cercaVoloPerCodice("V005");
        assertEquals("Aeroporto11", voloModificato.getAeroportoPartenza());
        assertEquals("Aeroporto12", voloModificato.getAeroportoArrivo());
    }
}

