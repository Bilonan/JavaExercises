import java.util.Scanner;

public class GuessingGame{
  Scanner sc = new Scanner(System.in);
  public void start(){
    System.out.println("Enter a number between 0 and 500 (-1 if you want me to choose one).");
    int num = sc.nextInt();
    int count = 1;
    if (num == -1) { num = (int) (Math.random()*500);
    }
    while (count <= 10) {
      int guess = sc.nextInt();
      if (guess == num) {System.out.println("Congratulations, "+num+" was the right guess!"); 
        System.out.println("You used "+count+" guesses.");
        break;}
      if (guess<num) {System.out.println("higher");}
      else if (guess>num){System.out.println("lower");
      }
      count = count + 1;
      if ((count == 11)&&(guess !=num)) {System.out.println("You have lost the game, the secret number was "+num+".");}
    }
    
  }  
  
  public static void main(String[] args){
    new GuessingGame().start();
  }
}