package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ez0 implements Iterable, ce0 {
    public final /* synthetic */ bt b;

    public ez0(bt btVar) {
        this.b = btVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new at(this.b);
    }
}
