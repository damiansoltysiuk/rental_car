package controller.servlet;

import model.car.Car;
import service.CarManagementService;
import service.impl.CarManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CarListServlet", urlPatterns = "/carList")
public class CarListServlet extends HttpServlet {
    CarManagementService carManagementService;

    @Override
    public void init() throws ServletException {
        carManagementService = new CarManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = carManagementService.getCars();
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("carList.jsp").forward(req,resp);
    }
}
