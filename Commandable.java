/**
 * 
 */
package Commands;

/**
 * @author Vader
 *
 */
public interface Commandable {
	
	public boolean matchCommand(String[] input);
	
	public void doCommand(String[] input);

}
