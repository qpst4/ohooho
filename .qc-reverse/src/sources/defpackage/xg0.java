package defpackage;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xg0 extends AbstractSet {
    public final /* synthetic */ int b;
    public final /* synthetic */ Map c;

    public /* synthetic */ xg0(int i, Map map) {
        this.b = i;
        this.c = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        int i = this.b;
        Map map = this.c;
        switch (i) {
            case 0:
                ((zg0) map).clear();
                break;
            case 1:
                ((zg0) map).clear();
                break;
            default:
                super.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        yg0 yg0VarA;
        int i = this.b;
        Map map = this.c;
        switch (i) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                zg0 zg0Var = (zg0) map;
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                yg0 yg0Var = null;
                if (key != null) {
                    try {
                        yg0VarA = zg0Var.a(key, false);
                    } catch (ClassCastException unused) {
                        yg0VarA = null;
                    }
                    break;
                } else {
                    yg0VarA = null;
                }
                if (yg0VarA != null && Objects.equals(yg0VarA.i, entry.getValue())) {
                    yg0Var = yg0VarA;
                }
                return yg0Var != null;
            case 1:
                return ((zg0) map).containsKey(obj);
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i = this.b;
        Map map = this.c;
        switch (i) {
            case 0:
                return new wg0((zg0) map, 0);
            case 1:
                return new wg0((zg0) map, 1);
            default:
                return new ib((kb) map);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        yg0 yg0VarA;
        int i = this.b;
        yg0 yg0VarA2 = null;
        Map map = this.c;
        switch (i) {
            case 0:
                zg0 zg0Var = (zg0) map;
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                if (key != null) {
                    try {
                        yg0VarA = zg0Var.a(key, false);
                    } catch (ClassCastException unused) {
                        yg0VarA = null;
                    }
                    break;
                } else {
                    yg0VarA = null;
                }
                if (yg0VarA != null && Objects.equals(yg0VarA.i, entry.getValue())) {
                    yg0VarA2 = yg0VarA;
                }
                if (yg0VarA2 == null) {
                    return false;
                }
                zg0Var.c(yg0VarA2, true);
                return true;
            case 1:
                zg0 zg0Var2 = (zg0) map;
                if (obj != null) {
                    try {
                        yg0VarA2 = zg0Var2.a(obj, false);
                        break;
                    } catch (ClassCastException unused2) {
                    }
                }
                if (yg0VarA2 != null) {
                    zg0Var2.c(yg0VarA2, true);
                }
                return yg0VarA2 != null;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i = this.b;
        Map map = this.c;
        switch (i) {
            case 0:
                return ((zg0) map).e;
            case 1:
                return ((zg0) map).e;
            default:
                return ((kb) map).d;
        }
    }
}
