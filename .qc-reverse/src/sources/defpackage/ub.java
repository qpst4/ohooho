package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ub extends Thread {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0017, code lost:
    
        r0.m();
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r2 = this;
        L0:
            java.lang.Class<vb> r2 = defpackage.vb.class
            monitor-enter(r2)     // Catch: java.lang.InterruptedException -> L0
            vb r0 = defpackage.vb.h()     // Catch: java.lang.Throwable -> Lb
            if (r0 != 0) goto Ld
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
            goto L0
        Lb:
            r0 = move-exception
            goto L1b
        Ld:
            vb r1 = defpackage.vb.i     // Catch: java.lang.Throwable -> Lb
            if (r0 != r1) goto L16
            r0 = 0
            defpackage.vb.i = r0     // Catch: java.lang.Throwable -> Lb
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
            return
        L16:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
            r0.m()     // Catch: java.lang.InterruptedException -> L0
            goto L0
        L1b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
            throw r0     // Catch: java.lang.InterruptedException -> L0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ub.run():void");
    }
}
