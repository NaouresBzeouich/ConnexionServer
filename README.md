# ConnexionServer
le projet est une application qui utilise la librerie RMI du java pour creer une connexion entre un serveur et ses clients 

Ce projet est réalisé par : 
-	 Ben Achour skander gl2/3
-  Bzeouich Naoures  gl2/1 

Titre du projet : 
- Gestion de Connexions
  
Description du travail réalisé : 
- lors de connexion d'un client, la date et le temps exacte de connexion s'enregistre dans les attributs de classe Connexion.
- dans un serveur, il est possible que plusieurs clients se connectent au meme temps
- chaque fois un connecté, il est associé a un numero. le numero 1 est associé au premier client connecté, 2 pour le deuxiemme connecteur et etc ..
- ce numero se décrémente lorsqu'un client dont le numero est inferieur, a quitté le serveur  
- lorsqu'un nouveau client s'est connecté un message contenant le temps exacte de sa connection et son numero apparaissent dans l'ecran du serveur
- lorsqu'un nouveau client s'est connecté un message contenant le nom de client apparaissent dans l'ecran du serveur
- un client connecté dans un serveur a la possibilité d'avoir des informations sur les clients connectés à cet instant
-	Un client ne peut pas connecter deux fois sans qu’il avait fait une déconnexion, s’il essaye de se connecter pour son deuxième fois un message contenant la date et l’heure exacte de sa première connexion va être afficher  
