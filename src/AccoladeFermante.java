
public class AccoladeFermante<EC> extends Chainon<EC> {
	protected Chainon<EC> associe;
	
	public AccoladeFermante() {
		associe = null;
	}
	
	public AccoladeFermante(Chainon<EC> associe) {
		this.associe = associe;
	}
}
