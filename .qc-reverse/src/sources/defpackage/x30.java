package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x30 implements w30 {
    public final String a;
    public final int b;
    public final /* synthetic */ y30 c;

    public x30(y30 y30Var, String str, int i) {
        this.c = y30Var;
        this.a = str;
        this.b = i;
    }

    @Override // defpackage.w30
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        j30 j30Var = this.c.w;
        if (j30Var != null && this.b < 0 && this.a == null && j30Var.l().Q(-1, 0)) {
            return false;
        }
        return this.c.R(arrayList, arrayList2, this.a, this.b, 1);
    }
}
