import java.util.HashMap;

public class Board {
	Cell[][] tiles;
	HashMap<Cell, Cell> chutes;
	HashMap<Cell, Cell> ladders;
	Cell begin;
	Cell end;
	String name;
	int width, height;
	
	
	public Board(Cell begin, Cell end, String name, int width, int height){
		setTiles();
		setBegin(begin);
		setEnd(end);
		setName(name);
		setWidth(width);
		setHeight(height);
		setChutes();
		setLadders();
	}
	public Cell[][] getTiles(){
		return this.tiles;
	}
	public Cell getCell(int x, int y){
		for(int i = 0; i < tiles.length; i++){
			for(int j = 0; j < tiles[0].length; j++){
				if(tiles[i][j].getX() == x && tiles[i][j].getY() == y){
					return tiles[i][j];
				}
			}
		}
		return null;
	}
	
	public Cell getCell(int ID){
		for(int i = 0; i < tiles.length; i++){
			for(int j = 0; j < tiles[0].length; j++){
				if(tiles[i][j].getID() == ID)
					return tiles[i][j];
			}
		}
		return null;
	}
	public Cell getBegin(){
		return this.begin;
	}
	public void setBegin(Cell begin){
		this.begin = begin;
	}
	
	public Cell getEnd(){
		return this.end;
	}
	public void setEnd(Cell end){
		this.end = end;
	}
	public String getName(){
		return this.name;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public void setTiles(){
		Cell[][] tiles = new Cell[10][10];
		int count = 0;
		for(int j = 0; j < 10; j++){
			for(int i = 0; i < 10; i++){
				Cell c = new Cell(count, i, j, Cell.CellType.NONE, new Player[4]);
				count++;
				tiles[i][j] = c;
				//System.out.println(c);
			}
		}
		this.tiles = tiles;
	}
	
	public void setLadders(){
		ladders = new HashMap<Cell, Cell>();
		int[] ladderBegins = {1, 4, 9, 28, 36, 40, 51, 71, 81};
		int[] ladderEnds = {38, 14, 31, 84, 42, 44, 67, 100, 91};
		for(int i = 0; i < ladderBegins.length; i++){
			getCell(ladderBegins[i]).setCellType(Cell.CellType.LADDER_BEGIN);
			getCell(ladderEnds[i]).setCellType(Cell.CellType.LADDER_END);
			ladders.put(getCell(ladderBegins[i]), getCell(ladderEnds[i]));
			System.out.println(ladders);
			//System.out.println("Ladder from " + (getCell(ladderBegins[i]) + " to " + getCell(ladderEnds[i])));
		}
	}
	
	public void setChutes(){
		chutes = new HashMap<Cell, Cell>();
		int[] chuteBegins = {98, 95, 93, 87, 64, 62, 56, 49, 47, 16}; 
		int[] chuteEnds = {78, 75, 73, 24, 60, 19, 53, 11, 26, 6};
		
		for(int i = 0; i < chuteBegins.length; i++){
			getCell(chuteBegins[i]).setCellType(Cell.CellType.CHUTE_BEGIN);
			getCell(chuteEnds[i]).setCellType(Cell.CellType.CHUTE_END);
			chutes.put(getCell(chuteBegins[i]), getCell(chuteEnds[i]));
			System.out.println(chutes);
			//System.out.println("Chute from " + getCell(chuteBegins[i]) + " to " + getCell(chuteEnds[i]));
		}
	}
	
	public HashMap<Cell, Cell> getChutes(){
		return this.chutes;
	}
	
	public HashMap<Cell, Cell> getLadders(){
		return this.ladders;
	}
}
