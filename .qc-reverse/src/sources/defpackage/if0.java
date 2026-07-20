package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class if0 extends lc1 {
    public static final if0 o = new if0(0);
    public static final if0 p = new if0(1);
    public final /* synthetic */ int n;

    public /* synthetic */ if0(int i) {
        this.n = i;
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public final float K0(defpackage.z01 r12) {
        /*
            r11 = this;
            int r11 = r11.n
            r0 = 1048576000(0x3e800000, float:0.25)
            r1 = 1053609165(0x3ecccccd, float:0.4)
            r2 = 1057803469(0x3f0ccccd, float:0.55)
            r3 = 1060320051(0x3f333333, float:0.7)
            r4 = 1062836634(0x3f59999a, float:0.85)
            r5 = 1067030938(0x3f99999a, float:1.2)
            r6 = 1068708659(0x3fb33333, float:1.4)
            r7 = 1070386381(0x3fcccccd, float:1.6)
            r8 = 1072064102(0x3fe66666, float:1.8)
            r9 = 1073741824(0x40000000, float:2.0)
            r10 = 1065353216(0x3f800000, float:1.0)
            switch(r11) {
                case 0: goto L3c;
                default: goto L23;
            }
        L23:
            int r11 = r12.c
            switch(r11) {
                case 0: goto L3b;
                case 1: goto L3a;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L34;
                case 5: goto L28;
                case 6: goto L32;
                case 7: goto L30;
                case 8: goto L2e;
                case 9: goto L2c;
                case 10: goto L2a;
                default: goto L28;
            }
        L28:
            r0 = r10
            goto L3b
        L2a:
            r0 = r9
            goto L3b
        L2c:
            r0 = r8
            goto L3b
        L2e:
            r0 = r7
            goto L3b
        L30:
            r0 = r6
            goto L3b
        L32:
            r0 = r5
            goto L3b
        L34:
            r0 = r4
            goto L3b
        L36:
            r0 = r3
            goto L3b
        L38:
            r0 = r2
            goto L3b
        L3a:
            r0 = r1
        L3b:
            return r0
        L3c:
            int r11 = r12.c
            switch(r11) {
                case 0: goto L54;
                case 1: goto L53;
                case 2: goto L51;
                case 3: goto L4f;
                case 4: goto L4d;
                case 5: goto L41;
                case 6: goto L4b;
                case 7: goto L49;
                case 8: goto L47;
                case 9: goto L45;
                case 10: goto L43;
                default: goto L41;
            }
        L41:
            r0 = r10
            goto L54
        L43:
            r0 = r9
            goto L54
        L45:
            r0 = r8
            goto L54
        L47:
            r0 = r7
            goto L54
        L49:
            r0 = r6
            goto L54
        L4b:
            r0 = r5
            goto L54
        L4d:
            r0 = r4
            goto L54
        L4f:
            r0 = r3
            goto L54
        L51:
            r0 = r2
            goto L54
        L53:
            r0 = r1
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.if0.K0(z01):float");
    }

    @Override // defpackage.lc1
    public final db M(String str, z01 z01Var, db dbVar, db dbVar2) {
        float f;
        float f2;
        switch (this.n) {
            case 0:
                int i = ey0.e;
                switch (z01Var.d) {
                    case 0:
                        f = 1.5f;
                        break;
                    case 1:
                        f = 1.75f;
                        break;
                    case 2:
                    default:
                        f = 2.0f;
                        break;
                    case 3:
                        f = 2.33f;
                        break;
                    case 4:
                        f = 2.66f;
                        break;
                    case 5:
                        f = 3.0f;
                        break;
                    case 6:
                        f = 3.33f;
                        break;
                    case 7:
                        f = 3.66f;
                        break;
                    case 8:
                        f = 4.0f;
                        break;
                    case 9:
                        f = 4.33f;
                        break;
                    case 10:
                        f = 4.66f;
                        break;
                    case 11:
                        f = 5.0f;
                        break;
                }
                int iJ = (int) (dbVar2.j() / f);
                int iB = (int) (dbVar2.b() / f);
                int iJ2 = (int) ((dbVar.j() / 2.0f) + dbVar.g());
                int iB2 = (int) ((((dbVar.b() / 6.0f) * z01Var.f) + (((int) ((dbVar.b() / 2.0f) + dbVar.h())) - (dbVar.b() / 2.0f))) - (iB / 2));
                int iJ3 = (ey0.e / 32) * z01Var.g;
                if (!str.equals("Left")) {
                    iJ3 = (i - iJ) - iJ3;
                }
                if (z01Var.b >= 5) {
                    int i2 = str.equals("Left") ? 1 : -1;
                    int i3 = ey0.d;
                    iB2 = (i3 - iB) - ((i3 / 48) * z01Var.g);
                    iJ3 = (int) (((dbVar.j() / 2.0f) * i2 * (-1)) + (iJ2 - (iJ / 2)) + ((int) ((dbVar.j() / 6.0f) * z01Var.f * i2)));
                }
                return new db(iJ, iB, iJ3, iB2);
            default:
                int i4 = ey0.d;
                switch (z01Var.d) {
                    case 0:
                        f2 = 1.5f;
                        break;
                    case 1:
                        f2 = 1.75f;
                        break;
                    case 2:
                    default:
                        f2 = 2.0f;
                        break;
                    case 3:
                        f2 = 2.33f;
                        break;
                    case 4:
                        f2 = 2.66f;
                        break;
                    case 5:
                        f2 = 3.0f;
                        break;
                    case 6:
                        f2 = 3.33f;
                        break;
                    case 7:
                        f2 = 3.66f;
                        break;
                    case 8:
                        f2 = 4.0f;
                        break;
                    case 9:
                        f2 = 4.33f;
                        break;
                    case 10:
                        f2 = 4.66f;
                        break;
                    case 11:
                        f2 = 5.0f;
                        break;
                }
                int iJ4 = (int) (dbVar2.j() / f2);
                int iB3 = (int) (dbVar2.b() / f2);
                int iJ5 = (int) ((dbVar.j() / 2.0f) + dbVar.g());
                int iB4 = (int) ((((dbVar.b() / 6.0f) * z01Var.f) + (((int) ((dbVar.b() / 2.0f) + dbVar.h())) - (dbVar.b() / 2.0f))) - (iB3 / 2));
                int iJ6 = (ey0.d / 32) * z01Var.g;
                if (!str.equals("Left")) {
                    iJ6 = (i4 - iJ4) - iJ6;
                }
                if (z01Var.b < 5) {
                    int i5 = str.equals("Left") ? 1 : -1;
                    int i6 = ey0.e;
                    iB4 = (i6 - iB3) - ((i6 / 48) * z01Var.g);
                    iJ6 = (int) (((dbVar.j() / 2.0f) * i5 * (-1)) + (iJ5 - (iJ4 / 2)) + ((int) ((dbVar.j() / 6.0f) * z01Var.f * i5)));
                }
                return new db(iJ4, iB3, iJ6, iB4);
        }
    }

    @Override // defpackage.lc1
    public final db N(String str, z01 z01Var) {
        switch (this.n) {
            case 0:
                if (str.equals("Floating")) {
                    int i = (int) (((((double) ey0.d) / 2.0d) / 5.0d) * ((double) (z01Var.b + 1)));
                    float f = z01Var.a;
                    return new db(f, f, (int) (((double) ey0.e) - (((double) r13) / 2.0d)), (((int) (((double) ey0.d) / 2.0d)) - r13) + i);
                }
                int i2 = z01Var.b;
                if0 if0Var = o;
                if (i2 < 5) {
                    return new db(z01Var.a, (int) (if0Var.K0(z01Var) * (ey0.d / 4.0f)), str.equals("Left") ? 0.0f : ey0.e - z01Var.a, (((int) (((double) ey0.d) / 2.0d)) - r11) + ((int) (((((double) ey0.d) / 2.0d) / 5.0d) * ((double) (z01Var.b + 1)))));
                }
                int iK0 = (int) (if0Var.K0(z01Var) * ey0.a(200));
                return new db(iK0, z01Var.a, str.equals("Left") ? (int) ((((((double) ey0.e) / 2.0d) - ((double) iK0)) / 5.0d) * ((double) (z01Var.b - 5))) : (ey0.e - iK0) - r0, ey0.d - z01Var.a);
            default:
                if (str.equals("Floating")) {
                    int iAbs = (int) ((((((double) ey0.e) / 2.0d) - ((double) z01Var.a)) / 5.0d) * ((double) Math.abs(z01Var.b - 10)));
                    float f2 = z01Var.a;
                    return new db(f2, f2, (int) (((double) ey0.d) - (((double) r13) / 2.0d)), ((int) (((double) ey0.e) / 2.0d)) + iAbs);
                }
                int i3 = z01Var.b;
                if0 if0Var2 = p;
                if (i3 < 5) {
                    int iK02 = (int) (if0Var2.K0(z01Var) * (ey0.d / 3.0f));
                    return new db(iK02, z01Var.a, str.equals("Left") ? (int) ((((((double) ey0.d) / 2.0d) - ((double) iK02)) / 4.0d) * ((double) (4 - z01Var.b))) : (ey0.d - iK02) - r0, ey0.e - z01Var.a);
                }
                return new db(z01Var.a, (int) (if0Var2.K0(z01Var) * ey0.a(200)), str.equals("Left") ? 0.0f : ey0.d - z01Var.a, ((int) (((double) ey0.e) / 2.0d)) + ((int) ((((((double) ey0.e) / 2.0d) - ((double) r11)) / 5.0d) * ((double) Math.abs(z01Var.b - 10)))));
        }
    }

    @Override // defpackage.lc1
    public final f91 n(String str) {
        switch (this.n) {
            case 0:
                return o(str, z01.a());
            default:
                return o(str, z01.b());
        }
    }

    @Override // defpackage.lc1
    public final db y(z01 z01Var) {
        switch (this.n) {
            case 0:
                return new db(ey0.e, (int) ((((double) ey0.d) / 8.0d) * ((double) (z01Var.e + 1))), 0.0f, 0.0f);
            default:
                return new db(ey0.d, (int) ((((double) ey0.e) / 8.0d) * ((double) (z01Var.e + 1))), 0.0f, 0.0f);
        }
    }
}
