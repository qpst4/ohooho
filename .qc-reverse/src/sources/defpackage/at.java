package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class at implements Iterator, ce0 {
    public int b = -1;
    public int c;
    public int d;
    public bc0 e;
    public final /* synthetic */ bt f;

    public at(bt btVar) {
        this.f = btVar;
        int length = btVar.a.length();
        if (length >= 0) {
            length = length >= 0 ? 0 : length;
            this.c = length;
            this.d = length;
        } else {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum 0.");
        }
    }

    public final void a() {
        bp0 bp0Var;
        bt btVar = this.f;
        String str = btVar.a;
        int i = this.d;
        if (i < 0) {
            this.b = 0;
            this.e = null;
            return;
        }
        if (i <= str.length() && (bp0Var = (bp0) btVar.b.f(str, Integer.valueOf(this.d))) != null) {
            int iIntValue = ((Number) bp0Var.b).intValue();
            int iIntValue2 = ((Number) bp0Var.c).intValue();
            this.e = iIntValue <= Integer.MIN_VALUE ? bc0.e : new bc0(this.c, iIntValue - 1, 1);
            int i2 = iIntValue + iIntValue2;
            this.c = i2;
            this.d = i2 + (iIntValue2 == 0 ? 1 : 0);
        } else {
            this.e = new bc0(this.c, str.length() - 1, 1);
            this.d = -1;
        }
        this.b = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b == -1) {
            a();
        }
        return this.b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b == -1) {
            a();
        }
        if (this.b == 0) {
            throw new NoSuchElementException();
        }
        bc0 bc0Var = this.e;
        bc0Var.getClass();
        this.e = null;
        this.b = -1;
        return bc0Var;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
