import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface ConnexionInterface extends Remote {

    // Recuprre le nombre de personnes connectes
    int getConnected() throws RemoteException;

    // Ajoute une personne connectee
    String addConnected(String var1, LocalDateTime var2) throws RemoteException;

    // Recupere les details d'une personne connectee
    String getDetails(String var1) throws RemoteException;

    // Enregistre un client
    void registerClient() throws RemoteException;

    // Retire une personne connectee
    boolean removeConnected( String name) throws RemoteException;
	
	//retourner  les personnes connectees avec la date de connexion 
	String getAllDetails() throws RemoteException;

}
