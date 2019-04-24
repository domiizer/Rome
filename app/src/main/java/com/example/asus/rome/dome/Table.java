package com.example.asus.rome.dome;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.example.asus.rome.framework.FMXGame;
import com.example.asus.rome.framework.FMXGraphics;
import com.example.asus.rome.framework.FMXImage;
import com.example.asus.rome.framework.FMXInput;
import com.example.asus.rome.framework.FMXScreen;

import java.util.List;

public class Table extends FMXScreen {
    private FMXImage table,table2,big,bige;
    private Paint paint = new Paint();
    private boolean canT=true;
    private int showset=0,isClick=0;
    private double alphanox;
    Select ss = new Select(game);

    public Table(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        table = g.newImage("table/tableEN.png", FMXGraphics.ImageFormat.ARGB4444);
        table2 = g.newImage("table/tableEN.png", FMXGraphics.ImageFormat.ARGB4444);
        big = g.newImage("table/betroomEN.png",FMXGraphics.ImageFormat.ARGB4444);
        bige = g.newImage("table/betroomEN.png",FMXGraphics.ImageFormat.ARGB4444);
        paint.setColor(Color.WHITE);
        paint.setTextSize(13);

    }

    @Override
    public void update(float deltaTime) {
        checkTouch();
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.drawImage(constan.mainbg,0,0);
//        g.drawImage(big,constan.SCREEN_HEIGHT/2-150,45,300* constan.selectbetroom,0,300,75);
        g.drawImage(bige,constan.SCREEN_HEIGHT/2-150,45,300* constan.selectbetroom,0,300,75);
        g.drawImage(constan.ibg, constan.SCREEN_HEIGHT - 60, 5,48,0,48,48);
        g.drawImage(constan.lal, 10, 10);
        g.drawImage(constan.lal, 170, 10);
        g.drawString("" + constan.user, 70, 30, paint);
        g.drawString("Credit : " + constan.credit, 180, 30, paint);
        g.drawImage(constan.ibg, 0, 0,0,0,48,48);

        g.drawImage(table2, constan.SCREEN_HEIGHT/2-(378+20), constan.SCREEN_WIDTH-360,0,0,756,174);
        g.drawImage(table2, constan.SCREEN_HEIGHT/2-(378-20), constan.SCREEN_WIDTH-210,0,174,756,174);
        g.drawImage(constan.statbtnX,20,constan.SCREEN_WIDTH-60,0,0,59,38);

        if (showset==1) {
            ss.Lotus(g,deltaTime);
        }
        if (isClick==1)
            ScreentoMode(g,deltaTime);
        if (isClick==2)
            ScreentoSelect(g,deltaTime);

    }
    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);
            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN && canT == true) {
                ////////////////////////////////////////////
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - (378 + 5), constan.SCREEN_WIDTH - 360, 120,150) && showset == 0) {
                    isClick=1;
                    constan.table=0;
                    Log.i("rghidsgsg", "checkTouch: 1");
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 378)+165, constan.SCREEN_WIDTH - 360, 120,150) && showset == 0) {
                    isClick=1;
                    Log.i("rghidsgsg", "checkTouch: 2");
                    constan.table=1;
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 378)+318, constan.SCREEN_WIDTH - 360, 120,150) && showset == 0) {
                    isClick=1;
                    Log.i("rghidsgsg", "checkTouch: 3");
                    constan.table=2;
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 378)+466, constan.SCREEN_WIDTH - 360, 120,150) && showset == 0) {
                    isClick=1;
                    Log.i("rghidsgsg", "checkTouch: 4");
                    constan.table=3;
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 378)+621, constan.SCREEN_WIDTH - 360, 120,150) && showset == 0) {
                    isClick=1;
                    Log.i("rghidsgsg", "checkTouch: 5");
                    constan.table=4;
                }
//////////////////////////////////////////////////////////////////////////////
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - (378 - 20)+15, constan.SCREEN_WIDTH - 210, 120,150) && showset == 0) {
                    isClick=1;
                    Log.i("rghidsgsg", "checkTouch: 6");
                    constan.table=5;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - (378 - 20)+165, constan.SCREEN_WIDTH - 210,120,150 ) && showset == 0) {
                    isClick=1;
                    Log.i("rghidsgsg", "checkTouch: 7");
                    constan.table=6;
                }

                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - (378 - 20)+318, constan.SCREEN_WIDTH - 210,120,150) && showset == 0) {
                    isClick=1;
                    Log.i("rghidsgsg", "checkTouch: 8");
                    constan.table=7;
                }

                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - (378 - 20)+466, constan.SCREEN_WIDTH - 210,120,150) && showset == 0) {
                    isClick=1;
                    Log.i("rghidsgsg", "checkTouch: 9");
                    constan.table=8;
                }

                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - (378 - 20)+621, constan.SCREEN_WIDTH - 210,120,150) && showset == 0) {
                    isClick=1;
                    Log.i("rghidsgsg", "checkTouch: 10");
                    constan.table=9;
                }


                ///////////////////////////////////////////
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, +10, 48, 48) && showset == 0) {
                    Log.i("inininin", "checkTouch: ");
                    showset = 1;
                    ss.setnum = 0;
                } else if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, +10, 48, 48) && showset == 1) {
                    Log.i("22222", "checkTouch: ");
                    showset = 0;
                    ss.setnum = 0;
                }
                //i
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 58, 40, 40) && showset == 1 && ss.setnum == 0) {
                    ss.setnum = 1;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 170 + 20, 20, 59, 38) && showset == 1) {
                    ss.setnum = 0;
                }
                //arrow
                if (dome.inBounds(event, 17, 222, 50, 100) && showset == 1 && ss.setnum == 2) {
                    ss.setnum = 1;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT-17, 222, 50, 100) && showset == 1 && ss.setnum == 1) {
                    ss.setnum = 2;
                }

                //sound
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103, 40, 40) && showset == 1 && ss.s == 1) {
                    ss.s = 2;
                } else if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103, 59, 38) && showset == 1 && ss.s == 2) {
                    ss.s = 1;
                }
                //back
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103+45, 40, 40) && showset == 1 && ss.s == 1) {
                    isClick=2;
                }
                //close
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103+45*2, 40, 40) && showset == 1) {
                    ss.setnum=3;
                }
                if (dome.inBounds(event,constan.SCREEN_HEIGHT/2+39,constan.SCREEN_WIDTH/2+30, 111, 48) && showset == 1&&ss.setnum==3){
                    ss.setnum=0;
                    showset=0;
                }
                if (dome.inBounds(event,constan.SCREEN_HEIGHT/2-150,constan.SCREEN_WIDTH/2+30, 111, 48) && showset == 1&&ss.setnum==3){
                    System.exit(0);
                }
                if (dome.inBounds(event,20,constan.SCREEN_WIDTH-60,59,38)&&showset==0){
                    isClick=2;
                }
            }
        }
    }
    private void ScreentoMode(FMXGraphics g, float deltaTime) {
        canT=false;
        alphanox+=deltaTime*0.01*500;
        g.drawRectBG(0,0,constan.SCREEN_HEIGHT,constan.SCREEN_WIDTH,Color.BLACK, (int) alphanox);
        Log.i("ssdfasdf", "swScreen: "+alphanox);
        if (alphanox>=250){
            game.setScreen(new BetRoom(game));
        }

    }
    private void ScreentoSelect(FMXGraphics g, float deltaTime) {
        canT=false;
        alphanox+=deltaTime*0.01*500;
        g.drawRectBG(0,0,constan.SCREEN_HEIGHT,constan.SCREEN_WIDTH,Color.BLACK, (int) alphanox);
        Log.i("ssdfasdf", "swScreen: "+alphanox);
        if (alphanox>=250){
            game.setScreen(new Select(game));
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
