package defpackage;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nw0 {
    public static final int[] a = {R.attr.state_pressed};
    public static final int[] b = {R.attr.state_focused};
    public static final int[] c = {R.attr.state_selected, R.attr.state_pressed};
    public static final int[] d = {R.attr.state_selected};
    public static final int[] e = {R.attr.state_enabled, R.attr.state_pressed};
    public static final String f = nw0.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        int[] iArr = b;
        return new ColorStateList(new int[][]{d, iArr, StateSet.NOTHING}, new int[]{b(colorStateList, c), b(colorStateList, iArr), b(colorStateList, a)});
    }

    public static int b(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return wl.f(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    public static ColorStateList c(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(e, 0)) != 0) {
            Log.w(f, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean d(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            } else if (i == 16842908 || i == 16842919 || i == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
