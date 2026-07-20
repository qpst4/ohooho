package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TriggersSettings;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.AdvancedTriggerActivity;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ia1 extends j30 {
    public w4 Z;
    public LinearLayout b0;
    public final bk Y = new bk(200);
    public final i70 a0 = new i70();

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir {
        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            k0(str, R.xml.preferences_triggers_mode_advanced_triggers);
            Preference preferenceH0 = h0("triggerMode");
            preferenceH0.f = new r1(22, (TriggersSettings) Z());
            preferenceH0.B(true);
        }
    }

    @Override // defpackage.j30
    public final View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        final int i = 0;
        View viewInflate = layoutInflater.inflate(R.layout.trigger_mode_advanced_triggers_layout, viewGroup, false);
        y30 y30VarL = l();
        y30VarL.getClass();
        ld ldVar = new ld(y30VarL);
        ldVar.i(R.id.triggers_mode_frame, new a());
        ldVar.e(false);
        this.b0 = (LinearLayout) viewInflate.findViewById(R.id.triggers_list);
        viewInflate.findViewById(R.id.trigger_add).setOnClickListener(new View.OnClickListener(this) { // from class: ga1
            public final /* synthetic */ ia1 c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = i;
                final int i3 = 1;
                final ia1 ia1Var = this.c;
                switch (i2) {
                    case 0:
                        int size = ia1Var.Z.c().size() + 1;
                        ia1Var.Z.c().add((ey0.b == 1 ? if0.p : if0.o).n("Trigger " + size));
                        xv0.d.c();
                        ia1Var.h0();
                        ia1Var.Y.a(new s4(15));
                        break;
                    case 1:
                        jl1 jl1Var = new jl1(ia1Var.o());
                        jl1Var.m(R.string.are_you_sure);
                        jl1Var.g(R.string.confirmation_reset_advanced_triggers);
                        ((x6) jl1Var.c).c = R.drawable.icon_warning;
                        jl1Var.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: ha1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i4) {
                                int i5 = i3;
                                ia1 ia1Var2 = ia1Var;
                                switch (i5) {
                                    case 0:
                                        xv0 xv0Var = xv0.d;
                                        xv0Var.a().a();
                                        xv0Var.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                    default:
                                        xv0 xv0Var2 = xv0.d;
                                        xv0Var2.a().r();
                                        xv0Var2.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                }
                            }
                        });
                        jl1Var.h(android.R.string.no, null);
                        jl1Var.n();
                        break;
                    default:
                        jl1 jl1Var2 = new jl1(ia1Var.o());
                        jl1Var2.m(R.string.are_you_sure);
                        jl1Var2.g(R.string.confirmation_copy_advanced_triggers_from_simple);
                        ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                        final int i4 = 0;
                        jl1Var2.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: ha1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i42) {
                                int i5 = i4;
                                ia1 ia1Var2 = ia1Var;
                                switch (i5) {
                                    case 0:
                                        xv0 xv0Var = xv0.d;
                                        xv0Var.a().a();
                                        xv0Var.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                    default:
                                        xv0 xv0Var2 = xv0.d;
                                        xv0Var2.a().r();
                                        xv0Var2.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                }
                            }
                        });
                        jl1Var2.h(android.R.string.no, null);
                        jl1Var2.n();
                        break;
                }
            }
        });
        final int i2 = 1;
        viewInflate.findViewById(R.id.advanced_triggers_reset).setOnClickListener(new View.OnClickListener(this) { // from class: ga1
            public final /* synthetic */ ia1 c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i22 = i2;
                final int i3 = 1;
                final ia1 ia1Var = this.c;
                switch (i22) {
                    case 0:
                        int size = ia1Var.Z.c().size() + 1;
                        ia1Var.Z.c().add((ey0.b == 1 ? if0.p : if0.o).n("Trigger " + size));
                        xv0.d.c();
                        ia1Var.h0();
                        ia1Var.Y.a(new s4(15));
                        break;
                    case 1:
                        jl1 jl1Var = new jl1(ia1Var.o());
                        jl1Var.m(R.string.are_you_sure);
                        jl1Var.g(R.string.confirmation_reset_advanced_triggers);
                        ((x6) jl1Var.c).c = R.drawable.icon_warning;
                        jl1Var.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: ha1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i42) {
                                int i5 = i3;
                                ia1 ia1Var2 = ia1Var;
                                switch (i5) {
                                    case 0:
                                        xv0 xv0Var = xv0.d;
                                        xv0Var.a().a();
                                        xv0Var.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                    default:
                                        xv0 xv0Var2 = xv0.d;
                                        xv0Var2.a().r();
                                        xv0Var2.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                }
                            }
                        });
                        jl1Var.h(android.R.string.no, null);
                        jl1Var.n();
                        break;
                    default:
                        jl1 jl1Var2 = new jl1(ia1Var.o());
                        jl1Var2.m(R.string.are_you_sure);
                        jl1Var2.g(R.string.confirmation_copy_advanced_triggers_from_simple);
                        ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                        final int i4 = 0;
                        jl1Var2.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: ha1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i42) {
                                int i5 = i4;
                                ia1 ia1Var2 = ia1Var;
                                switch (i5) {
                                    case 0:
                                        xv0 xv0Var = xv0.d;
                                        xv0Var.a().a();
                                        xv0Var.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                    default:
                                        xv0 xv0Var2 = xv0.d;
                                        xv0Var2.a().r();
                                        xv0Var2.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                }
                            }
                        });
                        jl1Var2.h(android.R.string.no, null);
                        jl1Var2.n();
                        break;
                }
            }
        });
        final int i3 = 2;
        viewInflate.findViewById(R.id.advanced_triggers_copy_from_simple).setOnClickListener(new View.OnClickListener(this) { // from class: ga1
            public final /* synthetic */ ia1 c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i22 = i3;
                final int i32 = 1;
                final ia1 ia1Var = this.c;
                switch (i22) {
                    case 0:
                        int size = ia1Var.Z.c().size() + 1;
                        ia1Var.Z.c().add((ey0.b == 1 ? if0.p : if0.o).n("Trigger " + size));
                        xv0.d.c();
                        ia1Var.h0();
                        ia1Var.Y.a(new s4(15));
                        break;
                    case 1:
                        jl1 jl1Var = new jl1(ia1Var.o());
                        jl1Var.m(R.string.are_you_sure);
                        jl1Var.g(R.string.confirmation_reset_advanced_triggers);
                        ((x6) jl1Var.c).c = R.drawable.icon_warning;
                        jl1Var.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: ha1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i42) {
                                int i5 = i32;
                                ia1 ia1Var2 = ia1Var;
                                switch (i5) {
                                    case 0:
                                        xv0 xv0Var = xv0.d;
                                        xv0Var.a().a();
                                        xv0Var.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                    default:
                                        xv0 xv0Var2 = xv0.d;
                                        xv0Var2.a().r();
                                        xv0Var2.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                }
                            }
                        });
                        jl1Var.h(android.R.string.no, null);
                        jl1Var.n();
                        break;
                    default:
                        jl1 jl1Var2 = new jl1(ia1Var.o());
                        jl1Var2.m(R.string.are_you_sure);
                        jl1Var2.g(R.string.confirmation_copy_advanced_triggers_from_simple);
                        ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                        final int i4 = 0;
                        jl1Var2.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: ha1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i42) {
                                int i5 = i4;
                                ia1 ia1Var2 = ia1Var;
                                switch (i5) {
                                    case 0:
                                        xv0 xv0Var = xv0.d;
                                        xv0Var.a().a();
                                        xv0Var.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                    default:
                                        xv0 xv0Var2 = xv0.d;
                                        xv0Var2.a().r();
                                        xv0Var2.c();
                                        ia1Var2.h0();
                                        CursorAccessibilityService.j();
                                        break;
                                }
                            }
                        });
                        jl1Var2.h(android.R.string.no, null);
                        jl1Var2.n();
                        break;
                }
            }
        });
        h0();
        return viewInflate;
    }

    @Override // defpackage.j30
    public final void R() {
        this.F = true;
        h0();
    }

    public final void h0() {
        if (this.b0 == null) {
            return;
        }
        this.Z = xv0.d.a().d();
        this.b0.removeAllViews();
        for (final f91 f91Var : this.Z.c()) {
            LinearLayout linearLayout = this.b0;
            Context contextO = o();
            v4 v4Var = new v4(contextO);
            View.inflate(contextO, R.layout.view_advanced_trigger, v4Var);
            final int i = 0;
            v4Var.findViewById(R.id.trigger_edit).setOnClickListener(new View.OnClickListener(this) { // from class: u4
                public final /* synthetic */ ia1 c;

                {
                    this.c = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i2 = i;
                    f91 f91Var2 = f91Var;
                    ia1 ia1Var = this.c;
                    switch (i2) {
                        case 0:
                            Intent intent = new Intent(ia1Var.u(), (Class<?>) AdvancedTriggerActivity.class);
                            intent.putExtra("triggerIndex", ia1Var.Z.c().indexOf(f91Var2));
                            ia1Var.f0(intent);
                            break;
                        case 1:
                            i70 i70Var = ia1Var.a0;
                            f91 f91Var3 = (f91) i70Var.e(i70Var.i(f91Var2), new mc1(f91.class));
                            f91Var3.m(f01.P(R.string.trigger_copied_name, "triggerName", f91Var3.g()));
                            ia1Var.Z.c().add(f91Var3);
                            xv0.d.c();
                            ia1Var.h0();
                            ia1Var.Y.a(new s4(15));
                            break;
                        case 2:
                            i70 i70Var2 = ia1Var.a0;
                            f91 f91Var4 = (f91) i70Var2.e(i70Var2.i(f91Var2), new mc1(f91.class));
                            f91Var4.h().l((ey0.c() - f91Var4.h().g()) - f91Var4.h().f());
                            f91Var4.f().l((ey0.c() - f91Var4.f().g()) - f91Var4.f().f());
                            f91Var4.m(f01.P(R.string.trigger_flipped_name, "triggerName", f91Var4.g()));
                            ia1Var.Z.c().add(f91Var4);
                            xv0.d.c();
                            ia1Var.h0();
                            ia1Var.Y.a(new s4(15));
                            break;
                        default:
                            Context contextO2 = ia1Var.o();
                            k2 k2Var = new k2(ia1Var, 19, f91Var2);
                            jl1 jl1Var = new jl1(contextO2);
                            jl1Var.m(R.string.are_you_sure);
                            ((x6) jl1Var.c).c = R.drawable.icon_warning;
                            jl1Var.k(android.R.string.yes, new z2(22, k2Var));
                            jl1Var.h(android.R.string.no, null);
                            jl1Var.n();
                            break;
                    }
                }
            });
            final int i2 = 1;
            v4Var.findViewById(R.id.trigger_copy).setOnClickListener(new View.OnClickListener(this) { // from class: u4
                public final /* synthetic */ ia1 c;

                {
                    this.c = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i22 = i2;
                    f91 f91Var2 = f91Var;
                    ia1 ia1Var = this.c;
                    switch (i22) {
                        case 0:
                            Intent intent = new Intent(ia1Var.u(), (Class<?>) AdvancedTriggerActivity.class);
                            intent.putExtra("triggerIndex", ia1Var.Z.c().indexOf(f91Var2));
                            ia1Var.f0(intent);
                            break;
                        case 1:
                            i70 i70Var = ia1Var.a0;
                            f91 f91Var3 = (f91) i70Var.e(i70Var.i(f91Var2), new mc1(f91.class));
                            f91Var3.m(f01.P(R.string.trigger_copied_name, "triggerName", f91Var3.g()));
                            ia1Var.Z.c().add(f91Var3);
                            xv0.d.c();
                            ia1Var.h0();
                            ia1Var.Y.a(new s4(15));
                            break;
                        case 2:
                            i70 i70Var2 = ia1Var.a0;
                            f91 f91Var4 = (f91) i70Var2.e(i70Var2.i(f91Var2), new mc1(f91.class));
                            f91Var4.h().l((ey0.c() - f91Var4.h().g()) - f91Var4.h().f());
                            f91Var4.f().l((ey0.c() - f91Var4.f().g()) - f91Var4.f().f());
                            f91Var4.m(f01.P(R.string.trigger_flipped_name, "triggerName", f91Var4.g()));
                            ia1Var.Z.c().add(f91Var4);
                            xv0.d.c();
                            ia1Var.h0();
                            ia1Var.Y.a(new s4(15));
                            break;
                        default:
                            Context contextO2 = ia1Var.o();
                            k2 k2Var = new k2(ia1Var, 19, f91Var2);
                            jl1 jl1Var = new jl1(contextO2);
                            jl1Var.m(R.string.are_you_sure);
                            ((x6) jl1Var.c).c = R.drawable.icon_warning;
                            jl1Var.k(android.R.string.yes, new z2(22, k2Var));
                            jl1Var.h(android.R.string.no, null);
                            jl1Var.n();
                            break;
                    }
                }
            });
            final int i3 = 2;
            v4Var.findViewById(R.id.trigger_flip).setOnClickListener(new View.OnClickListener(this) { // from class: u4
                public final /* synthetic */ ia1 c;

                {
                    this.c = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i22 = i3;
                    f91 f91Var2 = f91Var;
                    ia1 ia1Var = this.c;
                    switch (i22) {
                        case 0:
                            Intent intent = new Intent(ia1Var.u(), (Class<?>) AdvancedTriggerActivity.class);
                            intent.putExtra("triggerIndex", ia1Var.Z.c().indexOf(f91Var2));
                            ia1Var.f0(intent);
                            break;
                        case 1:
                            i70 i70Var = ia1Var.a0;
                            f91 f91Var3 = (f91) i70Var.e(i70Var.i(f91Var2), new mc1(f91.class));
                            f91Var3.m(f01.P(R.string.trigger_copied_name, "triggerName", f91Var3.g()));
                            ia1Var.Z.c().add(f91Var3);
                            xv0.d.c();
                            ia1Var.h0();
                            ia1Var.Y.a(new s4(15));
                            break;
                        case 2:
                            i70 i70Var2 = ia1Var.a0;
                            f91 f91Var4 = (f91) i70Var2.e(i70Var2.i(f91Var2), new mc1(f91.class));
                            f91Var4.h().l((ey0.c() - f91Var4.h().g()) - f91Var4.h().f());
                            f91Var4.f().l((ey0.c() - f91Var4.f().g()) - f91Var4.f().f());
                            f91Var4.m(f01.P(R.string.trigger_flipped_name, "triggerName", f91Var4.g()));
                            ia1Var.Z.c().add(f91Var4);
                            xv0.d.c();
                            ia1Var.h0();
                            ia1Var.Y.a(new s4(15));
                            break;
                        default:
                            Context contextO2 = ia1Var.o();
                            k2 k2Var = new k2(ia1Var, 19, f91Var2);
                            jl1 jl1Var = new jl1(contextO2);
                            jl1Var.m(R.string.are_you_sure);
                            ((x6) jl1Var.c).c = R.drawable.icon_warning;
                            jl1Var.k(android.R.string.yes, new z2(22, k2Var));
                            jl1Var.h(android.R.string.no, null);
                            jl1Var.n();
                            break;
                    }
                }
            });
            final int i4 = 3;
            v4Var.findViewById(R.id.trigger_delete).setOnClickListener(new View.OnClickListener(this) { // from class: u4
                public final /* synthetic */ ia1 c;

                {
                    this.c = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i22 = i4;
                    f91 f91Var2 = f91Var;
                    ia1 ia1Var = this.c;
                    switch (i22) {
                        case 0:
                            Intent intent = new Intent(ia1Var.u(), (Class<?>) AdvancedTriggerActivity.class);
                            intent.putExtra("triggerIndex", ia1Var.Z.c().indexOf(f91Var2));
                            ia1Var.f0(intent);
                            break;
                        case 1:
                            i70 i70Var = ia1Var.a0;
                            f91 f91Var3 = (f91) i70Var.e(i70Var.i(f91Var2), new mc1(f91.class));
                            f91Var3.m(f01.P(R.string.trigger_copied_name, "triggerName", f91Var3.g()));
                            ia1Var.Z.c().add(f91Var3);
                            xv0.d.c();
                            ia1Var.h0();
                            ia1Var.Y.a(new s4(15));
                            break;
                        case 2:
                            i70 i70Var2 = ia1Var.a0;
                            f91 f91Var4 = (f91) i70Var2.e(i70Var2.i(f91Var2), new mc1(f91.class));
                            f91Var4.h().l((ey0.c() - f91Var4.h().g()) - f91Var4.h().f());
                            f91Var4.f().l((ey0.c() - f91Var4.f().g()) - f91Var4.f().f());
                            f91Var4.m(f01.P(R.string.trigger_flipped_name, "triggerName", f91Var4.g()));
                            ia1Var.Z.c().add(f91Var4);
                            xv0.d.c();
                            ia1Var.h0();
                            ia1Var.Y.a(new s4(15));
                            break;
                        default:
                            Context contextO2 = ia1Var.o();
                            k2 k2Var = new k2(ia1Var, 19, f91Var2);
                            jl1 jl1Var = new jl1(contextO2);
                            jl1Var.m(R.string.are_you_sure);
                            ((x6) jl1Var.c).c = R.drawable.icon_warning;
                            jl1Var.k(android.R.string.yes, new z2(22, k2Var));
                            jl1Var.h(android.R.string.no, null);
                            jl1Var.n();
                            break;
                    }
                }
            });
            ((TextView) v4Var.findViewById(R.id.trigger_name)).setText(f91Var.g());
            linearLayout.addView(v4Var);
        }
    }
}
