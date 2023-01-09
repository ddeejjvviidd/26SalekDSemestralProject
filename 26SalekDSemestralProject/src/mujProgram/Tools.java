/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mujProgram;

import java.util.Scanner;
/**
 * Obsahuje pomocne funkce pro formatovani textu v konzoli.
 * 
 * @author david
 * @version 1.5
 */

public class Tools {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACKB = "\u001B[40m";
    
    public static int containerMaxWidth = 128; //maximalni sirka kontejneru
    public static int containerWidth = 32; //defaultni sirka kontejneru
    public static int containerSidePadding = 2; //pocet mezer mezi textem a bocnim ohranicenim
        
    public static void emptyLine() {
        System.out.printf("\n");
    }
    
    public static void enterToContinue() {
        /** 
         * Stiskni enter pro pokracovani.
         */
        Scanner sc = new Scanner(System.in);
        emptyLine();
        System.out.print("Press ENTER to continue...");
        sc.nextLine();
        emptyLine();
    }
    
     public static void input() {
        System.out.printf("Volba: ");
    }
    
    public static void textContainerStartEnd(int width) {
        width += (containerSidePadding*2);
        String output = "o";
        for (int i = 0; i < width; i++) {
            output += "-";
        }
        output += "o";
        
        System.out.printf("%s\n", output);
    }
    
    public static void textContainerLine(String text, int width) {
        width += (containerSidePadding*2);
        String output = "|";
        for (int i = 0; i < containerSidePadding; i++) {
            output += " ";
        }
        
        output += text;
        
        for (int i = output.length(); i < width-containerSidePadding+1; i++) {
            output += " ";
        }
        
        for (int i = 0; i < containerSidePadding; i++) {
            output += " ";
        }
        output += "|";
        
        System.out.printf("%s\n", output);
    }
    
    public static void textContainer(String inputText) {
        /**
         * Vstupni retezec vypise do konzole ohranicene rameckem; 
         * Bere v potaz odradkovani '\n'.
         */
        
        //rozdeli vstupni String na String pole dle odradkovani \n
        String[] output = inputText.split("\\r?\\n");
        
        //zjisti nejdelsi radek, dle nej se bude orientovat ramecek
        int longestLine = 0;
        for (int i = 0; i < output.length; i++) {
            if (output[i].length() > longestLine) {
                longestLine = output[i].length();
            }
        }
        
        //vypise do konzole text ohraniceny rameckem
        textContainerStartEnd(longestLine);
        for (int i = 0; i < output.length; i++) {
            textContainerLine(output[i], longestLine);
        }
        textContainerStartEnd(longestLine);
    }
}
