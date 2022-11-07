package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement[] equipements = new Equipement[2];

	public Romain(String nom, int force) {
		assert (force > 0);
		this.nom = nom;
		this.force = force;
	}

	public int getForce() {
		return this.force;
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le romain " + this.nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		int svForce = this.force;
//		assert (this.force > 0);
//
//		this.force -= forceCoup;
//		if (this.force > 0) {
//			this.parler("Aïe");
//		} else {
//			this.parler("J'abandonne...");
//
//		}
//		assert (svForce > this.force);
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;

		// précondition
		assert this.force > 0;

		int oldForce = this.force;
		forceCoup = this.calculResistanceEquipement(forceCoup);
		this.force -= forceCoup;

		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }

		if (this.force == 0) {
			this.parler("Aïe");
		} else {
			equipementEjecte = this.ejecterEquipement();
			this.parler("J'abandonne...");
		}

		// post condition la force à diminuer
		assert this.force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force ducoup est de " + forceCoup;
		int resistanceEquipement = 0;

		if (this.nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < this.nbEquipement; i++) {
				if (this.equipements[i] != null && this.equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		this.parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0)
			forceCoup = 0;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[this.nbEquipement];
		System.out.println("L'equipement de " + this.nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < this.nbEquipement; i++) {
			if (this.equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = this.equipements[i];
				nbEquipementEjecte++;
				this.equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {

		switch (this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.getNom() + " est déja bien protégé !");
			break;

		case 1:
			if (this.equipements[0] == equipement) {
				System.out.println("Le soldat " + this.getNom() + " posséde déja un " + equipement.toString() + " !");
				break;
			}
		default:
			this.equipements[this.nbEquipement++] = equipement;
			System.out.println("Le soldat " + this.getNom() + " séquipe avec un " + equipement.toString());
			break;
		}
	}

	public static void main(String[] args) {
		Romain lou = new Romain("lou", 6);
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
