package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.preference.DropDownPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cv implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ cv(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        bv bvVar;
        int i2 = this.b;
        Object obj = this.c;
        switch (i2) {
            case 0:
                DropDownPreference dropDownPreference = (DropDownPreference) obj;
                if (i >= 0) {
                    String string = dropDownPreference.V[i].toString();
                    if (!string.equals(dropDownPreference.W) && dropDownPreference.a(string)) {
                        dropDownPreference.M(string);
                        break;
                    }
                }
                break;
            default:
                if (i != -1 && (bvVar = ((rh0) obj).d) != null) {
                    bvVar.setListSelectionHidden(false);
                    break;
                }
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i = this.b;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }
}
