
public class Bataille extends Action {
    private Joueur adversaire;
    
    public Bataille(Joueur sc, Joueur a) {
        super(sc, "Bataille");
        this.adversaire = a;  
    }

    public Joueur getAdversaire() {
        return adversaire;
    }
    
    public int execute(){
        int res=-1;
        if(this.getJ().getNbCartes()>0 && this.getAdversaire().getNbCartes()>0)
        {
            Personnage c1 = this.getJ().getPaquet().getPerso(0);
            Personnage c2 = this.getAdversaire().getPaquet().getPerso(0);
            this.getJ().getPaquet().retirePerso(c1);
            this.getAdversaire().getPaquet().retirePerso(c2);
            
            if(c1.getValeur()==c2.getValeur()){
                res = 0;
                this.getJ().getPaquet().ajoutePerso(c1);
                this.getAdversaire().getPaquet().ajoutePerso(c2);
            }
            else{
                if(c1.getValeur()>c2.getValeur()){
                    res = 1;
                    this.getJ().getPaquet().ajoutePerso(c1);
                    this.getJ().getPaquet().ajoutePerso(c2);
                }
                else{
                    res = 2;
                    this.getAdversaire().getPaquet().ajoutePerso(c2);
                    this.getAdversaire().getPaquet().ajoutePerso(c1);
                }
            }
        }
            if(this.getJ().getNbCartes()==0 || this.getAdversaire().getNbCartes()==0){
                if(res==1)
                    this.setDeroulement(this.getJ().getPseudo()+" à joué contre "+this.getAdversaire().getPseudo()+" et "+this.getJ().getPseudo()+" à gagné");
                else if(res==2)
                    this.setDeroulement(this.getJ().getPseudo()+" à joué contre "+this.getAdversaire().getPseudo()+" et "+this.getAdversaire().getPseudo()+" à gagné");
            }
            return res;
    }
}
