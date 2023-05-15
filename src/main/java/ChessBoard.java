import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ChessBoard {
    /**
     * 按照明棋棋盘从右至左，从上到下的顺序，从1开始编号直到16。
     * 前16个为红方棋子，后16个为黑方棋子
     * 兵兵兵兵兵  54321
     * 炮炮       76
     * 车马相仕帅仕相马车 16 15 14 13 12 11 10 9 8
     */
    private char[][] board={
            {'车','马','相','仕','帅','仕','相','马','车','炮','炮','兵','兵','兵','兵','兵','车','马','相','仕','帅','仕','相','马','车','炮','炮','兵','兵','兵','兵','兵'}
            ,{'车','马','相','仕','帅','仕','相','马','车','炮','炮','兵','兵','兵','兵','兵','车','马','相','仕','帅','仕','相','马','车','炮','炮','兵','兵','兵','兵','兵'}
    };

    private String[] bd={
            ""
            ,""
    };

    private boolean isFirst=true;

    private Scanner sc=new Scanner(System.in);

    /**
     * 我方是否为红方
     */
    private boolean isRed=true;

    private ArrayList<char[]> boardList=new ArrayList<>();

    public void setRed() {
        System.out.println("红方写1，黑方写0");
        isRed=(sc.nextInt()==1);
        sc.nextLine();
        System.out.println("您为："+(isRed?"红方":"黑方"));
        System.out.println();
    }

    public void refreshBoardList(){
        boardList.clear();
        Collections.addAll(boardList, board);
    }

    public void rotateMatch(){
        while(!boardList.isEmpty()){
            System.out.println("输入棋子与坐标，空格分开，eg:车 1");
            int diff = 16;
            String[]line;
            int res;
            try{
                while(!boardList.isEmpty()){
                    //红方
                    System.out.println("现在输入红方棋子");
                    String input1 = sc.nextLine();
                    line = input1.split(" ");
                    res=match(line[0].charAt(0),Integer.parseInt(line[1]));
                    if(res<=3&&res!=0){
                        decideShowBoard(res);
                    }
                    if(boardList.isEmpty()){
                        break;
                    }
                    //黑方
                    System.out.println("现在输入黑方棋子");
                    String input2 = sc.nextLine();
                    line = input2.split(" ");
                    res=match(line[0].charAt(0),Integer.parseInt(line[1])+ diff);
                    if(res<=3&&res!=0){
                        decideShowBoard(res);
                    }
                }
            }catch(Exception e){
                System.out.println("输入格式不正确，请重新输入");
                sc.nextLine(); // 清空输入缓冲区，避免死循环
            }
        }
    }

    void decideShowBoard(int n){
        if(n>3){
            System.out.println("有"+n+"项符合要求");
            return;
        }
        if(n==0){
            System.out.println("无符合项");
            return;
        }
        System.out.println("有"+n+"项符合要求,输入1打印所有否则不打印");
        boolean res=sc.nextInt()==1;
        sc.nextLine();
        if(res){
            showBoardList();
        }else{
            System.out.println();
        }

    }


    public int match(char c, int index){
        index--;//index从1开始计数，到数组内需要-1
        ArrayList<char[]> tmp=new ArrayList<>();
        for(char[] anyBoard:this.boardList){
            if(anyBoard!=null&&anyBoard.length!=0&&anyBoard[index]==c){
                tmp.add(anyBoard);
            }
        }
        boardList=tmp;
        return boardList.size();
    }

    public void showBoardList(){
        if(isRed){
            for(char[] c:boardList){
                System.out.println("开始");
                //黑方
                for(int i=23;i<c.length;i++){
                    System.out.print(c[i]+"\t");
                }
                System.out.println();
                System.out.println("-----------------------------------");
                System.out.println("\t"+c[21]+"\t\t\t\t\t\t"+c[22]);
                System.out.println(c[16]+"\t\t"+c[17]+"\t\t"+c[18]+"\t\t"+c[19]+"\t\t"+c[20]);
                System.out.println("-----------------------------------");

                System.out.println("楚河-----汉界");

                //红方aka我方
                System.out.println("-----------------------------------");
                System.out.println(c[4]+"\t\t"+c[3]+"\t\t"+c[2]+"\t\t"+c[1]+"\t\t"+c[0]);
                System.out.println("\t"+c[6]+"\t\t\t\t\t\t"+c[5]);
                System.out.println("-----------------------------------");
                for(int i=15;i>=7;i--){
                    System.out.print(c[i]+"\t");
                }

                System.out.println();
                System.out.println("结束");
                System.out.println();
            }
        }else{
            for(char[] c:boardList){
                System.out.println("开始");
                //红方
                for(int i=7;i<16;i++){
                    System.out.print(c[i]+"\t");
                }
                System.out.println();
                System.out.println("-----------------------------------");
                System.out.println("\t"+c[5]+"\t\t\t\t\t\t"+c[6]);
                System.out.println(c[0]+"\t\t"+c[1]+"\t\t"+c[2]+"\t\t"+c[3]+"\t\t"+c[4]);
                System.out.println("-----------------------------------");

                System.out.println("楚河-----汉界");

                //黑方aka我方
                System.out.println("-----------------------------------");
                System.out.println(c[20]+"\t\t"+c[19]+"\t\t"+c[18]+"\t\t"+c[17]+"\t\t"+c[16]);
                System.out.println("\t"+c[22]+"\t\t\t\t\t\t"+c[21]);
                System.out.println("-----------------------------------");
                for(int i=31;i>=23;i--){
                    System.out.print(c[i]+"\t");
                }
                System.out.println();
                System.out.println("结束");
                System.out.println();
            }
        }

    }

    public boolean reStart(){
        if(isFirst){
            isFirst=false;
            return true;
        }
        System.out.println("输入1重新开始，否则结束");
        boolean res=sc.nextInt()==1;
        sc.nextLine();
        return res;
    }



}
