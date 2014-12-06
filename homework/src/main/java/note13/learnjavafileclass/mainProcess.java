package note13.learnjavafileclass;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * main process
 * @author author
 *
 */
public class mainProcess {

    /**
     * main process
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        File file = chooseFile(null);
        representFile(file);
        handleFile(file);
    }
    
    // choose the file you want to operation.
    private static File chooseFile(File file) {
        JFileChooser fileChooser;
        if (file == null) {
            fileChooser = new JFileChooser("c:\\");
        } else { 
            fileChooser = new JFileChooser(file);
        }
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setApproveButtonText("Ñ¡Ôñ");
        int selecttion = fileChooser.showDialog(null, null);
        if (selecttion != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        return fileChooser.getSelectedFile();
    }

    
    private static void representFile(File file) throws IOException {
        if (file == null) {
            System.out.println("You have not choosed a file.");
            return;
        }
        // you can get the objectives of the file.
        // ===============================================================
        System.out.println("path: " + file.getPath());
        System.out.println("name: " + file.getName());
        System.out.println("absolutePath" + file.getAbsolutePath());
        // ===============================================================
    }
    
    private static void handleFile(File file) throws IOException {
        if(file.isDirectory()){
            // you can test if this file is a directory
            System.out.println();
            System.out.println("this is a directory.");
            System.out.println("create a new child file with name 'test.txt'.");
            // you can create new file.
            File child = new File(file, "test.txt");
            // you can create new file with the abstract file object into your disk. 
            if (child.createNewFile()) {
                System.out.println("new file has been created: " + child.getPath());
            } else {
                System.out.println("failed to create the new file: " + child.getAbsolutePath());
            }
            System.out.println(child.mkdir());
            File subDirectory = new File(file, "sub");
            // you can create new directory with the abstract file object into your disk.
            System.out.println(subDirectory.createNewFile());
            if (subDirectory.mkdir()) {
                System.out.println("new directory has been created: " + subDirectory.getAbsolutePath());
            } else {
                System.out.println("failed to create the new directory: " + subDirectory.getAbsolutePath());
            }
            
            System.out.println();
        } else if (file.isFile()) {
         // you can test if this file is a file
            System.out.println();
            System.out.println("this is a file.");
            System.out.println("delete this file");
            if(JOptionPane.showConfirmDialog(null, "do you want to delete this file") == JOptionPane.OK_OPTION) {
                // you can delete this file from your disk.
                if(file.delete()) {
                    System.out.println("file has been deleted.");
                } else {
                    System.out.println("fail to delete this file.");
                }
            } else {
                System.out.println("the delete operation has been cacelled.");
            }
        }
    }
}
