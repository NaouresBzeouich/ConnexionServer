import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ConnexionClient {
    public ConnexionClient() {
    }
	
	//creation d un scanner 
	 static Scanner scanner = new Scanner(System.in);

    public static void main(String[] var0) {

        // Verifie le nombre d'arguments
        if (var0.length != 1) {
            System.out.println("Usage: java ConnexionClient <nom> ");
            System.exit(1);
        }

        // Initialise la date
        LocalDateTime date = LocalDateTime.now();

        try {
            // Recupere le registre RMI le registre par defaut est 1099
            Registry registry = LocateRegistry.getRegistry(1099);

            // Recupere l'objet distant ConnexionInterface
            ConnexionInterface cnx = (ConnexionInterface) registry.lookup("ConnexionService");

            // Ajoute le client a la liste des personnes connectees
                String nomCl = var0[0];
                String estConnecte = cnx.getDetails(nomCl);
				
				//si le personne n existe pas dans la liste des personnes connectees
                if (estConnecte.equals("false")) {
					// l ajout de personne a la liste et la recuperation de la liste de personnes connectees
                    String allClient = cnx.addConnected(nomCl, date);
					
					//affichage d un message de connexion , le nombre totale des personnes connectees et la liste des noms de ces personnes  
					System.out.println("connexion de client "+ nomCl+"\n \n connecte avec succes ! \n*************************************************** \n********** le client : "+nomCl+					
									   "\n\nle nombre de personnes qui ont connecte  jusqu a maintenant  : " + cnx.getConnected()+
										"\nla liste de personnes connectees : " + allClient );
                    
					//un msg va s afficher au cmd ConnexionServer 
					cnx.registerClient();
                }    
					//si la personne existe deja dans la liste des personnes connectes
				else {
                    System.out.println("Cette personne est deja connecte : " + estConnecte);
					System.exit(1); 
                }
				
				 //msg pour informer le clients  des commandes  possible a executer  
				System.out.println("si vous voulez plus d information sur les clients connectes a l instant tapez: info \nsi vous voulez se deconnecter tapez:exit"); 

				while(true){ 
						//msg pour infomer le client qu il ya un input 
					 System.out.print("\n>"); 
					 
					   //recuperation de l input 
					 String chaine = scanner.nextLine();
					 
					  //traitement si le client demande plus d information 
					 if(chaine.equals("info")){
						System.out.println(cnx.getAllDetails()); 
					 }
					 else{ 
						 //traitement si le client demande de se deconnecter 
						if(chaine.equals("exit")){
								// tester si l'execution a lieu correctement ou il y a un probleme 
								
							if(cnx.removeConnected(nomCl)) {
								//le client se deconnecte 
								System.out.println("\n\n  deconnexion de client :"+ nomCl+"\n*************************************************** \n"); 
								break; 
									}
							else {
								 //il y a un probleme lors de la deconnexion 
								System.out.println("\n\n probleme lors de la deconnexion du client"); 
								System.exit(1);
							} 
							}
						else{	
							// le client demande un traitement invalide 
					 	System.out.println("commande invalide ! "); 
						}
					}
                }
        } catch (Exception e) {
            // Gere les erreurs
            System.err.println("Erreur lors de l'execution du client : " + e.getMessage());
        } 
		scanner.close();
    }
}
