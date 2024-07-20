import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Dizi tanımlama ve eleman atama
        int[] dizi = new int[5];
        dizi[0] = 1;
        dizi[1] = 2;
        dizi[2] = 3;
        dizi[3] = 4;
        dizi[4] = 5;

        // Dizi elemanlarını yazdırma
        for (int sayi : dizi) {
            System.out.print(sayi + " ");
        }
        System.out.println("deneme");

        // ArrayList tanımlama ve eleman ekleme
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        // ArrayList elemanlarını yazdırma
        for (int sayi : lista) {
            System.out.println(sayi);
        }

        // Stream API kullanarak elemanları yazdırma
        lista.stream().forEach(sayi -> System.out.println(sayi));

        // User listesi oluşturma ve eleman ekleme
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Yağmur"));
        users.add(new User(2, "Atakan"));

        // User listesi elemanlarını yazdırma (lambda ifadesi)
        users.stream().forEach(user -> user.talk());
        // User listesi elemanlarını yazdırma (method reference)
        users.stream().forEach(User::talk);

        // Filtreleme: ID'si 2'den küçük olan kullanıcıları filtreleme
        List<User> filteredList = users.stream().filter(user -> user.id < 2).collect(Collectors.toList());
        System.out.println("Filtered");
        filteredList.stream().forEach(User::talk);

        // Mapleme: ID'si 100 eklenmiş kullanıcılar oluşturma
        List<User> mappedList = users.stream().map(user -> new User(user.id + 100, user.name)).collect(Collectors.toList());
        System.out.println("Mapped");
        mappedList.stream().forEach(user -> System.out.println(user.toString()));

        // User listesi ID ve isimlerini bir Map'e dönüştürme
        Map<Integer, String> userMap = users.stream().collect(Collectors.toMap(user -> user.id, user -> user.name));
        userMap.forEach((key, value) -> System.out.println(key + ": " + value)); // system.out yerine System.out

    }
}

class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

    public void talk() {
        System.out.println("Hi, I am " + this.name);
    }
}
