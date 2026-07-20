package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bt implements bz0 {
    public final String a;
    public final d31 b;

    public bt(String str, d31 d31Var) {
        this.a = str;
        this.b = d31Var;
    }

    @Override // defpackage.bz0
    public final Iterator iterator() {
        return new at(this);
    }
}
