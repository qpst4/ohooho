package defpackage;

import android.content.SharedPreferences;
import com.quickcursor.App;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yx0 {
    public final String a;
    public final rr b;
    public final CursorAccessibilityService c;
    public final CursorAccessibilityService d;
    public int e;
    public int f;
    public int g;
    public int h;

    public yx0(CursorAccessibilityService cursorAccessibilityService, CursorAccessibilityService cursorAccessibilityService2) {
        String simpleName = yx0.class.getSimpleName();
        this.a = simpleName;
        this.b = new rr(100L, 500L);
        this.d = cursorAccessibilityService;
        this.c = cursorAccessibilityService2;
        this.f = ey0.d;
        this.g = ey0.e;
        this.e = ey0.b;
        this.h = ey0.c;
        if (App.d) {
            z.a(cursorAccessibilityService, simpleName, 32);
        }
    }

    public static void a(yx0 yx0Var) {
        CursorAccessibilityService cursorAccessibilityService = yx0Var.c;
        ey0.e(yx0Var.d);
        int i = ey0.b;
        int i2 = ey0.d;
        int i3 = ey0.e;
        int i4 = ey0.c;
        if (i2 != yx0Var.f || i3 != yx0Var.g) {
            yx0Var.f = i2;
            yx0Var.g = i3;
            cursorAccessibilityService.getClass();
            f01.H(oq0.c((SharedPreferences) pn0.t().d, oq0.i0), oq0.c((SharedPreferences) pn0.t().d, oq0.j0), i2, i3);
        }
        boolean z = i != yx0Var.e;
        boolean z2 = i4 != yx0Var.h;
        yx0Var.e = i;
        yx0Var.h = i4;
        if (z && z2) {
            cursorAccessibilityService.getClass();
            si0.a("New orientation: ".concat(qq0.l(i)));
            cursorAccessibilityService.p();
        } else if (z) {
            cursorAccessibilityService.getClass();
            si0.a("New orientation: ".concat(qq0.l(i)));
            cursorAccessibilityService.p();
        } else if (z2) {
            cursorAccessibilityService.getClass();
            si0.a("New rotation: " + i4);
            cursorAccessibilityService.p();
        }
    }
}
