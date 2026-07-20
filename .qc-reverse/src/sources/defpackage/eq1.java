package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eq1 {
    public static final hm1 a;

    static {
        aq1 aq1Var = aq1.c;
        a = new hm1();
    }

    public static void a(int i, List list, tb0 tb0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!(list instanceof ip1)) {
            if (!z) {
                while (i2 < list.size()) {
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zo1Var.l(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zo1Var.k(i, 2);
            int iQ = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iQ += zo1.q((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zo1Var.m(iQ);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zo1Var.m((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        ip1 ip1Var = (ip1) list;
        if (!z) {
            while (i2 < ip1Var.d) {
                int iC = ip1Var.c(i2);
                zo1Var.l(i, (iC >> 31) ^ (iC + iC));
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int iQ2 = 0;
        for (int i4 = 0; i4 < ip1Var.d; i4++) {
            int iC2 = ip1Var.c(i4);
            iQ2 += zo1.q((iC2 >> 31) ^ (iC2 + iC2));
        }
        zo1Var.m(iQ2);
        while (i2 < ip1Var.d) {
            int iC3 = ip1Var.c(i2);
            zo1Var.m((iC3 >> 31) ^ (iC3 + iC3));
            i2++;
        }
    }

    public static void b(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                zo1Var.n(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iA += zo1.a((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        zo1Var.m(iA);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            zo1Var.o((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    public static void c(int i, List list, tb0 tb0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!(list instanceof ip1)) {
            if (!z) {
                while (i2 < list.size()) {
                    zo1Var.l(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zo1Var.k(i, 2);
            int iQ = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iQ += zo1.q(((Integer) list.get(i3)).intValue());
            }
            zo1Var.m(iQ);
            while (i2 < list.size()) {
                zo1Var.m(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        ip1 ip1Var = (ip1) list;
        if (!z) {
            while (i2 < ip1Var.d) {
                zo1Var.l(i, ip1Var.c(i2));
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int iQ2 = 0;
        for (int i4 = 0; i4 < ip1Var.d; i4++) {
            iQ2 += zo1.q(ip1Var.c(i4));
        }
        zo1Var.m(iQ2);
        while (i2 < ip1Var.d) {
            zo1Var.m(ip1Var.c(i2));
            i2++;
        }
    }

    public static void d(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zo1Var.n(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iA += zo1.a(((Long) list.get(i3)).longValue());
        }
        zo1Var.m(iA);
        while (i2 < list.size()) {
            zo1Var.o(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static boolean e(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int f(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof ip1)) {
            int iA = 0;
            while (i < size) {
                iA += zo1.a(((Integer) list.get(i)).intValue());
                i++;
            }
            return iA;
        }
        ip1 ip1Var = (ip1) list;
        int iA2 = 0;
        while (i < size) {
            iA2 += zo1.a(ip1Var.c(i));
            i++;
        }
        return iA2;
    }

    public static int g(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zo1.q(i << 3) + 4) * size;
    }

    public static int h(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zo1.q(i << 3) + 8) * size;
    }

    public static int i(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof ip1)) {
            int iA = 0;
            while (i < size) {
                iA += zo1.a(((Integer) list.get(i)).intValue());
                i++;
            }
            return iA;
        }
        ip1 ip1Var = (ip1) list;
        int iA2 = 0;
        while (i < size) {
            iA2 += zo1.a(ip1Var.c(i));
            i++;
        }
        return iA2;
    }

    public static int j(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iA = 0;
        for (int i = 0; i < size; i++) {
            iA += zo1.a(((Long) list.get(i)).longValue());
        }
        return iA;
    }

    public static int k(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof ip1)) {
            int iQ = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iQ += zo1.q((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iQ;
        }
        ip1 ip1Var = (ip1) list;
        int iQ2 = 0;
        while (i < size) {
            int iC = ip1Var.c(i);
            iQ2 += zo1.q((iC >> 31) ^ (iC + iC));
            i++;
        }
        return iQ2;
    }

    public static int l(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iA = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iA += zo1.a((jLongValue >> 63) ^ (jLongValue + jLongValue));
        }
        return iA;
    }

    public static int m(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof ip1)) {
            int iQ = 0;
            while (i < size) {
                iQ += zo1.q(((Integer) list.get(i)).intValue());
                i++;
            }
            return iQ;
        }
        ip1 ip1Var = (ip1) list;
        int iQ2 = 0;
        while (i < size) {
            iQ2 += zo1.q(ip1Var.c(i));
            i++;
        }
        return iQ2;
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iA = 0;
        for (int i = 0; i < size; i++) {
            iA += zo1.a(((Long) list.get(i)).longValue());
        }
        return iA;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void o(Object obj, Object obj2) {
        hp1 hp1Var = (hp1) obj;
        jq1 jq1Var = hp1Var.zzc;
        jq1 jq1Var2 = ((hp1) obj2).zzc;
        jq1 jq1Var3 = jq1.f;
        if (!jq1Var3.equals(jq1Var2)) {
            if (jq1Var3.equals(jq1Var)) {
                int i = jq1Var.a + jq1Var2.a;
                int[] iArrCopyOf = Arrays.copyOf(jq1Var.b, i);
                System.arraycopy(jq1Var2.b, 0, iArrCopyOf, jq1Var.a, jq1Var2.a);
                Object[] objArrCopyOf = Arrays.copyOf(jq1Var.c, i);
                System.arraycopy(jq1Var2.c, 0, objArrCopyOf, jq1Var.a, jq1Var2.a);
                jq1Var = new jq1(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                jq1Var.getClass();
                if (!jq1Var2.equals(jq1Var3)) {
                    if (!jq1Var.e) {
                        zy.a();
                        return;
                    }
                    int i2 = jq1Var.a + jq1Var2.a;
                    jq1Var.e(i2);
                    System.arraycopy(jq1Var2.b, 0, jq1Var.b, jq1Var.a, jq1Var2.a);
                    System.arraycopy(jq1Var2.c, 0, jq1Var.c, jq1Var.a, jq1Var2.a);
                    jq1Var.a = i2;
                }
            }
        }
        hp1Var.zzc = jq1Var;
    }

    public static void p(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                byte bBooleanValue = ((Boolean) list.get(i2)).booleanValue();
                zo1Var.m(i << 3);
                int i3 = zo1Var.d;
                try {
                    int i4 = i3 + 1;
                    try {
                        zo1Var.b[i3] = bBooleanValue;
                        zo1Var.d = i4;
                        i2++;
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                        i3 = i4;
                        throw new ap1(i3, zo1Var.c, 1, e);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                }
            }
            return;
        }
        zo1Var.k(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Boolean) list.get(i6)).getClass();
            i5++;
        }
        zo1Var.m(i5);
        while (i2 < list.size()) {
            byte bBooleanValue2 = ((Boolean) list.get(i2)).booleanValue();
            int i7 = zo1Var.d;
            try {
                int i8 = i7 + 1;
                try {
                    zo1Var.b[i7] = bBooleanValue2;
                    zo1Var.d = i8;
                    i2++;
                } catch (IndexOutOfBoundsException e3) {
                    e = e3;
                    i7 = i8;
                    throw new ap1(i7, zo1Var.c, 1, e);
                }
            } catch (IndexOutOfBoundsException e4) {
                e = e4;
            }
        }
    }

    public static void q(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zo1Var.f(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        zo1Var.m(i3);
        while (i2 < list.size()) {
            zo1Var.g(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void r(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!(list instanceof ip1)) {
            if (!z) {
                while (i2 < list.size()) {
                    zo1Var.h(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zo1Var.k(i, 2);
            int iA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iA += zo1.a(((Integer) list.get(i3)).intValue());
            }
            zo1Var.m(iA);
            while (i2 < list.size()) {
                zo1Var.i(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        ip1 ip1Var = (ip1) list;
        if (!z) {
            while (i2 < ip1Var.d) {
                zo1Var.h(i, ip1Var.c(i2));
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int iA2 = 0;
        for (int i4 = 0; i4 < ip1Var.d; i4++) {
            iA2 += zo1.a(ip1Var.c(i4));
        }
        zo1Var.m(iA2);
        while (i2 < ip1Var.d) {
            zo1Var.i(ip1Var.c(i2));
            i2++;
        }
    }

    public static void s(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!(list instanceof ip1)) {
            if (!z) {
                while (i2 < list.size()) {
                    zo1Var.d(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zo1Var.k(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zo1Var.m(i3);
            while (i2 < list.size()) {
                zo1Var.e(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        ip1 ip1Var = (ip1) list;
        if (!z) {
            while (i2 < ip1Var.d) {
                zo1Var.d(i, ip1Var.c(i2));
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < ip1Var.d; i6++) {
            ip1Var.c(i6);
            i5 += 4;
        }
        zo1Var.m(i5);
        while (i2 < ip1Var.d) {
            zo1Var.e(ip1Var.c(i2));
            i2++;
        }
    }

    public static void t(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zo1Var.f(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        zo1Var.m(i3);
        while (i2 < list.size()) {
            zo1Var.g(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void u(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zo1Var.d(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            i3 += 4;
        }
        zo1Var.m(i3);
        while (i2 < list.size()) {
            zo1Var.e(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public static void v(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!(list instanceof ip1)) {
            if (!z) {
                while (i2 < list.size()) {
                    zo1Var.h(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zo1Var.k(i, 2);
            int iA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iA += zo1.a(((Integer) list.get(i3)).intValue());
            }
            zo1Var.m(iA);
            while (i2 < list.size()) {
                zo1Var.i(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        ip1 ip1Var = (ip1) list;
        if (!z) {
            while (i2 < ip1Var.d) {
                zo1Var.h(i, ip1Var.c(i2));
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int iA2 = 0;
        for (int i4 = 0; i4 < ip1Var.d; i4++) {
            iA2 += zo1.a(ip1Var.c(i4));
        }
        zo1Var.m(iA2);
        while (i2 < ip1Var.d) {
            zo1Var.i(ip1Var.c(i2));
            i2++;
        }
    }

    public static void w(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zo1Var.n(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iA += zo1.a(((Long) list.get(i3)).longValue());
        }
        zo1Var.m(iA);
        while (i2 < list.size()) {
            zo1Var.o(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void x(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!(list instanceof ip1)) {
            if (!z) {
                while (i2 < list.size()) {
                    zo1Var.d(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zo1Var.k(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zo1Var.m(i3);
            while (i2 < list.size()) {
                zo1Var.e(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        ip1 ip1Var = (ip1) list;
        if (!z) {
            while (i2 < ip1Var.d) {
                zo1Var.d(i, ip1Var.c(i2));
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < ip1Var.d; i6++) {
            ip1Var.c(i6);
            i5 += 4;
        }
        zo1Var.m(i5);
        while (i2 < ip1Var.d) {
            zo1Var.e(ip1Var.c(i2));
            i2++;
        }
    }

    public static void y(int i, List list, tb0 tb0Var, boolean z) throws ap1 {
        if (list == null || list.isEmpty()) {
            return;
        }
        zo1 zo1Var = (zo1) tb0Var.c;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zo1Var.f(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zo1Var.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        zo1Var.m(i3);
        while (i2 < list.size()) {
            zo1Var.g(((Long) list.get(i2)).longValue());
            i2++;
        }
    }
}
