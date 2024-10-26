import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;


public class ToyQueue {
    private PriorityQueue<Toy> queue;

    public ToyQueue() {
        this.queue = new PriorityQueue<>((a, b) -> b.getWeight() - a.getWeight());
    }

    // Метод для добавления игрушек в очередь
    public void put(Toy toy) {
        for (int i = 0; i < toy.getWeight(); i++) {
            queue.add(toy);
        }
    }

    // Метод для случайного выбора игрушки
    public Toy get() {
        int totalWeight = queue.size(); 
        int randomValue = new Random().nextInt(totalWeight); 
        int index = 0; 
        for (Toy toy : queue) { 
            if (index == randomValue) { 
                return toy; 
            } 
            index++; 
        }
        return null;
    }

    public static void main(String[] args) {
        ToyQueue toyQueue = new ToyQueue();

        // Добавление игрушек
        toyQueue.put(new Toy("1", "Конструктор", 2));
        toyQueue.put(new Toy("2", "Робот", 2));
        toyQueue.put(new Toy("3", "Кукла", 6));

        try (FileWriter writer = new FileWriter("results.txt")) {
            for (int i = 0; i < 10; i++) {
                Toy result = toyQueue.get();
                writer.write(result + "\n");
                System.out.println("Получена игрушка с ID: " + result.getId() + ", " + result.getName() );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
