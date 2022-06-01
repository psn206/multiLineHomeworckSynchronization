public class Main {

    public static void main(String[] args) {
        final CarShop carShop = new CarShop();
        for (int i = 1; i < 4; i++) {
            new Thread(null, carShop::sellCar, "Покупатель" + i).start();
        }
        for (int i = 1; i < 4; i++) {
            new Thread(null, carShop::receivCar, "Производитель" + i).start();
        }


    }
}
