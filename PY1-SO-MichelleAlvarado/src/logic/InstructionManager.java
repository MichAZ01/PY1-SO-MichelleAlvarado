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
public class InstructionManager {
    public static final int LOADWeigth  = 2;
    public static final int STOREWeigth = 2;
    public static final int MOVWeigth   = 1;
    public static final int ADDWeigth   = 3;
    public static final int SUBWeigth   = 3;
    public static final int INCWeigth   = 1;
    public static final int DECWeigth  = 1;
    public static final int JUMWeigth   = 2;
    public static final int CMPWeigth   = 2;
    public static final int JEWeigth    = 2;
    public static final int JNEWeigth   = 2;
    public static final int PUSHWeigth  = 1;
    public static final int POPWeigth   = 1;
    public static final int PARAMWeigth = 3;
    
    public InstructionManager(){
        
    }
    
    public int getInstructionWeigth(String instructionType){
        int weigth = 0;
        switch(instructionType){
            case "LOAD":
                weigth = LOADWeigth;
                break;
            case "STORE":
                weigth = STOREWeigth;
                break;
            case "MOV":
                weigth = MOVWeigth;
                break;
            case "ADD":
                weigth = ADDWeigth;
                break;
            case "SUB":
                weigth = SUBWeigth;
                break;
            case "INC":
                weigth = INCWeigth;
                break;
            case "DEC":
                weigth = DECWeigth;
                break;
            case "JUM":
                weigth = JUMWeigth;
                break;
            case "CMP":
                weigth = CMPWeigth;
                break;
            case "JE":
                weigth = JEWeigth;
                break;
            case "JNE":
                weigth = JNEWeigth;
                break;
            case "PUSH":
                weigth = PUSHWeigth;
                break;
            case "POP":
                weigth = POPWeigth;
                break;
            case "PARAM":
                weigth = PARAMWeigth;
                break;
            default:
                weigth = 0;
                break;
        }
        return weigth;
    }
    
    public String executeInstruction(PCB currentPCB, String instruction){
        String result = "";
        String instructionType = instruction.split(" ")[0];
        switch(instructionType){
            case "LOAD":
                result = this.executeLOADInstruction(currentPCB, instruction);
                break;
            case "STORE":
                result = this.executeSTOREInstruction(currentPCB, instruction);
                break;
            case "MOV":
                break;
            case "ADD":
                result = this.executeADDInstruction(currentPCB, instruction);
                break;
            case "SUB":
                break;
            case "INC":
                result = this.executeINCInstruction(currentPCB);
                break;
            case "DEC":
                result = this.executeDECInstruction(currentPCB);
                break;
            case "JUM":
                break;
            case "CMP":
                break;
            case "JE":
                break;
            case "JNE":
                break;
            case "PUSH":
                break;
            case "POP":
                break;
            case "PARAM":
                this.executePARAMInstruction(currentPCB, instruction);
                break;
            default:
                break;
        }
        return result;
    }
    
    public String executeLOADInstruction(PCB currentPCB, String instruction){
        String register = instruction.split(" ")[1];
        switch(register){
            case "AX":
                currentPCB.getAC().setRegisterValue(currentPCB.getAX().getRegisterValue());
                break;
            case "BX":
                currentPCB.getAC().setRegisterValue(currentPCB.getBX().getRegisterValue());
                break;
            case "CX":
                currentPCB.getAC().setRegisterValue(currentPCB.getCX().getRegisterValue());
                break;
            case "DX":
                currentPCB.getAC().setRegisterValue(currentPCB.getDX().getRegisterValue());
                break;
            default:
                break;
        }
        
        return "";
    }
    
    public String executeSTOREInstruction(PCB currentPCB, String instruction){
        String register = instruction.split(" ")[1];
        switch(register){
            case "AX":
                currentPCB.getAX().setRegisterValue(currentPCB.getAC().getRegisterValue());
                break;
            case "BX":
                currentPCB.getBX().setRegisterValue(currentPCB.getAC().getRegisterValue());
                break;
            case "CX":
                currentPCB.getCX().setRegisterValue(currentPCB.getAC().getRegisterValue());
                break;
            case "DX":
                currentPCB.getDX().setRegisterValue(currentPCB.getAC().getRegisterValue());
                break;
            default:
                break;
        }
        
        return "";
    }
    
    public String executeINCInstruction(PCB currentPCB){
        currentPCB.getAC().setRegisterValue(Integer.toString(Integer.parseInt(currentPCB.getAC().getRegisterValue()) + 1));
        
        return "";
    }
    
    public String executeDECInstruction(PCB currentPCB){
        currentPCB.getAC().setRegisterValue(Integer.toString(Integer.parseInt(currentPCB.getAC().getRegisterValue()) - 1));
        
        return "";
    }
    
    public String executePARAMInstruction(PCB currentPCB, String instruction){
        String result = "";
        String[] instructionParts = instruction.split(",");
        String param1 = instructionParts[0].split(" ")[1];
        String[] params = new String[3];
        params[0] = param1;
        if(instructionParts.length == 3){
            params[1] = instructionParts[1].trim();
            params[2] = instructionParts[2].trim();
        }
        else if(instructionParts.length == 2){
            params[1] = instructionParts[1].trim();
        }
        
        for(int i = 0; i < params.length; i++) System.out.println(params[i]);
        
        if(currentPCB.getStackAvailableSpace() >= params.length){
            currentPCB.storeParamsIntoStack(params);
        }
        else{
            result = "Error de desbordamiento en la pila";
        }
        
        return result;
    }
    
    public String executeADDInstruction(PCB currentPCB, String instruction){
        String register = instruction.split(" ")[1];
        switch(register){
            case "AX":
                currentPCB.getAC().setRegisterValue(Integer.toString(Integer.parseInt(currentPCB.getAC().getRegisterValue()) + Integer.parseInt(currentPCB.getAX().getRegisterValue())));
                break;
            case "BX":
                currentPCB.getAC().setRegisterValue(Integer.toString(Integer.parseInt(currentPCB.getAC().getRegisterValue()) + Integer.parseInt(currentPCB.getBX().getRegisterValue())));
                break;
            case "CX":
                currentPCB.getAC().setRegisterValue(Integer.toString(Integer.parseInt(currentPCB.getAC().getRegisterValue()) + Integer.parseInt(currentPCB.getCX().getRegisterValue())));
                break;
            case "DX":
                currentPCB.getAC().setRegisterValue(Integer.toString(Integer.parseInt(currentPCB.getAC().getRegisterValue()) + Integer.parseInt(currentPCB.getDX().getRegisterValue())));
                break;
            default:
                break;
        }
        
        return "";
    }
    
    public String executeMOVInstruction(PCB currentPCB, String instruction){
        
        return "";
    }
}
