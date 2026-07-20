package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c90 extends a90 {
    public final ga0 f;
    public long g;
    public boolean h;
    public final /* synthetic */ g90 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c90(g90 g90Var, ga0 ga0Var) {
        super(g90Var);
        this.i = g90Var;
        this.g = -1L;
        this.h = true;
        this.f = ga0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zO;
        if (this.c) {
            return;
        }
        if (this.h) {
            try {
                zO = be1.o(this, 100);
            } catch (IOException unused) {
                zO = false;
            }
            if (!zO) {
                a(false, null);
            }
        }
        this.c = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        if (r10.h == false) goto L25;
     */
    @Override // defpackage.a90, defpackage.n11
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long j(defpackage.mh r11, long r12) throws java.io.IOException {
        /*
            r10 = this;
            boolean r12 = r10.c
            r0 = 0
            if (r12 != 0) goto Lae
            boolean r12 = r10.h
            r2 = -1
            if (r12 != 0) goto Ld
            goto L65
        Ld:
            long r12 = r10.g
            int r4 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r5 = 0
            if (r4 == 0) goto L18
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 != 0) goto L66
        L18:
            g90 r4 = r10.i
            oh r6 = r4.c
            java.lang.String r7 = "expected chunk size and optional extensions but was \""
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 == 0) goto L25
            r6.f()
        L25:
            long r12 = r6.p()     // Catch: java.lang.NumberFormatException -> La3
            r10.g = r12     // Catch: java.lang.NumberFormatException -> La3
            java.lang.String r12 = r6.f()     // Catch: java.lang.NumberFormatException -> La3
            java.lang.String r12 = r12.trim()     // Catch: java.lang.NumberFormatException -> La3
            long r8 = r10.g     // Catch: java.lang.NumberFormatException -> La3
            int r13 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r13 < 0) goto L87
            boolean r13 = r12.isEmpty()     // Catch: java.lang.NumberFormatException -> La3
            if (r13 != 0) goto L47
            java.lang.String r13 = ";"
            boolean r13 = r12.startsWith(r13)     // Catch: java.lang.NumberFormatException -> La3
            if (r13 == 0) goto L87
        L47:
            long r12 = r10.g
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 != 0) goto L61
            r10.h = r5
            sn0 r12 = r4.a
            ix r12 = r12.i
            ga0 r13 = r10.f
            w70 r0 = r4.h()
            defpackage.ea0.d(r12, r13, r0)
            r12 = 1
            r13 = 0
            r10.a(r12, r13)
        L61:
            boolean r12 = r10.h
            if (r12 != 0) goto L66
        L65:
            return r2
        L66:
            long r12 = r10.g
            r0 = 8192(0x2000, double:4.0474E-320)
            long r12 = java.lang.Math.min(r0, r12)
            long r11 = super.j(r11, r12)
            int r13 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r13 == 0) goto L7c
            long r0 = r10.g
            long r0 = r0 - r11
            r10.g = r0
            return r11
        L7c:
            java.net.ProtocolException r11 = new java.net.ProtocolException
            java.lang.String r12 = "unexpected end of stream"
            r11.<init>(r12)
            r10.a(r5, r11)
            throw r11
        L87:
            java.net.ProtocolException r11 = new java.net.ProtocolException     // Catch: java.lang.NumberFormatException -> La3
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> La3
            r13.<init>(r7)     // Catch: java.lang.NumberFormatException -> La3
            long r0 = r10.g     // Catch: java.lang.NumberFormatException -> La3
            r13.append(r0)     // Catch: java.lang.NumberFormatException -> La3
            r13.append(r12)     // Catch: java.lang.NumberFormatException -> La3
            java.lang.String r10 = "\""
            r13.append(r10)     // Catch: java.lang.NumberFormatException -> La3
            java.lang.String r10 = r13.toString()     // Catch: java.lang.NumberFormatException -> La3
            r11.<init>(r10)     // Catch: java.lang.NumberFormatException -> La3
            throw r11     // Catch: java.lang.NumberFormatException -> La3
        La3:
            r10 = move-exception
            java.net.ProtocolException r11 = new java.net.ProtocolException
            java.lang.String r10 = r10.getMessage()
            r11.<init>(r10)
            throw r11
        Lae:
            java.lang.String r10 = "closed"
            defpackage.s1.f(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c90.j(mh, long):long");
    }
}
