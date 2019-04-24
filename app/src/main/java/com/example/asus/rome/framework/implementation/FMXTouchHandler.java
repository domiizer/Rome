/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.rome.framework.implementation;

import java.util.List;

import android.view.View.OnTouchListener;

import com.example.asus.rome.framework.FMXInput.TouchEvent;

public interface FMXTouchHandler extends OnTouchListener {
    public boolean isTouchDown(int pointer);
    
    public int getTouchX(int pointer);
    
    public int getTouchY(int pointer);
    
    public List<TouchEvent> getTouchEvents();
}
