package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class oc1 extends i1 {
    public static Class p = null;
    public static Constructor q = null;
    public static Method r = null;
    public static Method s = null;
    public static boolean t = false;

    public static boolean k0(Object obj, String str, int i, boolean z) throws NoSuchMethodException {
        l0();
        try {
            return ((Boolean) r.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            zy.m(e);
            return false;
        }
    }

    public static void l0() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (t) {
            return;
        }
        t = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        q = constructor;
        p = cls;
        r = method2;
        s = method;
    }

    @Override // defpackage.i1
    public Typeface k(Context context, u20 u20Var, Resources resources, int i) throws NoSuchMethodException {
        l0();
        try {
            Object objNewInstance = q.newInstance(null);
            for (v20 v20Var : u20Var.a) {
                File fileW = xr.w(context);
                if (fileW == null) {
                    return null;
                }
                try {
                    if (!xr.d(fileW, resources, v20Var.f)) {
                        return null;
                    }
                    if (!k0(objNewInstance, fileW.getPath(), v20Var.b, v20Var.c)) {
                        return null;
                    }
                    fileW.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    fileW.delete();
                }
            }
            l0();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) p, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) s.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                zy.m(e);
                return null;
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            zy.m(e2);
            return null;
        }
    }

    @Override // defpackage.i1
    public Typeface l(Context context, x20[] x20VarArr, int i) {
        Typeface typefaceCreateFromFile;
        String str;
        if (x20VarArr.length >= 1) {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(i1.s(x20VarArr, i).a, "r", null);
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        try {
                            str = Os.readlink("/proc/self/fd/" + parcelFileDescriptorOpenFileDescriptor.getFd());
                        } finally {
                        }
                    } catch (ErrnoException unused) {
                    }
                    File file = OsConstants.S_ISREG(Os.stat(str).st_mode) ? new File(str) : null;
                    if (file != null && file.canRead()) {
                        Typeface typefaceCreateFromFile2 = Typeface.createFromFile(file);
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return typefaceCreateFromFile2;
                    }
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        File fileW = xr.w(context);
                        if (fileW == null) {
                            typefaceCreateFromFile = null;
                        } else {
                            try {
                                if (xr.e(fileW, fileInputStream)) {
                                    typefaceCreateFromFile = Typeface.createFromFile(fileW.getPath());
                                    fileW.delete();
                                }
                            } catch (RuntimeException unused2) {
                            } catch (Throwable th) {
                                fileW.delete();
                                throw th;
                            }
                            fileW.delete();
                            typefaceCreateFromFile = null;
                        }
                        fileInputStream.close();
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return typefaceCreateFromFile;
                    } finally {
                    }
                }
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return null;
                }
            } catch (IOException unused3) {
            }
        }
        return null;
    }
}
