import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
    // creates n-by-n grid, with all sites initially blocked
    int grid[][];
    int n;
    int arrf[];
    WeightedQuickUnionUF wu;
    public Percolation(int n){
        this.n=n;
        grid = new int[n][n];
        arrf=new int[n+2];
        //arrf[n*n]=1;
        //arrf[n*n+1]=1;
        int c=0;
        wu=new WeightedQuickUnionUF(n*n+2);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=0;
                //arrf[c++]=0;
            }
        }
        for(int i=0;i<n;i++){
        wu.union(n*n,i);
        wu.union(n*n+1,n*n-i-1);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        grid[row][col]=1;
        int ind=n*row+col;
        int bottom=n*(row+1)+col;
        int top=n*(row-1)+col;
        if(row!=0){
            if(grid[row-1][col]==1)
            wu.union(top,ind);
        }
        if(row!=n-1){
            if(grid[row+1][col]==1)
            wu.union(bottom,ind);
        }
        if(col!=0){
            int left;
            left=n*(row+1)+col-1;
            if(grid[row][col-1]==1)
            wu.union(left,ind);
        }
        if(col!=n-1){
            int right=n*(row+1)+col-1;
            if(grid[row][col+1]==1)
            wu.union(right,ind);
        }
        //arrf[ind]=1;
        return;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if(grid[row][col]==1) return true;
        return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        int ele=n*row+col;
        if(wu.connected(n*n,ele))return true;
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return 1;
    }

    // does the system percolate?
    public boolean percolates(){
        if(wu.connected(n*n,n*n+1))return true;
        return false;
    }

    // test client (optional)
    public static void main(String[] args){
    Percolation p = new Percolation(5); // 5x5 grid

    System.out.println("Initially, percolates? " + p.percolates());

    p.open(0, 0);
    p.open(1, 0);
    //p.open(2, 0);
    p.open(3, 0);
    p.open(4, 0);

    System.out.println("After opening a vertical path in the first column...");
    System.out.println("Is site (4, 0) open? " + p.isOpen(4, 0));
    System.out.println("Is site (4, 0) full? " + p.isFull(4, 0));
    System.out.println("opening 2,0");
    p.open(2,0);
    System.out.println("Does the system percolate? " + p.percolates());

    p.open(2, 0);
    System.out.println("Opened (2, 0) but connected to top, so isFull should be true: " + p.isFull(2, 0));


System.out.println("Runned");
    }
}
