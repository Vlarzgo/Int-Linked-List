import java.util.Arrays;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    private static class Entry {
        int value;
        Entry prev;
        Entry next;

        private Entry(int value) {
            this.value = value;
        }
    }

    private int size = 0;
    private Entry first = null;
    private Entry last = null;

    @Override
    public void add(int element) {
        Entry newEntry = new Entry(element);
        if (size == 0) {
            first = newEntry;
            last = newEntry;
        } else {
            last.next = newEntry;
            newEntry.prev = last;
            last = newEntry;
        }
        size++;
    }

    @Override
    public boolean add(int index, int element) {
        if (index > size) {
            throw new RuntimeException("Index is more than size");
        }
        if (index < 0) {
            throw new RuntimeException("Index must be natural");
        }
        Entry newEntry = new Entry(element);
        Entry buffFirst = first;
        Entry buffLast = last;
        if (index > 0 && index < size) {
            for (int i = 1; i <= index; i++) {
                buffFirst = buffFirst.next;
            }
            for (int i = size; i > index; i--) {
                buffLast = buffLast.prev;
            }
            buffFirst.prev = newEntry;
            newEntry.next = buffFirst;
            buffLast.next = newEntry;
            newEntry.prev = buffLast;

        } else if (index == 0) {
            first.prev = newEntry;
            newEntry.next = first;
            first = newEntry;
        } else if (index == size) {
            last.next = newEntry;
            newEntry.prev = last;
            last = newEntry;
        }
        size++;
        return true;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int get(int index) {
        if (index >= size) {
            throw new RuntimeException("Index is more than size");
        }
        if (index < 0) {
            throw new RuntimeException("Index must be natural");
        }
        Entry result = first;
        for (int i = 1; i <= index; i++) {
            result = result.next;
        }
        return result.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        if (index >= size) {
            throw new RuntimeException("Index is more than size");
        }
        if (index < 0) {
            throw new RuntimeException("Index must be natural");
        }
        Entry buff = first;
        if (index == 0) {
            first = buff.next;
            size--;
        } else if (index == size - 1) {
            size--;
        } else {
            for (int i = 1; i <= index; i++) {
                if (i == index) {
                    buff.prev = buff.prev.prev;
                    buff.next = buff.next.next;
                    size--;
                }
                buff = buff.next;
            }
        }
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        Entry buff = first;
        if (buff.value == value) {
            first = buff.next;
            size--;
        } else {
            for (int i = 1; i < size; i++) {
                if (i == size - 1) {
                    size--;
                    break;
                } else if (buff.value == value) {
                    buff = buff.prev;
                    buff.next = buff.next.next;
                    size--;
                    break;
                }
                buff = buff.next;

            }
        }
        return true;
    }

    @Override
    public boolean set(int index, int element) {
        if (index >= size) {
            throw new RuntimeException("Index is more than size");
        }
        if (index < 0) {
            throw new RuntimeException("Index must be natural");
        }
        if (index == 0) {
            first.value = element;
        } else {
            Entry buff = first;
            for (int i = 1; i <= index; i++) {
                buff = buff.next;
                if (i == index) {
                    buff.value = element;
                }
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size) {
            throw new RuntimeException("Index is out of range");
        }
        if (fromIndex > toIndex) {
            throw new RuntimeException("fromIndex must be less than toIndex");
        }
        IntList subList = new IntLinkedList();
        Entry buff = first;

        for (int i = 0; i < size; i++) {
            if (i >= fromIndex && i < toIndex) {
                subList.add(buff.value);
                buff = buff.next;
            } else {
                buff = buff.next;
            }

        }

        return subList;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            result[i] = tmp.value;
            tmp = tmp.next;
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public boolean push(int value) {
        Entry newEntry = new Entry(value);
        if (size == 0) {
            first = newEntry;
            last = newEntry;
        } else {
            first.prev = newEntry;
            newEntry.next = first;
            first = newEntry;
        }
        size++;
        return true;
    }

    @Override
    public int pop() {
        first = first.next;
        size--;
        return first.value;
    }

    @Override
    public int peek() {
        return first.value;
    }

    @Override
    public int remove() {
        int buff = first.value;
        first = first.next;
        size--;
        return buff;
    }

    @Override
    public int element() {
        return first.value;
    }

}
