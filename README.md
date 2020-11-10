# TA72-brainstorming

security:
	utilisation d'une authentification pour certaines pages
	-les pages accessibles par tous sont listées dans WebSecurityConfig sous authorizeRequests
	-utilisation pour le moment d'un user 'user'et password 'password' (renseigné et modifiable dans WebSecurityConfig méthode userDetailsService) 
	
	json messages
	params : id_user , token
	renvoi : liste discussions(id_discussion, nom_destinataire, dernier message)
	
	params : id_discussion , token
	renvoi : liste messages(id_message, contenu, heure)