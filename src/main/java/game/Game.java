package game;

public class Game {
	
	GameBuilder gameBuilder;
	private static Game UniqueGame;

	private Game(){}

	public static Game getUniqueGame(){
		if (UniqueGame == null) { return new Game();}
		else return UniqueGame;
	}

	public void playWith(){
		gameBuilder.playWith();

	}

	public void setGameBuilder(GameBuilder _gameBuilder) {this.gameBuilder=_gameBuilder;}
	
	
}
