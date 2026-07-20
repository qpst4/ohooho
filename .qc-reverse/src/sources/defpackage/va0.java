package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class va0 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[Bitmap.Config.values().length];
        a = iArr;
        iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
        iArr[Bitmap.Config.RGB_565.ordinal()] = 2;
        iArr[Bitmap.Config.ARGB_4444.ordinal()] = 3;
        iArr[Bitmap.Config.ALPHA_8.ordinal()] = 4;
    }
}
