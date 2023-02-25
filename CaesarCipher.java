
package limited.hackveda;

import java.util.Scanner;

public class CaesarCipher {

    // Encrypts text using a shift provided as parameter
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
               continue;
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) + shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) + shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Decrypts encrypted text using a shift provided as parameter
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        System.out.println("Enter a String:-");
        String message =kb.nextLine();
        System.out.println("Enter Key:-");
        int shift = kb.nextInt();

        String encrypted = encrypt(message, shift);
        System.out.println("Encrypted message: " + encrypted);

        String decrypted = decrypt(encrypted, shift);
        System.out.println("Decrypted message: " + decrypted);
    }
}
