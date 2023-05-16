public class Main {
    public static void main(String[] args) {
        ChessBoard chessBoard=new ChessBoard();
        while(chessBoard.reStart()){
            chessBoard.refreshBoardList();
            chessBoard.setRed();
            chessBoard.rotateMatch();
        }
    }
}