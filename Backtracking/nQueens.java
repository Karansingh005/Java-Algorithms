public class nQueens {
    public static void main(String args[]){
        int[][] board = {{0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        int n = board.length;
        if(saveTheQueens(board,0,n))
        {
            for(int k=0; k<n; k++){
                for(int j=0; j<n; j++){
                    System.out.print(board[k][j]+" ");
                }
                System.out.println();
            }
        }
        else
            {
            System.out.println("No solution for this problem exists.");
        }
    }

    private static boolean saveTheQueens(int[][] board, int col, int n) {
        if(col>=n){
            return true;
        }
        //choices
        for(int row=0; row<n; row++){
            //is it safe??
            if(isSafe(board,row,col,n)){
                board[row][col] = 1;
                //checking reccursion for the next column
                if(saveTheQueens(board,col+1,n)){
                    return true;
                }
                //backtracking if above decision fails
                board[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        int i,j;
        //checking for left of current element
        for(i=0; i<col; i++){
            if(board[row][i]==1){
                return false;
            }
        }
        //checking for upper left of the current element
        for(i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j]==1){
                return false;
            }
        }
        //checking for lower left of the current element
        for(i=row, j=col; i<n && j>=0; i++, j--){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }
}
