import java.util.ArrayDeque;
import java.util.Deque;


public class CarShop {

    private Deque<Car> cars = new ArrayDeque<>();

    public synchronized void receivCar() {
        try {
            Thread.sleep(3000);
            System.out.println("Поступила машина");
            cars.addLast(new Car("Lada"));
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sellCar() {
        System.out.println("Зашел " + Thread.currentThread().getName());
        try {
            while (cars.size() == 0) {
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(100);
            cars.pollFirst();
            System.out.println("Машина продана " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
