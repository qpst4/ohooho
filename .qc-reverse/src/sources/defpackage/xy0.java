package defpackage;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.Stream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xy0 {
    public static wy0 a;
    public static long b;
    public static final Object[] c = new Object[0];
    public static final c1 d = new c1("CLOSED_EMPTY", 4);
    public static final int[] e = {R.attr.theme, com.quickcursor.R.attr.theme};
    public static final int[] f = {com.quickcursor.R.attr.materialThemeOverlay};
    public static final Object g = new Object();
    public static Boolean h;
    public static Boolean i;
    public static Boolean j;
    public static Boolean k;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        return -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0078 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int A(int r7, java.lang.CharSequence r8) {
        /*
            int r0 = r8.length()
            r1 = -1
            if (r7 < r0) goto L8
            return r1
        L8:
            char r0 = r8.charAt(r7)
            r2 = 92
            r3 = 60
            if (r0 != r3) goto L39
        L12:
            int r7 = r7 + 1
            int r0 = r8.length()
            if (r7 >= r0) goto L38
            char r0 = r8.charAt(r7)
            r4 = 10
            if (r0 == r4) goto L38
            if (r0 == r3) goto L38
            r4 = 62
            if (r0 == r4) goto L35
            if (r0 == r2) goto L2b
            goto L12
        L2b:
            int r0 = r7 + 1
            boolean r4 = defpackage.i1.D(r0, r8)
            if (r4 == 0) goto L12
            r7 = r0
            goto L12
        L35:
            int r7 = r7 + 1
            return r7
        L38:
            return r1
        L39:
            r0 = 0
            r3 = r7
        L3b:
            int r4 = r8.length()
            if (r3 >= r4) goto L79
            char r4 = r8.charAt(r3)
            if (r4 == 0) goto L75
            r5 = 32
            if (r4 == r5) goto L75
            if (r4 == r2) goto L69
            r6 = 40
            if (r4 == r6) goto L64
            r5 = 41
            if (r4 == r5) goto L5e
            boolean r4 = java.lang.Character.isISOControl(r4)
            if (r4 == 0) goto L72
            if (r3 == r7) goto L78
            goto L77
        L5e:
            if (r0 != 0) goto L61
            goto L77
        L61:
            int r0 = r0 + (-1)
            goto L72
        L64:
            int r0 = r0 + 1
            if (r0 <= r5) goto L72
            goto L78
        L69:
            int r4 = r3 + 1
            boolean r5 = defpackage.i1.D(r4, r8)
            if (r5 == 0) goto L72
            r3 = r4
        L72:
            int r3 = r3 + 1
            goto L3b
        L75:
            if (r3 == r7) goto L78
        L77:
            return r3
        L78:
            return r1
        L79:
            int r7 = r8.length()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xy0.A(int, java.lang.CharSequence):int");
    }

    public static int B(int i2, CharSequence charSequence) {
        while (i2 < charSequence.length()) {
            switch (charSequence.charAt(i2)) {
                case '[':
                    return -1;
                case '\\':
                    int i3 = i2 + 1;
                    if (i1.D(i3, charSequence)) {
                        i2 = i3;
                    }
                    break;
                case ']':
                    return i2;
            }
            i2++;
        }
        return charSequence.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int C(java.lang.CharSequence r3, int r4, char r5) {
        /*
        L0:
            int r0 = r3.length()
            if (r4 >= r0) goto L28
            char r0 = r3.charAt(r4)
            r1 = 92
            if (r0 != r1) goto L18
            int r1 = r4 + 1
            boolean r2 = defpackage.i1.D(r1, r3)
            if (r2 == 0) goto L18
            r4 = r1
            goto L25
        L18:
            if (r0 != r5) goto L1b
            return r4
        L1b:
            r1 = 41
            if (r5 != r1) goto L25
            r1 = 40
            if (r0 != r1) goto L25
            r3 = -1
            return r3
        L25:
            int r4 = r4 + 1
            goto L0
        L28:
            int r3 = r3.length()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xy0.C(java.lang.CharSequence, int, char):int");
    }

    public static void F(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = uf1.a;
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = zHasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    public static wy0 G() {
        synchronized (xy0.class) {
            try {
                wy0 wy0Var = a;
                if (wy0Var == null) {
                    return new wy0();
                }
                a = wy0Var.f;
                wy0Var.f = null;
                b -= 8192;
                return wy0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int H(Context context, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i2});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static final Object[] I(Collection collection) {
        int size = collection.size();
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    objArrCopyOf[i2] = it.next();
                    if (i3 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            i4 = 2147483645;
                            if (i3 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                    } else if (!it.hasNext()) {
                        return Arrays.copyOf(objArrCopyOf, i3);
                    }
                    i2 = i3;
                }
            }
        }
        return c;
    }

    public static final Object[] J(Collection collection, Object[] objArr) {
        Object[] objArrCopyOf;
        int size = collection.size();
        int i2 = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArrCopyOf = objArr;
                } else {
                    Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    objNewInstance.getClass();
                    objArrCopyOf = (Object[]) objNewInstance;
                }
                while (true) {
                    int i3 = i2 + 1;
                    objArrCopyOf[i2] = it.next();
                    if (i3 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            i4 = 2147483645;
                            if (i3 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf != objArr) {
                            return Arrays.copyOf(objArrCopyOf, i3);
                        }
                        objArr[i3] = null;
                        return objArr;
                    }
                    i2 = i3;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }

    public static void K(int i2) throws GeneralSecurityException {
        int i3 = ee1.a;
        int iR = l11.r(i2);
        if (iR == 0) {
            s1.l("SHA1 is not safe for signature");
        } else if (iR == 1 || iR == 2) {
        } else {
            throw new GeneralSecurityException("Unsupported hash ".concat(i2 != 1 ? i2 != 2 ? i2 != 3 ? "null" : "SHA512" : "SHA256" : "SHA1"));
        }
    }

    public static Context L(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f, i2, i3);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        boolean z = (context instanceof io) && ((io) context).a == resourceId;
        if (resourceId == 0 || z) {
            return context;
        }
        io ioVar = new io(context, resourceId);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, e);
        int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = typedArrayObtainStyledAttributes2.getResourceId(1, 0);
        typedArrayObtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            ioVar.getTheme().applyStyle(resourceId2, true);
        }
        return ioVar;
    }

    public static void M(ByteArrayOutputStream byteArrayOutputStream, long j2, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((j2 >> (i3 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void N(ByteArrayOutputStream byteArrayOutputStream, int i2) throws IOException {
        M(byteArrayOutputStream, i2, 2);
    }

    public static /* synthetic */ boolean O(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, on1 on1Var, Object obj, Object obj2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(on1Var, obj, obj2)) {
            if (atomicReferenceFieldUpdater.get(on1Var) != obj && atomicReferenceFieldUpdater.get(on1Var) != obj) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(View view, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        view.getLocationOnScreen(iArr);
        view.getWindowVisibleDisplayFrame(rect);
        Context context = view.getContext();
        int width = view.getWidth();
        int height = view.getHeight();
        int i2 = (width / 2) + iArr[0];
        int i3 = context.getResources().getDisplayMetrics().widthPixels;
        int i4 = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        Toast toastMakeText = Toast.makeText(context, charSequence, 0);
        int i5 = iArr[1];
        int i6 = rect.top;
        if (i5 < i4) {
            toastMakeText.setGravity(49, i2 - (i3 / 2), (i5 - i6) + height);
        } else {
            toastMakeText.setGravity(49, i2 - (i3 / 2), (i5 - i6) - i4);
        }
        toastMakeText.show();
        return true;
    }

    public static void b(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static void c(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            zy.k("Must be called on ", handler.getLooper().getThread().getName(), " thread, but got ", looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper", ".");
        }
    }

    public static void d(Object obj) {
        if (obj != null) {
            return;
        }
        zy.r("null reference");
    }

    public static void e(String str, Object obj) {
        if (obj != null) {
            return;
        }
        zy.r(str);
    }

    public static int f(Context context, String str) {
        if (str != null) {
            return (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : new dn0(context).a.areNotificationsEnabled() ? 0 : -1;
        }
        zy.r("permission must be non-null");
        return 0;
    }

    public static byte[] g(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static int h(mu0 mu0Var, px pxVar, View view, View view2, zt0 zt0Var, boolean z) {
        if (zt0Var.v() == 0 || mu0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(zt0.L(view) - zt0.L(view2)) + 1;
        }
        return Math.min(pxVar.l(), pxVar.b(view2) - pxVar.e(view));
    }

    public static int i(mu0 mu0Var, px pxVar, View view, View view2, zt0 zt0Var, boolean z, boolean z2) {
        if (zt0Var.v() == 0 || mu0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (mu0Var.b() - Math.max(zt0.L(view), zt0.L(view2))) - 1) : Math.max(0, Math.min(zt0.L(view), zt0.L(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(pxVar.b(view2) - pxVar.e(view)) / (Math.abs(zt0.L(view) - zt0.L(view2)) + 1))) + (pxVar.k() - pxVar.e(view)));
        }
        return iMax;
    }

    public static int j(mu0 mu0Var, px pxVar, View view, View view2, zt0 zt0Var, boolean z) {
        if (zt0Var.v() == 0 || mu0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return mu0Var.b();
        }
        return (int) (((pxVar.b(view2) - pxVar.e(view)) / (Math.abs(zt0.L(view) - zt0.L(view2)) + 1)) * mu0Var.b());
    }

    public static boolean k(ArrayList arrayList, List list) {
        Stream stream = arrayList.stream();
        Objects.requireNonNull(list);
        return stream.anyMatch(new kv(1, list));
    }

    public static ImageView.ScaleType l(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 5 ? i2 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static final long m(InputStream inputStream, FileOutputStream fileOutputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = inputStream.read(bArr);
        long j2 = 0;
        while (i3 >= 0) {
            fileOutputStream.write(bArr, 0, i3);
            j2 += (long) i3;
            i3 = inputStream.read(bArr);
        }
        return j2;
    }

    public static double n(float f2, float f3, float f4, float f5) {
        return Math.hypot(f2 - f3, f4 - f5);
    }

    public static boolean o(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        if (r5.c == r8.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList p(android.content.Context r8, int r9) {
        /*
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.Resources$Theme r8 = r8.getTheme()
            dw0 r1 = new dw0
            r1.<init>(r0, r8)
            java.lang.Object r2 = defpackage.ew0.c
            monitor-enter(r2)
            java.util.WeakHashMap r3 = defpackage.ew0.b     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            if (r3 == 0) goto L50
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L3c
            if (r5 <= 0) goto L50
            java.lang.Object r5 = r3.get(r9)     // Catch: java.lang.Throwable -> L3c
            cw0 r5 = (defpackage.cw0) r5     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L50
            android.content.res.Configuration r6 = r5.b     // Catch: java.lang.Throwable -> L3c
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L4d
            if (r8 != 0) goto L3f
            int r6 = r5.c     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L49
            goto L3f
        L3c:
            r8 = move-exception
            goto Lb8
        L3f:
            if (r8 == 0) goto L4d
            int r6 = r5.c     // Catch: java.lang.Throwable -> L3c
            int r7 = r8.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r6 != r7) goto L4d
        L49:
            android.content.res.ColorStateList r3 = r5.a     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            goto L52
        L4d:
            r3.remove(r9)     // Catch: java.lang.Throwable -> L3c
        L50:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            r3 = r4
        L52:
            if (r3 == 0) goto L55
            return r3
        L55:
            java.lang.ThreadLocal r2 = defpackage.ew0.a
            java.lang.Object r3 = r2.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L67
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L67:
            r2 = 1
            r0.getValue(r9, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L76
            r3 = 31
            if (r2 > r3) goto L76
            goto L87
        L76:
            android.content.res.XmlResourceParser r2 = r0.getXml(r9)
            android.content.res.ColorStateList r4 = defpackage.vl.a(r0, r2, r8)     // Catch: java.lang.Exception -> L7f
            goto L87
        L7f:
            r2 = move-exception
            java.lang.String r3 = "ResourcesCompat"
            java.lang.String r5 = "Failed to inflate ColorStateList, leaving it to the framework"
            android.util.Log.w(r3, r5, r2)
        L87:
            if (r4 == 0) goto Lb3
            java.lang.Object r2 = defpackage.ew0.c
            monitor-enter(r2)
            java.util.WeakHashMap r0 = defpackage.ew0.b     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L9f
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L9f
            if (r3 != 0) goto La1
            android.util.SparseArray r3 = new android.util.SparseArray     // Catch: java.lang.Throwable -> L9f
            r3.<init>()     // Catch: java.lang.Throwable -> L9f
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L9f
            goto La1
        L9f:
            r8 = move-exception
            goto Lb1
        La1:
            cw0 r0 = new cw0     // Catch: java.lang.Throwable -> L9f
            android.content.res.Resources r1 = r1.a     // Catch: java.lang.Throwable -> L9f
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch: java.lang.Throwable -> L9f
            r0.<init>(r4, r1, r8)     // Catch: java.lang.Throwable -> L9f
            r3.append(r9, r0)     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            goto Lb7
        Lb1:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            throw r8
        Lb3:
            android.content.res.ColorStateList r4 = r0.getColorStateList(r9, r8)
        Lb7:
            return r4
        Lb8:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xy0.p(android.content.Context, int):android.content.res.ColorStateList");
    }

    public static Integer q(int i2, Object obj) {
        try {
            return obj instanceof Double ? Integer.valueOf(((Double) obj).intValue()) : obj instanceof Float ? Integer.valueOf(((Float) obj).intValue()) : Integer.valueOf(Integer.parseInt(obj.toString()));
        } catch (Exception unused) {
            return Integer.valueOf(i2);
        }
    }

    public static final int r(mb mbVar, Object obj, int i2) {
        int i3 = mbVar.d;
        if (i3 == 0) {
            return -1;
        }
        try {
            int iE = f01.e(i3, i2, mbVar.b);
            if (iE < 0 || fc0.b(obj, mbVar.c[iE])) {
                return iE;
            }
            int i4 = iE + 1;
            while (i4 < i3 && mbVar.b[i4] == i2) {
                if (fc0.b(obj, mbVar.c[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = iE - 1; i5 >= 0 && mbVar.b[i5] == i2; i5--) {
                if (fc0.b(obj, mbVar.c[i5])) {
                    return i5;
                }
            }
            return ~i4;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static boolean s(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (h == null) {
            h = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        h.booleanValue();
        if (i == null) {
            i = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (!i.booleanValue()) {
            return false;
        }
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 26 || i2 >= 30;
    }

    public static ep t(cp cpVar, ep epVar) {
        epVar.getClass();
        return tk0.y(cpVar, epVar);
    }

    public static byte[] u(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i3, i2 - i3);
            if (i4 < 0) {
                s1.f(qq0.i("Not enough bytes to read: ", i2));
                return null;
            }
            i3 += i4;
        }
        return bArr;
    }

    public static byte[] v(FileInputStream fileInputStream, int i2, int i3) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i3];
            byte[] bArr2 = new byte[2048];
            int i4 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i4 < i2) {
                int i5 = fileInputStream.read(bArr2);
                if (i5 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i2 + " bytes");
                }
                inflater.setInput(bArr2, 0, i5);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i3 - iInflate);
                    i4 += i5;
                } catch (DataFormatException e2) {
                    throw new IllegalStateException(e2.getMessage());
                }
            }
            if (i4 == i2) {
                if (inflater.finished()) {
                    return bArr;
                }
                throw new IllegalStateException("Inflater did not finish");
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i2 + " actual=" + i4);
        } finally {
            inflater.end();
        }
    }

    public static long w(InputStream inputStream, int i2) throws IOException {
        byte[] bArrU = u(inputStream, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 += ((long) (bArrU[i3] & 255)) << (i3 * 8);
        }
        return j2;
    }

    public static void x(wy0 wy0Var) {
        if (wy0Var.f != null || wy0Var.g != null) {
            throw new IllegalArgumentException();
        }
        if (wy0Var.d) {
            return;
        }
        synchronized (xy0.class) {
            try {
                long j2 = b + 8192;
                if (j2 > 65536) {
                    return;
                }
                b = j2;
                wy0Var.f = a;
                wy0Var.c = 0;
                wy0Var.b = 0;
                a = wy0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void y(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static void z(Activity activity, String[] strArr, int i2) {
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (TextUtils.isEmpty(strArr[i3])) {
                zy.n(l11.k(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
                return;
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i3], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i3));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < strArr.length; i5++) {
                if (!hashSet.contains(Integer.valueOf(i5))) {
                    strArr2[i4] = strArr[i5];
                    i4++;
                }
            }
        }
        activity.requestPermissions(strArr, i2);
    }

    public abstract void E(boolean z);

    public void D(boolean z) {
    }
}
