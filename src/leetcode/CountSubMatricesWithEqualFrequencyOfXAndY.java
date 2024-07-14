package leetcode;
//https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/



class CountSubMatricesWithEqualFrequencyOfXAndY {
    static class Pair{
        int xf;
        int yf;
        public Pair(int xf,int yf){
            this.xf=xf;
            this.yf=yf;
        }
    }
    public int numberOfSubmatrices(char[][] grid) {
        Pair[][] freq=new Pair[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            int x=0;
            int y=0;
            //horizontal summing
            //x and y values are added up for  incremental manner for every cell
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='X'){
                    x++;
                }
                else if(grid[i][j]=='Y'){
                    y++;
                }
                freq[i][j]=new Pair(x,y);
            }
        }
        //vertical summation
        for(int j=0;j<grid[0].length;j++){
            for(int i=1;i<grid.length;i++){
                freq[i][j].xf+=freq[i-1][j].xf;
                freq[i][j].yf+=freq[i-1][j].yf;
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(freq[i][j].xf==freq[i][j].yf&&freq[i][j].xf>0){
                    count++;
                }
            }
        }
        return count;
    }
}