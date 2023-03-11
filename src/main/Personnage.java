package main;

import java.util.HashMap;

/**
 * Représente un personnage ayant un nom, un genre, et des jauges de Clergé, Peuple, Armée et Finances.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Personnage {
    /**
     * Le nom du personnage
     */
    public static String nom;
    /**
     * Le genre du personnage
     */
    public static Genre genre;
    /**
     * La jauge de Clergé
     */
    public static Jauge jaugeClerge;
    /**
     * La jauge de Peuple
     */
    public static Jauge jaugePeuple;
    /**
     * La jauge d'Armée
     */
    public static Jauge jaugeArmee;
    /**
     * La jauge de Finances
     */
    public static Jauge jaugeFinance;
    public static HashMap<TypeJauge, Integer> jauges = new HashMap<TypeJauge, Integer>();
    public void CreationJauge(){
        jauges.put(TypeJauge.CLERGE, 15 + (int)(Math.random() * (35 - 15)));
        jauges.put(TypeJauge.PEUPLE, 15 + (int)(Math.random() * (35 - 15)));
        jauges.put(TypeJauge.ARMEE, 15 + (int)(Math.random() * (35 - 15)));
        jauges.put(TypeJauge.FINANCE, 15 + (int)(Math.random() * (35 - 15)));
    }

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

        CreationJauge();
        // Initialisation des jauges entre 15 et 35 points
        /*jaugeClerge = new Jauge("Clergé", 15 + (int)(Math.random() * (35 - 15)));
        jaugePeuple = new Jauge("Peuple", 15 + (int)(Math.random() * (35 - 15)));
        jaugeArmee = new Jauge("Armée", 15 + (int)(Math.random() * (35 - 15)));
        jaugeFinance = new Jauge("Finances", 15 + (int)(Math.random() * (35 - 15)));*/
    }

    /* Pour Afficher les nouvelles Jauges voir la class MethodsJauge*/




}
