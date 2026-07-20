package com.quickcursor.android.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import defpackage.b61;
import defpackage.es0;
import defpackage.kg1;
import defpackage.lc1;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.q0;
import defpackage.r0;
import defpackage.s10;
import defpackage.u01;
import defpackage.yb0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AccessibilityStoppedActivity extends es0 implements kg1 {
    public static final /* synthetic */ int t0 = 0;
    public s10 p0;
    public boolean o0 = false;
    public int q0 = -1;
    public int r0 = -1;
    public int s0 = -1;

    public static void f0(AccessibilityStoppedActivity accessibilityStoppedActivity) {
        int currentItem = accessibilityStoppedActivity.U.getCurrentItem();
        if (currentItem != accessibilityStoppedActivity.q0) {
            if (currentItem == accessibilityStoppedActivity.r0) {
                ((SharedPreferences) pn0.t().d).edit().putBoolean(oq0.j.name(), true).apply();
                accessibilityStoppedActivity.g0();
                return;
            } else if (currentItem == accessibilityStoppedActivity.s0) {
                lc1.m0(accessibilityStoppedActivity);
                return;
            } else {
                accessibilityStoppedActivity.W();
                return;
            }
        }
        if (CursorAccessibilityService.f()) {
            if (currentItem == accessibilityStoppedActivity.a0.g.size() - 1) {
                accessibilityStoppedActivity.g0();
                return;
            } else {
                accessibilityStoppedActivity.W();
                return;
            }
        }
        if (CursorAccessibilityService.f()) {
            yb0.y(R.string.accessibility_service_already_enabled, 1);
            accessibilityStoppedActivity.W();
        } else {
            accessibilityStoppedActivity.o0 = true;
            lc1.b0(accessibilityStoppedActivity);
        }
    }

    @Override // defpackage.es0, defpackage.hc0
    public final boolean J(int i) {
        try {
            return super.J(i);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // defpackage.kg1
    public final void d(int i) {
        if (i != 0 && i != this.q0 && i != this.r0) {
            this.f0 = false;
            a0();
        }
        int i2 = i == 0 ? 2 : 1;
        if (this.h0 != i2) {
            X(i2);
        }
        if (this.p0 == null) {
            return;
        }
        int currentItem = this.U.getCurrentItem();
        int i3 = this.r0;
        s10 s10Var = this.p0;
        if (currentItem == i3) {
            s10Var.j();
        } else {
            s10Var.i.f();
        }
    }

    public final void g0() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    @Override // defpackage.es0, defpackage.hc0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.U.b(this);
        int i = 0;
        this.X.setOnClickListener(new q0(this, i));
        this.j0 = this;
        this.f0 = true;
        a0();
        this.X.setVisibility(0);
        int i2 = 2;
        X(2);
        this.i0 = 2;
        this.Y.setOnClickListener(new q0(this, 1));
        u01 u01Var = new u01();
        u01Var.e = R.layout.simple_slide;
        u01Var.b = R.string.slide_first_title;
        u01Var.c = R.string.slide_first_description;
        u01Var.d = R.drawable.quick_cursor_logo_circle;
        u01Var.a = R.color.colorPrimaryDark;
        u01Var.h = R.string.slide_first_button;
        u01Var.i = new q0(this, i2);
        Q(u01Var.a());
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        lowerCase.getClass();
        if (lowerCase.equals("xiaomi")) {
            u01 u01Var2 = new u01();
            u01Var2.e = R.layout.intro_slide;
            u01Var2.d = R.drawable.xiaomi_tutorial_step1;
            u01Var2.c = R.string.generic_tutorial_slide_1;
            u01Var2.a = R.color.colorPrimaryDark;
            Q(u01Var2.a());
            u01 u01Var3 = new u01();
            u01Var3.e = R.layout.intro_slide;
            u01Var3.d = R.drawable.xiaomi_tutorial_step2;
            u01Var3.c = R.string.generic_tutorial_4_steps_slide_2;
            u01Var3.a = R.color.colorPrimaryDark;
            Q(u01Var3.a());
            u01 u01Var4 = new u01();
            u01Var4.e = R.layout.intro_slide;
            u01Var4.d = R.drawable.xiaomi_tutorial_step3;
            u01Var4.c = R.string.generic_tutorial_4_steps_slide_3;
            u01Var4.a = R.color.colorPrimaryDark;
            Q(u01Var4.a());
            u01 u01Var5 = new u01();
            u01Var5.e = R.layout.intro_slide;
            u01Var5.d = R.drawable.xiaomi_tutorial_step4;
            u01Var5.c = R.string.generic_tutorial_slide_3;
            u01Var5.a = R.color.colorPrimaryDark;
            u01Var5.h = R.string.generic_tutorial_slide_3_button;
            u01Var5.i = new q0(this, i2);
            Q(u01Var5.a());
        } else if (lowerCase.equals("samsung")) {
            u01 u01Var6 = new u01();
            u01Var6.e = R.layout.intro_slide;
            u01Var6.d = R.drawable.samsung_tutorial_step1;
            u01Var6.c = R.string.generic_tutorial_slide_1;
            u01Var6.a = R.color.colorPrimaryDark;
            Q(u01Var6.a());
            u01 u01Var7 = new u01();
            u01Var7.e = R.layout.intro_slide;
            u01Var7.d = R.drawable.samsung_tutorial_step2;
            u01Var7.c = R.string.generic_tutorial_4_steps_slide_2;
            u01Var7.a = R.color.colorPrimaryDark;
            Q(u01Var7.a());
            u01 u01Var8 = new u01();
            u01Var8.e = R.layout.intro_slide;
            u01Var8.d = R.drawable.samsung_tutorial_step3;
            u01Var8.c = R.string.generic_tutorial_4_steps_slide_3;
            u01Var8.a = R.color.colorPrimaryDark;
            Q(u01Var8.a());
            u01 u01Var9 = new u01();
            u01Var9.e = R.layout.intro_slide;
            u01Var9.d = R.drawable.samsung_tutorial_step4;
            u01Var9.c = R.string.generic_tutorial_slide_3;
            u01Var9.a = R.color.colorPrimaryDark;
            u01Var9.h = R.string.generic_tutorial_slide_3_button;
            u01Var9.i = new q0(this, i2);
            Q(u01Var9.a());
        } else {
            u01 u01Var10 = new u01();
            u01Var10.e = R.layout.intro_slide;
            u01Var10.d = R.drawable.generic_tutorial_step1;
            u01Var10.c = R.string.generic_tutorial_slide_1;
            u01Var10.a = R.color.colorPrimaryDark;
            Q(u01Var10.a());
            u01 u01Var11 = new u01();
            u01Var11.e = R.layout.intro_slide;
            u01Var11.d = R.drawable.generic_tutorial_step2;
            u01Var11.c = R.string.generic_tutorial_slide_2;
            u01Var11.a = R.color.colorPrimaryDark;
            Q(u01Var11.a());
            u01 u01Var12 = new u01();
            u01Var12.e = R.layout.intro_slide;
            u01Var12.d = R.drawable.generic_tutorial_step3;
            u01Var12.c = R.string.generic_tutorial_slide_3;
            u01Var12.a = R.color.colorPrimaryDark;
            u01Var12.h = R.string.generic_tutorial_slide_3_button;
            u01Var12.i = new q0(this, i2);
            Q(u01Var12.a());
        }
        this.q0 = this.a0.g.size() - 1;
        if (!oq0.a((SharedPreferences) pn0.t().d, oq0.j)) {
            s10 s10Var = new s10(new q0(this, i2));
            this.p0 = s10Var;
            Q(s10Var);
            this.r0 = this.a0.g.size() - 1;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("skipToFirstUse", false) && CursorAccessibilityService.f() && this.p0 != null && this.r0 != -1) {
            try {
                b61.b(new r0(this, i2), 150L);
                this.p0.j();
            } catch (Exception unused) {
            }
        }
        b61.b(new r0(this, i), 100L);
    }

    public void onLeftButtonClicked(View view) {
        if (this.h0 == 1) {
            J(this.U.getCurrentItem() - 1);
        } else {
            J(H() - 1);
        }
    }

    @Override // defpackage.z7, android.app.Activity
    public final void onPause() {
        super.onPause();
        s10 s10Var = this.p0;
        if (s10Var != null) {
            s10Var.i.f();
        }
    }

    @Override // defpackage.es0, defpackage.hc0, defpackage.z7, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (CursorAccessibilityService.f() && oq0.a((SharedPreferences) pn0.t().d, oq0.j)) {
            g0();
            return;
        }
        int currentItem = this.U.getCurrentItem();
        if (currentItem == this.q0) {
            if (CursorAccessibilityService.f()) {
                if (currentItem == this.a0.g.size() - 1) {
                    g0();
                } else {
                    W();
                }
            } else if (this.o0) {
                this.o0 = false;
                yb0.y(R.string.accessibility_not_enabled, 1);
            }
        }
        int i = this.s0;
        if (i > -1 && currentItem == i && CursorAccessibilityService.g() && !CursorAccessibilityService.f()) {
            yb0.y(R.string.slide_force_stop_not_stopped, 1);
        }
        if (this.p0 == null) {
            return;
        }
        int currentItem2 = this.U.getCurrentItem();
        int i2 = this.r0;
        s10 s10Var = this.p0;
        if (currentItem2 == i2) {
            s10Var.j();
        } else {
            s10Var.i.f();
        }
    }

    @Override // defpackage.kg1
    public final void a(int i) {
    }

    @Override // defpackage.kg1
    public final void l(float f, int i, int i2) {
    }
}
