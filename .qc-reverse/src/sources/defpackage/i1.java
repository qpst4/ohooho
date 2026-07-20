package defpackage;

import android.R;
import android.animation.TimeInterpolator;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i1 {
    public static final int[] c = {R.attr.name, R.attr.tint, R.attr.height, R.attr.width, R.attr.alpha, R.attr.autoMirrored, R.attr.tintMode, R.attr.viewportWidth, R.attr.viewportHeight};
    public static final int[] d = {R.attr.name, R.attr.pivotX, R.attr.pivotY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.translateX, R.attr.translateY};
    public static final int[] e = {R.attr.name, R.attr.fillColor, R.attr.pathData, R.attr.strokeColor, R.attr.strokeWidth, R.attr.trimPathStart, R.attr.trimPathEnd, R.attr.trimPathOffset, R.attr.strokeLineCap, R.attr.strokeLineJoin, R.attr.strokeMiterLimit, R.attr.strokeAlpha, R.attr.fillAlpha, R.attr.fillType};
    public static final int[] f = {R.attr.name, R.attr.pathData, R.attr.fillType};
    public static final int[] g = {R.attr.drawable};
    public static final int[] h = {R.attr.name, R.attr.animation};
    public static final se i = new se();
    public static final Type[] j = new Type[0];
    public static final byte[] k = {112, 114, 111, 0};
    public static final byte[] l = {112, 114, 109, 0};
    public static final l10 m;
    public static final l10[] n;
    public static Interpolator o;
    public final /* synthetic */ int b;

    static {
        l10 l10Var = new l10();
        m = l10Var;
        n = new l10[]{l10Var};
    }

    public i1() {
        this.b = 22;
        new ConcurrentHashMap();
    }

    public static void A(int i2, ln lnVar, vn vnVar, boolean z) {
        gn gnVar;
        gn gnVar2;
        boolean z2;
        gn gnVar3;
        gn gnVar4;
        if (vnVar.m) {
            return;
        }
        if (!(vnVar instanceof wn) && vnVar.z() && c(vnVar)) {
            wn.V(vnVar, lnVar, new se());
        }
        gn gnVarI = vnVar.i(2);
        gn gnVarI2 = vnVar.i(4);
        int iD = gnVarI.d();
        int iD2 = gnVarI2.d();
        HashSet<gn> hashSet = gnVarI.a;
        if (hashSet != null && gnVarI.c) {
            for (gn gnVar5 : hashSet) {
                vn vnVar2 = gnVar5.d;
                int i3 = i2 + 1;
                boolean zC = c(vnVar2);
                gn gnVar6 = vnVar2.I;
                gn gnVar7 = vnVar2.K;
                if (vnVar2.z() && zC) {
                    z2 = true;
                    wn.V(vnVar2, lnVar, new se());
                } else {
                    z2 = true;
                }
                boolean z3 = ((gnVar5 == gnVar6 && (gnVar4 = gnVar7.f) != null && gnVar4.c) || (gnVar5 == gnVar7 && (gnVar3 = gnVar6.f) != null && gnVar3.c)) ? z2 : false;
                int i4 = vnVar2.p0[0];
                if (i4 != 3 || zC) {
                    if (!vnVar2.z()) {
                        if (gnVar5 == gnVar6 && gnVar7.f == null) {
                            int iE = gnVar6.e() + iD;
                            vnVar2.J(iE, vnVar2.q() + iE);
                            A(i3, lnVar, vnVar2, z);
                        } else if (gnVar5 == gnVar7 && gnVar6.f == null) {
                            int iE2 = iD - gnVar7.e();
                            vnVar2.J(iE2 - vnVar2.q(), iE2);
                            A(i3, lnVar, vnVar2, z);
                        } else if (z3 && !vnVar2.x()) {
                            Y(i3, lnVar, vnVar2, z);
                        }
                    }
                } else if (i4 == 3 && vnVar2.v >= 0 && vnVar2.u >= 0 && (vnVar2.g0 == 8 || (vnVar2.r == 0 && vnVar2.W == 0.0f))) {
                    if (!vnVar2.x() && !vnVar2.F && z3 && !vnVar2.x()) {
                        Z(i3, vnVar, lnVar, vnVar2, z);
                    }
                }
            }
        }
        if (vnVar instanceof n70) {
            return;
        }
        HashSet<gn> hashSet2 = gnVarI2.a;
        if (hashSet2 != null && gnVarI2.c) {
            for (gn gnVar8 : hashSet2) {
                vn vnVar3 = gnVar8.d;
                int i5 = i2 + 1;
                boolean zC2 = c(vnVar3);
                gn gnVar9 = vnVar3.I;
                gn gnVar10 = vnVar3.K;
                if (vnVar3.z() && zC2) {
                    wn.V(vnVar3, lnVar, new se());
                }
                boolean z4 = (gnVar8 == gnVar9 && (gnVar2 = gnVar10.f) != null && gnVar2.c) || (gnVar8 == gnVar10 && (gnVar = gnVar9.f) != null && gnVar.c);
                int i6 = vnVar3.p0[0];
                if (i6 != 3 || zC2) {
                    if (!vnVar3.z()) {
                        if (gnVar8 == gnVar9 && gnVar10.f == null) {
                            int iE3 = gnVar9.e() + iD2;
                            vnVar3.J(iE3, vnVar3.q() + iE3);
                            A(i5, lnVar, vnVar3, z);
                        } else if (gnVar8 == gnVar10 && gnVar9.f == null) {
                            int iE4 = iD2 - gnVar10.e();
                            vnVar3.J(iE4 - vnVar3.q(), iE4);
                            A(i5, lnVar, vnVar3, z);
                        } else if (z4 && !vnVar3.x()) {
                            Y(i5, lnVar, vnVar3, z);
                        }
                    }
                } else if (i6 == 3 && vnVar3.v >= 0 && vnVar3.u >= 0) {
                    if (vnVar3.g0 == 8 || (vnVar3.r == 0 && vnVar3.W == 0.0f)) {
                        if (!vnVar3.x() && !vnVar3.F && z4 && !vnVar3.x()) {
                            Z(i5, vnVar, lnVar, vnVar3, z);
                        }
                    }
                }
            }
        }
        vnVar.m = true;
    }

    public static lu B(gd0 gd0Var, boolean z, cd0 cd0Var, int i2) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return gd0Var.z(z, (i2 & 2) != 0, cd0Var);
    }

    public static final boolean C(mp mpVar) {
        yc0 yc0Var = (yc0) mpVar.b().i(ow0.f);
        if (yc0Var != null) {
            return yc0Var.a();
        }
        return true;
    }

    public static boolean D(int i2, CharSequence charSequence) {
        if (i2 >= charSequence.length()) {
            return false;
        }
        char cCharAt = charSequence.charAt(i2);
        switch (cCharAt) {
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
                return true;
            default:
                switch (cCharAt) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                        return true;
                    default:
                        switch (cCharAt) {
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                                return true;
                            default:
                                switch (cCharAt) {
                                    case '{':
                                    case '|':
                                    case '}':
                                    case '~':
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public static boolean E(View view) {
        WeakHashMap weakHashMap = uf1.a;
        return view.getLayoutDirection() == 1;
    }

    public static boolean F(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static void I(z7 z7Var) {
        if (z7Var == null) {
            return;
        }
        String packageName = z7Var.getPackageName();
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
            intent.setFlags(270532608);
            z7Var.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            intent2.setFlags(270532608);
            z7Var.startActivity(intent2);
        }
    }

    public static PorterDuff.Mode J(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static int[] K(ByteArrayInputStream byteArrayInputStream, int i2) {
        int[] iArr = new int[i2];
        int iW = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            iW += (int) xy0.w(byteArrayInputStream, 2);
            iArr[i3] = iW;
        }
        return iArr;
    }

    public static rt[] L(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, rt[] rtVarArr) throws IOException {
        byte[] bArr3 = xr.l;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, xr.m)) {
                s1.f("Unsupported meta version");
                return null;
            }
            int iW = (int) xy0.w(fileInputStream, 2);
            byte[] bArrV = xy0.v(fileInputStream, (int) xy0.w(fileInputStream, 4), (int) xy0.w(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                s1.f("Content found after the end of file");
                return null;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrV);
            try {
                rt[] rtVarArrN = N(byteArrayInputStream, bArr2, iW, rtVarArr);
                byteArrayInputStream.close();
                return rtVarArrN;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(xr.g, bArr2)) {
            s1.f("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            return null;
        }
        if (!Arrays.equals(bArr, bArr3)) {
            s1.f("Unsupported meta version");
            return null;
        }
        int iW2 = (int) xy0.w(fileInputStream, 1);
        byte[] bArrV2 = xy0.v(fileInputStream, (int) xy0.w(fileInputStream, 4), (int) xy0.w(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            s1.f("Content found after the end of file");
            return null;
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrV2);
        try {
            rt[] rtVarArrM = M(byteArrayInputStream2, iW2, rtVarArr);
            byteArrayInputStream2.close();
            return rtVarArrM;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static rt[] M(ByteArrayInputStream byteArrayInputStream, int i2, rt[] rtVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new rt[0];
        }
        if (i2 != rtVarArr.length) {
            s1.f("Mismatched number of dex files found in metadata");
            return null;
        }
        String[] strArr = new String[i2];
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iW = (int) xy0.w(byteArrayInputStream, 2);
            iArr[i3] = (int) xy0.w(byteArrayInputStream, 2);
            strArr[i3] = new String(xy0.u(byteArrayInputStream, iW), StandardCharsets.UTF_8);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            rt rtVar = rtVarArr[i4];
            if (!rtVar.b.equals(strArr[i4])) {
                s1.f("Order of dexfiles in metadata did not match baseline");
                return null;
            }
            int i5 = iArr[i4];
            rtVar.e = i5;
            rtVar.h = K(byteArrayInputStream, i5);
        }
        return rtVarArr;
    }

    public static rt[] N(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i2, rt[] rtVarArr) throws IOException {
        rt rtVar;
        if (byteArrayInputStream.available() == 0) {
            return new rt[0];
        }
        if (i2 != rtVarArr.length) {
            s1.f("Mismatched number of dex files found in metadata");
            return null;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            xy0.w(byteArrayInputStream, 2);
            String str = new String(xy0.u(byteArrayInputStream, (int) xy0.w(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long jW = xy0.w(byteArrayInputStream, 4);
            int iW = (int) xy0.w(byteArrayInputStream, 2);
            if (rtVarArr.length > 0) {
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(":");
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                for (int i4 = 0; i4 < rtVarArr.length; i4++) {
                    if (rtVarArr[i4].b.equals(strSubstring)) {
                        rtVar = rtVarArr[i4];
                        break;
                    }
                }
                rtVar = null;
            } else {
                rtVar = null;
            }
            if (rtVar == null) {
                s1.f("Missing profile key: ".concat(str));
                return null;
            }
            rtVar.d = jW;
            int[] iArrK = K(byteArrayInputStream, iW);
            if (Arrays.equals(bArr, xr.k)) {
                rtVar.e = iW;
                rtVar.h = iArrK;
            }
        }
        return rtVarArr;
    }

    public static rt[] O(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, xr.h)) {
            s1.f("Unsupported version");
            return null;
        }
        int iW = (int) xy0.w(fileInputStream, 1);
        byte[] bArrV = xy0.v(fileInputStream, (int) xy0.w(fileInputStream, 4), (int) xy0.w(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            s1.f("Content found after the end of file");
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrV);
        try {
            rt[] rtVarArrP = P(byteArrayInputStream, str, iW);
            byteArrayInputStream.close();
            return rtVarArrP;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static rt[] P(ByteArrayInputStream byteArrayInputStream, String str, int i2) throws IOException {
        int i3 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new rt[0];
        }
        rt[] rtVarArr = new rt[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            int iW = (int) xy0.w(byteArrayInputStream, 2);
            int iW2 = (int) xy0.w(byteArrayInputStream, 2);
            rtVarArr[i4] = new rt(str, new String(xy0.u(byteArrayInputStream, iW), StandardCharsets.UTF_8), xy0.w(byteArrayInputStream, 4), iW2, (int) xy0.w(byteArrayInputStream, 4), (int) xy0.w(byteArrayInputStream, 4), new int[iW2], new TreeMap());
        }
        int i5 = 0;
        while (i5 < i2) {
            rt rtVar = rtVarArr[i5];
            int iAvailable = byteArrayInputStream.available();
            int i6 = rtVar.f;
            int i7 = rtVar.g;
            TreeMap treeMap = rtVar.i;
            int i8 = iAvailable - i6;
            int iW3 = i3;
            while (byteArrayInputStream.available() > i8) {
                iW3 += (int) xy0.w(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(iW3), 1);
                int iW4 = (int) xy0.w(byteArrayInputStream, 2);
                while (iW4 > 0) {
                    xy0.w(byteArrayInputStream, 2);
                    int iW5 = (int) xy0.w(byteArrayInputStream, 1);
                    if (iW5 != 6 && iW5 != 7) {
                        while (iW5 > 0) {
                            xy0.w(byteArrayInputStream, 1);
                            int i9 = i3;
                            int i10 = i5;
                            for (int iW6 = (int) xy0.w(byteArrayInputStream, 1); iW6 > 0; iW6--) {
                                xy0.w(byteArrayInputStream, 2);
                            }
                            iW5--;
                            i3 = i9;
                            i5 = i10;
                        }
                    }
                    iW4--;
                    i3 = i3;
                    i5 = i5;
                }
            }
            int i11 = i3;
            int i12 = i5;
            if (byteArrayInputStream.available() != i8) {
                s1.f("Read too much data during profile line parse");
                return null;
            }
            rtVar.h = K(byteArrayInputStream, rtVar.e);
            BitSet bitSetValueOf = BitSet.valueOf(xy0.u(byteArrayInputStream, (((i7 * 2) + 7) & (-8)) / 8));
            for (int i13 = i11; i13 < i7; i13++) {
                int i14 = bitSetValueOf.get(i13) ? 2 : i11;
                if (bitSetValueOf.get(i13 + i7)) {
                    i14 |= 4;
                }
                if (i14 != 0) {
                    Integer numValueOf = (Integer) treeMap.get(Integer.valueOf(i13));
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(i11);
                    }
                    treeMap.put(Integer.valueOf(i13), Integer.valueOf(i14 | numValueOf.intValue()));
                }
            }
            i5 = i12 + 1;
            i3 = i11;
        }
        return rtVarArr;
    }

    public static TypedValue Q(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0141 A[EDGE_INSN: B:86:0x0141->B:80:0x0141 BREAK  A[LOOP:0: B:3:0x0002->B:89:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[LOOP:0: B:3:0x0002->B:89:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v17, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r12v3, types: [l70] */
    /* JADX WARN: Type inference failed for: r12v4, types: [l70] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Type R(java.lang.reflect.Type r10, java.lang.Class r11, java.lang.reflect.Type r12, java.util.HashMap r13) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i1.R(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.HashMap):java.lang.reflect.Type");
    }

    public static boolean S(Context context, int i2, boolean z) {
        TypedValue typedValueQ = Q(context, i2);
        return (typedValueQ == null || typedValueQ.type != 18) ? z : typedValueQ.data != 0;
    }

    public static int T(Context context, int i2, int i3) {
        TypedValue typedValueQ = Q(context, i2);
        return (typedValueQ == null || typedValueQ.type != 16) ? i3 : typedValueQ.data;
    }

    public static TimeInterpolator U(Context context, int i2, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            zy.n("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
            return null;
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!F(strValueOf, "cubic-bezier") && !F(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (F(strValueOf, "cubic-bezier")) {
            String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
            if (strArrSplit.length == 4) {
                return new PathInterpolator(x(strArrSplit, 0), x(strArrSplit, 1), x(strArrSplit, 2), x(strArrSplit, 3));
            }
            ay0.d("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ", strArrSplit.length);
            return null;
        }
        if (!F(strValueOf, "path")) {
            zy.n("Invalid motion easing type: ".concat(strValueOf));
            return null;
        }
        String strSubstring = strValueOf.substring(5, strValueOf.length() - 1);
        Path path = new Path();
        try {
            lp0.b(xr.f(strSubstring), path);
            return new PathInterpolator(path);
        } catch (RuntimeException e2) {
            zy.l("Error in parsing ".concat(strSubstring), e2);
            return null;
        }
    }

    public static TypedValue V(int i2, Context context, String str) {
        TypedValue typedValueQ = Q(context, i2);
        if (typedValueQ != null) {
            return typedValueQ;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }

    public static int W(char c2, CharSequence charSequence, int i2, int i3) {
        while (i2 < i3) {
            if (charSequence.charAt(i2) != c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int X(CharSequence charSequence, int i2, int i3) {
        while (i2 < i3) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt != '\t' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static void Y(int i2, ln lnVar, vn vnVar, boolean z) {
        float f2 = vnVar.d0;
        gn gnVar = vnVar.I;
        int iD = gnVar.f.d();
        gn gnVar2 = vnVar.K;
        int iD2 = gnVar2.f.d();
        int iE = gnVar.e() + iD;
        int iE2 = iD2 - gnVar2.e();
        if (iD == iD2) {
            f2 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iQ = vnVar.q();
        int i3 = (iD2 - iD) - iQ;
        if (iD > iD2) {
            i3 = (iD - iD2) - iQ;
        }
        int i4 = ((int) (i3 > 0 ? (f2 * i3) + 0.5f : f2 * i3)) + iD;
        int i5 = i4 + iQ;
        if (iD > iD2) {
            i5 = i4 - iQ;
        }
        vnVar.J(i4, i5);
        A(i2 + 1, lnVar, vnVar, z);
    }

    public static void Z(int i2, vn vnVar, ln lnVar, vn vnVar2, boolean z) {
        float f2 = vnVar2.d0;
        gn gnVar = vnVar2.I;
        int iE = gnVar.e() + gnVar.f.d();
        gn gnVar2 = vnVar2.K;
        int iD = gnVar2.f.d() - gnVar2.e();
        if (iD >= iE) {
            int iQ = vnVar2.q();
            if (vnVar2.g0 != 8) {
                int i3 = vnVar2.r;
                if (i3 == 2) {
                    iQ = (int) (vnVar2.d0 * 0.5f * (vnVar instanceof wn ? vnVar.q() : vnVar.T.q()));
                } else if (i3 == 0) {
                    iQ = iD - iE;
                }
                iQ = Math.max(vnVar2.u, iQ);
                int i4 = vnVar2.v;
                if (i4 > 0) {
                    iQ = Math.min(i4, iQ);
                }
            }
            int i5 = iE + ((int) ((f2 * ((iD - iE) - iQ)) + 0.5f));
            vnVar2.J(i5, iQ + i5);
            A(i2 + 1, lnVar, vnVar2, z);
        }
    }

    public static void a0(int i2, ln lnVar, vn vnVar) {
        float f2 = vnVar.e0;
        gn gnVar = vnVar.J;
        int iD = gnVar.f.d();
        gn gnVar2 = vnVar.L;
        int iD2 = gnVar2.f.d();
        int iE = gnVar.e() + iD;
        int iE2 = iD2 - gnVar2.e();
        if (iD == iD2) {
            f2 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iK = vnVar.k();
        int i3 = (iD2 - iD) - iK;
        if (iD > iD2) {
            i3 = (iD - iD2) - iK;
        }
        int i4 = (int) (i3 > 0 ? (f2 * i3) + 0.5f : f2 * i3);
        int i5 = iD + i4;
        int i6 = i5 + iK;
        if (iD > iD2) {
            i5 = iD - i4;
            i6 = i5 - iK;
        }
        vnVar.K(i5, i6);
        e0(i2 + 1, lnVar, vnVar);
    }

    public static void b0(int i2, vn vnVar, ln lnVar, vn vnVar2) {
        float f2 = vnVar2.e0;
        gn gnVar = vnVar2.J;
        int iE = gnVar.e() + gnVar.f.d();
        gn gnVar2 = vnVar2.L;
        int iD = gnVar2.f.d() - gnVar2.e();
        if (iD >= iE) {
            int iK = vnVar2.k();
            if (vnVar2.g0 != 8) {
                int i3 = vnVar2.s;
                if (i3 == 2) {
                    iK = (int) (f2 * 0.5f * (vnVar instanceof wn ? vnVar.k() : vnVar.T.k()));
                } else if (i3 == 0) {
                    iK = iD - iE;
                }
                iK = Math.max(vnVar2.x, iK);
                int i4 = vnVar2.y;
                if (i4 > 0) {
                    iK = Math.min(i4, iK);
                }
            }
            int i5 = iE + ((int) ((f2 * ((iD - iE) - iK)) + 0.5f));
            vnVar2.K(i5, iK + i5);
            e0(i2 + 1, lnVar, vnVar2);
        }
    }

    public static boolean c(vn vnVar) {
        int[] iArr = vnVar.p0;
        int i2 = iArr[0];
        int i3 = iArr[1];
        vn vnVar2 = vnVar.T;
        wn wnVar = vnVar2 != null ? (wn) vnVar2 : null;
        if (wnVar != null) {
            int i4 = wnVar.p0[0];
        }
        if (wnVar != null) {
            int i5 = wnVar.p0[1];
        }
        boolean z = i2 == 1 || vnVar.A() || i2 == 2 || (i2 == 3 && vnVar.r == 0 && vnVar.W == 0.0f && vnVar.t(0)) || (i2 == 3 && vnVar.r == 1 && vnVar.u(0, vnVar.q()));
        boolean z2 = i3 == 1 || vnVar.B() || i3 == 2 || (i3 == 3 && vnVar.s == 0 && vnVar.W == 0.0f && vnVar.t(1)) || (i3 == 3 && vnVar.s == 1 && vnVar.u(1, vnVar.k()));
        return (vnVar.W > 0.0f && (z || z2)) || (z && z2);
    }

    /* JADX WARN: Finally extract failed */
    public static boolean c0(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, rt[] rtVarArr) throws IOException {
        int i2;
        long j2;
        int length;
        byte[] bArr2 = xr.k;
        byte[] bArr3 = xr.j;
        byte[] bArr4 = xr.g;
        int i3 = 0;
        if (!Arrays.equals(bArr, bArr4)) {
            byte[] bArr5 = xr.h;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrJ = j(rtVarArr, bArr5);
                xy0.M(byteArrayOutputStream, rtVarArr.length, 1);
                xy0.M(byteArrayOutputStream, bArrJ.length, 4);
                byte[] bArrG = xy0.g(bArrJ);
                xy0.M(byteArrayOutputStream, bArrG.length, 4);
                byteArrayOutputStream.write(bArrG);
                return true;
            }
            if (Arrays.equals(bArr, bArr3)) {
                xy0.M(byteArrayOutputStream, rtVarArr.length, 1);
                for (rt rtVar : rtVarArr) {
                    int size = rtVar.i.size() * 4;
                    String strT = t(rtVar.a, rtVar.b, bArr3);
                    Charset charset = StandardCharsets.UTF_8;
                    xy0.N(byteArrayOutputStream, strT.getBytes(charset).length);
                    xy0.N(byteArrayOutputStream, rtVar.h.length);
                    xy0.M(byteArrayOutputStream, size, 4);
                    xy0.M(byteArrayOutputStream, rtVar.c, 4);
                    byteArrayOutputStream.write(strT.getBytes(charset));
                    Iterator it = rtVar.i.keySet().iterator();
                    while (it.hasNext()) {
                        xy0.N(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        xy0.N(byteArrayOutputStream, 0);
                    }
                    for (int i4 : rtVar.h) {
                        xy0.N(byteArrayOutputStream, i4);
                    }
                }
                return true;
            }
            byte[] bArr6 = xr.i;
            if (Arrays.equals(bArr, bArr6)) {
                byte[] bArrJ2 = j(rtVarArr, bArr6);
                xy0.M(byteArrayOutputStream, rtVarArr.length, 1);
                xy0.M(byteArrayOutputStream, bArrJ2.length, 4);
                byte[] bArrG2 = xy0.g(bArrJ2);
                xy0.M(byteArrayOutputStream, bArrG2.length, 4);
                byteArrayOutputStream.write(bArrG2);
                return true;
            }
            if (!Arrays.equals(bArr, bArr2)) {
                return false;
            }
            xy0.N(byteArrayOutputStream, rtVarArr.length);
            for (rt rtVar2 : rtVarArr) {
                String str = rtVar2.a;
                TreeMap treeMap = rtVar2.i;
                String strT2 = t(str, rtVar2.b, bArr2);
                Charset charset2 = StandardCharsets.UTF_8;
                xy0.N(byteArrayOutputStream, strT2.getBytes(charset2).length);
                xy0.N(byteArrayOutputStream, treeMap.size());
                xy0.N(byteArrayOutputStream, rtVar2.h.length);
                xy0.M(byteArrayOutputStream, rtVar2.c, 4);
                byteArrayOutputStream.write(strT2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    xy0.N(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i5 : rtVar2.h) {
                    xy0.N(byteArrayOutputStream, i5);
                }
            }
            return true;
        }
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            xy0.N(byteArrayOutputStream2, rtVarArr.length);
            int i6 = 2;
            int i7 = 2;
            for (rt rtVar3 : rtVarArr) {
                xy0.M(byteArrayOutputStream2, rtVar3.c, 4);
                xy0.M(byteArrayOutputStream2, rtVar3.d, 4);
                xy0.M(byteArrayOutputStream2, rtVar3.g, 4);
                String strT3 = t(rtVar3.a, rtVar3.b, bArr4);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strT3.getBytes(charset3).length;
                xy0.N(byteArrayOutputStream2, length2);
                i7 = i7 + 14 + length2;
                byteArrayOutputStream2.write(strT3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i7 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i7 + ", does not match actual size " + byteArray.length);
            }
            dj1 dj1Var = new dj1(1, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList.add(dj1Var);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i8 = 0;
            int i9 = 0;
            while (i8 < rtVarArr.length) {
                try {
                    rt rtVar4 = rtVarArr[i8];
                    xy0.N(byteArrayOutputStream3, i8);
                    xy0.N(byteArrayOutputStream3, rtVar4.e);
                    i9 = i9 + 4 + (rtVar4.e * i6);
                    int[] iArr = rtVar4.h;
                    int length3 = iArr.length;
                    int i10 = i3;
                    while (i3 < length3) {
                        int i11 = iArr[i3];
                        xy0.N(byteArrayOutputStream3, i11 - i10);
                        i3++;
                        i6 = i6;
                        i10 = i11;
                    }
                    i8++;
                    i3 = 0;
                } catch (Throwable th) {
                }
            }
            int i12 = i6;
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i9 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i9 + ", does not match actual size " + byteArray2.length);
            }
            dj1 dj1Var2 = new dj1(3, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList.add(dj1Var2);
            byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i13 = 0;
            for (int i14 = 0; i14 < rtVarArr.length; i14++) {
                try {
                    rt rtVar5 = rtVarArr[i14];
                    Iterator it3 = rtVar5.i.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    try {
                        h0(byteArrayOutputStream4, iIntValue, rtVar5);
                        byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                        byteArrayOutputStream4.close();
                        byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            i0(byteArrayOutputStream4, rtVar5);
                            byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                            byteArrayOutputStream4.close();
                            xy0.N(byteArrayOutputStream3, i14);
                            int length4 = byteArray3.length + 2 + byteArray4.length;
                            int i15 = i13 + 6;
                            xy0.M(byteArrayOutputStream3, length4, 4);
                            xy0.N(byteArrayOutputStream3, iIntValue);
                            byteArrayOutputStream3.write(byteArray3);
                            byteArrayOutputStream3.write(byteArray4);
                            i13 = i15 + length4;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
            }
            byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
            if (i13 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i13 + ", does not match actual size " + byteArray5.length);
            }
            dj1 dj1Var3 = new dj1(4, byteArray5, true);
            byteArrayOutputStream3.close();
            arrayList.add(dj1Var3);
            long size2 = 12 + ((long) (arrayList.size() * 16));
            xy0.M(byteArrayOutputStream, arrayList.size(), 4);
            int i16 = 0;
            while (i16 < arrayList.size()) {
                dj1 dj1Var4 = (dj1) arrayList.get(i16);
                int i17 = dj1Var4.a;
                byte[] bArr7 = dj1Var4.b;
                if (i17 != 1) {
                    i2 = i12;
                    if (i17 == i2) {
                        j2 = 1;
                    } else if (i17 == 3) {
                        j2 = 2;
                    } else if (i17 == 4) {
                        j2 = 3;
                    } else {
                        if (i17 != 5) {
                            throw null;
                        }
                        j2 = 4;
                    }
                } else {
                    i2 = i12;
                    j2 = 0;
                }
                xy0.M(byteArrayOutputStream, j2, 4);
                xy0.M(byteArrayOutputStream, size2, 4);
                if (dj1Var4.c) {
                    long length5 = bArr7.length;
                    byte[] bArrG3 = xy0.g(bArr7);
                    arrayList2.add(bArrG3);
                    xy0.M(byteArrayOutputStream, bArrG3.length, 4);
                    xy0.M(byteArrayOutputStream, length5, 4);
                    length = bArrG3.length;
                } else {
                    arrayList2.add(bArr7);
                    xy0.M(byteArrayOutputStream, bArr7.length, 4);
                    xy0.M(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += (long) length;
                i16++;
                i12 = i2;
            }
            for (int i18 = 0; i18 < arrayList2.size(); i18++) {
                byteArrayOutputStream.write((byte[]) arrayList2.get(i18));
            }
            return true;
        } catch (Throwable th3) {
            try {
                byteArrayOutputStream2.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    public static Type d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new j70(d(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new k70(parameterizedType.getOwnerType(), (Class) parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new j70(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new l70(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static String d0(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static int e(int i2, float f2) {
        return f2 >= 1.0f ? i2 : wl.f(i2, Math.max(0, Math.min(255, (int) (Color.alpha(i2) * f2))));
    }

    public static void e0(int i2, ln lnVar, vn vnVar) {
        boolean z;
        gn gnVar;
        gn gnVar2;
        gn gnVar3;
        gn gnVar4;
        if (vnVar.n) {
            return;
        }
        if (!(vnVar instanceof wn) && vnVar.z() && c(vnVar)) {
            wn.V(vnVar, lnVar, new se());
        }
        gn gnVarI = vnVar.i(3);
        gn gnVarI2 = vnVar.i(5);
        int iD = gnVarI.d();
        int iD2 = gnVarI2.d();
        HashSet<gn> hashSet = gnVarI.a;
        if (hashSet != null && gnVarI.c) {
            for (gn gnVar5 : hashSet) {
                vn vnVar2 = gnVar5.d;
                int i3 = i2 + 1;
                boolean zC = c(vnVar2);
                gn gnVar6 = vnVar2.J;
                gn gnVar7 = vnVar2.L;
                if (vnVar2.z() && zC) {
                    wn.V(vnVar2, lnVar, new se());
                }
                boolean z2 = (gnVar5 == gnVar6 && (gnVar4 = gnVar7.f) != null && gnVar4.c) || (gnVar5 == gnVar7 && (gnVar3 = gnVar6.f) != null && gnVar3.c);
                int i4 = vnVar2.p0[1];
                if (i4 != 3 || zC) {
                    if (!vnVar2.z()) {
                        if (gnVar5 == gnVar6 && gnVar7.f == null) {
                            int iE = gnVar6.e() + iD;
                            vnVar2.K(iE, vnVar2.k() + iE);
                            e0(i3, lnVar, vnVar2);
                        } else if (gnVar5 == gnVar7 && gnVar6.f == null) {
                            int iE2 = iD - gnVar7.e();
                            vnVar2.K(iE2 - vnVar2.k(), iE2);
                            e0(i3, lnVar, vnVar2);
                        } else if (z2 && !vnVar2.y()) {
                            a0(i3, lnVar, vnVar2);
                        }
                    }
                } else if (i4 == 3 && vnVar2.y >= 0 && vnVar2.x >= 0 && (vnVar2.g0 == 8 || (vnVar2.s == 0 && vnVar2.W == 0.0f))) {
                    if (!vnVar2.y() && !vnVar2.F && z2 && !vnVar2.y()) {
                        b0(i3, vnVar, lnVar, vnVar2);
                    }
                }
            }
        }
        boolean z3 = true;
        z3 = true;
        z3 = true;
        if (vnVar instanceof n70) {
            return;
        }
        HashSet<gn> hashSet2 = gnVarI2.a;
        if (hashSet2 != null && gnVarI2.c) {
            for (gn gnVar8 : hashSet2) {
                vn vnVar3 = gnVar8.d;
                int i5 = i2 + 1;
                boolean zC2 = c(vnVar3);
                gn gnVar9 = vnVar3.J;
                gn gnVar10 = vnVar3.L;
                if (vnVar3.z() && zC2) {
                    wn.V(vnVar3, lnVar, new se());
                }
                boolean z4 = (gnVar8 == gnVar9 && (gnVar2 = gnVar10.f) != null && gnVar2.c) || (gnVar8 == gnVar10 && (gnVar = gnVar9.f) != null && gnVar.c);
                int i6 = vnVar3.p0[1];
                if (i6 != 3 || zC2) {
                    if (!vnVar3.z()) {
                        if (gnVar8 == gnVar9 && gnVar10.f == null) {
                            int iE3 = gnVar9.e() + iD2;
                            vnVar3.K(iE3, vnVar3.k() + iE3);
                            e0(i5, lnVar, vnVar3);
                        } else if (gnVar8 == gnVar10 && gnVar9.f == null) {
                            int iE4 = iD2 - gnVar10.e();
                            vnVar3.K(iE4 - vnVar3.k(), iE4);
                            e0(i5, lnVar, vnVar3);
                        } else if (z4 && !vnVar3.y()) {
                            a0(i5, lnVar, vnVar3);
                        }
                    }
                } else if (i6 == 3 && vnVar3.y >= 0 && vnVar3.x >= 0 && (vnVar3.g0 == 8 || (vnVar3.s == 0 && vnVar3.W == 0.0f))) {
                    if (!vnVar3.y() && !vnVar3.F && z4 && !vnVar3.y()) {
                        b0(i5, vnVar, lnVar, vnVar3);
                    }
                }
            }
        }
        gn gnVarI3 = vnVar.i(6);
        if (gnVarI3.a != null && gnVarI3.c) {
            int iD3 = gnVarI3.d();
            for (gn gnVar11 : gnVarI3.a) {
                vn vnVar4 = gnVar11.d;
                int i7 = i2 + 1;
                boolean zC3 = c(vnVar4);
                gn gnVar12 = vnVar4.M;
                if (vnVar4.z() && zC3) {
                    wn.V(vnVar4, lnVar, new se());
                }
                if (vnVar4.p0[z3 ? 1 : 0] != 3 || zC3) {
                    if (!vnVar4.z()) {
                        if (gnVar11 == gnVar12) {
                            int iE5 = gnVar11.e() + iD3;
                            if (vnVar4.E) {
                                int i8 = iE5 - vnVar4.a0;
                                int i9 = vnVar4.V + i8;
                                vnVar4.Z = i8;
                                vnVar4.J.l(i8);
                                vnVar4.L.l(i9);
                                gnVar12.l(iE5);
                                z = z3 ? 1 : 0;
                                vnVar4.l = z;
                            } else {
                                z = z3 ? 1 : 0;
                            }
                            e0(i7, lnVar, vnVar4);
                        }
                        z3 = z;
                    }
                }
                z = z3 ? 1 : 0;
                z3 = z;
            }
        }
        vnVar.n = z3;
    }

    public static void f(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void f0(ByteArrayOutputStream byteArrayOutputStream, rt rtVar) throws IOException {
        i0(byteArrayOutputStream, rtVar);
        int i2 = rtVar.g;
        int[] iArr = rtVar.h;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            xy0.N(byteArrayOutputStream, i5 - i4);
            i3++;
            i4 = i5;
        }
        byte[] bArr = new byte[(((i2 * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : rtVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i6 = iIntValue / 8;
                bArr[i6] = (byte) (bArr[i6] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i7 = iIntValue + i2;
                int i8 = i7 / 8;
                bArr[i8] = (byte) ((1 << (i7 % 8)) | bArr[i8]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void g(Type type) {
        f(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    public static void g0(ByteArrayOutputStream byteArrayOutputStream, rt rtVar, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        xy0.N(byteArrayOutputStream, str.getBytes(charset).length);
        xy0.N(byteArrayOutputStream, rtVar.e);
        xy0.M(byteArrayOutputStream, rtVar.f, 4);
        xy0.M(byteArrayOutputStream, rtVar.c, 4);
        xy0.M(byteArrayOutputStream, rtVar.g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void h0(ByteArrayOutputStream byteArrayOutputStream, int i2, rt rtVar) throws IOException {
        int i3 = rtVar.g;
        byte[] bArr = new byte[(((Integer.bitCount(i2 & (-2)) * i3) + 7) & (-8)) / 8];
        for (Map.Entry entry : rtVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            int i4 = 0;
            for (int i5 = 1; i5 <= 4; i5 <<= 1) {
                if (i5 != 1 && (i5 & i2) != 0) {
                    if ((i5 & iIntValue2) == i5) {
                        int i6 = (i4 * i3) + iIntValue;
                        int i7 = i6 / 8;
                        bArr[i7] = (byte) ((1 << (i6 % 8)) | bArr[i7]);
                    }
                    i4++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void i(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void i0(ByteArrayOutputStream byteArrayOutputStream, rt rtVar) throws IOException {
        int i2 = 0;
        for (Map.Entry entry : rtVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                xy0.N(byteArrayOutputStream, iIntValue - i2);
                xy0.N(byteArrayOutputStream, 0);
                i2 = iIntValue;
            }
        }
    }

    public static byte[] j(rt[] rtVarArr, byte[] bArr) throws IOException {
        int i2 = 0;
        int length = 0;
        for (rt rtVar : rtVarArr) {
            length += ((((rtVar.g * 2) + 7) & (-8)) / 8) + (rtVar.e * 2) + t(rtVar.a, rtVar.b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + rtVar.f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, xr.i)) {
            int length2 = rtVarArr.length;
            while (i2 < length2) {
                rt rtVar2 = rtVarArr[i2];
                g0(byteArrayOutputStream, rtVar2, t(rtVar2.a, rtVar2.b, bArr));
                f0(byteArrayOutputStream, rtVar2);
                i2++;
            }
        } else {
            for (rt rtVar3 : rtVarArr) {
                g0(byteArrayOutputStream, rtVar3, t(rtVar3.a, rtVar3.b, bArr));
            }
            int length3 = rtVarArr.length;
            while (i2 < length3) {
                f0(byteArrayOutputStream, rtVarArr[i2]);
                i2++;
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static boolean j0(byte b) {
        return b > -65;
    }

    public static int o(Context context, float f2) {
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static float p(Context context, int i2) {
        return TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    public static boolean q(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return Objects.equals(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return q(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return Objects.equals(typeVariable.getGenericDeclaration(), typeVariable2.getGenericDeclaration()) && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static String r(zh zhVar) {
        StringBuilder sb = new StringBuilder(zhVar.size());
        for (int i2 = 0; i2 < zhVar.size(); i2++) {
            byte b = zhVar.b(i2);
            if (b == 34) {
                sb.append("\\\"");
            } else if (b == 39) {
                sb.append("\\'");
            } else if (b != 92) {
                switch (b) {
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
                        if (b < 32 || b > 126) {
                            sb.append('\\');
                            sb.append((char) (((b >>> 6) & 3) + 48));
                            sb.append((char) (((b >>> 3) & 7) + 48));
                            sb.append((char) ((b & 7) + 48));
                        } else {
                            sb.append((char) b);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static x20 s(x20[] x20VarArr, int i2) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        x20 x20Var = null;
        int i4 = Integer.MAX_VALUE;
        for (x20 x20Var2 : x20VarArr) {
            int iAbs = (Math.abs(x20Var2.c - i3) * 2) + (x20Var2.d == z ? 0 : 1);
            if (x20Var == null || i4 > iAbs) {
                x20Var = x20Var2;
                i4 = iAbs;
            }
        }
        return x20Var;
    }

    public static String t(String str, String str2, byte[] bArr) {
        byte[] bArr2 = xr.j;
        byte[] bArr3 = xr.k;
        String str3 = (Arrays.equals(bArr, bArr3) || Arrays.equals(bArr, bArr2)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(str3)) {
                return str2.replace(":", "!");
            }
            if (":".equals(str3)) {
                return str2.replace("!", ":");
            }
        } else {
            if (str2.equals("classes.dex")) {
                return str;
            }
            if (str2.contains("!") || str2.contains(":")) {
                if ("!".equals(str3)) {
                    return str2.replace(":", "!");
                }
                if (":".equals(str3)) {
                    return str2.replace("!", ":");
                }
            } else if (!str2.endsWith(".apk")) {
                return l11.k(l11.l(str), (Arrays.equals(bArr, bArr3) || Arrays.equals(bArr, bArr2)) ? ":" : "!", str2);
            }
        }
        return str2;
    }

    public static Type u(Type type, Class cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i2 = 0; i2 < length; i2++) {
                Class<?> cls3 = interfaces[i2];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return u(cls.getGenericInterfaces()[i2], interfaces[i2], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return u(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static String v(Uri uri) {
        String strSubstring = null;
        try {
            String path = uri.getPath();
            if (path != null && e31.e0(6, path, ".") != -1) {
                strSubstring = path.substring(e31.e0(6, path, ".") + 1);
            }
        } catch (Exception unused) {
        }
        if (strSubstring == null || strSubstring.length() == 0) {
            strSubstring = "jpg";
        }
        return ".".concat(strSubstring);
    }

    public static File w(File file, String str) {
        file.getClass();
        if (str == null) {
            str = ".jpg";
        }
        try {
            String str2 = new SimpleDateFormat("yyyyMMdd_HHmmssSSS", Locale.getDefault()).format(new Date());
            str2.getClass();
            String strConcat = "IMG_".concat(str2).concat(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, strConcat);
            file2.createNewFile();
            return file2;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static float x(String[] strArr, int i2) {
        float f2 = Float.parseFloat(strArr[i2]);
        if (f2 >= 0.0f && f2 <= 1.0f) {
            return f2;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f2);
    }

    public static int y() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        int[] iArr = new int[2];
        EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (iArr2[0] == 0) {
            return 0;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344}, 0);
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext);
        int[] iArr3 = new int[1];
        GLES20.glGetIntegerv(3379, iArr3, 0);
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface);
        EGL14.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
        EGL14.eglTerminate(eGLDisplayEglGetDisplay);
        return iArr3[0];
    }

    public static Class z(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            f(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance((Class<?>) z(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return z(((WildcardType) type).getUpperBounds()[0]);
        }
        zy.i("Expected a Class, ParameterizedType, or GenericArrayType, but <", type, "> is of type ", type == null ? "null" : type.getClass().getName());
        return null;
    }

    public abstract void G(int i2);

    public abstract void H(Typeface typeface);

    public void b(int i2) {
        new Handler(Looper.getMainLooper()).post(new kf(i2, 1, this));
    }

    public abstract List h(String str, List list);

    public abstract Typeface k(Context context, u20 u20Var, Resources resources, int i2);

    public abstract Typeface l(Context context, x20[] x20VarArr, int i2);

    public Typeface m(int i2, Context context, List list) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface n(Context context, Resources resources, int i2, String str, int i3) {
        File fileW = xr.w(context);
        if (fileW == null) {
            return null;
        }
        try {
            if (xr.d(fileW, resources, i2)) {
                return Typeface.createFromFile(fileW.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileW.delete();
        }
    }

    public String toString() {
        switch (this.b) {
            case 24:
                return ((bo1) this).p.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ i1(int i2) {
        this.b = i2;
    }
}
