package menus;

import java.util.Scanner;

import entidades.Boss;
import entidades.Monstro;
import entidades.Personagem;

/**
 * Jogo � a classe para a execu��o do jogo
 * @author Phelipe/Kadu
 * Version 1;0
 */
public class Jogo {
	static Scanner scan = new Scanner(System.in);
	/**
	 * Fun��o do menu do jogo quando se est� jogando com um personagem com as 
	 * op��es de jogo para o personagem 
	 */
	public static void menu(Personagem p) {
		int opc = 0;
		do{
			System.out.println("Bem vindo " + p.getNome() + ", o que deseja fazer?");
			System.out.println("1 - Explorar");
			System.out.println("2 - Dormir");
			System.out.println("3 - Ler diario");
			System.out.println("4 - Status de(da) " + p.getNome());
			System.out.println("5 - Salvar e sair");
			System.out.print("Digite o numero da sua resposta ");
			opc = Entradas.leInt(scan);
			if((opc > 0) && (opc <= 5)){							
				executaOpc(p, opc);
			}
		}while((opc <= 0) || (opc > 5) || (opc != 5));
	}
	/**
	 * Fun��o para a execu��o da batalha durante o jogo, usar o Diario e passar de n�vel 
	 */
	private static void executaOpc(Personagem p, int opc) {
		
		switch(opc) {
		
			case 1:
				if((p.getLvl() == 5) || (p.getLvl() == 15) || (p.getLvl() == 30) || (p.getLvl() == 50) || (p.getLvl() == 100)) {
					Boss b = new Boss(p.getLvl());
					System.out.println("Alguem esta com raiva de voce!!");
					System.out.println(b.getNome() + "avanca com tudo em sua direcao, boa sorte");
					int retBattleBoss = Batalha.menuBatalhaBoss(p,b);
					if(retBattleBoss == 1) {
						p.lvlUP(p.getXp());
						p.setMana(p.getMaxmana());
						p.usarDiario(b);
						System.out.println("Seu diario foi atualizado!");
					}
					if(retBattleBoss == 0) {
						p.setVida(1);
						p.setXp(0);
						System.out.println("Voce acordou com uma dor de cabeca muito forte, e nao lembra de nada");
					}
					break;
				}
				Monstro m = new Monstro(p.getLvl());
				System.out.println("Voce foi surpreendido por um(a) " + m.getMonstro()+"!!");
				int retBattle = Batalha.menuBatalha(p, m);
				if(retBattle == 2) {
					System.out.println("Voce fugiu com sucesso!!!");
				}
				if(retBattle == 1) {
					p.lvlUP(p.getXp());
					p.setMana(p.getMaxmana());
					p.usarDiario(m);
					System.out.println("Seu diario foi atualizado!");
				}
				if(retBattle == 0) {
					p.setVida(1);
					p.setXp(0);
					System.out.println("Voce acordou com uma dor de cabeca muito forte, e nao lembra de nada");
				}
				break;
		
			case 2:
				p.setVida(p.getMaxvida());
				p.setMana(p.getMaxmana());
				System.out.println("Voce acorda totalmente revigorado, pronto para a proxima, com certeza!!!");
				break;
			
			case 3:
				int op;
				do {
				p.capaDoDiario();
				System.out.println("Deseja ler todo o diario?");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");
				op = Entradas.leInt(scan);
				}while((op <= 0) || (op > 2));
				if(op == 1) {
					p.paginasDiario();
					scan.nextLine();
					break;
				}
				if(op == 2) {
					break;
				}
				
			case 4:
				System.out.println("Level: " + p.getLvl() + "\nExperiencia: " + p.getXp() + "\nVida: " + p.getVida() + "\nMana: " + p.getMana() + "\nAtaque: " + p.getAtck() + "\nDefesa: " + p.getDef());
				scan.nextLine();
				break;
				
			case 5:
				break;
				
		}
	}

}
