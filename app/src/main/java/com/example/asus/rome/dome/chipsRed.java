package com.example.asus.rome.dome;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.example.asus.rome.framework.FMXGraphics;

import java.util.ArrayList;

public class chipsRed {
    ArrayList<Integer> show_chips = new ArrayList<>();

    private int horseW = 72, horseH = 176;
    private float startX, startY, endX, endY;
    private float speed;
    private float elapsed;
    private int price;
    private int bet_amount;
    //    int cound;
    Paint paint;
    Canvas canvas;
    private int img_no, dy, choose, no_chip, poschips;
    double a, Rx, Ry, bet = 100;
    // On starting movement
    private float distance;
    private float directionX;
    private float directionY;
    private double X = startX;
    private double Y = startY;
    private boolean moving = true;

    public chipsRed(double x, double y, double X, double Y, double endX, double endY, double speed
            , double distance, double directionX, double directionY, double elapsed, int price, int choose) {
        this.X = X;
        this.Y = Y;
        this.choose = choose;
        this.startX = (float) x;
        this.startY = (float) y;
        this.endX = (float) endX;
        this.endY = (float) endY;
        this.speed = (float) speed;
        this.distance = (float) distance;
        this.directionX = (float) directionX;
        this.directionY = (float) directionY;
        this.elapsed = (float) elapsed;
        this.price = price;
        if (constan.selectbetroom == 2) {
            constan.chip_type.clear();
            constan.chip_type.add(25);
            constan.chip_type.add(50);
            constan.chip_type.add(100);
            constan.chip_type.add(500);
            constan.chip_type.add(1000);
        }
        if (constan.selectbetroom == 0) {
            constan.chip_type.clear();
            constan.chip_type.add(1);
            constan.chip_type.add(5);
            constan.chip_type.add(10);
            constan.chip_type.add(25);
            constan.chip_type.add(50);
        }
        if (constan.selectbetroom == 1) {
            constan.chip_type.clear();
            constan.chip_type.add(10);
            constan.chip_type.add(25);
            constan.chip_type.add(50);
            constan.chip_type.add(100);
            constan.chip_type.add(500);
        }
    }

    public void paint(FMXGraphics g) {
        if (price == 1 && constan.selectbetroom == 0)
            g.drawImage(constan.chip1, (int) X, (int) Y, 0, 0, 48, 48);
        if (price == 5 && constan.selectbetroom == 0)
            g.drawImage(constan.chip2, (int) X, (int) Y, 0, 0, 48, 48);
        if (price == 10 && constan.selectbetroom == 0)
            g.drawImage(constan.chip3, (int) X, (int) Y, 0, 0, 48, 48);
        if (price == 25 && constan.selectbetroom == 0)
            g.drawImage(constan.chip4, (int) X, (int) Y, 0, 0, 48, 48);
        if (price == 50 && constan.selectbetroom == 0)
            g.drawImage(constan.chip5, (int) X, (int) Y, 0, 0, 48, 48);

        if (price == 10 && constan.selectbetroom == 1)
            g.drawImage(constan.chip01, (int) X, (int) Y, 0, 0, 48, 48);
        if (price == 25 && constan.selectbetroom == 1)
            g.drawImage(constan.chip02, (int) X, (int) Y, 0, 0, 48, 48);
        if (price == 50 && constan.selectbetroom == 1)
            g.drawImage(constan.chip03, (int) X, (int) Y, 0, 0, 48, 48);
        if (price == 100 && constan.selectbetroom == 1)
            g.drawImage(constan.chip04, (int) X, (int) Y, 0, 0, 48, 48);
        if (price == 500 && constan.selectbetroom == 1)
            g.drawImage(constan.chip05, (int) X, (int) Y, 0, 0, 48, 48);

        if (price == 25 && constan.selectbetroom == 2)
            g.drawImage(constan.chip25, (int) X, (int) Y, 0, 0, 48, 48);
        if (price == 50 && constan.selectbetroom == 2)
            g.drawImage(constan.chip50, (int) X, (int) Y, 0, 0, 48, 48);
        if (price == 100 && constan.selectbetroom == 2)
            g.drawImage(constan.chip100, (int) X, (int) Y, 0, 0, 44, 48);
        if (price == 500 && constan.selectbetroom == 2)
            g.drawImage(constan.chip500, (int) X, (int) Y, 0, 0, 48, 48);
        if (price == 1000 && constan.selectbetroom == 2)
            g.drawImage(constan.chip1k, (int) X, (int) Y, 0, 0, 48, 48);

//        canvas = new Canvas(constan.fram);
    }

    public void tick(float deltaTime) {
        if (moving == true) {
            X += directionX * speed * elapsed;
            Y += directionY * speed * elapsed;
            if (Math.sqrt(Math.pow(X - startX, 2) + Math.pow(Y - startY, 2)) >= distance) {
                X = endX;
                Y = endY;
                moving = false;
                constan.chipsReds.remove(this);
                ss();
            }
            constan.eieiza=0;
        }

            constan.eieiza=1;
    }

    public void ss() {
        img_no = 4;
        constan.bet_sub[choose - 1] += price;
        Log.i("bet_amount", "ss: " + constan.bet_sub[choose - 1]);
        int tmp = constan.bet_sub[choose - 1];
        for (int i = constan.chip_type.size() - 1; i >= 0; i--) {
            int cound = (int) Math.floor(tmp / constan.chip_type.get(i));
            show_chips.add(cound);
            tmp %= constan.chip_type.get(i);
        }

        for (int i = 0; i < constan.chip_type.size(); i++) {
            for (int j = 0; j < show_chips.get(i); j++) {
                Log.i("show_chips", "ss: " + show_chips.get(i));
                dy -= 5;
                no_chip++;
                ShowChipz showChips = new ShowChipz(endX, endY + dy, img_no, constan.chip_type.get(img_no), no_chip, choose, endX, endY);

                if (choose == 1) constan.arrShowChips1.add(showChips);
                if (choose == 2) constan.arrShowChips2.add(showChips);
                if (choose == 3) constan.arrShowChips3.add(showChips);
                if (choose == 4) constan.arrShowChips4.add(showChips);
                if (choose == 5) constan.arrShowChips5.add(showChips);
                if (choose == 6) constan.arrShowChips6.add(showChips);
                if (choose == 7) constan.arrShowChips7.add(showChips);
                if (choose == 8) constan.arrShowChips8.add(showChips);
                if (choose == 9) constan.arrShowChips9.add(showChips);
                if (choose == 10) constan.arrShowChips10.add(showChips);
                if (choose == 11) constan.arrShowChips11.add(showChips);
                if (choose == 12) constan.arrShowChips12.add(showChips);
                if (choose == 13) constan.arrShowChips13.add(showChips);
                if (choose == 14) constan.arrShowChips14.add(showChips);
            }
            img_no--;
        }
    }

}
