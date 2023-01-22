package mujProgram;

import java.util.Scanner;

/**
 * Slouzi jako spoustec pro vsechny ostatni programy;
 * Zobrazuje uzivateli menu moznosti a na zaklade jeho vstupu spousti zvolene
 * veci. 
 * 
 * @author david
 * @version 1.1
 */
public class Launcher {
    /**
    * Hlavni metoda programu; 
    * Vypisuje uzivateli menu, dle vstupu od uzivatele spusti vanocni ulohu, 
    * semestralni praci, nebo ukonci program.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String usr = System.getProperty("user.name");
        int menu = 0;

        System.out.printf("Vitejte uzivateli %S!\nCo si prejete udelat?\n", usr);

        // opakovane vypisuje menu programu
        do {
            Tools.textContainer("2 - Spust semestralni praci\n1 - Spust vanocni ulohu\n0 - Ukoncit program");
            System.out.print("Volba: ");
            menu = sc.nextInt();

            if (menu == 2) { // spusti semestralni praci
                SemestralniPrace.launch();
            }
            if (menu == 1) { // spusti vanocni ulohu
                VanocniUloha.launch();
            }
            
        } while (menu > 0);
        
        System.out.printf("\nPreji hezky den %S!\n", usr);
    }

}
