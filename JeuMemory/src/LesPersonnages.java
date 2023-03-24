import java.util.*;
public class LesPersonnages {
    
    private ArrayList<Personnage> persos; //delaration d'une liste ou un tableau de personnages
    
    //Constructeur par defaut
    public LesPersonnages() {
       //initialisation de l'attribut
        this.persos = new ArrayList<Personnage>();
    }
    
    //Accesseurs en lecture
    public ArrayList<Personnage> getPersos() {
        return persos;
    }
       
    public int getTaille() { 
         return this.persos.size(); 
    }
    
    //Methode pour recuperer le score
    public int getScore(){   
        int sc = 0;
        for(int i=0; i<getTaille(); i++)//parcourir la liste des personnages
           sc+=getPerso(i).getValeur(); //recuperer la valeur chaque personnage et additionner
        return sc;//retourner la valeur
    }
    
    //Méthode pour recuperer un personnage
    public Personnage getPerso(int i){//donner l'indice du personnage à recuperer 
        if (i>=0 && i<this.persos.size())//verifier que l'indice ne depasse pas la taille de la liste et quel n'est pas inferieur a 0;
             return this.persos.get(i);//retourner le joueur a cet indice s'il est trouvé
        else return null;//Sinon retourner null
    }
    
    //Méthode pour recuperer les personnages d'une même famille
    public LesPersonnages getPersosFamille(String f)//donner le nom de la famille en paramètre
    {   LesPersonnages lp = new LesPersonnages();
        for(int i=0; i<getTaille(); i++)//parcourir la liste
            if(getPerso(i).getFamille().equals(f))//verifier les personnages qui sont de la famille donnée en paramètre
                lp.ajoutePerso(getPerso(i));//ajouter ces personnages dans la liste lp
        return lp;//retourner la liste
    }
    
    //Methode pour supprimer un personnage
    public void retirePerso(Personnage p)//donner le personnage à supprimer en paramètre
    { 
        int i=0; 
        boolean trouve = false;//on suppose que le personnage n'est pas trouvé
        while(i<getTaille() && !trouve){//parcourir la liste 
          if (getPerso(i).getNom().equals(p.getNom())){//faire une verification
              this.persos.remove(i);  //supprimer le personnage
              trouve = true;//personnage trouvé
          }
          else i++;
        }      
    }
    
    //Méthode supprimer a supprimer 
    public LesPersonnages retirePersos(int n)//donner l'indice du personnage à supprimer 
    { LesPersonnages lcr = new LesPersonnages();//créer un nouveau personnage
        for (int i=0; i<=n; i++)//parcourir la liste jusqu'a l'indice du personnage
        {
            lcr.ajoutePerso(getPerso(0));
            this.persos.remove(0);  
        }
        return lcr;
    } 
    
    public LesPersonnages retirePersosFamille(String f)
    { 
        LesPersonnages lcr = new LesPersonnages();
        int i = 0;
        while(i<getTaille()){
            if (getPerso(i).getFamille().equals(f)) {
                lcr.ajoutePerso(getPerso(i));
                this.persos.remove(i);  
            }
            else i++;
        }
        return lcr;
    }
    
    //Methode pour ajouter un personnage
    public void ajoutePerso(Personnage p){//donner le personnage à ajouter en paramètre
        this.persos.add(p);//ajouter le personnage dans la liste des personnages
    }
    
    //Méthode pour des personnages
    public void ajoutPersos(LesPersonnages lp){//donner la liste des personnages à ajouter
        for(int i=0 ; i<lp.getTaille();i++){//parcourir la liste
            this.persos.add(lp.getPerso(i));//ajouter tous les personnages de la liste
        }
    }
    
    //Méthode pour retirer toutes les cartes
    public void retireCartes()
    { 
           persos.clear();//effacer toutes les cartes de la liste
    }
    
	@Override
    public String toString() {
        String s = "";
        for(int i=0; i<getTaille(); i++)
            s+=i+1+"- "+getPerso(i).toString();
       return s;
    }
	
  
    public ArrayList<String> getFamilles(){ 
      ArrayList<String> lp=new ArrayList<String>();
      for(int i=0;i<this.persos.size();i++){//parcourir la boucle des personnages
          Personnage p=this.getPerso(i); //recuperer le personnage
          boolean trouve=false; // on suppose qu'on a pas trouvé
          for(int j=0;j<lp.size();j++){ //parcourir la liste
              if(lp.get(j).equals(p.getFamille()))//faire la verification
               trouve=true;
          }
          if(!trouve){
              lp.add(p.getFamille());//ajouter la famille a la liste 
          }
      }
      return lp;
   }
    
    //Methode pour ajouter tous les personnages
    public LesPersonnages(int nc) { //donner le nombre en paramètre
        this.persos = new ArrayList<Personnage>();
        if (nc >= 4){ // 2 familles
            ajoutePerso(new Personnage("communs", "assault-trooper", 10));
            ajoutePerso(new Personnage("communs", "commando", 20));
            ajoutePerso(new Personnage("rares", "absolute-zero", 10));
            ajoutePerso(new Personnage("rares", "arctice-assassin", 20));
        }
        if (nc >= 10){ // 4 familles
            ajoutePerso(new Personnage("communs", "devestrator", 30));
            ajoutePerso(new Personnage("rares", "brawler", 30));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-can", 20));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace", 10));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-can", 20));
        }
        if (nc >= 18){ // 6 familles

            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-chn", 30));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-chn", 30));
            ajoutePerso(new Personnage("legendaires", "power-chord", 10));
            ajoutePerso(new Personnage("legendaires", "raptor", 20));
            ajoutePerso(new Personnage("legendaires", "raven", 30));
            ajoutePerso(new Personnage("epiques", "burnout", 10));
            ajoutePerso(new Personnage("epiques", "funk-ops", 20));
            ajoutePerso(new Personnage("epiques", "rex", 30));
        }
        if (nc == 32){ // 6 familles
            ajoutePerso(new Personnage("communs", "dominator", 40));
            ajoutePerso(new Personnage("communs", "highrise-assault-trooper", 50));
            ajoutePerso(new Personnage("communs", "jungle-scout", 60));
            ajoutePerso(new Personnage("communs", "pathfinder", 70));
            ajoutePerso(new Personnage("rares", "brilliant-striker", 40));
            ajoutePerso(new Personnage("rares", "brite-bomber", 50));
            ajoutePerso(new Personnage("rares", "circuit-breaker", 60));
            ajoutePerso(new Personnage("rares", "dazzle", 70));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-fra", 40));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-gbr", 50));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-fra", 40));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-gbr", 50));
            ajoutePerso(new Personnage("legendaires", "red-knight", 40));
            ajoutePerso(new Personnage("epiques", "shadow-ops", 40));
        }
    }
}
