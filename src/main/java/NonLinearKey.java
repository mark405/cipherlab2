public class NonLinearKey implements EncryptionKey {
    private final int A;
    private final int B;
    private final int C;

    public NonLinearKey(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public int calculateShift(int position) {
        return A * position * position + B * position + C;
    }

    @Override
    public boolean isValid() {
        // Add validation logic if needed, e.g., check range of A, B, and C
        return true;
    }
}