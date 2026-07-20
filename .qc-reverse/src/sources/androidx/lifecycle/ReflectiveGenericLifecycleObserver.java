package androidx.lifecycle;

import defpackage.dg0;
import defpackage.fg0;
import defpackage.gg0;
import defpackage.mk;
import defpackage.ok;
import defpackage.yf0;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements dg0 {
    public final fg0 b;
    public final mk c;

    public ReflectiveGenericLifecycleObserver(fg0 fg0Var) {
        this.b = fg0Var;
        ok okVar = ok.c;
        Class<?> cls = fg0Var.getClass();
        mk mkVar = (mk) okVar.a.get(cls);
        this.c = mkVar == null ? okVar.a(cls, null) : mkVar;
    }

    @Override // defpackage.dg0
    public final void c(gg0 gg0Var, yf0 yf0Var) {
        HashMap map = this.c.a;
        List list = (List) map.get(yf0Var);
        fg0 fg0Var = this.b;
        mk.a(list, gg0Var, yf0Var, fg0Var);
        mk.a((List) map.get(yf0.ON_ANY), gg0Var, yf0Var, fg0Var);
    }
}
