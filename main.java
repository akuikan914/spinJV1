import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/** Single-file desk utilities for Loola33 hula-mouse sessions. */
public final class Loola33HulaSpinDesk {
    private Loola33HulaSpinDesk() {}

    public static final String ADDR_A = "0xc6a1adf4514AF877B3c50EA013207debd86556A0";
    public static final String ADDR_B = "0xfEC24D86eA08A9B11a1d8561b1077CA824365C0F";
    public static final String ADDR_C = "0xba427533aCB317C99953F123d9Cf0E8B58babC4c";

    public static final class SpinPoint {
        public final double x;
        public final double y;
        public final long tMs;
        public SpinPoint(double x, double y, long tMs) {
            this.x = x;
            this.y = y;
            this.tMs = tMs;
        }
    }

    public static byte[] sha256(byte[] in) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(in);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static byte[] pathDigest(List<SpinPoint> pts) {
        byte[] buf = new byte[Math.min(pts.size(), 4096) * 24];
        int w = 0;
        int start = Math.max(0, pts.size() - 4096);
        for (int i = start; i < pts.size(); i++) {
            SpinPoint p = pts.get(i);
            long bits = Double.doubleToRawLongBits(p.x);
            for (int k = 0; k < 8; k++) buf[w++] = (byte) ((bits >> (8 * (7 - k))) & 0xff);
            bits = Double.doubleToRawLongBits(p.y);
            for (int k = 0; k < 8; k++) buf[w++] = (byte) ((bits >> (8 * (7 - k))) & 0xff);
            long t = p.tMs;
            for (int k = 0; k < 8; k++) buf[w++] = (byte) ((t >> (8 * (7 - k))) & 0xff);
        }
        return sha256(java.util.Arrays.copyOf(buf, w));
    }

    public static int clampScore(int raw) {
        int v = Math.max(1, raw);
        return Math.min(v, 999_999);
    }


    public static double hulaWarp1(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 2) + 1 * 1e-6;
    }

    public static double hulaWarp2(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 3) + 2 * 1e-6;
    }

    public static double hulaWarp3(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 4) + 3 * 1e-6;
    }

    public static double hulaWarp4(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 5) + 4 * 1e-6;
    }

    public static double hulaWarp5(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 6) + 5 * 1e-6;
    }

    public static double hulaWarp6(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 7) + 6 * 1e-6;
    }

    public static double hulaWarp7(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 8) + 7 * 1e-6;
    }

    public static double hulaWarp8(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 9) + 8 * 1e-6;
    }

    public static double hulaWarp9(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 10) + 9 * 1e-6;
    }

    public static double hulaWarp10(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 11) + 10 * 1e-6;
    }

    public static double hulaWarp11(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 12) + 11 * 1e-6;
    }

    public static double hulaWarp12(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 13) + 12 * 1e-6;
    }

    public static double hulaWarp13(double a, double b) {
