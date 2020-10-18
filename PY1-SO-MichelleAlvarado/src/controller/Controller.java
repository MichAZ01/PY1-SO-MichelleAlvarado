/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GUI.ColorRenderer;
import GUI.MiniPC;
import GUI.MyCustomFilter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import rojerusan.RSPanelsSlider;

/**
 *
 * @author Michelle Alvarado
 */
public class Controller implements ActionListener {

    private MiniPC view;
    public File[] selectedFiles = null;
    public rojerusan.RSButtonIconI[] viewTabButtons;

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
    }

    /**
     * Manages the different cases for an event like open a file, start the
     * execution of a program or execute the next instruction of a program
     *
     * @param ae: an event produced by an object in the view (button in this
     * case)
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "openFiles":
                this.OpenFolderButtonActionPerformed(view);
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
            default:
                break;
        }
    }

    public void OpenFolderButtonActionPerformed(javax.swing.JFrame view) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setAcceptAllFileFilterUsed(false);
        MyCustomFilter assemblerFilter = (MyCustomFilter) new MyCustomFilter(".asm", "Archivo de código Ensamblador");
        fileChooser.addChoosableFileFilter(assemblerFilter);
        int result = fileChooser.showOpenDialog(view);
        File[] files = null;
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                files = fileChooser.getSelectedFiles();
                this.selectedFiles = files;
            case JFileChooser.CANCEL_OPTION:
                break;
            default:
                break;
        }
    }

    public boolean StringExistsInArray(String string, String[] array) {
        Boolean exists = false;
        int size = array.length;
        String currentString = null;
        for (int i = 0; i < size; i++) {
            currentString = array[i];
            if (currentString == null) {
                break;
            } else if (string.equals(currentString)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Color generateColor(String[] usedColors, int currentIndex) {
        Color newColor = null;
        Random random = new Random();
        while (newColor == null) {
            final float hue = random.nextFloat(); // Saturation between 0.1 and 0.3 final 
            float saturation = (random.nextInt(2000) + 1000) / 10000f;
            final float luminance = 0.9f;
            final Color color = Color.getHSBColor(hue, saturation, luminance);
            if (!this.StringExistsInArray(color.toString(), usedColors) && hasOnlyOneCodeEqualy(color.toString(), usedColors, currentIndex)) {
                newColor = color;
            }
        }
        return newColor;
    }
    
    public boolean hasOnlyOneCodeEqualy(String color, String[] usedColors, int currentIndex){
        boolean hasOnlyOne = true;
        String[] previousColorRGB = null;
        String[] currentColorRGB = null;
        int countCoincidences = 0;
        if(currentIndex > 0){
            String previousColor = usedColors[currentIndex - 1];
            if(previousColor != null){
                previousColorRGB = this.getRGBCodes(previousColor);
                currentColorRGB = this.getRGBCodes(color);
                if(previousColorRGB[0].equals(currentColorRGB[0])) countCoincidences ++; 
                if(previousColorRGB[1].equals(currentColorRGB[1])) countCoincidences ++; 
                if(previousColorRGB[2].equals(currentColorRGB[2])) countCoincidences ++; 
            }
            if(countCoincidences >= 1){
                return false;
            }
        }
        
        return hasOnlyOne;
    }
    
    public String[] getRGBCodes(String color){
        int initialIndex = color.indexOf("[");
        String rgbCode = color.substring(initialIndex);
        String[] splitRGBCode = rgbCode.split("=");
        String red = splitRGBCode[1].split(",")[0];
        String green = splitRGBCode[2].split(",")[0];
        String blue = splitRGBCode[3].split("]")[0];
        return new String[]{red, green, blue};
    }

    public void loadProgramsButtonActionPerformed(javax.swing.JFrame view) {
        this.setSelectedTab(0);
        this.view.sliderPanelContainer.setPanelSlider(this.view.WIDTH, this.view.panelLoadPrograms, RSPanelsSlider.DIRECT.RIGHT);
        String[] colors = new String[2000];
        JTable table = null;
        ColorRenderer renderer = new ColorRenderer();
        for (int i = 0; i < 512; i++) {
            Color color = this.generateColor(colors, i);
            colors[i] = color.toString();
            for (int j = 0; j < 2; j++) {
                renderer.setColorForCell(i, j, color);
            }
        }
        this.view.mainMemoryTable.setDefaultRenderer(Object.class, renderer);
        this.view.mainMemoryTable.validate();
        this.view.mainMemoryTable.repaint();

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
}
