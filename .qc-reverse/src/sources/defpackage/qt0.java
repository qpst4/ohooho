package defpackage;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qt0 {
    public final rt0 a = new rt0();
    public boolean b = false;

    public abstract int a();

    public long b(int i) {
        return -1L;
    }

    public int c(int i) {
        return 0;
    }

    public final void d() {
        this.a.b();
    }

    public abstract void e(pu0 pu0Var, int i);

    public abstract pu0 f(ViewGroup viewGroup, int i);

    public final void g(boolean z) {
        if (this.a.a()) {
            s1.f("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        } else {
            this.b = z;
        }
    }
}
