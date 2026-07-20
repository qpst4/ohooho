package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gb implements Iterator, ce0 {
    public int b;
    public int c;
    public boolean d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public gb(kb kbVar, int i) {
        this(kbVar.d);
        this.e = i;
        switch (i) {
            case 1:
                this.f = kbVar;
                this(kbVar.d);
                break;
            default:
                this.f = kbVar;
                break;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c < this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objF;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.c;
        int i2 = this.e;
        Object obj = this.f;
        switch (i2) {
            case 0:
                objF = ((kb) obj).f(i);
                break;
            case 1:
                objF = ((kb) obj).i(i);
                break;
            default:
                objF = ((mb) obj).c[i];
                break;
        }
        this.c++;
        this.d = true;
        return objF;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.d) {
            s1.f("Call next() before removing an element.");
            return;
        }
        int i = this.c - 1;
        this.c = i;
        int i2 = this.e;
        Object obj = this.f;
        switch (i2) {
            case 0:
                ((kb) obj).g(i);
                break;
            case 1:
                ((kb) obj).g(i);
                break;
            default:
                ((mb) obj).b(i);
                break;
        }
        this.b--;
        this.d = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public gb(mb mbVar) {
        this(mbVar.d);
        this.e = 2;
        this.f = mbVar;
    }

    public gb(int i) {
        this.b = i;
    }
}
