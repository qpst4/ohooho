package defpackage;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class yi0 {
    public final /* synthetic */ int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public final Object f;
    public final Object g;

    public yi0(int i) {
        this.a = 0;
        this.b = i;
        if (i <= 0) {
            zy.n("maxSize <= 0");
            throw null;
        }
        this.f = new tb0(4);
        this.g = new ix(21);
    }

    public void a() {
        View view = (View) ((ArrayList) this.f).get(r0.size() - 1);
        h21 h21Var = (h21) view.getLayoutParams();
        this.c = ((StaggeredGridLayoutManager) this.g).r.b(view);
        h21Var.getClass();
    }

    public void b() {
        ((ArrayList) this.f).clear();
        this.b = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
        this.d = 0;
    }

    public int c() {
        return ((StaggeredGridLayoutManager) this.g).w ? e(r1.size() - 1, -1) : e(0, ((ArrayList) this.f).size());
    }

    public int d() {
        return ((StaggeredGridLayoutManager) this.g).w ? e(0, ((ArrayList) this.f).size()) : e(r1.size() - 1, -1);
    }

    public int e(int i, int i2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        int iK = staggeredGridLayoutManager.r.k();
        int iG = staggeredGridLayoutManager.r.g();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View view = (View) ((ArrayList) this.f).get(i);
            int iE = staggeredGridLayoutManager.r.e(view);
            int iB = staggeredGridLayoutManager.r.b(view);
            boolean z = iE <= iG;
            boolean z2 = iB >= iK;
            if (z && z2 && (iE < iK || iB > iG)) {
                return zt0.L(view);
            }
            i += i3;
        }
        return -1;
    }

    public Object f(Object obj) {
        synchronized (((ix) this.g)) {
            tb0 tb0Var = (tb0) this.f;
            tb0Var.getClass();
            Object obj2 = ((LinkedHashMap) tb0Var.c).get(obj);
            if (obj2 != null) {
                this.d++;
                return obj2;
            }
            this.e++;
            return null;
        }
    }

    public int g(int i) {
        int i2 = this.c;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (((ArrayList) this.f).size() == 0) {
            return i;
        }
        a();
        return this.c;
    }

    public View h(int i, int i2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        ArrayList arrayList = (ArrayList) this.f;
        View view = null;
        if (i2 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.w && zt0.L(view2) >= i) || ((!staggeredGridLayoutManager.w && zt0.L(view2) <= i) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            View view3 = (View) arrayList.get(i3);
            if ((staggeredGridLayoutManager.w && zt0.L(view3) <= i) || ((!staggeredGridLayoutManager.w && zt0.L(view3) >= i) || !view3.hasFocusable())) {
                break;
            }
            i3++;
            view = view3;
        }
        return view;
    }

    public int i(int i) {
        ArrayList arrayList = (ArrayList) this.f;
        int i2 = this.b;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (arrayList.size() == 0) {
            return i;
        }
        View view = (View) arrayList.get(0);
        h21 h21Var = (h21) view.getLayoutParams();
        this.b = ((StaggeredGridLayoutManager) this.g).r.e(view);
        h21Var.getClass();
        return this.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b6, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00be, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.lang.Object r5, java.lang.Object r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.g
            ix r0 = (defpackage.ix) r0
            monitor-enter(r0)
            int r1 = r4.c     // Catch: java.lang.Throwable -> L20
            int r1 = r1 + 1
            r4.c = r1     // Catch: java.lang.Throwable -> L20
            java.lang.Object r1 = r4.f     // Catch: java.lang.Throwable -> L20
            tb0 r1 = (defpackage.tb0) r1     // Catch: java.lang.Throwable -> L20
            java.lang.Object r1 = r1.c     // Catch: java.lang.Throwable -> L20
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L20
            java.lang.Object r5 = r1.put(r5, r6)     // Catch: java.lang.Throwable -> L20
            if (r5 == 0) goto L23
            int r6 = r4.c     // Catch: java.lang.Throwable -> L20
            int r6 = r6 + (-1)
            r4.c = r6     // Catch: java.lang.Throwable -> L20
            goto L23
        L20:
            r4 = move-exception
            goto Lc1
        L23:
            monitor-exit(r0)
            int r6 = r4.b
        L26:
            java.lang.Object r0 = r4.g
            ix r0 = (defpackage.ix) r0
            monitor-enter(r0)
            int r1 = r4.c     // Catch: java.lang.Throwable -> L42
            if (r1 < 0) goto Lb7
            java.lang.Object r1 = r4.f     // Catch: java.lang.Throwable -> L42
            tb0 r1 = (defpackage.tb0) r1     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r1.c     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L42
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L45
            int r1 = r4.c     // Catch: java.lang.Throwable -> L42
            if (r1 != 0) goto Lb7
            goto L45
        L42:
            r4 = move-exception
            goto Lbf
        L45:
            int r1 = r4.c     // Catch: java.lang.Throwable -> L42
            if (r1 <= r6) goto Lb5
            java.lang.Object r1 = r4.f     // Catch: java.lang.Throwable -> L42
            tb0 r1 = (defpackage.tb0) r1     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r1.c     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L42
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L58
            goto Lb5
        L58:
            java.lang.Object r1 = r4.f     // Catch: java.lang.Throwable -> L42
            tb0 r1 = (defpackage.tb0) r1     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r1.c     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L42
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L42
            r1.getClass()     // Catch: java.lang.Throwable -> L42
            boolean r2 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L42
            r3 = 0
            if (r2 == 0) goto L7b
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L42
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L75
            goto L8a
        L75:
            r2 = 0
            java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Throwable -> L42
            goto L8a
        L7b:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L42
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L42
            if (r2 != 0) goto L86
            goto L8a
        L86:
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L42
        L8a:
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L42
            if (r3 != 0) goto L90
            monitor-exit(r0)
            return r5
        L90:
            java.lang.Object r1 = r3.getKey()     // Catch: java.lang.Throwable -> L42
            java.lang.Object r2 = r3.getValue()     // Catch: java.lang.Throwable -> L42
            java.lang.Object r3 = r4.f     // Catch: java.lang.Throwable -> L42
            tb0 r3 = (defpackage.tb0) r3     // Catch: java.lang.Throwable -> L42
            r3.getClass()     // Catch: java.lang.Throwable -> L42
            r1.getClass()     // Catch: java.lang.Throwable -> L42
            java.lang.Object r3 = r3.c     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r3 = (java.util.LinkedHashMap) r3     // Catch: java.lang.Throwable -> L42
            r3.remove(r1)     // Catch: java.lang.Throwable -> L42
            int r1 = r4.c     // Catch: java.lang.Throwable -> L42
            r2.getClass()     // Catch: java.lang.Throwable -> L42
            int r1 = r1 + (-1)
            r4.c = r1     // Catch: java.lang.Throwable -> L42
            monitor-exit(r0)
            goto L26
        Lb5:
            monitor-exit(r0)
            return r5
        Lb7:
            java.lang.String r4 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L42
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L42
            throw r5     // Catch: java.lang.Throwable -> L42
        Lbf:
            monitor-exit(r0)
            throw r4
        Lc1:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yi0.j(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public String toString() {
        String str;
        switch (this.a) {
            case 0:
                synchronized (((ix) this.g)) {
                    try {
                        int i = this.d;
                        int i2 = this.e + i;
                        str = "LruCache[maxSize=" + this.b + ",hits=" + this.d + ",misses=" + this.e + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            default:
                return super.toString();
        }
    }

    public yi0(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.a = 1;
        this.g = staggeredGridLayoutManager;
        this.f = new ArrayList();
        this.b = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
        this.d = 0;
        this.e = i;
    }
}
