package model;

public class Laite {

	private String laitteenID, nimi, kuvaus;
	private double hinta;
	private int ostop‰iv‰m‰‰r‰;
	private int takuu;

	public Laite() {

	}

	public Laite(String laitteenID, String nimi, String kuvaus, double hinta,
			int ostop‰iv‰m‰‰r‰, int takuu) {
		this.laitteenID = laitteenID;
		this.nimi = nimi;
		this.kuvaus = kuvaus;
		this.kuvaus = kuvaus;
		this.ostop‰iv‰m‰‰r‰ = ostop‰iv‰m‰‰r‰;
		this.takuu = takuu;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public int getOstop‰iv‰m‰‰r‰() {
		return ostop‰iv‰m‰‰r‰;
	}

	public void setOstop‰iv‰m‰‰r‰(int ostop‰iv‰m‰‰r‰) {
		this.ostop‰iv‰m‰‰r‰ = ostop‰iv‰m‰‰r‰;
	}

	public int getTakuu() {
		return takuu;
	}

	public void setTakuu(int takuu) {
		this.takuu = takuu;
	}

	public String getLaitteenID() {
		return laitteenID;
	}

	public void setLaitteenID(String laitteenID) {
		this.laitteenID = laitteenID;
	}

}
