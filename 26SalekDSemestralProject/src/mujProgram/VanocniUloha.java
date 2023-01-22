/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mujProgram;

import java.util.Scanner;

/**
 * <b>Vanocni uloha, generovani vlastni vesnicky; </b>
 * <i>Hlavni funkce programu main() slouzi spise pro debug ucely, spousteni 
 * programu je zamysleno z externiho zdroje zavolanim funkce 'launch()', 
 * ktera se ovsem da zavolat i z funkce 'main()'; </i>
 * Funkce 'launch()' po spusteni prevezme komunikaci s uzivatelem 
 * a na zaklade jeho vstupu vypise do konzole vygenerovanou vanocni 
 * vecnicku funkci 'generateVillage()'.
 * 
 * @author david
 * @version 1.6
 */

public class VanocniUloha {
    
    /**
     * Vstupem metody je int x;
     * Metoda vypise do konzole String na indexu x v poli.
    */ 
    public static void pT(int x) {
        /**
         * Vraci casti obrazku stromu ze String pole, vstup funkce x 0-7
         */
        String print[] = {
                "         ",
                "         ",
                "    o    ",
                "   }^{   ",
                "   /|\\   ",
                "  //|\\\\  ",
                "  //|\\\\  ",
                ".///|\\\\\\."
        };
        System.out.print(print[x]);
    }
    /**
     * Vstupem metody je int x; 
     * Metoda vypise do konzole String na indexu x v poli.
    */ 
    public static void pS(int x) {
        /**
         * Vraci casti obrazku snehulaka ze String pole, vstup funkce x 0-7
         */
        String print[] = {
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                " _.O./ ",
                "  (^)  ",
                "..(^).."
        };
        System.out.print(print[x]);
    }
    /**
     * Vstupem metody je int x; 
     * Metoda vypise do konzole String na indexu x v poli.
    */ 
    public static void pH(int x) {
        /**
         * Vraci casti obrazku domu ze String pole, vstup funkce x 0-7
         */
        String print[] = {
                "             ",
                "             ",
                "    \\        ",
                "    ))       ",
                "  .-#-----.  ",
                " /_________\\ ",
                "  |[] _ []|  ",
                "..|  |*|  |.."
        };
        System.out.print(print[x]);
    }
    /**
     * Vstupem metody je int x;
     * Metoda vypise do konzole String na indexu x v poli.
    */ 
    public static void pB(int x) {
        /**
         * Vraci casti obrazku stodoly ze String pole, vstup funkce x 0-7
         */
        String print[] = {
                "                   ",
                "                   ",
                "                   ",
                "                   ",
                "        .-------.  ",
                "   ___ /_________\\ ",
                "  /___\\ |       |  ",
                "..|\"#\"|.|   |*| |.."
        };
        System.out.print(print[x]);
    }
    /**
     * Vstupem metody je int x; 
     * Metoda vypise do konzole String na indexu x v poli.
    */ 
    public static void pC(int x) {
        /**
         * Vraci casti obrazku kostela ze String pole, vstup funkce x 0-7
         */
        String print[] = {
                "       |       ",
                "      -+-      ",
                "      _|_      ",
                "     /___\\     ",
                "  .---'-'---.  ",
                " /___________\\ ",
                "  | A /^\\ A |  ",
                "..|   |\"|   |.."
        };
        System.out.print(print[x]);
    }
    /**
     * Vstupem metody je int x;
     * Metoda vypise do konzole String na indexu x v poli.
    */ 
    public static void pM(int x) {
        /**
         * Vraci casti obrazku mesice ze String pole, vstup funkce x 0-7
         */
        String print[] = {
                " .-.",
                "( ( ",
                " '-`",
                "    ",
                "    ",
                "    ",
                "    ",
                "...."
        };
        System.out.print(print[x]);
    }    
    /**
    * Vstupem metody je char pole znaku predstavujici objekty; 
    * Projde pole a v pripade existence akceptovanych znaku metoda 
    * vola dalsi metody, ktere do konzole vypisuji ASCII vesnicku; 
    * Vypisuje po radcich, vsechny objekty jsou vysoke 8 radku, 
    * proto má for podminku mensi nez 8.
    * @param inputFormated
    */
    public static void generateVillage(char[] inputFormated){
        for(int i = 0; i<8; i++) {
            for(int x = 0; x<inputFormated.length; x++) {
                if(inputFormated[x]=='h') {
                    pH(i);
                }
                if(inputFormated[x]=='b') {
                    pB(i);
                }
                if(inputFormated[x]=='t') {
                    pT(i);
                }
                if(inputFormated[x]=='s') {
                    pS(i);
                }
                if(inputFormated[x]=='c') {
                    pC(i);
                }
                if(inputFormated[x]=='m') {
                    pM(i);
                }
            }
            System.out.printf("\n");
        }
    }
    /**
     * Spoustec vanocni ulohy;
     * 1) Vypise uzivateli objekty, ktere muze 'stavet' 
     * 2) nacte String vstup od uzivatele
     * 3) zformatuje String vstup, odebere mezery, carky, prevede toLowerCase(), prevede ho do char pole
     * 4) spusti metodu generateVillage() se vstupnim parametrem char pole znaku.
    */
    public static void launch() {        
        Scanner sc = new Scanner(System.in);
        
        Tools.textContainer("""
                            Postav si svoji vlastni vanocni vesnicku!
                            Muzes stavet: 
                             h = house
                             b = barn
                             t = tree
                             s = snowman
                             c = church
                             m - moon
                            Poradi je libovolne a neomezene, zadejte po sobe pismena objektu "bhstmch"
                            """);
        
        Tools.input();
        String input = sc.nextLine();
        
        //formatuje vstup, zbavi se mezer, carek, prevede do char pole
        char[] inputFormated = input.toLowerCase().replace(",", "").replace(" ", "").toCharArray();
        
        generateVillage(inputFormated);
        Tools.enterToContinue();
    }
    /**
     * Hlavni metoda programu, z ktere lze spoustet metodu launch();
     * Program ma byt spousten volanim metody launch() z externiho zdroje;
     * Metodu main lze pouzit skvele pro debuggovaci ucely.
    */ 
    public static void main(String[] args) {
        //pri spusteni volanim launch() z externiho souboru se tato funkce vubec nespusti
        Tools.textContainer("!!! Spoustite vanocni ulohu bez pouziti launcheru !!!\nPro spravne fungovani programu ho spustte skrze Launcher.java");
        launch();
        
        
    }
}
