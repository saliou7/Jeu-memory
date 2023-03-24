
import java.util.ArrayList;


public class LesJoueurs {
    
    private ArrayList<Joueur>lstJ; //declaration d'une liste des joueurs
    
    //Constructeur par defaut
    public LesJoueurs(){ 
        this.lstJ = new ArrayList<Joueur>(); //initialisation de la liste des joueurs
    }
    
    //Methode pour recuperer un joueur dans la liste des joueurs
    public Joueur getJoueur(int i){ //l'indice du jouer à recuperer 
        if(i>=0 && i<this.lstJ.size()) //verifier que l'indice ne depasse pas la taille de la liste et quel n'est pas inferieur a 0;
            return this.lstJ.get(i); //retourner le joueur a cet indice
        else
            return null;//s'il n'existe pas retourner null
    }
    
    //Methode pour recuperer l'indice d'un joueur
    public int getIndiceJoueur(Joueur j){ //donner le joueur en paramètre 
         int x = this.lstJ.indexOf(j); //recuperer dans la liste l'indice de ce joueur 
         return x; //retourner l'indice 
    }
    
    public int getNbJoueurs(){
        return this.lstJ.size();//retourner la taille de la liste des joueurs
    }
    
    //Methode pour ajouter un joueur
    public void ajouteJoueur(Joueur j){//donner le joueur à ajouter en paramètre
        this.lstJ.add(j);//ajouter ce joueur à  la liste 
    }
    
    //Methode pour rechercher un joueur avec un pseudo
    public Joueur rechJoueur(String p){//donner en paramètre le pseudo à rechercher
        int i = 0; Joueur x=null;
        while(i<this.lstJ.size()){//parcourir la liste des joueurs
            if(p.equals(lstJ.get(i).getPseudo())){//comparer le pseudo en paramètre avec les pseudo dans la liste
            x= this.lstJ.get(i); //recuperer l'indice du pseudo
            return x; //Retourner l'indice
            }
            i++; 
        }
        return x; //retourner l'indice s'il est trouvé sinon retourner null
    }
    
    //Methode pour supprimer un joueur
    public  void  supprimeJoueur(Joueur j){ //donner en paramètre le joueur à supprimer 
        for (int i=0; i<this.lstJ.size();i++){//parcourir la liste des joueurs
            if(j.equals(lstJ.get(i).getPseudo()))//trouver le joueur
                this.lstJ.remove(i);//supprimer
        }
    }
    //Methode pour afficher la listes des joueurs sous forme de chaine de caractère
    public String toString(){
        String s="";
        for(int i=0;i<this.lstJ.size();i++){
            s+=(i+1)+"-"+getJoueur(i).toString()+"\n";
        }
        return s;
    }
    
    //Methode pour recuperer le joueur gagnant
    public LesJoueurs getGagnants(){
        int max=getJoueur(0).getScore();//recuperer le score du premier joueur
        for(int i=1; i<getNbJoueurs();i++){// parcourir le liste des joueurs 
            if (getJoueur(i).getScore()>max)// verifier si le score de l'indice du joueur selectionné est superieur a celui de max 
                max=this.getJoueur(i).getScore();// stocker le scrore du joueur selectionné
        }
        LesJoueurs lst=new LesJoueurs(); // creer une variable de type LesJoueur ;
        for(int i=0; i<getNbJoueurs();i++)//parcourir le liste des joueurs
            if (getJoueur(i).getScore()==max) // chercher le joueur qui a le scrore le plus elevé
                lst.ajouteJoueur(getJoueur(i)); // ajouter le joueur a lst
        return lst;// retourner lst
    } 
}
