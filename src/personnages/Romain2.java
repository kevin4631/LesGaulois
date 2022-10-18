package personnages;

public class Romain2 {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement equipements[] = new Equipement[2];

	public Romain2(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + this.nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		this.force -= forceCoup;
		if (this.force > 0) {
			this.parler("Aïe");
		} else {
			this.parler("J'abandonne...");
		}
	}

	public void sEquiper(Equipement equipement) {

		switch (this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé !");
			break;

		case 1:
			if (this.equipements[0] == equipement) {
				System.out.println("Le soldat " + this.getNom() + " possède déjà un " + equipement.toString() + " !");
				break;
			}
		default:
			this.equipements[this.nbEquipement++] = equipement;
			System.out.println("Le soldat " + this.getNom() + " s’équipe avec un " + equipement.toString());
			break;
		}
	}

	public static void main(String[] args) {
		Romain2 lou = new Romain2("lou", 6);
		lou.parler("non");
		lou.recevoirCoup(1);

		// TODO PRE POST condition

		System.out.println(Equipement.BOUCLIER);

		lou.sEquiper(Equipement.CASQUE);
		lou.sEquiper(Equipement.CASQUE);
		lou.sEquiper(Equipement.BOUCLIER);
		lou.sEquiper(Equipement.CASQUE);

	}
}
