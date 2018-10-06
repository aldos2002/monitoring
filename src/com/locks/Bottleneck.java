package com.locks;

/**
 * Created by admin
 * on 06.10.2018.
 */
public class Bottleneck {
    static class Spoon {
        public synchronized void passBottleneck(String threadName) {

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(String.format("%s has eaten!", threadName));
            }
        }
    }

    static class Diner {
        private String name;

        Diner(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void passBottleneck(Spoon spoon, String threadName) {
            spoon.passBottleneck(threadName);
        }
    }

    public static void main(String[] args) {
        final Spoon s = new Spoon();

        for (int i = 0; i < 100; i++) {
            final Diner husband = new Diner(String.format("thread%s", i));
            new Thread(new Runnable() {
                public void run() {
                    husband.passBottleneck(s, husband.getName());
                }
            }).start();
        }
    }
}