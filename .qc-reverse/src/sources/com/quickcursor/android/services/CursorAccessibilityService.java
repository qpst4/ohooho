package com.quickcursor.android.services;

import android.accessibilityservice.AccessibilityService;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityWindowInfo;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.activities.AccessibilityStoppedActivity;
import com.quickcursor.android.services.CursorAccessibilityService;
import defpackage.ar;
import defpackage.b61;
import defpackage.c;
import defpackage.e20;
import defpackage.en;
import defpackage.hg;
import defpackage.hj0;
import defpackage.i9;
import defpackage.ig;
import defpackage.js0;
import defpackage.kx0;
import defpackage.l11;
import defpackage.lc1;
import defpackage.lk0;
import defpackage.mi0;
import defpackage.ne0;
import defpackage.oq0;
import defpackage.pd1;
import defpackage.pn0;
import defpackage.r60;
import defpackage.rr;
import defpackage.s71;
import defpackage.si0;
import defpackage.vm;
import defpackage.xv0;
import defpackage.xw;
import defpackage.xx0;
import defpackage.yb0;
import defpackage.yx0;
import defpackage.z;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CursorAccessibilityService extends AccessibilityService {
    public static CursorAccessibilityService q;
    public ne0 b;
    public ig c;
    public pn0 d;
    public xv0 e;
    public KeyguardManager f;
    public PowerManager g;
    public yx0 h;
    public i9 i;
    public mi0 j;
    public kx0 k;
    public vm l;
    public js0 m;
    public int n;
    public ar o;
    public final b61 p = new b61(new c(16, this), 0);

    public static long a() {
        long jLongValue;
        SharedPreferences sharedPreferences = (SharedPreferences) pn0.t().d;
        try {
            try {
                oq0 oq0Var = oq0.f1;
                jLongValue = sharedPreferences.getLong(oq0Var.name(), ((Long) oq0Var.b).longValue());
            } catch (Exception unused) {
                Object obj = sharedPreferences.getAll().get(oq0.f1.name());
                jLongValue = obj instanceof Double ? ((Double) obj).longValue() : obj instanceof Integer ? ((Integer) obj).longValue() : Long.parseLong(obj.toString());
            }
        } catch (Exception unused2) {
            jLongValue = 0;
        }
        return jLongValue - (System.currentTimeMillis() / 1000);
    }

    public static void b() {
        if (e()) {
            q.o.o();
        }
    }

    public static boolean e() {
        CursorAccessibilityService cursorAccessibilityService = q;
        return (cursorAccessibilityService == null || cursorAccessibilityService.o == null || cursorAccessibilityService.n != 1) ? false : true;
    }

    public static boolean f() {
        CursorAccessibilityService cursorAccessibilityService = q;
        return (cursorAccessibilityService == null || cursorAccessibilityService.getServiceInfo() == null) ? false : true;
    }

    public static boolean g() {
        Context context = App.c;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append("/");
        sb.append(CursorAccessibilityService.class.getName());
        return string.contains(sb.toString());
    }

    public static void j() {
        if (q == null) {
            return;
        }
        int i = en.a;
        en.a = (ViewConfiguration.getLongPressTimeout() * 3) / 2;
        yx0 yx0Var = q.h;
        yx0Var.getClass();
        if (App.d) {
            z.a(yx0Var.d, yx0Var.a, 32);
        }
        q.c.c();
        q.b.c();
        r60.d(q);
        q.o();
    }

    public static void k(boolean z) {
        xw.e.f();
        s71.e.b();
        xv0.d.b();
        if (q == null) {
            return;
        }
        int i = en.a;
        en.a = (ViewConfiguration.getLongPressTimeout() * 3) / 2;
        yx0 yx0Var = q.h;
        yx0Var.getClass();
        if (App.d) {
            z.a(yx0Var.d, yx0Var.a, 32);
        }
        q.c.c();
        q.b.c();
        q.i();
        CursorAccessibilityService cursorAccessibilityService = q;
        ar arVar = cursorAccessibilityService.o;
        if (arVar != null) {
            try {
                arVar.m();
            } catch (Exception unused) {
            }
            cursorAccessibilityService.o = null;
        }
        if (z) {
            q.o();
        } else {
            q.p();
        }
    }

    public static void m() {
        CursorAccessibilityService cursorAccessibilityService = q;
        if (cursorAccessibilityService != null) {
            if (cursorAccessibilityService.d()) {
                CursorAccessibilityService cursorAccessibilityService2 = q;
                cursorAccessibilityService2.getClass();
                si0.a("turnOff(): ".concat(l11.p(2)));
                r60.k();
                ar arVar = cursorAccessibilityService2.o;
                if (arVar != null) {
                    try {
                        arVar.m();
                    } catch (Exception unused) {
                    }
                    cursorAccessibilityService2.o = null;
                }
                cursorAccessibilityService2.n = 2;
                return;
            }
            q.getClass();
            if (a() > 0) {
                yb0.y(R.string.turn_on_reset_timed_disable, 0);
                CursorAccessibilityService cursorAccessibilityService3 = q;
                cursorAccessibilityService3.getClass();
                pn0.t().U(-1L);
                cursorAccessibilityService3.l();
            }
            CursorAccessibilityService cursorAccessibilityService4 = q;
            cursorAccessibilityService4.o();
            si0.a("serviceState after turnOn(): ".concat(l11.p(cursorAccessibilityService4.n)));
            int iR = l11.r(cursorAccessibilityService4.n);
            if (iR == 2) {
                yb0.y(R.string.turn_on_paused_app, 0);
                return;
            }
            if (iR == 4) {
                yb0.z(lc1.K(R.string.turn_on_paused_blacklist) + cursorAccessibilityService4.c.i, 0);
                return;
            }
            if (iR == 5) {
                yb0.y(R.string.turn_on_paused_lockscreen, 0);
            } else if (iR == 6) {
                yb0.y(R.string.turn_on_paused_keyboard, 0);
            } else {
                if (iR != 7) {
                    return;
                }
                yb0.y(R.string.turn_on_paused_s_pen_detached, 0);
            }
        }
    }

    public final void c() {
        q = this;
        r60.d(this);
        int i = en.a;
        en.a = (ViewConfiguration.getLongPressTimeout() * 3) / 2;
        pd1.b();
        this.i = null;
        this.f = (KeyguardManager) getSystemService("keyguard");
        this.g = (PowerManager) getSystemService("power");
        this.b = new ne0(this, this);
        this.c = new ig(this, this);
        this.h = new yx0(this, this);
        this.d = pn0.t();
        this.e = xv0.d;
        i();
        try {
            vm vmVar = new vm(this);
            this.l = vmVar;
            registerReceiver(vmVar, (IntentFilter) vmVar.c);
        } catch (Exception unused) {
            this.l = null;
        }
        int i2 = kx0.d;
        FeatureInfo[] systemAvailableFeatures = getPackageManager().getSystemAvailableFeatures();
        int length = systemAvailableFeatures.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            if ("com.sec.feature.spen_usp".equalsIgnoreCase(systemAvailableFeatures[i4].name)) {
                si0.a("SPen supported. Trying to register SPenReceiver");
                try {
                    BroadcastReceiver broadcastReceiver = this.k;
                    if (broadcastReceiver != null) {
                        try {
                            unregisterReceiver(broadcastReceiver);
                            this.k = null;
                            si0.a("samsungSPenReceiver unregistered.");
                        } catch (Exception unused2) {
                        }
                    }
                    kx0 kx0Var = new kx0(this);
                    this.k = kx0Var;
                    registerReceiver(kx0Var, kx0Var.b);
                    si0.a("samsungSPenReceiver registered.");
                } catch (Exception unused3) {
                    this.k = null;
                }
            } else {
                i4++;
            }
        }
        l();
        o();
        if (!oq0.a((SharedPreferences) this.d.d, oq0.j)) {
            Intent intent = new Intent(App.c, (Class<?>) AccessibilityStoppedActivity.class);
            intent.addFlags(268566528);
            intent.putExtra("skipToFirstUse", true);
            startActivity(intent);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            i9 i9Var = new i9(this);
            this.i = i9Var;
            ((rr) i9Var.c).a(new lk0(i3, i9Var));
        }
        yx0 yx0Var = this.h;
        yx0Var.b.a(new xx0(yx0Var, i3));
    }

    public final boolean d() {
        return this.n == 1 && this.o != null;
    }

    public final void h() {
        String str;
        ig igVar = this.c;
        if (igVar.e == 1) {
            try {
            } catch (Exception unused) {
            }
            for (AccessibilityWindowInfo accessibilityWindowInfo : igVar.c.getWindows()) {
                if (accessibilityWindowInfo.getType() == 1) {
                    str = (String) accessibilityWindowInfo.getRoot().getPackageName();
                    accessibilityWindowInfo.recycle();
                    break;
                }
                accessibilityWindowInfo.recycle();
                str = null;
            }
            str = null;
            if (str != null) {
                si0.a("Temporarily disable for app: ".concat(str));
                igVar.k = str;
                igVar.d();
            } else {
                si0.a("tryToToTemporarilyDisableWithoutEvents couldn't get foreground app from Windows");
                igVar.g = true;
                igVar.d();
            }
        } else {
            String str2 = igVar.i;
            si0.a("Temporarily disable for app: " + str2);
            igVar.k = str2;
            igVar.d();
        }
        n(3);
    }

    public final void i() {
        try {
            BroadcastReceiver broadcastReceiver = this.j;
            if (broadcastReceiver != null) {
                try {
                    unregisterReceiver(broadcastReceiver);
                    this.j = null;
                    si0.a("lockUnlockReceiver unregistered.");
                } catch (Exception unused) {
                }
            }
            mi0 mi0Var = new mi0(this.f, this);
            this.j = mi0Var;
            registerReceiver(mi0Var, mi0Var.c);
            si0.a("lockUnlockReceiver registered.");
        } catch (Exception unused2) {
            this.j = null;
        }
    }

    public final void l() {
        long jA = a();
        b61 b61Var = this.p;
        if (jA <= 0) {
            b61Var.d();
            return;
        }
        si0.a("resetTimedDisableTimerHandler: " + jA);
        b61Var.b = jA * 1000;
        b61Var.a();
    }

    public final void n(int i) {
        if (this.n != 2) {
            si0.a("turnOff(): ".concat(l11.p(i)));
            r60.k();
            ar arVar = this.o;
            if (arVar != null) {
                try {
                    arVar.m();
                } catch (Exception unused) {
                }
                this.o = null;
            }
            this.n = i;
        }
    }

    public final void o() {
        kx0 kx0Var;
        try {
            si0.a("Try turnOn()");
            r60.k();
            ar arVar = this.o;
            if (arVar != null) {
                try {
                    arVar.m();
                } catch (Exception unused) {
                }
                this.o = null;
            }
            if (oq0.a((SharedPreferences) pn0.t().d, oq0.Z0)) {
                si0.a("OFF");
                this.n = 2;
                return;
            }
            if (this.g.isInteractive() && (!this.f.isKeyguardLocked() || oq0.a((SharedPreferences) pn0.t().d, oq0.X0))) {
                if (this.e.a().o()) {
                    si0.a("PAUSED_DISABLED_RESOLUTION");
                    this.n = 9;
                    return;
                }
                if (this.c.k != null) {
                    si0.a("PAUSED_TEMPORARILY_APP");
                    this.n = 3;
                    return;
                }
                if (a() > 0) {
                    si0.a("PAUSED_TIMED_DISABLE");
                    this.n = 4;
                    return;
                }
                if (this.c.j) {
                    si0.a("PAUSED_BLACKLIST");
                    this.n = 5;
                    return;
                }
                if (oq0.a((SharedPreferences) pn0.t().d, oq0.a1) && (kx0Var = this.k) != null && !kx0Var.c) {
                    si0.a("PAUSED_S_PEN_DETACHED");
                    this.n = 8;
                    return;
                }
                boolean z = this.b.a() > 0;
                if ((this.d.v() == 4) && z) {
                    si0.a("PAUSED_KEYBOARD");
                    this.n = 7;
                    return;
                }
                r60.d(this);
                ar arVar2 = this.o;
                if (arVar2 != null) {
                    try {
                        arVar2.m();
                    } catch (Exception unused2) {
                    }
                    this.o = null;
                }
                if (this.e.a().p()) {
                    this.o = new e20(this);
                } else {
                    this.o = new hj0(this);
                }
                this.n = 1;
                if (z) {
                    if (this.d.B()) {
                        ar arVar3 = this.o;
                        ne0 ne0Var = this.b;
                        arVar3.w(ne0Var.b(ne0Var.a()));
                        return;
                    } else {
                        if (this.d.C()) {
                            this.o.D();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            si0.a("PAUSED_LOCKSCREEN");
            this.n = 6;
        } catch (Exception e) {
            String message = e.getMessage();
            yb0.A(R.string.general_error_toast);
            if (message != null && message.length() > 0) {
                yb0.B(message);
            }
            this.n = 2;
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public final void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ActivityInfo activityInfo;
        yx0 yx0Var = this.h;
        yx0Var.getClass();
        final int i = 1;
        if (App.d && accessibilityEvent.getEventType() == 32) {
            yx0Var.b.a(new xx0(yx0Var, i));
        }
        ig igVar = this.c;
        final int i2 = 0;
        if (igVar.e != 1 || igVar.k != null || igVar.g) {
            try {
                if (accessibilityEvent.getEventType() == 32 && accessibilityEvent.getPackageName() != null && accessibilityEvent.getClassName() != null) {
                    ComponentName componentName = new ComponentName(accessibilityEvent.getPackageName().toString(), accessibilityEvent.getClassName().toString());
                    try {
                        activityInfo = igVar.c.getPackageManager().getActivityInfo(componentName, 0);
                    } catch (PackageManager.NameNotFoundException unused) {
                        activityInfo = null;
                    }
                    boolean z = activityInfo != null;
                    String packageName = componentName.getPackageName();
                    if (z && packageName != null && (!packageName.equals(igVar.h) || !packageName.equals(igVar.i))) {
                        igVar.h = packageName;
                        igVar.b.a(new hg(igVar, 0));
                    }
                }
            } catch (Exception e) {
                si0.b("BlacklistService issue on detecting current app." + e.getMessage());
            }
        }
        final ne0 ne0Var = this.b;
        if (ne0Var.e) {
            if (ne0Var.f > 0) {
                ne0Var.b.a(new Runnable() { // from class: me0
                    @Override // java.lang.Runnable
                    public final void run() {
                        int iA;
                        int i3 = i2;
                        ne0 ne0Var2 = ne0Var;
                        switch (i3) {
                            case 0:
                                CursorAccessibilityService cursorAccessibilityService = ne0Var2.d;
                                int iA2 = ne0Var2.a();
                                if (iA2 != ne0Var2.f) {
                                    ne0Var2.f = iA2;
                                    if (iA2 == 0) {
                                        ((Handler) ne0Var2.a.c).removeCallbacksAndMessages(null);
                                        z.a(ne0Var2.c, "ne0", Build.VERSION.SDK_INT <= 30 ? 32 : 4194336);
                                        if (cursorAccessibilityService.d.v() == 4) {
                                            cursorAccessibilityService.p();
                                        } else if (cursorAccessibilityService.d()) {
                                            if (cursorAccessibilityService.d.B() || cursorAccessibilityService.d.C()) {
                                                cursorAccessibilityService.o.y();
                                            }
                                        }
                                    } else if (cursorAccessibilityService.d()) {
                                        if (cursorAccessibilityService.d.B()) {
                                            ar arVar = cursorAccessibilityService.o;
                                            ne0 ne0Var3 = cursorAccessibilityService.b;
                                            arVar.w(ne0Var3.b(ne0Var3.f));
                                        } else if (cursorAccessibilityService.d.C()) {
                                            cursorAccessibilityService.o.D();
                                        }
                                    }
                                    break;
                                }
                                break;
                            default:
                                if (ne0Var2.f <= 0 && (iA = ne0Var2.a()) > 0) {
                                    ne0Var2.f = iA;
                                    z.a(ne0Var2.c, "ne0", 4194336);
                                    CursorAccessibilityService cursorAccessibilityService2 = ne0Var2.d;
                                    if (cursorAccessibilityService2.d.v() == 4) {
                                        cursorAccessibilityService2.n(7);
                                    } else if (cursorAccessibilityService2.d()) {
                                        ne0 ne0Var4 = cursorAccessibilityService2.b;
                                        int iB = ne0Var4.b(ne0Var4.f);
                                        if (cursorAccessibilityService2.d.u() == 3) {
                                            cursorAccessibilityService2.o.o();
                                        } else if (cursorAccessibilityService2.d.u() == 2) {
                                            ar arVar2 = cursorAccessibilityService2.o;
                                            if (arVar2.e.getVisibility() == 0) {
                                                m81 m81Var = arVar2.e;
                                                int iC = iB - oq0.c((SharedPreferences) pn0.t().d, oq0.o);
                                                int positionX = m81Var.getPositionX();
                                                int i4 = m81Var.p;
                                                int i5 = positionX - i4;
                                                int i6 = (iC - i4) - i4;
                                                WindowManager.LayoutParams layoutParams = m81Var.d;
                                                layoutParams.x = i5;
                                                layoutParams.y = i6;
                                                try {
                                                    m81Var.b.updateViewLayout(m81Var, layoutParams);
                                                    break;
                                                } catch (Exception unused2) {
                                                }
                                                r60.l(arVar2.e.getPositionX(), arVar2.e.getPositionY());
                                            }
                                        }
                                        if (cursorAccessibilityService2.d.B()) {
                                            cursorAccessibilityService2.o.w(iB);
                                        } else if (cursorAccessibilityService2.d.C()) {
                                            cursorAccessibilityService2.o.D();
                                        }
                                    }
                                }
                                break;
                        }
                    }
                });
            } else {
                ne0Var.a.a(new Runnable() { // from class: me0
                    @Override // java.lang.Runnable
                    public final void run() {
                        int iA;
                        int i3 = i;
                        ne0 ne0Var2 = ne0Var;
                        switch (i3) {
                            case 0:
                                CursorAccessibilityService cursorAccessibilityService = ne0Var2.d;
                                int iA2 = ne0Var2.a();
                                if (iA2 != ne0Var2.f) {
                                    ne0Var2.f = iA2;
                                    if (iA2 == 0) {
                                        ((Handler) ne0Var2.a.c).removeCallbacksAndMessages(null);
                                        z.a(ne0Var2.c, "ne0", Build.VERSION.SDK_INT <= 30 ? 32 : 4194336);
                                        if (cursorAccessibilityService.d.v() == 4) {
                                            cursorAccessibilityService.p();
                                        } else if (cursorAccessibilityService.d()) {
                                            if (cursorAccessibilityService.d.B() || cursorAccessibilityService.d.C()) {
                                                cursorAccessibilityService.o.y();
                                            }
                                        }
                                    } else if (cursorAccessibilityService.d()) {
                                        if (cursorAccessibilityService.d.B()) {
                                            ar arVar = cursorAccessibilityService.o;
                                            ne0 ne0Var3 = cursorAccessibilityService.b;
                                            arVar.w(ne0Var3.b(ne0Var3.f));
                                        } else if (cursorAccessibilityService.d.C()) {
                                            cursorAccessibilityService.o.D();
                                        }
                                    }
                                    break;
                                }
                                break;
                            default:
                                if (ne0Var2.f <= 0 && (iA = ne0Var2.a()) > 0) {
                                    ne0Var2.f = iA;
                                    z.a(ne0Var2.c, "ne0", 4194336);
                                    CursorAccessibilityService cursorAccessibilityService2 = ne0Var2.d;
                                    if (cursorAccessibilityService2.d.v() == 4) {
                                        cursorAccessibilityService2.n(7);
                                    } else if (cursorAccessibilityService2.d()) {
                                        ne0 ne0Var4 = cursorAccessibilityService2.b;
                                        int iB = ne0Var4.b(ne0Var4.f);
                                        if (cursorAccessibilityService2.d.u() == 3) {
                                            cursorAccessibilityService2.o.o();
                                        } else if (cursorAccessibilityService2.d.u() == 2) {
                                            ar arVar2 = cursorAccessibilityService2.o;
                                            if (arVar2.e.getVisibility() == 0) {
                                                m81 m81Var = arVar2.e;
                                                int iC = iB - oq0.c((SharedPreferences) pn0.t().d, oq0.o);
                                                int positionX = m81Var.getPositionX();
                                                int i4 = m81Var.p;
                                                int i5 = positionX - i4;
                                                int i6 = (iC - i4) - i4;
                                                WindowManager.LayoutParams layoutParams = m81Var.d;
                                                layoutParams.x = i5;
                                                layoutParams.y = i6;
                                                try {
                                                    m81Var.b.updateViewLayout(m81Var, layoutParams);
                                                    break;
                                                } catch (Exception unused2) {
                                                }
                                                r60.l(arVar2.e.getPositionX(), arVar2.e.getPositionY());
                                            }
                                        }
                                        if (cursorAccessibilityService2.d.B()) {
                                            cursorAccessibilityService2.o.w(iB);
                                        } else if (cursorAccessibilityService2.d.C()) {
                                            cursorAccessibilityService2.o.D();
                                        }
                                    }
                                }
                                break;
                        }
                    }
                });
            }
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        yx0 yx0Var = this.h;
        int i = 0;
        if (yx0Var != null) {
            yx0Var.b.a(new xx0(yx0Var, i));
        }
        i9 i9Var = this.i;
        if (i9Var != null) {
            ((rr) i9Var.c).a(new lk0(i, i9Var));
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        si0.a("Service onDestroy");
        yb0.A(R.string.accessibility_service_destroyed);
        mi0 mi0Var = this.j;
        if (mi0Var != null) {
            try {
                unregisterReceiver(mi0Var);
                this.j = null;
                si0.a("lockUnlockReceiver unregistered.");
            } catch (Exception unused) {
            }
        }
        vm vmVar = this.l;
        if (vmVar != null) {
            try {
                unregisterReceiver(vmVar);
                this.l = null;
            } catch (Exception unused2) {
            }
        }
        kx0 kx0Var = this.k;
        if (kx0Var != null) {
            try {
                unregisterReceiver(kx0Var);
                this.k = null;
                si0.a("samsungSPenReceiver unregistered.");
            } catch (Exception unused3) {
            }
        }
        q = null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public final void onInterrupt() {
        si0.a("Service onInterrupt");
        yb0.A(R.string.accessibility_service_interrupted);
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        si0.a("Service onRebind");
        yb0.A(R.string.accessibility_service_rebinded);
        c();
    }

    @Override // android.accessibilityservice.AccessibilityService
    public final void onServiceConnected() {
        Log.d("QuickCursorTag", "onServiceConnected()");
        try {
            try {
                si0.a("Service onServiceConnected");
                yb0.A(R.string.accessibility_service_started);
                c();
            } catch (Exception unused) {
                App.c = getBaseContext();
                try {
                    si0.a("Service onServiceConnected");
                    yb0.A(R.string.accessibility_service_started);
                    c();
                } catch (Exception e) {
                    si0.b("onServiceConnected error: " + e);
                }
            }
        } catch (Exception unused2) {
            App.c = getApplicationContext();
            si0.a("Service onServiceConnected");
            yb0.A(R.string.accessibility_service_started);
            c();
        }
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        si0.a("Service onUnbind");
        yb0.A(R.string.accessibility_service_unbinded);
        mi0 mi0Var = this.j;
        if (mi0Var != null) {
            try {
                unregisterReceiver(mi0Var);
                this.j = null;
                si0.a("lockUnlockReceiver unregistered.");
            } catch (Exception unused) {
            }
        }
        vm vmVar = this.l;
        if (vmVar != null) {
            try {
                unregisterReceiver(vmVar);
                this.l = null;
            } catch (Exception unused2) {
            }
        }
        kx0 kx0Var = this.k;
        if (kx0Var != null) {
            try {
                unregisterReceiver(kx0Var);
                this.k = null;
                si0.a("samsungSPenReceiver unregistered.");
            } catch (Exception unused3) {
            }
        }
        q = null;
        return true;
    }

    public final void p() {
        if (this.n != 2) {
            o();
        }
    }
}
