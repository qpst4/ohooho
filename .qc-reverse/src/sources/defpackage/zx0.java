package defpackage;

import android.view.View;
import android.view.WindowManager;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zx0 extends View {
    public static zx0 d;
    public final WindowManager b;
    public final WindowManager.LayoutParams c;

    public zx0() {
        super(CursorAccessibilityService.q);
        WindowManager windowManager = (WindowManager) CursorAccessibilityService.q.getSystemService("window");
        this.b = windowManager;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.c = layoutParams;
        layoutParams.type = 2032;
        layoutParams.flags = 24;
        layoutParams.width = 0;
        layoutParams.height = 0;
        layoutParams.format = -2;
        layoutParams.alpha = 0.0f;
        windowManager.addView(this, layoutParams);
        setVisibility(0);
    }

    public static void a(int i) {
        zx0 zx0Var = getInstance();
        WindowManager.LayoutParams layoutParams = zx0Var.c;
        int i2 = 1;
        if (i != 0) {
            if (i != 1) {
                i2 = 2;
                if (i == 2) {
                    i2 = 9;
                } else if (i == 3) {
                    i2 = 8;
                }
            } else {
                i2 = 0;
            }
        }
        layoutParams.screenOrientation = i2;
        zx0Var.b.updateViewLayout(zx0Var, layoutParams);
    }

    public static int getCurrentRotation() {
        zx0 zx0Var = d;
        if (zx0Var == null) {
            return -1;
        }
        int i = zx0Var.c.screenOrientation;
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 0;
        }
        if (i != 8) {
            return i != 9 ? -1 : 2;
        }
        return 3;
    }

    public static zx0 getInstance() {
        if (d == null) {
            synchronized (zx0.class) {
                try {
                    zx0 zx0Var = d;
                    if (zx0Var == null || !zx0Var.isAttachedToWindow()) {
                        d = new zx0();
                    }
                } finally {
                }
            }
        }
        return d;
    }
}
