package tan.a3634;

        import android.annotation.TargetApi;
        import android.os.Build;

        import java.security.SecureRandom;
        import java.util.Locale;
        import java.util.Objects;
        import java.util.Random;

public class generateCode {

    /**
     * Generate a random string. This is code taken from stackoverflow
     *https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string
     */
    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String lower = upper.toLowerCase(Locale.ROOT);

    public static final String digits = "0123456789";

    public static final String alphanum = upper + lower + digits;

    private final Random random;

    private final char[] symbols;

    private final char[] buf;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public generateCode(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    /**
     * Create an alphanumeric string generator.
     */
    public generateCode(int length, Random random) {
        this(length, random, alphanum);
    }

    /**
     * Create an alphanumeric strings from a secure generator.
     */
    public generateCode(int length) {
        this(length, new SecureRandom());
    }

    /**
     * Create session identifiers.
     */
    public generateCode() {
        this(5);
    } //Set the length of the string to 5 characters

}
