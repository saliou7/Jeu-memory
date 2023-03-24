
import javax.swing.ImageIcon;

public class Joueur {
    
    //Attributs
    private String pseudo; //attribut pour le pseudo du joueur
    private String famille;//attribut pour la famille du joueur
    private LesPersonnages paquet;//attribut pour les personnages gagnés par un joueur
    private ImageIcon photo;//attribut pour la photo du joueur

    //Constructeur par defaut
    public Joueur() {
        this.pseudo = "Annonyme"; //initialisation du pseudo
        this.famille = "Annonyme";//initialisation de la famille
        this.paquet = new LesPersonnages();//initialisation de paquet  du joueur
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png"));//initialisation du photo du joueur
    }
    
    //Constructeur standart
    public Joueur(String p, String f) { //en paramètre le pseudo et la famille du joueur
        this.pseudo = p;
        this.famille = f;
        this.paquet = new LesPersonnages();;
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png"));;
    }

    //Accesseurs en lecture
    public String getPseudo() {
        return pseudo; //renvois le pseudo du joueur
    }

    public String getFamille() {
        return famille;//renvois la famille du joueur
    }

    public LesPersonnages getPaquet() {
        return paquet;//renvois le paquet du joueur
    }

    public ImageIcon getPhoto() {
        return photo;//renvois l'image du joueur
    }

    
    //Accesseur en ecriture
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo; //affecteur a pseudo le donné nom en paramètre
    }

    public void setFamille(String famille) {
        this.famille = famille;//affecteur a pseudo la donnée en paramètre
    }

    public void setPaquet(LesPersonnages paquet) {
        this.paquet = paquet;//affecteur a pseudo le paquet donné en paramètre
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;//affecteur a pseudo la photo donnée en paramètre
    }
    
    public int getNbCartes() { 
        return this.paquet.getTaille();  
    }

    @Override
    //Methode pour afficher les information sous forme de chaine de caractère
    public String toString() {
        String s= "";
        s+="pseudo :"+this.pseudo+"\nfamille :"+this.famille+"\npaquet :\n"+this.paquet.toString()+"Score :"+getScore()+"\n";
        return s;
    }
    
    //Methode pour recuperer le score du joueur 
    public int getScore(){
        return this.paquet.getScore(); //renvoyer le score du joueur
    }
    
    public void ajoutePersoPaquet(Personnage p) {
        this.paquet.ajoutePerso(p);
    }
    public void initPaquetTest(){
        ajoutePersoPaquet(new Personnage("communs","assault-trooper", 10));
        ajoutePersoPaquet(new Personnage("communs", "commando", 20));
        ajoutePersoPaquet(new Personnage("rares", "absolute-zero", 10));
    }
}
