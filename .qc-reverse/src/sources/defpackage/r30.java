package defpackage;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class r30 {
    public boolean a;
    public final CopyOnWriteArrayList b;
    public k40 c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public r30(boolean z) {
        this.a = z;
        this.b = new CopyOnWriteArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r30(xp xpVar) {
        this(true);
        this.d = 1;
        this.e = xpVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r30(y30 y30Var) {
        this(false);
        this.d = 0;
        this.e = y30Var;
    }
}
