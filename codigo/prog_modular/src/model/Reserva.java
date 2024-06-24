package model;

import model.Mesa;
import model.ProprietarioReserva;

public class Reserva {
	
	private ProprietarioReserva proprietario;
	private Mesa mesa;
	private Comanda comanda;
	
	public Reserva(ProprietarioReserva proprietario, Mesa mesa) {
		this.proprietario = proprietario;
		this.mesa = mesa;
		this.comanda = new Comanda();
	}
}
