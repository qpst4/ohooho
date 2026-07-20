package defpackage;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.a;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z7 extends pm implements b8 {
    public boolean w;
    public boolean x;
    public y8 z;
    public final sp1 u = new sp1(24, new l30(this));
    public final a v = new a(this);
    public boolean y = true;

    public z7() {
        ((e8) this.e.c).e("android:support:lifecycle", new fm(1, this));
        final int i = 0;
        this.k.add(new ao(this) { // from class: k30
            public final /* synthetic */ z7 b;

            {
                this.b = this;
            }

            @Override // defpackage.ao
            public final void accept(Object obj) {
                int i2 = i;
                z7 z7Var = this.b;
                switch (i2) {
                    case 0:
                        z7Var.u.w();
                        break;
                    default:
                        z7Var.u.w();
                        break;
                }
            }
        });
        final int i2 = 1;
        this.m.add(new ao(this) { // from class: k30
            public final /* synthetic */ z7 b;

            {
                this.b = this;
            }

            @Override // defpackage.ao
            public final void accept(Object obj) {
                int i22 = i2;
                z7 z7Var = this.b;
                switch (i22) {
                    case 0:
                        z7Var.u.w();
                        break;
                    default:
                        z7Var.u.w();
                        break;
                }
            }
        });
        q(new gm(this, 1));
        ((e8) this.e.c).e("androidx:appcompat", new x7(this));
        q(new y7(this));
    }

    public static boolean x(y30 y30Var) {
        boolean zX = false;
        for (j30 j30Var : y30Var.c.m()) {
            if (j30Var != null) {
                l30 l30Var = j30Var.u;
                if ((l30Var == null ? null : l30Var.q) != null) {
                    zX |= x(j30Var.l());
                }
                i40 i40Var = j30Var.R;
                zf0 zf0Var = zf0.d;
                zf0 zf0Var2 = zf0.e;
                if (i40Var != null) {
                    i40Var.b();
                    if (i40Var.d.c.compareTo(zf0Var2) >= 0) {
                        a aVar = j30Var.R.d;
                        aVar.c("setCurrentState");
                        aVar.e(zf0Var);
                        zX = true;
                    }
                }
                if (j30Var.Q.c.compareTo(zf0Var2) >= 0) {
                    a aVar2 = j30Var.Q;
                    aVar2.c("setCurrentState");
                    aVar2.e(zf0Var);
                    zX = true;
                }
            }
        }
        return zX;
    }

    public final void A() {
        super.onPostResume();
        this.v.d(yf0.ON_RESUME);
        y30 y30Var = ((l30) this.u.c).p;
        y30Var.E = false;
        y30Var.F = false;
        y30Var.L.h = false;
        y30Var.u(7);
    }

    public final void B() {
        sp1 sp1Var = this.u;
        sp1Var.w();
        l30 l30Var = (l30) sp1Var.c;
        super.onStart();
        this.y = false;
        if (!this.w) {
            this.w = true;
            y30 y30Var = l30Var.p;
            y30Var.E = false;
            y30Var.F = false;
            y30Var.L.h = false;
            y30Var.u(4);
        }
        l30Var.p.z(true);
        this.v.d(yf0.ON_START);
        y30 y30Var2 = l30Var.p;
        y30Var2.E = false;
        y30Var2.F = false;
        y30Var2.L.h = false;
        y30Var2.u(5);
    }

    public final void C() {
        super.onStop();
        this.y = true;
        while (x(w())) {
        }
        y30 y30Var = ((l30) this.u.c).p;
        y30Var.F = true;
        y30Var.L.h = true;
        y30Var.u(4);
        this.v.d(yf0.ON_STOP);
    }

    public final void D(Toolbar toolbar) {
        y8 y8Var = (y8) u();
        if (y8Var.k instanceof Activity) {
            y8Var.A();
            j1 j1Var = y8Var.o;
            if (j1Var instanceof vh1) {
                s1.f("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
                return;
            }
            y8Var.p = null;
            if (j1Var != null) {
                j1Var.h();
            }
            y8Var.o = null;
            if (toolbar != null) {
                Object obj = y8Var.k;
                z61 z61Var = new z61(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : y8Var.q, y8Var.n);
                y8Var.o = z61Var;
                y8Var.n.c = z61Var.c;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                y8Var.n.c = null;
            }
            y8Var.b();
        }
    }

    @Override // defpackage.pm, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        y8 y8Var = (y8) u();
        y8Var.w();
        ((ViewGroup) y8Var.A.findViewById(R.id.content)).addView(view, layoutParams);
        y8Var.n.a(y8Var.m.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:167:0x0231 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00aa  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void attachBaseContext(android.content.Context r10) {
        /*
            Method dump skipped, instruction units count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z7.attachBaseContext(android.content.Context):void");
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        j1 j1VarV = v();
        if (getWindow().hasFeature(0)) {
            if (j1VarV == null || !j1VarV.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // defpackage.om, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        j1 j1VarV = v();
        if (keyCode == 82 && j1VarV != null && j1VarV.j(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0046  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dump(java.lang.String r7, java.io.FileDescriptor r8, java.io.PrintWriter r9, java.lang.String[] r10) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z7.dump(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    @Override // android.app.Activity
    public final View findViewById(int i) {
        y8 y8Var = (y8) u();
        y8Var.w();
        return y8Var.m.findViewById(i);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        y8 y8Var = (y8) u();
        if (y8Var.p == null) {
            y8Var.A();
            j1 j1Var = y8Var.o;
            y8Var.p = new m31(j1Var != null ? j1Var.e() : y8Var.l);
        }
        return y8Var.p;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        int i = re1.a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        u().b();
    }

    @Override // defpackage.pm, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.u.w();
        super.onActivityResult(i, i2, intent);
    }

    @Override // defpackage.pm, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        y8 y8Var = (y8) u();
        if (y8Var.F && y8Var.z) {
            y8Var.A();
            j1 j1Var = y8Var.o;
            if (j1Var != null) {
                j1Var.g();
            }
        }
        b9 b9VarA = b9.a();
        Context context = y8Var.l;
        synchronized (b9VarA) {
            bw0 bw0Var = b9VarA.a;
            synchronized (bw0Var) {
                vi0 vi0Var = (vi0) bw0Var.b.get(context);
                if (vi0Var != null) {
                    vi0Var.a();
                }
            }
        }
        y8Var.R = new Configuration(y8Var.l.getResources().getConfiguration());
        y8Var.m(false, false);
    }

    @Override // defpackage.pm, defpackage.om, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.v.d(yf0.ON_CREATE);
        ((l30) this.u.c).p.j();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((l30) this.u.c).p.f.onCreateView(null, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        y();
        u().f();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // defpackage.pm, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Intent intentS;
        if (!z(i, menuItem)) {
            j1 j1VarV = v();
            if (menuItem.getItemId() != 16908332 || j1VarV == null || (j1VarV.d() & 4) == 0 || (intentS = xr.s(this)) == null) {
                return false;
            }
            if (!shouldUpRecreateTask(intentS)) {
                navigateUpTo(intentS);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            Intent intentS2 = xr.s(this);
            if (intentS2 == null) {
                intentS2 = xr.s(this);
            }
            if (intentS2 != null) {
                ComponentName component = intentS2.getComponent();
                if (component == null) {
                    component = intentS2.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent intentT = xr.t(this, component);
                    while (intentT != null) {
                        arrayList.add(size, intentT);
                        intentT = xr.t(this, intentT.getComponent());
                    }
                    arrayList.add(intentS2);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e);
                }
            }
            if (arrayList.isEmpty()) {
                s1.f("No intents added to TaskStackBuilder; cannot startActivities");
                return false;
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            startActivities(intentArr, null);
            try {
                finishAffinity();
            } catch (IllegalStateException unused) {
                finish();
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.x = false;
        ((l30) this.u.c).p.u(5);
        this.v.d(yf0.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((y8) u()).w();
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        A();
        y8 y8Var = (y8) u();
        y8Var.A();
        j1 j1Var = y8Var.o;
        if (j1Var != null) {
            j1Var.s(true);
        }
    }

    @Override // defpackage.pm, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.u.w();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        sp1 sp1Var = this.u;
        sp1Var.w();
        super.onResume();
        this.x = true;
        ((l30) sp1Var.c).p.z(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        B();
        ((y8) u()).m(true, false);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.u.w();
    }

    @Override // android.app.Activity
    public void onStop() {
        C();
        y8 y8Var = (y8) u();
        y8Var.A();
        j1 j1Var = y8Var.o;
        if (j1Var != null) {
            j1Var.s(false);
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        u().l(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        j1 j1VarV = v();
        if (getWindow().hasFeature(0)) {
            if (j1VarV == null || !j1VarV.k()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // defpackage.pm, android.app.Activity
    public final void setContentView(int i) {
        s();
        u().i(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        super.setTheme(i);
        ((y8) u()).T = i;
    }

    public final k8 u() {
        if (this.z == null) {
            i8 i8Var = k8.b;
            this.z = new y8(this, null, this, this);
        }
        return this.z;
    }

    public final j1 v() {
        y8 y8Var = (y8) u();
        y8Var.A();
        return y8Var.o;
    }

    public final y30 w() {
        return ((l30) this.u.c).p;
    }

    public final void y() {
        super.onDestroy();
        ((l30) this.u.c).p.l();
        this.v.d(yf0.ON_DESTROY);
    }

    public final boolean z(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return ((l30) this.u.c).p.i();
        }
        return false;
    }

    @Override // defpackage.pm, android.app.Activity
    public void setContentView(View view) {
        s();
        u().j(view);
    }

    @Override // defpackage.pm, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        u().k(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((l30) this.u.c).p.f.onCreateView(view, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }
}
