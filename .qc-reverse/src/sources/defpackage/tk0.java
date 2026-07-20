package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Trace;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.method.TransformationMethod;
import android.util.Base64;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.a;
import com.quickcursor.R;
import defpackage.gg0;
import defpackage.yf0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tk0 {
    public static final ow0 g;
    public static final c70 i;
    public static long j;
    public static Method k;
    public static final float[][] a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    public static final float[][] b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    public static final float[] c = {95.047f, 100.0f, 108.883f};
    public static final float[][] d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    public static final String[] e = new String[0];
    public static final Object f = new Object();
    public static final ix h = new ix(25);

    static {
        int i2 = 24;
        g = new ow0(i2);
        i = new c70(i2);
    }

    public static int A(float f2) {
        if (!Float.isNaN(f2)) {
            return Math.round(f2);
        }
        zy.n("Cannot round NaN value.");
        return 0;
    }

    public static void D(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i2);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i3);
    }

    public static void E(z7 z7Var) {
        int i2;
        try {
            kj kjVar = new kj();
            kjVar.c = true;
            kjVar.f = true;
            kjVar.g = false;
            kjVar.h = true;
            kjVar.l = R.xml.changelog;
            kjVar.i = z7Var.getString(R.string.changelog_title) + " 3.0.1";
            bs0.k0(kjVar).j0(z7Var.w(), bs0.class.getName());
            SharedPreferences sharedPreferences = z7Var.getSharedPreferences("com.michaelflisar.changelog", 0);
            try {
                i2 = z7Var.getPackageManager().getPackageInfo(z7Var.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                i2 = -1;
            }
            sharedPreferences.edit().putInt("changelogVersion", i2).apply();
            pn0.t().Q(true);
        } catch (Exception unused) {
        }
    }

    public static void F(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    public static void G(byte[] bArr, long j2, int i2) {
        int i3 = 0;
        while (i3 < 4) {
            bArr[i2 + i3] = (byte) (255 & j2);
            i3++;
            j2 >>= 8;
        }
    }

    public static int H(int i2) throws GeneralSecurityException {
        int iR = l11.r(i2);
        int i3 = 1;
        if (iR != 1) {
            i3 = 2;
            if (iR != 2) {
                if (iR == 3) {
                    return 3;
                }
                throw new GeneralSecurityException("unknown curve type: ".concat(l11.s(i2)));
            }
        }
        return i3;
    }

    public static void I(int i2) throws NoSuchAlgorithmException {
        int iR = l11.r(i2);
        if (iR != 1 && iR != 2 && iR != 3) {
            throw new NoSuchAlgorithmException("hash unsupported for HMAC: ".concat(l11.t(i2)));
        }
    }

    public static void J(int i2) throws GeneralSecurityException {
        int iR = l11.r(i2);
        if (iR == 1 || iR == 2 || iR == 3) {
        } else {
            throw new GeneralSecurityException("unknown point format: ".concat(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "null" : "UNRECOGNIZED" : "DO_NOT_USE_CRUNCHY_UNCOMPRESSED" : "COMPRESSED" : "UNCOMPRESSED" : "UNKNOWN_FORMAT"));
        }
    }

    public static void K(xv xvVar) throws GeneralSecurityException {
        int i2;
        int i3 = xvVar.q().d;
        if (i3 != 0) {
            i2 = 2;
            if (i3 != 2) {
                i2 = 3;
                if (i3 != 3) {
                    i2 = 4;
                    if (i3 != 4) {
                        i2 = 0;
                    }
                }
            }
        } else {
            i2 = 1;
        }
        if (i2 == 0) {
            i2 = 5;
        }
        xr.m(H(i2));
        int iA = l11.a(xvVar.q().e);
        I(iA != 0 ? iA : 5);
        if (xvVar.p() == 1) {
            s1.l("unknown EC point format");
            return;
        }
        uv uvVar = xvVar.e;
        if (uvVar == null) {
            uvVar = uv.e;
        }
        je0 je0Var = uvVar.d;
        if (je0Var == null) {
            je0Var = je0.g;
        }
        ev0.f(je0Var);
    }

    public static void M(Parcel parcel, int i2, Parcelable parcelable, int i3) {
        if (parcelable == null) {
            return;
        }
        int iR = R(parcel, i2);
        parcelable.writeToParcel(parcel, i3);
        U(parcel, iR);
    }

    public static void N(Parcel parcel, int i2, String str) {
        if (str == null) {
            return;
        }
        int iR = R(parcel, i2);
        parcel.writeString(str);
        U(parcel, iR);
    }

    public static void O(Parcel parcel, int i2, Parcelable[] parcelableArr, int i3) {
        if (parcelableArr == null) {
            return;
        }
        int iR = R(parcel, i2);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i3);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        U(parcel, iR);
    }

    public static void P(Parcel parcel, int i2, List list) {
        if (list == null) {
            return;
        }
        int iR = R(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            Parcelable parcelable = (Parcelable) list.get(i3);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        U(parcel, iR);
    }

    public static float Q() {
        return ((float) Math.pow(0.5689655172413793d, 3.0d)) * 100.0f;
    }

    public static int R(Parcel parcel, int i2) {
        parcel.writeInt(i2 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void U(Parcel parcel, int i2) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(iDataPosition - i2);
        parcel.setDataPosition(iDataPosition);
    }

    public static void V(Parcel parcel, int i2, int i3) {
        parcel.writeInt(i2 | (i3 << 16));
    }

    public static final void a(bg1 bg1Var, final e8 e8Var, final a aVar) {
        Object obj;
        e8Var.getClass();
        aVar.getClass();
        HashMap map = bg1Var.a;
        if (map == null) {
            obj = null;
        } else {
            synchronized (map) {
                obj = bg1Var.a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController == null || savedStateHandleController.b) {
            return;
        }
        e8Var.getClass();
        aVar.getClass();
        if (savedStateHandleController.b) {
            s1.f("Already attached to lifecycleOwner");
        } else {
            savedStateHandleController.b = true;
            aVar.a(savedStateHandleController);
            e8Var.e(null, null);
        }
        zf0 zf0Var = aVar.c;
        if (zf0Var == zf0.c || zf0Var.compareTo(zf0.e) >= 0) {
            e8Var.f();
        } else {
            aVar.a(new dg0() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // defpackage.dg0
                public final void c(gg0 gg0Var, yf0 yf0Var) {
                    if (yf0Var == yf0.ON_START) {
                        aVar.f(this);
                        e8Var.f();
                    }
                }
            });
        }
    }

    public static void b(String str) {
        if (str.length() > 127) {
            str = str.substring(0, 127);
        }
        Trace.beginSection(str);
    }

    public static void c(String str) {
        if (str.length() <= 10000) {
            return;
        }
        throw new NumberFormatException("Number string too large: " + str.substring(0, 30) + "...");
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            zy.n("The key length in bytes must be 32.");
            return null;
        }
        long jU = u(0, bArr) & 67108863;
        int i2 = 3;
        long jU2 = (u(3, bArr) >> 2) & 67108611;
        long jU3 = (u(6, bArr) >> 4) & 67092735;
        long jU4 = (u(9, bArr) >> 6) & 66076671;
        long jU5 = (u(12, bArr) >> 8) & 1048575;
        long j2 = jU2 * 5;
        long j3 = jU3 * 5;
        long j4 = jU4 * 5;
        long j5 = jU5 * 5;
        byte[] bArr3 = new byte[17];
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        int i3 = 0;
        while (i3 < bArr2.length) {
            int iMin = Math.min(16, bArr2.length - i3);
            System.arraycopy(bArr2, i3, bArr3, 0, iMin);
            bArr3[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr3, iMin + 1, 17, (byte) 0);
            }
            long jU6 = j10 + (u(0, bArr3) & 67108863);
            long jU7 = j6 + ((u(i2, bArr3) >> 2) & 67108863);
            long jU8 = j7 + ((u(6, bArr3) >> 4) & 67108863);
            long jU9 = j8 + ((u(9, bArr3) >> 6) & 67108863);
            long j11 = jU2;
            long jU10 = j9 + (((u(12, bArr3) >> 8) & 67108863) | ((long) (bArr3[16] << 24)));
            long j12 = (jU10 * j2) + (jU9 * j3) + (jU8 * j4) + (jU7 * j5) + (jU6 * jU);
            long j13 = (jU10 * j3) + (jU9 * j4) + (jU8 * j5) + (jU7 * jU) + (jU6 * j11);
            long j14 = (jU10 * j4) + (jU9 * j5) + (jU8 * jU) + (jU7 * j11) + (jU6 * jU3);
            long j15 = (jU10 * j5) + (jU9 * jU) + (jU8 * j11) + (jU7 * jU3) + (jU6 * jU4);
            long j16 = jU9 * j11;
            long j17 = jU10 * jU;
            long j18 = j13 + (j12 >> 26);
            long j19 = j14 + (j18 >> 26);
            long j20 = j15 + (j19 >> 26);
            long j21 = j17 + j16 + (jU8 * jU3) + (jU7 * jU4) + (jU6 * jU5) + (j20 >> 26);
            long j22 = j21 >> 26;
            j9 = j21 & 67108863;
            long j23 = (j22 * 5) + (j12 & 67108863);
            i3 += 16;
            j7 = j19 & 67108863;
            j8 = j20 & 67108863;
            j10 = j23 & 67108863;
            j6 = (j18 & 67108863) + (j23 >> 26);
            jU2 = j11;
            i2 = 3;
        }
        long j24 = j7 + (j6 >> 26);
        long j25 = j24 & 67108863;
        long j26 = j8 + (j24 >> 26);
        long j27 = j26 & 67108863;
        long j28 = j9 + (j26 >> 26);
        long j29 = j28 & 67108863;
        long j30 = ((j28 >> 26) * 5) + j10;
        long j31 = j30 >> 26;
        long j32 = j30 & 67108863;
        long j33 = (j6 & 67108863) + j31;
        long j34 = j32 + 5;
        long j35 = j34 & 67108863;
        long j36 = j33 + (j34 >> 26);
        long j37 = j25 + (j36 >> 26);
        long j38 = j27 + (j37 >> 26);
        long j39 = j38 & 67108863;
        long j40 = (j29 + (j38 >> 26)) - 67108864;
        long j41 = j40 >> 63;
        long j42 = j32 & j41;
        long j43 = j33 & j41;
        long j44 = j25 & j41;
        long j45 = j27 & j41;
        long j46 = j29 & j41;
        long j47 = ~j41;
        long j48 = j43 | (j36 & 67108863 & j47);
        long j49 = j44 | (j37 & 67108863 & j47);
        long j50 = j45 | (j39 & j47);
        long j51 = (j42 | (j35 & j47) | (j48 << 26)) & 4294967295L;
        long j52 = ((j48 >> 6) | (j49 << 20)) & 4294967295L;
        long j53 = ((j49 >> 12) | (j50 << 14)) & 4294967295L;
        long j54 = ((j50 >> 18) | ((j46 | (j40 & j47)) << 8)) & 4294967295L;
        long jU11 = u(16, bArr) + j51;
        long j55 = jU11 & 4294967295L;
        long jU12 = u(20, bArr) + j52 + (jU11 >> 32);
        long jU13 = u(24, bArr) + j53 + (jU12 >> 32);
        long jU14 = (u(28, bArr) + j54 + (jU13 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        G(bArr4, j55, 0);
        G(bArr4, jU12 & 4294967295L, 4);
        G(bArr4, jU13 & 4294967295L, 8);
        G(bArr4, jU14, 12);
        return bArr4;
    }

    public static o20 e(Context context) {
        ProviderInfo providerInfo;
        m20 m20Var;
        ApplicationInfo applicationInfo;
        int i2 = 10;
        ow0 csVar = Build.VERSION.SDK_INT >= 28 ? new cs(i2) : new ow0(i2);
        PackageManager packageManager = context.getPackageManager();
        f01.k("Package manager required to locate emoji font provider", packageManager);
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            m20Var = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArrH = csVar.h(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArrH) {
                    arrayList.add(signature.toByteArray());
                }
                m20Var = new m20(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList), null, null);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e2);
                m20Var = null;
            }
        }
        if (m20Var == null) {
            return null;
        }
        return new o20(new n20(context, m20Var));
    }

    public static final void f(rx0 rx0Var) {
        px0 px0Var;
        zf0 zf0Var = rx0Var.p().c;
        if (zf0Var != zf0.c && zf0Var != zf0.d) {
            zy.n("Failed requirement.");
            return;
        }
        Iterator it = ((ix0) rx0Var.c().f).iterator();
        while (true) {
            ex0 ex0Var = (ex0) it;
            if (!ex0Var.hasNext()) {
                px0Var = null;
                break;
            }
            Map.Entry entry = (Map.Entry) ex0Var.next();
            entry.getClass();
            String str = (String) entry.getKey();
            px0Var = (px0) entry.getValue();
            if (fc0.b(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                break;
            }
        }
        if (px0Var == null) {
            mx0 mx0Var = new mx0(rx0Var.c(), (fg1) rx0Var);
            rx0Var.c().e("androidx.lifecycle.internal.SavedStateHandlesProvider", mx0Var);
            rx0Var.p().a(new SavedStateHandleAttacher(mx0Var));
        }
    }

    public static Drawable j(Context context, int i2) {
        return bw0.b().c(context, i2);
    }

    public static Object l(String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 34) {
            return j0.b(str, bundle);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (d4.class.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static final nx0 n(fg1 fg1Var) {
        ArrayList arrayList = new ArrayList();
        tu0.a.getClass();
        new lk(nx0.class);
        arrayList.add(new cg1(nx0.class));
        cg1[] cg1VarArr = (cg1[]) arrayList.toArray(new cg1[0]);
        return (nx0) new ra(fg1Var.m(), new sp1(29, (cg1[]) Arrays.copyOf(cg1VarArr, cg1VarArr.length)), fg1Var instanceof u70 ? ((u70) fg1Var).k() : sp.b).u(nx0.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }

    public static int o(int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 32) {
            return 5;
        }
        if (i2 == 64) {
            return 6;
        }
        if (i2 == 128) {
            return 7;
        }
        if (i2 == 256) {
            return 8;
        }
        if (i2 == 512) {
            return 9;
        }
        zy.n(qq0.i("type needs to be >= FIRST and <= LAST, type=", i2));
        return 0;
    }

    public static int p(float f2) {
        if (f2 < 1.0f) {
            return -16777216;
        }
        if (f2 > 99.0f) {
            return -1;
        }
        float f3 = (f2 + 16.0f) / 116.0f;
        float f4 = f2 > 8.0f ? f3 * f3 * f3 : f2 / 903.2963f;
        float f5 = f3 * f3 * f3;
        boolean z = f5 > 0.008856452f;
        float f6 = z ? f5 : ((f3 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f5 = ((f3 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = c;
        return wl.a(f6 * fArr[0], f4 * fArr[1], f5 * fArr[2]);
    }

    public static boolean r() {
        if (Build.VERSION.SDK_INT >= 29) {
            return g71.a();
        }
        try {
            if (k == null) {
                j = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                k = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) k.invoke(null, Long.valueOf(j))).booleanValue();
        } catch (Exception e2) {
            if (!(e2 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e2);
                return false;
            }
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            zy.m(cause);
            return false;
        }
    }

    public static float t(int i2) {
        float f2 = i2 / 255.0f;
        return (f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static long u(int i2, byte[] bArr) {
        return ((long) (((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16))) & 4294967295L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.t20 v(android.content.res.XmlResourceParser r26, android.content.res.Resources r27) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tk0.v(android.content.res.XmlResourceParser, android.content.res.Resources):t20");
    }

    public static BigDecimal w(String str) {
        c(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs(bigDecimal.scale()) < 10000) {
            return bigDecimal;
        }
        throw new NumberFormatException("Number has unsupported scale: ".concat(str));
    }

    public static ep y(ep epVar, ep epVar2) {
        epVar2.getClass();
        return epVar2 == my.b ? epVar : (ep) epVar2.g(epVar, xl.e);
    }

    public static List z(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i2);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public abstract void B(boolean z);

    public abstract void C(boolean z);

    public abstract TransformationMethod L(TransformationMethod transformationMethod);

    public abstract gn1 S(on1 on1Var);

    public abstract nn1 T(on1 on1Var);

    public abstract void W(nn1 nn1Var, nn1 nn1Var2);

    public abstract void X(nn1 nn1Var, Thread thread);

    public abstract boolean Y(on1 on1Var, gn1 gn1Var, gn1 gn1Var2);

    public abstract boolean Z(on1 on1Var, Object obj, Object obj2);

    public abstract boolean a0(on1 on1Var, nn1 nn1Var, nn1 nn1Var2);

    public abstract int g(String str, byte[] bArr, int i2, int i3);

    public abstract Method h(Class cls, Field field);

    public abstract Constructor i(Class cls);

    public abstract InputFilter[] k(InputFilter[] inputFilterArr);

    public abstract String[] m(Class cls);

    public abstract boolean q();

    public abstract boolean s(Class cls);

    public abstract int x(byte[] bArr, int i2, int i3);
}
