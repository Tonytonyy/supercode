package com.code.multithreading;
 public class TicketOffice implements Runnable {
    int ticketNum = 100;
    Thread thread;
      public void buy(){
          synchronized (TicketOffice.class){
              while (ticketNum > 0){
                  ticketNum --;
                  System.out.println(thread.toString() + " 当前票数 ："  +ticketNum);

              }
          }


    }


    @Override
    public void run() {
        buy();
    }

    public void startBuy(){
        if (thread == null){
            thread = new Thread(this);
            thread.start();
        }

    }
}
