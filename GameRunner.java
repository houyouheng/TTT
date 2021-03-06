import java.util.*;
class GameRunner{

  private static String gameStatus;

//change the game status
  public static void changeGameStatus(String i){
    gameStatus = i;
  }
//check if there are winners
  public boolean checkForWin(String winner, Board b){

    for(int i = 0; i < 3; i++){
      if(b.getBoard(i,0) == winner &&
        (b.getBoard(i,1) == winner) &&
        (b.getBoard(i,2) == winner)){
          return true;
      }

      else if(b.getBoard(0,i) == winner &&
        b.getBoard(1,i) == winner &&
        b.getBoard(2,i) == winner){
          return true;
      }
    }

    if(b.getBoard(0,0) == winner &&
      b.getBoard(1,1) == winner &&
      b.getBoard(2,2) == winner){
        return true;
    }

    else if(b.getBoard(2,0) == winner &&
      b.getBoard(1,1) == winner &&
      b.getBoard(0,2) == winner){
        return true;
    }
    return false;
  }

//simple welcome message
  public String welcomeMessage(){
    return "Welcome to my TicTacToe game!";
  }

//main game logic
  public static void main(String[] args) {
    GameRunner myClient = new GameRunner();
    Board myBoard = new Board();
    Player myPlayer = new Player();
    Scanner playAgain = new Scanner(System.in);
    System.out.println(myClient.welcomeMessage());
    myPlayer.setPlayerNames();
    myPlayer.whoIsFirst();
    myBoard.startBoard(3);

    do{
      System.out.println(myBoard.toString());
      System.out.print(myPlayer.getPlayer(0) +
        " Where do you want to set your piece? ");
      myBoard.makeMoveX();
      myBoard.isFull();
      if(myClient.checkForWin("X", myBoard) == true) {
        gameStatus = "FIRST_WON";
      }
      if (gameStatus == "FIRST_WON") {
            System.out.println(myPlayer.getPlayer(0) + " won!");
            break;
         } else if (gameStatus == "SECOND_WON") {
            System.out.println(myPlayer.getPlayer(1) + " won!");
            break;
         } else if (gameStatus == "DRAW") {
            System.out.println("It's a Draw!");
            break;
         }
      System.out.println(myBoard.toString());
      System.out.print(myPlayer.getPlayer(1) +
        " Where do you want to set your piece? ");
      myBoard.makeMoveO();
      if(myClient.checkForWin("O", myBoard)){
        gameStatus = "SECOND_WON";
      }
      if (gameStatus == "FIRST_WON") {
            System.out.println(myPlayer.getPlayer(0) + " won!");
            break;
         } else if (gameStatus == "SECOND_WON") {
            System.out.println(myPlayer.getPlayer(1) + " won!");
            break;
         } else if (gameStatus == "DRAW") {
            System.out.println("It's a Draw!");
            break;
         }
    }while(gameStatus == "PLAY");
    System.out.println(myBoard.toString());
  }
}
