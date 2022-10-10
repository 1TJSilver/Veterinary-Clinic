import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public interface Clinic {
    Staff veterinarian = null;
    Deque<Client> queue = new LinkedList<>();

    Client nextPet();
    void urgently(Client client);
    void appointment(Client client);
    boolean hasNext();
    void letGo(Client client);
}
