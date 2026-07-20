package defpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lm1 extends yl1 implements Set {
    public transient em1 c;

    public static int h(int i) {
        int iMax = Math.max(i, 2);
        if (iMax < 751619276) {
            int iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
            return iHighestOneBit;
        }
        if (iMax < 1073741824) {
            return 1073741824;
        }
        zy.n("collection too large");
        return 0;
    }

    public static lm1 j(int i, Object... objArr) {
        if (i == 0) {
            return zm1.j;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new bn1(obj);
        }
        int iH = h(i);
        Object[] objArr2 = new Object[iH];
        int i2 = iH - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            if (obj2 == null) {
                zy.r(qq0.i("at index ", i5));
                return null;
            }
            int iHashCode = obj2.hashCode();
            int iR = xr.R(iHashCode);
            while (true) {
                int i6 = iR & i2;
                Object obj3 = objArr2[i6];
                if (obj3 == null) {
                    objArr[i4] = obj2;
                    objArr2[i6] = obj2;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iR++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new bn1(obj4);
        }
        if (h(i4) < iH / 2) {
            return j(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zm1(i3, i2, i4, objArr, objArr2);
    }

    @Override // defpackage.yl1
    public em1 e() {
        em1 em1Var = this.c;
        if (em1Var != null) {
            return em1Var;
        }
        em1 em1VarI = i();
        this.c = em1VarI;
        return em1VarI;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof lm1) && (this instanceof zm1) && (((lm1) obj) instanceof zm1) && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public em1 i() {
        Object[] array = toArray(yl1.b);
        bm1 bm1Var = em1.c;
        return em1.j(array.length, array);
    }
}
