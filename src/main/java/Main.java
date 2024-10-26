public class Main {
    public static void main(String[] args) {
        TrithemiusCipher cipher = new TrithemiusCipher();

        // Linear key
        EncryptionKey linearKey = new LinearKey(1, 2);
        String encrypted = cipher.encrypt("hello", linearKey);
        String decrypted = cipher.decrypt(encrypted, linearKey);
        System.out.println("Linear Key Encrypted: " + encrypted);
        System.out.println("Linear Key Decrypted: " + decrypted);

        // Nonlinear key
        EncryptionKey nonLinearKey = new NonLinearKey(1, 2, 3);
        encrypted = cipher.encrypt("hello", nonLinearKey);
        decrypted = cipher.decrypt(encrypted, nonLinearKey);
        System.out.println("Nonlinear Key Encrypted: " + encrypted);
        System.out.println("Nonlinear Key Decrypted: " + decrypted);

        // Keyword key
        EncryptionKey keywordKey = new KeywordKey("keyword");
        encrypted = cipher.encrypt("hello", keywordKey);
        decrypted = cipher.decrypt(encrypted, keywordKey);
        System.out.println("Keyword Key Encrypted: " + encrypted);
        System.out.println("Keyword Key Decrypted: " + decrypted);
    }
}