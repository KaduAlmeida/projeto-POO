package menus;

//import java.io.IOException;
import java.util.Scanner;
import entidades.Personagem;

/**
 * Menu � a classe para o menu do jogo
 * @author Phelipe
 * Version 1.0
 */
public class Menu {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//int x = 1;
		Saves save = new Saves();
		//do {
		//	try {
		//		save.checkSave(save);
		//		x = 2;
		//	} catch (IOException e) {
		//		System.out.println("Arquivo Saves inexistente, falha ao criar novo arquivo");
		//	}
		//} while (x == 1);
		int aux = 0;
		do {
			menu();
			aux = Entradas.leInt(scan);
			if((aux > 0) && (aux <=3)){				
				execmenu(aux, save);
			}
		} while ((aux <= 0) || (aux > 3) || (aux != 3));
	}
	/**
	 * Menu principal do jogo
	 */
	static void menu() {
		System.out.println("\n##### Bem vindo ao RPG! #####\n");
		System.out.println("1 - Novo Jogo");
		System.out.println("2 - Continuar");
		System.out.println("3 - Sair");
		System.out.println("(caso a opcao seja invalida o menu ira reiniciar)");
		System.out.print("Digite sua opcao ");

	}
	/**
	 * Fun��o para executar o menu principal do jogo
	 */
	public static void execmenu(int opc, Saves save) {
		String nome = null;
		switch (opc) {

		case 1:
			System.out.print("Digite o nome do novo personagem: ");
			nome = scan.nextLine();
			Personagem p = new Personagem(nome);
			Jogo.menu(p);
			save.salvarPersonagem(p);
			System.out.println(save);
			save.gravarNoXmlSaves();
			break;

		case 2:
			int x = 1;
			do {
				System.out.println("Personagens existentes:");
				//save.mostrarSaves();
				System.out.println("Digite 0 para sair");
				System.out.print("Digite o nome do personagem que deseja selecionar: ");
				nome = scan.nextLine();
				if (nome.equals("0")) {
					x = 3;
				}else {
					if (save.getPersonagemByName(nome) == null) {
						System.out.println("Personagem inexistente, escreva um personagem que exista!");
					} else {
						menuSelecPersonagem(nome, save);
						x = 2;
					}
				}
			} while (x == 1);
			break;

		case 3:
			break;
		}
	}
	/**
	 * Menu para selecionar o personagem
	 */
	static void menuSelecPersonagem(String nome, Saves save) {
		int opc = 1;
		do {
			System.out.println("O que deseja fazer com " + nome);
			System.out.println("1 - Para jogar.");
			System.out.println("0 - Para DELETAR.");
			System.out.print("Digite sua opcao: ");
			opc = Entradas.leInt(scan);
			if (opc > 1) {
				System.out.println("Opcao invalida, digite novamente.");
			}
		} while (opc > 1);

		switch (opc) {

		case 1:
			Jogo.menu(save.getPersonagemByName(nome));
			save.gravarNoXmlSaves();
			break;

		case 2:
			save.apagarPersonagem(nome);
			System.out.println("Personagem apagado");
			save.gravarNoXmlSaves();
			break;
		}
	}
}
