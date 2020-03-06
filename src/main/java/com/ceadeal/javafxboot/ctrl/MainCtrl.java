package com.ceadeal.javafxboot.ctrl;

import cn.hutool.core.date.DateUtil;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * 主界面控制器
 *
 * @author westinyang
 * @date 2019/4/23 2:01
 */
@Slf4j
@FXMLController
public class MainCtrl implements Initializable {

    // 主容器
    public Pane rootPane;

    public Button btnAlert, btnChooseFile;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.info("initialize: {}", location.getPath());
    }

    /**
     * 弹出框按钮单击事件
     * @param actionEvent
     */
    public void onBtnAlertClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("当前时间：" + DateUtil.now());
        alert.show();
    }

    /**
     * 选择文件按钮单机事件
     * @param actionEvent
     */
    public void onBtnChooseFileClick(ActionEvent actionEvent) {
        Window window = rootPane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        // 文件类型过滤器
        /*FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Excel files (*.xls, *.xlsx)", "*.xls", "*.xlsx");
        fileChooser.getExtensionFilters().add(filter);*/
        // ...
        File file = fileChooser.showOpenDialog(window);
        String fileName = file == null ? "" : file.getName();
        String fileAbsolutePath = file == null ? "" : file.getAbsolutePath();

        if (file != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("文件路径：" + fileAbsolutePath);
            alert.show();
        }
    }
}
