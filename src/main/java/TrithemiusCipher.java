public class TrithemiusCipher {
    private static final int ALPHABET_SIZE = 35;

    public String encrypt(String plaintext, EncryptionKey key) {
        if (!key.isValid()) {
            throw new IllegalArgumentException("Invalid key");
        }

        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            int x = plainChar - 'a'; // Convert char to integer (e.g., 'a' -> 0)

            int k = getShift(key, i);
            int y = (x + k) % ALPHABET_SIZE;

            ciphertext.append((char) (y + 'a'));
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext, EncryptionKey key) {
        if (!key.isValid()) {
            throw new IllegalArgumentException("Invalid key");
        }

        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);
            int y = cipherChar - 'a';

            int k = getShift(key, i);
            int x = (y + ALPHABET_SIZE - (k % ALPHABET_SIZE)) % ALPHABET_SIZE;

            plaintext.append((char) (x + 'a'));
        }
        return plaintext.toString();
    }

    private int getShift(EncryptionKey key, int position) {
        if (key instanceof LinearKey) {
            return ((LinearKey) key).calculateShift(position);
        } else if (key instanceof NonLinearKey) {
            return ((NonLinearKey) key).calculateShift(position);
        } else if (key instanceof KeywordKey) {
            return ((KeywordKey) key).calculateShift(position);
        }
        throw new IllegalArgumentException("Unsupported key type");
    }
}
