public class KnightTour {

    private static int[] pathRow={2,1,-1,-2,-2,-1,1,2};
    private static int[] pathColumn={1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args){
        int[][] board = {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}
        };
        knightTour(board,0,0,0);
    }

    private static boolean knightTour(int[][] board, int row, int column, int step) {
        if(step == 63){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        for(int i=0; i<pathRow.length; i++){
            int newRow = row + pathRow[i];
            int newColumn = column + pathColumn[i];

            if(isValidMove(board, newRow, newColumn)){
                step++;
                board[newRow][newColumn] = step;

                if(knightTour(board,newRow,newColumn,step)){
                    return true;
                }
                //backtracking
                step--;
                board[newRow][newColumn]=0;
            }
        }
        return false;
    }

    private static boolean isValidMove(int[][] board, int newRow, int newColumn) {
        return (newRow >= 0 && newRow < 8 && newColumn < 8 && newColumn >=0
        && board[newRow][newColumn]==0);
    }
}
