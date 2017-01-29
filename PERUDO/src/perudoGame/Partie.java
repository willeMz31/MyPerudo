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
	
	//connaitre la valeur surencherie prÃ©cedement
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
	
	//Est ce que c'est plus judicieux, de faire secouerGobelets 1 par 1
	//Ou bien faire un for et secouer les gobelets de tout le monde?
	//(Demander à l'équipe)
	public void secouerGobelets(Joueur j){
		j.secouerGobelet();
	}
	
	//je fais la méthode au cas où
	public void secouerTousGobelets(){
		for (Joueur j : this.listeJoueurs){
			j.secouerGobelet();
		}
	}
	
	//Avoir le nom du joueur
	public String getNomJoueur(Joueur j){
		return j.getPseudo();
	}
	
	//Avoir la couleur d'un joueur
	public Couleur getCouleurJoueur(Joueur j){
		return j.getCouleur();
	}
	
	//Savoir le nombre de des d'un joueur
	public int nombreDesJoueur(Joueur j){
		return j.nombreDes();
	}
	
	//connaitre la valeur des dés du joueur courant
	public ArrayList<DePerudo> getValeurDesDeJoueurCourant(){
		return this.joueurCourant.connaitreValeurDes();
	}
	
	// Methode qui servira a devoiler les dés de tous
	private ArrayList<DePerudo> getValeurDesDeJoueur(Joueur j){
		return j.connaitreValeurDes();
	}
	
	//devoiler les dés
	public ArrayList<ArrayList<DePerudo>> souleverGobelets(){
		ArrayList<ArrayList<DePerudo>> a = new ArrayList<>();
		for (Joueur j : listeJoueurs){
			a.add(this.getValeurDesDeJoueur(j));
		}
		return a;
	}
	
	//Connaitre combien de dés sont en jeu
	public int nombreTotalDeDes(){
		int cpt = 0;
		for(Joueur j : this.listeJoueurs){
			cpt = cpt + this.nombreDesJoueur(j);
		}
		return cpt;
	}
	
	//Le joueur courant surencherit
	public void surencher(int nbrDe, int valDe){
		if((nbrDe > 0 && nbrDe < this.nombreTotalDeDes()) && (valDe > 1 && valDe < 7)){
			this.joueurCourant.majSurenchere(nbrDe, valDe);
			this.passerJoueurSuivant();
		}	
	}

}
