import java.util.ArrayList;

public class FirstFit extends Policy{
    @Override
    public boolean allocateMemory(Process process, ArrayList<Partition> partitions) {
        return false;
    }
}
