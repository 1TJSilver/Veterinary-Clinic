import java.util.HashMap;
import java.util.Map;

public class Client {
    private Map<String, Boolean> petList;
    private String name;
    private Clinic clinic;
    public Client(String name, Clinic clinic){
        this.name = name;
        this.clinic = clinic;
        petList = new HashMap<>();
    }
    String getSicked(){
        for (Map.Entry<String, Boolean> entry : petList.entrySet()) {
            if (entry.getValue() == false){
                return entry.getKey();
            }
        }
        return null;
    }
    Client addPet(String pet, boolean healthy){
        petList.put(pet, healthy);
        return this;
    }
    void cure(String pet){
        petList.replace(pet, true);
    }
    public String getName(){
        return name;
    }
}
