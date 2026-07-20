package defpackage;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y70 extends k {
    public final /* synthetic */ int a;
    public final kg b;
    public final Serializable c;

    public y70() {
        this.a = 1;
        this.b = new ab0();
        this.c = new ArrayList();
    }

    @Override // defpackage.k
    public void a(CharSequence charSequence) {
        switch (this.a) {
            case 1:
                ((ArrayList) this.c).add(charSequence);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003f A[LOOP:2: B:20:0x003b->B:22:0x003f, LOOP_END] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
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
    @Override // defpackage.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() {
        /*
            r9 = this;
            int r0 = r9.a
            switch(r0) {
                case 1: goto L6;
                default: goto L5;
            }
        L5:
            return
        L6:
            java.io.Serializable r0 = r9.c
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r1 = r0.size()
            int r1 = r1 + (-1)
        L10:
            r2 = 0
            if (r1 < 0) goto L36
            java.lang.Object r3 = r0.get(r1)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r4 = r3.length()
            r5 = r2
        L1e:
            r6 = -1
            if (r5 >= r4) goto L30
            char r7 = r3.charAt(r5)
            r8 = 32
            if (r7 == r8) goto L2d
            switch(r7) {
                case 9: goto L2d;
                case 10: goto L2d;
                case 11: goto L2d;
                case 12: goto L2d;
                case 13: goto L2d;
                default: goto L2c;
            }
        L2c:
            goto L31
        L2d:
            int r5 = r5 + 1
            goto L1e
        L30:
            r5 = r6
        L31:
            if (r5 != r6) goto L36
            int r1 = r1 + (-1)
            goto L10
        L36:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L3b:
            int r4 = r1 + 1
            if (r2 >= r4) goto L50
            java.lang.Object r4 = r0.get(r2)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.append(r4)
            r4 = 10
            r3.append(r4)
            int r2 = r2 + 1
            goto L3b
        L50:
            java.lang.String r0 = r3.toString()
            kg r9 = r9.b
            ab0 r9 = (defpackage.ab0) r9
            r9.f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y70.c():void");
    }

    @Override // defpackage.k
    public final kg d() {
        int i = this.a;
        kg kgVar = this.b;
        switch (i) {
            case 0:
                return (x70) kgVar;
            default:
                return (ab0) kgVar;
        }
    }

    @Override // defpackage.k
    public void f(ob0 ob0Var) {
        switch (this.a) {
            case 0:
                ob0Var.f((String) this.c, (x70) this.b);
                break;
        }
    }

    @Override // defpackage.k
    public final lg g(ou ouVar) {
        switch (this.a) {
            case 0:
                return null;
            default:
                if (ouVar.g >= 4) {
                    return new lg(-1, ouVar.c + 4, false);
                }
                if (ouVar.h) {
                    return lg.a(ouVar.e);
                }
                return null;
        }
    }

    public y70(String str, int i) {
        this.a = 0;
        x70 x70Var = new x70();
        this.b = x70Var;
        x70Var.f = i;
        this.c = str;
    }
}
