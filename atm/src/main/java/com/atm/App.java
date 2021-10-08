package com.atm;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {
        mainMenu();
    }

    //═   ╠   ║   ╔	╗	╚	╝ 

    public static void mainMenu() {
        int choice = 0;

        clearScreen();
        System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
        System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "        Welcome to ATM." + Color.TEXT_GREEN + "        ║");
        System.out.println(Color.TEXT_GREEN + "╠═══════════════════════════════╣");
        System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + " 1. Login" + Color.TEXT_GREEN + "                      ║");
        System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + " 2. Register" + Color.TEXT_GREEN + "                   ║");
        System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + " 3. Exit" + Color.TEXT_GREEN + "                       ║");
        System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
        System.out.print(Color.TEXT_GREEN + "Enter your choice: " + Color.TEXT_WHITE);
        choice = TextIO.getlnInt();

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "    Thank you for using ATM" + Color.TEXT_GREEN + "    ║");
                System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                break;
            default:
                System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "         Invalid choice" + Color.TEXT_GREEN + "            ║");
                System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                mainMenu();
                break;
        }
    }

    public static void login() {

        String accountNumber, newPin;
        int choice;
        double amount, amount2;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        clearScreen();
        System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
        System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "             Login" + Color.TEXT_GREEN + "             ║");
        System.out.println(Color.TEXT_GREEN + "╠═══════════════════════════════╣");
        System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + " Enter Account Number:" + Color.TEXT_GREEN + "         ║");
        System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
        accountNumber = TextIO.getlnString();
        if (!Account.checkAccountNumber(accountNumber)) {
            System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "         Account not found" + Color.TEXT_GREEN + "        ║");
            System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
            mainMenu();
        } else {
            System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + " Enter PIN:" + Color.TEXT_GREEN + "                    ║");
            System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
            String pin = TextIO.getlnString();
            if (!Account.verifyPin(pin)) {
                System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "         Wrong PIN" + Color.TEXT_GREEN + "            ║");
                System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                mainMenu();
            } else {
                System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "             Welcome" + Color.TEXT_GREEN + "           ║");
                System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                wait(1000);
                while(true) {
                    clearScreen();
                    System.out.println(Color.TEXT_GREEN + "╔══════════╗     ╔═════╗     ╔══════════╗");
                    System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_RED + " (0) Exit " + Color.TEXT_GREEN + "╠═════╣ " + Color.TEXT_CYAN + "ATM" + Color.TEXT_GREEN + " ╠═════╣ " + Color.TEXT_RED + dtf.format(now) + Color.TEXT_GREEN + " ║");
                    System.out.println(Color.TEXT_GREEN + "╚══════════╝     ╚═════╝     ╚══════════╝");
                    System.out.println(Color.TEXT_GREEN + "    ╔═══════════════════════════════╗");
                    System.out.println(Color.TEXT_GREEN + "    ║" + Color.TEXT_WHITE + " 1. Balance" + Color.TEXT_GREEN + "                    ║");
                    System.out.println(Color.TEXT_GREEN + "    ║" + Color.TEXT_WHITE + " 2. Withdraw" + Color.TEXT_GREEN + "                   ║");
                    System.out.println(Color.TEXT_GREEN + "    ║" + Color.TEXT_WHITE + " 3. Deposit" + Color.TEXT_GREEN + "                    ║");
                    System.out.println(Color.TEXT_GREEN + "    ║" + Color.TEXT_WHITE + " 4. Change PIN" + Color.TEXT_GREEN + "                 ║");
                    System.out.println(Color.TEXT_GREEN + "    ╚═══════════════════════════════╝");
                    
                    choice = TextIO.getInt();
                    switch (choice) {
                        case 0:
                            System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "    Thank you for using ATM" + Color.TEXT_GREEN + "    ║");
                            System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                            mainMenu();
                        case 1:
                            clearScreen();
                            System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "            Balance" + Color.TEXT_GREEN + "            ║");
                            System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                            System.out.println(Color.TEXT_GREEN + Color.TEXT_WHITE + "             $" + Account.getBalance(accountNumber, pin) + Color.TEXT_GREEN);
                            wait(3000);
                            break;
                        case 2:
                            clearScreen();
                            System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "             Withdraw" + Color.TEXT_GREEN + "          ║");
                            System.out.println(Color.TEXT_GREEN + "╠═══════════════════════════════╣");
                            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "         Enter amount:" + Color.TEXT_GREEN + "         ║");
                            System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                            amount = TextIO.getDouble();
                            if (Account.withdraw(accountNumber, pin, amount)) {
                                System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                                System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "         Withdraw successful" + Color.TEXT_GREEN + "      ║");
                                System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                                wait(3000);
                            } else {
                                System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                                System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "        Withdraw failed" + Color.TEXT_GREEN + "        ║");
                                System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                                wait(3000);
                            }
                            break;
                        case 3:
                            clearScreen();
                            System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "            Deposit" + Color.TEXT_GREEN + "            ║");
                            System.out.println(Color.TEXT_GREEN + "╠═══════════════════════════════╣");
                            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "         Enter amount:" + Color.TEXT_GREEN + "         ║");
                            System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                            amount2 = TextIO.getDouble();
                            if (Account.deposit(accountNumber, pin, amount2)) {
                                System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                                System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "       Deposit successful" + Color.TEXT_GREEN + "      ║");
                                System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                                wait(3000);
                            } else {
                                System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                                System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "        Deposit failed" + Color.TEXT_GREEN + "         ║");
                                System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                                wait(3000);
                            }
                            break;
                        case 4:
                            clearScreen();
                            System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "          Change PIN" + Color.TEXT_GREEN + "           ║");
                            System.out.println(Color.TEXT_GREEN + "╠═══════════════════════════════╣");
                            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "         Enter new PIN:" + Color.TEXT_GREEN + "        ║");
                            System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                            newPin = TextIO.getlnString();
                            wait(1000);
                            Account account = new Account(accountNumber, newPin, Double.toString(Account.getBalance(accountNumber, pin)));
                                System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                                System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "      Change PIN successful" + Color.TEXT_GREEN + "    ║");
                                System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                                wait(3000);
                            break;
                        default:
                            System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
                            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "         Invalid input" + Color.TEXT_GREEN + "         ║");
                            System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
                            wait(3000);
                            break;
                    }
                }
            }
        }
    }

    public static void register() {

        clearScreen();
        System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
        System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "            Register" + Color.TEXT_GREEN + "           ║");
        System.out.println(Color.TEXT_GREEN + "╠═══════════════════════════════╣");
        System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + " Would you like to register?" + Color.TEXT_GREEN + "   ║");
        System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
        boolean register = TextIO.getlnBoolean();
        if (!register) {
            mainMenu();
        } else {
            System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "      Generating Account..." + Color.TEXT_GREEN + "    ║");
            // create new account with random account number
            // random 8 digit integer: 
            int accountNumber = 0;
            while (countDigit(accountNumber) != 8) {
                accountNumber = (int) (Math.random() * 100000000);
            }
            Account account = new Account(Integer.toString(accountNumber), "0", "0");
            System.out.println(Color.TEXT_GREEN + "╠═══════════════════════════════╣");
            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + "      Account Generated! ✓" + Color.TEXT_GREEN + "     ║");
            System.out.println(Color.TEXT_GREEN + "╠═══════════════════════════════╩═════════════╗");
            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + " (" + Color.TEXT_RED + "!" + Color.TEXT_WHITE + ")" + Color.TEXT_RED + " You must remember your information! " + Color.TEXT_WHITE + "(" + Color.TEXT_RED + "!" + Color.TEXT_WHITE + ")" + Color.TEXT_GREEN + " ║");
            System.out.println(Color.TEXT_GREEN + "╠═══════════════════════════════╦═════════════╝");
            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + " Account Number: " + Color.TEXT_RED + accountNumber + Color.TEXT_GREEN + "      ║");
            System.out.println(Color.TEXT_GREEN + "╠═══════════════════════════════╣");
            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + " Enter PIN: " + Color.TEXT_GREEN + "                   ║");
            System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
            String pin = TextIO.getlnString();
            Account.setPin(pin);
            System.out.println();
            System.out.println(Color.TEXT_GREEN + "╔═══════════════════════════════╗");
            System.out.println(Color.TEXT_GREEN + "║" + Color.TEXT_WHITE + " Account created successfully." + Color.TEXT_GREEN + " ║");
            System.out.println(Color.TEXT_GREEN + "╚═══════════════════════════════╝");
            wait(1000);
            mainMenu();
            

        }
        
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int countDigit(int n) {
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
