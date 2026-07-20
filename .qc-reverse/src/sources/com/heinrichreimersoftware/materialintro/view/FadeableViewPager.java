package com.heinrichreimersoftware.materialintro.view;

import android.content.Context;
import android.util.AttributeSet;
import defpackage.c10;
import defpackage.e10;
import defpackage.kg1;
import defpackage.p31;
import defpackage.xo0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class FadeableViewPager extends p31 {
    public FadeableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f0 = -1;
        this.h0 = true;
        this.i0 = true;
        this.j0 = false;
        this.k0 = false;
    }

    @Override // defpackage.mg1
    public final void b(kg1 kg1Var) {
        c10 c10Var = new c10(this, kg1Var);
        if (this.U == null) {
            this.U = new ArrayList();
        }
        this.U.add(c10Var);
    }

    @Override // defpackage.mg1
    public xo0 getAdapter() {
        e10 e10Var = (e10) super.getAdapter();
        if (e10Var == null) {
            return null;
        }
        return e10Var.c;
    }

    @Override // defpackage.mg1
    public void setAdapter(xo0 xo0Var) {
        super.setAdapter(new e10(xo0Var));
    }

    @Override // defpackage.mg1
    @Deprecated
    public void setOnPageChangeListener(kg1 kg1Var) {
        super.setOnPageChangeListener(new c10(this, kg1Var));
    }
}
