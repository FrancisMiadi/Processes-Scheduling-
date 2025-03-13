// Name : Francis Ihab Miadi
//ID :1210100
// operating Systems second project
// section :1
// Date :5/1/2024

package OS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Process {

    String name;
    int arrivalTime;
    int burstTime;
    int waitingTime;
    int hasArrived = 0;
    int comeBack;
    int completion;
    boolean recent;
    int newBurst;
    int index;
    int priority;
    int newPriority;
    int left;
    int lastArrival;
    int burstSUM;
    int CBSUM;
    int originalarrival;
    int wentToAnswer;
    int ProcessingTime;
    int TurnAround;
    int lastEX = 0;
    int ready;

    public Process() {

    }

    public Process(String name, int arrivalTime, int burstTime, int waitingTime, int hasArrived, int comeBack,
            int completion) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = waitingTime;
        this.hasArrived = hasArrived;
        this.comeBack = comeBack;
        this.completion = completion;
        this.recent = false;
        this.newBurst = burstTime;
        this.originalarrival = arrivalTime;
    }

    public Process(String name, int arrivalTime, int burstTime, int waitingTime, int hasArrived, int comeBack,
            int completion, int index) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = waitingTime;
        this.hasArrived = hasArrived;
        this.comeBack = comeBack;
        this.completion = completion;
        this.recent = false;
        this.newBurst = burstTime;
        this.index = index;
        this.left = this.newBurst - this.burstTime;
        this.originalarrival = arrivalTime;

    }

    public Process(String name, int arrivalTime, int burstTime, int waitingTime, int hasArrived, int comeBack,
            int completion, int index, int priority) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = waitingTime;
        this.hasArrived = hasArrived;
        this.comeBack = comeBack;
        this.completion = completion;
        this.recent = false;
        this.newBurst = burstTime;
        this.index = index;
        this.priority = priority;
        this.newPriority = priority;
        this.originalarrival = arrivalTime;
        this.ready = ready;

    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setHasArrived(int hasArrived) {
        this.hasArrived = hasArrived;
    }

    public void setCompletion(int completion) {
        this.completion = completion;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getReady() {
        return ready;
    }

    public int getHasArrived() {
        return hasArrived;
    }

    public int getComeBack() {
        return comeBack;
    }

    public int getCompletion() {
        return completion;
    }

    public String getName() {
        return name;
    }

    public boolean isRecent() {
        return recent;
    }

    public int getNewBurst() {
        return newBurst;
    }

    public int getIndex() {
        return index;
    }

    public int getPriority() {
        return priority;
    }

    public int getNewPriority() {
        return newPriority;
    }

}

public class Secondtask {

    public static void main(String[] args) {

        Process p1 = new Process("p1", 0, 10, 0, 0, 2, 0);
        Process p2 = new Process("p2", 1, 8, 0, 0, 4, 0);
        Process p3 = new Process("p3", 3, 14, 0, 0, 6, 0);
        Process p4 = new Process("p4", 4, 7, 0, 0, 8, 0);
        Process p5 = new Process("p5", 6, 5, 0, 0, 3, 0);
        Process p6 = new Process("p6", 7, 4, 0, 0, 6, 0);
        Process p7 = new Process("p7", 8, 6, 0, 0, 9, 0);

        int time = 0, numOfProcesses = 7, i;
        int ge1,ge2,ge3,ge4,ge5,ge6,ge7;
        LinkedList<String> Done = new LinkedList<>();

        p1.setCompletion(p1.getArrivalTime() + p1.getBurstTime());
        p2.setCompletion(p1.getCompletion() + p2.getBurstTime());
        p3.setCompletion(p2.getCompletion() + p3.getBurstTime());
        p4.setCompletion(p3.getCompletion() + p4.getBurstTime());
        p5.setCompletion(p4.getCompletion() + p5.getBurstTime());
        p6.setCompletion(p5.getCompletion() + p6.getBurstTime());
        p7.setCompletion(p6.getCompletion() + p7.getBurstTime());
        ge1=0;ge2=0;ge3=0;ge4=0;ge5=0;ge6=0;ge7=0;
        Queue<String> ready = new LinkedList<>();
        Queue<String> waiting = new LinkedList<>();

        int burstSum1 = 54;
        //////////////////////////////////////////////////////////////////////// FCFS
        System.out.println();
        System.out.println("Gantt chart for FCFS");
        System.out.println();

        while (burstSum1 <= 200) {

            /*
             * System.out.println("p1 k "+p1.getCompletion());
             * System.out.println("p2 k "+p2.getCompletion());
             * System.out.println("p3 k "+p3.getCompletion());
             * System.out.println("p4 k "+p4.getCompletion());
             * System.out.println("p5 k "+p5.getCompletion());
             * System.out.println("p6 k "+p6.getCompletion());
             * System.out.println("p7 k "+p7.getCompletion());
             */
            if (time == p1.getArrivalTime()) {

                if (p1.hasArrived == 0) {
                    p1.CBSUM += p1.comeBack;
                    p1.burstSUM += p1.burstTime;
                }
                p1.setHasArrived(1);
                Done.add(p1.name);
                waiting.add(p1.name);
                System.out.print("p1 " + "(" + p1.completion + ") ");
                // burstSum1 += p1.burstTime;
                // p1.CBSUM += p1.comeBack;
                // p2.burstSUM+=p2.burstTime;

            }

            if (time == p2.getArrivalTime()) {
                if (p2.hasArrived == 0) {
                    p2.CBSUM += p2.comeBack;
                    p2.burstSUM += p2.burstTime;
                }
                p2.setHasArrived(1);
                waiting.add(p2.name);
                System.out.print("p2 " + "(" + p2.completion + ") ");
                // burstSum1 += p2.burstTime;
                Done.add(p2.name);
                // p2.CBSUM += p2.comeBack;
                // p2.burstSUM+=p2.burstTime;
            }

            if (time == p3.getArrivalTime()) {

                if (p3.hasArrived == 0) {
                    p3.CBSUM += p3.comeBack;
                    p3.burstSUM += p3.burstTime;
                }
                p3.setHasArrived(1);

                waiting.add(p3.name);
                System.out.print("p3 " + "(" + p3.completion + ") ");
                // burstSum1 += p3.burstTime;
                Done.add(p3.name);
                // p3.CBSUM += p3.comeBack;
                // p3.burstSUM+=p3.burstTime;
            }

            if (time == p4.getArrivalTime()) {

                if (p4.hasArrived == 0) {
                    p4.CBSUM += p4.comeBack;
                    p4.burstSUM += p4.burstTime;
                }
                p4.setHasArrived(1);
                waiting.add(p4.name);
                System.out.print("p4 " + "(" + p4.completion + ") ");
                // burstSum1 += p4.burstTime;
                Done.add(p4.name);
                // p4.CBSUM += p4.comeBack;
                // p4.burstSUM+=p4.burstTime;
            }

            if (time == p5.getArrivalTime()) {
                if (p5.hasArrived == 0) {
                    p5.CBSUM += p5.comeBack;
                    p5.burstSUM += p5.burstTime;
                }
                p5.setHasArrived(1);
                waiting.add(p5.name);
                System.out.print("p5 " + "(" + p5.completion + ") ");
                // burstSum1 += p5.burstTime;
                Done.add(p5.name);
                // p5.CBSUM += p5.comeBack;
                // p5.burstSUM+=p5.burstTime;
            }

            if (time == p6.getArrivalTime()) {
                if (p6.hasArrived == 0) {
                    p6.CBSUM += p6.comeBack;
                    p6.burstSUM += p6.burstTime;
                }
                p6.setHasArrived(1);
                waiting.add(p6.name);
                System.out.print("p6 " + "(" + p6.completion + ") ");
                // burstSum1 += p6.burstTime;
                Done.add(p6.name);
                // p6.CBSUM += p6.comeBack;
                // p6.burstSUM+=p6.burstTime;
            }

            if (time == p7.getArrivalTime()) {
                if (p7.hasArrived == 0) {
                    p7.CBSUM += p7.comeBack;
                    p7.burstSUM += p7.burstTime;
                }
                p7.setHasArrived(1);
                waiting.add(p7.name);
                System.out.print("p7 " + "(" + p7.completion + ") ");
                // burstSum1 += p7.burstTime;
                Done.add(p7.name);
                // p7.CBSUM += p7.comeBack;
                // p7.burstSUM+=p7.burstTime;

            }

            if (((time == p1.getCompletion()) && (p2.hasArrived == 1) && (p3.hasArrived == 1) && (p4.hasArrived == 1)
                    && (p5.hasArrived == 1) && (p6.hasArrived == 1) && (p7.hasArrived == 1))) {

                p1.setArrivalTime(time + p1.getComeBack());
                p1.setCompletion(p7.getCompletion() + p1.burstTime);
                burstSum1 += p1.burstTime;
                p1.lastArrival = p7.completion;
                p1.CBSUM += p1.comeBack;
                p1.burstSUM += p1.burstTime;
                // Done.add(waiting.remove());
                // System.out.print("p1 "+"("+p1.completion+") ");

            }

            if (time == p2.getCompletion()) {
                p2.setArrivalTime(time + p2.getComeBack());
                // Done.add(waiting.remove());
                p2.setCompletion(p1.getCompletion() + p2.burstTime);
                burstSum1 += p2.burstTime;
                // System.out.print("p2 "+"("+p2.completion+") ");
                p2.lastArrival = p1.completion;
                p2.CBSUM += p2.comeBack;
                p2.burstSUM += p2.burstTime;
            }

            if (time == p3.getCompletion()) {
                p3.setArrivalTime(time + p3.getComeBack());
                // Done.add(waiting.remove());
                burstSum1 += p3.burstTime;

                p3.setCompletion(p2.getCompletion() + p3.burstTime);
                // System.out.print("p3 "+"("+p3.completion+") ");
                p3.lastArrival = p2.completion;
                p3.CBSUM += p3.comeBack;
                p3.burstSUM += p3.burstTime;
            }

            if (time == p4.getCompletion()) {
                p4.setArrivalTime(time + p4.getComeBack());
                // Done.add(waiting.remove());
                burstSum1 += p4.burstTime;

                p4.setCompletion(p3.getCompletion() + p4.burstTime);
                if (burstSum1 > 200) {
                    Done.add(p4.name);
                    p4.completion--;

                    System.out.print("p4 " + "(" + p4.completion + ") ");
                }
                p4.lastArrival = p3.completion;
                p4.CBSUM += p4.comeBack;
                p4.burstSUM += p4.burstTime;
            }

            if (time == p5.getCompletion()) {
                p5.setArrivalTime(time + p5.getComeBack());
                // Done.add(waiting.remove());
                burstSum1 += p5.burstTime;

                p5.setCompletion(p4.getCompletion() + p5.burstTime);
                // System.out.print("p5 "+"("+p5.completion+") ");
                p5.lastArrival = p4.completion;
                p5.CBSUM += p5.comeBack;
                p5.burstSUM += p5.burstTime;
            }

            if (time == p6.getCompletion()) {
                p6.setArrivalTime(time + p6.getComeBack());
                // Done.add(waiting.remove());
                p6.setCompletion(p5.getCompletion() + p6.burstTime);
                burstSum1 += p6.burstTime;
                // System.out.print("p6 "+"("+p6.completion+") ");
                p6.lastArrival = p5.completion;
                p6.CBSUM += p6.comeBack;
                p6.burstSUM += p6.burstTime;
            }

            if (time == p7.getCompletion()) {
                p7.setArrivalTime(time + p7.getComeBack());
                // Done.add(waiting.remove());

                p7.setCompletion(p6.getCompletion() + p7.burstTime);
                burstSum1 += p7.burstTime;
                // System.out.print("p7 "+"("+p7.completion+") ");
                p7.lastArrival = p6.completion;
                p7.CBSUM += p7.comeBack;
                p7.burstSUM += p7.burstTime;
            }

            time++;

        }
        p1.burstSUM -= p1.burstTime;
        p2.burstSUM -= p2.burstTime;
        p3.burstSUM -= p3.burstTime;
        p4.burstSUM -= p4.burstTime;
        p5.burstSUM -= p5.burstTime;
        p6.burstSUM -= p6.burstTime;
        p7.burstSUM -= p7.burstTime;

        p1.CBSUM -= p1.comeBack;
        p2.CBSUM -= p2.comeBack;
        p3.CBSUM -= p3.comeBack;
        p4.CBSUM -= p4.comeBack;
        p5.CBSUM -= p5.comeBack;
        p6.CBSUM -= p6.comeBack;
        p7.CBSUM -= p7.comeBack;

        /*
         * System.out.println();
         * System.out.println(" p1 CB = "+p1.CBSUM );
         * System.out.println(" p2 CB = "+p2.CBSUM );
         * System.out.println(" p3 CB = "+p3.CBSUM );
         * System.out.println(" p4 CB = "+p4.CBSUM );
         * System.out.println(" p5 CB = "+p5.CBSUM );
         * System.out.println(" p6 CB = "+p6.CBSUM );
         * System.out.println(" p7 CB = "+p7.CBSUM );
         * System.out.println();
         * System.out.println(" p1 BS = "+p1.burstSUM );
         * System.out.println(" p2 BS = "+p2.burstSUM );
         * System.out.println(" p3 BS = "+p3.burstSUM );
         * System.out.println(" p4 BS = "+p4.burstSUM );
         * System.out.println(" p5 BS = "+p5.burstSUM );
         * System.out.println(" p6 BS = "+p6.burstSUM );
         * System.out.println(" p7 BS = "+p7.burstSUM );
         * 
         * System.out.println();
         * System.out.println(" p1 arr = "+p1.lastArrival );
         * System.out.println(" p2 arr = "+p2.lastArrival );
         * System.out.println(" p3 arr = "+p3.lastArrival );
         * System.out.println(" p4 arr = "+p4.lastArrival );
         * System.out.println(" p5 arr = "+p5.lastArrival );
         * System.out.println(" p6 arr = "+p6.lastArrival );
         * System.out.println(" p7 arr = "+p7.lastArrival );
         */

        p1.waitingTime = p1.lastArrival - p1.burstSUM - p1.CBSUM - p1.originalarrival;
        p2.waitingTime = p2.lastArrival - p2.burstSUM - p2.CBSUM - p2.originalarrival;
        p3.waitingTime = p3.lastArrival - p3.burstSUM - p3.CBSUM - p3.originalarrival;
        p4.waitingTime = p4.lastArrival - p4.burstSUM - p4.CBSUM - p4.originalarrival;
        p5.waitingTime = p5.lastArrival - p5.burstSUM - p5.CBSUM - p5.originalarrival;
        p6.waitingTime = p6.lastArrival - p6.burstSUM - p6.CBSUM - p6.originalarrival;
        p7.waitingTime = p7.lastArrival - p7.burstSUM - p7.CBSUM - p7.originalarrival;

        p1.burstSUM += p1.burstTime;
        p2.burstSUM += p2.burstTime;
        p3.burstSUM += p3.burstTime;
        p4.burstSUM += p4.burstTime;
        p5.burstSUM += p5.burstTime;
        p6.burstSUM += p6.burstTime;
        p7.burstSUM += p7.burstTime;
        p1.TurnAround = p1.waitingTime + p1.CBSUM + p1.burstSUM;
        p2.TurnAround = p2.waitingTime + p2.CBSUM + p2.burstSUM;
        p3.TurnAround = p3.waitingTime + p3.CBSUM + p3.burstSUM;
        p4.TurnAround = p4.waitingTime + p4.CBSUM + p4.burstSUM - (burstSum1 - 200);
        p5.TurnAround = p5.waitingTime + p5.CBSUM + p5.burstSUM;
        p6.TurnAround = p6.waitingTime + p6.CBSUM + p6.burstSUM;
        p7.TurnAround = p7.waitingTime + p7.CBSUM + p7.burstSUM;

        System.out.println();
        System.out.println();

        System.out.println(" p1 waiting = " + p1.waitingTime + " p1 Turn Around = " + p1.TurnAround);
        System.out.println(" p2 waiting = " + p2.waitingTime + " p2 Turn Around = " + p2.TurnAround);
        System.out.println(" p3 waiting = " + p3.waitingTime + " p3 Turn Around = " + p3.TurnAround);
        System.out.println(" p4 waiting = " + p4.waitingTime + " p4 Turn Around = " + p4.TurnAround);
        System.out.println(" p5 waiting = " + p5.waitingTime + " p5 Turn Around = " + p5.TurnAround);
        System.out.println(" p6 waiting = " + p6.waitingTime + " p6 Turn Around = " + p6.TurnAround);
        System.out.println(" p7 waiting = " + p7.waitingTime + " p7 Turn Around = " + p7.TurnAround);

        double FCFSAverageWaitingTime = (p1.waitingTime + p2.waitingTime + p3.waitingTime + p4.waitingTime
                + p5.waitingTime + p6.waitingTime + p7.waitingTime) / 7.0;
        double FCFSAverageTurnAroundTime = (p1.TurnAround + p2.TurnAround + p3.TurnAround + p4.TurnAround
                + p5.TurnAround + p6.TurnAround + p7.TurnAround) / 7.0;

        System.out.println();

        System.out.println("Average Waiting Time for FCFS = " + FCFSAverageWaitingTime);
        System.out.println("Average TurnAround for FCFS = " + FCFSAverageTurnAroundTime);

        // System.out.println("Gantt chart for FCFS");
        for (int k = 0; k < Done.size(); k++) {
            // System.out.print(Done.get(k) + " ");

        }
        System.out.println();

        Done.clear();

        ///////////////////////////////////////////////////////// SJF

        p1 = new Process("p1", 0, 10, 0, 0, 2, 0);
        p2 = new Process("p2", 1, 8, 0, 0, 4, 0);
        p3 = new Process("p3", 3, 14, 0, 0, 6, 0);
        p4 = new Process("p4", 4, 7, 0, 0, 8, 0);
        p5 = new Process("p5", 6, 5, 0, 0, 3, 0);
        p6 = new Process("p6", 7, 4, 0, 0, 6, 0);
        p7 = new Process("p7", 8, 6, 0, 0, 9, 0);
        int burstSum2 = 0;
        System.out.println();
        System.out.println("Gantt chart for SJF");
        System.out.println();

        if (p1.arrivalTime == 0) {
            burstSum2 = p1.burstTime;
            Done.add(p1.name);
            p1.completion = burstSum2;
            System.out.print("p1 " + "(" + p1.completion + ") ");

        } else if (p2.arrivalTime == 0) {
            burstSum2 = p2.burstTime;
            Done.add(p2.name);
            p2.completion = burstSum2;
            System.out.print("p2 " + "(" + p2.completion + ") ");
        } else if (p3.arrivalTime == 0) {
            burstSum2 = p3.burstTime;
            Done.add(p3.name);
            p3.completion = burstSum2;
            System.out.print("p3 " + "(" + p3.completion + ") ");
        } else if (p4.arrivalTime == 0) {
            burstSum2 = p4.burstTime;
            Done.add(p4.name);
            p4.completion = burstSum2;
            System.out.print("p4 " + "(" + p4.completion + ") ");
        } else if (p5.arrivalTime == 0) {
            burstSum2 = p5.burstTime;
            Done.add(p5.name);
            p5.completion = burstSum2;
            System.out.print("p5 " + "(" + p5.completion + ") ");
        } else if (p6.arrivalTime == 0) {
            burstSum2 = p6.burstTime;
            Done.add(p6.name);
            p6.completion = burstSum2;
            System.out.print("p6 " + "(" + p6.completion + ") ");
        } else if (p7.arrivalTime == 0) {
            burstSum2 = p7.burstTime;
            Done.add(p7.name);

            System.out.print("p7 " + "(" + p7.completion + ") ");
        }

        ArrayList<Integer> container = new ArrayList<>();
        container.add(p1.burstTime);
        container.add(p2.burstTime);
        container.add(p3.burstTime);
        container.add(p4.burstTime);
        container.add(p5.burstTime);
        container.add(p6.burstTime);
        container.add(p7.burstTime);
        Collections.sort(container);

        int min = 0;

        while (burstSum2 <= 200) {

            if (burstSum2 >= p1.getArrivalTime() && p1.recent == false) {

                p1.setHasArrived(1);
                container.add(p1.burstTime);

            }

            if (burstSum2 >= p2.getArrivalTime() && p2.recent == false) {
                p2.setHasArrived(1);
                container.add(p2.burstTime);

            }

            if (burstSum2 >= p3.getArrivalTime() && p3.recent == false) {
                p3.setHasArrived(1);
                container.add(p3.burstTime);

            }

            if (burstSum2 >= p4.getArrivalTime() && p4.recent == false) {
                p4.setHasArrived(1);
                container.add(p4.burstTime);

            }

            if (burstSum2 >= p5.getArrivalTime() && p5.recent == false) {
                p5.setHasArrived(1);
                container.add(p5.burstTime);

            }

            if (burstSum2 >= p6.getArrivalTime() && p6.recent == false) {
                p6.setHasArrived(1);

                container.add(p6.burstTime);

            }

            if (burstSum2 >= p7.getArrivalTime() && p7.recent == false) {
                p7.setHasArrived(1);
                container.add(p7.burstTime);

            }

            if ((p1.hasArrived + p2.hasArrived + p3.hasArrived + p4.hasArrived + p5.hasArrived + p6.hasArrived
                    + p7.hasArrived) > 0) {

                min = container.remove(0);

            }

            if (p1.burstTime == min && p1.hasArrived == 1) {
                p1.setHasArrived(0);
                p1.arrivalTime = burstSum2 + p1.comeBack;
                burstSum2 += p1.burstTime;
                p1.completion = burstSum2;
                System.out.print("p1 " + "(" + p1.completion + ") ");

                Done.add(p1.name);
                p1.recent = true;
                p2.recent = false;
                p3.recent = false;
                p4.recent = false;
                p5.recent = false;
                p6.recent = false;
                p7.recent = false;
                Collections.sort(container);

                p1.lastArrival = p1.completion;
                p1.CBSUM += p1.comeBack;
                p1.burstSUM += p1.burstTime;

            } else if (p2.burstTime == min && p2.hasArrived == 1) {
                p2.arrivalTime = burstSum2 + p2.comeBack;
                Done.add(p2.name);
                p2.setHasArrived(0);
                burstSum2 += p2.burstTime;
                p2.completion = burstSum2;
                System.out.print("p2 " + "(" + p2.completion + ") ");

                p1.recent = false;
                p2.recent = true;
                p3.recent = false;
                p4.recent = false;
                p5.recent = false;
                p6.recent = false;
                p7.recent = false;

                Collections.sort(container);
                p2.lastArrival = p2.completion;
                p2.CBSUM += p2.comeBack;
                p2.burstSUM += p2.burstTime;

            } else if (p3.burstTime == min && p3.hasArrived == 1) {
                p3.arrivalTime = burstSum2 + p3.comeBack;
                Done.add(p3.name);
                p3.setHasArrived(0);
                burstSum2 += p3.burstTime;
                p3.completion = burstSum2;
                System.out.print("p3" + "(" + p3.completion + ") ");

                p1.recent = false;
                p2.recent = false;
                p3.recent = true;
                p4.recent = false;
                p5.recent = false;
                p6.recent = false;
                p7.recent = false;

                Collections.sort(container);
                p3.lastArrival = p3.completion;
                p3.CBSUM += p3.comeBack;
                p3.burstSUM += p3.burstTime;

            } else if (p4.burstTime == min && p4.hasArrived == 1) {
                p4.arrivalTime = burstSum2 + p4.comeBack;
                Done.add(p4.name);
                p4.setHasArrived(0);
                burstSum2 += p4.burstTime;
                p4.completion = burstSum2;
                System.out.print("p4 " + "(" + p4.completion + ") ");

                p1.recent = false;
                p2.recent = false;
                p3.recent = false;
                p4.recent = true;
                p5.recent = false;
                p6.recent = false;
                p7.recent = false;

                Collections.sort(container);
                p4.lastArrival = p4.completion;
                p4.CBSUM += p4.comeBack;
                p4.burstSUM += p4.burstTime;

            } else if (p5.burstTime == min && p5.hasArrived == 1) {
                p5.arrivalTime = burstSum2 + p5.comeBack;

                Done.add(p5.name);
                p5.setHasArrived(0);
                burstSum2 += p5.burstTime;
                p5.completion = burstSum2;
                System.out.print("p5 " + "(" + p5.completion + ") ");

                p1.recent = false;
                p2.recent = false;
                p3.recent = false;
                p4.recent = false;
                p5.recent = true;
                p6.recent = false;
                p7.recent = false;

                Collections.sort(container);
                p5.lastArrival = p6.completion;
                p5.CBSUM += p5.comeBack;
                p5.burstSUM += p5.burstTime;

            } else if (p6.burstTime == min && p6.hasArrived == 1) {
                p6.arrivalTime = burstSum2 + p6.comeBack;
                Done.add(p6.name);
                p6.setHasArrived(0);
                burstSum2 += p6.burstTime;
                p6.completion = burstSum2;
                System.out.print("p6 " + "(" + p6.completion + ") ");

                p1.recent = false;
                p2.recent = false;
                p3.recent = false;
                p4.recent = false;
                p5.recent = false;
                p6.recent = true;
                p7.recent = false;

                Collections.sort(container);
                p6.lastArrival = p7.completion;
                p6.CBSUM += p6.comeBack;
                p6.burstSUM += p6.burstTime;

            } else if (p7.burstTime == min && p7.hasArrived == 1) {
                p7.arrivalTime = burstSum2 + p7.comeBack;
                Done.add(p7.name);
                p7.setHasArrived(0);
                burstSum2 += p7.burstTime;
                if (burstSum2 > 200) {
                    p7.completion = 200;
                } else
                    p7.completion = burstSum2;
                // p7.completion = burstSum2;
                System.out.print("p7 " + "(" + p7.completion + ") ");

                p1.recent = false;
                p2.recent = false;
                p3.recent = false;
                p4.recent = false;
                p5.recent = false;
                p6.recent = false;
                p7.recent = true;

                Collections.sort(container);

                p7.lastArrival = p5.completion;
                p7.CBSUM += p7.comeBack;
                p7.burstSUM += p7.burstTime;

            }

        }

        // p1.burstSUM-=p1.burstTime;
        // p2.burstSUM-=p2.burstTime;
        // p3.burstSUM-=p3.burstTime;
        // p4.burstSUM-=p4.burstTime;
        p5.burstSUM -= p5.burstTime;
        p6.burstSUM -= p6.burstTime;
        p7.burstSUM -= p7.burstTime;

        // p1.CBSUM-=p1.comeBack;
        // p2.CBSUM-=p2.comeBack;
        // p3.CBSUM-=p3.comeBack;
        // p4.CBSUM-=p4.comeBack;
        p5.CBSUM -= p5.comeBack;
        p6.CBSUM -= p6.comeBack;
        p7.CBSUM -= p7.comeBack;

        /*
         * System.out.println();
         * System.out.println(" p1 CB = "+p1.CBSUM );
         * //System.out.println(" p2 CB = "+p2.CBSUM );
         * //System.out.println(" p3 CB = "+p3.CBSUM );
         * //System.out.println(" p4 CB = "+p4.CBSUM );
         * System.out.println(" p5 CB = "+p5.CBSUM );
         * System.out.println(" p6 CB = "+p6.CBSUM );
         * System.out.println(" p7 CB = "+p7.CBSUM );
         * System.out.println();
         * System.out.println(" p1 BS = "+p1.burstSUM );
         * //System.out.println(" p2 BS = "+p2.burstSUM );
         * //System.out.println(" p3 BS = "+p3.burstSUM );
         * //System.out.println(" p4 BS = "+p4.burstSUM );
         * System.out.println(" p5 BS = "+p5.burstSUM );
         * System.out.println(" p6 BS = "+p6.burstSUM );
         * System.out.println(" p7 BS = "+p7.burstSUM );
         * 
         * System.out.println();
         * System.out.println(" p1 arr = "+p1.lastArrival );
         * //System.out.println(" p2 arr = "+p2.lastArrival );
         * //System.out.println(" p3 arr = "+p3.lastArrival );
         * //System.out.println(" p4 arr = "+p4.lastArrival );
         * System.out.println(" p5 arr = "+p5.lastArrival );
         * System.out.println(" p6 arr = "+p6.lastArrival );
         * System.out.println(" p7 arr = "+p7.lastArrival );
         */
        p1.waitingTime = p1.lastArrival - p1.burstSUM - p1.CBSUM - p1.originalarrival;
        // p2.waitingTime = p2.lastArrival - p2.burstSUM - p2.CBSUM;
        // p3.waitingTime = p3.lastArrival - p3.burstSUM - p3.CBSUM;
        // p4.waitingTime = p4.lastArrival - p4.burstSUM - p4.CBSUM;
        p5.waitingTime = p5.lastArrival - p5.burstSUM - p5.CBSUM - p5.originalarrival;
        p6.waitingTime = p6.lastArrival - p6.burstSUM - p6.CBSUM - p6.originalarrival;
        p7.waitingTime = p7.lastArrival - p7.burstSUM - p7.CBSUM - p7.originalarrival;
        System.out.println();

        p1.burstSUM += p1.burstTime;
        // p2.burstSUM+=p2.burstTime;
        // p3.burstSUM+=p3.burstTime;
        // p4.burstSUM+=p4.burstTime;
        p5.burstSUM += p5.burstTime;
        p6.burstSUM += p6.burstTime;
        // p7.burstSUM+=p7.burstTime;
        p1.TurnAround = p1.waitingTime + p1.CBSUM + p1.burstSUM;
        // p2.TurnAround = p2.waitingTime + p2.CBSUM + p2.burstSUM;
        // p3.TurnAround = p3.waitingTime + p3.CBSUM + p3.burstSUM;
        // p4.TurnAround = p4.waitingTime + p4.CBSUM + p4.burstSUM ;
        p5.TurnAround = p5.waitingTime + p5.CBSUM + p5.burstSUM;
        p6.TurnAround = p6.waitingTime + p6.CBSUM + p6.burstSUM;
        p7.TurnAround = p7.waitingTime + p7.CBSUM + p7.burstSUM + (200 - p5.completion);

        System.out.println();
        System.out.println(" p1 waiting = " + p1.waitingTime + " p1 Turn Around = " + p1.TurnAround);
        // System.out.println(" p2 waiting = "+p2.waitingTime +" p2 Turn Around = "+
        // p2.TurnAround);
        // System.out.println(" p3 waiting = "+p3.waitingTime +" p3 Turn Around = "+
        // p3.TurnAround);
        // System.out.println(" p4 waiting = "+p4.waitingTime +" p4 Turn Around = "+
        // p4.TurnAround);
        System.out.println(" p5 waiting = " + p5.waitingTime + " p5 Turn Around = " + p5.TurnAround);
        System.out.println(" p6 waiting = " + p6.waitingTime + " p6 Turn Around = " + p6.TurnAround);
        System.out.println(" p7 waiting = " + p7.waitingTime + " p7 Turn Around = " + p7.TurnAround);
        // System.out.println(" p1 waiting = "+p1.waitingTime );
        // System.out.println(" p2 waiting = "+p2.waitingTime );
        // System.out.println(" p3 waiting = "+p3.waitingTime );
        // System.out.println(" p4 waiting = "+p4.waitingTime );
        // System.out.println(" p5 waiting = "+p5.waitingTime );
        // System.out.println(" p6 waiting = "+p6.waitingTime );
        // System.out.println(" p7 waiting = "+p7.waitingTime );

        double SJFAverageWaitingTime = (p1.waitingTime + p5.waitingTime + p6.waitingTime + p7.waitingTime) / 4.0;
        double SJFAverageTurnAroundTime = (p1.TurnAround + p5.TurnAround + p6.TurnAround + p7.TurnAround) / 4.0;

        System.out.println();

        System.out.println("Average Waiting Time for SJF = " + SJFAverageWaitingTime);
        System.out.println("Average TurnAround for SJF = " + SJFAverageTurnAroundTime);

        System.out.println();
        // System.out.println("Gantt chart for SJF");
        for (int k = 0; k < Done.size(); k++) {
            // System.out.print(Done.get(k) + " ");
        }

        System.out.println();

        /////////////////////////////////////////////////// SRTF

        ArrayList<Process> arrived = new ArrayList<>();
        ArrayList<Process> AllProc = new ArrayList<>();
        ArrayList<Process> DONE = new ArrayList<>();

        AllProc.add(new Process("p1", 0, 10, 0, 0, 2, 0, 0));
        AllProc.add(new Process("p2", 1, 8, 0, 0, 4, 0, 1));
        AllProc.add(new Process("p3", 3, 14, 0, 0, 6, 0, 2));
        AllProc.add(new Process("p4", 4, 7, 0, 0, 8, 0, 3));
        AllProc.add(new Process("p5", 6, 5, 0, 0, 3, 0, 4));
        AllProc.add(new Process("p6", 7, 4, 0, 0, 6, 0, 5));
        AllProc.add(new Process("p7", 8, 6, 0, 0, 9, 0, 6));
        int burstSum3 = 0;

        Process pArrived;
        Process newProc;
        Process minn;

        int x, y;

        int time3 = 0;

        DONE.add(AllProc.get(0));
        DONE.get(DONE.size() - 1).wentToAnswer = time3;

        while (time3 <= 200) {

            for (i = 1; i < AllProc.size(); i++) {

                if (time3 >= AllProc.get(i).arrivalTime && AllProc.get(i).hasArrived == 0) {

                    AllProc.get(i).hasArrived = 1;
                    arrived.add(AllProc.get(i));

                }
            }
            Collections.sort(arrived, Comparator.comparingInt(Process::getNewBurst));

            if (time3 == 0) {
                DONE.get(DONE.size() - 1).newBurst--;
                DONE.get(DONE.size() - 1).ProcessingTime++;
                DONE.get(DONE.size() - 1).completion++;

            } else {

                if (!arrived.isEmpty()) {

                    if (DONE.get(DONE.size() - 1).newBurst <= arrived.get(0).newBurst) {

                        DONE.get(DONE.size() - 1).newBurst--;
                        DONE.get(DONE.size() - 1).ProcessingTime++;
                        // System.out.println( DONE.get(DONE.size() - 1).name + " "+DONE.get(DONE.size()
                        // - 1).ProcessingTime );
                        if (time3 != 200)
                            DONE.get(DONE.size() - 1).completion = time3 + 1;

                        if (DONE.get(DONE.size() - 1).newBurst == 0) {
                            DONE.get(DONE.size() - 1).newBurst = 100;
                            x = DONE.get(DONE.size() - 1).index;
                            newProc = new Process(DONE.get(DONE.size() - 1).name, DONE.get(DONE.size() - 1).arrivalTime,
                                    DONE.get(DONE.size() - 1).burstTime, 0, 0, DONE.get(DONE.size() - 1).comeBack,
                                    DONE.get(DONE.size() - 1).completion, DONE.get(DONE.size() - 1).index);
                            pArrived = DONE.get(DONE.size() - 1);
                            newProc.arrivalTime = newProc.comeBack + newProc.completion;
                            newProc.newBurst = pArrived.burstTime;
                            newProc.ProcessingTime = pArrived.ProcessingTime;

                            newProc.hasArrived = 0;
                            AllProc.add(newProc);

                        }

                    } else {

                        minn = arrived.get(0);
                        arrived.remove(0);

                        newProc = new Process(DONE.get(DONE.size() - 1).name, DONE.get(DONE.size() - 1).arrivalTime,
                                DONE.get(DONE.size() - 1).burstTime, 0, 0, DONE.get(DONE.size() - 1).comeBack,
                                DONE.get(DONE.size() - 1).completion, DONE.get(DONE.size() - 1).index);
                        pArrived = DONE.get(DONE.size() - 1);

                        newProc.newBurst = pArrived.newBurst;
                        newProc.hasArrived = 0;
                        if (newProc.newBurst == 0) {

                            newProc.arrivalTime = newProc.comeBack + newProc.completion;
                            newProc.newBurst = pArrived.burstTime;
                            newProc.ProcessingTime = pArrived.ProcessingTime;

                            AllProc.add(newProc);
                        } else {
                            AllProc.add(newProc);
                            newProc.ProcessingTime = pArrived.ProcessingTime;
                        }
                        DONE.add(minn);
                        DONE.get(DONE.size() - 1).wentToAnswer = time3;

                        DONE.get(DONE.size() - 1).newBurst--;
                        DONE.get(DONE.size() - 1).ProcessingTime++;
                        // System.out.println( DONE.get(DONE.size() - 1).name + " "+DONE.get(DONE.size()
                        // - 1).ProcessingTime );
                        DONE.get(DONE.size() - 1).completion = time3 + 1;

                    }

                }

            }
            time3++;

        }

        if (time3 > 200) {
            DONE.get(DONE.size() - 1).ProcessingTime -= (time3 - 200);
        }

        System.out.println();
        System.out.println("Gantt chart for SRTF");
        System.out.println();
        for (int k = 0; k < DONE.size(); k++) {

            System.out.print(DONE.get(k).name + " (" + DONE.get(k).completion + ") ");
            // System.out.print(DONE.get(k).name + " ");

        }

        System.out.println();
        int P1BS = 0, P2BS = 0, P3BS = 0, P4BS = 0, P5BS = 0, P6BS = 0, P7BS = 0, P1CB = 0, P2CB = 0, P3CB = 0,
                P4CB = 0, P5CB = 0, P6CB = 0, P7CB = 0;
        int p1bs = 0, p2bs = 0, p3bs = 0, p4bs = 0, p5bs = 0, p6bs = 0, p7bs = 0;
        int p1LA = 0, p2LA = 0, p3LA = 0, p4LA = 0, p5LA = 0, p6LA = 0, p7LA = 0;
        Process Index;
        int exec = 0;
        ge1=0;ge2=0;ge3=0;ge4=0;ge5=0;ge6=0;ge7=0;
        for (int k = 0; k < DONE.size(); k++) {
            Index = DONE.get(k);
            if ("p1".equals(Index.name)) {
                P1CB += Index.comeBack;
                p1LA = Index.wentToAnswer;
                exec = Index.completion - p1LA;
                P1BS = Index.ProcessingTime - exec;
                p1bs = Index.ProcessingTime;
                if(ge1==0)
                    ge1=1;
            } else if ("p2".equals(Index.name)) {
                P2CB += Index.comeBack;
                p2LA = Index.wentToAnswer;
                exec = Index.completion - p2LA;

                P2BS = Index.ProcessingTime - exec;
                p2bs = Index.ProcessingTime;
                if(ge2==0)
                    ge2=1;
            } else if ("p3".equals(Index.name)) {
                P3CB += Index.comeBack;
                p3LA = Index.wentToAnswer;
                exec = Index.completion - p3LA;

                P3BS = Index.ProcessingTime - exec;
                p3bs = Index.ProcessingTime;
                if(ge3==0)
                    ge3=1;
            } else if ("p4".equals(Index.name)) {
                P4CB += Index.comeBack;
                p4LA = Index.wentToAnswer;
                exec = Index.completion - p4LA;

                P4BS = Index.ProcessingTime - exec;
                p4bs = Index.ProcessingTime;
                if(ge4==0)
                    ge4=1;
            } else if ("p5".equals(Index.name)) {
                P5CB += Index.comeBack;
                p5LA = Index.wentToAnswer;
                exec = Index.completion - p5LA;

                P5BS = Index.ProcessingTime - exec;
                p5bs = Index.ProcessingTime;
                if(ge5==0)
                    ge5=1;
            } else if ("p6".equals(Index.name)) {
                P6CB += Index.comeBack;
                p6LA = Index.wentToAnswer;
                exec = Index.completion - p6LA;

                P6BS = Index.ProcessingTime - exec;
                p6bs = Index.ProcessingTime;
                if(ge6==0)
                    ge6=1;
            } else if ("p7".equals(Index.name)) {
                P7CB += Index.comeBack;
                p7LA = Index.wentToAnswer;
                exec = Index.completion - p7LA;

                P7BS = Index.ProcessingTime - exec;
                p7bs = Index.ProcessingTime;
                if(ge7==0)
                    ge7=1;
            }

        }
        P7CB = P7CB / 2;

        /*
         * P1CB-=AllProc.get(0).comeBack;
         * P2CB-=AllProc.get(1).comeBack;
         * P3CB-=AllProc.get(2).comeBack;
         * P4CB-=AllProc.get(3).comeBack;
         * P5CB-=AllProc.get(4).comeBack;
         * P6CB-=AllProc.get(5).comeBack;
         * P7CB-=AllProc.get(6).comeBack;
         * 
         * P1BS-=AllProc.get(0).burstTime;
         * P2BS-=AllProc.get(1).burstTime;
         * P3BS-=AllProc.get(2).burstTime;
         * P4BS-=AllProc.get(3).burstTime;
         * P5BS-=AllProc.get(4).burstTime;
         * P6BS-=AllProc.get(5).burstTime;
         * P7BS-=AllProc.get(6).burstTime;
         */
        P1CB -= AllProc.get(0).comeBack;
        P2CB -= AllProc.get(1).comeBack;
        P3CB -= AllProc.get(2).comeBack;
        P4CB -= AllProc.get(3).comeBack;
        P5CB -= AllProc.get(4).comeBack;
        P6CB -= AllProc.get(5).comeBack;
        P7CB -= AllProc.get(6).comeBack;

        int P1Waiting = p1LA - P1BS - P1CB - AllProc.get(0).originalarrival;
        int P2Waiting = p2LA - P2BS - P2CB - AllProc.get(1).originalarrival;
        int P3Waiting = p3LA - P3BS - P3CB - AllProc.get(2).originalarrival;
        int P4Waiting = p4LA - P4BS - P4CB - AllProc.get(3).originalarrival;
        int P5Waiting = p5LA - P5BS - P5CB - AllProc.get(4).originalarrival;
        int P6Waiting = p6LA - P6BS - P6CB - AllProc.get(5).originalarrival;
        int P7Waiting = p7LA - P7BS - P7CB - AllProc.get(6).originalarrival;

        int P1TA;
        int P2TA;
        int P3TA;
        int P4TA;
        int P5TA;
        int P6TA;
        int P7TA;

        if (P1Waiting < 0)
            P1Waiting = 0;
        if (P2Waiting < 0)
            P2Waiting = 0;
        if (P3Waiting < 0)
            P3Waiting = 0;
        if (P4Waiting < 0)
            P4Waiting = 0;
        if (P5Waiting < 0)
            P5Waiting = 0;
        if (P6Waiting < 0)
            P6Waiting = 0;
        if (P7Waiting < 0)
            P7Waiting = 0;

        P1TA = P1Waiting + p1bs + P1CB;
        P2TA = P2Waiting + p2bs + P2CB;
        P3TA = P3Waiting + p3bs + P3CB;
        P4TA = P4Waiting + p4bs + P4CB;
        P5TA = P5Waiting + p5bs + P5CB;
        P6TA = P6Waiting + p6bs + P6CB;
        P7TA = P7Waiting + p7bs + P7CB;
        System.out.println();
        System.out.println();

        System.out.println("p1 waiting time = " + P1Waiting + "   p1 TurnAround Time = " + P1TA);
        System.out.println("p2 waiting time = " + P2Waiting + "   p2 TurnAround Time = " + P2TA);
        System.out.println("p5 waiting time = " + P5Waiting + "   p5 TurnAround Time = " + P5TA);
        System.out.println("p6 waiting time = " + P6Waiting + "   p6 TurnAround Time = " + P6TA);
        System.out.println("p7 waiting time = " + P7Waiting + "   p7 TurnAround Time = " + P7TA);
        System.out.println();
        /*
         * System.out.println("p1 BS = "+P1BS);
         * System.out.println("p2 BS = "+P2BS);
         * System.out.println("p5 BS = "+P5BS);
         * System.out.println("p6 BS = "+P6BS);
         * System.out.println("p7 BS = "+P7BS);
         * System.out.println();
         * System.out.println("p1 CB = "+P1CB);
         * System.out.println("p2 CB = "+P2CB);
         * System.out.println("p5 CB = "+P5CB);
         * System.out.println("p6 CB = "+P6CB);
         * System.out.println("p7 CB = "+P7CB);
         * System.out.println();
         * System.out.println("p1 LA = "+p1LA);
         * System.out.println("p2 LA = "+p2LA);
         * System.out.println("p5 LA = "+p5LA);
         * System.out.println("p6 LA = "+p6LA);
         * System.out.println("p7 LA = "+p7LA);
         */
            int NOP = ge1+ge2+ge3+ge4+ge5+ge6+ge7;
        double SRTFAverageWaitingTime = (P1Waiting + P2Waiting + P5Waiting + P6Waiting + P7Waiting) / 5.0;
        double SRTFAverageTurnAroundTime = (P1TA + P2TA + P5TA + P6TA + P7TA) / 5.0;

        System.out.println("Average Waiting Time for SRTF = " + SRTFAverageWaitingTime);
        System.out.println("Average TurnAround Time for SRTF = " + SRTFAverageTurnAroundTime);

        ///////////////////////////////////////////// Round Robin with q=5

        int five = 0;
        arrived.clear();
        AllProc.clear();
        DONE.clear();

        AllProc.add(new Process("p1", 0, 10, 0, 0, 2, 0, 0));
        AllProc.add(new Process("p2", 1, 8, 0, 0, 4, 0, 1));
        AllProc.add(new Process("p3", 3, 14, 0, 0, 6, 0, 2));
        AllProc.add(new Process("p4", 4, 7, 0, 0, 8, 0, 3));
        AllProc.add(new Process("p5", 6, 5, 0, 0, 3, 0, 4));
        AllProc.add(new Process("p6", 7, 4, 0, 0, 6, 0, 5));
        AllProc.add(new Process("p7", 8, 6, 0, 0, 9, 0, 6));

        int time4 = 0, t = 5;
        Process head;

        System.out.println();
        System.out.println("Gantt chart for Round Robin");
        System.out.println();

        while (time4 < 200) {

            for (i = 0; i < AllProc.size(); i++) {

                if (time4 >= AllProc.get(i).arrivalTime && AllProc.get(i).hasArrived == 0) {
                    AllProc.get(i).hasArrived = 1;
                    arrived.add(AllProc.get(i));

                }

            }

            if (arrived.size() > 0) {
                head = arrived.get(0);
                // head.CBSUM+= head.comeBack;

                if (five < 5 && head.newBurst != 0) {

                    if (head.recent == false) {

                        head.recent = true;
                        if (head.burstTime <= 5 || (head.newBurst < 5 && head.newBurst > 0)) {
                            head.wentToAnswer = time4;

                            head.completion = time4 + head.newBurst;

                            DONE.add(head);

                        } else {
                            head.wentToAnswer = time4;

                            head.completion = t + five;
                            DONE.add(head);

                        }
                        System.out.print(DONE.get(DONE.size() - 1).name + " " + "("
                                + DONE.get(DONE.size() - 1).completion + ") ");
                    }
                    head.newBurst--;
                    head.ProcessingTime++;
                    five++;

                }
                if (five == 5 && head.newBurst != 0) {

                    five = 0;
                    head.recent = false;
                    arrived.add(head);
                    arrived.remove(0);

                }

                if (five <= 5 && head.newBurst == 0) {
                    arrived.remove(0);
                    head.newBurst = head.burstTime;
                    head.arrivalTime = head.comeBack + time4;
                    head.CBSUM += head.comeBack;

                    five = 0;
                    head.recent = false;
                    head.hasArrived = 0;
                    AllProc.add(head);

                }

            }

            time4++;
            t++;
        }
        int lastex = 0;
        P1BS = 0;
        P2BS = 0;
        P3BS = 0;
        P4BS = 0;
        P5BS = 0;
        P6BS = 0;
        P7BS = 0;
        P1CB = 0;
        P2CB = 0;
        P3CB = 0;
        P4CB = 0;
        P5CB = 0;
        P6CB = 0;
        P7CB = 0;
        int P1bs = 0, P2bs = 0, P3bs = 0, P4bs = 0, P5bs = 0, P6bs = 0, P7bs = 0;
        p1LA = 0;
        p2LA = 0;
        p3LA = 0;
        p4LA = 0;
        p5LA = 0;
        p6LA = 0;
        p7LA = 0;
        p1LA = 0;
        p2LA = 0;
        p3LA = 0;
        p4LA = 0;
        p5LA = 0;
        p6LA = 0;
        p7LA = 0;
        for (int k = 0; k < DONE.size(); k++) {

            Index = DONE.get(k);
            if ("p1".equals(Index.name)) {
                P1CB = Index.CBSUM;
                p1LA = Index.wentToAnswer;
                lastex = Index.completion - p1LA;
                if (lastex == 5) {
                    P1CB -= Index.comeBack;
                }
                P1BS = Index.ProcessingTime - lastex;
                P1bs = Index.ProcessingTime;

            } else if ("p2".equals(Index.name)) {
                P2CB = Index.CBSUM;
                p2LA = Index.wentToAnswer;
                lastex = Index.completion - p2LA;
                P2BS = Index.ProcessingTime - lastex;
                if (lastex == 3) {
                    P2CB -= Index.comeBack;
                }
                P2bs = Index.ProcessingTime;

            } else if ("p3".equals(Index.name)) {
                P3CB = Index.CBSUM;
                p3LA = Index.wentToAnswer;
                lastex = Index.completion - p3LA;
                P3BS = Index.ProcessingTime - lastex;
                if (lastex == 4) {
                    P3CB -= Index.comeBack;
                }
                P3bs = Index.ProcessingTime;

            } else if ("p4".equals(Index.name)) {
                P4CB = Index.CBSUM;
                p4LA = Index.wentToAnswer;
                lastex = Index.completion - p4LA;
                P4BS = Index.ProcessingTime - lastex;
                if (lastex == 3) {
                    P4CB -= Index.comeBack;
                }
                P4bs = Index.ProcessingTime;

            } else if ("p5".equals(Index.name)) {
                P5CB = Index.CBSUM;
                p5LA = Index.wentToAnswer;
                lastex = Index.completion - p5LA;
                P5BS = Index.ProcessingTime - lastex;
                if (lastex == 5) {
                    P5CB -= Index.comeBack;
                }
                P5bs = Index.ProcessingTime;

            } else if ("p6".equals(Index.name)) {
                P6CB = Index.CBSUM;
                p6LA = Index.wentToAnswer;
                lastex = Index.completion - p6LA;
                P6BS = Index.ProcessingTime - lastex;
                if (lastex == 4) {
                    P6CB -= Index.comeBack;
                    // P6BS-=5;
                }
                P6bs = Index.ProcessingTime;

            } else if ("p7".equals(Index.name)) {
                P7CB = Index.CBSUM;
                p7LA = Index.wentToAnswer;
                lastex = Index.completion - p7LA;
                P7BS = Index.ProcessingTime - lastex;
                if (lastex == 1) {
                    P7CB -= Index.comeBack;
                }
                P7bs = Index.ProcessingTime;

            }

        }
        /*
         * P1CB-=AllProc.get(0).comeBack;
         * P2CB-= AllProc.get(1).comeBack;
         * P3CB-= AllProc.get(2).comeBack;
         * P4CB-= AllProc.get(3).comeBack;
         * P5CB-= AllProc.get(4).comeBack;
         * P6CB-= AllProc.get(5).comeBack;
         * P7CB-= AllProc.get(6).comeBack;
         */

        /*
         * System.out.println();
         * System.out.println("p1 LA = "+p1LA);
         * System.out.println("p2 LA = "+p2LA);
         * System.out.println("p3 LA = "+p3LA);
         * System.out.println("p4 LA = "+p4LA);
         * System.out.println("p5 LA = "+p5LA);
         * System.out.println("p6 LA = "+p6LA);
         * System.out.println("p7 LA = "+p7LA);
         * System.out.println();
         * System.out.println("p1 BS = "+P1BS);
         * System.out.println("p2 BS = "+P2BS);
         * System.out.println("p3 BS = "+P3BS);
         * System.out.println("p4 BS = "+P4BS);
         * System.out.println("p5 BS = "+P5BS);
         * System.out.println("p6 BS = "+P5BS);
         * System.out.println("p7 BS = "+P7BS);
         * System.out.println();
         * System.out.println("p1 CB = "+P1CB);
         * System.out.println("p2 CB = "+P2CB);
         * System.out.println("p3 CB = "+P3CB);
         * System.out.println("p4 CB = "+P4CB);
         * 
         * System.out.println("p5 CB = "+P5CB);
         * System.out.println("p6 CB = "+P6CB);
         * System.out.println("p7 CB = "+P7CB);
         */
        System.out.println();

        P1Waiting = p1LA - P1BS - P1CB - AllProc.get(0).originalarrival;
        P2Waiting = p2LA - P2BS - P2CB - AllProc.get(1).originalarrival;
        P3Waiting = p3LA - P3BS - P3CB - AllProc.get(2).originalarrival;
        P4Waiting = p4LA - P4BS - P4CB - AllProc.get(3).originalarrival;
        P5Waiting = p5LA - P5BS - P5CB - AllProc.get(4).originalarrival;
        P6Waiting = p6LA - P6BS - P6CB - AllProc.get(5).originalarrival;
        P7Waiting = p7LA - P7BS - P7CB - AllProc.get(6).originalarrival;

        P1TA = P1Waiting + P1bs + P1CB;
        P2TA = P2Waiting + P2bs + P2CB;
        P3TA = P3Waiting + P3bs + P3CB;
        P4TA = P4Waiting + P4bs + P4CB;
        P5TA = P5Waiting + P5bs + P5CB;
        P6TA = P6Waiting + P6bs + P6CB;
        P7TA = P7Waiting + P7bs + P7CB;
        System.out.println();
        System.out.println();

        System.out.println("p1 waiting time = " + P1Waiting + "   p1 TurnAround Time = " + P1TA);
        System.out.println("p2 waiting time = " + P2Waiting + "   p2 TurnAround Time = " + P2TA);
        System.out.println("p3 waiting time = " + P3Waiting + "   p3 TurnAround Time = " + P3TA);
        System.out.println("p4 waiting time = " + P4Waiting + "   p4 TurnAround Time = " + P4TA);
        System.out.println("p5 waiting time = " + P5Waiting + "   p5 TurnAround Time = " + P5TA);
        System.out.println("p6 waiting time = " + P6Waiting + "   p6 TurnAround Time = " + P6TA);
        System.out.println("p7 waiting time = " + P7Waiting + "   p7 TurnAround Time = " + P7TA);
        System.out.println();

        double RRAverageWaitingTime = (P1Waiting + P2Waiting + P3Waiting + P4Waiting + P5Waiting + P6Waiting
                + P7Waiting) / 7.0;
        double RRAverageTurnAroundTime = (P1TA + P2TA + P3TA + P4TA + P5TA + P6TA + P7TA) / 7.0;

        System.out.println("Average Waiting Time for Round Robin = " + RRAverageWaitingTime);
        System.out.println("Average Turn Around Time for Round Robin = " + RRAverageTurnAroundTime);

        // System.out.println("Gantt chart for Round Robin");
        for (int k = 0; k < DONE.size(); k++) {
            // System.out.print(DONE.get(k).name + " ");
        }

        System.out.println();
        /////////////////////////////////////////////// Priority (PreEmptive)

        arrived.clear();
        AllProc.clear();
        DONE.clear();

        AllProc.add(new Process("p1", 0, 10, 0, 0, 2, 0, 0, 3));
        AllProc.add(new Process("p2", 1, 8, 0, 0, 4, 0, 1, 2));
        AllProc.add(new Process("p3", 3, 14, 0, 0, 6, 0, 2, 3));
        AllProc.add(new Process("p4", 4, 7, 0, 0, 8, 0, 3, 1));
        AllProc.add(new Process("p5", 6, 5, 0, 0, 3, 0, 4, 0));
        AllProc.add(new Process("p6", 7, 4, 0, 0, 6, 0, 5, 1));
        AllProc.add(new Process("p7", 8, 6, 0, 0, 9, 0, 6, 2));

        int time5 = 0;
        int decrement1;
        Process temp1;

        DONE.add(AllProc.get(0));

        for (Process process : AllProc) {
            process.ready = process.arrivalTime;

        }

        while (time5 <= 200) {

            for (i = 1; i < AllProc.size(); i++) {

                if (time5 >= AllProc.get(i).arrivalTime && AllProc.get(i).hasArrived == 0) {
                    AllProc.get(i).hasArrived = 1;
                    arrived.add(AllProc.get(i));

                }

            }

            if (arrived.size() > 0) {
                for (i = 0; i < arrived.size(); i++) {
                    decrement1 = (time5 - arrived.get(i).arrivalTime) / 5;
                    if (arrived.get(i).newPriority > 0) {
                        arrived.get(i).newPriority -= decrement1;

                    }

                    if (arrived.get(i).newPriority <= 0)
                        arrived.get(i).newPriority = 0;

                }

            }

            Collections.sort(arrived, Comparator.comparingInt(Process::getReady));
            Collections.sort(arrived, Comparator.comparingInt(Process::getNewPriority));

            for (i = 0; i < arrived.size(); i++) {
                // System.out.print(arrived.get(i).name+" "+arrived.get(i).newPriority+"
                // "+time5+" ");
            }
            // System.out.println();

            if (time5 == 0) {

                DONE.get(DONE.size() - 1).newBurst--;
                DONE.get(DONE.size() - 1).completion++;
                DONE.get(DONE.size() - 1).ready++;
                DONE.get(DONE.size() - 1).ProcessingTime++;

            } else {

                if (arrived.size() > 0) {

                    if (DONE.get(DONE.size() - 1).newPriority > arrived.get(0).newPriority) {

                        newProc = new Process(DONE.get(DONE.size() - 1).name, DONE.get(DONE.size() - 1).arrivalTime,
                                DONE.get(DONE.size() - 1).burstTime, 0, 0, DONE.get(DONE.size() - 1).comeBack,
                                DONE.get(DONE.size() - 1).completion, DONE.get(DONE.size() - 1).index,
                                DONE.get(DONE.size() - 1).priority);
                        newProc.newBurst = DONE.get(DONE.size() - 1).newBurst;
                        newProc.newPriority = DONE.get(DONE.size() - 1).priority;
                        newProc.arrivalTime = time5;
                        newProc.completion = DONE.get(DONE.size() - 1).completion;
                        newProc.hasArrived = 0;
                        newProc.ready = DONE.get(DONE.size() - 1).completion;
                        newProc.ProcessingTime = DONE.get(DONE.size() - 1).ProcessingTime;
                        newProc.CBSUM += newProc.comeBack;
                        AllProc.add(newProc);
                        arrived.get(0).wentToAnswer = time5;
                        DONE.add(arrived.get(0));
                        arrived.remove(0);

                        DONE.get(DONE.size() - 1).newBurst--;
                        DONE.get(DONE.size() - 1).completion = time5 + 1;
                        DONE.get(DONE.size() - 1).ProcessingTime++;

                    } else {

                        if (DONE.get(DONE.size() - 1).newBurst == 0) {

                            DONE.get(DONE.size() - 1).newBurst = DONE.get(DONE.size() - 1).burstTime;
                            newProc = new Process(DONE.get(DONE.size() - 1).name, DONE.get(DONE.size() - 1).arrivalTime,
                                    DONE.get(DONE.size() - 1).burstTime, 0, 0, DONE.get(DONE.size() - 1).comeBack,
                                    DONE.get(DONE.size() - 1).completion, DONE.get(DONE.size() - 1).index,
                                    DONE.get(DONE.size() - 1).priority);
                            newProc.newBurst = DONE.get(DONE.size() - 1).newBurst;
                            newProc.newPriority = DONE.get(DONE.size() - 1).priority;
                            newProc.arrivalTime = DONE.get(DONE.size() - 1).comeBack + time5 + 1;
                            newProc.completion = DONE.get(DONE.size() - 1).completion;
                            newProc.ProcessingTime = DONE.get(DONE.size() - 1).ProcessingTime;
                            newProc.CBSUM += newProc.comeBack;

                            newProc.hasArrived = 0;
                            newProc.ready = newProc.arrivalTime;
                            AllProc.add(newProc);
                            arrived.get(0).wentToAnswer = time5;

                            DONE.add(arrived.get(0));
                            arrived.remove(0);

                        }

                        DONE.get(DONE.size() - 1).newBurst--;
                        DONE.get(DONE.size() - 1).completion = time5 + 1;
                        DONE.get(DONE.size() - 1).ProcessingTime++;

                    }

                }

            }

            for (Process process : arrived) {
                process.newPriority = process.priority;

            }

            time5++;
        }

        if (DONE.get(DONE.size() - 1).completion > 200) {
            DONE.get(DONE.size() - 1).completion -= (DONE.get(DONE.size() - 1).completion - 200);
        }
        System.out.println();
        System.out.println("Gantt chart for Preemptive Priority");
        System.out.println();
        for (int k = 0; k < DONE.size(); k++) {
            System.out.print(DONE.get(k).name + " (" + DONE.get(k).completion + ") ");
        }

        System.out.println();

        P1BS = 0;
        P2BS = 0;
        P3BS = 0;
        P4BS = 0;
        P5BS = 0;
        P6BS = 0;
        P7BS = 0;
        P1CB = 0;
        P2CB = 0;
        P3CB = 0;
        P4CB = 0;
        P5CB = 0;
        P6CB = 0;
        P7CB = 0;
        P1bs = 0;
        P2bs = 0;
        P3bs = 0;
        P4bs = 0;
        P5bs = 0;
        P6bs = 0;
        P7bs = 0;
        p1bs = 0;
        p2bs = 0;
        p3bs = 0;
        p4bs = 0;
        p5bs = 0;
        p6bs = 0;
        p7bs = 0;
        p1LA = 0;
        p2LA = 0;
        p3LA = 0;
        p4LA = 0;
        p5LA = 0;
        p6LA = 0;
        p7LA = 0;
        exec = 0;
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0;
        for (int k = 0; k < DONE.size(); k++) {

            Index = DONE.get(k);
            if ("p1".equals(Index.name)) {
                P1CB += Index.CBSUM;
                p1LA = Index.wentToAnswer;
                exec = Index.completion - p1LA;
                P1BS = Index.ProcessingTime - exec;
                p1bs = Index.ProcessingTime;
                if (exec != Index.burstTime && c1 == 0) {
                    P1CB -= Index.comeBack;
                    c1 = 1;
                }
            } else if ("p2".equals(Index.name)) {
                P2CB += Index.CBSUM;
                p2LA = Index.wentToAnswer;
                exec = Index.completion - p2LA;

                P2BS = Index.ProcessingTime - exec;
                p2bs = Index.ProcessingTime;
                if (exec != Index.burstTime && c2 == 0) {
                    P2CB -= Index.comeBack;
                    c2 = 1;
                }
            } else if ("p3".equals(Index.name)) {
                P3CB += Index.CBSUM;
                p3LA = Index.wentToAnswer;
                exec = Index.completion - p3LA;

                P3BS = Index.ProcessingTime - exec;
                p3bs = Index.ProcessingTime;
                if (exec != Index.burstTime && c3 == 0) {
                    P3CB -= Index.comeBack;
                    c3 = 1;
                }
            } else if ("p4".equals(Index.name)) {
                P4CB += Index.CBSUM;
                p4LA = Index.wentToAnswer;
                exec = Index.completion - p4LA;

                P4BS = Index.ProcessingTime - exec;
                p4bs = Index.ProcessingTime;
                if (exec != Index.burstTime && c4 == 0) {
                    P4CB -= Index.comeBack;
                    c4 = 1;
                }
            } else if ("p5".equals(Index.name)) {
                P5CB += Index.CBSUM;
                p5LA = Index.wentToAnswer;
                exec = Index.completion - p5LA;

                P5BS = Index.ProcessingTime - exec;
                p5bs = Index.ProcessingTime;
                if (exec != Index.burstTime && c5 == 0) {
                    P5CB -= Index.comeBack;
                    c5 = 1;
                }
            } else if ("p6".equals(Index.name)) {
                P6CB += Index.CBSUM;
                p6LA = Index.wentToAnswer;
                exec = Index.completion - p6LA;

                P6BS = Index.ProcessingTime - exec;
                p6bs = Index.ProcessingTime;
                if (exec != Index.burstTime && c6 == 0) {
                    P6CB -= Index.comeBack;
                    c6 = 1;
                }
            } else if ("p7".equals(Index.name)) {
                P7CB += Index.CBSUM;
                p7LA = Index.wentToAnswer;
                exec = Index.completion - p7LA;

                P7BS = Index.ProcessingTime - exec;
                p7bs = Index.ProcessingTime;
                if (exec != Index.burstTime && c7 == 0) {
                    P7CB -= Index.comeBack;
                    c7 = 1;
                }
            }

        }

        /*
         * System.out.println();
         * System.out.println("p1 LA = "+p1LA);
         * System.out.println("p2 LA = "+p2LA);
         * System.out.println("p3 LA = "+p3LA);
         * System.out.println("p4 LA = "+p4LA);
         * System.out.println("p5 LA = "+p5LA);
         * System.out.println("p6 LA = "+p6LA);
         * System.out.println("p7 LA = "+p7LA);
         * System.out.println();
         * System.out.println("p1 BS = "+P1BS);
         * System.out.println("p2 BS = "+P2BS);
         * System.out.println("p3 BS = "+P3BS);
         * System.out.println("p4 BS = "+P4BS);
         * System.out.println("p5 BS = "+P5BS);
         * System.out.println("p6 BS = "+P5BS);
         * System.out.println("p7 BS = "+P7BS);
         * System.out.println();
         * System.out.println("p1 BS = "+P1bs);
         * System.out.println("p2 BS = "+P2bs);
         * System.out.println("p3 BS = "+P3bs);
         * System.out.println("p4 BS = "+P4bs);
         * System.out.println("p5 BS = "+P5bs);
         * System.out.println("p6 BS = "+P6bs);
         * System.out.println("p7 BS = "+P7bs);
         * System.out.println();
         * System.out.println("p1 CB = "+P1CB);
         * System.out.println("p2 CB = "+P2CB);
         * System.out.println("p3 CB = "+P3CB);
         * System.out.println("p4 CB = "+P4CB);
         * 
         * System.out.println("p5 CB = "+P5CB);
         * System.out.println("p6 CB = "+P6CB);
         * System.out.println("p7 CB = "+P7CB);
         */

        System.out.println();

        P1Waiting = p1LA - P1BS - P1CB - AllProc.get(0).originalarrival;
        P2Waiting = p2LA - P2BS - P2CB - AllProc.get(1).originalarrival;
        P3Waiting = p3LA - P3BS - P3CB - AllProc.get(2).originalarrival;
        P4Waiting = p4LA - P4BS - P4CB - AllProc.get(3).originalarrival;
        P5Waiting = p5LA - P5BS - P5CB - AllProc.get(4).originalarrival;
        P6Waiting = p6LA - P6BS - P6CB - AllProc.get(5).originalarrival;
        P7Waiting = p7LA - P7BS - P7CB - AllProc.get(6).originalarrival;

        P1TA = P1Waiting + p1bs + P1CB;
        P2TA = P2Waiting + p2bs + P2CB;
        P3TA = P3Waiting + p3bs + P3CB;
        P4TA = P4Waiting + p4bs + P4CB;
        P5TA = P5Waiting + p5bs + P5CB;
        P6TA = P6Waiting + p6bs + P6CB;
        P7TA = P7Waiting + p7bs + P7CB;
        System.out.println();
        System.out.println();

        System.out.println("p1 waiting time = " + P1Waiting + "   p1 TurnAround Time = " + P1TA);
        System.out.println("p2 waiting time = " + P2Waiting + "   p2 TurnAround Time = " + P2TA);
        System.out.println("p3 waiting time = " + P3Waiting + "   p3 TurnAround Time = " + P3TA);
        System.out.println("p4 waiting time = " + P4Waiting + "   p4 TurnAround Time = " + P4TA);
        System.out.println("p5 waiting time = " + P5Waiting + "   p5 TurnAround Time = " + P5TA);
        System.out.println("p6 waiting time = " + P6Waiting + "   p6 TurnAround Time = " + P6TA);
        System.out.println("p7 waiting time = " + P7Waiting + "   p7 TurnAround Time = " + P7TA);
        System.out.println();

        double PPAverageWaitingTime = (P1Waiting + P2Waiting + P3Waiting + P4Waiting + P5Waiting + P6Waiting
                + P7Waiting) / 7.0;
        double PPAverageTurnAroundTime = (P1TA + P2TA + P3TA + P4TA + P5TA + P6TA + P7TA) / 7.0;

        System.out.println("Average Waiting Time for Preemptive Priority = " + PPAverageWaitingTime);
        System.out.println("Average Turn Around Time for Preemptive Priority = " + PPAverageTurnAroundTime);

        /////////////////////////////////////////////// Priority (nonPreEmptive)

        arrived.clear();
        AllProc.clear();
        DONE.clear();

        AllProc.add(new Process("p1", 0, 10, 0, 0, 2, 0, 0, 3));
        AllProc.add(new Process("p2", 1, 8, 0, 0, 4, 0, 1, 2));
        AllProc.add(new Process("p3", 3, 14, 0, 0, 6, 0, 2, 3));
        AllProc.add(new Process("p4", 4, 7, 0, 0, 8, 0, 3, 1));
        AllProc.add(new Process("p5", 6, 5, 0, 0, 3, 0, 4, 0));
        AllProc.add(new Process("p6", 7, 4, 0, 0, 6, 0, 5, 1));
        AllProc.add(new Process("p7", 8, 6, 0, 0, 9, 0, 6, 2));

        int time6 = 0;
        int burstsum6 = 0;
        Process minP;
        Process temp;
        int decrement;
        System.out.println();
        System.out.println("Gantt chart for NonPreemptive Priority");
        System.out.println();
        while (burstsum6 <= 200) {

            for (i = 0; i < AllProc.size(); i++) {

                if (burstsum6 >= AllProc.get(i).arrivalTime && AllProc.get(i).hasArrived == 0) {
                    AllProc.get(i).hasArrived = 1;
                    arrived.add(AllProc.get(i));

                }

            }

            if (arrived.size() > 0) {
                for (i = 0; i < arrived.size(); i++) {
                    decrement = (burstsum6 - arrived.get(i).arrivalTime) / 5;
                    if (arrived.get(i).newPriority > 0) {
                        arrived.get(i).newPriority -= decrement;

                    }

                    if (arrived.get(i).newPriority <= 0)
                        arrived.get(i).newPriority = 0;

                }

            }

            Collections.sort(arrived, Comparator.comparingInt(Process::getNewPriority));

            for (i = 0; i < arrived.size(); i++) {
                if (i + 1 < arrived.size()) {
                    if (arrived.get(i).newPriority == arrived.get(i + 1).newPriority) {
                        if (arrived.get(i).arrivalTime > arrived.get(i + 1).arrivalTime) {
                            temp = arrived.get(i + 1);
                            arrived.remove(i + 1);

                            arrived.add(i, temp);
                        }
                    }
                }
            }

            if (arrived.size() > 0) {
                minP = arrived.get(0);

                if (arrived.size() > 0)
                    arrived.remove(0);
                burstsum6 += minP.burstTime;
                minP.arrivalTime = burstsum6 + minP.comeBack;
                minP.wentToAnswer = burstsum6 - minP.burstTime;
                minP.newPriority = minP.priority;
                minP.hasArrived = 0;
                if (burstsum6 > 200) {
                    minP.completion = 200;
                    minP.TurnAround = 200 - burstsum6;
                } else
                    minP.completion = burstsum6;
                System.out.print(minP.name + " " + "(" + minP.completion + ") ");

                DONE.add(minP);

            }

            time6++;

        }
        P1TA = AllProc.get(0).TurnAround;
        P2TA = AllProc.get(1).TurnAround;
        P3TA = AllProc.get(2).TurnAround;
        P4TA = AllProc.get(3).TurnAround;
        P5TA = AllProc.get(4).TurnAround;
        P6TA = AllProc.get(5).TurnAround;
        P7TA = AllProc.get(6).TurnAround;
        P1BS = 0;
        P2BS = 0;
        P3BS = 0;
        P4BS = 0;
        P5BS = 0;
        P6BS = 0;
        P7BS = 0;
        P1CB = 0;
        P2CB = 0;
        P3CB = 0;
        P4CB = 0;
        P5CB = 0;
        P6CB = 0;
        P7CB = 0;
        p1LA = 0;
        p2LA = 0;
        p3LA = 0;
        p4LA = 0;
        p5LA = 0;
        p6LA = 0;
        p7LA = 0;

        System.out.println();
        // System.out.println("Gantt chart for NonPreemptive Priority");
        for (int k = 0; k < DONE.size(); k++) {

            Index = DONE.get(k);
            if ("p1".equals(Index.name)) {
                P1CB += Index.comeBack;
                p1LA = Index.wentToAnswer;
                P1BS += Index.burstTime;

            } else if ("p2".equals(Index.name)) {
                P2CB += Index.comeBack;
                p2LA = Index.wentToAnswer;
                P2BS += Index.burstTime;

            } else if ("p3".equals(Index.name)) {
                P3CB += Index.comeBack;
                p3LA = Index.wentToAnswer;
                P3BS += Index.burstTime;
            } else if ("p4".equals(Index.name)) {
                P4CB += Index.comeBack;
                p4LA = Index.wentToAnswer;
                P4BS += Index.burstTime;
            } else if ("p5".equals(Index.name)) {
                P5CB += Index.comeBack;
                p5LA = Index.wentToAnswer;
                P5BS += Index.burstTime;
            } else if ("p6".equals(Index.name)) {
                P6CB += Index.comeBack;
                p6LA = Index.wentToAnswer;
                P6BS += Index.burstTime;
            } else if ("p7".equals(Index.name)) {
                P7CB += Index.comeBack;
                p7LA = Index.wentToAnswer;
                P7BS += Index.burstTime;
            }

        }

        P1BS -= AllProc.get(0).burstTime;
        P2BS -= AllProc.get(1).burstTime;
        P3BS -= AllProc.get(2).burstTime;
        P4BS -= AllProc.get(3).burstTime;
        P5BS -= AllProc.get(4).burstTime;
        P6BS -= AllProc.get(5).burstTime;
        P7BS -= AllProc.get(6).burstTime;

        P1CB -= AllProc.get(0).comeBack;
        P2CB -= AllProc.get(1).comeBack;
        P3CB -= AllProc.get(2).comeBack;
        P4CB -= AllProc.get(3).comeBack;
        P5CB -= AllProc.get(4).comeBack;
        P6CB -= AllProc.get(5).comeBack;
        P7CB -= AllProc.get(6).comeBack;

        P1Waiting = p1LA - P1BS - P1CB - AllProc.get(0).originalarrival;
        P2Waiting = p2LA - P2BS - P2CB - AllProc.get(1).originalarrival;
        P3Waiting = p3LA - P3BS - P3CB - AllProc.get(2).originalarrival;
        P4Waiting = p4LA - P4BS - P4CB - AllProc.get(3).originalarrival;
        P5Waiting = p5LA - P5BS - P5CB - AllProc.get(4).originalarrival;
        P6Waiting = p6LA - P6BS - P6CB - AllProc.get(5).originalarrival;
        P7Waiting = p7LA - P7BS - P7CB - AllProc.get(6).originalarrival;

        P1BS += AllProc.get(0).burstTime;
        P2BS += AllProc.get(1).burstTime;
        P3BS += AllProc.get(2).burstTime;
        P4BS += AllProc.get(3).burstTime;
        P5BS += AllProc.get(4).burstTime;
        P6BS += AllProc.get(5).burstTime;
        P7BS += AllProc.get(6).burstTime;

        P1TA += P1Waiting + P1BS + P1CB;
        P2TA += P2Waiting + P2BS + P2CB;
        P3TA += P3Waiting + P3BS + P3CB;
        P4TA += P4Waiting + P4BS + P4CB;
        P5TA += P5Waiting + P5BS + P5CB;
        P6TA += P6Waiting + P6BS + P6CB;
        P7TA += P7Waiting + P7BS + P7CB;

        if (P1Waiting < 0)
            P1Waiting = 0;
        if (P2Waiting < 0)
            P2Waiting = 0;
        if (P3Waiting < 0)
            P3Waiting = 0;
        if (P4Waiting < 0)
            P4Waiting = 0;
        if (P5Waiting < 0)
            P5Waiting = 0;
        if (P6Waiting < 0)
            P6Waiting = 0;
        if (P7Waiting < 0)
            P7Waiting = 0;
        System.out.println();
        System.out.println();

        System.out.println("p1 waiting time = " + P1Waiting + "    p1 TurnAround Time = " + P1TA);
        System.out.println("p2 waiting time = " + P2Waiting + "    p2 TurnAround Time = " + P2TA);
        System.out.println("p3 waiting time = " + P3Waiting + "    p3 TurnAround Time = " + P3TA);
        System.out.println("p4 waiting time = " + P4Waiting + "    p4 TurnAround Time = " + P4TA);
        System.out.println("p5 waiting time = " + P5Waiting + "    p5 TurnAround Time = " + P5TA);
        System.out.println("p6 waiting time = " + P6Waiting + "    p6 TurnAround Time = " + P6TA);
        System.out.println("p7 waiting time = " + P7Waiting + "    p7 TurnAround Time = " + P7TA);
        System.out.println();
        /*
         * System.out.println("p1 BS = "+P1BS);
         * System.out.println("p2 BS = "+P2BS);
         * System.out.println("p3 BS = "+P3BS);
         * System.out.println("p4 BS = "+P4BS);
         * System.out.println("p5 BS = "+P5BS);
         * System.out.println("p6 BS = "+P5BS);
         * System.out.println("p7 BS = "+P7BS);
         * System.out.println();
         * System.out.println("p1 CB = "+P1CB);
         * System.out.println("p2 CB = "+P2CB);
         * System.out.println("p1 CB = "+P3CB);
         * System.out.println("p2 CB = "+P4CB);
         * 
         * System.out.println("p5 CB = "+P5CB);
         * System.out.println("p6 CB = "+P6CB);
         * System.out.println("p7 CB = "+P7CB);
         * System.out.println();
         * System.out.println("p1 LA = "+p1LA);
         * System.out.println("p2 LA = "+p2LA);
         * System.out.println("p3 LA = "+p3LA);
         * System.out.println("p4 LA = "+p4LA);
         * System.out.println("p5 LA = "+p5LA);
         * System.out.println("p6 LA = "+p6LA);
         * System.out.println("p7 LA = "+p7LA);
         */

        double PriorityNONAverageWaitingTime = (P1Waiting + P2Waiting + P3Waiting + P4Waiting + P5Waiting + P6Waiting
                + P7Waiting) / 7.0;
        double PriorityNONAverageTurnAroundTime = (P1TA + P2TA + P3TA + P4TA + P5TA + P6TA + P7TA) / 7.0;

        System.out.println("Average Waiting Time for NonPreemptive Priority = " + PriorityNONAverageWaitingTime);
        System.out.println("Average Turn Around Time for NonPreemptive Priority = " + PriorityNONAverageTurnAroundTime);

        System.out.println();

    }

}
