
package nz.co.concreteOnlineA.services;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tyler Costa
 */
public class FileReceiver {

    public boolean connectionEstablished;

    public FileReceiver() throws IOException {

        //fileIn();
        //newFileIn();
    
    fileIn();
    }
    
    public void fileIn() {
    
        try {
            // Connect to the server
            Socket socket = new Socket("localhost", 8000);
            
            // Read the file name
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String fileName = in.readUTF();
            
            // Read the file
            byte[] bytes = new byte[16 * 1024];
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream("jobStack/"+fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int count;
            
            while ((count = is.read(bytes)) > 0) {
                bos.write(bytes, 0, count);
            }
            connectionEstablished = true;
            // Close the socket and output stream
            bos.close();
            socket.close();
        } catch (IOException ex) {
            //Logger.getLogger(FileReceiver.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Lost, Called from FileIn func");
        }
    }
    

//   public void newFileIn() throws IOException{
//        String serverAddress = "localhost"; // specify the server's IP address
//        int port = 1234; // specify the server's port number
//        Socket socket = new Socket(serverAddress, port);
//
//        byte[] bytes = new byte[16 * 1024];
//        InputStream in = socket.getInputStream();
//        FileOutputStream fos = new FileOutputStream("received_file.txt");
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
//        int bytesRead = in.read(bytes, 0, bytes.length);
//        bos.write(bytes, 0, bytesRead);
//        bos.close();
//
//        System.out.println("File received from server.");
//    }
    

}
