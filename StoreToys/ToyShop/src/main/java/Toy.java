public class Toy {
    //region Переменные
    private int id; //id игрушки
    private String name; //текстовое название
    private int quantity; //количество
    private double weight; //частота выпадения игрушки (вес в % от 100)
    //endregion
    //region Конструктор
    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }
    //endregion
    //region Гетторы и сетторы
    public int getId() { return id; }

    public String getName() { return name; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getWeight() { return weight; }

    public void setWeight(double weight) { this.weight = weight; }
    //endregion
}
