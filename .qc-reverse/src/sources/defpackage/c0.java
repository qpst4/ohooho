package defpackage;

import android.accessibilityservice.GestureDescription;
import android.app.NotificationChannel;
import android.graphics.Path;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class c0 {
    public static /* synthetic */ GestureDescription.StrokeDescription d(Path path) {
        return new GestureDescription.StrokeDescription(path, 0L, 1L, true);
    }

    public static /* synthetic */ GestureDescription.StrokeDescription e(Path path, long j, long j2, boolean z) {
        return new GestureDescription.StrokeDescription(path, j, j2, z);
    }

    public static /* synthetic */ NotificationChannel g(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }

    public static /* synthetic */ AdaptiveIconDrawable j(Drawable drawable, InsetDrawable insetDrawable) {
        return new AdaptiveIconDrawable(drawable, insetDrawable);
    }
}
