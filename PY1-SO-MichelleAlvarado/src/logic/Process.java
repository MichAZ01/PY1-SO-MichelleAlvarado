/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Color;
import java.util.ArrayList;

/**
 * this class contains the attributes and accesor methods that allowed manage the instructions of a process
 * @author Michelle Alvarado
 */
public class Process {
    private ArrayList<Register> processInstructions;
    private int processSize;
    private PCB PCB;
    private boolean processIsCorrect;
    private String processName;
    private String processID;
    private int PCBSize;
    private String initTime;
    private String finalTime;
    private Color processColor;
    
    public Process(){
        this.processInstructions = null;
        this.processSize = 0;
        this.processIsCorrect = false;
        this.processName = "";
        this.PCBSize = 19;
        this.initTime = "";
        this.finalTime = "";
    }
    
    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public ArrayList<Register> getProcessInstructions() {
        return processInstructions;
    }

    public void setProcessInstructions(String[] processInstructions) {
        this.processSize = processInstructions.length;
        this.processInstructions = new ArrayList<Register>();
        for(int i = 0; i < this.processSize; i++){
            Register newRegisterInstruction = new Register();
            newRegisterInstruction.setRegisterValue(processInstructions[i]);
            this.processInstructions.add(newRegisterInstruction);
        }
    }

    public void setProcessInstructions(ArrayList<Register> processRegisterInstructions) {
        for(int i = 0; i < processRegisterInstructions.size(); i++){
            processRegisterInstructions.get(i).setRegisterValue(this.processInstructions.get(i).getRegisterValue());
            //System.out.println(this.processInstructions.get(i).getRegisterValue());
            this.processInstructions.set(i, processRegisterInstructions.get(i));
            
        }
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

    public boolean getProcessIsCorrect() {
        return processIsCorrect;
    }

    public void setProcessIsCorrect() {
        this.processIsCorrect = !this.processIsCorrect;
    }

    public String getProcessID() {
        return processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }
    
    public int getPCBSize(){
        return this.PCBSize;
    }

    public String getInitTime() {
        return initTime;
    }

    public void setInitTime(String initTime) {
        this.initTime = initTime;
    }

    public String getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(String finalTime) {
        this.finalTime = finalTime;
    }

    public Color getProcessColor() {
        return processColor;
    }

    public void setProcessColor(Color processColor) {
        this.processColor = processColor;
    }
}
