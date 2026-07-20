package androidx.lifecycle;

import android.os.Bundle;
import defpackage.dg0;
import defpackage.gg0;
import defpackage.mx0;
import defpackage.yf0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements dg0 {
    public final mx0 b;

    public SavedStateHandleAttacher(mx0 mx0Var) {
        this.b = mx0Var;
    }

    @Override // defpackage.dg0
    public final void c(gg0 gg0Var, yf0 yf0Var) {
        if (yf0Var != yf0.ON_CREATE) {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + yf0Var).toString());
        }
        gg0Var.p().f(this);
        mx0 mx0Var = this.b;
        if (mx0Var.b) {
            return;
        }
        Bundle bundleC = mx0Var.a.c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = mx0Var.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleC != null) {
            bundle.putAll(bundleC);
        }
        mx0Var.c = bundle;
        mx0Var.b = true;
    }
}
