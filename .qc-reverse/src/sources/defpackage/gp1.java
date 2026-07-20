package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gp1 implements Cloneable {
    public final hp1 b;
    public hp1 c;

    public gp1(hp1 hp1Var) {
        this.b = hp1Var;
        if (hp1Var.c()) {
            zy.n("Default instance must be immutable.");
            throw null;
        }
        this.c = (hp1) hp1Var.d(4);
    }

    public static void a(int i, List list) {
        String str = "Element at index " + (list.size() - i) + " is null.";
        int size = list.size();
        while (true) {
            size--;
            if (size < i) {
                throw new NullPointerException(str);
            }
            list.remove(size);
        }
    }

    public final hp1 b() {
        boolean zC = this.c.c();
        hp1 hp1Var = this.c;
        if (zC) {
            hp1Var.j();
            hp1Var = this.c;
        }
        if (hp1.n(hp1Var, true)) {
            return hp1Var;
        }
        throw new iq1();
    }

    public final void c() {
        if (this.c.c()) {
            return;
        }
        hp1 hp1Var = (hp1) this.b.d(4);
        aq1.c.a(hp1Var.getClass()).b(hp1Var, this.c);
        this.c = hp1Var;
    }

    public final Object clone() {
        gp1 gp1Var = (gp1) this.b.d(5);
        boolean zC = this.c.c();
        hp1 hp1Var = this.c;
        if (zC) {
            hp1Var.j();
            hp1Var = this.c;
        }
        gp1Var.c = hp1Var;
        return gp1Var;
    }
}
