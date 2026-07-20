package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ClipDescription;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.Trace;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.quickcursor.R;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.Adler32;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ra implements u00, sb0, z00 {
    public static volatile ra f;
    public static final Object g = new Object();
    public static ra h;
    public final /* synthetic */ int b;
    public Object c;
    public Object d;
    public Object e;

    public ra(g7 g7Var, c70 c70Var, fs fsVar, Set set) {
        this.b = 9;
        this.c = c70Var;
        this.d = g7Var;
        this.e = fsVar;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            N(str, 0, str.length(), 1, true, new c1(str, 1));
        }
    }

    public static ra B(Context context) {
        if (f == null) {
            synchronized (g) {
                try {
                    if (f == null) {
                        f = new ra(context);
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public static ra L(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ra(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ra M(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new ra(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public static ra n(z7 z7Var) {
        ArrayList arrayList = new ArrayList(3);
        TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
        arrayList.add(new zo());
        arrayList.add(new zo());
        if (arrayList.isEmpty()) {
            s1.f("No plugins were added to this builder. Use #usePlugin method to add them");
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        HashSet hashSet = new HashSet(3);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            zo zoVar = (zo) obj;
            if (!arrayList2.contains(zoVar)) {
                if (hashSet.contains(zoVar)) {
                    zy.s("Cyclic dependency chain found: ", hashSet);
                    return null;
                }
                hashSet.add(zoVar);
                zoVar.getClass();
                hashSet.remove(zoVar);
                if (!arrayList2.contains(zoVar)) {
                    if (zo.class.isAssignableFrom(zoVar.getClass())) {
                        arrayList2.add(0, zoVar);
                    } else {
                        arrayList2.add(zoVar);
                    }
                }
            }
        }
        int i2 = 9;
        g7 g7Var = new g7(9);
        float f2 = z7Var.getResources().getDisplayMetrics().density;
        ij0 ij0Var = new ij0();
        ij0Var.d = (int) ((8.0f * f2) + 0.5f);
        ij0Var.a = (int) ((24.0f * f2) + 0.5f);
        int i3 = (int) ((4.0f * f2) + 0.5f);
        ij0Var.b = i3;
        int i4 = (int) ((1.0f * f2) + 0.5f);
        ij0Var.c = i4;
        ij0Var.e = i4;
        ij0Var.f = i3;
        f71 f71Var = new f71();
        kj0 kj0Var = new kj0(0);
        HashMap map = new HashMap(3);
        int size2 = arrayList2.size();
        int i5 = 0;
        while (true) {
            int i6 = 8;
            if (i5 >= size2) {
                break;
            }
            zo zoVar2 = (zo) arrayList2.get(i5);
            zoVar2.getClass();
            kj0Var.a(u41.class, new yo(zoVar2));
            kj0Var.a(f31.class, new xo(6));
            kj0Var.a(iy.class, new xo(7));
            kj0Var.a(mg.class, new xo(i6));
            kj0Var.a(zk.class, new xo(i2));
            kj0Var.a(m10.class, new xo(10));
            kj0Var.a(ab0.class, new xo(11));
            kj0Var.a(qa0.class, new xo(12));
            kj0Var.a(qh.class, new xo(14));
            kj0Var.a(po0.class, new xo(14));
            kj0Var.a(dh0.class, new xo(13));
            kj0Var.a(m51.class, new xo(0));
            kj0Var.a(x70.class, new xo(1));
            kj0Var.a(j11.class, new xo(2));
            kj0Var.a(t70.class, new xo(3));
            kj0Var.a(dp0.class, new xo(4));
            kj0Var.a(sg0.class, new xo(5));
            qg qgVar = new qg(1);
            map.put(f31.class, new qg(7));
            map.put(iy.class, new qg(3));
            map.put(mg.class, new qg(0));
            map.put(zk.class, new qg(2));
            map.put(m10.class, qgVar);
            map.put(ab0.class, qgVar);
            map.put(dh0.class, new qg(6));
            map.put(x70.class, new qg(4));
            map.put(sg0.class, new qg(5));
            map.put(m51.class, new qg(8));
            arrayList2 = arrayList2;
            size2 = size2;
            kj0Var = kj0Var;
            i5++;
            g7Var = g7Var;
            i2 = 9;
        }
        g7 g7Var2 = g7Var;
        ArrayList arrayList3 = arrayList2;
        kj0 kj0Var2 = kj0Var;
        ij0 ij0Var2 = new ij0();
        ij0Var2.a = ij0Var.a;
        ij0Var2.b = ij0Var.b;
        ij0Var2.c = ij0Var.c;
        ij0Var2.d = ij0Var.d;
        ij0Var2.e = ij0Var.e;
        ij0Var2.f = ij0Var.f;
        tb0 tb0Var = new tb0(5, Collections.unmodifiableMap(map));
        f71Var.b = ij0Var2;
        f71Var.h = tb0Var;
        if (((ix) f71Var.c) == null) {
            f71Var.c = new ix(8);
        }
        if (((ix) f71Var.d) == null) {
            f71Var.d = new ix(27);
        }
        int i7 = 19;
        if (((ow0) f71Var.e) == null) {
            f71Var.e = new ow0(i7);
        }
        if (((ow0) f71Var.f) == null) {
            f71Var.f = new ow0(18);
        }
        if (((ix) f71Var.g) == null) {
            f71Var.g = new ix(i7);
        }
        i9 i9Var = new i9(kj0Var2, new h7(f71Var), 25, false);
        g7 g7Var3 = new g7();
        ArrayList arrayList4 = (ArrayList) g7Var2.c;
        LinkedHashSet linkedHashSet = (LinkedHashSet) g7Var2.e;
        LinkedHashSet linkedHashSet2 = ou.p;
        ArrayList arrayList5 = new ArrayList();
        arrayList5.addAll(arrayList4);
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList5.add(ou.q.get((Class) it.next()));
        }
        g7Var3.c = arrayList5;
        g7Var3.b = new ow0(21);
        g7Var3.e = (ArrayList) g7Var2.b;
        ArrayList arrayList6 = (ArrayList) g7Var2.d;
        g7Var3.d = arrayList6;
        new ob0(new i9(arrayList6, Collections.EMPTY_MAP, 23, false));
        return new ra(g7Var3, i9Var, Collections.unmodifiableList(arrayList3));
    }

    public static boolean o(Editable editable, KeyEvent keyEvent, boolean z) {
        vc1[] vc1VarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (vc1VarArr = (vc1[]) editable.getSpans(selectionStart, selectionEnd, vc1.class)) != null && vc1VarArr.length > 0) {
                for (vc1 vc1Var : vc1VarArr) {
                    int spanStart = editable.getSpanStart(vc1Var);
                    int spanEnd = editable.getSpanEnd(vc1Var);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void t(ra raVar, fw fwVar) {
        long[] jArr = (long[]) raVar.c;
        ra raVar2 = fwVar.a;
        long[] jArr2 = (long[]) raVar2.c;
        long[] jArr3 = fwVar.b;
        lc1.W(jArr, jArr2, jArr3);
        long[] jArr4 = (long[]) raVar.d;
        long[] jArr5 = (long[]) raVar2.d;
        long[] jArr6 = (long[]) raVar2.e;
        lc1.W(jArr4, jArr5, jArr6);
        lc1.W((long[]) raVar.e, jArr6, jArr3);
    }

    public Typeface A(int i, int i2, aa aaVar) {
        int resourceId = ((TypedArray) this.c).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.d) == null) {
            this.d = new TypedValue();
        }
        Context context = (Context) this.e;
        TypedValue typedValue = (TypedValue) this.d;
        ThreadLocal threadLocal = ew0.a;
        if (context.isRestricted()) {
            return null;
        }
        return ew0.b(context, resourceId, typedValue, i2, aaVar, true, false);
    }

    public Method C(Class cls) {
        Method method;
        Class cls2;
        try {
            method = cls.getMethod((String) this.d, (Class[]) this.e);
        } catch (NoSuchMethodException unused) {
        }
        try {
            if ((method.getModifiers() & 1) == 0) {
                method = null;
            }
        } catch (NoSuchMethodException unused2) {
        }
        if (method == null || (cls2 = (Class) this.c) == null || cls2.isAssignableFrom(method.getReturnType())) {
            return method;
        }
        return null;
    }

    public int D(int i) {
        bk bkVar = (bk) this.d;
        if (i < 0) {
            return -1;
        }
        int childCount = ((pt0) this.c).a.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int iC = i - (i2 - bkVar.c(i2));
            if (iC == 0) {
                while (bkVar.e(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iC;
        }
        return -1;
    }

    public View E(int i) {
        return ((pt0) this.c).a.getChildAt(i);
    }

    public int F() {
        return ((pt0) this.c).a.getChildCount();
    }

    public boolean G(CharSequence charSequence, int i, int i2, uc1 uc1Var) {
        if ((uc1Var.c & 3) == 0) {
            fs fsVar = (fs) this.e;
            ul0 ul0VarB = uc1Var.b();
            int iA = ul0VarB.a(8);
            if (iA != 0) {
                ((ByteBuffer) ul0VarB.d).getShort(iA + ul0VarB.a);
            }
            fsVar.getClass();
            ThreadLocal threadLocal = fs.b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            TextPaint textPaint = fsVar.a;
            String string = sb.toString();
            int i3 = ap0.a;
            boolean zHasGlyph = textPaint.hasGlyph(string);
            int i4 = uc1Var.c & 4;
            uc1Var.c = zHasGlyph ? i4 | 2 : i4 | 1;
        }
        return (uc1Var.c & 3) == 2;
    }

    public void H(View view) {
        ((ArrayList) this.e).add(view);
        pt0 pt0Var = (pt0) this.c;
        pu0 pu0VarJ = RecyclerView.J(view);
        if (pu0VarJ != null) {
            View view2 = pu0VarJ.a;
            RecyclerView recyclerView = pt0Var.a;
            int i = pu0VarJ.q;
            if (i != -1) {
                pu0VarJ.p = i;
            } else {
                WeakHashMap weakHashMap = uf1.a;
                pu0VarJ.p = view2.getImportantForAccessibility();
            }
            if (recyclerView.N()) {
                pu0VarJ.q = 4;
                recyclerView.t0.add(pu0VarJ);
            } else {
                WeakHashMap weakHashMap2 = uf1.a;
                view2.setImportantForAccessibility(4);
            }
        }
    }

    public Object I(SSLSocket sSLSocket, Object... objArr) {
        Method methodC = C(sSLSocket.getClass());
        if (methodC == null) {
            throw new AssertionError("Method " + ((String) this.d) + " not supported for object " + sSLSocket);
        }
        try {
            return methodC.invoke(sSLSocket, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodC);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public void J(SSLSocket sSLSocket, Object... objArr) {
        try {
            Method methodC = C(sSLSocket.getClass());
            if (methodC == null) {
                return;
            }
            try {
                methodC.invoke(sSLSocket, objArr);
            } catch (IllegalAccessException unused) {
            }
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public boolean K(int i, ln lnVar, vn vnVar) {
        se seVar = (se) this.d;
        int[] iArr = vnVar.p0;
        int[] iArr2 = vnVar.t;
        seVar.a = iArr[0];
        seVar.b = iArr[1];
        seVar.c = vnVar.q();
        seVar.d = vnVar.k();
        seVar.i = false;
        seVar.j = i;
        boolean z = seVar.a == 3;
        boolean z2 = seVar.b == 3;
        boolean z3 = z && vnVar.W > 0.0f;
        boolean z4 = z2 && vnVar.W > 0.0f;
        if (z3 && iArr2[0] == 4) {
            seVar.a = 1;
        }
        if (z4 && iArr2[1] == 4) {
            seVar.b = 1;
        }
        lnVar.b(vnVar, seVar);
        vnVar.O(seVar.e);
        vnVar.L(seVar.f);
        vnVar.E = seVar.h;
        vnVar.I(seVar.g);
        seVar.j = 0;
        return seVar.i;
    }

    public Object N(CharSequence charSequence, int i, int i2, int i3, boolean z, cy cyVar) {
        int i4;
        char c;
        wl0 wl0Var = (wl0) ((g7) this.d).b;
        tq tqVar = new tq();
        tqVar.a = 1;
        tqVar.d = wl0Var;
        tqVar.e = wl0Var;
        int iCodePointAt = Character.codePointAt(charSequence, i);
        boolean zE = true;
        int i5 = 0;
        int iCharCount = i;
        loop0: while (true) {
            i4 = iCharCount;
            while (iCharCount < i2 && i5 < i3 && zE) {
                SparseArray sparseArray = ((wl0) tqVar.e).a;
                wl0 wl0Var2 = sparseArray == null ? null : (wl0) sparseArray.get(iCodePointAt);
                if (tqVar.a == 2) {
                    if (wl0Var2 != null) {
                        tqVar.e = wl0Var2;
                        tqVar.c++;
                    } else {
                        if (iCodePointAt == 65038) {
                            tqVar.a();
                        } else if (iCodePointAt != 65039) {
                            wl0 wl0Var3 = (wl0) tqVar.e;
                            if (wl0Var3.b != null) {
                                if (tqVar.c != 1) {
                                    tqVar.f = wl0Var3;
                                    tqVar.a();
                                } else if (tqVar.b()) {
                                    tqVar.f = (wl0) tqVar.e;
                                    tqVar.a();
                                } else {
                                    tqVar.a();
                                }
                                c = 3;
                            } else {
                                tqVar.a();
                            }
                        }
                        c = 1;
                    }
                    c = 2;
                } else if (wl0Var2 == null) {
                    tqVar.a();
                    c = 1;
                } else {
                    tqVar.a = 2;
                    tqVar.e = wl0Var2;
                    tqVar.c = 1;
                    c = 2;
                }
                tqVar.b = iCodePointAt;
                if (c == 1) {
                    iCharCount = Character.charCount(Character.codePointAt(charSequence, i4)) + i4;
                    if (iCharCount < i2) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                } else if (c == 2) {
                    int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                    if (iCharCount2 < i2) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                    }
                    iCharCount = iCharCount2;
                } else if (c == 3) {
                    if (z || !G(charSequence, i4, iCharCount, ((wl0) tqVar.f).b)) {
                        zE = cyVar.e(charSequence, i4, iCharCount, ((wl0) tqVar.f).b);
                        i5++;
                    }
                }
            }
            break loop0;
        }
        if (tqVar.a == 2 && ((wl0) tqVar.e).b != null && ((tqVar.c > 1 || tqVar.b()) && i5 < i3 && zE && (z || !G(charSequence, i4, iCharCount, ((wl0) tqVar.e).b)))) {
            cyVar.e(charSequence, i4, iCharCount, ((wl0) tqVar.e).b);
        }
        return cyVar.a();
    }

    public void O() {
        ((TypedArray) this.c).recycle();
    }

    public void P(hd hdVar, int i, boolean z) {
        fd fdVar = (fd) this.d;
        Context context = (Context) this.e;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        String str = hdVar.a;
        adler32.update(str.getBytes(Charset.forName("UTF-8")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        tq0 tq0Var = hdVar.c;
        adler32.update(byteBufferAllocate.putInt(vq0.a(tq0Var)).array());
        byte[] bArr = hdVar.b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i2 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i2 >= i) {
                        lc1.p("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", hdVar);
                        return;
                    }
                }
            }
        }
        Cursor cursorRawQuery = ((dx0) this.c).a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str, String.valueOf(vq0.a(tq0Var))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            builder.setMinimumLatency(fdVar.a(tq0Var, jLongValue, i));
            Set set = ((gd) fdVar.b.get(tq0Var)).c;
            if (set.contains(tx0.b)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(tx0.d)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(tx0.c)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", str);
            persistableBundle.putInt("priority", vq0.a(tq0Var));
            if (bArr != null) {
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            }
            builder.setExtras(persistableBundle);
            Object[] objArr = {hdVar, Integer.valueOf(value), Long.valueOf(fdVar.a(tq0Var, jLongValue, i)), lValueOf, Integer.valueOf(i)};
            String strL = lc1.L("JobInfoScheduler");
            if (Log.isLoggable(strL, 3)) {
                Log.d(strL, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    public void Q(xc xcVar) {
        ay0 ay0Var = new ay0(14);
        d91 d91Var = (d91) this.e;
        hd hdVar = (hd) this.c;
        uy uyVar = (uy) this.d;
        ss ssVar = d91Var.c;
        ra raVarA = hd.a();
        raVarA.R(hdVar.a);
        raVarA.e = tq0.b;
        raVarA.d = hdVar.b;
        hd hdVarM = raVarA.m();
        a9 a9Var = new a9();
        a9Var.f = new HashMap();
        a9Var.d = Long.valueOf(d91Var.a.d());
        a9Var.e = Long.valueOf(d91Var.b.d());
        a9Var.a = "PLAY_BILLING_LIBRARY";
        a9Var.c = new ry(uyVar, xcVar.a.b());
        a9Var.b = null;
        ssVar.b.execute(new mf(ssVar, hdVarM, ay0Var, a9Var.c()));
    }

    public void R(String str) {
        if (str != null) {
            this.c = str;
        } else {
            zy.r("Null backendName");
        }
    }

    public void S(TextView textView, String str) {
        List list = (List) this.e;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zo) it.next()).getClass();
        }
        g7 g7Var = (g7) this.c;
        if (str == null) {
            zy.r("input must not be null");
            return;
        }
        ou ouVar = new ou((ArrayList) g7Var.c, (ow0) g7Var.b, (ArrayList) g7Var.d);
        boolean z = false;
        int i = 0;
        while (true) {
            int length = str.length();
            int i2 = i;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                char cCharAt = str.charAt(i2);
                if (cCharAt == '\n' || cCharAt == '\r') {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                break;
            }
            ouVar.i(str.substring(i, i2));
            i = i2 + 1;
            if (i < str.length() && str.charAt(i2) == '\r' && str.charAt(i) == '\n') {
                i = i2 + 2;
            }
        }
        if (str.length() > 0 && (i == 0 || i < str.length())) {
            ouVar.i(str.substring(i));
        }
        ouVar.f(ouVar.n);
        i9 i9Var = new i9(ouVar.k, ouVar.m, 23, z);
        ouVar.j.getClass();
        ob0 ob0Var = new ob0(i9Var);
        Iterator it2 = ouVar.o.iterator();
        while (it2.hasNext()) {
            ((k) it2.next()).f(ob0Var);
        }
        x80 x80Var = (x80) ouVar.l.b;
        Iterator it3 = ((ArrayList) g7Var.e).iterator();
        if (it3.hasNext()) {
            throw l11.h(it3);
        }
        Iterator it4 = list.iterator();
        while (it4.hasNext()) {
            ((zo) it4.next()).getClass();
        }
        i9 i9Var2 = (i9) this.d;
        kj0 kj0Var = (kj0) i9Var2.c;
        h7 h7Var = (h7) i9Var2.d;
        kj0 kj0Var2 = new kj0(1);
        new ix(9);
        r11 r11Var = new r11();
        Map mapUnmodifiableMap = Collections.unmodifiableMap(kj0Var.a);
        g7 g7Var2 = new g7();
        g7Var2.c = h7Var;
        g7Var2.d = kj0Var2;
        g7Var2.b = r11Var;
        g7Var2.e = mapUnmodifiableMap;
        g7Var2.x(x80Var);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            ((zo) it5.next()).getClass();
        }
        r11 r11Var2 = (r11) g7Var2.b;
        SpannableStringBuilder p11Var = new p11(r11Var2.b);
        for (o11 o11Var : r11Var2.c) {
            p11Var.setSpan(o11Var.a, o11Var.b, o11Var.c, o11Var.d);
        }
        if (TextUtils.isEmpty(p11Var) && !TextUtils.isEmpty(str)) {
            p11Var = new SpannableStringBuilder(str);
        }
        Iterator it6 = list.iterator();
        while (it6.hasNext()) {
            ((zo) it6.next()).getClass();
            qo0[] qo0VarArr = (qo0[]) p11Var.getSpans(0, p11Var.length(), qo0.class);
            if (qo0VarArr != null) {
                TextPaint paint = textView.getPaint();
                for (qo0 qo0Var : qo0VarArr) {
                    qo0Var.e = (int) (paint.measureText(qo0Var.c) + 0.5f);
                }
            }
            Object[] objArr = (h51[]) p11Var.getSpans(0, p11Var.length(), h51.class);
            if (objArr != null) {
                for (Object obj : objArr) {
                    p11Var.removeSpan(obj);
                }
            }
            Object h51Var = new h51();
            new WeakReference(textView);
            p11Var.setSpan(h51Var, 0, p11Var.length(), 18);
        }
        textView.setText(p11Var, TextView.BufferType.SPANNABLE);
        Iterator it7 = list.iterator();
        while (it7.hasNext()) {
            ((zo) it7.next()).getClass();
            if (textView.getMovementMethod() == null) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    public void T(wn wnVar, int i, int i2, int i3) {
        wnVar.getClass();
        int i4 = wnVar.b0;
        int i5 = wnVar.c0;
        wnVar.b0 = 0;
        wnVar.c0 = 0;
        wnVar.O(i2);
        wnVar.L(i3);
        if (i4 < 0) {
            wnVar.b0 = 0;
        } else {
            wnVar.b0 = i4;
        }
        if (i5 < 0) {
            wnVar.c0 = 0;
        } else {
            wnVar.c0 = i5;
        }
        wn wnVar2 = (wn) this.e;
        wnVar2.t0 = i;
        wnVar2.U();
    }

    public void U(View view) {
        if (((ArrayList) this.e).remove(view)) {
            pt0 pt0Var = (pt0) this.c;
            pu0 pu0VarJ = RecyclerView.J(view);
            if (pu0VarJ != null) {
                RecyclerView recyclerView = pt0Var.a;
                int i = pu0VarJ.p;
                if (recyclerView.N()) {
                    pu0VarJ.q = i;
                    recyclerView.t0.add(pu0VarJ);
                } else {
                    View view2 = pu0VarJ.a;
                    WeakHashMap weakHashMap = uf1.a;
                    view2.setImportantForAccessibility(i);
                }
                pu0VarJ.p = 0;
            }
        }
    }

    public void V(wn wnVar) {
        ArrayList arrayList = (ArrayList) this.c;
        arrayList.clear();
        int size = wnVar.q0.size();
        for (int i = 0; i < size; i++) {
            vn vnVar = (vn) wnVar.q0.get(i);
            int[] iArr = vnVar.p0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(vnVar);
            }
        }
        wnVar.s0.b = true;
    }

    @Override // defpackage.sb0
    public ClipDescription a() {
        return (ClipDescription) this.d;
    }

    @Override // defpackage.u00
    public int b() {
        int i = ((ExtendedFloatingActionButton) this.e).I;
        return i == -1 ? ((i9) this.c).b() : (i == 0 || i == -2) ? ((q00) this.d).c.getMeasuredHeight() : i;
    }

    @Override // defpackage.u00
    public int c() {
        return ((ExtendedFloatingActionButton) this.e).B;
    }

    @Override // defpackage.u00
    public int d() {
        return ((ExtendedFloatingActionButton) this.e).A;
    }

    @Override // defpackage.sb0
    public Object e() {
        return null;
    }

    @Override // defpackage.sb0
    public Uri f() {
        return (Uri) this.c;
    }

    @Override // defpackage.wr0
    public Object get() {
        switch (this.b) {
            case 17:
                return new ra((Context) ((wr0) this.c).get(), (dx0) ((wr0) this.d).get(), (fd) ((c70) this.e).get(), 12, false);
            default:
                return new d91(new ix(29), new c70(28), (ss) ((h7) this.c).get(), (vd1) ((f71) this.d).get(), (g7) ((g7) this.e).get());
        }
    }

    @Override // defpackage.sb0
    public Uri h() {
        return (Uri) this.e;
    }

    @Override // defpackage.u00
    public int i() {
        int i = ((ExtendedFloatingActionButton) this.e).H;
        return i == -1 ? ((i9) this.c).i() : (i == 0 || i == -2) ? ((q00) this.d).i() : i;
    }

    @Override // defpackage.u00
    public ViewGroup.LayoutParams j() {
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) this.e;
        int i = extendedFloatingActionButton.H;
        if (i == 0) {
            i = -2;
        }
        int i2 = extendedFloatingActionButton.I;
        return new ViewGroup.LayoutParams(i, i2 != 0 ? i2 : -2);
    }

    public void k(View view, int i, boolean z) {
        RecyclerView recyclerView = ((pt0) this.c).a;
        int childCount = i < 0 ? recyclerView.getChildCount() : D(i);
        ((bk) this.d).f(childCount, z);
        if (z) {
            H(view);
        }
        recyclerView.addView(view, childCount);
        RecyclerView.J(view);
        ArrayList arrayList = recyclerView.B;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((sc0) recyclerView.B.get(size)).getClass();
            }
        }
    }

    public void l(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView recyclerView = ((pt0) this.c).a;
        int childCount = i < 0 ? recyclerView.getChildCount() : D(i);
        ((bk) this.d).f(childCount, z);
        if (z) {
            H(view);
        }
        pu0 pu0VarJ = RecyclerView.J(view);
        if (pu0VarJ != null) {
            if (!pu0VarJ.k() && !pu0VarJ.p()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + pu0VarJ + recyclerView.z());
            }
            pu0VarJ.j &= -257;
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public hd m() {
        String strConcat = ((String) this.c) == null ? " backendName" : "";
        if (((tq0) this.e) == null) {
            strConcat = strConcat.concat(" priority");
        }
        if (strConcat.isEmpty()) {
            return new hd((String) this.c, (byte[]) this.d, (tq0) this.e);
        }
        s1.f("Missing required properties:".concat(strConcat));
        return null;
    }

    public void p(int i) {
        pu0 pu0VarJ;
        int iD = D(i);
        ((bk) this.d).g(iD);
        RecyclerView recyclerView = ((pt0) this.c).a;
        View childAt = recyclerView.getChildAt(iD);
        if (childAt != null && (pu0VarJ = RecyclerView.J(childAt)) != null) {
            if (pu0VarJ.k() && !pu0VarJ.p()) {
                throw new IllegalArgumentException("called detach on an already detached child " + pu0VarJ + recyclerView.z());
            }
            pu0VarJ.a(256);
        }
        recyclerView.detachViewFromParent(iD);
    }

    public void q(Bundle bundle) {
        HashSet hashSet = (HashSet) this.d;
        String string = ((Context) this.e).getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (fb0.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    r((Class) it.next(), hashSet2);
                }
            } catch (ClassNotFoundException e) {
                throw new cm(e);
            }
        }
    }

    public Object r(Class cls, HashSet hashSet) {
        Object objB;
        HashMap map = (HashMap) this.c;
        if (tk0.r()) {
            try {
                tk0.b(cls.getSimpleName());
            } finally {
                Trace.endSection();
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        if (map.containsKey(cls)) {
            objB = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                fb0 fb0Var = (fb0) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = fb0Var.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!map.containsKey(cls2)) {
                            r(cls2, hashSet);
                        }
                    }
                }
                objB = fb0Var.b((Context) this.e);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th) {
                throw new cm(th);
            }
        }
        return objB;
    }

    public void s(wk wkVar, ByteArrayOutputStream byteArrayOutputStream) {
        HashMap map = (HashMap) this.c;
        tr0 tr0Var = new tr0(byteArrayOutputStream, map, (HashMap) this.d, (kn0) this.e);
        kn0 kn0Var = (kn0) map.get(wk.class);
        if (kn0Var != null) {
            kn0Var.a(wkVar, tr0Var);
        } else {
            throw new vy("No encoder for " + wk.class);
        }
    }

    public String toString() {
        switch (this.b) {
            case 5:
                return ((bk) this.d).toString() + ", hidden list:" + ((ArrayList) this.e).size();
            case 24:
                StringBuilder sb = new StringBuilder(32);
                sb.append((String) this.c);
                sb.append('{');
                pn0 pn0Var = (pn0) ((pn0) this.d).c;
                String str = "";
                while (pn0Var != null) {
                    Object obj = pn0Var.d;
                    sb.append(str);
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r1.length() - 1);
                    }
                    pn0Var = (pn0) pn0Var.c;
                    str = ", ";
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public bg1 u(Class cls, String str) {
        bg1 bg1VarB;
        dg1 dg1Var = (dg1) this.d;
        eg1 eg1Var = (eg1) this.c;
        eg1Var.getClass();
        LinkedHashMap linkedHashMap = eg1Var.a;
        bg1 bg1Var = (bg1) linkedHashMap.get(str);
        if (cls.isInstance(bg1Var)) {
            bg1Var.getClass();
            return bg1Var;
        }
        jm0 jm0Var = new jm0((nq1) this.e);
        ((LinkedHashMap) jm0Var.a).put(c70.j, str);
        try {
            bg1VarB = dg1Var.h(cls, jm0Var);
        } catch (AbstractMethodError unused) {
            bg1VarB = dg1Var.b(cls);
        }
        bg1VarB.getClass();
        bg1 bg1Var2 = (bg1) linkedHashMap.put(str, bg1VarB);
        if (bg1Var2 != null) {
            bg1Var2.b();
        }
        return bg1VarB;
    }

    public View v(int i) {
        return ((pt0) this.c).a.getChildAt(D(i));
    }

    public int w() {
        return ((pt0) this.c).a.getChildCount() - ((ArrayList) this.e).size();
    }

    public ColorStateList x(int i) {
        int resourceId;
        ColorStateList colorStateListP;
        TypedArray typedArray = (TypedArray) this.c;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListP = xy0.p((Context) this.e, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListP;
    }

    public Drawable y(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.c;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : tk0.j((Context) this.e, resourceId);
    }

    public Drawable z(int i) {
        int resourceId;
        Drawable drawableD;
        if (!((TypedArray) this.c).hasValue(i) || (resourceId = ((TypedArray) this.c).getResourceId(i, 0)) == 0) {
            return null;
        }
        b9 b9VarA = b9.a();
        Context context = (Context) this.e;
        synchronized (b9VarA) {
            drawableD = b9VarA.a.d(context, resourceId, true);
        }
        return drawableD;
    }

    @Override // defpackage.sb0
    public void g() {
    }

    public /* synthetic */ ra(Object obj, Object obj2, Object obj3, int i) {
        this.b = i;
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
    }

    public /* synthetic */ ra(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.b = i;
        this.e = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public ra(String str) {
        this.b = 24;
        pn0 pn0Var = new pn0(21, false);
        this.d = pn0Var;
        this.e = pn0Var;
        this.c = str;
    }

    public ra(g7 g7Var, i9 i9Var, List list) {
        this.b = 13;
        TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
        this.c = g7Var;
        this.d = i9Var;
        this.e = list;
    }

    public ra(hd hdVar, uy uyVar, ow0 ow0Var, d91 d91Var) {
        this.b = 20;
        this.c = hdVar;
        this.d = uyVar;
        this.e = d91Var;
    }

    public ra(eg1 eg1Var, dg1 dg1Var, nq1 nq1Var) {
        this.b = 23;
        eg1Var.getClass();
        nq1Var.getClass();
        this.c = eg1Var;
        this.d = dg1Var;
        this.e = nq1Var;
    }

    public ra(pt0 pt0Var) {
        this.b = 5;
        this.c = pt0Var;
        this.d = new bk();
        this.e = new ArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ra(eg1 eg1Var, dg1 dg1Var) {
        this(eg1Var, dg1Var, sp.b);
        this.b = 23;
        eg1Var.getClass();
    }

    public ra(Context context, TypedArray typedArray) {
        this.b = 18;
        this.e = context;
        this.c = typedArray;
    }

    public ra(Runnable runnable) {
        this.b = 14;
        this.e = new CopyOnWriteArrayList();
        this.c = new HashMap();
        this.d = runnable;
    }

    public ra(Context context, LocationManager locationManager) {
        this.b = 22;
        this.d = new cb1();
        this.e = context;
        this.c = locationManager;
    }

    public ra(Context context) {
        this.b = 0;
        this.e = context.getApplicationContext();
        this.d = new HashSet();
        this.c = new HashMap();
    }

    public ra(wn wnVar) {
        this.b = 2;
        this.c = new ArrayList();
        this.d = new se();
        this.e = wnVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ra() {
        this(new long[10], new long[10], new long[10], 8);
        this.b = 8;
    }

    public ra(ra raVar) {
        this.b = 8;
        this.c = Arrays.copyOf((long[]) raVar.c, 10);
        this.d = Arrays.copyOf((long[]) raVar.d, 10);
        this.e = Arrays.copyOf((long[]) raVar.e, 10);
    }

    public /* synthetic */ ra(int i) {
        this.b = i;
    }
}
