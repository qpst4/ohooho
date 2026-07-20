package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wn extends vn {
    public int A0;
    public cj[] B0;
    public cj[] C0;
    public int D0;
    public boolean E0;
    public boolean F0;
    public WeakReference G0;
    public WeakReference H0;
    public WeakReference I0;
    public WeakReference J0;
    public final HashSet K0;
    public final se L0;
    public ArrayList q0 = new ArrayList();
    public final ra r0 = new ra(this);
    public final ft s0;
    public int t0;
    public ln u0;
    public boolean v0;
    public final rg0 w0;
    public int x0;
    public int y0;
    public int z0;

    public wn() {
        ft ftVar = new ft();
        ftVar.b = true;
        ftVar.c = true;
        ftVar.e = new ArrayList();
        new ArrayList();
        ftVar.f = null;
        ftVar.g = new se();
        ftVar.h = new ArrayList();
        ftVar.a = this;
        ftVar.d = this;
        this.s0 = ftVar;
        this.u0 = null;
        this.v0 = false;
        this.w0 = new rg0();
        this.z0 = 0;
        this.A0 = 0;
        this.B0 = new cj[4];
        this.C0 = new cj[4];
        this.D0 = 257;
        this.E0 = false;
        this.F0 = false;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.K0 = new HashSet();
        this.L0 = new se();
    }

    public static void V(vn vnVar, ln lnVar, se seVar) {
        int i;
        int i2;
        if (lnVar == null) {
            return;
        }
        int i3 = vnVar.g0;
        int[] iArr = vnVar.t;
        if (i3 == 8 || (vnVar instanceof n70) || (vnVar instanceof fe)) {
            seVar.e = 0;
            seVar.f = 0;
            return;
        }
        int[] iArr2 = vnVar.p0;
        seVar.a = iArr2[0];
        seVar.b = iArr2[1];
        seVar.c = vnVar.q();
        seVar.d = vnVar.k();
        seVar.i = false;
        seVar.j = 0;
        boolean z = seVar.a == 3;
        boolean z2 = seVar.b == 3;
        boolean z3 = z && vnVar.W > 0.0f;
        boolean z4 = z2 && vnVar.W > 0.0f;
        if (z && vnVar.t(0) && vnVar.r == 0 && !z3) {
            seVar.a = 2;
            if (z2 && vnVar.s == 0) {
                seVar.a = 1;
            }
            z = false;
        }
        if (z2 && vnVar.t(1) && vnVar.s == 0 && !z4) {
            seVar.b = 2;
            if (z && vnVar.r == 0) {
                seVar.b = 1;
            }
            z2 = false;
        }
        if (vnVar.A()) {
            seVar.a = 1;
            z = false;
        }
        if (vnVar.B()) {
            seVar.b = 1;
            z2 = false;
        }
        if (z3) {
            if (iArr[0] == 4) {
                seVar.a = 1;
            } else if (!z2) {
                if (seVar.b == 1) {
                    i2 = seVar.d;
                } else {
                    seVar.a = 2;
                    lnVar.b(vnVar, seVar);
                    i2 = seVar.f;
                }
                seVar.a = 1;
                seVar.c = (int) (vnVar.W * i2);
            }
        }
        if (z4) {
            if (iArr[1] == 4) {
                seVar.b = 1;
            } else if (!z) {
                if (seVar.a == 1) {
                    i = seVar.c;
                } else {
                    seVar.b = 2;
                    lnVar.b(vnVar, seVar);
                    i = seVar.e;
                }
                seVar.b = 1;
                int i4 = vnVar.X;
                float f = vnVar.W;
                if (i4 == -1) {
                    seVar.d = (int) (i / f);
                } else {
                    seVar.d = (int) (f * i);
                }
            }
        }
        lnVar.b(vnVar, seVar);
        vnVar.O(seVar.e);
        vnVar.L(seVar.f);
        vnVar.E = seVar.h;
        vnVar.I(seVar.g);
        seVar.j = 0;
    }

    @Override // defpackage.vn
    public final void C() {
        this.w0.t();
        this.x0 = 0;
        this.y0 = 0;
        this.q0.clear();
        super.C();
    }

    @Override // defpackage.vn
    public final void F(ra raVar) {
        super.F(raVar);
        int size = this.q0.size();
        for (int i = 0; i < size; i++) {
            ((vn) this.q0.get(i)).F(raVar);
        }
    }

    @Override // defpackage.vn
    public final void P(boolean z, boolean z2) {
        super.P(z, z2);
        int size = this.q0.size();
        for (int i = 0; i < size; i++) {
            ((vn) this.q0.get(i)).P(z, z2);
        }
    }

    public final void R(vn vnVar, int i) {
        if (i == 0) {
            int i2 = this.z0 + 1;
            cj[] cjVarArr = this.C0;
            if (i2 >= cjVarArr.length) {
                this.C0 = (cj[]) Arrays.copyOf(cjVarArr, cjVarArr.length * 2);
            }
            cj[] cjVarArr2 = this.C0;
            int i3 = this.z0;
            cjVarArr2[i3] = new cj(vnVar, 0, this.v0);
            this.z0 = i3 + 1;
            return;
        }
        if (i == 1) {
            int i4 = this.A0 + 1;
            cj[] cjVarArr3 = this.B0;
            if (i4 >= cjVarArr3.length) {
                this.B0 = (cj[]) Arrays.copyOf(cjVarArr3, cjVarArr3.length * 2);
            }
            cj[] cjVarArr4 = this.B0;
            int i5 = this.A0;
            cjVarArr4[i5] = new cj(vnVar, 1, this.v0);
            this.A0 = i5 + 1;
        }
    }

    public final void S(rg0 rg0Var) {
        wn wnVar;
        rg0 rg0Var2;
        boolean zW = W(64);
        b(rg0Var, zW);
        int size = this.q0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            vn vnVar = (vn) this.q0.get(i);
            boolean[] zArr = vnVar.S;
            zArr[0] = false;
            zArr[1] = false;
            if (vnVar instanceof fe) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                vn vnVar2 = (vn) this.q0.get(i2);
                if (vnVar2 instanceof fe) {
                    fe feVar = (fe) vnVar2;
                    for (int i3 = 0; i3 < feVar.r0; i3++) {
                        vn vnVar3 = feVar.q0[i3];
                        if (feVar.t0 || vnVar3.c()) {
                            int i4 = feVar.s0;
                            if (i4 == 0 || i4 == 1) {
                                vnVar3.S[0] = true;
                            } else if (i4 == 2 || i4 == 3) {
                                vnVar3.S[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.K0;
        hashSet.clear();
        for (int i5 = 0; i5 < size; i5++) {
            vn vnVar4 = (vn) this.q0.get(i5);
            vnVar4.getClass();
            boolean z2 = vnVar4 instanceof h20;
            if (z2 || (vnVar4 instanceof n70)) {
                if (z2) {
                    hashSet.add(vnVar4);
                } else {
                    vnVar4.b(rg0Var, zW);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h20 h20Var = (h20) ((vn) it.next());
                for (int i6 = 0; i6 < h20Var.r0; i6++) {
                    if (hashSet.contains(h20Var.q0[i6])) {
                        h20Var.b(rg0Var, zW);
                        hashSet.remove(h20Var);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((vn) it2.next()).b(rg0Var, zW);
                }
                hashSet.clear();
            }
        }
        if (rg0.q) {
            HashSet<vn> hashSet2 = new HashSet();
            for (int i7 = 0; i7 < size; i7++) {
                vn vnVar5 = (vn) this.q0.get(i7);
                vnVar5.getClass();
                if (!(vnVar5 instanceof h20) && !(vnVar5 instanceof n70)) {
                    hashSet2.add(vnVar5);
                }
            }
            wnVar = this;
            rg0Var2 = rg0Var;
            wnVar.a(this, rg0Var2, hashSet2, this.p0[0] == 2 ? 0 : 1, false);
            for (vn vnVar6 : hashSet2) {
                lc1.f(wnVar, rg0Var2, vnVar6);
                vnVar6.b(rg0Var2, zW);
            }
        } else {
            wnVar = this;
            rg0Var2 = rg0Var;
            for (int i8 = 0; i8 < size; i8++) {
                vn vnVar7 = (vn) wnVar.q0.get(i8);
                if (vnVar7 instanceof wn) {
                    int[] iArr = vnVar7.p0;
                    int i9 = iArr[0];
                    int i10 = iArr[1];
                    if (i9 == 2) {
                        vnVar7.M(1);
                    }
                    if (i10 == 2) {
                        vnVar7.N(1);
                    }
                    vnVar7.b(rg0Var2, zW);
                    if (i9 == 2) {
                        vnVar7.M(i9);
                    }
                    if (i10 == 2) {
                        vnVar7.N(i10);
                    }
                } else {
                    lc1.f(wnVar, rg0Var2, vnVar7);
                    if (!(vnVar7 instanceof h20) && !(vnVar7 instanceof n70)) {
                        vnVar7.b(rg0Var2, zW);
                    }
                }
            }
        }
        if (wnVar.z0 > 0) {
            xr.a(wnVar, rg0Var2, null, 0);
        }
        if (wnVar.A0 > 0) {
            xr.a(wnVar, rg0Var2, null, 1);
        }
    }

    public final boolean T(int i, boolean z) {
        boolean z2;
        ft ftVar = this.s0;
        ArrayList arrayList = ftVar.e;
        wn wnVar = ftVar.a;
        boolean z3 = false;
        int iJ = wnVar.j(0);
        int iJ2 = wnVar.j(1);
        int iR = wnVar.r();
        int iS = wnVar.s();
        if (z && (iJ == 2 || iJ2 == 2)) {
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                Object obj = arrayList.get(i2);
                i2++;
                oh1 oh1Var = (oh1) obj;
                if (oh1Var.f == i && !oh1Var.k()) {
                    z = false;
                    break;
                }
            }
            if (i == 0) {
                if (z && iJ == 2) {
                    wnVar.M(1);
                    wnVar.O(ftVar.d(wnVar, 0));
                    wnVar.d.e.d(wnVar.q());
                }
            } else if (z && iJ2 == 2) {
                wnVar.N(1);
                wnVar.L(ftVar.d(wnVar, 1));
                wnVar.e.e.d(wnVar.k());
            }
        }
        int[] iArr = wnVar.p0;
        if (i == 0) {
            int i3 = iArr[0];
            if (i3 == 1 || i3 == 4) {
                int iQ = wnVar.q() + iR;
                wnVar.d.i.d(iQ);
                wnVar.d.e.d(iQ - iR);
                z2 = true;
            }
            z2 = false;
        } else {
            int i4 = iArr[1];
            if (i4 == 1 || i4 == 4) {
                int iK = wnVar.k() + iS;
                wnVar.e.i.d(iK);
                wnVar.e.e.d(iK - iS);
                z2 = true;
            }
            z2 = false;
        }
        ftVar.g();
        int size2 = arrayList.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList.get(i5);
            i5++;
            oh1 oh1Var2 = (oh1) obj2;
            if (oh1Var2.f == i && (oh1Var2.b != wnVar || oh1Var2.g)) {
                oh1Var2.e();
            }
        }
        int size3 = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size3) {
                z3 = true;
                break;
            }
            Object obj3 = arrayList.get(i6);
            i6++;
            oh1 oh1Var3 = (oh1) obj3;
            if (oh1Var3.f == i && (z2 || oh1Var3.b != wnVar)) {
                if (!oh1Var3.h.j || !oh1Var3.i.j || (!(oh1Var3 instanceof dj) && !oh1Var3.e.j)) {
                    break;
                }
            }
        }
        wnVar.M(iJ);
        wnVar.N(iJ2);
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:339:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x063d  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0677 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x067d  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x06b3  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x07c3  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0800  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x081a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0827 A[LOOP:14: B:486:0x0825->B:487:0x0827, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:490:0x085c  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x088e  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x089a  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x08ad  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x08b5  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x08b9  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x08ed  */
    /* JADX WARN: Removed duplicated region for block: B:521:0x08f1  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:595:0x08f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012c  */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v101 */
    /* JADX WARN: Type inference failed for: r0v102 */
    /* JADX WARN: Type inference failed for: r0v103 */
    /* JADX WARN: Type inference failed for: r0v104 */
    /* JADX WARN: Type inference failed for: r0v105 */
    /* JADX WARN: Type inference failed for: r0v106 */
    /* JADX WARN: Type inference failed for: r0v107 */
    /* JADX WARN: Type inference failed for: r0v108 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v99 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r24v15 */
    /* JADX WARN: Type inference failed for: r24v16 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r32v0, types: [vn, wn] */
    /* JADX WARN: Type inference failed for: r3v67, types: [int] */
    /* JADX WARN: Type inference failed for: r5v53, types: [int] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v77, types: [int] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v52, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U() {
        /*
            Method dump skipped, instruction units count: 2320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wn.U():void");
    }

    public final boolean W(int i) {
        return (this.D0 & i) == i;
    }

    @Override // defpackage.vn
    public final void n(StringBuilder sb) {
        sb.append(this.j + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.U);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.V);
        sb.append("\n");
        ArrayList arrayList = this.q0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((vn) obj).n(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
}
