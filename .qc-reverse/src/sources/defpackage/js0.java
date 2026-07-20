package defpackage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.activities.SettingsActivity;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class js0 extends vg {
    public final CursorAccessibilityService e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public js0(CursorAccessibilityService cursorAccessibilityService, CursorAccessibilityService cursorAccessibilityService2, int i) {
        super(cursorAccessibilityService);
        final int i2 = 0;
        switch (i) {
            case 1:
                super(cursorAccessibilityService);
                this.e = cursorAccessibilityService2;
                LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.timed_disable_layout, (ViewGroup) null);
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.container);
                for (int i3 = 0; i3 < linearLayout2.getChildCount(); i3++) {
                    LinearLayout linearLayout3 = (LinearLayout) linearLayout2.getChildAt(i3);
                    for (int i4 = 0; i4 < linearLayout3.getChildCount(); i4++) {
                        linearLayout3.getChildAt(i4).setOnClickListener(new a3(14, this));
                    }
                }
                a(linearLayout);
                break;
            default:
                this.e = cursorAccessibilityService2;
                LinearLayout linearLayout4 = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.quick_settings_layout, (ViewGroup) null);
                linearLayout4.findViewById(R.id.openSettings).setOnClickListener(new View.OnClickListener(this) { // from class: is0
                    public final /* synthetic */ js0 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i5 = i2;
                        js0 js0Var = this.c;
                        switch (i5) {
                            case 0:
                                Intent intent = new Intent(App.c, (Class<?>) SettingsActivity.class);
                                intent.addFlags(268435456);
                                App.c.startActivity(intent);
                                js0Var.b();
                                break;
                            case 1:
                                js0Var.e.h();
                                js0Var.b();
                                break;
                            case 2:
                                CursorAccessibilityService cursorAccessibilityService3 = js0Var.e;
                                cursorAccessibilityService3.getClass();
                                new js0(cursorAccessibilityService3, cursorAccessibilityService3, 1);
                                js0Var.b();
                                break;
                            case 3:
                                CursorAccessibilityService cursorAccessibilityService4 = js0Var.e;
                                cursorAccessibilityService4.getClass();
                                si0.a("turnOff(): ".concat(l11.p(2)));
                                r60.k();
                                ar arVar = cursorAccessibilityService4.o;
                                if (arVar != null) {
                                    try {
                                        arVar.m();
                                        break;
                                    } catch (Exception unused) {
                                    }
                                    cursorAccessibilityService4.o = null;
                                }
                                cursorAccessibilityService4.n = 2;
                                js0Var.b();
                                break;
                            case 4:
                                js0Var.b();
                                break;
                            default:
                                ig igVar = js0Var.e.c;
                                String str = igVar.i;
                                if (str == null || str.equals("com.quickcursor")) {
                                    yb0.B("Can't add that app to blacklist.");
                                } else {
                                    pn0 pn0VarT = pn0.t();
                                    String str2 = igVar.i;
                                    SharedPreferences sharedPreferences = (SharedPreferences) pn0VarT.d;
                                    oq0 oq0Var = oq0.h0;
                                    HashSet hashSet = new HashSet(sharedPreferences.getStringSet(oq0Var.name(), (Set) oq0Var.b));
                                    if (!hashSet.contains(str2)) {
                                        hashSet.add(str2);
                                        ((SharedPreferences) pn0VarT.d).edit().putStringSet(oq0Var.name(), hashSet).apply();
                                    }
                                    igVar.c();
                                    if (igVar.e != 1) {
                                        boolean zA = igVar.a(igVar.i);
                                        igVar.j = zA;
                                        if (zA) {
                                            igVar.d.n(5);
                                        }
                                    }
                                }
                                js0Var.b();
                                break;
                        }
                    }
                });
                final int i5 = 1;
                linearLayout4.findViewById(R.id.disableTemporary).setOnClickListener(new View.OnClickListener(this) { // from class: is0
                    public final /* synthetic */ js0 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i52 = i5;
                        js0 js0Var = this.c;
                        switch (i52) {
                            case 0:
                                Intent intent = new Intent(App.c, (Class<?>) SettingsActivity.class);
                                intent.addFlags(268435456);
                                App.c.startActivity(intent);
                                js0Var.b();
                                break;
                            case 1:
                                js0Var.e.h();
                                js0Var.b();
                                break;
                            case 2:
                                CursorAccessibilityService cursorAccessibilityService3 = js0Var.e;
                                cursorAccessibilityService3.getClass();
                                new js0(cursorAccessibilityService3, cursorAccessibilityService3, 1);
                                js0Var.b();
                                break;
                            case 3:
                                CursorAccessibilityService cursorAccessibilityService4 = js0Var.e;
                                cursorAccessibilityService4.getClass();
                                si0.a("turnOff(): ".concat(l11.p(2)));
                                r60.k();
                                ar arVar = cursorAccessibilityService4.o;
                                if (arVar != null) {
                                    try {
                                        arVar.m();
                                        break;
                                    } catch (Exception unused) {
                                    }
                                    cursorAccessibilityService4.o = null;
                                }
                                cursorAccessibilityService4.n = 2;
                                js0Var.b();
                                break;
                            case 4:
                                js0Var.b();
                                break;
                            default:
                                ig igVar = js0Var.e.c;
                                String str = igVar.i;
                                if (str == null || str.equals("com.quickcursor")) {
                                    yb0.B("Can't add that app to blacklist.");
                                } else {
                                    pn0 pn0VarT = pn0.t();
                                    String str2 = igVar.i;
                                    SharedPreferences sharedPreferences = (SharedPreferences) pn0VarT.d;
                                    oq0 oq0Var = oq0.h0;
                                    HashSet hashSet = new HashSet(sharedPreferences.getStringSet(oq0Var.name(), (Set) oq0Var.b));
                                    if (!hashSet.contains(str2)) {
                                        hashSet.add(str2);
                                        ((SharedPreferences) pn0VarT.d).edit().putStringSet(oq0Var.name(), hashSet).apply();
                                    }
                                    igVar.c();
                                    if (igVar.e != 1) {
                                        boolean zA = igVar.a(igVar.i);
                                        igVar.j = zA;
                                        if (zA) {
                                            igVar.d.n(5);
                                        }
                                    }
                                }
                                js0Var.b();
                                break;
                        }
                    }
                });
                final int i6 = 2;
                linearLayout4.findViewById(R.id.timedDisable).setOnClickListener(new View.OnClickListener(this) { // from class: is0
                    public final /* synthetic */ js0 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i52 = i6;
                        js0 js0Var = this.c;
                        switch (i52) {
                            case 0:
                                Intent intent = new Intent(App.c, (Class<?>) SettingsActivity.class);
                                intent.addFlags(268435456);
                                App.c.startActivity(intent);
                                js0Var.b();
                                break;
                            case 1:
                                js0Var.e.h();
                                js0Var.b();
                                break;
                            case 2:
                                CursorAccessibilityService cursorAccessibilityService3 = js0Var.e;
                                cursorAccessibilityService3.getClass();
                                new js0(cursorAccessibilityService3, cursorAccessibilityService3, 1);
                                js0Var.b();
                                break;
                            case 3:
                                CursorAccessibilityService cursorAccessibilityService4 = js0Var.e;
                                cursorAccessibilityService4.getClass();
                                si0.a("turnOff(): ".concat(l11.p(2)));
                                r60.k();
                                ar arVar = cursorAccessibilityService4.o;
                                if (arVar != null) {
                                    try {
                                        arVar.m();
                                        break;
                                    } catch (Exception unused) {
                                    }
                                    cursorAccessibilityService4.o = null;
                                }
                                cursorAccessibilityService4.n = 2;
                                js0Var.b();
                                break;
                            case 4:
                                js0Var.b();
                                break;
                            default:
                                ig igVar = js0Var.e.c;
                                String str = igVar.i;
                                if (str == null || str.equals("com.quickcursor")) {
                                    yb0.B("Can't add that app to blacklist.");
                                } else {
                                    pn0 pn0VarT = pn0.t();
                                    String str2 = igVar.i;
                                    SharedPreferences sharedPreferences = (SharedPreferences) pn0VarT.d;
                                    oq0 oq0Var = oq0.h0;
                                    HashSet hashSet = new HashSet(sharedPreferences.getStringSet(oq0Var.name(), (Set) oq0Var.b));
                                    if (!hashSet.contains(str2)) {
                                        hashSet.add(str2);
                                        ((SharedPreferences) pn0VarT.d).edit().putStringSet(oq0Var.name(), hashSet).apply();
                                    }
                                    igVar.c();
                                    if (igVar.e != 1) {
                                        boolean zA = igVar.a(igVar.i);
                                        igVar.j = zA;
                                        if (zA) {
                                            igVar.d.n(5);
                                        }
                                    }
                                }
                                js0Var.b();
                                break;
                        }
                    }
                });
                final int i7 = 3;
                linearLayout4.findViewById(R.id.stopService).setOnClickListener(new View.OnClickListener(this) { // from class: is0
                    public final /* synthetic */ js0 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i52 = i7;
                        js0 js0Var = this.c;
                        switch (i52) {
                            case 0:
                                Intent intent = new Intent(App.c, (Class<?>) SettingsActivity.class);
                                intent.addFlags(268435456);
                                App.c.startActivity(intent);
                                js0Var.b();
                                break;
                            case 1:
                                js0Var.e.h();
                                js0Var.b();
                                break;
                            case 2:
                                CursorAccessibilityService cursorAccessibilityService3 = js0Var.e;
                                cursorAccessibilityService3.getClass();
                                new js0(cursorAccessibilityService3, cursorAccessibilityService3, 1);
                                js0Var.b();
                                break;
                            case 3:
                                CursorAccessibilityService cursorAccessibilityService4 = js0Var.e;
                                cursorAccessibilityService4.getClass();
                                si0.a("turnOff(): ".concat(l11.p(2)));
                                r60.k();
                                ar arVar = cursorAccessibilityService4.o;
                                if (arVar != null) {
                                    try {
                                        arVar.m();
                                        break;
                                    } catch (Exception unused) {
                                    }
                                    cursorAccessibilityService4.o = null;
                                }
                                cursorAccessibilityService4.n = 2;
                                js0Var.b();
                                break;
                            case 4:
                                js0Var.b();
                                break;
                            default:
                                ig igVar = js0Var.e.c;
                                String str = igVar.i;
                                if (str == null || str.equals("com.quickcursor")) {
                                    yb0.B("Can't add that app to blacklist.");
                                } else {
                                    pn0 pn0VarT = pn0.t();
                                    String str2 = igVar.i;
                                    SharedPreferences sharedPreferences = (SharedPreferences) pn0VarT.d;
                                    oq0 oq0Var = oq0.h0;
                                    HashSet hashSet = new HashSet(sharedPreferences.getStringSet(oq0Var.name(), (Set) oq0Var.b));
                                    if (!hashSet.contains(str2)) {
                                        hashSet.add(str2);
                                        ((SharedPreferences) pn0VarT.d).edit().putStringSet(oq0Var.name(), hashSet).apply();
                                    }
                                    igVar.c();
                                    if (igVar.e != 1) {
                                        boolean zA = igVar.a(igVar.i);
                                        igVar.j = zA;
                                        if (zA) {
                                            igVar.d.n(5);
                                        }
                                    }
                                }
                                js0Var.b();
                                break;
                        }
                    }
                });
                final int i8 = 4;
                linearLayout4.findViewById(R.id.closeQuickSettings).setOnClickListener(new View.OnClickListener(this) { // from class: is0
                    public final /* synthetic */ js0 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i52 = i8;
                        js0 js0Var = this.c;
                        switch (i52) {
                            case 0:
                                Intent intent = new Intent(App.c, (Class<?>) SettingsActivity.class);
                                intent.addFlags(268435456);
                                App.c.startActivity(intent);
                                js0Var.b();
                                break;
                            case 1:
                                js0Var.e.h();
                                js0Var.b();
                                break;
                            case 2:
                                CursorAccessibilityService cursorAccessibilityService3 = js0Var.e;
                                cursorAccessibilityService3.getClass();
                                new js0(cursorAccessibilityService3, cursorAccessibilityService3, 1);
                                js0Var.b();
                                break;
                            case 3:
                                CursorAccessibilityService cursorAccessibilityService4 = js0Var.e;
                                cursorAccessibilityService4.getClass();
                                si0.a("turnOff(): ".concat(l11.p(2)));
                                r60.k();
                                ar arVar = cursorAccessibilityService4.o;
                                if (arVar != null) {
                                    try {
                                        arVar.m();
                                        break;
                                    } catch (Exception unused) {
                                    }
                                    cursorAccessibilityService4.o = null;
                                }
                                cursorAccessibilityService4.n = 2;
                                js0Var.b();
                                break;
                            case 4:
                                js0Var.b();
                                break;
                            default:
                                ig igVar = js0Var.e.c;
                                String str = igVar.i;
                                if (str == null || str.equals("com.quickcursor")) {
                                    yb0.B("Can't add that app to blacklist.");
                                } else {
                                    pn0 pn0VarT = pn0.t();
                                    String str2 = igVar.i;
                                    SharedPreferences sharedPreferences = (SharedPreferences) pn0VarT.d;
                                    oq0 oq0Var = oq0.h0;
                                    HashSet hashSet = new HashSet(sharedPreferences.getStringSet(oq0Var.name(), (Set) oq0Var.b));
                                    if (!hashSet.contains(str2)) {
                                        hashSet.add(str2);
                                        ((SharedPreferences) pn0VarT.d).edit().putStringSet(oq0Var.name(), hashSet).apply();
                                    }
                                    igVar.c();
                                    if (igVar.e != 1) {
                                        boolean zA = igVar.a(igVar.i);
                                        igVar.j = zA;
                                        if (zA) {
                                            igVar.d.n(5);
                                        }
                                    }
                                }
                                js0Var.b();
                                break;
                        }
                    }
                });
                if (pn0.t().i() == 2) {
                    final int i9 = 5;
                    linearLayout4.findViewById(R.id.addToBlacklist).setOnClickListener(new View.OnClickListener(this) { // from class: is0
                        public final /* synthetic */ js0 c;

                        {
                            this.c = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i52 = i9;
                            js0 js0Var = this.c;
                            switch (i52) {
                                case 0:
                                    Intent intent = new Intent(App.c, (Class<?>) SettingsActivity.class);
                                    intent.addFlags(268435456);
                                    App.c.startActivity(intent);
                                    js0Var.b();
                                    break;
                                case 1:
                                    js0Var.e.h();
                                    js0Var.b();
                                    break;
                                case 2:
                                    CursorAccessibilityService cursorAccessibilityService3 = js0Var.e;
                                    cursorAccessibilityService3.getClass();
                                    new js0(cursorAccessibilityService3, cursorAccessibilityService3, 1);
                                    js0Var.b();
                                    break;
                                case 3:
                                    CursorAccessibilityService cursorAccessibilityService4 = js0Var.e;
                                    cursorAccessibilityService4.getClass();
                                    si0.a("turnOff(): ".concat(l11.p(2)));
                                    r60.k();
                                    ar arVar = cursorAccessibilityService4.o;
                                    if (arVar != null) {
                                        try {
                                            arVar.m();
                                            break;
                                        } catch (Exception unused) {
                                        }
                                        cursorAccessibilityService4.o = null;
                                    }
                                    cursorAccessibilityService4.n = 2;
                                    js0Var.b();
                                    break;
                                case 4:
                                    js0Var.b();
                                    break;
                                default:
                                    ig igVar = js0Var.e.c;
                                    String str = igVar.i;
                                    if (str == null || str.equals("com.quickcursor")) {
                                        yb0.B("Can't add that app to blacklist.");
                                    } else {
                                        pn0 pn0VarT = pn0.t();
                                        String str2 = igVar.i;
                                        SharedPreferences sharedPreferences = (SharedPreferences) pn0VarT.d;
                                        oq0 oq0Var = oq0.h0;
                                        HashSet hashSet = new HashSet(sharedPreferences.getStringSet(oq0Var.name(), (Set) oq0Var.b));
                                        if (!hashSet.contains(str2)) {
                                            hashSet.add(str2);
                                            ((SharedPreferences) pn0VarT.d).edit().putStringSet(oq0Var.name(), hashSet).apply();
                                        }
                                        igVar.c();
                                        if (igVar.e != 1) {
                                            boolean zA = igVar.a(igVar.i);
                                            igVar.j = zA;
                                            if (zA) {
                                                igVar.d.n(5);
                                            }
                                        }
                                    }
                                    js0Var.b();
                                    break;
                            }
                        }
                    });
                } else {
                    linearLayout4.findViewById(R.id.addToBlacklist).setVisibility(8);
                }
                a(linearLayout4);
                break;
        }
    }
}
