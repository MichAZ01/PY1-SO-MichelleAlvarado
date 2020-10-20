/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * this class contains the attributes and accesor methods that allow simulating the operations that are allowed by the cpu
 * @author Michelle Alvarado
 */
public class Operation {
    private String operationName;
    
    public Operation(String operation){
        this.operationName = operation;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}
