package com.fixent.sm.server.service.test;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.Timer;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class CenterJFrameOnScreen
{
  public static void main(String[] args)
  {
    new CenterJFrameOnScreen();
  }
  
  public CenterJFrameOnScreen()
  {
    // create a new jframe, and pack it
    JFrame frame = new JFrame();
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // make the frame half the height and width
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int height = screenSize.height;
    int width = screenSize.width;
    frame.setSize(width/2, height/2);

    // center the jframe on screen
    frame.setLocationRelativeTo(null);
    
    frame.setVisible(true);
  }
}