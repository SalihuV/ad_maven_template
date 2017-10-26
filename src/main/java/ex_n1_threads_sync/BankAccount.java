/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n1_threads_sync;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Valon
 */
public final class BankAccount {

    private int balance;
    static Logger LOG = LogManager.getLogger(BankAccount.class);

    public BankAccount(final int balance) {
        this.balance = balance;
    }

    public BankAccount() {
        this(0);
    }

    public int getBalance() {
        return this.balance;

    }

    public void deposite(final int amount) {
        this.balance += amount;
    }
    
    public void transfer(final BankAccount target, final int amount)
    {
        LOG.info("Starting transfer of amout " + amount + " from " + this + " to " + target);
        this.balance -= amount;
        target.deposite(amount);
        LOG.info("Finished transfer. Balance " + this + ": " + this.balance + ". Balance" + target + ": " + target.getBalance());
    }

}
