package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x50 implements Iterator, ce0 {
    public Object b;
    public int c = -2;
    public final /* synthetic */ y50 d;

    public x50(y50 y50Var) {
        this.d = y50Var;
    }

    public final void a() {
        Object objG;
        if (this.c == -2) {
            n nVar = ct0.b;
            objG = Integer.valueOf(ct0.b.a().nextInt(2147418112) + 65536);
        } else {
            fp fpVar = (fp) this.d.b;
            Object obj = this.b;
            obj.getClass();
            objG = fpVar.g(obj);
        }
        this.b = objG;
        this.c = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.c < 0) {
            a();
        }
        return this.c == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.c < 0) {
            a();
        }
        if (this.c == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.b;
        obj.getClass();
        this.c = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
