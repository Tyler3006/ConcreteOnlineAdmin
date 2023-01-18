
package nz.co.concreteOnlineA.services;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
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
    
    multiFileIn();
    }
    
    public void multiFileIn() {
        try {
            Socket socket = new Socket("localhost", 5000); // connect to server on port 5000
            InputStream inputStream = socket.getInputStream(); // get input stream to receive data from server
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            
            // receive number of files to be received
            int numberOfFiles = dataInputStream.readInt();
            
            for (int i = 0; i < numberOfFiles; i++) {
                // receive file name and file size
                String fileName = dataInputStream.readUTF();
                long fileSize = dataInputStream.readLong();
                
                // create new file with the received file name
                File file = new File(fileName);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                
                // receive file contents and write them to the new file
                byte[] buffer = new byte[4096];
                int bytesRead;
                long totalBytesRead = 0;
                while (totalBytesRead < fileSize) {
                    bytesRead = inputStream.read(buffer);
                    fileOutputStream.write(buffer, 0, bytesRead);
                    totalBytesRead += bytesRead;
                }
                fileOutputStream.close();
            }
            connectionEstablished = true;
            inputStream.close();
            socket.close();
            
            
//        try {
//            Socket socket = new Socket("localhost", 8000);
//            InputStream inputStream = socket.getInputStream();
//            DataInputStream dataInputStream = new DataInputStream(inputStream);
//            int numFiles = dataInputStream.readInt();
//            for (int i = 0; i < numFiles; i++) {
//                String fileName = dataInputStream.readUTF();
//                FileOutputStream fileOutputStream = new FileOutputStream("jobStack/" + fileName);
//                byte[] buffer = new byte[4096];
//                int bytesRead;
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    fileOutputStream.write(buffer, 0, bytesRead);
//                }
//                
//                fileOutputStream.close();
//                
//            }
//                            connectionEstablished = true;
//
//            inputStream.close();
//            socket.close();
//        } catch (IOException ex) {
//            System.out.println("Connection Lost, Called from FileIn func");
//        }
        } catch (IOException ex) {
            Logger.getLogger(FileReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void fileIn() {
//    
//        try {
//            // Read the file name
//            try ( // Connect to the server
//                    Socket socket = new Socket("localhost", 8000)) {
//                // Read the file name
//                DataInputStream in = new DataInputStream(socket.getInputStream());
//                String fileName = in.readUTF();
//                
//                // Read the file
//                byte[] bytes = new byte[16 * 1024];
//                InputStream is = socket.getInputStream();
//                FileOutputStream fos = new FileOutputStream("jobStack/"+fileName);
//                BufferedOutputStream bos = new BufferedOutputStream(fos);
//                int count;
//                
//                while ((count = is.read(bytes)) > 0) {
//                    bos.write(bytes, 0, count);
//                }
//                connectionEstablished = true;
//                // Close the socket and output stream
//                bos.close();
//            }
//        } catch (IOException ex) {
//            //Logger.getLogger(FileReceiver.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Connection Lost, Called from FileIn func");
//        }
//    }
    

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
