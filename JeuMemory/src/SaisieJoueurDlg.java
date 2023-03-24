
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;


public class SaisieJoueurDlg extends javax.swing.JDialog {
    //Attributs
    private Joueur j;//variable de type joueur pour ajouter un nouveau joueur 
    private boolean valide;//variable boolean pour verifier si c'est valider ou pas 
    private ImageIcon photo; // photo du joueur a ajouter
    private LesPersonnages lp;//liste des personnages
    
    //Constructeur
    public SaisieJoueurDlg(java.awt.Frame parent, boolean modal,LesPersonnages lep) {
        super(parent, modal); //appel au constructeur parent de la classe ancêtre JDialog
        initComponents();//création de l'interface
        this.lp=lep;//initialisation de l'attribut lp
        this.photo=null;//initialisation de l'attribut photo a nul
        this.valide=false;//initialisation de l'attribut a false 
        this.j=null;//initialisation de l'attribut lp
        DefaultListModel mod=new DefaultListModel();//Modele pour la JList
        ListeFamillePerso.setModel(mod);//ajout des personnages dans la jList(ListeFamillePerso)
        initListeFamilles();
    }
    //Accesseurs en lecture
    public Joueur getJ() {
        return j;//retourne le joueur 
    }

    public boolean isValide(){
        return this.valide;//retourne l'indicateur
    }
    
    //Methode pour remplir la jList
    private void initListeFamilles(){ 
        ArrayList<String> f=this.lp.getFamilles();//tableau des familles des personnages
     DefaultListModel mod=(DefaultListModel) ListeFamillePerso.getModel();
        for(int i=0;i<f.size();i++){//parcourir la liste des familles des personnages
            mod.addElement(f.get(i));//ajout des familles a la liste 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Pseudo = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeFamillePerso = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BParcou = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        BPhoto = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Créez votre joueur !");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
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

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jPanel3.setLayout(new java.awt.GridLayout(3, 1));

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Donnez votre pseudo : ");
        jPanel5.add(jLabel4, java.awt.BorderLayout.NORTH);

        Pseudo.setText("jTextField1");
        jPanel5.add(Pseudo, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Quelle est votre préférée de personnages?");
        jPanel6.add(jLabel3, java.awt.BorderLayout.NORTH);

        ListeFamillePerso.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListeFamillePerso);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Choisissez une photo : ");
        jPanel7.add(jLabel2, java.awt.BorderLayout.NORTH);

        BParcou.setText("Parcourir");
        BParcou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BParcouActionPerformed(evt);
            }
        });
        jPanel7.add(BParcou, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel7);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new java.awt.BorderLayout());

        BPhoto.setText("jButton1");
        jPanel4.add(BPhoto, java.awt.BorderLayout.CENTER);

        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel8.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        jPanel8.add(Valider);

        jPanel4.add(jPanel8, java.awt.BorderLayout.SOUTH);

        jPanel2.add(jPanel4);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        this.valide=false;////pour montrer que ça n'a pas été valider 
        this.setVisible(false);//Fermer l'interface
    }//GEN-LAST:event_AnnulerActionPerformed

    private void BParcouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BParcouActionPerformed
        JFileChooser file=new JFileChooser(); //création d'une variable file
        if(file.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            String path=file.getSelectedFile().getPath(); //recuperer le chemin complet du fichier 
            Image img=Toolkit.getDefaultToolkit().getImage(path);//recuperer l'image
            img=img.getScaledInstance(BPhoto.getWidth()-10, BPhoto.getHeight()-10, Image.SCALE_DEFAULT); //dimensionner l'image
            photo=new ImageIcon(img);//stocker l'image dans photo
            BPhoto.setIcon(photo);//affichage de l'image sur le bouton BPhoto
        }
    }//GEN-LAST:event_BParcouActionPerformed

    //Getionnaire de clic sur le bouton valider
    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        String p;
        int i=ListeFamillePerso.getSelectedIndex(); //recuperer l'indice de l'element selectioné
        if(!Pseudo.getText().equals("")&&i!=-1){//verification que le pseudo n'est pas nul et qu'une famille est selectioné
            String f=ListeFamillePerso.getSelectedValue().toString(); //recuperer la famille selectionée
            p=Pseudo.getText();//recuperer le pseudo du joueur
            this.j=new Joueur(p,f);//créer un nouveau joueur avec les infos recuperés ci-haut
            if(photo!=null){ //verication que la photo du joueur n'est pas null
                j.setPhoto(photo); //
            }
            this.valide=true;//pour montrer que ça a été valider
            this.setVisible(false);//fermer l'interface
        }
        else{ 
            Pseudo.setText("le pseudo est vide");//afficher un message sur la zone de texte 
            this.setVisible(true);//garder l'interface ouverte
        }
    }//GEN-LAST:event_ValiderActionPerformed

    /**
     * @param args the command line arguments
     */ 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JButton BParcou;
    private javax.swing.JButton BPhoto;
    private javax.swing.JList<String> ListeFamillePerso;
    private javax.swing.JTextField Pseudo;
    private javax.swing.JButton Valider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
