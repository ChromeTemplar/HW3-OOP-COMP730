package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.Mockito.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import org.powermock.modules.junit4.PowerMockRunner;

import Commands.QuitCommand;

@RunWith(PowerMockRunner.class)
@PrepareForTest(QuitCommand.class)
class QuitCommandTest {

	QuitCommand obj;
	

	@Test
	void testGetCommand() {
		obj = new QuitCommand();
		assertEquals(obj.getCommand(), "quit");
	}
	
	@Test
	void testMatchCommand() {
		obj = new QuitCommand();
		
		String[] input = {"quit"};
		
		// positive case
		assertTrue(obj.matchCommand(input));
		
		//negative case
		input[0] = "fred";
		assertFalse(obj.matchCommand(input));
	}

	@Test
	void testQuitCommand_shutdownPrep() throws Exception {
		
		obj = new QuitCommand();
		int ret = Whitebox.invokeMethod(obj, "shutdownPrep");
		assertEquals(ret, 1);
	}	
	
	@Test
	void testQuitDoCommand() throws Exception {
		obj = new QuitCommand();
		String[] input = {"quit"};

		QuitCommand mCommand = PowerMockito.spy(obj);
	    PowerMockito.doNothing().when(mCommand,  PowerMockito.method(QuitCommand.class, "exitGame")).withNoArguments();
	    
        
	    mCommand.doCommand(input);
	    PowerMockito.verifyPrivate(mCommand).invoke("exitGame");
	}

}
