# JavaFX系列项目模板
- **[JDK8 & JavaFX & SpringBoot](https://gitee.com/westinyang/javafx-boot)** `加持SpringBoot，项目示例，Maven打包插件带可执行程序`
- [JDK8 & JavaFX](https://gitee.com/westinyang/javafx-start) `不依赖SpringBoot，项目示例，Maven打包插件带可执行程序`
- [JDK11+ & JavaFX15](https://gitee.com/westinyang/javafx-jdk11-start)  
    - `使用 jlink 打包为精简版jvm，7z压缩后约16m左右`
    - `使用 GraalVM native-image 静态编译不依赖jvm，7z压缩后13m左右`

---

![LOGO](./src/main/resources/icon/icon.png)

# javafx-boot

- [Gitee](https://gitee.com/westinyang/javafx-boot) 
- [Gtihub](https://github.com/westinyang/javafx-boot)

## 介绍
JavaFx+SpringBoot快速开始脚手架，应用示例。非SpringBoot版本请移步至该仓库：[javafx-start](https://gitee.com/westinyang/javafx-start)

> 参考资料：https://segmentfault.com/a/1190000014037443

Maven插件
- [springboot-javafx-support](https://github.com/roskenet/springboot-javafx-support)
- [JavaFX Maven Plugin](https://github.com/javafx-maven-plugin/javafx-maven-plugin)

## 配置文件
```yaml
javafx:
  title: JavaFx & SpringBoot
  appicons: /icon/icon.png
  stage:
    width: 640
    height: 480
#    style: DECORATED  # javafx.stage.StageStyle [DECORATED, UNDECORATED, TRANSPARENT, UTILITY, UNIFIED]
#    resizable: false
```

## 运行效果

![截图](./screenshot/03.gif)

## 打包教程

`mvn jfx:native`

## 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request
