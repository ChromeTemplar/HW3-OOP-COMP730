package Commands;

public class BaseCommand implements Commandable {
	
	String myCommand = "";

	protected BaseCommand(String cmd) {
		myCommand = cmd;
	}
	
	@Override
	public boolean matchCommand(String[] input) {
		if (myCommand.equalsIgnoreCase(input[0])) {
			return true;
		}
		return false;
	}

	@Override
	public void doCommand(String[] input) {
	}
	
	public String getCommand() {
		return myCommand;
	}
	
	
}
