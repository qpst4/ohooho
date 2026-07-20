package defpackage;

import android.app.NotificationManager;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g1 {
    public static final int[] j = {4, 8, 32};
    public Point a;
    public Point b;
    public Point c;
    public i3 d;
    public final e1 e;
    public CursorAccessibilityService f;
    public HashMap g;
    public f1 h;
    public int i;

    public g1() {
        this.h = f1.initial;
        this.d = i3.empty;
        this.e = e1.instant;
    }

    public static g1 a(CursorAccessibilityService cursorAccessibilityService, j jVar, int i, i3 i3Var, i3 i3Var2) {
        try {
            g1 g1Var = (g1) jVar.b().a().newInstance();
            g1Var.f = cursorAccessibilityService;
            HashMap mapC = jVar.c();
            g1Var.g = mapC;
            if (mapC == null) {
                g1Var.g = new HashMap();
            }
            g1Var.i = i;
            if (i3Var2 != null) {
                g1Var.k(i3Var2);
            }
            g1Var.k(jVar.a());
            g1Var.k(i3Var);
            if (g1Var.d == i3.instantOrDelayed) {
                g1Var.d = i3.instant;
            }
            return g1Var;
        } catch (Exception e) {
            si0.b(e.getMessage());
            return new zm0(true);
        }
    }

    public static int j(n3 n3Var) {
        int i = 0;
        int i2 = xr.y(n3Var.requirements, 2) ? 2 : 0;
        if (xr.y(n3Var.requirements, 1)) {
            i2 |= 1;
        }
        if (xr.y(n3Var.requirements, 8192)) {
            i2 |= 8192;
        }
        if (xr.y(n3Var.requirements, 4) && !Settings.System.canWrite(App.c)) {
            i2 |= 4;
        }
        if (xr.y(n3Var.requirements, 8) && !((NotificationManager) App.c.getSystemService("notification")).isNotificationPolicyAccessGranted()) {
            i2 |= 8;
        }
        if (xr.y(n3Var.requirements, 32) && xy0.f(App.c, "android.permission.CAMERA") != 0) {
            i2 |= 32;
        }
        if (xr.y(n3Var.requirements, 64) && !App.c.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            i2 |= 64;
        }
        if (xr.y(n3Var.requirements, 16) && Build.VERSION.SDK_INT < 28) {
            i2 |= 16;
        }
        if (xr.y(n3Var.requirements, 256) && Build.VERSION.SDK_INT < 29) {
            i2 |= 256;
        }
        if (xr.y(n3Var.requirements, 4096) && Build.VERSION.SDK_INT < 30) {
            i2 |= 4096;
        }
        if (xr.y(n3Var.requirements, 32768) && Build.VERSION.SDK_INT < 36) {
            i2 |= 32768;
        }
        if (xr.y(n3Var.requirements, 2048) && Build.VERSION.SDK_INT < 31) {
            i2 |= 2048;
        }
        if (xr.y(n3Var.requirements, 512) && pn0.t().j() == pq0.b) {
            i2 |= 512;
        }
        if (xr.y(n3Var.requirements, 128) && Build.VERSION.SDK_INT > 28) {
            i2 |= 128;
        }
        if (xr.y(n3Var.requirements, 1024) && Build.VERSION.SDK_INT >= 30) {
            try {
                if (CursorAccessibilityService.q.getSystemActions().stream().noneMatch(new d1(n3Var, i))) {
                    return i2 | 1024;
                }
            } catch (Exception unused) {
            }
        }
        return i2;
    }

    public void b(boolean z, boolean z2) {
        try {
            e1 e1Var = this.e;
            if (e1Var == e1.instant) {
                this.h = f1.triggered;
                g();
                this.h = f1.ended;
                return;
            }
            if (e1Var == e1.continuous) {
                this.h = f1.triggered;
                g();
                return;
            }
            if (e1Var == e1.onReleaseAndPositioned) {
                this.h = f1.scheduled;
                if (z && z2) {
                    this.h = f1.triggered;
                    g();
                    this.h = f1.ended;
                    return;
                }
                return;
            }
            if (e1Var == e1.continuousAfterPositioned) {
                if (z && !z2) {
                    this.h = f1.triggered;
                    g();
                    CursorAccessibilityService.q.o.e.s = 6;
                } else if (!z || !z2) {
                    this.h = f1.scheduled;
                } else {
                    this.h = f1.positioned;
                    i();
                }
            }
        } catch (Exception e) {
            si0.b("dispatch error: " + e.getMessage());
            yb0.A(R.string.general_action_error);
            this.h = f1.ended;
        }
    }

    public final void c() {
        try {
            e1 e1Var = this.e;
            if (e1Var == e1.continuous || e1Var == e1.continuousAfterPositioned) {
                h();
            } else {
                g();
            }
        } catch (Exception e) {
            si0.b("onEnd error: " + e.getMessage());
            yb0.A(R.string.general_action_error);
        }
        this.h = f1.ended;
    }

    public final boolean d() {
        return this.h != f1.ended;
    }

    public final void f() {
        try {
            e();
        } catch (Exception e) {
            si0.b("onCursorMove error: " + e.getMessage());
            c();
        }
    }

    public abstract void g();

    public final void k(i3 i3Var) {
        i3 i3Var2 = this.d;
        if (i3Var2 == i3.empty) {
            this.d = i3Var;
        } else if (i3Var2 == i3.instantOrDelayed) {
            if (i3Var == i3.instant || i3Var == i3.delayed) {
                this.d = i3Var;
            }
        }
    }

    public final boolean l() {
        return this.h.compareTo(f1.scheduled) >= 0;
    }

    public g1(i3 i3Var, e1 e1Var) {
        this.h = f1.initial;
        this.d = i3Var;
        this.e = e1Var;
    }

    public void e() {
    }

    public void h() {
    }

    public void i() {
    }
}
