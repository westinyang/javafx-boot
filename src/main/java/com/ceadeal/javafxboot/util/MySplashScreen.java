package com.ceadeal.javafxboot.util;

import de.felixroske.jfxsupport.SplashScreen;
import javafx.scene.Parent;
import org.springframework.stereotype.Component;

/**
 * 启动首屏
 *
 * @author westinyang
 * @date 2019/4/23 1:28
 */
@Component
public class MySplashScreen extends SplashScreen {
    private static final String DEFAULT_IMAGE = "/splash/javafx.png";

    public MySplashScreen() {
        super();
    }

    @Override
    public Parent getParent() {
        return super.getParent();
    }

    @Override
    public boolean visible() {
        return true;
    }

    @Override
    public String getImagePath() {
        return "/image/splash_screen.png";
    }
}
