import model.*;
import model.car.*;
import model.user.Address;
import model.user.Role;
import model.user.User;
import model.user.UserStatus;
import service.UserManagementService;
import service.impl.UserManagementServiceImpl;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Car car1 = new Car.Builder().registrationNumber("BS 61654").carConditionNote("Condition: OK").fuelLevel(1.0).mark(CarMark.CITROEN).productionYear(2005).carStatus(CarStatus.UNRESERVED).build();
        Car car2 = new Car.Builder().registrationNumber("BI 88688").carConditionNote("Condition: OK").fuelLevel(1.0).mark(CarMark.BMW).productionYear(2015).carStatus(CarStatus.UNRESERVED).build();

        Model model1 = new Model.Builder().carType(CarType.MEDIUM_CAR).fotoDirectory("c4sc.pl/BS61654").generation("I").name("C4").equipmentVersionID(1).build();
        Model model2 = new Model.Builder().carType(CarType.PREMIUM_CAR).fotoDirectory("syndykat.pl/BI88688").generation("F10").name("330i").equipmentVersionID(2).build();

        EquipmentVersion equipmentVersion1 = new EquipmentVersion("Exlusive", "Full Option");
        EquipmentVersion equipmentVersion2 = new EquipmentVersion("Individual", "Premium+");

        User user1 = new User.Builder()
                .userName("Damian")
                .userSurname("Solti")
                .userStatus(UserStatus.BANNED)
                .discount(1)
                .login("danyy")
                .password("****")
                .phoneNumber("111222333")
                .address(new Address("Sienkiewicza", "22/30", "11-222", "Pasym", "Poland").toString())
                .build();

        User user2 = new User.Builder()
                .userName("Bobby")
                .userSurname("Stamp")
                .userStatus(UserStatus.BANNED)
                .discount(3)
                .login("boblob")
                .password("***xx*")
                .phoneNumber("444222333")
                .address(new Address("st 43", "22/30", "55555", "Kansas", "USA").toString())
                .build();

        UserManagementService service = new UserManagementServiceImpl();
        service.saveUser(user1);
        service.saveUser(user2);

        service.saveRole(new Role("dada"));
        System.out.println(service.getRoleById(1));
        RentalCar rentalCar = new RentalCar.Builder().charge(22.22).dateFrom(new Date()).dateTo(new Date()).status("OPEN").build();
    }
}
