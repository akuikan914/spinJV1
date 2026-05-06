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
        return Math.sin(a * 3) * Math.cos(b * 1) + 13 * 1e-6;
    }

    public static double hulaWarp14(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 2) + 14 * 1e-6;
    }

    public static double hulaWarp15(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 3) + 15 * 1e-6;
    }

    public static double hulaWarp16(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 4) + 16 * 1e-6;
    }

    public static double hulaWarp17(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 5) + 17 * 1e-6;
    }

    public static double hulaWarp18(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 6) + 18 * 1e-6;
    }

    public static double hulaWarp19(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 7) + 19 * 1e-6;
    }

    public static double hulaWarp20(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 8) + 20 * 1e-6;
    }

    public static double hulaWarp21(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 9) + 21 * 1e-6;
    }

    public static double hulaWarp22(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 10) + 22 * 1e-6;
    }

    public static double hulaWarp23(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 11) + 23 * 1e-6;
    }

    public static double hulaWarp24(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 12) + 24 * 1e-6;
    }

    public static double hulaWarp25(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 13) + 25 * 1e-6;
    }

    public static double hulaWarp26(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 1) + 26 * 1e-6;
    }

    public static double hulaWarp27(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 2) + 27 * 1e-6;
    }

    public static double hulaWarp28(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 3) + 28 * 1e-6;
    }

    public static double hulaWarp29(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 4) + 0 * 1e-6;
    }

    public static double hulaWarp30(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 5) + 1 * 1e-6;
    }

    public static double hulaWarp31(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 6) + 2 * 1e-6;
    }

    public static double hulaWarp32(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 7) + 3 * 1e-6;
    }

    public static double hulaWarp33(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 8) + 4 * 1e-6;
    }

    public static double hulaWarp34(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 9) + 5 * 1e-6;
    }

    public static double hulaWarp35(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 10) + 6 * 1e-6;
    }

    public static double hulaWarp36(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 11) + 7 * 1e-6;
    }

    public static double hulaWarp37(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 12) + 8 * 1e-6;
    }

    public static double hulaWarp38(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 13) + 9 * 1e-6;
    }

    public static double hulaWarp39(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 1) + 10 * 1e-6;
    }

    public static double hulaWarp40(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 2) + 11 * 1e-6;
    }

    public static double hulaWarp41(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 3) + 12 * 1e-6;
    }

    public static double hulaWarp42(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 4) + 13 * 1e-6;
    }

    public static double hulaWarp43(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 5) + 14 * 1e-6;
    }

    public static double hulaWarp44(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 6) + 15 * 1e-6;
    }

    public static double hulaWarp45(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 7) + 16 * 1e-6;
    }

    public static double hulaWarp46(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 8) + 17 * 1e-6;
    }

    public static double hulaWarp47(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 9) + 18 * 1e-6;
    }

    public static double hulaWarp48(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 10) + 19 * 1e-6;
    }

    public static double hulaWarp49(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 11) + 20 * 1e-6;
    }

    public static double hulaWarp50(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 12) + 21 * 1e-6;
    }

    public static double hulaWarp51(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 13) + 22 * 1e-6;
    }

    public static double hulaWarp52(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 1) + 23 * 1e-6;
    }

    public static double hulaWarp53(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 2) + 24 * 1e-6;
    }

    public static double hulaWarp54(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 3) + 25 * 1e-6;
    }

    public static double hulaWarp55(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 4) + 26 * 1e-6;
    }

    public static double hulaWarp56(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 5) + 27 * 1e-6;
    }

    public static double hulaWarp57(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 6) + 28 * 1e-6;
    }

    public static double hulaWarp58(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 7) + 0 * 1e-6;
    }

    public static double hulaWarp59(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 8) + 1 * 1e-6;
    }

    public static double hulaWarp60(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 9) + 2 * 1e-6;
    }

    public static double hulaWarp61(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 10) + 3 * 1e-6;
    }

    public static double hulaWarp62(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 11) + 4 * 1e-6;
    }

    public static double hulaWarp63(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 12) + 5 * 1e-6;
    }

    public static double hulaWarp64(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 13) + 6 * 1e-6;
    }

    public static double hulaWarp65(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 1) + 7 * 1e-6;
    }

    public static double hulaWarp66(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 2) + 8 * 1e-6;
    }

    public static double hulaWarp67(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 3) + 9 * 1e-6;
    }

    public static double hulaWarp68(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 4) + 10 * 1e-6;
    }

    public static double hulaWarp69(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 5) + 11 * 1e-6;
    }

    public static double hulaWarp70(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 6) + 12 * 1e-6;
    }

    public static double hulaWarp71(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 7) + 13 * 1e-6;
    }

    public static double hulaWarp72(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 8) + 14 * 1e-6;
    }

    public static double hulaWarp73(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 9) + 15 * 1e-6;
    }

    public static double hulaWarp74(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 10) + 16 * 1e-6;
    }

    public static double hulaWarp75(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 11) + 17 * 1e-6;
    }

    public static double hulaWarp76(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 12) + 18 * 1e-6;
    }

    public static double hulaWarp77(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 13) + 19 * 1e-6;
    }

    public static double hulaWarp78(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 1) + 20 * 1e-6;
    }

    public static double hulaWarp79(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 2) + 21 * 1e-6;
    }

    public static double hulaWarp80(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 3) + 22 * 1e-6;
    }

    public static double hulaWarp81(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 4) + 23 * 1e-6;
    }

    public static double hulaWarp82(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 5) + 24 * 1e-6;
    }

    public static double hulaWarp83(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 6) + 25 * 1e-6;
    }

    public static double hulaWarp84(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 7) + 26 * 1e-6;
    }

    public static double hulaWarp85(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 8) + 27 * 1e-6;
    }

    public static double hulaWarp86(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 9) + 28 * 1e-6;
    }

    public static double hulaWarp87(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 10) + 0 * 1e-6;
    }

    public static double hulaWarp88(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 11) + 1 * 1e-6;
    }

    public static double hulaWarp89(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 12) + 2 * 1e-6;
    }

    public static double hulaWarp90(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 13) + 3 * 1e-6;
