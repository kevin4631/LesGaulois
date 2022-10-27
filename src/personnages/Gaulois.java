package personnages;

public class Gaulois {

	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "« " + texte + "»");
	}

//	private String prendreParole() {
//		return "Le gaulois " + this.nom + " : ";
//	}

	private String prendreParole() {
		return "Le gaulois " + this.nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(this.nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(this.force / 3);
//	}

	public void frapper(Romain romain) {
		System.out.println(this.nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] equipementTrophees = romain.recevoirCoup((this.force / 3) * this.effetPotion);
		for (int i = 0; equipementTrophees != null && i < equipementTrophees.length; i++, this.nbTrophees++) {
			this.trophees[this.nbTrophees] = equipementTrophees[i];
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + this.nom + ", force=" + this.force + ", effetPotion=" + this.effetPotion + "]";
	}

	public void boirePotion(int forcePdruide) {
		this.effetPotion = forcePdruide;
		this.parler("Merci Druide, je sens que ma force est " + forcePdruide + " fois décuplée.");
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		System.out.println(asterix);
		asterix.parler("rhaaaaaaaaa");
		asterix.frapper(new Romain("ronin", 3));
		asterix.boirePotion(6);
	}

}
