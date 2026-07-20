package com.quickcursor.android.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.FeatureInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatButton;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.quickcursor.R;
import com.quickcursor.android.activities.AboutActivity;
import com.quickcursor.android.activities.SettingsActivity;
import com.quickcursor.android.preferences.ButtonPreference;
import com.quickcursor.android.preferences.DetailedListPreference;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import com.quickcursor.android.services.CursorAccessibilityService;
import defpackage.bk;
import defpackage.di0;
import defpackage.ey0;
import defpackage.ir;
import defpackage.ix;
import defpackage.jv;
import defpackage.jz0;
import defpackage.kx0;
import defpackage.lc1;
import defpackage.ld;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.s4;
import defpackage.wj;
import defpackage.y30;
import defpackage.zp0;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class SettingsActivity extends wj {
    public static final /* synthetic */ int C = 0;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir {
        public final bk h0 = new bk(100);
        public DetailedListPreference i0;
        public DetailedListPreference j0;
        public SeekBarDialogPreference k0;
        public SeekBarDialogPreference l0;
        public di0 m0;
        public ButtonPreference n0;
        public SwitchPreference o0;

        @Override // defpackage.j30
        public final void R() {
            this.F = true;
            ButtonPreference buttonPreference = this.n0;
            String string = buttonPreference.b.getString(ey0.d() ? R.string.settings_triggers_portrait_title : R.string.settings_triggers_landscape_title);
            if (!TextUtils.equals(string, buttonPreference.i)) {
                buttonPreference.i = string;
                buttonPreference.k();
            }
            ButtonPreference buttonPreference2 = this.n0;
            String string2 = buttonPreference2.b.getResources().getString(ey0.d() ? R.string.settings_triggers_orientation_landscape : R.string.settings_triggers_orientation_portrait);
            buttonPreference2.P = string2;
            AppCompatButton appCompatButton = buttonPreference2.R;
            if (appCompatButton != null) {
                appCompatButton.setText(string2);
            }
        }

        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            Integer numValueOf = Integer.valueOf(R.drawable.icon_settings);
            ey0.e(o());
            k0(str, R.xml.preferences_settings);
            this.o0 = (SwitchPreference) h0(oq0.S0.name());
            this.m0 = (di0) Z();
            this.k0 = (SeekBarDialogPreference) h0("keyboardAboveExtra");
            this.l0 = (SeekBarDialogPreference) h0("keyboardThinnerPercentage");
            DetailedListPreference detailedListPreference = (DetailedListPreference) h0("keyboardTriggersHandle");
            this.i0 = detailedListPreference;
            final int i = 0;
            detailedListPreference.f = new zp0(this) { // from class: hz0
                public final /* synthetic */ SettingsActivity.a c;

                {
                    this.c = this;
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
                @Override // defpackage.zp0
                public final boolean a(Preference preference, Object obj) {
                    int i2 = i;
                    final int i3 = 2;
                    Object[] objArr = 0;
                    final int i4 = 1;
                    final SettingsActivity.a aVar = this.c;
                    switch (i2) {
                        case 0:
                            String str2 = (String) obj;
                            aVar.i0.O((qq0.p(str2) == 2 || qq0.p(str2) == 3) ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.j0.F(qq0.p(str2) != 4);
                            aVar.l0();
                            break;
                        case 1:
                            aVar.j0.O(qq0.o((String) obj) == 2 ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.l0();
                            break;
                        case 2:
                            aVar.l0();
                            break;
                        case 3:
                            String str3 = (String) obj;
                            if (str3 == null || str3.isEmpty()) {
                                f01.k = null;
                            } else {
                                try {
                                    f01.k = new g7(str3);
                                } catch (Exception e) {
                                    si0.b("iconPackChanged exception: " + e);
                                }
                            }
                            aVar.h0.a(new s4(15));
                            break;
                        case 4:
                            String str4 = (String) obj;
                            si0.b("New language: " + str4);
                            if (str4.equalsIgnoreCase("help")) {
                                z7 z7VarZ = aVar.Z();
                                Intent intent = new Intent(z7VarZ, (Class<?>) AboutActivity.class);
                                intent.putExtra("BUNDLE_TRANSLATION", true);
                                z7VarZ.startActivity(intent);
                            } else if (str4.contains("-")) {
                                String[] strArrSplit = str4.split("-");
                                di0 di0Var = aVar.m0;
                                Locale locale = new Locale(strArrSplit[0], strArrSplit[1]);
                                di0Var.getClass();
                                di0Var.E().c(di0Var, locale);
                            } else {
                                di0 di0Var2 = aVar.m0;
                                di0Var2.getClass();
                                ei0 ei0VarE = di0Var2.E();
                                ei0VarE.getClass();
                                ei0VarE.c(di0Var2, new Locale(str4));
                            }
                            break;
                        default:
                            if (!((Boolean) obj).booleanValue()) {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.settings_material_you_coloring_disable_dialog_title);
                                jl1Var.g(R.string.settings_material_you_coloring_disable_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.settings_material_you_coloring_disable_dialog_keep, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = i4;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.i(R.string.dialog_button_default, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = i3;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.dialog_button_cancel, null);
                                jl1Var.n();
                            } else {
                                jl1 jl1Var2 = new jl1(aVar.o());
                                jl1Var2.m(R.string.are_you_sure);
                                jl1Var2.g(R.string.settings_material_you_coloring_dialog_message);
                                ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                                final Object[] objArr2 = objArr == true ? 1 : 0;
                                jl1Var2.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = objArr2;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var2.h(android.R.string.no, null);
                                jl1Var2.n();
                            }
                            break;
                    }
                    return false;
                }
            };
            detailedListPreference.e0 = new jz0(this, 0);
            pn0 pn0VarT = pn0.t();
            detailedListPreference.O((pn0VarT.B() || pn0VarT.C()) ? numValueOf : null);
            DetailedListPreference detailedListPreference2 = (DetailedListPreference) h0("keyboardTrackerHandle");
            this.j0 = detailedListPreference2;
            boolean z = true;
            final char c = 1 == true ? 1 : 0;
            detailedListPreference2.f = new zp0(this) { // from class: hz0
                public final /* synthetic */ SettingsActivity.a c;

                {
                    this.c = this;
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
                @Override // defpackage.zp0
                public final boolean a(Preference preference, Object obj) {
                    int i2 = c;
                    final int i3 = 2;
                    Object[] objArr = 0;
                    final int i4 = 1;
                    final SettingsActivity.a aVar = this.c;
                    switch (i2) {
                        case 0:
                            String str2 = (String) obj;
                            aVar.i0.O((qq0.p(str2) == 2 || qq0.p(str2) == 3) ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.j0.F(qq0.p(str2) != 4);
                            aVar.l0();
                            break;
                        case 1:
                            aVar.j0.O(qq0.o((String) obj) == 2 ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.l0();
                            break;
                        case 2:
                            aVar.l0();
                            break;
                        case 3:
                            String str3 = (String) obj;
                            if (str3 == null || str3.isEmpty()) {
                                f01.k = null;
                            } else {
                                try {
                                    f01.k = new g7(str3);
                                } catch (Exception e) {
                                    si0.b("iconPackChanged exception: " + e);
                                }
                            }
                            aVar.h0.a(new s4(15));
                            break;
                        case 4:
                            String str4 = (String) obj;
                            si0.b("New language: " + str4);
                            if (str4.equalsIgnoreCase("help")) {
                                z7 z7VarZ = aVar.Z();
                                Intent intent = new Intent(z7VarZ, (Class<?>) AboutActivity.class);
                                intent.putExtra("BUNDLE_TRANSLATION", true);
                                z7VarZ.startActivity(intent);
                            } else if (str4.contains("-")) {
                                String[] strArrSplit = str4.split("-");
                                di0 di0Var = aVar.m0;
                                Locale locale = new Locale(strArrSplit[0], strArrSplit[1]);
                                di0Var.getClass();
                                di0Var.E().c(di0Var, locale);
                            } else {
                                di0 di0Var2 = aVar.m0;
                                di0Var2.getClass();
                                ei0 ei0VarE = di0Var2.E();
                                ei0VarE.getClass();
                                ei0VarE.c(di0Var2, new Locale(str4));
                            }
                            break;
                        default:
                            if (!((Boolean) obj).booleanValue()) {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.settings_material_you_coloring_disable_dialog_title);
                                jl1Var.g(R.string.settings_material_you_coloring_disable_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.settings_material_you_coloring_disable_dialog_keep, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = i4;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.i(R.string.dialog_button_default, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = i3;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.dialog_button_cancel, null);
                                jl1Var.n();
                            } else {
                                jl1 jl1Var2 = new jl1(aVar.o());
                                jl1Var2.m(R.string.are_you_sure);
                                jl1Var2.g(R.string.settings_material_you_coloring_dialog_message);
                                ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                                final int objArr2 = objArr == true ? 1 : 0;
                                jl1Var2.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = objArr2;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var2.h(android.R.string.no, null);
                                jl1Var2.n();
                            }
                            break;
                    }
                    return false;
                }
            };
            detailedListPreference2.e0 = new jz0(this, 1);
            final int i2 = 2;
            if (pn0.t().u() != 2) {
                numValueOf = null;
            }
            detailedListPreference2.O(numValueOf);
            final int i3 = 4;
            this.j0.F(!(pn0.t().v() == 4));
            h0("systemGestureOverlap").f = new zp0(this) { // from class: hz0
                public final /* synthetic */ SettingsActivity.a c;

                {
                    this.c = this;
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
                @Override // defpackage.zp0
                public final boolean a(Preference preference, Object obj) {
                    int i22 = i2;
                    final int i32 = 2;
                    Object[] objArr = 0;
                    final int i4 = 1;
                    final SettingsActivity.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            String str2 = (String) obj;
                            aVar.i0.O((qq0.p(str2) == 2 || qq0.p(str2) == 3) ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.j0.F(qq0.p(str2) != 4);
                            aVar.l0();
                            break;
                        case 1:
                            aVar.j0.O(qq0.o((String) obj) == 2 ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.l0();
                            break;
                        case 2:
                            aVar.l0();
                            break;
                        case 3:
                            String str3 = (String) obj;
                            if (str3 == null || str3.isEmpty()) {
                                f01.k = null;
                            } else {
                                try {
                                    f01.k = new g7(str3);
                                } catch (Exception e) {
                                    si0.b("iconPackChanged exception: " + e);
                                }
                            }
                            aVar.h0.a(new s4(15));
                            break;
                        case 4:
                            String str4 = (String) obj;
                            si0.b("New language: " + str4);
                            if (str4.equalsIgnoreCase("help")) {
                                z7 z7VarZ = aVar.Z();
                                Intent intent = new Intent(z7VarZ, (Class<?>) AboutActivity.class);
                                intent.putExtra("BUNDLE_TRANSLATION", true);
                                z7VarZ.startActivity(intent);
                            } else if (str4.contains("-")) {
                                String[] strArrSplit = str4.split("-");
                                di0 di0Var = aVar.m0;
                                Locale locale = new Locale(strArrSplit[0], strArrSplit[1]);
                                di0Var.getClass();
                                di0Var.E().c(di0Var, locale);
                            } else {
                                di0 di0Var2 = aVar.m0;
                                di0Var2.getClass();
                                ei0 ei0VarE = di0Var2.E();
                                ei0VarE.getClass();
                                ei0VarE.c(di0Var2, new Locale(str4));
                            }
                            break;
                        default:
                            if (!((Boolean) obj).booleanValue()) {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.settings_material_you_coloring_disable_dialog_title);
                                jl1Var.g(R.string.settings_material_you_coloring_disable_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.settings_material_you_coloring_disable_dialog_keep, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = i4;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.i(R.string.dialog_button_default, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = i32;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.dialog_button_cancel, null);
                                jl1Var.n();
                            } else {
                                jl1 jl1Var2 = new jl1(aVar.o());
                                jl1Var2.m(R.string.are_you_sure);
                                jl1Var2.g(R.string.settings_material_you_coloring_dialog_message);
                                ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                                final int objArr2 = objArr == true ? 1 : 0;
                                jl1Var2.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = objArr2;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var2.h(android.R.string.no, null);
                                jl1Var2.n();
                            }
                            break;
                    }
                    return false;
                }
            };
            h0("disabledWhileSPenDetached").f = new zp0(this) { // from class: hz0
                public final /* synthetic */ SettingsActivity.a c;

                {
                    this.c = this;
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
                @Override // defpackage.zp0
                public final boolean a(Preference preference, Object obj) {
                    int i22 = i2;
                    final int i32 = 2;
                    Object[] objArr = 0;
                    final int i4 = 1;
                    final SettingsActivity.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            String str2 = (String) obj;
                            aVar.i0.O((qq0.p(str2) == 2 || qq0.p(str2) == 3) ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.j0.F(qq0.p(str2) != 4);
                            aVar.l0();
                            break;
                        case 1:
                            aVar.j0.O(qq0.o((String) obj) == 2 ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.l0();
                            break;
                        case 2:
                            aVar.l0();
                            break;
                        case 3:
                            String str3 = (String) obj;
                            if (str3 == null || str3.isEmpty()) {
                                f01.k = null;
                            } else {
                                try {
                                    f01.k = new g7(str3);
                                } catch (Exception e) {
                                    si0.b("iconPackChanged exception: " + e);
                                }
                            }
                            aVar.h0.a(new s4(15));
                            break;
                        case 4:
                            String str4 = (String) obj;
                            si0.b("New language: " + str4);
                            if (str4.equalsIgnoreCase("help")) {
                                z7 z7VarZ = aVar.Z();
                                Intent intent = new Intent(z7VarZ, (Class<?>) AboutActivity.class);
                                intent.putExtra("BUNDLE_TRANSLATION", true);
                                z7VarZ.startActivity(intent);
                            } else if (str4.contains("-")) {
                                String[] strArrSplit = str4.split("-");
                                di0 di0Var = aVar.m0;
                                Locale locale = new Locale(strArrSplit[0], strArrSplit[1]);
                                di0Var.getClass();
                                di0Var.E().c(di0Var, locale);
                            } else {
                                di0 di0Var2 = aVar.m0;
                                di0Var2.getClass();
                                ei0 ei0VarE = di0Var2.E();
                                ei0VarE.getClass();
                                ei0VarE.c(di0Var2, new Locale(str4));
                            }
                            break;
                        default:
                            if (!((Boolean) obj).booleanValue()) {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.settings_material_you_coloring_disable_dialog_title);
                                jl1Var.g(R.string.settings_material_you_coloring_disable_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.settings_material_you_coloring_disable_dialog_keep, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = i4;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.i(R.string.dialog_button_default, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = i32;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.dialog_button_cancel, null);
                                jl1Var.n();
                            } else {
                                jl1 jl1Var2 = new jl1(aVar.o());
                                jl1Var2.m(R.string.are_you_sure);
                                jl1Var2.g(R.string.settings_material_you_coloring_dialog_message);
                                ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                                final int objArr2 = objArr == true ? 1 : 0;
                                jl1Var2.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i5) {
                                        int i6 = objArr2;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i6) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var2.h(android.R.string.no, null);
                                jl1Var2.n();
                            }
                            break;
                    }
                    return false;
                }
            };
            Preference preferenceH0 = h0("disabledWhileSPenDetached");
            Context contextU = u();
            int i4 = kx0.d;
            FeatureInfo[] systemAvailableFeatures = contextU.getPackageManager().getSystemAvailableFeatures();
            int length = systemAvailableFeatures.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z = false;
                    break;
                } else if ("com.sec.feature.spen_usp".equalsIgnoreCase(systemAvailableFeatures[i5].name)) {
                    break;
                } else {
                    i5++;
                }
            }
            preferenceH0.F(z);
            final int i6 = 3;
            h0(oq0.b1.name()).f = new zp0(this) { // from class: hz0
                public final /* synthetic */ SettingsActivity.a c;

                {
                    this.c = this;
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
                @Override // defpackage.zp0
                public final boolean a(Preference preference, Object obj) {
                    int i22 = i6;
                    final int i32 = 2;
                    Object[] objArr = 0;
                    final int i42 = 1;
                    final SettingsActivity.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            String str2 = (String) obj;
                            aVar.i0.O((qq0.p(str2) == 2 || qq0.p(str2) == 3) ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.j0.F(qq0.p(str2) != 4);
                            aVar.l0();
                            break;
                        case 1:
                            aVar.j0.O(qq0.o((String) obj) == 2 ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.l0();
                            break;
                        case 2:
                            aVar.l0();
                            break;
                        case 3:
                            String str3 = (String) obj;
                            if (str3 == null || str3.isEmpty()) {
                                f01.k = null;
                            } else {
                                try {
                                    f01.k = new g7(str3);
                                } catch (Exception e) {
                                    si0.b("iconPackChanged exception: " + e);
                                }
                            }
                            aVar.h0.a(new s4(15));
                            break;
                        case 4:
                            String str4 = (String) obj;
                            si0.b("New language: " + str4);
                            if (str4.equalsIgnoreCase("help")) {
                                z7 z7VarZ = aVar.Z();
                                Intent intent = new Intent(z7VarZ, (Class<?>) AboutActivity.class);
                                intent.putExtra("BUNDLE_TRANSLATION", true);
                                z7VarZ.startActivity(intent);
                            } else if (str4.contains("-")) {
                                String[] strArrSplit = str4.split("-");
                                di0 di0Var = aVar.m0;
                                Locale locale = new Locale(strArrSplit[0], strArrSplit[1]);
                                di0Var.getClass();
                                di0Var.E().c(di0Var, locale);
                            } else {
                                di0 di0Var2 = aVar.m0;
                                di0Var2.getClass();
                                ei0 ei0VarE = di0Var2.E();
                                ei0VarE.getClass();
                                ei0VarE.c(di0Var2, new Locale(str4));
                            }
                            break;
                        default:
                            if (!((Boolean) obj).booleanValue()) {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.settings_material_you_coloring_disable_dialog_title);
                                jl1Var.g(R.string.settings_material_you_coloring_disable_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.settings_material_you_coloring_disable_dialog_keep, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i52) {
                                        int i62 = i42;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i62) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.i(R.string.dialog_button_default, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i52) {
                                        int i62 = i32;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i62) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.dialog_button_cancel, null);
                                jl1Var.n();
                            } else {
                                jl1 jl1Var2 = new jl1(aVar.o());
                                jl1Var2.m(R.string.are_you_sure);
                                jl1Var2.g(R.string.settings_material_you_coloring_dialog_message);
                                ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                                final int objArr2 = objArr == true ? 1 : 0;
                                jl1Var2.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i52) {
                                        int i62 = objArr2;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i62) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var2.h(android.R.string.no, null);
                                jl1Var2.n();
                            }
                            break;
                    }
                    return false;
                }
            };
            ButtonPreference buttonPreference = (ButtonPreference) h0("triggers");
            this.n0 = buttonPreference;
            buttonPreference.O = new jz0(this, 2);
            ListPreference listPreference = (ListPreference) h0("language");
            listPreference.f = new zp0(this) { // from class: hz0
                public final /* synthetic */ SettingsActivity.a c;

                {
                    this.c = this;
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
                @Override // defpackage.zp0
                public final boolean a(Preference preference, Object obj) {
                    int i22 = i3;
                    final int i32 = 2;
                    Object[] objArr = 0;
                    final int i42 = 1;
                    final SettingsActivity.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            String str2 = (String) obj;
                            aVar.i0.O((qq0.p(str2) == 2 || qq0.p(str2) == 3) ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.j0.F(qq0.p(str2) != 4);
                            aVar.l0();
                            break;
                        case 1:
                            aVar.j0.O(qq0.o((String) obj) == 2 ? Integer.valueOf(R.drawable.icon_settings) : null);
                            aVar.l0();
                            break;
                        case 2:
                            aVar.l0();
                            break;
                        case 3:
                            String str3 = (String) obj;
                            if (str3 == null || str3.isEmpty()) {
                                f01.k = null;
                            } else {
                                try {
                                    f01.k = new g7(str3);
                                } catch (Exception e) {
                                    si0.b("iconPackChanged exception: " + e);
                                }
                            }
                            aVar.h0.a(new s4(15));
                            break;
                        case 4:
                            String str4 = (String) obj;
                            si0.b("New language: " + str4);
                            if (str4.equalsIgnoreCase("help")) {
                                z7 z7VarZ = aVar.Z();
                                Intent intent = new Intent(z7VarZ, (Class<?>) AboutActivity.class);
                                intent.putExtra("BUNDLE_TRANSLATION", true);
                                z7VarZ.startActivity(intent);
                            } else if (str4.contains("-")) {
                                String[] strArrSplit = str4.split("-");
                                di0 di0Var = aVar.m0;
                                Locale locale = new Locale(strArrSplit[0], strArrSplit[1]);
                                di0Var.getClass();
                                di0Var.E().c(di0Var, locale);
                            } else {
                                di0 di0Var2 = aVar.m0;
                                di0Var2.getClass();
                                ei0 ei0VarE = di0Var2.E();
                                ei0VarE.getClass();
                                ei0VarE.c(di0Var2, new Locale(str4));
                            }
                            break;
                        default:
                            if (!((Boolean) obj).booleanValue()) {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.settings_material_you_coloring_disable_dialog_title);
                                jl1Var.g(R.string.settings_material_you_coloring_disable_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.settings_material_you_coloring_disable_dialog_keep, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i52) {
                                        int i62 = i42;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i62) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.i(R.string.dialog_button_default, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i52) {
                                        int i62 = i32;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i62) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.dialog_button_cancel, null);
                                jl1Var.n();
                            } else {
                                jl1 jl1Var2 = new jl1(aVar.o());
                                jl1Var2.m(R.string.are_you_sure);
                                jl1Var2.g(R.string.settings_material_you_coloring_dialog_message);
                                ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                                final int objArr2 = objArr == true ? 1 : 0;
                                jl1Var2.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: iz0
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i52) {
                                        int i62 = objArr2;
                                        SettingsActivity.a aVar2 = aVar;
                                        switch (i62) {
                                            case 0:
                                                aVar2.o0.J(true);
                                                pn0.t().T(true);
                                                i9.f(aVar2.o(), true);
                                                break;
                                            case 1:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                break;
                                            default:
                                                aVar2.o0.J(false);
                                                pn0.t().T(false);
                                                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                oq0.g(editorEdit, oq0.c0);
                                                oq0.g(editorEdit, oq0.r0);
                                                oq0.g(editorEdit, oq0.W);
                                                oq0.g(editorEdit, oq0.Z);
                                                oq0.g(editorEdit, oq0.e0);
                                                oq0.g(editorEdit, oq0.y0);
                                                oq0.g(editorEdit, oq0.w0);
                                                oq0.g(editorEdit, oq0.C0);
                                                oq0.g(editorEdit, oq0.A0);
                                                for (uv0 uv0Var : xv0.d.c.values()) {
                                                    ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                    arrayList.addAll(uv0Var.d().c());
                                                    int size = arrayList.size();
                                                    int i7 = 0;
                                                    while (i7 < size) {
                                                        Object obj2 = arrayList.get(i7);
                                                        i7++;
                                                        f91 f91Var = (f91) obj2;
                                                        da1 da1VarD = f91Var.d();
                                                        int i8 = dn.O2;
                                                        da1VarD.t(i8);
                                                        da1VarD.u(i8);
                                                        da1VarD.z(dn.P2);
                                                        q91 q91VarJ = f91Var.b().j();
                                                        q91VarJ.o(dn.N0);
                                                        q91VarJ.p(dn.O0);
                                                        q91VarJ.q(dn.P0);
                                                        q91VarJ.m(dn.Q0);
                                                        o91 o91VarB = f91Var.b().b();
                                                        o91VarB.h(dn.U0);
                                                        o91VarB.g(dn.V0);
                                                    }
                                                }
                                                xv0.d.c();
                                                editorEdit.apply();
                                                si0.b("Material You turned off. Reverting colors to default.");
                                                CursorAccessibilityService.k(true);
                                                break;
                                        }
                                    }
                                });
                                jl1Var2.h(android.R.string.no, null);
                                jl1Var2.n();
                            }
                            break;
                    }
                    return false;
                }
            };
            di0 di0Var = this.m0;
            di0Var.E().getClass();
            Locale localeG = ix.g(di0Var);
            Locale localeH = ix.h(di0Var);
            if (localeH != null) {
                localeG = localeH;
            } else {
                ix.k(di0Var, localeG);
            }
            listPreference.M(localeG.toLanguageTag());
            listPreference.u = Locale.getDefault().getLanguage();
            boolean zA = jv.a();
            SwitchPreference switchPreference = this.o0;
            if (!zA) {
                switchPreference.F(false);
            } else {
                final int i7 = 5;
                switchPreference.f = new zp0(this) { // from class: hz0
                    public final /* synthetic */ SettingsActivity.a c;

                    {
                        this.c = this;
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
                    @Override // defpackage.zp0
                    public final boolean a(Preference preference, Object obj) {
                        int i22 = i7;
                        final int i32 = 2;
                        Object[] objArr = 0;
                        final int i42 = 1;
                        final SettingsActivity.a aVar = this.c;
                        switch (i22) {
                            case 0:
                                String str2 = (String) obj;
                                aVar.i0.O((qq0.p(str2) == 2 || qq0.p(str2) == 3) ? Integer.valueOf(R.drawable.icon_settings) : null);
                                aVar.j0.F(qq0.p(str2) != 4);
                                aVar.l0();
                                break;
                            case 1:
                                aVar.j0.O(qq0.o((String) obj) == 2 ? Integer.valueOf(R.drawable.icon_settings) : null);
                                aVar.l0();
                                break;
                            case 2:
                                aVar.l0();
                                break;
                            case 3:
                                String str3 = (String) obj;
                                if (str3 == null || str3.isEmpty()) {
                                    f01.k = null;
                                } else {
                                    try {
                                        f01.k = new g7(str3);
                                    } catch (Exception e) {
                                        si0.b("iconPackChanged exception: " + e);
                                    }
                                }
                                aVar.h0.a(new s4(15));
                                break;
                            case 4:
                                String str4 = (String) obj;
                                si0.b("New language: " + str4);
                                if (str4.equalsIgnoreCase("help")) {
                                    z7 z7VarZ = aVar.Z();
                                    Intent intent = new Intent(z7VarZ, (Class<?>) AboutActivity.class);
                                    intent.putExtra("BUNDLE_TRANSLATION", true);
                                    z7VarZ.startActivity(intent);
                                } else if (str4.contains("-")) {
                                    String[] strArrSplit = str4.split("-");
                                    di0 di0Var2 = aVar.m0;
                                    Locale locale = new Locale(strArrSplit[0], strArrSplit[1]);
                                    di0Var2.getClass();
                                    di0Var2.E().c(di0Var2, locale);
                                } else {
                                    di0 di0Var22 = aVar.m0;
                                    di0Var22.getClass();
                                    ei0 ei0VarE = di0Var22.E();
                                    ei0VarE.getClass();
                                    ei0VarE.c(di0Var22, new Locale(str4));
                                }
                                break;
                            default:
                                if (!((Boolean) obj).booleanValue()) {
                                    jl1 jl1Var = new jl1(aVar.o());
                                    jl1Var.m(R.string.settings_material_you_coloring_disable_dialog_title);
                                    jl1Var.g(R.string.settings_material_you_coloring_disable_dialog_message);
                                    ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                    jl1Var.k(R.string.settings_material_you_coloring_disable_dialog_keep, new DialogInterface.OnClickListener() { // from class: iz0
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i52) {
                                            int i62 = i42;
                                            SettingsActivity.a aVar2 = aVar;
                                            switch (i62) {
                                                case 0:
                                                    aVar2.o0.J(true);
                                                    pn0.t().T(true);
                                                    i9.f(aVar2.o(), true);
                                                    break;
                                                case 1:
                                                    aVar2.o0.J(false);
                                                    pn0.t().T(false);
                                                    break;
                                                default:
                                                    aVar2.o0.J(false);
                                                    pn0.t().T(false);
                                                    SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                    oq0.g(editorEdit, oq0.c0);
                                                    oq0.g(editorEdit, oq0.r0);
                                                    oq0.g(editorEdit, oq0.W);
                                                    oq0.g(editorEdit, oq0.Z);
                                                    oq0.g(editorEdit, oq0.e0);
                                                    oq0.g(editorEdit, oq0.y0);
                                                    oq0.g(editorEdit, oq0.w0);
                                                    oq0.g(editorEdit, oq0.C0);
                                                    oq0.g(editorEdit, oq0.A0);
                                                    for (uv0 uv0Var : xv0.d.c.values()) {
                                                        ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                        arrayList.addAll(uv0Var.d().c());
                                                        int size = arrayList.size();
                                                        int i72 = 0;
                                                        while (i72 < size) {
                                                            Object obj2 = arrayList.get(i72);
                                                            i72++;
                                                            f91 f91Var = (f91) obj2;
                                                            da1 da1VarD = f91Var.d();
                                                            int i8 = dn.O2;
                                                            da1VarD.t(i8);
                                                            da1VarD.u(i8);
                                                            da1VarD.z(dn.P2);
                                                            q91 q91VarJ = f91Var.b().j();
                                                            q91VarJ.o(dn.N0);
                                                            q91VarJ.p(dn.O0);
                                                            q91VarJ.q(dn.P0);
                                                            q91VarJ.m(dn.Q0);
                                                            o91 o91VarB = f91Var.b().b();
                                                            o91VarB.h(dn.U0);
                                                            o91VarB.g(dn.V0);
                                                        }
                                                    }
                                                    xv0.d.c();
                                                    editorEdit.apply();
                                                    si0.b("Material You turned off. Reverting colors to default.");
                                                    CursorAccessibilityService.k(true);
                                                    break;
                                            }
                                        }
                                    });
                                    jl1Var.i(R.string.dialog_button_default, new DialogInterface.OnClickListener() { // from class: iz0
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i52) {
                                            int i62 = i32;
                                            SettingsActivity.a aVar2 = aVar;
                                            switch (i62) {
                                                case 0:
                                                    aVar2.o0.J(true);
                                                    pn0.t().T(true);
                                                    i9.f(aVar2.o(), true);
                                                    break;
                                                case 1:
                                                    aVar2.o0.J(false);
                                                    pn0.t().T(false);
                                                    break;
                                                default:
                                                    aVar2.o0.J(false);
                                                    pn0.t().T(false);
                                                    SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                    oq0.g(editorEdit, oq0.c0);
                                                    oq0.g(editorEdit, oq0.r0);
                                                    oq0.g(editorEdit, oq0.W);
                                                    oq0.g(editorEdit, oq0.Z);
                                                    oq0.g(editorEdit, oq0.e0);
                                                    oq0.g(editorEdit, oq0.y0);
                                                    oq0.g(editorEdit, oq0.w0);
                                                    oq0.g(editorEdit, oq0.C0);
                                                    oq0.g(editorEdit, oq0.A0);
                                                    for (uv0 uv0Var : xv0.d.c.values()) {
                                                        ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                        arrayList.addAll(uv0Var.d().c());
                                                        int size = arrayList.size();
                                                        int i72 = 0;
                                                        while (i72 < size) {
                                                            Object obj2 = arrayList.get(i72);
                                                            i72++;
                                                            f91 f91Var = (f91) obj2;
                                                            da1 da1VarD = f91Var.d();
                                                            int i8 = dn.O2;
                                                            da1VarD.t(i8);
                                                            da1VarD.u(i8);
                                                            da1VarD.z(dn.P2);
                                                            q91 q91VarJ = f91Var.b().j();
                                                            q91VarJ.o(dn.N0);
                                                            q91VarJ.p(dn.O0);
                                                            q91VarJ.q(dn.P0);
                                                            q91VarJ.m(dn.Q0);
                                                            o91 o91VarB = f91Var.b().b();
                                                            o91VarB.h(dn.U0);
                                                            o91VarB.g(dn.V0);
                                                        }
                                                    }
                                                    xv0.d.c();
                                                    editorEdit.apply();
                                                    si0.b("Material You turned off. Reverting colors to default.");
                                                    CursorAccessibilityService.k(true);
                                                    break;
                                            }
                                        }
                                    });
                                    jl1Var.h(R.string.dialog_button_cancel, null);
                                    jl1Var.n();
                                } else {
                                    jl1 jl1Var2 = new jl1(aVar.o());
                                    jl1Var2.m(R.string.are_you_sure);
                                    jl1Var2.g(R.string.settings_material_you_coloring_dialog_message);
                                    ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                                    final int objArr2 = objArr == true ? 1 : 0;
                                    jl1Var2.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: iz0
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i52) {
                                            int i62 = objArr2;
                                            SettingsActivity.a aVar2 = aVar;
                                            switch (i62) {
                                                case 0:
                                                    aVar2.o0.J(true);
                                                    pn0.t().T(true);
                                                    i9.f(aVar2.o(), true);
                                                    break;
                                                case 1:
                                                    aVar2.o0.J(false);
                                                    pn0.t().T(false);
                                                    break;
                                                default:
                                                    aVar2.o0.J(false);
                                                    pn0.t().T(false);
                                                    SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                                                    oq0.g(editorEdit, oq0.c0);
                                                    oq0.g(editorEdit, oq0.r0);
                                                    oq0.g(editorEdit, oq0.W);
                                                    oq0.g(editorEdit, oq0.Z);
                                                    oq0.g(editorEdit, oq0.e0);
                                                    oq0.g(editorEdit, oq0.y0);
                                                    oq0.g(editorEdit, oq0.w0);
                                                    oq0.g(editorEdit, oq0.C0);
                                                    oq0.g(editorEdit, oq0.A0);
                                                    for (uv0 uv0Var : xv0.d.c.values()) {
                                                        ArrayList arrayList = new ArrayList(uv0Var.l().l());
                                                        arrayList.addAll(uv0Var.d().c());
                                                        int size = arrayList.size();
                                                        int i72 = 0;
                                                        while (i72 < size) {
                                                            Object obj2 = arrayList.get(i72);
                                                            i72++;
                                                            f91 f91Var = (f91) obj2;
                                                            da1 da1VarD = f91Var.d();
                                                            int i8 = dn.O2;
                                                            da1VarD.t(i8);
                                                            da1VarD.u(i8);
                                                            da1VarD.z(dn.P2);
                                                            q91 q91VarJ = f91Var.b().j();
                                                            q91VarJ.o(dn.N0);
                                                            q91VarJ.p(dn.O0);
                                                            q91VarJ.q(dn.P0);
                                                            q91VarJ.m(dn.Q0);
                                                            o91 o91VarB = f91Var.b().b();
                                                            o91VarB.h(dn.U0);
                                                            o91VarB.g(dn.V0);
                                                        }
                                                    }
                                                    xv0.d.c();
                                                    editorEdit.apply();
                                                    si0.b("Material You turned off. Reverting colors to default.");
                                                    CursorAccessibilityService.k(true);
                                                    break;
                                            }
                                        }
                                    });
                                    jl1Var2.h(android.R.string.no, null);
                                    jl1Var2.n();
                                }
                                break;
                        }
                        return false;
                    }
                };
            }
        }

        public final void l0() {
            this.h0.a(new s4(15));
        }
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.preferences_activity);
        if (bundle == null) {
            y30 y30VarW = w();
            y30VarW.getClass();
            ld ldVar = new ld(y30VarW);
            ldVar.i(R.id.settings, new a());
            ldVar.e(false);
        }
        Optional.ofNullable(v()).ifPresent(new defpackage.a(13));
    }
}
