package com.example.asus.rome.dome;

import android.graphics.Color;
import android.util.Log;

import com.example.asus.rome.framework.FMXGame;
import com.example.asus.rome.framework.FMXGraphics;
import com.example.asus.rome.framework.FMXImage;
import com.example.asus.rome.framework.FMXInput;
import com.example.asus.rome.framework.FMXScreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class runhorse02 extends FMXScreen {
    private FMXImage floor02, finline;
    private FMXImage[] horse = new FMXImage[10];
    private double rrr, floorsie, linesie, delauy, floorsiez = 1100, distance = 11000, floornekoya, s, v, t, tsst, fff;
    private int y = constan.SCREEN_WIDTH, horsew = 138, horseh = 104, cnn = 0;
    private int bounds = 100, aasd;
    private int[] controlrun = new int[10], x = new int[10], runframeH = new int[10];
    private int[][] runfix = new int[10][10];
    boolean test = true;
    private float[] tall = new float[10];
    private double[] speedhorse = new double[10];
    private double[] testhorseT = new double[10], testhorseT2 = new double[10], testhorseT3 = new double[10], testhorseT4 = new double[10], testhorseT5 = new double[10], testhorseT6 = new double[10], testhorseT7 = new double[10], testhorseT8 = new double[10], testhorseT9 = new double[10], testhorseT10 = new double[10];
    private Random random = new Random();

    public runhorse02(FMXGame game) {
        super(game);

        FMXGraphics g = game.getGraphics();
        floor02 = g.newImage("floorrun2.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[0] = g.newImage("horse01.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[1] = g.newImage("horse02.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[2] = g.newImage("horse03.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[3] = g.newImage("horse04.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[4] = g.newImage("horse05.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[5] = g.newImage("horse06.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[6] = g.newImage("horse07.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[7] = g.newImage("horse08.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[8] = g.newImage("horse09.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[9] = g.newImage("horse010.png", FMXGraphics.ImageFormat.ARGB4444);
        finline = g.newImage("line.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.winners = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            constan.winners.add(i);
        }

        Collections.shuffle(constan.winners);
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < runfix[i].length; j++) {
//                runfix[i][j] = random.nextInt(bounds) + 200;
//                Log.i("runfixa" + i, "runhorse" + j + ": " + runfix[i][j]);
//            }
//        }
//        controlrun[0]=600;
//        controlrun[1]=450;
//        controlrun[2]=480;
//
//
//        for (int i = 0; i <speedhorse.length ; i++) {
//            speedhorse[i]=0;
//        }
//        bounds=70;
//        for (int i = 0; i < testhorseT.length; i++) {
//            v=random.nextInt(bounds)+100;
//            testhorseT[i]=v/1000;
//            Log.i("testhorseT", "runhorse02: "+testhorseT[i]);
//            tall[0]+=v/1000;
//        }
//
//        for (int i = 0; i < testhorseT2.length; i++) {
//            v=random.nextInt(bounds)+100;
//            testhorseT2[i]=v/1000;
//            Log.i("testhorseT", "runhorse02: "+ testhorseT2[i]);
//            tall[1]+=v/1000;
//        }
//
//        for (int i = 0; i < testhorseT3.length; i++) {
//            v=random.nextInt(bounds)+100;
//            testhorseT3[i]=v/1000;
//            Log.i("testhorseT", "runhorse02: "+testhorseT3[i]);
//            tall[2]+=v/1000;
//        }
//
//        for (int i = 0; i < testhorseT4.length; i++) {
//            v=random.nextInt(bounds)+100;
//            testhorseT4[i]=v/1000;
//            Log.i("testhorseT", "runhorse02: "+testhorseT4[i]);
//            tall[3]+=v/1000;
//        }
//
//        for (int i = 0; i < testhorseT5.length; i++) {
//            v=random.nextInt(bounds)+100;
//            testhorseT5[i]=v/1000;
//            Log.i("testhorseT", "runhorse02: "+testhorseT5[i]);
//            tall[4]+=v/1000;
//        }
//
//        for (int i = 0; i < testhorseT6.length; i++) {
//            v=random.nextInt(bounds)+100;
//            testhorseT6[i]=v/1000;
//            Log.i("testhorseT", "runhorse02: "+testhorseT6[i]);
//            tall[5]+=v/1000;
//        }
//
//        for (int i = 0; i < testhorseT7.length; i++) {
//            v=random.nextInt(bounds)+100;
//            testhorseT7[i]=v/1000;
//            Log.i("testhorseT", "runhorse02: "+testhorseT7[i]);
//            tall[6]+=v/1000;
//        }
//
//        for (int i = 0; i < testhorseT8.length; i++) {
//            v=random.nextInt(bounds)+100;
//            testhorseT8[i]=v/1000;
//            Log.i("testhorseT", "runhorse02: "+testhorseT8[i]);
//            tall[7]+=v/1000;
//        }
//
//        for (int i = 0; i < testhorseT9.length; i++) {
//            v=random.nextInt(bounds)+100;
//            testhorseT9[i]=v/1000;
//            Log.i("testhorseT", "runhorse02: "+testhorseT9[i]);
//            tall[8]+=v/1000;
//        }
//
//        for (int i = 0; i < testhorseT10.length; i++) {
//            v=random.nextInt(bounds)+100;
//            testhorseT10[i]=v/1000;
//            Log.i("testhorseT", "runhorse02: "+testhorseT10[i]);
//            tall[9]+=v/1000;
//        }
//
//        Log.i("ssssss", "iiiiiiiiii" + tall[0] + "/" + tall[1] + "/" + tall[2] + "/" + tall[3] + "/" + tall[4] + "/" + tall[5] + "/" + tall[6] + "/" + tall[7] + "/" + tall[8] + "/" + tall[9]);
        oneSTop();

    }

    @Override
    public void update(float deltaTime) {
        if (speedhorse[0] < distance - 70) {

            delauy += deltaTime * 0.01;
            if (delauy > 2)
                runset2(deltaTime);

//                runset(deltaTime);
            finish(deltaTime);
            /////////////////////////////////////Floor
            if (constan.SCREEN_HEIGHT - floorsie < -1100) {
                floorsie = 0;
            }
            if (constan.SCREEN_HEIGHT - floorsiez < -1100) {
                floorsiez = 0;
            }
            //////////////////////////////////////End Flor

        }
        checkTouch();

    }


    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.clearScreen(Color.BLACK);
        g.drawImage(floor02, (int) (constan.SCREEN_HEIGHT - floorsie), constan.SCREEN_WIDTH - 187);
        g.drawImage(floor02, (int) (constan.SCREEN_HEIGHT - floorsiez), constan.SCREEN_WIDTH - 187);
        Log.i("sdfdsadf", "update: " + (distance - linesie));

        g.drawImage(finline, (int) (distance - linesie), constan.SCREEN_WIDTH - 187);
        for (int i = 0; i < horse.length; i++) {
            g.drawImage(horse[i], (int) (speedhorse[i] - floornekoya) - 80, constan.SCREEN_WIDTH - 104 - 18 * (9 - i), 138 * runframeH[i], 0, 138, 104);
        }
    }
    private double[][] speed=new double[10][10],u=new double[10][10];
    private double[][] a=new double[10][10];
    private int jay,bboy=50;
    private double ticks;
    public void runset(Float deltaTime) {
        for (int i = 0; i < runframeH.length; i++) {
            rrr += deltaTime * 0.01 * controlrun[i] / 100;
            runframeH[i] = (int) (rrr % 4);
        }
        fff += deltaTime * 0.01 ;

        if (fff > 5 && aasd < 9) {
            aasd++;
            Log.i("asdfs", "runset: "+aasd);
            fff=0;
        }

        for (int i = 0; i < 10; i++) {
            speedhorse[i] += deltaTime * 0.01 * runfix[i][aasd];
//            speedhorse[i]+= deltaTime*0.01* controlrun[i];
            if (speedhorse[i] - floornekoya >= constan.SCREEN_HEIGHT / 2) {
                floorsie += deltaTime * 0.01 *  runfix[i][aasd];
                floorsiez += deltaTime * 0.01 *  runfix[i][aasd];
                floornekoya += deltaTime * 0.01 *  runfix[i][aasd];
                linesie += deltaTime * 0.01 *  runfix[i][aasd];
            }
        }
    }
    private void oneSTop() {
        for (int i = 0; i <speed.length ; i++) {
            for (int j = 0; j <speed[i].length ; j++) {
                v=random.nextInt(bboy)+100;
                speed[i][j]= (v/10000);
//            tall[0]+=v/1000;
//                Log.i("V Speed["+i+"]["+j+"]", "oneSTop: "+speed[i][j]);
//                Log.i("U Speed["+i+"]["+j+"]", "oneSTop: "+u[i][j]);
            }
        }
        for (int i = 0; i <u.length ; i++) {
            for (int j = 1; j <u[i].length ; j++) {
                u[i][j]= speed[i][j-1];
//            tall[0]+=v/1000;
//                Log.i("V Speed["+i+"]["+j+"]", "oneSTop: "+speed[i][j]);
//                Log.i("U Speed["+i+"]["+j+"]", "oneSTop: "+u[i][j]);
            }
            u[i][0]=0;
        }
        for (int i = 0; i <speed.length ; i++) {
            for (int j = 0; j <speed[i].length ; j++) {
//            tall[0]+=v/1000;
                a[i][j]=speed[i][j]-u[i][j];
                Log.i("U Speed["+i+"]["+j+"]", "oneSTop: "+u[i][j]);
                Log.i("V Speed["+i+"]["+j+"]", "oneSTop: "+speed[i][j]);
                Log.i("A Speed["+i+"]["+j+"]", "oneSTop: "+a[i][j]);
            }
        }
    }
    private void runset2(float deltaTime) {
        if (ticks>=1&&jay<9) {
            jay++;
            ticks=0;
            Log.i("lijsadf", "runset2: "+jay);
        }
        ticks+=deltaTime*0.01;
        if (jay<=9)
        for (int i = 0; i <speed.length ; i++) {
//                speedhorse[i]+=deltaTime*speed[i][jay]*500;
                speedhorse[i]+=deltaTime*a[i][jay]*500;
//            runframeH[i]= (int) (speedhorse[i]%4);
            if (speedhorse[i]-floornekoya>=constan.SCREEN_HEIGHT/2) {
                floornekoya +=deltaTime*speed[i][jay]*500;
                floorsie += deltaTime * speed[i][jay] * 500;
                floorsiez += deltaTime * speed[i][jay] * 500;
            }
        }
    }

    public void finish(Float deltaTime) {

    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {

    }

    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);
            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN) {

                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2, 0, constan.SCREEN_WIDTH / 2, constan.SCREEN_HEIGHT / 2)) {
                    Log.i("sdsdg", "checkTouch: ");
                }
                if (dome.inBounds(event, 0, 0, constan.SCREEN_WIDTH / 2, constan.SCREEN_HEIGHT / 2)) {
                    Log.i("sadgsdg", "checkTouch: ");
                }

            }
        }
    }
}
