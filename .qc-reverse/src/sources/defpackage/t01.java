package defpackage;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class t01 {
    public int[] b;
    public Object[] c;
    public int d;

    public t01(int i) {
        this.b = i == 0 ? f01.d : new int[i];
        this.c = i == 0 ? f01.e : new Object[i << 1];
    }

    public final int a(Object obj) {
        int i = this.d * 2;
        Object[] objArr = this.c;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i) {
        int i2 = this.d;
        int[] iArr = this.b;
        if (iArr.length < i) {
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i * 2);
        }
        if (this.d != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i, Object obj) {
        int i2 = this.d;
        if (i2 == 0) {
            return -1;
        }
        int iE = f01.e(i2, i, this.b);
        if (iE < 0 || fc0.b(obj, this.c[iE << 1])) {
            return iE;
        }
        int i3 = iE + 1;
        while (i3 < i2 && this.b[i3] == i) {
            if (fc0.b(obj, this.c[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iE - 1; i4 >= 0 && this.b[i4] == i; i4--) {
            if (fc0.b(obj, this.c[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public final void clear() {
        if (this.d > 0) {
            this.b = f01.d;
            this.c = f01.e;
            this.d = 0;
        }
        if (this.d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj.hashCode(), obj);
    }

    public final int e() {
        int i = this.d;
        if (i == 0) {
            return -1;
        }
        int iE = f01.e(i, 0, this.b);
        if (iE < 0 || this.c[iE << 1] == null) {
            return iE;
        }
        int i2 = iE + 1;
        while (i2 < i && this.b[i2] == 0) {
            if (this.c[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iE - 1; i3 >= 0 && this.b[i3] == 0; i3--) {
            if (this.c[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof t01) {
                int i = this.d;
                if (i != ((t01) obj).d) {
                    return false;
                }
                t01 t01Var = (t01) obj;
                for (int i2 = 0; i2 < i; i2++) {
                    Object objF = f(i2);
                    Object objI = i(i2);
                    Object obj2 = t01Var.get(objF);
                    if (objI == null) {
                        if (obj2 != null || !t01Var.containsKey(objF)) {
                            return false;
                        }
                    } else if (!objI.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.d != ((Map) obj).size()) {
                return false;
            }
            int i3 = this.d;
            for (int i4 = 0; i4 < i3; i4++) {
                Object objF2 = f(i4);
                Object objI2 = i(i4);
                Object obj3 = ((Map) obj).get(objF2);
                if (objI2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objF2)) {
                        return false;
                    }
                } else if (!objI2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i) {
        if (i < 0 || i >= this.d) {
            throw new IllegalArgumentException(qq0.i("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        return this.c[i << 1];
    }

    public final Object g(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.d)) {
            throw new IllegalArgumentException(qq0.i("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        Object[] objArr = this.c;
        int i3 = i << 1;
        Object obj = objArr[i3 + 1];
        if (i2 <= 1) {
            clear();
            return obj;
        }
        int i4 = i2 - 1;
        int[] iArr = this.b;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            if (i < i4) {
                int i5 = i + 1;
                pb.e0(i, i5, i2, iArr, iArr);
                Object[] objArr2 = this.c;
                pb.f0(i3, i5 << 1, i2 << 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.c;
            int i6 = i4 << 1;
            objArr3[i6] = null;
            objArr3[i6 + 1] = null;
        } else {
            int i7 = i2 > 8 ? i2 + (i2 >> 1) : 8;
            this.b = Arrays.copyOf(iArr, i7);
            this.c = Arrays.copyOf(this.c, i7 << 1);
            if (i2 != this.d) {
                throw new ConcurrentModificationException();
            }
            if (i > 0) {
                pb.e0(0, 0, i, iArr, this.b);
                pb.f0(0, 0, i3, objArr, this.c);
            }
            if (i < i4) {
                int i8 = i + 1;
                pb.e0(i, i8, i2, iArr, this.b);
                pb.f0(i3, i8 << 1, i2 << 1, objArr, this.c);
            }
        }
        if (i2 != this.d) {
            throw new ConcurrentModificationException();
        }
        this.d = i4;
        return obj;
    }

    public Object get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.c[(iD << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.c[(iD << 1) + 1] : obj2;
    }

    public final Object h(int i, Object obj) {
        if (i < 0 || i >= this.d) {
            throw new IllegalArgumentException(qq0.i("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = this.c;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public final int hashCode() {
        int[] iArr = this.b;
        Object[] objArr = this.c;
        int i = this.d;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public final Object i(int i) {
        if (i < 0 || i >= this.d) {
            throw new IllegalArgumentException(qq0.i("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        return this.c[(i << 1) + 1];
    }

    public final boolean isEmpty() {
        return this.d <= 0;
    }

    public final Object put(Object obj, Object obj2) {
        int i = this.d;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(iHashCode, obj) : e();
        if (iC >= 0) {
            int i2 = (iC << 1) + 1;
            Object[] objArr = this.c;
            Object obj3 = objArr[i2];
            objArr[i2] = obj2;
            return obj3;
        }
        int i3 = ~iC;
        int[] iArr = this.b;
        if (i >= iArr.length) {
            int i4 = 8;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i < 4) {
                i4 = 4;
            }
            this.b = Arrays.copyOf(iArr, i4);
            this.c = Arrays.copyOf(this.c, i4 << 1);
            if (i != this.d) {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i) {
            int[] iArr2 = this.b;
            int i5 = i3 + 1;
            pb.e0(i5, i3, i, iArr2, iArr2);
            Object[] objArr2 = this.c;
            pb.f0(i5 << 1, i3 << 1, this.d << 1, objArr2, objArr2);
        }
        int i6 = this.d;
        if (i == i6) {
            int[] iArr3 = this.b;
            if (i3 < iArr3.length) {
                iArr3[i3] = iHashCode;
                Object[] objArr3 = this.c;
                int i7 = i3 << 1;
                objArr3[i7] = obj;
                objArr3[i7 + 1] = obj2;
                this.d = i6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0 || !fc0.b(obj2, i(iD))) {
            return false;
        }
        g(iD);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0 || !fc0.b(obj2, i(iD))) {
            return false;
        }
        h(iD, obj3);
        return true;
    }

    public final int size() {
        return this.d;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objF = f(i2);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objI = i(i2);
            if (objI != sb) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public Object remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return g(iD);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD >= 0) {
            return h(iD, obj2);
        }
        return null;
    }
}
