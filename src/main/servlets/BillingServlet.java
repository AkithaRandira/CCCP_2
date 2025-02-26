package main.servlets;

import main.app.ApplicationContext;
import main.app.UserInteraction;
import main.service.concurrency.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class BillingServlet extends HttpServlet {
    private UserInteraction userInteraction;
    private RequestHandler requestHandler;

    @Override
    public void init() throws ServletException {
        System.out.println("Initializing BillingServlet...");
        // Retrieve the ApplicationContext from the ServletContext
        ApplicationContext context = (ApplicationContext) getServletContext().getAttribute("appContext");
        if (context == null) {
            System.err.println("ApplicationContext is null in BillingServlet.init()");
        } else {
            // Initialize UserInteraction with the ApplicationContext
            this.userInteraction = new UserInteraction(context);
            System.out.println("BillingServlet initialized successfully.");
        }

        // Initialize the RequestHandler for concurrency
        this.requestHandler = new RequestHandler();
        System.out.println("RequestHandler initialized successfully.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Generate a unique billing session token if not present
        String billingToken = (String) req.getSession().getAttribute("billingToken");
        if (billingToken == null) {
            billingToken = UUID.randomUUID().toString();
            req.getSession().setAttribute("billingToken", billingToken);
        }

        clearSessionMessages(req);
        req.getRequestDispatcher("/WEB-INF/jspFiles/billing.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        clearSessionMessages(req);

        // Get billing token from session
        final String billingToken = (String) req.getSession().getAttribute("billingToken");
        if (billingToken == null) {
            req.getSession().setAttribute("billingToken", UUID.randomUUID().toString());
        }

        // Capture effectively final variables for lambda
        final HttpServletRequest request = req;
        final HttpServletResponse response = resp;

        // Wrap the request processing logic in a Runnable
        Runnable task = () -> {
            try {
                // Delegate to UserInteraction for processing the request
                userInteraction.processRequest(request.getParameterMap(), request, billingToken);

                // Redirect or forward based on processing results
                if (request.getSession().getAttribute("errorMessage") != null) {
                    request.getRequestDispatcher("/WEB-INF/jspFiles/billing.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/WEB-INF/jspFiles/billing.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // Add the task to the RequestHandler for processing
        requestHandler.handleRequest(task);
    }


    private void clearSessionMessages(HttpServletRequest req) {
        req.getSession().removeAttribute("successMessage");
        req.getSession().removeAttribute("errorMessage");
    }
}
