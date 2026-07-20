package defpackage;

import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class g0 {
    public static /* synthetic */ AdaptiveIconDrawable d(Drawable drawable, InsetDrawable insetDrawable, InsetDrawable insetDrawable2) {
        return new AdaptiveIconDrawable(drawable, insetDrawable, insetDrawable2);
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedCallback f(Object obj) {
        return (OnBackInvokedCallback) obj;
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher i(Object obj) {
        return (OnBackInvokedDispatcher) obj;
    }
}
