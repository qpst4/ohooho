package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.quickcursor.R;
import com.quickcursor.android.activities.AboutActivity;
import com.quickcursor.android.activities.HowToUseActivity;
import com.quickcursor.android.activities.settings.BackupAndRestoreSettings;
import com.quickcursor.android.activities.settings.CursorSettings;
import com.quickcursor.android.activities.settings.DebugSettings;
import com.quickcursor.android.activities.settings.MissingPermissions;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ c(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        ?? r4;
        int i = this.b;
        int i2 = 2;
        ?? r42 = 1;
        r42 = 1;
        a4 a4Var = null;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                AboutActivity.a aVar = (AboutActivity.a) obj2;
                try {
                    aVar.Z().getIntent().putExtra("BUNDLE_TRANSLATION", false);
                    int top = aVar.a0.getChildAt(5).getTop() + aVar.Z().findViewById(R.id.settings).getTop();
                    NestedScrollView nestedScrollView = (NestedScrollView) aVar.Z().findViewById(R.id.nestedScrollView);
                    nestedScrollView.u(0 - nestedScrollView.getScrollX(), top - nestedScrollView.getScrollY(), 1000, false);
                    return;
                } catch (Exception unused) {
                    return;
                }
            case 1:
                ((t1) obj2).h0("verticalPosition").w();
                return;
            case 2:
                ((t1) obj2).h0("verticalPosition").w();
                return;
            case 3:
                r2 r2Var = (r2) obj2;
                ((InputMethodManager) r2Var.o().getSystemService("input_method")).showSoftInput(r2Var.F0, 1);
                return;
            case 4:
                ((g3) obj2).c();
                return;
            case 5:
                Activity activity = (Activity) obj2;
                if (activity.isFinishing()) {
                    return;
                }
                Handler handler = b4.g;
                Method method = b4.f;
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 28) {
                    activity.recreate();
                    return;
                }
                if (((i3 != 26 && i3 != 27) || method != null) && (b4.e != null || b4.d != null)) {
                    try {
                        Object obj3 = b4.c.get(activity);
                        if (obj3 != null && (obj = b4.b.get(activity)) != null) {
                            Application application = activity.getApplication();
                            a4 a4Var2 = new a4(activity);
                            application.registerActivityLifecycleCallbacks(a4Var2);
                            handler.post(new vn1(a4Var2, i2, obj3));
                            if (i3 != 26 && i3 != 27) {
                                r42 = 0;
                            }
                            int i4 = 3;
                            try {
                                if (r42 != 0) {
                                    try {
                                        Boolean bool = Boolean.FALSE;
                                        r42 = application;
                                        a4Var = a4Var2;
                                        method.invoke(obj, obj3, null, null, 0, bool, null, null, bool, bool);
                                    } catch (Throwable th) {
                                        th = th;
                                        r4 = application;
                                        a4Var = a4Var2;
                                        handler.post(new vn1((Object) r4, i4, a4Var));
                                        throw th;
                                    }
                                } else {
                                    r42 = application;
                                    a4Var = a4Var2;
                                    activity.recreate();
                                }
                                handler.post(new vn1((Object) r42, i4, a4Var));
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                r4 = r42;
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                activity.recreate();
                return;
            case 6:
                ((t4) obj2).q0();
                return;
            case 7:
                ya yaVar = (ya) obj2;
                ((InputMethodManager) yaVar.o().getSystemService("input_method")).showSoftInput(yaVar.w0, 1);
                return;
            case 8:
                ((BackupAndRestoreSettings.a) obj2).h0("permissions").F(!MissingPermissions.H().isEmpty());
                return;
            case 9:
                de deVar = (de) obj2;
                if (deVar.A == deVar.B) {
                    deVar.C.c();
                    return;
                }
                float fPow = deVar.k > 0.0f ? (float) Math.pow(Math.min(deVar.k, System.currentTimeMillis() - deVar.v) / deVar.k, 2.0d) : 1.0f;
                long j = deVar.w - deVar.v;
                float fAbs = Math.abs(deVar.B - deVar.A);
                float f = deVar.l;
                float fMin = fPow == 1.0f ? Math.min(j * f, fAbs) : Math.min(Math.min(0.05f, f) * fPow * j, fAbs);
                float f2 = deVar.B;
                float f3 = deVar.A;
                if (f2 > f3) {
                    deVar.A = f3 + fMin;
                } else {
                    deVar.A = f3 - fMin;
                }
                if (deVar.n) {
                    float f4 = deVar.A;
                    r60.j.h = f4;
                    r60.k.h = f4;
                    r60.c.invalidate();
                }
                deVar.n(deVar.A);
                deVar.C.c();
                return;
            case 10:
                ((of) obj2).a(null, Boolean.FALSE);
                return;
            case 11:
                ((wh) obj2).a(null, Boolean.FALSE);
                return;
            case 12:
                ((CarouselLayoutManager) obj2).p0();
                return;
            case 13:
                ((sk) obj2).s(true);
                return;
            case 14:
                km kmVar = (km) obj2;
                Runnable runnable = kmVar.c;
                if (runnable != null) {
                    runnable.run();
                    kmVar.c = null;
                    return;
                }
                return;
            case 15:
                qm.a((qm) obj2);
                return;
            case 16:
                CursorAccessibilityService cursorAccessibilityService = CursorAccessibilityService.q;
                ((CursorAccessibilityService) obj2).p();
                return;
            case 17:
                int i5 = CursorSettings.D;
                ((CursorSettings) obj2).H();
                return;
            case 18:
                jr jrVar = (jr) obj2;
                l3 l3Var = jr.k;
                try {
                    if (jr.m(zy0.m(jrVar.f.getRootInActiveWindow(), AccessibilityNodeInfo.AccessibilityAction.ACTION_CUT)) || !pn0.t().A()) {
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post(new s4(4));
                    return;
                } catch (Exception unused3) {
                    return;
                }
            case 19:
                ((DebugSettings.a) obj2).i0(null, null);
                return;
            case 20:
                qu quVar = (qu) obj2;
                wa waVar = qu.k;
                CursorAccessibilityService cursorAccessibilityService2 = quVar.f;
                Point point = quVar.a;
                hm0.o(cursorAccessibilityService2, point.x, point.y, quVar.g);
                return;
            case 21:
                ev evVar = (ev) obj2;
                boolean zIsPopupShowing = evVar.h.isPopupShowing();
                evVar.s(zIsPopupShowing);
                evVar.m = zIsPopupShowing;
                return;
            case 22:
                ((uw) obj2).p0.w();
                return;
            case 23:
                ((vw) obj2).a(i3.delayed);
                return;
            case 24:
                ((e20) obj2).I();
                return;
            case 25:
                n20 n20Var = (n20) obj2;
                synchronized (n20Var.d) {
                    try {
                        if (n20Var.h == null) {
                            return;
                        }
                        try {
                            x20 x20VarC = n20Var.c();
                            int i6 = x20VarC.f;
                            if (i6 == 2) {
                                synchronized (n20Var.d) {
                                }
                            }
                            if (i6 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i6 + ")");
                            }
                            try {
                                int i7 = h71.a;
                                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                ow0 ow0Var = n20Var.c;
                                Context context = n20Var.a;
                                ow0Var.getClass();
                                x20[] x20VarArr = {x20VarC};
                                i1 i1Var = nc1.a;
                                tk0.b("TypefaceCompat.createFromFontInfo");
                                try {
                                    Typeface typefaceL = nc1.a.l(context, x20VarArr, 0);
                                    Trace.endSection();
                                    MappedByteBuffer mappedByteBufferA = xr.A(n20Var.a, x20VarC.a);
                                    if (mappedByteBufferA == null || typefaceL == null) {
                                        throw new RuntimeException("Unable to open file.");
                                    }
                                    try {
                                        Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                        g7 g7Var = new g7(typefaceL, fp1.y(mappedByteBufferA));
                                        Trace.endSection();
                                        synchronized (n20Var.d) {
                                            try {
                                                yb0 yb0Var = n20Var.h;
                                                if (yb0Var != null) {
                                                    yb0Var.r(g7Var);
                                                }
                                            } finally {
                                            }
                                            break;
                                        }
                                        n20Var.b();
                                        return;
                                    } finally {
                                        int i8 = h71.a;
                                    }
                                } finally {
                                    Trace.endSection();
                                }
                            } finally {
                            }
                            break;
                        } catch (Throwable th3) {
                            synchronized (n20Var.d) {
                                try {
                                    yb0 yb0Var2 = n20Var.h;
                                    if (yb0Var2 != null) {
                                        yb0Var2.q(th3);
                                    }
                                    n20Var.b();
                                    return;
                                } finally {
                                }
                            }
                        }
                    } finally {
                    }
                }
            case 26:
                j60 j60Var = (j60) obj2;
                j60Var.d.c = System.currentTimeMillis() - j60Var.c;
                t51 t51Var = j60Var.d;
                t51 t51Var2 = new t51();
                t51Var2.a = t51Var.a;
                t51Var2.b = t51Var.b;
                t51Var2.c = t51Var.c;
                j60Var.a(t51Var2);
                return;
            case 27:
                final HowToUseActivity howToUseActivity = (HowToUseActivity) obj2;
                int i9 = HowToUseActivity.C;
                jl1 jl1Var = new jl1(howToUseActivity);
                jl1Var.m(R.string.are_you_sure);
                jl1Var.g(R.string.confirmation_open_how_to_use);
                x6 x6Var = (x6) jl1Var.c;
                x6Var.c = R.drawable.icon_warning;
                final boolean z = false ? 1 : 0;
                jl1Var.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: r80
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        int i11 = z;
                        HowToUseActivity howToUseActivity2 = howToUseActivity;
                        switch (i11) {
                            case 0:
                                int i12 = HowToUseActivity.C;
                                y30 y30VarW = howToUseActivity2.w();
                                y30VarW.getClass();
                                ld ldVar = new ld(y30VarW);
                                s10 s10Var = howToUseActivity2.B;
                                ldVar.i(R.id.firstUseSlide, s10Var.b);
                                ldVar.e(false);
                                s10Var.j();
                                Optional.ofNullable(howToUseActivity2.v()).ifPresent(new a(9));
                                break;
                            default:
                                int i13 = HowToUseActivity.C;
                                howToUseActivity2.finish();
                                break;
                        }
                    }
                });
                final int i10 = 1 == true ? 1 : 0;
                jl1Var.h(android.R.string.no, new DialogInterface.OnClickListener() { // from class: r80
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i102) {
                        int i11 = i10;
                        HowToUseActivity howToUseActivity2 = howToUseActivity;
                        switch (i11) {
                            case 0:
                                int i12 = HowToUseActivity.C;
                                y30 y30VarW = howToUseActivity2.w();
                                y30VarW.getClass();
                                ld ldVar = new ld(y30VarW);
                                s10 s10Var = howToUseActivity2.B;
                                ldVar.i(R.id.firstUseSlide, s10Var.b);
                                ldVar.e(false);
                                s10Var.j();
                                Optional.ofNullable(howToUseActivity2.v()).ifPresent(new a(9));
                                break;
                            default:
                                int i13 = HowToUseActivity.C;
                                howToUseActivity2.finish();
                                break;
                        }
                    }
                });
                x6Var.o = new s80(false ? 1 : 0, howToUseActivity);
                jl1Var.n();
                return;
            case 28:
                SharedPreferences sharedPreferencesB = ((lf0) obj2).Z.b();
                HashMap map = new HashMap();
                map.put("packageName", sharedPreferencesB.getString("packageName", null));
                map.put("windowed", Boolean.valueOf(sharedPreferencesB.getBoolean("windowed", false)));
                map.put("windowConfig", sharedPreferencesB.getString("windowConfig", null));
                map.put("windowedMode", sharedPreferencesB.getString("windowedMode", null));
                qf0 qf0Var = new qf0(n3.launchApp, map);
                CursorAccessibilityService cursorAccessibilityService3 = CursorAccessibilityService.q;
                i3 i3Var = i3.instant;
                g1.a(cursorAccessibilityService3, qf0Var, 511, i3Var, i3Var).b(false, false);
                return;
            default:
                wa waVar2 = mf0.k;
                CursorAccessibilityService.b();
                b61.b(new s4(10, (mf0) obj2), 500L);
                return;
        }
    }
}
