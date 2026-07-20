package com.quickcursor.android.activities.settings;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TriggersSettings;
import com.quickcursor.android.views.ProOverlayView;
import defpackage.bk;
import defpackage.ey0;
import defpackage.ia1;
import defpackage.j1;
import defpackage.j30;
import defpackage.ja1;
import defpackage.la1;
import defpackage.lc1;
import defpackage.ld;
import defpackage.ma1;
import defpackage.s4;
import defpackage.tv0;
import defpackage.uv0;
import defpackage.w11;
import defpackage.wj;
import defpackage.wq0;
import defpackage.x11;
import defpackage.xv0;
import defpackage.y30;
import defpackage.za1;
import java.util.ArrayList;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class TriggersSettings extends wj implements wq0 {
    public static final /* synthetic */ int G = 0;
    public final bk C = new bk(200);
    public ProOverlayView D;
    public uv0 E;
    public Spinner F;

    public final void G(j30 j30Var) {
        y30 y30VarW = w();
        y30VarW.getClass();
        ld ldVar = new ld(y30VarW);
        ldVar.i(R.id.settings, j30Var);
        ldVar.e(false);
        this.C.a(new s4(15));
    }

    public final void H(tv0 tv0Var) {
        if (tv0Var == tv0.simpleTriggers) {
            i();
            G(new ma1());
        } else if (tv0Var == tv0.advancedTriggers) {
            i();
            G(new ia1());
        } else if (tv0Var == tv0.floating) {
            f();
            G(new la1());
        } else {
            i();
            G(new ja1());
        }
    }

    @Override // defpackage.wq0
    public final void f() {
        this.D.a();
    }

    @Override // defpackage.wq0
    public final void i() {
        ProOverlayView proOverlayView = this.D;
        View viewFindViewById = proOverlayView.findViewById(R.id.overlayPro);
        if (viewFindViewById != null) {
            proOverlayView.removeView(viewFindViewById);
        }
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.preferences_activity_with_pro_overlay);
        this.D = (ProOverlayView) findViewById(R.id.proOverlayView);
        if (bundle == null) {
            if (getIntent().getBooleanExtra("portrait", false)) {
                setRequestedOrientation(7);
            } else if (getIntent().getBooleanExtra("landscape", false)) {
                setRequestedOrientation(6);
            }
        }
        ey0.e(this);
        j1 j1VarV = v();
        if (j1VarV != null) {
            j1VarV.p();
            j1VarV.q();
            View viewInflate = getLayoutInflater().inflate(R.layout.action_bar_triggers, (ViewGroup) null);
            j1VarV.m(viewInflate);
            this.F = (Spinner) viewInflate.findViewById(R.id.action_bar_spinner);
            final ArrayList arrayList = new ArrayList();
            xv0 xv0Var = xv0.d;
            final uv0 uv0VarA = xv0Var.a();
            arrayList.add(new w11(uv0VarA.m(), uv0VarA.f()));
            arrayList.add(new w11(uv0VarA.f(), uv0VarA.m()));
            xv0Var.c.forEach(new BiConsumer() { // from class: ya1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    uv0 uv0Var = (uv0) obj2;
                    int i = TriggersSettings.G;
                    int iM = uv0Var.m();
                    uv0 uv0Var2 = uv0VarA;
                    boolean z = false;
                    boolean z2 = iM == uv0Var2.m() && uv0Var.f() == uv0Var2.f();
                    if (uv0Var.f() == uv0Var2.m() && uv0Var.m() == uv0Var2.f()) {
                        z = true;
                    }
                    if (z2 || z) {
                        return;
                    }
                    arrayList.add(new w11(uv0Var.m(), uv0Var.f()));
                }
            });
            this.F.setAdapter((SpinnerAdapter) new x11(this, arrayList));
            this.F.setOnItemSelectedListener(new za1(this));
        }
        uv0 uv0VarA2 = xv0.d.a();
        this.E = uv0VarA2;
        H(uv0VarA2.g());
    }
}
