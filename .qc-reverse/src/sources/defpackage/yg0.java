package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yg0 implements Map.Entry {
    public yg0 b;
    public yg0 c;
    public yg0 d;
    public yg0 e;
    public yg0 f;
    public final Object g;
    public final boolean h;
    public Object i;
    public int j;

    public yg0(boolean z, yg0 yg0Var, Object obj, yg0 yg0Var2, yg0 yg0Var3) {
        this.b = yg0Var;
        this.g = obj;
        this.h = z;
        this.j = 1;
        this.e = yg0Var2;
        this.f = yg0Var3;
        yg0Var3.e = this;
        yg0Var2.f = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.g;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.i;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.g;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.i;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.g;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.i;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.h) {
            zy.r("value == null");
            return null;
        }
        Object obj2 = this.i;
        this.i = obj;
        return obj2;
    }

    public final String toString() {
        return this.g + "=" + this.i;
    }

    public yg0(boolean z) {
        this.g = null;
        this.h = z;
        this.f = this;
        this.e = this;
    }
}
