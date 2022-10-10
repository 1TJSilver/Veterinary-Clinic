public class Main {
    public static void main(String[] args) {
        Clinic clinic = new VeterinaryClinic();
        ThreadGroup group = new ThreadGroup("Group");
        new Veterinarian(clinic, "Maria", group).start();
        new Veterinarian(clinic, "Igor", group).start();
        clinic.appointment(new Client("Senya", clinic)
                .addPet("Citty", true)
                .addPet("Bobik", false));
        clinic.appointment(new Client("Pasha", clinic)
                .addPet("Kesha", false));
        clinic.urgently(new Client("Misha", clinic)
                .addPet("Flint", false));
        waitAndFinish(group);
    }
    public static void waitAndFinish (ThreadGroup group){
        while (group.activeCount() > 0){
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(group.getName() + " is end");
        group.interrupt();
    }
}
