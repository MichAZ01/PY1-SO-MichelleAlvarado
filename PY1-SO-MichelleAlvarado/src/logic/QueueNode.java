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
public class QueueNode {
    private Process process;
    private QueueNode nextNode;
    
    public QueueNode(Process process){
        this.process = process;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public QueueNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(QueueNode nextNode) {
        this.nextNode = nextNode;
    }
    
    
}
