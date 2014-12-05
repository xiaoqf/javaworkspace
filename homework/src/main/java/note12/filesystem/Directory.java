package note12.filesystem;

import java.util.HashSet;
import java.util.Set;

/**
 * class Directory<br/>
 * A directory
 * @author author
 * @since 2014/12/05
 */
public class Directory extends FSElement {

    /**
     * Create a new directory.
     * @param parent Parent directory.
     * @param name The name of the new directory.
     * @param owner The owner of the new directory.
     */
    public Directory(Directory parent, String name, String owner) {
        super(parent, name, owner, 0);
    }
    // this program use HashSet because the file is not allowed to be the same as another one;
    @SuppressWarnings("serial")
    private Set<FSElement> children = new HashSet<FSElement>() {
        public boolean add(FSElement element) {
            if (contains(element)) {
                return false;
            } else {
                return super.add(element);
            }
        }
    };
    /**
     * Add a file or directory into this directory.
     * @param fsElement New file or directory.
     */
    public void appendChildren(FSElement fsElement){
        children.add(fsElement);
    }
    /**
     * Get the files or directories in this directory.
     * @return The files or directories in this directory
     */
    public Set<FSElement> getChildren() {
        return children;
    }
    /**
     * Get the total size of all the children.
     */
    public int getSize() {
        int size = 0;
        for(FSElement fsElement: children) {
            size = size + fsElement.getSize();
        }
        return size;
    }
}
