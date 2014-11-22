package design.process;

public class Process {
	private long id;
	
	private int timeReqd;
	
	private int priority;
	
	private int timeArrival;
	
	private int runningTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTimeReqd() {
		return timeReqd;
	}

	public void setTimeReqd(int timeReqd) {
		this.timeReqd = timeReqd;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(int timeArrival) {
		this.timeArrival = timeArrival;
	}
	
	public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    @Override
	public String toString() {
		return "( " + id + ", " + timeReqd + ", " + priority + ")";
	}
}
