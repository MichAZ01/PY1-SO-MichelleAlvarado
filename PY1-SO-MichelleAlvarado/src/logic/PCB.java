/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * 19
 * @author Michelle Alvarado
 */
public class PCB {
    private Register processID;
    private Register processStatus;
    private Register IOStatus;
    private Register PC;
    private Register AC;
    private Register AX;
    private Register BX;
    private Register CX;
    private Register DX;
    private Register[] stack;
    private Register coreWhereIsRunning;
    private Register initTime;
    private Register timeSpent;
    private Register initProgramIndex;
    private Register processLength;
    
    public PCB(){
        this.processID = new Register();
        this.processStatus = new Register();
        this.IOStatus = new Register();
        this.PC = new Register();
        this.AC = new Register();
        this.AX = new Register();
        this.BX = new Register();
        this.CX = new Register();
        this.DX = new Register();
        this.stack = new Register[5];
        this.coreWhereIsRunning = new Register();
        this.initTime = new Register();
        this.timeSpent = new Register();
        this.initProgramIndex = new Register();
        this.processLength = new Register();
    }

    public Register getProcessID() {
        return processID;
    }

    public void setProcessID(Register processID) {
        this.processID = processID;
    }

    public Register getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Register processStatus) {
        this.processStatus = processStatus;
    }

    public Register getIOStatus() {
        return IOStatus;
    }

    public void setIOStatus(Register IOStatus) {
        this.IOStatus = IOStatus;
    }

    public Register getPC() {
        return PC;
    }

    public void setPC(Register PC) {
        this.PC = PC;
    }

    public Register getAC() {
        return AC;
    }

    public void setAC(Register AC) {
        this.AC = AC;
    }

    public Register getAX() {
        return AX;
    }

    public void setAX(Register AX) {
        this.AX = AX;
    }

    public Register getBX() {
        return BX;
    }

    public void setBX(Register BX) {
        this.BX = BX;
    }

    public Register getCX() {
        return CX;
    }

    public void setCX(Register CX) {
        this.CX = CX;
    }

    public Register getDX() {
        return DX;
    }

    public void setDX(Register DX) {
        this.DX = DX;
    }

    public Register[] getStack() {
        return stack;
    }

    public void setStack(Register[] stack) {
        this.stack = stack;
    }

    public Register getCoreWhereIsRunning() {
        return coreWhereIsRunning;
    }

    public void setCoreWhereIsRunning(Register coreWhereIsRunning) {
        this.coreWhereIsRunning = coreWhereIsRunning;
    }

    public Register getInitTime() {
        return initTime;
    }

    public void setInitTime(Register initTime) {
        this.initTime = initTime;
    }

    public Register getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Register timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Register getInitProgramIndex() {
        return initProgramIndex;
    }

    public void setInitProgramIndex(Register initProgramIndex) {
        this.initProgramIndex = initProgramIndex;
    }

    public Register getProcessLength() {
        return processLength;
    }

    public void setProcessLength(Register processLength) {
        this.processLength = processLength;
    }
}
