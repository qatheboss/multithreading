package com.company;


class Pythag {

    public static void doPythag(int start, int end, double[][] data) {
        for(int i=start;i<end;i++) {
            data[i][2] = Math.sqrt(Math.pow(data[i][0], 2) + Math.pow(data[i][1], 2));
        }
    }

    private static class PythagThread implements Runnable {
        private int index;
        private int n;
        private double[][] data;

        public PythagThread(int index, int n, double[][] data) {
            this.index = index;
            this.n = n;
            this.data = data;
        }

        public void run() {
            try {
                // Thread.currentThread().getId()
                int start = data.length*index/n;
                int end = data.length*(index+1)/n;
                if(end > data.length) {
                    end = data.length;
                }
                if(end > start) {
                    doPythag(start, end, data);
                }

            } catch (Exception e) {
                // Throwing an exception
                System.out.println("Exception is caught");
            }
        }
    }

    public static void pythagThread(int n, double[][] data) {

        Thread[] threads = new Thread[n];
        for (int i=0; i<n; i++) {
            Thread object = new Thread(new PythagThread(i, n, data));
            object.start();
            threads[i] = object;
        }

        for(int i=0;i<n;i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }



}
