/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michelle Alvarado
 */
public class MemoryManager {
    
    public MemoryManager(){
        
    }
    
    public Memory initializeMemory(Memory memory, int memoryLength, String memoryType){
        memory.setMemoryLength(memoryLength);
        memory.setFreeSpaces(memoryLength);
        for(int i = 0; i < memoryLength; i++){
            Register newRegister = new Register();
            newRegister.getRegisterAddress().setMemoryType(memoryType);
            newRegister.getRegisterAddress().setMemoryIndex(i);
            newRegister.getRegisterAddress().setMemoryAddress(this.getProcessAddressForRegister(newRegister));
            memory.getMemoryRegisters().add(newRegister);
        }
        return memory;
    }
    
    public ArrayList<Register> getMemoryForNewProcess(Memory mainMemory, Memory secondaryMemory, Process process){
        ArrayList<Register> memorySpaces = new ArrayList<Register>();
        int requiredSpace = process.getPCBSize() + process.getprocessSize();
        if(mainMemory.getFreeSpaces() >= requiredSpace){
            memorySpaces = this.getMemorySpaces(mainMemory, requiredSpace);
            mainMemory.setFreeSpaces(mainMemory.getFreeSpaces() - memorySpaces.size());
        }
        else if(secondaryMemory.getFreeSpaces() >= requiredSpace){
            memorySpaces = this.getMemorySpaces(secondaryMemory, requiredSpace);
            secondaryMemory.setFreeSpaces(secondaryMemory.getFreeSpaces() - memorySpaces.size());
        }
        return memorySpaces;
    }
    
    public ArrayList<Register> getMemorySpaces(Memory memory, int requiredSpace){
        ArrayList<Register> memorySpaces = new ArrayList<Register>();
        int currentSpaceIndex = 0;
        int currentFinalIndex = requiredSpace;
        boolean hasSpace = true;
        while(currentSpaceIndex < memory.getMemoryLength() && currentFinalIndex <= memory.getMemoryLength()){
            List registersList = memory.getMemoryRegisters().subList(currentSpaceIndex, currentFinalIndex);
            ArrayList<Register> registers = new ArrayList<>(registersList.size());
            registers.addAll(registersList);
            for(int i = 0; i < registers.size(); i++){
                if(!registers.get(i).getRegisterValue().equals("-")){
                    currentSpaceIndex += 1;
                    hasSpace = false;
                }
            }
            if(hasSpace){
                memorySpaces = registers;
                break;
            }
            currentFinalIndex = currentSpaceIndex + requiredSpace;
            hasSpace = true;
        }
        
        
        return memorySpaces;
    }
    
    public String getProcessAddressForRegister(Register register){
        String processAddress = "";
        if(register.getRegisterAddress().getMemoryType().equals("mainMemory")) processAddress += "0000 ";
        else processAddress += "1000 ";
        int zerosAmount = 4 - (Integer.toString(register.getRegisterAddress().getMemoryIndex()).length());
        for(int i = 0; i < zerosAmount; i++) processAddress += "0";
        processAddress += Integer.toString(register.getRegisterAddress().getMemoryIndex());
        return processAddress;
    }
}
