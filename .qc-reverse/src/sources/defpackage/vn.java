package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class vn {
    public int A;
    public float B;
    public final int[] C;
    public float D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public final gn I;
    public final gn J;
    public final gn K;
    public final gn L;
    public final gn M;
    public final gn N;
    public final gn O;
    public final gn P;
    public final gn[] Q;
    public final ArrayList R;
    public final boolean[] S;
    public vn T;
    public int U;
    public int V;
    public float W;
    public int X;
    public int Y;
    public int Z;
    public int a0;
    public dj b;
    public int b0;
    public dj c;
    public int c0;
    public float d0;
    public float e0;
    public View f0;
    public int g0;
    public String h0;
    public int i0;
    public String j;
    public int j0;
    public boolean k;
    public final float[] k0;
    public boolean l;
    public final vn[] l0;
    public boolean m;
    public final vn[] m0;
    public boolean n;
    public int n0;
    public int o;
    public int o0;
    public int p;
    public final int[] p0;
    public int q;
    public int r;
    public int s;
    public final int[] t;
    public int u;
    public int v;
    public float w;
    public int x;
    public int y;
    public float z;
    public boolean a = false;
    public q80 d = null;
    public cf1 e = null;
    public final boolean[] f = {true, true};
    public boolean g = true;
    public int h = -1;
    public int i = -1;

    public vn() {
        new HashMap();
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = -1;
        this.p = -1;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = new int[2];
        this.u = 0;
        this.v = 0;
        this.w = 1.0f;
        this.x = 0;
        this.y = 0;
        this.z = 1.0f;
        this.A = -1;
        this.B = 1.0f;
        this.C = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.D = Float.NaN;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        gn gnVar = new gn(this, 2);
        this.I = gnVar;
        gn gnVar2 = new gn(this, 3);
        this.J = gnVar2;
        gn gnVar3 = new gn(this, 4);
        this.K = gnVar3;
        gn gnVar4 = new gn(this, 5);
        this.L = gnVar4;
        gn gnVar5 = new gn(this, 6);
        this.M = gnVar5;
        gn gnVar6 = new gn(this, 8);
        this.N = gnVar6;
        gn gnVar7 = new gn(this, 9);
        this.O = gnVar7;
        gn gnVar8 = new gn(this, 7);
        this.P = gnVar8;
        this.Q = new gn[]{gnVar, gnVar3, gnVar2, gnVar4, gnVar5, gnVar8};
        ArrayList arrayList = new ArrayList();
        this.R = arrayList;
        this.S = new boolean[2];
        this.p0 = new int[]{1, 1};
        this.T = null;
        this.U = 0;
        this.V = 0;
        this.W = 0.0f;
        this.X = -1;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        this.d0 = 0.5f;
        this.e0 = 0.5f;
        this.g0 = 0;
        this.h0 = null;
        this.i0 = 0;
        this.j0 = 0;
        this.k0 = new float[]{-1.0f, -1.0f};
        this.l0 = new vn[]{null, null};
        this.m0 = new vn[]{null, null};
        this.n0 = -1;
        this.o0 = -1;
        arrayList.add(gnVar);
        arrayList.add(gnVar2);
        arrayList.add(gnVar3);
        arrayList.add(gnVar4);
        arrayList.add(gnVar6);
        arrayList.add(gnVar7);
        arrayList.add(gnVar8);
        arrayList.add(gnVar5);
    }

    public static void G(int i, int i2, String str, StringBuilder sb) {
        if (i == i2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i);
        sb.append(",\n");
    }

    public static void H(StringBuilder sb, String str, float f, float f2) {
        if (f == f2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f);
        sb.append(",\n");
    }

    public static void o(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, float f, int i6) {
        String str2;
        sb.append(str);
        sb.append(" :  {\n");
        if (i6 == 1) {
            str2 = "FIXED";
        } else if (i6 == 2) {
            str2 = "WRAP_CONTENT";
        } else if (i6 == 3) {
            str2 = "MATCH_CONSTRAINT";
        } else {
            if (i6 != 4) {
                throw null;
            }
            str2 = "MATCH_PARENT";
        }
        if (!"FIXED".equals(str2)) {
            sb.append("      behavior");
            sb.append(" :   ");
            sb.append(str2);
            sb.append(",\n");
        }
        G(i, 0, "      size", sb);
        G(i2, 0, "      min", sb);
        G(i3, Integer.MAX_VALUE, "      max", sb);
        G(i4, 0, "      matchMin", sb);
        G(i5, 0, "      matchDef", sb);
        H(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    public static void p(StringBuilder sb, String str, gn gnVar) {
        if (gnVar.f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(gnVar.f);
        sb.append("'");
        if (gnVar.h != Integer.MIN_VALUE || gnVar.g != 0) {
            sb.append(",");
            sb.append(gnVar.g);
            if (gnVar.h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(gnVar.h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public boolean A() {
        if (this.k) {
            return true;
        }
        return this.I.c && this.K.c;
    }

    public boolean B() {
        if (this.l) {
            return true;
        }
        return this.J.c && this.L.c;
    }

    public void C() {
        this.I.j();
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.T = null;
        this.D = Float.NaN;
        this.U = 0;
        this.V = 0;
        this.W = 0.0f;
        this.X = -1;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0.5f;
        this.e0 = 0.5f;
        int[] iArr = this.p0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.f0 = null;
        this.g0 = 0;
        this.i0 = 0;
        this.j0 = 0;
        float[] fArr = this.k0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.o = -1;
        this.p = -1;
        int[] iArr2 = this.C;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.r = 0;
        this.s = 0;
        this.w = 1.0f;
        this.z = 1.0f;
        this.v = Integer.MAX_VALUE;
        this.y = Integer.MAX_VALUE;
        this.u = 0;
        this.x = 0;
        this.A = -1;
        this.B = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        this.F = false;
        boolean[] zArr2 = this.S;
        zArr2[0] = false;
        zArr2[1] = false;
        this.g = true;
        int[] iArr3 = this.t;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.h = -1;
        this.i = -1;
    }

    public final void D() {
        vn vnVar = this.T;
        if (vnVar != null && (vnVar instanceof wn)) {
            ((wn) vnVar).getClass();
        }
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((gn) arrayList.get(i)).j();
        }
    }

    public final void E() {
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            gn gnVar = (gn) arrayList.get(i);
            gnVar.c = false;
            gnVar.b = 0;
        }
    }

    public void F(ra raVar) {
        this.I.k();
        this.J.k();
        this.K.k();
        this.L.k();
        this.M.k();
        this.P.k();
        this.N.k();
        this.O.k();
    }

    public final void I(int i) {
        this.a0 = i;
        this.E = i > 0;
    }

    public final void J(int i, int i2) {
        if (this.k) {
            return;
        }
        this.I.l(i);
        this.K.l(i2);
        this.Y = i;
        this.U = i2 - i;
        this.k = true;
    }

    public final void K(int i, int i2) {
        if (this.l) {
            return;
        }
        this.J.l(i);
        this.L.l(i2);
        this.Z = i;
        this.V = i2 - i;
        if (this.E) {
            this.M.l(i + this.a0);
        }
        this.l = true;
    }

    public final void L(int i) {
        this.V = i;
        int i2 = this.c0;
        if (i < i2) {
            this.V = i2;
        }
    }

    public final void M(int i) {
        this.p0[0] = i;
    }

    public final void N(int i) {
        this.p0[1] = i;
    }

    public final void O(int i) {
        this.U = i;
        int i2 = this.b0;
        if (i < i2) {
            this.U = i2;
        }
    }

    public void P(boolean z, boolean z2) {
        int i;
        int i2;
        q80 q80Var = this.d;
        boolean z3 = z & q80Var.g;
        cf1 cf1Var = this.e;
        boolean z4 = z2 & cf1Var.g;
        int i3 = q80Var.h.g;
        int i4 = cf1Var.h.g;
        int i5 = q80Var.i.g;
        int i6 = cf1Var.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.Y = i3;
        }
        if (z4) {
            this.Z = i4;
        }
        if (this.g0 == 8) {
            this.U = 0;
            this.V = 0;
            return;
        }
        int[] iArr = this.p0;
        if (z3) {
            if (iArr[0] == 1 && i8 < (i2 = this.U)) {
                i8 = i2;
            }
            this.U = i8;
            int i10 = this.b0;
            if (i8 < i10) {
                this.U = i10;
            }
        }
        if (z4) {
            if (iArr[1] == 1 && i9 < (i = this.V)) {
                i9 = i;
            }
            this.V = i9;
            int i11 = this.c0;
            if (i9 < i11) {
                this.V = i11;
            }
        }
    }

    public void Q(rg0 rg0Var, boolean z) {
        int i;
        int i2;
        cf1 cf1Var;
        q80 q80Var;
        rg0Var.getClass();
        int iN = rg0.n(this.I);
        int iN2 = rg0.n(this.J);
        int iN3 = rg0.n(this.K);
        int iN4 = rg0.n(this.L);
        if (z && (q80Var = this.d) != null) {
            gt gtVar = q80Var.h;
            if (gtVar.j) {
                gt gtVar2 = q80Var.i;
                if (gtVar2.j) {
                    iN = gtVar.g;
                    iN3 = gtVar2.g;
                }
            }
        }
        if (z && (cf1Var = this.e) != null) {
            gt gtVar3 = cf1Var.h;
            if (gtVar3.j) {
                gt gtVar4 = cf1Var.i;
                if (gtVar4.j) {
                    iN2 = gtVar3.g;
                    iN4 = gtVar4.g;
                }
            }
        }
        int i3 = iN4 - iN2;
        if (iN3 - iN < 0 || i3 < 0 || iN == Integer.MIN_VALUE || iN == Integer.MAX_VALUE || iN2 == Integer.MIN_VALUE || iN2 == Integer.MAX_VALUE || iN3 == Integer.MIN_VALUE || iN3 == Integer.MAX_VALUE || iN4 == Integer.MIN_VALUE || iN4 == Integer.MAX_VALUE) {
            iN = 0;
            iN2 = 0;
            iN3 = 0;
            iN4 = 0;
        }
        int i4 = iN3 - iN;
        int i5 = iN4 - iN2;
        this.Y = iN;
        this.Z = iN2;
        if (this.g0 == 8) {
            this.U = 0;
            this.V = 0;
            return;
        }
        int[] iArr = this.p0;
        int i6 = iArr[0];
        if (i6 == 1 && i4 < (i2 = this.U)) {
            i4 = i2;
        }
        if (iArr[1] == 1 && i5 < (i = this.V)) {
            i5 = i;
        }
        this.U = i4;
        this.V = i5;
        int i7 = this.c0;
        if (i5 < i7) {
            this.V = i7;
        }
        int i8 = this.b0;
        if (i4 < i8) {
            this.U = i8;
        }
        int i9 = this.v;
        if (i9 > 0 && i6 == 3) {
            this.U = Math.min(this.U, i9);
        }
        int i10 = this.y;
        if (i10 > 0 && iArr[1] == 3) {
            this.V = Math.min(this.V, i10);
        }
        int i11 = this.U;
        if (i4 != i11) {
            this.h = i11;
        }
        int i12 = this.V;
        if (i5 != i12) {
            this.i = i12;
        }
    }

    public final void a(wn wnVar, rg0 rg0Var, HashSet hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            lc1.f(wnVar, rg0Var, this);
            hashSet.remove(this);
            b(rg0Var, wnVar.W(64));
        }
        if (i == 0) {
            HashSet hashSet2 = this.I.a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((gn) it.next()).d.a(wnVar, rg0Var, hashSet, i, true);
                }
            }
            HashSet hashSet3 = this.K.a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((gn) it2.next()).d.a(wnVar, rg0Var, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.J.a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((gn) it3.next()).d.a(wnVar, rg0Var, hashSet, i, true);
            }
        }
        HashSet hashSet5 = this.L.a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((gn) it4.next()).d.a(wnVar, rg0Var, hashSet, i, true);
            }
        }
        HashSet hashSet6 = this.M.a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((gn) it5.next()).d.a(wnVar, rg0Var, hashSet, i, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fd  */
    /* JADX WARN: Type inference failed for: r12v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r4v24, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v25, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r58v0, types: [vn] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(defpackage.rg0 r59, boolean r60) {
        /*
            Method dump skipped, instruction units count: 1910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vn.b(rg0, boolean):void");
    }

    public boolean c() {
        return this.g0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x03bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0493 A[PHI: r0
  0x0493: PHI (r0v15 int) = (r0v14 int), (r0v19 int), (r0v19 int), (r0v19 int) binds: [B:280:0x0483, B:282:0x0489, B:283:0x048b, B:285:0x048f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:345:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(defpackage.rg0 r30, boolean r31, boolean r32, boolean r33, boolean r34, defpackage.m11 r35, defpackage.m11 r36, int r37, boolean r38, defpackage.gn r39, defpackage.gn r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, int r51, int r52, int r53, int r54, float r55, boolean r56) {
        /*
            Method dump skipped, instruction units count: 1323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vn.d(rg0, boolean, boolean, boolean, boolean, m11, m11, int, boolean, gn, gn, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void e(int i, vn vnVar, int i2, int i3) {
        boolean z;
        if (i == 7) {
            if (i2 != 7) {
                if (i2 == 2 || i2 == 4) {
                    e(2, vnVar, i2, 0);
                    e(4, vnVar, i2, 0);
                    i(7).a(vnVar.i(i2), 0);
                    return;
                } else {
                    if (i2 == 3 || i2 == 5) {
                        e(3, vnVar, i2, 0);
                        e(5, vnVar, i2, 0);
                        i(7).a(vnVar.i(i2), 0);
                        return;
                    }
                    return;
                }
            }
            gn gnVarI = i(2);
            gn gnVarI2 = i(4);
            gn gnVarI3 = i(3);
            gn gnVarI4 = i(5);
            boolean z2 = true;
            if ((gnVarI == null || !gnVarI.h()) && (gnVarI2 == null || !gnVarI2.h())) {
                e(2, vnVar, 2, 0);
                e(4, vnVar, 4, 0);
                z = true;
            } else {
                z = false;
            }
            if ((gnVarI3 == null || !gnVarI3.h()) && (gnVarI4 == null || !gnVarI4.h())) {
                e(3, vnVar, 3, 0);
                e(5, vnVar, 5, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                i(7).a(vnVar.i(7), 0);
                return;
            } else if (z) {
                i(8).a(vnVar.i(8), 0);
                return;
            } else {
                if (z2) {
                    i(9).a(vnVar.i(9), 0);
                    return;
                }
                return;
            }
        }
        if (i == 8 && (i2 == 2 || i2 == 4)) {
            gn gnVarI5 = i(2);
            gn gnVarI6 = vnVar.i(i2);
            gn gnVarI7 = i(4);
            gnVarI5.a(gnVarI6, 0);
            gnVarI7.a(gnVarI6, 0);
            i(8).a(gnVarI6, 0);
            return;
        }
        if (i == 9 && (i2 == 3 || i2 == 5)) {
            gn gnVarI8 = vnVar.i(i2);
            i(3).a(gnVarI8, 0);
            i(5).a(gnVarI8, 0);
            i(9).a(gnVarI8, 0);
            return;
        }
        if (i == 8 && i2 == 8) {
            i(2).a(vnVar.i(2), 0);
            i(4).a(vnVar.i(4), 0);
            i(8).a(vnVar.i(i2), 0);
            return;
        }
        if (i == 9 && i2 == 9) {
            i(3).a(vnVar.i(3), 0);
            i(5).a(vnVar.i(5), 0);
            i(9).a(vnVar.i(i2), 0);
            return;
        }
        gn gnVarI9 = i(i);
        gn gnVarI10 = vnVar.i(i2);
        if (gnVarI9.i(gnVarI10)) {
            if (i == 6) {
                gn gnVarI11 = i(3);
                gn gnVarI12 = i(5);
                if (gnVarI11 != null) {
                    gnVarI11.j();
                }
                if (gnVarI12 != null) {
                    gnVarI12.j();
                }
            } else if (i == 3 || i == 5) {
                gn gnVarI13 = i(6);
                if (gnVarI13 != null) {
                    gnVarI13.j();
                }
                gn gnVarI14 = i(7);
                if (gnVarI14.f != gnVarI10) {
                    gnVarI14.j();
                }
                gn gnVarF = i(i).f();
                gn gnVarI15 = i(9);
                if (gnVarI15.h()) {
                    gnVarF.j();
                    gnVarI15.j();
                }
            } else if (i == 2 || i == 4) {
                gn gnVarI16 = i(7);
                if (gnVarI16.f != gnVarI10) {
                    gnVarI16.j();
                }
                gn gnVarF2 = i(i).f();
                gn gnVarI17 = i(8);
                if (gnVarI17.h()) {
                    gnVarF2.j();
                    gnVarI17.j();
                }
            }
            gnVarI9.a(gnVarI10, i3);
        }
    }

    public final void f(gn gnVar, gn gnVar2, int i) {
        if (gnVar.d == this) {
            e(gnVar.e, gnVar2.d, gnVar2.e, i);
        }
    }

    public final void g(rg0 rg0Var) {
        rg0Var.k(this.I);
        rg0Var.k(this.J);
        rg0Var.k(this.K);
        rg0Var.k(this.L);
        if (this.a0 > 0) {
            rg0Var.k(this.M);
        }
    }

    public final void h() {
        if (this.d == null) {
            q80 q80Var = new q80(this);
            q80Var.h.e = 4;
            q80Var.i.e = 5;
            q80Var.f = 0;
            this.d = q80Var;
        }
        if (this.e == null) {
            cf1 cf1Var = new cf1(this);
            gt gtVar = new gt(cf1Var);
            cf1Var.k = gtVar;
            cf1Var.l = null;
            cf1Var.h.e = 6;
            cf1Var.i.e = 7;
            gtVar.e = 8;
            cf1Var.f = 1;
            this.e = cf1Var;
        }
    }

    public gn i(int i) {
        switch (l11.r(i)) {
            case 0:
                return null;
            case 1:
                return this.I;
            case 2:
                return this.J;
            case 3:
                return this.K;
            case 4:
                return this.L;
            case 5:
                return this.M;
            case 6:
                return this.P;
            case 7:
                return this.N;
            case 8:
                return this.O;
            default:
                throw new AssertionError(l11.o(i));
        }
    }

    public final int j(int i) {
        int[] iArr = this.p0;
        if (i == 0) {
            return iArr[0];
        }
        if (i == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int k() {
        if (this.g0 == 8) {
            return 0;
        }
        return this.V;
    }

    public final vn l(int i) {
        gn gnVar;
        gn gnVar2;
        if (i != 0) {
            if (i == 1 && (gnVar2 = (gnVar = this.L).f) != null && gnVar2.f == gnVar) {
                return gnVar2.d;
            }
            return null;
        }
        gn gnVar3 = this.K;
        gn gnVar4 = gnVar3.f;
        if (gnVar4 == null || gnVar4.f != gnVar3) {
            return null;
        }
        return gnVar4.d;
    }

    public final vn m(int i) {
        gn gnVar;
        gn gnVar2;
        if (i != 0) {
            if (i == 1 && (gnVar2 = (gnVar = this.J).f) != null && gnVar2.f == gnVar) {
                return gnVar2.d;
            }
            return null;
        }
        gn gnVar3 = this.I;
        gn gnVar4 = gnVar3.f;
        if (gnVar4 == null || gnVar4.f != gnVar3) {
            return null;
        }
        return gnVar4.d;
    }

    public void n(StringBuilder sb) {
        sb.append("  " + this.j + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.U);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.V);
        sb.append("\n");
        sb.append("    actualLeft:" + this.Y);
        sb.append("\n");
        sb.append("    actualTop:" + this.Z);
        sb.append("\n");
        p(sb, "left", this.I);
        p(sb, "top", this.J);
        p(sb, "right", this.K);
        p(sb, "bottom", this.L);
        p(sb, "baseline", this.M);
        p(sb, "centerX", this.N);
        p(sb, "centerY", this.O);
        int i = this.U;
        int i2 = this.b0;
        int[] iArr = this.C;
        int i3 = iArr[0];
        int i4 = this.u;
        int i5 = this.r;
        float f = this.w;
        int[] iArr2 = this.p0;
        int i6 = iArr2[0];
        float[] fArr = this.k0;
        float f2 = fArr[0];
        o(sb, "    width", i, i2, i3, i4, i5, f, i6);
        int i7 = this.V;
        int i8 = this.c0;
        int i9 = iArr[1];
        int i10 = this.x;
        int i11 = this.s;
        float f3 = this.z;
        int i12 = iArr2[1];
        float f4 = fArr[1];
        o(sb, "    height", i7, i8, i9, i10, i11, f3, i12);
        float f5 = this.W;
        int i13 = this.X;
        if (f5 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f5);
            sb.append(",");
            sb.append(i13);
            sb.append("");
            sb.append("],\n");
        }
        H(sb, "    horizontalBias", this.d0, 0.5f);
        H(sb, "    verticalBias", this.e0, 0.5f);
        G(this.i0, 0, "    horizontalChainStyle", sb);
        G(this.j0, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public final int q() {
        if (this.g0 == 8) {
            return 0;
        }
        return this.U;
    }

    public final int r() {
        vn vnVar = this.T;
        return (vnVar == null || !(vnVar instanceof wn)) ? this.Y : ((wn) vnVar).x0 + this.Y;
    }

    public final int s() {
        vn vnVar = this.T;
        return (vnVar == null || !(vnVar instanceof wn)) ? this.Z : ((wn) vnVar).y0 + this.Z;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(int r5) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L1b
            gn r5 = r4.I
            gn r5 = r5.f
            if (r5 == 0) goto Ld
            r5 = r2
            goto Le
        Ld:
            r5 = r1
        Le:
            gn r4 = r4.K
            gn r4 = r4.f
            if (r4 == 0) goto L16
            r4 = r2
            goto L17
        L16:
            r4 = r1
        L17:
            int r5 = r5 + r4
            if (r5 >= r0) goto L3b
            goto L3a
        L1b:
            gn r5 = r4.J
            gn r5 = r5.f
            if (r5 == 0) goto L23
            r5 = r2
            goto L24
        L23:
            r5 = r1
        L24:
            gn r3 = r4.L
            gn r3 = r3.f
            if (r3 == 0) goto L2c
            r3 = r2
            goto L2d
        L2c:
            r3 = r1
        L2d:
            int r5 = r5 + r3
            gn r4 = r4.M
            gn r4 = r4.f
            if (r4 == 0) goto L36
            r4 = r2
            goto L37
        L36:
            r4 = r1
        L37:
            int r5 = r5 + r4
            if (r5 >= r0) goto L3b
        L3a:
            return r2
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vn.t(int):boolean");
    }

    public String toString() {
        StringBuilder sbL = l11.l("");
        sbL.append(this.h0 != null ? l11.k(new StringBuilder("id: "), this.h0, " ") : "");
        sbL.append("(");
        sbL.append(this.Y);
        sbL.append(", ");
        sbL.append(this.Z);
        sbL.append(") - (");
        sbL.append(this.U);
        sbL.append(" x ");
        sbL.append(this.V);
        sbL.append(")");
        return sbL.toString();
    }

    public final boolean u(int i, int i2) {
        gn gnVar;
        gn gnVar2;
        gn gnVar3;
        gn gnVar4;
        if (i == 0) {
            gn gnVar5 = this.I;
            gn gnVar6 = gnVar5.f;
            if (gnVar6 == null || !gnVar6.c || (gnVar4 = (gnVar3 = this.K).f) == null || !gnVar4.c) {
                return false;
            }
            return (gnVar4.d() - gnVar3.e()) - (gnVar5.e() + gnVar5.f.d()) >= i2;
        }
        gn gnVar7 = this.J;
        gn gnVar8 = gnVar7.f;
        if (gnVar8 == null || !gnVar8.c || (gnVar2 = (gnVar = this.L).f) == null || !gnVar2.c) {
            return false;
        }
        return (gnVar2.d() - gnVar.e()) - (gnVar7.e() + gnVar7.f.d()) >= i2;
    }

    public final void v(int i, int i2, int i3, int i4, vn vnVar) {
        i(i).b(vnVar.i(i2), i3, i4, true);
    }

    public final boolean w(int i) {
        gn gnVar;
        gn gnVar2;
        int i2 = i * 2;
        gn[] gnVarArr = this.Q;
        gn gnVar3 = gnVarArr[i2];
        gn gnVar4 = gnVar3.f;
        return (gnVar4 == null || gnVar4.f == gnVar3 || (gnVar2 = (gnVar = gnVarArr[i2 + 1]).f) == null || gnVar2.f != gnVar) ? false : true;
    }

    public final boolean x() {
        gn gnVar = this.I;
        gn gnVar2 = gnVar.f;
        if (gnVar2 != null && gnVar2.f == gnVar) {
            return true;
        }
        gn gnVar3 = this.K;
        gn gnVar4 = gnVar3.f;
        return gnVar4 != null && gnVar4.f == gnVar3;
    }

    public final boolean y() {
        gn gnVar = this.J;
        gn gnVar2 = gnVar.f;
        if (gnVar2 != null && gnVar2.f == gnVar) {
            return true;
        }
        gn gnVar3 = this.L;
        gn gnVar4 = gnVar3.f;
        return gnVar4 != null && gnVar4.f == gnVar3;
    }

    public final boolean z() {
        return this.g && this.g0 != 8;
    }
}
