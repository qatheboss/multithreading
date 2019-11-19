package com.company;

public class Main {

    public static void main(String[] args) {
    	// write your code here
        int triangleCount = 1000000;
        int threadCount = 10;

        System.out.println("Generating data");
        double[][] triangles = new double[triangleCount][3];
        double[][] trianglesCopy = new double[triangleCount][3];
        for(int i=0;i<triangleCount;i++) {
            triangles[i][0] = Math.random()*10;
            triangles[i][1] = Math.random()*10;
            trianglesCopy[i][0] = triangles[i][0];
            trianglesCopy[i][1] = triangles[i][1];
        }

        long startMilis;
        long elapsed;

        System.out.println("Begin multithread version");
        startMilis = System.currentTimeMillis();
        for(int i=0;i<10000;i++) {
            Pythag.pythagThread(threadCount, triangles);
        }
        elapsed = System.currentTimeMillis()-startMilis;
        System.out.println("Elapsed multithread time: " + elapsed);

        startMilis = System.currentTimeMillis();
        for(int i=0;i<10000;i++) {
            Pythag.doPythag(0, triangleCount, triangles);
        }
        elapsed = System.currentTimeMillis()-startMilis;
        System.out.println("Elapsed normal time: " + elapsed);

        /*
        for(int i=0;i<5;i++) {
            System.out.printf("%.3f^2 + %.3f^2 = %.3f^2\n", triangles[i][0], triangles[i][1], triangles[i][2]);
        }
        System.out.println("...");
        for(int i=triangleCount-5;i<triangleCount;i++) {
            System.out.printf("%.3f^2 + %.3f^2 = %.3f^2\n", triangles[i][0], triangles[i][1], triangles[i][2]);
        }

         */

        // a b hyp
        // 3 4 ....5
        // 1 1 ....1.414
        //

    }
}
