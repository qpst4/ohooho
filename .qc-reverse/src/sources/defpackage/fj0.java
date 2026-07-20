package defpackage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fj0 extends fb1 {
    public final /* synthetic */ int a = 1;
    public final Object b;
    public final fb1 c;
    public final Object d;

    public fj0(il ilVar, fj0 fj0Var, fj0 fj0Var2, jn0 jn0Var) {
        this.b = fj0Var;
        this.c = fj0Var2;
        this.d = jn0Var;
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        switch (this.a) {
            case 0:
                int I = vd0Var.I();
                if (I == 9) {
                    vd0Var.E();
                    return null;
                }
                Map map = (Map) ((jn0) this.d).h();
                if (I == 1) {
                    vd0Var.a();
                    while (vd0Var.v()) {
                        vd0Var.a();
                        Object objB = ((fj0) this.b).c.b(vd0Var);
                        if (map.put(objB, ((fj0) this.c).c.b(vd0Var)) != null) {
                            throw new wd0("duplicate key: " + objB);
                        }
                        vd0Var.m();
                    }
                    vd0Var.m();
                } else {
                    vd0Var.g();
                    while (vd0Var.v()) {
                        c70.k.getClass();
                        if (vd0Var instanceof yd0) {
                            yd0 yd0Var = (yd0) vd0Var;
                            yd0Var.S(5);
                            Map.Entry entry = (Map.Entry) ((Iterator) yd0Var.W()).next();
                            yd0Var.Y(entry.getValue());
                            yd0Var.Y(new ud0((String) entry.getKey()));
                        } else {
                            int i = vd0Var.h;
                            if (i == 0) {
                                i = vd0Var.i();
                            }
                            if (i == 13) {
                                vd0Var.h = 9;
                            } else if (i == 12) {
                                vd0Var.h = 8;
                            } else {
                                if (i != 14) {
                                    throw vd0Var.R("a name");
                                }
                                vd0Var.h = 10;
                            }
                        }
                        Object objB2 = ((fj0) this.b).c.b(vd0Var);
                        if (map.put(objB2, ((fj0) this.c).c.b(vd0Var)) != null) {
                            throw new wd0("duplicate key: " + objB2);
                        }
                    }
                    vd0Var.q();
                }
                return map;
            default:
                return this.c.b(vd0Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    @Override // defpackage.fb1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.ae0 r4, java.lang.Object r5) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.a
            fb1 r1 = r3.c
            switch(r0) {
                case 0: goto L4a;
                default: goto L7;
            }
        L7:
            java.lang.Object r0 = r3.d
            java.lang.reflect.Type r0 = (java.lang.reflect.Type) r0
            if (r5 == 0) goto L1a
            boolean r2 = r0 instanceof java.lang.Class
            if (r2 != 0) goto L15
            boolean r2 = r0 instanceof java.lang.reflect.TypeVariable
            if (r2 == 0) goto L1a
        L15:
            java.lang.Class r2 = r5.getClass()
            goto L1b
        L1a:
            r2 = r0
        L1b:
            if (r2 == r0) goto L46
            java.lang.Object r3 = r3.b
            i70 r3 = (defpackage.i70) r3
            mc1 r0 = new mc1
            r0.<init>(r2)
            fb1 r3 = r3.g(r0)
            boolean r0 = r3 instanceof defpackage.zu0
            if (r0 != 0) goto L2f
            goto L45
        L2f:
            r0 = r1
        L30:
            boolean r2 = r0 instanceof defpackage.fz0
            if (r2 == 0) goto L40
            r2 = r0
            fz0 r2 = (defpackage.fz0) r2
            fb1 r2 = r2.d()
            if (r2 != r0) goto L3e
            goto L40
        L3e:
            r0 = r2
            goto L30
        L40:
            boolean r0 = r0 instanceof defpackage.zu0
            if (r0 != 0) goto L45
            goto L46
        L45:
            r1 = r3
        L46:
            r1.c(r4, r5)
            return
        L4a:
            java.util.Map r5 = (java.util.Map) r5
            fj0 r1 = (defpackage.fj0) r1
            if (r5 != 0) goto L54
            r4.t()
            goto L81
        L54:
            r4.h()
            java.util.Set r3 = r5.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L5f:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L7e
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r0 = r5.getKey()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r4.r(r0)
            java.lang.Object r5 = r5.getValue()
            r1.c(r4, r5)
            goto L5f
        L7e:
            r4.q()
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fj0.c(ae0, java.lang.Object):void");
    }

    public fj0(i70 i70Var, fb1 fb1Var, Type type) {
        this.b = i70Var;
        this.c = fb1Var;
        this.d = type;
    }
}
