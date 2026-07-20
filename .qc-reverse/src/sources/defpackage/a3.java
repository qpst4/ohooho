package defpackage;

import android.content.Intent;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.quickcursor.R;
import com.quickcursor.android.activities.BuyProActivity;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.extra.TriggerActionsListActivity;
import com.quickcursor.android.preferences.ButtonPreference;
import com.quickcursor.android.preferences.CustomSwitchPreference;
import com.quickcursor.android.preferences.DetailedListPreference;
import com.quickcursor.android.services.CursorAccessibilityService;
import com.quickcursor.android.views.ProOverlayView;
import com.quickcursor.android.views.settings.EdgeBarConstraintLayout;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a3 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a3(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        boolean z = false;
        int i2 = 1;
        Object obj = this.c;
        switch (i) {
            case 0:
                ((c3) obj).q0.run();
                return;
            case 1:
                ((vg) obj).b();
                return;
            case 2:
                jz0 jz0Var = ((ButtonPreference) obj).O;
                if (jz0Var != null) {
                    jz0Var.run();
                    return;
                }
                return;
            case 3:
                sk skVar = (sk) obj;
                EditText editText = skVar.i;
                if (editText == null) {
                    return;
                }
                Editable text = editText.getText();
                if (text != null) {
                    text.clear();
                }
                skVar.p();
                return;
            case 4:
                Runnable runnable = ((CustomSwitchPreference) obj).X;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            case 5:
                Runnable runnable2 = ((DetailedListPreference) obj).e0;
                if (runnable2 != null) {
                    runnable2.run();
                    return;
                }
                return;
            case 6:
                ((ev) obj).t();
                return;
            case 7:
                nw nwVar = (nw) obj;
                EdgeActionsSettings edgeActionsSettings = (EdgeActionsSettings) nwVar.getContext();
                j30 j30VarC = edgeActionsSettings.w().C(R.id.settings);
                EdgeBarConstraintLayout edgeBarConstraintLayout = null;
                for (EdgeBarConstraintLayout edgeBarConstraintLayout2 : edgeActionsSettings.P) {
                    edgeBarConstraintLayout2.m(null);
                    if (edgeBarConstraintLayout2.E.a(nwVar) > -1) {
                        if (!edgeBarConstraintLayout2.B || !(j30VarC instanceof rw)) {
                            edgeActionsSettings.M(edgeBarConstraintLayout2);
                        }
                        edgeBarConstraintLayout = edgeBarConstraintLayout2;
                    }
                }
                r2.o0(edgeActionsSettings.w(), n3.b(1), new ArrayList(), Arrays.asList(n3.nothing, n3.expandNotifications, n3.expandQuickSettings, n3.takeScreenshot), new qs(edgeActionsSettings, nwVar, edgeBarConstraintLayout, i2));
                return;
            case 8:
                rw rwVar = (rw) obj;
                dx dxVar = rwVar.Y;
                if (!zq0.b.c()) {
                    yb0.y(R.string.setting_not_available_for_free_version, 0);
                    return;
                }
                dxVar.a(new lw(n3.nothing, null));
                rwVar.c0.getAdapter().a.e(dxVar.c() - 1, 1);
                rwVar.e();
                return;
            case 9:
                Button button = (Button) view;
                String str = (String) button.getText();
                view.setEnabled(false);
                ((Button) view).setText(R.string.slide_first_use_target_clicked);
                b61.b(new mf(view, button, str), 3000L);
                return;
            case 10:
                ih0 ih0Var = (ih0) obj;
                ih0Var.t0 = (jh0) view.getTag();
                ih0Var.h0(false, false);
                return;
            case 11:
                ((fk0) obj).k0();
                throw null;
            case 12:
                jp0 jp0Var = (jp0) obj;
                EditText editText2 = jp0Var.f;
                if (editText2 == null) {
                    return;
                }
                int selectionEnd = editText2.getSelectionEnd();
                EditText editText3 = jp0Var.f;
                if (editText3 != null && (editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                    z = true;
                }
                EditText editText4 = jp0Var.f;
                if (z) {
                    editText4.setTransformationMethod(null);
                } else {
                    editText4.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    jp0Var.f.setSelection(selectionEnd);
                }
                jp0Var.p();
                return;
            case 13:
                ProOverlayView proOverlayView = (ProOverlayView) obj;
                int i3 = ProOverlayView.b;
                proOverlayView.getContext().startActivity(new Intent(proOverlayView.getContext(), (Class<?>) BuyProActivity.class));
                return;
            case 14:
                js0 js0Var = (js0) obj;
                CursorAccessibilityService cursorAccessibilityService = js0Var.e;
                int i4 = Integer.parseInt(view.getTag().toString());
                cursorAccessibilityService.getClass();
                pn0.t().U(i4);
                cursorAccessibilityService.n(4);
                cursorAccessibilityService.l();
                js0Var.b();
                return;
            case 15:
                p71 p71Var = (p71) obj;
                if (!zq0.b.c()) {
                    yb0.y(R.string.setting_not_available_for_free_version, 0);
                    return;
                }
                p71Var.Y.add(0, new j71(n3.nothing, null));
                p71Var.a0.getAdapter().a.e(0, 1);
                p71Var.e();
                return;
            default:
                TriggerActionsListActivity triggerActionsListActivity = (TriggerActionsListActivity) obj;
                bk bkVar = TriggerActionsListActivity.G;
                if (!zq0.b.c()) {
                    yb0.y(R.string.setting_not_available_for_free_version, 0);
                    return;
                }
                triggerActionsListActivity.D.add(0, new h91(1, n3.nothing, null, i3.empty));
                triggerActionsListActivity.F.getAdapter().a.e(0, 1);
                triggerActionsListActivity.e();
                return;
        }
    }
}
