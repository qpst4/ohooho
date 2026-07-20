package com.quickcursor.android.activities.settings;

import android.os.Bundle;
import android.text.TextUtils;
import com.quickcursor.R;
import com.quickcursor.android.preferences.AppPickerPreference;
import defpackage.bk;
import defpackage.ir;
import defpackage.jg;
import defpackage.lc1;
import defpackage.ld;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.wj;
import defpackage.y30;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class BlacklistSettings extends wj {
    public static final /* synthetic */ int C = 0;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir {
        public final bk h0 = new bk(100);
        public AppPickerPreference i0;

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
        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            k0(str, R.xml.preferences_blacklist_settings);
            AppPickerPreference appPickerPreference = (AppPickerPreference) h0(oq0.h0.name());
            this.i0 = appPickerPreference;
            appPickerPreference.f = new jg(this, 0);
            h0(oq0.g0.name()).f = new jg(this, 1);
            h0("app_filter_reset").g = new jg(this, 2);
            AppPickerPreference appPickerPreference2 = this.i0;
            String string = appPickerPreference2.b.getString(R.string.blacklist_settings_filtered_apps_title);
            if (!TextUtils.equals(string, appPickerPreference2.i)) {
                appPickerPreference2.i = string;
                appPickerPreference2.k();
            }
            this.i0.B((pn0.t().i() == 1 ? 1 : 0) ^ 1);
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
        Optional.ofNullable(v()).ifPresent(new defpackage.a(4));
    }
}
