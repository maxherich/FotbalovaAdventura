public class Product {
    private String name;
    private int prize;

    public Product(String name, int prize) {
        this.name = name;
        this.prize = prize;
    }

    @Override
    public String toString() {
        return name + ": " + prize + "$";
    }
}
