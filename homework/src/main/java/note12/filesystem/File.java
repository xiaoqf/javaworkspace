package note12.filesystem;

import java.util.Date;

/**
 * class Directory<br/>
 * A file
 * @author author
 * @since 2014/12/05
 */
public class File extends FSElement {

    /**
     * Create a new file.
     * @param parent Parent file.
     * @param name The name of the new file.
     * @param owner The owner of the new file.
     * @param size The initial size of this file.
     */
    public File(Directory parent, String name, String owner, int size) {
        super(parent, name, owner, size);
    }

    /**
     * Change the file content;
     * @param size The new size of this file after it changed.
     */
    public void change(int size) {
        setSize(size);
        setLastModified(new Date());
    }
}
