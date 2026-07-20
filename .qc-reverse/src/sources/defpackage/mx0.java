package defpackage;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mx0 implements px0 {
    public final e8 a;
    public boolean b;
    public Bundle c;
    public final u31 d;

    public mx0(e8 e8Var, fg1 fg1Var) {
        e8Var.getClass();
        this.a = e8Var;
        this.d = new u31(new ci0(fg1Var, 1));
    }

    @Override // defpackage.px0
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        Iterator it = ((nx0) this.d.a()).c.entrySet().iterator();
        if (!it.hasNext()) {
            this.b = false;
            return bundle;
        }
        Map.Entry entry = (Map.Entry) it.next();
        ((lx0) entry.getValue()).getClass();
        throw null;
    }
}
