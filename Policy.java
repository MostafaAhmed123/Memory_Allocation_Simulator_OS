import java.util.ArrayList;

public interface Policy {
    boolean allocateMemory(Process process, ArrayList<Partition> partitions);
}
