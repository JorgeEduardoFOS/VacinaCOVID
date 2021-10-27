package com.unicamp.mc322.lab04;

public class User {
	private String cpf;
	private String name;
	private Position address;
	private Date birthDate;
	private boolean agendado = false;
	private ComprovanteDeAgendamento comprovante;
	
	User(String name, String cpf, Date birthDate, Position address){
		this.cpf = cpf;
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
	}
	public String getCPF() {
		return cpf;
	}
	public int getAge() {
		return birthDate.getAge();
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
	void setAgendado(boolean marcaDesmarca) {
		agendado = marcaDesmarca;
	}
	boolean getAgendado() {
		return agendado;
	}
	//////////////////////////////
	//Teste
	/////////////////////////////
	/*public static void main(String[] args) {
		User u1 = new User("Willian Gates da Silva", "123.345.432-25", new Date(1966, 03, 14), new Position(34, 56));
		System.out.println(u1.getAge());
	}*/
}
