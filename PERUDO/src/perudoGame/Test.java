package perudoGame;

public class Test {


	public static void main(String[] args) {
		
		Red r1 = new Red();
		Blue b1 = new Blue();
		Green g1 = new Green();
		
		Joueur j1 = new Joueur(1, "Andr√© Pierre Gignac",r1);
		Joueur j2 = new Joueur(2, "Mathieu Valbuena",b1);
		Joueur j3 = new Joueur(3, "Karim Benzema",g1);
		
		Partie p1 = new Partie(1, "Party","Waiting Players");
		
		System.out.println("Bienvenu a : " + p1.getNom() + ", status: " + p1.getStatus());
		
		p1.ajouterJoueur(j1);
		p1.ajouterJoueur(j2);
		p1.ajouterJoueur(j3);
		
		p1.premierAJouer();
		
		System.out.println("Le premier a jouer est : " + p1.getJoueurCourrant().getPseudo());
		
		p1.passerJoueurSuivant();
		
		System.out.println("Le nouveau joueur currant est : " + p1.getJoueurCourrant().getPseudo());
		
		j1.secouerGobelet();
		j2.secouerGobelet();
		j3.secouerGobelet();
		
		System.out.println(j1.getPseudo() + " poss√®de " + j1.nombreDes() + " des");
		System.out.println(j2.getPseudo() + " poss√®de " + j2.nombreDes() + " des");
		System.out.println(j3.getPseudo() + " poss√®de " + j3.nombreDes() + " des");
		
		System.out.println(j1.getPseudo() + " poss√®de \n" + j1.voirDes());
		System.out.println(j2.getPseudo() + " poss√®de \n" + j2.voirDes());
		System.out.println(j3.getPseudo() + " poss√®de \n" + j3.voirDes());
		
		j1.majSurenchere(3,3);
		j2.majSurenchere(2,2);
		j3.majSurenchere(4,4);
		System.out.println(j1.getPseudo() + " a dit " + j1.afficherValeursChoisies());
		System.out.println(j2.getPseudo() + " a dit " + j2.afficherValeursChoisies());
		System.out.println(j3.getPseudo() + " a dit " + j3.afficherValeursChoisies());
		
		System.out.println("C'est le tour de : " + p1.getJoueurCourrant().getPseudo());
		System.out.println("Rappel: Les derniËres valeurs jouÈes sont: " + p1.derniereValeurJouee().get(0) + " dÈs de valeur " + p1.derniereValeurJouee().get(1));
		System.out.println("Valeurs annoncÈes par " + p1.connaitreJoueurPrecedant().getPseudo());
	}

}
