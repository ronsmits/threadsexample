package nl.group9.server;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Singleton;
import nl.group9.app.Model;

/**
 * Created by ronsmi on 12/13/2016.
 */
@Singleton
public class CommandServlet extends HttpServlet
{
    @Inject
    private Model model;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("called");
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setContentType("text/plain");
        resp.setStatus(200);
        resp.getWriter().write(model.getActiveModel().getFirstname().getValue()+
            " "+
            model.getActiveModel().getLastname().getValue());
    }
}
