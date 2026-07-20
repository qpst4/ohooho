package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ue1 {
    public final kb a;
    public final kb b;
    public final kb c;

    public ue1(kb kbVar, kb kbVar2, kb kbVar3) {
        this.a = kbVar;
        this.b = kbVar2;
        this.c = kbVar3;
    }

    public abstract ve1 a();

    public final Class b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        kb kbVar = this.c;
        Class cls2 = (Class) kbVar.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        kbVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException {
        kb kbVar = this.a;
        Method method = (Method) kbVar.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, ue1.class.getClassLoader()).getDeclaredMethod("read", ue1.class);
        kbVar.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        kb kbVar = this.b;
        Method method = (Method) kbVar.get(name);
        if (method != null) {
            return method;
        }
        Class clsB = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, ue1.class);
        kbVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i);

    public final int f(int i, int i2) {
        return !e(i2) ? i : ((ve1) this).e.readInt();
    }

    public final Parcelable g(Parcelable parcelable, int i) {
        if (!e(i)) {
            return parcelable;
        }
        return ((ve1) this).e.readParcelable(ve1.class.getClassLoader());
    }

    public final we1 h() {
        String string = ((ve1) this).e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (we1) c(string).invoke(null, a());
        } catch (ClassNotFoundException e) {
            zy.l("VersionedParcel encountered ClassNotFoundException", e);
            return null;
        } catch (IllegalAccessException e2) {
            zy.l("VersionedParcel encountered IllegalAccessException", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            zy.l("VersionedParcel encountered NoSuchMethodException", e3);
            return null;
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            zy.l("VersionedParcel encountered InvocationTargetException", e4);
            return null;
        }
    }

    public abstract void i(int i);

    public final void j(int i, int i2) {
        i(i2);
        ((ve1) this).e.writeInt(i);
    }

    public final void k(we1 we1Var) {
        if (we1Var == null) {
            ((ve1) this).e.writeString(null);
            return;
        }
        try {
            ((ve1) this).e.writeString(b(we1Var.getClass()).getName());
            ve1 ve1VarA = a();
            try {
                d(we1Var.getClass()).invoke(null, we1Var, ve1VarA);
                Parcel parcel = ve1VarA.e;
                int i = ve1VarA.i;
                if (i >= 0) {
                    int i2 = ve1VarA.d.get(i);
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i2);
                    parcel.writeInt(iDataPosition - i2);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e) {
                zy.l("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                zy.l("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                zy.l("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (e4.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e4.getCause());
                }
                zy.l("VersionedParcel encountered InvocationTargetException", e4);
            }
        } catch (ClassNotFoundException e5) {
            zy.l(we1Var.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
