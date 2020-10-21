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
        for (int i = 0; i < this.regexInstructionsArray.length; i++) {
            if (Pattern.matches(this.regexInstructionsArray[i], line)) {
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
    public String validateLineFormat(String data) throws IOException {
        String lines[] = data.split("\\r?\\n");
        String linesWithError = "";
        for (int i = 0; i < lines.length; i++) {
            if (!validateSingleLine(lines[i])) {
                int lineIndex = i + 1;
                linesWithError += lineIndex + " ";
            }
        }
        return linesWithError;
    }

    /**
     * validates that the .asm selected file is not empty and has the correct
     * format
     *
     * @param data
     * @return
     * @throws IOException
     */
    public String[] validateSelectedFile(String data) throws IOException {
        String[] result = new String[2];
        Boolean fileIsEmpty = data.isEmpty();

        if (fileIsEmpty) {
            result[0] = "1";
            result[1] = "Error: el archivo está vacío";
            return result;
        } else {
            String linesWithError = this.validateLineFormat(data);
            if (linesWithError.equals("")) {
                result[0] = "0";
                result[1] = "Nuevo";
            }
            else{
                result[0] = "1";
                if(linesWithError.split(" ").length > 1){
                    result[1] = "Error en las líneas: " + linesWithError;
                }
                else result[1] = "Error en la línea: " + linesWithError;
            }
        }

        return result;
    }
}
