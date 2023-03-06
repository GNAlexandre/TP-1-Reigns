package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Représente un personnage ayant un nom, un genre, et des jauges de Clergé, Peuple, Armée et Finances.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */


public class Personnage {

    public static ArrayList<Jauge> ListeJauge;
    /**
     * Le nom du personnage
     */
    public static String nom;
    /**
     * Le genre du personnage
     */
    public static Genre genre;





    public static Jauge jaugePeuple;
    public static Jauge jaugeArmee;
    public static Jauge jaugeFinance;
    public static Jauge jaugeClerge;


    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom Le nom du personnage
     * @param genre Le genre du personnage
     */
    public Personnage(String nom, Genre genre) {
        Personnage.nom = nom;
        Personnage.genre = genre;


        // Initialisation des jauges entre 15 et 35 points
        ListeJauge = new ArrayList<>();


        jaugeClerge = new Jauge("Clergé", 15 + (int)(Math.random() * (35 - 15)));
        ListeJauge.add(jaugeClerge);
        jaugePeuple = new Jauge("Peuple", 15 + (int)(Math.random() * (35 - 15)));
        ListeJauge.add(jaugePeuple);
        jaugeArmee = new Jauge("Armée", 15 + (int)(Math.random() * (35 - 15)));
        ListeJauge.add(jaugeArmee);
        jaugeFinance = new Jauge("Finances", 15 + (int)(Math.random() * (35 - 15)));
        ListeJauge.add(jaugeFinance);
    }

    /* Pour Afficher les nouvelles Jauges voir la class MethodsJauge*/




}
