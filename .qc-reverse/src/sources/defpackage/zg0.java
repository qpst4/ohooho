package defpackage;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zg0 extends AbstractMap implements Serializable {
    public static final ik j = new ik(3);
    public final boolean c;
    public yg0 d;
    public final yg0 g;
    public xg0 h;
    public xg0 i;
    public int e = 0;
    public int f = 0;
    public final Comparator b = j;

    public zg0(boolean z) {
        this.c = z;
        this.g = new yg0(z);
    }

    public final yg0 a(Object obj, boolean z) {
        int iCompareTo;
        yg0 yg0Var;
        yg0 yg0Var2 = this.d;
        ik ikVar = j;
        Comparator comparator = this.b;
        if (yg0Var2 != null) {
            Comparable comparable = comparator == ikVar ? (Comparable) obj : null;
            while (true) {
                Object obj2 = yg0Var2.g;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return yg0Var2;
                }
                yg0 yg0Var3 = iCompareTo < 0 ? yg0Var2.c : yg0Var2.d;
                if (yg0Var3 == null) {
                    break;
                }
                yg0Var2 = yg0Var3;
            }
        } else {
            iCompareTo = 0;
        }
        yg0 yg0Var4 = yg0Var2;
        if (!z) {
            return null;
        }
        yg0 yg0Var5 = this.g;
        if (yg0Var4 != null) {
            yg0Var = new yg0(this.c, yg0Var4, obj, yg0Var5, yg0Var5.f);
            if (iCompareTo < 0) {
                yg0Var4.c = yg0Var;
            } else {
                yg0Var4.d = yg0Var;
            }
            b(yg0Var4, true);
        } else {
            if (comparator == ikVar && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            yg0Var = new yg0(this.c, yg0Var4, obj, yg0Var5, yg0Var5.f);
            this.d = yg0Var;
        }
        this.e++;
        this.f++;
        return yg0Var;
    }

    public final void b(yg0 yg0Var, boolean z) {
        while (yg0Var != null) {
            yg0 yg0Var2 = yg0Var.c;
            yg0 yg0Var3 = yg0Var.d;
            int i = yg0Var2 != null ? yg0Var2.j : 0;
            int i2 = yg0Var3 != null ? yg0Var3.j : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                yg0 yg0Var4 = yg0Var3.c;
                yg0 yg0Var5 = yg0Var3.d;
                int i4 = (yg0Var4 != null ? yg0Var4.j : 0) - (yg0Var5 != null ? yg0Var5.j : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    e(yg0Var);
                } else {
                    f(yg0Var3);
                    e(yg0Var);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                yg0 yg0Var6 = yg0Var2.c;
                yg0 yg0Var7 = yg0Var2.d;
                int i5 = (yg0Var6 != null ? yg0Var6.j : 0) - (yg0Var7 != null ? yg0Var7.j : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    f(yg0Var);
                } else {
                    e(yg0Var2);
                    f(yg0Var);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                yg0Var.j = i + 1;
                if (z) {
                    return;
                }
            } else {
                yg0Var.j = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            yg0Var = yg0Var.b;
        }
    }

    public final void c(yg0 yg0Var, boolean z) {
        yg0 yg0Var2;
        yg0 yg0Var3;
        int i;
        if (z) {
            yg0 yg0Var4 = yg0Var.f;
            yg0Var4.e = yg0Var.e;
            yg0Var.e.f = yg0Var4;
        }
        yg0 yg0Var5 = yg0Var.c;
        yg0 yg0Var6 = yg0Var.d;
        yg0 yg0Var7 = yg0Var.b;
        int i2 = 0;
        if (yg0Var5 == null || yg0Var6 == null) {
            if (yg0Var5 != null) {
                d(yg0Var, yg0Var5);
                yg0Var.c = null;
            } else if (yg0Var6 != null) {
                d(yg0Var, yg0Var6);
                yg0Var.d = null;
            } else {
                d(yg0Var, null);
            }
            b(yg0Var7, false);
            this.e--;
            this.f++;
            return;
        }
        if (yg0Var5.j > yg0Var6.j) {
            yg0 yg0Var8 = yg0Var5.d;
            while (true) {
                yg0 yg0Var9 = yg0Var8;
                yg0Var3 = yg0Var5;
                yg0Var5 = yg0Var9;
                if (yg0Var5 == null) {
                    break;
                } else {
                    yg0Var8 = yg0Var5.d;
                }
            }
        } else {
            yg0 yg0Var10 = yg0Var6.c;
            while (true) {
                yg0Var2 = yg0Var6;
                yg0Var6 = yg0Var10;
                if (yg0Var6 == null) {
                    break;
                } else {
                    yg0Var10 = yg0Var6.c;
                }
            }
            yg0Var3 = yg0Var2;
        }
        c(yg0Var3, false);
        yg0 yg0Var11 = yg0Var.c;
        if (yg0Var11 != null) {
            i = yg0Var11.j;
            yg0Var3.c = yg0Var11;
            yg0Var11.b = yg0Var3;
            yg0Var.c = null;
        } else {
            i = 0;
        }
        yg0 yg0Var12 = yg0Var.d;
        if (yg0Var12 != null) {
            i2 = yg0Var12.j;
            yg0Var3.d = yg0Var12;
            yg0Var12.b = yg0Var3;
            yg0Var.d = null;
        }
        yg0Var3.j = Math.max(i, i2) + 1;
        d(yg0Var, yg0Var3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.d = null;
        this.e = 0;
        this.f++;
        yg0 yg0Var = this.g;
        yg0Var.f = yg0Var;
        yg0Var.e = yg0Var;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        yg0 yg0VarA = null;
        if (obj != null) {
            try {
                yg0VarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return yg0VarA != null;
    }

    public final void d(yg0 yg0Var, yg0 yg0Var2) {
        yg0 yg0Var3 = yg0Var.b;
        yg0Var.b = null;
        if (yg0Var2 != null) {
            yg0Var2.b = yg0Var3;
        }
        if (yg0Var3 == null) {
            this.d = yg0Var2;
        } else if (yg0Var3.c == yg0Var) {
            yg0Var3.c = yg0Var2;
        } else {
            yg0Var3.d = yg0Var2;
        }
    }

    public final void e(yg0 yg0Var) {
        yg0 yg0Var2 = yg0Var.c;
        yg0 yg0Var3 = yg0Var.d;
        yg0 yg0Var4 = yg0Var3.c;
        yg0 yg0Var5 = yg0Var3.d;
        yg0Var.d = yg0Var4;
        if (yg0Var4 != null) {
            yg0Var4.b = yg0Var;
        }
        d(yg0Var, yg0Var3);
        yg0Var3.c = yg0Var;
        yg0Var.b = yg0Var3;
        int iMax = Math.max(yg0Var2 != null ? yg0Var2.j : 0, yg0Var4 != null ? yg0Var4.j : 0) + 1;
        yg0Var.j = iMax;
        yg0Var3.j = Math.max(iMax, yg0Var5 != null ? yg0Var5.j : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        xg0 xg0Var = this.h;
        if (xg0Var != null) {
            return xg0Var;
        }
        xg0 xg0Var2 = new xg0(0, this);
        this.h = xg0Var2;
        return xg0Var2;
    }

    public final void f(yg0 yg0Var) {
        yg0 yg0Var2 = yg0Var.c;
        yg0 yg0Var3 = yg0Var.d;
        yg0 yg0Var4 = yg0Var2.c;
        yg0 yg0Var5 = yg0Var2.d;
        yg0Var.c = yg0Var5;
        if (yg0Var5 != null) {
            yg0Var5.b = yg0Var;
        }
        d(yg0Var, yg0Var2);
        yg0Var2.d = yg0Var;
        yg0Var.b = yg0Var2;
        int iMax = Math.max(yg0Var3 != null ? yg0Var3.j : 0, yg0Var5 != null ? yg0Var5.j : 0) + 1;
        yg0Var.j = iMax;
        yg0Var2.j = Math.max(iMax, yg0Var4 != null ? yg0Var4.j : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        yg0 yg0VarA;
        if (obj != null) {
            try {
                yg0VarA = a(obj, false);
            } catch (ClassCastException unused) {
                yg0VarA = null;
            }
        } else {
            yg0VarA = null;
        }
        if (yg0VarA != null) {
            return yg0VarA.i;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        xg0 xg0Var = this.i;
        if (xg0Var != null) {
            return xg0Var;
        }
        xg0 xg0Var2 = new xg0(1, this);
        this.i = xg0Var2;
        return xg0Var2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            zy.r("key == null");
            return null;
        }
        if (obj2 == null && !this.c) {
            zy.r("value == null");
            return null;
        }
        yg0 yg0VarA = a(obj, true);
        Object obj3 = yg0VarA.i;
        yg0VarA.i = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        yg0 yg0VarA;
        if (obj != null) {
            try {
                yg0VarA = a(obj, false);
            } catch (ClassCastException unused) {
                yg0VarA = null;
            }
        } else {
            yg0VarA = null;
        }
        if (yg0VarA != null) {
            c(yg0VarA, true);
        }
        if (yg0VarA != null) {
            return yg0VarA.i;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.e;
    }
}
