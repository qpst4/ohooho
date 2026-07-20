package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x7 implements px0 {
    public final /* synthetic */ int a;
    public final Object b;

    public x7(e8 e8Var) {
        this.a = 1;
        this.b = new LinkedHashSet();
        e8Var.e("androidx.savedstate.Restarter", this);
    }

    @Override // defpackage.px0
    public final Bundle a() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Bundle bundle = new Bundle();
                ((z7) obj).u().getClass();
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) obj));
                return bundle2;
        }
    }

    public x7(z7 z7Var) {
        this.a = 0;
        this.b = z7Var;
    }
}
