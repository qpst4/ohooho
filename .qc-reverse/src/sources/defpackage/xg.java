package defpackage;

import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xg implements ol0 {
    public boolean b;
    public Object c;

    public xg(Runnable runnable) {
        this.b = false;
        this.c = runnable;
    }

    @Override // defpackage.ol0
    public void a(zk0 zk0Var, boolean z) {
        a2 a2Var;
        z61 z61Var = (z61) this.c;
        if (this.b) {
            return;
        }
        this.b = true;
        ActionMenuView actionMenuView = z61Var.a.a.b;
        if (actionMenuView != null && (a2Var = actionMenuView.u) != null) {
            a2Var.d();
            x1 x1Var = a2Var.u;
            if (x1Var != null && x1Var.b()) {
                x1Var.i.dismiss();
            }
        }
        z61Var.b.onPanelClosed(108, zk0Var);
        this.b = false;
    }

    public boolean b() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(int r7, java.lang.CharSequence r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L45
            if (r7 < 0) goto L45
            int r0 = r8.length()
            int r0 = r0 - r7
            if (r0 < 0) goto L45
            java.lang.Object r0 = r6.c
            ix r0 = (defpackage.ix) r0
            if (r0 != 0) goto L16
            boolean r6 = r6.b()
            return r6
        L16:
            r0 = 0
            r1 = 2
            r2 = r0
            r3 = r1
        L1a:
            r4 = 1
            if (r2 >= r7) goto L3a
            if (r3 != r1) goto L3a
            char r3 = r8.charAt(r2)
            byte r3 = java.lang.Character.getDirectionality(r3)
            xg r5 = defpackage.y41.a
            if (r3 == 0) goto L36
            if (r3 == r4) goto L34
            if (r3 == r1) goto L34
            switch(r3) {
                case 14: goto L36;
                case 15: goto L36;
                case 16: goto L34;
                case 17: goto L34;
                default: goto L32;
            }
        L32:
            r3 = r1
            goto L37
        L34:
            r3 = r0
            goto L37
        L36:
            r3 = r4
        L37:
            int r2 = r2 + 1
            goto L1a
        L3a:
            if (r3 == 0) goto L44
            if (r3 == r4) goto L43
            boolean r6 = r6.b()
            return r6
        L43:
            return r0
        L44:
            return r4
        L45:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xg.c(int, java.lang.CharSequence):boolean");
    }

    public void d() {
        if (this.b) {
            return;
        }
        ((Runnable) this.c).run();
        this.b = true;
    }

    public void e(lr1 lr1Var) {
        if (this.b) {
            pn1.g("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            ((ra) this.c).Q(new xc(lr1Var));
        } catch (Throwable unused) {
            pn1.g("BillingLogger", "logging failed.");
        }
    }

    @Override // defpackage.ol0
    public boolean s(zk0 zk0Var) {
        ((z61) this.c).b.onMenuOpened(108, zk0Var);
        return true;
    }

    public /* synthetic */ xg(Object obj, boolean z) {
        this.c = obj;
        this.b = z;
    }

    public /* synthetic */ xg(Object obj) {
        this.c = obj;
    }

    public xg(ix ixVar, boolean z) {
        this(ixVar);
        this.b = z;
    }
}
