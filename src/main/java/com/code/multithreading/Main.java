package com.code.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        new Main().runTicketOffice();
    }


    public void runTicketOffice(){
        TicketOffice ticketOffice = new TicketOffice();
        TicketOffice ticketOffice1 = new TicketOffice();
        TicketOffice ticketOffice2 = new TicketOffice();
        ticketOffice.startBuy();
        ticketOffice1.startBuy();
        ticketOffice2.startBuy();

    }

    public void runTicketOfficeByExecut(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            executorService.execute(new TicketOffice());
        }
        executorService.shutdown();

    }
}
