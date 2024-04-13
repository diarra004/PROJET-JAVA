import java.sql.Connection;


public class DatabaseTest {
    public static void main(String[] args) {
        // Créer une instance de DatabaseManager
        DatabaseManager databaseManager = new DatabaseManager();

        // Récupérer la connexion à la base de données
        Connection connection = databaseManager.getConnection();

        if (connection != null) {
            System.out.println("Connexion à la base de données établie avec succès.");
            
            // Vous pouvez effectuer d'autres opérations avec la connexion ici...

            // Fermer la connexion après utilisation
            databaseManager.closeConnection();
        } else {
            System.out.println("La connexion à la base de données a échoué.");
        }
    }
}
