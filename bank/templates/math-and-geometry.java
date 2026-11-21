// Math and Geometry: e.g. fast exponentiation by squaring, O(log n).
double myPow(double x, int n) {
    long e = n;                          // long: -Integer.MIN_VALUE overflows int
    if (e < 0) { x = 1 / x; e = -e; }
    double result = 1;
    while (e > 0) {
        if ((e & 1) == 1) result *= x;
        x *= x;
        e >>= 1;
    }
    return result;
}
// Distances: compare squared distances to avoid sqrt. gcd(a, b) = b == 0 ? a : gcd(b, a % b).
