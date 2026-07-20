package defpackage;

import android.content.SharedPreferences;
import android.os.Build;
import com.quickcursor.R;
import com.quickcursor.android.preferences.ActionPickerPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s2 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ActionPickerPreference c;

    public /* synthetic */ s2(ActionPickerPreference actionPickerPreference, int i) {
        this.b = i;
        this.c = actionPickerPreference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar;
        int i = this.b;
        ActionPickerPreference actionPickerPreference = this.c;
        switch (i) {
            case 0:
                String str = actionPickerPreference.m;
                if (actionPickerPreference.Q != null && (jVar = actionPickerPreference.O) != null) {
                    String strK = lc1.K(jVar.b().titleId);
                    if (str.equals("doubleTapTrackerAction") && actionPickerPreference.O.b() != n3.nothing && pn0.t().j() != pq0.d) {
                        strK = strK + "\n\n" + lc1.K(R.string.tap_behaviour_double_tap_summary_warning);
                    } else if (str.equals("secondTapTrackerAction") && actionPickerPreference.O.b() != n3.nothing && Build.VERSION.SDK_INT >= 35) {
                        strK = strK + "\n\n" + lc1.K(R.string.tap_behaviour_second_tap_summary_warning);
                    } else if (str.equals("longTapTrackerAction") && oq0.a((SharedPreferences) pn0.t().d, oq0.e1)) {
                        strK = strK + "\n\n" + lc1.K(R.string.tap_behaviour_long_tap_input_dispatcher_bug_warning);
                    }
                    actionPickerPreference.E(strK);
                    actionPickerPreference.Q.setVisibility(actionPickerPreference.O.b().actionTypePickedInterceptor == null ? 8 : 0);
                    actionPickerPreference.R.setVisibility((actionPickerPreference.V.getVisibility() != 8 || actionPickerPreference.O.b().actionTypePickedInterceptor == null) ? 8 : 0);
                    break;
                }
                break;
            default:
                actionPickerPreference.J();
                break;
        }
    }
}
