package com.github.jetqin.sychronized;

/**
 * Created by jet on 16/6/8.
 */
public class SychronizedMain
{
    public static void main(String[] args)
    {
//        Account account = new Account();
//        account.setBalance(1000);
//
//        Company company = new Company(account);
//        Thread companyThread = new Thread(company);
//
//        Bank bank = new Bank(account);
//        Thread bankThread = new Thread(bank);
//        System.out.printf("Account : Initial Balance: %f\n", account.getBalance());
//
//        companyThread.start();
//        bankThread.start();
//
//        try
//        {
//            companyThread.join();
//            bankThread.join();
//            System.out.printf("Account : Final Balance: %f\n", account.
//                    getBalance());
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }

        EventStorage storage=new EventStorage();
        Producer producer=new Producer(storage);
        Thread thread1=new Thread(producer);
        Consumer consumer=new Consumer(storage);
        Thread thread2=new Thread(consumer);
        thread2.start();
        thread1.start();
    }
}
