package defpackage;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y90 implements n11 {
    public final mh b = new mh();
    public final mh c = new mh();
    public final long d;
    public boolean e;
    public boolean f;
    public final /* synthetic */ aa0 g;

    public y90(aa0 aa0Var, long j) {
        this.g = aa0Var;
        this.d = j;
    }

    @Override // defpackage.n11
    public final a61 b() {
        return this.g.i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j;
        synchronized (this.g) {
            this.e = true;
            mh mhVar = this.c;
            j = mhVar.c;
            try {
                mhVar.skip(j);
                this.g.e.isEmpty();
                this.g.notifyAll();
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
        if (j > 0) {
            this.g.d.s(j);
        }
        this.g.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0093  */
    @Override // defpackage.n11
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long j(defpackage.mh r13, long r14) throws defpackage.v21 {
        /*
            r12 = this;
        L0:
            aa0 r14 = r12.g
            monitor-enter(r14)
            aa0 r15 = r12.g     // Catch: java.lang.Throwable -> L6f
            z90 r15 = r15.i     // Catch: java.lang.Throwable -> L6f
            r15.i()     // Catch: java.lang.Throwable -> L6f
            aa0 r15 = r12.g     // Catch: java.lang.Throwable -> L59
            int r0 = r15.k     // Catch: java.lang.Throwable -> L59
            if (r0 == 0) goto L11
            goto L12
        L11:
            r0 = 0
        L12:
            boolean r1 = r12.e     // Catch: java.lang.Throwable -> L59
            if (r1 != 0) goto L9c
            java.util.ArrayDeque r15 = r15.e     // Catch: java.lang.Throwable -> L59
            r15.isEmpty()     // Catch: java.lang.Throwable -> L59
            mh r15 = r12.c     // Catch: java.lang.Throwable -> L59
            long r1 = r15.c     // Catch: java.lang.Throwable -> L59
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = -1
            if (r5 <= 0) goto L5b
            r8 = 8192(0x2000, double:4.0474E-320)
            long r1 = java.lang.Math.min(r8, r1)     // Catch: java.lang.Throwable -> L59
            long r1 = r15.j(r13, r1)     // Catch: java.lang.Throwable -> L59
            aa0 r13 = r12.g     // Catch: java.lang.Throwable -> L59
            long r8 = r13.a     // Catch: java.lang.Throwable -> L59
            long r8 = r8 + r1
            r13.a = r8     // Catch: java.lang.Throwable -> L59
            if (r0 != 0) goto L7f
            u90 r13 = r13.d     // Catch: java.lang.Throwable -> L59
            jl1 r13 = r13.o     // Catch: java.lang.Throwable -> L59
            int r13 = r13.d()     // Catch: java.lang.Throwable -> L59
            int r13 = r13 / 2
            long r10 = (long) r13     // Catch: java.lang.Throwable -> L59
            int r13 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r13 < 0) goto L7f
            aa0 r13 = r12.g     // Catch: java.lang.Throwable -> L59
            u90 r15 = r13.d     // Catch: java.lang.Throwable -> L59
            int r5 = r13.c     // Catch: java.lang.Throwable -> L59
            long r8 = r13.a     // Catch: java.lang.Throwable -> L59
            r15.v(r5, r8)     // Catch: java.lang.Throwable -> L59
            aa0 r13 = r12.g     // Catch: java.lang.Throwable -> L59
            r13.a = r3     // Catch: java.lang.Throwable -> L59
            goto L7f
        L59:
            r13 = move-exception
            goto La4
        L5b:
            boolean r15 = r12.f     // Catch: java.lang.Throwable -> L59
            if (r15 != 0) goto L7e
            if (r0 != 0) goto L7e
            aa0 r15 = r12.g     // Catch: java.lang.Throwable -> L59
            r15.wait()     // Catch: java.lang.Throwable -> L59 java.lang.InterruptedException -> L71
            aa0 r15 = r12.g     // Catch: java.lang.Throwable -> L6f
            z90 r15 = r15.i     // Catch: java.lang.Throwable -> L6f
            r15.n()     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L6f
            goto L0
        L6f:
            r12 = move-exception
            goto Lac
        L71:
            java.lang.Thread r13 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L59
            r13.interrupt()     // Catch: java.lang.Throwable -> L59
            java.io.InterruptedIOException r13 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L59
            r13.<init>()     // Catch: java.lang.Throwable -> L59
            throw r13     // Catch: java.lang.Throwable -> L59
        L7e:
            r1 = r6
        L7f:
            aa0 r13 = r12.g     // Catch: java.lang.Throwable -> L6f
            z90 r13 = r13.i     // Catch: java.lang.Throwable -> L6f
            r13.n()     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L6f
            int r13 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r13 == 0) goto L93
            aa0 r12 = r12.g
            u90 r12 = r12.d
            r12.s(r1)
            return r1
        L93:
            if (r0 != 0) goto L96
            return r6
        L96:
            v21 r12 = new v21
            r12.<init>(r0)
            throw r12
        L9c:
            java.io.IOException r13 = new java.io.IOException     // Catch: java.lang.Throwable -> L59
            java.lang.String r15 = "stream closed"
            r13.<init>(r15)     // Catch: java.lang.Throwable -> L59
            throw r13     // Catch: java.lang.Throwable -> L59
        La4:
            aa0 r12 = r12.g     // Catch: java.lang.Throwable -> L6f
            z90 r12 = r12.i     // Catch: java.lang.Throwable -> L6f
            r12.n()     // Catch: java.lang.Throwable -> L6f
            throw r13     // Catch: java.lang.Throwable -> L6f
        Lac:
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L6f
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y90.j(mh, long):long");
    }
}
