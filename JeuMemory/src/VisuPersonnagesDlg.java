
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class VisuPersonnagesDlg extends javax.swing.JDialog {

    //Attribut
    private  Joueur j; //Pour le joueur courant
    
    //Constructeur
    public VisuPersonnagesDlg(java.awt.Frame parent, boolean modal,Joueur joueur) {
        super(parent, modal);//appel au constructeur parent 
        initComponents();//création de l'interface
        this.j=joueur;//initialisation de l'attribut j
        initPanneau();//permet la creation du trombinoscope
    }

    //Methode pour creation du trombinoscope
    public  void initPanneau()
    {   
        LesPersonnages lc = j.getPaquet();
        int nbi= lc.getTaille();
        // taille de la grille nxn
        int n= (int) Math.floor(Math.sqrt(nbi))+1; 
        Panneau.setLayout(new java.awt.GridLayout(n, n));
        for (int i =0; i<nbi; i++)
        { 
            JButton bt= new JButton();
            Panneau.add(bt);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panneau = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BAfficher = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Panneau.setLayout(new java.awt.GridLayout(2, 2));
        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        jLabel2.setText("Score :");
        jPanel3.add(jLabel2);

        BAfficher.setText("Afficher");
        BAfficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAfficherActionPerformed(evt);
            }
        });
        jPanel3.add(BAfficher);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jLabel1.setText("Cartes du joueur :");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Gestionnaire du clic sur le Afficher
    private void BAfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAfficherActionPerformed

        for(int i=0;i<this.j.getPaquet().getTaille();i++){ //prcourir toutes les personnages dans le paquet
            JButton jb=(JButton)Panneau.getComponent(i);
            Personnage per = this.j.getPaquet().getPerso(i);//recuperer le personnage
            Image img =per.getPhoto().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_DEFAULT);//dimensionner la photo
            jb.setIcon(new ImageIcon(img));//Afficher la photo sur le bouton
            jLabel1.setText("Cartes du joueur : "+this.j.getPseudo());//Afficher le nom du joueur 
            jLabel2.setText("Score : "+this.j.getScore());//afficher son score
        }
    }//GEN-LAST:event_BAfficherActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAfficher;
    private javax.swing.JPanel Panneau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
