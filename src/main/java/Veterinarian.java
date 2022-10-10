public class Veterinarian extends Thread implements Staff{
    final static int CURE = 2000;
    final static int PAUSE = 500;
    Clinic clinic;
    String name;

    public Veterinarian(Clinic clinic, String name, ThreadGroup group){
        super(group, name);
        this.name = name;
        this.clinic = clinic;
    }
    @Override
    public void next() throws InterruptedException{
        if (clinic.hasNext()){
            Client client;
            synchronized (clinic){
                client = clinic.nextPet();
            }
            System.out.println(name + ": accepted " + client.getSicked());
            Thread.sleep(CURE);
            System.out.println(client.getSicked() + " was cured");
            clinic.letGo(client);
        } else {
        }
    }

    @Override
    public void end() {

    }

    @Override
    public void run() {
        while (clinic.hasNext()){
            try {
                Thread.sleep(PAUSE);
                if (clinic.hasNext()){
                    next();
                }
            } catch (InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
