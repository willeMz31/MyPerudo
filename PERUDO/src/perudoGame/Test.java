package perudoGame;

public class Test {


	public static void main(String[] args) {
		
		Red r1 = new Red();
		Blue b1 = new Blue();
		Green g1 = new Green();
		
		Joueur j1 = new Joueur(1, "André Pierre Gignac",r1);
		Joueur j2 = new Joueur(2, "Mathieu Valbuena",b1);
		Joueur j3 = new Joueur(3, "Karim Benzema",g1);
		
		Partie p1 = new Partie(1, "Party");
		
		System.out.println("Bienvenu a : " + p1.getNom());
		
		p1.ajouterJoueur(j1);
		p1.ajouterJoueur(j2);
		p1.ajouterJoueur(j3);
		
		p1.premierAJouer();
		
		System.out.println("Le premier a jouer est : " + p1.getJoueurCourrant().getPseudo());
		
		p1.joueurSuivant();
		
		System.out.println("Le joueur suivant est : " + p1.getJoueurCourrant().getPseudo());
		
		j1.secouerGobelet();
		j2.secouerGobelet();
		j3.secouerGobelet();
		
		System.out.println(j1.getPseudo() + " possède " + j1.nombreDes() + " des");
		System.out.println(j2.getPseudo() + " possède " + j2.nombreDes() + " des");
		System.out.println(j3.getPseudo() + " possède " + j3.nombreDes() + " des");
		
		System.out.println(j1.getPseudo() + " possède \n" + j1.voirDes());
		System.out.println(j2.getPseudo() + " possède \n" + j2.voirDes());
		System.out.println(j3.getPseudo() + " possède \n" + j3.voirDes());
		
		// à regarder
		j2.majSurenchere(2,2);
		System.out.println(j2.getPseudo() + " a dit " + j2.afficherValeursChoisies());


	}

}
