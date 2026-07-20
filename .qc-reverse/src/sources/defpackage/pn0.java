package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Pair;
import android.util.SparseIntArray;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import com.google.android.gms.common.api.Status;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.preferences.ActionPickerPreference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pn0 implements aq0, z00, m3, un0, xl1 {
    public static pn0 e;
    public final /* synthetic */ int b;
    public Object c;
    public Object d;

    public pn0(int i) {
        this.b = i;
        switch (i) {
            case 9:
                this.c = new ArrayList();
                this.d = new p21();
                break;
            case 13:
                this.c = new t01(0);
                this.d = new vi0();
                break;
            case 18:
                this.c = Collections.synchronizedMap(new WeakHashMap());
                this.d = Collections.synchronizedMap(new WeakHashMap());
                break;
            case 19:
                w60 w60Var = w60.c;
                this.c = new SparseIntArray();
                this.d = w60Var;
                break;
            default:
                this.c = new i70();
                Context context = App.c;
                this.d = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
                break;
        }
    }

    public static void V() {
        if (oq0.a((SharedPreferences) t().d, oq0.D0)) {
            pn0 pn0VarT = t();
            ((SharedPreferences) pn0VarT.d).edit().putFloat(oq0.E0.name(), w71.l0()).apply();
        }
    }

    public static pn0 t() {
        if (e == null) {
            e = new pn0(2);
        }
        return e;
    }

    public boolean A() {
        return oq0.a((SharedPreferences) this.d, oq0.f);
    }

    public boolean B() {
        return v() == 2;
    }

    public boolean C() {
        return v() == 3;
    }

    public boolean D() {
        return oq0.a((SharedPreferences) this.d, oq0.Y);
    }

    public boolean E(View view) {
        ef1 ef1Var = (ef1) this.d;
        xt0 xt0Var = (xt0) this.c;
        int iD = xt0Var.d();
        int iC = xt0Var.c();
        int iB = xt0Var.b(view);
        int iA = xt0Var.a(view);
        ef1Var.b = iD;
        ef1Var.c = iC;
        ef1Var.d = iB;
        ef1Var.e = iA;
        ef1Var.a = 24579;
        return ef1Var.a();
    }

    public void F(int i, int i2) {
        int[] iArr = (int[]) this.d;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        g(i3);
        int[] iArr2 = (int[]) this.d;
        System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
        Arrays.fill((int[]) this.d, i, i3, -1);
        ArrayList arrayList = (ArrayList) this.c;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            i21 i21Var = (i21) ((ArrayList) this.c).get(size);
            int i4 = i21Var.b;
            if (i4 >= i) {
                i21Var.b = i4 + i2;
            }
        }
    }

    public void G(int i, int i2) {
        int[] iArr = (int[]) this.d;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        g(i3);
        int[] iArr2 = (int[]) this.d;
        System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
        int[] iArr3 = (int[]) this.d;
        Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.c;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            i21 i21Var = (i21) ((ArrayList) this.c).get(size);
            int i4 = i21Var.b;
            if (i4 >= i) {
                if (i4 < i3) {
                    ((ArrayList) this.c).remove(size);
                } else {
                    i21Var.b = i4 - i2;
                }
            }
        }
    }

    public rm0 H(pu0 pu0Var, int i) {
        ag1 ag1Var;
        rm0 rm0Var;
        t01 t01Var = (t01) this.c;
        int iD = t01Var.d(pu0Var);
        if (iD >= 0 && (ag1Var = (ag1) t01Var.i(iD)) != null) {
            int i2 = ag1Var.a;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                ag1Var.a = i3;
                if (i == 4) {
                    rm0Var = ag1Var.b;
                } else if (i == 8) {
                    rm0Var = ag1Var.c;
                } else {
                    zy.n("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    t01Var.g(iD);
                    ag1Var.a = 0;
                    ag1Var.b = null;
                    ag1Var.c = null;
                    ag1.d.c(ag1Var);
                }
                return rm0Var;
            }
        }
        return null;
    }

    public byte[] I() throws IOException {
        String str = (String) this.d;
        try {
            String string = ((SharedPreferences) this.c).getString(str, null);
            if (string != null) {
                return xr.g(string);
            }
            throw new IOException("can't read keyset; the pref value " + str + " does not exist");
        } catch (ClassCastException e2) {
            e = e2;
            throw new IOException(l11.j("can't read keyset; the pref value ", str, " is not a valid hex string"), e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw new IOException(l11.j("can't read keyset; the pref value ", str, " is not a valid hex string"), e);
        }
    }

    public void J(pu0 pu0Var) {
        ag1 ag1Var = (ag1) ((t01) this.c).get(pu0Var);
        if (ag1Var == null) {
            return;
        }
        ag1Var.a &= -2;
    }

    public void K(pu0 pu0Var) {
        vi0 vi0Var = (vi0) this.d;
        int iE = vi0Var.e() - 1;
        while (true) {
            if (iE < 0) {
                break;
            }
            if (pu0Var == vi0Var.f(iE)) {
                Object[] objArr = vi0Var.d;
                Object obj = objArr[iE];
                Object obj2 = tk0.f;
                if (obj != obj2) {
                    objArr[iE] = obj2;
                    vi0Var.b = true;
                }
            } else {
                iE--;
            }
        }
        ag1 ag1Var = (ag1) ((t01) this.c).remove(pu0Var);
        if (ag1Var != null) {
            ag1Var.a = 0;
            ag1Var.b = null;
            ag1Var.c = null;
            ag1.d.c(ag1Var);
        }
    }

    public void L() {
        ((SharedPreferences) this.d).edit().remove(oq0.q.name()).remove(oq0.y.name()).remove(oq0.w.name()).remove(oq0.v.name()).remove(oq0.x.name()).remove(oq0.u.name()).remove(oq0.r.name()).remove(oq0.s.name()).remove(oq0.z.name()).remove(oq0.A.name()).remove(oq0.b0.name()).remove(oq0.c0.name()).remove(oq0.d0.name()).apply();
    }

    public void M() {
        ((SharedPreferences) this.d).edit().remove(oq0.k0.name()).remove(oq0.l0.name()).remove(oq0.m0.name()).remove(oq0.n0.name()).remove(oq0.p0.name()).remove(oq0.q0.name()).remove(oq0.r0.name()).remove(oq0.s0.name()).remove(oq0.t0.name()).remove(oq0.o0.name()).remove(oq0.u0.name()).apply();
    }

    public void N() {
        ((SharedPreferences) this.d).edit().remove(oq0.N.name()).remove(oq0.O.name()).remove(oq0.P.name()).remove(oq0.Q.name()).apply();
    }

    public void O() {
        ((SharedPreferences) this.d).edit().remove(oq0.B.name()).remove(oq0.C.name()).remove(oq0.F.name()).remove(oq0.E.name()).remove(oq0.I.name()).remove(oq0.J.name()).remove(oq0.H.name()).remove(oq0.K.name()).remove(oq0.D.name()).remove(oq0.G.name()).apply();
    }

    public void P() {
        ((SharedPreferences) this.d).edit().remove(oq0.R.name()).remove(oq0.S.name()).remove(oq0.T.name()).remove(oq0.U.name()).remove(oq0.V.name()).remove(oq0.W.name()).remove(oq0.X.name()).remove(oq0.Y.name()).remove(oq0.Z.name()).remove(oq0.a0.name()).apply();
    }

    public void Q(boolean z) {
        ((SharedPreferences) this.d).edit().putBoolean(oq0.i.name(), z).apply();
    }

    public void R(Bitmap bitmap) {
        try {
            String strJ = xr.j(bitmap);
            si0.b("Encoded length:" + strJ.length());
            ((SharedPreferences) this.d).edit().putString(oq0.y.name(), strJ).apply();
        } catch (Exception e2) {
            si0.b("setCursorDesignCustomBitmap error: " + e2);
        }
    }

    public void S(j71 j71Var) {
        ((SharedPreferences) this.d).edit().putString(oq0.N0.name(), ((i70) this.c).i(j71Var)).apply();
    }

    public void T(boolean z) {
        ((SharedPreferences) this.d).edit().putBoolean(oq0.S0.name(), z).apply();
    }

    public void U(long j) {
        ((SharedPreferences) this.d).edit().putLong(oq0.f1.name(), j == -1 ? 0L : j + (System.currentTimeMillis() / 1000)).apply();
    }

    public void W(Bitmap bitmap) {
        try {
            String strJ = xr.j(bitmap);
            si0.b("Encoded length:" + strJ.length());
            ((SharedPreferences) this.d).edit().putString(oq0.C.name(), strJ).apply();
        } catch (Exception e2) {
            si0.b("setTrackerDesignCustomBitmap error: " + e2);
        }
    }

    public void X(int i) {
        SharedPreferences.Editor editorEdit = ((SharedPreferences) this.d).edit();
        oq0 oq0Var = oq0.d;
        editorEdit.putInt("versionCode", i).apply();
    }

    public void Y() {
        xw.e.e();
        s71.e.a();
        xv0 xv0Var = xv0.d;
        xv0Var.getClass();
        xv0Var.c = new HashMap();
        xv0Var.c();
        SharedPreferences.Editor editorEdit = ((SharedPreferences) this.d).edit();
        editorEdit.putInt(oq0.i0.name(), ey0.d);
        editorEdit.putInt(oq0.j0.name(), ey0.e);
        oq0.e(editorEdit, oq0.e);
        oq0.e(editorEdit, oq0.f);
        oq0.e(editorEdit, oq0.h);
        oq0.e(editorEdit, oq0.a1);
        oq0.h(editorEdit, oq0.l);
        oq0.h(editorEdit, oq0.m);
        oq0.h(editorEdit, oq0.n);
        oq0.h(editorEdit, oq0.q);
        oq0.h(editorEdit, oq0.B);
        oq0.h(editorEdit, oq0.b0);
        oq0.g(editorEdit, oq0.o);
        oq0.g(editorEdit, oq0.p);
        oq0.e(editorEdit, oq0.M0);
        oq0.h(editorEdit, oq0.N0);
        oq0.h(editorEdit, oq0.P0);
        oq0.h(editorEdit, oq0.R0);
        oq0.f(editorEdit, oq0.r);
        oq0.f(editorEdit, oq0.u);
        oq0.g(editorEdit, oq0.v);
        oq0.g(editorEdit, oq0.w);
        oq0.g(editorEdit, oq0.x);
        oq0.g(editorEdit, oq0.c0);
        oq0.g(editorEdit, oq0.e0);
        oq0.f(editorEdit, oq0.D);
        oq0.g(editorEdit, oq0.E);
        oq0.g(editorEdit, oq0.F);
        oq0.e(editorEdit, oq0.N);
        oq0.e(editorEdit, oq0.O);
        oq0.e(editorEdit, oq0.P);
        oq0.g(editorEdit, oq0.Q);
        oq0.g(editorEdit, oq0.O0);
        oq0.g(editorEdit, oq0.L);
        oq0.f(editorEdit, oq0.M);
        oq0.e(editorEdit, oq0.U);
        oq0.e(editorEdit, oq0.V);
        oq0.g(editorEdit, oq0.d0);
        oq0.g(editorEdit, oq0.R);
        oq0.g(editorEdit, oq0.S);
        oq0.f(editorEdit, oq0.T);
        oq0.e(editorEdit, oq0.a0);
        oq0.e(editorEdit, oq0.k);
        oq0.e(editorEdit, oq0.f0);
        oq0.f(editorEdit, oq0.k0);
        oq0.g(editorEdit, oq0.l0);
        oq0.e(editorEdit, oq0.n0);
        oq0.e(editorEdit, oq0.m0);
        oq0.e(editorEdit, oq0.o0);
        oq0.g(editorEdit, oq0.p0);
        oq0.g(editorEdit, oq0.q0);
        oq0.g(editorEdit, oq0.r0);
        oq0.g(editorEdit, oq0.t0);
        oq0.f(editorEdit, oq0.s0);
        oq0.h(editorEdit, oq0.u0);
        oq0.f(editorEdit, oq0.v0);
        oq0.f(editorEdit, oq0.x0);
        oq0.f(editorEdit, oq0.z0);
        oq0.g(editorEdit, oq0.B0);
        oq0.g(editorEdit, oq0.w0);
        oq0.g(editorEdit, oq0.y0);
        oq0.g(editorEdit, oq0.A0);
        oq0.g(editorEdit, oq0.C0);
        oq0.e(editorEdit, oq0.D0);
        oq0.f(editorEdit, oq0.E0);
        oq0.e(editorEdit, oq0.G0);
        oq0.h(editorEdit, oq0.F0);
        oq0.g(editorEdit, oq0.H0);
        oq0.e(editorEdit, oq0.I0);
        oq0.h(editorEdit, oq0.J0);
        oq0.g(editorEdit, oq0.K0);
        oq0.e(editorEdit, oq0.L0);
        oq0.e(editorEdit, oq0.S0);
        oq0.g(editorEdit, oq0.T0);
        oq0.e(editorEdit, oq0.U0);
        editorEdit.apply();
        t().getClass();
        V();
    }

    public void Z() {
        P();
        L();
        N();
        O();
        SharedPreferences sharedPreferences = (SharedPreferences) this.d;
        sharedPreferences.edit().remove(oq0.g0.name()).remove(oq0.h0.name()).apply();
        M();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        oq0.i(editorEdit, oq0.f0);
        oq0 oq0Var = oq0.N0;
        editorEdit.putString(oq0Var.name(), (String) oq0Var.c);
        editorEdit.apply();
        xw xwVar = xw.e;
        xwVar.getClass();
        wa waVar = new wa();
        dx dxVar = new dx();
        n3 n3Var = n3.expandNotifications;
        wa waVar2 = j00.k;
        dxVar.a(new lw(n3Var, waVar2));
        n3 n3Var2 = n3.expandQuickSettings;
        dxVar.a(new lw(n3Var2, waVar2));
        waVar.put("topEdgeBar", dxVar);
        waVar.put("leftEdgeBar", xw.b());
        waVar.put("rightEdgeBar", xw.c());
        waVar.put("bottomEdgeBar", xw.a());
        xwVar.c = waVar;
        xwVar.g();
        s71 s71Var = s71.e;
        s71Var.getClass();
        ArrayList arrayList = new ArrayList();
        s71Var.c = arrayList;
        n3 n3Var3 = n3.gestureSwipe;
        wa waVar3 = o60.k;
        r71 r71Var = new r71(waVar3);
        r71Var.put("swipeDirection", m60.BOTTOM);
        arrayList.add(new j71(n3Var3, r71Var));
        s71Var.c.add(new j71(n3.longTap, xi0.k));
        List list = s71Var.c;
        r71 r71Var2 = new r71(waVar3);
        r71Var2.put("swipeDirection", m60.LEFT);
        list.add(new j71(n3Var3, r71Var2));
        s71Var.c.add(new j71(n3.copy, vo.k));
        List list2 = s71Var.c;
        r71 r71Var3 = new r71(waVar3);
        r71Var3.put("swipeDirection", m60.TOP);
        list2.add(new j71(n3Var3, r71Var3));
        s71Var.c.add(new j71(n3.takeScreenshot, null));
        List list3 = s71Var.c;
        r71 r71Var4 = new r71(waVar3);
        r71Var4.put("swipeDirection", m60.RIGHT);
        list3.add(new j71(n3Var3, r71Var4));
        s71Var.c.add(new j71(n3Var2, waVar2));
        s71Var.d = new j71(n3.nothing, null);
        s71Var.c();
        t().getClass();
        V();
    }

    public void a(String str, Object obj) {
        ((ArrayList) this.c).add(str + "=" + String.valueOf(obj));
    }

    public void a0(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.c)) {
            map = new HashMap((Map) this.c);
        }
        synchronized (((Map) this.d)) {
            map2 = new HashMap((Map) this.d);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                s1.d();
                return;
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((l41) entry2.getKey()).a(new v7(status));
            }
        }
    }

    public void b(String str) {
        SharedPreferences sharedPreferences = (SharedPreferences) this.d;
        oq0 oq0Var = oq0.g;
        sharedPreferences.edit().putString(oq0Var.name(), (oq0.d(sharedPreferences, oq0Var) + str + "\n").substring(Math.max(0, r4.length() - 5000))).apply();
    }

    public void b0(sq1 sq1Var) {
        if (sq1Var == null) {
            return;
        }
        try {
            kr1 kr1VarU = lr1.u();
            kr1VarU.d((er1) this.c);
            kr1VarU.c();
            lr1.o((lr1) kr1VarU.c, sq1Var);
            ((xg) this.d).e((lr1) kr1VarU.b());
        } catch (Throwable th) {
            pn1.h("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        ((PreferenceGroup) this.c).T = Integer.MAX_VALUE;
        jq0 jq0Var = (jq0) this.d;
        Handler handler = jq0Var.g;
        nc ncVar = jq0Var.h;
        handler.removeCallbacks(ncVar);
        handler.post(ncVar);
        return true;
    }

    public void c0(wq1 wq1Var) {
        if (wq1Var == null) {
            return;
        }
        try {
            kr1 kr1VarU = lr1.u();
            kr1VarU.d((er1) this.c);
            kr1VarU.c();
            lr1.p((lr1) kr1VarU.c, wq1Var);
            ((xg) this.d).e((lr1) kr1VarU.b());
        } catch (Throwable th) {
            pn1.h("BillingLogger", "Unable to log.", th);
        }
    }

    public void d(ValueAnimator valueAnimator) {
        ow0 ow0Var = new ow0(26);
        valueAnimator.addListener((p21) this.d);
        ((ArrayList) this.c).add(ow0Var);
    }

    public void d0(ar1 ar1Var) {
        try {
            kr1 kr1VarU = lr1.u();
            kr1VarU.d((er1) this.c);
            kr1VarU.c();
            lr1.q((lr1) kr1VarU.c, ar1Var);
            ((xg) this.d).e((lr1) kr1VarU.b());
        } catch (Throwable th) {
            pn1.h("BillingLogger", "Unable to log.", th);
        }
    }

    public void e(pu0 pu0Var, rm0 rm0Var) {
        t01 t01Var = (t01) this.c;
        ag1 ag1VarA = (ag1) t01Var.get(pu0Var);
        if (ag1VarA == null) {
            ag1VarA = ag1.a();
            t01Var.put(pu0Var, ag1VarA);
        }
        ag1VarA.c = rm0Var;
        ag1VarA.a |= 8;
    }

    public void e0(or1 or1Var) {
        try {
            xg xgVar = (xg) this.d;
            kr1 kr1VarU = lr1.u();
            kr1VarU.d((er1) this.c);
            kr1VarU.c();
            lr1.s((lr1) kr1VarU.c, or1Var);
            xgVar.e((lr1) kr1VarU.b());
        } catch (Throwable th) {
            pn1.h("BillingLogger", "Unable to log.", th);
        }
    }

    public hs0 f() {
        if ("first_party".equals((String) this.d)) {
            zy.n("Serialized doc id must be provided for first party products.");
            return null;
        }
        if (((String) this.c) == null) {
            zy.n("Product id must be provided.");
            return null;
        }
        if (((String) this.d) != null) {
            return new hs0(this);
        }
        zy.n("Product type must be provided.");
        return null;
    }

    public void f0(pr1 pr1Var) {
        if (pr1Var == null) {
            return;
        }
        try {
            kr1 kr1VarU = lr1.u();
            kr1VarU.d((er1) this.c);
            kr1VarU.c();
            lr1.t((lr1) kr1VarU.c, pr1Var);
            ((xg) this.d).e((lr1) kr1VarU.b());
        } catch (Throwable th) {
            pn1.h("BillingLogger", "Unable to log.", th);
        }
    }

    public void g(int i) {
        int[] iArr = (int[]) this.d;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.d = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.d = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.d;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    @Override // defpackage.wr0
    public Object get() {
        ix ixVar = new ix(29);
        c70 c70Var = new c70(28);
        Object obj = ((wr0) this.c).get();
        wr0 wr0Var = (wr0) this.d;
        return new dx0(ixVar, c70Var, zc.f, (vx0) obj, wr0Var);
    }

    public View h(int i, int i2, int i3, int i4) {
        View viewU;
        ef1 ef1Var = (ef1) this.d;
        xt0 xt0Var = (xt0) this.c;
        int iD = xt0Var.d();
        int iC = xt0Var.c();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            switch (xt0Var.a) {
                case 0:
                    viewU = xt0Var.b.u(i);
                    break;
                default:
                    viewU = xt0Var.b.u(i);
                    break;
            }
            int iB = xt0Var.b(viewU);
            int iA = xt0Var.a(viewU);
            ef1Var.b = iD;
            ef1Var.c = iC;
            ef1Var.d = iB;
            ef1Var.e = iA;
            if (i3 != 0) {
                ef1Var.a = i3;
                if (ef1Var.a()) {
                    return viewU;
                }
            }
            if (i4 != 0) {
                ef1Var.a = i4;
                if (ef1Var.a()) {
                    view = viewU;
                }
            }
            i += i5;
        }
        return view;
    }

    public int i() {
        try {
            return l11.v(oq0.d((SharedPreferences) this.d, oq0.g0));
        } catch (Exception unused) {
            return l11.v((String) oq0.g0.b);
        }
    }

    public pq0 j() {
        try {
            return pq0.valueOf(oq0.d((SharedPreferences) this.d, oq0.l));
        } catch (Exception unused) {
            return pq0.valueOf((String) oq0.l.b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    @Override // defpackage.un0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.wi1 k(android.view.View r18, defpackage.wi1 r19) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pn0.k(android.view.View, wi1):wi1");
    }

    @Override // defpackage.m3
    public y30 l() {
        switch (this.b) {
            case 10:
                return ((la1) this.d).l();
            default:
                return ((ua1) this.d).l();
        }
    }

    public int m() {
        try {
            return l11.w(oq0.d((SharedPreferences) this.d, oq0.q));
        } catch (Exception unused) {
            return l11.w((String) oq0.q.b);
        }
    }

    @Override // defpackage.m3
    public void n(Intent intent, e4 e4Var) {
        switch (this.b) {
            case 10:
                la1 la1Var = (la1) this.d;
                la1Var.B0 = (qs) e4Var;
                la1Var.C0.a(intent);
                break;
            default:
                ua1 ua1Var = (ua1) this.d;
                ua1Var.s0 = (qs) e4Var;
                ua1Var.t0.a(intent);
                break;
        }
    }

    @Override // defpackage.m3
    public Context o() {
        switch (this.b) {
            case 10:
                return ((la1) this.d).o();
            default:
                return ((ua1) this.d).o();
        }
    }

    public Bitmap p() {
        try {
            Bitmap bitmapH = xr.h(oq0.d((SharedPreferences) this.d, oq0.y));
            if (bitmapH != null) {
                return bitmapH;
            }
        } catch (Exception e2) {
            si0.b("getCursorDesignCustomBitmap error: " + e2);
        }
        return lc1.v(R.drawable.cursor_design_custom);
    }

    @Override // defpackage.m3
    public void q(i iVar) {
        int i = 15;
        switch (this.b) {
            case 10:
                la1 la1Var = (la1) this.d;
                ActionPickerPreference actionPickerPreference = (ActionPickerPreference) this.c;
                if (actionPickerPreference == la1Var.x0) {
                    la1Var.A0.O(new h91(iVar));
                    actionPickerPreference.K(la1Var.A0.n());
                } else if (actionPickerPreference == la1Var.y0) {
                    la1Var.A0.K(new h91(iVar));
                    actionPickerPreference.K(la1Var.A0.h());
                }
                la1Var.p0();
                xv0.d.c();
                la1Var.j0.a(new s4(i));
                break;
            default:
                ua1 ua1Var = (ua1) this.d;
                ActionPickerPreference actionPickerPreference2 = (ActionPickerPreference) this.c;
                m91 m91Var = ua1Var.m0;
                if (actionPickerPreference2 == ua1Var.q0) {
                    m91Var.O(new h91(iVar));
                    actionPickerPreference2.K(m91Var.n());
                } else if (actionPickerPreference2 == ua1Var.r0) {
                    m91Var.K(new h91(iVar));
                    actionPickerPreference2.K(m91Var.h());
                }
                xv0.d.c();
                ua1Var.j0.a(new s4(i));
                break;
        }
    }

    public Pair r() {
        Float fValueOf = Float.valueOf(0.5f);
        SharedPreferences sharedPreferences = (SharedPreferences) this.d;
        try {
            return new Pair(Float.valueOf(oq0.b(sharedPreferences, oq0.z)), Float.valueOf(oq0.b(sharedPreferences, oq0.A)));
        } catch (Exception unused) {
            return new Pair(fValueOf, fValueOf);
        }
    }

    public j71 s() {
        try {
            String strD = oq0.d((SharedPreferences) this.d, oq0.P0);
            i70 i70Var = (i70) this.c;
            i70Var.getClass();
            return (j71) i70Var.e(strD, new mc1(j71.class));
        } catch (Exception e2) {
            si0.b("getDoubleTapTrackerAction exception: " + e2);
            return new j71(n3.nothing, null);
        }
    }

    public String toString() {
        int i = 0;
        switch (this.b) {
            case 0:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.d.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.c;
                int size = arrayList.size();
                while (i < size) {
                    sb.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb.append(", ");
                    }
                    i++;
                }
                sb.append('}');
                return sb.toString();
            case 3:
                String string = "[ ";
                if (((m11) this.c) != null) {
                    while (i < 9) {
                        StringBuilder sbL = l11.l(string);
                        sbL.append(((m11) this.c).i[i]);
                        sbL.append(" ");
                        string = sbL.toString();
                        i++;
                    }
                }
                return string + "] " + ((m11) this.c);
            case 16:
                return "Bounds{lower=" + ((xb0) this.c) + " upper=" + ((xb0) this.d) + "}";
            default:
                return super.toString();
        }
    }

    public int u() {
        try {
            return qq0.o(oq0.d((SharedPreferences) this.d, oq0.n));
        } catch (Exception unused) {
            return qq0.o((String) oq0.n.b);
        }
    }

    public int v() {
        try {
            return qq0.p(oq0.d((SharedPreferences) this.d, oq0.m));
        } catch (Exception unused) {
            return qq0.p((String) oq0.m.b);
        }
    }

    public j71 w() {
        try {
            String strD = oq0.d((SharedPreferences) this.d, oq0.N0);
            i70 i70Var = (i70) this.c;
            i70Var.getClass();
            return (j71) i70Var.e(strD, new mc1(j71.class));
        } catch (Exception e2) {
            si0.b("getLongTapTrackerAction exception: " + e2);
            return new j71(n3.nothing, null);
        }
    }

    public int x() {
        return oq0.c((SharedPreferences) this.d, oq0.Z);
    }

    public j71 y() {
        try {
            String strD = oq0.d((SharedPreferences) this.d, oq0.R0);
            i70 i70Var = (i70) this.c;
            i70Var.getClass();
            return (j71) i70Var.e(strD, new mc1(j71.class));
        } catch (Exception e2) {
            si0.b("getSecondTapTrackerAction exception: " + e2);
            return new j71(n3.nothing, null);
        }
    }

    public int z() {
        try {
            return qq0.q(oq0.d((SharedPreferences) this.d, oq0.B));
        } catch (Exception unused) {
            return qq0.q((String) oq0.B.b);
        }
    }

    public /* synthetic */ pn0(Object obj, int i, Object obj2) {
        this.b = i;
        this.d = obj;
        this.c = obj2;
    }

    public /* synthetic */ pn0(Object obj, Object obj2, int i, boolean z) {
        this.b = i;
        this.c = obj;
        this.d = obj2;
    }

    public pn0(Context context, er1 er1Var) {
        ra raVarC;
        uy uyVar;
        ow0 ow0Var;
        Set set;
        this.b = 23;
        xg xgVar = new xg();
        try {
            d91.b(context);
            raVarC = d91.a().c(bi.e);
            uyVar = new uy("proto");
            ow0Var = new ow0(29);
            set = (Set) raVarC.c;
        } catch (Throwable unused) {
            xgVar.b = true;
        }
        if (set.contains(uyVar)) {
            xgVar.c = new ra((hd) raVarC.d, uyVar, ow0Var, (d91) raVarC.e);
            this.d = xgVar;
            this.c = er1Var;
            return;
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", uyVar, set));
    }

    public /* synthetic */ pn0(Object obj) {
        this.b = 0;
        this.d = obj;
        this.c = new ArrayList();
    }

    public pn0(uq0 uq0Var) {
        this.b = 3;
        this.d = uq0Var;
    }

    public pn0(int i, Context context, String str) {
        this.b = i;
        switch (i) {
            case 7:
                this.d = str;
                this.c = context.getApplicationContext().getSharedPreferences("prefs_extra", 0).edit();
                break;
            default:
                this.d = str;
                this.c = context.getApplicationContext().getSharedPreferences("prefs_extra", 0);
                break;
        }
    }

    public /* synthetic */ pn0(int i, boolean z) {
        this.b = i;
    }

    public pn0(xt0 xt0Var) {
        this.b = 12;
        this.c = xt0Var;
        ef1 ef1Var = new ef1();
        ef1Var.a = 0;
        this.d = ef1Var;
    }

    public pn0(mg1 mg1Var) {
        this.b = 14;
        this.d = mg1Var;
        this.c = new Rect();
    }
}
