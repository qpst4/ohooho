package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nm1 extends cn1 {
    public final Object b;
    public boolean c;

    public nm1(Object obj) {
        this.b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.c) {
            throw new NoSuchElementException();
        }
        this.c = true;
        return this.b;
    }
}
