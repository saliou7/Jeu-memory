
public class Transfert extends Action{
    
    private Joueur cible;
    private String fp; //famille de la carte sélectionnée
    private LesPersonnages cartesTransferees; // cartes transférées
    
    public LesPersonnages getCartesTransferees(){
        return cartesTransferees;
    }
    
    public Joueur getJoueurCible(){ 
        return this.cible; 
    }
    
    public Transfert(Joueur sc, Joueur c, String f){
        super(sc, "Transfert de cartes");
        this.cible = c;
        this.fp =f;
        this.cartesTransferees= new LesPersonnages();
    }
    
   public int execute(){
       int res = 0;
        if(this.cible.getPaquet().getPersosFamille(fp)!=null){
            this.cartesTransferees=this.cible.getPaquet().retirePersosFamille(fp);
            res = this.cartesTransferees.getTaille();
            this.getJ().getPaquet().ajoutPersos(cartesTransferees);
            this.setDeroulement(getJ().getPseudo()+" a pris la famille "+this.fp+" du joueur "+this.cible.getPseudo());
        }
        return res;
   }
}
