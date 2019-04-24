package com.example.asus.rome.dome;

import android.graphics.Color;
import android.graphics.Paint;
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

public class BetRoom extends FMXScreen {
    private FMXImage horse2, bar2,bar2e, clearbt, userbar, table1, table2, shiftbar, chip, bgbet, bghorse, newbutton, tablemode;
    private int horseW = 72, horseH = 178, chipSize = 72, add = 0, betW = 120, rass, xxixx = 0, abs, showset = 0;
    private double exid, alphanox = 0;
    private boolean numC, canT = true, isClickstat = false;
    private int price, bytouch, ddsi = 138, pl, isClick = 0, statsize = 40;
    public float distance = 0, olddis;
    public float time = 0;
    public float velocity = 0;
    float[] checktime = new float[10];
    Select ss = new Select(game);
    Random rn = new Random();
    Integer[] checkshowbet = {0, 0, 0, 0};
    Integer[] checkshowhosre = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private Paint paint = new Paint(), paintstat = new Paint();
    private int centos;
    boolean showpayout;

    public BetRoom(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();

//        bar2 = g.newImage("bar2.png", FMXGraphics.ImageFormat.ARGB4444);
        bar2e = g.newImage("betroom/bar2e.png", FMXGraphics.ImageFormat.ARGB4444);
        clearbt = g.newImage("betroom/clearbt.png", FMXGraphics.ImageFormat.ARGB4444);
        userbar = g.newImage("betroom/user bar.png", FMXGraphics.ImageFormat.ARGB4444);
        table1 = g.newImage("betroom/table 1.png", FMXGraphics.ImageFormat.ARGB4444);
        table2 = g.newImage("betroom/table 2.png", FMXGraphics.ImageFormat.ARGB4444);
        shiftbar = g.newImage("betroom/Shift bar.png", FMXGraphics.ImageFormat.ARGB4444);
        bgbet = g.newImage("betroom/bar1.png", FMXGraphics.ImageFormat.ARGB4444);
        bghorse = g.newImage("betroom/horse1.png", FMXGraphics.ImageFormat.ARGB4444);
        newbutton = g.newImage("betroom/newbutton.png", FMXGraphics.ImageFormat.ARGB4444);
        tablemode = g.newImage("betroom/tablemode.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.winners = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            constan.winners.add(i);
        }

        Collections.shuffle(constan.winners);
        bytouch = 0;
        clear();
        paint.setColor(Color.WHITE);
        paint.setTextSize(13);
        paintstat.setColor(Color.WHITE);
        paintstat.setTextSize(20);
    }

    @Override
    public void update(float deltaTime) {
        for (int i = 0; i <= constan.chipsReds.size() - 1; i++) {
            constan.chipsReds.get(i).tick(deltaTime);
        }
        exid += deltaTime * 0.01 * 50;
        if (exid >= 20)
            exid = 0;

    }

    int c = 0, d = 0, a = 0;

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.drawImage(constan.mainbg, 0, 0);
//        g.drawImage(constan.betroom, constan.SCREEN_HEIGHT - 420, 0, 180 * constan.selectbetroom, 0, 180, 45);
        g.drawImage(constan.betroome, constan.SCREEN_HEIGHT - 420, 0, 180 * constan.selectbetroom, 0, 180, 45);
        if (constan.table > 4) {
            abs = constan.table - 5;
            rass = 1;
        } else {
            abs = constan.table;
            rass = 0;
        }
        g.drawImage(tablemode, constan.SCREEN_HEIGHT - 220, 0, 143 * abs, 45 * rass, 143, 45);
        g.drawImage(bghorse, constan.SCREEN_HEIGHT / 2 - 384, 49);
        g.drawImage(constan.horse, constan.SCREEN_HEIGHT / 2 - 360, 50, 0, 0, horseW * 10, horseH);//horse
        g.drawImage(bgbet, constan.SCREEN_HEIGHT / 2 - 264, 226);
//        g.drawImage(bar2, constan.SCREEN_HEIGHT / 2 - 241, 226, 0, 0, 482, 132);//bet odd etc
        g.drawImage(bar2e, constan.SCREEN_HEIGHT / 2 - 241, 226, 0, 0, 482, 132);//bet odd etc
        g.drawImage(table1, constan.SCREEN_HEIGHT / 2 - 383, 226, 0, 0, 138, 223);//win rate
        g.drawImage(table2, constan.SCREEN_HEIGHT / 2 + 246, 226, 0, 0, 138, 223);//stat
        ////////////////////////////////////////////
//        if (constan.status.size() > 0)
//            for (int i = constan.status.size(), nl = 0, nt = 4; i > 0; i--, nt--) {
//                if (i % 5 == 0) {
//                    nl++;
//                    nt = 4;
//                }
//                g.drawString("" + constan.status.get(i - 1), constan.SCREEN_HEIGHT / 2 + 256 + 25 * (nt), 226 + 40 + 30 * nl, paint);
//            }
        if (constan.StatusHalf.get(constan.table).size() > 0)
            for (int i = constan.StatusHalf.get(constan.table).size(), nl = 0, nt = 4; i > 0; i--, nt--) {
                if (i % 5 == 0) {
                    nl++;
                    nt = 4;
                }
                if (nl < 6)
                    g.drawString("" + constan.StatusHalf.get(constan.table).get(i - 1), constan.SCREEN_HEIGHT / 2 + 256 + 25 * (nt), 226 + 40 + 30 * nl, paint);
            }
        ////////////////////////////////////////////////////////////////////////////////////////////
        g.drawImage(userbar, constan.SCREEN_HEIGHT / 2 - 392, constan.SCREEN_WIDTH - 31);
        g.drawImage(shiftbar, constan.SCREEN_HEIGHT / 2 - 244, constan.SCREEN_WIDTH - 92);

        clicked1();
        g.drawImage(constan.ibg, constan.SCREEN_HEIGHT - 60, 5, 48, 0, 48, 48);
        if (numC == false)
            for (int i = 0; i < 5; i++) {
                g.drawImage(constan.point, (constan.SCREEN_HEIGHT / 2 - 223) + chipSize * i, (int) ((constan.SCREEN_WIDTH - ddsi) + exid));
            }
        if (numC == true) {
            g.drawImage(constan.point, (constan.SCREEN_HEIGHT / 2 - 223) + chipSize * centos, (int) ((constan.SCREEN_WIDTH - ddsi) + exid));
            g.drawImage(constan.fxchip, (constan.SCREEN_HEIGHT / 2 - 223 - 27) + chipSize * centos, (constan.SCREEN_WIDTH - ddsi) + 38);
        }
        if (constan.selectbetroom == 0) {
            g.drawImage(constan.chip1, constan.SCREEN_HEIGHT / 2 - 235, constan.SCREEN_WIDTH - 86);//chipsred
            g.drawImage(constan.chip2, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 1, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip3, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 2, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip4, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 3, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip5, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 4, constan.SCREEN_WIDTH - 86);//chipsaquar
        }
        if (constan.selectbetroom == 1) {
            g.drawImage(constan.chip01, constan.SCREEN_HEIGHT / 2 - 235, constan.SCREEN_WIDTH - 86);//chipsred
            g.drawImage(constan.chip02, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 1, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip03, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 2, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip04, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 3, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip05, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 4, constan.SCREEN_WIDTH - 86);//chipsaquar
        }

        if (constan.selectbetroom == 2) {
            g.drawImage(constan.chip25, constan.SCREEN_HEIGHT / 2 - 235, constan.SCREEN_WIDTH - 86);//chipsred
            g.drawImage(constan.chip50, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 1, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip100, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 2, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip500, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 3, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip1k, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 4, constan.SCREEN_WIDTH - 86);//chipsaquar
        }

        g.drawImage(clearbt, constan.SCREEN_HEIGHT / 2 + 136, constan.SCREEN_WIDTH - 77, 0, 0, 96, 30);//clear all
        g.drawImage(constan.statbtnX, constan.SCREEN_HEIGHT / 2 - 362, constan.SCREEN_WIDTH - 40, 0, 0, 59, 38);//back
        g.drawImage(newbutton, constan.SCREEN_HEIGHT / 2 + (245 + 69 - 48), constan.SCREEN_WIDTH - 50, 0, 0, 112, 47);//cf

        g.drawString("" + constan.winners.get(0), constan.SCREEN_HEIGHT / 2 + 246 + 10, 226 + 40, paint);
        g.drawString("" + constan.winners.get(1), constan.SCREEN_HEIGHT / 2 + 246 + 35, 226 + 40, paint);
        g.drawString("" + constan.winners.get(2), constan.SCREEN_HEIGHT / 2 + 246 + 60, 226 + 40, paint);
        g.drawString("" + constan.winners.get(3), constan.SCREEN_HEIGHT / 2 + 246 + 85, 226 + 40, paint);
        g.drawString("" + constan.winners.get(4), constan.SCREEN_HEIGHT / 2 + 246 + 110, 226 + 40, paint);

        for (int i = 0; i <= constan.chipsReds.size() - 1; i++) {
            constan.chipsReds.get(i).paint(g);
        }

        for (int i = 0; i <= constan.arrShowChips1.size() - 1; i++) {
            constan.arrShowChips1.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips2.size() - 1; i++) {
            constan.arrShowChips2.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips3.size() - 1; i++) {
            constan.arrShowChips3.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips4.size() - 1; i++) {
            constan.arrShowChips4.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips5.size() - 1; i++) {
            constan.arrShowChips5.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips6.size() - 1; i++) {
            constan.arrShowChips6.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips7.size() - 1; i++) {
            constan.arrShowChips7.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips8.size() - 1; i++) {
            constan.arrShowChips8.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips9.size() - 1; i++) {
            constan.arrShowChips9.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips10.size() - 1; i++) {
            constan.arrShowChips10.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips11.size() - 1; i++) {
            constan.arrShowChips11.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips12.size() - 1; i++) {
            constan.arrShowChips12.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips13.size() - 1; i++) {
            constan.arrShowChips13.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips14.size() - 1; i++) {
            constan.arrShowChips14.get(i).paint(g);
        }
        g.drawImage(constan.lal, 10, 10);
        g.drawImage(constan.lal, 170, 10);
        g.drawString("" + constan.user, 70, 30, paint);
        g.drawString("Credit : " + constan.credit, 180, 30, paint);
        g.drawString("Bet : " + constan.bet_amount, 250, constan.SCREEN_WIDTH-10, paint);

        g.drawImage(constan.ibg, 0, 0, 0, 0, 48, 48);

        for (int i = 0; i < 10; i++) {
            g.drawString("" + (constan.shows[i]), constan.SCREEN_HEIGHT / 2 - 315, constan.SCREEN_WIDTH / 2 + 34 + 17 * i, paint);
        }
        if (showpayout == true)
            g.drawImage(constan.shpayout, constan.SCREEN_HEIGHT / 2 - 384, constan.SCREEN_WIDTH / 2 - 240);
        checkTouch();
        if (showset == 1) {
//            g.drawRectBG(0,0,constan.SCREEN_HEIGHT,constan.SCREEN_WIDTH,Color.BLACK,120);
//            g.drawImage(constan.ibg, constan.SCREEN_HEIGHT - 60, 5,48,0,48,48);
////            g.drawImage(constan.ibg, 0, 0,0,0,48,48);
//            g.drawImage(constan.setbg, constan.SCREEN_HEIGHT - 218, +58);
//            g.drawImage(constan.setbg, constan.SCREEN_HEIGHT - 218, +108);
//            if (setnum==1){
//                g.drawImage(constan.shpayout,0,0);
//            }
//            else if (setnum==2){
//
//            }
            ss.Lotus(g, deltaTime);
        }
        if (isClick == 1)
            ScreentoRunTheworld(g, deltaTime);
        if (isClick == 2) {
            ScreentoSelect(g, deltaTime);
        }
        if (isClickstat == true) {
            ShowStat(g, deltaTime);
        }
    }

    void clicked1() {
        FMXGraphics g = game.getGraphics();
        if (numC == true && a == 1) {
            for (int i = 0; i < 10; i++) {
                if (c == i) {
                    if (add == 1) {
                        float startX = (float) (constan.SCREEN_HEIGHT / 2 - 235),
                                startY = (float) constan.SCREEN_WIDTH - 86,
                                endX = (float) constan.SCREEN_HEIGHT / 2 - 322 - 24 + 71 * c,
                                endY = 188 - 24;
                        float distance = (float) Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
                        float directionX = ((endX - startX) / distance);
                        float directionY = ((endY - startY) / distance);
                        double speed = 7000;
                        float elapsed = 0.01f;
                        double X = startX;
                        double Y = startY;
                        if (constan.credit - price >= 0 && constan.bet_amount + price <= constan.maxroom) {
                            constan.chipsReds.add(new chipsRed(startX, startY, X, Y, endX, endY, speed, distance, directionX, directionY, elapsed, price, c + 1));
                            constan.credit -= price;
                            constan.bet_amount += price;
                        }
                        add = 0;
                    }
                }
            }
        } else if (numC == true && a == 2) {
            for (int i = 0; i < 4; i++) {
                if (d == i) {
                    if (add == 1) {
                        float startX = (float) (constan.SCREEN_HEIGHT / 2),
                                startY = (float) constan.SCREEN_WIDTH,
                                endX = (float) constan.SCREEN_HEIGHT / 2 - 205 + 120 * d,
                                endY = 226 + 66;
                        float distance = (float) Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
                        float directionX = ((endX - startX) / distance);
                        float directionY = ((endY - startY) / distance);
                        double speed = 7000;
                        float elapsed = 0.01f;
                        double X = startX;
                        double Y = startY;
                        if (constan.credit - price >= 0 && constan.bet_amount + price <= constan.maxroom) {
                            constan.chipsReds.add(new chipsRed(startX, startY, X, Y, endX, endY, speed, distance, directionX, directionY, elapsed, price, d + 11));
                            constan.credit -= price;
                            constan.bet_amount += price;
                        }
                        add = 0;
                    }
                }
            }
        } else
            add = 0;
        for (int i = 0; i < checkshowhosre.length; i++) {
            if (checkshowhosre[i] > 0)
                g.drawImage(constan.horse, constan.SCREEN_HEIGHT / 2 - 360 + horseW * (i), 50, horseW * (i), horseH, horseW, horseH);
        }
        for (int i = 0; i < checkshowbet.length; i++) {
            if (checkshowbet[i] > 0)
                g.drawImage(bar2e, (constan.SCREEN_HEIGHT / 2 - 241) + betW * (i), 226, 120 * (i), 132, betW, 132);//h
//                g.drawImage(bar2, (constan.SCREEN_HEIGHT / 2 - 241) + betW * (i), 226, 120 * (i), 132, betW, 132);//h
        }
    }

    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);
            if (event.type==FMXInput.TouchEvent.TOUCH_DRAGGED){
                Log.i("sdgpidhgio", "checkTouch: "+event.type);
            }
            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN && canT == true && isClickstat == false) {
                //Check Touch by area
                //event  //imagepositionX ///imagepositionY ///imagesizeWidth ///imagesizeHeight
                if (price > 0 && constan.bet_amount + price <= constan.maxroom) {
                    for (int j = 0; j < checkshowhosre.length; j++) {
                        if (j >= 9)
                            pl = 10;
                        else
                            pl = 0;
                        if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2) - 360 + (horseW * j) + pl, 50, horseW, horseH) && constan.credit > 0 && showset == 0) {
                            Log.i("sdgsag", "checkTouch: " + (horseW * j));
                            add = 1;
                            c = j;
                            a = 1;
                            checkshowhosre[j] = 1;
                        }
                    }
                    for (int j = 0; j < checkshowbet.length; j++) {
                        if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 241) + 120 * (j), 226, 120, 132) && constan.credit > 0 && showset == 0) {
                            Log.i("ss5o1", "checkTouch: height");
                            add = 1;
                            a = 2;
                            d = j;
                            checkshowbet[j] = 1;
                        }
                    }
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 235), constan.SCREEN_WIDTH - 86, 44, 44) && showset == 0) {
                    Log.i("ss5o1", "checkTouch: 25");
                    numC = true;
                    price = constan.price1;
                    centos = 0;
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 1, constan.SCREEN_WIDTH - 86, 48, 48) && showset == 0) {
                    Log.i("ss5o1", "checkTouch: 50");
                    numC = true;
                    price = constan.price2;
                    centos = 1;
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 235+10) + chipSize * 2, constan.SCREEN_WIDTH - 86, 48, 48) && showset == 0) {
                    Log.i("ss5o1", "checkTouch: 100");
                    numC = true;
                    price = constan.price3;
                    centos = 2;
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 235+20) + chipSize * 3, constan.SCREEN_WIDTH - 86, 48, 48) && showset == 0) {
                    Log.i("ss5o1", "checkTouch: 500");
                    numC = true;
                    price = constan.price4;
                    centos = 3;
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 235+20) + chipSize * 4, constan.SCREEN_WIDTH - 86, 48, 48) && showset == 0) {
                    Log.i("ss5o1", "checkTouch: 1K");
                    numC = true;
                    price = constan.price5;
                    centos = 4;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 + (246 + 100 - 48), constan.SCREEN_WIDTH - 50, 96, 30) && constan.eieiza == 1 && showset == 0) {
                    Log.i("ss5o1", "checkTouch: CF");
                    isClick = 1;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 + 136 + 50, constan.SCREEN_WIDTH - 80, 96, 40) && showset == 0) {
                    Log.i("clear", "checkTouch: ");
                    bytouch = 1;
                    clear();
                }
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
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 17, 222, 50, 100) && showset == 1 && ss.setnum == 1) {
                    ss.setnum = 2;
                }

                //sound
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103, 40, 40) && showset == 1 && ss.s == 1) {
                    ss.s = 2;
                } else if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103, 59, 38) && showset == 1 && ss.s == 2) {
                    ss.s = 1;
                }
                //back
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103 + 45, 40, 40) && showset == 1 && ss.s == 1) {
                    bytouch = 1;
                    clear();
                    isClick = 2;
                }
                //close
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 20, 103 + 45 * 2, 40, 40) && showset == 1) {
                    ss.setnum = 3;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 + 39, constan.SCREEN_WIDTH / 2 + 30, 111, 48) && showset == 1 && ss.setnum == 3) {
                    ss.setnum = 0;
                    showset = 0;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - 150, constan.SCREEN_WIDTH / 2 + 30, 111, 48) && showset == 1 && ss.setnum == 3) {

                    System.exit(0);
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 + 246), 226, 138, 180) && isClickstat == false && showset == 0) {
                    Log.i("ss5o1", "checkTouch: state");
                    isClickstat = true;
                }


                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - 362, constan.SCREEN_WIDTH - 50, 100, 50) && showset == 0) {
                    bytouch = 1;
                    clear();
                    isClick = 2;
                }
            }
            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN && canT == true && isClickstat == true) {
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 + 215 + 20, 5, 59, 38) && isClickstat == true) {
                    isClickstat = false;
                }
            }
        }
    }

    public void calculate() {
        constan.count++;
        constan.rounds[constan.winners.get(0) - 1]++;
        for (int i = 0; i < constan.shows.length; i++) {
            constan.shows[i] = (int) ((constan.rounds[i] / constan.count) * 100);
        }
//        arr1st[constan.count - 1] = constan.winners.get(0);

        if (constan.winners.get(0) % 2 == 0) {
            constan.payout += constan.bet_sub[12] * 2;
            Log.i("payout[12]", "calculate: even" + constan.bet_sub[12]);
        }

        if (constan.winners.get(0) % 2 == 1) {
            constan.payout += constan.bet_sub[13] * 2;
            Log.i("payout[13]", "calculate: odd" + constan.bet_sub[13]);
        }

        if (constan.winners.get(0) > 5) {
            constan.payout += constan.bet_sub[11] * 2;
            Log.i("payout[11]", "calculate: height" + constan.bet_sub[11]);
        } else {
            constan.payout += constan.bet_sub[10] * 2;
            Log.i("payout[10]", "calculate: low" + constan.bet_sub[10]);
        }

        constan.payout += constan.bet_sub[constan.winners.get(0) - 1] * 6;
        constan.credit += constan.payout;
    }

    public void clear() {
        for (int i = 0; i < checkshowhosre.length; i++) {
            checkshowhosre[i] = 0;
        }
        for (int i = 0; i < checkshowbet.length; i++) {
            checkshowbet[i] = 0;
        }
        c = 0;
        d = 0;
        a = 0;
        constan.eieiza = 0;
        if (bytouch == 1)
            constan.credit += constan.bet_amount;

        constan.bet_amount = 0;
        for (int i = 0; i < constan.bet_sub.length; i++) {
            constan.bet_sub[i] = 0;
        }
        constan.arrShowChips1.clear();
        constan.arrShowChips2.clear();
        constan.arrShowChips3.clear();
        constan.arrShowChips4.clear();
        constan.arrShowChips5.clear();
        constan.arrShowChips6.clear();
        constan.arrShowChips7.clear();
        constan.arrShowChips8.clear();
        constan.arrShowChips9.clear();
        constan.arrShowChips10.clear();
        constan.arrShowChips11.clear();
        constan.arrShowChips12.clear();
        constan.arrShowChips13.clear();
        constan.arrShowChips14.clear();
        constan.payout = 0;
    }

    private void ScreentoRunTheworld(FMXGraphics g, float deltaTime) {
        canT = false;
        alphanox += deltaTime * 0.01 * 500;
        g.drawRectBG(0, 0, constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, Color.BLACK, (int) alphanox);
        Log.i("ssdfasdf", "swScreen: " + alphanox);
        if (alphanox >= 250) {
            calculate();
            game.setScreen(new HorseRun(game));

        }
    }

    private void ScreentoSelect(FMXGraphics g, float deltaTime) {
        canT = false;
        alphanox += deltaTime * 0.01 * 500;
        g.drawRectBG(0, 0, constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, Color.BLACK, (int) alphanox);
        Log.i("ssdfasdf", "swScreen: " + alphanox);
        if (alphanox >= 250) {
            game.setScreen(new Table(game));
        }

    }


    private void ShowStat(FMXGraphics g, float deltaTime) {
        g.drawRectBG(0, 0, constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, Color.BLACK, 155);
        g.drawImage(constan.statbtnX, constan.SCREEN_HEIGHT / 2 + 215, 5, 59, 0, 59, 38);
        g.drawImage(constan.stathead, constan.SCREEN_HEIGHT / 2 - 277, 59);
        g.drawImage(constan.statbody, constan.SCREEN_HEIGHT / 2 - 277, 111);
        if (constan.StatusFull.get(constan.table).size() > 0)
            for (int i = 0; i < constan.StatusFull.get(constan.table).size(); i++) {
                for (int j = 0, x = constan.countRound[constan.table] - 1; j < constan.countRound[constan.table]; j++, x--) {
                    g.drawString("" + (x + 1), constan.SCREEN_HEIGHT / 2 - 250, 140 + 35 * j, paintstat);
                    if (constan.StatusFull.get(constan.table).get(10 * (j)) == i + 1) {
                        g.drawImage(constan.stattest[i], constan.SCREEN_HEIGHT / 2 - 277 + 102, 120 + 35 * x);
                    } else if (constan.StatusFull.get(constan.table).get(1 + 10 * (j)) == i + 1) {
                        g.drawImage(constan.stattest[i], constan.SCREEN_HEIGHT / 2 - 277 + 182, 120 + 35 * x);
                    } else if (constan.StatusFull.get(constan.table).get(2 + 10 * (j)) == i + 1) {
                        g.drawImage(constan.stattest[i], constan.SCREEN_HEIGHT / 2 - 277 + 182 + statsize, 120 + 35 * x);
                    } else if (constan.StatusFull.get(constan.table).get(3 + 10 * (j)) == i + 1) {
                        g.drawImage(constan.stattest[i], constan.SCREEN_HEIGHT / 2 - 277 + 182 + statsize * (2), 120 + 35 * x);
                    } else if (constan.StatusFull.get(constan.table).get(4 + 10 * (j)) == i + 1) {
                        g.drawImage(constan.stattest[i], constan.SCREEN_HEIGHT / 2 - 277 + 182 + statsize * (3), 120 + 35 * x);
                    } else if (constan.StatusFull.get(constan.table).get(5 + 10 * (j)) == i + 1) {
                        g.drawImage(constan.stattest[i], constan.SCREEN_HEIGHT / 2 - 277 + 182 + statsize * (4), 120 + 35 * x);
                    } else if (constan.StatusFull.get(constan.table).get(6 + 10 * (j)) == i + 1) {
                        g.drawImage(constan.stattest[i], constan.SCREEN_HEIGHT / 2 - 277 + 182 + statsize * (5), 120 + 35 * x);
                    } else if (constan.StatusFull.get(constan.table).get(7 + 10 * (j)) == i + 1) {
                        g.drawImage(constan.stattest[i], constan.SCREEN_HEIGHT / 2 - 277 + 182 + statsize * (6), 120 + 35 * x);
                    } else if (constan.StatusFull.get(constan.table).get(8 + 10 * (j)) == i + 1) {
                        g.drawImage(constan.stattest[i], constan.SCREEN_HEIGHT / 2 - 277 + 182 + statsize * (7), 120 + 35 * x);
                    } else if (constan.StatusFull.get(constan.table).get(9 + 10 * (j)) == i + 1) {
                        g.drawImage(constan.stattest[i], constan.SCREEN_HEIGHT / 2 - 277 + 182 + statsize * (8), 120 + 35 * x);
                    }
                }
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
