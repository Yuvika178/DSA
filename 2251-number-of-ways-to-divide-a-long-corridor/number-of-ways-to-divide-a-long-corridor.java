class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;

        int totalSeats = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') totalSeats++;
        }

        // If seats are odd or zero, no valid division
        if (totalSeats == 0 || totalSeats % 2 != 0) {
            return 0;
        }

        long ways = 1;
        int seatCount = 0;
        int plantCount = 0;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;

                // Every time a new section starts (after 2 seats)
                if (seatCount > 2 && seatCount % 2 == 1) {
                    ways = (ways * (plantCount + 1)) % MOD;
                    plantCount = 0;
                }
            } else { // 'P'
                if (seatCount >= 2 && seatCount % 2 == 0) {
                    plantCount++;
                }
            }
        }

        return (int) ways;
    }
}
