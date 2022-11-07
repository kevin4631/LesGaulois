package personnages;

public class Trophee {

	private Gaulois gaulois;
	private Equipement Equipement;

	public Trophee(Gaulois gaulois, personnages.Equipement equipement) {
		super();
		this.gaulois = gaulois;
		this.Equipement = equipement;
	}

	public Gaulois getGaulois() {
		return this.gaulois;
	}

	public Equipement getEquipement() {
		return this.Equipement;
	}

	public String donnerNom() {
		return this.gaulois.getNom();
	}
}
