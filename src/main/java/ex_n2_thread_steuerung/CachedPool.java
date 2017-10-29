/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n2_thread_steuerung;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Valon
 */
public class CachedPool {

    private static final Logger LOG = LogManager.getLogger(CachedPool.class);

    public static void main(String[] args) {
        //Obtain a cached thread pool
        ExecutorService cachedPool = Executors.newCachedThreadPool();

        //create an anonymous Callable<T> object.
        //you ned to override the calld() method
        Callable<String> aCallable;
        aCallable = new Callable<String>() {
            String message = "Callable is done!";

            @Override
            public String call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    LOG.info("Callabe is doing something");
                    Thread.sleep(500);
                }
                return message;
            }

        };
        Runnable aRunnable;
        aRunnable = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    LOG.info("Runnable is doing something");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {

            }
        };

        Future<String> callableFuture = cachedPool.submit(aCallable);
        Future<?> runnableFuture = cachedPool.submit(aRunnable);

        if (callableFuture.isDone()) {
            LOG.info("Callable is done!");
        } else {
            LOG.info("Callable is not done!");
        }
        if (runnableFuture.isDone()) {
            LOG.info("Runnable is done");
        } else {
            LOG.info("Runnable is not done");
        }
        try {
            String returnedValue = callableFuture.get();
            LOG.info(returnedValue);
        } catch (InterruptedException | ExecutionException ex) {
        }
        cachedPool.shutdown();

    }

}
