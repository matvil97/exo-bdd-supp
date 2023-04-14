import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import src.models.User;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Connexion à la base de données
            String url = "jdbc:mysql://localhost:8888/GreenScape";
            String user = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);

            
                // Création du DAO pour la table "users"
                UserDao userDao = new UserDao(connection);
            
                // Ajout d'un utilisateur
                User user1 = new User("John Doe", "john.doe@example.com");
                userDao.insert(user1);
            
                // Récupération d'un utilisateur par son identifiant
                User user2 = userDao.select(1);
                System.out.println(user2);
            
                // Mise à jour d'un utilisateur
                user2.setName("Jane Doe");
                userDao.update(user2);
            
                // Suppression d'un utilisateur
                userDao.delete(1);
            
                // Récupération de tous les utilisateurs
                List<User> users = userDao.getAll();
                for (User utilisateur : users) {
                    System.out.println(utilisateur);
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Fermeture de la connexion
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}
            