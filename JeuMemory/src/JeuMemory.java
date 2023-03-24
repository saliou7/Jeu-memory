
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;


public class JeuMemory extends javax.swing.JFrame {

    private LesPersonnages persos; //liste des personnages
    private LesJoueurs joueurs;//liste des joueurs
    private Jeu monJeu;
    private int l1,c1,l2,c2;
    private int indC;
    private int bouton1,bouton2;
    //Constructeur
    public JeuMemory() {
        initComponents();//Creation de l'interface
        //initialisation des attributs
        joueurs = new LesJoueurs();
        this.persos = new LesPersonnages(4);
        l1=-1;c1=-1;l2=-1;c2=-1;
        recommencer.setEnabled(false);
        carte.setEnabled(false);
        BJoueurs.setEnabled(false);
        indC =0;
    }
    
    public void startTimer(){// définit un timer qui lance la vérification des deux personnages au bout d'une demi-seconde
        Timer t = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                    verifPersos();
            }
        });
        t.setRepeats(false);
        t.start();
    }
    
    public void ouvreBoite(){
        int v = monJeu.getMonP().getCase(l1, c1);
        String fam = persos.getPerso(v).getFamille();
        int bonus = monJeu.traiterTour(joueurs.getJoueur(indC),v);
            if(bonus>=0){
                Edition.setText("Vous avez gagné tous les personnages de "+fam);
                if(bonus==0){
                    Edition.setText(""+joueurs.getJoueur(indC)+" à gagné");
                }
                else if(bonus==1){
                    TransfertDlg tfd = new TransfertDlg(this,true,joueurs,indC);
                    tfd.setSize(800,800);
                    tfd.setVisible(true);
                    if(tfd.isOk()==true)
                        Edition.setText(""+tfd.getTc().getDeroulement()+"\n\n");
                    else
                        Edition.setText("Transfert annuler\n\n");
                } 
                else if(bonus==2){
                    BatailleDlg btd = new BatailleDlg(this,true,joueurs,indC);
                    btd.setSize(800,800);
                    btd.setVisible(true);
                    Edition.setText(""+btd.getB().getDeroulement()+"\n\n");
                }
                bonus = -1;
            }
    }
    
    public  void  verifPersos(){
        if(monJeu.getMonP().getCase(l1, c1)==monJeu.getMonP().getCase(l2, c2)){
            ouvreBoite();
            this.indC = monJeu.getIndSuivant(indC);//modifier l'indice du joueur
            monJeu.getMonP().invalide(l1, c1, l2, c2);
            
            if(monJeu.getMonP().jeuVide()==true){
                for(int i=0;i<monJeu.getMonP().getNbc()*2;i++){
                    JButton jb1=(JButton)Panneau.getComponent(i);
                    jb1.setEnabled(false);
                }
                
                LesJoueurs gagnants = joueurs.getGagnants();
                if(gagnants.getNbJoueurs()>1)
                    Edition.setText("Le Jeu est Terminé  !!! \n"+JGagnants(gagnants)+" ont gagné");
                else
                    Edition.setText("Le Jeu est Termié !!! \n"+JGagnants(gagnants)+"à gagné"); 
                    NbPersonnage.setText("");NbPersoRestant.setText("");nomJ.setText("FIN DU JEU");
            }
            else{
                int n = joueurs.getJoueur(indC).getNbCartes();
                nomJ.setText("C'est à "+joueurs.getJoueur(indC).getPseudo()+" de jouer !");
                NbPersonnage.setText("Nb de personnages trouvés : "+n);
                NbPersoRestant.setText("Nb de personnages restants : "+(monJeu.getMonP().getNbp()));
                Edition.append(joueurs.getJoueur(indC).toString()+"\n");
                //recuperation des deux boutons
                JButton jb1=(JButton)Panneau.getComponent(bouton1);
                JButton jb2=(JButton)Panneau.getComponent(bouton2);
                jb1.setEnabled(false);jb2.setEnabled(false);//rendre les deux boutons 
            }        
        }
        else{
            //recuperation des deux boutons
            JButton jb1=(JButton)Panneau.getComponent(bouton1);
            JButton jb2=(JButton)Panneau.getComponent(bouton2);
            jb1.setIcon(null);jb2.setIcon(null); //retourner les cartes
            indC = monJeu.getIndSuivant(indC);
            int n = joueurs.getJoueur(indC).getNbCartes();
            nomJ.setText("C'est à "+joueurs.getJoueur(indC).getPseudo()+" de jouer !");
            NbPersonnage.setText("Nb de personnages trouvés : "+n);
            NbPersoRestant.setText("Nb de personnages restants : "+(monJeu.getMonP().getNbp()));   
            Edition.append(joueurs.getJoueur(indC).toString()+"\n");   
        }       
        l1=-1;c1=-1;l2=-1;c2=-1;          
    }

    private void boutonActionPerformed(ActionEvent evt){
        JButton bt=(JButton)evt.getSource();
        int name = Integer.parseInt(bt.getName());// la proprité Name, contient ici le nom du personnage affiché sur le bouton
        int nligne = name/monJeu.getMonP().getNbcol();
        int ncolone = name%monJeu.getMonP().getNbcol();
        int v = monJeu.getMonP().getCase(nligne,ncolone);
        
        Image img = persos.getPerso(v).getPhoto().getScaledInstance(bt.getWidth(), bt.getHeight(),Image.SCALE_DEFAULT);
        bt.setIcon(new ImageIcon(img));
        
        if(c1 == -1 && l1 ==-1){
            l1 = nligne;
            c1 = ncolone;
            bouton1 = Integer.parseInt(bt.getName());
        }
        else if(c2== -1 && l2==-1){
            bouton2 = Integer.parseInt(bt.getName());
            if(bouton1!=bouton2){ //verifier que le meme bouton n'est pas cliqué deux fois
                l2 = nligne;
                c2 = ncolone;
                startTimer();
            }
        }
    }
    
    //Methode qui renvoit le pseudo du ou des gagnant
    public String JGagnants(LesJoueurs j){
        String s = "";
        for(int i=0;i<j.getNbJoueurs();i++){
            s+=j.getJoueur(i).getPseudo()+" ";
        }
        return s;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        NbPersonnage = new javax.swing.JLabel();
        NbPersoRestant = new javax.swing.JLabel();
        nomJ = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        Démarrer = new javax.swing.JButton();
        recommencer = new javax.swing.JButton();
        Panneau = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        parametre = new javax.swing.JMenu();
        Options = new javax.swing.JMenuItem();
        ajoutJoueur = new javax.swing.JMenuItem();
        Visualiser = new javax.swing.JMenu();
        BJoueurs = new javax.swing.JMenuItem();
        carte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 208));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(3, 1));
        jPanel3.add(NbPersonnage);
        jPanel3.add(NbPersoRestant);

        nomJ.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jPanel3.add(nomJ);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        Edition.setEditable(false);
        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        Démarrer.setText("Demarrer");
        Démarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DémarrerActionPerformed(evt);
            }
        });
        jPanel4.add(Démarrer);

        recommencer.setText("Recommencer ");
        recommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recommencerActionPerformed(evt);
            }
        });
        jPanel4.add(recommencer);

        jPanel1.add(jPanel4, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        Panneau.setLayout(new java.awt.GridLayout(4, 5));
        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        parametre.setText("Paramètre");
        parametre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parametreActionPerformed(evt);
            }
        });

        Options.setText("option");
        Options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsActionPerformed(evt);
            }
        });
        parametre.add(Options);

        ajoutJoueur.setText("Ajout Joueur");
        ajoutJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutJoueurActionPerformed(evt);
            }
        });
        parametre.add(ajoutJoueur);

        jMenuBar1.add(parametre);

        Visualiser.setText("Visualiser");

        BJoueurs.setText("Joueurs");
        BJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BJoueursActionPerformed(evt);
            }
        });
        Visualiser.add(BJoueurs);

        carte.setText("Carte");
        carte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carteActionPerformed(evt);
            }
        });
        Visualiser.add(carte);

        jMenuBar1.add(Visualiser);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DémarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DémarrerActionPerformed
        if(joueurs.getNbJoueurs()<2)
            Edition.setText("Le nombre de joueur ne dois être inferieur a 2");
        else{
            Démarrer.setEnabled(false);
            recommencer.setEnabled(true);
            Options.setEnabled(false);
            ajoutJoueur.setEnabled(false);
            carte.setEnabled(true);
            BJoueurs.setEnabled(true);
            
            int n = joueurs.getJoueur(indC).getNbCartes();
            NbPersonnage.setText("Nb de personnages trouvés : "+n);
            NbPersoRestant.setText("Nb de personnages restants : "+(monJeu.getMonP().getNbp()));
            nomJ.setText("C'est à "+joueurs.getJoueur(indC).getPseudo()+" de jouer !");
            Edition.setText(joueurs.getJoueur(indC).toString()+"\n");
            
            int c = monJeu.getMonP().getNbcol();
            int l = monJeu.getMonP().getNblig();
            Panneau.setLayout(new GridLayout(l,c));
            
            for(int i=0;i<persos.getTaille()*2;i++){
                JButton bt =new JButton();
                bt.setName(""+i);
                bt.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        boutonActionPerformed(evt);
                    }
                });
                Panneau.add(bt);
        }
        this.pack();
    }
        
    }//GEN-LAST:event_DémarrerActionPerformed

    private void OptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsActionPerformed
        InitDlg diag = new InitDlg(this,true);//Creation d'une variale diag qui reference la classe InitDlg 
        diag.setSize(900,600);
        diag.setVisible(true);//ouverture de l'interface
        if(diag.isValide()==true)//Accesseur pour recuperer l'indicateur
        {
            for(int i=0;i<diag.getLesJoueurs().getNbJoueurs();i++){//parcourir la liste des joueurs dans InitDlg
                joueurs.ajouteJoueur(diag.getLesJoueurs().getJoueur(i));//ajouter des joueur
            }
            int n = diag.getNiveau();
            this.persos=new LesPersonnages(n);//créer les personnages en fonction du niveau du jeu 
            Edition.setText(this.joueurs.toString());
            monJeu = new Jeu(this.persos,this.joueurs,n);
        }
    }//GEN-LAST:event_OptionsActionPerformed

    private void BJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BJoueursActionPerformed
        VisuJoueurDlg vjd =new VisuJoueurDlg(this, true, this.joueurs);//Creation d'une variale vjd qui reference la classe VisuJoueurDlg 
        vjd.setSize(1000,400);
        vjd.setVisible(true);//Ouvrir l'interface
    }//GEN-LAST:event_BJoueursActionPerformed

    private void parametreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parametreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parametreActionPerformed

    private void carteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carteActionPerformed
        VisuPersonnagesDlg dialog = new VisuPersonnagesDlg(this, true,joueurs.getJoueur(indC));//declaration d'une variable qui référence la classe VusuPersonnages
        dialog.setSize(600,600);
        dialog.setVisible(true);//ouverture de l'interface
    }//GEN-LAST:event_carteActionPerformed

    private void ajoutJoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutJoueurActionPerformed
        SaisieJoueurDlg diag=new SaisieJoueurDlg(this,true,this.persos);//declaration d'une variable qui référence la classe SaisieJoueur
        diag.setSize(600,400);
        diag.setVisible(true);//affiche de l'interface
        if(diag.isValide()==true){//recuperer l'indicateur pour savoir si ça a été fermée par valider ou annuler
            this.joueurs.ajouteJoueur(diag.getJ());//ajouter sur la liste 
            Edition.setText(this.joueurs.toString());
        }
    }//GEN-LAST:event_ajoutJoueurActionPerformed
    
    private void recommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recommencerActionPerformed
        joueurs = new LesJoueurs();
        this.persos = new LesPersonnages();
        Démarrer.setEnabled(true);
        recommencer.setEnabled(false);
        Options.setEnabled(true);
        ajoutJoueur.setEnabled(true);
        carte.setEnabled(false);
        BJoueurs.setEnabled(false);
        Edition.setText("");
        NbPersonnage.setText("");
        NbPersoRestant.setText("");
        nomJ.setText("");
        Panneau.removeAll();
        Panneau.repaint();
        indC=0;
    }//GEN-LAST:event_recommencerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JeuMemory jm = new JeuMemory();
                jm.setSize(1000,800);
                jm.setLocation(200, 0); // ordonnée et abscisse
                jm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BJoueurs;
    private javax.swing.JButton Démarrer;
    private javax.swing.JTextArea Edition;
    private javax.swing.JLabel NbPersoRestant;
    private javax.swing.JLabel NbPersonnage;
    private javax.swing.JMenuItem Options;
    private javax.swing.JPanel Panneau;
    private javax.swing.JMenu Visualiser;
    private javax.swing.JMenuItem ajoutJoueur;
    private javax.swing.JMenuItem carte;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nomJ;
    private javax.swing.JMenu parametre;
    private javax.swing.JButton recommencer;
    // End of variables declaration//GEN-END:variables
}
