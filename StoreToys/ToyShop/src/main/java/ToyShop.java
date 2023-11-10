import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class ToyShop { //класс магазин игрушек
    private ArrayList<Toy> toys; //array list игрушек

    public ToyShop(){
        toys = new ArrayList<>();
    }

    //region Метод добавления игрушек
    public void add(Toy toy) {
        boolean foundToy = false;
        for (Toy t : toys) {
            if (t.getId() == toy.getId()) {
                t.setQuantity(t.getQuantity() + toy.getQuantity());
                foundToy = true;
                break;
            }
        }
        if (!foundToy) {toys.add(toy);}
    }
    //endregion
    //region Метод измения веса игрушки
    public void setWeight(int toyId, double weight){
        for (Toy t : toys){
            if (t.getId() == toyId){
                t.setWeight(weight);
                break;
            }
        }
    }
    //endregion
    //region метод получения списка игрушек с параметрами
    public ArrayList<String> getToyList(){
        ArrayList<String> toyList =new ArrayList<>();
        for (Toy t : toys) {
            toyList.add("ID: " + t.getId() + " Название: " + t.getName() +
                    " Колличество: " + t.getQuantity() + " Процент: " + t.getWeight() + " %");
        }
        return toyList;
    }
    //endregion
    //region Метод розыгрыша игрушек
    public ArrayList<Toy> playGame(int count){
        ArrayList<Toy> winners = new ArrayList<>();
        double weightSum = 0;
        for (Toy t : toys) {
            weightSum += t.getWeight();
        }
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            double randomNumber = random.nextDouble() * weightSum;
            double currentSum = 0;
            for (Toy t : toys) {
                currentSum += t.getWeight();
                if (randomNumber >= currentSum) {
                    if (t.getQuantity() > 0) {
                        winners.add(t);
                        t.setQuantity(t.getQuantity() - 1);
                        weightSum -= t.getWeight();
                    }
                    break;
                }
            }
        }
        return winners;
    }
    //endregion
    //region метод сохранения данных в файл об игрушках
    public void saveToFile(String filename) throws IOException{
        try (FileWriter writer = new FileWriter(new File(filename))){
            for (Toy t : toys){
                writer.write(t.getId() + "," + t.getName() +
                        "," + t.getQuantity() + "," + t.getWeight() +"\n");

            }
        }
    }
    //endregion
    //region метод загрузки информации из файла об игрушках
    public void loadFormFile(String filename) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] toyData = line.split(",");
                Toy toy = new Toy(Integer.parseInt(toyData[0]), toyData[1], Integer.parseInt(toyData[2]),
                        Double.parseDouble(toyData[3]));
                toys.add(toy);
            }

        }
    }
    //endregion

}
