/*
Create a program to read from a flat file and write to the flat file. You will create a menu for reading and writing to the file. Use the folllowing starter code.
*/
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

class Main {
  public static void main(String[] args) throws IOException{
    int length = databaseLength();
    String[][] database = parseDatabase(length);
    String choice = menu();
    selection(choice, length, database);
  }
  public static int databaseLength() throws IOException {
    int lineNumber = 0;
    try{
      Scanner fileInput = new Scanner(new File("database.txt"));
      while (fileInput.hasNext()) {
        lineNumber++;
        fileInput.nextLine();
      }
      fileInput.close();
    }catch (IOException ioException) {
      System.err.println("Java Exception: " + ioException);
    }
    return lineNumber;
  }
  public static String[][] parseDatabase(int length) throws IOException {
    String[][] databaseParsed = new String [length][4];
    int line = 0; 
    try {
      Scanner fileInput = new Scanner(new File("database.txt"));
      while (fileInput.hasNext()) {
        String output = fileInput.nextLine();
        String[] info = output.split(",");
        databaseParsed[line][0] = info[0].trim();
        databaseParsed[line][1] = info[1].trim();
        databaseParsed[line][2] = info[2].trim();
        databaseParsed[line][3] = info[3].trim();
        line++;
      }
    } catch (IOException ioException) {
      System.err.println("Java Exception: " + ioException);
    }
    return databaseParsed;
  }
  public static String menu() {
    System.out.println("Main menu:");
    System.out.println("a)  Show all last names");
    System.out.println("b)  Show all first names");
    System.out.println("c)  Show all date of births");
    System.out.println("d)  Show all student numbers");
    System.out.println("e)  Enter a new student");
    System.out.print("Enter your choice: ");
    Scanner input = new Scanner (System.in);
    String choice = input.nextLine();
    return choice;
  }
  public static void selection(String choice, int length, String[][] database) {
    if (choice.equalsIgnoreCase("a")) {
      for (int i = 1; i < length; i++) {
        System.out.println(database[i][0]);
      }
    }
    else if (choice.equalsIgnoreCase("b")) {
      for (int i = 1; i < length; i++) {
        System.out.println(database[i][1]);
      }
    }
    else if (choice.equalsIgnoreCase("c")) {
      for (int i = 1; i < length; i++) {
        System.out.println(database[i][2]);
      }
    }
    else if (choice.equalsIgnoreCase("d")) {
      for (int i = 1; i < length; i++) {
        System.out.println(database[i][3]);
      }
    }
    else if (choice.equalsIgnoreCase("e")) {
      Scanner input = new Scanner (System.in);
      String last;
      String first;
      String dob;
      String stuNum;
      System.out.print("Enter last name: ");
      last = input.nextLine();
      System.out.print("Enter first name: ");
      first = input.nextLine();
      System.out.print("Enter date of brith: ");
      dob = input.nextLine();
      System.out.print("Enter student number: ");
      stuNum = input.nextLine();
      try{
        FileWriter myWriter = new FileWriter("database.txt", true);
        myWriter.write("\n" + last + ", " + first + ", " + dob + ", " + stuNum);
        myWriter.close();
        System.out.println("Sucessfully wrote to file");
      }catch (IOException e) {
        System.out.println("An error occured ):");
        e.printStackTrace();
      }
    }
  }
}