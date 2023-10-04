
/**
 * Given a string s, return the number of segments in the string.
 * A segment is defined to be a contiguous sequence of non-space characters.
 */
public class Segments {

    public int countSegments(String s) {
        if (s.trim().length()==0) return 0;
        String[] segments = s.trim().split("\\s+");
        return segments.length;
    }
}
