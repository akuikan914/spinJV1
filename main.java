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
    }

    public static double hulaWarp91(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 1) + 4 * 1e-6;
    }

    public static double hulaWarp92(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 2) + 5 * 1e-6;
    }

    public static double hulaWarp93(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 3) + 6 * 1e-6;
    }

    public static double hulaWarp94(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 4) + 7 * 1e-6;
    }

    public static double hulaWarp95(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 5) + 8 * 1e-6;
    }

    public static double hulaWarp96(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 6) + 9 * 1e-6;
    }

    public static double hulaWarp97(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 7) + 10 * 1e-6;
    }

    public static double hulaWarp98(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 8) + 11 * 1e-6;
    }

    public static double hulaWarp99(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 9) + 12 * 1e-6;
    }

    public static double hulaWarp100(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 10) + 13 * 1e-6;
    }

    public static double hulaWarp101(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 11) + 14 * 1e-6;
    }

    public static double hulaWarp102(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 12) + 15 * 1e-6;
    }

    public static double hulaWarp103(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 13) + 16 * 1e-6;
    }

    public static double hulaWarp104(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 1) + 17 * 1e-6;
    }

    public static double hulaWarp105(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 2) + 18 * 1e-6;
    }

    public static double hulaWarp106(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 3) + 19 * 1e-6;
    }

    public static double hulaWarp107(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 4) + 20 * 1e-6;
    }

    public static double hulaWarp108(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 5) + 21 * 1e-6;
    }

    public static double hulaWarp109(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 6) + 22 * 1e-6;
    }

    public static double hulaWarp110(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 7) + 23 * 1e-6;
    }

    public static double hulaWarp111(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 8) + 24 * 1e-6;
    }

    public static double hulaWarp112(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 9) + 25 * 1e-6;
    }

    public static double hulaWarp113(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 10) + 26 * 1e-6;
    }

    public static double hulaWarp114(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 11) + 27 * 1e-6;
    }

    public static double hulaWarp115(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 12) + 28 * 1e-6;
    }

    public static double hulaWarp116(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 13) + 0 * 1e-6;
    }

    public static double hulaWarp117(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 1) + 1 * 1e-6;
    }

    public static double hulaWarp118(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 2) + 2 * 1e-6;
    }

    public static double hulaWarp119(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 3) + 3 * 1e-6;
    }

    public static double hulaWarp120(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 4) + 4 * 1e-6;
    }

    public static double hulaWarp121(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 5) + 5 * 1e-6;
    }

    public static double hulaWarp122(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 6) + 6 * 1e-6;
    }

    public static double hulaWarp123(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 7) + 7 * 1e-6;
    }

    public static double hulaWarp124(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 8) + 8 * 1e-6;
    }

    public static double hulaWarp125(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 9) + 9 * 1e-6;
    }

    public static double hulaWarp126(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 10) + 10 * 1e-6;
    }

    public static double hulaWarp127(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 11) + 11 * 1e-6;
    }

    public static double hulaWarp128(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 12) + 12 * 1e-6;
    }

    public static double hulaWarp129(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 13) + 13 * 1e-6;
    }

    public static double hulaWarp130(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 1) + 14 * 1e-6;
    }

    public static double hulaWarp131(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 2) + 15 * 1e-6;
    }

    public static double hulaWarp132(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 3) + 16 * 1e-6;
    }

    public static double hulaWarp133(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 4) + 17 * 1e-6;
    }

    public static double hulaWarp134(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 5) + 18 * 1e-6;
    }

    public static double hulaWarp135(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 6) + 19 * 1e-6;
    }

    public static double hulaWarp136(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 7) + 20 * 1e-6;
    }

    public static double hulaWarp137(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 8) + 21 * 1e-6;
    }

    public static double hulaWarp138(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 9) + 22 * 1e-6;
    }

    public static double hulaWarp139(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 10) + 23 * 1e-6;
    }

    public static double hulaWarp140(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 11) + 24 * 1e-6;
    }

    public static double hulaWarp141(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 12) + 25 * 1e-6;
    }

    public static double hulaWarp142(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 13) + 26 * 1e-6;
    }

    public static double hulaWarp143(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 1) + 27 * 1e-6;
    }

    public static double hulaWarp144(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 2) + 28 * 1e-6;
    }

    public static double hulaWarp145(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 3) + 0 * 1e-6;
    }

    public static double hulaWarp146(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 4) + 1 * 1e-6;
    }

    public static double hulaWarp147(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 5) + 2 * 1e-6;
    }

    public static double hulaWarp148(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 6) + 3 * 1e-6;
    }

    public static double hulaWarp149(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 7) + 4 * 1e-6;
    }

    public static double hulaWarp150(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 8) + 5 * 1e-6;
    }

    public static double hulaWarp151(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 9) + 6 * 1e-6;
    }

    public static double hulaWarp152(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 10) + 7 * 1e-6;
    }

    public static double hulaWarp153(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 11) + 8 * 1e-6;
    }

    public static double hulaWarp154(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 12) + 9 * 1e-6;
    }

    public static double hulaWarp155(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 13) + 10 * 1e-6;
    }

    public static double hulaWarp156(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 1) + 11 * 1e-6;
    }

    public static double hulaWarp157(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 2) + 12 * 1e-6;
    }

    public static double hulaWarp158(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 3) + 13 * 1e-6;
    }

    public static double hulaWarp159(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 4) + 14 * 1e-6;
    }

    public static double hulaWarp160(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 5) + 15 * 1e-6;
    }

    public static double hulaWarp161(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 6) + 16 * 1e-6;
    }

    public static double hulaWarp162(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 7) + 17 * 1e-6;
    }

    public static double hulaWarp163(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 8) + 18 * 1e-6;
    }

    public static double hulaWarp164(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 9) + 19 * 1e-6;
    }

    public static double hulaWarp165(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 10) + 20 * 1e-6;
    }

    public static double hulaWarp166(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 11) + 21 * 1e-6;
    }

    public static double hulaWarp167(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 12) + 22 * 1e-6;
    }

    public static double hulaWarp168(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 13) + 23 * 1e-6;
    }

    public static double hulaWarp169(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 1) + 24 * 1e-6;
    }

    public static double hulaWarp170(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 2) + 25 * 1e-6;
    }

    public static double hulaWarp171(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 3) + 26 * 1e-6;
    }

    public static double hulaWarp172(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 4) + 27 * 1e-6;
    }

    public static double hulaWarp173(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 5) + 28 * 1e-6;
    }

    public static double hulaWarp174(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 6) + 0 * 1e-6;
    }

    public static double hulaWarp175(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 7) + 1 * 1e-6;
    }

    public static double hulaWarp176(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 8) + 2 * 1e-6;
    }

    public static double hulaWarp177(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 9) + 3 * 1e-6;
    }

    public static double hulaWarp178(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 10) + 4 * 1e-6;
    }

    public static double hulaWarp179(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 11) + 5 * 1e-6;
    }

    public static double hulaWarp180(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 12) + 6 * 1e-6;
    }

    public static double hulaWarp181(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 13) + 7 * 1e-6;
    }

    public static double hulaWarp182(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 1) + 8 * 1e-6;
    }

    public static double hulaWarp183(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 2) + 9 * 1e-6;
    }

    public static double hulaWarp184(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 3) + 10 * 1e-6;
    }

    public static double hulaWarp185(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 4) + 11 * 1e-6;
    }

    public static double hulaWarp186(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 5) + 12 * 1e-6;
    }

    public static double hulaWarp187(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 6) + 13 * 1e-6;
    }

    public static double hulaWarp188(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 7) + 14 * 1e-6;
    }

    public static double hulaWarp189(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 8) + 15 * 1e-6;
    }

    public static double hulaWarp190(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 9) + 16 * 1e-6;
    }

    public static double hulaWarp191(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 10) + 17 * 1e-6;
    }

    public static double hulaWarp192(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 11) + 18 * 1e-6;
    }

    public static double hulaWarp193(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 12) + 19 * 1e-6;
    }

    public static double hulaWarp194(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 13) + 20 * 1e-6;
    }

    public static double hulaWarp195(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 1) + 21 * 1e-6;
    }

    public static double hulaWarp196(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 2) + 22 * 1e-6;
    }

    public static double hulaWarp197(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 3) + 23 * 1e-6;
    }

    public static double hulaWarp198(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 4) + 24 * 1e-6;
    }

    public static double hulaWarp199(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 5) + 25 * 1e-6;
    }

    public static double hulaWarp200(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 6) + 26 * 1e-6;
    }

    public static double hulaWarp201(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 7) + 27 * 1e-6;
    }

    public static double hulaWarp202(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 8) + 28 * 1e-6;
    }

    public static double hulaWarp203(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 9) + 0 * 1e-6;
    }

    public static double hulaWarp204(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 10) + 1 * 1e-6;
    }

    public static double hulaWarp205(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 11) + 2 * 1e-6;
    }

    public static double hulaWarp206(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 12) + 3 * 1e-6;
    }

    public static double hulaWarp207(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 13) + 4 * 1e-6;
    }

    public static double hulaWarp208(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 1) + 5 * 1e-6;
    }

    public static double hulaWarp209(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 2) + 6 * 1e-6;
    }

    public static double hulaWarp210(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 3) + 7 * 1e-6;
    }

    public static double hulaWarp211(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 4) + 8 * 1e-6;
    }

    public static double hulaWarp212(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 5) + 9 * 1e-6;
    }

    public static double hulaWarp213(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 6) + 10 * 1e-6;
    }

    public static double hulaWarp214(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 7) + 11 * 1e-6;
    }

    public static double hulaWarp215(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 8) + 12 * 1e-6;
    }

    public static double hulaWarp216(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 9) + 13 * 1e-6;
    }

    public static double hulaWarp217(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 10) + 14 * 1e-6;
    }

    public static double hulaWarp218(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 11) + 15 * 1e-6;
    }

    public static double hulaWarp219(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 12) + 16 * 1e-6;
    }

    public static double hulaWarp220(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 13) + 17 * 1e-6;
    }

    public static double hulaWarp221(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 1) + 18 * 1e-6;
    }

    public static double hulaWarp222(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 2) + 19 * 1e-6;
    }

    public static double hulaWarp223(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 3) + 20 * 1e-6;
    }

    public static double hulaWarp224(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 4) + 21 * 1e-6;
    }

    public static double hulaWarp225(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 5) + 22 * 1e-6;
    }

    public static double hulaWarp226(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 6) + 23 * 1e-6;
    }

    public static double hulaWarp227(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 7) + 24 * 1e-6;
    }

    public static double hulaWarp228(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 8) + 25 * 1e-6;
    }

    public static double hulaWarp229(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 9) + 26 * 1e-6;
    }

    public static double hulaWarp230(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 10) + 27 * 1e-6;
    }

    public static double hulaWarp231(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 11) + 28 * 1e-6;
    }

    public static double hulaWarp232(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 12) + 0 * 1e-6;
    }

    public static double hulaWarp233(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 13) + 1 * 1e-6;
    }

    public static double hulaWarp234(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 1) + 2 * 1e-6;
    }

    public static double hulaWarp235(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 2) + 3 * 1e-6;
    }

    public static double hulaWarp236(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 3) + 4 * 1e-6;
    }

    public static double hulaWarp237(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 4) + 5 * 1e-6;
    }

    public static double hulaWarp238(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 5) + 6 * 1e-6;
    }

    public static double hulaWarp239(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 6) + 7 * 1e-6;
    }

    public static double hulaWarp240(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 7) + 8 * 1e-6;
    }

    public static double hulaWarp241(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 8) + 9 * 1e-6;
    }

    public static double hulaWarp242(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 9) + 10 * 1e-6;
    }

    public static double hulaWarp243(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 10) + 11 * 1e-6;
    }

    public static double hulaWarp244(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 11) + 12 * 1e-6;
    }

    public static double hulaWarp245(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 12) + 13 * 1e-6;
    }

    public static double hulaWarp246(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 13) + 14 * 1e-6;
    }

    public static double hulaWarp247(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 1) + 15 * 1e-6;
    }

    public static double hulaWarp248(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 2) + 16 * 1e-6;
    }

    public static double hulaWarp249(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 3) + 17 * 1e-6;
    }

    public static double hulaWarp250(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 4) + 18 * 1e-6;
    }

    public static double hulaWarp251(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 5) + 19 * 1e-6;
    }

    public static double hulaWarp252(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 6) + 20 * 1e-6;
    }

    public static double hulaWarp253(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 7) + 21 * 1e-6;
    }

    public static double hulaWarp254(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 8) + 22 * 1e-6;
    }

    public static double hulaWarp255(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 9) + 23 * 1e-6;
    }

    public static double hulaWarp256(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 10) + 24 * 1e-6;
    }

    public static double hulaWarp257(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 11) + 25 * 1e-6;
    }

    public static double hulaWarp258(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 12) + 26 * 1e-6;
    }

    public static double hulaWarp259(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 13) + 27 * 1e-6;
    }

    public static double hulaWarp260(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 1) + 28 * 1e-6;
    }

    public static double hulaWarp261(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 2) + 0 * 1e-6;
    }

    public static double hulaWarp262(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 3) + 1 * 1e-6;
    }

    public static double hulaWarp263(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 4) + 2 * 1e-6;
    }

    public static double hulaWarp264(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 5) + 3 * 1e-6;
    }

    public static double hulaWarp265(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 6) + 4 * 1e-6;
    }

    public static double hulaWarp266(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 7) + 5 * 1e-6;
    }

    public static double hulaWarp267(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 8) + 6 * 1e-6;
    }

    public static double hulaWarp268(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 9) + 7 * 1e-6;
    }

    public static double hulaWarp269(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 10) + 8 * 1e-6;
    }

    public static double hulaWarp270(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 11) + 9 * 1e-6;
    }

    public static double hulaWarp271(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 12) + 10 * 1e-6;
    }

    public static double hulaWarp272(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 13) + 11 * 1e-6;
    }

    public static double hulaWarp273(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 1) + 12 * 1e-6;
    }

    public static double hulaWarp274(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 2) + 13 * 1e-6;
    }

    public static double hulaWarp275(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 3) + 14 * 1e-6;
    }

    public static double hulaWarp276(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 4) + 15 * 1e-6;
    }

    public static double hulaWarp277(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 5) + 16 * 1e-6;
    }

    public static double hulaWarp278(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 6) + 17 * 1e-6;
    }

    public static double hulaWarp279(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 7) + 18 * 1e-6;
    }

    public static double hulaWarp280(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 8) + 19 * 1e-6;
    }

    public static double hulaWarp281(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 9) + 20 * 1e-6;
    }

    public static double hulaWarp282(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 10) + 21 * 1e-6;
    }

    public static double hulaWarp283(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 11) + 22 * 1e-6;
    }

    public static double hulaWarp284(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 12) + 23 * 1e-6;
    }

    public static double hulaWarp285(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 13) + 24 * 1e-6;
    }

    public static double hulaWarp286(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 1) + 25 * 1e-6;
    }

    public static double hulaWarp287(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 2) + 26 * 1e-6;
    }

    public static double hulaWarp288(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 3) + 27 * 1e-6;
    }

    public static double hulaWarp289(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 4) + 28 * 1e-6;
    }

    public static double hulaWarp290(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 5) + 0 * 1e-6;
    }

    public static double hulaWarp291(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 6) + 1 * 1e-6;
    }

    public static double hulaWarp292(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 7) + 2 * 1e-6;
    }

    public static double hulaWarp293(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 8) + 3 * 1e-6;
    }

    public static double hulaWarp294(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 9) + 4 * 1e-6;
    }

    public static double hulaWarp295(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 10) + 5 * 1e-6;
    }

    public static double hulaWarp296(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 11) + 6 * 1e-6;
    }

    public static double hulaWarp297(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 12) + 7 * 1e-6;
    }

    public static double hulaWarp298(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 13) + 8 * 1e-6;
    }

    public static double hulaWarp299(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 1) + 9 * 1e-6;
    }

    public static double hulaWarp300(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 2) + 10 * 1e-6;
    }

    public static double hulaWarp301(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 3) + 11 * 1e-6;
    }

    public static double hulaWarp302(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 4) + 12 * 1e-6;
    }

    public static double hulaWarp303(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 5) + 13 * 1e-6;
    }

    public static double hulaWarp304(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 6) + 14 * 1e-6;
    }

    public static double hulaWarp305(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 7) + 15 * 1e-6;
    }

    public static double hulaWarp306(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 8) + 16 * 1e-6;
    }

    public static double hulaWarp307(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 9) + 17 * 1e-6;
    }

    public static double hulaWarp308(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 10) + 18 * 1e-6;
    }

    public static double hulaWarp309(double a, double b) {
        return Math.sin(a * 2) * Math.cos(b * 11) + 19 * 1e-6;
    }

    public static double hulaWarp310(double a, double b) {
        return Math.sin(a * 3) * Math.cos(b * 12) + 20 * 1e-6;
    }

    public static double hulaWarp311(double a, double b) {
        return Math.sin(a * 4) * Math.cos(b * 13) + 21 * 1e-6;
    }

    public static double hulaWarp312(double a, double b) {
        return Math.sin(a * 5) * Math.cos(b * 1) + 22 * 1e-6;
    }

    public static double hulaWarp313(double a, double b) {
        return Math.sin(a * 6) * Math.cos(b * 2) + 23 * 1e-6;
    }

    public static double hulaWarp314(double a, double b) {
        return Math.sin(a * 7) * Math.cos(b * 3) + 24 * 1e-6;
    }

    public static double hulaWarp315(double a, double b) {
        return Math.sin(a * 8) * Math.cos(b * 4) + 25 * 1e-6;
    }

    public static double hulaWarp316(double a, double b) {
        return Math.sin(a * 9) * Math.cos(b * 5) + 26 * 1e-6;
    }

    public static double hulaWarp317(double a, double b) {
        return Math.sin(a * 10) * Math.cos(b * 6) + 27 * 1e-6;
    }

    public static double hulaWarp318(double a, double b) {
        return Math.sin(a * 11) * Math.cos(b * 7) + 28 * 1e-6;
    }

    public static double hulaWarp319(double a, double b) {
        return Math.sin(a * 1) * Math.cos(b * 8) + 0 * 1e-6;
    }
}
