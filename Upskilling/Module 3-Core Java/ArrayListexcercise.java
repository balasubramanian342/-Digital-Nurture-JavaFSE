import java.util.*;
public class ArrayListexcercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> s = new ArrayList<>();
        System.out.print("How many students? ");
        int n = sc.nextInt();
        sc.nextLine(); 
        for(int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            s.add(sc.nextLine());
        }
        System.out.println("\nStudent Names:");
        for(String name : s) {
            System.out.println(name);
        }
        sc.close();
    }
}