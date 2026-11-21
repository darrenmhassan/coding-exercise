// Matrices: careful index bookkeeping. Direction arrays keep neighbour code tidy.
int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
boolean inBounds(int r, int c) { return r >= 0 && r < rows && c >= 0 && c < cols; }

// Spiral order with shrinking boundaries
int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
while (top <= bottom && left <= right) {
    for (int c = left; c <= right; c++) out.add(m[top][c]);
    for (int r = top + 1; r <= bottom; r++) out.add(m[r][right]);
    if (top < bottom) for (int c = right - 1; c >= left; c--) out.add(m[bottom][c]);
    if (left < right) for (int r = bottom - 1; r > top; r--) out.add(m[r][left]);
    top++; bottom--; left++; right--;
}
// Rotate 90 clockwise in place: transpose, then reverse each row.
