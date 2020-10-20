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
public class ProgramQueue {
    private QueueNode firstNode;
    private int queueLength;
    
    public ProgramQueue(){
        this.firstNode = null;
        this.queueLength = 0;
    }

    public QueueNode getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(QueueNode firstNode) {
        this.firstNode = firstNode;
    }

    public int getQueueLength() {
        return queueLength;
    }

    public void setQueueLength(int queueLength) {
        this.queueLength = queueLength;
    }
    
    public void push(Program program){
        QueueNode newNode = new QueueNode(program);
        QueueNode currentNode = firstNode;
        if(currentNode == null) this.firstNode = newNode;
        else{
            while(currentNode.getNextNode() != null) currentNode = currentNode.getNextNode();
            currentNode.setNextNode(newNode);
        }
        this.queueLength += 1;
    }
    
    public QueueNode pop(){
        QueueNode node = new QueueNode(this.firstNode.getProgram());
        this.firstNode = this.firstNode.getNextNode();
        this.queueLength -= 1;
        return node;
    }
    
    
}
