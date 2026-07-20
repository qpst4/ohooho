package defpackage;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kl1 {
    public static final Collector a;

    static {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 1;
        final int i4 = 1;
        a = Collector.of(new Supplier() { // from class: el1
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i) {
                    case 0:
                        return new am1();
                    case 1:
                        return new km1();
                    default:
                        return new gm1();
                }
            }
        }, new BiConsumer() { // from class: hl1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                switch (i2) {
                    case 0:
                        ((am1) obj).a(obj2);
                        break;
                    case 1:
                        km1 km1Var = (km1) obj;
                        km1Var.getClass();
                        obj2.getClass();
                        km1Var.a(obj2);
                        break;
                    default:
                        gm1 gm1Var = (gm1) obj;
                        sm1 sm1Var = (sm1) obj2;
                        gm1Var.getClass();
                        if (!sm1Var.b.equals(sm1Var.c)) {
                            gm1Var.a.add(sm1Var);
                        } else {
                            zy.n(lc1.y0("range must not be empty, but was %s", sm1Var));
                        }
                        break;
                }
            }
        }, new BinaryOperator() { // from class: fl1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                int i5 = 0;
                switch (i3) {
                    case 0:
                        gm1 gm1Var = (gm1) obj;
                        gm1Var.getClass();
                        ArrayList arrayList = ((gm1) obj2).a;
                        int size = arrayList.size();
                        while (i5 < size) {
                            Object obj3 = arrayList.get(i5);
                            i5++;
                            sm1 sm1Var = (sm1) obj3;
                            if (sm1Var.b.equals(sm1Var.c)) {
                                zy.n(lc1.y0("range must not be empty, but was %s", sm1Var));
                                return null;
                            }
                            gm1Var.a.add(sm1Var);
                        }
                        return gm1Var;
                    case 1:
                        am1 am1Var = (am1) obj;
                        am1 am1Var2 = (am1) obj2;
                        Object[] objArr = am1Var2.a;
                        int i6 = am1Var2.b;
                        for (int i7 = 0; i7 < i6; i7++) {
                            am1Var.getClass();
                            if (objArr[i7] == null) {
                                zy.r(qq0.i("at index ", i7));
                                return null;
                            }
                        }
                        am1Var.c(i6);
                        System.arraycopy(objArr, 0, am1Var.a, am1Var.b, i6);
                        am1Var.b += i6;
                        return am1Var;
                    default:
                        km1 km1Var = (km1) obj;
                        km1 km1Var2 = (km1) obj2;
                        Object[] objArr2 = km1Var2.a;
                        int i8 = km1Var2.b;
                        for (int i9 = 0; i9 < i8; i9++) {
                            km1Var.getClass();
                            if (objArr2[i9] == null) {
                                zy.r(qq0.i("at index ", i9));
                                return null;
                            }
                        }
                        km1Var.c(i8);
                        System.arraycopy(objArr2, 0, km1Var.a, km1Var.b, i8);
                        km1Var.b += i8;
                        return km1Var;
                }
            }
        }, new Function() { // from class: gl1
            /* JADX WARN: Removed duplicated region for block: B:100:0x012f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:70:0x012b  */
            @Override // java.util.function.Function
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object apply(java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 428
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.gl1.apply(java.lang.Object):java.lang.Object");
            }
        }, new Collector.Characteristics[0]);
        final int i5 = 1;
        final int i6 = 1;
        final int i7 = 2;
        final int i8 = 2;
        Collector.of(new Supplier() { // from class: el1
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return new am1();
                    case 1:
                        return new km1();
                    default:
                        return new gm1();
                }
            }
        }, new BiConsumer() { // from class: hl1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                switch (i6) {
                    case 0:
                        ((am1) obj).a(obj2);
                        break;
                    case 1:
                        km1 km1Var = (km1) obj;
                        km1Var.getClass();
                        obj2.getClass();
                        km1Var.a(obj2);
                        break;
                    default:
                        gm1 gm1Var = (gm1) obj;
                        sm1 sm1Var = (sm1) obj2;
                        gm1Var.getClass();
                        if (!sm1Var.b.equals(sm1Var.c)) {
                            gm1Var.a.add(sm1Var);
                        } else {
                            zy.n(lc1.y0("range must not be empty, but was %s", sm1Var));
                        }
                        break;
                }
            }
        }, new BinaryOperator() { // from class: fl1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                int i52 = 0;
                switch (i7) {
                    case 0:
                        gm1 gm1Var = (gm1) obj;
                        gm1Var.getClass();
                        ArrayList arrayList = ((gm1) obj2).a;
                        int size = arrayList.size();
                        while (i52 < size) {
                            Object obj3 = arrayList.get(i52);
                            i52++;
                            sm1 sm1Var = (sm1) obj3;
                            if (sm1Var.b.equals(sm1Var.c)) {
                                zy.n(lc1.y0("range must not be empty, but was %s", sm1Var));
                                return null;
                            }
                            gm1Var.a.add(sm1Var);
                        }
                        return gm1Var;
                    case 1:
                        am1 am1Var = (am1) obj;
                        am1 am1Var2 = (am1) obj2;
                        Object[] objArr = am1Var2.a;
                        int i62 = am1Var2.b;
                        for (int i72 = 0; i72 < i62; i72++) {
                            am1Var.getClass();
                            if (objArr[i72] == null) {
                                zy.r(qq0.i("at index ", i72));
                                return null;
                            }
                        }
                        am1Var.c(i62);
                        System.arraycopy(objArr, 0, am1Var.a, am1Var.b, i62);
                        am1Var.b += i62;
                        return am1Var;
                    default:
                        km1 km1Var = (km1) obj;
                        km1 km1Var2 = (km1) obj2;
                        Object[] objArr2 = km1Var2.a;
                        int i82 = km1Var2.b;
                        for (int i9 = 0; i9 < i82; i9++) {
                            km1Var.getClass();
                            if (objArr2[i9] == null) {
                                zy.r(qq0.i("at index ", i9));
                                return null;
                            }
                        }
                        km1Var.c(i82);
                        System.arraycopy(objArr2, 0, km1Var.a, km1Var.b, i82);
                        km1Var.b += i82;
                        return km1Var;
                }
            }
        }, new Function() { // from class: gl1
            /* JADX WARN: Removed duplicated region for block: B:100:0x012f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:70:0x012b  */
            @Override // java.util.function.Function
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object apply(java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 428
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.gl1.apply(java.lang.Object):java.lang.Object");
            }
        }, new Collector.Characteristics[0]);
        final int i9 = 2;
        final int i10 = 2;
        final int i11 = 0;
        final int i12 = 0;
        Collector.of(new Supplier() { // from class: el1
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return new am1();
                    case 1:
                        return new km1();
                    default:
                        return new gm1();
                }
            }
        }, new BiConsumer() { // from class: hl1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                switch (i10) {
                    case 0:
                        ((am1) obj).a(obj2);
                        break;
                    case 1:
                        km1 km1Var = (km1) obj;
                        km1Var.getClass();
                        obj2.getClass();
                        km1Var.a(obj2);
                        break;
                    default:
                        gm1 gm1Var = (gm1) obj;
                        sm1 sm1Var = (sm1) obj2;
                        gm1Var.getClass();
                        if (!sm1Var.b.equals(sm1Var.c)) {
                            gm1Var.a.add(sm1Var);
                        } else {
                            zy.n(lc1.y0("range must not be empty, but was %s", sm1Var));
                        }
                        break;
                }
            }
        }, new BinaryOperator() { // from class: fl1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                int i52 = 0;
                switch (i11) {
                    case 0:
                        gm1 gm1Var = (gm1) obj;
                        gm1Var.getClass();
                        ArrayList arrayList = ((gm1) obj2).a;
                        int size = arrayList.size();
                        while (i52 < size) {
                            Object obj3 = arrayList.get(i52);
                            i52++;
                            sm1 sm1Var = (sm1) obj3;
                            if (sm1Var.b.equals(sm1Var.c)) {
                                zy.n(lc1.y0("range must not be empty, but was %s", sm1Var));
                                return null;
                            }
                            gm1Var.a.add(sm1Var);
                        }
                        return gm1Var;
                    case 1:
                        am1 am1Var = (am1) obj;
                        am1 am1Var2 = (am1) obj2;
                        Object[] objArr = am1Var2.a;
                        int i62 = am1Var2.b;
                        for (int i72 = 0; i72 < i62; i72++) {
                            am1Var.getClass();
                            if (objArr[i72] == null) {
                                zy.r(qq0.i("at index ", i72));
                                return null;
                            }
                        }
                        am1Var.c(i62);
                        System.arraycopy(objArr, 0, am1Var.a, am1Var.b, i62);
                        am1Var.b += i62;
                        return am1Var;
                    default:
                        km1 km1Var = (km1) obj;
                        km1 km1Var2 = (km1) obj2;
                        Object[] objArr2 = km1Var2.a;
                        int i82 = km1Var2.b;
                        for (int i92 = 0; i92 < i82; i92++) {
                            km1Var.getClass();
                            if (objArr2[i92] == null) {
                                zy.r(qq0.i("at index ", i92));
                                return null;
                            }
                        }
                        km1Var.c(i82);
                        System.arraycopy(objArr2, 0, km1Var.a, km1Var.b, i82);
                        km1Var.b += i82;
                        return km1Var;
                }
            }
        }, new Function() { // from class: gl1
            /* JADX WARN: Removed duplicated region for block: B:100:0x012f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:70:0x012b  */
            @Override // java.util.function.Function
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object apply(java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 428
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.gl1.apply(java.lang.Object):java.lang.Object");
            }
        }, new Collector.Characteristics[0]);
    }
}
