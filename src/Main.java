import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		List<String> liste = new ArrayList<String>();
		Stack pile = new Stack();
		Chainon chainon = new Chainon();
		
		// Scanner va permettre de rentrer le nom du fichier texte au clavier
		Scanner sc = new Scanner ( System.in );
		System.out.println ( " Entrez le nom du fichier : " );
		String nomFichier = sc.nextLine ( );
		
		Scanner file = new Scanner (new File (nomFichier) );
		
		while(file.hasNext()) {
			liste.add(file.next());
		}
		file.close();
		
		System.out.println(liste);
				
		Iterator it = liste.iterator();
		
		//Ce qu'il faut faire au début d'après ce que j'ai compris
		Liste maListeDoublementChainee = new Liste(); //Créer une liste chainee vide
		
		int i = 0 ;
		while(it.hasNext()) {
			i++;
			String valeur = it.next().toString();
			if(valeur.equals("{")) {
				maListeDoublementChainee.insererAcoladeOuvrante();
			}
			else if(valeur.equals("}")) {
				maListeDoublementChainee.insererAcoladeFermante();
			}
			else {
				maListeDoublementChainee.insererMot(valeur, i);
			}
			
		}
		
		//On commence la recherche :
		//première recherche (la variable d est null)
		
		while(maListeDoublementChainee.d == null) {
			System.out.println("Entrez une commande : ");
			String res = sc.nextLine();
			System.out.println("La commande est : " + res);
 		
			if(res.charAt(0)=='f') {
				System.out.println("Fin. Programme terminé");
			}
			else if(res.charAt(0)=='t') {
				String cible = res.substring(2);
				System.out.println(cible);
 			
				maListeDoublementChainee.recherche(cible);
			}
		}
			System.out.println(maListeDoublementChainee.d);
			sc.close();
 		
		
	}

}
