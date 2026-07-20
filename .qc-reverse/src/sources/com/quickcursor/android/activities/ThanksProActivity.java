package com.quickcursor.android.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.quickcursor.R;
import com.quickcursor.android.activities.ThanksProActivity;
import defpackage.af;
import defpackage.aq0;
import defpackage.di0;
import defpackage.dn;
import defpackage.ir;
import defpackage.j51;
import defpackage.k2;
import defpackage.lc1;
import defpackage.ld;
import defpackage.lk0;
import defpackage.ra;
import defpackage.sf;
import defpackage.xg;
import defpackage.xy0;
import defpackage.y30;
import defpackage.zq0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ThanksProActivity extends di0 {
    public static final /* synthetic */ int D = 0;
    public sf B;
    public a C;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir {
        public PreferenceCategory h0;
        public Preference i0;
        public Preference j0;
        public Preference k0;

        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            k0(str, R.xml.preferences_thanks_pro);
            this.h0 = (PreferenceCategory) h0("subscriptionCategory");
            this.i0 = h0("cancelSubscription");
            this.j0 = h0("subscriptionCanceled");
            this.k0 = h0("buyLifetime");
            final int i = 0;
            h0("email").g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i2 = i;
                    final ThanksProActivity.a aVar = this.c;
                    final int i3 = 1;
                    switch (i2) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i4) {
                                        int i5 = i3;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i5) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i4 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i42) {
                                        int i5 = i4;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i5) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            final int i2 = 2;
            h0("telegram").g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i2;
                    final ThanksProActivity.a aVar = this.c;
                    final int i3 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i42) {
                                        int i5 = i3;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i5) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i4 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i42) {
                                        int i5 = i4;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i5) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            final int i3 = 3;
            h0("reddit").g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i3;
                    final ThanksProActivity.a aVar = this.c;
                    final int i32 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i42) {
                                        int i5 = i32;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i5) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i4 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i42) {
                                        int i5 = i4;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i5) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            final int i4 = 4;
            h0("xda").g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i4;
                    final ThanksProActivity.a aVar = this.c;
                    final int i32 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i42) {
                                        int i5 = i32;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i5) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i42 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i5 = i42;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i5) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            final int i5 = 5;
            h0("share").g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i5;
                    final ThanksProActivity.a aVar = this.c;
                    final int i32 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i32;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i42 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i42;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            final int i6 = 6;
            h0("rateApp").g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i6;
                    final ThanksProActivity.a aVar = this.c;
                    final int i32 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i32;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i42 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i42;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            final int i7 = 7;
            this.i0.g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i7;
                    final ThanksProActivity.a aVar = this.c;
                    final int i32 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i32;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i42 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i42;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            this.j0.g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i7;
                    final ThanksProActivity.a aVar = this.c;
                    final int i32 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i32;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i42 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i42;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            final int i8 = 8;
            this.k0.g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i8;
                    final ThanksProActivity.a aVar = this.c;
                    final int i32 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i32;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i42 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i42;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            final int i9 = 1;
            h0(dn.a).g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i9;
                    final ThanksProActivity.a aVar = this.c;
                    final int i32 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i32;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i42 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i42;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            h0(dn.b).g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i9;
                    final ThanksProActivity.a aVar = this.c;
                    final int i32 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i32;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i42 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i42;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            h0(dn.c).g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i9;
                    final ThanksProActivity.a aVar = this.c;
                    final int i32 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i32;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i42 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i42;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            h0(dn.d).g = new aq0(this) { // from class: k51
                public final /* synthetic */ ThanksProActivity.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i9;
                    final ThanksProActivity.a aVar = this.c;
                    final int i32 = 1;
                    switch (i22) {
                        case 0:
                            aVar.f0(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(dn.k)), lc1.K(R.string.choose_email_client_popup_title)));
                            break;
                        case 1:
                            ThanksProActivity.F((ThanksProActivity) aVar.Z(), preference.m);
                            break;
                        case 2:
                            f01.J(aVar.u(), dn.h);
                            break;
                        case 3:
                            f01.J(aVar.u(), dn.g);
                            break;
                        case 4:
                            f01.J(aVar.u(), dn.i);
                            break;
                        case 5:
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", "Share URL");
                            intent.putExtra("android.intent.extra.TEXT", dn.f);
                            aVar.f0(Intent.createChooser(intent, "Share URL"));
                            break;
                        case 6:
                            i1.I(aVar.t());
                            break;
                        case 7:
                            aVar.l0();
                            break;
                        default:
                            if (!aVar.i0.x) {
                                ThanksProActivity.F((ThanksProActivity) aVar.Z(), dn.a);
                            } else {
                                jl1 jl1Var = new jl1(aVar.o());
                                jl1Var.m(R.string.thanks_pro_upgrade_lifetime_dialog_title);
                                jl1Var.g(R.string.thanks_pro_upgrade_lifetime_dialog_message);
                                ((x6) jl1Var.c).c = R.drawable.icon_warning;
                                jl1Var.k(R.string.thanks_pro_upgrade_lifetime_dialog_buy_lifetime_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i32;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.h(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_button, null);
                                final int i42 = 0;
                                jl1Var.i(R.string.thanks_pro_upgrade_lifetime_dialog_cancel_subscription_button, new DialogInterface.OnClickListener() { // from class: l51
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i422) {
                                        int i52 = i42;
                                        ThanksProActivity.a aVar2 = aVar;
                                        switch (i52) {
                                            case 0:
                                                aVar2.l0();
                                                break;
                                            default:
                                                ThanksProActivity.F((ThanksProActivity) aVar2.Z(), dn.a);
                                                break;
                                        }
                                    }
                                });
                                jl1Var.n();
                            }
                            break;
                    }
                    return true;
                }
            };
            m0(new ArrayList(), 1);
        }

        public final void l0() {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/account/subscriptions?sku=" + dn.d + "&package=" + o().getPackageName()));
            intent.setFlags(270532608);
            o().startActivity(intent);
        }

        public final void m0(ArrayList arrayList, int i) {
            int i2;
            Iterator it = Arrays.asList(dn.a, dn.b, dn.c, dn.d).iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                i2 = R.string.thanks_pro_already_bought_summary;
                if (!zHasNext) {
                    break;
                }
                String str = (String) it.next();
                Preference preferenceH0 = h0(str);
                if (arrayList.contains(str)) {
                    preferenceH0.B(false);
                    preferenceH0.E(preferenceH0.b.getString(R.string.thanks_pro_already_bought_summary));
                } else {
                    preferenceH0.B(true);
                    preferenceH0.E("");
                }
            }
            this.h0.F(i != 1);
            if (this.h0.x) {
                this.i0.F(i == 2);
                this.j0.F(i == 3);
                Preference preference = this.k0;
                List list = sf.d;
                preference.B(!xy0.k(arrayList, list));
                Preference preference2 = this.k0;
                if (!xy0.k(arrayList, list)) {
                    i2 = R.string.thanks_pro_buy_lifetime_summary;
                }
                preference2.E(preference2.b.getString(i2));
            }
        }
    }

    public static void F(ThanksProActivity thanksProActivity, String str) {
        sf sfVar = thanksProActivity.B;
        if (sfVar != null) {
            af afVar = sfVar.c;
            if (afVar != null) {
                afVar.b();
            }
            thanksProActivity.B = null;
        }
        sf sfVar2 = new sf(thanksProActivity, new j51(thanksProActivity, 2));
        thanksProActivity.B = sfVar2;
        sfVar2.i(new xg((Runnable) new k2(thanksProActivity, 18, str)));
    }

    @Override // defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.thanks_pro_activity);
        Optional.ofNullable(v()).ifPresent(new defpackage.a(15));
        if (bundle == null) {
            this.C = new a();
            y30 y30VarW = w();
            y30VarW.getClass();
            ld ldVar = new ld(y30VarW);
            ldVar.i(R.id.settings, this.C);
            ldVar.e(false);
        }
        ra.n(this).S((TextView) findViewById(R.id.markdown), getString(R.string.markdown_thanks_pro));
    }

    @Override // defpackage.di0, defpackage.z7, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (!zq0.b.c()) {
            startActivity(new Intent(this, (Class<?>) BuyProActivity.class));
            finish();
            return;
        }
        lc1.e(this);
        sf sfVar = this.B;
        if (sfVar != null) {
            af afVar = sfVar.c;
            if (afVar != null) {
                afVar.b();
            }
            this.B = null;
        }
        sf sfVar2 = new sf(this, new j51(this, 0));
        this.B = sfVar2;
        sfVar2.i(new xg((Runnable) new lk0(12, this)));
    }
}
