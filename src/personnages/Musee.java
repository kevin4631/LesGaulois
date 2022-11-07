package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee;

	public void DonnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (this.nbTrophee < 200) {
			Trophee trophee = new Trophee(gaulois, equipement);
			this.trophees[this.nbTrophee] = trophee;
			this.nbTrophee++;
		} else {
			System.out.println("le Musee ne peut plus aceuillir de trophee.");
		}
	}

	public String extraireInstructionsCaml() {
		String musee = "let musee = [\n";

		for (int i = 0; i < this.nbTrophee; i++) {
			musee += "	\"" + this.trophees[i].donnerNom() + "\", \"" + this.trophees[i].getEquipement().toString()
					+ "\"";
			if (i != this.nbTrophee - 1)
				musee += ";";
			musee += "\n";
		}
		musee += "]";

		return musee;
	}

	public static void main(String[] args) {
		Musee m = new Musee();
		Gaulois g = new Gaulois("kevin", 3);
		m.DonnerTrophees(g, Equipement.BOUCLIER);
		m.DonnerTrophees(g, Equipement.CASQUE);
		m.DonnerTrophees(g, Equipement.BOUCLIER);
		m.DonnerTrophees(g, Equipement.CASQUE);
		System.out.println(m.extraireInstructionsCaml());
	}

}
