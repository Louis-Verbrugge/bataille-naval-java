package bo.code;

import java.util.Arrays;
import java.util.Scanner;


public class Plateau {

    private int tailleMapX;
    private int tailleMapY;

    private String[][] grillePlateauAttaque;

    private String[][] plateauSolution;
    private String[][] plateauSolutionEnnemi;
    private int[] tailleBateau;

    public Plateau(int tailleMapX, int tailleMapY, int[] tailleBateau) {

        this.tailleMapX = tailleMapX;
        this.tailleMapY = tailleMapY;

        CreationMap mapInit = new CreationMap(tailleMapX, tailleMapY, tailleBateau);
        this.grillePlateauAttaque = mapInit.initPlateau();
        this.plateauSolution = mapInit.creationPlatauSolution();

        this.tailleBateau = tailleBateau;
        this.plateauSolutionEnnemi = plateauSolutionEnnemi;
    }


    public boolean finGame() {
        /*
        Dasn cette fonction je vais compter tout les "T" de la liste grillePlateauAttaque
        donc si ce n'est pas un "." et "A" cela signifie qu'il a touche un bateau
        et si l'accu = sum d de {5, 4, 3} il a perdu
        */
        int accumulateur = 0;
        for (int y = 0; y < tailleMapY; y++) {
            for (int x = 0; x < tailleMapX; x++) {
                if ( grillePlateauAttaque[y][x] != "." && grillePlateauAttaque[y][x] != "W" ) {
                    accumulateur++;
                    if ( accumulateur == Arrays.stream(tailleBateau).sum() ) {
                        return false; // il a perdu
                    }
                }
            }
        }
        return true; // il n'a pas encore perdu
    }



    public void setPlateauSolutionEnnemi(String[][] newPlateauSolutionEnnemi) {
        plateauSolutionEnnemi = newPlateauSolutionEnnemi;
    }

    public String[][] getGrillePlateauAttaque() {
        return grillePlateauAttaque;
    }
    public String[][] getTableauSolution() {
        return plateauSolution;
    }


}