package defpackage;

import android.app.Notification;
import android.content.Context;
import android.content.LocusId;
import android.content.res.Resources;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.Insets;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ua {
    public static LocusId a(String str) {
        return new LocusId(str);
    }

    public static ColorFilter b(int i, Object obj) {
        return new BlendModeColorFilter(i, (BlendMode) obj);
    }

    public static String c(LocusId locusId) {
        return locusId.getId();
    }

    public static String d(Context context) {
        return context.getOpPackageName();
    }

    public static Object e() {
        switch (l11.r(10)) {
            case 0:
                return BlendMode.CLEAR;
            case 1:
                return BlendMode.SRC;
            case 2:
                return BlendMode.DST;
            case 3:
                return BlendMode.SRC_OVER;
            case 4:
                return BlendMode.DST_OVER;
            case 5:
                return BlendMode.SRC_IN;
            case 6:
                return BlendMode.DST_IN;
            case 7:
                return BlendMode.SRC_OUT;
            case 8:
                return BlendMode.DST_OUT;
            case 9:
                return BlendMode.SRC_ATOP;
            case 10:
                return BlendMode.DST_ATOP;
            case 11:
                return BlendMode.XOR;
            case 12:
                return BlendMode.PLUS;
            case 13:
                return BlendMode.MODULATE;
            case 14:
                return BlendMode.SCREEN;
            case 15:
                return BlendMode.OVERLAY;
            case 16:
                return BlendMode.DARKEN;
            case 17:
                return BlendMode.LIGHTEN;
            case 18:
                return BlendMode.COLOR_DODGE;
            case 19:
                return BlendMode.COLOR_BURN;
            case 20:
                return BlendMode.HARD_LIGHT;
            case 21:
                return BlendMode.SOFT_LIGHT;
            case 22:
                return BlendMode.DIFFERENCE;
            case 23:
                return BlendMode.EXCLUSION;
            case 24:
                return BlendMode.MULTIPLY;
            case 25:
                return BlendMode.HUE;
            case 26:
                return BlendMode.SATURATION;
            case 27:
                return BlendMode.COLOR;
            case 28:
                return BlendMode.LUMINOSITY;
            default:
                return null;
        }
    }

    public static Insets f(int i, int i2, int i3, int i4) {
        return Insets.of(i, i2, i3, i4);
    }

    public static void g(Resources.Theme theme) {
        theme.rebase();
    }

    public static void h(Notification.Builder builder, boolean z) {
        builder.setAllowSystemGeneratedContextualActions(z);
    }

    public static void i(Notification.Builder builder) {
        builder.setBubbleMetadata(null);
    }

    public static void j(Notification.Action.Builder builder) {
        builder.setContextual(false);
    }
}
