
public class Jeu {
    private LesPersonnages lesPers;     
    private PlateauJeu monP;
    private LesJoueurs lesJ;
    private int indC;
    private Action act;
    
    public Jeu(LesPersonnages lp, LesJoueurs lj, int nbc){   
        this.lesPers=lp;
        this.monP=new PlateauJeu(nbc);
        this.lesJ=lj;
        this.act=null;
        this.indC=0;
    }

    public LesPersonnages getLesPers() {
        return lesPers;
    }

    public PlateauJeu getMonP() {
        return monP;
    }

    public LesJoueurs getLesJ() {
        return lesJ;
    }

    public int getIndC() {
        return indC;
    }

    public Action getAct() {
        return act;
    }

    public void setIndC(int indC) {
        this.indC = indC;
    }
    
    public int getIndSuivant(int j){
        return (j+1)%lesJ.getNbJoueurs(); 
    }
    public Joueur getJoueurCourant(){
        return lesJ.getJoueur(indC);
    } 
    public Joueur getJoueurSuivant(int j){
        return lesJ.getJoueur(getIndSuivant(j));
    }
    
    public boolean finJeu()  { 
        return monP.jeuVide();
    }
    
    public int nbPers(){
        int n = 0;
        for(int i = 0; i < lesJ.getNbJoueurs(); i++){
            if (i !=this.indC)   
                n+=lesJ.getJoueur(i).getNbCartes();
        }    
        return n;           
    }
    
    public int traiterTour(Joueur jo, int s){
        int bonus = -1;
        Personnage pers = lesPers.getPerso(s);
        jo.getPaquet().ajoutePerso(pers);
        String f = pers.getFamille();
        int npf = lesPers.getPersosFamille(f).getTaille();
        int nbj = jo.getPaquet().getPersosFamille(f).getTaille();
        if(npf==nbj){
            if(jo.getFamille().equals(f)){
                bonus = 0;
                monP.termineJeu();
            }
            else{
                if(nbPers()>0){
                    if(f.equals("rares") || f.equals("communs"))
                        bonus=1;
                    else{
                        if(f.equals("legendaires") || f.equals("epiques"))
                            bonus =2;
                    }
                }
            }
        }
        return bonus;
    }
}
