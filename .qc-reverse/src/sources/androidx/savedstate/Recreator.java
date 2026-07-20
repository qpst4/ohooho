package androidx.savedstate;

import android.os.Bundle;
import defpackage.bg1;
import defpackage.dg0;
import defpackage.e8;
import defpackage.eg1;
import defpackage.fg1;
import defpackage.gg0;
import defpackage.l11;
import defpackage.ox0;
import defpackage.rx0;
import defpackage.s1;
import defpackage.tk0;
import defpackage.yf0;
import defpackage.zy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements dg0 {
    public final rx0 b;

    public Recreator(rx0 rx0Var) {
        this.b = rx0Var;
    }

    @Override // defpackage.dg0
    public final void c(gg0 gg0Var, yf0 yf0Var) {
        if (yf0Var != yf0.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        gg0Var.p().f(this);
        rx0 rx0Var = this.b;
        Bundle bundleC = rx0Var.c().c("androidx.savedstate.Restarter");
        if (bundleC == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleC.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            s1.f("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            return;
        }
        int size = stringArrayList.size();
        int i = 0;
        while (i < size) {
            String str = stringArrayList.get(i);
            i++;
            String str2 = str;
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str2, false, Recreator.class.getClassLoader()).asSubclass(ox0.class);
                clsAsSubclass.getClass();
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(null);
                        objNewInstance.getClass();
                        if (!(rx0Var instanceof fg1)) {
                            s1.f("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                            return;
                        }
                        eg1 eg1VarM = ((fg1) rx0Var).m();
                        e8 e8VarC = rx0Var.c();
                        eg1VarM.getClass();
                        LinkedHashMap linkedHashMap = eg1VarM.a;
                        for (String str3 : new HashSet(linkedHashMap.keySet())) {
                            str3.getClass();
                            bg1 bg1Var = (bg1) linkedHashMap.get(str3);
                            bg1Var.getClass();
                            tk0.a(bg1Var, e8VarC, rx0Var.p());
                        }
                        if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                            e8VarC.f();
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to instantiate " + str2, e);
                    }
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                }
            } catch (ClassNotFoundException e3) {
                zy.l(l11.j("Class ", str2, " wasn't found"), e3);
                return;
            }
        }
    }
}
