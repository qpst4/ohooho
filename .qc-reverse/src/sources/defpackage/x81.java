package defpackage;

import android.view.ViewGroup;
import com.quickcursor.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x81 {
    public static final rc a = new rc();
    public static final ThreadLocal b = new ThreadLocal();
    public static final ArrayList c = new ArrayList();

    public static void a(ViewGroup viewGroup, t81 t81Var) {
        ArrayList arrayList = c;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        arrayList.add(viewGroup);
        if (t81Var == null) {
            t81Var = a;
        }
        t81 t81VarClone = t81Var.clone();
        ArrayList arrayList2 = (ArrayList) b().get(viewGroup);
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((t81) obj).w(viewGroup);
            }
        }
        t81VarClone.h(viewGroup, true);
        if (viewGroup.getTag(R.id.transition_current_scene) != null) {
            s1.d();
            return;
        }
        viewGroup.setTag(R.id.transition_current_scene, null);
        w81 w81Var = new w81();
        w81Var.b = t81VarClone;
        w81Var.c = viewGroup;
        viewGroup.addOnAttachStateChangeListener(w81Var);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(w81Var);
    }

    public static kb b() {
        kb kbVar;
        ThreadLocal threadLocal = b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (kbVar = (kb) weakReference.get()) != null) {
            return kbVar;
        }
        kb kbVar2 = new kb(0);
        threadLocal.set(new WeakReference(kbVar2));
        return kbVar2;
    }
}
