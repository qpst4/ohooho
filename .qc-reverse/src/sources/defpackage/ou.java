package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ou {
    public static final LinkedHashSet p = new LinkedHashSet(Arrays.asList(mg.class, x70.class, m10.class, x80.class, m51.class, ah0.class, ab0.class));
    public static final Map q;
    public CharSequence a;
    public boolean d;
    public boolean h;
    public final List i;
    public final ow0 j;
    public final List k;
    public final nu l;
    public final ArrayList n;
    public final LinkedHashSet o;
    public int b = 0;
    public int c = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public final LinkedHashMap m = new LinkedHashMap();

    static {
        HashMap map = new HashMap();
        map.put(mg.class, new ng(0));
        map.put(x70.class, new ng(2));
        map.put(m10.class, new ng(1));
        map.put(x80.class, new ng(3));
        map.put(m51.class, new ng(6));
        map.put(ah0.class, new ng(5));
        map.put(ab0.class, new ng(4));
        q = Collections.unmodifiableMap(map);
    }

    public ou(ArrayList arrayList, ow0 ow0Var, ArrayList arrayList2) {
        ArrayList arrayList3 = new ArrayList();
        this.n = arrayList3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.o = linkedHashSet;
        this.i = arrayList;
        this.j = ow0Var;
        this.k = arrayList2;
        nu nuVar = new nu(0);
        this.l = nuVar;
        arrayList3.add(nuVar);
        linkedHashSet.add(nuVar);
    }

    public final void a(k kVar) {
        while (!h().b(kVar.d())) {
            e(h());
        }
        h().d().b(kVar.d());
        this.n.add(kVar);
        this.o.add(kVar);
    }

    public final void b(ep0 ep0Var) {
        ug0 ug0Var = ep0Var.b;
        ug0Var.a();
        ArrayList arrayList = ug0Var.c;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            tg0 tg0Var = (tg0) obj;
            dp0 dp0Var = ep0Var.a;
            tg0Var.f();
            vm0 vm0Var = dp0Var.d;
            tg0Var.d = vm0Var;
            if (vm0Var != null) {
                vm0Var.e = tg0Var;
            }
            tg0Var.e = dp0Var;
            dp0Var.d = tg0Var;
            vm0 vm0Var2 = dp0Var.a;
            tg0Var.a = vm0Var2;
            if (tg0Var.d == null) {
                vm0Var2.b = tg0Var;
            }
            String str = tg0Var.f;
            LinkedHashMap linkedHashMap = this.m;
            if (!linkedHashMap.containsKey(str)) {
                linkedHashMap.put(str, tg0Var);
            }
        }
    }

    public final void c() {
        CharSequence charSequenceSubSequence;
        if (this.d) {
            int i = this.b + 1;
            CharSequence charSequence = this.a;
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(i, charSequence.length());
            int i2 = 4 - (this.c % 4);
            StringBuilder sb = new StringBuilder(charSequenceSubSequence2.length() + i2);
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(' ');
            }
            sb.append(charSequenceSubSequence2);
            charSequenceSubSequence = sb.toString();
        } else {
            CharSequence charSequence2 = this.a;
            charSequenceSubSequence = charSequence2.subSequence(this.b, charSequence2.length());
        }
        h().a(charSequenceSubSequence);
    }

    public final void d() {
        char cCharAt = this.a.charAt(this.b);
        int i = this.b;
        if (cCharAt != '\t') {
            this.b = i + 1;
            this.c++;
        } else {
            this.b = i + 1;
            int i2 = this.c;
            this.c = (4 - (i2 % 4)) + i2;
        }
    }

    public final void e(k kVar) {
        if (h() == kVar) {
            this.n.remove(r0.size() - 1);
        }
        if (kVar instanceof ep0) {
            b((ep0) kVar);
        }
        kVar.c();
    }

    public final void f(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            e((k) list.get(size));
        }
    }

    public final void g() {
        int i = this.b;
        int i2 = this.c;
        this.h = true;
        int length = this.a.length();
        while (true) {
            if (i >= length) {
                break;
            }
            char cCharAt = this.a.charAt(i);
            if (cCharAt == '\t') {
                i++;
                i2 += 4 - (i2 % 4);
            } else if (cCharAt != ' ') {
                this.h = false;
                break;
            } else {
                i++;
                i2++;
            }
        }
        this.e = i;
        this.f = i2;
        this.g = i2 - this.c;
    }

    public final k h() {
        return (k) this.n.get(r1.size() - 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x01ca, code lost:
    
        if (r3 < 1) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01cc, code lost:
    
        r3 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01d2, code lost:
    
        if (r3 >= r13.length()) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01d4, code lost:
    
        r6 = r13.charAt(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01da, code lost:
    
        if (r6 == '\t') goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01de, code lost:
    
        if (r6 == ' ') goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01e1, code lost:
    
        r6 = r13.subSequence(r8, r15).toString();
        r14 = new defpackage.po0();
        r14.g = java.lang.Integer.parseInt(r6);
        r14.h = r5;
        r5 = new defpackage.bh0(r14, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x05ec, code lost:
    
        k(r22.e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c0, code lost:
    
        r21 = r6;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:107:0x01b7. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0328 A[PHI: r8 r21
  0x0328: PHI (r8v32 int) = (r8v6 int), (r8v6 int), (r8v6 int), (r8v33 int), (r8v34 int) binds: [B:301:0x0534, B:303:0x053a, B:305:0x0542, B:179:0x02fe, B:185:0x0327] A[DONT_GENERATE, DONT_INLINE]
  0x0328: PHI (r21v10 k) = (r21v5 k), (r21v5 k), (r21v5 k), (r21v11 k), (r21v11 k) binds: [B:301:0x0534, B:303:0x053a, B:305:0x0542, B:179:0x02fe, B:185:0x0327] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0187  */
    /* JADX WARN: Type inference failed for: r22v0, types: [ou] */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r4v66 */
    /* JADX WARN: Type inference failed for: r4v67 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.String r23) {
        /*
            Method dump skipped, instruction units count: 1616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ou.i(java.lang.String):void");
    }

    public final void j(int i) {
        int i2;
        int i3 = this.f;
        if (i >= i3) {
            this.b = this.e;
            this.c = i3;
        }
        int length = this.a.length();
        while (true) {
            i2 = this.c;
            if (i2 >= i || this.b == length) {
                break;
            } else {
                d();
            }
        }
        if (i2 <= i) {
            this.d = false;
            return;
        }
        this.b--;
        this.c = i;
        this.d = true;
    }

    public final void k(int i) {
        int i2 = this.e;
        if (i >= i2) {
            this.b = i2;
            this.c = this.f;
        }
        int length = this.a.length();
        while (true) {
            int i3 = this.b;
            if (i3 >= i || i3 == length) {
                break;
            } else {
                d();
            }
        }
        this.d = false;
    }
}
