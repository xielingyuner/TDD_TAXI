package tdd.taxi;

public class Taxi {
    private static final double UNIT_PRICE = 0.8;

    private static final double LONG_DISTANCE_ADD_COST_PERCENTAGE = 0.5;

    private static final int EIGHT_KM_PERIOD = 8;

    private static final double STOP_CAR_COST_PER_MINUTE = 0.25;

    /**
     * 计算在某个距离，某停车时长时的花费
     *
     * @param distance       距离
     * @param stopMinuteNums 停车等待时长 单位：分钟
     * @return 在某个距离，某停车时长时的花费
     */
    public double calculate(int distance, int stopMinuteNums) {
        double stopCost = 0;
        if (stopMinuteNums > 0) {
            stopCost = stopMinuteNums * STOP_CAR_COST_PER_MINUTE;
        }

        double limit_8km_cost = UNIT_PRICE * distance;
        if (distance <= EIGHT_KM_PERIOD) {
            return limit_8km_cost + stopCost;
        }

        int longDistanceNum = distance - EIGHT_KM_PERIOD;
        double longDistanceCost = longDistanceNum * UNIT_PRICE * LONG_DISTANCE_ADD_COST_PERCENTAGE;
        return limit_8km_cost + longDistanceCost + stopCost;
    }
}
