package ZAD1;

public class PascalTriangle {
    int[][] triangle;

    public void compute(int n) {
        if(n<=0) throw new IllegalArgumentException("n musi byc wieksze od 0");
        else {
            int[][] tri = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        tri[i][j] = 1;
                    } else {
                        tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];
                    }
                }
            }
            triangle=tri;
        }
    }
    public int[][] getTriangle(){
        return triangle;
    }
}
