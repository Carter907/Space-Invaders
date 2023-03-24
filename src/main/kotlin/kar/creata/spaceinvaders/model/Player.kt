package kar.creata.spaceinvaders.model

import javafx.scene.image.ImageView

class Player {

    val view = ImageView(
        javaClass.getResource("../assets/images/Ship.png")?.toExternalForm() ?: error ("oh no")
    )

}