
public class AccoladeFermante<EC> extends Chainon<EC> {
	protected Chainon<EC> associe;
	
	public AccoladeFermante() {
		super();
		associe = null;
	}
	
	public AccoladeFermante(Chainon<EC> precedant, Chainon<EC> suivant, Chainon<EC> associe) {
		super(precedant, suivant);
		this.associe = associe;
	}
}
