package defpackage;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.BackupAndRestoreSettings;
import com.quickcursor.android.activities.settings.MissingPermissions;
import com.quickcursor.android.activities.settings.b;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pd implements DialogInterface.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ pd(Map map, Runnable runnable) {
        this.b = 2;
        this.d = map;
        this.c = runnable;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.b;
        Object obj = this.c;
        Object obj2 = this.d;
        switch (i2) {
            case 0:
                final BackupAndRestoreSettings.a aVar = (BackupAndRestoreSettings.a) obj;
                final Map map = (Map) obj2;
                Double dValueOf = Double.valueOf(-1.0d);
                try {
                    int iIntValue = ((Double) map.getOrDefault(oq0.i0.name(), dValueOf)).intValue();
                    int iIntValue2 = ((Double) map.getOrDefault(oq0.j0.name(), dValueOf)).intValue();
                    if (iIntValue > 0 && iIntValue2 > 0) {
                        ud.c(map, (wj) aVar.Z());
                        aVar.h0("permissions").F(!MissingPermissions.H().isEmpty());
                    }
                } catch (Exception e) {
                    si0.b("Exception showResolutionDialog(): " + e);
                }
                jl1 jl1Var = new jl1(aVar.Z());
                View viewInflate = aVar.Z().getLayoutInflater().inflate(R.layout.restore_resolution_missing_dialog, (ViewGroup) null);
                final EditText editText = (EditText) viewInflate.findViewById(R.id.width);
                final EditText editText2 = (EditText) viewInflate.findViewById(R.id.height);
                editText.setText(ey0.d + "");
                editText2.setText(ey0.e + "");
                jl1Var.m(R.string.missing_resolution_dialog_title);
                x6 x6Var = (x6) jl1Var.c;
                x6Var.n = true;
                x6Var.u = viewInflate;
                jl1Var.k(R.string.missing_resolution_dialog_resolve_button, new DialogInterface.OnClickListener() { // from class: rd
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface2, int i3) {
                        Integer numValueOf;
                        EditText editText3 = editText;
                        EditText editText4 = editText2;
                        Integer numValueOf2 = 0;
                        try {
                            numValueOf = Integer.valueOf(Integer.parseInt(editText3.getText().toString()));
                            try {
                                numValueOf2 = Integer.valueOf(Integer.parseInt(editText4.getText().toString()));
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            numValueOf = numValueOf2;
                        }
                        if (numValueOf.intValue() == 0 || numValueOf2.intValue() == 0) {
                            yb0.z(f01.P(R.string.missing_resolution_dialog_invalid_resolution, "resolution", numValueOf + "x" + numValueOf2), 0);
                            return;
                        }
                        String strName = oq0.i0.name();
                        Map map2 = map;
                        map2.put(strName, numValueOf);
                        map2.put(oq0.j0.name(), numValueOf2);
                        yb0.z(f01.P(R.string.missing_resolution_dialog_resolution_set, "resolution", numValueOf + "x" + numValueOf2), 0);
                        BackupAndRestoreSettings.a aVar2 = aVar;
                        ud.c(map2, (wj) aVar2.Z());
                        aVar2.h0("permissions").F(MissingPermissions.H().isEmpty() ^ true);
                    }
                });
                jl1Var.h(R.string.missing_resolution_dialog_cancel_button, new g2(2));
                jl1Var.c();
                jl1Var.n();
                break;
            case 1:
                er erVar = (er) obj;
                Pair pair = new Pair(Float.valueOf(erVar.g), Float.valueOf(erVar.h));
                pn0 pn0VarT = pn0.t();
                ((SharedPreferences) pn0VarT.d).edit().putFloat(oq0.z.name(), ((Float) pair.first).floatValue()).putFloat(oq0.A.name(), ((Float) pair.second).floatValue()).apply();
                ((b) obj2).a.h0.a(new s4(15));
                break;
            default:
                Map map2 = (Map) obj2;
                Runnable runnable = (Runnable) obj;
                i70 i70Var = ud.a;
                try {
                    si0.b("restoreExpiredPreferencesBackup try...");
                    SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
                    for (Map.Entry entry : map2.entrySet()) {
                        ud.b(editorEdit, (String) entry.getKey(), entry.getValue());
                    }
                    editorEdit.remove("expiredPreferencesBackup");
                    editorEdit.commit();
                    pd1.b();
                    pn0.t().Q(true);
                    yb0.y(R.string.backup_settings_restore_done, 1);
                    f01.j();
                    CursorAccessibilityService.k(true);
                    lv.b();
                    si0.b("restoreExpiredPreferencesBackup success.");
                } catch (Exception e2) {
                    si0.b("restoreExpiredPreferencesBackup error:" + e2);
                }
                runnable.run();
                break;
        }
    }

    public /* synthetic */ pd(Object obj, int i, Object obj2) {
        this.b = i;
        this.c = obj;
        this.d = obj2;
    }
}
