package ua.com.alevel;

import java.util.Stack;

public class StringLib {

    public static String reverse(String input) {
        Stack<Character> stack = new Stack<>();
        char[] symbols = input.toCharArray();
        char[] out = new char[symbols.length];

        int count = 0;
        int semi = 0;

        for (int i = 0; i < input.length(); i++) {
            if (symbols[i] != ((char) 32)) {
                count++;
                stack.push(symbols[i]);
            } else if ((symbols[i] == ((char) 32))) {
                while (count != 0) {
                    out[semi] = stack.pop();
                    count--;
                    semi++;
                }
                out[semi] = (char) 32;
                semi++;
            }
        }

        System.out.print(" ");
        while (count != 0) {
            out[semi] = stack.pop();
            count--;
            semi++;
        }
        System.out.println();
        return new String(out);
    }

    public static String reverseSubstring(String input, String needrew) {
        char[] in = input.toCharArray();
        char[] revR = needrew.toCharArray();

        String reverseNeedRev = StringLib.reverse(needrew);
        char[] suprRever = reverseNeedRev.toCharArray();
        int count = 0;

        char[] out = new char[in.length];

        for (int i = 0; i < in.length; i++) {

            if (in[i] != revR[count]) {
                out[i] = in[i];
            } else if (in[i] == revR[count]) {
                out[i] = suprRever[count];
                if (count < revR.length - 1)
                    count++;
            }
        }
        return new String(out);
    }

    public static String reverseIndex(String input, int firstIndex, int lastIndex) {
        char[] symbols = input.toCharArray();
        char[] needRev = new char[lastIndex - firstIndex+1];

        int count = 0;
        int semi = firstIndex;

        char[] out = new char[input.length()];

        for (int i = 0; i < needRev.length; i++) {
            needRev[i] = symbols[semi];
            semi++;
        }
        String revIndex = new String(needRev);
        revIndex = StringLib.reverse(revIndex);
        System.out.println(revIndex);

        char[] revForIndex = revIndex.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            if ((i < firstIndex) || (i > lastIndex)) {
                out[i] = symbols[i];
            }
            else {
                out[i] = revForIndex[count];
                if (count < revForIndex.length - 1)
                    count++;
            }
        }
        return new String(out);
    }
}