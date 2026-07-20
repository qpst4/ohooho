package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mm1 implements Iterator {
    public final Iterator b;
    public boolean c;
    public Object d;

    public mm1(Iterator it) {
        it.getClass();
        this.b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c || this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.c) {
            return this.b.next();
        }
        Object obj = this.d;
        this.c = false;
        this.d = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.c) {
            s1.f("Can't remove after you've peeked at next");
        } else {
            this.b.remove();
        }
    }
}
