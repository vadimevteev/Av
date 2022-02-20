package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final String CAR_BRAND_DATA = "car.brand";
    private static final String MIN_PRICE_DATA = "car.minPrice";
    private static final String MIN_YEAR_DATA = "car.minYear";
    private static final String MAX_PRICE_DATA ="car.maxPrice";
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getCarBrand(){
        return getTestData(CAR_BRAND_DATA);
    }

    public static int getCarMinPrice(){
        return Integer.parseInt(getTestData(MIN_PRICE_DATA));
    }

    public static int getCarMinYear(){
        return Integer.parseInt(getTestData(MIN_YEAR_DATA));
    }

    public static int getCarMaxPrice(){
        return Integer.parseInt(getTestData(MAX_PRICE_DATA));
    }

    private static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
