package com.quickcursor.android.activities.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;
import com.quickcursor.R;
import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;
import defpackage.b41;
import defpackage.bk;
import defpackage.cr;
import defpackage.j30;
import defpackage.j71;
import defpackage.l71;
import defpackage.lc1;
import defpackage.ld;
import defpackage.n3;
import defpackage.o71;
import defpackage.oq0;
import defpackage.p71;
import defpackage.pn0;
import defpackage.s4;
import defpackage.s71;
import defpackage.si0;
import defpackage.w71;
import defpackage.wj;
import defpackage.x30;
import defpackage.y30;
import defpackage.y31;
import defpackage.yw;
import defpackage.z71;
import java.util.List;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class TrackerActionsSettings extends wj implements y31 {
    public static final /* synthetic */ int I = 0;
    public ImageView D;
    public TrackerDrawable E;
    public TabLayout F;
    public List H;
    public final bk C = new bk(250);
    public int G = -1;

    public final void G() {
        this.F.i(3).h.setVisibility(8);
        this.F.i(4).h.setVisibility(s71.e.d.b() != n3.nothing ? 0 : 8);
    }

    public final void H(j71 j71Var) {
        J(3);
        y30 y30VarW = w();
        y30VarW.getClass();
        y30VarW.x(new x30(y30VarW, "l71", -1), false);
        y30 y30VarW2 = w();
        y30VarW2.getClass();
        ld ldVar = new ld(y30VarW2);
        ldVar.j(R.anim.fragment_fade_in, R.anim.fragment_fade_out);
        ldVar.i(R.id.frameLayout, new l71(j71Var));
        ldVar.c("l71");
        ldVar.e(false);
    }

    public final void I() {
        J(4);
        y30 y30VarW = w();
        y30VarW.getClass();
        y30VarW.x(new x30(y30VarW, "l71", -1), false);
        y30 y30VarW2 = w();
        y30VarW2.getClass();
        ld ldVar = new ld(y30VarW2);
        ldVar.j(R.anim.fragment_fade_in, R.anim.fragment_fade_out);
        ldVar.i(R.id.frameLayout, new z71());
        ldVar.c("l71");
        ldVar.e(false);
    }

    public final void J(int i) {
        this.F.M.remove(this);
        TabLayout tabLayout = this.F;
        tabLayout.m(tabLayout.i(i), true);
        this.F.a(this);
        if (i < 3) {
            G();
        }
    }

    public final void K() {
        this.E.o();
        this.E.setAlphaAnimation(1.0f);
        this.E.setActionsAnimation(1.0f);
        this.E.invalidateSelf();
        this.C.a(new s4(18));
    }

    public final void L(int i) {
        try {
            this.G = i;
            this.E.m(i);
            this.E.invalidateSelf();
        } catch (Exception unused) {
            si0.b("Caught updatePreviewSelectedSlice exception.");
        }
    }

    public final void M(int i, int i2) {
        int i3 = i + i2;
        this.E.o();
        TrackerDrawable trackerDrawable = this.E;
        int i4 = i3 / 2;
        TrackerDrawable.f(trackerDrawable.b);
        trackerDrawable.i = i4;
        trackerDrawable.j = i4;
        TrackerDrawable trackerDrawable2 = this.E;
        trackerDrawable2.n = i / 2;
        trackerDrawable2.z.setStrokeWidth(i2);
        this.E.setAlphaAnimation(1.0f);
        this.E.setActionsAnimation(1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.D.setLayoutParams(layoutParams);
        this.E.invalidateSelf();
        this.C.a(new s4(19));
    }

    @Override // defpackage.x31
    public final void n(b41 b41Var) {
        int i = b41Var.e;
        j30 z71Var = i != 0 ? i != 1 ? i != 2 ? i != 4 ? null : new z71() : new o71() : new p71() : new w71();
        if (z71Var == null) {
            return;
        }
        y30 y30VarW = w();
        y30VarW.getClass();
        y30VarW.x(new x30(y30VarW, "l71", -1), false);
        y30 y30VarW2 = w();
        y30VarW2.getClass();
        ld ldVar = new ld(y30VarW2);
        ldVar.j(R.anim.fragment_fade_in, R.anim.fragment_fade_out);
        ldVar.i(R.id.frameLayout, z71Var);
        ldVar.e(false);
        G();
    }

    @Override // defpackage.pm, android.app.Activity
    public final void onBackPressed() {
        super.onBackPressed();
        j30 j30VarC = w().C(R.id.frameLayout);
        if (!(j30VarC instanceof l71)) {
            L(-1);
        }
        if (j30VarC instanceof w71) {
            J(0);
        } else if (j30VarC instanceof p71) {
            J(1);
        } else if (j30VarC instanceof o71) {
            J(2);
        }
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        Optional.ofNullable(v()).ifPresent(new defpackage.a(16));
        setContentView(R.layout.tracker_actions_settings_activity);
        y30 y30VarW = w();
        y30VarW.getClass();
        ld ldVar = new ld(y30VarW);
        ldVar.i(R.id.frameLayout, new w71());
        ldVar.e(false);
        Optional.ofNullable(v()).ifPresent(new yw(1, this));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        this.F = tabLayout;
        tabLayout.a(this);
        G();
        this.H = s71.e.c;
        int iB = ((int) oq0.b((SharedPreferences) pn0.t().d, oq0.z0)) + ((int) oq0.b((SharedPreferences) pn0.t().d, oq0.x0));
        TrackerDrawable trackerDrawableN = TrackerDrawable.n(pn0.t().z());
        this.E = trackerDrawableN;
        trackerDrawableN.o();
        TrackerDrawable trackerDrawable = this.E;
        int i = iB / 2;
        TrackerDrawable.f(trackerDrawable.b);
        trackerDrawable.i = i;
        trackerDrawable.j = i;
        this.E.setAlphaAnimation(1.0f);
        this.E.setActionsAnimation(1.0f);
        ImageView imageView = (ImageView) findViewById(R.id.trackerActionsPreview);
        this.D = imageView;
        imageView.setImageDrawable(this.E);
        this.D.setLayerType(1, null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams.width = iB;
        layoutParams.height = iB;
        this.D.setLayoutParams(layoutParams);
        this.E.invalidateSelf();
        this.D.setOnTouchListener(new cr(2, this));
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
