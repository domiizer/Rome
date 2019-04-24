package com.example.asus.rome.dome;

import android.graphics.Color;
import android.util.Log;

import com.example.asus.rome.framework.FMXGame;
import com.example.asus.rome.framework.FMXGraphics;
import com.example.asus.rome.framework.FMXImage;
import com.example.asus.rome.framework.FMXInput;
import com.example.asus.rome.framework.FMXScreen;

import java.util.ArrayList;
import java.util.List;

public class loading extends FMXScreen {
    FMXImage bg,logo,bt,bar;
    double DLLogo;
    int SPLogo;
    boolean canT=true;
    public loading(FMXGame game) {
        super(game);
        FMXGraphics g =game.getGraphics();
        bg=g.newImage("loading/loadingbg.png",FMXGraphics.ImageFormat.ARGB4444);
        logo=g.newImage("loading/loadinglogo.png",FMXGraphics.ImageFormat.ARGB4444);
        bt=g.newImage("loading/startbton.png",FMXGraphics.ImageFormat.ARGB4444);
        bar=g.newImage("loading/loadingBar.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.mainbg =g.newImage("constan/mainbg.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.ibg =g.newImage("constan/logo_iam.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.lal =g.newImage("constan/05_username_credit_box.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.setBot =g.newImage("constan/settingBot.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.statbtnX =g.newImage("constan/statbtnx.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.shpayout =g.newImage("constan/pay out.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.arrow =g.newImage("constan/arrow bt.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.shhowto =g.newImage("constan/howto.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.exitAlert =g.newImage("constan/exitalret.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.exitBT =g.newImage("constan/exitBT.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.betroome=g.newImage("constan/bet room.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.horse=g.newImage("betroom/horse2.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.point = g.newImage("constan/point.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.fxchip = g.newImage("constan/chip_effect.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.statbody=g.newImage("constan/statbody.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stathead=g.newImage("constan/stathead.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.statline=g.newImage("constan/statline.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.statenumber=g.newImage("constan/statnumber.png",FMXGraphics.ImageFormat.ARGB4444);

        constan.chip1 = g.newImage("constan/tile100.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip2 = g.newImage("constan/tile101.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip3 = g.newImage("constan/tile102.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip4 = g.newImage("constan/tile103.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip5 = g.newImage("constan/tile104.png", FMXGraphics.ImageFormat.ARGB4444);

        constan.chip01 = g.newImage("constan/tile010.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip02 = g.newImage("constan/tile011.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip03 = g.newImage("constan/tile012.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip04 = g.newImage("constan/tile013.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip05 = g.newImage("constan/tile014.png", FMXGraphics.ImageFormat.ARGB4444);

        constan.chip25 = g.newImage("constan/tile000.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip50 = g.newImage("constan/tile001.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip100 = g.newImage("constan/tile002.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip500 = g.newImage("constan/tile003.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip1k = g.newImage("constan/tile004.png", FMXGraphics.ImageFormat.ARGB4444);

        for(int i = 0; i < 10; i++)  {
            constan.StatusHalf.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < 10; i++)  {
            constan.StatusFull.add(new ArrayList<Integer>());
        }
    }

    @Override
    public void update(float deltaTime) {
        DLLogo+=deltaTime*0.01*20;
        SPLogo= (int) (DLLogo%5);
        checkTouch();

    }
public void SWtoSelsect(FMXGraphics g , Float deltaTime){
    canT = false;
    alphanox += deltaTime * 0.01 * 500;
    g.drawRectBG(0, 0, constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH, Color.BLACK, (int) alphanox);
    Log.i("ssdfasdf", "swScreen: " + alphanox);
    if (alphanox >= 245) {
        game.setScreen(new Select(game));

    }
}
    @Override
    public void paint(float deltaTime) {
        FMXGraphics g =game.getGraphics();
        g.drawImage(bg,0,0);
        g.drawImage(logo,(constan.SCREEN_HEIGHT/2)-(logo.getWidth()/5)/2,10,(logo.getWidth()/5)*SPLogo,0,logo.getWidth()/5,logo.getHeight());
        g.drawImage(bt, constan.SCREEN_HEIGHT / 2 - bt.getWidth()/4, constan.SCREEN_WIDTH - constan.SCREEN_WIDTH / 4, 0, 0, bt.getWidth()/2, bt.getHeight());
        if (active==true){
            SWtoSelsect(g,deltaTime);
        }
    }
boolean active=false;
    double alphanox;
    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);
            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN&&canT == true) {
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - bt.getWidth()/4+10, constan.SCREEN_WIDTH - constan.SCREEN_WIDTH / 4, bt.getWidth()/2, bt.getHeight())) {
                    active=true;
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
