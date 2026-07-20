package defpackage;

import android.app.Application;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.a;
import com.quickcursor.R;
import defpackage.eg1;
import defpackage.gg0;
import defpackage.jm;
import defpackage.pm;
import defpackage.yf0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pm extends om implements fg1, u70, rx0 {
    public static final /* synthetic */ int t = 0;
    public final ho c = new ho();
    public final ra d;
    public final qx0 e;
    public eg1 f;
    public final km g;
    public final u31 h;
    public final AtomicInteger i;
    public final mm j;
    public final CopyOnWriteArrayList k;
    public final CopyOnWriteArrayList l;
    public final CopyOnWriteArrayList m;
    public final CopyOnWriteArrayList n;
    public final CopyOnWriteArrayList o;
    public final CopyOnWriteArrayList p;
    public boolean q;
    public boolean r;
    public final u31 s;

    public pm() {
        int i = 0;
        this.d = new ra(new dm(this, i));
        qx0 qx0Var = new qx0(this);
        this.e = qx0Var;
        this.g = new km(this);
        int i2 = 1;
        this.h = new u31(new nm(this, i2));
        this.i = new AtomicInteger();
        this.j = new mm(this);
        this.k = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.n = new CopyOnWriteArrayList();
        this.o = new CopyOnWriteArrayList();
        this.p = new CopyOnWriteArrayList();
        a aVar = this.b;
        if (aVar == null) {
            s1.f("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
            throw null;
        }
        aVar.a(new em(i, this));
        this.b.a(new em(i2, this));
        this.b.a(new dg0() { // from class: androidx.activity.ComponentActivity$4
            @Override // defpackage.dg0
            public final void c(gg0 gg0Var, yf0 yf0Var) {
                int i3 = pm.t;
                pm pmVar = this.b;
                if (pmVar.f == null) {
                    jm jmVar = (jm) pmVar.getLastNonConfigurationInstance();
                    if (jmVar != null) {
                        pmVar.f = jmVar.a;
                    }
                    if (pmVar.f == null) {
                        pmVar.f = new eg1();
                    }
                }
                pmVar.b.f(this);
            }
        });
        qx0Var.b();
        tk0.f(this);
        ((e8) qx0Var.c).e("android:support:activity-result", new fm(i, this));
        q(new gm(this, i));
        this.s = new u31(new nm(this, 2));
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        this.g.a(decorView);
        super.addContentView(view, layoutParams);
    }

    @Override // defpackage.rx0
    public final e8 c() {
        return (e8) this.e.c;
    }

    @Override // defpackage.u70
    public final jm0 k() {
        jm0 jm0Var = new jm0(0);
        LinkedHashMap linkedHashMap = (LinkedHashMap) jm0Var.a;
        if (getApplication() != null) {
            ix ixVar = ix.g;
            Application application = getApplication();
            application.getClass();
            linkedHashMap.put(ixVar, application);
        }
        linkedHashMap.put(tk0.g, this);
        linkedHashMap.put(tk0.h, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            linkedHashMap.put(tk0.i, extras);
        }
        return jm0Var;
    }

    @Override // defpackage.fg1
    public final eg1 m() {
        if (getApplication() == null) {
            s1.f("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
            return null;
        }
        if (this.f == null) {
            jm jmVar = (jm) getLastNonConfigurationInstance();
            if (jmVar != null) {
                this.f = jmVar.a;
            }
            if (this.f == null) {
                this.f = new eg1();
            }
        }
        eg1 eg1Var = this.f;
        eg1Var.getClass();
        return eg1Var;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.j.a(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        r().d();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        configuration.getClass();
        super.onConfigurationChanged(configuration);
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((ao) it.next()).accept(configuration);
        }
    }

    @Override // defpackage.om, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.e.c(bundle);
        ho hoVar = this.c;
        hoVar.getClass();
        hoVar.b = this;
        Iterator it = hoVar.a.iterator();
        while (it.hasNext()) {
            ((co0) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i = lv0.c;
        jv0.b(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        menu.getClass();
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.d.e).iterator();
        while (it.hasNext()) {
            ((s30) it.next()).a.k();
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        menuItem.getClass();
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            Iterator it = ((CopyOnWriteArrayList) this.d.e).iterator();
            while (it.hasNext()) {
                if (((s30) it.next()).a.p()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        configuration.getClass();
        this.q = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.q = false;
            Iterator it = this.n.iterator();
            while (it.hasNext()) {
                ((ao) it.next()).accept(new im0(z));
            }
        } catch (Throwable th) {
            this.q = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((ao) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        menu.getClass();
        Iterator it = ((CopyOnWriteArrayList) this.d.e).iterator();
        while (it.hasNext()) {
            ((s30) it.next()).a.q();
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        configuration.getClass();
        this.r = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.r = false;
            Iterator it = this.o.iterator();
            while (it.hasNext()) {
                ((ao) it.next()).accept(new pp0(z));
            }
        } catch (Throwable th) {
            this.r = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        menu.getClass();
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.d.e).iterator();
        while (it.hasNext()) {
            ((s30) it.next()).a.t();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        strArr.getClass();
        iArr.getClass();
        if (this.j.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        jm jmVar;
        eg1 eg1Var = this.f;
        if (eg1Var == null && (jmVar = (jm) getLastNonConfigurationInstance()) != null) {
            eg1Var = jmVar.a;
        }
        if (eg1Var == null) {
            return null;
        }
        jm jmVar2 = new jm();
        jmVar2.a = eg1Var;
        return jmVar2;
    }

    @Override // defpackage.om, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        a aVar = this.b;
        if (aVar != null) {
            aVar.c("setCurrentState");
            aVar.e(zf0.d);
        }
        super.onSaveInstanceState(bundle);
        this.e.d(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((ao) it.next()).accept(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator it = this.p.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // defpackage.gg0
    public final a p() {
        return this.b;
    }

    public final void q(co0 co0Var) {
        ho hoVar = this.c;
        hoVar.getClass();
        pm pmVar = hoVar.b;
        if (pmVar != null) {
            co0Var.a(pmVar);
        }
        hoVar.a.add(co0Var);
    }

    public final androidx.activity.a r() {
        return (androidx.activity.a) this.s.a();
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (tk0.r()) {
                tk0.b("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            j40 j40Var = (j40) this.h.a();
            synchronized (j40Var.a) {
                try {
                    j40Var.b = true;
                    ArrayList arrayList = j40Var.c;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((k40) obj).a();
                    }
                    j40Var.c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            Trace.endSection();
        }
    }

    public final void s() {
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        decorView2.getClass();
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        decorView3.getClass();
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        decorView4.getClass();
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        decorView5.getClass();
        decorView5.setTag(R.id.report_drawn, this);
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        s();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        this.g.a(decorView);
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i) {
        intent.getClass();
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        intentSender.getClass();
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public final g4 t(e4 e4Var, f01 f01Var) {
        mm mmVar = this.j;
        mmVar.getClass();
        return mmVar.c("activity_rq#" + this.i.getAndIncrement(), this, f01Var, e4Var);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i, Bundle bundle) {
        intent.getClass();
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        intentSender.getClass();
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        s();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        this.g.a(decorView);
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        this.g.a(decorView);
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z) {
        if (this.q) {
            return;
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            ((ao) it.next()).accept(new im0(z));
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z) {
        if (this.r) {
            return;
        }
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((ao) it.next()).accept(new pp0(z));
        }
    }
}
