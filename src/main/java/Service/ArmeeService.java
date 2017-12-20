package Service;

public class ArmeeService {

    private static ArmeeService instance = null;

    public static ArmeeService getInstance() {
        if (instance == null) {
            instance = new ArmeeService();
        }
        return instance;
    }

    private ArmeeService() {

    }
}
