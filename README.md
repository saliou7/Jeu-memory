# Explication

Actions à réaliser avant le démarrage :
Avant le démarrage, on peut réaliser diverses actions à savoir :

❖ Accéder à la sous-option « Options » du menu « Paramètre » pour ouvrir la boite 
de dialogue InitDlg afin de choisir le niveau du jeu (par défaut on a le niveau 
enfant avec 8 cartes) et les joueurs (crées par défaut) tout en ayant un aperçue 
(photo et informations) de chacun d’entre eux avant de valider. Une fois 
valider, on reçoit les informations des personnages choisit dans la zone 
d’édition de la fenêtre principale ;

❖ Accéder à la sous-option « Ajout Joueur » du menu « Paramètre » pour ouvrir la 
boite de dialogue SaisieJoueurDlg afin crée un joueur en saisissant son nom dans 
la zone d’édition, choisissant la famille préférée du personnage en fonction du 
niveau de jeu défini au préalable et choisir une photo dans notre répertoire avant de valider. Une fois valider, on reçoit les informations des personnages 
ou du personnage crée dans la zone d’édition de la fenêtre principale ;

❖ Accéder à la sous-option « Joueurs » du menu « Visualiser » pour ouvrir la boite 
de dialogue VisuJoueursDlg afin de revoir les photos des joueurs par défaut
choisit dans InitDlg ou des personnages crée dans SaisieJoueursDlg ou voir les 
caractéristiques dans la zone d’édition en appuyant sur photo.
NB : Avant d’appuyer sur Demarrer il faut s’assurer d’avoir un minimum de 2joueurs



Actions à effectuer ou possibles pendant le jeu :
Pendant le jeu diverses actions possibles et peuvent être effectuer à savoir :

❖ En fonction du joueur courant on peut cliquer (retourner) les cartes se trouvant 
dans le panel à droite pour voir le personnage(photo) caché derrière et si deux 
cartes sont semblables elles sont rendues invisibles (grise et non cliquable) et 
on a notre score qui augmente en s’affichant dans la zone d’édition avec les ses 
autres informations, dans les labels on remarque le nombre personnages trouvé et 
restant et aussi à qui le tour ;

❖ Les sous-options du Menu « Paramètres » et le bouton « Démarrer » sont bloqués ;

❖ On peut toujours accéder à la sous-options « Joueurs » du menu « Visualiser » 
pour la visualisation des joueurs comme expliquer précédemment. Encore plus, on 
peut accéder à la sous-options « Cartes » du même menu, ouvrir la boite de 
dialogue VisuPersonnagesDlg pour visualiser les photos (cartes gagnés) du 
personnage courant en appuyant sur « Afficher » et aussi voir son score ;

❖ Une bataille est déclenchée lorsque le joueur courant gagne tous les personnages 
de la famille « legendaires » ou « epiques ». Pour permettre cette bataille, la 
boite de dialogue BatailleDlg s’ouvre ;

❖ Un transfert est réalisé lorsque le joueur courant gagne tous les personnages de 
la famille « rares » ou « communs » à condition qu’il ne soit pas de ces 
familles (sa famille préférée differente de « rares » et « communs »). Pour 
permettre ce transfert la boite de dialogue TransfertDlg s’ouvre.
NB : À tout moment on peut recommencer le jeu après démarrage.



Actions liées à l’arrêt du jeu :
L’arrêt du jeu est lié à l’une de ces deux possibilités à savoir :
1- Si toutes les cartes sont retournées ou
2- Si l’un des joueurs gagne tous les personnages de sa famille préférée.
De là, on a les informations du gagnant ou des gagnants en cas d’égalité qui 
s’affiche dans la zone d’édition à l’aide de la méthode getGagnants() avec un petit 
message de félicitations et de fin du jeu dans les labels « jLabel3 » et 
« jLabel2 »
