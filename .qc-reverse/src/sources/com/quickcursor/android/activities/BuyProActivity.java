package com.quickcursor.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.quickcursor.R;
import com.quickcursor.android.activities.BuyProActivity;
import defpackage.a;
import defpackage.af;
import defpackage.di0;
import defpackage.lc1;
import defpackage.ra;
import defpackage.sf;
import defpackage.th;
import defpackage.uh;
import defpackage.wh;
import defpackage.xg;
import defpackage.yq0;
import defpackage.zq0;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class BuyProActivity extends di0 {
    public static final /* synthetic */ int H = 0;
    public boolean B = false;
    public ExtendedFloatingActionButton C;
    public ExtendedFloatingActionButton D;
    public TextView E;
    public TextView F;
    public sf G;

    @Override // defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.buy_pro_activity);
        Optional.ofNullable(v()).ifPresent(new a(5));
        ra.n(this).S((TextView) findViewById(R.id.proFeaturesDescription), getString(R.string.buy_pro_description));
        this.C = (ExtendedFloatingActionButton) findViewById(R.id.floatingBuyLifetime);
        this.D = (ExtendedFloatingActionButton) findViewById(R.id.floatingBuySubscription);
        this.E = (TextView) findViewById(R.id.textViewFreeTrial);
        this.F = (TextView) findViewById(R.id.textViewOr);
        this.G = new sf(this, new wh(this, 0));
    }

    @Override // defpackage.z7, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        sf sfVar = this.G;
        if (sfVar != null) {
            af afVar = sfVar.c;
            if (afVar != null) {
                afVar.b();
            }
            this.G = null;
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // defpackage.di0, defpackage.z7, android.app.Activity
    public final void onResume() {
        super.onResume();
        zq0 zq0Var = zq0.b;
        if (zq0Var.c()) {
            if (this.B) {
                return;
            }
            startActivity(new Intent(this, (Class<?>) ThanksProActivity.class));
            finish();
            return;
        }
        if (zq0Var.b() == yq0.pending) {
            this.D.setVisibility(8);
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.C.setIcon(null);
            this.C.setText(R.string.processing_transaction);
            this.C.setOnClickListener(new th());
            return;
        }
        final int i = 0;
        this.F.setVisibility(0);
        this.D.setVisibility(0);
        this.D.setText(R.string.buy_quick_cursor_pro_subscription);
        this.D.setOnClickListener(new View.OnClickListener(this) { // from class: vh
            public final /* synthetic */ BuyProActivity c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = i;
                BuyProActivity buyProActivity = this.c;
                switch (i2) {
                    case 0:
                        int i3 = BuyProActivity.H;
                        buyProActivity.G.i(new xg((Runnable) new k2(buyProActivity, 8, dn.d)));
                        break;
                    default:
                        int i4 = BuyProActivity.H;
                        buyProActivity.G.i(new xg((Runnable) new k2(buyProActivity, 8, dn.a)));
                        break;
                }
            }
        });
        this.E.setVisibility(8);
        this.C.setIcon(getResources().getDrawable(R.drawable.icon_buy_lifetime, getTheme()));
        this.C.setText(R.string.buy_quick_cursor_pro_lifetime);
        final int i2 = 1;
        this.C.setOnClickListener(new View.OnClickListener(this) { // from class: vh
            public final /* synthetic */ BuyProActivity c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i22 = i2;
                BuyProActivity buyProActivity = this.c;
                switch (i22) {
                    case 0:
                        int i3 = BuyProActivity.H;
                        buyProActivity.G.i(new xg((Runnable) new k2(buyProActivity, 8, dn.d)));
                        break;
                    default:
                        int i4 = BuyProActivity.H;
                        buyProActivity.G.i(new xg((Runnable) new k2(buyProActivity, 8, dn.a)));
                        break;
                }
            }
        });
        this.G.i(new xg((Runnable) new uh(this, i2)));
    }
}
