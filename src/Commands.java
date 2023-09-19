import java.util.*;

/**
 *  Given a list of session command logs, find a session with the maximum no. of different commands
 *  Ex.
 *  start sessionA, command1,command2,command1, command3    => 3 commands
 *  start sessionB, command1,command2,command1, command3    => 3 commands
 *  start sessionA, command1,command23,command11, command3  => 4 commands
 *  start sessionC, command1,command2,command1, command3    => 3 commands
 */
public class Commands {
    public Integer maximumUniqueCommands(List<String> logs) {
        String rawSessionAndCommands;
        Map<String, Integer> sessionCounter = new HashMap<>();
        for( String line: logs){
            rawSessionAndCommands = line.substring(6);
            String[] sessionLogs = rawSessionAndCommands.split(",");
            String session = sessionLogs[0].trim();
            Set<String> uniqueCommands = new HashSet<>();
            for (int i=1; i< sessionLogs.length; i++){
                uniqueCommands.add(sessionLogs[i].trim());
            }
            if (sessionCounter.containsKey(session)){
                if (uniqueCommands.size()>sessionCounter.get(session)) {
                    sessionCounter.put(session, uniqueCommands.size());
                }
            }else{
                sessionCounter.put(session,uniqueCommands.size());
            }
        }
        return Collections.max(sessionCounter.values());
    }
}
