package com.atm;

public class Account {
    
    private static String accountNumber, pin, availableBalance; //Account Number is 8 digits, PIN is 4 digits

    public Account(String accountNumber2, String pin2, String balance2) {
        accountNumber = Cryptography.encrypt(accountNumber2);
        pin = Cryptography.encrypt(pin2);
        availableBalance = balance2;
    }

    public static boolean verifyPin(String pin2) {
        return pin.equals(Cryptography.encrypt(pin2));
    }

    public static boolean checkAccountNumber(String accountNumber2) {
        return accountNumber.equals(Cryptography.encrypt(accountNumber2));
    }

    public static void setBalance(double availableBalance2) {
        availableBalance = Double.toString(availableBalance2);
    }

    public static void setPin(String pin2) {
        pin = Cryptography.encrypt(pin2);
    }

    public static double getBalance(String accountNumber2, String pin2) {
        if (checkAccountNumber(accountNumber2) && verifyPin(pin2)) {
            return Double.parseDouble(availableBalance);
        } else {
            return -1;
        }
    }

    public static boolean withdraw(String accountNumber2, String pin2, double amount) {
        if (checkAccountNumber(accountNumber2) && verifyPin(pin2)) {
            double balance = Double.parseDouble(availableBalance);
            if (balance >= amount) {
                balance -= amount;
                availableBalance = Double.toString(balance);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean deposit(String accountNumber2, String pin2, double amount) {
        if (checkAccountNumber(accountNumber2) && verifyPin(pin2)) {
            double balance = Double.parseDouble(availableBalance);
            balance += amount;
            availableBalance = Double.toString(balance);
            return true;
        } else {
            return false;
        }
    }

}
