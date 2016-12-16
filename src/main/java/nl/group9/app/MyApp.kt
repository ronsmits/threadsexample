package nl.group9.app

import com.google.inject.Guice
import javafx.application.Application
import nl.group9.server.KeepassServer
import nl.group9.view.MainView
import tornadofx.App
import tornadofx.DIContainer
import tornadofx.FX
import kotlin.reflect.KClass

class MyApp: App(MainView::class, Styles::class) {
    val guice = Guice.createInjector(GuiceConfigurator(), GuiceServletConfigurator())
    val keepassServer : KeepassServer = guice.getInstance(KeepassServer::class.java)
    init {
        println("Starting guice and server")
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T = guice.getInstance(type.java)
        }
        keepassServer.start()
    }

    override fun stop() {
        keepassServer.stop()
    }
}

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}
