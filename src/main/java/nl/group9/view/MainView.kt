package nl.group9.view

import javafx.scene.web.WebView
import tornadofx.*

class MainView : View("Hello TornadoFX Application") {
    override val root = vbox {
        prefWidth=600.0
        prefHeight=480.0
        val webview = WebView()
            button("Open editor") {
                setOnAction {
                    openInternalWindow(EntryDetailView::class, modal = true)
                }
            }.style { backgroundColor+=c("#88B04B") }
    //this+=EntryDetailView::class
        button("reload webpage") {
            setOnAction { webview.engine.load("http://localhost:8080") }
        }
        this+=webview
    }
}
