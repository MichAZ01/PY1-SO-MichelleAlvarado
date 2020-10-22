/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GUI.ColorRenderer;
import GUI.MiniPC;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTable;
import logic.CPU;
import logic.ColorManager;
import logic.Memory;

/**
 *
 * @author Michelle Alvarado
 */
public class TableController {

    JTable mainMemoryViewTable;
    JTable secondaryMemoryViewTable;
    JTable loadedFilesViewTable;
    JTable processesViewTable;

    public TableController(MiniPC viewP) {
        this.mainMemoryViewTable = viewP.mainMemoryTable;
        this.secondaryMemoryViewTable = viewP.SecondaryMemoryTable;
        this.loadedFilesViewTable = viewP.loadedFilesTable;
    }

    /**
     * displays the data in the view's table
     *
     * @param data
     */
    public void setTableModel(Object[][] data, JTable table, String[] header, boolean[] editable) {
        table.setModel(new javax.swing.table.DefaultTableModel(
                data,
                header
        ) {
            boolean[] canEdit = editable;

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    /**
     * restarts the view's table
     *
     * @param columns
     * @param rows
     */
    public Object[][] CreateEmptyData(int columns, int rows) {
        Object[][] data = new Object[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = null;
            }
        }
        return data;
    }

    public void setLoadedFilesTable() {
        this.cleanLoadedFilesTable();
        ArrayList<logic.Process> queue = CPU.getCPU().getLoadedProcesses();
        String[] header = new String[]{"Color", "Nombre del programa", "Estado actual"};
        boolean editable[] = new boolean[]{false, false, false};
        int rows = this.loadedFilesViewTable.getModel().getRowCount();
        int x = queue.size();
        if (rows > x) {
            x = rows;
        }
        Object processes[][] = this.CreateEmptyData(3, x);
        for (int i = 0; i < x; i++) {
            if (i < queue.size()) {
                processes[i][0] = "";
                processes[i][1] = queue.get(i).getProcessName();
                processes[i][2] = queue.get(i).getPCB().getProcessStatus().getRegisterValue();
            } else {
                processes[i][0] = null;
                processes[i][1] = null;
                processes[i][1] = null;
            }
        }
        this.setTableModel(processes, this.loadedFilesViewTable, header, editable);
        this.setLoadedFilesColors();
        this.loadedFilesViewTable.getColumnModel().getColumn(0).setPreferredWidth(1);
        this.loadedFilesViewTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        this.loadedFilesViewTable.getColumnModel().getColumn(2).setPreferredWidth(130);
    }

    public void cleanLoadedFilesTable() {
        int rows = this.loadedFilesViewTable.getModel().getRowCount();
        int columns = this.loadedFilesViewTable.getModel().getColumnCount();
        this.setTableModel(this.CreateEmptyData(columns, rows), this.loadedFilesViewTable, new String[]{"Color", "Nombre del programa", "Estado actual"}, new boolean[]{false, false, false});
        this.loadedFilesViewTable.getColumnModel().getColumn(0).setPreferredWidth(1);
        this.loadedFilesViewTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        this.loadedFilesViewTable.getColumnModel().getColumn(2).setPreferredWidth(130);
    }

    public void setLoadedFilesColors() {
        ArrayList<logic.Process> queue = CPU.getCPU().getLoadedProcesses();
        ColorManager colorManager = new ColorManager();
        ColorRenderer renderer = new ColorRenderer();
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getProcessIsCorrect()) {
                Color color = colorManager.generateColor(i);
                queue.get(i).setProcessColor(color);
                renderer.setColorForCell(i, 0, color);
            }
        }
        this.loadedFilesViewTable.setDefaultRenderer(Object.class, renderer);
    }

    public void cleanMainMemoryTable() {
        int rows = this.mainMemoryViewTable.getModel().getRowCount();
        int columns = this.mainMemoryViewTable.getModel().getColumnCount();
        this.setTableModel(this.CreateEmptyData(columns, rows), this.mainMemoryViewTable, new String[]{"Posición", "Valor"}, new boolean[]{false, false});
        this.mainMemoryViewTable.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.mainMemoryViewTable.getColumnModel().getColumn(1).setPreferredWidth(130);

    }

    public void setMainMemoryColors() {
        ArrayList<logic.Process> queue = CPU.getCPU().getCurrentProcesses();
        ColorManager colorManager = new ColorManager();
        ColorRenderer renderer = new ColorRenderer();
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getProcessIsCorrect()) {
                if (queue.get(i).getPCB().getProcessID().getRegisterAddress().getMemoryType().equals("mainMemory")) {
                    renderer = this.setProcessColor(renderer, colorManager, queue.get(i));
                }
            }
        }
        this.mainMemoryViewTable.setDefaultRenderer(Object.class, renderer);
    }

    public ColorRenderer setProcessColor(ColorRenderer renderer, ColorManager colorManager, logic.Process process) {
        int initRow = process.getPCB().getProcessID().getRegisterAddress().getMemoryIndex();
        int finalRow = process.getProcessInstructions().get(process.getProcessInstructions().size() - 1).getRegisterAddress().getMemoryIndex() + 1;
        int columns = 2;
        for (int i = initRow; i < finalRow; i++) {
            for (int j = 0; j < columns; j++) {
                Color color = process.getProcessColor();
                renderer.setColorForCell(i, j, color);
            }
        }

        return renderer;
    }

    public void setMainMemoryTable() {
        this.cleanMainMemoryTable();
        Memory memory = CPU.getCPU().getMainMemory();
        String[] header = new String[]{"Posición", "Valor"};
        boolean editable[] = new boolean[]{false, false};
        int rows = this.mainMemoryViewTable.getModel().getRowCount();
        int x = memory.getMemoryRegisters().size();
        if (rows > x) {
            x = rows;
        }
        Object data[][] = this.CreateEmptyData(3, x);
        for (int i = 0; i < x; i++) {
            if (i < memory.getMemoryRegisters().size()) {
                data[i][0] = i;
                data[i][1] = memory.getMemoryRegisters().get(i).getRegisterValue();
            } else {
                data[i][0] = null;
                data[i][1] = null;
            }
        }
        this.setTableModel(data, this.mainMemoryViewTable, header, editable);
        this.setMainMemoryColors();
        this.mainMemoryViewTable.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.mainMemoryViewTable.getColumnModel().getColumn(1).setPreferredWidth(130);
    }
    
    public void cleanSecondaryMemoryTable() {
        int rows = this.secondaryMemoryViewTable.getModel().getRowCount();
        int columns = this.secondaryMemoryViewTable.getModel().getColumnCount();
        this.setTableModel(this.CreateEmptyData(columns, rows), this.secondaryMemoryViewTable, new String[]{"Posición", "Valor"}, new boolean[]{false, false});
        this.secondaryMemoryViewTable.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.secondaryMemoryViewTable.getColumnModel().getColumn(1).setPreferredWidth(130);

    }

    public void setSecondaryMemoryColors() {
        ArrayList<logic.Process> queue = CPU.getCPU().getCurrentProcesses();
        ColorManager colorManager = new ColorManager();
        ColorRenderer renderer = new ColorRenderer();
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getProcessIsCorrect()) {
                if (queue.get(i).getPCB().getProcessID().getRegisterAddress().getMemoryType().equals("secondaryMemory")) {
                    renderer = this.setProcessColor(renderer, colorManager, queue.get(i));
                }
            }
        }
        this.secondaryMemoryViewTable.setDefaultRenderer(Object.class, renderer);
    }
    
    public void setSecondaryMemoryTable() {
        this.cleanSecondaryMemoryTable();
        Memory memory = CPU.getCPU().getSecondaryMemory();
        String[] header = new String[]{"Posición", "Valor"};
        boolean editable[] = new boolean[]{false, false};
        int rows = this.secondaryMemoryViewTable.getModel().getRowCount();
        int x = memory.getMemoryRegisters().size();
        if (rows > x) {
            x = rows;
        }
        Object data[][] = this.CreateEmptyData(3, x);
        for (int i = 0; i < x; i++) {
            if (i < memory.getMemoryRegisters().size()) {
                data[i][0] = i;
                data[i][1] = memory.getMemoryRegisters().get(i).getRegisterValue();
            } else {
                data[i][0] = null;
                data[i][1] = null;
            }
        }
        this.setTableModel(data, this.secondaryMemoryViewTable, header, editable);
        this.setSecondaryMemoryColors();
        this.secondaryMemoryViewTable.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.secondaryMemoryViewTable.getColumnModel().getColumn(1).setPreferredWidth(130);
    }

}
