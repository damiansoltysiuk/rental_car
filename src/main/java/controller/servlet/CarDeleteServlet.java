package controller.servlet;

import service.CarManagementService;
import service.impl.CarManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="carDeleteServlet", urlPatterns = "/carDelete")
public class CarDeleteServlet extends HttpServlet {
    private CarManagementService service;

    @Override
    public void init() throws ServletException {
        service = new CarManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.deleteCar(Integer.parseInt(req.getParameter("id")));
        req.getRequestDispatcher("carList").forward(req, resp);
    }
}
