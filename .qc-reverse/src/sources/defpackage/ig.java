package defpackage;

import android.content.SharedPreferences;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ig {
    public final CursorAccessibilityService c;
    public final CursorAccessibilityService d;
    public int e;
    public HashSet f;
    public boolean g;
    public boolean j;
    public String k;
    public b61 l;
    public final String a = ig.class.getSimpleName();
    public final bk b = new bk(100);
    public String h = "";
    public String i = "";

    public ig(CursorAccessibilityService cursorAccessibilityService, CursorAccessibilityService cursorAccessibilityService2) {
        this.c = cursorAccessibilityService;
        this.d = cursorAccessibilityService2;
        c();
    }

    public final boolean a(String str) {
        if (str == null || str.length() == 0 || "com.quickcursor".equals(str)) {
            return false;
        }
        boolean zContains = this.f.contains(str);
        int iR = l11.r(this.e);
        if (iR == 1) {
            return zContains;
        }
        if (iR != 2) {
            return false;
        }
        return !zContains;
    }

    public final void b() {
        String str;
        boolean zA;
        try {
            str = (String) this.c.getRootInActiveWindow().getPackageName();
        } catch (Exception unused) {
            str = null;
        }
        if (str == null) {
            b61 b61Var = new b61(new hg(this, 1), this.l != null ? Math.min((int) (r0.b * 1.5f), 5000) : 100);
            b61Var.c();
            this.l = b61Var;
            return;
        }
        if (str.equals(this.i)) {
            return;
        }
        b61 b61Var2 = this.l;
        if (b61Var2 != null) {
            b61Var2.d();
            this.l = null;
        }
        this.i = str;
        String str2 = this.k;
        CursorAccessibilityService cursorAccessibilityService = this.d;
        if (str2 != null && !str.equals(str2)) {
            si0.a("Temporarily disabled app expired: " + this.k);
            this.k = null;
            this.g = false;
            cursorAccessibilityService.p();
            d();
        }
        if (this.g && this.k == null) {
            si0.a("Temporarily disable for app with needEventsForTemporarily: " + this.i);
            this.k = this.i;
        }
        if (this.e == 1 || this.j == (zA = a(this.i))) {
            return;
        }
        si0.a("Previous app blacklist: " + this.j);
        si0.a("Current app blacklist (" + this.i + "): " + zA);
        this.j = zA;
        if (zA) {
            cursorAccessibilityService.n(5);
        } else {
            cursorAccessibilityService.p();
        }
    }

    public final void c() {
        this.e = pn0.t().i();
        SharedPreferences sharedPreferences = (SharedPreferences) pn0.t().d;
        oq0 oq0Var = oq0.h0;
        this.f = new HashSet(sharedPreferences.getStringSet(oq0Var.name(), (Set) oq0Var.b));
        d();
    }

    public final void d() {
        boolean z = true;
        if (this.e == 1 && this.k == null && !this.g) {
            z = false;
        }
        String str = this.a;
        CursorAccessibilityService cursorAccessibilityService = this.c;
        if (z) {
            z.a(cursorAccessibilityService, str, 32);
        } else {
            z.a(cursorAccessibilityService, str, 0);
        }
    }
}
