/*package OS;
class Process {
    String name;
    int arrivalTime;
    int burstTime;
    int waitingTime;
    int hasArrived=0;
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
    int lastEX =0;
   
    public Process(){
        
    }
    public Process(String name, int arrivalTime,int burstTime,int waitingTime,int hasArrived, int comeBack, int completion) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = waitingTime;
        this.hasArrived= hasArrived;
        this.comeBack= comeBack;
        this.completion= completion;
        this.recent=false;
        this.newBurst = burstTime;
        this.originalarrival = arrivalTime;
    }
    public Process(String name, int arrivalTime,int burstTime,int waitingTime,int hasArrived, int comeBack, int completion,int index) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = waitingTime;
        this.hasArrived= hasArrived;
        this.comeBack= comeBack;
        this.completion= completion;
        this.recent=false;
        this.newBurst = burstTime;
        this.index=index;
        this.left =  this.newBurst-this.burstTime ;
         this.originalarrival = arrivalTime;
        
    }
     public Process(String name, int arrivalTime,int burstTime,int waitingTime,int hasArrived, int comeBack, int completion,int index, int priority) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = waitingTime;
        this.hasArrived= hasArrived;
        this.comeBack= comeBack;
        this.completion= completion;
        this.recent=false;
        this.newBurst = burstTime;
        this.index=index;
        this.priority=priority;
        this.newPriority=priority;
         this.originalarrival = arrivalTime;
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





}*/