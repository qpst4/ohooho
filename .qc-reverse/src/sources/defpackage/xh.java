package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xh implements Iterator {
    public final /* synthetic */ int b = 1;
    public int c = 0;
    public final int d;
    public final /* synthetic */ Object e;

    public xh(yo1 yo1Var) {
        this.e = yo1Var;
        this.d = yo1Var.d();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.b) {
            case 0:
                if (this.c < this.d) {
                }
                break;
            default:
                if (this.c < this.d) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        Object obj = this.e;
        switch (i) {
            case 0:
                try {
                    int i2 = this.c;
                    this.c = i2 + 1;
                    return Byte.valueOf(((zh) obj).b(i2));
                } catch (IndexOutOfBoundsException e) {
                    throw new NoSuchElementException(e.getMessage());
                }
            default:
                int i3 = this.c;
                if (i3 >= this.d) {
                    throw new NoSuchElementException();
                }
                this.c = i3 + 1;
                return Byte.valueOf(((yo1) obj).c(i3));
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public xh(zh zhVar) {
        this.e = zhVar;
        this.d = zhVar.size();
    }
}
