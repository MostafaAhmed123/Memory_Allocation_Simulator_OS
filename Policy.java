import java.util.ArrayList;

public abstract class Policy {
    public abstract boolean allocateMemory(Process process, ArrayList<Partition> partitions);
    public void print(ArrayList<Partition> partitions){
        for(int i = 0;i<partitions.size();i++){
            if(partitions.get(i).isFree())
                System.out.println(partitions.get(i).getPartitionName() + '(' + partitions.get(i).getSize() + "KB) => External fragment");
            else
                System.out.println(partitions.get(i).getPartitionName() + '(' + partitions.get(i).getSize() + "KB) => " + partitions.get(i).getProcess().getProcessName());
        }
    }
    public void compaction(ArrayList<Partition> partitions){
     ArrayList<Partition> p2 = new ArrayList<>();
     int fragmentSize = 0;
     for(int i = 0;i<partitions.size();i++){
         if(partitions.get(i).isFree())
             fragmentSize += partitions.get(i).getSize();
         else
             p2.add(partitions.get(i));
     }
     p2.add(new Partition("Partition " + String.valueOf(partitions.size()), fragmentSize, true));
     partitions.clear();
     partitions.addAll(p2);
    }
}
