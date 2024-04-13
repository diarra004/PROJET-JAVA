import java.util.List; 
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
       
        Bibliotheque bibliotheque = new Bibliotheque();
        
        InterfaceUtilisateur interfaceUtilisateur = new CLIUtilisateur(); // Utilisation de l'interface CLI

        Utilisateur utilisateur = interfaceUtilisateur.saisirInformationsUtilisateur();
        System.out.println("Bienvenue , " + utilisateur.getNom() + " !");

       

        boolean quitter = false;

        while (!quitter) {
            interfaceUtilisateur.afficherMenuPrincipal();
            int choixPrincipal = interfaceUtilisateur.saisirEntier("Choix");

            switch (choixPrincipal) {
                case 1:
                    gererLivres(bibliotheque, interfaceUtilisateur);
                    break;
                case 2:
                    gererEmprunts(bibliotheque, interfaceUtilisateur);
                    break;
                case 3:
                    quitter = true;
                    System.out.println("Merci d'avoir utilisé le gestionnaire de bibliothèque. À bientôt !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
    

    private static void gererLivres(Bibliotheque bibliotheque, InterfaceUtilisateur interfaceUtilisateur) {
        boolean retourMenuPrincipal = false;

        while (!retourMenuPrincipal) {
            interfaceUtilisateur.afficherMenuGestionLivres();
            int choixGestionLivres = interfaceUtilisateur.saisirEntier("Choix");

            switch (choixGestionLivres) {
                case 1:
                    ajouterLivre(bibliotheque, interfaceUtilisateur);
                    break;
                case 2:
                    rechercherLivre(bibliotheque, interfaceUtilisateur);
                    break;
                case 3:
                     // Afficher la liste des livres et permettre à l'utilisateur de choisir le livre à modifier
                List<Livre> livresDansBibliotheque = bibliotheque.getLivres();
                interfaceUtilisateur.afficherLivres(livresDansBibliotheque);

                int choixLivre = interfaceUtilisateur.saisirEntier("Choisissez le numéro du livre à modifier");
                if (choixLivre >= 1 && choixLivre <= livresDansBibliotheque.size()) {
                    Livre livreAModifier = livresDansBibliotheque.get(choixLivre - 1);
                    bibliotheque.modifierLivre(livreAModifier, interfaceUtilisateur);
                    interfaceUtilisateur.afficherLivres(livresDansBibliotheque);
                } else {
                    System.out.println("Numéro de livre invalide.");
                }
                break;
                case 4:
                supprimerLivre(bibliotheque, interfaceUtilisateur);
                    break;
                
                case 5:
                    retourMenuPrincipal = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void ajouterLivre(Bibliotheque bibliotheque, InterfaceUtilisateur interfaceUtilisateur) {
        

        
        String titre = interfaceUtilisateur.saisirString("Titre");
        interfaceUtilisateur.saisirString(""); 
       
        String auteur = interfaceUtilisateur.saisirString("Auteur");
        int anneePublication = interfaceUtilisateur.saisirEntier("Année de publication");
        interfaceUtilisateur.saisirString(""); 

        String isbn = interfaceUtilisateur.saisirString("ISBN");

        Livre nouveauLivre = new Livre(titre, auteur, anneePublication, isbn);
        bibliotheque.ajouterLivre(nouveauLivre);
        System.out.println("Livre ajouté avec succès !");
    System.out.println("Livres dans la bibliothèque :");
    interfaceUtilisateur.afficherLivres(bibliotheque.getLivres());


    }
       
    

    private static void rechercherLivre(Bibliotheque bibliotheque, InterfaceUtilisateur interfaceUtilisateur) {
        
       

        interfaceUtilisateur.saisirString("Entrez le titre, l'auteur ou l'ISBN du livre: ");
        String critere = interfaceUtilisateur.saisirString("");// Lire la saisie de l'utilisateur
        
       

        List<Livre> resultats = bibliotheque.rechercherLivres(critere);

        if (resultats.isEmpty()) {
            System.out.println("Aucun livre trouvé pour ce critère.");
        } else {
            interfaceUtilisateur.afficherLivres(resultats);
        }
    }


    private static void gererEmprunts(Bibliotheque bibliotheque, InterfaceUtilisateur interfaceUtilisateur) {
        // À implémenter : gestion des emprunts
        System.out.println("Fonctionnalité non implémentée.");
    }


    public  static void supprimerLivre(Bibliotheque bibliotheque ,InterfaceUtilisateur interfaceUtilisateur) {
        // Afficher la liste des livres disponibles
        List<Livre> livres = bibliotheque.getLivres();
        interfaceUtilisateur.afficherLivres(bibliotheque.getLivres());
        // Demander à l'utilisateur de choisir le livre à supprimer
        int choixLivre =  interfaceUtilisateur.saisirEntier("Choisissez le numéro du livre à supprimer (0 pour annuler)");

        if (choixLivre == 0) {
            System.out.println("Opération annulée.");
            return;
        }

        // Vérifier si le numéro de livre est valide
        if (choixLivre > 0 && choixLivre <= livres.size()) {
            Livre livreASupprimer = livres.get(choixLivre - 1);
            bibliotheque.supprimerLivre(livreASupprimer);
            System.out.println("Livre supprimé avec succès.");
            interfaceUtilisateur.afficherLivres(bibliotheque.getLivres());
            
        } else {
            System.out.println("Numéro de livre invalide.");
        }
    }

    
}
