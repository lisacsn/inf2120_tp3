import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList liste = new ArrayList();
		Stack pile = new Stack();
		Chainon chainon = new Chainon();
		
		// Scanner va permettre de rentrer le nom du fichier texte au clavier
		Scanner sc = new Scanner ( System.in );
		System.out.println ( " Entrez le nom du fichier : " );
		String nomFichier = sc.nextLine ( );
		sc.close ( );
		
		Scanner file = new Scanner (new File (nomFichier) );
		
		while(file.hasNext()) {
			liste.add(file.next());
		}
		
		System.out.println(liste);
		
		// la m�thode qui va ajouter une accolade fermante va devoir trouver l�accolade
		// ouvrante qui lui est associ�e afin d�affecter les r�f�rences d�une vers l�autre
		// construire une pile d'accoladeOuvrante
		for(int i=0; i<liste.size(); ++i) {
			
		}
		
	}

}
