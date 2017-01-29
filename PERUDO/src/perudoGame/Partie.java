package perudoGame;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Pereira
 * @version 1
 *
 */
public class Partie {
	
	private int id;
	private String status;
	private String AdressePartie; /*c pour le p2p*/
	private String nom;
	private ArrayList<Joueur> listeJoueurs;
	private Joueur joueurCourant;
	
	public Partie(int id, String nom, String stat){
		this.id= id;
		this.nom = nom;
		this.status = stat;
		this.listeJoueurs = new ArrayList<>();
	}
	
	public int getIdPartie() {
		return id;
	}

	public void setIdPartie(int idPartie) {
		this.id = idPartie;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdressePartie() {
		return AdressePartie;
	}

	public void setAdressePartie(String adressePartie) {
		AdressePartie = adressePartie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}
	
	public Joueur getJoueurCourrant() {
		return joueurCourant;
	}

	public void setJoueurCourrant(Joueur joueurCourrant) {
		this.joueurCourant = joueurCourrant;
	}
	
	//Choisir Joueur qui commence (aleatoire)
	public void premierAJouer(){
		int j;
		if( listeJoueurs.size() > 1 ){
			Random r = new Random();
			j = r.nextInt(listeJoueurs.size());
			this.joueurCourant = listeJoueurs.get(j);
		}
	}
	
	//ajouter joueur 1 par 1
	public void ajouterJoueur(Joueur j){
		if (this.listeJoueurs.size() < 6)
			this.listeJoueurs.add(j);
	}
	
	//Demander la liste des joueurs au Gestionneur de Protocole
	/*public ArrayList<Joueur> demanderListeJoueurs(GestionProtocole gP){
		return gP.getListeJoueur();
	}*/
	
	//connaitre la valeur surencherie précedement
	public ArrayList<Integer> derniereValeurJouee(){
		int i = this.listeJoueurs.indexOf(joueurCourant);
		int s = listeJoueurs.size() - 1 ;
		if( i == 0 )
			return this.listeJoueurs.get(s).dernieresValeursChoisies();
		else	
			return this.listeJoueurs.get(this.listeJoueurs.indexOf(this.joueurCourant)-1).dernieresValeursChoisies();
	}
	
	public Joueur connaitreJoueurPrecedant(){
		int i = this.listeJoueurs.indexOf(joueurCourant);
		int s = listeJoueurs.size() - 1 ;
		if (i == 0)
			return this.listeJoueurs.get(s);
		else
			return this.listeJoueurs.get(--i);
	}
	
	//passer le tour de annoncer au joueur suivant
	public void passerJoueurSuivant(){
		int courant;
		courant = this.listeJoueurs.indexOf(this.joueurCourant);
		if(courant == (this.listeJoueurs.size()-1))
			this.joueurCourant = this.listeJoueurs.get(0);
		else
			this.joueurCourant = this.listeJoueurs.get(courant + 1);
	}
	
	//Traitement surencher
	//public void traitementSurencher(){
		
	//}

}
