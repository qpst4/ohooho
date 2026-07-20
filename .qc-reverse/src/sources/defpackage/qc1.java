package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class qc1 extends oc1 {
    public final Method A;
    public final Class u;
    public final Constructor v;
    public final Method w;
    public final Method x;
    public final Method y;
    public final Method z;

    public qc1() throws NoSuchMethodException {
        Method methodQ0;
        Constructor<?> constructor;
        Method methodP0;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodP0 = p0(cls2);
            Class cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodQ0 = q0(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            methodQ0 = null;
            constructor = null;
            methodP0 = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.u = cls;
        this.v = constructor;
        this.w = methodP0;
        this.x = method;
        this.y = method2;
        this.z = method3;
        this.A = methodQ0;
    }

    public static Method p0(Class cls) {
        Class cls2 = Boolean.TYPE;
        Class cls3 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls3, cls2, cls3, cls3, cls3, FontVariationAxis[].class);
    }

    @Override // defpackage.oc1, defpackage.i1
    public final Typeface k(Context context, u20 u20Var, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.w;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.k(context, u20Var, resources, i);
        }
        try {
            objNewInstance = this.v.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            v20[] v20VarArr = u20Var.a;
            int length = v20VarArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    v20 v20Var = v20VarArr[i2];
                    String str = v20Var.a;
                    int i3 = v20Var.e;
                    int i4 = v20Var.b;
                    boolean z = v20Var.c;
                    FontVariationAxis[] fontVariationAxisArrFromFontVariationSettings = FontVariationAxis.fromFontVariationSettings(v20Var.d);
                    qc1 qc1Var = this;
                    Context context2 = context;
                    if (qc1Var.m0(context2, objNewInstance, str, i3, i4, z ? 1 : 0, fontVariationAxisArrFromFontVariationSettings)) {
                        i2++;
                        this = qc1Var;
                        context = context2;
                    } else {
                        try {
                            qc1Var.z.invoke(objNewInstance, null);
                            break;
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                } else {
                    qc1 qc1Var2 = this;
                    if (qc1Var2.o0(objNewInstance)) {
                        return qc1Var2.n0(objNewInstance);
                    }
                }
            }
        }
        return null;
    }

    @Override // defpackage.oc1, defpackage.i1
    public final Typeface l(Context context, x20[] x20VarArr, int i) throws IOException {
        Object objNewInstance;
        Typeface typefaceN0;
        boolean zBooleanValue;
        if (x20VarArr.length >= 1) {
            Method method = this.w;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            try {
                if (method != null) {
                    HashMap map = new HashMap();
                    for (x20 x20Var : x20VarArr) {
                        if (x20Var.f == 0) {
                            Uri uri = x20Var.a;
                            if (!map.containsKey(uri)) {
                                map.put(uri, xr.A(context, uri));
                            }
                        }
                    }
                    Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                    try {
                        objNewInstance = this.v.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        objNewInstance = null;
                    }
                    if (objNewInstance != null) {
                        int length = x20VarArr.length;
                        int i2 = 0;
                        boolean z = false;
                        while (true) {
                            Method method2 = this.z;
                            if (i2 < length) {
                                x20 x20Var2 = x20VarArr[i2];
                                ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(x20Var2.a);
                                if (byteBuffer != null) {
                                    try {
                                        zBooleanValue = ((Boolean) this.x.invoke(objNewInstance, byteBuffer, Integer.valueOf(x20Var2.b), null, Integer.valueOf(x20Var2.c), Integer.valueOf(x20Var2.d ? 1 : 0))).booleanValue();
                                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                                        zBooleanValue = false;
                                    }
                                    if (!zBooleanValue) {
                                        method2.invoke(objNewInstance, null);
                                        break;
                                    }
                                    z = true;
                                }
                                i2++;
                                z = z;
                            } else if (!z) {
                                method2.invoke(objNewInstance, null);
                            } else if (o0(objNewInstance) && (typefaceN0 = n0(objNewInstance)) != null) {
                                return Typeface.create(typefaceN0, i);
                            }
                        }
                    }
                } else {
                    x20 x20VarS = i1.s(x20VarArr, i);
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(x20VarS.a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(x20VarS.c).setItalic(x20VarS.d).build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return typefaceBuild;
                        } finally {
                        }
                    }
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return null;
                    }
                }
            } catch (IOException | IllegalAccessException | InvocationTargetException unused3) {
            }
        }
        return null;
    }

    public final boolean m0(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.w.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    @Override // defpackage.i1
    public final Typeface n(Context context, Resources resources, int i, String str, int i2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.w;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.n(context, resources, i, str, i2);
        }
        try {
            objNewInstance = this.v.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            if (!m0(context, objNewInstance, str, 0, -1, -1, null)) {
                try {
                    this.z.invoke(objNewInstance, null);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            } else if (o0(objNewInstance)) {
                return n0(objNewInstance);
            }
        }
        return null;
    }

    public Typeface n0(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.u, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.A.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean o0(Object obj) {
        try {
            return ((Boolean) this.y.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method q0(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
