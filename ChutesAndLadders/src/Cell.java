
public class Cell{
	public enum CellType{
		NONE, CHUTE_BEGIN, CHUTE_END, LADDER_BEGIN, LADDER_END;
	}	
	int ID, x, y;
	CellType cellType;
	Player[] playersOn;
	public Cell(int ID, int x, int y, CellType cellType, Player[] playersOn){
		setID(ID);
		setX(x);
		setY(y);
		setCellType(cellType);
		setPlayersOn(playersOn);
	}
	
	public int getID(){
		return this.ID + 1;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public CellType getCellType(){
		return this.cellType;
	}
	public Player[] getPlayersOn(){
		return this.playersOn;
	}
	
	public void setID(int ID){
		this.ID = ID;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setCellType(CellType cellType){
		this.cellType = cellType;
	}
	public void setPlayersOn(Player[] playersOn){
		this.playersOn = playersOn;
	}
	
	public String toString(){
		return this.ID + ", " + this.x + ", " + this.y + ", " + this.cellType;
	}
}
