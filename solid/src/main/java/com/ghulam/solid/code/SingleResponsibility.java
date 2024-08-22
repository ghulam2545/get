package com.ghulam.solid.code;


import java.util.List;

// violation
class WSavingAccount {
    private String accountNumber;
    private String customerName;
    private List<String> transactions;

    // more public methods

    // and
    public void statementPrinter(List<String> transactions) {
        // logic for printing
    }
}

/** ******************************************************************* */

class SavingAccount {
    private String accountNumber;
    private String customerName;
    private List<String> transactions;

    // more public methods
}

class StatementPrinter {
    List<String> transaction;

    public void print() {
        // logic for printing
    }
}

public class SingleResponsibility {
    public static void main(String[] args) {

    }
}
