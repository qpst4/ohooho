package com.quickcursor.android.activities.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.quickcursor.R;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import defpackage.b61;
import defpackage.bk;
import defpackage.br;
import defpackage.d30;
import defpackage.f4;
import defpackage.fp1;
import defpackage.ir;
import defpackage.l11;
import defpackage.lc1;
import defpackage.ld;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.qq0;
import defpackage.s4;
import defpackage.wj;
import defpackage.y30;
import defpackage.yq;
import defpackage.zp0;
import defpackage.zq0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CursorSettings extends wj {
    public static final /* synthetic */ int D = 0;
    public final ArrayList C = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir implements zp0 {
        public CursorSettings i0;
        public Preference j0;
        public Preference k0;
        public final bk h0 = new bk(200);
        public final d30 l0 = (d30) Y(new br(this, 0), new f4(2));

        @Override // defpackage.gq0, defpackage.j30
        public final void T() {
            super.T();
            l0(pn0.t().m());
        }

        @Override // defpackage.zp0
        public final boolean a(Preference preference, Object obj) {
            if (preference.m.equals(oq0.b0.name())) {
                boolean zEquals = obj.equals("off");
                Preference preference2 = this.j0;
                if (zEquals) {
                    preference2.B(false);
                    this.k0.B(false);
                } else {
                    zq0 zq0Var = zq0.b;
                    preference2.B(zq0Var.c());
                    this.k0.B(zq0Var.c());
                }
            }
            CursorSettings cursorSettings = this.i0;
            Objects.requireNonNull(cursorSettings);
            b61.b(new defpackage.c(17, cursorSettings), 0L);
            this.h0.a(new s4(15));
            return true;
        }

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
        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            int iR;
            int iR2;
            k0(str, R.xml.preferences_cursor_settings);
            this.i0 = (CursorSettings) t();
            this.j0 = h0(oq0.c0.name());
            this.k0 = h0(oq0.d0.name());
            h0(oq0.q.name()).f = new br(this, 1 == true ? 1 : 0);
            oq0 oq0Var = oq0.r;
            SeekBarDialogPreference seekBarDialogPreference = (SeekBarDialogPreference) h0(oq0Var.name());
            seekBarDialogPreference.L((int) oq0.b((SharedPreferences) pn0.t().d, oq0Var));
            seekBarDialogPreference.f = this;
            oq0 oq0Var2 = oq0.s;
            h0(oq0Var2.name()).f = this;
            h0(oq0.t.name()).f = this;
            ((SeekBarDialogPreference) h0("cursorTipSize")).L((int) oq0.b((SharedPreferences) pn0.t().d, oq0Var2));
            oq0 oq0Var3 = oq0.u;
            SeekBarDialogPreference seekBarDialogPreference2 = (SeekBarDialogPreference) h0(oq0Var3.name());
            seekBarDialogPreference2.L((int) oq0.b((SharedPreferences) pn0.t().d, oq0Var3));
            seekBarDialogPreference2.f = this;
            h0(oq0.v.name()).f = this;
            h0(oq0.w.name()).f = this;
            h0(oq0.x.name()).f = this;
            h0("cursorTipPosition").g = new br(this, 2);
            oq0 oq0Var4 = oq0.b0;
            h0(oq0Var4.name()).f = this;
            Preference preference = this.j0;
            preference.f = this;
            this.k0.f = this;
            pn0 pn0VarT = pn0.t();
            pn0VarT.getClass();
            try {
                iR = qq0.r(oq0.d((SharedPreferences) pn0VarT.d, oq0Var4));
            } catch (Exception unused) {
                iR = qq0.r((String) oq0.b0.b);
            }
            preference.B(iR != 1);
            Preference preference2 = this.k0;
            pn0 pn0VarT2 = pn0.t();
            pn0VarT2.getClass();
            try {
                iR2 = qq0.r(oq0.d((SharedPreferences) pn0VarT2.d, oq0.b0));
            } catch (Exception unused2) {
                iR2 = qq0.r((String) oq0.b0.b);
            }
            preference2.B(iR2 != 1);
            h0("cursorResetDefault").g = new br(this, 3);
            h0("cursorDesignCustomImagePicker").g = new br(this, 4);
            fp1.o(this, Arrays.asList("cursorDesign", "cursorSize", "trailType", "cursorMirrored"));
        }

        public final void l0(int i) {
            PreferenceCategory preferenceCategory = (PreferenceCategory) this.Z.g.J("cursor_settings_visual");
            for (int i2 = 0; i2 < preferenceCategory.P.size(); i2++) {
                Preference preferenceK = preferenceCategory.K(i2);
                String str = preferenceK.m;
                if (str != null && str.startsWith("cursor_design_")) {
                    preferenceK.F(preferenceK.m.equals("cursor_design_".concat(l11.q(i))));
                }
            }
            h0(oq0.s.name()).F(i != 1);
            h0(oq0.t.name()).F(i != 1);
            CursorSettings.G(this.i0, yq.j(i));
            this.h0.a(new s4(15));
        }
    }

    public static void G(CursorSettings cursorSettings, yq yqVar) {
        cursorSettings.getClass();
        yqVar.m();
        ArrayList arrayList = cursorSettings.C;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((ImageView) obj).setImageDrawable(yqVar);
        }
        cursorSettings.H();
    }

    public final void H() {
        ArrayList arrayList = this.C;
        int i = 0;
        int paddingBottom = ((ImageView) arrayList.get(0)).getPaddingBottom() * 2;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ImageView imageView = (ImageView) obj;
            int iB = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.r);
            yq yqVar = (yq) imageView.getDrawable();
            yqVar.k();
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            int iIntValue = ((Integer) yqVar.d.first).intValue();
            int iIntValue2 = ((Integer) yqVar.d.second).intValue();
            yqVar.b = iIntValue;
            yqVar.c = iIntValue2;
            int i2 = iB + paddingBottom;
            layoutParams.width = i2;
            layoutParams.height = i2;
            imageView.setLayoutParams(layoutParams);
        }
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.cursor_settings_activity);
        if (bundle == null) {
            y30 y30VarW = w();
            y30VarW.getClass();
            ld ldVar = new ld(y30VarW);
            ldVar.i(R.id.settings, new a());
            ldVar.e(false);
        }
        Optional.ofNullable(v()).ifPresent(new defpackage.a(6));
        ImageView imageView = (ImageView) findViewById(R.id.imageViewCursorPreviewWhite);
        ArrayList arrayList = this.C;
        arrayList.add(imageView);
        arrayList.add((ImageView) findViewById(R.id.imageViewCursorPreviewBlack));
        arrayList.add((ImageView) findViewById(R.id.imageViewCursorPreviewGray));
        arrayList.add((ImageView) findViewById(R.id.imageViewCursorPreviewColor));
    }
}
