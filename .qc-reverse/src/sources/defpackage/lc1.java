package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.activities.AccessibilityStoppedActivity;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lc1 {
    public static final or0 a = new or0("list-item-type");
    public static final or0 b = new or0("bullet-list-item-level");
    public static final or0 c = new or0("ordered-list-item-number");
    public static final or0 d = new or0("heading-level");
    public static final or0 e = new or0("link-destination");
    public static final or0 f = new or0("paragraph-is-in-tight-list");
    public static final or0 g = new or0("code-block-info");
    public static final int[] h = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    public static final int[] i = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    public static final int[] j = {67108863, 33554431};
    public static final int[] k = {26, 25};
    public static final boolean[] l = new boolean[3];
    public static final c1 m = new c1("NO_THREAD_ELEMENTS", 4);

    public static Drawable A(Context context, int i2) {
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        ThreadLocal threadLocal = ew0.a;
        return resources.getDrawable(i2, theme);
    }

    public static int A0(dq1 dq1Var, int i2, byte[] bArr, int i3, int i4, kp1 kp1Var, uo1 uo1Var) throws np1 {
        hp1 hp1VarD = dq1Var.d();
        dq1 dq1Var2 = dq1Var;
        byte[] bArr2 = bArr;
        int i5 = i4;
        uo1 uo1Var2 = uo1Var;
        int iI0 = I0(hp1VarD, dq1Var2, bArr2, i3, i5, uo1Var2);
        dq1Var2.a(hp1VarD);
        uo1Var2.c = hp1VarD;
        kp1Var.add(hp1VarD);
        while (iI0 < i5) {
            uo1 uo1Var3 = uo1Var2;
            int i6 = i5;
            int iD0 = D0(bArr2, iI0, uo1Var3);
            if (i2 != uo1Var3.a) {
                break;
            }
            byte[] bArr3 = bArr2;
            dq1 dq1Var3 = dq1Var2;
            hp1 hp1VarD2 = dq1Var3.d();
            iI0 = I0(hp1VarD2, dq1Var3, bArr3, iD0, i6, uo1Var3);
            dq1Var2 = dq1Var3;
            bArr2 = bArr3;
            i5 = i6;
            uo1Var2 = uo1Var3;
            dq1Var2.a(hp1VarD2);
            uo1Var2.c = hp1VarD2;
            kp1Var.add(hp1VarD2);
        }
        return iI0;
    }

    public static int B0(byte[] bArr, int i2, kp1 kp1Var, uo1 uo1Var) throws np1 {
        ip1 ip1Var = (ip1) kp1Var;
        int iD0 = D0(bArr, i2, uo1Var);
        int i3 = uo1Var.a + iD0;
        while (iD0 < i3) {
            iD0 = D0(bArr, iD0, uo1Var);
            ip1Var.d(uo1Var.a);
        }
        if (iD0 == i3) {
            return iD0;
        }
        ay0.b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return 0;
    }

    public static int C0(int i2, byte[] bArr, int i3, int i4, jq1 jq1Var, uo1 uo1Var) throws np1 {
        if ((i2 >>> 3) == 0) {
            ay0.b("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int iG0 = G0(bArr, i3, uo1Var);
            jq1Var.c(i2, Long.valueOf(uo1Var.b));
            return iG0;
        }
        if (i5 == 1) {
            jq1Var.c(i2, Long.valueOf(J0(i3, bArr)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int iD0 = D0(bArr, i3, uo1Var);
            int i6 = uo1Var.a;
            if (i6 < 0) {
                ay0.b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                return 0;
            }
            if (i6 > bArr.length - iD0) {
                ay0.b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                return 0;
            }
            if (i6 == 0) {
                jq1Var.c(i2, yo1.d);
            } else {
                jq1Var.c(i2, yo1.f(bArr, iD0, i6));
            }
            return iD0 + i6;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                jq1Var.c(i2, Integer.valueOf(z0(i3, bArr)));
                return i3 + 4;
            }
            ay0.b("Protocol message contained an invalid tag (zero).");
            return 0;
        }
        int i7 = (i2 & (-8)) | 4;
        jq1 jq1VarB = jq1.b();
        int i8 = uo1Var.d + 1;
        uo1Var.d = i8;
        if (i8 >= 100) {
            ay0.b("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int i9 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int iD02 = D0(bArr, i3, uo1Var);
            int i10 = uo1Var.a;
            if (i10 == i7) {
                i9 = i10;
                i3 = iD02;
                break;
            }
            i3 = C0(i10, bArr, iD02, i4, jq1VarB, uo1Var);
            i9 = i10;
        }
        uo1Var.d--;
        if (i3 > i4 || i9 != i7) {
            ay0.b("Failed to parse the message.");
            return 0;
        }
        jq1Var.c(i2, jq1VarB);
        return i3;
    }

    public static int D(int i2) {
        return App.c.getResources().getInteger(i2);
    }

    public static int D0(byte[] bArr, int i2, uo1 uo1Var) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return E0(b2, bArr, i3, uo1Var);
        }
        uo1Var.a = b2;
        return i3;
    }

    public static int E0(int i2, byte[] bArr, int i3, uo1 uo1Var) {
        byte b2 = bArr[i3];
        int i4 = i3 + 1;
        int i5 = i2 & 127;
        if (b2 >= 0) {
            uo1Var.a = i5 | (b2 << 7);
            return i4;
        }
        int i6 = i5 | ((b2 & 127) << 7);
        int i7 = i3 + 2;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            uo1Var.a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & 127) << 14);
        int i9 = i3 + 3;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            uo1Var.a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & 127) << 21);
        int i11 = i3 + 4;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            uo1Var.a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & 127) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                uo1Var.a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int F0(int i2, byte[] bArr, int i3, int i4, kp1 kp1Var, uo1 uo1Var) {
        ip1 ip1Var = (ip1) kp1Var;
        int iD0 = D0(bArr, i3, uo1Var);
        ip1Var.d(uo1Var.a);
        while (iD0 < i4) {
            int iD02 = D0(bArr, iD0, uo1Var);
            if (i2 != uo1Var.a) {
                break;
            }
            iD0 = D0(bArr, iD02, uo1Var);
            ip1Var.d(uo1Var.a);
        }
        return iD0;
    }

    public static lc1 G(int i2, int i3) {
        Type type = uv0.MAP_HASH_TYPE;
        return i2 < i3 ? if0.p : if0.o;
    }

    public static int G0(byte[] bArr, int i2, uo1 uo1Var) {
        long j2 = bArr[i2];
        int i3 = i2 + 1;
        if (j2 >= 0) {
            uo1Var.b = j2;
            return i3;
        }
        int i4 = i2 + 2;
        byte b2 = bArr[i3];
        long j3 = (j2 & 127) | (((long) (b2 & 127)) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            i5 += 7;
            j3 |= ((long) (b3 & 127)) << i5;
            b2 = b3;
            i4 = i6;
        }
        uo1Var.b = j3;
        return i4;
    }

    public static int H0(Object obj, dq1 dq1Var, byte[] bArr, int i2, int i3, int i4, uo1 uo1Var) throws np1 {
        xp1 xp1Var = (xp1) dq1Var;
        int i5 = uo1Var.d + 1;
        uo1Var.d = i5;
        if (i5 >= 100) {
            ay0.b("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int iT = xp1Var.t(obj, bArr, i2, i3, i4, uo1Var);
        uo1Var.d--;
        uo1Var.c = obj;
        return iT;
    }

    public static int I0(Object obj, dq1 dq1Var, byte[] bArr, int i2, int i3, uo1 uo1Var) throws np1 {
        int iE0 = i2 + 1;
        int i4 = bArr[i2];
        if (i4 < 0) {
            iE0 = E0(i4, bArr, iE0, uo1Var);
            i4 = uo1Var.a;
        }
        int i5 = iE0;
        if (i4 < 0 || i4 > i3 - i5) {
            ay0.b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        int i6 = uo1Var.d + 1;
        uo1Var.d = i6;
        if (i6 >= 100) {
            ay0.b("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            return 0;
        }
        int i7 = i5 + i4;
        dq1Var.f(obj, bArr, i5, i7, uo1Var);
        uo1Var.d--;
        uo1Var.c = obj;
        return i7;
    }

    public static long J0(int i2, byte[] bArr) {
        return (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48) | ((((long) bArr[i2 + 7]) & 255) << 56);
    }

    public static String K(int i2) {
        return App.c.getResources().getString(i2);
    }

    public static String L(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return "TRuntime.".concat(str);
        }
        String strConcat = "TRuntime.".concat(str);
        return strConcat.length() > 23 ? strConcat.substring(0, 23) : strConcat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac A[Catch: all -> 0x0071, TryCatch #0 {all -> 0x0071, blocks: (B:11:0x0058, B:29:0x0085, B:31:0x00ac, B:35:0x00c7, B:32:0x00b9, B:34:0x00c4), top: B:56:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9 A[Catch: all -> 0x0071, TryCatch #0 {all -> 0x0071, blocks: (B:11:0x0058, B:29:0x0085, B:31:0x00ac, B:35:0x00c7, B:32:0x00b9, B:34:0x00c4), top: B:56:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3 A[Catch: Exception -> 0x006e, TRY_ENTER, TryCatch #1 {Exception -> 0x006e, blocks: (B:6:0x0027, B:12:0x0067, B:42:0x00ee, B:44:0x00f3, B:45:0x00f6, B:37:0x00e3, B:39:0x00e8), top: B:57:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8 A[Catch: Exception -> 0x006e, TryCatch #1 {Exception -> 0x006e, blocks: (B:6:0x0027, B:12:0x0067, B:42:0x00ee, B:44:0x00f3, B:45:0x00f6, B:37:0x00e3, B:39:0x00e8), top: B:57:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ee A[Catch: Exception -> 0x006e, TryCatch #1 {Exception -> 0x006e, blocks: (B:6:0x0027, B:12:0x0067, B:42:0x00ee, B:44:0x00f3, B:45:0x00f6, B:37:0x00e3, B:39:0x00e8), top: B:57:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f3 A[Catch: Exception -> 0x006e, TryCatch #1 {Exception -> 0x006e, blocks: (B:6:0x0027, B:12:0x0067, B:42:0x00ee, B:44:0x00f3, B:45:0x00f6, B:37:0x00e3, B:39:0x00e8), top: B:57:0x0027 }] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.net.Uri O(android.content.Context r7, java.io.File r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lc1.O(android.content.Context, java.io.File):android.net.Uri");
    }

    public static final void R(ep epVar, Throwable th) throws IllegalAccessException, InvocationTargetException {
        Throwable runtimeException;
        Iterator it = ip.a.iterator();
        while (it.hasNext()) {
            try {
                ((f7) it.next()).q(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    f01.b(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            f01.b(th, new st(epVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static List V(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        listSingletonList.getClass();
        return listSingletonList;
    }

    public static void W(long[] jArr, long[] jArr2, long[] jArr3) {
        long j2 = jArr2[0];
        long j3 = jArr3[0];
        long j4 = j2 * j3;
        long j5 = jArr3[1];
        long j6 = jArr2[1];
        long j7 = (j6 * j3) + (j2 * j5);
        long j8 = jArr3[2];
        long j9 = jArr2[2];
        long j10 = (j9 * j3) + (j2 * j8) + (j6 * 2 * j5);
        long j11 = jArr3[3];
        long j12 = jArr2[3];
        long j13 = (j12 * j3) + (j2 * j11) + (j9 * j5) + (j6 * j8);
        long j14 = jArr3[4];
        long j15 = jArr2[4];
        long j16 = (j15 * j3) + (j2 * j14) + (((j12 * j5) + (j6 * j11)) * 2) + (j9 * j8);
        long j17 = jArr3[5];
        long j18 = jArr2[5];
        long j19 = (j18 * j3) + (j2 * j17) + (j15 * j5) + (j6 * j14) + (j12 * j8) + (j9 * j11);
        long j20 = jArr3[6];
        long j21 = (j2 * j20) + (j15 * j8) + (j9 * j14) + (((j18 * j5) + (j6 * j17) + (j12 * j11)) * 2);
        long j22 = jArr2[6];
        long j23 = (j22 * j3) + j21;
        long j24 = jArr3[7];
        long j25 = jArr2[7];
        long j26 = (j25 * j3) + (j2 * j24) + (j22 * j5) + (j6 * j20) + (j18 * j8) + (j9 * j17) + (j15 * j11) + (j12 * j14);
        long j27 = jArr3[8];
        long j28 = jArr2[8];
        long j29 = (j28 * j3) + (j2 * j27) + (j22 * j8) + (j9 * j20) + (((j25 * j5) + (j6 * j24) + (j18 * j11) + (j12 * j17)) * 2) + (j15 * j14);
        long j30 = jArr3[9];
        long j31 = jArr2[9];
        long j32 = (j3 * j31) + (j2 * j30) + (j28 * j5) + (j6 * j27) + (j25 * j8) + (j9 * j24) + (j22 * j11) + (j12 * j20) + (j18 * j14) + (j15 * j17);
        long j33 = j5 * j31;
        long j34 = (j28 * j8) + (j9 * j27) + (j22 * j14) + (j15 * j20) + ((j33 + (j6 * j30) + (j25 * j11) + (j12 * j24) + (j18 * j17)) * 2);
        long j35 = j8 * j31;
        long j36 = j35 + (j9 * j30) + (j28 * j11) + (j12 * j27) + (j25 * j14) + (j15 * j24) + (j22 * j17) + (j18 * j20);
        long j37 = j11 * j31;
        long j38 = j28 * j14;
        long j39 = j14 * j31;
        long j40 = j28 * j20;
        long j41 = j20 * j31;
        long[] jArr4 = {j4, j7, j10, j13, j16, j19, j23, j26, j29, j32, j34, j36, j38 + (j15 * j27) + ((j37 + (j12 * j30) + (j25 * j17) + (j18 * j24)) * 2) + (j22 * j20), j39 + (j15 * j30) + (j28 * j17) + (j18 * j27) + (j25 * j20) + (j22 * j24), j40 + (j22 * j27) + (((j17 * j31) + (j18 * j30) + (j25 * j24)) * 2), j41 + (j22 * j30) + (j28 * j24) + (j25 * j27), (((j24 * j31) + (j25 * j30)) * 2) + (j28 * j27), (j27 * j31) + (j28 * j30), j31 * 2 * j30};
        e0(jArr4);
        d0(jArr4);
        System.arraycopy(jArr4, 0, jArr, 0, 10);
    }

    public static void a(Object obj) {
        if (obj != null) {
            if (obj instanceof h50) {
                if ((obj instanceof i50 ? ((i50) obj).b() : obj instanceof k40 ? 0 : obj instanceof v40 ? 1 : obj instanceof z40 ? 2 : -1) == 2) {
                    return;
                }
            }
            r0("kotlin.jvm.functions.Function2", obj);
            throw null;
        }
    }

    public static void b0(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString(":settings:fragment_args_key", "com.quickcursor/com.quickcursor.android.services.CursorAccessibilityService");
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        intent.addFlags(276856832);
        intent.putExtra(":settings:show_fragment_args", bundle);
        try {
            try {
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            Intent intent2 = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }

    public static final void c0(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                c0(sb, i2, str, it.next());
            }
            return;
        }
        sb.append('\n');
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            zh zhVar = zh.d;
            sb.append(i1.r(new zh(((String) obj).getBytes(ec0.a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zh) {
            sb.append(": \"");
            sb.append(i1.r((zh) obj));
            sb.append('\"');
        } else {
            if (!(obj instanceof w50)) {
                sb.append(": ");
                sb.append(obj.toString());
                return;
            }
            sb.append(" {");
            f0((w50) obj, sb, i2 + 2);
            sb.append("\n");
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append("}");
        }
    }

    public static final String d(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    public static void d0(long[] jArr) {
        jArr[10] = 0;
        int i2 = 0;
        while (i2 < 10) {
            long j2 = jArr[i2];
            long j3 = j2 / 67108864;
            jArr[i2] = j2 - (j3 << 26);
            int i3 = i2 + 1;
            long j4 = jArr[i3] + j3;
            jArr[i3] = j4;
            long j5 = j4 / 33554432;
            jArr[i3] = j4 - (j5 << 25);
            i2 += 2;
            jArr[i2] = jArr[i2] + j5;
        }
        long j6 = jArr[0];
        long j7 = jArr[10];
        long j8 = j6 + (j7 << 4);
        jArr[0] = j8;
        long j9 = j8 + (j7 << 1);
        jArr[0] = j9;
        long j10 = j9 + j7;
        jArr[0] = j10;
        jArr[10] = 0;
        long j11 = j10 / 67108864;
        jArr[0] = j10 - (j11 << 26);
        jArr[1] = jArr[1] + j11;
    }

    public static boolean e(z7 z7Var) {
        if (!CursorAccessibilityService.f()) {
            z7Var.startActivity(new Intent(z7Var, (Class<?>) AccessibilityStoppedActivity.class));
            z7Var.finish();
            return false;
        }
        if (oq0.a((SharedPreferences) pn0.t().d, oq0.j)) {
            return true;
        }
        Intent intent = new Intent(z7Var, (Class<?>) AccessibilityStoppedActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("skipToFirstUse", true);
        intent.putExtras(bundle);
        z7Var.startActivity(intent);
        z7Var.finish();
        return false;
    }

    public static void e0(long[] jArr) {
        long j2 = jArr[8];
        long j3 = jArr[18];
        long j4 = j2 + (j3 << 4);
        jArr[8] = j4;
        long j5 = j4 + (j3 << 1);
        jArr[8] = j5;
        jArr[8] = j5 + j3;
        long j6 = jArr[7];
        long j7 = jArr[17];
        long j8 = j6 + (j7 << 4);
        jArr[7] = j8;
        long j9 = j8 + (j7 << 1);
        jArr[7] = j9;
        jArr[7] = j9 + j7;
        long j10 = jArr[6];
        long j11 = jArr[16];
        long j12 = j10 + (j11 << 4);
        jArr[6] = j12;
        long j13 = j12 + (j11 << 1);
        jArr[6] = j13;
        jArr[6] = j13 + j11;
        long j14 = jArr[5];
        long j15 = jArr[15];
        long j16 = j14 + (j15 << 4);
        jArr[5] = j16;
        long j17 = j16 + (j15 << 1);
        jArr[5] = j17;
        jArr[5] = j17 + j15;
        long j18 = jArr[4];
        long j19 = jArr[14];
        long j20 = j18 + (j19 << 4);
        jArr[4] = j20;
        long j21 = j20 + (j19 << 1);
        jArr[4] = j21;
        jArr[4] = j21 + j19;
        long j22 = jArr[3];
        long j23 = jArr[13];
        long j24 = j22 + (j23 << 4);
        jArr[3] = j24;
        long j25 = j24 + (j23 << 1);
        jArr[3] = j25;
        jArr[3] = j25 + j23;
        long j26 = jArr[2];
        long j27 = jArr[12];
        long j28 = j26 + (j27 << 4);
        jArr[2] = j28;
        long j29 = j28 + (j27 << 1);
        jArr[2] = j29;
        jArr[2] = j29 + j27;
        long j30 = jArr[1];
        long j31 = jArr[11];
        long j32 = j30 + (j31 << 4);
        jArr[1] = j32;
        long j33 = j32 + (j31 << 1);
        jArr[1] = j33;
        jArr[1] = j33 + j31;
        long j34 = jArr[0];
        long j35 = jArr[10];
        long j36 = j34 + (j35 << 4);
        jArr[0] = j36;
        long j37 = j36 + (j35 << 1);
        jArr[0] = j37;
        jArr[0] = j37 + j35;
    }

    public static void f(wn wnVar, rg0 rg0Var, vn vnVar) {
        vnVar.o = -1;
        gn gnVar = vnVar.M;
        int[] iArr = vnVar.p0;
        gn gnVar2 = vnVar.L;
        gn gnVar3 = vnVar.J;
        gn gnVar4 = vnVar.K;
        gn gnVar5 = vnVar.I;
        vnVar.p = -1;
        int[] iArr2 = wnVar.p0;
        if (iArr2[0] != 2 && iArr[0] == 4) {
            int i2 = gnVar5.g;
            int iQ = wnVar.q() - gnVar4.g;
            gnVar5.i = rg0Var.k(gnVar5);
            gnVar4.i = rg0Var.k(gnVar4);
            rg0Var.d(gnVar5.i, i2);
            rg0Var.d(gnVar4.i, iQ);
            vnVar.o = 2;
            vnVar.Y = i2;
            int i3 = iQ - i2;
            vnVar.U = i3;
            int i4 = vnVar.b0;
            if (i3 < i4) {
                vnVar.U = i4;
            }
        }
        if (iArr2[1] == 2 || iArr[1] != 4) {
            return;
        }
        int i5 = gnVar3.g;
        int iK = wnVar.k() - gnVar2.g;
        gnVar3.i = rg0Var.k(gnVar3);
        gnVar2.i = rg0Var.k(gnVar2);
        rg0Var.d(gnVar3.i, i5);
        rg0Var.d(gnVar2.i, iK);
        if (vnVar.a0 > 0 || vnVar.g0 == 8) {
            m11 m11VarK = rg0Var.k(gnVar);
            gnVar.i = m11VarK;
            rg0Var.d(m11VarK, vnVar.a0 + i5);
        }
        vnVar.p = 2;
        vnVar.Z = i5;
        int i6 = iK - i5;
        vnVar.V = i6;
        int i7 = vnVar.c0;
        if (i6 < i7) {
            vnVar.V = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f0(defpackage.w50 r12, java.lang.StringBuilder r13, int r14) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lc1.f0(w50, java.lang.StringBuilder, int):void");
    }

    public static final void g0(ep epVar, Object obj) {
        if (obj == m) {
            return;
        }
        if (!(obj instanceof q51)) {
            epVar.g(null, xl.i).getClass();
            s1.d();
            return;
        }
        wo[] woVarArr = ((q51) obj).b;
        int length = woVarArr.length - 1;
        if (length < 0) {
            return;
        }
        wo woVar = woVarArr[length];
        throw null;
    }

    public static void h0(z7 z7Var) {
        z7Var.setTitle(z7Var.getString(zq0.b.c() ? R.string.app_name_pro : R.string.app_name));
    }

    public static void i(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void i0(ArrayList arrayList, float f2) {
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((hp0) obj).d(f2);
        }
    }

    public static byte[] j(long[] jArr) {
        int[] iArr;
        int i2;
        int[] iArr2;
        long[] jArrCopyOf = Arrays.copyOf(jArr, 10);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            iArr = k;
            if (i4 >= 2) {
                break;
            }
            int i5 = 0;
            while (i5 < 9) {
                long j2 = jArrCopyOf[i5];
                int i6 = iArr[i5 & 1];
                int i7 = -((int) (((j2 >> 31) & j2) >> i6));
                jArrCopyOf[i5] = j2 + ((long) (i7 << i6));
                i5++;
                jArrCopyOf[i5] = jArrCopyOf[i5] - ((long) i7);
            }
            long j3 = jArrCopyOf[9];
            int i8 = -((int) (((j3 >> 31) & j3) >> 25));
            jArrCopyOf[9] = j3 + ((long) (i8 << 25));
            jArrCopyOf[0] = jArrCopyOf[0] - ((long) (i8 * 19));
            i4++;
        }
        long j4 = jArrCopyOf[0];
        int i9 = -((int) (((j4 >> 31) & j4) >> 26));
        jArrCopyOf[0] = j4 + ((long) (i9 << 26));
        jArrCopyOf[1] = jArrCopyOf[1] - ((long) i9);
        int i10 = 0;
        while (true) {
            iArr2 = j;
            if (i10 >= 2) {
                break;
            }
            int i11 = i3;
            while (i11 < 9) {
                long j5 = jArrCopyOf[i11];
                int i12 = i11 & 1;
                int i13 = i3;
                int i14 = (int) (j5 >> iArr[i12]);
                jArrCopyOf[i11] = j5 & ((long) iArr2[i12]);
                i11++;
                jArrCopyOf[i11] = jArrCopyOf[i11] + ((long) i14);
                i3 = i13;
                i10 = i10;
            }
            i10++;
        }
        int i15 = i3;
        long j6 = jArrCopyOf[9];
        jArrCopyOf[9] = j6 & 33554431;
        long j7 = jArrCopyOf[i15] + ((long) (((int) (j6 >> 25)) * 19));
        jArrCopyOf[i15] = j7;
        int i16 = ~((((int) j7) - 67108845) >> 31);
        for (int i17 = 1; i17 < 10; i17++) {
            int i18 = ~(((int) jArrCopyOf[i17]) ^ iArr2[i17 & 1]);
            int i19 = i18 & (i18 << 16);
            int i20 = i19 & (i19 << 8);
            int i21 = i20 & (i20 << 4);
            int i22 = i21 & (i21 << 2);
            i16 &= (i22 & (i22 << 1)) >> 31;
        }
        jArrCopyOf[i15] = jArrCopyOf[i15] - ((long) (67108845 & i16));
        long j8 = 33554431 & i16;
        jArrCopyOf[1] = jArrCopyOf[1] - j8;
        for (i2 = 2; i2 < 10; i2 += 2) {
            jArrCopyOf[i2] = jArrCopyOf[i2] - ((long) (67108863 & i16));
            int i23 = i2 + 1;
            jArrCopyOf[i23] = jArrCopyOf[i23] - j8;
        }
        for (int i24 = i15; i24 < 10; i24++) {
            jArrCopyOf[i24] = jArrCopyOf[i24] << i[i24];
        }
        byte[] bArr = new byte[32];
        for (int i25 = i15; i25 < 10; i25++) {
            int i26 = h[i25];
            long j9 = bArr[i26];
            long j10 = jArrCopyOf[i25];
            bArr[i26] = (byte) (j9 | (j10 & 255));
            bArr[i26 + 1] = (byte) (((long) bArr[r5]) | ((j10 >> 8) & 255));
            bArr[i26 + 2] = (byte) (((long) bArr[r5]) | ((j10 >> 16) & 255));
            bArr[i26 + 3] = (byte) (((long) bArr[r4]) | ((j10 >> 24) & 255));
        }
        return bArr;
    }

    public static void j0(Outline outline, Path path) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            uu.a(outline, path);
            return;
        }
        if (i2 >= 29) {
            try {
                tu.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            tu.a(outline, path);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] k(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            jArr[i2] = iArr[i2];
        }
        return jArr;
    }

    public static void l(zz zzVar, a00 a00Var, int i2) throws IOException {
        byte[] bArr = new byte[8192];
        while (i2 > 0) {
            int iMin = Math.min(i2, 8192);
            int i3 = zzVar.read(bArr, 0, iMin);
            if (i3 != iMin) {
                zy.p("Failed to copy the given amount of bytes from the inputstream to the output stream.");
                return;
            } else {
                i2 -= i3;
                a00Var.write(bArr, 0, i3);
            }
        }
    }

    public static void l0(long[] jArr, long[] jArr2) {
        long j2 = jArr2[0];
        long j3 = j2 * 2;
        long j4 = jArr2[1];
        long j5 = jArr2[2];
        long j6 = jArr2[3];
        long j7 = jArr2[4];
        long j8 = jArr2[5];
        long j9 = jArr2[6];
        long j10 = jArr2[7];
        long j11 = jArr2[8];
        long j12 = jArr2[9];
        long[] jArr3 = {j2 * j2, j3 * j4, ((j2 * j5) + (j4 * j4)) * 2, ((j2 * j6) + (j4 * j5)) * 2, (j3 * j7) + (j4 * 4 * j6) + (j5 * j5), ((j2 * j8) + (j4 * j7) + (j5 * j6)) * 2, ((j4 * 2 * j8) + (j2 * j9) + (j5 * j7) + (j6 * j6)) * 2, ((j2 * j10) + (j4 * j9) + (j5 * j8) + (j6 * j7)) * 2, (((((j6 * j8) + (j4 * j10)) * 2) + (j2 * j11) + (j5 * j9)) * 2) + (j7 * j7), ((j2 * j12) + (j4 * j11) + (j5 * j10) + (j6 * j9) + (j7 * j8)) * 2, ((((j4 * j12) + (j6 * j10)) * 2) + (j5 * j11) + (j7 * j9) + (j8 * j8)) * 2, ((j5 * j12) + (j6 * j11) + (j7 * j10) + (j8 * j9)) * 2, (((((j6 * j12) + (j8 * j10)) * 2) + (j7 * j11)) * 2) + (j9 * j9), ((j7 * j12) + (j8 * j11) + (j9 * j10)) * 2, ((j8 * 2 * j12) + (j9 * j11) + (j10 * j10)) * 2, ((j9 * j12) + (j10 * j11)) * 2, (j10 * 4 * j12) + (j11 * j11), j11 * 2 * j12, 2 * j12 * j12};
        e0(jArr3);
        d0(jArr3);
        System.arraycopy(jArr3, 0, jArr, 0, 10);
    }

    public static void m(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i2);
            }
        }
    }

    public static void m0(Context context) {
        context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + App.c.getPackageName())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void n0(z40 z40Var, l lVar, l lVar2) {
        try {
            xr.H(fp1.q(((o31) z40Var).h(lVar2, lVar)), ow0.h);
        } catch (Throwable th) {
            lVar2.e(new jw0(th));
            throw th;
        }
    }

    public static void o0(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 10; i2++) {
            jArr[i2] = jArr2[i2] - jArr3[i2];
        }
    }

    public static void p(String str, String str2, Object obj) {
        String strL = L(str);
        if (Log.isLoggable(strL, 3)) {
            Log.d(strL, String.format(str2, obj));
        }
    }

    public static void p0(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 10; i2++) {
            jArr[i2] = jArr2[i2] + jArr3[i2];
        }
    }

    public static Bitmap q(File file, float f2, float f3) {
        int i2;
        int i3;
        int i4;
        Bitmap bitmapCreateBitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int i5 = options.outHeight;
        int i6 = options.outWidth;
        float f4 = i6;
        float f5 = i5;
        float f6 = f4 / f5;
        float f7 = f2 / f3;
        if (f5 <= f3 && f4 <= f2) {
            i2 = i5;
            i3 = i6;
        } else if (f6 < f7) {
            i3 = (int) ((f3 / f5) * f4);
            i2 = (int) f3;
        } else {
            if (f6 > f7) {
                f3 = (f2 / f4) * f5;
            }
            i2 = (int) f3;
            i3 = (int) f2;
        }
        if (i5 > i2 || i6 > i3) {
            int i7 = i5 / 2;
            int i8 = i6 / 2;
            i4 = 1;
            while (i7 / i4 >= i2 && i8 / i4 >= i3) {
                i4 *= 2;
            }
        } else {
            i4 = 1;
        }
        options.inSampleSize = i4;
        options.inJustDecodeBounds = false;
        if (bitmapDecodeFile != null) {
            int i9 = (options.outHeight / i4) * (options.outWidth / i4);
            Bitmap.Config config = bitmapDecodeFile.getConfig();
            config.getClass();
            int i10 = va0.a[config.ordinal()];
            if (i9 * (i10 != 1 ? (i10 == 2 || i10 == 3) ? 2 : 1 : 4) <= bitmapDecodeFile.getAllocationByteCount()) {
                options.inMutable = true;
                options.inBitmap = bitmapDecodeFile;
            }
        }
        options.inTempStorage = new byte[16384];
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            bitmapCreateBitmap = null;
        }
        Bitmap bitmap = bitmapCreateBitmap;
        float f8 = i3;
        float f9 = f8 / options.outWidth;
        float f10 = i2;
        float f11 = f10 / options.outHeight;
        float f12 = f8 / 2.0f;
        float f13 = f10 / 2.0f;
        Matrix matrix = new Matrix();
        matrix.setScale(f9, f11, f12, f13);
        bitmap.getClass();
        Canvas canvas = new Canvas(bitmap);
        canvas.setMatrix(matrix);
        bitmapDecodeFile.getClass();
        canvas.drawBitmap(bitmapDecodeFile, f12 - (bitmapDecodeFile.getWidth() / 2), f13 - (bitmapDecodeFile.getHeight() / 2), new Paint(2));
        bitmapDecodeFile.recycle();
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), new Matrix(), true);
    }

    public static final Object q0(ep epVar) {
        Object objG = epVar.g(0, xl.h);
        objG.getClass();
        return objG;
    }

    public static void r(String str, String str2, Exception exc) {
        String strL = L(str);
        if (Log.isLoggable(strL, 6)) {
            Log.e(strL, str2, exc);
        }
    }

    public static void r0(String str, Object obj) {
        ClassCastException classCastException = new ClassCastException((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
        fc0.L(classCastException, lc1.class.getName());
        throw classCastException;
    }

    public static final boolean s(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    public static long[] t(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i2 = 0; i2 < 10; i2++) {
            int i3 = h[i2];
            jArr[i2] = ((((((long) (bArr[i3] & 255)) | (((long) (bArr[i3 + 1] & 255)) << 8)) | (((long) (bArr[i3 + 2] & 255)) << 16)) | (((long) (bArr[i3 + 3] & 255)) << 24)) >> i[i2]) & ((long) j[i2 & 1]);
        }
        return jArr;
    }

    public static LinkedList u(View view) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(view);
        while (!linkedList2.isEmpty()) {
            KeyEvent.Callback callback = (View) linkedList2.remove();
            if (callback instanceof hp0) {
                linkedList.add((hp0) callback);
            } else if (callback instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) callback;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    linkedList2.add(viewGroup.getChildAt(childCount));
                }
            }
        }
        return linkedList;
    }

    public static Bitmap v(int i2) {
        Drawable drawableA = A(App.c, i2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableA.getIntrinsicWidth(), drawableA.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableA.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableA.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static final Object v0(ep epVar, Object obj) {
        if (obj == null) {
            obj = q0(epVar);
        }
        if (obj == 0) {
            return m;
        }
        if (obj instanceof Integer) {
            return epVar.g(new q51(epVar, ((Number) obj).intValue()), xl.j);
        }
        s1.d();
        return null;
    }

    public static boolean w(int i2) {
        return App.c.getResources().getBoolean(i2);
    }

    public static Class w0(Class cls) {
        return cls == Integer.TYPE ? Integer.class : cls == Float.TYPE ? Float.class : cls == Byte.TYPE ? Byte.class : cls == Double.TYPE ? Double.class : cls == Long.TYPE ? Long.class : cls == Character.TYPE ? Character.class : cls == Boolean.TYPE ? Boolean.class : cls == Short.TYPE ? Short.class : cls == Void.TYPE ? Void.class : cls;
    }

    public static ColorStateList x(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !d0.t(drawable)) {
            return null;
        }
        return d0.e(drawable).getColorStateList();
    }

    public static int x0(byte[] bArr, int i2, uo1 uo1Var) throws np1 {
        int iD0 = D0(bArr, i2, uo1Var);
        int i3 = uo1Var.a;
        if (i3 < 0) {
            ay0.b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            return 0;
        }
        if (i3 > bArr.length - iD0) {
            ay0.b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return 0;
        }
        if (i3 == 0) {
            uo1Var.c = yo1.d;
            return iD0;
        }
        uo1Var.c = yo1.f(bArr, iD0, i3);
        return iD0 + i3;
    }

    public static String y0(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            length = objArr.length;
            if (i3 >= length) {
                break;
            }
            Object obj = objArr[i3];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e2) {
                    String str2 = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str2), (Throwable) e2);
                    string = "<" + str2 + " threw " + e2.getClass().getName() + ">";
                }
            }
            objArr[i3] = string;
            i3++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i4 = 0;
        while (true) {
            length2 = objArr.length;
            if (i2 >= length2 || (iIndexOf = str.indexOf("%s", i4)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i4, iIndexOf);
            sb.append(objArr[i2]);
            i2++;
            i4 = iIndexOf + 2;
        }
        sb.append((CharSequence) str, i4, str.length());
        if (i2 < length2) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i5 = i2 + 1; i5 < objArr.length; i5++) {
                sb.append(", ");
                sb.append(objArr[i5]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static int z(int i2) {
        return App.c.getResources().getDimensionPixelOffset(i2);
    }

    public static int z0(int i2, byte[] bArr) {
        int i3 = bArr[i2] & 255;
        int i4 = bArr[i2 + 1] & 255;
        int i5 = bArr[i2 + 2] & 255;
        return ((bArr[i2 + 3] & 255) << 24) | (i4 << 8) | i3 | (i5 << 16);
    }

    public abstract int B();

    public abstract int C();

    public abstract int E();

    public abstract int F();

    public abstract int H(View view);

    public abstract int I(CoordinatorLayout coordinatorLayout);

    public abstract int J();

    public abstract db M(String str, z01 z01Var, db dbVar, db dbVar2);

    public abstract db N(String str, z01 z01Var);

    public int P(View view) {
        return 0;
    }

    public int Q() {
        return 0;
    }

    public abstract boolean S(float f2);

    public abstract boolean T(View view);

    public abstract boolean U(float f2, float f3);

    public abstract void Y(int i2);

    public abstract void Z(View view, int i2, int i3);

    public abstract void a0(View view, float f2, float f3);

    public abstract int b(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float c(int i2);

    public abstract int g(View view, int i2);

    public abstract int h(View view, int i2);

    public abstract boolean k0(View view, float f2);

    public abstract f91 n(String str);

    public f91 o(String str, z01 z01Var) {
        db dbVarN = N(str, z01Var);
        db dbVarY = y(z01Var);
        return new f91(str, dbVarN, M(str, z01Var, dbVarN, dbVarY), dbVarY, new da1(), new m91());
    }

    public abstract boolean s0(View view, int i2);

    public abstract void t0(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3);

    public void u0(uv0 uv0Var, z01 z01Var, boolean z, boolean z2) {
        List<f91> listK = uv0Var.k();
        da1 da1VarD = ((f91) listK.get(0)).d();
        m91 m91VarB = ((f91) listK.get(0)).b();
        listK.clear();
        if (z) {
            listK.add(o("Left", z01Var));
        }
        if (z2) {
            listK.add(o("Right", z01Var));
        }
        for (f91 f91Var : listK) {
            f91Var.k(da1VarD);
            f91Var.i(m91VarB);
        }
    }

    public abstract db y(z01 z01Var);

    public void X(View view, int i2) {
    }
}
