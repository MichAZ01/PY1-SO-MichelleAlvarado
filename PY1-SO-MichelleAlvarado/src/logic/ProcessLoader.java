/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;

/**
 * this class contains the methods that allow to take all the process instructions and store them
 * @author Michelle Alvarado
 */
public class ProcessLoader {
    private Process process;
    
    public ProcessLoader(String data) throws IOException{
        this.process = new Process();
        this.LoadProcessInstructions(data);
    }

    /**
     * takes the string that contains all the process ans separate them by the backslash 
     * @param data
     * @throws IOException 
     */
    public void LoadProcessInstructions(String data) throws IOException{
        String lines[] = data.split("\\r?\\n");
        this.process.setProcessInstructions(lines);
    }
    

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
    
}
