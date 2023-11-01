package com.yusuf.kusar.couriertracking.util;

import com.yusuf.kusar.couriertracking.constant.CourierTrackingConstant;

public class GeolocationUtil {

    private static GeolocationUtil instance;

    private GeolocationUtil() {
    }

    public static synchronized GeolocationUtil getInstance() {
        if (instance == null) {
            instance = new GeolocationUtil();
        }
        return instance;
    }

    public double calculateDistance(double startLat, double startLng, double endLat, double endLng) {

        double latDistance = Math.toRadians(startLat - endLat);
        double lngDistance = Math.toRadians(startLng - endLng);

        double a = (Math.sin(latDistance / 2) * Math.sin(latDistance / 2)) +
                (Math.cos(Math.toRadians(startLat))) *
                        (Math.cos(Math.toRadians(endLat))) *
                        (Math.sin(lngDistance / 2)) *
                        (Math.sin(lngDistance / 2));

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return CourierTrackingConstant.AVERAGE_RADIUS_OF_EARTH * c;
    }
}
