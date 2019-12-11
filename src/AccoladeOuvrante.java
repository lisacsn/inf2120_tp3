public class AccoladeOuvrante<EC> extends Chainon<EC>{
	protected Chainon<EC> associe;
	
	public AccoladeOuvrante() {
		super();
		associe = null;
	}
	
	public AccoladeOuvrante(Chainon<EC> precedant, Chainon<EC> suivant, Chainon<EC> associe) {
		super(precedant, suivant);
		this.associe = associe;
	}
}
