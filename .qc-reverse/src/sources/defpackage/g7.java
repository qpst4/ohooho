package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.a;
import com.quickcursor.App;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class g7 implements ni, z00 {
    public Object b;
    public Object c;
    public Object d;
    public Object e;

    public g7(Typeface typeface, vl0 vl0Var) {
        int i;
        int i2;
        int i3;
        int i4;
        this.e = typeface;
        this.c = vl0Var;
        this.b = new wl0(1024);
        int iA = vl0Var.a(6);
        if (iA != 0) {
            int i5 = iA + vl0Var.a;
            i = ((ByteBuffer) vl0Var.d).getInt(((ByteBuffer) vl0Var.d).getInt(i5) + i5);
        } else {
            i = 0;
        }
        this.d = new char[i * 2];
        int iA2 = vl0Var.a(6);
        if (iA2 != 0) {
            int i6 = iA2 + vl0Var.a;
            i2 = ((ByteBuffer) vl0Var.d).getInt(((ByteBuffer) vl0Var.d).getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            uc1 uc1Var = new uc1(this, i7);
            ul0 ul0VarB = uc1Var.b();
            int iA3 = ul0VarB.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) ul0VarB.d).getInt(iA3 + ul0VarB.a) : 0, (char[]) this.d, i7 * 2);
            ul0 ul0VarB2 = uc1Var.b();
            int iA4 = ul0VarB2.a(16);
            if (iA4 != 0) {
                int i8 = iA4 + ul0VarB2.a;
                i3 = ((ByteBuffer) ul0VarB2.d).getInt(((ByteBuffer) ul0VarB2.d).getInt(i8) + i8);
            } else {
                i3 = 0;
            }
            f01.g("invalid metadata codepoint length", i3 > 0);
            wl0 wl0Var = (wl0) this.b;
            ul0 ul0VarB3 = uc1Var.b();
            int iA5 = ul0VarB3.a(16);
            if (iA5 != 0) {
                int i9 = iA5 + ul0VarB3.a;
                i4 = ((ByteBuffer) ul0VarB3.d).getInt(((ByteBuffer) ul0VarB3.d).getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            wl0Var.a(uc1Var, 0, i4 - 1);
        }
    }

    public void a(j30 j30Var) {
        if (((ArrayList) this.c).contains(j30Var)) {
            zy.s("Fragment already added: ", j30Var);
            return;
        }
        synchronized (((ArrayList) this.c)) {
            ((ArrayList) this.c).add(j30Var);
        }
        j30Var.m = true;
    }

    public void b(vm0 vm0Var) {
        if (vm0Var.e != null) {
            f();
            ((r11) this.b).a('\n');
        }
    }

    public mv0 c() {
        if (((ga0) this.c) != null) {
            return new mv0(this);
        }
        s1.f("url == null");
        return null;
    }

    public synchronized void d() {
        Iterator it = ((ArrayDeque) this.d).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            throw null;
        }
        Iterator it2 = ((ArrayDeque) this.b).iterator();
        if (it2.hasNext()) {
            if (it2.next() != null) {
                throw new ClassCastException();
            }
            throw null;
        }
        Iterator it3 = ((ArrayDeque) this.e).iterator();
        while (it3.hasNext()) {
            ((ht0) it3.next()).a();
        }
    }

    public void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((t01) this.d).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                e(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public void f() {
        r11 r11Var = (r11) this.b;
        StringBuilder sb = r11Var.b;
        if (sb.length() <= 0 || '\n' == sb.charAt(sb.length() - 1)) {
            return;
        }
        r11Var.a('\n');
    }

    public j30 g(String str) {
        a aVar = (a) ((HashMap) this.d).get(str);
        if (aVar != null) {
            return aVar.c;
        }
        return null;
    }

    @Override // defpackage.wr0
    public Object get() {
        return new g7((Executor) ((wr0) this.c).get(), (dx0) ((wr0) this.d).get(), (ra) ((ra) this.b).get(), (dx0) ((wr0) this.e).get());
    }

    public j30 h(String str) {
        for (a aVar : ((HashMap) this.d).values()) {
            if (aVar != null) {
                j30 j30VarH = aVar.c;
                if (!str.equals(j30VarH.g)) {
                    j30VarH = j30VarH.v.c.h(str);
                }
                if (j30VarH != null) {
                    return j30VarH;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(defpackage.ht0 r12) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.e
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0
            monitor-enter(r11)
            boolean r12 = r0.remove(r12)     // Catch: java.lang.Throwable -> Lba
            if (r12 == 0) goto Lbd
            monitor-exit(r11)     // Catch: java.lang.Throwable -> Lba
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            monitor-enter(r11)
            java.lang.Object r0 = r11.d     // Catch: java.lang.Throwable -> L50
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0     // Catch: java.lang.Throwable -> L50
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L50
        L1a:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L50
            r2 = 0
            if (r1 == 0) goto L66
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L50
            if (r1 != 0) goto L60
            java.lang.Object r1 = r11.b     // Catch: java.lang.Throwable -> L50
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch: java.lang.Throwable -> L50
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L50
            r3 = 64
            if (r1 < r3) goto L34
            goto L66
        L34:
            java.lang.Object r1 = r11.b     // Catch: java.lang.Throwable -> L50
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch: java.lang.Throwable -> L50
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L50
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L50
            if (r3 != 0) goto L53
            r0.remove()     // Catch: java.lang.Throwable -> L50
            r12.add(r2)     // Catch: java.lang.Throwable -> L50
            java.lang.Object r1 = r11.b     // Catch: java.lang.Throwable -> L50
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch: java.lang.Throwable -> L50
            r1.add(r2)     // Catch: java.lang.Throwable -> L50
            goto L1a
        L50:
            r0 = move-exception
            r12 = r0
            goto Lb8
        L53:
            java.lang.Object r12 = r1.next()     // Catch: java.lang.Throwable -> L50
            if (r12 != 0) goto L5a
            throw r2     // Catch: java.lang.Throwable -> L50
        L5a:
            java.lang.ClassCastException r12 = new java.lang.ClassCastException     // Catch: java.lang.Throwable -> L50
            r12.<init>()     // Catch: java.lang.Throwable -> L50
            throw r12     // Catch: java.lang.Throwable -> L50
        L60:
            java.lang.ClassCastException r12 = new java.lang.ClassCastException     // Catch: java.lang.Throwable -> L50
            r12.<init>()     // Catch: java.lang.Throwable -> L50
            throw r12     // Catch: java.lang.Throwable -> L50
        L66:
            monitor-enter(r11)     // Catch: java.lang.Throwable -> L50
            java.lang.Object r0 = r11.b     // Catch: java.lang.Throwable -> Lb4
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0     // Catch: java.lang.Throwable -> Lb4
            r0.size()     // Catch: java.lang.Throwable -> Lb4
            java.lang.Object r0 = r11.e     // Catch: java.lang.Throwable -> Lb4
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0     // Catch: java.lang.Throwable -> Lb4
            r0.size()     // Catch: java.lang.Throwable -> Lb4
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L50
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L50
            int r0 = r12.size()
            if (r0 <= 0) goto Lb3
            r0 = 0
            java.lang.Object r12 = r12.get(r0)
            if (r12 != 0) goto Lb0
            monitor-enter(r11)
            java.lang.Object r12 = r11.c     // Catch: java.lang.Throwable -> La9
            java.util.concurrent.ThreadPoolExecutor r12 = (java.util.concurrent.ThreadPoolExecutor) r12     // Catch: java.lang.Throwable -> La9
            if (r12 != 0) goto Lac
            java.util.concurrent.ThreadPoolExecutor r3 = new java.util.concurrent.ThreadPoolExecutor     // Catch: java.lang.Throwable -> La9
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> La9
            java.util.concurrent.SynchronousQueue r9 = new java.util.concurrent.SynchronousQueue     // Catch: java.lang.Throwable -> La9
            r9.<init>()     // Catch: java.lang.Throwable -> La9
            java.lang.String r12 = "OkHttp Dispatcher"
            byte[] r1 = defpackage.be1.a     // Catch: java.lang.Throwable -> La9
            ae1 r10 = new ae1     // Catch: java.lang.Throwable -> La9
            r10.<init>(r12, r0)     // Catch: java.lang.Throwable -> La9
            r4 = 0
            r5 = 2147483647(0x7fffffff, float:NaN)
            r6 = 60
            r3.<init>(r4, r5, r6, r8, r9, r10)     // Catch: java.lang.Throwable -> La9
            r11.c = r3     // Catch: java.lang.Throwable -> La9
            goto Lac
        La9:
            r0 = move-exception
            r12 = r0
            goto Lae
        Lac:
            monitor-exit(r11)
            throw r2
        Lae:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> La9
            throw r12
        Lb0:
            defpackage.s1.d()
        Lb3:
            return
        Lb4:
            r0 = move-exception
            r12 = r0
            monitor-exit(r11)     // Catch: java.lang.Throwable -> Lb4
            throw r12     // Catch: java.lang.Throwable -> L50
        Lb8:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L50
            throw r12
        Lba:
            r0 = move-exception
            r12 = r0
            goto Lc5
        Lbd:
            java.lang.AssertionError r12 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> Lba
            java.lang.String r0 = "Call wasn't in-flight!"
            r12.<init>(r0)     // Catch: java.lang.Throwable -> Lba
            throw r12     // Catch: java.lang.Throwable -> Lba
        Lc5:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> Lba
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g7.i(ht0):void");
    }

    public i31 j(e2 e2Var) {
        ArrayList arrayList = (ArrayList) this.b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            i31 i31Var = (i31) arrayList.get(i);
            if (i31Var != null && i31Var.b == e2Var) {
                return i31Var;
            }
        }
        i31 i31Var2 = new i31((Context) this.d, e2Var);
        arrayList.add(i31Var2);
        return i31Var2;
    }

    public ArrayList k() {
        ArrayList arrayList = new ArrayList();
        for (a aVar : ((HashMap) this.d).values()) {
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public ArrayList l() {
        ArrayList arrayList = new ArrayList();
        for (a aVar : ((HashMap) this.d).values()) {
            if (aVar != null) {
                arrayList.add(aVar.c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public List m() {
        ArrayList arrayList;
        if (((ArrayList) this.c).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.c)) {
            arrayList = new ArrayList((ArrayList) this.c);
        }
        return arrayList;
    }

    public Drawable n(String str) {
        int identifier;
        Resources resources = (Resources) this.e;
        Intent launchIntentForPackage = ((PackageManager) this.c).getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            si0.b("Can't get icon for non launchable intents.");
        }
        String str2 = (String) ((HashMap) this.d).get(launchIntentForPackage.getComponent().toString());
        if (str2 == null || str2.isEmpty() || (identifier = resources.getIdentifier(str2, "drawable", (String) this.b)) <= 0) {
            return null;
        }
        return resources.getDrawable(identifier, null);
    }

    public int o() {
        return ((r11) this.b).b.length();
    }

    @Override // defpackage.ni
    public void onCancel() {
        View view = (View) this.c;
        view.clearAnimation();
        ((ViewGroup) this.d).endViewTransition(view);
        ((vs) this.b).d();
        if (y30.I(2)) {
            Log.v("FragmentManager", "Animation from operation " + ((v11) this.e) + " has been cancelled.");
        }
    }

    public void p(a aVar) {
        j30 j30Var = aVar.c;
        String str = j30Var.g;
        HashMap map = (HashMap) this.d;
        if (map.get(str) != null) {
            return;
        }
        map.put(j30Var.g, aVar);
        if (j30Var.D) {
            boolean z = j30Var.C;
            a40 a40Var = (a40) this.e;
            if (z) {
                a40Var.c(j30Var);
            } else {
                a40Var.f(j30Var);
            }
            j30Var.D = false;
        }
        if (y30.I(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + j30Var);
        }
    }

    public void q(a aVar) {
        j30 j30Var = aVar.c;
        if (j30Var.C) {
            ((a40) this.e).f(j30Var);
        }
        if (((a) ((HashMap) this.d).put(j30Var.g, null)) != null && y30.I(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + j30Var);
        }
    }

    public void r(String str, xy0 xy0Var) {
        if (str == null) {
            zy.r("method == null");
            return;
        }
        if (str.length() == 0) {
            zy.n("method.length() == 0");
            return;
        }
        if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
            zy.n(l11.j("method ", str, " must have a request body."));
        } else {
            this.b = str;
        }
    }

    public boolean s(e2 e2Var, MenuItem menuItem) {
        return ((ActionMode.Callback) this.c).onActionItemClicked(j(e2Var), new gl0((Context) this.d, (n31) menuItem));
    }

    public boolean t(e2 e2Var, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.c;
        i31 i31VarJ = j(e2Var);
        t01 t01Var = (t01) this.e;
        Menu sl0Var = (Menu) t01Var.get(menu);
        if (sl0Var == null) {
            sl0Var = new sl0((Context) this.d, (zk0) menu);
            t01Var.put(menu, sl0Var);
        }
        return callback.onCreateActionMode(i31VarJ, sl0Var);
    }

    public void u(String str) {
        ((jj) this.d).g(str);
    }

    public void v(vm0 vm0Var, int i) {
        Class<?> cls = vm0Var.getClass();
        h7 h7Var = (h7) this.c;
        qg qgVar = (qg) ((Map) ((tb0) h7Var.f).c).get(cls);
        if (qgVar != null) {
            Object objA = qgVar.a(h7Var, (kj0) this.d);
            r11 r11Var = (r11) this.b;
            StringBuilder sb = r11Var.b;
            int length = sb.length();
            int length2 = sb.length();
            if (length <= i || i < 0 || length > length2) {
                return;
            }
            r11.c(r11Var, objA, i, length);
        }
    }

    public void w(String str) {
        if (str == null) {
            zy.r("url == null");
            return;
        }
        String strConcat = str.regionMatches(true, 0, "ws:", 0, 3) ? "http:".concat(str.substring(3)) : str.regionMatches(true, 0, "wss:", 0, 4) ? "https:".concat(str.substring(4)) : str;
        fa0 fa0Var = new fa0();
        fa0Var.b(null, strConcat);
        this.c = fa0Var.a();
    }

    public void x(vm0 vm0Var) {
        jj0 jj0Var = (jj0) ((Map) this.e).get(vm0Var.getClass());
        if (jj0Var != null) {
            jj0Var.a(this, vm0Var);
        } else {
            y(vm0Var);
        }
    }

    public void y(vm0 vm0Var) {
        vm0 vm0Var2 = vm0Var.b;
        while (vm0Var2 != null) {
            vm0 vm0Var3 = vm0Var2.e;
            vm0Var2.a(this);
            vm0Var2 = vm0Var3;
        }
    }

    public void z(Context context, String str) {
        if (context == null) {
            zy.n("need an Android context");
        } else {
            this.c = new pn0(6, context, str);
            this.d = new pn0(7, context, str);
        }
    }

    public g7(String str) {
        this.d = new HashMap();
        PackageManager packageManager = App.c.getPackageManager();
        this.c = packageManager;
        this.b = str;
        try {
            Resources resourcesForApplication = packageManager.getResourcesForApplication(str);
            this.e = resourcesForApplication;
            try {
                InputStream inputStreamOpen = resourcesForApplication.getAssets().open("appfilter.xml");
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setInput(new InputStreamReader(inputStreamOpen));
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    if (eventType == 2 && "item".equals(xmlPullParserNewPullParser.getName())) {
                        String attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "component");
                        if (!((HashMap) this.d).containsKey(attributeValue)) {
                            ((HashMap) this.d).put(attributeValue, xmlPullParserNewPullParser.getAttributeValue(null, "drawable"));
                        }
                    }
                }
                inputStreamOpen.close();
            } catch (IOException unused) {
            } catch (XmlPullParserException unused2) {
                si0.b("Can't parse icon pack appfilter.xml");
            }
        } catch (PackageManager.NameNotFoundException e) {
            si0.b("IconPack constructor crash: " + e);
            ((SharedPreferences) pn0.t().d).edit().putString(oq0.b1.name(), "").apply();
            si0.b("IconPack constructor resetIconPackName");
            zy.m(e);
            throw null;
        }
    }

    public /* synthetic */ g7(Object obj, Object obj2, Object obj3, Object obj4) {
        this.c = obj;
        this.d = obj2;
        this.b = obj3;
        this.e = obj4;
    }

    public g7(int i) {
        switch (i) {
            case 3:
                this.c = new tp0(10);
                this.d = new t01(0);
                this.b = new ArrayList();
                this.e = new HashSet();
                break;
            case 4:
                this.d = new ArrayDeque();
                this.b = new ArrayDeque();
                this.e = new ArrayDeque();
                break;
            case 5:
                this.c = new ArrayList();
                this.d = new HashMap();
                this.b = new HashMap();
                break;
            case 6:
            case 7:
            case 8:
            case 10:
            case 12:
            default:
                this.c = null;
                this.d = null;
                this.b = null;
                this.e = null;
                break;
            case 9:
                this.c = new ArrayList();
                this.d = new ArrayList();
                this.b = new ArrayList();
                this.e = ou.p;
                break;
            case 11:
                this.e = Collections.EMPTY_MAP;
                this.b = "GET";
                this.d = new jj(1);
                break;
            case 13:
                this.c = new kb(0);
                this.d = new SparseArray();
                this.b = new vi0();
                this.e = new kb(0);
                break;
        }
    }
}
