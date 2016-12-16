package nl.group9.server;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceFilter;

/**
 * Created by ronsmi on 12/13/2016.
 */
@Singleton
public class KeepassServer
{
    private Server server;

    public void start() throws Exception {
        server = new Server(8080);
        ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        servletContextHandler.addFilter(GuiceFilter.class, "/", EnumSet.allOf(DispatcherType.class));
        servletContextHandler.addServlet(DefaultServlet.class, "/");
        server.start();
    }

    public void stop() throws Exception
    {
        server.stop();
    }
}
