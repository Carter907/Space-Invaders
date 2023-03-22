package kar.creata.spaceinvaders

import javafx.application.Application
import javafx.application.Platform
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class App: Application() {
    override fun start(primaryStage: Stage?) {
        primaryStage?.let {


            val loader = FXMLLoader(this.javaClass.getResource("home.fxml"));

            val scene: Scene = Scene(loader.load(), 500.0, 500.0);
            scene.stylesheets.add(
                javaClass.getResource("assets/css/Application.css")?.toExternalForm() ?: error("no file found")
            );

            primaryStage.scene = scene;
            primaryStage.title = "Space Invaders";
            primaryStage.show();

        }
    }

}

fun main(args: Array<String>) {
    Platform.startup {
        App().start(Stage());
    }
}