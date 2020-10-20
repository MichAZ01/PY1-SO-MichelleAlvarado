/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * this class contains the attributes and accesor methods that allowed manage the instructions of a program
 * @author Michelle Alvarado
 */
public class Program {
    String[] programInstructions;
    int programSize;
    
    public Program(){
    }

    public String[] getProgramInstructions() {
        return programInstructions;
    }

    public void setProgramInstructions(String[] programInstructions) {
        this.programInstructions = programInstructions;
        this.programSize = this.programInstructions.length;
    }

    public int getProgramSize() {
        return programSize;
    }
    
    
    
    
}
