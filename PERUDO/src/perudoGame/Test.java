package perudoGame;

public class Test {


	public static void main(String[] args) {
		
		Red r1 = new Red();
		Blue b1 = new Blue();
		Green g1 = new Green();
		
		Joueur j1 = new Joueur(1, "André Pierre Gignac",r1);
		Joueur j2 = new Joueur(2, "Mathieu Valbuena",b1);
		Joueur j3 = new Joueur(3, "Karim Benzema",g1);
		
		Partie p1 = new Partie(1, "Party","Waiting Players");
		
		System.out.println("Bienvenu a : " + p1.getNom() + ", status: " + p1.getStatus());
		
		p1.ajouterJoueur(j1);
		p1.ajouterJoueur(j2);
		p1.ajouterJoueur(j3);
		
		p1.premierAJouer();
		
		System.out.println("Le premier a jouer est : " + p1.getCouleurJoueur(p1.getJoueurCourrant()).getCodeCouleur()+ " " + p1.getJoueurCourrant().getPseudo());
		
		p1.passerJoueurSuivant();
		
		System.out.println("Le nouveau joueur currant est : " + p1.getJoueurCourrant().getPseudo());
		
		/*p1.secouerGobelets(j1);
		p1.secouerGobelets(j2);
		p1.secouerGobelets(j3);*/
		
		p1.secouerTousGobelets();
		
		//test Affichage du dé 1 du joueur Courant
		//System.out.println(p1.getValeurDesDeJoueurCourant().get(0).getPerudo());
		
		//Sequence pour tester la methode connaireValeurDes() de joueur.
		/*System.out.println(p1.getJoueurCourrant().connaitreValeurDes().get(0).getPerudo());
		System.out.println(p1.getJoueurCourrant().connaitreValeurDes().get(1).getPerudo());
		System.out.println(p1.getJoueurCourrant().connaitreValeurDes().get(2).getPerudo());
		System.out.println(p1.getJoueurCourrant().connaitreValeurDes().get(3).getPerudo());
		System.out.println(p1.getJoueurCourrant().connaitreValeurDes().get(4).getPerudo());*/
		
		System.out.println("Il y a " + p1.nombreTotalDeDes() + " dés dans la partie");
		
		System.out.println(p1.getNomJoueur(j1) + " possède " + p1.nombreDesJoueur(j1) + " des");
		System.out.println(p1.getNomJoueur(j2) + " possède " + p1.nombreDesJoueur(j2) + " des");
		System.out.println(p1.getNomJoueur(j3) + " possède " + p1.nombreDesJoueur(j3) + " des");
		
		System.out.println(p1.getNomJoueur(j1) + " possède \n" + j1.voirDes());
		System.out.println(p1.getNomJoueur(j2) + " possède \n" + j2.voirDes());
		System.out.println(p1.getNomJoueur(j3) + " possède \n" + j3.voirDes());
		
		j1.majSurenchere(3,3);
		j2.majSurenchere(2,2);
		j3.majSurenchere(4,4);
		System.out.println(p1.getNomJoueur(j1) + " a dit " + j1.afficherValeursChoisies());
		System.out.println(p1.getNomJoueur(j2) + " a dit " + j2.afficherValeursChoisies());
		System.out.println(p1.getNomJoueur(j3) + " a dit " + j3.afficherValeursChoisies());
		
		System.out.println("C'est le tour de : " + p1.getJoueurCourrant().getPseudo());
		System.out.println("Rappel: Les dernières valeurs jouées sont: " + p1.derniereValeurJouee().get(0) + " dés de valeur " + p1.derniereValeurJouee().get(1));
		System.out.println("Valeurs annoncées par " + p1.connaitreJoueurPrecedant().getPseudo());
		System.out.println();
		
		p1.surencher(7, 4);
		System.out.println("C'est le tour de : " + p1.getJoueurCourrant().getPseudo());
		System.out.println("Rappel: Les dernières valeurs jouées sont: " + p1.derniereValeurJouee().get(0) + " dés de valeur " + p1.derniereValeurJouee().get(1));
		System.out.println("Valeurs annoncées par " + p1.connaitreJoueurPrecedant().getPseudo());
		
		//sert a tester le devoil des dés
		//System.out.println(p1.souleverGobelets().get(1).get(3).getPerudo());
	}

}
