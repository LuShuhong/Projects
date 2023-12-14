public class Main {
    public static void main(String[] args) {
        ReducedSpeedNow reducedSpeedNow = new ReducedSpeedNow();
        System.out.println(reducedSpeedNow.getArea());
        System.out.println(reducedSpeedNow.getFontColor());
        System.out.println(reducedSpeedNow.getBackgroundColor());
        System.out.println(reducedSpeedNow.getMessage());
        System.out.println(reducedSpeedNow.getShape());

        SpeedLimitCircle speedLimitCircle = new SpeedLimitCircle();
        System.out.println(speedLimitCircle.getArea());
        System.out.println(speedLimitCircle.getFontColor());
        System.out.println(speedLimitCircle.getBackgroundColor());
        System.out.println(speedLimitCircle.getMessage());
        System.out.println(speedLimitCircle.getShape());

        GiveWay giveWay = new GiveWay();
        System.out.println(giveWay.getArea());
        System.out.println(giveWay.getFontColor());
        System.out.println(giveWay.getBackgroundColor());
        System.out.println(giveWay.getMessage());
        System.out.println(giveWay.getShape());
    }
}
