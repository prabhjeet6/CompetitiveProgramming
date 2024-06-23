package leetcode;


class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double glasses[][]=new double [102][102];
        glasses[0][0]=(double)poured;
        for(int i=0;i<=query_row;i++){
            for(int j=0;j<=i;j++){
                double q = (glasses[i][j] - 1.0) / 2.0;
                if(q>0){
                    glasses[i+1][j]=glasses[i+1][j]+q;
                    glasses[i+1][j+1]=glasses[i+1][j+1]+q;
                }
            }
        }
        return Math.min(1, glasses[query_row][query_glass]);
    }
}