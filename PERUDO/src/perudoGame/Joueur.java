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
	
	//ça revient à lancer dés
	public void secouerGobelet(){
		this.gobelet.secouer();
	}
	
	//Voir le nombre de dés en possession
	public int nombreDes(){
		return gobelet.listeDe.size();
	}
	
	//Regarder la valeur de nos dés
	public String voirDes(){
		int i=1;
		String des = new String();
		des = "";
		for(String s : this.gobelet.afficherDes()){
			des = des + "Dé " + i + ": " + s + "\n";
			i++;
		}
		return des;
	}
	
	//Quand on choisit de surencherir, on met a jour les nouvelles valeurs
	public void majSurenchere(int nbrDe, int valeurDe){
		this.valeursChoisies.add(nbrDe);
		this.valeursChoisies.add(valeurDe);
	}
	
	//Voir mon dernier surenchère fait
	public ArrayList<Integer> dernieresValeursChoisies(){
		return this.valeursChoisies; 
	}
	
	public String afficherValeursChoisies(){
		return (this.valeursChoisies.get(0) + "-" + this.valeursChoisies.get(1) + "  (Format : nombre de dés - valeur de dé Parié)" );
	}
	
}
