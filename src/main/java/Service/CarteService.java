package Service;

public class CarteService {

    private static CarteService instance = null;

    public static CarteService getInstance() {
        if (instance == null) {
            instance = new CarteService();
        }
        return instance;
    }

    private CarteService() {

    }

    public void createCarte(int x, int y){

    }


}
