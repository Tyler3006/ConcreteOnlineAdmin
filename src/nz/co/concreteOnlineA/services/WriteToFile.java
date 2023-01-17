
package nz.co.concreteOnlineA.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import nz.co.concreteOnlineA.JobHandling.ConcreteJobOrder;
import nz.co.concreteOnlineA.users.User;

/**
 *
    * @author Tyler Costa
 */
public class WriteToFile {

    String fileInput;
    String targetFile;
    String txtExtension = ".concon";
    boolean append = true;
    static HashMap<Integer, ConcreteJobOrder> jobsToWrite;

    public WriteToFile(String fileInput, String targetFile, boolean append) {
        this.fileInput = fileInput;
        this.targetFile = targetFile;
        this.append = append;
        writeFile();
    }

    public WriteToFile(HashMap<Integer, ConcreteJobOrder> jobs, String targetFile) {

        this.jobsToWrite = jobs;
        this.targetFile = targetFile;

        //System.out.println("From WTF class: " + users);

        HashMapWriter();
    }

    public void writeFile() {
        try {
            PrintWriter pw = null;
            pw = new PrintWriter(new FileOutputStream(targetFile + txtExtension, append));
            pw.println(fileInput);
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

    public void HashMapWriter() {
        try {

            PrintWriter pw = null;

            pw = new PrintWriter(new FileOutputStream(targetFile + txtExtension, append));

            for (Map.Entry<Integer, ConcreteJobOrder> entry : jobsToWrite.entrySet()) {
                pw.write(entry.getKey() + ": " + entry.getValue());
            }

            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

}