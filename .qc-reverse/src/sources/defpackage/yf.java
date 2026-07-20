package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yf implements mp {
    public final Context b;
    public final WeakReference c;
    public final Uri d;
    public final Bitmap e;
    public final float[] f;
    public final int g;
    public final int h;
    public final int i;
    public final boolean j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final boolean o;
    public final boolean p;
    public final lq q;
    public final Bitmap.CompressFormat r;
    public final int s;
    public final Uri t;
    public yc0 u;

    public yf(Context context, WeakReference weakReference, Uri uri, Bitmap bitmap, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3, lq lqVar, Bitmap.CompressFormat compressFormat, int i8, Uri uri2) {
        fArr.getClass();
        lqVar.getClass();
        compressFormat.getClass();
        this.b = context;
        this.c = weakReference;
        this.d = uri;
        this.e = bitmap;
        this.f = fArr;
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.j = z;
        this.k = i4;
        this.l = i5;
        this.m = i6;
        this.n = i7;
        this.o = z2;
        this.p = z3;
        this.q = lqVar;
        this.r = compressFormat;
        this.s = i8;
        this.t = uri2;
        this.u = new bd0();
    }

    public static final Object a(yf yfVar, uf ufVar, o31 o31Var) throws Throwable {
        rs rsVar = iu.a;
        Object objU = fc0.U(dj0.a, new vf(yfVar, ufVar, null, 0), o31Var);
        return objU == np.b ? objU : ow0.h;
    }

    @Override // defpackage.mp
    public final ep b() {
        rs rsVar = iu.a;
        q70 q70Var = dj0.a;
        yc0 yc0Var = this.u;
        q70Var.getClass();
        return xy0.t(q70Var, yc0Var);
    }
}
