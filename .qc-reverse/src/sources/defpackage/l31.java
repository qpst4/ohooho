package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l31 {
    public CharSequence A;
    public CharSequence B;
    public final /* synthetic */ m31 E;
    public final Menu a;
    public boolean h;
    public int i;
    public int j;
    public CharSequence k;
    public CharSequence l;
    public int m;
    public char n;
    public int o;
    public char p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public String x;
    public String y;
    public dl0 z;
    public ColorStateList C = null;
    public PorterDuff.Mode D = null;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public boolean f = true;
    public boolean g = true;

    public l31(m31 m31Var, Menu menu) {
        this.E = m31Var;
        this.a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        m31 m31Var = this.E;
        Context context = m31Var.c;
        boolean z = false;
        menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
        int i = this.v;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        if (this.y != null) {
            if (context.isRestricted()) {
                s1.f("The android:onClick attribute cannot be used within a restricted context");
                return;
            }
            if (m31Var.d == null) {
                m31Var.d = m31.a(context);
            }
            Object obj = m31Var.d;
            String str = this.y;
            k31 k31Var = new k31();
            k31Var.c = obj;
            Class<?> cls = obj.getClass();
            try {
                k31Var.d = cls.getMethod(str, k31.e);
                menuItem.setOnMenuItemClickListener(k31Var);
            } catch (Exception e) {
                StringBuilder sbM = l11.m("Couldn't resolve menu item onClick handler ", str, " in class ");
                sbM.append(cls.getName());
                InflateException inflateException = new InflateException(sbM.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }
        if (this.r >= 2) {
            if (menuItem instanceof cl0) {
                cl0 cl0Var = (cl0) menuItem;
                cl0Var.x = (cl0Var.x & (-5)) | 4;
            } else if (menuItem instanceof gl0) {
                gl0 gl0Var = (gl0) menuItem;
                n31 n31Var = gl0Var.c;
                try {
                    if (gl0Var.d == null) {
                        gl0Var.d = n31Var.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    gl0Var.d.invoke(n31Var, Boolean.TRUE);
                } catch (Exception e2) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
                }
            }
        }
        String str2 = this.x;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, m31.e, m31Var.a));
            z = true;
        }
        int i2 = this.w;
        if (i2 > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i2);
            }
        }
        dl0 dl0Var = this.z;
        if (dl0Var != null) {
            if (menuItem instanceof n31) {
                ((n31) menuItem).a(dl0Var);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.A;
        boolean z2 = menuItem instanceof n31;
        if (z2) {
            ((n31) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            pa0.g(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z2) {
            ((n31) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            pa0.o(menuItem, charSequence2);
        }
        char c = this.n;
        int i3 = this.o;
        if (z2) {
            ((n31) menuItem).setAlphabeticShortcut(c, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            pa0.e(menuItem, c, i3);
        }
        char c2 = this.p;
        int i4 = this.q;
        if (z2) {
            ((n31) menuItem).setNumericShortcut(c2, i4);
        } else if (Build.VERSION.SDK_INT >= 26) {
            pa0.k(menuItem, c2, i4);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z2) {
                ((n31) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                pa0.j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            if (z2) {
                ((n31) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                pa0.i(menuItem, colorStateList);
            }
        }
    }
}
