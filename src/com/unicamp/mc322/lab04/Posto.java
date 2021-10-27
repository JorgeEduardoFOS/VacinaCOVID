package com.unicamp.mc322.lab04;
import java.util.Calendar;
//import java.util.Date;

public class Posto {
	private static final int VAZIO = 0, MAX_DIAS_VACINA_ARRAY_INDEX = 3;
	private boolean sunday, monday, tuesday, wednesday, thursday, friday, saturday;
	private String name;
	private int maxVagas, diasVacinaCounter;
	private Position address;
	private int[] diasVacina = new int[3];
	public Calendar calendario = Calendar.getInstance();
	//public Date date;
	
	Posto(String name, Position address, int maxVagas){
		this.name = name;
		this.maxVagas = maxVagas;
		this.address = address;
		//date = calendario.getTime();
	}
	public String getName() {
		return name;
	}
	int getX() {
		return address.getX();
	}
	int getY() {
		return address.getY();
	}
	int[] getDiasVacina() {
		return diasVacina;
	}
	public void addDiasVacina(String dia) {
		dia.toLowerCase();
		if(diasVacinaCounter == 3)
			System.out.println("Não é possível adicionar dia de vacinação. Máximo de dias permitido atingido.");
		else
			switch (dia){
			case "segunda":
			case "2":
			case "monday":
			case "lundi":
			case "lunes":
				if(monday == true) {
					System.out.println("Dia já estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					monday = true;
					++diasVacinaCounter;
					break;
				}
			case "terça":
			case "3":
			case "tuesday":
				if(tuesday == true) {
					System.out.println("Dia já estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					tuesday = true;
					++diasVacinaCounter;
					break;
				}
			case "quarta":
			case "4":
			case "wednesday":
				if(wednesday == true) {
					System.out.println("Dia já estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					wednesday = true;
					++diasVacinaCounter;
					break;
				}
			case "quinta":
			case "5":
			case "thursday":
				if(thursday == true) {
					System.out.println("Dia já estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					thursday = true;
					++diasVacinaCounter;
					break;
				}
			case "sexta":
			case "6":
			case "friday":
				if(friday == true) {
					System.out.println("Dia já estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					friday = true;
					++diasVacinaCounter;
					break;
				}
			case "sabado":
			case "sábado":
			case "7":
			case "saturday":
				if(saturday == true) {
					System.out.println("Dia já estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					saturday = true;
					++diasVacinaCounter;
					break;
				}
			case "domingo":
			case "1":
			case "sunday":
				if(sunday == true) {
					System.out.println("Dia já estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					sunday = true;
					++diasVacinaCounter;
					break;
				}
		}
	}
	public void addDiasVacina(String dia1, String dia2) {
		addDiasVacina(dia1);
		addDiasVacina(dia2);
	}
	public void addDiasVacina(String dia1, String dia2, String dia3) {
		addDiasVacina(dia1);
		addDiasVacina(dia2);
		addDiasVacina(dia3);
	}
	public void removeDiasVacina(String dia) {
		dia.toLowerCase();
		if(diasVacinaCounter == 0)
			System.out.println("Não há dias a serem removidos. Agenda vazia. Nada a ser feito.");
		else
			switch (dia){
			case "segunda":
			case "2":
			case "monday":
			case "lundi":
			case "lunes":
				if(monday == false) {
					break;
				}
				else {
					monday = false;
					--diasVacinaCounter;
					break;
				}
			case "terça":
			case "3":
			case "tuesday":
				if(tuesday == false) {
					System.out.println("Dia já não estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					tuesday = false;
					--diasVacinaCounter;
					break;
				}
			case "quarta":
			case "4":
			case "wednesday":
				if(wednesday == false) {
					System.out.println("Dia já não estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					wednesday = false;
					--diasVacinaCounter;
					break;
				}
			case "quinta":
			case "5":
			case "thursday":
				if(thursday == false) {
					System.out.println("Dia já não estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					thursday = false;
					--diasVacinaCounter;
					break;
				}
			case "sexta":
			case "6":
			case "friday":
				if(friday == false) {
					System.out.println("Dia já não estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					friday = false;
					--diasVacinaCounter;
					break;
				}
			case "sabado":
			case "sábado":
			case "7":
			case "saturday":
				if(saturday == false) {
					System.out.println("Dia já não estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					saturday = false;
					--diasVacinaCounter;
					break;
				}
			case "domingo":
			case "1":
			case "sunday":
				if(sunday == false) {
					System.out.println("Dia já não estava cadastrado. Nada a ser feito.");
					break;
				}
				else {
					sunday = false;
					--diasVacinaCounter;
					break;
				}
			
			}
	}
	public void removeDiasVacina(String dia1, String dia2) {
		removeDiasVacina(dia1);
		removeDiasVacina(dia2);
	}
	public void removeDiasVacina(String dia1, String dia2, String dia3) {
		removeDiasVacina(dia1);
		removeDiasVacina(dia2);
		removeDiasVacina(dia3);
	}
	public void cleanDiasVacina() {
		diasVacinaCounter = 0;
		monday = tuesday = wednesday = thursday = friday = saturday = sunday = false;
	}
	
	//////////////////////////////
	//Teste
	/////////////////////////////
	public static void main(String[] args) {
		System.out.println(java.time.LocalDate.now());
		Posto p1 = new Posto("SOUSAS", new Position(0,20), 5);
		System.out.println(p1.calendario.getTime());
		p1.calendario.add(p1.calendario.DATE, 7);
		System.out.println(p1.calendario.get(p1.calendario.DAY_OF_WEEK_IN_MONTH));
		System.out.println(p1.calendario.getTime());
	}
}
