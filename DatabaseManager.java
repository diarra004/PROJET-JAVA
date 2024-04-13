import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/ma_bibliotheque";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection connection;

    public DatabaseManager() {
     

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Établir la connexion à la base de données
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion à la base de données établie avec succès.");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : Pilote JDBC MySQL introuvable.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion à la base de données fermée.");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}
