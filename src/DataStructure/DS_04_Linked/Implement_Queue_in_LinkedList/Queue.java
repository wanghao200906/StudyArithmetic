package DataStructure.DS_04_Linked.Implement_Queue_in_LinkedList;

public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
