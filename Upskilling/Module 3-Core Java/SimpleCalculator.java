import java.util.*;
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double result=0;
        double n1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double n2 = sc.nextDouble();
        System.out.print("Enter an operator (+, -, *, /): ");
        char op = sc.next().charAt(0);
        switch(op){
            case '+':
                result=n1+n2;
                break;
            case '-':
                result=n1-n2;   
                break;
            case '*':
                result=n1*n2;       
                break;
            case '/':
                if(n2!=0){
                    result=n1/n2; 
                }
                else{
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
                return;
        }
        System.out.println("Output: " + result);
    }
}
