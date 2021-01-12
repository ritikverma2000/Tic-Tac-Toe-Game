import java.lang.reflect.Array;
import java.util.*;

public class tic_tac_toe_Code {
    static ArrayList<Integer>playerPositions=new ArrayList<>();
    static ArrayList<Integer>cpuPositions=new ArrayList<>();
    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},


        };
        /* 1 2 3
           4 5 6
           7 8 9
         */
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter your placement(1-9)");
            int playerpos = s.nextInt();
            while(playerPositions.contains(playerpos)||cpuPositions.contains(playerpos)){
                System.out.println("Enter the correct position as its already taken");
                playerpos = s.nextInt();
            }
            //System.out.println(pos);


            placingPieces(gameBoard, playerpos, "player");
            String result=CheckWinner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }
            Random rand=new Random();
            int cpupos=rand.nextInt(9)+1;
            while(playerPositions.contains(cpupos)||cpuPositions.contains(cpupos)){

                cpupos=rand.nextInt(9)+1;
            }
            placingPieces(gameBoard, cpupos, "cpu");
            printGameboard(gameBoard);
         result=CheckWinner();
         if(result.length()>0){
             System.out.println(result);
             break;
         }

        }

    }
    private static void printGameboard(char[][] gameBoard) {

        for (int i = 0; i < gameBoard.length ; i++) {
            for (int j = 0; j < gameBoard.length ; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();

        }
    }
    private static void placingPieces(char[][] gameBoard,int pos,String  user){
        char symbol='X' ;
        if(user.equals("player")){
            symbol='X';
            playerPositions.add(pos);
        }else if (user.equals("cpu")){
            symbol='O';
            cpuPositions.add(pos);
        }
        switch(pos){
            case 1:gameBoard[0][0]=symbol;
                break;
            case 2:gameBoard[0][2]=symbol;
                break;
            case 3:gameBoard[0][4]=symbol;
                break;
            case 4:gameBoard[2][0]=symbol;
                break;
            case 5:gameBoard[2][2]=symbol;
                break;
            case 6:gameBoard[2][4]=symbol;
                break;
            case 7:gameBoard[4][0]=symbol;
                break;
            case 8:gameBoard[4][2]=symbol;
                break;
            case 9:gameBoard[4][4]=symbol;
                break;
            default:
                System.out.println("Pls enter the correct position");


        }

    }
    public static String CheckWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftCol= Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List diagonal1 = Arrays.asList(1,5,9);
        List diagonal2 = Arrays.asList(7,5,3);
        List<List>WinningSenarios =new ArrayList<List>();
        WinningSenarios.add(topRow);
        WinningSenarios.add(midRow);
        WinningSenarios.add(bottomRow);
        WinningSenarios.add(leftCol);
        WinningSenarios.add(midCol);
        WinningSenarios.add(rightCol);
        WinningSenarios.add(diagonal1);
        WinningSenarios.add(diagonal2);
        for (List l :WinningSenarios){
            if(playerPositions.containsAll(l)){
                       return "congratulations you won";
            }else if (cpuPositions.containsAll(l)){
                return "computer won";
            }else if (playerPositions.size()+cpuPositions.size()==9){
                return "DRAW";
            }
        }

        return "";
    }

}


