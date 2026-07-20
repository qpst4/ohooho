package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class j10 extends ix0 {
    public final HashMap f = new HashMap();

    @Override // defpackage.ix0
    public final fx0 b(Object obj) {
        return (fx0) this.f.get(obj);
    }

    @Override // defpackage.ix0
    public final Object c(Object obj) {
        Object objC = super.c(obj);
        this.f.remove(obj);
        return objC;
    }
}
