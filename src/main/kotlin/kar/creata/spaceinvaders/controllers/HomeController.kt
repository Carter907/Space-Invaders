package kar.creata.spaceinvaders.controllers

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.StackPane
import javafx.scene.text.Text
import kar.creata.spaceinvaders.App
import java.net.URL
import java.util.*

class HomeController : Initializable {

    @FXML
    lateinit var background: StackPane

    @FXML
    lateinit var title: Label

    @FXML
    lateinit var button: Button
    override fun initialize(location: URL?, resources: ResourceBundle?) {


        val image: ImageView = ImageView(
            (javaClass.getResource("../assets/images/Ship.png")?.toExternalForm()) ?: error("hoes mad")
        );

        title.graphic = image;


        button.onAction = EventHandler {


            (it.source as Node).scene.root = FXMLLoader.load(javaClass.getResource("../game.fxml"));
        }
    }
}