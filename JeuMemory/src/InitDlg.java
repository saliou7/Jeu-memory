
import java.awt.Image;
import javax.swing.ImageIcon;


public class InitDlg extends javax.swing.JDialog {
    
    //Attributs
    private LesJoueurs lesjoueurs;//liste des joueurs
    private int niveau;//niveau du jeu
    private boolean valide;//l'indicateur

    //Accesseurs en lecture
    public int getNiveau() {
        return niveau;//renvois le niveau du jeu
    }

    public boolean isValide() {
        return valide;//renvois un boolean true ou false
    }
    
    public LesJoueurs getLesJoueurs(){
        return lesjoueurs;//renvois la liste des joueurs
    } 
    
    //Constructeur
    public InitDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);//appel au constructeur parent JDialog
        initComponents();//Creation de l'interface
        //initialisation des attributs
        lesjoueurs = new LesJoueurs();
        this.valide=false;
        this.niveau=4;//mettre le niveau de jeu a 4
        enfant.setSelected(true);//cocher la case radion enfant
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        enfant = new javax.swing.JRadioButton();
        débutant = new javax.swing.JRadioButton();
        avancé = new javax.swing.JRadioButton();
        expert = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        CaseLara = new javax.swing.JCheckBox();
        CaseJack = new javax.swing.JCheckBox();
        CaseJean = new javax.swing.JCheckBox();
        CaseAmadeus = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        BPhoto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choisissez la taille du jeu");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel4.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.GridLayout(4, 1));

        buttonGroup1.add(enfant);
        enfant.setText("enfant(4 personnage,2 familles)");
        enfant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enfantActionPerformed(evt);
            }
        });
        jPanel6.add(enfant);

        buttonGroup1.add(débutant);
        débutant.setText("débutant(10 personnages, 2 familles)");
        débutant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                débutantActionPerformed(evt);
            }
        });
        jPanel6.add(débutant);

        buttonGroup1.add(avancé);
        avancé.setText("avancé (18 personnages, 4 familles)");
        avancé.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avancéActionPerformed(evt);
            }
        });
        jPanel6.add(avancé);

        buttonGroup1.add(expert);
        expert.setText("expert (32 personnages, 6 familles)");
        expert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expertActionPerformed(evt);
            }
        });
        jPanel6.add(expert);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Choisissez les joueurs créés par défaut ");
        jPanel5.add(jLabel2, java.awt.BorderLayout.NORTH);

        jPanel7.setLayout(new java.awt.GridLayout(4, 1));

        CaseLara.setText("Lara");
        CaseLara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseLaraActionPerformed(evt);
            }
        });
        jPanel7.add(CaseLara);

        CaseJack.setText("Jack");
        CaseJack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseJackActionPerformed(evt);
            }
        });
        jPanel7.add(CaseJack);

        CaseJean.setText("Jean-Sébastien");
        CaseJean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseJeanActionPerformed(evt);
            }
        });
        jPanel7.add(CaseJean);

        CaseAmadeus.setText("Amadeus");
        CaseAmadeus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseAmadeusActionPerformed(evt);
            }
        });
        jPanel7.add(CaseAmadeus);

        jPanel5.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        Edition.setEditable(false);
        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        jPanel2.add(jScrollPane1);
        jPanel2.add(BPhoto);

        getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel3.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        jPanel3.add(Valider);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Gestionnaire du clic sur le bouton valider
    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        if(CaseJack.isSelected()){//verifier si la case est coché
            Joueur j=new Joueur("Jack","rare");//creation d'un nouveau joueur
            lesjoueurs.ajouteJoueur(j);//ajouter le joueur dans la liste
            j.setPhoto(new javax.swing.ImageIcon(getClass().getResource("/img/jack.png")));//lui attribuer une photo
        }//Même code pour les autres boutons CheckBox
        if(CaseLara.isSelected()){
            Joueur j=new Joueur("Lara","epiques");
            lesjoueurs.ajouteJoueur(j);
            j.setPhoto(new javax.swing.ImageIcon(getClass().getResource("/img/lara.jpg")));
        }
        if(CaseJean.isSelected()){
            Joueur j=new Joueur("Jean-Sebastien","alpins-femmes");
            lesjoueurs.ajouteJoueur(j);
            j.setPhoto(new javax.swing.ImageIcon(getClass().getResource("/img/bach.jpg")));
    
        }
        if(CaseAmadeus.isSelected()){
            Joueur j=new Joueur("Amadeus","communs");
            lesjoueurs.ajouteJoueur(j);
            j.setPhoto(new javax.swing.ImageIcon(getClass().getResource("/img/joueurDefaut.png")));
    
        }
        this.valide=true;
        this.setVisible(false);//Fermeture de l'interface
        this.dispose();
    }//GEN-LAST:event_ValiderActionPerformed

    //Gestionnaire du clic sur le bouton radio avancé
    private void avancéActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avancéActionPerformed
        this.niveau=18;
    }//GEN-LAST:event_avancéActionPerformed

    //Gestionnaire du clic sur le bouton CheckBox lara
    private void CaseLaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseLaraActionPerformed
        Joueur j=new Joueur("Lara", "epiques"); //Creation du joueur
        j.setPhoto(new ImageIcon(getClass().getResource("/img/lara.jpg")));//attribuer une photo au joueur
        Edition.setText(j.toString());//afficher ses informations dans la zone d'edtion 
        Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(), BPhoto.getHeight(), Image.SCALE_SMOOTH);//dimensionner la photo
        BPhoto.setIcon(new ImageIcon(img));//Afficher sa photo sur le bouton BPhoto
        //Même code pour les autres boutons checkbox
    }//GEN-LAST:event_CaseLaraActionPerformed

    ////Gestionnaire du clic sur le bouton CheckBox jack
    private void CaseJackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseJackActionPerformed
        Joueur j=new Joueur("Jack", "rares");
        j.setPhoto(new ImageIcon(getClass().getResource("/img/jack.png")));
        Edition.setText(j.toString());
        Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(), BPhoto.getHeight(), Image.SCALE_SMOOTH);
        BPhoto.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_CaseJackActionPerformed

    //Gestionnaire du clic sur le bouton CheckBox Jean-Sébastien
    private void CaseJeanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseJeanActionPerformed
        Joueur j=new Joueur("Jean-Sébastien", "alpins-femmes");
        j.setPhoto(new ImageIcon(getClass().getResource("/img/bach.jpg")));
        Edition.setText(j.toString());
        Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(), BPhoto.getHeight(), Image.SCALE_SMOOTH);
        BPhoto.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_CaseJeanActionPerformed

    //Gestionnaire du clic sur le bouton CheckBox Amadeus
    private void CaseAmadeusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseAmadeusActionPerformed
        Joueur j=new Joueur("Amadeus", "communs");
        j.setPhoto(new ImageIcon(getClass().getResource("/img/joueurDefaut.png")));
        Edition.setText(j.toString());
        Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(), BPhoto.getHeight(), Image.SCALE_SMOOTH);
        BPhoto.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_CaseAmadeusActionPerformed

    //Gestionnaire du clic sur le bouton radio enfant
    private void enfantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enfantActionPerformed
        this.niveau=4;
    }//GEN-LAST:event_enfantActionPerformed

    //Gestionnaire du clic sur le bouton radio debutant
    private void débutantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_débutantActionPerformed
        this.niveau=10;
    }//GEN-LAST:event_débutantActionPerformed

    //Gestionnaire du clic sur le bouton radio expert
    private void expertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expertActionPerformed
        this.niveau=32;
    }//GEN-LAST:event_expertActionPerformed

    //Gestionnaire du clic sur le bouton Annuler
    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        this.setVisible(false);//fermer l'interface
        this.valide=false;//passer valide a false
        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

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
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InitDlg dialog = new InitDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JButton BPhoto;
    private javax.swing.JCheckBox CaseAmadeus;
    private javax.swing.JCheckBox CaseJack;
    private javax.swing.JCheckBox CaseJean;
    private javax.swing.JCheckBox CaseLara;
    private javax.swing.JTextArea Edition;
    private javax.swing.JButton Valider;
    private javax.swing.JRadioButton avancé;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton débutant;
    private javax.swing.JRadioButton enfant;
    private javax.swing.JRadioButton expert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
