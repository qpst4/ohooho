package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ib implements Iterator, Map.Entry {
    public int b;
    public int c = -1;
    public boolean d;
    public final /* synthetic */ kb e;

    public ib(kb kbVar) {
        this.e = kbVar;
        this.b = kbVar.d - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.d) {
            s1.f("This container does not support retaining Map.Entry objects");
            return false;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            int i = this.c;
            kb kbVar = this.e;
            if (fc0.b(key, kbVar.f(i)) && fc0.b(entry.getValue(), kbVar.i(this.c))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.d) {
            return this.e.f(this.c);
        }
        s1.f("This container does not support retaining Map.Entry objects");
        return null;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.d) {
            return this.e.i(this.c);
        }
        s1.f("This container does not support retaining Map.Entry objects");
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c < this.b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.d) {
            s1.f("This container does not support retaining Map.Entry objects");
            return 0;
        }
        int i = this.c;
        kb kbVar = this.e;
        Object objF = kbVar.f(i);
        Object objI = kbVar.i(this.c);
        return (objF == null ? 0 : objF.hashCode()) ^ (objI != null ? objI.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.c++;
        this.d = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.d) {
            throw new IllegalStateException();
        }
        this.e.g(this.c);
        this.c--;
        this.b--;
        this.d = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.d) {
            return this.e.h(this.c, obj);
        }
        s1.f("This container does not support retaining Map.Entry objects");
        return null;
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
