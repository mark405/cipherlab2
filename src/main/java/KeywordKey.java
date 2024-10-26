public class KeywordKey implements EncryptionKey {
    private final String keyword;

    public KeywordKey(String keyword) {
        this.keyword = keyword;
    }

    public int calculateShift(int position) {
        char keyChar = keyword.charAt(position % keyword.length());
        return keyChar - 'a'; // Assuming lowercase letters only
    }

    @Override
    public boolean isValid() {
        // Keyword should not be empty
        return keyword != null && !keyword.isEmpty();
    }
}

