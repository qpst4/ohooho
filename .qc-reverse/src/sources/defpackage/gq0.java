package defpackage;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.DialogPreference;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gq0 extends j30 {
    public lq0 Z;
    public RecyclerView a0;
    public boolean b0;
    public boolean c0;
    public nc e0;
    public final eq0 Y = new eq0(this);
    public int d0 = R.layout.preference_list_fragment;
    public final y6 f0 = new y6(this, Looper.getMainLooper());
    public final nc g0 = new nc(10, this);

    @Override // defpackage.j30
    public void J(Bundle bundle) {
        super.J(bundle);
        TypedValue typedValue = new TypedValue();
        o().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i == 0) {
            i = R.style.PreferenceThemeOverlay;
        }
        o().getTheme().applyStyle(i, false);
        lq0 lq0Var = new lq0(o());
        this.Z = lq0Var;
        lq0Var.j = this;
        Bundle bundle2 = this.h;
        i0(bundle2 != null ? bundle2.getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null, bundle);
    }

    @Override // defpackage.j30
    public final View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        RecyclerView recyclerView;
        TypedArray typedArrayObtainStyledAttributes = o().obtainStyledAttributes(null, vs0.h, R.attr.preferenceFragmentCompatStyle, 0);
        this.d0 = typedArrayObtainStyledAttributes.getResourceId(0, this.d0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(3, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(o());
        View viewInflate = layoutInflaterCloneInContext.inflate(this.d0, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(android.R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            s1.f("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        if (!o().getPackageManager().hasSystemFeature("android.hardware.type.automotive") || (recyclerView = (RecyclerView) viewGroup2.findViewById(R.id.recycler_view)) == null) {
            recyclerView = (RecyclerView) layoutInflaterCloneInContext.inflate(R.layout.preference_recyclerview, viewGroup2, false);
            o();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
            recyclerView.setAccessibilityDelegateCompat(new mq0(recyclerView));
        }
        this.a0 = recyclerView;
        eq0 eq0Var = this.Y;
        recyclerView.g(eq0Var);
        if (drawable != null) {
            eq0Var.getClass();
            eq0Var.b = drawable.getIntrinsicHeight();
        } else {
            eq0Var.b = 0;
        }
        eq0Var.a = drawable;
        gq0 gq0Var = eq0Var.d;
        RecyclerView recyclerView2 = gq0Var.a0;
        if (recyclerView2.o.size() != 0) {
            zt0 zt0Var = recyclerView2.n;
            if (zt0Var != null) {
                zt0Var.c("Cannot invalidate item decorations during a scroll or layout");
            }
            recyclerView2.P();
            recyclerView2.requestLayout();
        }
        if (dimensionPixelSize != -1) {
            eq0Var.b = dimensionPixelSize;
            RecyclerView recyclerView3 = gq0Var.a0;
            if (recyclerView3.o.size() != 0) {
                zt0 zt0Var2 = recyclerView3.n;
                if (zt0Var2 != null) {
                    zt0Var2.c("Cannot invalidate item decorations during a scroll or layout");
                }
                recyclerView3.P();
                recyclerView3.requestLayout();
            }
        }
        eq0Var.c = z;
        if (this.a0.getParent() == null) {
            viewGroup2.addView(this.a0);
        }
        this.f0.post(this.g0);
        return viewInflate;
    }

    @Override // defpackage.j30
    public final void M() {
        nc ncVar = this.g0;
        y6 y6Var = this.f0;
        y6Var.removeCallbacks(ncVar);
        y6Var.removeMessages(1);
        if (this.b0) {
            this.a0.setAdapter(null);
            PreferenceScreen preferenceScreen = this.Z.g;
            if (preferenceScreen != null) {
                preferenceScreen.q();
            }
        }
        this.a0 = null;
        this.F = true;
    }

    @Override // defpackage.j30
    public final void S(Bundle bundle) {
        PreferenceScreen preferenceScreen = this.Z.g;
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.c(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // defpackage.j30
    public void T() {
        this.F = true;
        lq0 lq0Var = this.Z;
        lq0Var.h = this;
        lq0Var.i = this;
    }

    @Override // defpackage.j30
    public final void U() {
        this.F = true;
        lq0 lq0Var = this.Z;
        lq0Var.h = null;
        lq0Var.i = null;
    }

    @Override // defpackage.j30
    public final void V(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreen = this.Z.g) != null) {
            preferenceScreen.b(bundle2);
        }
        if (this.b0) {
            PreferenceScreen preferenceScreen2 = this.Z.g;
            if (preferenceScreen2 != null) {
                this.a0.setAdapter(new jq0(preferenceScreen2));
                preferenceScreen2.m();
            }
            nc ncVar = this.e0;
            if (ncVar != null) {
                ncVar.run();
                this.e0 = null;
            }
        }
        this.c0 = true;
    }

    public final Preference h0(CharSequence charSequence) {
        PreferenceScreen preferenceScreen;
        lq0 lq0Var = this.Z;
        if (lq0Var == null || (preferenceScreen = lq0Var.g) == null) {
            return null;
        }
        return preferenceScreen.J(charSequence);
    }

    public abstract void i0(String str, Bundle bundle);

    public void j0(DialogPreference dialogPreference) {
        wt gm0Var;
        for (j30 j30Var = this; j30Var != null; j30Var = j30Var.w) {
        }
        if (x().D("androidx.preference.PreferenceFragment.DIALOG") != null) {
            return;
        }
        if (dialogPreference instanceof EditTextPreference) {
            String str = dialogPreference.m;
            gm0Var = new kx();
            Bundle bundle = new Bundle(1);
            bundle.putString("key", str);
            gm0Var.c0(bundle);
        } else if (dialogPreference instanceof ListPreference) {
            String str2 = dialogPreference.m;
            gm0Var = new th0();
            Bundle bundle2 = new Bundle(1);
            bundle2.putString("key", str2);
            gm0Var.c0(bundle2);
        } else {
            if (!(dialogPreference instanceof MultiSelectListPreference)) {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + dialogPreference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
            }
            String str3 = dialogPreference.m;
            gm0Var = new gm0();
            Bundle bundle3 = new Bundle(1);
            bundle3.putString("key", str3);
            gm0Var.c0(bundle3);
        }
        gm0Var.d0(this);
        gm0Var.j0(x(), "androidx.preference.PreferenceFragment.DIALOG");
    }

    public final void k0(String str, int i) {
        lq0 lq0Var = this.Z;
        if (lq0Var == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
        PreferenceScreen preferenceScreenC = lq0Var.c(o(), i);
        PreferenceScreen preferenceScreen = preferenceScreenC;
        if (str != null) {
            Preference preferenceJ = preferenceScreenC.J(str);
            boolean z = preferenceJ instanceof PreferenceScreen;
            preferenceScreen = preferenceJ;
            if (!z) {
                zy.n(l11.j("Preference object with key ", str, " is not a PreferenceScreen"));
                return;
            }
        }
        PreferenceScreen preferenceScreen2 = preferenceScreen;
        lq0 lq0Var2 = this.Z;
        PreferenceScreen preferenceScreen3 = lq0Var2.g;
        if (preferenceScreen2 != preferenceScreen3) {
            if (preferenceScreen3 != null) {
                preferenceScreen3.q();
            }
            lq0Var2.g = preferenceScreen2;
            this.b0 = true;
            if (this.c0) {
                y6 y6Var = this.f0;
                if (y6Var.hasMessages(1)) {
                    return;
                }
                y6Var.obtainMessage(1).sendToTarget();
            }
        }
    }
}
