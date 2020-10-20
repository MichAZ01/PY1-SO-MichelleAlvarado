/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 *
 * @author Michelle Alvarado
 */
public class ProgramValidator {
    String[] regexInstructionsArray;

    public ProgramValidator() throws IOException {
        this.loadRegexInstructions();
    }

    public void loadRegexInstructions() throws IOException {
        FileReader fileReader = new FileReader();
        String regexConfigFile = System.getProperty("user.dir") + "\\src\\logic\\configFiles\\InstructionsRegexConfigFile.txt";
        String[] fileLines = fileReader.readFile(regexConfigFile);
        String[] regexInstructions = new String[fileLines.length];
        for (int i = 0; i < fileLines.length; i++) {
            regexInstructions[i] = fileLines[i].split(":")[1];
            System.out.println(regexInstructions[i]);
        }
        this.regexInstructionsArray = regexInstructions;
    }

    /**
     * validate (depend of the operation) if a instruction is correct or not
     *
     * @param line
     * @return
     * @throws IOException
     */
    public Boolean validateSingleLine(String line) {
        Boolean correctFormat = false;
        String operation = line.split(" ")[0];
        for(int i = 0; i < this.regexInstructionsArray.length; i++){
            if(Pattern.matches(this.regexInstructionsArray[i], line)){
                correctFormat = true;
                break;
            }
        }

        return correctFormat;
    }

    /**
     * the loop for validate each program instruction
     *
     * @param data
     * @return
     * @throws IOException
     */
    public Boolean validateLineFormat(String data) throws IOException {
        Boolean correctFormat = true;
        String lines[] = data.split("\\r?\\n");

        for (int i = 0; i < lines.length; i++) {
            if (!validateSingleLine(lines[i])) {
                correctFormat = false;
                break;
            }
        }
        return correctFormat;
    }

    /**
     * validates that the .asm selected file is not empty and has the correct
     * format
     *
     * @param data
     * @return
     * @throws IOException
     */
    public Boolean validateSelectedFile(String data) throws IOException {
        Boolean correctFile = true;
        Boolean fileIsEmpty = data.isEmpty();
        Boolean correctFormat = this.validateLineFormat(data);

        if (fileIsEmpty || !correctFormat) {
            correctFile = false;
        }

        return correctFile;
    }
}