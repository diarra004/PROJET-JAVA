import java.util.List;
import java.util.Scanner;

public class CLIUtilisateur implements InterfaceUtilisateur {

    private Scanner scanner;

    public CLIUtilisateur() {
        this.scanner = new Scanner(System.in);
    }
    @Override
   
public boolean saisirBoolean(String message) {
    System.out.print(message + " (oui/non) : ");
    String input = scanner.next().toLowerCase();

    if (input.equals("oui") || input.equals("o")) {
        return true;
    } else if (input.equals("non") || input.equals("n")) {
        return false;
    } else {
        System.out.println("Réponse invalide. Veuillez répondre par 'oui' ou 'non'.");
        return saisirBoolean(message); // Redemande la saisie récursivement en cas de réponse invalide
    }
}


    @Override
    public String saisirString(String message) {
        System.out.print(message + ":"); // Affiche le message d'invitation avec un espace à la fin
        return scanner.nextLine(); // Récupère la saisie de l'utilisateur sur la même ligne
    }

    public Utilisateur saisirInformationsUtilisateur() {
        System.out.println("===== Bienvenue dans le gestionnaire de bibliothèque =====");
        String nom = saisirString("Entrez votre nom ");
        int numeroIdentification = saisirEntier("Entrez votre numéro d'identification :");
        return new Utilisateur(nom, numeroIdentification);
    }
    
    

    @Override
    public void afficherMenuPrincipal() {
        System.out.println("===== Menu Principal =====");
        System.out.println("1. Gestion des Livres");
        System.out.println("2. Gestion des Emprunts");
        System.out.println("3. Gestion des Utilisateurs");
        System.out.println("4. Afficher les statistiques de la Biblioteque");
        System.out.println("5. Quitter");
    }




    @Override
    public void afficherMenuGestionLivres() {
        System.out.println("===== Gestion des Livres =====");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Rechercher un livre");
        System.out.println("3. Modifier un livre existant");
        System.out.println("4. Supprimer un livre existant");
        System.out.println("5. Retour au menu principal");
    }

    @Override
    public void afficherMenuGestionEmprunts() {
        System.out.println("===== Gestion des Emprunts =====");
        System.out.println("1. Emprunter un livre");
        System.out.println("2. Retourner un livre");
        System.out.println("3. Afficher les livres empruntés");
        System.out.println("4. Retour au menu principal");
    }

    @Override
    public void afficherMenuGestionUtilisateurs() {
    System.out.println("===== Gestion des Utilisateurs =====");
    System.out.println("1. Ajouter un utilisateur");
    System.out.println("2. Supprimer un utilisateur");
    System.out.println("3. Afficher Liste utilisateur");
    System.out.println("4. Retour au menu principal");


}


    @Override
    public void afficherLivres(List<Livre> livres) {
        System.out.println("===== Liste des Livres =====");
        for (Livre livre : livres) {
            System.out.println(livre);
        }
        System.out.println("=============================");
    }

    @Override
    public void afficherLivresEmpruntes(Utilisateur utilisateur, List<Livre> livres) {
        System.out.println("===== Livres empruntés par " + utilisateur.getNom() + " =====");
        for (Livre livre : livres) {
            System.out.println(livre);
        }
        System.out.println("=============================");
    }

    

    @Override
    public int saisirEntier(String message) {
        System.out.print(message + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez saisir un entier valide.");
            scanner.next(); // Vide la saisie incorrecte
        }
        int entier = scanner.nextInt(); // Récupère l'entier saisi
        scanner.nextLine(); // Nettoie le scanner après la saisie de l'entier
        return entier;
    }
    @Override
public void afficherUtilisateurs(List<Utilisateur> utilisateurs) {
    System.out.println("===== Liste des Utilisateurs =====");
    for (Utilisateur utilisateur : utilisateurs) {
        String etatCotisation = utilisateur.getCotisation() ? "à jour" : "pas à jour";
        System.out.println(utilisateur.getNom() + " - Cotisations : " + etatCotisation);
    }
    System.out.println("=============================");
}

    

    
    
}
