import java.util.ArrayList;

public class FirstFit extends Policy{
    @Override
        public boolean allocateMemory(Process process, ArrayList<Partition> partitions) {

            int idx = -1;
            for(int i = 0;i<partitions.size();i++){
                int fragmentation = partitions.get(i).getSize() - process.getSize();

                if(partitions.get(i).getSize()>=process.getSize()&&partitions.get(i).isFree()){
                    idx= i;

                }
                if(idx!= -1){
                    Partition p = new Partition(partitions.get(idx).getPartitionName() + String.valueOf(idx + 1),partitions.get(idx).getSize()-process.getSize(),true);
                    if(p.getSize()>0)
                        partitions.add(p);
                    partitions.get(idx).setFree(false);
                    partitions.get(idx).setSize(process.getSize());
                    partitions.get(idx).setProcess(process);
                    return true;
                }

            }
            
            return  false;

        }
    }