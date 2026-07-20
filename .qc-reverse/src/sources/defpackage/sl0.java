package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class sl0 extends v8 implements Menu {
    public final zk0 c;

    public sl0(Context context, zk0 zk0Var) {
        super(context);
        if (zk0Var != null) {
            this.c = zk0Var;
        } else {
            zy.n("Wrapped Object can not be null.");
            throw null;
        }
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return g(this.c.a(0, 0, 0, charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.c.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = g(menuItemArr2[i5]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.c.addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        t01 t01Var = (t01) this.b;
        if (t01Var != null) {
            t01Var.clear();
        }
        this.c.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.c.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        return g(this.c.findItem(i));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return g(this.c.getItem(i));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.c.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.c.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i2) {
        return this.c.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.c.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        if (((t01) this.b) != null) {
            int i2 = 0;
            while (true) {
                t01 t01Var = (t01) this.b;
                if (i2 >= t01Var.d) {
                    break;
                }
                if (((n31) t01Var.f(i2)).getGroupId() == i) {
                    ((t01) this.b).g(i2);
                    i2--;
                }
                i2++;
            }
        }
        this.c.removeGroup(i);
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        if (((t01) this.b) != null) {
            int i2 = 0;
            while (true) {
                t01 t01Var = (t01) this.b;
                if (i2 >= t01Var.d) {
                    break;
                }
                if (((n31) t01Var.f(i2)).getItemId() == i) {
                    ((t01) this.b).g(i2);
                    break;
                }
                i2++;
            }
        }
        this.c.removeItem(i);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z, boolean z2) {
        this.c.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z) {
        this.c.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z) {
        this.c.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.c.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.c.size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return this.c.addSubMenu(i);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return this.c.addSubMenu(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return this.c.addSubMenu(i, i2, i3, i4);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return g(this.c.add(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return g(this.c.a(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, int i4) {
        return g(this.c.add(i, i2, i3, i4));
    }
}
