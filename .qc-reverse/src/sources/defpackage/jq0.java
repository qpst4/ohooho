package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jq0 extends qt0 {
    public final PreferenceGroup c;
    public ArrayList d;
    public ArrayList e;
    public final ArrayList f;
    public final nc h = new nc(12, this);
    public final Handler g = new Handler(Looper.getMainLooper());

    public jq0(PreferenceGroup preferenceGroup) {
        this.c = preferenceGroup;
        preferenceGroup.H = this;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        if (preferenceGroup instanceof PreferenceScreen) {
            g(((PreferenceScreen) preferenceGroup).U);
        } else {
            g(true);
        }
        l();
    }

    @Override // defpackage.qt0
    public final int a() {
        return this.e.size();
    }

    @Override // defpackage.qt0
    public final long b(int i) {
        if (this.b) {
            return j(i).e();
        }
        return -1L;
    }

    @Override // defpackage.qt0
    public final int c(int i) {
        iq0 iq0Var = new iq0(j(i));
        ArrayList arrayList = this.f;
        int iIndexOf = arrayList.indexOf(iq0Var);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = arrayList.size();
        arrayList.add(iq0Var);
        return size;
    }

    @Override // defpackage.qt0
    public final void e(pu0 pu0Var, int i) {
        nq0 nq0Var = (nq0) pu0Var;
        Preference preferenceJ = j(i);
        ColorStateList colorStateList = nq0Var.u;
        View view = nq0Var.a;
        Drawable background = view.getBackground();
        Drawable drawable = nq0Var.t;
        if (background != drawable) {
            WeakHashMap weakHashMap = uf1.a;
            view.setBackground(drawable);
        }
        TextView textView = (TextView) nq0Var.r(R.id.title);
        if (textView != null && colorStateList != null && !textView.getTextColors().equals(colorStateList)) {
            textView.setTextColor(colorStateList);
        }
        preferenceJ.o(nq0Var);
    }

    @Override // defpackage.qt0
    public final pu0 f(ViewGroup viewGroup, int i) {
        iq0 iq0Var = (iq0) this.f.get(i);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, vs0.a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = tk0.j(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(iq0Var.a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            WeakHashMap weakHashMap = uf1.a;
            viewInflate.setBackground(drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i2 = iq0Var.b;
            if (i2 != 0) {
                layoutInflaterFrom.inflate(i2, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new nq0(viewInflate);
    }

    public final ArrayList h(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = preferenceGroup.P.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            CharSequence string = null;
            if (i2 >= size) {
                int i4 = preferenceGroup.T;
                if (i4 != Integer.MAX_VALUE && i3 > i4) {
                    Context context = preferenceGroup.b;
                    long j = preferenceGroup.d;
                    i00 i00Var = new i00(context, null);
                    i00Var.F = com.quickcursor.R.layout.expand_button;
                    i00Var.D(com.quickcursor.R.drawable.ic_arrow_down_24dp);
                    Context context2 = i00Var.b;
                    String string2 = context2.getString(com.quickcursor.R.string.expand_button_title);
                    if (!TextUtils.equals(string2, i00Var.i)) {
                        i00Var.i = string2;
                        i00Var.k();
                    }
                    if (999 != i00Var.h) {
                        i00Var.h = 999;
                        jq0 jq0Var = i00Var.H;
                        if (jq0Var != null) {
                            Handler handler = jq0Var.g;
                            nc ncVar = jq0Var.h;
                            handler.removeCallbacks(ncVar);
                            handler.post(ncVar);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    int size2 = arrayList2.size();
                    while (i < size2) {
                        Object obj = arrayList2.get(i);
                        i++;
                        Preference preference = (Preference) obj;
                        CharSequence charSequence = preference.i;
                        boolean z = preference instanceof PreferenceGroup;
                        if (z && !TextUtils.isEmpty(charSequence)) {
                            arrayList3.add((PreferenceGroup) preference);
                        }
                        if (arrayList3.contains(preference.J)) {
                            if (z) {
                                arrayList3.add((PreferenceGroup) preference);
                            }
                        } else if (!TextUtils.isEmpty(charSequence)) {
                            string = string == null ? charSequence : context2.getString(com.quickcursor.R.string.summary_collapsed_preference_list, string, charSequence);
                        }
                    }
                    i00Var.E(string);
                    i00Var.O = j + 1000000;
                    i00Var.g = new pn0(this, 1, preferenceGroup);
                    arrayList.add(i00Var);
                }
                return arrayList;
            }
            Preference preferenceK = preferenceGroup.K(i2);
            if (preferenceK.x) {
                int i5 = preferenceGroup.T;
                if (i5 == Integer.MAX_VALUE || i3 < i5) {
                    arrayList.add(preferenceK);
                } else {
                    arrayList2.add(preferenceK);
                }
                if (preferenceK instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceK;
                    if (preferenceGroup2 instanceof PreferenceScreen) {
                        continue;
                    } else {
                        if (preferenceGroup.T != Integer.MAX_VALUE && preferenceGroup2.T != Integer.MAX_VALUE) {
                            s1.f("Nesting an expandable group inside of another expandable group is not supported!");
                            return null;
                        }
                        ArrayList arrayListH = h(preferenceGroup2);
                        int size3 = arrayListH.size();
                        int i6 = 0;
                        while (i6 < size3) {
                            Object obj2 = arrayListH.get(i6);
                            i6++;
                            Preference preference2 = (Preference) obj2;
                            int i7 = preferenceGroup.T;
                            if (i7 == Integer.MAX_VALUE || i3 < i7) {
                                arrayList.add(preference2);
                            } else {
                                arrayList2.add(preference2);
                            }
                            i3++;
                        }
                    }
                } else {
                    i3++;
                }
            }
            i2++;
        }
    }

    public final void i(ArrayList arrayList, PreferenceGroup preferenceGroup) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.P);
        }
        int size = preferenceGroup.P.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceK = preferenceGroup.K(i);
            arrayList.add(preferenceK);
            iq0 iq0Var = new iq0(preferenceK);
            if (!this.f.contains(iq0Var)) {
                this.f.add(iq0Var);
            }
            if (preferenceK instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceK;
                if (!(preferenceGroup2 instanceof PreferenceScreen)) {
                    i(arrayList, preferenceGroup2);
                }
            }
            preferenceK.H = this;
        }
    }

    public final Preference j(int i) {
        if (i < 0 || i >= this.e.size()) {
            return null;
        }
        return (Preference) this.e.get(i);
    }

    public final int k() {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals("edgeActionsFeedbackCategory", ((Preference) this.e.get(i)).m)) {
                return i;
            }
        }
        return -1;
    }

    public final void l() {
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((Preference) obj).H = null;
        }
        ArrayList arrayList2 = new ArrayList(this.d.size());
        this.d = arrayList2;
        PreferenceGroup preferenceGroup = this.c;
        i(arrayList2, preferenceGroup);
        this.e = h(preferenceGroup);
        d();
        ArrayList arrayList3 = this.d;
        int size2 = arrayList3.size();
        while (i < size2) {
            Object obj2 = arrayList3.get(i);
            i++;
            ((Preference) obj2).getClass();
        }
    }
}
