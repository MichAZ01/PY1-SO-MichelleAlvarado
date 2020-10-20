/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;

/**
 * this class contains the methods that allow to take all the program instructions and store them, also in this class is possible to store the binary
 * instructions asociated to an each assembly instruction of the program
 * @author Michelle Alvarado
 */
public class ProgramLoader {
    private Program program;
    
    public ProgramLoader(String data) throws IOException{
        this.program = new Program();
        this.LoadProgramInstructions(data);
    }

    /**
     * takes the string that contains all the program ans separate them by the backslash 
     * @param data
     * @throws IOException 
     */
    public void LoadProgramInstructions(String data) throws IOException{
        String lines[] = data.split("\\r?\\n");
        this.program.setProgramInstructions(lines);
    }
    

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
    
}
