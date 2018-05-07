package entidades;

import java.io.Serializable;

/**
 * Monstro � uma classe para definir os Monstros do jogo
 * @author Phelipe/Kadu
 * Version 1.0
 */
public class Monstro extends Atributos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * String Para o nome 
	 * Double para valor da vida
	 */
	private String nome;
	private double vida;
	/**
	 * Fun��o para gerar o Monstro de acordo com o n�vel
	 */
	public Monstro(int lvl) {
		super(0, 0);
		tipoMonstro(lvl);
		balanceaVida(lvl);
		aumentaAtckDef(lvl);
	}

	public String getMonstro() {
		return nome;
	}

	public void setMonstro(String monstro) {
		this.nome = monstro;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}
	/**
	 * Fun��o para balancear a vida do monstro de acordo com o nivel do personagem
	 */
	public void balanceaVida(int lvl) {
		if (lvl >= 1 && lvl < 5) {
			int x = (int) Math.floor(Math.random() * 5);
			System.out.println(x);
			switch (x) {
			case 0:
				this.vida = 50;
				break;
			case 1:
				this.vida = 55;
				break;
			case 2:
				this.vida = 60;
				break;
			case 3:
				this.vida = 65;
				break;
			case 4:
				this.vida = 70;
				break;
			}
		}
		if (lvl == 5) {
			this.vida = 100;
		}
		if (lvl > 5 && lvl < 15) {
			int x = (int) Math.floor(Math.random() * 5);
			switch (x) {
			case 0:
				this.vida = 150;
				break;
			case 1:
				this.vida = 155;
				break;
			case 2:
				this.vida = 160;
				break;
			case 3:
				this.vida = 165;
				break;
			case 4:
				this.vida = 170;
				break;
			}
		}
		if (lvl == 15) {
			this.vida = 180;
		}
		if (lvl > 15 && lvl < 30) {
			int x = (int) Math.floor(Math.random() * 5);
			switch (x) {
			case 0:
				this.vida = 200;
				break;
			case 1:
				this.vida = 205;
				break;
			case 2:
				this.vida = 210;
				break;
			case 3:
				this.vida = 220;
				break;
			case 4:
				this.vida = 230;
				break;
			}
		}
		if (lvl == 30) {
			this.vida = 300;
		}
		if (lvl > 30 && lvl < 50) {
			int x = (int) Math.floor(Math.random() * 5);
			switch (x) {
			case 0:
				this.vida = 350;
				break;
			case 1:
				this.vida = 355;
				break;
			case 2:
				this.vida = 400;
				break;
			case 3:
				this.vida = 450;
				break;
			case 4:
				this.vida = 460;
				break;
			}
		}
		if (lvl >= 50) {
			int x = (int) Math.floor(Math.random() * 5);
			switch (x) {
			case 0:
				this.vida = 500;
				break;
			case 1:
				this.vida = 555;
				break;
			case 2:
				this.vida = 560;
				break;
			case 3:
				this.vida = 580;
				break;
			case 4:
				this.vida = 600;
				break;
			}
		}
	}
	/**
	 * Fun��o para aumentar o ataque e defesa do monstro 
	 */
	public void aumentaAtckDef(int lvl) {
		if (lvl >= 1 && lvl < 5) {
			double x = this.getAtck() + (2 * lvl);
			setAtck(x);
			double y = this.getDef() + (2 * lvl);
			setDef(y);
		}
		if (lvl == 5) {
			double x = this.getAtck() + 15;
			setAtck(x);
			double y = this.getDef() + 10;
			setDef(y);
		}
		if (lvl > 5 && lvl < 15) {
			double x = this.getAtck() + (3 * lvl);
			setAtck(x);
			double y = this.getDef() + (3 * lvl);
			setDef(y);
		}
		if (lvl == 15) {
			double x = this.getAtck() + 35;
			setAtck(x);
			double y = this.getDef() + 25;
			setDef(y);
		}
		if (lvl > 15 && lvl < 30) {
			double x = this.getAtck() + (4 * lvl);
			setAtck(x);
			double y = this.getDef() + (3 * lvl);
			setDef(y);
		}
		if (lvl == 30) {
			double x = this.getAtck() + 40;
			setAtck(x);
			double y = this.getDef() + 30;
			setDef(y);
		}
		if (lvl > 30 && lvl < 50) {
			double x = this.getAtck() + (5 * lvl);
			setAtck(x);
			double y = this.getDef() + (4 * lvl);
			setDef(y);
		}
		if (lvl >= 50) {
			double x = this.getAtck() + 50;
			setAtck(x);
			double y = this.getDef() + 40;
			setDef(y);
		}
	}
	/**
	 * Fun��o para dar um nome aleatorio ao Monstro
	 * (feito para que o personagem nao lute o jogo todo com apenas um monstro),
	 * recebe o novel como parametro, para que a cada etapa de niveis ele encontre monstros diferentes 
	 */
	public void tipoMonstro(int lvl) {
		if (lvl <= 5) {
			int x = (int) Math.floor(Math.random() * 5);
			switch (x) {
			case 0:
				this.nome = "Rato";
				break;
			case 1:
				this.nome = "Slime";
				break;
			case 2:
				this.nome = "Abelha";
				break;
			case 3:
				this.nome = "Planta carnivora";
				break;
			case 4:
				this.nome = "Batedor de carteira";
				break;
			}
		}
		if (lvl > 5 && lvl <= 10) {
			int x = (int) Math.floor(Math.random() * 8);
			switch (x) {
			case 0:
				this.nome = "Javali";
				break;
			case 1:
				this.nome = "Barata gigante";
				break;
			case 2:
				this.nome = "Morto vivo";
				break;
			case 3:
				this.nome = "Arranha venenosa";
				break;
			case 4:
				this.nome = "Esqueleto";
				break;
			case 5:
				this.nome = "Goblin";
				break;
			case 6:
				this.nome = "Morcego da caverna";
				break;
			case 7:
				this.nome = "Ladrao";
				break;
			}
		}
		if (lvl > 10 && lvl <= 25) {
			int x = (int) Math.floor(Math.random() * 15);
			switch (x) {
			case 0:
				this.nome = "Guerreiro esqueleto";
				break;
			case 1:
				this.nome = "Zumbi";
				break;
			case 2:
				this.nome = "Slime rainha";
				break;
			case 3:
				this.nome = "Armadura possuida";
				break;
			case 4:
				this.nome = "Guerreiro Amaldicoado";
				break;
			case 5:
				this.nome = "Mago da Seita";
				break;
			case 6:
				this.nome = "Sapo Gigante";
				break;
			case 7:
				this.nome = "Harpia";
				break;
			case 8:
				this.nome = "Imp";
				break;
			case 9:
				this.nome = "Espectro";
				break;
			case 10:
				this.nome = "Construto";
				break;
			case 11:
				this.nome = "Lobisomem";
				break;
			case 12:
				this.nome = "Ogro do pantano";
				break;
			case 13:
				this.nome = "Mestre ladrao";
				break;
			case 14:
				this.nome = "Mumia";
				break;
			}
		}
		if (lvl > 25 && lvl <= 35) {
			int x = (int) Math.floor(Math.random() * 15);
			switch (x) {
			case 0:
				this.nome = "Aparicao";
				break;
			case 1:
				this.nome = "Yeti";
				break;
			case 2:
				this.nome = "Gigante raivoso";
				break;
			case 3:
				this.nome = "Ogro berserker";
				break;
			case 4:
				this.nome = "Warlock da Seita";
				break;
			case 5:
				this.nome = "Demonio";
				break;
			case 6:
				this.nome = "Vampiro";
				break;
			case 7:
				this.nome = "Troll";
				break;
			case 8:
				this.nome = "Otacu";
				break;
			case 9:
				this.nome = "Chimera";
				break;
			case 10:
				this.nome = "Medusa";
				break;
			case 11:
				this.nome = "Assassino";
				break;
			case 12:
				this.nome = "Guerreiro da Seita";
				break;
			case 13:
				this.nome = "Gargula";
				break;
			case 14:
				this.nome = "Beholder";
				break;
			}
		}
		if (lvl > 35 && lvl <= 45) {
			int x = (int) Math.floor(Math.random() * 15);
			switch (x) {
			case 0:
				this.nome = "Dragao jovem";
				break;
			case 1:
				this.nome = "Juggernaut";
				break;
			case 2:
				this.nome = "Devorador";
				break;
			case 3:
				this.nome = "Gigante de Gelo";
				break;
			case 4:
				this.nome = "Druida sombrio";
				break;
			case 5:
				this.nome = "Lorde Vampiro";
				break;
			case 6:
				this.nome = "Carrasco da Seita";
				break;
			case 7:
				this.nome = "Cavaleiro da morte";
				break;
			case 8:
				this.nome = "Minotauro";
				break;
			case 9:
				this.nome = "Centauro da selva";
				break;
			case 10:
				this.nome = "Cerbero";
				break;
			case 11:
				this.nome = "Bruxa de Salem";
				break;
			case 12:
				this.nome = "Basilico";
				break;
			case 13:
				this.nome = "Guerreiro Negro";
				break;
			case 14:
				this.nome = "Lider da Seita";
				break;
			}
		}
		if (lvl > 45 && lvl <= 50) {
			int x = (int) Math.floor(Math.random() * 5);
			switch (x) {
			case 0:
				this.nome = "Dragao Infernal";
				break;
			case 1:
				this.nome = "Oraculo";
				break;
			case 2:
				this.nome = "Hidra";
				break;
			case 3:
				this.nome = "Tarrasque";
				break;
			case 4:
				this.nome = "Tiamat";
				break;
			}
		}
	}
	/**
	 * Fun��o para o valor recebido de Xp ap�s derrotar um Monstro
	 * @return double
	 */
	public double xpMonstro(int lvl) {
		if (lvl <= 5) {
			return 5;
		}
		if (lvl > 5 && lvl <= 10) {
			return 10;
		}
		if (lvl > 10 && lvl <= 25) {
			return 25;
		}
		if (lvl > 25 && lvl <= 35) {
			return 34;
		}
		if (lvl > 45 && lvl <= 50) {
			return 50;
		}

		return 100;
	}


	public String toString() {
		return "Nome :" + nome + ", Vida:" + vida + ", Ataque: " + this.getAtck() + ", Defesa: " + this.getDef() + ".";
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(vida);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monstro other = (Monstro) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(vida) != Double.doubleToLongBits(other.vida))
			return false;
		return true;
	}
	
	
}
