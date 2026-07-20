package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class sc1 extends i1 {
    public static Font k0(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iN0 = n0(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int iN02 = n0(fontStyle, font2.getStyle());
            if (iN02 < iN0) {
                font = font2;
                iN0 = iN02;
            }
        }
        return font;
    }

    public static int n0(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // defpackage.i1
    public final Typeface k(Context context, u20 u20Var, Resources resources, int i) {
        try {
            FontFamily.Builder builder = null;
            for (v20 v20Var : u20Var.a) {
                try {
                    Font fontBuild = new Font.Builder(resources, v20Var.f).setWeight(v20Var.b).setSlant(v20Var.c ? 1 : 0).setTtcIndex(v20Var.e).setFontVariationSettings(v20Var.d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(k0(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // defpackage.i1
    public final Typeface l(Context context, x20[] x20VarArr, int i) {
        try {
            FontFamily fontFamilyL0 = l0(x20VarArr, context.getContentResolver());
            if (fontFamilyL0 == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(fontFamilyL0).setStyle(k0(fontFamilyL0, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    public final FontFamily l0(x20[] x20VarArr, ContentResolver contentResolver) {
        Font fontBuild;
        String str;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        FontFamily.Builder builder = null;
        for (x20 x20Var : x20VarArr) {
            if (Objects.equals(x20Var.a.getScheme(), "systemfont")) {
                fontBuild = m0(x20Var);
            } else {
                try {
                    Uri uri = x20Var.a;
                    str = x20Var.e;
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                } catch (IOException e) {
                    Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
                    fontBuild = null;
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    fontBuild = null;
                } else {
                    try {
                        Font.Builder ttcIndex = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(x20Var.c).setSlant(x20Var.d ? 1 : 0).setTtcIndex(x20Var.b);
                        if (!TextUtils.isEmpty(str)) {
                            ttcIndex.setFontVariationSettings(str);
                        }
                        fontBuild = ttcIndex.build();
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            }
            if (fontBuild != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(fontBuild);
                } else {
                    builder.addFont(fontBuild);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    @Override // defpackage.i1
    public final Typeface m(int i, Context context, List list) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyL0 = l0((x20[]) list.get(0), contentResolver);
            if (fontFamilyL0 == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyL0);
            for (int i2 = 1; i2 < list.size(); i2++) {
                FontFamily fontFamilyL02 = l0((x20[]) list.get(i2), contentResolver);
                if (fontFamilyL02 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyL02);
                }
            }
            return customFallbackBuilder.setStyle(k0(fontFamilyL0, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    public Font m0(x20 x20Var) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }

    @Override // defpackage.i1
    public final Typeface n(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }
}
