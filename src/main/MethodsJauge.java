package main;

public class MethodsJauge extends Personnage{

    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom   Le nom du personnage
     * @param genre Le genre du personnage
     */
    public MethodsJauge(String nom, Genre genre) {
        super(nom, genre);
    }

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     * @param jauge La jauge à afficher
     */

    public static void afficheJauge(Jauge jauge) {
        // valeur : ####
        String resultat = "[" + "#".repeat(Math.max(0, jauge.getValeur())) +
                // on complète avec ____
                "_".repeat(Math.max(0, 50 - (Math.max(jauge.getValeur(), 0)))) +
                "] " +
                // affichage du nom
                jauge.getNom();
        System.out.println(resultat);
    }



    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public static void AfficheJauges() {
        MethodsJauge.afficheJauge(jaugeClerge);
        MethodsJauge.afficheJauge(jaugePeuple);
        MethodsJauge.afficheJauge(jaugeArmee);
        MethodsJauge.afficheJauge(jaugeFinance);
        System.out.println();
    }



    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public static boolean finDuJeu(){
        return Personnage.jaugeClerge.getValeur() <= 0
                || jaugeClerge.getValeur() >= 50
                || jaugePeuple.getValeur() <= 0
                || jaugePeuple.getValeur() >= 50
                || jaugeArmee.getValeur() <= 0
                || jaugeArmee.getValeur() >= 50
                || jaugeFinance.getValeur() <= 0
                || jaugeFinance.getValeur() >= 50;
    }



}
