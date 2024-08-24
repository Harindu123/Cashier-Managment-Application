package com.example.hr_fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;
import java.io.*;

public class FoodQueue extends Application{
    static int burgerCount = 50;
    static String[] cashier1 = {"Available", "Available", "Available", "Available", "Available"};
    static String[] cashier2 = {"Available", "Available", "Available", "Available", "Available"};
    static String[] cashier3 = {"Available", "Available", "Available", "Available", "Available"};
    static String[] waiting = {"Available", "Available", "Available", "Available", "Available", "Available", "Available", "Available"};
    static int q1income = 0;
    static int q2income = 0;
    static int q3income = 0;

    //run in a different tread https://stackoverflow.com/a/76501882/15515954
    @Override
    public void start(Stage stage) {
        Platform.setImplicitExit(false);
        Thread cliThread = new Thread(this::runCLI);
        cliThread.start();
    }

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

    public static int getMin(Integer[] inputArray){
        int minValue = inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
            }
        }
        return minValue;
    }
    // Adding customer to Queue
    static void part3() {
        int queue1Size = 0;
        int queue2Size = 0;
        int queue3Size = 0;
        for (String i : cashier1) {
            if (!i.equals("Available")) {
                queue1Size++;
            }
        }
        for (String i : cashier2) {
            if (!i.equals("Available")) {
                queue2Size++;
            }
        }
        for (String i : cashier3) {
            if (!i.equals("Available")) {
                queue3Size++;
            }
        }
        String index;
        if ((queue1Size <= queue2Size) && (queue1Size < 2)) {
            if (queue1Size <= queue3Size) {
                //adding to queue 1
                index = "1";

            } else {
                //adding to queue 3
                index = "3";
            }
        } else {
            if (queue3Size <= queue2Size && queue3Size < 5) {
                //adding to queue 3
                index = "3";
            } else {
                if (queue2Size < 3) {
                    //adding to queue 2
                    index = "2";

                } else {
                    if (queue3Size < 5) {
                        //adding to queue 3
                        index = "3";
                    } else {
                        //adding to waiting list
                        index = "4";
                    }
                }
            }
        }
        if (index.equals("1") && cashier1[1].equals("Available")) {
            System.out.print("\nEnter Customer 1st Name :");
            Scanner cusName1 = new Scanner(System.in);
            String custName1 = cusName1.nextLine();
            System.out.print("\nEnter Customer 2nd Name :");
            Scanner cusName2 = new Scanner(System.in);
            String custName2 = cusName2.nextLine();
            int brg;
            while (true){
                try {
                    System.out.print("\nEnter Burgers :");
                    Scanner cusName = new Scanner(System.in);
                    brg = cusName.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("invalid input");
                }
            }
            Customer customer = new Customer(custName1, custName2, brg);
            int j = 0;
            for (String i : cashier1) {
                if (i.equals("Available")) {
                    cashier1[j] = String.valueOf(customer);
                    break;
                } else {
                    j++;
                }
            }
        } else if (index.equals("2") && cashier2[2].equals("Available")) {
            System.out.print("\nEnter Customer 1st Name :");
            Scanner cusName1 = new Scanner(System.in);
            String custName1 = cusName1.nextLine();
            System.out.print("\nEnter Customer 2nd Name :");
            Scanner cusName2 = new Scanner(System.in);
            String custName2 = cusName2.nextLine();
            int brg;
            while (true){
                try {
                    System.out.print("\nEnter Burgers :");
                    Scanner cusName = new Scanner(System.in);
                    brg = cusName.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("invalid input");
                }
            }
            Customer customer = new Customer(custName1, custName2, brg);
            int j = 0;
            for (String i : cashier2) {
                if (i.equals("Available")) {
                    cashier2[j] = String.valueOf(customer);
                    break;
                } else {
                    j++;
                }
            }
        } else if (index.equals("3") && cashier3[4].equals("Available")) {
            System.out.print("\nEnter Customer 1st Name :");
            Scanner cusName1 = new Scanner(System.in);
            String custName1 = cusName1.nextLine();
            System.out.print("\nEnter Customer 2nd Name :");
            Scanner cusName2 = new Scanner(System.in);
            String custName2 = cusName2.nextLine();
            int brg;
            while (true){
                try {
                    System.out.print("\nEnter Burgers :");
                    Scanner cusName = new Scanner(System.in);
                    brg = cusName.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("invalid input");
                }
            }
            Customer customer = new Customer(custName1, custName2, brg);
            int j = 0;
            for (String i : cashier3) {
                if (i.equals("Available")) {
                    cashier3[j] = String.valueOf(customer);
                    break;
                } else {
                    j++;
                }
            }
        } else if (index.equals("4") && waiting[7].equals("Available")){
            System.out.println("All Queues are full this customer will be added to the waiting list");
            System.out.print("\nEnter Customer 1st Name :");
            Scanner cusName1 = new Scanner(System.in);
            String custName1 = cusName1.nextLine();
            System.out.print("\nEnter Customer 2nd Name :");
            Scanner cusName2 = new Scanner(System.in);
            String custName2 = cusName2.nextLine();
            System.out.print("\nEnter Burgers :");
            Scanner cusName = new Scanner(System.in);
            int brg = cusName.nextInt();
            Customer customer = new Customer(custName1, custName2, brg);
            int j = 0;
            for (String i : cashier3) {
                if (i.equals("Available")) {
                    waiting[j] = String.valueOf(customer);
                    break;
                } else {
                    j++;
                }
            }
        } else {
            System.out.println("All Queues are full.");
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
        try {
            while (true){
                System.out.print("\nEnter Queue Number : ");
                Scanner pos1 = new Scanner(System.in);
                String position1 = pos1.nextLine();
                if (position1.equals("1")) {
                    if (!cashier1[0].equals("Available")){
                        String[] queueValues = cashier1[0].split(":");
                        try {
                            for (int i = 0; i < 2; i++) {
                                cashier1[i] = cashier1[i + 1];
                            }
                            int cBurg = Integer.parseInt(queueValues[2]);
                            burgerCount = burgerCount - cBurg;
                            q1income += cBurg;
                            break;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            cashier1[1] = "Available";
                        }
                    } else {
                        System.out.println("queue is empty");
                        break;
                    }

                } else if (position1.equals("2")) {
                    if (!cashier2[0].equals("Available")){
                        String[] queueValues = cashier2[0].split(":");
                        try {
                            for (int i = 0; i < 3; i++) {
                                cashier2[i] = cashier2[i + 1];
                            }
                            int cBurg = Integer.parseInt(queueValues[2]);
                            burgerCount = burgerCount - cBurg;
                            q2income += cBurg;
                            break;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            cashier2[2] = "Available";
                        }
                    } else {
                        System.out.println("queue is empty");
                        break;
                    }

                } else if (position1.equals("3")) {
                    if (!cashier3[0].equals("Available")){
                        String[] queueValues = cashier3[0].split(":");
                        try {
                            for (int i = 0; i < 5; i++) {
                                cashier3[i] = cashier3[i + 1];
                            }
                            int cBurg = Integer.parseInt(queueValues[2]);
                            burgerCount = burgerCount - cBurg;
                            q3income += cBurg;
                            break;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            cashier3[4] = "Available";
                            break;
                        }
                    } else {
                        System.out.println("queue is empty");
                        break;
                    }
                } else {
                    System.out.println("invalid input");
                }
            }


        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
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

    public void runCLI() {

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
                    110 or IFQ: View Income of each Queues
                    112 or GUI: Open GUI.
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

            } else if (choice.equals("109") || choice.equals("AFS")) {
                try {
                    Scanner add = new Scanner(System.in);
                    System.out.print("How Many Burgers Do You Want to Add? :");
                    int count = add.nextInt();
                    burgerCount += count;
                    System.out.println(burgerCount + " burgers are now available in stock ");
                } catch (Exception e){
                    System.out.println("Invalid input");
                }

            }else if (choice.equals("110") || choice.equals("IFQ")) {
                System.out.println("Income of the queue 1 is - "+(q1income*650));
                System.out.println("Income of the queue 2 is - "+(q2income*650));
                System.out.println("Income of the queue 3 is - "+(q3income*650));

            } else if (choice.equals("112") || choice.equals("GUI")) {
                Platform.runLater(this::showGUI);

            }else if (choice.equals("999") || choice.equalsIgnoreCase("EXT")) {
                System.exit(0);

            } else {
                System.out.println("Invalid Input");
            }

        }
    }
    //GUI
    private Stage stage;
    private void showGUI() {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FoodQueue.class.getResource("hello-view.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 720);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }


    //main method
    public static void main(String[] args) {
        Application.launch();
    }
}
class Customer {
    String fName;
    String sureName;
    int burgers;
    public Customer(String fstName, String sndName, int burg){
        this.fName = fstName;
        this.sureName = sndName;
        this.burgers = burg;
    }

    @Override
    public String toString() {
        return fName + ":" + sureName + ":" + burgers;
    }
}