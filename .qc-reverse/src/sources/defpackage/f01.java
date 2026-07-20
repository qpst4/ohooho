package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.drawable.IconCompat;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f01 {
    public static volatile d01 b;
    public static volatile ArrayList c;
    public static l7 h;
    public static g7 k;
    public static Vibrator l;
    public static final int[] d = new int[0];
    public static final Object[] e = new Object[0];
    public static final ow0 f = new ow0(16);
    public static final l7 g = new l7(null, null, null);
    public static final int[] i = {R.attr.colorPrimary};
    public static final int[] j = {R.attr.colorPrimaryVariant};

    public static ArrayList A(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.CREATE_SHORTCUT"), 0);
        ArrayList arrayList = new ArrayList();
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            arrayList.add(new to0(activityInfo.packageName, (String) activityInfo.loadLabel(packageManager), w(activityInfo.packageName), new Pair(activityInfo.packageName, activityInfo.name)));
        }
        return arrayList;
    }

    public static boolean C(String str) {
        try {
            App.c.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static TypedArray E(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        i(context, attributeSet, i2, i3);
        l(context, attributeSet, iArr, i2, i3, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
    }

    public static void H(int i2, int i3, int i4, int i5) {
        try {
            si0.b("oldWidth: " + i2 + ", oldHeight: " + i3 + ", newWidth: " + i4 + ", newHeight: " + i5);
            final vv0 vv0Var = new vv0(i2, i3, i4, i5);
            float f2 = vv0Var.c;
            if (i2 > 0 && i3 > 0 && i4 > 0 && i5 > 0) {
                if (vv0Var.d) {
                    si0.a("Scale only with: " + f2);
                } else {
                    si0.a("Complex scale with width: " + vv0Var.a + ", height: " + vv0Var.b + ", square: " + f2);
                }
                if (f2 != 1.0f) {
                    final SharedPreferences sharedPreferences = (SharedPreferences) pn0.e.d;
                    final SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    oq0.g1.forEach(new Consumer() { // from class: wv0
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            oq0 oq0Var = (oq0) obj;
                            String strName = oq0Var.name();
                            SharedPreferences sharedPreferences2 = sharedPreferences;
                            if (sharedPreferences2.contains(strName)) {
                                float fB = oq0.b(sharedPreferences2, oq0Var);
                                float f3 = vv0Var.c * fB;
                                editorEdit.putFloat(oq0Var.name(), f3);
                                si0.a("Change '" + oq0Var.name() + " from '" + fB + "' to '" + f3 + "'");
                            }
                        }
                    });
                    editorEdit.apply();
                }
                yb0.B("Resolution changed. Old: " + i2 + "x" + i3 + ", New: " + i4 + "x" + i5);
                ((SharedPreferences) pn0.t().d).edit().putInt(oq0.i0.name(), i4).putInt(oq0.j0.name(), i5).apply();
                CursorAccessibilityService.k(false);
                return;
            }
            si0.a("Something is not ok. Not doing any changes because input data is wrong.");
        } catch (Exception unused) {
            yb0.B("Something went wrong on resolution change");
        }
    }

    public static void I(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat(str)));
            intent.setFlags(270532608);
            App.c.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=".concat(str)));
            intent2.setFlags(270532608);
            App.c.startActivity(intent2);
        }
    }

    public static void J(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException unused) {
            yb0.z("2131952744 " + str, 0);
        }
    }

    public static void L(Context context, c01 c01Var) {
        IconCompat iconCompat;
        int i2;
        InputStream inputStreamF;
        Bitmap bitmapDecodeStream;
        IconCompat iconCompat2;
        context.getClass();
        int i3 = Build.VERSION.SDK_INT;
        int maxShortcutCountPerActivity = i3 >= 25 ? b01.c(context.getSystemService(b01.d())).getMaxShortcutCountPerActivity() : 5;
        if (maxShortcutCountPerActivity == 0) {
            return;
        }
        if (i3 <= 29 && (iconCompat = c01Var.h) != null && (((i2 = iconCompat.a) == 6 || i2 == 4) && (inputStreamF = iconCompat.f(context)) != null && (bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamF)) != null)) {
            if (i2 == 6) {
                iconCompat2 = new IconCompat(5);
                iconCompat2.b = bitmapDecodeStream;
            } else {
                iconCompat2 = new IconCompat(1);
                iconCompat2.b = bitmapDecodeStream;
            }
            c01Var.h = iconCompat2;
        }
        if (i3 >= 30) {
            b01.c(context.getSystemService(b01.d())).pushDynamicShortcut(c01Var.a());
        } else if (i3 >= 25) {
            ShortcutManager shortcutManagerC = b01.c(context.getSystemService(b01.d()));
            if (shortcutManagerC.isRateLimitingActive()) {
                return;
            }
            List dynamicShortcuts = shortcutManagerC.getDynamicShortcuts();
            if (dynamicShortcuts.size() >= maxShortcutCountPerActivity) {
                shortcutManagerC.removeDynamicShortcuts(Arrays.asList(e01.a(dynamicShortcuts)));
            }
            shortcutManagerC.addDynamicShortcuts(Arrays.asList(c01Var.a()));
        }
        try {
            z(context).getClass();
            ArrayList arrayList = new ArrayList();
            if (arrayList.size() >= maxShortcutCountPerActivity) {
                String[] strArr = new String[1];
                int size = arrayList.size();
                int i4 = -1;
                String str = null;
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    c01 c01Var2 = (c01) obj;
                    int i6 = c01Var2.l;
                    if (i6 > i4) {
                        str = c01Var2.b;
                        i4 = i6;
                    }
                }
                strArr[0] = str;
                Arrays.asList(strArr);
            }
            Arrays.asList(c01Var);
            Iterator it = ((ArrayList) y(context)).iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    s1.d();
                    return;
                } else {
                    Collections.singletonList(c01Var);
                    throw null;
                }
            }
        } catch (Exception unused) {
            Iterator it2 = ((ArrayList) y(context)).iterator();
            if (it2.hasNext()) {
                if (it2.next() != null) {
                    s1.d();
                    return;
                } else {
                    Collections.singletonList(c01Var);
                    throw null;
                }
            }
        } catch (Throwable th) {
            Iterator it3 = ((ArrayList) y(context)).iterator();
            if (!it3.hasNext()) {
                M(context, c01Var.b);
                throw th;
            }
            if (it3.next() != null) {
                s1.d();
                return;
            } else {
                Collections.singletonList(c01Var);
                throw null;
            }
        }
        M(context, c01Var.b);
    }

    public static void M(Context context, String str) {
        context.getClass();
        str.getClass();
        if (Build.VERSION.SDK_INT >= 25) {
            b01.c(context.getSystemService(b01.d())).reportShortcutUsed(str);
        }
        Iterator it = ((ArrayList) y(context)).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
            } else {
                Collections.singletonList(str);
                throw null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006c A[PHI: r15
  0x006c: PHI (r15v3 long) = (r15v2 long), (r15v4 long) binds: [B:30:0x005f, B:34:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long N(java.lang.String r21, long r22, long r24, long r26) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f01.N(java.lang.String, long, long, long):long");
    }

    public static int O(int i2, int i3, String str) {
        return (int) N(str, i2, 1L, (i3 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static String P(int i2, String str, String str2) {
        return lc1.K(i2).replace("{[" + str + "]}", str2);
    }

    public static final ad1 Q(jo joVar, ep epVar, Object obj) {
        ad1 ad1Var = null;
        if ((joVar instanceof op) && epVar.i(bd1.b) != null) {
            op opVarC = (op) joVar;
            while (true) {
                if ((opVarC instanceof gu) || (opVarC = opVarC.c()) == null) {
                    break;
                }
                if (opVarC instanceof ad1) {
                    ad1Var = (ad1) opVarC;
                    break;
                }
            }
            if (ad1Var != null) {
                ad1Var.Q(epVar, obj);
            }
        }
        return ad1Var;
    }

    public static void R(boolean z) {
        if (z) {
            AsyncTask.execute(new s4(29));
        }
    }

    public static final void S(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2) {
        if (i2 < 0 || byteBuffer2.remaining() < i2 || byteBuffer3.remaining() < i2 || byteBuffer.remaining() < i2) {
            zy.n("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static final byte[] T(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (i4 < 0 || bArr.length - i4 < i2 || bArr2.length - i4 < i3) {
            zy.n("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
            return null;
        }
        byte[] bArr3 = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr3[i5] = (byte) (bArr[i5 + i2] ^ bArr2[i5 + i3]);
        }
        return bArr3;
    }

    public static final byte[] U(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return T(bArr, 0, bArr2, 0, bArr.length);
        }
        zy.n("The lengths of x and y should match.");
        return null;
    }

    public static void V(int i2, int i3) {
        String strY0;
        if (i2 < 0 || i2 >= i3) {
            if (i2 < 0) {
                strY0 = lc1.y0("%s (%s) must not be negative", "index", Integer.valueOf(i2));
            } else {
                if (i3 < 0) {
                    zy.n(qq0.i("negative size: ", i3));
                    return;
                }
                strY0 = lc1.y0("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(strY0);
        }
    }

    public static void X(int i2, int i3) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(d0(i2, i3, "index"));
        }
    }

    public static void b(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        th.getClass();
        th2.getClass();
        if (th != th2) {
            Integer num = tc0.a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = rp0.a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static void b0(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i4) ? d0(i2, i4, "start index") : (i3 < 0 || i3 > i4) ? d0(i3, i4, "end index") : lc1.y0("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    public static Context d(Context context) {
        Locale locale;
        context.getClass();
        Resources resources = context.getResources();
        resources.getClass();
        Configuration configuration = resources.getConfiguration();
        configuration.getClass();
        int i2 = Build.VERSION.SDK_INT;
        boolean zEqualsIgnoreCase = false;
        if (i2 >= 26) {
            locale = configuration.getLocales().get(0);
            locale.getClass();
        } else {
            locale = configuration.locale;
            locale.getClass();
        }
        Locale localeG = ix.g(context);
        Locale localeH = ix.h(context);
        if (localeH != null) {
            localeG = localeH;
        } else {
            ix.k(context, localeG);
        }
        String string = locale.toString();
        String string2 = localeG.toString();
        if (string != null) {
            zEqualsIgnoreCase = string.equalsIgnoreCase(string2);
        } else if (string2 == null) {
            zEqualsIgnoreCase = true;
        }
        if (zEqualsIgnoreCase) {
            return context;
        }
        if (i2 < 26) {
            fi0 fi0Var = new fi0(context);
            Configuration configuration2 = fi0Var.getResources().getConfiguration();
            configuration2.setLocale(localeG);
            Context contextCreateConfigurationContext = fi0Var.createConfigurationContext(configuration2);
            contextCreateConfigurationContext.getClass();
            return contextCreateConfigurationContext;
        }
        fi0 fi0Var2 = new fi0(context);
        Configuration configuration3 = fi0Var2.getResources().getConfiguration();
        configuration3.setLocale(localeG);
        LocaleList localeList = new LocaleList(localeG);
        LocaleList.setDefault(localeList);
        configuration3.setLocales(localeList);
        Context contextCreateConfigurationContext2 = fi0Var2.createConfigurationContext(configuration3);
        contextCreateConfigurationContext2.getClass();
        return contextCreateConfigurationContext2;
    }

    public static String d0(int i2, int i3, String str) {
        if (i2 < 0) {
            return lc1.y0("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return lc1.y0("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        zy.n(qq0.i("negative size: ", i3));
        return null;
    }

    public static final int e(int i2, int i3, int[] iArr) {
        iArr.getClass();
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else {
                if (i7 <= i3) {
                    return i6;
                }
                i4 = i6 - 1;
            }
        }
        return ~i5;
    }

    public static final int f(long[] jArr, int i2, long j2) {
        jArr.getClass();
        int i3 = i2 - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            long j3 = jArr[i5];
            if (j3 < j2) {
                i4 = i5 + 1;
            } else {
                if (j3 <= j2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static void g(String str, boolean z) {
        if (z) {
            return;
        }
        zy.n(str);
    }

    public static void h(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void i(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.H, i2, i3);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                n(context, j, "Theme.MaterialComponents");
            }
        }
        n(context, i, "Theme.AppCompat");
    }

    public static void j() {
        int iC = oq0.c((SharedPreferences) pn0.t().d, oq0.i0);
        int iC2 = oq0.c((SharedPreferences) pn0.t().d, oq0.j0);
        if (iC <= 0 || iC2 <= 0) {
            return;
        }
        int i2 = ey0.d;
        int i3 = ey0.e;
        if (i2 == iC && i3 == iC2) {
            return;
        }
        H(iC, iC2, i2, i3);
    }

    public static void k(String str, Object obj) {
        if (obj != null) {
            return;
        }
        zy.r(str);
    }

    public static void l(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.H, i2, i3);
        boolean z = false;
        if (!typedArrayObtainStyledAttributes.getBoolean(2, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2.length != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
            for (int i4 : iArr2) {
                if (typedArrayObtainStyledAttributes2.getResourceId(i4, -1) == -1) {
                    typedArrayObtainStyledAttributes2.recycle();
                    break;
                }
            }
            typedArrayObtainStyledAttributes2.recycle();
            z = true;
        } else if (typedArrayObtainStyledAttributes.getResourceId(0, -1) != -1) {
            z = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            return;
        }
        zy.n("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    }

    public static void n(Context context, int[] iArr, String str) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i2)) {
                typedArrayObtainStyledAttributes.recycle();
                zy.n(l11.j("The style on this component requires your app theme to be ", str, " (or a descendant)."));
                return;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int o(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static final void q(Closeable closeable, Throwable th) throws IllegalAccessException, IOException, InvocationTargetException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                b(th, th2);
            }
        }
    }

    public static byte[] r(byte[]... bArr) throws GeneralSecurityException {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            if (length > Integer.MAX_VALUE - bArr2.length) {
                s1.l("exceeded size limit");
                return null;
            }
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    public static final boolean t(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 |= bArr[i3] ^ bArr2[i3];
        }
        return i2 == 0;
    }

    public static final ep u(ep epVar, ep epVar2, boolean z) {
        Boolean bool = Boolean.FALSE;
        xl xlVar = xl.g;
        boolean zBooleanValue = ((Boolean) epVar.g(bool, xlVar)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) epVar2.g(bool, xlVar)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return epVar.h(epVar2);
        }
        xl xlVar2 = new xl(2, 7);
        my myVar = my.b;
        ep epVar3 = (ep) epVar.g(myVar, xlVar2);
        Object objG = epVar2;
        if (zBooleanValue2) {
            objG = epVar2.g(myVar, xl.f);
        }
        return epVar3.h((ep) objG);
    }

    public static ArrayList v(Context context) {
        if (Build.VERSION.SDK_INT < 25) {
            try {
                z(context).getClass();
                return new ArrayList();
            } catch (Exception unused) {
                return new ArrayList();
            }
        }
        List dynamicShortcuts = b01.c(context.getSystemService(b01.d())).getDynamicShortcuts();
        ArrayList arrayList = new ArrayList(dynamicShortcuts.size());
        Iterator it = dynamicShortcuts.iterator();
        while (it.hasNext()) {
            c01 c01Var = (c01) new tb0(context, b01.b(it.next())).c;
            if (TextUtils.isEmpty(c01Var.e)) {
                zy.n("Shortcut must have a non-empty label");
                return null;
            }
            Intent[] intentArr = c01Var.c;
            if (intentArr == null || intentArr.length == 0) {
                zy.n("Shortcut must have an intent");
                return null;
            }
            arrayList.add(c01Var);
        }
        return arrayList;
    }

    public static Drawable w(String str) {
        g7 g7Var;
        try {
            if (k == null) {
                SharedPreferences sharedPreferences = (SharedPreferences) pn0.t().d;
                oq0 oq0Var = oq0.b1;
                String strD = oq0.d(sharedPreferences, oq0Var);
                if (strD != null && !strD.isEmpty()) {
                    k = new g7(oq0.d((SharedPreferences) pn0.t().d, oq0Var));
                }
            }
            g7Var = k;
        } catch (Exception unused) {
            return lc1.A(App.c, R.drawable.icon_action_no_icon);
        }
        if (g7Var != null) {
            try {
                Drawable drawableN = g7Var.n(str);
                if (drawableN != null) {
                    return drawableN.getConstantState().newDrawable().mutate();
                }
            } catch (Exception e2) {
                si0.b("Can't get icon pack icon. " + e2);
            }
            return lc1.A(App.c, R.drawable.icon_action_no_icon);
        }
        try {
            return App.c.getPackageManager().getApplicationIcon(str);
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Stream x(Context context, boolean z) {
        ApplicationInfo applicationInfo;
        try {
            final PackageManager packageManager = context.getPackageManager();
            Stream streamSorted = packageManager.getInstalledApplications(0).stream().filter(new f2(1, packageManager)).map(new Function() { // from class: uo0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    ApplicationInfo applicationInfo2 = (ApplicationInfo) obj;
                    try {
                        CharSequence charSequenceLoadLabel = applicationInfo2.loadLabel(packageManager);
                        String string = charSequenceLoadLabel != null ? charSequenceLoadLabel.toString() : applicationInfo2.packageName;
                        String str = applicationInfo2.packageName;
                        return new to0(str, string, f01.w(str), applicationInfo2.packageName);
                    } catch (Throwable th) {
                        si0.b("getInstalledPackages map loadLabel crash: " + th);
                        return null;
                    }
                }
            }).filter(new vo0()).sorted(new j20(1));
            if (z) {
                try {
                    PackageManager packageManager2 = context.getPackageManager();
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.HOME");
                    ActivityInfo activityInfo = packageManager2.resolveActivity(intent, 65536).activityInfo;
                    if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null) {
                        CharSequence charSequenceLoadLabel = applicationInfo.loadLabel(packageManager);
                        String string = charSequenceLoadLabel != null ? charSequenceLoadLabel.toString() : activityInfo.applicationInfo.packageName;
                        String str = activityInfo.applicationInfo.packageName;
                        return Stream.concat(Stream.of(new to0(str, string, w(str), activityInfo.applicationInfo.packageName)), streamSorted);
                    }
                } catch (Throwable th) {
                    si0.b("getInstalledPackages includeLauncher crash: " + th);
                }
            }
            return streamSorted;
        } catch (Exception e2) {
            yb0.y(R.string.general_error_contact, 0);
            si0.b("getInstalledPackages general exception: " + e2);
            return Stream.empty();
        }
    }

    public static List y(Context context) {
        Bundle bundle;
        String string;
        if (c == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("androidx.core.content.pm.SHORTCUT_LISTENER");
            intent.setPackage(context.getPackageName());
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 128).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.metaData) != null && (string = bundle.getString("androidx.core.content.pm.shortcut_listener_impl")) != null) {
                    try {
                        if (Class.forName(string, false, f01.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context) != null) {
                            throw new ClassCastException();
                        }
                        arrayList.add(null);
                    } catch (Exception unused) {
                        continue;
                    }
                }
            }
            if (c == null) {
                c = arrayList;
            }
        }
        return c;
    }

    public static d01 z(Context context) {
        if (b == null) {
            try {
                b = (d01) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, f01.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
            } catch (Exception unused) {
            }
            if (b == null) {
                b = new d01();
            }
        }
        return b;
    }

    public m0 B(Context context, Object obj) {
        return null;
    }

    public abstract long D();

    public abstract View F(int i2);

    public abstract boolean G();

    public abstract Object K(Intent intent, int i2);

    public abstract void W(xr1 xr1Var, xr1 xr1Var2);

    public abstract void Y(xr1 xr1Var, Thread thread);

    public abstract boolean Z(as1 as1Var, fq1 fq1Var, fq1 fq1Var2);

    public abstract boolean a0(as1 as1Var, Object obj, Object obj2);

    public abstract boolean c0(as1 as1Var, xr1 xr1Var, xr1 xr1Var2);

    public abstract Intent s(Context context, Object obj);
}
