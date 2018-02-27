package Commands;

public class QuitCommand extends BaseCommand {
	
	public QuitCommand() {
		super("quit");
	}
	
	@Override
	public void doCommand(String[] input) {
		if (super.matchCommand(input)) {
			shutdownPrep();
			exitGame();
		}
	}
	
	private int shutdownPrep() {
		// nothing to do just yet
		return 1;
	}


	private int exitGame() {
		 System.exit(0);
		 return 0;
	}
}
