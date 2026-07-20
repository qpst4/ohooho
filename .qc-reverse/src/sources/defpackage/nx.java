package defpackage;

import android.content.Context;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nx {
    public static final int f = (int) Math.round(5.1000000000000005d);
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public nx(Context context) {
        boolean zS = i1.S(context, R.attr.elevationOverlayEnabled, false);
        int iK = xr.k(context, R.attr.elevationOverlayColor, 0);
        int iK2 = xr.k(context, R.attr.elevationOverlayAccentColor, 0);
        int iK3 = xr.k(context, R.attr.colorSurface, 0);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.a = zS;
        this.b = iK;
        this.c = iK2;
        this.d = iK3;
        this.e = f2;
    }
}
