import java.util.Deque;
import java.util.LinkedList;

public class VeterinaryClinic implements Clinic{

    private Deque<Client> queue = new LinkedList<>();
    @Override
    public Client nextPet() {
        return queue.removeFirst();
    }

    @Override
    public void urgently(Client client) {
        queue.addFirst(client);
    }

    @Override
    public void appointment(Client client) {
        queue.addLast(client);
    }

    @Override
    public void letGo(Client client) {
        client.cure(client.getSicked());
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
