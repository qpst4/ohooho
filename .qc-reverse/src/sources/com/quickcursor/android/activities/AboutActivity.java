package com.quickcursor.android.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.AboutActivity;
import defpackage.aq0;
import defpackage.b61;
import defpackage.c;
import defpackage.di0;
import defpackage.ir;
import defpackage.lc1;
import defpackage.ld;
import defpackage.ra;
import defpackage.y30;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AboutActivity extends di0 {
    public static final /* synthetic */ int B = 0;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir {
        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            k0(str, R.xml.preferences_about_activity);
            final int i = 0;
            h0("email").g = new aq0(this) { // from class: b
                public final /* synthetic */ AboutActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i2 = i;
                    AboutActivity.a aVar = this.c;
                    switch (i2) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 4:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 5:
                            tk0.E(aVar.t());
                            break;
                        default:
                            f01.J(aVar.u(), dn.j);
                            break;
                    }
                    return true;
                }
            };
            final int i2 = 1;
            h0("telegram").g = new aq0(this) { // from class: b
                public final /* synthetic */ AboutActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i2;
                    AboutActivity.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 4:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 5:
                            tk0.E(aVar.t());
                            break;
                        default:
                            f01.J(aVar.u(), dn.j);
                            break;
                    }
                    return true;
                }
            };
            final int i3 = 2;
            h0("reddit").g = new aq0(this) { // from class: b
                public final /* synthetic */ AboutActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i3;
                    AboutActivity.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 4:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 5:
                            tk0.E(aVar.t());
                            break;
                        default:
                            f01.J(aVar.u(), dn.j);
                            break;
                    }
                    return true;
                }
            };
            final int i4 = 3;
            h0("xda").g = new aq0(this) { // from class: b
                public final /* synthetic */ AboutActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i4;
                    AboutActivity.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 4:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 5:
                            tk0.E(aVar.t());
                            break;
                        default:
                            f01.J(aVar.u(), dn.j);
                            break;
                    }
                    return true;
                }
            };
            final int i5 = 4;
            h0("share").g = new aq0(this) { // from class: b
                public final /* synthetic */ AboutActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i5;
                    AboutActivity.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 4:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 5:
                            tk0.E(aVar.t());
                            break;
                        default:
                            f01.J(aVar.u(), dn.j);
                            break;
                    }
                    return true;
                }
            };
            final int i6 = 5;
            h0("changelog").g = new aq0(this) { // from class: b
                public final /* synthetic */ AboutActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i6;
                    AboutActivity.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 4:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 5:
                            tk0.E(aVar.t());
                            break;
                        default:
                            f01.J(aVar.u(), dn.j);
                            break;
                    }
                    return true;
                }
            };
            final int i7 = 6;
            h0("translate").g = new aq0(this) { // from class: b
                public final /* synthetic */ AboutActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i7;
                    AboutActivity.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 4:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 5:
                            tk0.E(aVar.t());
                            break;
                        default:
                            f01.J(aVar.u(), dn.j);
                            break;
                    }
                    return true;
                }
            };
            Preference preferenceH0 = h0("changelog");
            String str2 = ((Object) h0("changelog").i) + " 3.0.1";
            if (!TextUtils.equals(str2, preferenceH0.i)) {
                preferenceH0.i = str2;
                preferenceH0.k();
            }
            if (Z().getIntent() == null || !Z().getIntent().getBooleanExtra("BUNDLE_TRANSLATION", false)) {
                return;
            }
            b61.b(new c(0, this), 250L);
        }
    }

    @Override // defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.about_activity);
        if (bundle == null) {
            a aVar = new a();
            aVar.c0(bundle);
            y30 y30VarW = w();
            y30VarW.getClass();
            ld ldVar = new ld(y30VarW);
            ldVar.i(R.id.settings, aVar);
            ldVar.e(false);
        }
        Optional.ofNullable(v()).ifPresent(new defpackage.a(0));
        ra.n(this).S((TextView) findViewById(R.id.markdown), getString(R.string.markdown_credits_thanks) + getString(R.string.markdown_credits_list));
    }

    @Override // defpackage.di0, defpackage.z7, android.app.Activity
    public final void onResume() {
        super.onResume();
        lc1.e(this);
    }
}
