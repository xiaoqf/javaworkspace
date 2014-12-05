package note12.filesystem;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class FSElement {
    private String name;
    private String owner;
    private Date createdDate;
    private Date lastModified;
    private int size;
    private Directory parent;
    
    public FSElement(Directory parent, String name, String owner, int size) {
        this.parent = parent;
        if (parent != null) {
            parent.appendChildren(this);
        }
        this.name = name;
        this.owner = owner;
        this.size = size;
        this.createdDate = new Date();
        this.lastModified = new Date();
    }

    public String getName() {
        return name;
    }

    /**
     * invoke when to change the name of this fsElement
     * 
     * @param name New name.
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    /**
     * invoke when to change the owner of this fsElement
     * 
     * @param owner New owner.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    /**
     * invoke when to change the content of this fsElement
     * 
     * @param lastModified New lastModified.
     */
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public int getSize() {
        return size;
    }

    /**
     * invoke when to change the content of this fsElemet
     * 
     * @param size New size.
     */
    public void setSize(int size) {
        this.size = size;
    }

    public Directory getParent() {
        return parent;
    }
    
    public String getPath() {
        String path = "/" ;
        if (parent != null) {
            path = parent.getPath() + parent.getName()+ path;
        }
        return path;
    }

    /**
     *  invoke when to move this fsElement
     *  @param parent the new directory where this fsElement want to move to.
     */
    public void moveTo(Directory parent) {
        if (this.parent != null) {
            this.parent.getChildren().remove(this);
        }
        this.parent = parent;
        parent.getChildren().add(this);
    }

    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss:SSS");
        StringBuilder builder = new StringBuilder();
        builder.append(getPath());
        builder.append(name);
        builder.append("   ");
        builder.append(owner);
        builder.append("   ");
        builder.append(getSize());
        builder.append("   ");
        builder.append(format.format(createdDate));
        builder.append("   ");
        builder.append(format.format(lastModified));
        return builder.toString();
    }
    
    public boolean equals(Object obj) {
        if(!(obj instanceof FSElement)) {
            return false;
        } 
        FSElement element = (FSElement) obj;
        if(getParent().equals(element.getParent()) && getName().equals(element.getName())) {
            return false;
        }
        return true;
    }
}
