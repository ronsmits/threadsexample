package nl.group9.app;

import com.google.inject.servlet.ServletModule;
import nl.group9.server.CommandServlet;

/**
 * Created by ronsmi on 12/13/2016.
 */
public class GuiceServletConfigurator extends ServletModule
{
    @Override
    protected void configureServlets() {
        bind(CommandServlet.class);
        serve("/*").with(CommandServlet.class);
    }
}
