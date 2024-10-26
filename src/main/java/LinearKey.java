public class LinearKey implements EncryptionKey {
    private final int A;
    private final int B;

    public LinearKey(int A, int B) {
        this.A = A;
        this.B = B;
    }

    public int calculateShift(int position) {
        return A * position + B;
    }

    @Override
    public boolean isValid() {
        // Add validation logic if needed, e.g., check range of A and B
        return true;
    }
}
