package defpackage;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xp1 implements dq1 {
    public static final int[] j = new int[0];
    public static final Unsafe k = oq1.i();
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final ro1 e;
    public final int[] f;
    public final int g;
    public final int h;
    public final hm1 i;

    public xp1(int[] iArr, Object[] objArr, int i, int i2, ro1 ro1Var, int[] iArr2, int i3, int i4, hm1 hm1Var, cp1 cp1Var) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.f = iArr2;
        this.g = i3;
        this.h = i4;
        this.i = hm1Var;
        this.e = ro1Var;
    }

    public static Field E(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static boolean r(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof hp1) {
            return ((hp1) obj).c();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.xp1 u(defpackage.cq1 r35, defpackage.hm1 r36, defpackage.cp1 r37) {
        /*
            Method dump skipped, instruction units count: 1050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp1.u(cq1, hm1, cp1):xp1");
    }

    public static int v(long j2, Object obj) {
        return ((Integer) oq1.h(j2, obj)).intValue();
    }

    public static int x(int i) {
        return (i >>> 20) & 255;
    }

    public static long z(long j2, Object obj) {
        return ((Long) oq1.h(j2, obj)).longValue();
    }

    public final qo1 A(int i) {
        int i2 = i / 3;
        return (qo1) this.b[i2 + i2 + 1];
    }

    public final dq1 B(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        Object[] objArr = this.b;
        dq1 dq1Var = (dq1) objArr[i3];
        if (dq1Var != null) {
            return dq1Var;
        }
        dq1 dq1VarA = aq1.c.a((Class) objArr[i3 + 1]);
        objArr[i3] = dq1VarA;
        return dq1VarA;
    }

    public final Object C(int i, Object obj) {
        dq1 dq1VarB = B(i);
        int iY = y(i) & 1048575;
        if (!p(i, obj)) {
            return dq1VarB.d();
        }
        Object object = k.getObject(obj, iY);
        if (r(object)) {
            return object;
        }
        hp1 hp1VarD = dq1VarB.d();
        if (object != null) {
            dq1VarB.b(hp1VarD, object);
        }
        return hp1VarD;
    }

    public final Object D(int i, int i2, Object obj) {
        dq1 dq1VarB = B(i2);
        if (!s(i, i2, obj)) {
            return dq1VarB.d();
        }
        Object object = k.getObject(obj, y(i2) & 1048575);
        if (r(object)) {
            return object;
        }
        hp1 hp1VarD = dq1VarB.d();
        if (object != null) {
            dq1VarB.b(hp1VarD, object);
        }
        return hp1VarD;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    @Override // defpackage.dq1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp1.a(java.lang.Object):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // defpackage.dq1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r13, java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp1.b(java.lang.Object, java.lang.Object):void");
    }

    @Override // defpackage.dq1
    public final void c(Object obj, tb0 tb0Var) throws ap1 {
        int i;
        int i2;
        xp1 xp1Var = this;
        Unsafe unsafe = k;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (true) {
            int[] iArr = xp1Var.a;
            if (i4 >= iArr.length) {
                ((hp1) obj).zzc.d(tb0Var);
                return;
            }
            int iY = xp1Var.y(i4);
            int iX = x(iY);
            int i7 = iArr[i4];
            if (iX <= 17) {
                int i8 = iArr[i4 + 2];
                int i9 = i8 & i3;
                if (i9 != i6) {
                    i5 = i9 == i3 ? 0 : unsafe.getInt(obj, i9);
                    i6 = i9;
                }
                i = 1 << (i8 >>> 20);
            } else {
                i = 0;
            }
            long j2 = iY & i3;
            switch (iX) {
                case 0:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).f(i7, Double.doubleToRawLongBits(oq1.c.a(j2, obj)));
                    }
                    break;
                case 1:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).d(i7, Float.floatToRawIntBits(oq1.c.b(j2, obj)));
                    }
                    break;
                case 2:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).n(i7, unsafe.getLong(obj, j2));
                    }
                    break;
                case 3:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).n(i7, unsafe.getLong(obj, j2));
                    }
                    break;
                case 4:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).h(i7, unsafe.getInt(obj, j2));
                    }
                    break;
                case 5:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).f(i7, unsafe.getLong(obj, j2));
                    }
                    break;
                case 6:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).d(i7, unsafe.getInt(obj, j2));
                    }
                    break;
                case 7:
                    if (!xp1Var.q(obj, i4, i6, i5, i)) {
                        continue;
                    } else {
                        byte bG = oq1.c.g(j2, obj);
                        zo1 zo1Var = (zo1) tb0Var.c;
                        zo1Var.m(i7 << 3);
                        int i10 = zo1Var.d;
                        try {
                            int i11 = i10 + 1;
                            try {
                                zo1Var.b[i10] = bG;
                                zo1Var.d = i11;
                            } catch (IndexOutOfBoundsException e) {
                                e = e;
                                i10 = i11;
                                throw new ap1(i10, zo1Var.c, 1, e);
                            }
                        } catch (IndexOutOfBoundsException e2) {
                            e = e2;
                        }
                    }
                    break;
                case 8:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        Object object = unsafe.getObject(obj, j2);
                        if (object instanceof String) {
                            ((zo1) tb0Var.c).j((String) object, i7);
                        } else {
                            ((zo1) tb0Var.c).c(i7, (yo1) object);
                        }
                    }
                    break;
                case 9:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        tb0Var.n(i7, unsafe.getObject(obj, j2), xp1Var.B(i4));
                    }
                    break;
                case 10:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).c(i7, (yo1) unsafe.getObject(obj, j2));
                    }
                    break;
                case 11:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).l(i7, unsafe.getInt(obj, j2));
                    }
                    break;
                case 12:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).h(i7, unsafe.getInt(obj, j2));
                    }
                    break;
                case 13:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).d(i7, unsafe.getInt(obj, j2));
                    }
                    break;
                case 14:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        ((zo1) tb0Var.c).f(i7, unsafe.getLong(obj, j2));
                    }
                    break;
                case 15:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        int i12 = unsafe.getInt(obj, j2);
                        ((zo1) tb0Var.c).l(i7, (i12 >> 31) ^ (i12 + i12));
                    }
                    break;
                case 16:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        long j3 = unsafe.getLong(obj, j2);
                        ((zo1) tb0Var.c).n(i7, (j3 >> 63) ^ (j3 + j3));
                    }
                    break;
                case 17:
                    if (xp1Var.q(obj, i4, i6, i5, i)) {
                        tb0Var.m(i7, unsafe.getObject(obj, j2), xp1Var.B(i4));
                    }
                    break;
                case 18:
                    eq1.q(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 19:
                    eq1.u(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 20:
                    eq1.w(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 21:
                    eq1.d(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 22:
                    eq1.v(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 23:
                    eq1.t(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 24:
                    eq1.s(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 25:
                    eq1.p(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 26:
                    int i13 = iArr[i4];
                    List list = (List) unsafe.getObject(obj, j2);
                    hm1 hm1Var = eq1.a;
                    if (list != null && !list.isEmpty()) {
                        tb0Var.getClass();
                        for (int i14 = 0; i14 < list.size(); i14++) {
                            ((zo1) tb0Var.c).j((String) list.get(i14), i13);
                        }
                    }
                    break;
                case 27:
                    int i15 = iArr[i4];
                    List list2 = (List) unsafe.getObject(obj, j2);
                    dq1 dq1VarB = xp1Var.B(i4);
                    hm1 hm1Var2 = eq1.a;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i16 = 0; i16 < list2.size(); i16++) {
                            tb0Var.n(i15, list2.get(i16), dq1VarB);
                        }
                    }
                    break;
                case 28:
                    int i17 = iArr[i4];
                    List list3 = (List) unsafe.getObject(obj, j2);
                    hm1 hm1Var3 = eq1.a;
                    if (list3 != null && !list3.isEmpty()) {
                        tb0Var.getClass();
                        for (int i18 = 0; i18 < list3.size(); i18++) {
                            ((zo1) tb0Var.c).c(i17, (yo1) list3.get(i18));
                        }
                    }
                    break;
                case 29:
                    eq1.c(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 30:
                    eq1.r(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 31:
                    eq1.x(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 32:
                    eq1.y(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 33:
                    eq1.a(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 34:
                    eq1.b(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, false);
                    break;
                case 35:
                    eq1.q(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 36:
                    eq1.u(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 37:
                    eq1.w(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 38:
                    eq1.d(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 39:
                    eq1.v(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 40:
                    eq1.t(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 41:
                    eq1.s(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 42:
                    eq1.p(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 43:
                    eq1.c(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 44:
                    eq1.r(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 45:
                    eq1.x(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 46:
                    eq1.y(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 47:
                    eq1.a(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 48:
                    eq1.b(iArr[i4], (List) unsafe.getObject(obj, j2), tb0Var, true);
                    break;
                case 49:
                    int i19 = iArr[i4];
                    List list4 = (List) unsafe.getObject(obj, j2);
                    dq1 dq1VarB2 = xp1Var.B(i4);
                    hm1 hm1Var4 = eq1.a;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            tb0Var.m(i19, list4.get(i20), dq1VarB2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j2) != null) {
                        int i21 = i4 / 3;
                        xp1Var.b[i21 + i21].getClass();
                        s1.d();
                        return;
                    }
                    break;
                    break;
                case 51:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).f(i7, Double.doubleToRawLongBits(((Double) oq1.h(j2, obj)).doubleValue()));
                    }
                    break;
                case 52:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).d(i7, Float.floatToRawIntBits(((Float) oq1.h(j2, obj)).floatValue()));
                    }
                    break;
                case 53:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).n(i7, z(j2, obj));
                    }
                    break;
                case 54:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).n(i7, z(j2, obj));
                    }
                    break;
                case 55:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).h(i7, v(j2, obj));
                    }
                    break;
                case 56:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).f(i7, z(j2, obj));
                    }
                    break;
                case 57:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).d(i7, v(j2, obj));
                    }
                    break;
                case 58:
                    if (!xp1Var.s(i7, i4, obj)) {
                        continue;
                    } else {
                        byte bBooleanValue = ((Boolean) oq1.h(j2, obj)).booleanValue();
                        zo1 zo1Var2 = (zo1) tb0Var.c;
                        zo1Var2.m(i7 << 3);
                        int i22 = zo1Var2.d;
                        try {
                            i2 = i22 + 1;
                        } catch (IndexOutOfBoundsException e3) {
                            e = e3;
                        }
                        try {
                            zo1Var2.b[i22] = bBooleanValue;
                            zo1Var2.d = i2;
                        } catch (IndexOutOfBoundsException e4) {
                            e = e4;
                            i22 = i2;
                            throw new ap1(i22, zo1Var2.c, 1, e);
                        }
                    }
                    break;
                case 59:
                    if (xp1Var.s(i7, i4, obj)) {
                        Object object2 = unsafe.getObject(obj, j2);
                        if (object2 instanceof String) {
                            ((zo1) tb0Var.c).j((String) object2, i7);
                        } else {
                            ((zo1) tb0Var.c).c(i7, (yo1) object2);
                        }
                    }
                    break;
                case 60:
                    if (xp1Var.s(i7, i4, obj)) {
                        tb0Var.n(i7, unsafe.getObject(obj, j2), xp1Var.B(i4));
                    }
                    break;
                case 61:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).c(i7, (yo1) unsafe.getObject(obj, j2));
                    }
                    break;
                case 62:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).l(i7, v(j2, obj));
                    }
                    break;
                case 63:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).h(i7, v(j2, obj));
                    }
                    break;
                case 64:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).d(i7, v(j2, obj));
                    }
                    break;
                case 65:
                    if (xp1Var.s(i7, i4, obj)) {
                        ((zo1) tb0Var.c).f(i7, z(j2, obj));
                    }
                    break;
                case 66:
                    if (xp1Var.s(i7, i4, obj)) {
                        int iV = v(j2, obj);
                        ((zo1) tb0Var.c).l(i7, (iV >> 31) ^ (iV + iV));
                    }
                    break;
                case 67:
                    if (xp1Var.s(i7, i4, obj)) {
                        long jZ = z(j2, obj);
                        ((zo1) tb0Var.c).n(i7, (jZ >> 63) ^ (jZ + jZ));
                    }
                    break;
                case 68:
                    if (xp1Var.s(i7, i4, obj)) {
                        tb0Var.m(i7, unsafe.getObject(obj, j2), xp1Var.B(i4));
                    }
                    break;
            }
            i4 += 3;
            i3 = 1048575;
            xp1Var = this;
        }
    }

    @Override // defpackage.dq1
    public final hp1 d() {
        return (hp1) ((hp1) this.e).d(4);
    }

    @Override // defpackage.dq1
    public final boolean e(hp1 hp1Var, hp1 hp1Var2) {
        boolean zE;
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i < iArr.length) {
                int iY = y(i);
                long j2 = iY & 1048575;
                switch (x(iY)) {
                    case 0:
                        if (o(hp1Var, hp1Var2, i)) {
                            nq1 nq1Var = oq1.c;
                            if (Double.doubleToLongBits(nq1Var.a(j2, hp1Var)) == Double.doubleToLongBits(nq1Var.a(j2, hp1Var2))) {
                                continue;
                                i += 3;
                            }
                        }
                        break;
                    case 1:
                        if (o(hp1Var, hp1Var2, i)) {
                            nq1 nq1Var2 = oq1.c;
                            if (Float.floatToIntBits(nq1Var2.b(j2, hp1Var)) == Float.floatToIntBits(nq1Var2.b(j2, hp1Var2))) {
                                continue;
                                i += 3;
                            }
                        }
                        break;
                    case 2:
                        if (o(hp1Var, hp1Var2, i) && oq1.f(j2, hp1Var) == oq1.f(j2, hp1Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 3:
                        if (o(hp1Var, hp1Var2, i) && oq1.f(j2, hp1Var) == oq1.f(j2, hp1Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 4:
                        if (o(hp1Var, hp1Var2, i) && oq1.e(j2, hp1Var) == oq1.e(j2, hp1Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 5:
                        if (o(hp1Var, hp1Var2, i) && oq1.f(j2, hp1Var) == oq1.f(j2, hp1Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 6:
                        if (o(hp1Var, hp1Var2, i) && oq1.e(j2, hp1Var) == oq1.e(j2, hp1Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 7:
                        if (o(hp1Var, hp1Var2, i)) {
                            nq1 nq1Var3 = oq1.c;
                            if (nq1Var3.g(j2, hp1Var) == nq1Var3.g(j2, hp1Var2)) {
                                continue;
                                i += 3;
                            }
                        }
                        break;
                    case 8:
                        if (o(hp1Var, hp1Var2, i) && eq1.e(oq1.h(j2, hp1Var), oq1.h(j2, hp1Var2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 9:
                        if (o(hp1Var, hp1Var2, i) && eq1.e(oq1.h(j2, hp1Var), oq1.h(j2, hp1Var2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 10:
                        if (o(hp1Var, hp1Var2, i) && eq1.e(oq1.h(j2, hp1Var), oq1.h(j2, hp1Var2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 11:
                        if (o(hp1Var, hp1Var2, i) && oq1.e(j2, hp1Var) == oq1.e(j2, hp1Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 12:
                        if (o(hp1Var, hp1Var2, i) && oq1.e(j2, hp1Var) == oq1.e(j2, hp1Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 13:
                        if (o(hp1Var, hp1Var2, i) && oq1.e(j2, hp1Var) == oq1.e(j2, hp1Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 14:
                        if (o(hp1Var, hp1Var2, i) && oq1.f(j2, hp1Var) == oq1.f(j2, hp1Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 15:
                        if (o(hp1Var, hp1Var2, i) && oq1.e(j2, hp1Var) == oq1.e(j2, hp1Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 16:
                        if (o(hp1Var, hp1Var2, i) && oq1.f(j2, hp1Var) == oq1.f(j2, hp1Var2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 17:
                        if (o(hp1Var, hp1Var2, i) && eq1.e(oq1.h(j2, hp1Var), oq1.h(j2, hp1Var2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        zE = eq1.e(oq1.h(j2, hp1Var), oq1.h(j2, hp1Var2));
                        break;
                    case 50:
                        zE = eq1.e(oq1.h(j2, hp1Var), oq1.h(j2, hp1Var2));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long j3 = iArr[i + 2] & 1048575;
                        if (oq1.e(j3, hp1Var) == oq1.e(j3, hp1Var2) && eq1.e(oq1.h(j2, hp1Var), oq1.h(j2, hp1Var2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    default:
                        i += 3;
                        break;
                }
                if (zE) {
                    i += 3;
                }
            } else if (hp1Var.zzc.equals(hp1Var2.zzc)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.dq1
    public final void f(Object obj, byte[] bArr, int i, int i2, uo1 uo1Var) {
        t(obj, bArr, i, i2, 0, uo1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    @Override // defpackage.dq1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(defpackage.ro1 r19) {
        /*
            Method dump skipped, instruction units count: 1836
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp1.g(ro1):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00db A[PHI: r1
  0x00db: PHI (r1v34 int) = (r1v10 int), (r1v35 int) binds: [B:85:0x01ea, B:43:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.dq1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(defpackage.hp1 r11) {
        /*
            Method dump skipped, instruction units count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp1.h(hp1):int");
    }

    @Override // defpackage.dq1
    public final boolean i(Object obj) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.g) {
            int i7 = this.f[i5];
            int[] iArr = this.a;
            int i8 = iArr[i7];
            int iY = y(i7);
            int i9 = iArr[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = k.getInt(obj, i10);
                }
                i2 = i7;
                i3 = i4;
                i = i10;
            } else {
                int i12 = i4;
                i = i6;
                i2 = i7;
                i3 = i12;
            }
            if ((268435456 & iY) == 0 || q(obj, i2, i, i3, i11)) {
                int iX = x(iY);
                if (iX != 9 && iX != 17) {
                    if (iX != 27) {
                        if (iX == 60 || iX == 68) {
                            if (!s(i8, i2, obj) || B(i2).i(oq1.h(iY & 1048575, obj))) {
                            }
                        } else if (iX != 49) {
                            if (iX == 50 && !((tp1) oq1.h(iY & 1048575, obj)).isEmpty()) {
                                int i13 = i2 / 3;
                                this.b[i13 + i13].getClass();
                                s1.d();
                                return false;
                            }
                        }
                        i5++;
                        i6 = i;
                        i4 = i3;
                    }
                    List list = (List) oq1.h(iY & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        dq1 dq1VarB = B(i2);
                        for (int i14 = 0; i14 < list.size(); i14++) {
                            if (dq1VarB.i(list.get(i14))) {
                            }
                        }
                    }
                    i5++;
                    i6 = i;
                    i4 = i3;
                } else if (!q(obj, i2, i, i3, i11) || B(i2).i(oq1.h(iY & 1048575, obj))) {
                    i5++;
                    i6 = i;
                    i4 = i3;
                }
            }
            return false;
        }
        return true;
    }

    public final void j(Object obj, int i, Object obj2) {
        if (p(i, obj2)) {
            int iY = y(i) & 1048575;
            Unsafe unsafe = k;
            long j2 = iY;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.a[i] + " is present but null: " + obj2.toString());
            }
            dq1 dq1VarB = B(i);
            if (!p(i, obj)) {
                if (r(object)) {
                    hp1 hp1VarD = dq1VarB.d();
                    dq1VarB.b(hp1VarD, object);
                    unsafe.putObject(obj, j2, hp1VarD);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                l(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!r(object2)) {
                hp1 hp1VarD2 = dq1VarB.d();
                dq1VarB.b(hp1VarD2, object2);
                unsafe.putObject(obj, j2, hp1VarD2);
                object2 = hp1VarD2;
            }
            dq1VarB.b(object2, object);
        }
    }

    public final void k(Object obj, int i, Object obj2) {
        int[] iArr = this.a;
        int i2 = iArr[i];
        if (s(i2, i, obj2)) {
            int iY = y(i) & 1048575;
            Unsafe unsafe = k;
            long j2 = iY;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            dq1 dq1VarB = B(i);
            if (!s(i2, i, obj)) {
                if (r(object)) {
                    hp1 hp1VarD = dq1VarB.d();
                    dq1VarB.b(hp1VarD, object);
                    unsafe.putObject(obj, j2, hp1VarD);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                oq1.j(obj, iArr[i + 2] & 1048575, i2);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!r(object2)) {
                hp1 hp1VarD2 = dq1VarB.d();
                dq1VarB.b(hp1VarD2, object2);
                unsafe.putObject(obj, j2, hp1VarD2);
                object2 = hp1VarD2;
            }
            dq1VarB.b(object2, object);
        }
    }

    public final void l(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j2 = 1048575 & i2;
        if (j2 == 1048575) {
            return;
        }
        oq1.j(obj, j2, (1 << (i2 >>> 20)) | oq1.e(j2, obj));
    }

    public final void m(Object obj, int i, Object obj2) {
        k.putObject(obj, y(i) & 1048575, obj2);
        l(i, obj);
    }

    public final void n(int i, int i2, Object obj, Object obj2) {
        k.putObject(obj, y(i2) & 1048575, obj2);
        oq1.j(obj, this.a[i2 + 2] & 1048575, i);
    }

    public final boolean o(hp1 hp1Var, hp1 hp1Var2, int i) {
        return p(i, hp1Var) == p(i, hp1Var2);
    }

    public final boolean p(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j2 = i2 & 1048575;
        if (j2 == 1048575) {
            int iY = y(i);
            long j3 = iY & 1048575;
            switch (x(iY)) {
                case 0:
                    if (Double.doubleToRawLongBits(oq1.c.a(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(oq1.c.b(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (oq1.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (oq1.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (oq1.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (oq1.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (oq1.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return oq1.c.g(j3, obj);
                case 8:
                    Object objH = oq1.h(j3, obj);
                    if (objH instanceof String) {
                        if (((String) objH).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(objH instanceof yo1)) {
                            throw new IllegalArgumentException();
                        }
                        if (yo1.d.equals(objH)) {
                            return false;
                        }
                    }
                case 9:
                    if (oq1.h(j3, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (yo1.d.equals(oq1.h(j3, obj))) {
                        return false;
                    }
                    break;
                case 11:
                    if (oq1.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (oq1.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (oq1.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (oq1.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (oq1.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (oq1.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (oq1.h(j3, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i2 >>> 20)) & oq1.e(j2, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean q(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? p(i, obj) : (i3 & i4) != 0;
    }

    public final boolean s(int i, int i2, Object obj) {
        return oq1.e((long) (this.a[i2 + 2] & 1048575), obj) == i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02a5, code lost:
    
        defpackage.ay0.b("Protocol message had invalid UTF-8.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02aa, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02fc, code lost:
    
        defpackage.ay0.b("Protocol message had invalid UTF-8.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0301, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0362, code lost:
    
        defpackage.ay0.b("Protocol message had invalid UTF-8.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0366, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0460, code lost:
    
        r8 = r10;
        r7 = r11;
        r9 = r12;
        r3 = r13;
        r6 = r15;
        r15 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x04de, code lost:
    
        r1 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e2, code lost:
    
        r5 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e4, code lost:
    
        r3 = r9;
        r8 = r10;
        r7 = r11;
        r9 = r12;
        r6 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0155, code lost:
    
        r3 = r2;
        r2 = r1;
        r1 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02dd A[PHI: r3
  0x02dd: PHI (r3v56 byte) = (r3v55 byte), (r3v63 byte) binds: [B:121:0x02d8, B:123:0x02dc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x0a1a  */
    /* JADX WARN: Removed duplicated region for block: B:540:0x0cd9 A[PHI: r1 r4 r8 r10 r11 r23
  0x0cd9: PHI (r1v174 byte[]) = 
  (r1v149 byte[])
  (r1v150 byte[])
  (r1v151 byte[])
  (r1v152 byte[])
  (r1v153 byte[])
  (r1v154 byte[])
  (r1v155 byte[])
  (r1v156 byte[])
  (r1v157 byte[])
  (r1v164 byte[])
  (r1v175 byte[])
 binds: [B:538:0x0cc2, B:535:0x0ca1, B:532:0x0c84, B:529:0x0c68, B:526:0x0c4b, B:523:0x0c2d, B:516:0x0c06, B:502:0x0bc6, B:500:0x0bb3, B:475:0x0afd, B:463:0x0a99] A[DONT_GENERATE, DONT_INLINE]
  0x0cd9: PHI (r4v163 uo1) = 
  (r4v136 uo1)
  (r4v137 uo1)
  (r4v138 uo1)
  (r4v139 uo1)
  (r4v140 uo1)
  (r4v141 uo1)
  (r4v142 uo1)
  (r4v143 uo1)
  (r4v145 uo1)
  (r4v152 uo1)
  (r4v164 uo1)
 binds: [B:538:0x0cc2, B:535:0x0ca1, B:532:0x0c84, B:529:0x0c68, B:526:0x0c4b, B:523:0x0c2d, B:516:0x0c06, B:502:0x0bc6, B:500:0x0bb3, B:475:0x0afd, B:463:0x0a99] A[DONT_GENERATE, DONT_INLINE]
  0x0cd9: PHI (r8v44 jq1) = 
  (r8v3 jq1)
  (r8v3 jq1)
  (r8v3 jq1)
  (r8v3 jq1)
  (r8v3 jq1)
  (r8v3 jq1)
  (r8v3 jq1)
  (r8v3 jq1)
  (r8v3 jq1)
  (r8v37 jq1)
  (r8v3 jq1)
 binds: [B:538:0x0cc2, B:535:0x0ca1, B:532:0x0c84, B:529:0x0c68, B:526:0x0c4b, B:523:0x0c2d, B:516:0x0c06, B:502:0x0bc6, B:500:0x0bb3, B:475:0x0afd, B:463:0x0a99] A[DONT_GENERATE, DONT_INLINE]
  0x0cd9: PHI (r10v44 int) = 
  (r10v30 int)
  (r10v31 int)
  (r10v32 int)
  (r10v33 int)
  (r10v34 int)
  (r10v35 int)
  (r10v36 int)
  (r10v37 int)
  (r10v38 int)
  (r10v40 int)
  (r10v45 int)
 binds: [B:538:0x0cc2, B:535:0x0ca1, B:532:0x0c84, B:529:0x0c68, B:526:0x0c4b, B:523:0x0c2d, B:516:0x0c06, B:502:0x0bc6, B:500:0x0bb3, B:475:0x0afd, B:463:0x0a99] A[DONT_GENERATE, DONT_INLINE]
  0x0cd9: PHI (r11v68 int) = 
  (r11v46 int)
  (r11v47 int)
  (r11v48 int)
  (r11v49 int)
  (r11v50 int)
  (r11v51 int)
  (r11v52 int)
  (r11v53 int)
  (r11v54 int)
  (r11v59 int)
  (r11v69 int)
 binds: [B:538:0x0cc2, B:535:0x0ca1, B:532:0x0c84, B:529:0x0c68, B:526:0x0c4b, B:523:0x0c2d, B:516:0x0c06, B:502:0x0bc6, B:500:0x0bb3, B:475:0x0afd, B:463:0x0a99] A[DONT_GENERATE, DONT_INLINE]
  0x0cd9: PHI (r23v24 int) = 
  (r23v6 int)
  (r23v7 int)
  (r23v8 int)
  (r23v9 int)
  (r23v10 int)
  (r23v11 int)
  (r23v12 int)
  (r23v13 int)
  (r23v14 int)
  (r23v17 int)
  (r23v25 int)
 binds: [B:538:0x0cc2, B:535:0x0ca1, B:532:0x0c84, B:529:0x0c68, B:526:0x0c4b, B:523:0x0c2d, B:516:0x0c06, B:502:0x0bc6, B:500:0x0bb3, B:475:0x0afd, B:463:0x0a99] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0d0d  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x02fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:631:0x0a08 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:646:0x0cdc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:650:0x005d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:670:0x0cf2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x025c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int t(java.lang.Object r39, byte[] r40, int r41, int r42, int r43, defpackage.uo1 r44) {
        /*
            Method dump skipped, instruction units count: 3638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp1.t(java.lang.Object, byte[], int, int, int, uo1):int");
    }

    public final int w(int i, int i2) {
        int[] iArr = this.a;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final int y(int i) {
        return this.a[i + 1];
    }
}
