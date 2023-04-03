package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class ZooDriver {

    public static void userMenu(ArrayList<Talkable> zoo){
        Scanner keyboard = new Scanner(System.in);

        String newThingName = "";
        int teacherAge = 34;
        int newMice = 0;
        boolean dog = false;

        String menu = String.format("Please enter the number of the item you would " +
                "like to create: \n" +
                "1.  Teacher\n" +
                "2.  Dog\n" +
                "3.  Cat");

        System.out.println(menu);

        char input = keyboard.next().charAt(0);

        switch (input){
            case '1':  // create Teacher

                System.out.print("Enter the teacher's name>> ");
                newThingName = keyboard.next();

                System.out.print("Enter the teacher's age>> ");

                try {
                    teacherAge = Integer.parseInt(keyboard.next());
                    // validate the age entry makes sense
                    if(teacherAge < 20 || teacherAge > 75){
                        System.out.println("Invalid entry.  Please enter a valid age: ");
                        teacherAge = Integer.parseInt(keyboard.next());
                    }
                } catch (Exception e){
                    System.out.println("Exception thrown: " + e);
                    System.out.println(String.format("Age defaulted to 34"));
                }
                keyboard.close();
                zoo.add(new Teacher(teacherAge,newThingName));

                break;
            case '2':   // create Dog

                System.out.print("Enter the dog's name>> ");
                newThingName = keyboard.next();

                System.out.print("Is the dog friendly (Y/N)? ");
                char newFriendly = keyboard.next().charAt(0);
                dog = (newFriendly == 'y' || newFriendly == 'Y') ? (true) : (false);

                keyboard.close();
                zoo.add(new Dog(dog,newThingName));

                break;
            case '3':   // create Cat

                System.out.print("Enter the cat's name>> ");
                newThingName = keyboard.next();

                System.out.print("How many mice killed? ");

                try {
                    newMice = Integer.parseInt(keyboard.next());
                    // validate the age entry makes sense
                    if(newMice < 0 || newMice > 25){
                        System.out.println("Invalid entry.  Please enter a valid number of mice killed: ");
                        newMice = Integer.parseInt(keyboard.next());
                    }
                } catch (Exception e){
                    System.out.println("Exception thrown: " + e);
                    System.out.println(String.format("Age defaulted to 0"));
                }

                keyboard.close();
                zoo.add(new Cat(newMice,newThingName));

                break;
        }
    }
}
