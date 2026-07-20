package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f7 extends m implements cp {
    private volatile Object _preHandler;

    public f7() {
        super(c70.f);
        this._preHandler = this;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(java.lang.Throwable r4) {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r1 > r0) goto L4a
            r1 = 28
            if (r0 >= r1) goto L4a
            java.lang.Object r0 = r3._preHandler
            r1 = 0
            if (r0 == r3) goto L12
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
            goto L32
        L12:
            java.lang.Class<java.lang.Thread> r0 = java.lang.Thread.class
            java.lang.String r2 = "getUncaughtExceptionPreHandler"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r1)     // Catch: java.lang.Throwable -> L2f
            int r2 = r0.getModifiers()     // Catch: java.lang.Throwable -> L2f
            boolean r2 = java.lang.reflect.Modifier.isPublic(r2)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L2f
            int r2 = r0.getModifiers()     // Catch: java.lang.Throwable -> L2f
            boolean r2 = java.lang.reflect.Modifier.isStatic(r2)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L2f
            goto L30
        L2f:
            r0 = r1
        L30:
            r3._preHandler = r0
        L32:
            if (r0 == 0) goto L39
            java.lang.Object r3 = r0.invoke(r1, r1)
            goto L3a
        L39:
            r3 = r1
        L3a:
            boolean r0 = r3 instanceof java.lang.Thread.UncaughtExceptionHandler
            if (r0 == 0) goto L41
            r1 = r3
            java.lang.Thread$UncaughtExceptionHandler r1 = (java.lang.Thread.UncaughtExceptionHandler) r1
        L41:
            if (r1 == 0) goto L4a
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            r1.uncaughtException(r3, r4)
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f7.q(java.lang.Throwable):void");
    }
}
