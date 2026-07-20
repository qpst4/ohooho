package defpackage;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h90 {
    public static final ai a = ai.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final String[] b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final String[] c = new String[64];
    public static final String[] d = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = d;
            if (i2 >= strArr.length) {
                break;
            }
            Object[] objArr = {Integer.toBinaryString(i2)};
            byte[] bArr = be1.a;
            strArr[i2] = String.format(Locale.US, "%8s", objArr).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i3 = iArr[0];
        strArr2[i3 | 8] = l11.k(new StringBuilder(), strArr2[i3], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            int i6 = iArr[0];
            String[] strArr3 = c;
            int i7 = i6 | i5;
            strArr3[i7] = strArr3[i6] + '|' + strArr3[i5];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i6]);
            sb.append('|');
            strArr3[i7 | 8] = l11.k(sb, strArr3[i5], "|PADDED");
        }
        while (true) {
            String[] strArr4 = c;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = d[i];
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(boolean r4, int r5, int r6, byte r7, byte r8) {
        /*
            java.lang.String[] r0 = defpackage.h90.b
            int r1 = r0.length
            if (r7 >= r1) goto L8
            r0 = r0[r7]
            goto L1a
        L8:
            java.lang.Byte r0 = java.lang.Byte.valueOf(r7)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            byte[] r1 = defpackage.be1.a
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "0x%02x"
            java.lang.String r0 = java.lang.String.format(r1, r2, r0)
        L1a:
            if (r8 != 0) goto L1f
            java.lang.String r7 = ""
            goto L6a
        L1f:
            r1 = 2
            java.lang.String[] r2 = defpackage.h90.d
            if (r7 == r1) goto L68
            r1 = 3
            if (r7 == r1) goto L68
            r1 = 4
            if (r7 == r1) goto L5f
            r1 = 6
            if (r7 == r1) goto L5f
            r1 = 7
            if (r7 == r1) goto L68
            r1 = 8
            if (r7 == r1) goto L68
            java.lang.String[] r1 = defpackage.h90.c
            int r3 = r1.length
            if (r8 >= r3) goto L3c
            r1 = r1[r8]
            goto L3e
        L3c:
            r1 = r2[r8]
        L3e:
            r2 = 5
            if (r7 != r2) goto L4e
            r2 = r8 & 4
            if (r2 == 0) goto L4e
            java.lang.String r7 = "HEADERS"
            java.lang.String r8 = "PUSH_PROMISE"
            java.lang.String r7 = r1.replace(r7, r8)
            goto L6a
        L4e:
            if (r7 != 0) goto L5d
            r7 = r8 & 32
            if (r7 == 0) goto L5d
            java.lang.String r7 = "PRIORITY"
            java.lang.String r8 = "COMPRESSED"
            java.lang.String r7 = r1.replace(r7, r8)
            goto L6a
        L5d:
            r7 = r1
            goto L6a
        L5f:
            r7 = 1
            if (r8 != r7) goto L65
            java.lang.String r7 = "ACK"
            goto L6a
        L65:
            r7 = r2[r8]
            goto L6a
        L68:
            r7 = r2[r8]
        L6a:
            if (r4 == 0) goto L6f
            java.lang.String r4 = "<<"
            goto L71
        L6f:
            java.lang.String r4 = ">>"
        L71:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r4 = new java.lang.Object[]{r4, r5, r6, r0, r7}
            byte[] r5 = defpackage.be1.a
            java.util.Locale r5 = java.util.Locale.US
            java.lang.String r6 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r4 = java.lang.String.format(r5, r6, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h90.a(boolean, int, int, byte, byte):java.lang.String");
    }

    public static void b(String str, Object... objArr) {
        byte[] bArr = be1.a;
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    public static void c(String str, Object... objArr) {
        byte[] bArr = be1.a;
        throw new IOException(String.format(Locale.US, str, objArr));
    }
}
