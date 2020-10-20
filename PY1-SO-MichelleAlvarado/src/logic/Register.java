/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * this class contains the attributes and the accesor methods that allow to simulate the general registers of the cpu like AX, BX, CX, DX
 * @author Michelle Alvarado
 */
public class Register {
    private String registerName;
    private String registerValue;
    private int registerIndex;
    
    public Register(String register){
        this.registerName = register;
        this.registerValue = "";
        this.registerIndex = -1;
    }

    public String getRegisterValue() {
        return registerValue;
    }

    public void setRegisterValue(String registerValue) {
        this.registerValue = registerValue;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public int getRegisterIndex() {
        return registerIndex;
    }

    public void setRegisterIndex(int registerIndex) {
        this.registerIndex = registerIndex;
    }
}
