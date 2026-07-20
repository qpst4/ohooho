package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mk {
    public final HashMap a = new HashMap();
    public final HashMap b;

    public mk(HashMap map) {
        this.b = map;
        for (Map.Entry entry : map.entrySet()) {
            yf0 yf0Var = (yf0) entry.getValue();
            List arrayList = (List) this.a.get(yf0Var);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.a.put(yf0Var, arrayList);
            }
            arrayList.add((nk) entry.getKey());
        }
    }

    public static void a(List list, gg0 gg0Var, yf0 yf0Var, fg0 fg0Var) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                nk nkVar = (nk) list.get(size);
                Method method = nkVar.b;
                try {
                    int i = nkVar.a;
                    if (i == 0) {
                        method.invoke(fg0Var, null);
                    } else if (i == 1) {
                        method.invoke(fg0Var, gg0Var);
                    } else if (i == 2) {
                        method.invoke(fg0Var, gg0Var, yf0Var);
                    }
                } catch (IllegalAccessException e) {
                    zy.m(e);
                    return;
                } catch (InvocationTargetException e2) {
                    zy.l("Failed to call observer method", e2.getCause());
                    return;
                }
            }
        }
    }
}
