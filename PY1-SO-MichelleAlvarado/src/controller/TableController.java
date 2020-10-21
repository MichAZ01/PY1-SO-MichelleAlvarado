/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GUI.ColorRenderer;
import GUI.MiniPC;
import java.awt.Color;
import javax.swing.JTable;
import logic.CPU;
import logic.ColorManager;
import logic.ProcessesQueue;
import logic.QueueNode;
/**
 *
 * @author Michelle Alvarado
 */
public class TableController {
    JTable mainMemoryViewTable;
    JTable secondaryMemoryViewTable;
    JTable loadedFilesViewTable;
    JTable processesViewTable;
    
    
    public TableController(MiniPC viewP){
        this.mainMemoryViewTable = viewP.mainMemoryTable;
        this.secondaryMemoryViewTable = viewP.SecondaryMemoryTable;
        this.loadedFilesViewTable = viewP.loadedFilesTable;
    }

    /**
     * displays the data in the view's table
     * @param data 
     */
    public void setTableModel(Object[][] data, JTable table, String[] header, boolean[] editable){
        table.setModel(new javax.swing.table.DefaultTableModel(
            data,
            header
        ) {
            boolean[] canEdit = editable;

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    
    /**
     * restarts the view's table
     * @param columns
     * @param rows 
     */
    public void CreateEmptyTableModel(int columns, int rows){
        Object[][] data = new Object[rows][columns];
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                data[i][j] = null;
            }
        }
    }
    
    public void setLoadedFilesTable(){
        ProcessesQueue queue = CPU.getCPU().getCurrentProcesses();
        String[] header = new String[]{"Color", "Nombre del programa", "Estado actual"};
        boolean editable[] = new boolean[]{false, false, false};
        int rows = this.loadedFilesViewTable.getModel().getRowCount();
        int x = queue.getQueueLength();
        if(rows > x) x = rows;
        QueueNode currentValue = queue.getFirstNode();
        Object data[][] = new Object[x][3];
        int i = 0;
        while(currentValue != null){
            data[i][0] = "";
            data[i][1] = currentValue.getProcess().getProcessName();
            data[i][2] = currentValue.getProcess().getPCB().getProcessStatus().getRegisterValue();
            i++;
            currentValue = currentValue.getNextNode();
        }
        
        this.setTableModel(data, this.loadedFilesViewTable, header, editable);
        this.setLoadedFilesColors();
        this.loadedFilesViewTable.getColumnModel().getColumn(0).setPreferredWidth(1);
        this.loadedFilesViewTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        this.loadedFilesViewTable.getColumnModel().getColumn(2).setPreferredWidth(130);

    }
    
    public void setLoadedFilesColors(){
        ProcessesQueue queue = CPU.getCPU().getCurrentProcesses();
        JTable table = null;
        ColorManager colorManager = new ColorManager();
        ColorRenderer renderer = new ColorRenderer();
        QueueNode processNode = queue.getFirstNode();
        for (int i = 0; i < queue.getQueueLength(); i++) {
            if(processNode.getProcess().getProcessIsCorrect()){
                Color color = colorManager.generateColor(i);
                processNode.getProcess().setProcessColors(colorManager.getRGBCodes(color.toString()));
                renderer.setColorForCell(i, 0, color);
            }
            processNode = processNode.getNextNode();
        }
        this.loadedFilesViewTable.setDefaultRenderer(Object.class, renderer);
    }

}
