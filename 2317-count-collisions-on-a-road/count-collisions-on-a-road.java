public class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int l = 0;
        int r = n - 1;

        // ignore leading 'L's — woh kabhi collide nahi karengi
        while (l < n && directions.charAt(l) == 'L') {
            l++;
        }

        // ignore trailing 'R's — woh bhi kabhi collide nahi karengi
        while (r >= 0 && directions.charAt(r) == 'R') {
            r--;
        }

        int collisions = 0;
        // For the remaining segment [l..r], each car which is not 'S' (i.e. 'L' or 'R')
        // will definitely collide eventually
        for (int i = l; i <= r; i++) {
            char c = directions.charAt(i);
            if (c != 'S') {
                collisions++;
            }
        }

        return collisions;
    }
}
