package defpackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gn {
    public int b;
    public boolean c;
    public final vn d;
    public final int e;
    public gn f;
    public m11 i;
    public HashSet a = null;
    public int g = 0;
    public int h = Integer.MIN_VALUE;

    public gn(vn vnVar, int i) {
        this.d = vnVar;
        this.e = i;
    }

    public final void a(gn gnVar, int i) {
        b(gnVar, i, Integer.MIN_VALUE, false);
    }

    public final boolean b(gn gnVar, int i, int i2, boolean z) {
        if (gnVar == null) {
            j();
            return true;
        }
        if (!z && !i(gnVar)) {
            return false;
        }
        this.f = gnVar;
        if (gnVar.a == null) {
            gnVar.a = new HashSet();
        }
        HashSet hashSet = this.f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.g = i;
        this.h = i2;
        return true;
    }

    public final void c(int i, nh1 nh1Var, ArrayList arrayList) {
        HashSet hashSet = this.a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                fp1.f(((gn) it.next()).d, i, arrayList, nh1Var);
            }
        }
    }

    public final int d() {
        if (this.c) {
            return this.b;
        }
        return 0;
    }

    public final int e() {
        gn gnVar;
        if (this.d.g0 == 8) {
            return 0;
        }
        int i = this.h;
        return (i == Integer.MIN_VALUE || (gnVar = this.f) == null || gnVar.d.g0 != 8) ? this.g : i;
    }

    public final gn f() {
        int i = this.e;
        int iR = l11.r(i);
        vn vnVar = this.d;
        switch (iR) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return vnVar.K;
            case 2:
                return vnVar.L;
            case 3:
                return vnVar.I;
            case 4:
                return vnVar.J;
            default:
                throw new AssertionError(l11.o(i));
        }
    }

    public final boolean g() {
        HashSet hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((gn) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0063 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(defpackage.gn r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L5
            goto L65
        L5:
            vn r1 = r10.d
            int r10 = r10.e
            r2 = 6
            int r3 = r9.e
            r4 = 1
            if (r10 != r3) goto L1c
            if (r3 != r2) goto L63
            boolean r10 = r1.E
            if (r10 == 0) goto L65
            vn r9 = r9.d
            boolean r9 = r9.E
            if (r9 != 0) goto L63
            goto L65
        L1c:
            int r9 = defpackage.l11.r(r3)
            r5 = 4
            r6 = 2
            r7 = 9
            r8 = 8
            switch(r9) {
                case 0: goto L65;
                case 1: goto L53;
                case 2: goto L3f;
                case 3: goto L53;
                case 4: goto L3f;
                case 5: goto L3a;
                case 6: goto L33;
                case 7: goto L65;
                case 8: goto L65;
                default: goto L29;
            }
        L29:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            java.lang.String r10 = defpackage.l11.o(r3)
            r9.<init>(r10)
            throw r9
        L33:
            if (r10 == r2) goto L65
            if (r10 == r8) goto L65
            if (r10 == r7) goto L65
            goto L63
        L3a:
            if (r10 == r6) goto L65
            if (r10 != r5) goto L63
            goto L65
        L3f:
            r9 = 3
            if (r10 == r9) goto L48
            r9 = 5
            if (r10 != r9) goto L46
            goto L48
        L46:
            r9 = r0
            goto L49
        L48:
            r9 = r4
        L49:
            boolean r1 = r1 instanceof defpackage.n70
            if (r1 == 0) goto L52
            if (r9 != 0) goto L63
            if (r10 != r7) goto L65
            goto L63
        L52:
            return r9
        L53:
            if (r10 == r6) goto L5a
            if (r10 != r5) goto L58
            goto L5a
        L58:
            r9 = r0
            goto L5b
        L5a:
            r9 = r4
        L5b:
            boolean r1 = r1 instanceof defpackage.n70
            if (r1 == 0) goto L64
            if (r9 != 0) goto L63
            if (r10 != r8) goto L65
        L63:
            return r4
        L64:
            return r9
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gn.i(gn):boolean");
    }

    public final void j() {
        HashSet hashSet;
        gn gnVar = this.f;
        if (gnVar != null && (hashSet = gnVar.a) != null) {
            hashSet.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = Integer.MIN_VALUE;
        this.c = false;
        this.b = 0;
    }

    public final void k() {
        m11 m11Var = this.i;
        if (m11Var == null) {
            this.i = new m11(1);
        } else {
            m11Var.c();
        }
    }

    public final void l(int i) {
        this.b = i;
        this.c = true;
    }

    public final String toString() {
        return this.d.h0 + ":" + l11.o(this.e);
    }
}
