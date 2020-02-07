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

import static util.Namespace.CAR;

@WebServlet(name = "carInfoServlet", urlPatterns = "/carInfo")
public class CarInfoServlet extends HttpServlet {
    CarManagementService service;

    @Override
    public void init() throws ServletException {
        service = new CarManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer carID = Integer.parseInt(req.getParameter("id"));
        Car car = service.getCarByID(carID);
        req.setAttribute(CAR, car);
        req.getRequestDispatcher("/carInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
