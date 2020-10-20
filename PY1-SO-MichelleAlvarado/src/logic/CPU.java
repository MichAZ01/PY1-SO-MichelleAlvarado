/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;

/**
 *
 * @author Michelle Alvarado
 */
public class CPU {
    private static CPU myCPU = null;
    private ProgramQueue currentPrograms;
    
    public CPU(){
        this.currentPrograms = new ProgramQueue();
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
    
    public void loadPrograms(File[] programFiles){
        
    }
}
