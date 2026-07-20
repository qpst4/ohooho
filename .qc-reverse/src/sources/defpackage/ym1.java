package defpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ym1 implements Map, Serializable {
    public static final ym1 h = new ym1(null, new Object[0], 0);
    public transient vm1 b;
    public transient wm1 c;
    public transient xm1 d;
    public final transient Object e;
    public final transient Object[] f;
    public final transient int g;

    public ym1(Object obj, Object[] objArr, int i) {
        this.e = obj;
        this.f = objArr;
        this.g = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019e  */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.ym1 a(int r19, java.lang.Object[] r20, defpackage.f9 r21) {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ym1.a(int, java.lang.Object[], f9):ym1");
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        xm1 xm1Var = this.d;
        if (xm1Var == null) {
            xm1Var = new xm1(this.f, 1, this.g);
            this.d = xm1Var;
        }
        return xm1Var.contains(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        vm1 vm1Var = this.b;
        if (vm1Var != null) {
            return vm1Var;
        }
        vm1 vm1Var2 = new vm1(this, this.f, this.g);
        this.b = vm1Var2;
        return vm1Var2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x0038->B:22:0x004e], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0063->B:32:0x007a], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x0089->B:43:0x00a0]] */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L6
        L3:
            r8 = r0
            goto L9c
        L6:
            r1 = 1
            int r2 = r8.g
            java.lang.Object[] r3 = r8.f
            if (r2 != r1) goto L20
            r8 = 0
            r8 = r3[r8]
            java.util.Objects.requireNonNull(r8)
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L3
            r8 = r3[r1]
            java.util.Objects.requireNonNull(r8)
            goto L9c
        L20:
            java.lang.Object r8 = r8.e
            if (r8 != 0) goto L25
            goto L3
        L25:
            boolean r2 = r8 instanceof byte[]
            r4 = -1
            if (r2 == 0) goto L51
            r2 = r8
            byte[] r2 = (byte[]) r2
            int r8 = r2.length
            int r5 = r8 + (-1)
            int r8 = r9.hashCode()
            int r8 = defpackage.xr.R(r8)
        L38:
            r8 = r8 & r5
            r4 = r2[r8]
            r6 = 255(0xff, float:3.57E-43)
            r4 = r4 & r6
            if (r4 != r6) goto L41
            goto L3
        L41:
            r6 = r3[r4]
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L4e
            r8 = r4 ^ 1
            r8 = r3[r8]
            goto L9c
        L4e:
            int r8 = r8 + 1
            goto L38
        L51:
            boolean r2 = r8 instanceof short[]
            if (r2 == 0) goto L7d
            r2 = r8
            short[] r2 = (short[]) r2
            int r8 = r2.length
            int r5 = r8 + (-1)
            int r8 = r9.hashCode()
            int r8 = defpackage.xr.R(r8)
        L63:
            r8 = r8 & r5
            short r4 = r2[r8]
            char r4 = (char) r4
            r6 = 65535(0xffff, float:9.1834E-41)
            if (r4 != r6) goto L6d
            goto L3
        L6d:
            r6 = r3[r4]
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L7a
            r8 = r4 ^ 1
            r8 = r3[r8]
            goto L9c
        L7a:
            int r8 = r8 + 1
            goto L63
        L7d:
            int[] r8 = (int[]) r8
            int r2 = r8.length
            int r2 = r2 + r4
            int r5 = r9.hashCode()
            int r5 = defpackage.xr.R(r5)
        L89:
            r5 = r5 & r2
            r6 = r8[r5]
            if (r6 != r4) goto L90
            goto L3
        L90:
            r7 = r3[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto La0
            r8 = r6 ^ 1
            r8 = r3[r8]
        L9c:
            if (r8 != 0) goto L9f
            return r0
        L9f:
            return r8
        La0:
            int r5 = r5 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ym1.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        vm1 vm1Var = this.b;
        if (vm1Var == null) {
            vm1Var = new vm1(this, this.f, this.g);
            this.b = vm1Var;
        }
        Iterator it = vm1Var.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        wm1 wm1Var = this.c;
        if (wm1Var != null) {
            return wm1Var;
        }
        wm1 wm1Var2 = new wm1(this, new xm1(this.f, 0, this.g));
        this.c = wm1Var2;
        return wm1Var2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final int size() {
        return this.g;
    }

    public final String toString() {
        int i = this.g;
        fp1.J("size", i);
        StringBuilder sb = new StringBuilder((int) Math.min(((long) i) * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : (vm1) entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        xm1 xm1Var = this.d;
        if (xm1Var != null) {
            return xm1Var;
        }
        xm1 xm1Var2 = new xm1(this.f, 1, this.g);
        this.d = xm1Var2;
        return xm1Var2;
    }
}
