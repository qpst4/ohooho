package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pc1 extends i1 {
    public static final Class p;
    public static final Constructor q;
    public static final Method r;
    public static final Method s;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        q = constructor;
        p = cls;
        r = method2;
        s = method;
    }

    public static boolean k0(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) r.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface l0(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) p, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) s.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // defpackage.i1
    public final Typeface k(Context context, u20 u20Var, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        MappedByteBuffer map;
        FileInputStream fileInputStream;
        try {
            objNewInstance = q.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            for (v20 v20Var : u20Var.a) {
                int i2 = v20Var.f;
                File fileW = xr.w(context);
                if (fileW != null) {
                    try {
                        if (xr.d(fileW, resources, i2)) {
                            try {
                                fileInputStream = new FileInputStream(fileW);
                            } catch (IOException unused2) {
                                map = null;
                            }
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                if (map != null && k0(objNewInstance, map, v20Var.e, v20Var.b, v20Var.c)) {
                                }
                            } finally {
                            }
                        }
                    } finally {
                        fileW.delete();
                    }
                }
                map = null;
                if (map != null) {
                }
            }
            return l0(objNewInstance);
        }
        return null;
    }

    @Override // defpackage.i1
    public final Typeface l(Context context, x20[] x20VarArr, int i) {
        Object objNewInstance;
        try {
            objNewInstance = q.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            int i2 = 0;
            t01 t01Var = new t01(0);
            int length = x20VarArr.length;
            while (true) {
                if (i2 < length) {
                    x20 x20Var = x20VarArr[i2];
                    Uri uri = x20Var.a;
                    ByteBuffer byteBufferA = (ByteBuffer) t01Var.get(uri);
                    if (byteBufferA == null) {
                        byteBufferA = xr.A(context, uri);
                        t01Var.put(uri, byteBufferA);
                    }
                    if (byteBufferA == null || !k0(objNewInstance, byteBufferA, x20Var.b, x20Var.c, x20Var.d)) {
                        break;
                    }
                    i2++;
                } else {
                    Typeface typefaceL0 = l0(objNewInstance);
                    if (typefaceL0 != null) {
                        return Typeface.create(typefaceL0, i);
                    }
                }
            }
        }
        return null;
    }
}
