
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;



public class BatailleDlg extends javax.swing.JDialog {

    private LesJoueurs lj;       //collection des joueurs (en entrée)
    private int indj;            //indice du joueur courant (en entrée)
    private Joueur adversaire;   //adversaire sélectionné (en sortie)
    private boolean ok;          // action faite ou non (en sortie)
    private Bataille b;          // action réalisé
   
    public BatailleDlg(java.awt.Frame parent, boolean modal, LesJoueurs lj, int jc) {
        super(parent, modal);
        initComponents();
        this.lj = lj;
        this.indj = jc;
        this.ok=false;
        this.b=null;
        Annuler.setText("Annuler");
        Annuler.setVisible(false); // aucune bataille existe
        MessageJ.setText(lj.getJoueur(indj).getPseudo()+" va effectuer une bataille contre : ");
        DefaultListModel mod=new DefaultListModel();//Modele pour la JList
        liste.setModel(mod);//ajout des personnages dans la jList(ListeFamillePerso)
        initListeJ();
        Demarrer.setEnabled(false);
    }

    
    public Bataille getB() {
        return b;
    }

    public void initListeJ(){    
        DefaultListModel mod=(DefaultListModel) liste.getModel();
        for(int i=0;i<lj.getNbJoueurs();i++){//parcourir la liste des familles des personnages
            mod.addElement(lj.getJoueur(i).getPseudo());//ajout des familles a la liste 
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        LJoueur = new javax.swing.JLabel();
        LAdversaire = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InfosCarte1 = new javax.swing.JTextArea();
        Carte1 = new javax.swing.JButton();
        Carte2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        InfosCarte2 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        MessageJ = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        liste = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        vainqueur = new javax.swing.JLabel();
        Annuler = new javax.swing.JButton();
        Demarrer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        LJoueur.setText("jLabel1");
        jPanel5.add(LJoueur);

        LAdversaire.setText("LAdversaire");
        jPanel5.add(LAdversaire);

        jPanel1.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.GridLayout(1, 4));

        InfosCarte1.setEditable(false);
        InfosCarte1.setColumns(20);
        InfosCarte1.setRows(5);
        jScrollPane1.setViewportView(InfosCarte1);

        jPanel6.add(jScrollPane1);

        Carte1.setText("jButton1");
        jPanel6.add(Carte1);

        Carte2.setText("jButton1");
        jPanel6.add(Carte2);

        InfosCarte2.setEditable(false);
        InfosCarte2.setColumns(20);
        InfosCarte2.setRows(5);
        jScrollPane2.setViewportView(InfosCarte2);

        jPanel6.add(jScrollPane2);

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));
        jPanel3.add(MessageJ);

        liste.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        liste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(liste);

        jPanel3.add(jScrollPane3);

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.GridLayout(1, 3));

        vainqueur.setBackground(new java.awt.Color(174, 227, 76));
        vainqueur.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vainqueur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vainqueur.setText("Vainqueur");
        jPanel4.add(vainqueur);

        Annuler.setText("Annuler/Fermer");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel4.add(Annuler);

        Demarrer.setText("Demarrer");
        Demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DemarrerActionPerformed(evt);
            }
        });
        jPanel4.add(Demarrer);

        getContentPane().add(jPanel4, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        this.ok=false;
        if (Annuler.getText().equals("Annuler")){
            this.b.setDeroulement("Bataille interrompue en cours de partie");
            this.setVisible(false);
            this.dispose();}
        if (Annuler.getText().equals("Fermer")){
            this.b.setDeroulement(b.getDeroulement());
            this.ok=true;
            this.setVisible(false);
            this.dispose();}
    }//GEN-LAST:event_AnnulerActionPerformed

    private void DemarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DemarrerActionPerformed
        Image img1 = lj.getJoueur(indj).getPaquet().getPerso(0).getPhoto().getScaledInstance(Carte1.getWidth(), Carte1.getHeight(),Image.SCALE_DEFAULT);
        Carte1.setIcon(new ImageIcon(img1));
        Image img2 = adversaire.getPaquet().getPerso(0).getPhoto().getScaledInstance(Carte2.getWidth(), Carte2.getHeight(),Image.SCALE_DEFAULT);
        Carte2.setIcon(new ImageIcon(img2));
        InfosCarte1.append(lj.getJoueur(indj).getPseudo()+" à joué  :"+lj.getJoueur(indj).getPaquet().getPerso(0).toString());
        InfosCarte2.append(adversaire.getPseudo()+" à joué  :"+adversaire.getPaquet().getPerso(0).toString());
        int res = b.execute();
       
        if(res == 1){
            InfosCarte1.append(lj.getJoueur(indj).getPseudo()+" gagne\n"+lj.getJoueur(indj).getPaquet().toString()+"\n");
            InfosCarte2.append(adversaire.getPseudo()+" perd\n"+adversaire.getPaquet().toString()+"\n");
            vainqueur.setText(""+lj.getJoueur(indj).getPseudo());
        }
        else if(res == 2){
            InfosCarte1.append(lj.getJoueur(indj).getPseudo()+" perd\n"+lj.getJoueur(indj).getPaquet().toString()+"\n");
            InfosCarte2.append(adversaire.getPseudo()+" gagne\n"+adversaire.getPaquet().toString()+"\n");
            vainqueur.setText(""+adversaire.getPseudo());
        }
        else if(res ==0){
            InfosCarte1.append(lj.getJoueur(indj).getPseudo()+" null\n"+lj.getJoueur(indj).getPaquet().toString()+"\n");
            InfosCarte2.append(adversaire.getPseudo()+" null\n"+adversaire.getPaquet().toString()+"\n");
            vainqueur.setText("Null");
        }
        
        if(this.lj.getJoueur(indj).getNbCartes()==0 || this.adversaire.getNbCartes()==0){
            Demarrer.setEnabled(false);
            Annuler.setText("Fermer");
            }
        liste.setEnabled(false);
    }//GEN-LAST:event_DemarrerActionPerformed

    private void listeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeMouseClicked
                int i=liste.getSelectedIndex(); //recuperer l'indice de l'element selectioné
                adversaire = lj.getJoueur(i);
        if(i != -1){
            if(i==indj){
                System.out.println("Veuillez choisir un autre joueur");
            }
            else{
                Demarrer.setEnabled(true);
                b = new Bataille(lj.getJoueur(indj),adversaire);
                Annuler.setVisible(true);
                LJoueur.setText(""+lj.getJoueur(indj).getPseudo());
                LAdversaire.setText(""+adversaire.getPseudo());
                InfosCarte1.setText(""+lj.getJoueur(indj).getPaquet()+"\n");
                InfosCarte2.setText(""+adversaire.getPaquet().toString()+"\n");
            }
        }
    }//GEN-LAST:event_listeMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JButton Carte1;
    private javax.swing.JButton Carte2;
    private javax.swing.JButton Demarrer;
    private javax.swing.JTextArea InfosCarte1;
    private javax.swing.JTextArea InfosCarte2;
    private javax.swing.JLabel LAdversaire;
    private javax.swing.JLabel LJoueur;
    private javax.swing.JLabel MessageJ;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> liste;
    private javax.swing.JLabel vainqueur;
    // End of variables declaration//GEN-END:variables
}
