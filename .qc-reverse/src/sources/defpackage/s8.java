package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class s8 implements Window.Callback {
    public final Window.Callback b;
    public y61 c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final /* synthetic */ y8 g;

    public s8(y8 y8Var, Window.Callback callback) {
        this.g = y8Var;
        if (callback != null) {
            this.b = callback;
        } else {
            zy.n("Window callback may not be null");
            throw null;
        }
    }

    public final void a(Window.Callback callback) {
        try {
            this.d = true;
            callback.onContentChanged();
        } finally {
            this.d = false;
        }
    }

    public final boolean b(int i, Menu menu) {
        return this.b.onMenuOpened(i, menu);
    }

    public final void c(int i, Menu menu) {
        this.b.onPanelClosed(i, menu);
    }

    public final void d(List list, Menu menu, int i) {
        qh1.a(this.b, list, menu, i);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.b.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = this.e;
        Window.Callback callback = this.b;
        return z ? callback.dispatchKeyEvent(keyEvent) : this.g.u(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (!this.b.dispatchKeyShortcutEvent(keyEvent)) {
            int keyCode = keyEvent.getKeyCode();
            y8 y8Var = this.g;
            y8Var.A();
            j1 j1Var = y8Var.o;
            if (j1Var == null || !j1Var.i(keyCode, keyEvent)) {
                x8 x8Var = y8Var.M;
                if (x8Var == null || !y8Var.F(x8Var, keyEvent.getKeyCode(), keyEvent)) {
                    if (y8Var.M == null) {
                        x8 x8VarZ = y8Var.z(0);
                        y8Var.G(x8VarZ, keyEvent);
                        boolean zF = y8Var.F(x8VarZ, keyEvent.getKeyCode(), keyEvent);
                        x8VarZ.k = false;
                        if (zF) {
                        }
                    }
                    return false;
                }
                x8 x8Var2 = y8Var.M;
                if (x8Var2 != null) {
                    x8Var2.l = true;
                    return true;
                }
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.b.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.b.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.b.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.b.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.b.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.d) {
            this.b.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof zk0)) {
            return this.b.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        y61 y61Var = this.c;
        if (y61Var != null) {
            View view = i == 0 ? new View(y61Var.b.a.a.getContext()) : null;
            if (view != null) {
                return view;
            }
        }
        return this.b.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.b.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.b.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        b(i, menu);
        if (i == 108) {
            y8 y8Var = this.g;
            y8Var.A();
            j1 j1Var = y8Var.o;
            if (j1Var != null) {
                j1Var.c(true);
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (this.f) {
            this.b.onPanelClosed(i, menu);
            return;
        }
        c(i, menu);
        y8 y8Var = this.g;
        if (i == 108) {
            y8Var.A();
            j1 j1Var = y8Var.o;
            if (j1Var != null) {
                j1Var.c(false);
                return;
            }
            return;
        }
        if (i == 0) {
            x8 x8VarZ = y8Var.z(i);
            if (x8VarZ.m) {
                y8Var.s(x8VarZ, false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z) {
        rh1.a(this.b, z);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        zk0 zk0Var = menu instanceof zk0 ? (zk0) menu : null;
        if (i == 0 && zk0Var == null) {
            return false;
        }
        if (zk0Var != null) {
            zk0Var.x = true;
        }
        y61 y61Var = this.c;
        if (y61Var != null && i == 0) {
            z61 z61Var = y61Var.b;
            if (!z61Var.d) {
                z61Var.a.l = true;
                z61Var.d = true;
            }
        }
        boolean zOnPreparePanel = this.b.onPreparePanel(i, view, menu);
        if (zk0Var != null) {
            zk0Var.x = false;
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        zk0 zk0Var = this.g.z(0).h;
        if (zk0Var != null) {
            d(list, zk0Var, i);
        } else {
            d(list, menu, i);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return ph1.a(this.b, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.b.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.b.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        ViewGroup viewGroup;
        y8 y8Var = this.g;
        Context context = y8Var.l;
        if (i != 0) {
            return ph1.b(this.b, callback, i);
        }
        g7 g7Var = new g7();
        g7Var.d = context;
        g7Var.c = callback;
        g7Var.b = new ArrayList();
        g7Var.e = new t01(0);
        e2 e2Var = y8Var.u;
        if (e2Var != null) {
            e2Var.a();
        }
        i9 i9Var = new i9(y8Var, 2, g7Var);
        y8Var.A();
        j1 j1Var = y8Var.o;
        if (j1Var != null) {
            y8Var.u = j1Var.x(i9Var);
        }
        if (y8Var.u == null) {
            ng1 ng1Var = y8Var.y;
            if (ng1Var != null) {
                ng1Var.b();
            }
            e2 e2Var2 = y8Var.u;
            if (e2Var2 != null) {
                e2Var2.a();
            }
            int i2 = 1;
            if (y8Var.v == null) {
                if (y8Var.I) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = context.getTheme();
                    theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = context.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        io ioVar = new io(context, 0);
                        ioVar.getTheme().setTo(themeNewTheme);
                        context = ioVar;
                    }
                    y8Var.v = new ActionBarContextView(context, null);
                    PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    y8Var.w = popupWindow;
                    popupWindow.setWindowLayoutType(2);
                    y8Var.w.setContentView(y8Var.v);
                    y8Var.w.setWidth(-1);
                    context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    y8Var.v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    y8Var.w.setHeight(-2);
                    y8Var.x = new l8(y8Var, i2);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) y8Var.A.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        y8Var.A();
                        j1 j1Var2 = y8Var.o;
                        Context contextE = j1Var2 != null ? j1Var2.e() : null;
                        if (contextE != null) {
                            context = contextE;
                        }
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(context));
                        y8Var.v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (y8Var.v != null) {
                ng1 ng1Var2 = y8Var.y;
                if (ng1Var2 != null) {
                    ng1Var2.b();
                }
                y8Var.v.e();
                Context context2 = y8Var.v.getContext();
                ActionBarContextView actionBarContextView = y8Var.v;
                k21 k21Var = new k21();
                k21Var.d = context2;
                k21Var.e = actionBarContextView;
                k21Var.f = i9Var;
                zk0 zk0Var = new zk0(actionBarContextView.getContext());
                zk0Var.l = 1;
                k21Var.i = zk0Var;
                zk0Var.e = k21Var;
                if (((g7) i9Var.c).t(k21Var, zk0Var)) {
                    k21Var.h();
                    y8Var.v.c(k21Var);
                    y8Var.u = k21Var;
                    boolean z = y8Var.z && (viewGroup = y8Var.A) != null && viewGroup.isLaidOut();
                    ActionBarContextView actionBarContextView2 = y8Var.v;
                    if (z) {
                        actionBarContextView2.setAlpha(0.0f);
                        ng1 ng1VarA = uf1.a(y8Var.v);
                        ng1VarA.a(1.0f);
                        y8Var.y = ng1VarA;
                        ng1VarA.d(new n8(i2, y8Var));
                    } else {
                        actionBarContextView2.setAlpha(1.0f);
                        y8Var.v.setVisibility(0);
                        if (y8Var.v.getParent() instanceof View) {
                            View view = (View) y8Var.v.getParent();
                            WeakHashMap weakHashMap = uf1.a;
                            jf1.c(view);
                        }
                    }
                    if (y8Var.w != null) {
                        y8Var.m.getDecorView().post(y8Var.x);
                    }
                } else {
                    y8Var.u = null;
                }
            }
            y8Var.I();
            y8Var.u = y8Var.u;
        }
        y8Var.I();
        e2 e2Var3 = y8Var.u;
        if (e2Var3 != null) {
            return g7Var.j(e2Var3);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.b.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
