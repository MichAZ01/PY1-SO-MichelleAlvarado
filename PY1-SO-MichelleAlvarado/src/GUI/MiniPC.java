/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.UIManager;
/**
 *
 * @author Michelle Alvarado
 */
public class MiniPC extends javax.swing.JFrame {

    /**
     * Creates new form MiniPC
     */
    public MiniPC() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainContainerPanel = new keeptoo.KGradientPanel();
        menuContainer = new javax.swing.JPanel();
        loadProgramsButtonTab = new rojerusan.RSButtonIconI();
        ExecuteButtonTab = new rojerusan.RSButtonIconI();
        StatisticsButtonTab = new rojerusan.RSButtonIconI();
        ConfigButtonTab = new rojerusan.RSButtonIconI();
        myMiniPCIcon = new rojerusan.RSPanelImage();
        sliderPanelContainer = new rojerusan.RSPanelsSlider();
        panelLoadPrograms = new keeptoo.KGradientPanel();
        openFilesButton = new javax.swing.JButton();
        panelExecute = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelStatistics = new keeptoo.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        panelConfig = new keeptoo.KGradientPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MiniPC OS");
        setMaximumSize(new java.awt.Dimension(1365, 735));
        setMinimumSize(new java.awt.Dimension(1365, 735));

        mainContainerPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainContainerPanel.setkEndColor(new java.awt.Color(255, 255, 255));
        mainContainerPanel.setkGradientFocus(0);
        mainContainerPanel.setkStartColor(new java.awt.Color(255, 255, 255));

        menuContainer.setBackground(new java.awt.Color(90, 129, 158));
        menuContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        loadProgramsButtonTab.setBackground(new java.awt.Color(90, 129, 158));
        loadProgramsButtonTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/upload.png"))); // NOI18N
        loadProgramsButtonTab.setText("Carga de programas");
        loadProgramsButtonTab.setActionCommand("loadPrograms");
        loadProgramsButtonTab.setBorderPainted(false);
        loadProgramsButtonTab.setColorHover(new java.awt.Color(108, 194, 189));
        loadProgramsButtonTab.setFocusPainted(false);
        loadProgramsButtonTab.setFocusable(false);
        loadProgramsButtonTab.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        loadProgramsButtonTab.setName("loadProgramsButtonTab"); // NOI18N
        loadProgramsButtonTab.setSelected(true);

        ExecuteButtonTab.setBackground(new java.awt.Color(90, 129, 158));
        ExecuteButtonTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/execute.png"))); // NOI18N
        ExecuteButtonTab.setText("Ejecución                ");
        ExecuteButtonTab.setActionCommand("openExecution");
        ExecuteButtonTab.setBorderPainted(false);
        ExecuteButtonTab.setColorHover(new java.awt.Color(108, 194, 189));
        ExecuteButtonTab.setFocusPainted(false);
        ExecuteButtonTab.setFocusable(false);
        ExecuteButtonTab.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        ExecuteButtonTab.setName("ExecuteButtonTab"); // NOI18N

        StatisticsButtonTab.setBackground(new java.awt.Color(90, 129, 158));
        StatisticsButtonTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/statistics.png"))); // NOI18N
        StatisticsButtonTab.setText("Estadísticas            ");
        StatisticsButtonTab.setActionCommand("openStatistics");
        StatisticsButtonTab.setBorderPainted(false);
        StatisticsButtonTab.setColorHover(new java.awt.Color(108, 194, 189));
        StatisticsButtonTab.setFocusPainted(false);
        StatisticsButtonTab.setFocusable(false);
        StatisticsButtonTab.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        StatisticsButtonTab.setName("StatisticsButtonTab"); // NOI18N

        ConfigButtonTab.setBackground(new java.awt.Color(90, 129, 158));
        ConfigButtonTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/settings.png"))); // NOI18N
        ConfigButtonTab.setText("Configuraciones      ");
        ConfigButtonTab.setActionCommand("OpenConfig");
        ConfigButtonTab.setBorderPainted(false);
        ConfigButtonTab.setColorHover(new java.awt.Color(108, 194, 189));
        ConfigButtonTab.setFocusPainted(false);
        ConfigButtonTab.setFocusable(false);
        ConfigButtonTab.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        ConfigButtonTab.setName("ConfigButtonTab"); // NOI18N

        myMiniPCIcon.setImagen(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/my-computer-icon.png"))); // NOI18N

        javax.swing.GroupLayout myMiniPCIconLayout = new javax.swing.GroupLayout(myMiniPCIcon);
        myMiniPCIcon.setLayout(myMiniPCIconLayout);
        myMiniPCIconLayout.setHorizontalGroup(
            myMiniPCIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        myMiniPCIconLayout.setVerticalGroup(
            myMiniPCIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuContainerLayout = new javax.swing.GroupLayout(menuContainer);
        menuContainer.setLayout(menuContainerLayout);
        menuContainerLayout.setHorizontalGroup(
            menuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loadProgramsButtonTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ExecuteButtonTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(StatisticsButtonTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ConfigButtonTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuContainerLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(myMiniPCIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        menuContainerLayout.setVerticalGroup(
            menuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myMiniPCIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(loadProgramsButtonTab, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExecuteButtonTab, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(StatisticsButtonTab, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfigButtonTab, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        loadProgramsButtonTab.getAccessibleContext().setAccessibleName("loadProgramsButtonTab");
        ExecuteButtonTab.getAccessibleContext().setAccessibleName("ExecuteButtonTab");
        ExecuteButtonTab.getAccessibleContext().setAccessibleDescription("");
        StatisticsButtonTab.getAccessibleContext().setAccessibleName("StatisticsButtonTab");
        ConfigButtonTab.getAccessibleContext().setAccessibleName("ConfigButtonTab");

        sliderPanelContainer.setBackground(new java.awt.Color(255, 255, 255));
        sliderPanelContainer.setName("sliderPanelContainer"); // NOI18N

        panelLoadPrograms.setkEndColor(new java.awt.Color(108, 194, 189));
        panelLoadPrograms.setkGradientFocus(200);
        panelLoadPrograms.setkStartColor(new java.awt.Color(255, 193, 167));
        panelLoadPrograms.setName("panelLoadPrograms"); // NOI18N

        openFilesButton.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        openFilesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/open_folder.png"))); // NOI18N
        openFilesButton.setText("Abrir archivos");
        openFilesButton.setActionCommand("openFiles");
        openFilesButton.setBorderPainted(false);
        openFilesButton.setContentAreaFilled(false);
        openFilesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openFilesButton.setFocusPainted(false);
        openFilesButton.setFocusable(false);
        openFilesButton.setName("openFilesButton"); // NOI18N

        javax.swing.GroupLayout panelLoadProgramsLayout = new javax.swing.GroupLayout(panelLoadPrograms);
        panelLoadPrograms.setLayout(panelLoadProgramsLayout);
        panelLoadProgramsLayout.setHorizontalGroup(
            panelLoadProgramsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoadProgramsLayout.createSequentialGroup()
                .addGap(431, 431, 431)
                .addComponent(openFilesButton)
                .addContainerGap(487, Short.MAX_VALUE))
        );
        panelLoadProgramsLayout.setVerticalGroup(
            panelLoadProgramsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoadProgramsLayout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(openFilesButton)
                .addContainerGap(431, Short.MAX_VALUE))
        );

        openFilesButton.getAccessibleContext().setAccessibleName("openFilesButton");

        sliderPanelContainer.add(panelLoadPrograms, "card2");
        panelLoadPrograms.getAccessibleContext().setAccessibleName("");

        panelExecute.setkEndColor(new java.awt.Color(108, 194, 189));
        panelExecute.setkGradientFocus(200);
        panelExecute.setkStartColor(new java.awt.Color(255, 193, 167));
        panelExecute.setName("panelExecute"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout panelExecuteLayout = new javax.swing.GroupLayout(panelExecute);
        panelExecute.setLayout(panelExecuteLayout);
        panelExecuteLayout.setHorizontalGroup(
            panelExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExecuteLayout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(414, Short.MAX_VALUE))
        );
        panelExecuteLayout.setVerticalGroup(
            panelExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExecuteLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        sliderPanelContainer.add(panelExecute, "card3");
        panelExecute.getAccessibleContext().setAccessibleName("");

        panelStatistics.setkEndColor(new java.awt.Color(108, 194, 189));
        panelStatistics.setkGradientFocus(200);
        panelStatistics.setkStartColor(new java.awt.Color(255, 193, 167));
        panelStatistics.setName("panelStatistics"); // NOI18N

        jScrollPane2.setViewportView(jTree1);

        javax.swing.GroupLayout panelStatisticsLayout = new javax.swing.GroupLayout(panelStatistics);
        panelStatistics.setLayout(panelStatisticsLayout);
        panelStatisticsLayout.setHorizontalGroup(
            panelStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStatisticsLayout.createSequentialGroup()
                .addContainerGap(637, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
        );
        panelStatisticsLayout.setVerticalGroup(
            panelStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatisticsLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(303, Short.MAX_VALUE))
        );

        sliderPanelContainer.add(panelStatistics, "card4");
        panelStatistics.getAccessibleContext().setAccessibleName("panelStatistics");

        panelConfig.setkEndColor(new java.awt.Color(108, 194, 189));
        panelConfig.setkGradientFocus(200);
        panelConfig.setkStartColor(new java.awt.Color(255, 193, 167));
        panelConfig.setName("panelConfig"); // NOI18N

        javax.swing.GroupLayout panelConfigLayout = new javax.swing.GroupLayout(panelConfig);
        panelConfig.setLayout(panelConfigLayout);
        panelConfigLayout.setHorizontalGroup(
            panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1109, Short.MAX_VALUE)
        );
        panelConfigLayout.setVerticalGroup(
            panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );

        sliderPanelContainer.add(panelConfig, "card5");
        panelConfig.getAccessibleContext().setAccessibleName("panelConfig");

        javax.swing.GroupLayout mainContainerPanelLayout = new javax.swing.GroupLayout(mainContainerPanel);
        mainContainerPanel.setLayout(mainContainerPanelLayout);
        mainContainerPanelLayout.setHorizontalGroup(
            mainContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContainerPanelLayout.createSequentialGroup()
                .addComponent(menuContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainContainerPanelLayout.setVerticalGroup(
            mainContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sliderPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sliderPanelContainer.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("MiniPC SO");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MiniPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniPC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniPC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public rojerusan.RSButtonIconI ConfigButtonTab;
    public rojerusan.RSButtonIconI ExecuteButtonTab;
    public rojerusan.RSButtonIconI StatisticsButtonTab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTree jTree1;
    public rojerusan.RSButtonIconI loadProgramsButtonTab;
    private keeptoo.KGradientPanel mainContainerPanel;
    private javax.swing.JPanel menuContainer;
    private rojerusan.RSPanelImage myMiniPCIcon;
    public javax.swing.JButton openFilesButton;
    public keeptoo.KGradientPanel panelConfig;
    public keeptoo.KGradientPanel panelExecute;
    public keeptoo.KGradientPanel panelLoadPrograms;
    public keeptoo.KGradientPanel panelStatistics;
    public rojerusan.RSPanelsSlider sliderPanelContainer;
    // End of variables declaration//GEN-END:variables
}
