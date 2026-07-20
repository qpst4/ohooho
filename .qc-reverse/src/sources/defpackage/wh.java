package defpackage;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.quickcursor.R;
import com.quickcursor.android.activities.BuyProActivity;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wh implements qf, of, zr0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ BuyProActivity c;

    public /* synthetic */ wh(BuyProActivity buyProActivity, int i) {
        this.b = i;
        this.c = buyProActivity;
    }

    @Override // defpackage.of
    public void a(String str, Boolean bool) {
        int i = this.b;
        BuyProActivity buyProActivity = this.c;
        switch (i) {
            case 1:
                if (str != null) {
                    buyProActivity.D.setText(lc1.K(R.string.buy_quick_cursor_pro_subscription) + "\n(" + f01.P(R.string.buy_quick_cursor_pro_subscription_price, "price", str) + ")");
                    buyProActivity.E.setVisibility(bool.booleanValue() ? 0 : 8);
                } else {
                    int i2 = BuyProActivity.H;
                }
                break;
            default:
                if (str != null) {
                    buyProActivity.C.setIcon(buyProActivity.getResources().getDrawable(bool.booleanValue() ? R.drawable.icon_buy_lifetime_sale : R.drawable.icon_buy_lifetime, buyProActivity.getTheme()));
                    ExtendedFloatingActionButton extendedFloatingActionButton = buyProActivity.C;
                    StringBuilder sb = new StringBuilder();
                    sb.append(lc1.K(bool.booleanValue() ? R.string.buy_quick_cursor_pro_lifetime_sale : R.string.buy_quick_cursor_pro_lifetime));
                    sb.append("\n(");
                    sb.append(f01.P(R.string.buy_quick_cursor_pro_lifetime_price, "price", str));
                    sb.append(")");
                    extendedFloatingActionButton.setText(sb.toString());
                } else {
                    int i3 = BuyProActivity.H;
                }
                break;
        }
    }

    @Override // defpackage.zr0
    public void b(df dfVar, List list) {
        BuyProActivity buyProActivity = this.c;
        int i = BuyProActivity.H;
        try {
            sf sfVar = buyProActivity.G;
            s1 s1Var = new s1(9);
            af afVar = sfVar.c;
            String str = "subs";
            afVar.getClass();
            int i2 = 2;
            if (!afVar.c()) {
                df dfVar2 = zl1.k;
                afVar.w(2, 11, dfVar2);
                s1Var.b(dfVar2, null);
            } else if (af.h(new rk1(afVar, str, s1Var, i2), 30000L, new vn1(afVar, 16, s1Var), afVar.u(), afVar.l()) == null) {
                df dfVarI = afVar.i();
                afVar.w(25, 11, dfVarI);
                s1Var.b(dfVarI, null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.qf
    public void c(yq0 yq0Var) {
        int i = BuyProActivity.H;
        yq0 yq0Var2 = yq0.lifetime;
        BuyProActivity buyProActivity = this.c;
        if (yq0Var == yq0Var2 || yq0Var == yq0.subscription) {
            buyProActivity.B = true;
            fp1.b(yq0Var, buyProActivity, new uh(buyProActivity, 0));
        } else if (yq0Var == yq0.pending) {
            fp1.a();
            buyProActivity.recreate();
        }
    }
}
