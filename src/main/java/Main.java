public class Main {
    public static void main(String[] args) {
        ChessBoard chessBoard=new ChessBoard();
        while(chessBoard.reStart()){
            chessBoard.refreshBoardList();
            chessBoard.setRed();
            chessBoard.rotateMatch();
        }
        System.out.println("branch 9");
        System.out.println("branch 1");
        System.out.println("branch 10");
        System.out.println("branch 11");
    }
}