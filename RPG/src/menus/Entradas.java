package menus;

import java.util.Scanner;

/**
 * Entradas é a classe para garantir a entrada de um Inteiro
 * @author Pedro/Phelipe
 * Version 1.0
 */
public class Entradas {
	/**
	 * Função para garantir a entrada dee um inteiro 
	 */
	public static int leInt(Scanner in) {
		while (!in.hasNextInt()) {
			in.nextLine();
			System.out.println("Tipo de dado inválido. Tente novamente:");
		}
		int r = in.nextInt();
		in.nextLine();
		return r;
	}

}
