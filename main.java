import java.util.List; 
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
                    retourMenuPrincipal = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void ajouterLivre(Bibliotheque bibliotheque, InterfaceUtilisateur interfaceUtilisateur) {

        
        String titre = interfaceUtilisateur.saisirString("Titre");
        String auteur = interfaceUtilisateur.saisirString("Auteur");
        int anneePublication = interfaceUtilisateur.saisirEntier("Année de publication");
        interfaceUtilisateur.saisirString(""); 

        String isbn = interfaceUtilisateur.saisirString("ISBN");

        Livre nouveauLivre = new Livre(titre, auteur, anneePublication, isbn);
        bibliotheque.ajouterLivre(nouveauLivre);
        System.out.println("Livre ajouté avec succès !");

        List<Livre> livresDansBibliotheque = bibliotheque.getLivres();
        System.out.println("Livres dans la bibliothèque :");
    for (Livre livre : livresDansBibliotheque) {
        System.out.println(livre.getTitre() + " - " + livre.getAuteur());
    }
       
    }

    private static void rechercherLivre(Bibliotheque bibliotheque, InterfaceUtilisateur interfaceUtilisateur) {
        String critere = interfaceUtilisateur.saisirString("Entrez le titre, l'auteur ou l'ISBN du livre");
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

    
}
