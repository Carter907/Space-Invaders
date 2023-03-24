package kar.creata.spaceinvaders.controllers

import javafx.application.Platform
import javafx.concurrent.Task
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.layout.FlowPane
import javafx.stage.Stage
import kar.creata.spaceinvaders.model.Player
import java.net.URL
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class GameController : Initializable {

    @FXML
    private lateinit var layout: FlowPane

    private lateinit var scene: Scene;

    private val service: ExecutorService = Executors.newSingleThreadExecutor();

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        val player: Player = Player();
        player.view.translateX = 250.0;
        player.view.translateY = 400.0;
        layout.children.add(player.view);
        var getScene = object : Task<Unit>() {
            override fun call() {
                while (layout.scene == null) {
                    Thread.sleep(10)
                }
                scene = layout.scene;

                scene.setOnKeyPressed {
                    println(it.code)
                    when (it.code) {
                        KeyCode.A -> player.view.translateX -= 5;
                        KeyCode.D -> player.view.translateX += 5;

                        else -> {}
                    }
                }


            }
        }
        service.execute(getScene);

    }


}