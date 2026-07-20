package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ix0 implements Iterable {
    public fx0 b;
    public fx0 c;
    public final WeakHashMap d = new WeakHashMap();
    public int e = 0;

    public fx0 b(Object obj) {
        fx0 fx0Var = this.b;
        while (fx0Var != null && !fx0Var.b.equals(obj)) {
            fx0Var = fx0Var.d;
        }
        return fx0Var;
    }

    public Object c(Object obj) {
        fx0 fx0VarB = b(obj);
        if (fx0VarB == null) {
            return null;
        }
        this.e--;
        WeakHashMap weakHashMap = this.d;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((hx0) it.next()).a(fx0VarB);
            }
        }
        fx0 fx0Var = fx0VarB.e;
        fx0 fx0Var2 = fx0VarB.d;
        if (fx0Var != null) {
            fx0Var.d = fx0Var2;
        } else {
            this.b = fx0Var2;
        }
        fx0 fx0Var3 = fx0VarB.d;
        if (fx0Var3 != null) {
            fx0Var3.e = fx0Var;
        } else {
            this.c = fx0Var;
        }
        fx0VarB.d = null;
        fx0VarB.e = null;
        return fx0VarB.c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r1.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((defpackage.ex0) r6).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof defpackage.ix0
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            ix0 r6 = (defpackage.ix0) r6
            int r1 = r5.e
            int r3 = r6.e
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r5 = r5.iterator()
            java.util.Iterator r6 = r6.iterator()
        L1b:
            r1 = r5
            ex0 r1 = (defpackage.ex0) r1
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L44
            r3 = r6
            ex0 r3 = (defpackage.ex0) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            java.lang.Object r1 = r1.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r3.next()
            if (r1 != 0) goto L3b
            if (r3 != 0) goto L43
        L3b:
            if (r1 == 0) goto L1b
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r5 = r1.hasNext()
            if (r5 != 0) goto L53
            ex0 r6 = (defpackage.ex0) r6
            boolean r5 = r6.hasNext()
            if (r5 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ix0.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            ex0 ex0Var = (ex0) it;
            if (!ex0Var.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) ex0Var.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        ex0 ex0Var = new ex0(this.b, this.c, 0);
        this.d.put(ex0Var, Boolean.FALSE);
        return ex0Var;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            ex0 ex0Var = (ex0) it;
            if (!ex0Var.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) ex0Var.next()).toString());
            if (ex0Var.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
