package com.example.asus.rome.dome;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;

import com.example.asus.rome.framework.FMXGame;
import com.example.asus.rome.framework.FMXGraphics;
import com.example.asus.rome.framework.FMXImage;
import com.example.asus.rome.framework.FMXInput;
import com.example.asus.rome.framework.FMXScreen;

import java.util.List;

public class Select extends FMXScreen {
    private FMXImage background, bet1, bet2, bet3, bt1, bt2, bt3;
    public int mCurrentScreen = 0, egick, showset = 0, setnum = 0, isClick = 0, s = 1;
    private double din01, din02, din03, gick, alphanox,arrowdin;
    private boolean canT = true;
    Paint paint = new Paint(), paintsa = new Paint();
    public Select(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        bt1 = g.newImage("main/mode1.png", FMXGraphics.ImageFormat.ARGB4444);
        bt2 = g.newImage("main/mode2.png", FMXGraphics.ImageFormat.ARGB4444);
        bt3 = g.newImage("main/mode3.png", FMXGraphics.ImageFormat.ARGB4444);
        paint.setColor(Color.WHITE);
        paint.setTextSize(13);
        paint.setTypeface(Typeface.create("Comic Sans MS", Typeface.NORMAL));
        paintsa.setColor(Color.WHITE);
        paintsa.setTextSize(20);
        paintsa.setTypeface(Typeface.create("Comic Sans MS", Typeface.NORMAL));
    }

    @Override
    public void update(float deltaTime) {
        gick += deltaTime * 0.01 * 10;
        egick = (int) (gick % 5);

        checkTouch();
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();

        g.drawImage(constan.mainbg, 0, 0);
        g.drawImage(bt1, constan.SCREEN_HEIGHT / 2 - 398, constan.SCREEN_WIDTH / 2 - 173, (int) (256 * egick), 0, 256, 385);
        g.drawImage(bt2, constan.SCREEN_HEIGHT / 2 - 136, constan.SCREEN_WIDTH / 2 - 173, (int) (256 * egick), 0, 256, 385);
        g.drawImage(bt3, constan.SCREEN_HEIGHT / 2 + 126, constan.SCREEN_WIDTH / 2 - 173, (int) (256 * egick), 0, 256, 385);
        g.drawImage(constan.ibg, constan.SCREEN_HEIGHT - 60, 5, 48, 0, 48, 48);
        g.drawImage(constan.lal, 10, 10);
        g.drawImage(constan.lal, 170, 10);
        g.drawString("" + constan.user, 70, 30, paint);
        g.drawString("Credit : " + constan.credit, 180, 30, paint);
        g.drawImage(constan.ibg, 0, 0, 0, 0, 48, 48);

        if (showset == 1) {
            Lotus(g,deltaTime);
        }
        if (isClick == 1)
            swScreen(g, deltaTime);
    }

    public void Lotus(FMXGraphics g,Float deltaTime) {
        if (setnum == 0)
            g.drawRectBG(0, 0, constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, Color.BLACK, 120);
        g.drawImage(constan.ibg, constan.SCREEN_HEIGHT - 60, 5, 48, 0, 48, 48);
        g.drawImage(constan.setBot, constan.SCREEN_HEIGHT - 55, 58, 0, 0, 38, 38);//i
        g.drawImage(constan.setBot, constan.SCREEN_HEIGHT - 55, 103, 38 * s, 0, 38, 38);//sound
        g.drawImage(constan.setBot, constan.SCREEN_HEIGHT - 55, 103 + 45, 38 * 3, 0, 38, 38);//back
        g.drawImage(constan.setBot, constan.SCREEN_HEIGHT - 55, 103 + 45 * 2, 38 * 4, 0, 38, 38);//close

        if (setnum == 1) {
            arrowdin+=deltaTime*0.01*50;
            g.drawRectBG(0, 0, constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, Color.BLACK, 120);
            g.drawImage(constan.statbtnX, constan.SCREEN_HEIGHT - 170, 20, 59, 0, 59, 38);
            g.drawImage(constan.shpayout, constan.SCREEN_HEIGHT / 2 - 384, 20);
//            g.drawImage(constan.arrow, (int) (17), 222,0,0,40,100);
            g.drawImage(constan.arrow, (int) (constan.SCREEN_HEIGHT-60+arrowdin), 222,40,0,40,100);
            if (arrowdin>=10)
                arrowdin=0;
        } else if (setnum == 2) {
            arrowdin+=deltaTime*0.01*50;
            g.drawRectBG(0, 0, constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, Color.BLACK, 120);
            g.drawImage(constan.statbtnX, constan.SCREEN_HEIGHT - 170, 20, 59, 0, 59, 38);
            g.drawImage(constan.shhowto, constan.SCREEN_HEIGHT / 2 - 384, 20);
            g.drawImage(constan.arrow, (int) (17-arrowdin), 222,0,0,40,100);
//            g.drawImage(constan.arrow, (int) (constan.SCREEN_HEIGHT-60), 222,40,0,40,100);
            if (arrowdin>=10)
                arrowdin=0;
        }

        if (setnum==3){
            g.drawRectBG(0, 0, constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, Color.BLACK, 120);
            g.drawImage(constan.exitAlert,constan.SCREEN_HEIGHT/2-254,constan.SCREEN_WIDTH/2-128);
            g.drawImage(constan.exitBT,constan.SCREEN_HEIGHT/2-150,constan.SCREEN_WIDTH/2+30,0,0,111,48);
            g.drawImage(constan.exitBT,constan.SCREEN_HEIGHT/2+39,constan.SCREEN_WIDTH/2+30,0,48,111,48);
        }
    }


    private void swScreen(FMXGraphics g, float deltaTime) {
        canT = false;
        alphanox += deltaTime * 0.01 * 500;
        g.drawRectBG(0, 0, constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, Color.BLACK, (int) alphanox);
        Log.i("ssdfasdf", "swScreen: " + alphanox);
        if (alphanox >= 245) {
            game.setScreen(new Table(game));

        }
    }

    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);
            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN && canT == true) {
                //Check Touch by area
                //event  //imagepositionX ///imagepositionY ///imagesizeWidth ///imagesizeHeight
                //1
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - 398, constan.SCREEN_WIDTH / 2 - 173, 272, 385) && showset == 0) {
                    constan.price1 = 1;
                    constan.price2 = 5;
                    constan.price3 = 10;
                    constan.price4 = 25;
                    constan.price5 = 50;
                    constan.selectbetroom = 0;
                    constan.maxroom = 90;
                    isClick = 1;
//                        if (mCurrentScreen==1)
//                        game.setScreen(new mode1(game));
                }
                //2
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - 136, constan.SCREEN_WIDTH / 2 - 173, 272, 385) && showset == 0) {
                    constan.price1 = 10;
                    constan.price2 = 25;
                    constan.price3 = 50;
                    constan.price4 = 100;
                    constan.price5 = 500;
                    constan.selectbetroom = 1;
                    constan.maxroom = 900;
                    isClick = 1;
//                        if (mCurrentScreen==1)
//                        game.setScreen(new mode1(game));
                }
                //3
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 + 126, constan.SCREEN_WIDTH / 2 - 173, 272, 385) && showset == 0) {
                    constan.price1 = 25;
                    constan.price2 = 50;
                    constan.price3 = 100;
                    constan.price4 = 500;
                    constan.price5 = 1000;
                    constan.selectbetroom = 2;
                    constan.maxroom = 10000;
                    isClick = 1;
//                        if (mCurrentScreen==1)
//                        game.setScreen(new mode1(game));
                }
                //LOtus
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, +10, 48, 48) && showset == 0) {
                    Log.i("inininin", "checkTouch: ");
                    showset = 1;
                    setnum = 0;
                } else if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, +10, 48, 48) && showset == 1) {
                    Log.i("22222", "checkTouch: ");
                    showset = 0;
                    setnum = 0;
                }
                //i
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 58, 40, 40) && showset == 1 && setnum == 0) {
                    setnum = 1;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 170 + 20, 20, 59, 38) && showset == 1) {
                    setnum = 0;
                }
                //arrow
                if (dome.inBounds(event, 17, 222, 50, 100) && showset == 1 && setnum == 2) {
                    setnum = 1;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT-17, 222, 50, 100) && showset == 1 && setnum == 1) {
                    setnum = 2;
                }

                //sound
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103, 40, 40) && showset == 1 && s == 1) {
                    s = 2;
                } else if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103, 59, 38) && showset == 1 && s == 2) {
                    s = 1;
                }
                //back
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103+45, 40, 40) && showset == 1 && s == 1) {
                    s = 2;
                } else if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103+45, 59, 38) && showset == 1 && s == 2) {
                    s = 1;
                }
                //close
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103+45*2, 40, 40) && showset == 1) {
                    setnum=3;
                }
                if (dome.inBounds(event,constan.SCREEN_HEIGHT/2+39,constan.SCREEN_WIDTH/2+30, 111, 48) && showset == 1&&setnum==3){
                    setnum=0;
                    showset=0;
                }
                if (dome.inBounds(event,constan.SCREEN_HEIGHT/2-150,constan.SCREEN_WIDTH/2+30, 111, 48) && showset == 1&&setnum==3){
                    System.exit(0);
                }
            }
            Log.i("aasdfa", "checkTouch: "+event.type);

        }
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
