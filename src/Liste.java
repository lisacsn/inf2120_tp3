import java.util.Iterator;

/**
 * Implementation d'un type de donnees abstrait de <code>Liste</code> a l'aide d'un double chainage.
 * 
 * Les positions dans la <code>Liste</code> sont designees par des entiers.  L'element a la premiere
 * case de la liste est a la position <code>0</code> et l'element a la derniere case est a la position 
 * <code>taille() - 1</code>.
 * @param <E> Le type des elements places dans la <code>Liste</code>.
 */
public class Liste< E > implements Iterable< E > {
	/**
	 * Une classe interne pour representer un <code>Chainon</code> contenant un element.
	 * Il contient aussi deux references.  Une vers le <code>Chainon</code> precedant et une autre
	 * vers le <code>Chainon</code> suivant.
	 */
	private class Chainon< EC > {
		public EC element;
		public Chainon< EC > precedant; 
		public Chainon< EC > suivant;

		public Chainon( Chainon< EC > precedant, EC element ) {
			this.element = element;
			this.precedant = precedant;
		}

		public Chainon( Chainon< EC > precedant, EC element, Chainon< EC > suivant ) {
			this.element = element;
			this.precedant = precedant;
			this.suivant = suivant;
		}
	}
	
	private class ListeIterator< EI > implements Iterator< EI > {
		
		private Chainon< EI > _courant;
		
		public ListeIterator( Chainon< EI > tete ) {
			_courant = tete;
		}

		@Override
		public boolean hasNext() {
			return null != _courant;
		}

		@Override
		public EI next() {
			EI element = _courant.element;
			_courant = _courant.suivant;
			return element;
		}
		
	}
	
	/**
	 * methode interne utilisee pour retrouver un <code>Chainon</code> selon sa position.
	 * @param position La position du <code>Chainon</code>.  Le premier <code>Chainon</code>
	 *                 est a la position <code>0</code>.
	 * @return Le <code>Chainon</code> demande.
	 * @throws IndexOutOfBoundsException Lance si la position est invalide : <code> position < 0 || taille() <= position</code>. 
	 */
	private Chainon< E > getChainon( int position ) 
	throws IndexOutOfBoundsException {
		if( position < 0 || _taille <= position  ) {
			throw new IndexOutOfBoundsException();
		}
		
		Chainon< E > courant = _tete;
		
		while( position != 0 ) {
			courant = courant.suivant;
			-- position;
		}
		
		return courant;
	}
	

	/**
	 * Une reference au premier element de la <code>Liste</code> est maintenu ici.
	 */
	protected Chainon< E > _tete;
	
	/**
	 * Puisque l'ajout a la fin d'une <code>Liste</code> est courante, un reference est 
	 * conserve pour obtenir rapidement le dernier element.
	 */
	protected Chainon< E > _fin;
	
	protected int _taille;
	
	
	
	
	/**
	 * Construit une <code>Liste</code> vide.
	 */
	public Liste() {
		_tete = null;
		_taille = 0;
	}
	
	
	
	
	/**
	 * Donne l'element a la position indiquee.
	 * @param position La position de l'element a extraire.
	 * @return L'element extrait.
	 * @throws IndexOutOfBoundsException Lance si la position est invalide : <code> position < 0 || taille() <= position</code>.
	 */
	public E get( int position ) 
	throws IndexOutOfBoundsException { 
		return getChainon( position ).element;
	}
	

	/**
	 * Ajoute un element a la fin de la <code>Liste</code>
	 * @param element L'element a ajouter.
	 */
	public void inserer( E element ) {
		Chainon< E > nouveau = new Chainon<>( _fin, element );
		
		if( _taille == 0 ) {
			_tete = nouveau;
		} else {
			_fin.suivant = nouveau;
		}
		
		_fin = nouveau;

		++ _taille;
	}
	
	
	/**
	 * Ajoute un element dans la <code>Liste</code> a la position indiquee.
	 * @param position La position ou l'element est ajoute.  Les valeurs au position suivante seront
	 *                 decalees de une case.  Un ajout a la position <code>taille()</code> ajoute l'element a la 
	 *                 fin de la <code>Liste</code>.
	 * @param element L'element a ajouter.
	 * @throws IndexOutOfBoundsException Lance si la position est invalide : <code> position < 0 || taille() < position</code>.
	 */
	public void inserer( int position, E element ) 
	throws IndexOutOfBoundsException {
		if( position == _taille ) {
			inserer( element );
		} else {
			Chainon< E > courant = getChainon( position );
			
			Chainon< E > nouveau = new Chainon<>( courant.precedant, element, courant );
			
			if( courant.precedant == null ) {
				_tete = nouveau;
			} else {
				courant.precedant.suivant = nouveau;
			}
			courant.precedant = nouveau;
			
			++ _taille;
		}
	}
	
	

	/**
	 * genere un <code>Iterator</code>
	 * @return Un <code>Iterator</code>
	 */
	@Override
	public Iterator< E > iterator() {
		return new ListeIterator< E >( _tete );
	}

	
	/**
	 * Modifie l'element a la position indiquee.
	 * @param position La position de l'element a modifier.
	 * @param element L'element qui va remplacer l'ancien element.
	 * @throws IndexOutOfBoundsException Lance si la position est invalide : <code> position < 0 || taille() <= position</code>.
	 */
	public void set( int position, E element ) 
	throws IndexOutOfBoundsException {
		getChainon( position ).element = element;
	}
	

	/**
	 * Enleve un element de la <code>Liste</code>
	 * @param position La position de l'element a supprimer.
	 * @throws IndexOutOfBoundsException Lance si la position est invalide : <code> position < 0 || taille() <= position</code>.
	 */
	public void supprimer( int position ) 
	throws IndexOutOfBoundsException {
		Chainon< E > courant = getChainon( position );
		
		if( null == courant.precedant ) {
			_tete = courant.suivant;
		} else {
			courant.precedant.suivant = courant.suivant;
		}
		
		if( null == courant.suivant ) {
			_fin = courant.precedant;
		} else {
			courant.suivant.precedant = courant.precedant;
		}
		
		-- _taille;
	}

	
	/**
	 * La taille de la <code>Liste</code>.
	 * @return Le nombre d'element que contient la <code>Liste</code>.
	 */
	public int taille() {
		return _taille;
	}
}