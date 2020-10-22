/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Michelle Alvarado
 */
public class CPU {
    private static CPU myCPU = null;
    private int CPUCurrentTime;
    private boolean hasProcessesToExecute;
    private ArrayList<Process> loadedProcesses;
    private Memory mainMemory;
    private Memory secondaryMemory;
    private ArrayList<PCB> readyProcessesQueue;
    private MemoryManager memoryManager = new MemoryManager();
    private ArrayList<Process> currentProcesses;
    private ArrayList<Process> currentReadyProcesses;
    
    public CPU(){
        this.CPUCurrentTime = 0;
        this.hasProcessesToExecute = false;
        this.loadedProcesses = new ArrayList<Process>();
        this.mainMemory = this.memoryManager.initializeMemory(new Memory(), 128, "mainMemory");
        this.secondaryMemory = this.memoryManager.initializeMemory(new Memory(), 512, "secondaryMemory");
        this.readyProcessesQueue = new ArrayList<PCB>();
        this.currentProcesses = new ArrayList<Process>();
        this.currentReadyProcesses = new ArrayList<Process>();
    }
    /**
     * Singleton method
     * @return
     * @throws IOException 
     */
    public static CPU getCPU(){
        if(myCPU == null){
            myCPU = new CPU();
        }
        return myCPU;
    }
    
    public void loadProcesses(File[] processFiles) throws IOException{
        this.loadedProcesses = new ArrayList<Process>();
        this.currentProcesses = new ArrayList<Process>();
        File currentProcessFile;
        FileReader fileReader = new FileReader();
        ProgramValidator programValidator = new ProgramValidator();
        String[] processStatus = null;
        for(int i = 0; i < processFiles.length; i++){
            currentProcessFile = processFiles[i];
            String processLine = fileReader.extractFileInfo(currentProcessFile);
            processStatus = programValidator.validateSelectedFile(processLine);
            Process newProcess = new ProcessLoader(processLine).getProcess();
            if(processStatus[0].equals("0")){
                newProcess.setProcessIsCorrect();
                this.hasProcessesToExecute = true;
                this.currentProcesses.add(newProcess);
            }
            newProcess.setPCB(new PCB(processStatus[1], newProcess.getProcessInstructions().size()));
            newProcess.setProcessName(currentProcessFile.getName());
            this.loadedProcesses.add(newProcess);
        }
    }
    
    private void storeJobSchedulerIndexes(){
        for(int i = 0; i < this.currentProcesses.size(); i++){
            this.currentProcesses.get(i).setProcessID(Integer.toString(i));
            this.mainMemory.getMemoryRegisters().get(i).setRegisterValue(Integer.toString(i));
            this.currentProcesses.get(i).getPCB().getProcessID().setRegisterValue(Integer.toString(i));
        }
        this.mainMemory.setFreeSpaces(this.mainMemory.getFreeSpaces() - this.currentProcesses.size());
    }
    
    private void storeProcessesIntoMemory(){
        Random random = new Random();
        String [] coreNames = new String[]{"Núcleo 1", "Núcleo 2"};
        for(int i = 0; i < this.currentProcesses.size(); i++){
            Process currentProcess = this.currentProcesses.get(i);
            ArrayList<Register> memorySpaces = this.memoryManager.getMemoryForNewProcess(this.mainMemory, this.secondaryMemory, currentProcess);
            if(memorySpaces.size() > 0){
                currentProcess.getPCB().setPCBRegisters(memorySpaces);
                currentProcess.getPCB().getInitProgramIndex().setRegisterValue(Integer.toString(memorySpaces.get(19).getRegisterAddress().getMemoryIndex()));
                List instructionsList = memorySpaces.subList(19, memorySpaces.size());
                ArrayList<Register> registerInstructionsList = new ArrayList<>(instructionsList.size());
                registerInstructionsList.addAll(instructionsList);
                currentProcess.setProcessInstructions(registerInstructionsList);
                this.mainMemory.getMemoryRegisters().get(Integer.parseInt(currentProcess.getProcessID())).setRegisterValue(currentProcess.getPCB().getProcessID().getRegisterAddress().getMemoryAddress());
                currentProcess.getPCB().getPC().setRegisterValue(currentProcess.getProcessInstructions().get(0).getRegisterAddress().getMemoryAddress());
                currentProcess.getPCB().getCoreWhereIsRunning().setRegisterValue(coreNames[random.nextInt(coreNames.length)]);
                this.readyProcessesQueue.add(currentProcess.getPCB());
                this.currentReadyProcesses.add(currentProcess);
            } 
        }
    }
    
    public void storeCurrentProcessesIntoMemory(){
        this.storeJobSchedulerIndexes();
        this.storeProcessesIntoMemory();
    }

    public ArrayList<Process> getLoadedProcesses() {
        return loadedProcesses;
    }

    public void setLoadedProcesses() {
        this.loadedProcesses = new ArrayList<Process>();
    }

    public int getCPUCurrentTime() {
        return CPUCurrentTime;
    }

    public void setCPUCurrentTime() {
        this.CPUCurrentTime += 1;
    }
    
    public void setCPUCurrentTime(int time) {
        this.CPUCurrentTime = time;
    }

    public boolean hasProcessesToExecute() {
        return hasProcessesToExecute;
    }

    public void setHasProcessesToExecute(boolean hasProcessesToExecute) {
        this.hasProcessesToExecute = hasProcessesToExecute;
    }

    public Memory getMainMemory() {
        return mainMemory;
    }

    public Memory getSecondaryMemory() {
        return secondaryMemory;
    }

    public ArrayList<PCB> getReadyProcessesQueue() {
        return readyProcessesQueue;
    }

    public ArrayList<Process> getCurrentProcesses() {
        return currentProcesses;
    }

    public ArrayList<Process> getCurrentReadyProcesses() {
        return currentReadyProcesses;
    }
    
    
}
