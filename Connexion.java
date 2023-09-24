import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Connexion extends UnicastRemoteObject implements ConnexionInterface {
    private int cpt = 0;
    private List nom = new ArrayList();
    private List dateTime = new ArrayList();

    // constructeur de Connexion qui etend UnicastRemoteObject
    public Connexion() throws RemoteException {
    }

    // methode qui renvoie le nombre de personnes connectees
    public int getConnected() throws RemoteException {
        return this.cpt;
    }

    // methode qui ajoute une personne connectee a la liste
    public String addConnected(String var1, LocalDateTime var2) throws RemoteException {
        this.nom.add(var1);
        this.dateTime.add(var2.toString());
        ++this.cpt;
        return this.nom.toString();
    }

    // methode qui renvoie les details d'une personne connectee
    public String getDetails(String var1) throws RemoteException {
        int var2 = this.nom.indexOf(var1);
        return var2 == -1 ? "false" : var1 + " a connecte a " + String.valueOf(this.dateTime.get(var2));
    }

    // methode qui affiche le nom du nouveau client connecte
    public void registerClient() throws RemoteException {
        System.out.println( " date et heure : " + String.valueOf(this.dateTime.get(this.cpt - 1)) +"\t un  nouveau client " + String.valueOf(this.nom.get(this.cpt - 1)) + " s'est connecte ! ");
    }

    // methode qui supprime une personne de la liste des connectes
    public boolean removeConnected(String name) throws RemoteException {
        int x = nom.indexOf(name);
        if (x != -1) {
			LocalDateTime var = LocalDateTime.now();
			System.out.println(" date et heure : "+var.toString() + "\t"+ name + " a quitte le serveur ; il a connecte "+ dateTime.get(x));
            nom.remove(x);
            dateTime.remove(x);
            cpt--;
            return true;
        }
        return false;
    }
	//methode qui retourner  les personnes connectees avec la date de connexion 
	public String getAllDetails() throws RemoteException{
		String Alldetails = ""; 
		for(int i=0; i<cpt ; i++) {
			Alldetails+= "la personne numero "+i+" : "+nom.get(i)+" avait connecte a : "+ dateTime.get(i)+"\n"; 
		}
		return Alldetails.equals("") ? "aucun personne n est connecte" : Alldetails ; 
	} 
}