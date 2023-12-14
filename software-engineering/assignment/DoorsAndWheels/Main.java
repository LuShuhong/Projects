import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new HGV());
        vehicles.add(new Bus());
        vehicles.add(new Motorcycle());

        int totalDoors =0;
        int totalWheels = 0;
        for(Vehicle vehicle: vehicles){
            totalDoors += vehicle.getNumberOfDoors();
            totalWheels += vehicle.getNumberOfWheels();
            System.out.println(vehicle.getNumberOfDoors());
            System.out.println(vehicle.getNumberOfWheels());
        }

        System.out.println(totalDoors);
        System.out.println(totalWheels);
    }
}
