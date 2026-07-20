package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f8 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Context c;

    public /* synthetic */ f8(Context context, int i) {
        this.b = i;
        this.c = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r10 = this;
            int r0 = r10.b
            android.content.Context r10 = r10.c
            switch(r0) {
                case 0: goto L2d;
                case 1: goto L13;
                default: goto L7;
            }
        L7:
            jr0 r0 = new jr0
            r0.<init>()
            ow0 r1 = defpackage.fp1.c
            r2 = 0
            defpackage.fp1.H(r10, r0, r1, r2)
            return
        L13:
            java.util.concurrent.ThreadPoolExecutor r3 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.LinkedBlockingQueue r9 = new java.util.concurrent.LinkedBlockingQueue
            r9.<init>()
            r4 = 0
            r5 = 1
            r6 = 0
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS
            r3.<init>(r4, r5, r6, r8, r9)
            f8 r0 = new f8
            r1 = 2
            r0.<init>(r10, r1)
            r3.execute(r0)
            return
        L2d:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 33
            if (r0 < r2) goto Lad
            android.content.ComponentName r3 = new android.content.ComponentName
            java.lang.String r4 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            r3.<init>(r10, r4)
            android.content.pm.PackageManager r4 = r10.getPackageManager()
            int r4 = r4.getComponentEnabledSetting(r3)
            if (r4 == r1) goto Lad
            java.lang.String r4 = "locale"
            if (r0 < r2) goto L84
            mb r0 = defpackage.k8.h
            r0.getClass()
            gb r2 = new gb
            r2.<init>(r0)
        L53:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L72
            java.lang.Object r0 = r2.next()
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            java.lang.Object r0 = r0.get()
            k8 r0 = (defpackage.k8) r0
            if (r0 == 0) goto L53
            y8 r0 = (defpackage.y8) r0
            android.content.Context r0 = r0.l
            if (r0 == 0) goto L53
            java.lang.Object r0 = r0.getSystemService(r4)
            goto L73
        L72:
            r0 = 0
        L73:
            if (r0 == 0) goto L89
            android.os.LocaleList r0 = defpackage.h8.a(r0)
            ai0 r2 = new ai0
            bi0 r5 = new bi0
            r5.<init>(r0)
            r2.<init>(r5)
            goto L8b
        L84:
            ai0 r2 = defpackage.k8.d
            if (r2 == 0) goto L89
            goto L8b
        L89:
            ai0 r2 = defpackage.ai0.b
        L8b:
            bi0 r0 = r2.a
            android.os.LocaleList r0 = r0.a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto La6
            java.lang.String r0 = defpackage.xr.F(r10)
            java.lang.Object r2 = r10.getSystemService(r4)
            if (r2 == 0) goto La6
            android.os.LocaleList r0 = defpackage.g8.a(r0)
            defpackage.h8.b(r2, r0)
        La6:
            android.content.pm.PackageManager r10 = r10.getPackageManager()
            r10.setComponentEnabledSetting(r3, r1, r1)
        Lad:
            defpackage.k8.g = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f8.run():void");
    }
}
