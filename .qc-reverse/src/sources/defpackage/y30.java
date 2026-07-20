package defpackage;

import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.a;
import androidx.fragment.app.FragmentContainerView;
import com.quickcursor.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y30 {
    public k4 A;
    public k4 B;
    public ArrayDeque C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public ArrayList I;
    public ArrayList J;
    public ArrayList K;
    public a40 L;
    public final nc M;
    public boolean b;
    public ArrayList d;
    public ArrayList e;
    public a g;
    public final i9 l;
    public final CopyOnWriteArrayList m;
    public final p30 n;
    public final p30 o;
    public final p30 p;
    public final p30 q;
    public final s30 r;
    public int s;
    public l30 t;
    public f01 u;
    public j30 v;
    public j30 w;
    public final t30 x;
    public final ix y;
    public k4 z;
    public final ArrayList a = new ArrayList();
    public final g7 c = new g7(5);
    public final o30 f = new o30(this);
    public final r30 h = new r30(this);
    public final AtomicInteger i = new AtomicInteger();
    public final Map j = Collections.synchronizedMap(new HashMap());
    public final Map k = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Type inference failed for: r0v12, types: [p30] */
    /* JADX WARN: Type inference failed for: r0v13, types: [p30] */
    /* JADX WARN: Type inference failed for: r0v14, types: [p30] */
    /* JADX WARN: Type inference failed for: r0v15, types: [p30] */
    public y30() {
        Collections.synchronizedMap(new HashMap());
        this.l = new i9(this);
        this.m = new CopyOnWriteArrayList();
        final int i = 0;
        this.n = new ao(this) { // from class: p30
            public final /* synthetic */ y30 b;

            {
                this.b = this;
            }

            @Override // defpackage.ao
            public final void accept(Object obj) {
                int i2 = i;
                y30 y30Var = this.b;
                switch (i2) {
                    case 0:
                        if (y30Var.K()) {
                            y30Var.h(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (y30Var.K() && num.intValue() == 80) {
                            y30Var.m(false);
                            break;
                        }
                        break;
                    case 2:
                        im0 im0Var = (im0) obj;
                        if (y30Var.K()) {
                            boolean z = im0Var.a;
                            y30Var.n(false);
                        }
                        break;
                    default:
                        pp0 pp0Var = (pp0) obj;
                        if (y30Var.K()) {
                            boolean z2 = pp0Var.a;
                            y30Var.s(false);
                        }
                        break;
                }
            }
        };
        final int i2 = 1;
        this.o = new ao(this) { // from class: p30
            public final /* synthetic */ y30 b;

            {
                this.b = this;
            }

            @Override // defpackage.ao
            public final void accept(Object obj) {
                int i22 = i2;
                y30 y30Var = this.b;
                switch (i22) {
                    case 0:
                        if (y30Var.K()) {
                            y30Var.h(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (y30Var.K() && num.intValue() == 80) {
                            y30Var.m(false);
                            break;
                        }
                        break;
                    case 2:
                        im0 im0Var = (im0) obj;
                        if (y30Var.K()) {
                            boolean z = im0Var.a;
                            y30Var.n(false);
                        }
                        break;
                    default:
                        pp0 pp0Var = (pp0) obj;
                        if (y30Var.K()) {
                            boolean z2 = pp0Var.a;
                            y30Var.s(false);
                        }
                        break;
                }
            }
        };
        final int i3 = 2;
        this.p = new ao(this) { // from class: p30
            public final /* synthetic */ y30 b;

            {
                this.b = this;
            }

            @Override // defpackage.ao
            public final void accept(Object obj) {
                int i22 = i3;
                y30 y30Var = this.b;
                switch (i22) {
                    case 0:
                        if (y30Var.K()) {
                            y30Var.h(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (y30Var.K() && num.intValue() == 80) {
                            y30Var.m(false);
                            break;
                        }
                        break;
                    case 2:
                        im0 im0Var = (im0) obj;
                        if (y30Var.K()) {
                            boolean z = im0Var.a;
                            y30Var.n(false);
                        }
                        break;
                    default:
                        pp0 pp0Var = (pp0) obj;
                        if (y30Var.K()) {
                            boolean z2 = pp0Var.a;
                            y30Var.s(false);
                        }
                        break;
                }
            }
        };
        final int i4 = 3;
        this.q = new ao(this) { // from class: p30
            public final /* synthetic */ y30 b;

            {
                this.b = this;
            }

            @Override // defpackage.ao
            public final void accept(Object obj) {
                int i22 = i4;
                y30 y30Var = this.b;
                switch (i22) {
                    case 0:
                        if (y30Var.K()) {
                            y30Var.h(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (y30Var.K() && num.intValue() == 80) {
                            y30Var.m(false);
                            break;
                        }
                        break;
                    case 2:
                        im0 im0Var = (im0) obj;
                        if (y30Var.K()) {
                            boolean z = im0Var.a;
                            y30Var.n(false);
                        }
                        break;
                    default:
                        pp0 pp0Var = (pp0) obj;
                        if (y30Var.K()) {
                            boolean z2 = pp0Var.a;
                            y30Var.s(false);
                        }
                        break;
                }
            }
        };
        this.r = new s30(this);
        this.s = -1;
        this.x = new t30(this);
        this.y = new ix(18);
        this.C = new ArrayDeque();
        this.M = new nc(8, this);
    }

    public static boolean I(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean J(j30 j30Var) {
        j30Var.getClass();
        ArrayList arrayListL = j30Var.v.c.l();
        int size = arrayListL.size();
        boolean zJ = false;
        int i = 0;
        while (i < size) {
            Object obj = arrayListL.get(i);
            i++;
            j30 j30Var2 = (j30) obj;
            if (j30Var2 != null) {
                zJ = J(j30Var2);
            }
            if (zJ) {
                return true;
            }
        }
        return false;
    }

    public static boolean L(j30 j30Var) {
        if (j30Var == null) {
            return true;
        }
        if (j30Var.E) {
            return j30Var.t == null || L(j30Var.w);
        }
        return false;
    }

    public static boolean M(j30 j30Var) {
        if (j30Var == null) {
            return true;
        }
        y30 y30Var = j30Var.t;
        return j30Var == y30Var.w && M(y30Var.v);
    }

    public static void b0(j30 j30Var) {
        if (I(2)) {
            Log.v("FragmentManager", "show: " + j30Var);
        }
        if (j30Var.A) {
            j30Var.A = false;
            j30Var.L = !j30Var.L;
        }
    }

    public final void A(ld ldVar, boolean z) {
        if (z && (this.t == null || this.G)) {
            return;
        }
        y(z);
        ldVar.a(this.I, this.J);
        this.b = true;
        try {
            T(this.I, this.J);
            d();
            e0();
            v();
            ((HashMap) this.c.d).values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0232 A[PHI: r14
  0x0232: PHI (r14v19 int) = (r14v18 int), (r14v20 int) binds: [B:103:0x0222, B:108:0x022e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(java.util.ArrayList r24, java.util.ArrayList r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 1256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y30.B(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final j30 C(int i) {
        g7 g7Var = this.c;
        ArrayList arrayList = (ArrayList) g7Var.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            j30 j30Var = (j30) arrayList.get(size);
            if (j30Var != null && j30Var.x == i) {
                return j30Var;
            }
        }
        for (androidx.fragment.app.a aVar : ((HashMap) g7Var.d).values()) {
            if (aVar != null) {
                j30 j30Var2 = aVar.c;
                if (j30Var2.x == i) {
                    return j30Var2;
                }
            }
        }
        return null;
    }

    public final j30 D(String str) {
        g7 g7Var = this.c;
        ArrayList arrayList = (ArrayList) g7Var.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            j30 j30Var = (j30) arrayList.get(size);
            if (j30Var != null && str.equals(j30Var.z)) {
                return j30Var;
            }
        }
        for (androidx.fragment.app.a aVar : ((HashMap) g7Var.d).values()) {
            if (aVar != null) {
                j30 j30Var2 = aVar.c;
                if (str.equals(j30Var2.z)) {
                    return j30Var2;
                }
            }
        }
        return null;
    }

    public final ViewGroup E(j30 j30Var) {
        ViewGroup viewGroup = j30Var.G;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (j30Var.y <= 0 || !this.u.G()) {
            return null;
        }
        View viewF = this.u.F(j30Var.y);
        if (viewF instanceof ViewGroup) {
            return (ViewGroup) viewF;
        }
        return null;
    }

    public final t30 F() {
        j30 j30Var = this.v;
        return j30Var != null ? j30Var.t.F() : this.x;
    }

    public final ix G() {
        j30 j30Var = this.v;
        return j30Var != null ? j30Var.t.G() : this.y;
    }

    public final void H(j30 j30Var) {
        if (I(2)) {
            Log.v("FragmentManager", "hide: " + j30Var);
        }
        if (j30Var.A) {
            return;
        }
        j30Var.A = true;
        j30Var.L = true ^ j30Var.L;
        a0(j30Var);
    }

    public final boolean K() {
        j30 j30Var = this.v;
        if (j30Var == null) {
            return true;
        }
        return j30Var.D() && this.v.x().K();
    }

    public final void N(int i, boolean z) {
        l30 l30Var;
        if (this.t == null && i != -1) {
            s1.f("No activity");
            return;
        }
        if (z || i != this.s) {
            this.s = i;
            g7 g7Var = this.c;
            HashMap map = (HashMap) g7Var.d;
            ArrayList arrayList = (ArrayList) g7Var.c;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                androidx.fragment.app.a aVar = (androidx.fragment.app.a) map.get(((j30) obj).g);
                if (aVar != null) {
                    aVar.k();
                }
            }
            for (androidx.fragment.app.a aVar2 : map.values()) {
                if (aVar2 != null) {
                    aVar2.k();
                    j30 j30Var = aVar2.c;
                    if (j30Var.n && !j30Var.F()) {
                        g7Var.q(aVar2);
                    }
                }
            }
            c0();
            if (this.D && (l30Var = this.t) != null && this.s == 7) {
                l30Var.q.invalidateOptionsMenu();
                this.D = false;
            }
        }
    }

    public final void O() {
        if (this.t == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.L.h = false;
        for (j30 j30Var : this.c.m()) {
            if (j30Var != null) {
                j30Var.v.O();
            }
        }
    }

    public final boolean P() {
        return Q(-1, 0);
    }

    public final boolean Q(int i, int i2) {
        z(false);
        y(true);
        j30 j30Var = this.w;
        if (j30Var != null && i < 0 && j30Var.l().P()) {
            return true;
        }
        boolean zR = R(this.I, this.J, null, i, i2);
        if (zR) {
            this.b = true;
            try {
                T(this.I, this.J);
            } finally {
                d();
            }
        }
        e0();
        v();
        ((HashMap) this.c.d).values().removeAll(Collections.singleton(null));
        return zR;
    }

    public final boolean R(ArrayList arrayList, ArrayList arrayList2, String str, int i, int i2) {
        boolean z = (i2 & 1) != 0;
        ArrayList arrayList3 = this.d;
        int size = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (str != null || i >= 0) {
                int size2 = this.d.size() - 1;
                while (size2 >= 0) {
                    ld ldVar = (ld) this.d.get(size2);
                    if ((str != null && str.equals(ldVar.i)) || (i >= 0 && i == ldVar.s)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    size = size2;
                } else if (z) {
                    size = size2;
                    while (size > 0) {
                        ld ldVar2 = (ld) this.d.get(size - 1);
                        if ((str == null || !str.equals(ldVar2.i)) && (i < 0 || i != ldVar2.s)) {
                            break;
                        }
                        size--;
                    }
                } else if (size2 != this.d.size() - 1) {
                    size = size2 + 1;
                }
            } else {
                size = z ? 0 : this.d.size() - 1;
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.d.size() - 1; size3 >= size; size3--) {
            arrayList.add((ld) this.d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void S(j30 j30Var) {
        if (I(2)) {
            Log.v("FragmentManager", "remove: " + j30Var + " nesting=" + j30Var.s);
        }
        boolean zF = j30Var.F();
        if (j30Var.B && zF) {
            return;
        }
        g7 g7Var = this.c;
        synchronized (((ArrayList) g7Var.c)) {
            ((ArrayList) g7Var.c).remove(j30Var);
        }
        j30Var.m = false;
        if (J(j30Var)) {
            this.D = true;
        }
        j30Var.n = true;
        a0(j30Var);
    }

    public final void T(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            s1.f("Internal error with the back stack records");
            return;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((ld) arrayList.get(i)).p) {
                if (i2 != i) {
                    B(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((ld) arrayList.get(i2)).p) {
                        i2++;
                    }
                }
                B(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            B(arrayList, arrayList2, i2, size);
        }
    }

    public final void U(Parcelable parcelable) {
        i9 i9Var;
        int i;
        boolean z;
        int i2;
        androidx.fragment.app.a aVar;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.t.n.getClassLoader());
                this.k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.t.n.getClassLoader());
                arrayList.add((e40) bundle.getParcelable("state"));
            }
        }
        g7 g7Var = this.c;
        HashMap map = (HashMap) g7Var.b;
        HashMap map2 = (HashMap) g7Var.d;
        map.clear();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            e40 e40Var = (e40) obj;
            map.put(e40Var.c, e40Var);
        }
        z30 z30Var = (z30) bundle3.getParcelable("state");
        if (z30Var == null) {
            return;
        }
        map2.clear();
        ArrayList arrayList2 = z30Var.b;
        int size2 = arrayList2.size();
        int i4 = 0;
        while (true) {
            i9Var = this.l;
            i = 2;
            if (i4 >= size2) {
                break;
            }
            Object obj2 = arrayList2.get(i4);
            i4++;
            e40 e40Var2 = (e40) ((HashMap) g7Var.b).remove((String) obj2);
            if (e40Var2 != null) {
                j30 j30Var = (j30) this.L.c.get(e40Var2.c);
                if (j30Var != null) {
                    if (I(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + j30Var);
                    }
                    aVar = new androidx.fragment.app.a(i9Var, g7Var, j30Var, e40Var2);
                } else {
                    aVar = new androidx.fragment.app.a(this.l, this.c, this.t.n.getClassLoader(), F(), e40Var2);
                }
                j30 j30Var2 = aVar.c;
                j30Var2.t = this;
                if (I(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + j30Var2.g + "): " + j30Var2);
                }
                aVar.m(this.t.n.getClassLoader());
                g7Var.p(aVar);
                aVar.e = this.s;
            }
        }
        a40 a40Var = this.L;
        a40Var.getClass();
        ArrayList arrayList3 = new ArrayList(a40Var.c.values());
        int size3 = arrayList3.size();
        int i5 = 0;
        while (true) {
            z = true;
            if (i5 >= size3) {
                break;
            }
            Object obj3 = arrayList3.get(i5);
            i5++;
            j30 j30Var3 = (j30) obj3;
            if (map2.get(j30Var3.g) == null) {
                if (I(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + j30Var3 + " that was not found in the set of active Fragments " + z30Var.b);
                }
                this.L.f(j30Var3);
                j30Var3.t = this;
                androidx.fragment.app.a aVar2 = new androidx.fragment.app.a(i9Var, g7Var, j30Var3);
                aVar2.e = 1;
                aVar2.k();
                j30Var3.n = true;
                aVar2.k();
            }
        }
        ArrayList arrayList4 = z30Var.c;
        ((ArrayList) g7Var.c).clear();
        if (arrayList4 != null) {
            int size4 = arrayList4.size();
            int i6 = 0;
            while (i6 < size4) {
                Object obj4 = arrayList4.get(i6);
                i6++;
                String str3 = (String) obj4;
                j30 j30VarG = g7Var.g(str3);
                if (j30VarG == null) {
                    s1.f(l11.j("No instantiated fragment for (", str3, ")"));
                    return;
                }
                if (I(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + j30VarG);
                }
                g7Var.a(j30VarG);
            }
        }
        if (z30Var.d != null) {
            this.d = new ArrayList(z30Var.d.length);
            int i7 = 0;
            while (true) {
                md[] mdVarArr = z30Var.d;
                if (i7 >= mdVarArr.length) {
                    break;
                }
                md mdVar = mdVarArr[i7];
                ArrayList arrayList5 = mdVar.c;
                ld ldVar = new ld(this);
                int[] iArr = mdVar.b;
                int i8 = 0;
                int i9 = 0;
                while (i8 < iArr.length) {
                    h40 h40Var = new h40();
                    int i10 = i8 + 1;
                    int i11 = i;
                    h40Var.a = iArr[i8];
                    if (I(i11)) {
                        Log.v("FragmentManager", "Instantiate " + ldVar + " op #" + i9 + " base fragment #" + iArr[i10]);
                    }
                    h40Var.h = zf0.values()[mdVar.d[i9]];
                    h40Var.i = zf0.values()[mdVar.e[i9]];
                    int i12 = i8 + 2;
                    h40Var.c = iArr[i10] != 0 ? z : false;
                    int i13 = iArr[i12];
                    h40Var.d = i13;
                    int i14 = iArr[i8 + 3];
                    h40Var.e = i14;
                    int i15 = i8 + 5;
                    int i16 = iArr[i8 + 4];
                    h40Var.f = i16;
                    i8 += 6;
                    int[] iArr2 = iArr;
                    int i17 = iArr2[i15];
                    h40Var.g = i17;
                    ldVar.b = i13;
                    ldVar.c = i14;
                    ldVar.d = i16;
                    ldVar.e = i17;
                    ldVar.b(h40Var);
                    i9++;
                    i = i11;
                    iArr = iArr2;
                    z = true;
                }
                int i18 = i;
                ldVar.f = mdVar.f;
                ldVar.i = mdVar.g;
                ldVar.g = true;
                ldVar.j = mdVar.i;
                ldVar.k = mdVar.j;
                ldVar.l = mdVar.k;
                ldVar.m = mdVar.l;
                ldVar.n = mdVar.m;
                ldVar.o = mdVar.n;
                ldVar.p = mdVar.o;
                ldVar.s = mdVar.h;
                for (int i19 = 0; i19 < arrayList5.size(); i19++) {
                    String str4 = (String) arrayList5.get(i19);
                    if (str4 != null) {
                        ((h40) ldVar.a.get(i19)).b = g7Var.g(str4);
                    }
                }
                ldVar.d(1);
                if (I(i18)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i7 + " (index " + ldVar.s + "): " + ldVar);
                    PrintWriter printWriter = new PrintWriter(new ui0());
                    ldVar.h("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(ldVar);
                i7++;
                i = i18;
                z = true;
            }
            i2 = 0;
        } else {
            i2 = 0;
            this.d = null;
        }
        this.i.set(z30Var.e);
        String str5 = z30Var.f;
        if (str5 != null) {
            j30 j30VarG2 = g7Var.g(str5);
            this.w = j30VarG2;
            r(j30VarG2);
        }
        ArrayList arrayList6 = z30Var.g;
        if (arrayList6 != null) {
            while (i2 < arrayList6.size()) {
                this.j.put((String) arrayList6.get(i2), (nd) z30Var.h.get(i2));
                i2++;
            }
        }
        this.C = new ArrayDeque(z30Var.i);
    }

    public final Bundle V() {
        int i;
        ArrayList arrayList;
        md[] mdVarArr;
        int size;
        Bundle bundle = new Bundle();
        Iterator it = e().iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            xs xsVar = (xs) it.next();
            if (xsVar.e) {
                if (I(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                xsVar.e = false;
                xsVar.c();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((xs) it2.next()).e();
        }
        z(true);
        this.E = true;
        this.L.h = true;
        g7 g7Var = this.c;
        g7Var.getClass();
        HashMap map = (HashMap) g7Var.d;
        ArrayList arrayList2 = new ArrayList(map.size());
        Iterator it3 = map.values().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) it3.next();
            if (aVar != null) {
                j30 j30Var = aVar.c;
                e40 e40Var = new e40(j30Var);
                if (j30Var.b <= -1 || e40Var.n != null) {
                    e40Var.n = j30Var.c;
                } else {
                    Bundle bundle2 = new Bundle();
                    j30Var.S(bundle2);
                    j30Var.T.d(bundle2);
                    bundle2.putParcelable("android:support:fragments", j30Var.v.V());
                    aVar.a.r(false);
                    Bundle bundle3 = bundle2.isEmpty() ? null : bundle2;
                    if (j30Var.H != null) {
                        aVar.o();
                    }
                    if (j30Var.d != null) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putSparseParcelableArray("android:view_state", j30Var.d);
                    }
                    if (j30Var.e != null) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putBundle("android:view_registry_state", j30Var.e);
                    }
                    if (!j30Var.J) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putBoolean("android:user_visible_hint", j30Var.J);
                    }
                    e40Var.n = bundle3;
                    if (j30Var.j != null) {
                        if (bundle3 == null) {
                            e40Var.n = new Bundle();
                        }
                        e40Var.n.putString("android:target_state", j30Var.j);
                        int i2 = j30Var.k;
                        if (i2 != 0) {
                            e40Var.n.putInt("android:target_req_state", i2);
                        }
                    }
                }
                arrayList2.add(j30Var.g);
                if (I(2)) {
                    Log.v("FragmentManager", "Saved state of " + j30Var + ": " + j30Var.c);
                }
            }
        }
        g7 g7Var2 = this.c;
        g7Var2.getClass();
        ArrayList arrayList3 = new ArrayList(((HashMap) g7Var2.b).values());
        if (!arrayList3.isEmpty()) {
            g7 g7Var3 = this.c;
            synchronized (((ArrayList) g7Var3.c)) {
                try {
                    if (((ArrayList) g7Var3.c).isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(((ArrayList) g7Var3.c).size());
                        ArrayList arrayList4 = (ArrayList) g7Var3.c;
                        int size2 = arrayList4.size();
                        int i3 = 0;
                        while (i3 < size2) {
                            Object obj = arrayList4.get(i3);
                            i3++;
                            j30 j30Var2 = (j30) obj;
                            arrayList.add(j30Var2.g);
                            if (I(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + j30Var2.g + "): " + j30Var2);
                            }
                        }
                    }
                } finally {
                }
            }
            ArrayList arrayList5 = this.d;
            if (arrayList5 == null || (size = arrayList5.size()) <= 0) {
                mdVarArr = null;
            } else {
                mdVarArr = new md[size];
                for (int i4 = 0; i4 < size; i4++) {
                    mdVarArr[i4] = new md((ld) this.d.get(i4));
                    if (I(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i4 + ": " + this.d.get(i4));
                    }
                }
            }
            z30 z30Var = new z30();
            z30Var.f = null;
            ArrayList arrayList6 = new ArrayList();
            z30Var.g = arrayList6;
            ArrayList arrayList7 = new ArrayList();
            z30Var.h = arrayList7;
            z30Var.b = arrayList2;
            z30Var.c = arrayList;
            z30Var.d = mdVarArr;
            z30Var.e = this.i.get();
            j30 j30Var3 = this.w;
            if (j30Var3 != null) {
                z30Var.f = j30Var3.g;
            }
            arrayList6.addAll(this.j.keySet());
            arrayList7.addAll(this.j.values());
            z30Var.i = new ArrayList(this.C);
            bundle.putParcelable("state", z30Var);
            for (String str : this.k.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.k.get(str));
            }
            int size3 = arrayList3.size();
            while (i < size3) {
                Object obj2 = arrayList3.get(i);
                i++;
                e40 e40Var2 = (e40) obj2;
                Bundle bundle4 = new Bundle();
                bundle4.putParcelable("state", e40Var2);
                bundle.putBundle("fragment_" + e40Var2.c, bundle4);
            }
        } else if (I(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final void W() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.t.o.removeCallbacks(this.M);
                    this.t.o.post(this.M);
                    e0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void X(j30 j30Var, boolean z) {
        ViewGroup viewGroupE = E(j30Var);
        if (viewGroupE == null || !(viewGroupE instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupE).setDrawDisappearingViewsLast(!z);
    }

    public final void Y(j30 j30Var, zf0 zf0Var) {
        if (j30Var == this.c.g(j30Var.g) && (j30Var.u == null || j30Var.t == this)) {
            j30Var.P = zf0Var;
        } else {
            zy.i("Fragment ", j30Var, " is not an active fragment of FragmentManager ", this);
        }
    }

    public final void Z(j30 j30Var) {
        if (j30Var != null) {
            if (j30Var != this.c.g(j30Var.g) || (j30Var.u != null && j30Var.t != this)) {
                zy.i("Fragment ", j30Var, " is not an active fragment of FragmentManager ", this);
                return;
            }
        }
        j30 j30Var2 = this.w;
        this.w = j30Var;
        r(j30Var2);
        r(this.w);
    }

    public final androidx.fragment.app.a a(j30 j30Var) {
        String str = j30Var.O;
        if (str != null) {
            g40.c(j30Var, str);
        }
        if (I(2)) {
            Log.v("FragmentManager", "add: " + j30Var);
        }
        androidx.fragment.app.a aVarF = f(j30Var);
        j30Var.t = this;
        g7 g7Var = this.c;
        g7Var.p(aVarF);
        if (!j30Var.B) {
            g7Var.a(j30Var);
            j30Var.n = false;
            if (j30Var.H == null) {
                j30Var.L = false;
            }
            if (J(j30Var)) {
                this.D = true;
            }
        }
        return aVarF;
    }

    public final void a0(j30 j30Var) {
        ViewGroup viewGroupE = E(j30Var);
        if (viewGroupE != null) {
            h30 h30Var = j30Var.K;
            if ((h30Var == null ? 0 : h30Var.e) + (h30Var == null ? 0 : h30Var.d) + (h30Var == null ? 0 : h30Var.c) + (h30Var == null ? 0 : h30Var.b) > 0) {
                if (viewGroupE.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    viewGroupE.setTag(R.id.visible_removing_fragment_view_tag, j30Var);
                }
                j30 j30Var2 = (j30) viewGroupE.getTag(R.id.visible_removing_fragment_view_tag);
                h30 h30Var2 = j30Var.K;
                boolean z = h30Var2 != null ? h30Var2.a : false;
                if (j30Var2.K == null) {
                    return;
                }
                j30Var2.s().a = z;
            }
        }
    }

    public final void b(l30 l30Var, f01 f01Var, j30 j30Var) {
        if (this.t != null) {
            s1.f("Already attached");
            return;
        }
        this.t = l30Var;
        this.u = f01Var;
        this.v = j30Var;
        CopyOnWriteArrayList copyOnWriteArrayList = this.m;
        if (j30Var != null) {
            copyOnWriteArrayList.add(new u30(j30Var));
        } else if (l30Var != null) {
            copyOnWriteArrayList.add(l30Var);
        }
        if (this.v != null) {
            e0();
        }
        if (l30Var != null) {
            a aVarR = l30Var.q.r();
            this.g = aVarR;
            aVarR.a(j30Var != null ? j30Var : l30Var, this.h);
        }
        int i = 0;
        if (j30Var != null) {
            a40 a40Var = j30Var.t.L;
            HashMap map = a40Var.d;
            a40 a40Var2 = (a40) map.get(j30Var.g);
            if (a40Var2 == null) {
                a40Var2 = new a40(a40Var.f);
                map.put(j30Var.g, a40Var2);
            }
            this.L = a40Var2;
        } else if (l30Var != null) {
            ra raVar = new ra(l30Var.q.m(), a40.i, sp.b);
            String canonicalName = a40.class.getCanonicalName();
            if (canonicalName == null) {
                zy.n("Local and anonymous classes can not be ViewModels");
                return;
            }
            this.L = (a40) raVar.u(a40.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        } else {
            this.L = new a40(false);
        }
        a40 a40Var3 = this.L;
        int i2 = 1;
        a40Var3.h = this.E || this.F;
        this.c.e = a40Var3;
        l30 l30Var2 = this.t;
        int i3 = 2;
        if (l30Var2 != null && j30Var == null) {
            e8 e8VarC = l30Var2.c();
            e8VarC.e("android:support:fragments", new fm(i3, this));
            Bundle bundleC = e8VarC.c("android:support:fragments");
            if (bundleC != null) {
                U(bundleC);
            }
        }
        l30 l30Var3 = this.t;
        if (l30Var3 != null) {
            mm mmVar = l30Var3.q.j;
            String strConcat = "FragmentManager:".concat(j30Var != null ? l11.k(new StringBuilder(), j30Var.g, ":") : "");
            this.z = mmVar.d(strConcat.concat("StartActivityForResult"), new f4(i3), new q30(this, i2));
            this.A = mmVar.d(strConcat.concat("StartIntentSenderForResult"), new f4(5), new q30(this, i3));
            this.B = mmVar.d(strConcat.concat("RequestPermissions"), new f4(i2), new q30(this, i));
        }
        l30 l30Var4 = this.t;
        if (l30Var4 != null) {
            z7 z7Var = l30Var4.q;
            p30 p30Var = this.n;
            p30Var.getClass();
            z7Var.k.add(p30Var);
        }
        l30 l30Var5 = this.t;
        if (l30Var5 != null) {
            z7 z7Var2 = l30Var5.q;
            p30 p30Var2 = this.o;
            p30Var2.getClass();
            z7Var2.l.add(p30Var2);
        }
        l30 l30Var6 = this.t;
        if (l30Var6 != null) {
            z7 z7Var3 = l30Var6.q;
            p30 p30Var3 = this.p;
            p30Var3.getClass();
            z7Var3.n.add(p30Var3);
        }
        l30 l30Var7 = this.t;
        if (l30Var7 != null) {
            z7 z7Var4 = l30Var7.q;
            p30 p30Var4 = this.q;
            p30Var4.getClass();
            z7Var4.o.add(p30Var4);
        }
        l30 l30Var8 = this.t;
        if (l30Var8 == null || j30Var != null) {
            return;
        }
        z7 z7Var5 = l30Var8.q;
        s30 s30Var = this.r;
        s30Var.getClass();
        ra raVar2 = z7Var5.d;
        ((CopyOnWriteArrayList) raVar2.e).add(s30Var);
        ((Runnable) raVar2.d).run();
    }

    public final void c(j30 j30Var) {
        if (I(2)) {
            Log.v("FragmentManager", "attach: " + j30Var);
        }
        if (j30Var.B) {
            j30Var.B = false;
            if (j30Var.m) {
                return;
            }
            this.c.a(j30Var);
            if (I(2)) {
                Log.v("FragmentManager", "add from attach: " + j30Var);
            }
            if (J(j30Var)) {
                this.D = true;
            }
        }
    }

    public final void c0() {
        ArrayList arrayListK = this.c.k();
        int size = arrayListK.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListK.get(i);
            i++;
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) obj;
            j30 j30Var = aVar.c;
            if (j30Var.I) {
                if (this.b) {
                    this.H = true;
                } else {
                    j30Var.I = false;
                    aVar.k();
                }
            }
        }
    }

    public final void d() {
        this.b = false;
        this.J.clear();
        this.I.clear();
    }

    public final void d0(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new ui0());
        l30 l30Var = this.t;
        if (l30Var == null) {
            try {
                w("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw illegalStateException;
            }
        }
        try {
            l30Var.q.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw illegalStateException;
        }
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        ArrayList arrayListK = this.c.k();
        int size = arrayListK.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListK.get(i);
            i++;
            ViewGroup viewGroup = ((androidx.fragment.app.a) obj).c.G;
            if (viewGroup != null) {
                hashSet.add(xs.f(viewGroup, G()));
            }
        }
        return hashSet;
    }

    public final void e0() {
        synchronized (this.a) {
            try {
                if (!this.a.isEmpty()) {
                    r30 r30Var = this.h;
                    r30Var.a = true;
                    k40 k40Var = r30Var.c;
                    if (k40Var != null) {
                        k40Var.a();
                    }
                    return;
                }
                r30 r30Var2 = this.h;
                ArrayList arrayList = this.d;
                r30Var2.a = (arrayList != null ? arrayList.size() : 0) > 0 && M(this.v);
                k40 k40Var2 = r30Var2.c;
                if (k40Var2 != null) {
                    k40Var2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final androidx.fragment.app.a f(j30 j30Var) {
        String str = j30Var.g;
        g7 g7Var = this.c;
        androidx.fragment.app.a aVar = (androidx.fragment.app.a) ((HashMap) g7Var.d).get(str);
        if (aVar != null) {
            return aVar;
        }
        androidx.fragment.app.a aVar2 = new androidx.fragment.app.a(this.l, g7Var, j30Var);
        aVar2.m(this.t.n.getClassLoader());
        aVar2.e = this.s;
        return aVar2;
    }

    public final void g(j30 j30Var) {
        if (I(2)) {
            Log.v("FragmentManager", "detach: " + j30Var);
        }
        if (j30Var.B) {
            return;
        }
        j30Var.B = true;
        if (j30Var.m) {
            if (I(2)) {
                Log.v("FragmentManager", "remove from detach: " + j30Var);
            }
            g7 g7Var = this.c;
            synchronized (((ArrayList) g7Var.c)) {
                ((ArrayList) g7Var.c).remove(j30Var);
            }
            j30Var.m = false;
            if (J(j30Var)) {
                this.D = true;
            }
            a0(j30Var);
        }
    }

    public final void h(boolean z) {
        if (z && this.t != null) {
            d0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (j30 j30Var : this.c.m()) {
            if (j30Var != null) {
                j30Var.F = true;
                if (z) {
                    j30Var.v.h(true);
                }
            }
        }
    }

    public final boolean i() {
        if (this.s >= 1) {
            for (j30 j30Var : this.c.m()) {
                if (j30Var != null) {
                    if (!j30Var.A ? j30Var.v.i() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void j() {
        this.E = false;
        this.F = false;
        this.L.h = false;
        u(1);
    }

    public final boolean k() {
        if (this.s < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (j30 j30Var : this.c.m()) {
            if (j30Var != null && L(j30Var)) {
                if (!j30Var.A ? j30Var.v.k() : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(j30Var);
                    z = true;
                }
            }
        }
        if (this.e != null) {
            for (int i = 0; i < this.e.size(); i++) {
                j30 j30Var2 = (j30) this.e.get(i);
                if (arrayList == null || !arrayList.contains(j30Var2)) {
                    j30Var2.getClass();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public final void l() {
        boolean zIsChangingConfigurations = true;
        this.G = true;
        z(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((xs) it.next()).e();
        }
        l30 l30Var = this.t;
        g7 g7Var = this.c;
        if (l30Var != null) {
            zIsChangingConfigurations = ((a40) g7Var.e).g;
        } else {
            z7 z7Var = l30Var.n;
            if (z7Var != null) {
                zIsChangingConfigurations = true ^ z7Var.isChangingConfigurations();
            }
        }
        if (zIsChangingConfigurations) {
            Iterator it2 = this.j.values().iterator();
            while (it2.hasNext()) {
                ArrayList arrayList = ((nd) it2.next()).b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    String str = (String) obj;
                    a40 a40Var = (a40) g7Var.e;
                    a40Var.getClass();
                    if (I(3)) {
                        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
                    }
                    a40Var.e(str);
                }
            }
        }
        u(-1);
        l30 l30Var2 = this.t;
        if (l30Var2 != null) {
            z7 z7Var2 = l30Var2.q;
            p30 p30Var = this.o;
            p30Var.getClass();
            z7Var2.l.remove(p30Var);
        }
        l30 l30Var3 = this.t;
        if (l30Var3 != null) {
            z7 z7Var3 = l30Var3.q;
            p30 p30Var2 = this.n;
            p30Var2.getClass();
            z7Var3.k.remove(p30Var2);
        }
        l30 l30Var4 = this.t;
        if (l30Var4 != null) {
            z7 z7Var4 = l30Var4.q;
            p30 p30Var3 = this.p;
            p30Var3.getClass();
            z7Var4.n.remove(p30Var3);
        }
        l30 l30Var5 = this.t;
        if (l30Var5 != null) {
            z7 z7Var5 = l30Var5.q;
            p30 p30Var4 = this.q;
            p30Var4.getClass();
            z7Var5.o.remove(p30Var4);
        }
        l30 l30Var6 = this.t;
        if (l30Var6 != null) {
            z7 z7Var6 = l30Var6.q;
            s30 s30Var = this.r;
            s30Var.getClass();
            ra raVar = z7Var6.d;
            ((CopyOnWriteArrayList) raVar.e).remove(s30Var);
            if (((HashMap) raVar.c).remove(s30Var) == null) {
                ((Runnable) raVar.d).run();
            } else {
                s1.d();
            }
        }
        this.t = null;
        this.u = null;
        this.v = null;
        if (this.g != null) {
            Iterator it3 = this.h.b.iterator();
            while (it3.hasNext()) {
                ((mi) it3.next()).cancel();
            }
            this.g = null;
        }
        k4 k4Var = this.z;
        if (k4Var != null) {
            k4Var.b();
            this.A.b();
            this.B.b();
        }
    }

    public final void m(boolean z) {
        if (z && this.t != null) {
            d0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (j30 j30Var : this.c.m()) {
            if (j30Var != null) {
                j30Var.F = true;
                if (z) {
                    j30Var.v.m(true);
                }
            }
        }
    }

    public final void n(boolean z) {
        if (z && this.t != null) {
            d0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (j30 j30Var : this.c.m()) {
            if (j30Var != null && z) {
                j30Var.v.n(true);
            }
        }
    }

    public final void o() {
        ArrayList arrayListL = this.c.l();
        int size = arrayListL.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListL.get(i);
            i++;
            j30 j30Var = (j30) obj;
            if (j30Var != null) {
                j30Var.E();
                j30Var.v.o();
            }
        }
    }

    public final boolean p() {
        if (this.s >= 1) {
            for (j30 j30Var : this.c.m()) {
                if (j30Var != null) {
                    if (!j30Var.A ? j30Var.v.p() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void q() {
        if (this.s < 1) {
            return;
        }
        for (j30 j30Var : this.c.m()) {
            if (j30Var != null && !j30Var.A) {
                j30Var.v.q();
            }
        }
    }

    public final void r(j30 j30Var) {
        if (j30Var != null) {
            if (j30Var != this.c.g(j30Var.g)) {
                return;
            }
            j30Var.t.getClass();
            boolean zM = M(j30Var);
            Boolean bool = j30Var.l;
            if (bool == null || bool.booleanValue() != zM) {
                j30Var.l = Boolean.valueOf(zM);
                y30 y30Var = j30Var.v;
                y30Var.e0();
                y30Var.r(y30Var.w);
            }
        }
    }

    public final void s(boolean z) {
        if (z && this.t != null) {
            d0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (j30 j30Var : this.c.m()) {
            if (j30Var != null && z) {
                j30Var.v.s(true);
            }
        }
    }

    public final boolean t() {
        if (this.s < 1) {
            return false;
        }
        boolean z = false;
        for (j30 j30Var : this.c.m()) {
            if (j30Var != null && L(j30Var)) {
                if (!j30Var.A ? j30Var.v.t() : false) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        j30 j30Var = this.v;
        if (j30Var != null) {
            sb.append(j30Var.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.v)));
            sb.append("}");
        } else {
            l30 l30Var = this.t;
            if (l30Var != null) {
                sb.append(l30Var.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.t)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(int i) {
        try {
            this.b = true;
            for (androidx.fragment.app.a aVar : ((HashMap) this.c.d).values()) {
                if (aVar != null) {
                    aVar.e = i;
                }
            }
            N(i, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((xs) it.next()).e();
            }
            this.b = false;
            z(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final void v() {
        if (this.H) {
            this.H = false;
            c0();
        }
    }

    public final void w(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        g7 g7Var = this.c;
        ArrayList arrayList = (ArrayList) g7Var.c;
        String str3 = str + "    ";
        HashMap map = (HashMap) g7Var.d;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (androidx.fragment.app.a aVar : map.values()) {
                printWriter.print(str);
                if (aVar != null) {
                    j30 j30Var = aVar.c;
                    printWriter.println(j30Var);
                    j30Var.getClass();
                    printWriter.print(str3);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(j30Var.x));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(j30Var.y));
                    printWriter.print(" mTag=");
                    printWriter.println(j30Var.z);
                    printWriter.print(str3);
                    printWriter.print("mState=");
                    printWriter.print(j30Var.b);
                    printWriter.print(" mWho=");
                    printWriter.print(j30Var.g);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(j30Var.s);
                    printWriter.print(str3);
                    printWriter.print("mAdded=");
                    printWriter.print(j30Var.m);
                    printWriter.print(" mRemoving=");
                    printWriter.print(j30Var.n);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(j30Var.o);
                    printWriter.print(" mInLayout=");
                    printWriter.println(j30Var.p);
                    printWriter.print(str3);
                    printWriter.print("mHidden=");
                    printWriter.print(j30Var.A);
                    printWriter.print(" mDetached=");
                    printWriter.print(j30Var.B);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(j30Var.E);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(str3);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(j30Var.C);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(j30Var.J);
                    if (j30Var.t != null) {
                        printWriter.print(str3);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(j30Var.t);
                    }
                    if (j30Var.u != null) {
                        printWriter.print(str3);
                        printWriter.print("mHost=");
                        printWriter.println(j30Var.u);
                    }
                    if (j30Var.w != null) {
                        printWriter.print(str3);
                        printWriter.print("mParentFragment=");
                        printWriter.println(j30Var.w);
                    }
                    if (j30Var.h != null) {
                        printWriter.print(str3);
                        printWriter.print("mArguments=");
                        printWriter.println(j30Var.h);
                    }
                    if (j30Var.c != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(j30Var.c);
                    }
                    if (j30Var.d != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(j30Var.d);
                    }
                    if (j30Var.e != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(j30Var.e);
                    }
                    Object objA = j30Var.A(false);
                    if (objA != null) {
                        printWriter.print(str3);
                        printWriter.print("mTarget=");
                        printWriter.print(objA);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(j30Var.k);
                    }
                    printWriter.print(str3);
                    printWriter.print("mPopDirection=");
                    h30 h30Var = j30Var.K;
                    printWriter.println(h30Var == null ? false : h30Var.a);
                    h30 h30Var2 = j30Var.K;
                    if ((h30Var2 == null ? 0 : h30Var2.b) != 0) {
                        printWriter.print(str3);
                        printWriter.print("getEnterAnim=");
                        h30 h30Var3 = j30Var.K;
                        printWriter.println(h30Var3 == null ? 0 : h30Var3.b);
                    }
                    h30 h30Var4 = j30Var.K;
                    if ((h30Var4 == null ? 0 : h30Var4.c) != 0) {
                        printWriter.print(str3);
                        printWriter.print("getExitAnim=");
                        h30 h30Var5 = j30Var.K;
                        printWriter.println(h30Var5 == null ? 0 : h30Var5.c);
                    }
                    h30 h30Var6 = j30Var.K;
                    if ((h30Var6 == null ? 0 : h30Var6.d) != 0) {
                        printWriter.print(str3);
                        printWriter.print("getPopEnterAnim=");
                        h30 h30Var7 = j30Var.K;
                        printWriter.println(h30Var7 == null ? 0 : h30Var7.d);
                    }
                    h30 h30Var8 = j30Var.K;
                    if ((h30Var8 == null ? 0 : h30Var8.e) != 0) {
                        printWriter.print(str3);
                        printWriter.print("getPopExitAnim=");
                        h30 h30Var9 = j30Var.K;
                        printWriter.println(h30Var9 == null ? 0 : h30Var9.e);
                    }
                    if (j30Var.G != null) {
                        printWriter.print(str3);
                        printWriter.print("mContainer=");
                        printWriter.println(j30Var.G);
                    }
                    if (j30Var.H != null) {
                        printWriter.print(str3);
                        printWriter.print("mView=");
                        printWriter.println(j30Var.H);
                    }
                    if (j30Var.u() != null) {
                        ra raVar = new ra(j30Var.m(), yh0.d);
                        String canonicalName = yh0.class.getCanonicalName();
                        if (canonicalName != null) {
                            t11 t11Var = ((yh0) raVar.u(yh0.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName))).c;
                            if (t11Var.d > 0) {
                                printWriter.print(str3);
                                printWriter.println("Loaders:");
                                if (t11Var.d > 0) {
                                    if (t11Var.c[0] == null) {
                                        printWriter.print(str3);
                                        printWriter.print("  #");
                                        printWriter.print(t11Var.b[0]);
                                        printWriter.print(": ");
                                        throw null;
                                    }
                                    s1.d();
                                }
                            }
                        } else {
                            zy.n("Local and anonymous classes can not be ViewModels");
                        }
                    }
                    printWriter.print(str3);
                    printWriter.println("Child " + j30Var.v + ":");
                    j30Var.v.w(str3.concat("  "), fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size3; i++) {
                j30 j30Var2 = (j30) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(j30Var2.toString());
            }
        }
        ArrayList arrayList2 = this.e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                j30 j30Var3 = (j30) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(j30Var3.toString());
            }
        }
        ArrayList arrayList3 = this.d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                ld ldVar = (ld) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(ldVar.toString());
                ldVar.h(str2, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            try {
                int size4 = this.a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        Object obj = (w30) this.a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.t);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.u);
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.v);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.s);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public final void x(w30 w30Var, boolean z) {
        if (!z) {
            if (this.t == null) {
                if (this.G) {
                    s1.f("FragmentManager has been destroyed");
                    return;
                } else {
                    s1.f("FragmentManager has not been attached to a host.");
                    return;
                }
            }
            if (this.E || this.F) {
                s1.f("Can not perform this action after onSaveInstanceState");
                return;
            }
        }
        synchronized (this.a) {
            try {
                if (this.t == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(w30Var);
                    W();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y(boolean z) {
        if (this.b) {
            s1.f("FragmentManager is already executing transactions");
            return;
        }
        if (this.t == null) {
            if (this.G) {
                s1.f("FragmentManager has been destroyed");
                return;
            } else {
                s1.f("FragmentManager has not been attached to a host.");
                return;
            }
        }
        if (Looper.myLooper() != this.t.o.getLooper()) {
            s1.f("Must be called from main thread of fragment host");
            return;
        }
        if (!z && (this.E || this.F)) {
            s1.f("Can not perform this action after onSaveInstanceState");
        } else if (this.I == null) {
            this.I = new ArrayList();
            this.J = new ArrayList();
        }
    }

    public final boolean z(boolean z) {
        boolean zA;
        ArrayList arrayList;
        y(z);
        boolean z2 = false;
        while (true) {
            ArrayList arrayList2 = this.I;
            ArrayList arrayList3 = this.J;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    zA = false;
                } else {
                    try {
                        int size = this.a.size();
                        int i = 0;
                        zA = false;
                        while (true) {
                            arrayList = this.a;
                            if (i >= size) {
                                break;
                            }
                            zA |= ((w30) arrayList.get(i)).a(arrayList2, arrayList3);
                            i++;
                        }
                        arrayList.clear();
                        this.t.o.removeCallbacks(this.M);
                    } finally {
                    }
                }
            }
            if (!zA) {
                e0();
                v();
                ((HashMap) this.c.d).values().removeAll(Collections.singleton(null));
                return z2;
            }
            z2 = true;
            this.b = true;
            try {
                T(this.I, this.J);
            } finally {
                d();
            }
        }
    }
}
