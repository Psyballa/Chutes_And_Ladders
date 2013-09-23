


public class Player {
	private int ID;
	private Cell position;
	private String name;
	private Dice dice;
	
	public Player(int ID, Cell position, String name, Dice dice){
		setID(ID);
		setPosition(position);
		setName(name);
		setDice(dice);
	}
	
	public int getID(){
		return this.ID;
	}
	
	public void setID(int ID){
		this.ID = ID;
	}
	
	public Cell getPosition(){
		return this.position;
	}
	
	public void setPosition(Cell position){
		this.position = position;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Dice getDice(){
		return this.dice;
	}
	
	public void setDice(Dice dice){
		this.dice = dice;
	}
		
	protected void move(Cell end)
	{
		this.setPosition(end);
	}
	

	
	public String toString(){
		return "Player " + (this.getID() + 1) + " is named " + this.getName();
	}
}
