/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Michelle Alvarado
 */
public class Memory {
    private int memoryLength;
    private Register[] memoryRegisters[];
    
    public Memory(){
        
    }

    public int getMemoryLength() {
        return memoryLength;
    }

    public void setMemoryLength(int memoryLength) {
        this.memoryLength = memoryLength;
    }

    public Register[][] getMemoryRegisters() {
        return memoryRegisters;
    }

    public void setMemoryRegisters(Register[][] memoryRegisters) {
        this.memoryRegisters = memoryRegisters;
    }
    
    
}
