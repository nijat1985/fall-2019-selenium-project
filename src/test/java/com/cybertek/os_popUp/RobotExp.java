package com.cybertek.os_popUp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotExp
{

    public static void main(String[] args)
    {

        try {

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
        }
        catch (AWTException e) {
            e.printStackTrace();
        }
    }
}