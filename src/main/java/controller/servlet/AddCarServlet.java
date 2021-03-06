package controller.servlet;

import controller.error.ValidationError;
import model.car.*;
import service.CarManagementService;
import service.impl.CarManagementServiceImpl;
import util.AttributeUtil;
import util.Namespace;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.AttributeUtil.*;
import static util.Namespace.*;

@WebServlet(name = "addCarServlet", urlPatterns = {"/addCar"})
public class AddCarServlet extends HttpServlet {
    private CarManagementService service;
    private List<ValidationError> errors;

    @Override
    public void init() throws ServletException {
        service = new CarManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(CAR_FEATURE_LIST, FEATURE_LIST);
        req.setAttribute(CAR_TYPE, CAR_TYPE_LIST);
        req.setAttribute(CAR_STATUS, CAR_STATUS_LIST);
        req.getRequestDispatcher("addCar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        errors = new ArrayList<>();

        String registrationNumber = req.getParameter(CAR_REGISTRATION_NUMBER);
        if(service.registrationNumberIsExist(registrationNumber)) {
            errors.add(new ValidationError(ERROR_HEADER_CAR_REGISTRATION_NUMBER, ERROR_MESSAGE_CAR_REGISTRATION_NUMBER));
        }

        if(errors.size() != 0) {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/addCar.jsp").forward(req,resp);
            return;
        }

        CarMark mark = CarMark.valueOf(req.getParameter(CAR_MARK).toUpperCase());
        Double fuelLevel = Double.parseDouble(req.getParameter(CAR_FUEL_LEVEL));
        Integer yearProduction = Integer.parseInt(req.getParameter(CAR_YEAR_PRODUCTION));
        CarStatus carStatus = CarStatus.valueOf(req.getParameter(CAR_STATUS).toUpperCase());
        String carConditionNote = req.getParameter(CAR_CONDITION_NOTE);

        String modelName = req.getParameter(CAR_MODEL);
        String generation = req.getParameter(CAR_GENERATION);
        String fotoDirectory = req.getParameter(CAR_PHOTO_DIRECTORY);
        CarType carType = CarType.valueOf(req.getParameter(CAR_TYPE));

        Car car = new Car.Builder()
                .mark(mark)
                .registrationNumber(registrationNumber)
                .fuelLevel(fuelLevel)
                .productionYear(yearProduction)
                .carStatus(carStatus)
                .carConditionNote(carConditionNote)
                .build();

        Model model = new Model.Builder()
                .name(modelName)
                .generation(generation)
                .carType(carType)
                .fotoDirectory(fotoDirectory)
                .build();

        String[] featureArray = req.getParameterValues(CAR_FEATURE);
        String equipmentDescription = stringArrayToString(featureArray);
        String equipmentName = req.getParameter(CAR_EQUIPMENT_VERSION);
        EquipmentVersion ev = new EquipmentVersion(equipmentName, equipmentDescription);

        ev = service.findPrimaryEquipmentVersion(ev);
        model.setEquipmentVersion(ev);
        model = service.findPrimaryModel(model);
        car.setModel(model);
        service.saveCar(car);

        req.getRequestDispatcher("carList").forward(req, resp);
    }

    private String stringArrayToString(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s).append("; ");
        }
        return sb.toString().trim();
    }
}
