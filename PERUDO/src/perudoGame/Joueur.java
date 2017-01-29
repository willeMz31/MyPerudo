package perudoGame;

import java.util.ArrayList;

/**
 * 
 * @author Pereira-Delgado
 *
 */
public class Joueur {
	private String pseudo;
	private int id;
	Gobelet gobelet;
	private ArrayList<Integer> valeursChoisies;
	
	public Joueur(int id,String nom,Couleur c){
		this.id = id;
		this.pseudo = nom;
		this.gobelet = new Gobelet(c);
		this.valeursChoisies = new ArrayList<>();
	}

	public String getPseudo() {
		return pseudo;
	}
	public void setNom(String nom) {
		this.pseudo = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//√ßa revient √† lancer d√©s
	public void secouerGobelet(){
		this.gobelet.secouer();
	}
	
	//Voir le nombre de d√©s en possession
	public int nombreDes(){
		return gobelet.listeDe.size();
	}
	
	//Regarder la valeur de nos d√©s, ceci est une methode affichage pour le test
	public String voirDes(){
		int i=1;
		String des = new String();
		des = "";
		for(String s : this.gobelet.afficherDes()){
			des = des + "DÈ " + i + ": " + s + "\n";
			i++;
		}
		return des;
	}
	
	public ArrayList<DePerudo> connaitreValeurDes(){
		return this.gobelet.getListeDe();
	}
	
	//Quand on choisit de surencherir, on met a jour les nouvelles valeurs
	public void majSurenchere(int nbrDe, int valeurDe){
		this.valeursChoisies.clear();
		this.valeursChoisies.add(nbrDe);
		this.valeursChoisies.add(valeurDe);
	}
	
	//Voir mon dernier surench√®re fait
	public ArrayList<Integer> dernieresValeursChoisies(){
		return this.valeursChoisies; 
	}
	
	// methode pour tester dans le main
	public String afficherValeursChoisies(){
		return (this.valeursChoisies.get(0) + "-" + this.valeursChoisies.get(1) + "  (Format : nombre de dÈs - valeur de dÈ PariÈ)" );
	}
	
	//Afficher couleur joueur
	public Couleur getCouleur(){
		return this.gobelet.getCouleur();
	}
}
