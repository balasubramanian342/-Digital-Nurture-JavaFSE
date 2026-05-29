import java.util.*;
public class LambdaExercise{
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Priya");
        names.add("Alex");
        names.add("David");
        Collections.sort(names,
                (a, b) -> a.compareTo(b));
        System.out.println("Sorted List:");
        for(String name : names) {
            System.out.println(name);
        }
    }
}