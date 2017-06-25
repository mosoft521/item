package alvintest;

import java.math.BigDecimal;

/**
 * Created by 001620 on 2014/9/13.
 */
public class LngLatAlvin {
    /**
     * 计算两点之间距离
     *
     * @param _lat1 - start纬度
     * @param _lon1 - start经度
     * @param _lat2 - end纬度
     * @param _lon2 - end经度
     * @return m(四舍五入)
     */
    public static int getDistance(double _lat1, double _lon1, double _lat2, double _lon2) {
        double lat1 = (Math.PI / 180) * _lat1;
        double lat2 = (Math.PI / 180) * _lat2;

        double lon1 = (Math.PI / 180) * _lon1;
        double lon2 = (Math.PI / 180) * _lon2;

        //地球半径
        double R = 6378.1;

        double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;

        return new BigDecimal(d * 1000).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    public static void main(String[] args) {
        System.out.println(getDistance(45.73990, 126.55893, 45.73876, 126.55037));
        System.out.println(getDistance(31.25372, 121.58249, 31.250656, 120.535846));//上海苏州
        System.out.println(getDistance(31.25372, 121.58249, 37.53656156286, 121.30955503009));//上海烟台
        System.out.println(getDistance(31.25372, 121.58249, 32.25372, 121.58249));//纬度1
        System.out.println(getDistance(31.25372, 121.58249, 31.25372, 122.58249));//经度1
        System.out.println(getDistance(31.25372, 121.58249, 32.25372, 122.58249));//经度纬度1
        System.out.println(getDistance(31.25372, 121.58249, 31.75372, 122.08249));//经度纬度0.5
        System.out.println(getDistance(31.25372, 121.58249, 31.50372, 121.83249));//经度纬度0.25
        System.out.println(getDistance(31.25372, 121.58249, 31.27372, 121.60249));//经度纬度0.02
        System.out.println(getDistance(31.25372, 121.58249, 31.26372, 121.59249));//经度纬度0.01
    }
}
