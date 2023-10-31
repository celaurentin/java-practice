/**
 * An infamous gang of cyber criminals named “The Gray Cyber Mob”, which is behind many hacking attacks and drug
 * trafficking, has recently become a target for the FBI. After intercepting some of their messages, which looked
 * like complete nonsense, the agency learned that they indeed encrypt their messages, and studied their method of
 * encryption.
 *
 * Their messages consist of lowercase latin letters only, and every word is encrypted separately as follows:
 *
 * Convert every letter to its ASCII value. Add 1 to the first letter, and then for every letter from the second one
 * to the last one, add the value of the previous letter. Subtract 26 from every letter until it is in the range of
 * lowercase letters a-z in ASCII. Convert the values back to letters.
 *
 * For instance, to encrypt the word “crime”
 *
 * Decrypted message:	c	r	i	m	e
 *              Step 1:	99	114	105	109	101
 *              Step 2:	100	214	319	428	529
 *              Step 3:	100	110	111	116	113
 * Encrypted message:	d	n	o	t	q
 */
public class DecryptMessage {

    public String decrypt(String word) {
        if (word.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        char[] chars = word.toCharArray();
        int prevAscii = chars[0];
        sb.append((char) (prevAscii-1));

        for (int i=1; i<chars.length; i++){
            int currentAscii = chars[i];
            int current = currentAscii - prevAscii;
            while (current < 97){
                current+= 26;
            }
            sb.append((char)current);
            prevAscii = currentAscii;
        }

        return sb.toString();
    }
}
