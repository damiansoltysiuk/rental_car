package util;

import java.util.Arrays;
import java.util.List;

public class AttributeUtil {
    public static final List<String> FEATURE_LIST = Arrays.asList(
            "Automatic transmission", "Automatic air condition", "Front parking sensor", "Rear parking sensor",
            "Reversing camera", "Keyless", "Isofix", "Leather steering wheel", "Leather seats", "Rain sensor",
            "Sound system", "Sunroof", "Led lights");
    public static final List<String> CAR_TYPE_LIST = Arrays.asList(
            "SMALL_CAR", "MEDIUM_CAR", "LARGE_CAR", "ESTATE_CAR", "PREMIUM_CAR", "BUS", "SUV");
    public static final List<String> CAR_STATUS_LIST = Arrays.asList(
            "RENTED", "RESERVED", "UNRESERVED", "IN_SERVICE");
}
