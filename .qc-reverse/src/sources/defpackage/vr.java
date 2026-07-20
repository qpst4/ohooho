package defpackage;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.DebugSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class vr implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ DebugSettings.a a;
    public final /* synthetic */ View b;

    public /* synthetic */ vr(DebugSettings.a aVar, View view) {
        this.a = aVar;
        this.b = view;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            oq0 oq0Var = oq0.g;
            if (str.equals(oq0Var.name())) {
                this.a.j0.S((TextView) this.b.findViewById(R.id.markdown), "```" + oq0.d((SharedPreferences) pn0.t().d, oq0Var) + "```");
            }
        }
    }
}
