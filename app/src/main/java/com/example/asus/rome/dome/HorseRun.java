package com.example.asus.rome.dome;

import android.graphics.Color;
import android.util.Log;

import com.example.asus.rome.framework.FMXGame;
import com.example.asus.rome.framework.FMXGraphics;
import com.example.asus.rome.framework.FMXImage;
import com.example.asus.rome.framework.FMXScreen;

import java.util.Random;

public class HorseRun extends FMXScreen {
    FMXImage floor, line, flor,crowed;
    FMXImage[] horse = new FMXImage[10],ad = new FMXImage[10];
    String numh;
    double runf, DelHorse, gamera,Amez;
    int lenght, SPHorse,radiz=0,conq,pai;
    int[] s = new int[10];
    double[] hp = new double[10];
    Random dis = new Random();

    public HorseRun(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        floor = g.newImage("run/floorrun2.png", FMXGraphics.ImageFormat.ARGB4444);
        flor =g.newImage("run/bg ground.png",FMXGraphics.ImageFormat.ARGB4444);
        lenght = 50;
        line = g.newImage("run/line.png", FMXGraphics.ImageFormat.ARGB4444);
        crowed = g.newImage("run/bg crowd.png", FMXGraphics.ImageFormat.ARGB4444);

        for (int i = 0; i < 10; i++) {
            horse[i] = g.newImage("run/h " + (i + 1) + ".png", FMXGraphics.ImageFormat.ARGB4444);
        }

        for (int i = 0; i < 10; i++) {
            ad[i] = g.newImage("run/bg ad " + (i + 1) + ".png", FMXGraphics.ImageFormat.ARGB4444);
        }
        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j <10 ; j++) {
                s[i] = dis.nextInt(200) + 200;
                Log.i("sdfg", "HorseRun: " + s[i]);
//            }
        }
        oneSTop();
    }
double ss,tjjc;
    @Override
    public void update(float deltaTime) {
        for (int i = 0; i <10 ; i++) {
            s[i]+=deltaTime*(u[radiz][i])*100;
        }
//        s[0]+=deltaTime*deltaV[0][radiz]*200;
//        s[1]+=deltaTime*deltaV[1][radiz]*200;
//        if (floor.getWidth()*lenght-runf>=constan.SCREEN_HEIGHT+10)
//        runf+=deltaTime*0.01*500;
        Amez+=deltaTime*0.01;
        if (Amez>=5&&radiz!=9) {
            radiz++;
            Amez = 0;
        }
//        hp[0] += deltaTime * 0.01 * s[radiz];
//        hp[0] += deltaTime * 0.01 * s[0];
//        hp[1] += deltaTime * 0.01 * s[1];
//        Log.i("goerasdf", "update: "+hp[0]);
        DelHorse += deltaTime * 0.01 * 5;
        SPHorse = (int) (DelHorse % 4);
//        if (hp[0] - gamera > constan.SCREEN_HEIGHT / 2 && floor.getWidth() * lenght - gamera >= constan.SCREEN_HEIGHT + 10)
//            gamera += deltaTime * 0.01 * s[0];
//        if (hp[1] - gamera > constan.SCREEN_HEIGHT / 2 && floor.getWidth() * lenght - gamera >= constan.SCREEN_HEIGHT + 10)
//            gamera += deltaTime * 0.01 * s[1];
        for (int i = 0; i < 10; i++) {
                if (hp[i]- gamera < constan.SCREEN_HEIGHT - 200)
                    hp[i] += deltaTime * 0.01 * s[i];
                if (hp[i] - gamera > constan.SCREEN_HEIGHT / 2 && (flor.getWidth() * lenght) - gamera > constan.SCREEN_HEIGHT + 20)
                    gamera += deltaTime * 0.01 * s[i];
        }
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.drawRectBG(0, 0, constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, Color.GRAY, 255);

        /////floor//////
        for (int i = 0; i < lenght; i++) {
//            g.drawImage(floor, (int) (floor.getWidth() * i - gamera), constan.SCREEN_WIDTH - floor.getHeight());
            if (pai>=10)
                pai=0;
            g.drawImage(flor, (int) (flor.getWidth()*i- gamera),constan.SCREEN_WIDTH - flor.getHeight());
            g.drawImage(ad[pai], (int) (ad[pai].getWidth()*i- gamera),crowed.getHeight());
            g.drawImage(crowed, (int) (crowed.getWidth()*i- gamera),0);
            pai++;
        }
        g.drawImage(line, (int) (flor.getWidth() * lenght - 200 - gamera), constan.SCREEN_WIDTH - line.getHeight());
        /////floor//////^^


        ////Horse//////
        for (int i = 0; i < 10; i++) {
            g.drawImage(horse[i], (int) (hp[i] - gamera), (constan.SCREEN_WIDTH - floor.getHeight() -130) + 25 * i, 138 * SPHorse, 0, 138, 255);
        }
//        g.drawImage(horse[0], (int) (hp[0]-gamera),constan.SCREEN_WIDTH - floor.getHeight()-20,138 * SPHorse, 0, 138, 255);
//        g.drawImage(horse[1], (int) (hp[1]-gamera),constan.SCREEN_WIDTH - floor.getHeight()+20,138 * SPHorse, 0, 138, 255);
        ////Horse////^^^

    }






    private double[][] speed=new double[10][10],u=new double[10][10],a=new double[10][10];
    private double[][] deltaV =new double[10][10];
    private int jay,bboy=5;
    private Random random = new Random();
    private double v;
    private void oneSTop() {
        for (int i = 0; i <speed.length ; i++) {
            for (int j = 0; j <speed[i].length ; j++) {
                v=random.nextInt(bboy);
                speed[i][j]= (v/1000);
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
                deltaV[i][j]=speed[i][j]-u[i][j];
                Log.i("USpeed["+i+"]["+j+"]", "oneSTop: "+u[i][j]);
                Log.i("VSpeed["+i+"]["+j+"]", "oneSTop: "+speed[i][j]);
                Log.i("deltaV["+i+"]["+j+"]", "oneSTop: "+ deltaV[i][j]);
            }
        }
//        for (int i = 0; i <10 ; i++) {
//            for (int j = 0; j <10 ; j++) {
//                a[i][j]=deltaV[i][j]/1000;
//            }
//        }
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
}
