package review.collectionTest;

public class Car {
    private String name;
    private String carNum;
    private Owner owner;

    public Car(String name, String carNum) {
        this.name = name;
        this.carNum = carNum;
        this.owner = new Owner(name);
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return owner.getOwnerName();
    }

    public String getCarNum() {
        return carNum;
    }

    public void printCar(){
        System.out.println(name);
    }

    public class Owner {
        private String name;

        public Owner(String name) {
            this.name = name;
        }

        public String getOwnerName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Car car = new Car("타요", "1234");

        car.printCar();
    }
}
