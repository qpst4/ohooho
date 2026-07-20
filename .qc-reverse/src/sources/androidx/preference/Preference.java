package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.quickcursor.R;
import defpackage.aq0;
import defpackage.bq0;
import defpackage.fp1;
import defpackage.ix;
import defpackage.j30;
import defpackage.jq0;
import defpackage.l1;
import defpackage.l11;
import defpackage.ld;
import defpackage.lq0;
import defpackage.nc;
import defpackage.nq0;
import defpackage.s1;
import defpackage.t30;
import defpackage.tk0;
import defpackage.uf1;
import defpackage.vs0;
import defpackage.y30;
import defpackage.zp0;
import defpackage.zy;
import java.util.ArrayList;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public int F;
    public int G;
    public jq0 H;
    public ArrayList I;
    public PreferenceGroup J;
    public boolean K;
    public bq0 L;
    public ix M;
    public final l1 N;
    public final Context b;
    public lq0 c;
    public long d;
    public boolean e;
    public zp0 f;
    public aq0 g;
    public int h;
    public CharSequence i;
    public CharSequence j;
    public int k;
    public Drawable l;
    public final String m;
    public Intent n;
    public final String o;
    public Bundle p;
    public boolean q;
    public final boolean r;
    public boolean s;
    public final String t;
    public Object u;
    public boolean v;
    public boolean w;
    public boolean x;
    public final boolean y;
    public final boolean z;

    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        this.h = Integer.MAX_VALUE;
        this.q = true;
        this.r = true;
        this.s = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = true;
        this.z = true;
        this.B = true;
        this.E = true;
        this.F = R.layout.preference;
        this.N = new l1(4, this);
        this.b = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vs0.g, i, i2);
        this.k = typedArrayObtainStyledAttributes.getResourceId(23, typedArrayObtainStyledAttributes.getResourceId(0, 0));
        String string = typedArrayObtainStyledAttributes.getString(26);
        this.m = string == null ? typedArrayObtainStyledAttributes.getString(6) : string;
        CharSequence text = typedArrayObtainStyledAttributes.getText(34);
        this.i = text == null ? typedArrayObtainStyledAttributes.getText(4) : text;
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(33);
        this.j = text2 == null ? typedArrayObtainStyledAttributes.getText(7) : text2;
        this.h = typedArrayObtainStyledAttributes.getInt(28, typedArrayObtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
        String string2 = typedArrayObtainStyledAttributes.getString(22);
        this.o = string2 == null ? typedArrayObtainStyledAttributes.getString(13) : string2;
        this.F = typedArrayObtainStyledAttributes.getResourceId(27, typedArrayObtainStyledAttributes.getResourceId(3, R.layout.preference));
        this.G = typedArrayObtainStyledAttributes.getResourceId(35, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        this.q = typedArrayObtainStyledAttributes.getBoolean(21, typedArrayObtainStyledAttributes.getBoolean(2, true));
        boolean z = typedArrayObtainStyledAttributes.getBoolean(30, typedArrayObtainStyledAttributes.getBoolean(5, true));
        this.r = z;
        this.s = typedArrayObtainStyledAttributes.getBoolean(29, typedArrayObtainStyledAttributes.getBoolean(1, true));
        String string3 = typedArrayObtainStyledAttributes.getString(19);
        this.t = string3 == null ? typedArrayObtainStyledAttributes.getString(10) : string3;
        this.y = typedArrayObtainStyledAttributes.getBoolean(16, typedArrayObtainStyledAttributes.getBoolean(16, z));
        this.z = typedArrayObtainStyledAttributes.getBoolean(17, typedArrayObtainStyledAttributes.getBoolean(17, z));
        if (typedArrayObtainStyledAttributes.hasValue(18)) {
            this.u = r(typedArrayObtainStyledAttributes, 18);
        } else if (typedArrayObtainStyledAttributes.hasValue(11)) {
            this.u = r(typedArrayObtainStyledAttributes, 11);
        }
        this.E = typedArrayObtainStyledAttributes.getBoolean(31, typedArrayObtainStyledAttributes.getBoolean(12, true));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(32);
        this.A = zHasValue;
        if (zHasValue) {
            this.B = typedArrayObtainStyledAttributes.getBoolean(32, typedArrayObtainStyledAttributes.getBoolean(14, true));
        }
        this.C = typedArrayObtainStyledAttributes.getBoolean(24, typedArrayObtainStyledAttributes.getBoolean(15, false));
        this.x = typedArrayObtainStyledAttributes.getBoolean(25, typedArrayObtainStyledAttributes.getBoolean(25, true));
        this.D = typedArrayObtainStyledAttributes.getBoolean(20, typedArrayObtainStyledAttributes.getBoolean(20, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void C(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                C(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public final void A(Set set) {
        if (H() && !set.equals(h(null))) {
            SharedPreferences.Editor editorA = this.c.a();
            editorA.putStringSet(this.m, set);
            I(editorA);
        }
    }

    public final void B(boolean z) {
        if (this.q != z) {
            this.q = z;
            l(G());
            k();
        }
    }

    public final void D(int i) {
        Drawable drawableJ = tk0.j(this.b, i);
        if (this.l != drawableJ) {
            this.l = drawableJ;
            this.k = 0;
            k();
        }
        this.k = i;
    }

    public void E(CharSequence charSequence) {
        if (this.M != null) {
            s1.f("Preference already has a SummaryProvider set.");
        } else {
            if (TextUtils.equals(this.j, charSequence)) {
                return;
            }
            this.j = charSequence;
            k();
        }
    }

    public final void F(boolean z) {
        if (this.x != z) {
            this.x = z;
            jq0 jq0Var = this.H;
            if (jq0Var != null) {
                Handler handler = jq0Var.g;
                nc ncVar = jq0Var.h;
                handler.removeCallbacks(ncVar);
                handler.post(ncVar);
            }
        }
    }

    public boolean G() {
        return !j();
    }

    public final boolean H() {
        return (this.c == null || !this.s || TextUtils.isEmpty(this.m)) ? false : true;
    }

    public final void I(SharedPreferences.Editor editor) {
        if (this.c.e) {
            return;
        }
        editor.apply();
    }

    public boolean a(Object obj) {
        zp0 zp0Var = this.f;
        return zp0Var == null || zp0Var.a(this, obj);
    }

    public void b(Bundle bundle) {
        Parcelable parcelable;
        String str = this.m;
        if (TextUtils.isEmpty(str) || (parcelable = bundle.getParcelable(str)) == null) {
            return;
        }
        this.K = false;
        s(parcelable);
        if (this.K) {
            return;
        }
        s1.f("Derived class did not call super.onRestoreInstanceState()");
    }

    public void c(Bundle bundle) {
        String str = this.m;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.K = false;
        Parcelable parcelableT = t();
        if (!this.K) {
            s1.f("Derived class did not call super.onSaveInstanceState()");
        } else if (parcelableT != null) {
            bundle.putParcelable(str, parcelableT);
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i = this.h;
        int i2 = preference2.h;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.i;
        CharSequence charSequence2 = preference2.i;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference2.i.toString());
    }

    public final Bundle d() {
        if (this.p == null) {
            this.p = new Bundle();
        }
        return this.p;
    }

    public long e() {
        return this.d;
    }

    public final int f(int i) {
        return !H() ? i : this.c.b().getInt(this.m, i);
    }

    public final String g(String str) {
        return !H() ? str : this.c.b().getString(this.m, str);
    }

    public final Set h(Set set) {
        return !H() ? set : this.c.b().getStringSet(this.m, set);
    }

    public CharSequence i() {
        ix ixVar = this.M;
        return ixVar != null ? ixVar.j(this) : this.j;
    }

    public boolean j() {
        return this.q && this.v && this.w;
    }

    public void k() {
        int iIndexOf;
        jq0 jq0Var = this.H;
        if (jq0Var == null || (iIndexOf = jq0Var.e.indexOf(this)) == -1) {
            return;
        }
        jq0Var.a.d(iIndexOf, 1, this);
    }

    public void l(boolean z) {
        ArrayList arrayList = this.I;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Preference preference = (Preference) arrayList.get(i);
            if (preference.v == z) {
                preference.v = !z;
                preference.l(preference.G());
                preference.k();
            }
        }
    }

    public void m() {
        PreferenceScreen preferenceScreen;
        String str = this.t;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        lq0 lq0Var = this.c;
        Preference preferenceJ = null;
        if (lq0Var != null && (preferenceScreen = lq0Var.g) != null) {
            preferenceJ = preferenceScreen.J(str);
        }
        if (preferenceJ == null) {
            StringBuilder sbM = l11.m("Dependency \"", str, "\" not found for preference \"");
            sbM.append(this.m);
            sbM.append("\" (title: \"");
            sbM.append((Object) this.i);
            sbM.append("\"");
            throw new IllegalStateException(sbM.toString());
        }
        if (preferenceJ.I == null) {
            preferenceJ.I = new ArrayList();
        }
        preferenceJ.I.add(this);
        boolean zG = preferenceJ.G();
        if (this.v == zG) {
            this.v = !zG;
            l(G());
            k();
        }
    }

    public final void n(lq0 lq0Var) {
        long j;
        this.c = lq0Var;
        if (!this.e) {
            synchronized (lq0Var) {
                j = lq0Var.b;
                lq0Var.b = 1 + j;
            }
            this.d = j;
        }
        if (H()) {
            lq0 lq0Var2 = this.c;
            if ((lq0Var2 != null ? lq0Var2.b() : null).contains(this.m)) {
                v(null, true);
                return;
            }
        }
        Object obj = this.u;
        if (obj != null) {
            v(obj, false);
        }
    }

    public void o(nq0 nq0Var) {
        Integer numValueOf;
        View view = nq0Var.a;
        view.setOnClickListener(this.N);
        view.setId(0);
        TextView textView = (TextView) nq0Var.r(android.R.id.summary);
        if (textView != null) {
            CharSequence charSequenceI = i();
            if (TextUtils.isEmpty(charSequenceI)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceI);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) nq0Var.r(android.R.id.title);
        boolean z = this.r;
        if (textView2 != null) {
            CharSequence charSequence = this.i;
            if (TextUtils.isEmpty(charSequence)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequence);
                textView2.setVisibility(0);
                if (this.A) {
                    textView2.setSingleLine(this.B);
                }
                if (!z && j() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) nq0Var.r(android.R.id.icon);
        boolean z2 = this.C;
        if (imageView != null) {
            int i = this.k;
            if (i != 0 || this.l != null) {
                if (this.l == null) {
                    this.l = tk0.j(this.b, i);
                }
                Drawable drawable = this.l;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.l != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(z2 ? 4 : 8);
            }
        }
        View viewR = nq0Var.r(R.id.icon_frame);
        if (viewR == null) {
            viewR = nq0Var.r(android.R.id.icon_frame);
        }
        if (viewR != null) {
            if (this.l != null) {
                viewR.setVisibility(0);
            } else {
                viewR.setVisibility(z2 ? 4 : 8);
            }
        }
        if (this.E) {
            C(view, j());
        } else {
            C(view, true);
        }
        view.setFocusable(z);
        view.setClickable(z);
        nq0Var.w = this.y;
        nq0Var.x = this.z;
        boolean z3 = this.D;
        if (z3 && this.L == null) {
            this.L = new bq0(this);
        }
        view.setOnCreateContextMenuListener(z3 ? this.L : null);
        view.setLongClickable(z3);
        if (!z3 || z) {
            return;
        }
        WeakHashMap weakHashMap = uf1.a;
        view.setBackground(null);
    }

    public void q() {
        ArrayList arrayList;
        PreferenceScreen preferenceScreen;
        String str = this.t;
        if (str != null) {
            lq0 lq0Var = this.c;
            Preference preferenceJ = null;
            if (lq0Var != null && (preferenceScreen = lq0Var.g) != null) {
                preferenceJ = preferenceScreen.J(str);
            }
            if (preferenceJ == null || (arrayList = preferenceJ.I) == null) {
                return;
            }
            arrayList.remove(this);
        }
    }

    public Object r(TypedArray typedArray, int i) {
        return null;
    }

    public void s(Parcelable parcelable) {
        this.K = true;
        if (parcelable == AbsSavedState.EMPTY_STATE || parcelable == null) {
            return;
        }
        zy.n("Wrong state class -- expecting Preference State");
    }

    public Parcelable t() {
        this.K = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.i;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence charSequenceI = i();
        if (!TextUtils.isEmpty(charSequenceI)) {
            sb.append(charSequenceI);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public void v(Object obj, boolean z) {
        u(obj);
    }

    public final void w() {
        j30 j30Var;
        String str;
        if (j() && this.r) {
            p();
            aq0 aq0Var = this.g;
            if (aq0Var == null || !aq0Var.c(this)) {
                lq0 lq0Var = this.c;
                if (lq0Var == null || (j30Var = lq0Var.h) == null || (str = this.o) == null) {
                    Intent intent = this.n;
                    if (intent != null) {
                        this.b.startActivity(intent);
                        return;
                    }
                    return;
                }
                for (j30 j30Var2 = j30Var; j30Var2 != null; j30Var2 = j30Var2.w) {
                }
                Log.w("PreferenceFragment", "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
                y30 y30VarX = j30Var.x();
                Bundle bundleD = d();
                t30 t30VarF = y30VarX.F();
                j30Var.Z().getClassLoader();
                j30 j30VarA = t30VarF.a(str);
                j30VarA.c0(bundleD);
                j30VarA.d0(j30Var);
                ld ldVar = new ld(y30VarX);
                ldVar.i(((View) j30Var.a0().getParent()).getId(), j30VarA);
                ldVar.c(null);
                ldVar.e(false);
            }
        }
    }

    public void x(View view) {
        w();
    }

    public final void y(int i) {
        if (H() && i != f(~i)) {
            SharedPreferences.Editor editorA = this.c.a();
            editorA.putInt(this.m, i);
            I(editorA);
        }
    }

    public final void z(String str) {
        if (H() && !TextUtils.equals(str, g(null))) {
            SharedPreferences.Editor editorA = this.c.a();
            editorA.putString(this.m, str);
            I(editorA);
        }
    }

    public void p() {
    }

    public void u(Object obj) {
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, fp1.g(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle), 0);
    }
}
