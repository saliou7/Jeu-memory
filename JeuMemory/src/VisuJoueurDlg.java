
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.*;


public class VisuJoueurDlg extends javax.swing.JDialog {
    //Attribut 
    private LesJoueurs lj;//liste des joueurs
    
    public VisuJoueurDlg(java.awt.Frame parent, boolean modal,LesJoueurs lstj) {
        super(parent, modal);//Appel au constructeur au parent 
        initComponents();//Creation de l'interface
        this.lj=lstj;//initialiser l'attribut lj
        initTrombi();//Appel à la methode initTrombi
    }
    
    //Methode pour afficher les informations des joueurs
    private void AfficheInfosJoueur(java.awt.event.ActionEvent evt){ 
        JButton jb = (JButton)evt.getSource(); //transformer le chemin en format JBouton
        int n = Integer.parseInt(jb.getName());//recuperer le nom du bouton en format int
        Edition.setText(lj.getJoueur(n).toString());//afficher l'info du joueur sur la zone de texte
    }
    
    //Methode pour construire 
    private void initTrombi(){
        int nb = this.lj.getNbJoueurs();//recuperer le nombre de joueur dans la liste
        Panneau.setLayout(new GridLayout(1,nb));//mettre dans le panneau un gridLayout d'une ligne et nb colonne
        for (int i=0; i< nb; i++){ //faire une boucle
            JButton jb= new JButton();//ajouter un bouton a chaque tour de boucle
            Joueur j1= lj.getJoueur(i);//recuperer le joueur a cet indice
            jb.setName(""+i);//renommer le nom du bouton
            jb.addActionListener(new java.awt.event.ActionListener() {//un gestionnaire d'événement pour le clic sur un bouton
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AfficheInfosJoueur(evt);//afficher ses informations
                }
            });        
            Panneau.add(jb);//ajout du bouton dans le panneau
        }
        this.pack();// pour ajuster correctement la taille des composants après les ajouts si besoin
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanCentre = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        Panneau = new javax.swing.JPanel();
        Afficher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Choisissez un joueur pour voir ses caractéristiques");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 164, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 164, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        PanCentre.setLayout(new java.awt.BorderLayout());

        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        PanCentre.add(jScrollPane1, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout PanneauLayout = new javax.swing.GroupLayout(Panneau);
        Panneau.setLayout(PanneauLayout);
        PanneauLayout.setHorizontalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );
        PanneauLayout.setVerticalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        PanCentre.add(Panneau, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanCentre, java.awt.BorderLayout.CENTER);

        Afficher.setText("Afficher");
        Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherActionPerformed(evt);
            }
        });
        getContentPane().add(Afficher, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Gestionnaire d'événement pour le clic sur bouton afficher
    private void AfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherActionPerformed
        /*for(int i=0 ; i<lj.getNbJoueurs();i++)//boucle qui parcours la liste
        {
            JButton jb = (JButton)Panneau.getComponent(i); //recuperer le bouton du panneau a cet indice
            jb.setIcon(lj.getJoueur(i).getPhoto());//afficher la photo du joueur 
        }
        */
        for (int i=0; i<this.lj.getNbJoueurs(); i++){ 
        JButton jb= (JButton) Panneau.getComponent(i);
        Joueur j= lj.getJoueur(i);
        Image img = j.getPhoto().getImage().getScaledInstance(jb.getWidth(), jb.getHeight(),Image.SCALE_DEFAULT);
        jb.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_AfficherActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Afficher;
    private javax.swing.JTextArea Edition;
    private javax.swing.JPanel PanCentre;
    private javax.swing.JPanel Panneau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
