import java.awt.*;
import javax.swing.*;

public class Personnage {
    //Attributs
    private String famille;//attribut pour la famille du personnage 
    private String nom;//attribut pour le nom du personnage 
    private int valeur;//attribut pour la valeur du personnage 
    private Image photo;//attribut pour la photo du personnage 

    //Constructeur par defaut
    public Personnage(){
        //initialisation des attributs
        this.famille = "anonyme";
        this.nom = "anonyme";
        this.valeur =0;
        this.photo = new ImageIcon(getClass().getResource("")).getImage();
    }
    
    //Constructeur standard
    public Personnage(String s,String p ,int i){
       //initialisation des attributs
       this.famille = s ;
       this.nom = p;
       this.valeur = i;
       this.photo = new ImageIcon(getClass().getResource("/img/"+p+".jpg")).getImage();
   }
    
    //Accesseurs en lecture
    public String getFamille() {
        return famille; //return la famille
    }

    public String getNom() {
        return nom;//return le nom
    }

    public int getValeur() {
        return valeur;//return la valeur du personnage
    }

    public Image getPhoto() {
        return photo;//return la photo du personnage
    }

    //Accesseurs en ecriture
    public void setNom(String nom) {
        this.nom = nom;//modifie le nom
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;//modifie la valeur
    }

    public void setPhoto(Image photo) {
        this.photo = photo;//modifie la photo
    }
    
    
    public void setFamille(String famille) {
        this.famille = famille;//modifie le nom de la famille
    }
    
    //Methode pour afficher la informations des personnages sous forme de chaine de caractère
    public String toString() {
        return nom+ " de la famille " + famille +", valeur : "+valeur+"\n";
    }


}
