package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xo implements jj0 {
    public final /* synthetic */ int a;

    public /* synthetic */ xo(int i) {
        this.a = i;
    }

    @Override // defpackage.jj0
    public final void a(g7 g7Var, vm0 vm0Var) {
        boolean z = false;
        int i = 0;
        z = false;
        switch (this.a) {
            case 0:
                vm0 vm0Var2 = (m51) vm0Var;
                g7Var.f();
                int iO = g7Var.o();
                ((r11) g7Var.b).a((char) 160);
                g7Var.v(vm0Var2, iO);
                g7Var.b(vm0Var2);
                break;
            case 1:
                x70 x70Var = (x70) vm0Var;
                g7Var.f();
                int iO2 = g7Var.o();
                g7Var.y(x70Var);
                lc1.d.b((kj0) g7Var.d, Integer.valueOf(x70Var.f));
                g7Var.v(x70Var, iO2);
                g7Var.b(x70Var);
                break;
            case 2:
                ((r11) g7Var.b).a(' ');
                break;
            case 3:
                g7Var.f();
                break;
            case 4:
                vm0 vm0Var3 = (dp0) vm0Var;
                kg kgVar = (kg) vm0Var3.a;
                if (kgVar != null) {
                    kg kgVar2 = (kg) kgVar.a;
                    if (kgVar2 instanceof ah0) {
                        z = ((ah0) kgVar2).f;
                    }
                }
                if (!z) {
                    g7Var.f();
                }
                int iO3 = g7Var.o();
                g7Var.y(vm0Var3);
                lc1.f.b((kj0) g7Var.d, Boolean.valueOf(z));
                g7Var.v(vm0Var3, iO3);
                if (!z) {
                    g7Var.b(vm0Var3);
                }
                break;
            case 5:
                sg0 sg0Var = (sg0) vm0Var;
                int iO4 = g7Var.o();
                g7Var.y(sg0Var);
                lc1.e.b((kj0) g7Var.d, sg0Var.f);
                g7Var.v(sg0Var, iO4);
                break;
            case 6:
                vm0 vm0Var4 = (f31) vm0Var;
                int iO5 = g7Var.o();
                g7Var.y(vm0Var4);
                g7Var.v(vm0Var4, iO5);
                break;
            case 7:
                vm0 vm0Var5 = (iy) vm0Var;
                int iO6 = g7Var.o();
                g7Var.y(vm0Var5);
                g7Var.v(vm0Var5, iO6);
                break;
            case 8:
                vm0 vm0Var6 = (mg) vm0Var;
                g7Var.f();
                int iO7 = g7Var.o();
                g7Var.y(vm0Var6);
                g7Var.v(vm0Var6, iO7);
                g7Var.b(vm0Var6);
                break;
            case 9:
                zk zkVar = (zk) vm0Var;
                int iO8 = g7Var.o();
                r11 r11Var = (r11) g7Var.b;
                StringBuilder sb = r11Var.b;
                sb.append((char) 160);
                sb.append(zkVar.f);
                r11Var.a((char) 160);
                g7Var.v(zkVar, iO8);
                break;
            case 10:
                m10 m10Var = (m10) vm0Var;
                zo.a(g7Var, m10Var.i, m10Var.j, m10Var);
                break;
            case 11:
                ab0 ab0Var = (ab0) vm0Var;
                zo.a(g7Var, null, ab0Var.f, ab0Var);
                break;
            case 12:
                r11 r11Var2 = (r11) g7Var.b;
                qa0 qa0Var = (qa0) vm0Var;
                h7 h7Var = (h7) g7Var.c;
                qg qgVar = (qg) ((Map) ((tb0) h7Var.f).c).get(qa0.class);
                if (qgVar == null) {
                    g7Var.y(qa0Var);
                    break;
                } else {
                    int iO9 = g7Var.o();
                    g7Var.y(qa0Var);
                    if (iO9 == g7Var.o()) {
                        r11Var2.a((char) 65532);
                    }
                    boolean z2 = qa0Var.a instanceof sg0;
                    ow0 ow0Var = (ow0) h7Var.e;
                    String str = qa0Var.f;
                    ow0Var.getClass();
                    kj0 kj0Var = (kj0) g7Var.d;
                    xr.d.b(kj0Var, str);
                    xr.e.b(kj0Var, Boolean.valueOf(z2));
                    xr.f.b(kj0Var, null);
                    Object objA = qgVar.a(h7Var, kj0Var);
                    StringBuilder sb2 = r11Var2.b;
                    int length = sb2.length();
                    int length2 = sb2.length();
                    if (length > iO9 && iO9 >= 0 && length <= length2) {
                        r11.c(r11Var2, objA, iO9, length);
                        break;
                    }
                }
                break;
            case 13:
                vm0 vm0Var7 = (dh0) vm0Var;
                or0 or0Var = lc1.a;
                int iO10 = g7Var.o();
                kj0 kj0Var2 = (kj0) g7Var.d;
                g7Var.y(vm0Var7);
                kg kgVar3 = (kg) vm0Var7.a;
                if (kgVar3 instanceof po0) {
                    po0 po0Var = (po0) kgVar3;
                    int i2 = po0Var.g;
                    or0Var.b(kj0Var2, ap.c);
                    lc1.c.b(kj0Var2, Integer.valueOf(i2));
                    po0Var.g++;
                } else {
                    or0Var.b(kj0Var2, ap.b);
                    or0 or0Var2 = lc1.b;
                    for (vm0 vm0VarC = (kg) vm0Var7.a; vm0VarC != null; vm0VarC = vm0VarC.c()) {
                        if (vm0VarC instanceof dh0) {
                            i++;
                        }
                    }
                    or0Var2.b(kj0Var2, Integer.valueOf(i));
                }
                g7Var.v(vm0Var7, iO10);
                if (vm0Var7.e != null) {
                    g7Var.f();
                }
                break;
            default:
                g7Var.f();
                int iO11 = g7Var.o();
                g7Var.y(vm0Var);
                g7Var.v(vm0Var, iO11);
                g7Var.b(vm0Var);
                break;
        }
    }
}
