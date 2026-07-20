package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityService$TakeScreenshotCallback;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gy0 implements AccessibilityService$TakeScreenshotCallback {
    public final /* synthetic */ iy0 a;

    public gy0(iy0 iy0Var) {
        this.a = iy0Var;
    }

    public final void onFailure(int i) {
        String str = jy0.k;
        new Handler(Looper.getMainLooper()).post(new s4(13));
        si0.b("onFailure error: " + i);
        yb0.y(R.string.general_action_error, 1);
    }

    public final void onSuccess(AccessibilityService.ScreenshotResult screenshotResult) {
        String str = jy0.k;
        new Handler(Looper.getMainLooper()).post(new s4(13));
        Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(screenshotResult.getHardwareBuffer(), screenshotResult.getColorSpace());
        final iy0 iy0Var = this.a;
        jy0.p(iy0Var, bitmapWrapHardwareBuffer);
        if (iy0Var.a) {
            jy0.q();
        }
        if (iy0Var.b) {
            jy0.o(iy0Var);
        }
        hy0 hy0Var = iy0Var.g;
        if (hy0Var == hy0.extraOptions) {
            final int i = 0;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: fy0
                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = i;
                    iy0 iy0Var2 = iy0Var;
                    switch (i2) {
                        case 0:
                            new g3(CursorAccessibilityService.q, iy0Var2, 1);
                            break;
                        default:
                            new g3(CursorAccessibilityService.q, iy0Var2, 0);
                            break;
                    }
                }
            });
        } else if (hy0Var == hy0.share) {
            jy0.r();
        } else if (hy0Var == hy0.crop) {
            final int i2 = 1;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: fy0
                @Override // java.lang.Runnable
                public final void run() {
                    int i22 = i2;
                    iy0 iy0Var2 = iy0Var;
                    switch (i22) {
                        case 0:
                            new g3(CursorAccessibilityService.q, iy0Var2, 1);
                            break;
                        default:
                            new g3(CursorAccessibilityService.q, iy0Var2, 0);
                            break;
                    }
                }
            });
        }
    }
}
