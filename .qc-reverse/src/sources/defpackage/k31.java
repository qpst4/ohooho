package defpackage;

import android.view.MenuItem;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class k31 implements MenuItem.OnMenuItemClickListener {
    public static final Class[] e = {MenuItem.class};
    public final /* synthetic */ int b = 0;
    public Object c;
    public Object d;

    public k31(gl0 gl0Var, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.d = gl0Var;
        this.c = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        boolean zBooleanValue;
        switch (this.b) {
            case 0:
                Object obj = this.c;
                Method method = (Method) this.d;
                try {
                    if (method.getReturnType() == Boolean.TYPE) {
                        zBooleanValue = ((Boolean) method.invoke(obj, menuItem)).booleanValue();
                    } else {
                        method.invoke(obj, menuItem);
                        zBooleanValue = true;
                    }
                    return zBooleanValue;
                } catch (Exception e2) {
                    zy.m(e2);
                    return false;
                }
            default:
                return ((MenuItem.OnMenuItemClickListener) this.c).onMenuItemClick(((gl0) this.d).g(menuItem));
        }
    }

    public /* synthetic */ k31() {
    }
}
