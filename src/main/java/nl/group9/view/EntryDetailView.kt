package nl.group9.view

import nl.group9.app.Model
import tornadofx.*

/**
 * Created by ronsmi on 12/13/2016.
 */
class EntryDetailView : View("My View") {
    val model : Model by di()
    override val root = vbox {

        form {
            fieldset("basic") {
                field("First name"){
                    textfield (model.activeModel.firstname)
                }
                field("Last name") {
                    textfield (model.activeModel.lastname)
                }
                button("ok"){

                    setOnAction {
                        model.activeModel.commit()
                    closeModal()}
                }
            }
        }
    }
}
