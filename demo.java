package MemoryAllocation;

import java.util.*;

import java.io.*;


public class demo {

	public static void main(String[] args)
    {
		Scanner myObj1 = new Scanner(System.in) ;
	    Scanner myObj2 = new Scanner(System.in);
	    String PartitonName,processname ;
	    int No_Partitions,PartitionSize,No_processes,processSize;
	    Policy p ;
	System.out.println("Enter nmuber of paritions ");
	   No_Partitions= myObj1.nextInt() ;
	   System.out.println("Enter nmuber of processes ");
	   No_processes= myObj1.nextInt() ;
	       
	   Partition []Partitions = new Partition[No_Partitions];
	   Process [] Processes = new Process [No_processes] ;
		  ArrayList <Partition> partitions= new ArrayList<Partition>();
		  ArrayList <Process>  processes= new ArrayList<Process>();
		  
		
		  for(int i =0; i<No_Partitions;i++)
		  {
			 System.out.println("Enter name of partition "+(i+1)+" ");
			 PartitonName= myObj2.nextLine() ;
			 
			 System.out.println("Enter size of partition ");
			 PartitionSize = myObj1.nextInt();
			 Partitions[i]= new Partition(PartitonName, PartitionSize, true); 
			 partitions.add(Partitions[i]);
		  }
		  
		  for(int i = 0 ; i<No_processes ; i++)
		  {
			  System.out.println("Enter name of process"+(i+1)+" ");
			  processname=myObj2.nextLine();
			  Processes[i].setProcessName(processname);
			  System.out.println("Enter size of process ");
			  processSize=myObj1.nextInt() ;
			  Processes[i].setSize(processSize);
			  processes.add(Processes[i]);
			  
 		  }
		  for(int i = 0;i< processes.size();i++){
			    p.allocateMemory(processes.get(i),partitions);
			}
		   int select ;
		  
		  while(true)
		  {
			  System.out.println("Select the policy you want to apply:\r\n"
			  		+ "1. First fit\r\n"
			  		+ "2. Worst fit\r\n"
			  		+ "3. Best fit \n"
			  		+ "4. exit \n");
			  select = myObj1.nextInt() ;
			   if(select==1)
			   {
				   p = new FirstFit();
				   for(int i = 0;i< processes.size();i++){
					    p.allocateMemory(processes.get(i),partitions);
					}
			   }
			   else if (select==2)
			   {
				  p = new WorstFit();
				  for(int i = 0;i< processes.size();i++){
					    p.allocateMemory(processes.get(i),partitions);
					}
			   }
			   else if (select == 3)
			   {
				   p = new BestFit();
				   for(int i = 0;i< processes.size();i++){
					    p.allocateMemory(processes.get(i),partitions);
					}
			   }
			   else if (select==4) {
				   break;
			   }	
		  } 
    }

}