import java.util.ArrayList;

public class WorstFit extends Policy{
    @Override
    public boolean allocateMemory(Process process, ArrayList<Partition> partitions) {
        return false;
    }
}
