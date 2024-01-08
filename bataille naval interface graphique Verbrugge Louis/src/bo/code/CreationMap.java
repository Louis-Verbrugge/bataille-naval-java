package bo.code;

public class CreationMap {

    private int tailleMapX;
    private int tailleMapY;
    private String[] tempX;
    private int[] tailleBateau;

    public CreationMap(int tailleMapX, int tailleMapY, int[] tailleBateau) {
        this.tailleMapX = tailleMapX;
        this.tailleMapY = tailleMapY;
        this.tailleBateau = tailleBateau;
    }

    public String[][] initPlateau() {
        String[][] grillePlateauAttaquee = new String[tailleMapX][tailleMapY]; // Initialiser le tableau avec la taille tailleMapY

        for (int y = 0; y < tailleMapX; y++) {
            tempX = new String[tailleMapX]; // Initialiser le tableau avec la taille tailleMapY
            for (int x = 0; x < tailleMapX; x++) {

                // je le place ici pour eviter les shadows copies
                tempX[x] = ".";
            }
            grillePlateauAttaquee[y] = tempX;
        }

        return grillePlateauAttaquee;
    }

    public String[][] creationPlatauSolution() {
        String[][] plateauSolution = initPlateau();
        int posX; int posY; int nbBateauAplace = 0;
        boolean vertical;
        while (nbBateauAplace != tailleBateau.length ) {
            int temp = (int)(Math.random() * 2);
            if ( temp == 0 ) { // vertical
                posX = (int)(Math.random() * tailleMapX-1 );
                posY = (int)(Math.random() * (tailleMapY-1-tailleBateau[nbBateauAplace]));
                vertical = true;
            } else {
                posX = (int)(Math.random() * (tailleMapX-1-tailleBateau[nbBateauAplace]));
                posY = (int)(Math.random() * (tailleMapY-1));
                vertical = false;
            }

            if ( testPlaceBateau(vertical,  posX, posY, tailleBateau[nbBateauAplace], plateauSolution) ) {
                /// il est bien place donc je supp le bateau
                plateauSolution = placeBateau(vertical, posX, posY, tailleBateau[nbBateauAplace], plateauSolution, nbBateauAplace);
                nbBateauAplace++;
            }
        }
        return plateauSolution;
    }

    private boolean testPlaceBateau(boolean vertical, int posX, int posY, int tailleBateau, String[][] plateauSolution) {
        // verrical si True, bateau vertical, sinon horizontal
        if ( vertical ) {
            for ( int i = 0; i < tailleBateau; i++) {
                if ( plateauSolution[posY + i][posX] != ".") {
                    return false;
                }
            }
        } else { // horizontal
            for ( int i = 0; i < tailleBateau; i++) {
                if ( plateauSolution[posY][posX +i ] != ".") {
                    return false;
                }
            }
        }
        return true;
    }

    private String[][] placeBateau(boolean vertical, int posX, int posY, int tailleBateau, String[][] plateauSolution, int nbBateauAplace) {
        if ( vertical ) {
            for (int i = 0; i < tailleBateau; i++) {
                plateauSolution[posY + i][posX] = "B";
            }
        } else {
            for (int i = 0; i < tailleBateau; i++) {
                plateauSolution[posY][posX + i] = "B";
            }
        }
        return plateauSolution;
    }


}
