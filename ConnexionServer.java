import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConnexionServer {
    public ConnexionServer() {
    }

    public static void main(String[] args) {
        try {
            // Creer une instance de la classe Connexion
            Connexion connexion = new Connexion();
            // Creer le registre RMI
            Registry registry = LocateRegistry.createRegistry(1099);
            // Enregistrer le service avec un nom dans le registre
            registry.rebind("ConnexionService", connexion);
            // Afficher un message indiquant que le service a ete enregistre
            System.out.println("\n*************************************************** \nLe service de connexion est enregistre.");
        } catch (Exception e) {
            // Afficher un message d'erreur si l'enregistrement du service échoue
            System.err.println("Erreur lors de l'enregistrement du service : " + e.getMessage());
        }

    }

}
