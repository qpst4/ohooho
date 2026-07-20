package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ea0 {
    static {
        ai.c("\"\\");
        ai.c("\t ,=");
    }

    public static long a(hw0 hw0Var) {
        String strA = hw0Var.g.a("Content-Length");
        if (strA == null) {
            return -1L;
        }
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean b(hw0 hw0Var) {
        if (hw0Var.b.b.equals("HEAD")) {
            return false;
        }
        int i = hw0Var.d;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && a(hw0Var) == -1 && !"chunked".equalsIgnoreCase(hw0Var.a("Transfer-Encoding"))) ? false : true;
    }

    public static int c(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01bc, code lost:
    
        if (r19 == (-1)) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01c5, code lost:
    
        if (r19 > 9223372036854775L) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01c7, code lost:
    
        r30 = r19 * 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01cb, code lost:
    
        r30 = r10 + r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01cf, code lost:
    
        if (r30 < r10) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01d3, code lost:
    
        if (r30 <= 253402300799999L) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01d6, code lost:
    
        r19 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01d9, code lost:
    
        r19 = 253402300799999L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01dc, code lost:
    
        r19 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01de, code lost:
    
        r0 = r35.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01e2, code lost:
    
        if (r15 != null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01e4, code lost:
    
        r15 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01ea, code lost:
    
        if (r0.equals(r15) == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01f1, code lost:
    
        if (r0.endsWith(r15) == false) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0204, code lost:
    
        if (r0.charAt((r0.length() - r15.length()) - 1) != '.') goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0210, code lost:
    
        if (defpackage.be1.h.matcher(r0).matches() != false) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x021a, code lost:
    
        if (r0.length() == r15.length()) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x021c, code lost:
    
        r6 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.h;
        r6.getClass();
        r9 = java.net.IDN.toUnicode(r15).split("\\.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0231, code lost:
    
        if (r6.a.get() != false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x023b, code lost:
    
        if (r6.a.compareAndSet(false, true) == false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x023d, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0268, code lost:
    
        r6.b.await();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x026e, code lost:
    
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b1, code lost:
    
        r36 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01b5, code lost:
    
        if (r19 != Long.MIN_VALUE) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01b7, code lost:
    
        r19 = Long.MIN_VALUE;
     */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x033d A[LOOP:10: B:209:0x033a->B:211:0x033d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(defpackage.ix r34, defpackage.ga0 r35, defpackage.w70 r36) {
        /*
            Method dump skipped, instruction units count: 996
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ea0.d(ix, ga0, w70):void");
    }

    public static int e(int i, String str, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }
}
