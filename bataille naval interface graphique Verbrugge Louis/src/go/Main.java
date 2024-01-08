package go;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import bo.code.Attaque;
import bo.code.Plateau;
import bo.afichage.affichage;
import bo.code.Clique;


public class Main {

    private static Plateau joueur1;
    private static Plateau joueur2;
    private static Clique clique1;
    private static Clique clique2;

    private static affichage windows1;
    private static affichage windows2;
    private static Attaque joueur1Attaque;
    private static Attaque joueur2Attaque;

    public static void main(String[] args) {

        //initialisation des variable/constante:
        int TAILLE_MAP_X = 10;
        int TAILLE_MAP_Y = 10;
        int[] TAILLE_BATEAU = {2, 3, 4, 4, 5,-6};
        boolean run = false;
        final int HEIGHT = 400;
        final int  WIDTH = 600;

        joueur1 = new Plateau(TAILLE_MAP_X, TAILLE_MAP_Y, TAILLE_BATEAU);
        joueur2 = new Plateau(TAILLE_MAP_X, TAILLE_MAP_Y, TAILLE_BATEAU);

        joueur1.setPlateauSolutionEnnemi(joueur2.getTableauSolution());
        joueur2.setPlateauSolutionEnnemi(joueur1.getTableauSolution());

        clique1 = new Clique();
        clique2 = new Clique();

        windows1 = new affichage(TAILLE_MAP_X, TAILLE_MAP_Y, HEIGHT, WIDTH, "joueur 1", clique1, new int[]{150, 200});
        windows2 = new affichage(TAILLE_MAP_X, TAILLE_MAP_Y, HEIGHT, WIDTH, "joueur 2", clique2, new int[]{750, 200});

        windows1.afficheMap(joueur1.getTableauSolution(), joueur1.getGrillePlateauAttaque());
        windows2.afficheMap(joueur2.getTableauSolution(), joueur2.getGrillePlateauAttaque());

        joueur1Attaque = new Attaque(joueur1.getGrillePlateauAttaque(), joueur2.getTableauSolution(), clique1);
        joueur2Attaque = new Attaque(joueur2.getGrillePlateauAttaque(), joueur1.getTableauSolution(), clique2);

        // la game:
        while ( joueur1.finGame() && joueur2.finGame() ) {
            // joueur 1:
            joueur1Attaque.attaqueEnnemi();
            joueur1Attaque.modifApresAttaque(clique1.getCoordonneCliqueX(), clique1.getCoordonneCliqueY(), joueur2.getTableauSolution());
            windows1.afficheModifMap(clique1.getBoutonModif(), clique1.getCoordonneCliqueX(), clique1.getCoordonneCliqueY(), joueur2.getTableauSolution());

            if (joueur1.finGame()) {
                // joueur 2:
                joueur2Attaque.attaqueEnnemi();
                joueur2Attaque.modifApresAttaque(clique2.getCoordonneCliqueX(), clique2.getCoordonneCliqueY(), joueur1.getTableauSolution());
                windows2.afficheModifMap(clique2.getBoutonModif(), clique2.getCoordonneCliqueX(), clique2.getCoordonneCliqueY(), joueur1.getTableauSolution());

            }
        }

        //affiche qui gagne !
        if (joueur1.finGame()) {
            windows1.afficheMap(joueur1.getTableauSolution(), joueur2.getTableauSolution());
            windows1.afficheFinGame("tu as gagne !");
            windows2.afficheFinGame("tu as perdu !");

        } else {
            windows1.afficheMap(joueur2.getTableauSolution(), joueur1.getTableauSolution());
            windows1.afficheFinGame("tu as perdu !");
            windows2.afficheFinGame("tu as gagne !");
        }


    }

}