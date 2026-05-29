import java.util.List;
record Person(String name, int age) {}
public class Records {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", 22),
                new Person("Priya", 17),
                new Person("Alex", 25)
        );
        System.out.println("All Persons:");
        people.forEach(System.out::println);
        System.out.println("\nAdults:");
        people.stream()
              .filter(p -> p.age() >= 18)
              .forEach(System.out::println);
    }
}