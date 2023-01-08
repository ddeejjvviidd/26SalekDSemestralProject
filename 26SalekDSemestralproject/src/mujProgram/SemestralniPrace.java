package mujProgram;

import java.util.Scanner;

/**
 * <b>26 uloha, magicka matice;</b>
 * <i>Hlavni funkce programu 'main()' slouzi spise pro debug ucely, spousteni 
 * programu je zamysleno z externiho zdroje zavolanim funkce launch(), 
 * ktera se ovsem da zavolat i z funkce 'main()'; </i>
 * Program po spusteni funkce 'launch()' nacte od uzivatele rozmery matice 
 * a jeji hodnoty; 
 * Po nacteni zavola funkci 'isMagical()', ktera naslednou posloupnosti 
 * testovani pomoci podpurnych funkci zjisti zda se jedna o magicky ctverec 
 * ci nikoliv; 
 * Na zaklade vystupu funkce 'isMagical()' pak funkce 'launch()' vypise vysledek;
 * Program pobezi v loopu dokud uzivatel nezada rozmery matice mensi rovno 0.
 * 
 * @author david
 * @version 1.8
 */

/* 
Zapište program, který bude testovat, zda zadaná čtvercová matice celých 
čísel tvoří magický čtverec či nikoli. 
Řekneme, že čtvercová matice celých čísel velikosti n (n řádků, n sloupců, 
matice obsahuje celkem n2 prvků) tvoří magický čtverec právě, když (a) součty 
ve všech řádcích, ve všech sloupcích a v obou diagonálách jsou stejné 
a zároveň (b) matice obsahuje všechny hodnoty 1, 2, 3, … n2. 
 */

public class SemestralniPrace {

    public static boolean elementsCheck(int[][] matice) {
        boolean output = true;
        int rozmery = matice.length * matice.length;
        boolean[] elements = new boolean[rozmery];

        // kontroluje, zda jsou v matici cisla z intervalu <1;n^2> a zapisuje jejich existenci do kontrolniho pole
        for (int i = 0; i < matice.length && output; i++) {
            for (int j = 0; j < matice[i].length && output; j++) {
                if (matice[i][j] > 0 && matice[i][j] <= rozmery) {
                    elements[matice[i][j] - 1] = true;
                } else {
                    output = false;
                }
            }
        }

        //kontroluje, zda se v matici nachazi kazdy prvek posloupnosti prave jednou
        for (int i = 0; i < elements.length && output; i++) {
            if (!elements[i]) {
                output = false;
            }
        }

        return output;
    }

    public static int rowSum(int[][] matice) {
        int output = 1;

        int prvniRadek = 0;
        for (int j = 0; j < matice[0].length; j++) {
            prvniRadek += matice[0][j];
        }
        //System.out.printf("Debug: Prvni radek: %d\n", prvniRadek);

        for (int i = 1; i < matice.length && output > 0; i++) {
            //System.out.printf("Debug: i: %d\n", i);
            int dalsiRadek = 0;

            for (int j = 0; j < matice[i].length; j++) {
                //System.out.printf("Debug: j: %d\n", j);
                dalsiRadek += matice[i][j];
            }

            //System.out.printf("Debug: radek: %d\n", radek);
            if (dalsiRadek == prvniRadek) {
                output = dalsiRadek;
            } else {
                output = 0;
                break;
            }
        }

        //System.out.println(output);
        return output;
    }

    public static int columnSum(int[][] matice) {
        int output = 1;

        int prvniSloupec = 0;
        for (int i = 0; i < matice[0].length; i++) {
            prvniSloupec += matice[i][0];
        }
        //System.out.printf("Debug: Prvni sloupec: %d\n", prvniSloupec);

        for (int j = 1; j < matice[0].length && output > 0; j++) {
            //System.out.printf("Debug: j: %d\n", j);
            int dalsiSloupec = 0;

            for (int i = 0; i < matice.length; i++) {
                //System.out.printf("Debug: i: %d\n", i);
                dalsiSloupec += matice[i][j];
            }

            //System.out.printf("Debug: sloupec: %d\n", sloupec);
            if (dalsiSloupec == prvniSloupec) {
                output = dalsiSloupec;
            } else {
                output = 0;
                break;
            }
        }

        //System.out.println(output);
        return output;
    }

    public static int leftDiagonalSum(int[][] matice) {
        int output = 0;

        for (int i = 0; i < matice.length; i++) {
            output += matice[i][i];
        }

        return output;
    }

    public static int rightDiagonalSum(int[][] matice) {
        int output = 0;

        for (int i = 0; i < matice.length; i++) {
            output += matice[i][(matice[i].length) - i - 1];
        }

        return output;
    }

    public static boolean isMagical(int[][] matice) {
        boolean isMagical = true;

        do {
            // kontrola existence spravnych prvku
            if (!elementsCheck(matice)) {
                isMagical = false;
                break;
            }
            
            int rowSum = rowSum(matice);
            int columnSum = columnSum(matice);
            int rowColumnSum = rowSum + columnSum;
            int diagonalsSum = leftDiagonalSum(matice) + rightDiagonalSum(matice);
                    
            if (rowSum != columnSum) {
                isMagical = false;
                break;
            }

            if (rowColumnSum != diagonalsSum) {
                isMagical = false;
                break;
            }

        } while (false);

        return isMagical;
    }

    public static void vypisMatici(int[][] matice) {
        for (int i = 0; i < matice.length; i++) {
            for (int j = 0; j < matice[i].length; j++) {
                System.out.printf("%d ", matice[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static void launch() {
        Scanner sc = new Scanner(System.in);

        int n = 0; // rozmer ctvercove matice


        do {
            Tools.textContainer("Otestuj, zda tvoje matice tvori magicky ctverec!\nZadej rozmer ctvercove matice: (0 a mensi cislo = exit)\n");
            System.out.print("Rozmer matice: ");
            n = sc.nextInt();

            if (n > 0) {

                int[][] matice = new int[n][n]; // vytvori matici o 'n x n' rozmerech
                Tools.textContainer("Zadejte ciselne hodnoty postupne po radcich matice:\n");
                
                // cyklus pro nacteni hodnot do matice
                for (int i = 0; i < matice.length; i++) {
                    for (int j = 0; j < matice[i].length; j++) {
                        matice[i][j] = sc.nextInt();
                    }
                }

                Tools.emptyLine();

                if (isMagical(matice)) {
                    System.out.printf("Zadana matice TVORI magicky ctverec\n");
                } else {
                    System.out.printf("Zadana matice NETVORI magicky ctverec\n");
                }
                
                Tools.enterToContinue();
                //vypisMatici(matice);

            } else {
                break;
            }

        } while (n > 0);

    }
    
    public static void main(String[] args) {
        
        //pri spusteni volanim launch() z externiho souboru se tato funkce vubec nespusti
        Tools.textContainer("!!! Spoustite semestralni praci bez pouziti launcheru !!!\nPro spravne fungovani programu ho spustte skrze Launcher.java");
        //launch();
        
        //prostor pro debug
        int[][] kontrolaPrvku = {{1,2,-3}, {4,5,6}, {7,8,10}};
        int[][] magicalMatrix = {{4,9,2}, {3,5,7}, {8,1,6}};
        int[][] nonMagicalMatrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        /*
        vypisMatici(kontrolaPrvku);
        if (elementsCheck(kontrolaPrvku)) {
            System.out.println("PRVKY SEDI");
        } else {
            System.out.println("PRVKY NESEDI");
        }*/
        /*
        vypisMatici(nonMagicalMatrix);
        if (elementsCheck(nonMagicalMatrix)) {
            System.out.println("PRVKY SEDI");
        } else {
            System.out.println("PRVKY NESEDI");
        }*/
        
        System.out.println("Nemagicka matice:");
        vypisMatici(nonMagicalMatrix);
        if (isMagical(nonMagicalMatrix)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
        /*
        System.out.println("Magicka matice:");
        vypisMatici(magicalMatrix);
        if (isMagical(magicalMatrix)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }*/
        
        System.out.printf("%d \n", leftDiagonalSum(nonMagicalMatrix));
        System.out.printf("%d \n", rightDiagonalSum(nonMagicalMatrix));
        //System.out.printf("%d \n", rightDiagonalSum(magicalMatrix));
    }
}
