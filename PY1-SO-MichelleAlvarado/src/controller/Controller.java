/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GUI.ColorRenderer;
import GUI.MiniPC;
import GUI.MyCustomFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import logic.CPU;
import logic.Memory;
import rojerusan.RSPanelsSlider;

/**
 *
 * @author Michelle Alvarado
 */
public class Controller implements ActionListener {
    private MiniPC view;
    public rojerusan.RSButtonIconI[] viewTabButtons;
    public TableController tableController;

    public Controller() {
        this.viewTabButtons = new rojerusan.RSButtonIconI[3];
    }

    public void showView() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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

        this.view = new MiniPC();
        MiniPC viewP = this.view;
        this.view.openFilesButton.addActionListener(this);
        this.view.loadProgramsButtonTab.addActionListener(this);
        this.view.ExecuteButtonTab.addActionListener(this);
        this.view.StatisticsButtonTab.addActionListener(this);
        this.view.saveProgramsButton.addActionListener(this);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                viewP.setVisible(true);
                viewP.setResizable(false);
                viewP.setLocationRelativeTo(null);
            }
        });
        this.viewTabButtons[0] = this.view.loadProgramsButtonTab;
        this.viewTabButtons[1] = this.view.ExecuteButtonTab;
        this.viewTabButtons[2] = this.view.StatisticsButtonTab;
        this.tableController = new TableController(this.view);
    }

    /**
     * Manages the different cases for an event like open a file, start the
     * execution of a process or execute the next instruction of a process
     *
     * @param ae: an event produced by an object in the view (button in this
     * case)
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "openFiles":
        {
            try {
                this.OpenFolderButtonActionPerformed(view);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "loadPrograms":
                loadProgramsButtonActionPerformed(view);
                break;
            case "openExecution":
                openExecutionButtonActionPerformed(view);
                break;
            case "openStatistics":
                openStatisticsButtonActionPerformed(view);
                break;
            case "loadProgramsIntoMemory":
                loadProgramsIntoMemoryButtonActionPerformed(view);
            default:
                break;
        }
    }

    public void OpenFolderButtonActionPerformed(javax.swing.JFrame view) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setAcceptAllFileFilterUsed(false);
        MyCustomFilter assemblerFilter = (MyCustomFilter) new MyCustomFilter(".asm", "Archivo de código Ensamblador");
        fileChooser.addChoosableFileFilter(assemblerFilter);
        int result = fileChooser.showOpenDialog(view);
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                this.loadProgramsIntoQueue(fileChooser.getSelectedFiles());
            case JFileChooser.CANCEL_OPTION:
                break;
            default:
                break;
        }
    }

    public void loadProgramsIntoQueue(File[] selectedFiles) throws IOException{
        CPU.getCPU().loadProcesses(selectedFiles);
        this.tableController.setLoadedFilesTable();
        if(CPU.getCPU().hasProcessesToExecute()){
            this.view.saveProgramsButton.setEnabled(true);
            this.view.openFilesButton.setEnabled(false);
        }
    }
    
    public void loadProgramsButtonActionPerformed(javax.swing.JFrame view) {
        this.setSelectedTab(0);
        this.view.sliderPanelContainer.setPanelSlider(this.view.WIDTH, this.view.panelLoadPrograms, RSPanelsSlider.DIRECT.RIGHT);
    }
    

    public void openExecutionButtonActionPerformed(javax.swing.JFrame view) {
        this.setSelectedTab(1);
        this.view.sliderPanelContainer.setPanelSlider(this.view.WIDTH, this.view.panelExecute, RSPanelsSlider.DIRECT.RIGHT);
    }

    public void openStatisticsButtonActionPerformed(javax.swing.JFrame view) {
        this.setSelectedTab(2);
        this.view.sliderPanelContainer.setPanelSlider(this.view.WIDTH, this.view.panelStatistics, RSPanelsSlider.DIRECT.RIGHT);
    }

    public void setSelectedTab(int currentTabIndex) {
        rojerusan.RSButtonIconI button = null;
        for (int i = 0; i < this.viewTabButtons.length; i++) {
            button = this.viewTabButtons[i];
            if (i == currentTabIndex) {
                button.setSelected(true);
            } else {
                button.setSelected(false);
            }
        }
    }
    
    public void loadProgramsIntoMemoryButtonActionPerformed(javax.swing.JFrame view){
        CPU.getCPU().storeCurrentProcessesIntoMemory();
        this.tableController.setMainMemoryTable();
        this.tableController.setSecondaryMemoryTable();
        this.view.saveProgramsButton.setEnabled(false);
        this.view.ExecuteButtonTab.setEnabled(true);
    }
}
