package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import com.canhub.cropper.CropImageActivity;
import com.quickcursor.R;
import com.quickcursor.android.activities.MainActivity;
import com.quickcursor.android.activities.settings.BlacklistSettings;
import com.quickcursor.android.activities.settings.CursorSettings;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.activities.settings.TapBehaviourSettings;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import com.quickcursor.android.activities.settings.VibrationsAndVisualSettings;
import com.quickcursor.android.services.CursorAccessibilityService;
import com.quickcursor.android.views.settings.EdgeBarConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ z2(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.b;
        int i3 = 0;
        Object obj = this.c;
        switch (i2) {
            case 0:
                ((c3) obj).r0 = true;
                break;
            case 1:
                ((SharedPreferences) pn0.t().d).edit().remove(oq0.g0.name()).remove(oq0.h0.name()).apply();
                ((BlacklistSettings.a) obj).i0(null, null);
                CursorAccessibilityService.j();
                break;
            case 2:
                kh khVar = (kh) obj;
                try {
                    ((SharedPreferences) pn0.t().d).edit().putInt(oq0.V0.name(), Integer.parseInt(String.valueOf(khVar.q0.getText()))).putInt(oq0.W0.name(), Integer.parseInt(String.valueOf(khVar.r0.getText()))).apply();
                } catch (Exception unused) {
                    yb0.y(R.string.general_error_toast, 0);
                    return;
                }
                break;
            case 3:
                aq aqVar = (aq) obj;
                int i4 = CropImageActivity.H;
                aqVar.g(i == 0 ? zp.b : zp.c);
                break;
            case 4:
                CursorSettings.a aVar = (CursorSettings.a) obj;
                pn0.t().L();
                aVar.i0(null, null);
                aVar.T();
                CursorAccessibilityService.j();
                CursorSettings.G(aVar.i0, yq.j(pn0.t().m()));
                break;
            case 5:
                ((vr) obj).onSharedPreferenceChanged(null, null);
                break;
            case 6:
                kt ktVar = (kt) obj;
                ktVar.w0 = i;
                ktVar.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
                break;
            case 7:
                qw qwVar = (qw) obj;
                EdgeBarConstraintLayout edgeBarConstraintLayout = qwVar.i0;
                edgeBarConstraintLayout.getEdgeBar().h(edgeBarConstraintLayout.E.a(qwVar.h0));
                EdgeActionsSettings edgeActionsSettings = (EdgeActionsSettings) qwVar.u();
                edgeActionsSettings.getClass();
                edgeBarConstraintLayout.m(null);
                edgeActionsSettings.M(edgeBarConstraintLayout);
                b61.b(new pw(qwVar, i3), 100L);
                break;
            case 8:
                uw uwVar = (uw) obj;
                pn0.t().M();
                xw xwVar = xw.e;
                xwVar.getClass();
                if (zq0.b.c()) {
                    wa waVar = new wa();
                    dx dxVar = new dx();
                    n3 n3Var = n3.expandNotifications;
                    wa waVar2 = j00.k;
                    dxVar.a(new lw(n3Var, waVar2));
                    dxVar.a(new lw(n3.expandQuickSettings, waVar2));
                    waVar.put("topEdgeBar", dxVar);
                    waVar.put("leftEdgeBar", xw.b());
                    waVar.put("rightEdgeBar", xw.c());
                    waVar.put("bottomEdgeBar", xw.a());
                    xwVar.c = waVar;
                    xwVar.g();
                } else {
                    xwVar.e();
                }
                CursorAccessibilityService.j();
                Intent intent = uwVar.Z().getIntent();
                uwVar.Z().finish();
                uwVar.f0(intent);
                break;
            case 9:
                MainActivity.a aVar2 = (MainActivity.a) obj;
                CursorAccessibilityService cursorAccessibilityService = CursorAccessibilityService.q;
                if (cursorAccessibilityService != null) {
                    si0.a("turnOff(): ".concat(l11.p(2)));
                    r60.k();
                    ar arVar = cursorAccessibilityService.o;
                    if (arVar != null) {
                        try {
                            arVar.m();
                            break;
                        } catch (Exception unused2) {
                        }
                        cursorAccessibilityService.o = null;
                    }
                    cursorAccessibilityService.n = 2;
                    CursorAccessibilityService.q.disableSelf();
                    CursorAccessibilityService.q = null;
                }
                lc1.e(aVar2.t());
                break;
            case 10:
                ((ih0) obj).q0 = null;
                break;
            case 11:
                bs0 bs0Var = (bs0) obj;
                bs0Var.A(true);
                i1.I(bs0Var.t());
                break;
            case 12:
                a11 a11Var = (a11) obj;
                a11Var.n0();
                xv0 xv0Var = xv0.d;
                xv0Var.a().t();
                xv0Var.c();
                a11Var.i0(null, null);
                CursorAccessibilityService.j();
                a11Var.l0();
                break;
            case 13:
                ((SharedPreferences) pn0.t().d).edit().remove(oq0.N0.name()).remove(oq0.P0.name()).remove(oq0.R0.name()).remove(oq0.O0.name()).remove(oq0.Q0.name()).remove(oq0.l.name()).remove(oq0.L.name()).remove(oq0.e0.name()).remove(oq0.f0.name()).remove(oq0.M.name()).remove(oq0.M0.name()).remove(oq0.k.name()).putFloat("clickDistanceThreshold", dn.v).apply();
                ((TapBehaviourSettings.a) obj).i0(null, null);
                CursorAccessibilityService.j();
                break;
            case 14:
                l71 l71Var = (l71) obj;
                l71Var.i0.remove(l71Var.h0);
                pn0.t().getClass();
                pn0.V();
                l71Var.Z().onBackPressed();
                ((TrackerActionsSettings) l71Var.Z()).K();
                break;
            case 15:
                o71 o71Var = (o71) obj;
                SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.t().d).edit();
                oq0.f(editorEdit, oq0.v0);
                oq0 oq0Var = oq0.x0;
                oq0.f(editorEdit, oq0Var);
                oq0 oq0Var2 = oq0.z0;
                oq0.f(editorEdit, oq0Var2);
                oq0.g(editorEdit, oq0.B0);
                oq0.g(editorEdit, oq0.w0);
                oq0.g(editorEdit, oq0.y0);
                oq0.g(editorEdit, oq0.A0);
                oq0.g(editorEdit, oq0.C0);
                editorEdit.apply();
                o71Var.i0(null, null);
                o71Var.h0.M((int) oq0.b((SharedPreferences) pn0.t().d, oq0Var), (int) oq0.b((SharedPreferences) pn0.t().d, oq0Var2));
                CursorAccessibilityService.j();
                break;
            case 16:
                w71 w71Var = (w71) obj;
                w71Var.k0.J(true);
                pn0.t().S(new j71(n3.openTrackerActionsOnce, null));
                w71Var.h0.K();
                break;
            case 17:
                j91 j91Var = (j91) obj;
                j91Var.k0.remove(j91Var.j0);
                j91Var.m0();
                j91Var.Z().onBackPressed();
                break;
            case 18:
                p91 p91Var = (p91) obj;
                p91Var.n0();
                p91Var.k0.f();
                xv0.d.c();
                p91Var.i0(null, null);
                CursorAccessibilityService.j();
                p91Var.l0();
                break;
            case 19:
                r91 r91Var = (r91) obj;
                r91Var.n0();
                r91Var.l0.j();
                xv0.d.c();
                r91Var.i0(null, null);
                CursorAccessibilityService.j();
                r91Var.l0();
                break;
            case 20:
                la1 la1Var = (la1) obj;
                xv0 xv0Var2 = xv0.d;
                xv0Var2.a().s();
                xv0Var2.c();
                la1Var.i0(null, null);
                CursorAccessibilityService.j();
                la1Var.l0.d(-1, la1Var.z0);
                break;
            case 21:
                pn0.t().P();
                ((VibrationsAndVisualSettings.a) obj).i0(null, null);
                break;
            default:
                ((k2) obj).run();
                break;
        }
    }
}
