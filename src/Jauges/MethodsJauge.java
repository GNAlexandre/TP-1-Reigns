package Jauges;

import main.Genre;
import main.Personnage;

import java.util.HashMap;
import java.util.Map;

public class MethodsJauge extends Personnage {

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
     */

    public static void afficheJauge(HashMap<TypeJauge, Integer> jauges) {
        for(Map.Entry<TypeJauge, Integer> jauge : jauges.entrySet()){
            String resultat = "[" + "#".repeat(Math.max(0, jauge.getValue())) +
                    // on complète avec ____
                    "_".repeat(Math.max(0, 50 - (Math.max(jauge.getValue(), 0)))) +
                    "] " +
                    // affichage du nom
                    jauge.getKey();
            System.out.println(resultat);
        }

    }



    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public static void AfficheJauges(HashMap<TypeJauge, Integer> jauges) {
        afficheJauge(jauges);
        System.out.println();
    }



    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public static boolean finDuJeu(HashMap<TypeJauge, Integer> jauges) {
        for (Map.Entry<TypeJauge, Integer> jauge : jauges.entrySet()) {
            if (jauge.getValue() <= 0 || jauge.getValue() >= 50) {
                System.out.println("La partie est perdue");
                return true;
            }
        }
        return false;
    }


}
