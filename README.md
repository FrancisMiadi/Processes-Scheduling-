# ⚙️ CPU Scheduling Simulation  

## 📌 Overview  
This **Operating System Concepts** project simulates different **CPU scheduling algorithms** . The program processes a set of **7 processes** with given **arrival times, burst times, and priorities**, using **Object-Oriented Programming (OOP) principles in Java**.  

## 💡 Features  
- **Gantt Chart Visualization:** Displays the execution timeline of processes.  
- **Calculates Performance Metrics:** Computes **average waiting time (AWT)** and **average turnaround time (ATAT)**.  
- **Implemented CPU Scheduling Algorithms:**  
  - **First Come First Served (FCFS)**  
  - **Shortest Job First (SJF)**  
  - **Shortest Remaining Time First (SRTF)**  
  - **Round Robin (RR) (q = 5)**  
  - **Preemptive Priority Scheduling (with aging)**  
  - **Non-preemptive Priority Scheduling (with aging)**  
- **Handles Process Completion & Rescheduling:** Processes return to the queue after a defined wait time.  

## 📊 System Functionality  
**1. Process Creation & Initialization**  
   - Each process has **arrival time, burst time, priority, and return delay**.  
**2. Scheduling Simulation**  
   - **First Come First Served (FCFS)** → Executes processes in order of arrival.  
   - **Shortest Job First (SJF)** → Picks the process with the shortest burst time.  
   - **Shortest Remaining Time First (SRTF)** → Chooses the process with the least remaining time.  
   - **Round Robin (RR, q = 5)** → Time-sliced execution with preemption.  
   - **Preemptive & Non-preemptive Priority Scheduling (with aging)** → Adjusts priority dynamically.  
**3. Performance Evaluation**  
   - Computes **Average Waiting Time (AWT)** and **Average Turnaround Time (ATAT)**.  
**4. Gantt Chart Output**  
   - Displays execution order for better visualization.

## 🌐 Contact  
**For inquiries, reach out via:**  
- **Email:** *francismiadi0@gmail.com*  
- **GitHub:** *FrancisMiadi*  
