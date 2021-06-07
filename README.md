# AuctionProject
 Projet application web d'enchères en ligne
 
PATCH NOTES
 
Màj 040621 (Mickael) :
 
1 - Pour s'inscrire le pseudo et l'email sont uniques. Si un utilisateur est déjà enregistré dans BDD avec soit le même pseudo soit le même email : message d'erreur avec bouton de retour au formulaire.
2 - Il est désormais possible de se connecter au choix, via le même champ, soit avec son email soit avec son pseudo.
3 - Le pseudo est désormais limité à 3 caractères minimum et 15 maximum. Et il ne peut contenir que des caractères alphanumériques.
3b - Lors de l'affichage du dépassement de limite de caractères un message apparaît mais la session garde en mémoire les saisies de l'utilisateur dans les champs du formulaire, il n'a donc plus besoin de le remplir à nouveau.
4 - Ajout d'une exception personnalisé pour la classe Utilisateur. Jeux de thows depuis la DAL jusqu'a l'IHM, puis gestion de l'affichage en conséquence.
5 - Màj mineures et optimisation du code + ajout de commentaires et de javadoc.

*************************************

Màj 040621b (Mickael) :

1 - Au niveau de l'inscription, si l'utilisateur rentre un pseudo ou un email déjà utilisé par un membre, il n'y a plus de message d'erreur. Un simple avertissement apparait en haut de la page et la session garde en mémoire les saisie de l'utilisateur dans les champs du formulaire ormis le pseudo et l'email.
2 - Les sessions ouvertes suite aux erreurs d'inscription (dépassement de la limite de caractères du pseudo et identifiants déjà utilisés) ont été écourté à 1 seconde pour éviter le cumul d'avertissement.