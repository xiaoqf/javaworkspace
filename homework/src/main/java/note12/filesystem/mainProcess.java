package note12.filesystem;
/**
 * main process
 * @author author
 *
 */
public class mainProcess {
    /**
     * main process
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Directory root = new Directory(null, "root", "author");
        Directory home = new Directory(root, "home", "author");
        Directory tom = new Directory(home, "tom", "tom");
        Directory tomWork = new Directory(tom, "tomWork", "tom");
        Directory tomTest = new Directory(tom, "tomTest", "tom");
        Directory jim = new Directory(home, "jim", "jim");
        Directory jimWork = new Directory(jim, "jimWork", "jim");
        Directory jimTest = new Directory(jim, "jimTest", "jim");
        File tomLog = new File(tom, "tomLog", "tom", 10);
        File tomWorkFile = new File(tomWork, "tomWorkFile", "tom", 20);
        File tomTestFile = new File(tomTest, "tomTestFile", "tom", 30);
        System.out.println("Before move");
        // show all the files and directories of this file system.
        showChildren(root);
        tomLog.moveTo(jim);
        System.out.println("\nAfter move tomLog to jim");
        // show the changed file and its parent
        // watch of the size of the directories "jim" and "tom", even through they've not been changed.
        System.out.println(root);
        System.out.println(jim);
        System.out.println(tom);
        System.out.println(tomLog);
        tomLog.change(25);
        // show the changed file and its parent
        // watch of the size of the directory "jim", even through it has not been changed.
        System.out.println("\nAfter tomLog changed");
        System.out.println(root);
        System.out.println(jim);
        System.out.println(tom);
        System.out.println(tomLog);
        
        // you can move the files and directories to everywhere if you want.
        System.out.println("\nAfter move");
        jimWork.moveTo(tom);
        tomTestFile.moveTo(jimTest);
        System.out.println(jimWork);
        System.out.println(tomTestFile);
        jimTest.moveTo(tomTest);
        System.out.println(jimTest);
        System.out.println(tomTestFile);
        
        System.out.println("\nat last check the file system.");
        showChildren(root);
    }
    
    public static void showChildren(Directory directory) {
        System.out.println(directory);
        for(FSElement element : directory.getChildren()) {
            if(element instanceof Directory) {
                showChildren((Directory) element);
            } else {
                System.out.println(element);
            }
        }
    }
}
