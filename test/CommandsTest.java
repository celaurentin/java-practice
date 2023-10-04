import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandsTest {

    Commands commands = new Commands();

    @Test
    void maximumUniqueCommandsTest() {
        List<String> logs = new ArrayList<>();
        logs.add("start sessionA, command1,command2,command1, command3");
        logs.add("start sessionB, command1,command2,command1, command3");
        logs.add("start sessionA, command1,command23,command11, command3");
        logs.add("start sessionB, command1,command2,command4, command3, command10");

        assertEquals("sessionB", commands.getSessionWithMaximumUniqueCommands(logs));
    }
}
