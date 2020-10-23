/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import GUI.MiniPC;
import java.awt.Label;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import logic.CPU;
import logic.Core;
import logic.InstructionManager;
import logic.Memory;
import logic.MemoryManager;
import logic.PCB;
import logic.Register;

/**
 *
 * @author Michelle Alvarado
 */
public class ExecuteController {

    MiniPC view;
    PCB currentProcessPCB1;
    PCB currentProcessPCB2;
    int currentInstructionPCB1RemainingTime;
    int currentInstructionPCB2RemainingTime;
    InstructionManager instructionManager;

    public ExecuteController(MiniPC viewP) {
        this.view = viewP;
        this.currentProcessPCB1 = null;
        this.currentProcessPCB2 = null;
        this.currentInstructionPCB1RemainingTime = -1;
        this.currentInstructionPCB2RemainingTime = -1;
        this.instructionManager = new InstructionManager();
    }

    public void setCPUTimeLabel() {
        this.view.cpuTimeValue.setText(Integer.toString(CPU.getCPU().getCPUCurrentTime()));
    }

    public void setCore1LabelValues() {
        Core core1 = CPU.getCPU().getCore1();
        this.view.processCore1IDValue.setText(core1.getCurrentProcessID().getRegisterValue());
        this.view.IRRegisterCore1Value.setText(core1.getIRRegister().getRegisterValue());
    }

    public void setCore2LabelValues() {
        Core core2 = CPU.getCPU().getCore2();
        this.view.processCore2IDValue.setText(core2.getCurrentProcessID().getRegisterValue());
        this.view.IRRegisterCore2Value.setText(core2.getIRRegister().getRegisterValue());
    }

    public void setBCP1LabelValues(PCB processPCB) {
        this.view.idProcessBCP1Value.setText(processPCB.getProcessID().getRegisterValue());
        this.view.stateBCP1Value.setText(processPCB.getProcessStatus().getRegisterValue());
        this.view.pcRegisterBCP1Value.setText(processPCB.getPC().getRegisterValue());
        this.view.acRegisterBCP1Value.setText(processPCB.getAC().getRegisterValue());
        this.view.axRegisterBCP1Value.setText(processPCB.getAX().getRegisterValue());
        this.view.bxRegisterBCP1Value.setText(processPCB.getBX().getRegisterValue());
        this.view.cxRegisterBCP1Value.setText(processPCB.getCX().getRegisterValue());
        this.view.dxRegisterBCP1Value.setText(processPCB.getDX().getRegisterValue());
        this.view.ESStateBCP1Value.setText(processPCB.getIOStatus().getRegisterValue());
        this.view.initTimeBCP1Value.setText(processPCB.getInitTime().getRegisterValue());
        this.view.instructionTimeBCP1Value.setText(Integer.toString(this.currentInstructionPCB1RemainingTime));
    }

    public void setBCP2LabelValues(PCB processPCB) {
        this.view.idProcessBCP1Value1.setText(processPCB.getProcessID().getRegisterValue());
        this.view.stateBCP1Value1.setText(processPCB.getProcessStatus().getRegisterValue());
        this.view.pcRegisterBCP1Value1.setText(processPCB.getPC().getRegisterValue());
        this.view.acRegisterBCP1Value1.setText(processPCB.getAC().getRegisterValue());
        this.view.axRegisterBCP1Value1.setText(processPCB.getAX().getRegisterValue());
        this.view.bxRegisterBCP1Value1.setText(processPCB.getBX().getRegisterValue());
        this.view.cxRegisterBCP1Value1.setText(processPCB.getCX().getRegisterValue());
        this.view.dxRegisterBCP1Value1.setText(processPCB.getDX().getRegisterValue());
        this.view.ESStateBCP1Value1.setText(processPCB.getIOStatus().getRegisterValue());
        this.view.initTimeBCP1Value1.setText(processPCB.getInitTime().getRegisterValue());
        this.view.instructionTimeBCP2Value.setText(Integer.toString(this.currentInstructionPCB2RemainingTime));
    }

    public void setBCPStackLabelValues(ArrayList<Register> stack, JTable table) {
        String[] header = new String[]{"Pila"};
        boolean[] editable = new boolean[]{false};
        Object[][] data = new Object[stack.size()][1];
        for (int i = 0; i < stack.size(); i++) {
            data[i][0] = stack.get(i).getRegisterValue();
        }
        table.setModel(new javax.swing.table.DefaultTableModel(
                data,
                header
        ) {
            boolean[] canEdit = editable;

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    public void setExecuteVariables() {
        this.setCPUTimeLabel();
        if (this.currentProcessPCB1 != null) {
            CPU.getCPU().getCore1().getCurrentProcessID().setRegisterValue(this.currentProcessPCB1.getProcessID().getRegisterValue());
            CPU.getCPU().getCore1().getIRRegister().setRegisterValue(this.getInstructionForIRRegister(this.currentProcessPCB1));
            this.currentProcessPCB1.getInitTime().setRegisterValue(Integer.toString(CPU.getCPU().getCPUCurrentTime()));
            int weigth = this.instructionManager.getInstructionWeigth(CPU.getCPU().getCore1().getIRRegister().getRegisterValue().split(" ")[0]);
            this.currentInstructionPCB1RemainingTime = weigth;
            this.setCore1LabelValues();
            this.setBCP1LabelValues(this.currentProcessPCB1);
            this.setBCPStackLabelValues(this.currentProcessPCB1.getStack(), this.view.stackBCP1);
        }
        if (this.currentProcessPCB2 != null) {
            CPU.getCPU().getCore2().getCurrentProcessID().setRegisterValue(this.currentProcessPCB2.getProcessID().getRegisterValue());
            CPU.getCPU().getCore2().getIRRegister().setRegisterValue(this.getInstructionForIRRegister(this.currentProcessPCB2));
            this.currentProcessPCB2.getInitTime().setRegisterValue(Integer.toString(CPU.getCPU().getCPUCurrentTime()));
            int weigth = this.instructionManager.getInstructionWeigth(CPU.getCPU().getCore2().getIRRegister().getRegisterValue().split(" ")[0]);
            this.currentInstructionPCB2RemainingTime = weigth;
            this.setCore2LabelValues();
            this.setBCP2LabelValues(this.currentProcessPCB2);
            this.setBCPStackLabelValues(this.currentProcessPCB2.getStack(), this.view.stackBCP2);
        }
        new controller.TableController(view).setProcessesTable();
    }

    public PCB[] getNextProcessesToExecute() {
        PCB[] processesToExecute = new PCB[2];
        ArrayList<PCB> readyQueue = CPU.getCPU().getReadyProcessesQueue();
        if (readyQueue.size() >= 1) {
            processesToExecute[0] = readyQueue.get(0);
            readyQueue.remove(0);
        }
        for (int i = 0; i < readyQueue.size(); i++) {
            PCB currentPCB = readyQueue.get(i);
            if (!currentPCB.getCoreWhereIsRunning().getRegisterValue().equals(processesToExecute[0].getCoreWhereIsRunning().getRegisterValue())) {
                processesToExecute[1] = currentPCB;
                readyQueue.remove(i);
                break;
            }
        }

        return processesToExecute;
    }

    public PCB getProcessByCore(String coreName) {
        PCB processPCB = null;
        ArrayList<PCB> readyQueue = CPU.getCPU().getReadyProcessesQueue();
        for (int i = 0; i < readyQueue.size(); i++) {
            PCB currentReadyPCB = readyQueue.get(i);
            if (currentReadyPCB.getCoreWhereIsRunning().getRegisterValue().equals(coreName)) {
                processPCB = currentReadyPCB;
                break;
            }
        }
        return processPCB;
    }

    public void assignProcessToCore(PCB[] processesToExecute) {
        PCB process1PCB = processesToExecute[0];
        PCB process2PCB = processesToExecute[1];
        if (process1PCB != null) {
            process1PCB.getProcessStatus().setRegisterValue("Ejecutando");
            process1PCB.getInitTime().setRegisterValue(Integer.toString(CPU.getCPU().getCPUCurrentTime()));
        }
        if (process2PCB != null) {
            process2PCB.getProcessStatus().setRegisterValue("Ejecutando");
            process2PCB.getInitTime().setRegisterValue(Integer.toString(CPU.getCPU().getCPUCurrentTime()));
        }

        if (process1PCB != null) {
            if (process1PCB.getCoreWhereIsRunning().getRegisterValue().equals("Núcleo 1")) {
                this.currentProcessPCB1 = process1PCB;
                this.currentProcessPCB2 = process2PCB;
            } else {
                this.currentProcessPCB2 = process1PCB;
                this.currentProcessPCB1 = process2PCB;
            }
        } else if (process2PCB != null) {
            if (process2PCB.getCoreWhereIsRunning().getRegisterValue().equals("Núcleo 1")) {
                this.currentProcessPCB2 = process1PCB;
                this.currentProcessPCB1 = process2PCB;
            } else {
                this.currentProcessPCB1 = process1PCB;
                this.currentProcessPCB2 = process2PCB;
            }
        }
    }

    public void setProcessesToExecute() {
        ArrayList<PCB> readyQueue = CPU.getCPU().getReadyProcessesQueue();
        if (readyQueue.size() > 0) {
            if (this.currentProcessPCB1 == null && this.currentProcessPCB2 == null) {
                PCB[] processesToExecute = this.getNextProcessesToExecute();
                this.assignProcessToCore(processesToExecute);
            } else if (this.currentProcessPCB1 != null && this.currentProcessPCB2 == null) {
                this.currentProcessPCB2 = this.getProcessByCore("Núcleo2");
                if (this.currentProcessPCB2 != null) {
                    this.currentProcessPCB2.getProcessStatus().setRegisterValue("Ejecutando");
                    this.currentProcessPCB2.getInitTime().setRegisterValue(Integer.toString(CPU.getCPU().getCPUCurrentTime()));
                }
            } else if (this.currentProcessPCB1 == null && this.currentProcessPCB2 != null) {
                this.currentProcessPCB1 = this.getProcessByCore("Núcleo 1");
                if (this.currentProcessPCB1 != null) {
                    this.currentProcessPCB1.getProcessStatus().setRegisterValue("Ejecutando");
                    this.currentProcessPCB1.getInitTime().setRegisterValue(Integer.toString(CPU.getCPU().getCPUCurrentTime()));
                }
            }
        } else {
            CPU.getCPU().setCPUIsExecutingProcesses();
        }
    }

    public String getZeros(int count) {
        String zeros = "";
        for (int i = 0; i < count; i++) {
            zeros += "0";
        }
        return zeros;
    }

    public void executeCore1Instruction() {
        if (this.currentProcessPCB1 != null) {
            if (!this.currentProcessPCB1.getProcessStatus().getRegisterValue().equals("En espera")) {
                if (this.currentInstructionPCB1RemainingTime == 1 && this.currentProcessPCB1.getProcessStatus().getRegisterValue().equals("Ejecutando")) {
                    this.currentInstructionPCB1RemainingTime = 0;
                    String result = this.instructionManager.executeInstruction(currentProcessPCB1, CPU.getCPU().getCore1().getIRRegister().getRegisterValue());
                    if (result != "") {
                        JOptionPane.showMessageDialog(this.view, result);
                        this.currentProcessPCB1.getProcessStatus().setRegisterValue(result);
                        this.currentProcessPCB1 = null;
                    } else {
                        int PCIndex = Integer.parseInt(new MemoryManager().decodeAddress(this.currentProcessPCB1.getPC().getRegisterValue())[1]);
                        int initIndex = Integer.parseInt(this.currentProcessPCB1.getInitProgramIndex().getRegisterValue());
                        int programLength = Integer.parseInt(this.currentProcessPCB1.getProcessLength().getRegisterValue());
                        if (PCIndex < (initIndex + programLength)) {
                            String prefix = this.currentProcessPCB1.getPC().getRegisterValue().split(" ")[0];
                            this.currentProcessPCB1.getPC().setRegisterValue(prefix + " " + this.getZeros(4 - Integer.toString(PCIndex).length()) + Integer.toString(PCIndex + 1));
                        } else {
                            this.currentProcessPCB1.getProcessStatus().setRegisterValue("Finalizado");
                            this.currentProcessPCB1 = null;
                        }
                    }
                } else if (this.currentInstructionPCB1RemainingTime > 0 && this.currentProcessPCB1.getProcessStatus().getRegisterValue().equals("Ejecutando")) {
                    this.currentInstructionPCB1RemainingTime -= 1;
                }
            } else {
                //Incluir manejo de E/S
            }
        }
    }

    public void executeCore2Instruction() {
        if (this.currentProcessPCB2 != null) {
            if (!this.currentProcessPCB2.getProcessStatus().getRegisterValue().equals("En espera")) {
                if (this.currentInstructionPCB2RemainingTime == 1 && this.currentProcessPCB2.getProcessStatus().getRegisterValue().equals("Ejecutando")) {
                    this.currentInstructionPCB2RemainingTime = 0;
                    String result = this.instructionManager.executeInstruction(currentProcessPCB2, CPU.getCPU().getCore2().getIRRegister().getRegisterValue());
                    if (result != "") {
                        JOptionPane.showMessageDialog(this.view, result);
                        this.currentProcessPCB2.getProcessStatus().setRegisterValue(result);
                        this.currentProcessPCB2 = null;
                    } else {
                        int PCIndex = Integer.parseInt(new MemoryManager().decodeAddress(this.currentProcessPCB2.getPC().getRegisterValue())[1]);
                        int initIndex = Integer.parseInt(this.currentProcessPCB2.getInitProgramIndex().getRegisterValue());
                        int programLength = Integer.parseInt(this.currentProcessPCB2.getProcessLength().getRegisterValue());
                        if (PCIndex < (initIndex + programLength)) {
                            String prefix = this.currentProcessPCB2.getPC().getRegisterValue().split(" ")[0];
                            this.currentProcessPCB2.getPC().setRegisterValue(prefix + " " + this.getZeros(4 - Integer.toString(PCIndex).length()) + Integer.toString(PCIndex + 1));
                        } else {
                            this.currentProcessPCB2.getProcessStatus().setRegisterValue("Finalizado");
                            this.currentProcessPCB2 = null;
                        }
                    }
                } else if (this.currentInstructionPCB2RemainingTime > 0 && this.currentProcessPCB2.getProcessStatus().getRegisterValue().equals("Ejecutando")) {
                    this.currentInstructionPCB2RemainingTime -= 1;
                }
            } else {
                //Incluir manejo de E/S
            }
        }
    }

    public String getInstructionForIRRegister(PCB processPCB) {
        String instruction = "";
        String[] instructionLocation = new MemoryManager().decodeAddress(processPCB.getPC().getRegisterValue());
        Memory memory = instructionLocation[0].equals("mainMemory") ? CPU.getCPU().getMainMemory() : CPU.getCPU().getSecondaryMemory();
        instruction = memory.getMemoryRegisters().get(Integer.parseInt(instructionLocation[1])).getRegisterValue();
        return instruction;
    }

    public void executeOneCPUTime() {
        this.setProcessesToExecute();
        if (this.currentProcessPCB1 != null || this.currentProcessPCB2 != null) {
            CPU.getCPU().setCPUCurrentTime();
            this.executeCore1Instruction();
            this.executeCore2Instruction();
            this.setCurrentExecutionVariables();
        } else {
            this.view.nextButton.setEnabled(false);
        }
    }

    public void setCurrentExecutionVariables() {
        this.setCPUTimeLabel();
        if (this.currentProcessPCB1 != null) {
            this.setCore1LabelValues();
            this.setBCP1LabelValues(this.currentProcessPCB1);
            this.setBCPStackLabelValues(this.currentProcessPCB1.getStack(), this.view.stackBCP1);
            if (this.currentInstructionPCB1RemainingTime == 0) {
                int weigth = this.instructionManager.getInstructionWeigth(CPU.getCPU().getCore1().getIRRegister().getRegisterValue().split(" ")[0]);
                this.currentInstructionPCB1RemainingTime = weigth;
                CPU.getCPU().getCore1().getIRRegister().setRegisterValue(this.getInstructionForIRRegister(this.currentProcessPCB1));
            }
        }
        if (this.currentProcessPCB2 != null) {
            this.setCore2LabelValues();
            this.setBCP2LabelValues(this.currentProcessPCB2);
            this.setBCPStackLabelValues(this.currentProcessPCB2.getStack(), this.view.stackBCP2);
            if (this.currentInstructionPCB2RemainingTime == 0) {
                int weigth = this.instructionManager.getInstructionWeigth(CPU.getCPU().getCore2().getIRRegister().getRegisterValue().split(" ")[0]);
                this.currentInstructionPCB2RemainingTime = weigth;
                CPU.getCPU().getCore2().getIRRegister().setRegisterValue(this.getInstructionForIRRegister(this.currentProcessPCB2));
            }

        }
        new controller.TableController(view).setProcessesTable();
    }
}
