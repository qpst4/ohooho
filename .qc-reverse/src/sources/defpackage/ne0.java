package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityWindowInfo;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ne0 {
    public final bk a = new bk(100);
    public final r51 b = new r51(100, true);
    public final CursorAccessibilityService c;
    public final CursorAccessibilityService d;
    public boolean e;
    public int f;

    public ne0(CursorAccessibilityService cursorAccessibilityService, CursorAccessibilityService cursorAccessibilityService2) {
        this.c = cursorAccessibilityService;
        this.d = cursorAccessibilityService2;
        c();
    }

    public final int a() {
        Rect rect;
        Iterator<AccessibilityWindowInfo> it = this.c.getWindows().iterator();
        while (true) {
            if (!it.hasNext()) {
                rect = null;
                break;
            }
            AccessibilityWindowInfo next = it.next();
            if (next.getType() == 2) {
                rect = new Rect();
                next.getBoundsInScreen(rect);
                next.recycle();
                break;
            }
            next.recycle();
        }
        if (rect == null) {
            return 0;
        }
        return rect.height();
    }

    public final int b(int i) {
        return (ey0.b() - i) - yb0.l(this.c);
    }

    public final void c() {
        boolean z = true;
        if (pn0.t().v() == 1 && pn0.t().u() == 1) {
            z = false;
        }
        this.e = z;
        si0.a("Keyboard handle: " + this.e);
        boolean z2 = this.e;
        CursorAccessibilityService cursorAccessibilityService = this.c;
        if (!z2) {
            this.f = 0;
            z.a(cursorAccessibilityService, "ne0", 0);
            return;
        }
        int iA = a();
        this.f = iA;
        if (iA > 0) {
            z.a(cursorAccessibilityService, "ne0", 4194336);
        } else {
            z.a(cursorAccessibilityService, "ne0", Build.VERSION.SDK_INT <= 30 ? 32 : 4194336);
        }
    }
}
