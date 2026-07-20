package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.quickcursor.android.activities.settings.TriggersSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class za1 implements AdapterView.OnItemSelectedListener {
    public boolean b = false;
    public final /* synthetic */ TriggersSettings c;

    public za1(TriggersSettings triggersSettings) {
        this.c = triggersSettings;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (this.b) {
            w11 w11Var = (w11) adapterView.getItemAtPosition(i);
            int i2 = TriggersSettings.G;
            int i3 = w11Var.c;
            int i4 = w11Var.d;
            if (i3 != ey0.c() || i4 != ey0.b()) {
                int i5 = w11Var.c;
                int iB = ey0.b();
                TriggersSettings triggersSettings = this.c;
                if (i5 == iB && i4 == ey0.c()) {
                    Intent intent = new Intent(triggersSettings, (Class<?>) TriggersSettings.class);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(ey0.d() ? "landscape" : "portrait", true);
                    intent.putExtras(bundle);
                    triggersSettings.startActivity(intent);
                    triggersSettings.finish();
                } else {
                    triggersSettings.F.setSelection(0);
                    yb0.z("Change your device resolution to edit this config.", 1);
                }
            }
        }
        this.b = true;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
