package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.BackupAndRestoreSettings;
import com.quickcursor.android.activities.settings.DebugSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ur implements zp0, aq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ DebugSettings.a c;

    public /* synthetic */ ur(DebugSettings.a aVar, int i) {
        this.b = i;
        this.c = aVar;
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        int i = this.b;
        DebugSettings.a aVar = this.c;
        switch (i) {
            case 0:
                StringBuilder sb = new StringBuilder();
                sb.append(preference.m);
                sb.append(" turned: ");
                sb.append(((Boolean) obj).booleanValue() ? "on" : "off");
                si0.b(sb.toString());
                aVar.h0.a(new s4(15));
                break;
            default:
                aVar.i0.a(new s4(5));
                break;
        }
        return true;
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        final DebugSettings.a aVar = this.c;
        final int i2 = 1;
        switch (i) {
            case 2:
                jl1 jl1Var = new jl1(aVar.Z());
                View viewInflate = aVar.Z().getLayoutInflater().inflate(R.layout.logs_dialog, (ViewGroup) null);
                vr vrVar = new vr(aVar, viewInflate);
                vrVar.onSharedPreferenceChanged(null, oq0.g.name());
                ((SharedPreferences) pn0.e.d).registerOnSharedPreferenceChangeListener(vrVar);
                jl1Var.m(R.string.debug_logs_dialog_title);
                x6 x6Var = (x6) jl1Var.c;
                x6Var.n = true;
                x6Var.u = viewInflate;
                final int i3 = 0;
                jl1Var.k(R.string.debug_logs_dialog_share, new DialogInterface.OnClickListener() { // from class: wr
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        int i5 = i3;
                        DebugSettings.a aVar2 = aVar;
                        switch (i5) {
                            case 0:
                                Intent intent = new Intent("android.intent.action.SEND");
                                intent.setType("text/plain");
                                intent.putExtra("android.intent.extra.TEXT", oq0.d((SharedPreferences) pn0.t().d, oq0.g));
                                aVar2.f0(Intent.createChooser(intent, lc1.K(R.string.debug_logs_dialog_share_prompt_title)));
                                break;
                            default:
                                Context contextO = aVar2.o();
                                String strK = lc1.K(R.string.debug_logs_dialog_copy_label);
                                String strD = oq0.d((SharedPreferences) pn0.t().d, oq0.g);
                                String strK2 = lc1.K(R.string.debug_toast_logs_copied);
                                ((ClipboardManager) contextO.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(strK, strD));
                                if (strK2 != null) {
                                    yb0.z(strK2, 0);
                                }
                                break;
                        }
                    }
                });
                jl1Var.h(R.string.debug_logs_dialog_copy, new DialogInterface.OnClickListener() { // from class: wr
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        int i5 = i2;
                        DebugSettings.a aVar2 = aVar;
                        switch (i5) {
                            case 0:
                                Intent intent = new Intent("android.intent.action.SEND");
                                intent.setType("text/plain");
                                intent.putExtra("android.intent.extra.TEXT", oq0.d((SharedPreferences) pn0.t().d, oq0.g));
                                aVar2.f0(Intent.createChooser(intent, lc1.K(R.string.debug_logs_dialog_share_prompt_title)));
                                break;
                            default:
                                Context contextO = aVar2.o();
                                String strK = lc1.K(R.string.debug_logs_dialog_copy_label);
                                String strD = oq0.d((SharedPreferences) pn0.t().d, oq0.g);
                                String strK2 = lc1.K(R.string.debug_toast_logs_copied);
                                ((ClipboardManager) contextO.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(strK, strD));
                                if (strK2 != null) {
                                    yb0.z(strK2, 0);
                                }
                                break;
                        }
                    }
                });
                jl1Var.i(R.string.debug_toast_dialog_close, new z2(5, vrVar));
                jl1Var.c();
                jl1Var.n();
                break;
            case 3:
                jl1 jl1Var2 = new jl1(aVar.o());
                jl1Var2.m(R.string.are_you_sure);
                jl1Var2.g(R.string.debug_confirmation_clear_logs);
                ((x6) jl1Var2.c).c = R.drawable.icon_warning;
                jl1Var2.k(android.R.string.yes, new g2(4));
                jl1Var2.h(android.R.string.no, null);
                jl1Var2.n();
                break;
            default:
                BackupAndRestoreSettings.a.l0(aVar.o(), new c(19, aVar));
                break;
        }
        return true;
    }
}
