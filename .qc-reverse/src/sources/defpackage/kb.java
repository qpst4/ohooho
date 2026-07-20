package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kb extends t01 implements Map {
    public xg0 e;
    public hb f;
    public jb g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kb(t01 t01Var) {
        super(0);
        int i = t01Var.d;
        b(this.d + i);
        if (this.d != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(t01Var.f(i2), t01Var.i(i2));
            }
        } else if (i > 0) {
            pb.e0(0, 0, i, t01Var.b, this.b);
            pb.f0(0, 0, i << 1, t01Var.c, this.c);
            this.d = i;
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        xg0 xg0Var = this.e;
        if (xg0Var != null) {
            return xg0Var;
        }
        xg0 xg0Var2 = new xg0(2, this);
        this.e = xg0Var2;
        return xg0Var2;
    }

    public final boolean j(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(Collection collection) {
        int i = this.d;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i != this.d;
    }

    @Override // java.util.Map
    public final Set keySet() {
        hb hbVar = this.f;
        if (hbVar != null) {
            return hbVar;
        }
        hb hbVar2 = new hb(this);
        this.f = hbVar2;
        return hbVar2;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.d);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        jb jbVar = this.g;
        if (jbVar != null) {
            return jbVar;
        }
        jb jbVar2 = new jb(this);
        this.g = jbVar2;
        return jbVar2;
    }
}
