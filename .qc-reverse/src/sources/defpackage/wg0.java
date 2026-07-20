package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wg0 implements Iterator {
    public yg0 b;
    public yg0 c = null;
    public int d;
    public final /* synthetic */ zg0 e;
    public final /* synthetic */ int f;

    public wg0(zg0 zg0Var, int i) {
        this.f = i;
        this.e = zg0Var;
        this.b = zg0Var.g.e;
        this.d = zg0Var.f;
    }

    public final Object a() {
        return b();
    }

    public final yg0 b() {
        yg0 yg0Var = this.b;
        zg0 zg0Var = this.e;
        if (yg0Var == zg0Var.g) {
            throw new NoSuchElementException();
        }
        if (zg0Var.f != this.d) {
            throw new ConcurrentModificationException();
        }
        this.b = yg0Var.e;
        this.c = yg0Var;
        return yg0Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b != this.e.g;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.f) {
            case 1:
                return b().g;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        yg0 yg0Var = this.c;
        if (yg0Var == null) {
            throw new IllegalStateException();
        }
        zg0 zg0Var = this.e;
        zg0Var.c(yg0Var, true);
        this.c = null;
        this.d = zg0Var.f;
    }
}
