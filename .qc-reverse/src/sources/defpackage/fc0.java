package defpackage;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import com.nabinbhandari.android.permissions.PermissionsActivity;
import com.quickcursor.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fc0 {
    public static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public static final ew b = new ew(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    public static final fw c = new fw(new ra(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 8), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    public static final c1 d = new c1("CONDITION_FALSE", 4);
    public static final Object e = new Object();
    public static Method f = null;
    public static boolean g = false;
    public static boolean h = false;
    public static Method i = null;
    public static boolean j = false;
    public static Field k;

    public static void A(String str) {
        Log.d("Permissions", str);
    }

    public static int B(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.right;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.bottom;
        } else if (i2 == 66) {
            i3 = rect2.left;
            i4 = rect.right;
        } else {
            if (i2 != 130) {
                zy.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                return 0;
            }
            i3 = rect2.top;
            i4 = rect.bottom;
        }
        return Math.max(0, i3 - i4);
    }

    public static String C(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            zy.n("Invalid input received");
            return null;
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(str.charAt(i2));
            if (str2.length() > i2) {
                sb.append(str2.charAt(i2));
            }
        }
        return sb.toString();
    }

    public static int D(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        zy.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        return 0;
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static void E(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static boolean F(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static boolean I(Parcel parcel, int i2) {
        W(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static int J(Parcel parcel, int i2) {
        W(parcel, i2, 4);
        return parcel.readInt();
    }

    public static int K(Parcel parcel, int i2) {
        return (i2 & (-65536)) != -65536 ? (char) (i2 >> 16) : parcel.readInt();
    }

    public static void L(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
    }

    public static byte[] M(byte[] bArr) {
        byte[] bArr2 = new byte[64];
        for (int i2 = 0; i2 < 32; i2++) {
            int i3 = i2 * 2;
            bArr2[i3] = (byte) (bArr[i2] & 15);
            bArr2[i3 + 1] = (byte) (((bArr[i2] & 255) >> 4) & 15);
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < 63) {
            byte b2 = (byte) (bArr2[i4] + i5);
            bArr2[i4] = b2;
            int i6 = (b2 + 8) >> 4;
            bArr2[i4] = (byte) (b2 - (i6 << 4));
            i4++;
            i5 = i6;
        }
        bArr2[63] = (byte) (bArr2[63] + i5);
        fw fwVar = new fw(0);
        fw fwVar2 = new fw(1);
        for (int i7 = 1; i7 < 64; i7 += 2) {
            ew ewVar = new ew();
            N(ewVar, i7 / 2, bArr2[i7]);
            fw.a(fwVar2, fwVar);
            a(fwVar, fwVar2, ewVar);
        }
        ra raVar = new ra();
        ra.t(raVar, fwVar);
        p(raVar, fwVar);
        ra.t(raVar, fwVar);
        p(raVar, fwVar);
        ra.t(raVar, fwVar);
        p(raVar, fwVar);
        ra.t(raVar, fwVar);
        p(raVar, fwVar);
        for (int i8 = 0; i8 < 64; i8 += 2) {
            ew ewVar2 = new ew();
            N(ewVar2, i8 / 2, bArr2[i8]);
            fw.a(fwVar2, fwVar);
            a(fwVar, fwVar2, ewVar2);
        }
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        ra raVar2 = fwVar.a;
        long[] jArr4 = (long[]) raVar2.c;
        long[] jArr5 = fwVar.b;
        lc1.W(jArr, jArr4, jArr5);
        long[] jArr6 = (long[]) raVar2.d;
        long[] jArr7 = (long[]) raVar2.e;
        lc1.W(jArr2, jArr6, jArr7);
        lc1.W(jArr3, jArr7, jArr5);
        long[] jArr8 = new long[10];
        lc1.l0(jArr8, jArr);
        long[] jArr9 = new long[10];
        lc1.l0(jArr9, jArr2);
        long[] jArr10 = new long[10];
        lc1.l0(jArr10, jArr3);
        long[] jArr11 = new long[10];
        lc1.l0(jArr11, jArr10);
        long[] jArr12 = new long[10];
        lc1.o0(jArr12, jArr9, jArr8);
        lc1.W(jArr12, jArr12, jArr10);
        long[] jArr13 = new long[10];
        lc1.W(jArr13, jArr8, jArr9);
        lc1.W(jArr13, jArr13, gw.a);
        lc1.p0(jArr13, jArr13, jArr11);
        if (!f01.t(lc1.j(jArr12), lc1.j(jArr13))) {
            s1.f("arithmetic error in scalar multiplication");
            return null;
        }
        long[] jArr14 = new long[10];
        long[] jArr15 = new long[10];
        long[] jArr16 = new long[10];
        long[] jArr17 = new long[10];
        long[] jArr18 = new long[10];
        long[] jArr19 = new long[10];
        long[] jArr20 = new long[10];
        long[] jArr21 = new long[10];
        long[] jArr22 = new long[10];
        long[] jArr23 = new long[10];
        long[] jArr24 = new long[10];
        long[] jArr25 = new long[10];
        long[] jArr26 = new long[10];
        lc1.l0(jArr17, jArr3);
        lc1.l0(jArr26, jArr17);
        lc1.l0(jArr25, jArr26);
        lc1.W(jArr18, jArr25, jArr3);
        lc1.W(jArr19, jArr18, jArr17);
        lc1.l0(jArr25, jArr19);
        lc1.W(jArr20, jArr25, jArr18);
        lc1.l0(jArr25, jArr20);
        lc1.l0(jArr26, jArr25);
        lc1.l0(jArr25, jArr26);
        lc1.l0(jArr26, jArr25);
        lc1.l0(jArr25, jArr26);
        lc1.W(jArr21, jArr25, jArr20);
        lc1.l0(jArr25, jArr21);
        lc1.l0(jArr26, jArr25);
        for (int i9 = 2; i9 < 10; i9 += 2) {
            lc1.l0(jArr25, jArr26);
            lc1.l0(jArr26, jArr25);
        }
        lc1.W(jArr22, jArr26, jArr21);
        lc1.l0(jArr25, jArr22);
        lc1.l0(jArr26, jArr25);
        for (int i10 = 2; i10 < 20; i10 += 2) {
            lc1.l0(jArr25, jArr26);
            lc1.l0(jArr26, jArr25);
        }
        lc1.W(jArr25, jArr26, jArr22);
        lc1.l0(jArr26, jArr25);
        lc1.l0(jArr25, jArr26);
        for (int i11 = 2; i11 < 10; i11 += 2) {
            lc1.l0(jArr26, jArr25);
            lc1.l0(jArr25, jArr26);
        }
        lc1.W(jArr23, jArr25, jArr21);
        lc1.l0(jArr25, jArr23);
        lc1.l0(jArr26, jArr25);
        for (int i12 = 2; i12 < 50; i12 += 2) {
            lc1.l0(jArr25, jArr26);
            lc1.l0(jArr26, jArr25);
        }
        lc1.W(jArr24, jArr26, jArr23);
        lc1.l0(jArr26, jArr24);
        lc1.l0(jArr25, jArr26);
        for (int i13 = 2; i13 < 100; i13 += 2) {
            lc1.l0(jArr26, jArr25);
            lc1.l0(jArr25, jArr26);
        }
        lc1.W(jArr26, jArr25, jArr24);
        lc1.l0(jArr25, jArr26);
        lc1.l0(jArr26, jArr25);
        for (int i14 = 2; i14 < 50; i14 += 2) {
            lc1.l0(jArr25, jArr26);
            lc1.l0(jArr26, jArr25);
        }
        lc1.W(jArr25, jArr26, jArr23);
        lc1.l0(jArr26, jArr25);
        lc1.l0(jArr25, jArr26);
        lc1.l0(jArr26, jArr25);
        lc1.l0(jArr25, jArr26);
        lc1.l0(jArr26, jArr25);
        lc1.W(jArr14, jArr26, jArr19);
        lc1.W(jArr15, jArr, jArr14);
        lc1.W(jArr16, jArr2, jArr14);
        byte[] bArrJ = lc1.j(jArr16);
        bArrJ[31] = (byte) (bArrJ[31] ^ ((lc1.j(jArr15)[0] & 1) << 7));
        return bArrJ;
    }

    public static void N(ew ewVar, int i2, byte b2) {
        int i3 = (b2 & 255) >> 7;
        int i4 = b2 - (((-i3) & b2) << 1);
        ew[][] ewVarArr = gw.b;
        ewVar.a(ewVarArr[i2][0], r(i4, 1));
        ewVar.a(ewVarArr[i2][1], r(i4, 2));
        ewVar.a(ewVarArr[i2][2], r(i4, 3));
        ewVar.a(ewVarArr[i2][3], r(i4, 4));
        ewVar.a(ewVarArr[i2][4], r(i4, 5));
        ewVar.a(ewVarArr[i2][5], r(i4, 6));
        ewVar.a(ewVarArr[i2][6], r(i4, 7));
        ewVar.a(ewVarArr[i2][7], r(i4, 8));
        long[] jArr = ewVar.b;
        long[] jArrCopyOf = Arrays.copyOf(jArr, 10);
        long[] jArr2 = ewVar.a;
        long[] jArrCopyOf2 = Arrays.copyOf(jArr2, 10);
        long[] jArr3 = ewVar.c;
        long[] jArrCopyOf3 = Arrays.copyOf(jArr3, 10);
        for (int i5 = 0; i5 < jArrCopyOf3.length; i5++) {
            jArrCopyOf3[i5] = -jArrCopyOf3[i5];
        }
        i(jArr2, jArrCopyOf, i3);
        i(jArr, jArrCopyOf2, i3);
        i(jArr3, jArrCopyOf3, i3);
    }

    public static void O(View view, ik0 ik0Var) {
        nx nxVar = ik0Var.b.b;
        if (nxVar == null || !nxVar.a) {
            return;
        }
        float fE = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            WeakHashMap weakHashMap = uf1.a;
            fE += lf1.e((View) parent);
        }
        hk0 hk0Var = ik0Var.b;
        if (hk0Var.l != fE) {
            hk0Var.l = fE;
            ik0Var.n();
        }
    }

    public static void P(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            c71.a(view, charSequence);
            return;
        }
        e71 e71Var = e71.l;
        if (e71Var != null && e71Var.b == view) {
            e71.b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new e71(view, charSequence);
            return;
        }
        e71 e71Var2 = e71.m;
        if (e71Var2 != null && e71Var2.b == view) {
            e71Var2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static void Q(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + K(parcel, i2));
    }

    public static final Object R(wx0 wx0Var, wx0 wx0Var2, z40 z40Var) throws Throwable {
        Object amVar;
        Object objB;
        xa0 xa0Var;
        try {
            lc1.a(z40Var);
            amVar = z40Var.f(wx0Var2, wx0Var);
        } catch (Throwable th) {
            amVar = new am(th);
        }
        np npVar = np.b;
        if (amVar == npVar || (objB = wx0Var.B(amVar)) == yb0.f) {
            return npVar;
        }
        if (objB instanceof am) {
            throw ((am) objB).a;
        }
        ya0 ya0Var = objB instanceof ya0 ? (ya0) objB : null;
        return (ya0Var == null || (xa0Var = ya0Var.a) == null) ? objB : xa0Var;
    }

    public static void S(String str) {
        cm cmVar = new cm(l11.j("lateinit property ", str, " has not been initialized"));
        L(cmVar, fc0.class.getName());
        throw cmVar;
    }

    public static int T(Parcel parcel) {
        int i2 = parcel.readInt();
        int iK = K(parcel, i2);
        char c2 = (char) i2;
        int iDataPosition = parcel.dataPosition();
        if (c2 != 20293) {
            throw new cm("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i2))), parcel);
        }
        int i3 = iK + iDataPosition;
        if (i3 < iDataPosition || i3 > parcel.dataSize()) {
            throw new cm(qq0.h(iDataPosition, i3, "Size read is invalid start=", " end="), parcel);
        }
        return i3;
    }

    public static final Object U(q70 q70Var, z40 z40Var, o31 o31Var) throws Throwable {
        xa0 xa0Var;
        ep epVar = o31Var.c;
        epVar.getClass();
        ep epVarH = !((Boolean) q70Var.g(Boolean.FALSE, xl.g)).booleanValue() ? epVar.h(q70Var) : f01.u(epVar, q70Var, false);
        yc0 yc0Var = (yc0) epVarH.i(ow0.f);
        if (yc0Var != null && !yc0Var.a()) {
            throw ((gd0) yc0Var).r();
        }
        if (epVarH == epVar) {
            wx0 wx0Var = new wx0(epVarH, o31Var);
            return R(wx0Var, wx0Var, z40Var);
        }
        ow0 ow0Var = ow0.d;
        if (b(epVarH.i(ow0Var), epVar.i(ow0Var))) {
            ad1 ad1Var = new ad1(epVarH, o31Var);
            ep epVar2 = ad1Var.f;
            Object objV0 = lc1.v0(epVar2, null);
            try {
                return R(ad1Var, ad1Var, z40Var);
            } finally {
                lc1.g0(epVar2, objV0);
            }
        }
        gu guVar = new gu(epVarH, o31Var);
        lc1.n0(z40Var, guVar, guVar);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = gu.h;
        do {
            int i2 = atomicIntegerFieldUpdater.get(guVar);
            if (i2 != 0) {
                if (i2 != 2) {
                    s1.f("Already suspended");
                    return null;
                }
                Object objV = guVar.v();
                ya0 ya0Var = objV instanceof ya0 ? (ya0) objV : null;
                if (ya0Var != null && (xa0Var = ya0Var.a) != null) {
                    objV = xa0Var;
                }
                if (objV instanceof am) {
                    throw ((am) objV).a;
                }
                return objV;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(guVar, 0, 1));
        return np.b;
    }

    public static boolean V(Comparator comparator, Collection collection) {
        Object objComparator;
        comparator.getClass();
        collection.getClass();
        if (collection instanceof SortedSet) {
            objComparator = ((SortedSet) collection).comparator();
            if (objComparator == null) {
                objComparator = qm1.c;
            }
        } else {
            if (!(collection instanceof an1)) {
                return false;
            }
            objComparator = ((an1) collection).d;
        }
        return comparator.equals(objComparator);
    }

    public static void W(Parcel parcel, int i2, int i3) {
        int iK = K(parcel, i2);
        if (iK == i3) {
            return;
        }
        String hexString = Integer.toHexString(iK);
        StringBuilder sb = new StringBuilder("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(iK);
        sb.append(" (0x");
        throw new cm(l11.k(sb, hexString, ")"), parcel);
    }

    public static void a(fw fwVar, fw fwVar2, ew ewVar) {
        long[] jArr = new long[10];
        ra raVar = fwVar.a;
        long[] jArr2 = (long[]) raVar.c;
        ra raVar2 = fwVar2.a;
        lc1.p0(jArr2, (long[]) raVar2.d, (long[]) raVar2.c);
        lc1.o0((long[]) raVar.d, (long[]) raVar2.d, (long[]) raVar2.c);
        long[] jArr3 = (long[]) raVar.d;
        lc1.W(jArr3, jArr3, ewVar.b);
        long[] jArr4 = (long[]) raVar.e;
        long[] jArr5 = (long[]) raVar.c;
        lc1.W(jArr4, jArr5, ewVar.a);
        long[] jArr6 = fwVar.b;
        lc1.W(jArr6, fwVar2.b, ewVar.c);
        System.arraycopy((long[]) raVar2.e, 0, jArr5, 0, 10);
        lc1.p0(jArr, jArr5, jArr5);
        lc1.o0(jArr5, jArr4, jArr3);
        lc1.p0(jArr3, jArr4, jArr3);
        lc1.p0(jArr4, jArr, jArr6);
        lc1.o0(jArr6, jArr, jArr6);
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = d(r9, r10, r11)
            boolean r1 = d(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L72
            if (r0 != 0) goto Lf
            goto L72
        Lf:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L3b
            if (r9 == r3) goto L34
            if (r9 == r4) goto L2d
            if (r9 != r1) goto L29
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L71
            goto L41
        L29:
            defpackage.zy.n(r0)
            return r2
        L2d:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L71
            goto L41
        L34:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L71
            goto L41
        L3b:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L71
        L41:
            if (r9 == r5) goto L71
            if (r9 != r4) goto L46
            goto L71
        L46:
            int r11 = B(r9, r10, r11)
            if (r9 == r5) goto L66
            if (r9 == r3) goto L61
            if (r9 == r4) goto L5c
            if (r9 != r1) goto L58
            int r9 = r12.bottom
            int r10 = r10.bottom
        L56:
            int r9 = r9 - r10
            goto L6b
        L58:
            defpackage.zy.n(r0)
            return r2
        L5c:
            int r9 = r12.right
            int r10 = r10.right
            goto L56
        L61:
            int r9 = r10.top
            int r10 = r12.top
            goto L56
        L66:
            int r9 = r10.left
            int r10 = r12.left
            goto L56
        L6b:
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L72
        L71:
            return r6
        L72:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fc0.c(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean d(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        zy.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        return false;
                    }
                }
                if (rect2.bottom < rect.top) {
                }
            }
            if (rect2.right >= rect.left && rect2.left <= rect.right) {
                return true;
            }
        } else if (rect2.bottom < rect.top && rect2.top <= rect.bottom) {
            return true;
        }
        return false;
    }

    public static void h(Context context, String[] strArr, mp0 mp0Var, sp1 sp1Var) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Collections.addAll(linkedHashSet, strArr);
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            if (context.checkSelfPermission((String) it.next()) != 0) {
                PermissionsActivity.f = sp1Var;
                context.startActivity(new Intent(context, (Class<?>) PermissionsActivity.class).putExtra("permissions", new ArrayList(linkedHashSet)).putExtra("rationale", (String) null).putExtra("options", mp0Var));
                return;
            }
        }
        ((y2) sp1Var.c).d();
        A("Permission(s) ".concat(PermissionsActivity.f == null ? "already granted." : "just granted from settings."));
        PermissionsActivity.f = null;
    }

    public static void i(long[] jArr, long[] jArr2, int i2) {
        int i3 = -i2;
        for (int i4 = 0; i4 < 10; i4++) {
            long j2 = jArr[i4];
            jArr[i4] = ((int) j2) ^ ((((int) j2) ^ ((int) jArr2[i4])) & i3);
        }
    }

    public static fc0 j(int i2) {
        return i2 != 0 ? i2 != 1 ? new tw0() : new kr() : new tw0();
    }

    public static Parcelable k(Parcel parcel, int i2, Parcelable.Creator creator) {
        int iK = K(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iK);
        return parcelable;
    }

    public static String l(Parcel parcel, int i2) {
        int iK = K(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iK);
        return string;
    }

    public static Object[] m(Parcel parcel, int i2, Parcelable.Creator creator) {
        int iK = K(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iK);
        return objArrCreateTypedArray;
    }

    public static boolean n(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int iIndexOfKey;
        WeakHashMap weakHashMap = uf1.a;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList2 = tf1.d;
            tf1 tf1Var = (tf1) view.getTag(R.id.tag_unhandled_key_event_manager);
            WeakReference weakReference = null;
            if (tf1Var == null) {
                tf1Var = new tf1();
                tf1Var.a = null;
                tf1Var.b = null;
                tf1Var.c = null;
                view.setTag(R.id.tag_unhandled_key_event_manager, tf1Var);
            }
            WeakReference weakReference2 = tf1Var.c;
            if (weakReference2 == null || weakReference2.get() != keyEvent) {
                tf1Var.c = new WeakReference(keyEvent);
                if (tf1Var.b == null) {
                    tf1Var.b = new SparseArray();
                }
                SparseArray sparseArray = tf1Var.b;
                if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
                    sparseArray.removeAt(iIndexOfKey);
                }
                if (weakReference == null) {
                    weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReference != null) {
                    View view2 = (View) weakReference.get();
                    if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
                        return true;
                    }
                    arrayList.get(size).getClass();
                    s1.d();
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean o(ge0 ge0Var, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (ge0Var != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return ge0Var.b(keyEvent);
            }
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window = activity.getWindow();
                if (window.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!h) {
                            try {
                                i = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            h = true;
                        }
                        Method method = i;
                        if (method != null) {
                            try {
                                Object objInvoke = method.invoke(actionBar, keyEvent);
                                if (objInvoke != null) {
                                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (zBooleanValue) {
                            return true;
                        }
                    }
                }
                if (window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window.getDecorView();
                if (uf1.c(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
            }
            if (callback instanceof Dialog) {
                Dialog dialog = (Dialog) callback;
                if (!j) {
                    try {
                        Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                        k = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    j = true;
                }
                Field field = k;
                if (field != null) {
                    try {
                        onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                    } catch (IllegalAccessException unused4) {
                        onKeyListener = null;
                    }
                } else {
                    onKeyListener = null;
                }
                if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                Window window2 = dialog.getWindow();
                if (window2.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView2 = window2.getDecorView();
                if (uf1.c(decorView2, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
            }
            if ((view != null && uf1.c(view, keyEvent)) || ge0Var.b(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public static void p(ra raVar, fw fwVar) {
        long[] jArr = new long[10];
        ra raVar2 = fwVar.a;
        long[] jArr2 = (long[]) raVar2.c;
        long[] jArr3 = (long[]) raVar.c;
        lc1.l0(jArr2, jArr3);
        long[] jArr4 = (long[]) raVar2.e;
        long[] jArr5 = (long[]) raVar.d;
        lc1.l0(jArr4, jArr5);
        long[] jArr6 = fwVar.b;
        lc1.l0(jArr6, (long[]) raVar.e);
        lc1.p0(jArr6, jArr6, jArr6);
        long[] jArr7 = (long[]) raVar2.d;
        lc1.p0(jArr7, jArr3, jArr5);
        lc1.l0(jArr, jArr7);
        long[] jArr8 = (long[]) raVar2.e;
        long[] jArr9 = (long[]) raVar2.c;
        lc1.p0(jArr7, jArr8, jArr9);
        lc1.o0(jArr8, jArr8, jArr9);
        lc1.o0(jArr9, jArr, jArr7);
        lc1.o0(jArr6, jArr6, jArr8);
    }

    public static void q(Parcel parcel, int i2) {
        if (parcel.dataPosition() != i2) {
            throw new cm(qq0.i("Overread allowed size end=", i2), parcel);
        }
    }

    public static int r(int i2, int i3) {
        int i4 = (~(i2 ^ i3)) & 255;
        int i5 = i4 & (i4 << 4);
        int i6 = i5 & (i5 << 2);
        return ((i6 & (i6 << 1)) >> 7) & 1;
    }

    public static boolean s() {
        Class cls = Integer.TYPE;
        try {
            if (AudioManager.class.getMethod("setFineVolume", cls, cls, cls, cls) != null) {
                return true;
            }
        } catch (NoSuchMethodException unused) {
        }
        try {
            if (AudioManager.class.getMethod("semSetFineVolume", cls, cls, cls, cls) != null) {
                if (AudioManager.class.getMethod("getFineVolume", cls, cls) != null) {
                    return true;
                }
            }
        } catch (NoSuchMethodException unused2) {
        }
        try {
            return AudioManager.class.getMethod("semGetFineVolume", cls, cls) != null;
        } catch (NoSuchMethodException unused3) {
            return false;
        }
    }

    public static Set u() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (objInvoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    public static void v() {
        Iterator it = Collections.EMPTY_LIST.iterator();
        if (it.hasNext()) {
            throw l11.h(it);
        }
    }

    public static byte[] w(byte[] bArr) {
        MessageDigest messageDigest = (MessageDigest) jz.g.a("SHA-512");
        messageDigest.update(bArr, 0, 32);
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest[0] = (byte) (bArrDigest[0] & 248);
        byte b2 = (byte) (bArrDigest[31] & 127);
        bArrDigest[31] = b2;
        bArrDigest[31] = (byte) (b2 | 64);
        return bArrDigest;
    }

    public static ArrayList x(ArrayList arrayList, boolean z) {
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if ((arrayList.get(i2) instanceof nc0) && ((nc0) arrayList.get(i2)).d == z) {
                arrayList2.add(arrayList.get(i2));
            }
        }
        return arrayList2;
    }

    public static boolean y(int i2, Rect rect, Rect rect2) {
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            if ((i3 > i4 || rect.left >= i4) && rect.left > rect2.left) {
                return true;
            }
        } else if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            if ((i5 > i6 || rect.top >= i6) && rect.top > rect2.top) {
                return true;
            }
        } else if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            if ((i7 < i8 || rect.right <= i8) && rect.right < rect2.right) {
                return true;
            }
        } else {
            if (i2 != 130) {
                zy.n("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                return false;
            }
            int i9 = rect.top;
            int i10 = rect2.top;
            if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static l21 z(mp mpVar, ep epVar, z40 z40Var) {
        ep epVarU = f01.u(mpVar.b(), epVar, true);
        rs rsVar = iu.a;
        if (epVarU != rsVar && epVarU.i(ow0.d) == null) {
            epVarU = epVarU.h(rsVar);
        }
        l21 l21Var = new l21(epVarU, true);
        int iOrdinal = pp.b.ordinal();
        if (iOrdinal == 0) {
            lc1.n0(z40Var, l21Var, l21Var);
            return l21Var;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                fp1.q(((o31) z40Var).h(l21Var, l21Var)).e(ow0.h);
            } else {
                if (iOrdinal != 3) {
                    throw new cm();
                }
                try {
                    ep epVar2 = l21Var.f;
                    Object objV0 = lc1.v0(epVar2, null);
                    try {
                        lc1.a(z40Var);
                        Object objF = z40Var.f(l21Var, l21Var);
                        if (objF != np.b) {
                            l21Var.e(objF);
                            return l21Var;
                        }
                    } finally {
                        lc1.g0(epVar2, objV0);
                    }
                } catch (Throwable th) {
                    l21Var.e(new jw0(th));
                    return l21Var;
                }
            }
        }
        return l21Var;
    }

    public abstract void G(t tVar, t tVar2);

    public abstract void H(t tVar, Thread thread);

    public abstract boolean e(u uVar, q qVar);

    public abstract boolean f(u uVar, Object obj, Object obj2);

    public abstract boolean g(u uVar, t tVar, t tVar2);

    public abstract void t(wz0 wz0Var, float f2, float f3);
}
