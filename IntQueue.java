package Task4;

public interface IntQueue {

    void add(int element);
    int remove(); // return first in Queue and remove it
    int element(); // return first in Queue but not remove it
}
