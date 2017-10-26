/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n1_threads_sync;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Valon
 */
public class Bank {

    static Logger LOG = LogManager.getLogger(Bank.class);
    private List<BankAccount> sourceBankAccounts = new ArrayList();
    private List<BankAccount> targetBankAccounts = new ArrayList();
    private int amount = 0;
    private int numberOfTransactions = 1;

    public Bank(final int amount, final int numberOfTransactions) {
        this.amount = amount;
        this.numberOfTransactions = numberOfTransactions;
        this.sourceBankAccounts.add(new BankAccount(200));
        this.sourceBankAccounts.add(new BankAccount(200));
        this.sourceBankAccounts.add(new BankAccount(200));
        this.sourceBankAccounts.add(new BankAccount(200));
        this.sourceBankAccounts.add(new BankAccount(200));
        this.sourceBankAccounts.add(new BankAccount(200));
        this.sourceBankAccounts.add(new BankAccount(200));
        this.sourceBankAccounts.add(new BankAccount(200));
    }

    public void StartTransfer() {
        int circlesNumber = this.numberOfTransactions * this.sourceBankAccounts.size();
        final Thread[] threads = new Thread[circlesNumber * 2];
        int amountPerTransaction = amount / numberOfTransactions;
        for (int i = 0; i < this.sourceBankAccounts.size(); i++) {

            for (int j = 0; j < numberOfTransactions; j++) {
                threads[j + (i * numberOfTransactions)] = new Thread(new AccountTask(this.sourceBankAccounts.get(i), this.targetBankAccounts.get(i), amountPerTransaction));
                threads[j + (i * numberOfTransactions) + circlesNumber] = new Thread(new AccountTask(this.targetBankAccounts.get(i), this.sourceBankAccounts.get(i), amountPerTransaction));
            }
        }
        for (final Thread thread : threads) {
            thread.start();
        }

    }

    public List<BankAccount> getSourceAccounts() {
        return this.sourceBankAccounts;
    }

    public List<BankAccount> getTargetAccount() {
        return this.targetBankAccounts;
    }

}
