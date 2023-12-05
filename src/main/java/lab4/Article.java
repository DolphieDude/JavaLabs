package lab4;

public class Article {
    private String name;

    private float price;

    public Article(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}