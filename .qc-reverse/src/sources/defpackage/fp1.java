package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EdgeEffect;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.google.android.material.appbar.MaterialToolbar;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fp1 {
    public static final byte[] a = new byte[0];
    public static final char[][] b = {new char[]{'0', '.'}, new char[]{'0', '.', '0'}, new char[]{'0', '.', '0', '0'}, new char[]{'0', '.', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0', '0', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}, new char[]{'0', '.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}};
    public static final ow0 c = new ow0(22);
    public static final ik d = new ik(5);
    public static boolean e = true;

    public static void A(i9 i9Var, float f) {
        float f2;
        float f3;
        rw0 rw0Var = (rw0) i9Var.c;
        CardView cardView = (CardView) i9Var.d;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f != rw0Var.e || rw0Var.f != useCompatPadding || rw0Var.g != preventCornerOverlap) {
            rw0Var.e = f;
            rw0Var.f = useCompatPadding;
            rw0Var.g = preventCornerOverlap;
            rw0Var.b(null);
            rw0Var.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            i9Var.I(0, 0, 0, 0);
            return;
        }
        rw0 rw0Var2 = (rw0) i9Var.c;
        float f4 = rw0Var2.e;
        float f5 = rw0Var2.a;
        if (cardView.getPreventCornerOverlap()) {
            f2 = (float) (((1.0d - sw0.a) * ((double) f5)) + ((double) f4));
        } else {
            int i = sw0.b;
            f2 = f4;
        }
        int iCeil = (int) Math.ceil(f2);
        if (cardView.getPreventCornerOverlap()) {
            f3 = (float) (((1.0d - sw0.a) * ((double) f5)) + ((double) (f4 * 1.5f)));
        } else {
            f3 = f4 * 1.5f;
        }
        int iCeil2 = (int) Math.ceil(f3);
        i9Var.I(iCeil, iCeil2, iCeil, iCeil2);
    }

    public static void B(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            yf1.b(viewGroup, z);
        } else if (e) {
            try {
                yf1.b(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
    }

    public static int C(int i) throws GeneralSecurityException {
        int iR = l11.r(i);
        int i2 = 1;
        if (iR != 1) {
            i2 = 2;
            if (iR != 2) {
                if (iR == 3) {
                    return 3;
                }
                throw new GeneralSecurityException("unknown curve type: ".concat(l11.s(i)));
            }
        }
        return i2;
    }

    public static void D(int i) throws GeneralSecurityException {
        int iR = l11.r(i);
        if (iR == 1 || iR == 2) {
        } else {
            throw new GeneralSecurityException("unknown ECDSA encoding: ".concat(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "UNRECOGNIZED" : "DER" : "IEEE_P1363" : "UNKNOWN_ENCODING"));
        }
    }

    public static int E(int i) throws GeneralSecurityException {
        int iR = l11.r(i);
        int i2 = 1;
        if (iR != 1) {
            i2 = 2;
            if (iR != 2) {
                if (iR == 3) {
                    return 3;
                }
                throw new GeneralSecurityException("unknown hash type: ".concat(l11.t(i)));
            }
        }
        return i2;
    }

    public static boolean F(int i, int i2, int i3, int i4) {
        return (i3 == 1 || i3 == 2 || (i3 == 4 && i != 2)) || (i4 == 1 || i4 == 2 || (i4 == 4 && i2 != 2));
    }

    public static void G(ov ovVar) throws GeneralSecurityException {
        int iP = ovVar.p();
        int iA = l11.a(ovVar.d);
        if (iA == 0) {
            iA = 5;
        }
        int i = ovVar.e;
        int i2 = i != 0 ? i != 2 ? i != 3 ? i != 4 ? 0 : 4 : 3 : 2 : 1;
        int i3 = i2 != 0 ? i2 : 5;
        int iR = l11.r(iP);
        if (iR != 1 && iR != 2) {
            s1.l("unsupported signature encoding");
            return;
        }
        int iR2 = l11.r(i3);
        if (iR2 == 1) {
            if (iA == 3) {
                return;
            }
            s1.l("Invalid ECDSA parameters");
        } else if (iR2 != 2 && iR2 != 3) {
            s1.l("Invalid ECDSA parameters");
        } else {
            if (iA == 4) {
                return;
            }
            s1.l("Invalid ECDSA parameters");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0168 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0150  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v27, types: [int] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v44 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v47 */
    /* JADX WARN: Type inference failed for: r7v48 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v53 */
    /* JADX WARN: Type inference failed for: r7v54 */
    /* JADX WARN: Type inference failed for: r7v55 */
    /* JADX WARN: Type inference failed for: r7v56 */
    /* JADX WARN: Type inference failed for: r7v57 */
    /* JADX WARN: Type inference failed for: r7v58 */
    /* JADX WARN: Type inference failed for: r7v59 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v60 */
    /* JADX WARN: Type inference failed for: r7v61 */
    /* JADX WARN: Type inference failed for: r7v62 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void H(android.content.Context r18, java.util.concurrent.Executor r19, defpackage.kr0 r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fp1.H(android.content.Context, java.util.concurrent.Executor, kr0, boolean):void");
    }

    public static String I(yo1 yo1Var) {
        StringBuilder sb = new StringBuilder(yo1Var.d());
        for (int i = 0; i < yo1Var.d(); i++) {
            byte b2 = yo1Var.b(i);
            if (b2 == 34) {
                sb.append("\\\"");
            } else if (b2 == 39) {
                sb.append("\\'");
            } else if (b2 != 92) {
                switch (b2) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (b2 < 32 || b2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((b2 >>> 6) & 3) + 48));
                            sb.append((char) (((b2 >>> 3) & 7) + 48));
                            sb.append((char) ((b2 & 7) + 48));
                        } else {
                            sb.append((char) b2);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static void J(String str, int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static bp1 K() {
        String str;
        ClassLoader classLoader = fp1.class.getClassLoader();
        if (bp1.class.equals(bp1.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!bp1.class.getPackage().equals(fp1.class.getPackage())) {
                zy.n(bp1.class.getName());
                return null;
            }
            str = bp1.class.getPackage().getName() + ".BlazeGenerated" + bp1.class.getSimpleName() + "Loader";
        }
        try {
            try {
                try {
                    try {
                        qq0.j(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                        throw null;
                    } catch (InvocationTargetException e2) {
                        throw new IllegalStateException(e2);
                    }
                } catch (NoSuchMethodException e3) {
                    throw new IllegalStateException(e3);
                }
            } catch (IllegalAccessException e4) {
                throw new IllegalStateException(e4);
            } catch (InstantiationException e5) {
                throw new IllegalStateException(e5);
            }
        } catch (ClassNotFoundException unused) {
            try {
                Iterator it = Arrays.asList(new fp1[0]).iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    try {
                        if (it.next() == null) {
                            throw null;
                        }
                        throw new ClassCastException();
                    } catch (ServiceConfigurationError e6) {
                        Logger.getLogger(zo1.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(bp1.class.getSimpleName()), (Throwable) e6);
                    }
                }
                if (arrayList.size() == 1) {
                    return (bp1) arrayList.get(0);
                }
                if (arrayList.size() == 0) {
                    return null;
                }
                try {
                    return (bp1) bp1.class.getMethod("combine", Collection.class).invoke(null, arrayList);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(e7);
                } catch (NoSuchMethodException e8) {
                    throw new IllegalStateException(e8);
                } catch (InvocationTargetException e9) {
                    throw new IllegalStateException(e9);
                }
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    public static void a() {
        yb0.y(R.string.pro_version_activation_pending, 1);
        az azVar = (az) zq0.b.a.edit();
        azVar.putString(xq0.proState.name(), yq0.pending.name());
        azVar.apply();
        CursorAccessibilityService.k(true);
    }

    public static void b(yq0 yq0Var, Activity activity, Runnable runnable) {
        yq0 yq0Var2 = yq0.lifetime;
        int i = 1;
        yb0.y(yq0Var == yq0Var2 ? R.string.pro_version_activated_lifetime : R.string.pro_version_activated_subscription, 1);
        zq0 zq0Var = zq0.b;
        dz dzVar = zq0Var.a;
        if (!zq0Var.c()) {
            pn0.t().Z();
            az azVar = (az) dzVar.edit();
            azVar.putString(xq0.proState.name(), yq0Var.name());
            azVar.commit();
        } else if (yq0Var == yq0Var2 && zq0Var.b() == yq0.subscription) {
            si0.b("Switch to 'lifetime' from 'subscription'.");
            az azVar2 = (az) dzVar.edit();
            azVar2.putString(xq0.proState.name(), yq0Var.name());
            azVar2.commit();
        }
        if (yq0Var == yq0.subscription) {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            si0.b("Subscription activation time: " + jCurrentTimeMillis);
            az azVar3 = (az) dzVar.edit();
            azVar3.putLong(xq0.subscriptionActivationTime.name(), jCurrentTimeMillis);
            azVar3.apply();
        }
        CursorAccessibilityService.k(true);
        i70 i70Var = ud.a;
        Map map = null;
        try {
            SharedPreferences sharedPreferences = (SharedPreferences) pn0.e.d;
            if (sharedPreferences.contains("expiredPreferencesBackup")) {
                map = (Map) ud.a.f(sharedPreferences.getString("expiredPreferencesBackup", null), ud.b);
            }
        } catch (Exception e2) {
            si0.b("getExpiredPreferencesBackup() couldn't decode, error: " + e2);
        }
        if (map == null) {
            si0.b("expiredPreferences null");
            runnable.run();
            return;
        }
        si0.b("expiredPreferences dialog shown");
        jl1 jl1Var = new jl1(activity);
        x6 x6Var = (x6) jl1Var.c;
        jl1Var.m(R.string.pro_restore_previous_settings_dialog_title);
        jl1Var.g(R.string.pro_restore_previous_settings_dialog_message);
        x6Var.c = R.drawable.icon_warning;
        jl1Var.k(R.string.pro_restore_previous_settings_dialog_restore_button, new pd(map, runnable));
        jl1Var.h(R.string.dialog_button_no, new sd(runnable, i));
        x6Var.o = new s80(i, runnable);
        jl1Var.n();
    }

    public static int c(int i, int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public static byte[] d(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i++) {
            byte b2 = (byte) ((bArr[i] << 1) & 254);
            bArr2[i] = b2;
            if (i < length - 1) {
                bArr2[i] = (byte) (b2 | ((byte) ((bArr[i + 1] >> 7) & 1)));
            }
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
        return bArr2;
    }

    public static boolean e(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = e(file2) && z;
        }
        return z;
    }

    public static nh1 f(vn vnVar, int i, ArrayList arrayList, nh1 nh1Var) {
        int i2;
        int i3 = i == 0 ? vnVar.n0 : vnVar.o0;
        if (i3 != -1 && (nh1Var == null || i3 != nh1Var.b)) {
            int i4 = 0;
            while (true) {
                if (i4 >= arrayList.size()) {
                    break;
                }
                nh1 nh1Var2 = (nh1) arrayList.get(i4);
                if (nh1Var2.b == i3) {
                    if (nh1Var != null) {
                        nh1Var.c(i, nh1Var2);
                        arrayList.remove(nh1Var);
                    }
                    nh1Var = nh1Var2;
                } else {
                    i4++;
                }
            }
        } else if (i3 != -1) {
            return nh1Var;
        }
        if (nh1Var == null) {
            if (vnVar instanceof b80) {
                b80 b80Var = (b80) vnVar;
                int i5 = 0;
                while (true) {
                    if (i5 >= b80Var.r0) {
                        i2 = -1;
                        break;
                    }
                    vn vnVar2 = b80Var.q0[i5];
                    if ((i == 0 && (i2 = vnVar2.n0) != -1) || (i == 1 && (i2 = vnVar2.o0) != -1)) {
                        break;
                    }
                    i5++;
                }
                if (i2 != -1) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= arrayList.size()) {
                            break;
                        }
                        nh1 nh1Var3 = (nh1) arrayList.get(i6);
                        if (nh1Var3.b == i2) {
                            nh1Var = nh1Var3;
                            break;
                        }
                        i6++;
                    }
                }
            }
            if (nh1Var == null) {
                nh1Var = new nh1();
                nh1Var.a = new ArrayList();
                nh1Var.d = null;
                nh1Var.e = -1;
                int i7 = nh1.f;
                nh1.f = i7 + 1;
                nh1Var.b = i7;
                nh1Var.c = i;
            }
            arrayList.add(nh1Var);
        }
        ArrayList arrayList2 = nh1Var.a;
        if (arrayList2.contains(vnVar)) {
            return nh1Var;
        }
        arrayList2.add(vnVar);
        if (vnVar instanceof n70) {
            n70 n70Var = (n70) vnVar;
            n70Var.t0.c(n70Var.u0 == 0 ? 1 : 0, nh1Var, arrayList);
        }
        int i8 = nh1Var.b;
        if (i == 0) {
            vnVar.n0 = i8;
            vnVar.I.c(i, nh1Var, arrayList);
            vnVar.K.c(i, nh1Var, arrayList);
        } else {
            vnVar.o0 = i8;
            vnVar.J.c(i, nh1Var, arrayList);
            vnVar.M.c(i, nh1Var, arrayList);
            vnVar.L.c(i, nh1Var, arrayList);
        }
        vnVar.P.c(i, nh1Var, arrayList);
        return nh1Var;
    }

    public static int g(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? i : i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String h(android.content.ContextWrapper r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            r9.getClass()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            if (r8 == 0) goto L31
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2e
            if (r9 == 0) goto L31
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2e
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2e
            r8.close()
            return r9
        L2a:
            r0 = move-exception
            r9 = r0
            r7 = r8
            goto L46
        L2e:
            r0 = move-exception
            r9 = r0
            goto L3d
        L31:
            if (r8 == 0) goto L45
            r8.close()
            return r7
        L37:
            r0 = move-exception
            r9 = r0
            goto L46
        L3a:
            r0 = move-exception
            r9 = r0
            r8 = r7
        L3d:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L2a
            if (r8 == 0) goto L45
            r8.close()
        L45:
            return r7
        L46:
            if (r7 == 0) goto L4b
            r7.close()
        L4b:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fp1.h(android.content.ContextWrapper, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static float i(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return hx.b(edgeEffect);
        }
        return 0.0f;
    }

    public static f9 j(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        f9 f9VarB;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i2 = typedValue.type;
            if (i2 >= 28 && i2 <= 31) {
                return new f9((Shader) null, (ColorStateList) null, typedValue.data);
            }
            try {
                f9VarB = f9.b(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            } catch (Exception e2) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
                f9VarB = null;
            }
            if (f9VarB != null) {
                return f9VarB;
            }
        }
        return new f9((Shader) null, (ColorStateList) null, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ba A[PHI: r9
  0x02ba: PHI (r9v1 android.net.Uri) = (r9v0 android.net.Uri), (r9v3 android.net.Uri) binds: [B:104:0x02b3, B:65:0x01c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0179  */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String k(android.content.ContextWrapper r14, android.net.Uri r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fp1.k(android.content.ContextWrapper, android.net.Uri):java.lang.String");
    }

    public static ArrayList l(MaterialToolbar materialToolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < materialToolbar.getChildCount(); i++) {
            View childAt = materialToolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static final void m(ep epVar, Throwable th) throws IllegalAccessException, InvocationTargetException {
        try {
            f7 f7Var = (f7) epVar.i(c70.f);
            if (f7Var != null) {
                f7Var.q(th);
            } else {
                lc1.R(epVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                f01.b(runtimeException, th);
                th = runtimeException;
            }
            lc1.R(epVar, th);
        }
    }

    public static void n(ir irVar) {
        o(irVar, Collections.EMPTY_LIST);
    }

    public static void o(ir irVar, List list) {
        boolean zC = zq0.b.c();
        PreferenceScreen preferenceScreen = irVar.Z.g;
        ArrayList arrayList = new ArrayList();
        xr.v(preferenceScreen, arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Preference preference = (Preference) obj;
            String str = preference.m;
            if (str == null) {
                str = "";
            }
            if (zC && str.equals("hide_on_pro")) {
                preference.F(false);
            } else if (!zC && !str.equals("ignore") && !str.equals("hide_on_pro") && !list.contains(str)) {
                preference.B(false);
            }
        }
    }

    public static boolean p(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static jo q(jo joVar) {
        joVar.getClass();
        o31 o31Var = joVar instanceof o31 ? (o31) joVar : null;
        if (o31Var == null || (joVar = o31Var.d) != null) {
            return joVar;
        }
        ep epVar = o31Var.c;
        epVar.getClass();
        hp hpVar = (hp) epVar.i(ow0.d);
        jo fuVar = hpVar != null ? new fu(hpVar, o31Var) : o31Var;
        o31Var.d = fuVar;
        return fuVar;
    }

    public static Paint r(Context context) {
        Paint paint = new Paint();
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.checker_background);
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        paint.setShader(new BitmapShader(bitmapDecodeResource, tileMode, tileMode));
        paint.setStrokeWidth(TypedValue.applyDimension(1, 1.5f, context.getResources().getDisplayMetrics()));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        return paint;
    }

    public static Paint s(Context context) {
        Paint paint = new Paint();
        paint.setColor(-8355712);
        paint.setStrokeWidth(TypedValue.applyDimension(1, 1.5f, context.getResources().getDisplayMetrics()));
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    public static void t(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static TypedArray u(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static float x(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return hx.c(edgeEffect, f, f2);
        }
        gx.a(edgeEffect, f, f2);
        return f;
    }

    public static vl0 y(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i = byteBufferDuplicate.getShort() & 65535;
        if (i > 100) {
            zy.p("Cannot read metadata.");
            return null;
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                j = -1;
                break;
            }
            int i3 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i3) {
                break;
            }
            i2++;
        }
        if (j != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j - ((long) byteBufferDuplicate.position()))));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j2 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            for (int i4 = 0; i4 < j2; i4++) {
                int i5 = byteBufferDuplicate.getInt();
                long j3 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i5 || 1701669481 == i5) {
                    byteBufferDuplicate.position((int) (j3 + j));
                    vl0 vl0Var = new vl0();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    vl0Var.d = byteBufferDuplicate;
                    vl0Var.a = iPosition;
                    int i6 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    vl0Var.b = i6;
                    vl0Var.c = ((ByteBuffer) vl0Var.d).getShort(i6);
                    return vl0Var;
                }
            }
        }
        zy.p("Cannot read metadata.");
        return null;
    }

    public static Parcelable z(Parcel parcel) {
        try {
            return parcel.readParcelable(Class.forName(parcel.readString()).getClassLoader());
        } catch (ClassNotFoundException e2) {
            Log.e("Changelog Library", "Error unparceling filter", e2);
            zy.m(e2);
            return null;
        }
    }

    public abstract void v(int i);

    public abstract void w(Typeface typeface, boolean z);
}
