package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uz extends fb1 {
    public volatile fb1 a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ i70 d;
    public final /* synthetic */ mc1 e;
    public final /* synthetic */ vz f;

    public uz(vz vzVar, boolean z, boolean z2, i70 i70Var, mc1 mc1Var) {
        this.f = vzVar;
        this.b = z;
        this.c = z2;
        this.d = i70Var;
        this.e = mc1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0085 A[SYNTHETIC] */
    @Override // defpackage.fb1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(defpackage.vd0 r12) throws java.io.IOException {
        /*
            r11 = this;
            boolean r0 = r11.b
            r1 = 0
            if (r0 == 0) goto L9
            r12.P()
            return r1
        L9:
            fb1 r0 = r11.a
            if (r0 != 0) goto L94
            i70 r0 = r11.d
            vz r2 = r11.f
            mc1 r3 = r11.e
            jd0 r4 = r0.d
            r4.getClass()
            java.util.concurrent.ConcurrentHashMap r5 = r4.c
            id0 r6 = defpackage.jd0.d
            r7 = 1
            if (r2 != r6) goto L20
            goto L63
        L20:
            java.lang.Class r6 = r3.a()
            java.lang.Object r8 = r5.get(r6)
            gb1 r8 = (defpackage.gb1) r8
            if (r8 == 0) goto L2f
            if (r8 != r2) goto L64
            goto L63
        L2f:
            java.lang.Class<hd0> r8 = defpackage.hd0.class
            java.lang.annotation.Annotation r8 = r6.getAnnotation(r8)
            hd0 r8 = (defpackage.hd0) r8
            if (r8 != 0) goto L3a
            goto L64
        L3a:
            java.lang.Class r8 = r8.value()
            java.lang.Class<gb1> r9 = defpackage.gb1.class
            boolean r9 = r9.isAssignableFrom(r8)
            if (r9 != 0) goto L47
            goto L64
        L47:
            c70 r9 = r4.b
            mc1 r10 = new mc1
            r10.<init>(r8)
            jn0 r8 = r9.i(r10, r7)
            java.lang.Object r8 = r8.h()
            gb1 r8 = (defpackage.gb1) r8
            java.lang.Object r5 = r5.putIfAbsent(r6, r8)
            gb1 r5 = (defpackage.gb1) r5
            if (r5 == 0) goto L61
            r8 = r5
        L61:
            if (r8 != r2) goto L64
        L63:
            r2 = r4
        L64:
            java.util.List r4 = r0.e
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
        L6b:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L85
            java.lang.Object r6 = r4.next()
            gb1 r6 = (defpackage.gb1) r6
            if (r5 != 0) goto L7d
            if (r6 != r2) goto L6b
            r5 = r7
            goto L6b
        L7d:
            fb1 r6 = r6.a(r0, r3)
            if (r6 == 0) goto L6b
            r0 = r6
            goto L8b
        L85:
            if (r5 != 0) goto L8e
            fb1 r0 = r0.g(r3)
        L8b:
            r11.a = r0
            goto L94
        L8e:
            java.lang.String r11 = "GSON cannot serialize or deserialize "
            defpackage.zy.h(r11, r3)
            return r1
        L94:
            java.lang.Object r11 = r0.b(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uz.b(vd0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084 A[SYNTHETIC] */
    @Override // defpackage.fb1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.ae0 r11, java.lang.Object r12) throws java.io.IOException {
        /*
            r10 = this;
            boolean r0 = r10.c
            if (r0 == 0) goto L8
            r11.t()
            return
        L8:
            fb1 r0 = r10.a
            if (r0 != 0) goto L93
            i70 r0 = r10.d
            vz r1 = r10.f
            mc1 r2 = r10.e
            jd0 r3 = r0.d
            r3.getClass()
            java.util.concurrent.ConcurrentHashMap r4 = r3.c
            id0 r5 = defpackage.jd0.d
            r6 = 1
            if (r1 != r5) goto L1f
            goto L62
        L1f:
            java.lang.Class r5 = r2.a()
            java.lang.Object r7 = r4.get(r5)
            gb1 r7 = (defpackage.gb1) r7
            if (r7 == 0) goto L2e
            if (r7 != r1) goto L63
            goto L62
        L2e:
            java.lang.Class<hd0> r7 = defpackage.hd0.class
            java.lang.annotation.Annotation r7 = r5.getAnnotation(r7)
            hd0 r7 = (defpackage.hd0) r7
            if (r7 != 0) goto L39
            goto L63
        L39:
            java.lang.Class r7 = r7.value()
            java.lang.Class<gb1> r8 = defpackage.gb1.class
            boolean r8 = r8.isAssignableFrom(r7)
            if (r8 != 0) goto L46
            goto L63
        L46:
            c70 r8 = r3.b
            mc1 r9 = new mc1
            r9.<init>(r7)
            jn0 r7 = r8.i(r9, r6)
            java.lang.Object r7 = r7.h()
            gb1 r7 = (defpackage.gb1) r7
            java.lang.Object r4 = r4.putIfAbsent(r5, r7)
            gb1 r4 = (defpackage.gb1) r4
            if (r4 == 0) goto L60
            r7 = r4
        L60:
            if (r7 != r1) goto L63
        L62:
            r1 = r3
        L63:
            java.util.List r3 = r0.e
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
        L6a:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L84
            java.lang.Object r5 = r3.next()
            gb1 r5 = (defpackage.gb1) r5
            if (r4 != 0) goto L7c
            if (r5 != r1) goto L6a
            r4 = r6
            goto L6a
        L7c:
            fb1 r5 = r5.a(r0, r2)
            if (r5 == 0) goto L6a
            r0 = r5
            goto L8a
        L84:
            if (r4 != 0) goto L8d
            fb1 r0 = r0.g(r2)
        L8a:
            r10.a = r0
            goto L93
        L8d:
            java.lang.String r10 = "GSON cannot serialize or deserialize "
            defpackage.zy.h(r10, r2)
            return
        L93:
            r0.c(r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uz.c(ae0, java.lang.Object):void");
    }
}
