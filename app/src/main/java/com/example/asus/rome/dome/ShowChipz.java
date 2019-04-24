package com.example.asus.rome.dome;

import com.example.asus.rome.framework.FMXGraphics;

public class ShowChipz {

    float x, y;

    float FixX, FixY;

    int no_ima, choose, id;
    double betAmount;

    public ShowChipz(float x, float y, int no_ima, double betAmount, int id, int choose, float FixX, float FixY) {
        this.x = x;
        this.y = y;
        this.FixX = FixX;
        this.FixY = FixY;

        this.choose = choose;
        this.id = id;
        this.no_ima = no_ima;
        this.betAmount = betAmount;

//        iv1 = new ImageView(context);
//
//        lp = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
//
//
//        iv1.setLayoutParams(lp);
//        rl.addView(iv1);
//
//        iv1.setX(x);
//        iv1.setY(y);
//        lp.height = 60;
//        lp.width = 60;

    }

    public void paint(FMXGraphics g) {
        if (constan.selectbetroom == 2) {
            if (no_ima == 0) g.drawImage(constan.chip25, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 1) g.drawImage(constan.chip50, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 2) g.drawImage(constan.chip100, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 3) g.drawImage(constan.chip500, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 4) g.drawImage(constan.chip1k, (int) x, (int) y, 0, 0, 48, 48);
        }
        if (constan.selectbetroom == 0) {
            if (no_ima == 0) g.drawImage(constan.chip1, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 1) g.drawImage(constan.chip2, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 2) g.drawImage(constan.chip3, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 3) g.drawImage(constan.chip4, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 4) g.drawImage(constan.chip5, (int) x, (int) y, 0, 0, 48, 48);
        }
        if (constan.selectbetroom == 1) {
            if (no_ima == 0) g.drawImage(constan.chip01, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 1) g.drawImage(constan.chip02, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 2) g.drawImage(constan.chip03, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 3) g.drawImage(constan.chip04, (int) x, (int) y, 0, 0, 48, 48);
            if (no_ima == 4) g.drawImage(constan.chip05, (int) x, (int) y, 0, 0, 48, 48);
        }
    }
}