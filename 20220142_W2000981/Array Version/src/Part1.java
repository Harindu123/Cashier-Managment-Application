import java.util.*;
import java.io.*;

public class Part1 {
    static int burgerCount = 50;
    static String[] cashier1 = {"Available", "Available", "Available", "Available", "Available"};
    static String[] cashier2 = {"Available", "Available", "Available", "Available", "Available"};
    static String[] cashier3 = {"Available", "Available", "Available", "Available", "Available"};

//View All Queues
    static void part1() {
        System.out.println("""
                ********************\s
                *   ~~CASHIERS~~   *\s
                ********************""");

        String[][] tempArray = {(cashier1), (cashier2), (cashier3)};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (!tempArray[j][i].equals("Available")) {
                    System.out.print("  O   ");
                } else {
                    if (j == 0 && i < 2) {
                        System.out.print("  X   ");
                    } else if (j == 1 && i < 3) {
                        System.out.print("  X   ");
                    } else if (j == 2) {
                        System.out.print("  X   ");
                    } else {
                        System.out.print("      ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("X – Not Occupied O – Occupied");
    }

//View Empty Queues
    static void part2() {
        System.out.println("Empty Queue/s : " + ((cashier1[0].equals("Available")) ? "\n Queue " +
                "One" : "") + ((cashier2[0].equals("Available")) ? "\n Queue Two" : "") + ((cashier3[0].equals("Available")) ? "\n Queue Three" : ""));
    }

// Adding customer to Queue
    static void part3() {
        System.out.print("\nEnter Queue :");
        Scanner queue = new Scanner(System.in);
        String queueOp = queue.nextLine();
        if (queueOp.equals("1") && cashier1[1].equals("Available")) {
            System.out.print("\nEnter Customer Name :");
            Scanner cusName = new Scanner(System.in);
            String custName = cusName.nextLine();
            int j = 0;
            for (String i : cashier1) {
                if (i.equals("Available")) {
                    cashier1[j] = custName.toLowerCase();
                    break;
                } else {
                    j++;
                }
            }
        } else if (queueOp.equals("2") && cashier2[2].equals("Available")) {
            System.out.print("\nEnter Customer Name :");
            Scanner cusName = new Scanner(System.in);
            String custName = cusName.nextLine();
            int j = 0;
            for (String i : cashier2) {
                if (i.equals("Available")) {
                    cashier2[j] = custName.toLowerCase();
                    break;
                } else {
                    j++;
                }
            }
        } else if (queueOp.equals("3") && cashier3[4].equals("Available")) {
            System.out.print("\nEnter Customer Name :");
            Scanner cusName = new Scanner(System.in);
            String custName = cusName.nextLine();
            int j = 0;
            for (String i : cashier3) {
                if (i.equals("Available")) {
                    cashier3[j] = custName.toLowerCase();
                    break;
                } else {
                    j++;
                }
            }
        } else {

            if (queueOp.equals("1") || queueOp.equals("2") || queueOp.equals("3")) {
                if (queueOp.equals("1")) {
                    System.out.println("Queue 1 is full");
                } else if (queueOp.equals("2")) {
                    System.out.println("Queue 2 is full");
                } else {
                    System.out.println("Queue 3 is full");
                }
            } else {
                System.out.println("\nInvalid Queue Number");
            }
        }
    }

//Removing Customer From Queue
    static void part4() {
        System.out.print("\nEnter Queue Number :");
        Scanner queue = new Scanner(System.in);
        String queueNo = queue.nextLine();
        label:
        while (true) {
            try {
                System.out.print("\nEnter Customer's Position in Queue(From Front) :");
                Scanner pos = new Scanner(System.in);
                int position = pos.nextInt();
                position = position - 1;

                switch (queueNo) {
                    case "1" -> {
                        if (cashier1[position].equals("Available")) {
                            System.out.println("\nPosition is Empty");
                        } else {
                            try {
                                for (int i = position; i < 2; i++) {
                                    cashier1[i] = cashier1[i + 1];
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                cashier1[1] = "Available";
                            }
                        }
                        break label;
                    }
                    case "2" -> {
                        if (cashier2[position].equals("Available")) {
                            System.out.println("\nPosition is Empty");
                        } else {
                            try {
                                for (int i = position; i < 3; i++) {
                                    cashier2[i] = cashier2[i + 1];
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                cashier2[2] = "Available";
                            }
                        }
                        break label;
                    }
                    case "3" -> {
                        if (cashier3[position].equals("Available")) {
                            System.out.println("\nPosition is Empty");
                        } else {
                            try {
                                for (int i = position; i < 5; i++) {
                                    cashier3[i] = cashier3[i + 1];
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                cashier3[4] = "Available";
                            }
                        }
                        break label;
                    }
                    default -> System.out.println("invalid input");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
            }
        }
    }

//Removing Served Customer
    static void part5() {
        while (true) {
            try {
                System.out.print("\nEnter Queue Number : ");
                Scanner pos1 = new Scanner(System.in);
                String position1 = pos1.nextLine();
                if (position1.equals("1")) {
                    try {
                        for (int i = 0; i < 2; i++) {
                            cashier1[i] = cashier1[i + 1];
                        }
                        burgerCount=burgerCount-5;
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        cashier1[1] = "Available";
                    }

                } else if (position1.equals("2")) {
                    try {
                        for (int i = 0; i < 3; i++) {
                            cashier2[i] = cashier2[i + 1];
                        }
                        burgerCount=burgerCount-5;
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        cashier2[2] = "Available";
                    }

                } else if (position1.equals("3")) {
                    try {
                        for (int i = 0; i < 5; i++) {
                            cashier3[i] = cashier3[i + 1];
                        }
                        burgerCount=burgerCount-5;
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        cashier3[4] = "Available";
                        break;
                    }
                }


            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
            }
        }
    }

//writing file to store data
    static void part6() {
        try {
            File save = new File("Backup Data.txt");
            if (save.createNewFile()) {
                System.out.println("File Created");
            } else {
                System.out.println("File Already There");
            }
            FileWriter writer = new FileWriter("Backup Data.txt");
            PrintWriter log = new PrintWriter(writer);
            for (String i : cashier1) {
                if (!i.equals("Available")) {
                    log.print(i);
                    log.print(" ");
                }
            }
            log.println("\n");
            for (String i : cashier2) {
                if (!i.equals("Available")) {
                    log.print(i);
                    log.print(" ");
                }
            }
            log.println("\n");
            for (String i : cashier3) {
                if (!i.equals("Available")) {
                    log.print(i);
                    log.print("\n");
                }
            }
            writer.close();
            System.out.println("Data Saved ");

        } catch (IOException e) {
            System.out.println("An Error Occurred.");
            e.printStackTrace();
        }
    }

//Reading Saved File
    static void part7() {
        try {
            File read = new File("Backup Data.txt");
            Scanner Details = new Scanner(read);
            int x = 0;
            while (Details.hasNextLine()) {
                String text = Details.nextLine();
                if (!text.equals("")) {
                    System.out.println(text);
                    String[] tempArray = text.split(" ");
                    if (x == 0) {
                        int j = 0;
                        for (String i : tempArray) {
                            cashier1[j] = i;
                            j++;
                        }
                    } else if (x == 1) {
                        int j = 0;
                        for (String i : tempArray) {
                            cashier2[j] = i;
                            j++;
                        }
                    } else if (x == 2) {
                        int j = 0;
                        for (String i : tempArray) {
                            cashier3[j] = i;
                            j++;
                        }
                    }
                    x++;
                }
            }
        } catch (IOException e) {
            System.out.println("An Error Occurred.");
            e.printStackTrace();
        }
    }

//Sorting Customers in Alphabetical Order
    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap arr[j] and arr[j+1]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop,
            // the array is already sorted
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {

        while (true) {
            String Menu = """
                                    
                    100 or VFQ: View all Queues.              
                    101 or VEQ: View all Empty Queues.
                    102 or ACQ: Add customer to a Queue.
                    103 or RCQ: Remove a customer from a Queue. 
                    104 or PCQ: Remove a served customer.
                    105 or VCS: View Customers Sorted in alphabetical order. 
                    106 or SPD: Store Program Data into file.
                    107 or LPD: Load Program Data from file.
                    108 or STK: View Remaining burgers Stock.
                    109 or AFS: Add burgers to Stock.
                    999 or EXT: Exit the Program.""";

            System.out.println(Menu);
            System.out.print("\nEnter Your Option :");
            Scanner option = new Scanner(System.in);
            String choice = option.nextLine();
            choice = choice.toUpperCase();

            if (choice.equals("100") || choice.equals("VFQ")) {
                part1();

            } else if (choice.equals("101") || choice.equals("VEQ")) {
                part2();

            } else if (choice.equals("102") || choice.equals("ACQ")) {
                part3();

            } else if (choice.equals("103") || choice.equals("RCQ")) {
                part4();

            } else if (choice.equals("104") || choice.equals("PCQ")) {
                part5();

            } else if (choice.equals("105") || choice.equals("VCS")) {
                String[] temp1 = {"Available", "Available", "Available", "Available", "Available"};
                int j=0;
                for (String i:cashier1){
                    temp1[j]=i;
                    j++;
                }
                String[] temp2 = {"Available", "Available", "Available", "Available", "Available"};
                int k=0;
                for (String i:cashier2){
                    temp2[k]=i;
                    k++;
                }
                String[] temp3 = {"Available", "Available", "Available", "Available", "Available"};
                int l=0;
                for (String i:cashier3){
                    temp3[l]=i;
                    l++;
                }
                bubbleSort(temp1);
                bubbleSort(temp2);
                bubbleSort(temp3);
                System.out.println("Queue 1");
                for (String i: temp1){
                    if (!i.equals("Available")) {
                        System.out.println(i);
                    }
                }
                System.out.println("Queue 2");
                for (String i: temp2){
                    if (!i.equals("Available")) {
                        System.out.println(i);
                    }
                }
                System.out.println("Queue 3");
                for (String i: temp3){
                    if (!i.equals("Available")) {
                        System.out.println(i);
                    }
                }
            } else if (choice.equals("106") || choice.equals("SPD")) {
                part6();

            } else if (choice.equals("107") || choice.equals("LPD")) {
                part7();

            } else if (choice.equals("108") || choice.equals("STK")) {
                System.out.println(burgerCount+" burgers available");

            } else if (choice.equals("109") || choice.equals("EXT")) {
                try {
                    Scanner add = new Scanner(System.in);
                    System.out.print("How Many Burgers Do You Wanna Add? :");
                    int count = add.nextInt();
                    burgerCount += count;
                    System.out.println(burgerCount + " burgers are now available in stock ");
                } catch (Exception e){
                    System.out.println("Invalid input");
                }

            } else if (choice.equals("999") || choice.equalsIgnoreCase("EXT")) {
                System.exit(0);

            } else {
                System.out.println("Invalid Input");
            }

            }
        }
    }
