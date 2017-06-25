package alvintest.emoji;

/**
 * Created by Alvin on 2014/10/12 0012.
 */
public class EmojiAlvinTest {
    public static void main(String[] args) {
        String emojiString = EmojiParser.demojizedText(":zzz:");
        System.out.println(emojiString);

        String emojiString2 = EmojiParser.emojiText("[1f4a4]");
        System.out.println(emojiString2);
    }
}
