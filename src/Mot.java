
public class Mot<EC> extends Chainon<EC>{
	String clef;
	int indexe;
	
	public Mot() {
		super();
		clef = null;
		indexe = -1;
	}
	
	public Mot(Chainon<EC> precedant, Chainon<EC> suivant, String clef, int indexe) {
		this.clef = clef;
		this.indexe = indexe;
	}
}
