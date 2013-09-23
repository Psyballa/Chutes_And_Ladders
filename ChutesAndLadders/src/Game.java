import java.util.*;

public class Game {

	/**
	 * @param args
	 */
	
	public static Player[] makePlayers(){
		Scanner sc = new Scanner(System.in);
		Player[] players = new Player[4];
		
		for(int i = 0; i < 4; i++){
			System.out.println("Enter Player " + (i+1) + "'s Name: ");
			players[i] = new Player(i, null, sc.next(), new Dice(1, new Random()));
			//players[i].setPosition(new Cell(0,0,0,Cell.CellType.NONE, players));
		}
		
		return players;
	}
	
	public static void BeginGame(Player[] players, Board b){
		for(int i = 0; i < players.length; i++){
			players[i].setPosition(new Cell(-1, -1, 0, Cell.CellType.NONE, players));
		}
	}
	public static void PlayGame(Player[] players, Board b){
		boolean winnerDecided = false;
		Player winner = null;
		/*
		 * For each player:
		 * Roll a dice,
		 * move # of spaces on board.
		 * If on Chute/Ladder, move accordingly
		 * */
		Scanner sc = new Scanner(System.in);
		while(!winnerDecided){
			for(int i = 0; i < players.length; i++){
				System.out.println("Press ENTER to roll the dice!");
				sc.nextLine();
				players[i].getDice().setRoll();
				System.out.println(players[i].getName() + " rolled a " + players[i].getDice().getRoll() + "!");
				//If the player's dice puts them over 10, go to next row
				
				if(players[i].getPosition().getX() + players[i].getDice().getRoll() > 10
						&& players[i].getPosition().getY() < 10){
					players[i].setPosition(b.getCell((players[i].getPosition().getX() +
							players[i].getDice().getRoll()) % 10,
							players[i].getPosition().getY() + 1));
				}
				else{
				players[i].setPosition(b.getCell((players[i].getPosition().getX() + 
						players[i].getDice().getRoll() % 10),
						players[i].getPosition().getY()));
				}
				
				for(Cell ladder : b.ladders.keySet()){
					if(players[i].getPosition().equals(ladder)){
						System.out.println("Ladder hit!");
						players[i].setPosition(b.ladders.get(ladder));
					}
				}
				for(Cell chute : b.chutes.keySet()){
					if(players[i].getPosition().equals(chute)){
						System.out.println("Chute hit!");
						players[i].setPosition(b.chutes.get(chute));
					}
				}
				System.out.println(players[i].getName() + " is at Cell " + players[i].getPosition().getID());
				if(players[i].getPosition().equals(b.getEnd()))
				{
					winnerDecided = true;
					winner = players[i];
				}
			}
		}
		System.out.println("Player " + (winner.getID()) + "wins!");
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		GameFrame gameFrame = new GameFrame();
		gameFrame.show();
		Player[] players = makePlayers();
		Board b = new Board(new Cell(0, 0, 0, Cell.CellType.NONE, players), new Cell(100, 10, 10, Cell.CellType.NONE, new Player[4]), players[0].getName(), 10, 10);
		b.begin = b.getCell(b.tiles[0][0].getX(), b.tiles[0][0].getY());
		b.end = b.getCell(b.tiles[9][9].getX(), b.tiles[9][9].getY());
		
		for(int i = 0; i < players.length; i++){
			System.out.println(players[i]);
		}
		
		
		BeginGame(players, b);
		PlayGame(players, b);
	
	}
	
	

}
