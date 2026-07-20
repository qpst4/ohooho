package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.icu.text.DecimalFormatSymbols;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xr {
    public static final c1 b;
    public static final c1 c;
    public static boolean o;
    public static int p;
    public static Field q;
    public static boolean r;
    public static Class s;
    public static boolean t;
    public static Field u;
    public static boolean v;
    public static Field w;
    public static boolean x;
    public static final Object a = new Object();
    public static final or0 d = new or0("image-destination");
    public static final or0 e = new or0("image-replacement-text-is-link");
    public static final or0 f = new or0("image-size");
    public static final byte[] g = {48, 49, 53, 0};
    public static final byte[] h = {48, 49, 48, 0};
    public static final byte[] i = {48, 48, 57, 0};
    public static final byte[] j = {48, 48, 53, 0};
    public static final byte[] k = {48, 48, 49, 0};
    public static final byte[] l = {48, 48, 49, 0};
    public static final byte[] m = {48, 48, 50, 0};
    public static final Object n = new Object();

    static {
        int i2 = 4;
        b = new c1("UNDEFINED", i2);
        c = new c1("REUSABLE_CLAIMED", i2);
    }

    public static MappedByteBuffer A(Context context, Uri uri) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                parcelFileDescriptorOpenFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    public static pd0 B(vd0 vd0Var) {
        int i2 = vd0Var.p;
        if (i2 == 2) {
            vd0Var.p = 1;
        }
        try {
            try {
                return yb0.s(vd0Var);
            } finally {
                vd0Var.L(i2);
            }
        } catch (OutOfMemoryError | StackOverflowError e2) {
            throw new cm("Failed parsing JSON source: " + vd0Var + " to Json", e2);
        }
    }

    public static pd0 C(String str) {
        try {
            try {
                vd0 vd0Var = new vd0(new StringReader(str));
                pd0 pd0VarB = B(vd0Var);
                try {
                    pd0VarB.getClass();
                    if (!(pd0VarB instanceof sd0) && vd0Var.I() != 10) {
                        throw new wd0("Did not consume the entire document.");
                    }
                    return pd0VarB;
                } catch (NumberFormatException e2) {
                    e = e2;
                    throw new wd0(e);
                }
            } catch (IOException e3) {
                throw new rd0(e3);
            }
        } catch (ej0 | NumberFormatException e4) {
            e = e4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void D(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.Object r0 = defpackage.xr.a
            monitor-enter(r0)
            java.lang.String r1 = ""
            boolean r1 = r6.equals(r1)     // Catch: java.lang.Throwable -> L12
            if (r1 == 0) goto L14
            java.lang.String r6 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r5.deleteFile(r6)     // Catch: java.lang.Throwable -> L12
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            return
        L12:
            r5 = move-exception
            goto L60
        L14:
            java.lang.String r1 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r2 = 0
            java.io.FileOutputStream r5 = r5.openFileOutput(r1, r2)     // Catch: java.lang.Throwable -> L12 java.io.FileNotFoundException -> L57
            org.xmlpull.v1.XmlSerializer r1 = android.util.Xml.newSerializer()     // Catch: java.lang.Throwable -> L12
            r2 = 0
            r1.setOutput(r5, r2)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            java.lang.String r3 = "UTF-8"
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r1.startDocument(r3, r4)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            java.lang.String r3 = "locales"
            r1.startTag(r2, r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            java.lang.String r3 = "application_locales"
            r1.attribute(r2, r3, r6)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            java.lang.String r6 = "locales"
            r1.endTag(r2, r6)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r1.endDocument()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            if (r5 == 0) goto L4f
        L3e:
            r5.close()     // Catch: java.lang.Throwable -> L12 java.io.IOException -> L4f
            goto L4f
        L42:
            r6 = move-exception
            goto L51
        L44:
            r6 = move-exception
            java.lang.String r1 = "AppLocalesStorageHelper"
            java.lang.String r2 = "Storing App Locales : Failed to persist app-locales in storage "
            android.util.Log.w(r1, r2, r6)     // Catch: java.lang.Throwable -> L42
            if (r5 == 0) goto L4f
            goto L3e
        L4f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            goto L5f
        L51:
            if (r5 == 0) goto L56
            r5.close()     // Catch: java.lang.Throwable -> L12 java.io.IOException -> L56
        L56:
            throw r6     // Catch: java.lang.Throwable -> L12
        L57:
            java.lang.String r5 = "AppLocalesStorageHelper"
            java.lang.String r6 = "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing "
            android.util.Log.w(r5, r6)     // Catch: java.lang.Throwable -> L12
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
        L5f:
            return
        L60:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xr.D(android.content.Context, java.lang.String):void");
    }

    public static void E(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long jMax = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = (Animator) arrayList.get(i2);
            jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        arrayList.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r1 = r3.getAttributeValue(null, "application_locales");
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0046 A[EXC_TOP_SPLITTER, PHI: r1
  0x0046: PHI (r1v2 java.lang.String) = (r1v0 java.lang.String), (r1v4 java.lang.String) binds: [B:29:0x0053, B:23:0x0044] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String F(android.content.Context r8) {
        /*
            java.lang.Object r0 = defpackage.xr.a
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileInputStream r2 = r8.openFileInput(r2)     // Catch: java.lang.Throwable -> L4a java.io.FileNotFoundException -> L6a
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L4c
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L4c
            int r4 = r3.getDepth()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L4c
        L18:
            int r5 = r3.next()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L4c
            r6 = 1
            if (r5 == r6) goto L44
            r6 = 3
            if (r5 != r6) goto L2b
            int r7 = r3.getDepth()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L4c
            if (r7 <= r4) goto L44
            goto L2b
        L29:
            r8 = move-exception
            goto L64
        L2b:
            if (r5 == r6) goto L18
            r6 = 4
            if (r5 != r6) goto L31
            goto L18
        L31:
            java.lang.String r5 = r3.getName()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L4c
            java.lang.String r6 = "locales"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L4c
            if (r5 == 0) goto L18
            java.lang.String r4 = "application_locales"
            r5 = 0
            java.lang.String r1 = r3.getAttributeValue(r5, r4)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L4c
        L44:
            if (r2 == 0) goto L56
        L46:
            r2.close()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L56
            goto L56
        L4a:
            r8 = move-exception
            goto L6c
        L4c:
            java.lang.String r3 = "AppLocalesStorageHelper"
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r3, r4)     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L56
            goto L46
        L56:
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L4a
            if (r2 != 0) goto L5d
            goto L62
        L5d:
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r8.deleteFile(r2)     // Catch: java.lang.Throwable -> L4a
        L62:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4a
            return r1
        L64:
            if (r2 == 0) goto L69
            r2.close()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L69
        L69:
            throw r8     // Catch: java.lang.Throwable -> L4a
        L6a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4a
            return r1
        L6c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4a
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xr.F(android.content.Context):java.lang.String");
    }

    public static final Object G(Object obj) {
        return obj instanceof am ? new jw0(((am) obj).a) : obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5 A[Catch: all -> 0x0094, DONT_GENERATE, TryCatch #2 {all -> 0x0094, blocks: (B:25:0x006e, B:27:0x007b, B:29:0x0081, B:31:0x008b, B:45:0x00b8, B:34:0x0096, B:35:0x0097, B:37:0x00a4, B:42:0x00af, B:44:0x00b5, B:50:0x00c5, B:53:0x00ce, B:52:0x00cb, B:40:0x00aa), top: B:66:0x006e, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void H(defpackage.jo r11, java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xr.H(jo, java.lang.Object):void");
    }

    public static void I(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                I(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public static void J(TextView textView, int i2) {
        f01.h(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            ju.m(textView, i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void K(TextView textView, int i2) {
        f01.h(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void L(TextView textView, int i2) {
        f01.h(i2);
        if (i2 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i2 - r0, 1.0f);
        }
    }

    public static void M(View view) {
        if (oq0.a((SharedPreferences) pn0.t().d, oq0.h)) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
            List listSingletonList = Collections.singletonList(new Rect(0, 0, layoutParams.width, layoutParams.height));
            WeakHashMap weakHashMap = uf1.a;
            if (Build.VERSION.SDK_INT >= 29) {
                qf1.c(view, listSingletonList);
            }
        }
    }

    public static String N(int i2) throws NoSuchAlgorithmException {
        int iR = l11.r(i2);
        if (iR == 1) {
            return "HmacSha1";
        }
        if (iR == 2) {
            return "HmacSha256";
        }
        if (iR == 3) {
            return "HmacSha512";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: ".concat(l11.t(i2)));
    }

    public static RectF O(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i2 = 1; i2 < fArr.length; i2 += 2) {
            float fRound = Math.round(fArr[i2 - 1] * 10.0f) / 10.0f;
            float fRound2 = Math.round(fArr[i2] * 10.0f) / 10.0f;
            float f2 = rectF.left;
            if (fRound < f2) {
                f2 = fRound;
            }
            rectF.left = f2;
            float f3 = rectF.top;
            if (fRound2 < f3) {
                f3 = fRound2;
            }
            rectF.top = f3;
            float f4 = rectF.right;
            if (fRound <= f4) {
                fRound = f4;
            }
            rectF.right = fRound;
            float f5 = rectF.bottom;
            if (fRound2 <= f5) {
                fRound2 = f5;
            }
            rectF.bottom = fRound2;
        }
        rectF.sort();
        return rectF;
    }

    public static ActionMode.Callback P(ActionMode.Callback callback) {
        return (!(callback instanceof f51) || Build.VERSION.SDK_INT < 26) ? callback : ((f51) callback).a;
    }

    public static ActionMode.Callback Q(ActionMode.Callback callback, TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof f51) || callback == null) ? callback : new f51(callback, textView);
    }

    public static int R(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * (-862048943)), 15)) * 461845907);
    }

    public static /* synthetic */ boolean S(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, as1 as1Var, Object obj, Object obj2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(as1Var, obj, obj2)) {
            if (atomicReferenceFieldUpdater.get(as1Var) != obj && atomicReferenceFieldUpdater.get(as1Var) != obj) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:189:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x06a3  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x06b3  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x06c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x06e3 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(defpackage.wn r40, defpackage.rg0 r41, java.util.ArrayList r42, int r43) {
        /*
            Method dump skipped, instruction units count: 1776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xr.a(wn, rg0, java.util.ArrayList, int):void");
    }

    public static void b(ECPoint eCPoint, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        ECField field = ellipticCurve.getField();
        if (!(field instanceof ECFieldFp)) {
            s1.l("Only curves over prime order fields are supported");
            return;
        }
        BigInteger p2 = ((ECFieldFp) field).getP();
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        if (affineX == null || affineY == null) {
            s1.l("point is at infinity");
            return;
        }
        if (affineX.signum() == -1 || affineX.compareTo(p2) != -1) {
            s1.l("x is out of range");
            return;
        }
        if (affineY.signum() == -1 || affineY.compareTo(p2) != -1) {
            s1.l("y is out of range");
        } else {
            if (affineY.multiply(affineY).mod(p2).equals(affineX.multiply(affineX).add(ellipticCurve.getA()).multiply(affineX).add(ellipticCurve.getB()).mod(p2))) {
                return;
            }
            s1.l("Point is not on curve");
        }
    }

    public static float[] c(float[] fArr, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i2, length);
        float[] fArr2 = new float[i2];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    public static boolean d(File file, Resources resources, int i2) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i2);
        } catch (Throwable th) {
            th = th;
            inputStreamOpenRawResource = null;
        }
        try {
            boolean zE = e(file, inputStreamOpenRawResource);
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException unused) {
                }
            }
            return zE;
        } catch (Throwable th2) {
            th = th2;
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean e(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 != -1) {
                    fileOutputStream.write(bArr, 0, i2);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            fileOutputStream.close();
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return true;
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[Catch: NumberFormatException -> 0x00aa, LOOP:3: B:25:0x0068->B:44:0x0096, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.lp0[] f(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xr.f(java.lang.String):lp0[]");
    }

    public static byte[] g(String str) {
        if (str.length() % 2 != 0) {
            zy.n("Expected a string of even length");
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            int iDigit = Character.digit(str.charAt(i3), 16);
            int iDigit2 = Character.digit(str.charAt(i3 + 1), 16);
            if (iDigit == -1 || iDigit2 == -1) {
                zy.n("input is not hexadecimal");
                return null;
            }
            bArr[i2] = (byte) ((iDigit * 16) + iDigit2);
        }
        return bArr;
    }

    public static Bitmap h(String str) {
        try {
            if (str.length() <= 0) {
                return null;
            }
            byte[] bArrDecode = Base64.decode(str.getBytes(), 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String i(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            int i2 = b2 & 255;
            sb.append("0123456789abcdef".charAt(i2 / 16));
            sb.append("0123456789abcdef".charAt(i2 % 16));
        }
        return sb.toString();
    }

    public static String j(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static int k(Context context, int i2, int i3) {
        Integer numValueOf;
        TypedValue typedValueQ = i1.Q(context, i2);
        if (typedValueQ != null) {
            int i4 = typedValueQ.resourceId;
            numValueOf = Integer.valueOf(i4 != 0 ? context.getColor(i4) : typedValueQ.data);
        } else {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : i3;
    }

    public static int l(View view, int i2) {
        Context context = view.getContext();
        TypedValue typedValueV = i1.V(i2, view.getContext(), view.getClass().getCanonicalName());
        int i3 = typedValueV.resourceId;
        return i3 != 0 ? context.getColor(i3) : typedValueV.data;
    }

    public static ECParameterSpec m(int i2) {
        int iR = l11.r(i2);
        if (iR == 0) {
            return r("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
        }
        if (iR == 1) {
            return r("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
        }
        if (iR == 2) {
            return r("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
        }
        throw new NoSuchAlgorithmException("curve not implemented:".concat(i2 != 1 ? i2 != 2 ? i2 != 3 ? "null" : "NIST_P521" : "NIST_P384" : "NIST_P256"));
    }

    public static void n(int i2, byte[] bArr) {
    }

    public static ECPublicKey o(int i2, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpecM = m(i2);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, bArr), new BigInteger(1, bArr2));
        b(eCPoint, eCParameterSpecM.getCurve());
        return (ECPublicKey) ((KeyFactory) jz.i.a("EC")).generatePublic(new ECPublicKeySpec(eCPoint, eCParameterSpecM));
    }

    public static final String p(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static Paint q(int i2, float f2) {
        if (f2 <= 0.0f) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i2);
        paint.setStrokeWidth(f2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    public static ECParameterSpec r(String str, String str2, String str3, String str4, String str5) {
        BigInteger bigInteger = new BigInteger(str);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigInteger), bigInteger.subtract(new BigInteger("3")), new BigInteger(str3, 16)), new ECPoint(new BigInteger(str4, 16), new BigInteger(str5, 16)), new BigInteger(str2), 1);
    }

    public static Intent s(z7 z7Var) {
        Intent parentActivityIntent = z7Var.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String strU = u(z7Var, z7Var.getComponentName());
            if (strU == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(z7Var, strU);
            try {
                return u(z7Var, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strU + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Intent t(z7 z7Var, ComponentName componentName) {
        String strU = u(z7Var, componentName);
        if (strU == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strU);
        return u(z7Var, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String u(Context context, ComponentName componentName) {
        String string;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, Build.VERSION.SDK_INT >= 29 ? 269222528 : 787072);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static void v(Preference preference, ArrayList arrayList) {
        if (!(preference instanceof PreferenceCategory) && !(preference instanceof PreferenceScreen)) {
            arrayList.add(preference);
            return;
        }
        PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
        int size = preferenceGroup.P.size();
        for (int i2 = 0; i2 < size; i2++) {
            v(preferenceGroup.K(i2), arrayList);
        }
    }

    public static File w(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(cacheDir, str + i2);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static wp0 x(AppCompatTextView appCompatTextView) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new wp0(ju.j(appCompatTextView));
        }
        TextPaint textPaint = new TextPaint(appCompatTextView.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = appCompatTextView.getBreakStrategy();
        int hyphenationFrequency = appCompatTextView.getHyphenationFrequency();
        if (appCompatTextView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i2 < 28 || (appCompatTextView.getInputType() & 15) != 3) {
            boolean z = appCompatTextView.getLayoutDirection() == 1;
            switch (appCompatTextView.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(ju.b(DecimalFormatSymbols.getInstance(appCompatTextView.getTextLocale()))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new wp0(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static boolean y(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    public static int z(float f2, int i2, int i3) {
        return wl.d(wl.f(i3, Math.round(Color.alpha(i3) * f2)), i2);
    }
}
