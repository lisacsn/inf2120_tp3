
public class AccoladeOuvrante<EC> extends Chainon<EC>{
	protected Chainon<EC> associe;
	
	public AccoladeOuvrante() {
		associe = null;
	}
	
	public AccoladeOuvrante(Chainon<EC> associe) {
		this.associe = associe;
	}
}
