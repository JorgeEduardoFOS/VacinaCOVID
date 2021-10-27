package com.unicamp.mc322.lab04;

public class Runner {

	public static void main(String[] args) {
		System.out.println("--------------------------------------");
		System.out.println("Runner v2");

        VacinaCovid app = new VacinaCovid();
        app.setIdadeMinimaAtendida(60);

        app.cadastrarUsuario("Jose da Silva", "123.456.789-01", 
                              new Date(1960,12,03), new Position(10,30));
        app.cadastrarUsuario("Maria Assuncao", "321.654.987-10", 
                              new Date(1999,4,11), new Position(-43,101));

        app.cadastrarPosto("SOUSAS", new Position(0,20), 5);
        app.cadastrarPosto("BARAO GERALDO", new Position(-20,40), 2);

        Reserva r1 = app.agendar("123.456.789-01", "SOUSAS");
        Reserva r2 = app.agendarPerto("321.654.987-10");

        app.imprimirSituacaoPostos();

        app.imprimirCadastroUsuarios();
        
        ////////////
        //Meus testes
        app.cadastrarUsuario("Joaquim Bonifácio", "321.654.987-10", 
                new Date(1765,4,11), new Position(43,101));
        app.cadastrarUsuario("Willian Gates da Silva", "123.345.432-25", new Date(1966, 03, 14), new Position(34, 56));
        app.cadastrarUsuario("Alanis Morrisete", "155.345.432-25", new Date(1980, 9, 14), new Position(94, 56));
        app.cadastrarUsuario("Matusalem Antunes da Fonseca", "000.000.001-21", new Date(1880, 12, 14), new Position(-30, 50));
        app.imprimirCadastroUsuarios();
        Reserva r3 = app.agendarPerto("000.000.001-21");
        Reserva r4 = app.agendarPerto("000.000.001-21");     
        app.cadastrarPosto("SOUSAS", new Position(34,20), 12);
	}

}