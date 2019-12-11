
public class Chainon<EC> {
	protected Chainon<EC> precedant;
	protected Chainon<EC> suivant;
	
	public Chainon() {
		precedant = null;
		suivant = null;
	}
	
	public Chainon(Chainon<EC> precedant, Chainon<EC> suivant) {
		this.precedant = precedant;
		this.suivant = suivant;
	}
	
	
}
