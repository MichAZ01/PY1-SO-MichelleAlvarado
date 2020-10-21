/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * this class contains the attributes and accesor methods that allowed manage the instructions of a process
 * @author Michelle Alvarado
 */
public class Process {
    private Register[] processInstructions;
    private int processSize;
    private PCB PCB;
    private String[] processColors;
    private boolean processIsCorrect;
    private String processName;
    
    public Process(){
        this.processInstructions = null;
        this.processSize = 0;
        this.PCB = new PCB();
        this.processColors = new String[3];
        this.processIsCorrect = false;
        this.processName = "";
    }
    
    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Register[] getProcessInstructions() {
        return processInstructions;
    }

    public void setProcessInstructions(String[] processInstructions) {
        this.processSize = processInstructions.length;
        this.processInstructions = new Register[this.processSize];
        for(int i = 0; i < this.processSize; i++){
            Register newRegisterInstruction = new Register();
            newRegisterInstruction.setRegisterValue(processInstructions[i]);
            this.processInstructions[i] = newRegisterInstruction;
        }
        this.PCB.getProcessLength().setRegisterValue(Integer.toString(this.processSize));
    }

    public int getprocessSize() {
        return processSize;
    } 

    public PCB getPCB() {
        return PCB;
    }

    public void setPCB(PCB PCB) {
        this.PCB = PCB;
    }

    public String[] getprocessColors() {
        return processColors;
    }

    public void setProcessColors(String[] processColors) {
        this.processColors = processColors;
    }

    public boolean getProcessIsCorrect() {
        return processIsCorrect;
    }

    public void setProcessIsCorrect() {
        this.processIsCorrect = !this.processIsCorrect;
    }
    
}
