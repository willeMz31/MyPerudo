package perudoGame;

/**
 * 
 * @author Pereira-Keraghel
 * @version 1
 *
 */
public class Client {

	
	public static void main (String args[]) {
		
		ConnexionClient connexion = new ConnexionClient();
		connexion.ConnecterServeur();
		connexion.envoyer("lut");
		System.out.println("Reçu: " + connexion.recevoir());
		
		
		connexion.FermerConnexionServeur();
	}
}
