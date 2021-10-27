package com.unicamp.mc322.lab04;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.math.MathContext;
import java.math.RoundingMode;

public class VacinaCovid {
	private int idadeMinima;
	private ArrayList<User> usersCadastrados = new ArrayList<User>();
	private ArrayList<Posto> postosCadastrados = new ArrayList<Posto>();
	private DecimalFormat df0 = new DecimalFormat(".##");

	public void setIdadeMinimaAtendida(int idadeMinima) {
		//System.out.println("-----------------------");
		//System.out.println("Configurando idade mínima.");
		this.idadeMinima = idadeMinima;
	}
	private int getIdadeMinima() {
		return idadeMinima;
	}
	public void cadastrarUsuario(String name, String cpf, Date birthDay, Position address) {
		if(searchCPF(cpf) != null)
			System.out.println("CPF já cadastrado anteriormente. Nada a ser feito.");
		else
			usersCadastrados.add(new User(name, cpf, birthDay, address));
	}
	public void cadastrarPosto(String name, Position address, int maxVagas) {
		if(searchNamePosto(name) != null)
			System.out.println("Nome de posto já cadastrado anteriormente. Nada a ser feito.");
		else
			postosCadastrados.add(new Posto(name, address, maxVagas));
	}
	public void imprimirSituacaoPostos() {
		//////Fazer!
	}
	public void imprimirCadastroUsuarios() {
		int i;
		i = 0;
		System.out.println("\n--------------------");
		System.out.println("Cadastro de usuários");
		System.out.println("\n--------------------");
		for(User user : usersCadastrados) {
			++i;
			System.out.println("Usuário número: " + i);
			System.out.println("CPF: " + user.getCPF());
			System.out.println("Nome: " + user.getName());
			System.out.println("Idade: " + user.getAge());
			System.out.println("------------------------------\n");
		}
	}
	public User searchCPF(String cpf) {
		//System.out.println("-----------");
		//System.out.println("Procurando usuário por CPF no cadastro.");
		for(User user : usersCadastrados)
			if(user.getCPF().compareTo(cpf) == 0)
				return user;
		return null;
	}
	private Posto searchNamePosto(String name) {
		//System.out.println("-----------");
		//System.out.println("Procurando posto por nome no cadastro.");
		for(Posto posto : postosCadastrados) {
			if(posto.getName().compareTo(name) == 0)
				return posto;
		}
		return null;
	}
	public Reserva agendar(String cpf, String localName) {
		User user;
		Posto posto;
		//System.out.println("-----------------------------");
		//System.out.println("Sistema de agendamento");
		if((user = searchCPF(cpf)) != null) {
			if(user.getAge() < idadeMinima) {
				System.out.println("O agendamento não está aberto para esta idade no momento.");
				return null;
			}
			else if(user.getAgendado() == true) {
				System.out.println("Usuário já foi agendado anteriormente. Nada a ser feito.");
				return null;
			}
			else
				System.out.println("Usuário encontrado no cadastro.");
		}
		else {
			System.out.println("Usuário não cadastrado. Agendamento não foi feito.");
			return null;
		}
		if((posto = searchNamePosto(localName)) != null);
		else {
			System.out.println("Posto não cadastrado. Agendamento não foi feito.");
			return null;
		}
		System.out.println("Agendamento do usuário " + user.getName() + " no posto " + posto.getName() 
			+ " efetuado com sucesso." );
		user.setAgendado(true);
		return new Reserva(user, posto);
	}
	public Reserva agendarPerto(String cpf) {
		User user;
		Posto posto, postoTemp;
		posto = null;
		int counter = 0;
		double menor, temp;
		menor = temp = 0;
		//System.out.println("----------------------------");
		//System.out.println("Agendar perto.");
		if((user = searchCPF(cpf)) != null) {
			if(user.getAge() < idadeMinima) {
				System.out.println("O agendamento não está aberto para esta idade no momento.");
				return null;
			}
			else if(user.getAgendado() == true) {
				System.out.println("Usuário já foi agendado anteriormente. Nada a ser feito.");
				return null;
			}
			else
				System.out.println("Usuário encontrado no cadastro.");
		}
		else {
			System.out.println("Usuário não cadastrado. Agendamento não foi feito.");
			return null;
		}
		posto = postosCadastrados.get(counter);
		menor = Math.sqrt(Math.pow(user.getX() - posto.getX(), 2) +
				Math.pow(user.getY() - posto.getY(), 2));
		++counter;
		while(counter < postosCadastrados.size()) {
			postoTemp = postosCadastrados.get(counter);
			temp = Math.sqrt(Math.pow(user.getX() - postoTemp.getX(), 2) +
					Math.pow(user.getY() - postoTemp.getY(), 2));
			++counter;
			if(temp < menor) {
				menor = temp;
				posto = postoTemp;
			}
		}
		df0.setRoundingMode(RoundingMode.HALF_UP);
		System.out.println("Usuário " + user.getName() + " agendado no posto " + posto.getName() +
				" que é o mais próximo a sua residência.\nA distância é de: " + df0.format(menor));
		user.setAgendado(true);
		return new Reserva(user, posto);
	}
	public Posto getPostoCadastrado(int posto) {
		return postosCadastrados.get(posto);
	}
	//////////////////////////////
	//Teste
	/////////////////////////////
	public static void main(String[] args) {
		VacinaCovid app = new VacinaCovid();
		app.cadastrarUsuario("Jose da Silva", "123.456.789-01", 
                new Date(1960,12,03), new Position(10,30));
		app.imprimirCadastroUsuarios();
		app.searchCPF("123.456.789-01");
	}
}
