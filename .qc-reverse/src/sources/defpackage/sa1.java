package defpackage;

import android.content.Intent;
import androidx.preference.Preference;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.extra.TriggerActionsListActivity;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sa1 implements e4, q2, aq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ ua1 c;

    public /* synthetic */ sa1(ua1 ua1Var, int i) {
        this.b = i;
        this.c = ua1Var;
    }

    @Override // defpackage.e4
    public void b(Object obj) {
        d4 d4Var = (d4) obj;
        qs qsVar = this.c.s0;
        if (qsVar == null) {
            return;
        }
        qsVar.b(d4Var);
    }

    @Override // defpackage.aq0
    public boolean c(Preference preference) {
        int i = this.b;
        ua1 ua1Var = this.c;
        int i2 = 1;
        switch (i) {
            case 2:
                y30 y30VarL = ua1Var.l();
                List listB = n3.b(32);
                n3 n3Var = n3.nothing;
                n3 n3Var2 = n3.triggerTap;
                n3 n3Var3 = n3.grabCursor;
                n3 n3Var4 = n3.expandNotifications;
                n3 n3Var5 = n3.expandQuickSettings;
                r2.o0(y30VarL, listB, Arrays.asList(n3Var, n3Var2, n3Var3, n3Var4, n3Var5, n3.lockScreen), Arrays.asList(n3Var, n3Var2, n3Var3, n3Var4, n3Var5, n3.backButton, n3.homeButton, n3.recentsButton), new sa1(ua1Var, 6));
                break;
            case 3:
                y30 y30VarL2 = ua1Var.l();
                List listB2 = n3.b(64);
                n3 n3Var6 = n3.nothing;
                n3 n3Var7 = n3.triggerLongTap;
                n3 n3Var8 = n3.grabCursor;
                n3 n3Var9 = n3.expandNotifications;
                n3 n3Var10 = n3.expandQuickSettings;
                r2.o0(y30VarL2, listB2, Arrays.asList(n3Var6, n3Var7, n3Var8, n3Var9, n3Var10, n3.lockScreen), Arrays.asList(n3Var6, n3Var7, n3Var8, n3Var9, n3Var10, n3.backButton, n3.homeButton, n3.recentsButton), new sa1(ua1Var, i2));
                break;
            case 4:
                Intent intent = new Intent(ua1Var.u(), (Class<?>) TriggerActionsListActivity.class);
                intent.putExtra("triggerIndex", ua1Var.k0 ? xv0.d.a().d().c().indexOf(ua1Var.l0) : -1);
                intent.putExtra("actionsList", "shortActions");
                ua1Var.f0(intent);
                break;
            default:
                Intent intent2 = new Intent(ua1Var.u(), (Class<?>) TriggerActionsListActivity.class);
                intent2.putExtra("triggerIndex", ua1Var.k0 ? xv0.d.a().d().c().indexOf(ua1Var.l0) : -1);
                intent2.putExtra("actionsList", "longActions");
                ua1Var.f0(intent2);
                break;
        }
        return true;
    }

    @Override // defpackage.q2
    public void i(i iVar) {
        int i = this.b;
        ua1 ua1Var = this.c;
        switch (i) {
            case 1:
                m91 m91Var = ua1Var.m0;
                if (iVar != null) {
                    m91Var.K(new h91(iVar));
                    ua1Var.r0.K(m91Var.h());
                    xv0.d.c();
                    ua1Var.j0.a(new s4(15));
                    break;
                }
                break;
            default:
                m91 m91Var2 = ua1Var.m0;
                if (iVar != null) {
                    m91Var2.O(new h91(iVar));
                    ua1Var.q0.K(m91Var2.n());
                    xv0.d.c();
                    ua1Var.j0.a(new s4(15));
                    break;
                }
                break;
        }
    }
}
