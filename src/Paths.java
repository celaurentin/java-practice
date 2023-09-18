import java.util.*;

/**
 * Given a list of paths, find the common recurring folder path
 *  /a/folder1/folder12/file.txt,
 *  /a/folder1/folder13/file.txt,
 *  /b/folder1/folder13/file.txt,
 *  /b/folder2/folder12/file.txt,
 *  /c/folder3/folder12/file.txt
 */
public class Paths {

    public String mostRecurringPath(List<String> paths){
        String path;
        Map<String, Integer> pathCounter = new HashMap<>();
        for (String rawPath: paths){
            path = rawPath.substring(0, rawPath.lastIndexOf("/")).trim();
            if (pathCounter.containsKey(path))
                pathCounter.put(path, pathCounter.get(path)+1);
            else
                pathCounter.put(path,1);
        }

        String mostRecurringPath = "";
        int max = 0;
        for (Map.Entry<String,Integer> entry: pathCounter.entrySet()){
            if (entry.getValue()>max) {
                max = entry.getValue();
                mostRecurringPath = entry.getKey();
            }
        }
        return mostRecurringPath;
    }

}
