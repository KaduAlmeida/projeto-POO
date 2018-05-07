package menus;

import java.util.Scanner;

import entidades.Boss;
import entidades.Monstro;
import entidades.Personagem;

/**
 * Batalha � classe de batalha do jogo, entre o personagem e Monstros ou Bosses
 * @author Kadu/Phelipe
 * Version 1.0
 */
public class Batalha {
	static Scanner scan = new Scanner(System.in);
	/**
	 * Fun��o para o menu de Batalha com os Monstros
	 */
	public static int menuBatalha(Personagem p, Monstro m) {
		int opc = 0, funcr = 0;
		boolean x, y;
		for (;;) {
			x = p.batalhaPm(p);
			y = m.batalhaMp(m);
			if (x) {
				System.out.println("Voce morreu!");
				return 0;
			}
			if (y) {
				System.out.println("Voce venceu!");
				m.setVida(0);
				p.maisXp(m.xpMonstro(p.getLvl()));
				return 1;
			}
			do {
				System.out.println("!! " + p.getNome() + " Vs " + m.getMonstro() + " !!");
				System.out.println(p.getNome() + " tem " + p.getVida() + " de vida, e " + p.getMana() + "de mana");
				System.out.println(m.getMonstro() + " tem " + m.getVida() + " de vida");
				System.out.println("1 - Atacar");
				System.out.println("2 - Golpe forte");
				System.out.println("3 - Defender");
				System.out.println("4 - Run!!!");
				System.out.print("Digite a sua acao: ");
				opc = Entradas.leInt(scan);
			} while ((opc <= 0) || (opc > 4));
			funcr = executaOpcBatalha(p, m, opc);
			if (funcr == 4) {
				return 2;
			}
		}

	}
	/**
	 * Fun��o para a execu��o da Batalha com os Monstros
	 */
	private static int executaOpcBatalha(Personagem p, Monstro m, int opc) {

		switch (opc) {

		case 1:
			p.atacarMonstro(p, m);
			m.atacarPersonagem(m, p);
			return 1;
		case 2:
			if (p.atacarForte(m, p)) {
				System.out.println("Voce atacou forte, o(a) " + m.getMonstro() + " ficou atordoado!");
				return 2;
			} else {
				m.atacarPersonagem(m, p);
			}
		case 3:

			System.out.println("Voce defendeu o ataque do(a) " + m.getMonstro() + " !!");

			return 3;
		case 4:
			int x = (int) Math.floor(Math.random() * 1);
			if (x == 1) {
				return 4;
			} else {
				System.out.println("Voce falhou em fugir :( ");
				m.atacarPersonagem(m, p);
			}
		}
		return 0;
	}
	/**
	 * Fun��o para o menu de Batalha com os Boss
	 */
	public static int menuBatalhaBoss(Personagem p, Boss b) {
		int opc = 0;
		boolean x, y;
		for (;;) {
			x = p.batalhaPm(p);
			y = b.batalhaBoss(b);
			if (!x) {
				System.out.println("Voce morreu!");
				return 0;
			}
			if (!y) {
				System.out.println("Voce venceu!");
				p.maisXp(b.xpBoss(p.getLvl()));
				return 1;
			}
			do {
				System.out.println("!! " + p.getNome() + " Vs " + b.getNome() + " !!");
				System.out.println(p.getNome() + " tem " + p.getVida() + " de vida, e " + p.getMana() + "de mana");
				System.out.println(b.getNome() + " tem " + b.getVida() + " de vida");
				System.out.println("1 - Atacar");
				System.out.println("2 - Golpe forte");
				System.out.println("3 - Defender");
				System.out.print("Digite a sua acao: ");
				opc = Entradas.leInt(scan);
			} while ((opc <= 0) || (opc > 3));
			executaOpcBatalhaBoss(p, b, opc);
		}
	}
	/**
	 * Fun��o para a execu��o de Batalha com os Boss
	 */
	private static void executaOpcBatalhaBoss(Personagem p, Boss b, int opc) {
		switch (opc) {

		case 1:
			p.atacarBoss(p, b);
			b.bossAtacarPersonagem(b, p);
			break;
		case 2:
			if (p.atacarForteBoss(b, p)) {
				System.out.println("Voce atacou forte, o(a) " + b.getNome() + " ficou atordoado!");
				break;
			} else {
				b.bossAtacarPersonagem(b, p);
			}
		case 3:
			System.out.println("Voce defendeu o ataque do(a) " + b.getNome() + " !!");
			break;
		}
	}


}