package com.ceadeal.javafxboot;

import com.ceadeal.javafxboot.util.MySplashScreen;
import com.ceadeal.javafxboot.view.MainView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collection;
import java.util.Collections;

@Slf4j
@SpringBootApplication
public class Application extends AbstractJavaFxApplicationSupport implements ApplicationRunner {

    public static void main(String[] args) {
        // SpringApplication.run(Application.class, args);
        launch(Application.class, MainView.class, new MySplashScreen(), args);
    }

    /**
     * Spring 容器启动时执行一些初始化操作，如：读取外部配置文件
     * 此方法自行完之后，JavaFx应用程序启动画面才会关闭，原因分析：
     * 1 de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport[row:120].init() 重写了 javafx.application.Application.init()
     * 2 先启动SpringBoot应用，当SpringBoot应用启动完毕时，执行了两个异步操作，第二个异步操作是关闭启动画面
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationRunner.run...");
        // TODO: 显示启动首屏时加载自定义资源...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws Exception {
        log.info("init");
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        log.info("start");
        super.start(stage);
    }

    @Override
    public void beforeShowingSplash(Stage splashStage) {
        super.beforeShowingSplash(splashStage);
        log.info("beforeShowingSplash");
    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        log.info("beforeInitialView");
        super.beforeInitialView(stage, ctx);
        // 在非JavaFX应用程序主线程上运行指定的Runnable
        /*Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Spring application context Initialized.");
            alert.show();
        });*/
    }

    @Override
    public void stop() throws Exception {
        log.info("stop");
        super.stop();
    }

    // 虽然在application.yml中可以设置应用图标，但是首屏启动时的应用图标未改变，建议在此处覆盖默认图标
    @Override
    public Collection<Image> loadDefaultIcons() {
        return Collections.singletonList(new Image(getClass().getResource("/icon/icon.png").toExternalForm()));
    }
}
