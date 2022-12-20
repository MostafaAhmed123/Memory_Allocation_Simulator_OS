import java.util.ArrayList;

public class WorstFit implements Policy{
    @Override
    public boolean allocateMemory(Process process, ArrayList<Partition> partitions) {
        return false;
    }
}
