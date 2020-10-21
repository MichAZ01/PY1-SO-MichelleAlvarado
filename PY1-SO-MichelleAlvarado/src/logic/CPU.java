/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Michelle Alvarado
 */
public class CPU {
    private static CPU myCPU = null;
    private ProcessesQueue currentProcesses;
    private int CPUCurrentTime;
    private boolean hasProcessesToExecute;
    
    public CPU(){
        this.currentProcesses = new ProcessesQueue();
        this.CPUCurrentTime = 0;
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
            }
            newProcess.getPCB().getProcessStatus().setRegisterValue(processStatus[1]);
            newProcess.getPCB().getProcessID().setRegisterValue(Integer.toString(i));
            newProcess.setProcessName(currentProcessFile.getName());
            this.currentProcesses.push(newProcess);
        }
    }

    public ProcessesQueue getCurrentProcesses() {
        return currentProcesses;
    }

    public void setCurrentProcesses() {
        this.currentProcesses = new ProcessesQueue();
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
    
    
}
