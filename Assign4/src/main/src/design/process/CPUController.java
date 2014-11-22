package design.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CPUController {

    /** the processes that is in the CPU heap */
    private static List<Process> heap = new ArrayList<Process>();

    /** all processes read from the input file */
    private static Iterator<Process> fileProcesses;

    /** time units the CPU ¡°will hold¡± each process */
    private static int processTime;

    /** output Stream */
    private static PrintStream printer;

    /** the process which is in processing */
    private static Process currentProcess;

    /** a comparator which compares processes with priority */
    private static PriorityComparator priorityComparator = new PriorityComparator();

    /** whitespace at the start of the process information lines */
    private static final String LINEHEADER = "    ";

    /**
     * this class is not allowed to be instantiated
     */
    private CPUController() {
    }

    public static void main(String[] args) throws IOException {
        try {
            // get the input file with path
            String inputFileName = Thread.currentThread().getContextClassLoader().getResource("inputData.data")
                    .getPath();
            // set the name and path of the output file
            String outputFileName = "E:/result.txt";

            // initialize
            init(inputFileName, outputFileName);

            Process nextFileProcess = fileProcesses.next();
            for (int time = 1; !heap.isEmpty() || fileProcesses.hasNext() || currentProcess != null; time++) {

                printer.println();
                printer.println("time unit " + time + ":");

                while (time == nextFileProcess.getTimeArrival()) {
                    heap.add(nextFileProcess);
                    if (fileProcesses.hasNext()) {
                        nextFileProcess = fileProcesses.next();
                    } else {
                        break;
                    }
                }
                timeUnitStart();
                running();
                timeUnitEnd();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (printer != null) {
                printer.close();
            }
        }
    }

    /**
     * read the input file and initialize the CPU
     * 
     * @param inputFileName
     *            the name with path of the input File
     * @param outputFileName
     *            the name with path of the output File
     */
    @SuppressWarnings("resource")
    private static void init(String inputFileName, String outputFileName) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));

        // first line
        String line = reader.readLine();
        processTime = Integer.parseInt(line.trim());

        List<Process> processes = new ArrayList<Process>();
        // process lines
        line = reader.readLine();
        while (line != null) {
            if (!line.equals("")) {
                // split with any whitespace
                String[] values = line.trim().split("\\s+");

                // process setting
                Process process = new Process();
                process.setId(Long.parseLong(values[0]));
                process.setTimeReqd(Integer.parseInt(values[1]));
                process.setPriority(Integer.parseInt(values[2]));
                process.setTimeArrival(Integer.parseInt(values[3]));
                processes.add(process);
            }
            // next line
            line = reader.readLine();
        }
        // sort with the arriving time
        processes.sort(new Comparator<Process>() {
            public int compare(Process o1, Process o2) {
                if (o1.getTimeArrival() > o2.getTimeArrival())
                    return 1;
                if (o1.getTimeArrival() < o2.getTimeArrival())
                    return -1;
                return 0;
            }
        });
        fileProcesses = processes.iterator();
        printer = new PrintStream(outputFileName);
    }

    /**
     * time unit processing start
     */
    private static void timeUnitStart() {
        heap.sort(priorityComparator);
        printer.println(LINEHEADER + heap);
        if (currentProcess != null) {
            printer.println(LINEHEADER + currentProcess);
        } else {
            printer.println(LINEHEADER + "-");
            currentProcess = heap.remove(0);
            currentProcess.setRunningTime(processTime);
        }
    }

    /**
     * time unit processing
     */
    private static void running() {
        printer.println();
        printer.println(LINEHEADER + heap);
        printer.println(LINEHEADER + currentProcess);
        currentProcess.setTimeReqd(currentProcess.getTimeReqd() - 1);
        currentProcess.setRunningTime(currentProcess.getRunningTime() - 1);
    }

    /**
     * time unit processing end
     */
    private static void timeUnitEnd() {
        if (currentProcess.getTimeReqd() == 0) {
            currentProcess = null;
        } else if (currentProcess.getRunningTime() == 0) {
            heap.add(currentProcess);
            heap.sort(priorityComparator);
            currentProcess = null;
        }

        printer.println();
        printer.println(LINEHEADER + heap);
        if (currentProcess != null) {
            printer.println(LINEHEADER + currentProcess);
        } else {
            printer.println(LINEHEADER + "-");
        }
    }

    /**
     * 
     * @author xiao
     * 
     */
    private static class PriorityComparator implements Comparator<Process> {
        public int compare(Process o1, Process o2) {
            if (o1.getPriority() > o2.getPriority())
                return -1;
            if (o1.getPriority() < o2.getPriority())
                return 1;
            return 0;
        }
    }
}
