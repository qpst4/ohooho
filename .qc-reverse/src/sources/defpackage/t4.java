package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.quickcursor.R;
import com.quickcursor.android.preferences.SeekBarDialogPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class t4 extends hr {
    public SwitchPreference A0;
    public final bk j0;
    public final f91 k0;
    public final xa1 l0;
    public EditTextPreference m0;
    public SeekBarDialogPreference n0;
    public SeekBarDialogPreference o0;
    public SeekBarDialogPreference p0;
    public SeekBarDialogPreference q0;
    public SeekBarDialogPreference r0;
    public SeekBarDialogPreference s0;
    public SeekBarDialogPreference t0;
    public SeekBarDialogPreference u0;
    public SeekBarDialogPreference v0;
    public SeekBarDialogPreference w0;
    public SeekBarDialogPreference x0;
    public SeekBarDialogPreference y0;
    public SeekBarDialogPreference z0;

    public t4(f91 f91Var) {
        super(R.xml.preferences_advanced_triggers_general);
        this.j0 = new bk(200L);
        this.k0 = f91Var;
        this.l0 = new xa1(false);
    }

    @Override // defpackage.hr, defpackage.j30
    public final void P() {
        super.P();
        this.l0.f();
    }

    @Override // defpackage.hr, defpackage.j30
    public final void R() {
        super.R();
        this.l0.c(-1, this.k0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.hr, defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        super.i0(str, bundle);
        this.m0 = (EditTextPreference) h0("triggerName");
        this.n0 = (SeekBarDialogPreference) h0("triggerAreaWidth");
        this.o0 = (SeekBarDialogPreference) h0("triggerAreaHeight");
        this.p0 = (SeekBarDialogPreference) h0("triggerAreaMarginLeft");
        this.q0 = (SeekBarDialogPreference) h0("triggerAreaMarginTop");
        this.r0 = (SeekBarDialogPreference) h0("cursorAreaWidth");
        this.s0 = (SeekBarDialogPreference) h0("cursorAreaHeight");
        this.t0 = (SeekBarDialogPreference) h0("cursorAreaMarginLeft");
        this.u0 = (SeekBarDialogPreference) h0("cursorAreaMarginTop");
        this.v0 = (SeekBarDialogPreference) h0("trackerAreaCursorScaleValue");
        this.w0 = (SeekBarDialogPreference) h0("trackerAreaWidth");
        this.x0 = (SeekBarDialogPreference) h0("trackerAreaHeight");
        this.y0 = (SeekBarDialogPreference) h0("trackerAreaMarginLeft");
        this.z0 = (SeekBarDialogPreference) h0("trackerAreaMarginTop");
        this.A0 = (SwitchPreference) h0("trackerAreaCursorScale");
        this.n0.c0 = ey0.c();
        this.p0.c0 = ey0.c();
        this.w0.c0 = ey0.c();
        this.y0.c0 = ey0.c();
        this.r0.c0 = ey0.c();
        this.r0.b0 = ey0.c();
        this.t0.c0 = ey0.c();
        final int i = 2;
        this.s0.b0 = ey0.b() / 2;
        this.s0.c0 = ey0.b();
        this.u0.c0 = ey0.b();
        this.o0.c0 = ey0.b();
        this.q0.c0 = ey0.b();
        this.x0.c0 = ey0.b();
        this.z0.c0 = ey0.b();
        SeekBarDialogPreference seekBarDialogPreference = this.v0;
        final Object[] objArr = null == true ? 1 : 0;
        seekBarDialogPreference.f = new zp0(this) { // from class: r4
            public final /* synthetic */ t4 c;

            {
                this.c = this;
            }

            @Override // defpackage.zp0
            public final boolean a(Preference preference, Object obj) {
                int i2 = objArr;
                t4 t4Var = this.c;
                switch (i2) {
                    case 0:
                        t4Var.p0(obj);
                        break;
                    case 1:
                        t4Var.v0.L((int) (((((Integer) obj).intValue() * 1.0f) / t4Var.k0.c().j()) * 100.0f));
                        break;
                    case 2:
                        b61.b(new c(6, t4Var), 1L);
                        break;
                    default:
                        f91 f91Var = t4Var.k0;
                        if (t4Var.A0.O) {
                            SeekBarDialogPreference seekBarDialogPreference2 = t4Var.r0;
                            SeekBarDialogPreference seekBarDialogPreference3 = t4Var.w0;
                            if (preference != seekBarDialogPreference2) {
                                seekBarDialogPreference3.L((int) ((f91Var.c().j() * t4Var.v0.d0) / 100.0f));
                                t4Var.x0.L((int) (((((Integer) obj).intValue() * 1.0f) * t4Var.v0.d0) / 100.0f));
                            } else {
                                seekBarDialogPreference3.L((int) (((((Integer) obj).intValue() * 1.0f) * t4Var.v0.d0) / 100.0f));
                                t4Var.x0.L((int) ((f91Var.c().b() * t4Var.v0.d0) / 100.0f));
                            }
                        }
                        break;
                }
                return true;
            }
        };
        final int i2 = 1;
        this.w0.f = new zp0(this) { // from class: r4
            public final /* synthetic */ t4 c;

            {
                this.c = this;
            }

            @Override // defpackage.zp0
            public final boolean a(Preference preference, Object obj) {
                int i22 = i2;
                t4 t4Var = this.c;
                switch (i22) {
                    case 0:
                        t4Var.p0(obj);
                        break;
                    case 1:
                        t4Var.v0.L((int) (((((Integer) obj).intValue() * 1.0f) / t4Var.k0.c().j()) * 100.0f));
                        break;
                    case 2:
                        b61.b(new c(6, t4Var), 1L);
                        break;
                    default:
                        f91 f91Var = t4Var.k0;
                        if (t4Var.A0.O) {
                            SeekBarDialogPreference seekBarDialogPreference2 = t4Var.r0;
                            SeekBarDialogPreference seekBarDialogPreference3 = t4Var.w0;
                            if (preference != seekBarDialogPreference2) {
                                seekBarDialogPreference3.L((int) ((f91Var.c().j() * t4Var.v0.d0) / 100.0f));
                                t4Var.x0.L((int) (((((Integer) obj).intValue() * 1.0f) * t4Var.v0.d0) / 100.0f));
                            } else {
                                seekBarDialogPreference3.L((int) (((((Integer) obj).intValue() * 1.0f) * t4Var.v0.d0) / 100.0f));
                                t4Var.x0.L((int) ((f91Var.c().b() * t4Var.v0.d0) / 100.0f));
                            }
                        }
                        break;
                }
                return true;
            }
        };
        this.A0.f = new zp0(this) { // from class: r4
            public final /* synthetic */ t4 c;

            {
                this.c = this;
            }

            @Override // defpackage.zp0
            public final boolean a(Preference preference, Object obj) {
                int i22 = i;
                t4 t4Var = this.c;
                switch (i22) {
                    case 0:
                        t4Var.p0(obj);
                        break;
                    case 1:
                        t4Var.v0.L((int) (((((Integer) obj).intValue() * 1.0f) / t4Var.k0.c().j()) * 100.0f));
                        break;
                    case 2:
                        b61.b(new c(6, t4Var), 1L);
                        break;
                    default:
                        f91 f91Var = t4Var.k0;
                        if (t4Var.A0.O) {
                            SeekBarDialogPreference seekBarDialogPreference2 = t4Var.r0;
                            SeekBarDialogPreference seekBarDialogPreference3 = t4Var.w0;
                            if (preference != seekBarDialogPreference2) {
                                seekBarDialogPreference3.L((int) ((f91Var.c().j() * t4Var.v0.d0) / 100.0f));
                                t4Var.x0.L((int) (((((Integer) obj).intValue() * 1.0f) * t4Var.v0.d0) / 100.0f));
                            } else {
                                seekBarDialogPreference3.L((int) (((((Integer) obj).intValue() * 1.0f) * t4Var.v0.d0) / 100.0f));
                                t4Var.x0.L((int) ((f91Var.c().b() * t4Var.v0.d0) / 100.0f));
                            }
                        }
                        break;
                }
                return true;
            }
        };
        final int i3 = 3;
        this.r0.f = new zp0(this) { // from class: r4
            public final /* synthetic */ t4 c;

            {
                this.c = this;
            }

            @Override // defpackage.zp0
            public final boolean a(Preference preference, Object obj) {
                int i22 = i3;
                t4 t4Var = this.c;
                switch (i22) {
                    case 0:
                        t4Var.p0(obj);
                        break;
                    case 1:
                        t4Var.v0.L((int) (((((Integer) obj).intValue() * 1.0f) / t4Var.k0.c().j()) * 100.0f));
                        break;
                    case 2:
                        b61.b(new c(6, t4Var), 1L);
                        break;
                    default:
                        f91 f91Var = t4Var.k0;
                        if (t4Var.A0.O) {
                            SeekBarDialogPreference seekBarDialogPreference2 = t4Var.r0;
                            SeekBarDialogPreference seekBarDialogPreference3 = t4Var.w0;
                            if (preference != seekBarDialogPreference2) {
                                seekBarDialogPreference3.L((int) ((f91Var.c().j() * t4Var.v0.d0) / 100.0f));
                                t4Var.x0.L((int) (((((Integer) obj).intValue() * 1.0f) * t4Var.v0.d0) / 100.0f));
                            } else {
                                seekBarDialogPreference3.L((int) (((((Integer) obj).intValue() * 1.0f) * t4Var.v0.d0) / 100.0f));
                                t4Var.x0.L((int) ((f91Var.c().b() * t4Var.v0.d0) / 100.0f));
                            }
                        }
                        break;
                }
                return true;
            }
        };
        this.s0.f = new zp0(this) { // from class: r4
            public final /* synthetic */ t4 c;

            {
                this.c = this;
            }

            @Override // defpackage.zp0
            public final boolean a(Preference preference, Object obj) {
                int i22 = i3;
                t4 t4Var = this.c;
                switch (i22) {
                    case 0:
                        t4Var.p0(obj);
                        break;
                    case 1:
                        t4Var.v0.L((int) (((((Integer) obj).intValue() * 1.0f) / t4Var.k0.c().j()) * 100.0f));
                        break;
                    case 2:
                        b61.b(new c(6, t4Var), 1L);
                        break;
                    default:
                        f91 f91Var = t4Var.k0;
                        if (t4Var.A0.O) {
                            SeekBarDialogPreference seekBarDialogPreference2 = t4Var.r0;
                            SeekBarDialogPreference seekBarDialogPreference3 = t4Var.w0;
                            if (preference != seekBarDialogPreference2) {
                                seekBarDialogPreference3.L((int) ((f91Var.c().j() * t4Var.v0.d0) / 100.0f));
                                t4Var.x0.L((int) (((((Integer) obj).intValue() * 1.0f) * t4Var.v0.d0) / 100.0f));
                            } else {
                                seekBarDialogPreference3.L((int) (((((Integer) obj).intValue() * 1.0f) * t4Var.v0.d0) / 100.0f));
                                t4Var.x0.L((int) ((f91Var.c().b() * t4Var.v0.d0) / 100.0f));
                            }
                        }
                        break;
                }
                return true;
            }
        };
        EditTextPreference editTextPreference = this.m0;
        f91 f91Var = this.k0;
        editTextPreference.K(f91Var.g());
        this.n0.L(f91Var.h().f());
        this.o0.L(f91Var.h().c());
        this.p0.L(f91Var.h().d());
        this.q0.L(f91Var.h().e());
        this.r0.L(f91Var.c().f());
        this.s0.L(f91Var.c().c());
        this.t0.L(f91Var.c().d());
        this.u0.L(f91Var.c().e());
        this.w0.L(f91Var.f().f());
        this.x0.L(f91Var.f().c());
        this.y0.L(f91Var.f().d());
        this.z0.L(f91Var.f().e());
        this.A0.J(((int) ((f91Var.c().j() / f91Var.c().b()) * 100.0f)) == ((int) ((f91Var.f().j() / f91Var.f().b()) * 100.0f)));
        this.v0.L((int) ((f91Var.f().j() / f91Var.c().j()) * 100.0f));
        q0();
        this.l0.c(-1, f91Var);
    }

    @Override // defpackage.hr
    public final void m0(SharedPreferences sharedPreferences, String str) {
        String str2 = this.m0.U;
        f91 f91Var = this.k0;
        f91Var.m(str2);
        f91Var.h().o(this.n0.d0);
        f91Var.h().k(this.o0.d0);
        f91Var.h().m(this.p0.d0);
        f91Var.h().n(this.q0.d0);
        f91Var.c().o(this.r0.d0);
        f91Var.c().k(this.s0.d0);
        f91Var.c().m(this.t0.d0);
        f91Var.c().n(this.u0.d0);
        f91Var.f().o(this.w0.d0);
        f91Var.f().k(this.x0.d0);
        f91Var.f().m(this.y0.d0);
        f91Var.f().n(this.z0.d0);
        this.l0.c(-1, f91Var);
        this.j0.a(new s4(0));
    }

    public final void p0(Object obj) {
        SeekBarDialogPreference seekBarDialogPreference = this.w0;
        f91 f91Var = this.k0;
        Integer num = (Integer) obj;
        seekBarDialogPreference.L((num.intValue() * ((int) f91Var.c().j())) / 100);
        this.x0.L((num.intValue() * ((int) f91Var.c().b())) / 100);
    }

    public final void q0() {
        this.v0.B(this.A0.O);
        this.w0.B(!this.A0.O);
        this.x0.B(!this.A0.O);
        if (this.A0.O) {
            p0(Integer.valueOf(this.v0.d0));
        }
    }

    @Override // defpackage.hr
    public final void o0(SharedPreferences.Editor editor) {
    }
}
