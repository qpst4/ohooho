package com.quickcursor.android.activities.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.BackupAndRestoreSettings;
import defpackage.aq0;
import defpackage.fp1;
import defpackage.i70;
import defpackage.ir;
import defpackage.jl1;
import defpackage.lc1;
import defpackage.ld;
import defpackage.sd;
import defpackage.wj;
import defpackage.x6;
import defpackage.y30;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class BackupAndRestoreSettings extends wj {
    public static final /* synthetic */ int C = 0;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir {
        public final SimpleDateFormat h0 = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        public final i70 i0 = new i70();

        public static void l0(Context context, Runnable runnable) {
            jl1 jl1Var = new jl1(context);
            jl1Var.m(R.string.are_you_sure);
            jl1Var.g(R.string.confirmation_reset_all_settings);
            ((x6) jl1Var.c).c = R.drawable.icon_warning;
            jl1Var.k(android.R.string.yes, new sd(runnable, 0));
            jl1Var.h(android.R.string.no, null);
            jl1Var.n();
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00d2  */
        @Override // defpackage.j30
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void H(int r7, int r8, android.content.Intent r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 345
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.quickcursor.android.activities.settings.BackupAndRestoreSettings.a.H(int, int, android.content.Intent):void");
        }

        @Override // defpackage.j30
        public final void R() {
            this.F = true;
            h0("permissions").F(true ^ MissingPermissions.H().isEmpty());
        }

        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            k0(str, R.xml.preferences_backup_and_restore);
            final int i = 0;
            h0("backup").g = new aq0(this) { // from class: qd
                public final /* synthetic */ BackupAndRestoreSettings.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i2 = i;
                    BackupAndRestoreSettings.a aVar = this.c;
                    switch (i2) {
                        case 0:
                            Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                            intent.addCategory("android.intent.category.OPENABLE");
                            intent.setType("application/json");
                            intent.putExtra("android.intent.extra.TITLE", "quick_cursor_" + aVar.h0.format(new Date()) + ".json");
                            xw.e.g();
                            s71.e.c();
                            xv0.d.c();
                            aVar.g0(intent, 1);
                            break;
                        case 1:
                            Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                            intent2.addCategory("android.intent.category.OPENABLE");
                            intent2.setType("*/*");
                            aVar.g0(intent2, 2);
                            break;
                        default:
                            BackupAndRestoreSettings.a.l0(aVar.o(), new c(8, aVar));
                            break;
                    }
                    return true;
                }
            };
            final int i2 = 1;
            h0("restore").g = new aq0(this) { // from class: qd
                public final /* synthetic */ BackupAndRestoreSettings.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i2;
                    BackupAndRestoreSettings.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                            intent.addCategory("android.intent.category.OPENABLE");
                            intent.setType("application/json");
                            intent.putExtra("android.intent.extra.TITLE", "quick_cursor_" + aVar.h0.format(new Date()) + ".json");
                            xw.e.g();
                            s71.e.c();
                            xv0.d.c();
                            aVar.g0(intent, 1);
                            break;
                        case 1:
                            Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                            intent2.addCategory("android.intent.category.OPENABLE");
                            intent2.setType("*/*");
                            aVar.g0(intent2, 2);
                            break;
                        default:
                            BackupAndRestoreSettings.a.l0(aVar.o(), new c(8, aVar));
                            break;
                    }
                    return true;
                }
            };
            final int i3 = 2;
            h0("reset").g = new aq0(this) { // from class: qd
                public final /* synthetic */ BackupAndRestoreSettings.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i3;
                    BackupAndRestoreSettings.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                            intent.addCategory("android.intent.category.OPENABLE");
                            intent.setType("application/json");
                            intent.putExtra("android.intent.extra.TITLE", "quick_cursor_" + aVar.h0.format(new Date()) + ".json");
                            xw.e.g();
                            s71.e.c();
                            xv0.d.c();
                            aVar.g0(intent, 1);
                            break;
                        case 1:
                            Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                            intent2.addCategory("android.intent.category.OPENABLE");
                            intent2.setType("*/*");
                            aVar.g0(intent2, 2);
                            break;
                        default:
                            BackupAndRestoreSettings.a.l0(aVar.o(), new c(8, aVar));
                            break;
                    }
                    return true;
                }
            };
            fp1.o(this, Collections.singletonList("reset"));
        }
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.preferences_activity_with_pro_overlay);
        if (bundle == null) {
            y30 y30VarW = w();
            y30VarW.getClass();
            ld ldVar = new ld(y30VarW);
            ldVar.i(R.id.settings, new a());
            ldVar.e(false);
        }
        Optional.ofNullable(v()).ifPresent(new defpackage.a(2));
    }
}
